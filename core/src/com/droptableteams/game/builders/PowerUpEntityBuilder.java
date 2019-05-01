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

    // Not done yet. Still need to figure out all necessary components
    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        checkIdNotNull();

        //TODO: Add power ups to script. Load powerups from script
        //TODO: Load sprite, and set size, center, etc

        //Below is some pseudo code to give a general idea for implementation
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        //cl.add(new SpriteComponent(_id, sp));
        //cl.add(location component)
        //cl.add(size component)
        //cl.add(hitbox component)
        return cl;
    }

    // Not done yet. Unsure what other systems to add. Will figure out
    @Override
    public ArrayList<ISystem> buildSystemList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        sl.add(new UpdateSpriteSystem(_id));
        sl.add(new SetHitboxLocationSystem(_id));
        // Power up collision system belongs to player, and not power up
        //sl.add(new PowerUpCollisionSystem(_id));
        return sl;
    }
}
