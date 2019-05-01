package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.OwnerComponent;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

import java.util.ArrayList;

public class DestroyOnOwnerDeathSystem implements ISystem {
    private int _id;
    private String _type;

    public DestroyOnOwnerDeathSystem(int id) {
        _id = id;
        _type = "DestroyOnOwnerDeathSystem";
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
        ECSEngine engine = ECSEngine.getInstance(SystemUpdateOrder.get());
        OwnerComponent oc = (OwnerComponent)engine.getComponentManager().getComponent(_id, "OwnerComponenet");
        ArrayList<Integer> flagged = engine.getFlaggedForRemoval();
        for(int i = 0; i < flagged.size(); i++) {
            if(oc.getOwnerId() == flagged.get(i)) {
                engine.flagEntityForRemoval(_id);
            }
        }
    }
}
