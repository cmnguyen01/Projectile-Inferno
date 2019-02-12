package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.JsonWriter;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.factories.EnemyEntityFactory;
import com.droptableteams.game.factories.GameEntityFactory;
import com.droptableteams.game.factories.PlayerEntityFactory;
import com.droptableteams.game.factories.data.EnemyData;
import com.droptableteams.game.util.Spawnable;
import com.droptableteams.game.util.TimeVector2;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

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
		//writeSampleLevelJson();
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
		_am.load("sprites/enemyB.png", Texture.class);
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
        long deltaTime = time - temporaryLastSpawnVar;
        if((float)(deltaTime/Math.pow(10,9)) > 10.0f) { // TODO: removing speed mult from all but player move
			ArrayList<TimeVector2> destinations = new ArrayList<TimeVector2>();
			float initX = -64;
			float initY = Gdx.graphics.getHeight()/2;
			float finalX = Gdx.graphics.getWidth() + 64;
			float finalY = initY;
			destinations.add(new TimeVector2(finalX, finalY, 0l));
        	EnemyData ed = new EnemyData("EnemyB", destinations, initX, initY);
            EnemyEntityFactory.createTypeB(_am, ed);
            temporaryLastSpawnVar = time;
        }
    }

    /**
     * temporary method to generate json files
     */
    private void writeSampleLevelJson() {
    	float initX = Gdx.graphics.getWidth();
    	float initY = Gdx.graphics.getHeight();
    	float finalX = 3*Gdx.graphics.getWidth()/4;
    	float finalY = 3*Gdx.graphics.getHeight()/4;
    	ArrayList<TimeVector2> destinations = new ArrayList<TimeVector2>();
    	destinations.add(new TimeVector2(finalX,finalY,0l));
    	EnemyData ed = new EnemyData("EnemyA", destinations, initX,initY);
    	Spawnable spawnable = new Spawnable(0L, "EnemyEntity", ed);
		ArrayList<Spawnable> spawnList = new ArrayList<Spawnable>();
		spawnList.add(spawnable);

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("sample-level.json"));
            json.setOutputType(JsonWriter.OutputType.json);
			out.write(json.prettyPrint(spawnList));
			out.close();
			System.out.println("File created successfully");
		}
		catch (IOException e) {
		}

	}
}
