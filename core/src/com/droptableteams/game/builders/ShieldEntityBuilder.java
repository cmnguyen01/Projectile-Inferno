package com.droptableteams.game.builders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.ShieldEntity;
import com.droptableteams.game.systems.RelativePositionSystem;
import com.droptableteams.game.systems.SetHitboxLocationSystem;
import com.droptableteams.game.systems.UpdateSpriteSystem;
import com.droptableteams.game.util.constants.SpecialEntityIds;

import java.util.ArrayList;

public class ShieldEntityBuilder extends AbstractEntityBuilder {
    private static ShieldEntityBuilder _self;

    private AssetManager _am;

    private ShieldEntityBuilder(AssetManager am) {
        _am = am;
        _id = null;
    }

    public static ShieldEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new ShieldEntityBuilder(am);
        }
        return _self;
    }

    @Override
    public IEntity buildEntity() throws NullPointerException {
        checkIdNotNull();
        return new ShieldEntity(_id);
    }

    @Override
    public void startBuild() {
        _id = SpecialEntityIds.SHIELD_ENTITY;
    }

    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        checkIdNotNull();
        ComponentManager cm = ComponentManager.getInstance();
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        LocationComponent lc = (LocationComponent) cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "LocationComponent");
        SizeComponent sc = (SizeComponent) cm.getComponent((SpecialEntityIds.PLAYER_ENTITY), "SizeComponent");
        float x = 0, y = 0;
        if(null != lc) {
            x = lc.getX();
            y = lc.getY();
        }
        float width = sc.getWidth()*1.1f;
        float height = sc.getHeight()*1.1f;
        Sprite sp = new Sprite(_am.get("sprites/shield.png", Texture.class));
        sp.setSize(width,height);
        sp.setCenter(x,y);
        cl.clear();
        cl.add(new HitboxComponent(_id,new Rectangle(x,y,width,height)));
        cl.add(new SpriteComponent(_id, sp));
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
        sl.add(new SetHitboxLocationSystem(_id));
        sl.add(new RelativePositionSystem(_id));
        return sl;
    }
}
