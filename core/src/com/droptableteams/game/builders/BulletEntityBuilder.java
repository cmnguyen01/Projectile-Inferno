package com.droptableteams.game.builders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.BulletEntity;
import com.droptableteams.game.util.types.BulletType;
import com.droptableteams.game.util.types.BulletTypeFactory;
import com.droptableteams.game.util.data.BulletData;
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.systems.*;

import java.util.ArrayList;

public class BulletEntityBuilder extends AbstractEntityBuilder {
    private static BulletEntityBuilder _self;
    private AssetManager _am;
    private BulletData _bd;

    private BulletEntityBuilder(AssetManager am) {
        _am = am;
        _bd = null;
        _id = null;
    }

    public static BulletEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new BulletEntityBuilder(am);
        }
        return _self;
    }

    public void setBuildData(BulletData bd) {
        _bd = bd;
    }

    @Override
    public void finishBuild() {
        super.finishBuild();
        _bd = null;
    }

    @Override
    public IEntity buildEntity() throws NullPointerException {
        if(null == _id) {
            throw new NullPointerException();
        }
        return new BulletEntity(_id);
    }

    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        if(null == _id) {
            throw new NullPointerException("_id cannot be null. Was startBuild() called? Note: ECSEngine does this automatically.");
        }
        if(null == _bd) {
            throw new NullPointerException("Must call setBuildData() first.");
        }
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        BulletType bt = BulletTypeFactory.make(_bd.bulletType);
        Sprite sp = new Sprite(_am.get(bt.texture, Texture.class));
        sp.setSize(bt.width,bt.height);
        sp.setCenter(_bd.x,_bd.y);
        cl.add(new SpriteComponent(_id, sp));
        cl.add(new LocationComponent(_id, _bd.x,_bd.y));
        cl.add(new SizeComponent(_id, bt.width,bt.height));
        cl.add(new VelocityComponent(_id, bt.speed));
        cl.add(new HasBeenInboundsComponent(_id, false));
        cl.add(new MoveDirectionComponent(_id, _bd.direction));
        cl.add(new OwnerComponent(_id, _bd.ownerId));
        cl.add(new DamageComponent(_id, bt.damage));
        cl.add(new HitboxComponent(_id, new Rectangle(_bd.x,_bd.y,bt.width,bt.height)));
        return cl;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() throws NullPointerException {
        if(null == _id) {
            throw new NullPointerException("_id cannot be null. Was startBuild() called?");
        }
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        sl.add(new UpdateSpriteSystem(_id));
        sl.add(new DespawnOutOfBoundsSystem(_id));
        sl.add(new DirectionalMovementSystem(_id));
        sl.add(new RotateSpriteToDirectionSystem(_id));
        sl.add(new BulletCollisionSystem(_id));
        sl.add(new SetHitboxLocationSystem(_id));
        return sl;
    }
}
