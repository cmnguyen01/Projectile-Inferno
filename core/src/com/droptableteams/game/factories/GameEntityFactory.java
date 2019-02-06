package com.droptableteams.game.factories;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.RenderComponent;
import com.droptableteams.game.entities.GameEntity;
import com.droptableteams.game.statics.EntityRenderOrder;
import com.droptableteams.game.statics.OrderedSystemTypes;
import com.droptableteams.game.systems.RenderSystem;

import java.util.ArrayList;

/**
 * Factory is not currently very extensible or adaptable
 * for use with script inputs or other forms of argument.
 *
 * TODO: Redesign Factory, and consider building an interface.
 */
public class GameEntityFactory {

    private static ECSEngine _engine = ECSEngine.getInstance(OrderedSystemTypes.get());
    private static ArrayList<IComponent> _cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> _sl = new ArrayList<ISystem>();

    public static void create(SpriteBatch batch) {
        int id = _engine.acquireEntityId();
        IEntity entity = new GameEntity(id);
        generateComponentList(id, batch);
        generateSystemList(id, batch);
        _engine.addEntity(entity, _cl, _sl);
    }

    private static void generateComponentList(int id, SpriteBatch batch) {
        _cl.clear();
        IComponent c1 = new RenderComponent(id, batch, EntityRenderOrder.get());
        _cl.add(c1);
    }

    private static void generateSystemList(int id, SpriteBatch batch) {
        _sl.clear();
        ISystem s1 = new RenderSystem(id);
        _sl.add(s1);
    }
}
