package com.droptableteams.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.interfaces.IComponent;

public class RenderComponent implements IComponent {
    private int _id;
    private String _type;
    private SpriteBatch _batch;
    private String[] _entityRenderOrder;

    public RenderComponent(int id, SpriteBatch batch, String[] entityRenderOrder) {
        _id = id;
        _batch = batch;
        _type = "RenderComponent";
        _entityRenderOrder = entityRenderOrder;
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public SpriteBatch getBatch() {
        return _batch;
    }

    public String[] getEntityRenderOrder() {
        return _entityRenderOrder;
    }
}
