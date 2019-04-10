package com.droptableteams.game.builders;

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
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.systems.*;

public class BossEntityBuilder extends AbstractEntityBuilder{
    private static BossEntityBuilder _self;
    private AssetManager _am;
    //private EnemyData _ed;

    private BossEntityBuilder(AssetManager am) {
        _am = am;
        //_ed = null;
        _id = null;
    }
    public static BossEntityBuilder getInstance(AssetManager am) {
        if(null == _self) {
            _self = new BossEntityBuilder(am);
        }
        return _self;
    }

}
