package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

import java.util.ArrayList;


public class DestinationMovementComponent implements IComponent {
    private int _id;
    private String _type;

    private ArrayList<Float> _xList;
    private ArrayList<Float> _yList;
    private ArrayList<Long> _stayForMillis;
    private int nextDest;
    private long _hereSinceMillis;
    private boolean _shouldLoop;


    public DestinationMovementComponent(int id, ArrayList<Float> xList, ArrayList<Float> yList, ArrayList<Long> stayForMillis, boolean shouldLoop) {
        _id = id;
        _type = "DestinationMovementComponent";
        _xList = xList;
        _yList = yList;
        _stayForMillis = stayForMillis;
        nextDest = 0;
        _hereSinceMillis = -1;
        _shouldLoop = shouldLoop;
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
        return _xList.get(nextDest);
    }

    public float getNextY() {
        return _yList.get(nextDest);
    }

    public long getStayFor() {
        return _stayForMillis.get(nextDest);
    }

    public long getHereFor(long currentTimeMillis) {
        if(_hereSinceMillis != -1) {
            return currentTimeMillis - _hereSinceMillis;
        }
        return -1;
    }

    public boolean incrementNextDest() {
        if(nextDest < _xList.size()-1) {
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
