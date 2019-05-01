package com.droptableteams.game.systems.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.builders.TextDisplayBuilder;
import com.droptableteams.game.components.LifeCounterComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;
import com.droptableteams.game.components.game.AssetManagerComponent;
import com.droptableteams.game.components.game.SpawnListComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

public class EndGameSystem implements ISystem {
    private int _id;
    private String _type = "EndGameSystem";
    private boolean victory;
    private boolean defeat;
    private  boolean gameOver;
    private EntityManager _em;
    private ECSEngine _engine;
    private ComponentManager _cm;
    private AssetManager _am;


    public EndGameSystem(int id){
        _id = id;
        victory = false;
        defeat = false;
        gameOver = false;
        _em = EntityManager.getInstance();
        _engine = ECSEngine.getInstance(SystemUpdateOrder.get());
        _cm = ComponentManager.getInstance();
        _am = ((AssetManagerComponent)_cm.getComponent(SpecialEntityIds.GAME_ENTITY, "AssetManagerComponent")).getAssetManager();
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void update() {
        if(!gameOver) {
            SpawnListComponent slc = (SpawnListComponent) _cm.getComponent(_id, "SpawnListComponent");

            if (slc.getSpawnList().size() == 0 && (_em.getEntities("EnemyEntity") == null || _em.getEntities("EnemyEntity").size() == 0)
                    && (_em.getEntities("BossEntity") == null || _em.getEntities("BossEntity").size() == 0)) {
                victory = true;
            }
            if (((LifeCounterComponent) _cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "LifeCounterComponent")).getLifeCount() == -1) {
                defeat = true;
            }

            if (victory) {
                displayVictory();
                gameOver = true;
            }
            if (defeat) {
                displayDefeat();
                gameOver = true;
            }
        }
    }
    private void displayVictory(){
        TextDisplayBuilder.getInstance(_am).setBuildData("sprites/victory.png");
        _engine.addEntity(TextDisplayBuilder.getInstance(_am));
        TextDisplayBuilder.getInstance(_am).finishBuild();

    }
    private void displayDefeat(){
        TextDisplayBuilder.getInstance(_am).setBuildData("sprites/defeat.png");
        _engine.addEntity(TextDisplayBuilder.getInstance(_am));
        TextDisplayBuilder.getInstance(_am).finishBuild();
    }
}
