package com.droptableteams.game.builders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;
import com.droptableteams.game.entities.LifeDisplayEntity;
import com.droptableteams.game.systems.UpdateSpriteSystem;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

import java.util.ArrayList;

public class LifeDisplayBuilder extends AbstractEntityBuilder {
    private static LifeDisplayBuilder _self;
    private AssetManager _am;

    public static LifeDisplayBuilder getInstance(AssetManager am){
        if(null == _self) {
            _self = new LifeDisplayBuilder(am);
        }
        return _self;
    }
    private LifeDisplayBuilder(AssetManager am){
        _am = am;
        _id = null;
    }
    @Override
    public IEntity buildEntity() {
        checkIdNotNull();
        return new LifeDisplayEntity(_id);
    }

    @Override
    public ArrayList<IComponent> buildComponentList() {
        checkIdNotNull();
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        float width = 14;
        float height = 14;
        float x = Gdx.graphics.getWidth();
        float y = Gdx.graphics.getHeight();
        ECSEngine engine = ECSEngine.getInstance(SystemUpdateOrder.get());
        EntityManager em = engine.getEntityManager();
        int numOfLifeEntities = 0;
        if(em.getEntities("LifeDisplayEntity") != null)
            numOfLifeEntities = em.getEntities("LifeDisplayEntity").size();
        Sprite sp = new Sprite(_am.get("sprites/player.png", Texture.class));
        x = x-width*(numOfLifeEntities+1);
        y = y-height;
        //sp.setCenter(x,y);
        cl.add(new SpriteComponent(_id, sp, true));
        cl.add(new SizeComponent(_id,width,height));
        cl.add(new LocationComponent(_id, x,y));
        return cl;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() {
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        sl.add(new UpdateSpriteSystem(_id));

        return sl;
    }
}
