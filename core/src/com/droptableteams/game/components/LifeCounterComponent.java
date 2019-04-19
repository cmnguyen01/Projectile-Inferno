package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class LifeCounterComponent implements IComponent {
    private int _id;
    private int _count;
    private String _type = "LifeCounterComponent";
    private boolean _isDead;

    public LifeCounterComponent(int id, int initialLives){
        _id = id;
        _count = initialLives;
    }

    public  int getLifeCount(){
        return _count;
    }
    public void IncrementLife(){
        _count++;
    }
    public void DecrementLife(){
        _count--;
        _isDead = true;
    }

    public void beginNewLife(){
        _isDead = false;
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
