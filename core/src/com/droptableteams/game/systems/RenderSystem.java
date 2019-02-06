package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.RenderComponent;
import com.droptableteams.game.components.SpriteComponent;

import java.util.Map;
import java.util.Set;

public class RenderSystem implements ISystem {
    private int _id;
    private String _type;
    private EntityManager _em;
    private ComponentManager _cm;

    public RenderSystem(int id) {
        _id = id;
        _cm = ComponentManager.getInstance();
        _em = EntityManager.getInstance();
        _type = "RenderSystem";
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
        RenderComponent rc = (RenderComponent) _cm.getComponent(_id,"RenderComponent");

        for(String type : rc.getEntityRenderOrder()) {
            Set<Map.Entry<Integer,IEntity>> entities = _em.getEntities(type).entrySet();
            for(Map.Entry<Integer,IEntity> e : entities) {
                int id = e.getValue().getId();
                SpriteComponent sp = (SpriteComponent)_cm.getComponent(id, "SpriteComponent");
                sp.getSprite().draw(rc.getBatch());
            }
        }
    }
}
