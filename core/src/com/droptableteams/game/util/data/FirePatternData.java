package com.droptableteams.game.util.data;

/**
 * currently unused.
 * TODO: store as a member of fire control component?
 */
public class FirePatternData {
    private float _baseDirection;
    private int _numberOfBullets;
    private float _dividingAngle;
    private boolean _splitForEven;
    private float _deltaTheta;
    private float _fireRate;
    private String _bulletType;

    public FirePatternData(float baseDirection, int numberOfBullets, float dividingAngle, float deltaTheta, float fireRate, String bulletType) {
        _baseDirection = baseDirection;
        _numberOfBullets = numberOfBullets;
        _dividingAngle = dividingAngle;
        _deltaTheta = deltaTheta;
        _fireRate = fireRate;
        _bulletType = bulletType;
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

    public void setNumberOfBullets(int nnumberOfBullets) {
        _numberOfBullets = nnumberOfBullets;
    }

    public float getDividingAngle() {
        return _dividingAngle;
    }

    public void setDividingAngle(float dividingAngle) {
        _dividingAngle = dividingAngle;
    }

    public boolean isSplitForEven() {
        return _splitForEven;
    }

    public void setSplitForEven(boolean splitForEven) {
        _splitForEven = splitForEven;
    }

    public float getDeltaTheta() {
        return _deltaTheta;
    }

    public void setDeltaTheta(float deltaTheta) {
        _deltaTheta = deltaTheta;
    }

    public float getFireRate() {
        return _fireRate;
    }

    public void setFireRate(float fireRate) {
        _fireRate = fireRate;
    }

    public String getBulletType() {
        return _bulletType;
    }

    public void setBulletType(String bulletType) {
        _bulletType = bulletType;
    }
}
