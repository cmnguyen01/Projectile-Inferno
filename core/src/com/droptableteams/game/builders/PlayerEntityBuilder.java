package com.droptableteams.game.builders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
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
 * TODO: create PlayerData class, and transition factory to use PlayerData, instead of hardcoded values
 */
public class PlayerEntityBuilder extends AbstractEntityBuilder {
    private static PlayerEntityBuilder _self;
    private AssetManager _am;

    private PlayerEntityBuilder(AssetManager am) {
        _am = am;
        _id = null;
    }

    public static PlayerEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new PlayerEntityBuilder(am);
        }
        return _self;
    }

    @Override
    public void startBuild() {
        _id = SpecialEntityIds.PLAYER_ENTITY;
    }

    @Override
    public IEntity buildEntity() throws NullPointerException {
        checkIdNotNull();
        return new PlayerEntity(_id);
    }

    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        float x = Gdx.graphics.getWidth()/2f;
        float y = Gdx.graphics.getHeight()/4f;
        float width = 64;
        float height = 64;
        Sprite sp = new Sprite(_am.get("sprites/player.png", Texture.class));
        //sp.setCenter(x,y);
        cl.add(new SpriteComponent(_id, sp, true));
        cl.add(new LocationComponent(_id, x,y));
        cl.add(new SizeComponent(_id, width,height));
        cl.add(new VelocityComponent(_id, 360));
        cl.add(new MoveDirectionComponent(_id, null));
        cl.add(new FireControlComponent(_id, 0.125f,false));
        cl.add(new HitpointComponent(_id, 200));
        cl.add(new CollisionsComponent(_id));
        cl.add(new HitboxComponent(_id, new Rectangle(x,y,12,12)));
        cl.add(new FirePatternComponent(_id, Directions.UP, 1, (float)Math.PI/24f, 0, "PlayerBullet"));
        cl.add(new LifeCounterComponent(_id, 5));
        return cl;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        sl.add(new UpdateSpriteSystem(_id));
        sl.add(new StopAtBoundarySystem(_id));
        sl.add(new DirectionalMovementSystem(_id));
        sl.add(new FireControlSystem(_id));
        sl.add(new SpeedModifierSystem(_id));
        sl.add(new CollisionDamageSystem(_id));
        sl.add(new SetHitboxLocationSystem(_id));
        sl.add(new RespawnSystem(_id));
        return sl;
    }
}
