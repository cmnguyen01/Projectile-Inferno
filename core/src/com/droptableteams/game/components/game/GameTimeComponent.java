package com.droptableteams.game.components.game;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.Utils;

public class GameTimeComponent implements IComponent {
    private int _id;
    private String _type;
    private long _startTime;

    public GameTimeComponent(int id) {
        _id = id;
        _type = "GameTimeComponent";
        _startTime = Utils.nanosToMillis(System.nanoTime());
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

    public long getTimeInMillis() {
        long now = Utils.nanosToMillis(System.nanoTime());
        return now - _startTime;
    }
}
