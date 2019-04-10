package com.droptableteams.game.util.data;

import com.droptableteams.game.util.TimeVector3;

import java.util.ArrayList;

public class BossData {
    public String bossType;
    public ArrayList<TimeVector3> destinationList;
    public float x;
    public float y;

    public BossData() {
        bossType = "none";
        destinationList = null;
        x = 0;
        y = 0;
    }

    public BossData(String bossType, ArrayList<TimeVector3> destinationList, float x, float y) {
        this.bossType = bossType;
        this.destinationList = destinationList;
        this.x = x;
        this.y = y;
    }
}
