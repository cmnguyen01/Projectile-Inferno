package com.droptableteams.game.builders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.VisibleHitboxEntity;
import com.droptableteams.game.systems.*;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VisibleHitboxEntityBuilder extends AbstractEntityBuilder {
    private static VisibleHitboxEntityBuilder _self;
    private AssetManager _am;

    private VisibleHitboxEntityBuilder(AssetManager am) {
        _am = am;
        _id = null;
    }

    public static VisibleHitboxEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new VisibleHitboxEntityBuilder(am);
        }
        return _self;
    }

    @Override
    public IEntity buildEntity() throws NullPointerException {
        checkIdNotNull();
        return new VisibleHitboxEntity(_id);
    }

    @Override
    public void startBuild() {
        _id = SpecialEntityIds.VISIBLE_HITBOX_ENTITY;
    }

    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        LocationComponent lc = (LocationComponent)ComponentManager.getInstance().getComponent(SpecialEntityIds.PLAYER_ENTITY, "LocationComponent");
        float x = 0, y = 0;
        if(null != lc) {
            x = lc.getX();
            y = lc.getY();
        }
        float width = 12;
        float height = 12;
        Sprite sp = new Sprite(_am.get("sprites/hitbox.png", Texture.class));
        sp.setSize(width,height);
        sp.setCenter(x,y);
        cl.clear();
        cl.add(new SpriteComponent(_id, sp, false));
        cl.add(new LocationComponent(_id, x,y));
        cl.add(new SizeComponent(_id, width,height));
        cl.add(new VelocityComponent(_id, 360));
        cl.add(new RelativePositionComponent(_id, 0,0, SpecialEntityIds.PLAYER_ENTITY));
        return cl;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        sl.add(new UpdateSpriteSystem(_id));
        sl.add(new RelativePositionSystem(_id));
        return sl;
    }
}
