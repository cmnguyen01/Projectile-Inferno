package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.factories.EnemyEntityFactory;
import com.droptableteams.game.factories.GameEntityFactory;
import com.droptableteams.game.factories.PlayerEntityFactory;
import com.droptableteams.game.statics.SystemUpdateOrder;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch _batch;
	private AssetManager _assetManager;

	private ECSEngine _ecsEngine;
	
	@Override
	public void create () {
		_batch = new SpriteBatch();
        _assetManager = new AssetManager();
        loadAssets();
        _ecsEngine = ECSEngine.getInstance(SystemUpdateOrder.get());
		GameEntityFactory.create(_batch);
        PlayerEntityFactory.create(_assetManager);
        EnemyEntityFactory.create(_assetManager);
	}

	@Override
	public void render () {
        _ecsEngine.update();
	}
	
	@Override
	public void dispose () {
        _batch.dispose();
	}

	private void loadAssets() {
	    _assetManager.load("vvrv.png", Texture.class);
        while(!_assetManager.update());
    }
}
