package com.droptableteams.game.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.OrderedSystemTypes;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;
import com.droptableteams.game.entities.PlayerEntity;
import com.droptableteams.game.systems.DrawSystem;
import com.droptableteams.game.systems.UpdateSpriteSystem;

import java.util.ArrayList;

public class PlayerFactory {

    private static ECSEngine _engine = ECSEngine.getInstance(OrderedSystemTypes.get());
    private static ArrayList<IComponent> cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> sl = new ArrayList<ISystem>();

    public static void createPlayer() {
        int id = _engine.acquireEntityId();

        IEntity entity = new PlayerEntity(id);
        IComponent c1 = new SpriteComponent(id, new Sprite(new Texture("vvrv.png")));
        cl.add(c1);
        IComponent c2 = new LocationComponent(id, 10,10);
        cl.add(c2);
        IComponent c3 = new SizeComponent(id, 64,64);
        cl.add(c3);

        ISystem s1 = new DrawSystem(id);
        sl.add(s1);
        ISystem s2 = new UpdateSpriteSystem(id);
        sl.add(s2);

        _engine.addEntity(entity, cl, sl);
    }
}
