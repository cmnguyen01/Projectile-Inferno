package com.droptableteams.game.factories.data;

import com.droptableteams.game.util.TimeVector2;

import java.util.ArrayList;

public class EnemyData {
    public String enemyType;
    public ArrayList<TimeVector2> destinationList;
    public float x;
    public float y;

    public EnemyData(String enemyType, ArrayList<TimeVector2> destinationList, float x, float y) {
        this.enemyType = enemyType;
        this.destinationList = destinationList;
        this.x = x;
        this.y = y;
    }
}
