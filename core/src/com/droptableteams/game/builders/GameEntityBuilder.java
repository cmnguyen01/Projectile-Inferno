package com.droptableteams.game.builders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.AbstractEntityBuilder;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.game.*;
import com.droptableteams.game.entities.GameEntity;
import com.droptableteams.game.systems.game.HandleInputSystem;
import com.droptableteams.game.systems.game.SpawnerSystem;
import com.droptableteams.game.util.ScriptReader;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.EntityRenderOrder;
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.systems.game.RenderSystem;

import java.util.ArrayList;

public class GameEntityBuilder extends AbstractEntityBuilder {
    private static GameEntityBuilder _self;
    private AssetManager _am;
    private SpriteBatch _batch;

    private GameEntityBuilder(AssetManager am, SpriteBatch batch) {
        _am = am;
        _batch = batch;
        _id = null;
    }

    public static GameEntityBuilder getInstance(AssetManager am, SpriteBatch batch) {
        if(null == _self) {
            _self = new GameEntityBuilder(am, batch);
        }
        return _self;
    }

    @Override
    public void startBuild() {
        _id = SpecialEntityIds.GAME_ENTITY;
    }

    @Override
    public IEntity buildEntity() throws NullPointerException {
        checkIdNotNull();
        return new GameEntity(_id);
    }

    @Override
    public ArrayList<IComponent> buildComponentList() throws NullPointerException {
        checkIdNotNull();
        if(null == _batch) {
            throw new NullPointerException("Must call setBuildData() first.");
        }
        ArrayList<IComponent> cl = new ArrayList<IComponent>();
        cl.add(new RenderComponent(_id, _batch, EntityRenderOrder.get()));
        cl.add(new AssetManagerComponent(_id, _am));
        cl.add(new GameCheatsComponent(_id, 0.5f));
        cl.add(new SpawnListComponent(_id, ScriptReader.readLevel("sample-level.json")));
        cl.add(new GameTimeComponent(_id));
        return cl;
    }

    @Override
    public ArrayList<ISystem> buildSystemList() throws NullPointerException {
        checkIdNotNull();
        ArrayList<ISystem> sl = new ArrayList<ISystem>();
        sl.add(new RenderSystem(_id));
        sl.add(new HandleInputSystem(_id));
        sl.add(new SpawnerSystem(_id));
        return sl;
    }

    /*private static ECSEngine _engine = ECSEngine.getInstance(SystemUpdateOrder.get());
    private static ArrayList<IComponent> _cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> _sl = new ArrayList<ISystem>();

    @Deprecated
    public static void create(SpriteBatch batch, AssetManager am) {
        int id = SpecialEntityIds.GAME_ENTITY;
        IEntity entity = new GameEntity(id);
        generateComponentList(id, batch, am);
        generateSystemList(id);
        _engine.addEntity(entity, _cl, _sl);
    }

    @Deprecated
    private static void generateComponentList(int id, SpriteBatch batch, AssetManager am) {
        _cl.clear();
        _cl.add(new RenderComponent(id, batch, EntityRenderOrder.get()));
        _cl.add(new AssetManagerComponent(id, am));
        _cl.add(new GameCheatsComponent(id, 0.5f));
        _cl.add(new SpawnListComponent(id, ScriptReader.readLevel("sample-level.json")));
        _cl.add(new GameTimeComponent(id));
    }

    @Deprecated
    private static void generateSystemList(int id) {
        _sl.clear();
        _sl.add(new RenderSystem(id));
        _sl.add(new HandleInputSystem(id));
        _sl.add(new SpawnerSystem(id));
    }*/
}
