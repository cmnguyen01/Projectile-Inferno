package com.droptableteams.game.builders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.components.game.GameTimeComponent;
import com.droptableteams.game.entities.FireControlEntity;
import com.droptableteams.game.systems.*;
import com.droptableteams.game.util.constants.*;
import com.droptableteams.game.util.data.FireControlData;
import com.droptableteams.game.util.types.FirePatternType;
import com.droptableteams.game.util.types.SubtypeManager;
import com.droptableteams.game.util.constants.EntityRenderOrder;

import java.util.ArrayList;

public class FireControlEntityBuilder extends AbstractEntityBuilder {
    AssetManager _am;
    FireControlData _fcd;

    private static FireControlEntityBuilder _self;

    private FireControlEntityBuilder(AssetManager am) {
        _am = am;
        _fcd = null;
        _id = null;
    }

    public static FireControlEntityBuilder getInstance(AssetManager am) {
        if (null == _self) {
            _self = new FireControlEntityBuilder(am);
        }
        return _self;
    }

    public void setBuildData(FireControlData fcd) {
        _fcd = fcd;
    }

    @Override
    public void finishBuild() {
        super.finishBuild();
        _fcd = null;
    }

    @Override
    public IEntity buildEntity() {
        checkIdNotNull();
        return new FireControlEntity(_id);
    }

    @Override
    public ArrayList<IComponent> buildComponentList() {
        if (null == _fcd) {
            throw new NullPointerException("Must call `setBuildData()` first.");
        }
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        FirePatternType fpt = (FirePatternType) SubtypeManager.getInstance().getSubtype(_fcd.firePattenrType);
        if (fpt.fcTexture != "") {
            Sprite sp = new Sprite(_am.get(fpt.fcTexture, Texture.class));
            cl.add(new SpriteComponent(_id, sp));
            cl.add(new SizeComponent(_id, fpt.fcWidth, fpt.fcHeight));
        }
        cl.add(new RelativePositionComponent(_id, fpt.fcInitialTheta, fpt.fcInitialRadius, _fcd.parentId));
        if (fpt.deltaTheta != 0f || fpt.fcDeltaRadius != 0) {
            cl.add(new SpiralComponent(_id, fpt.fcDeltaRadius, fpt.fcDeltaTheta));
        }
        LocationComponent plc = (LocationComponent) ECSEngine.getInstance(SystemUpdateOrder.get()).getComponentManager().getComponent(_fcd.parentId, "LocationComponent");
        GameTimeComponent gtc = (GameTimeComponent) ComponentManager.getInstance().getComponent(SpecialEntityIds.GAME_ENTITY, "GameTimeComponent");
        long currentTime = gtc.getTimeInMillis();
        cl.add(new DurationComponent(_id, fpt.fcDurationType, fpt.duration, currentTime));
        cl.add(new LocationComponent(_id, plc.getX(), plc.getY()));
        cl.add(new FireControlComponent(_id, _fcd));
        cl.add(new FirePatternComponent(_id, fpt.baseDirection, fpt.rateOfFire, fpt.numberOfBullets,
                fpt.dividingAngle, fpt.deltaTheta, fpt.bulletType));
        cl.add(new OwnerComponent(_id, _fcd.parentId));
        return cl;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() {
        checkIdNotNull();
        if (null == _fcd) {
            throw new NullPointerException("Must call `setBuildData()` first.");
        }
        FirePatternType fpt = (FirePatternType) SubtypeManager.getInstance().getSubtype(_fcd.firePattenrType);
        ArrayList<ISystem> sl = new ArrayList<ISystem>();

        sl.add(new RelativePositionSystem(_id));
        if (fpt.fcDeltaRadius != 0 || fpt.fcDeltaTheta != 0) {
            sl.add(new SpiralAroundEntitySytem(_id));
        }
        if (fpt.fcTexture != "") {
            sl.add(new UpdateSpriteSystem(_id));
        }
        sl.add(new FireControlSystem(_id));
        sl.add(new DestroyOnOwnerDeathSystem(_id));
        sl.add(new DurationSystem(_id));
        sl.add(new DespawnWithDurationSystem(_id));
        return sl;
    }
}
