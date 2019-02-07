package com.droptableteams.game.components;

import com.badlogic.gdx.assets.AssetManager;
import com.droptableteams.game.LibECS.interfaces.IComponent;

public class AssetManagerComponent implements IComponent {
    private int _id;
    private String _type;
    private AssetManager _am;

    public AssetManagerComponent(int id, AssetManager am) {
        _id = id;
        _am = am;
        _type = "AssetManagerComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public AssetManager getAssetManager() { return _am; }
}
