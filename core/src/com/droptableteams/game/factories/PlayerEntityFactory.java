package com.droptableteams.game.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.PlayerEntity;
import com.droptableteams.game.util.constants.Directions;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.systems.*;
import java.util.ArrayList;

/**
 * Factory is not currently very extensible or adaptable
 * for use with script inputs or other forms of argument.
 *
 * TODO: Redesign Factory, and consider building an interface.
 *
 * TODO: Rename Factories to Builders -- since not technically factory pattern.
 */
public class PlayerEntityFactory {

    private static ECSEngine _engine = ECSEngine.getInstance(SystemUpdateOrder.get());
    private static ArrayList<IComponent> _cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> _sl = new ArrayList<ISystem>();

    public static void create(AssetManager assetManager) {
        int id = SpecialEntityIds.getPlayerEntityId();
        IEntity entity = new PlayerEntity(id);
        generateComponentList(id, assetManager);
        generateSystemList(id);
        _engine.addEntity(entity, _cl, _sl);
    }

    private static void generateComponentList(int id, AssetManager am) {
        float x = Gdx.graphics.getWidth()/2;
        float y = Gdx.graphics.getHeight()/4;
        float width = 64;
        float height = 64;
        Sprite sp = new Sprite(am.get("sprites/player.png", Texture.class));
        sp.setSize(width,height);
        sp.setCenter(x,y);
        _cl.clear();
        _cl.add(new SpriteComponent(id, sp));
        _cl.add(new LocationComponent(id, x,y));
        _cl.add(new SizeComponent(id, width,height));
        _cl.add(new VelocityComponent(id, 360));
        _cl.add(new MoveDirectionComponent(id, null));
        _cl.add(new FireControlComponent(id, 0.125f,true));
        _cl.add(new FirePatternComponent(id, Directions.UP, 1, (float)Math.PI/12, 0, "PlayerBullet"));
    }

    private static void generateSystemList(int id) {
        _sl.clear();
        _sl.add(new UpdateSpriteSystem(id));
        _sl.add(new UpdateLocationSystem(id));
        _sl.add(new HandleInputSystem(id));
        _sl.add(new StopAtBoundarySystem(id));
        _sl.add(new DirectionalMovementSystem(id));
        _sl.add(new FireControlSystem(id));
        _sl.add(new SpeedModifierSystem(id));
    }
}
