package com.droptableteams.game.builders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Json;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.PowerUpEntity;
import com.droptableteams.game.systems.*;
import com.droptableteams.game.util.data.EnemyData;
import com.droptableteams.game.util.types.EnemyType;

import java.util.ArrayList;

public class PowerUpEntityBuilder extends AbstractEntityBuilder {
    private static PowerUpEntityBuilder _self;
    private AssetManager _am;


    private PowerUpEntityBuilder(AssetManager am) {
        _am = am;
        _id = null;
    }

    public static PowerUpEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new PowerUpEntityBuilder(am);
        }
        return _self;
    }


    @Override
    public void finishBuild() {
        super.finishBuild();
    }

    @Override
    public IEntity buildEntity() throws NullPointerException {
        checkIdNotNull();
        return new PowerUpEntity(_id);
    }

    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        return cl;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        return sl;
    }
}
