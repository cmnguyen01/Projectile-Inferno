package com.droptableteams.game.ecs;

import com.badlogic.gdx.graphics.Texture;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.OrderedSystemTypes;

import java.util.ArrayList;

public class PlayerFactory {

    private static ECSEngine _engine = ECSEngine.getInstance(OrderedSystemTypes.get());
    private static ArrayList<IComponent> cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> sl = new ArrayList<ISystem>();

    public static void createPlayer() {
        int id = _engine.acquireEntityId();

        IEntity entity = new PlayerEntity(id);
        IComponent c1 = new SpriteComponent(id, new Texture("vvrv.png"));
        cl.add(c1);
        IComponent c2 = new LocationComponent(id, 10,10);
        cl.add(c2);
        IComponent c3 = new SizeComponent(id, 64,64);
        cl.add(c3);
        _engine.addEntity(entity, cl, sl);
    }
}
