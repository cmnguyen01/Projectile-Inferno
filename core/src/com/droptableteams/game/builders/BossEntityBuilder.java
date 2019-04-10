package com.droptableteams.game.builders;

import com.badlogic.gdx.assets.AssetManager;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.util.data.BossData;
import com.droptableteams.game.util.data.EnemyData;

import java.util.ArrayList;

public class BossEntityBuilder extends AbstractEntityBuilder {
    private static BossEntityBuilder _self;
    private AssetManager _am;
    private BossData _bd;

    private BossEntityBuilder(AssetManager am) {
        _am = am;
        _bd = null;
        _id = null;
    }

    public static BossEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new BossEntityBuilder(am);
        }
        return _self;
    }

    public void setBuildData(BossData bd) {
        _bd = bd;
    }

    @Override
    public void finishBuild() {
        super.finishBuild();
        _bd = null;
    }

    @Override
    public IEntity buildEntity() {
        return null;
    }

    @Override
    public ArrayList<IComponent> buildComponentList() {
        return null;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() {
        return null;
    }
}
