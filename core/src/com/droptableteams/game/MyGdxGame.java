package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.JsonWriter;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.builders.GameEntityBuilder;
import com.droptableteams.game.builders.LifeDisplayBuilder;
import com.droptableteams.game.builders.PlayerEntityBuilder;
import com.droptableteams.game.builders.VisibleHitboxEntityBuilder;
import com.droptableteams.game.entities.PlayerEntity;
import com.droptableteams.game.util.ScriptReader;
import com.droptableteams.game.util.data.EnemyData;
import com.droptableteams.game.util.Spawnable;
import com.droptableteams.game.util.TimeVector3;
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.util.types.BulletType;
import com.droptableteams.game.util.types.EnemyType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

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
		initializeEntities();
		parseTypeData();
	}

	@Override
	public void render () {
	    _ecsEngine.update();
	}
	
	@Override
	public void dispose () {
        _batch.dispose();
        _am.dispose();
	}

	/**
	 * Load all assets into asset manager, and loop until loading complete.
	 */
	private void loadAssets() {
	    _am.load("sprites/player.png", Texture.class);
        _am.load("sprites/enemyA.png", Texture.class);
		_am.load("sprites/enemyB.png", Texture.class);
		_am.load("sprites/hitbox.png", Texture.class);
	    _am.load("sprites/playerBullet.png", Texture.class);
		_am.load("sprites/playerBulletD.png", Texture.class);
        _am.load("sprites/enemyBulletA.png", Texture.class);
		_am.load("sprites/enemyBulletB.png", Texture.class);
		_am.load("sprites/shield.png", Texture.class);
        while(!_am.update());
    }

	/**
	 * Add starting entities to ECSEngine.
	 */
	private void initializeEntities() {
		GameEntityBuilder geBuilder = GameEntityBuilder.getInstance(_am, _batch);
		_ecsEngine.addEntity(geBuilder);
		PlayerEntityBuilder peBuilder = PlayerEntityBuilder.getInstance(_am);
		_ecsEngine.addEntity(peBuilder);
		VisibleHitboxEntityBuilder vheBuilder = VisibleHitboxEntityBuilder.getInstance(_am);
		_ecsEngine.addEntity(vheBuilder);

	}

	private void parseTypeData() {
		String[] typePaths = {
				"enemyA.json",
				"enemyB.json",
				"EnemyBulletA.json",
				"EnemyBulletB.json",
				"PlayerBullet.json",
		};
		Class<?>[] classTypes = {
				EnemyType.class,
				EnemyType.class,
				BulletType.class,
				BulletType.class,
				BulletType.class,
		};
		for(int i=0; i < typePaths.length; i++) {
			ScriptReader.readTypeData(typePaths[i], classTypes[i]);
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
    	ArrayList<TimeVector3> destinations = new ArrayList<TimeVector3>();
    	destinations.add(new TimeVector3(finalX,finalY,0l));
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
