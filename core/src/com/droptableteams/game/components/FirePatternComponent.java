package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

// TODO: consolidate fire pattern and fire control components
// TODO: create fire pattern definitions?
// EG: fire pattern type A, B, C ?
public class FirePatternComponent implements IComponent {
    private int _id;
    private String _type;
    private float _baseDirection;
    private int _numberOfBullets;
    private float _dividingAngle;
    private float _deltaTheta;
    private String _bulletType;

    public FirePatternComponent(int id, float baseDirection, String bulletType) {
        _id = id;
        _baseDirection = baseDirection;
        _numberOfBullets = 1;
        _dividingAngle = 0;
        _deltaTheta = 0;
        _bulletType = bulletType;
        _type = "FirePatternComponent";
    }

    public FirePatternComponent(int id, float baseDirection, int numberOfBullets,
                                float dividingAngle, float deltaTheta, String bulletType) {
        _id = id;
        _baseDirection = baseDirection;
        _numberOfBullets = numberOfBullets;
        _dividingAngle = dividingAngle;
        _deltaTheta = deltaTheta;
        _bulletType = bulletType;
        _type = "FirePatternComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public float getBaseDirection() {
        return _baseDirection;
    }

    public void setBaseDirection(float baseDirection) {
        _baseDirection = baseDirection;
    }

    public int getNumberOfBullets() {
        return _numberOfBullets;
    }

    public void setNumberOfBullets(int numberOfBullets) {
        _numberOfBullets = numberOfBullets;
    }

    public float getDividingAngle() {
        return _dividingAngle;
    }

    public void setDividingAngle(float dividingAngle) {
        _dividingAngle = dividingAngle;
    }

    public float getDeltaTheta() { return _deltaTheta; }

    public void setDeltaTheta(float deltaTheta) {
        _deltaTheta = deltaTheta;
    }

    public String getBulletType() {
        return _bulletType;
    }

    public void setBulletType(String bulletType) {
        _bulletType = bulletType;
    }
}
