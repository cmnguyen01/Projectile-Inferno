package com.droptableteams.game.factories;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.BulletEntity;
import com.droptableteams.game.factories.data.BulletData;
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
public class BulletEntityFactory {

    private static ECSEngine _engine = ECSEngine.getInstance(SystemUpdateOrder.get());
    private static ArrayList<IComponent> _cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> _sl = new ArrayList<ISystem>();

    public static void create(AssetManager assetManager, BulletData bulletData) {
        int id = _engine.acquireEntityId();
        IEntity entity = new BulletEntity(id);
        generateComponentList(id, assetManager, bulletData);
        generateSystemList(id);
        _engine.addEntity(entity, _cl, _sl);
    }

    private static void generateComponentList(int id, AssetManager am, BulletData bd) {
        Sprite sp = new Sprite(am.get(bd.texture, Texture.class));
        sp.setSize(bd.width,bd.height);
        sp.setCenter(bd.x,bd.y);
        _cl.clear();
        _cl.add(new SpriteComponent(id, sp));
        _cl.add(new LocationComponent(id, bd.x,bd.y));
        _cl.add(new SizeComponent(id, bd.width,bd.height));
        _cl.add(new VelocityComponent(id, bd.speed));
        _cl.add(new HasBeenInboundsComponent(id, false));
        _cl.add(new MoveDirectionComponent(id, bd.direction));
    }

    private static void generateSystemList(int id) {
        _sl.clear();
        _sl.add(new UpdateSpriteSystem(id));
        _sl.add(new DespawnOutOfBoundsSystem(id));
        _sl.add(new DirectionalMovementSystem(id));
        _sl.add(new RotateSpriteToDirectionSystem(id));
    }
}
