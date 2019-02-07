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

import java.util.Dictionary;
import java.util.HashMap;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch _batch;
	private AssetManager _am;

	private ECSEngine _ecsEngine;

	
	@Override
	public void create () {
		_batch = new SpriteBatch();
		_am = new AssetManager();
		loadAssets();
		_ecsEngine = ECSEngine.getInstance(SystemUpdateOrder.get());
		GameEntityFactory.create(_batch, _am);
		PlayerEntityFactory.create(_am);
		EnemyEntityFactory.create(_am);
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
	    _am.load("sprites/player.png", Texture.class);
	    _am.load("sprites/playerbullet.png", Texture.class);
	    _am.load("sprites/enemyA.png", Texture.class);
        while(!_am.update());

    }
}
