package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        ecsEngine.update();
        batch.end();
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
