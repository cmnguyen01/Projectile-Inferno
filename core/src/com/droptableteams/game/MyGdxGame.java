package com.droptableteams.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.ecs.*;

import java.util.ArrayList;

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

        ComponentManager cm = ComponentManager.getInstance();
		ArrayList<IComponent> sprites = cm.getComponents("SpriteComponent");
		batch.begin();

        for (IComponent sprite: sprites) {
            IComponent location = cm.getComponent(sprite.getId(), "LocationComponent");
            IComponent size = cm.getComponent(sprite.getId(), "SizeComponent");
            SpriteComponent s = (SpriteComponent) sprite;
            LocationComponent l = (LocationComponent) location;
            SizeComponent z = (SizeComponent) size;
            batch.draw(s.getSprite(), l.getX(), l.getY(), z.getWidth(), z.getHeight());
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
