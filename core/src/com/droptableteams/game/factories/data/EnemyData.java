package com.droptableteams.game.factories.data;

import com.droptableteams.game.util.TimeVector3;

import java.util.ArrayList;

public class EnemyData {
    public String enemyType;
    public ArrayList<TimeVector3> destinationList;
    public float x;
    public float y;

    public EnemyData() {
        enemyType = "unknown";
        destinationList = null;
        x = 0;
        y = 0;
    }

    public EnemyData(String enemyType, ArrayList<TimeVector3> destinationList, float x, float y) {
        this.enemyType = enemyType;
        this.destinationList = destinationList;
        this.x = x;
        this.y = y;
    }
}
