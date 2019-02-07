package com.droptableteams.game.factories;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.AssetManagerComponent;
import com.droptableteams.game.components.GameCheatsComponent;
import com.droptableteams.game.components.RenderComponent;
import com.droptableteams.game.entities.GameEntity;
import com.droptableteams.game.statics.SpecialEntityIds;
import com.droptableteams.game.statics.EntityRenderOrder;
import com.droptableteams.game.statics.SystemUpdateOrder;
import com.droptableteams.game.systems.RenderSystem;

import java.util.ArrayList;

/**
 * Factory is not currently very extensible or adaptable
 * for use with script inputs or other forms of argument.
 *
 * TODO: Redesign Factory, and consider building an interface.
 */
public class GameEntityFactory {

    private static ECSEngine _engine = ECSEngine.getInstance(SystemUpdateOrder.get());
    private static ArrayList<IComponent> _cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> _sl = new ArrayList<ISystem>();

    public static void create(SpriteBatch batch, AssetManager am) {
        int id = SpecialEntityIds.getGameEntityId();
        IEntity entity = new GameEntity(id);
        generateComponentList(id, batch, am);
        generateSystemList(id);
        _engine.addEntity(entity, _cl, _sl);
    }

    private static void generateComponentList(int id, SpriteBatch batch, AssetManager am) {
        _cl.clear();
        _cl.add(new RenderComponent(id, batch, EntityRenderOrder.get()));
        _cl.add(new AssetManagerComponent(id, am));
        _cl.add(new GameCheatsComponent(id, 0.5f));
    }

    private static void generateSystemList(int id) {
        _sl.clear();
        _sl.add(new RenderSystem(id));
    }
}
