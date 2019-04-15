package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class LifeCounterComponent implements IComponent {
    private int _id;
    private int _count;
    private String _type = "LifeCounterComponent";

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
