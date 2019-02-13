package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.TimeVector3;

import java.util.ArrayList;


public class DestinationMovementComponent implements IComponent {
    private int _id;
    private String _type;
    private ArrayList<TimeVector3> _destinationList;
    private int nextDest;
    private long _hereSinceMillis;
    private boolean _shouldLoop;


    public DestinationMovementComponent(int id, ArrayList<TimeVector3> destinationList, boolean shouldLoop) {
        _id = id;
        _type = "DestinationMovementComponent";
        nextDest = 0;
        _hereSinceMillis = -1;
        _shouldLoop = shouldLoop;
        _destinationList = destinationList;

    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public float getNextX() {
        return _destinationList.get(nextDest).getX();
    }

    public float getNextY() {
        return _destinationList.get(nextDest).getY();
    }

    public long getStayFor() {
        return _destinationList.get(nextDest).getTime();
    }

    public long getHereFor(long currentTimeMillis) {
        if(_hereSinceMillis != -1) {
            return currentTimeMillis - _hereSinceMillis;
        }
        return -1;
    }

    public boolean incrementNextDest() {
        if(nextDest < _destinationList.size()-1) {
            nextDest++;
            return true;
        }
        else {
            if(_shouldLoop) {
                nextDest = 0;
                return true;
            }
        }
        return false;
    }

    public void setHereSinceMillis(long timeInMillis) {
        _hereSinceMillis = timeInMillis;
    }
}
