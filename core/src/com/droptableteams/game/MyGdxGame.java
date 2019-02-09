package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.components.GameCheatsComponent;
import com.droptableteams.game.factories.BulletEntityFactory;
import com.droptableteams.game.factories.EnemyEntityFactory;
import com.droptableteams.game.factories.GameEntityFactory;
import com.droptableteams.game.factories.PlayerEntityFactory;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch _batch;
	private AssetManager _am;
	private ECSEngine _ecsEngine;

	// Temp var for demo
	private long temporaryLastSpawnVar = 0;

	@Override
	public void create () {
		_batch = new SpriteBatch();
		_am = new AssetManager();
		loadAssets();
		_ecsEngine = ECSEngine.getInstance(SystemUpdateOrder.get());
		GameEntityFactory.create(_batch, _am);
		PlayerEntityFactory.create(_am);
		//EnemyEntityFactory.create(_am);
	}

	@Override
	public void render () {
        temporarySpawnEnemiesMethod();
	    _ecsEngine.update();
	}
	
	@Override
	public void dispose () {
        _batch.dispose();
	}

	private void loadAssets() {
	    _am.load("sprites/player.png", Texture.class);
        _am.load("sprites/enemyA.png", Texture.class);
	    _am.load("sprites/playerBullet.png", Texture.class);
		_am.load("sprites/playerBulletD.png", Texture.class);
        _am.load("sprites/enemyBulletA.png", Texture.class);
		_am.load("sprites/enemyBulletB.png", Texture.class);
        while(!_am.update());

    }

    /**
     * temporary method for demo purposes.
     */
    private void temporarySpawnEnemiesMethod() {
        long time = System.nanoTime();
		ComponentManager cm = _ecsEngine.getComponentManager();
        GameCheatsComponent gcc = (GameCheatsComponent) cm.getComponent(SpecialEntityIds.GAME_ENTITY, "GameCheatsComponent");
        long deltaTime = time - temporaryLastSpawnVar;
        if((float)(deltaTime/Math.pow(10,9)) > 10.0f/gcc.getSpeedMultiplier()) {
            EnemyEntityFactory.create(_am);
            temporaryLastSpawnVar = time;
        }
    }
}
