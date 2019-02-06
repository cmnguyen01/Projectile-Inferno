package com.droptableteams.game.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.SpriteComponent;

/**
 * Draw system works at present, but will have to be refactored eventually,
 * to ensure entities are rendered in the correct order.
 * At present, entities will be rendered in the order in which their systems
 * are hashed in the system manager. This is sub-ideal, since some entities will
 * need to be rendered above or below others.
 *
 * // TODO: consider using a single DrawSystem to draw all entities.
 * // TODO: A new entity type, such as SystemEntity may be appropriate for use with DrawSystem.
 */
public class DrawSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;
    private SpriteBatch _batch;

    public DrawSystem(int id, SpriteBatch batch) {
        _id = id;
        _type = "DrawSystem";
        _cm = ComponentManager.getInstance();
        _batch = batch;
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
        ((SpriteComponent)_cm.getComponent(_id, "SpriteComponent")).getSprite().draw(_batch);
    }
}
