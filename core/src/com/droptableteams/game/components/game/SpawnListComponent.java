package com.droptableteams.game.components.game;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.Spawnable;

import java.util.ArrayList;

public class SpawnListComponent implements IComponent {
    private int _id;
    private String _type;
    private ArrayList<ArrayList<Spawnable>> _spawnList;

    public SpawnListComponent(int id, ArrayList<ArrayList<Spawnable>> spawnList) {
        _id = id;
        _type = "SpawnListComponent";
        _spawnList = spawnList;
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public ArrayList<ArrayList<Spawnable>> getSpawnList() {
        return _spawnList;
    }

    public void setSpawnList(ArrayList<ArrayList<Spawnable>> spawnList) {
        _spawnList = spawnList;
    }
}
