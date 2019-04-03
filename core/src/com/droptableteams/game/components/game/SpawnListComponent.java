package com.droptableteams.game.components.game;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.Spawnable;
import com.droptableteams.game.util.Wave;
import com.droptableteams.game.util.data.EnemyData;

import java.util.ArrayList;

public class SpawnListComponent implements IComponent {
    private int _id;
    private String _type;
    private ArrayList<Spawnable> _spawnList;

    public SpawnListComponent(int id, ArrayList<Wave> waveList) {
        _id = id;
        _spawnList = new ArrayList<Spawnable>();
        _type = "SpawnListComponent";
        for (Wave x: waveList)
        {
            _spawnList.addAll(x.enemies);
        }
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public ArrayList<Spawnable> getSpawnList() {
        return _spawnList;
    }

    public void setSpawnList(ArrayList<Spawnable> spawnList) {
        _spawnList = spawnList;
    }
}
