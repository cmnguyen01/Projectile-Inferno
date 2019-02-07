package com.droptableteams.game.interfaces;

import com.badlogic.gdx.assets.AssetManager;

import java.util.HashMap;

public interface IEntityFactory {

    void create(AssetManager am);
    void setArgs(HashMap<String, Object> args);
    void resetDefaults();
}
