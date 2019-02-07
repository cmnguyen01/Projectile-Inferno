package com.droptableteams.game.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;
import com.droptableteams.game.components.VelocityComponent;
import com.droptableteams.game.entities.EnemyEntity;
import com.droptableteams.game.entities.PlayerEntity;
import com.droptableteams.game.statics.SystemUpdateOrder;
import com.droptableteams.game.systems.EnemyMovementSystem;
import com.droptableteams.game.systems.HandleInputSystem;
import com.droptableteams.game.systems.UpdateLocationSystem;
import com.droptableteams.game.systems.UpdateSpriteSystem;

import java.util.ArrayList;

public class EnemyEntityFactory {
    private static ECSEngine _engine = ECSEngine.getInstance(SystemUpdateOrder.get());
    private static ArrayList<IComponent> _cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> _sl = new ArrayList<ISystem>();

    public static void create(AssetManager assetManager /*, SpriteBatch batch*/) {
        int id = _engine.acquireEntityId();
        IEntity entity = new EnemyEntity(id);
        generateComponentList(id, assetManager);
        generateSystemList(id);
        _engine.addEntity(entity, _cl, _sl);
    }

    private static void generateComponentList(int id, AssetManager am) {
        float x = Gdx.graphics.getWidth()/2;
        float y = Gdx.graphics.getHeight()/2;
        float width = 32;
        float height = 32;
        Sprite sp = new Sprite(am.get("vvrv.png", Texture.class));
        sp.setSize(width,height);
        sp.setCenter(x,y);
        _cl.clear();
        IComponent c1 = new SpriteComponent(id, sp);
        _cl.add(c1);
        IComponent c2 = new LocationComponent(id, x,y);
        _cl.add(c2);
        IComponent c3 = new SizeComponent(id, width,height);
        _cl.add(c3);
        IComponent c4 = new VelocityComponent(id, 64);
        _cl.add(c4);
    }

    private static void generateSystemList(int id) {
        _sl.clear();
        ISystem s1 = new UpdateSpriteSystem(id);
        _sl.add(s1);
        ISystem s2 = new UpdateLocationSystem(id);
        _sl.add(s2);
        //ISystem s4 = new HandleInputSystem(id);
        //_sl.add(s4);

        ISystem s3 = new EnemyMovementSystem(id);
        _sl.add(s3);
    }

}
