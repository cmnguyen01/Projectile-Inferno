package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.factories.GameEntityFactory;
import com.droptableteams.game.factories.PlayerEntityFactory;
import com.droptableteams.game.statics.OrderedSystemTypes;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	AssetManager assetManager;

	com.droptableteams.game.LibECS.ECSEngine ecsEngine;
	ArrayList<String> systemTypes;
	
	@Override
	public void create () {
        assetManager = new AssetManager();
        loadAssets();
        batch = new SpriteBatch();
        systemTypes = new ArrayList<String>();
        ecsEngine = ECSEngine.getInstance(OrderedSystemTypes.get());
		GameEntityFactory.create(batch);
        PlayerEntityFactory.create(assetManager);
	}

	@Override
	public void render () {
        ecsEngine.update();
	}
	
	@Override
	public void dispose () {
        batch.dispose();
	}

	private void loadAssets() {
	    assetManager.load("vvrv.png", Texture.class);
        while(!assetManager.update());
    }
}
