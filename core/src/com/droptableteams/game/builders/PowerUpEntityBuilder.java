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
import com.droptableteams.game.util.data.PowerUpData;
import com.droptableteams.game.util.types.EnemyType;
import com.droptableteams.game.util.types.PowerUpType;

import java.util.ArrayList;

public class PowerUpEntityBuilder extends AbstractEntityBuilder {
    private static PowerUpEntityBuilder _self;
    private AssetManager _am;
    private PowerUpData _pd;


    private PowerUpEntityBuilder(AssetManager am) {
        _am = am;
        _id = null;
        _pd = null;
    }

    public static PowerUpEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new PowerUpEntityBuilder(am);
        }
        return _self;
    }

    public void setBuildData(PowerUpData pd){
        _pd = pd;
    }


    @Override
    public void finishBuild() {
        super.finishBuild();
        _pd = null;
    }

    @Override
    public IEntity buildEntity() throws NullPointerException {
        checkIdNotNull();
        return new PowerUpEntity(_id);
    }

    // Not done yet. Still need to figure out all necessary components
    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        if(null == _id) {
            throw new NullPointerException("_id cannot be null. Was startBuild() called? Note: ECSEngine does this automatically.");
        }
        if(null == _pd) {
            throw new NullPointerException("Must call setBuildData() first.");
        }

        //TODO: Add power ups to script. Load powerups from script
        //TODO: Load sprite, and set size, center, etc

        //Below is some pseudo code to give a general idea for implementation
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        Json json = new Json();
        PowerUpType pt = json.fromJson(PowerUpType.class, Gdx.files.internal("scripts/powerUp/" + _pd.powerUpType+ ".json"));
        Sprite sp = new Sprite(_am.get(pt.texture, Texture.class));
        sp.setSize(pt.width, pt.height);
        sp.setCenter(_pd.x, _pd.y);
        cl.add(new SpriteComponent(_id, sp));
        cl.add(new LocationComponent(_id, _pd.x, _pd.y));
        cl.add(new SizeComponent(_id, pt.width, pt.height));
        cl.add(new VelocityComponent(_id, pt.speed));
        cl.add(new MoveDirectionComponent(_id, _pd.direction));
        cl.add(new HitboxComponent(_id, new Rectangle(_pd.x, _pd.y, pt.width, pt.height)));
        return cl;
    }

    // Not done yet. Not sure what other systems to add. Will figure out later
    @Override
    public ArrayList<ISystem> buildSystemList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        sl.add(new UpdateSpriteSystem(_id));
        sl.add(new DirectionalMovementSystem(_id));
        sl.add(new SetHitboxLocationSystem(_id));
        sl.add(new PowerUpCollisionSystem(_id));
        return sl;
    }
}
