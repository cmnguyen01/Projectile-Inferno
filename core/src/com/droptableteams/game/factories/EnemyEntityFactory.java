package com.droptableteams.game.factories;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.EnemyEntity;
import com.droptableteams.game.util.types.EnemyType;
import com.droptableteams.game.util.types.EnemyTypeFactory;
import com.droptableteams.game.util.data.EnemyData;
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.systems.*;

import java.util.ArrayList;

public class EnemyEntityFactory {
    private static ECSEngine _engine = ECSEngine.getInstance(SystemUpdateOrder.get());
    private static ArrayList<IComponent> _cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> _sl = new ArrayList<ISystem>();

    public static void create(AssetManager am, EnemyData ed) {
        int id = _engine.acquireEntityId();
        IEntity entity = new EnemyEntity(id);
        generateComponentsList(id, am, ed);
        generateSystemList(id);
        _engine.addEntity(entity, _cl, _sl);
    }

    private static void generateComponentsList(int id, AssetManager am, EnemyData ed) {
        EnemyType et = EnemyTypeFactory.make(ed.enemyType);
        float x = ed.x;
        float y = ed.y;
        Sprite sp = new Sprite(am.get(et.texture, Texture.class));
        sp.setSize(et.width,et.width);
        sp.setCenter(x,y);
        _cl.clear();
        _cl.add(new SpriteComponent(id, sp));
        _cl.add(new LocationComponent(id, ed.x,ed.y));
        _cl.add(new SizeComponent(id, et.width,et.height));
        _cl.add(new VelocityComponent(id, et.speed));
        _cl.add(new HasBeenInboundsComponent(id, false));
        _cl.add(new DestinationMovementComponent(id, ed.destinationList,et.loopDestinations));
        _cl.add(new FireControlComponent(id, et.firePattern.getFireRate(), true));
        _cl.add(new FirePatternComponent(id, et.firePattern.getBaseDirection(),et.firePattern.getNumberOfBullets(),
                et.firePattern.getDividingAngle(), et.firePattern.getDeltaTheta(), et.firePattern.getBulletType()));
    }

    private static void generateSystemList(int id) {
        _sl.clear();
        _sl.add(new UpdateSpriteSystem(id));
        _sl.add(new DestinationMovementSystem(id));
        _sl.add(new DespawnOutOfBoundsSystem(id));
        _sl.add(new FireControlSystem(id));
    }
}
