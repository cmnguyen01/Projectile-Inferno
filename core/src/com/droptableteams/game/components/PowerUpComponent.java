package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.data.PowerUpData;

public class PowerUpComponent implements IComponent {
    private int _id;
    private String _type;
    public String _powerUpType;
    public boolean _hasPowerUp;

    public PowerUpComponent(int id, String powerUpType){
        _id = id;
        _type = "PowerUpComponent";
        _powerUpType = powerUpType;
        if( powerUpType.equals("")){
            _powerUpType = null;
            _hasPowerUp = false;
        }else {
            _powerUpType = "scripts/powerUp/" + powerUpType + ".json";
            _hasPowerUp = true;
        }
        //powerUp(powerUpType);
    }

    private void powerUp(String powerUp){
        if(powerUp != ""){
            _hasPowerUp = true;
        }
        else{
            _hasPowerUp = false;
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


}
