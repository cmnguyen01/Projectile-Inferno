package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.constants.Enums.DurationType;

import javax.xml.datatype.Duration;

public class DurationComponent implements IComponent {

    private int _id;
    private String _type;
    // data:
    public DurationType durationType;
    public float duration;
    public float elapsedTheta;
    public float elapsedRadius;
    public long startTime;
    public boolean durationMet;

    public DurationComponent(int id, DurationType durationType, float duration) {
        _id = id;
        _type = "DurationComponent";
        this.durationType = durationType;
        this.duration = duration;
        startTime = 0;
        elapsedRadius = 0;
        elapsedTheta = 0;
        durationMet = false;
    }

    public DurationComponent(int id, DurationType durationType, float duration, long startTime) {
        _id = id;
        _type = "DurationComponent";
        this.durationType = durationType;
        this.duration = duration;
        this.startTime = startTime;
        elapsedRadius = 0;
        elapsedTheta = 0;
        durationMet = false;
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }
}
