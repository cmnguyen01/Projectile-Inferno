package com.droptableteams.game.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.VelocityComponent;
import com.droptableteams.game.systems.*;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;
import com.droptableteams.game.entities.PlayerEntity;

import java.util.ArrayList;

public class PlayerFactory {

    private static ECSEngine _engine = ECSEngine.getInstance(OrderedSystemTypes.get());
    private static ArrayList<IComponent> cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> sl = new ArrayList<ISystem>();

    public static void createPlayer(AssetManager assetManager, SpriteBatch batch) {
        int id = _engine.acquireEntityId();
        IEntity entity = new PlayerEntity(id);
        generateComponentList(id, assetManager);
        generateSystemList(id, batch);
        _engine.addEntity(entity, cl, sl);
    }

    private static void generateComponentList(int id, AssetManager am) {
        float x = Gdx.graphics.getWidth()/2;
        float y = Gdx.graphics.getHeight()/4;
        float width = 64;
        float height = 64;
        Sprite sp = new Sprite(am.get("vvrv.png", Texture.class));
        sp.setSize(width,height);
        sp.setCenter(x,y);
        cl.clear();
        IComponent c1 = new SpriteComponent(id, sp);
        cl.add(c1);
        IComponent c2 = new LocationComponent(id, x,y);
        cl.add(c2);
        IComponent c3 = new SizeComponent(id, width,height);
        cl.add(c3);
        IComponent c4 = new VelocityComponent(id, 256);
        cl.add(c4);
    }

    private static void generateSystemList(int id, SpriteBatch batch) {
        sl.clear();
        ISystem s1 = new DrawSystem(id, batch);
        sl.add(s1);
        ISystem s2 = new UpdateSpriteSystem(id);
        sl.add(s2);
        ISystem s3 = new UpdateLocationSystem(id);
        sl.add(s3);
        ISystem s4 = new HandleInputSystem(id);
        sl.add(s4);
    }
}
