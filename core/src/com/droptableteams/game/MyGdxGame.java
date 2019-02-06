package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.SystemManager;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;
import com.droptableteams.game.factories.PlayerFactory;
import com.droptableteams.game.systems.DrawSystem;

import java.util.ArrayList;
import java.util.Map;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	com.droptableteams.game.LibECS.ECSEngine ecsEngine;
	ArrayList<String> systemTypes;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		systemTypes = new ArrayList<String>();
		ecsEngine = ECSEngine.getInstance(OrderedSystemTypes.get());
        PlayerFactory.createPlayer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ecsEngine.update();
		batch.begin();
        for(Map.Entry<Integer, ISystem> e : SystemManager.getInstance().getSystemEntries("DrawSystem")) {
            ((DrawSystem)e.getValue()).draw(batch);
        }
		//batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
