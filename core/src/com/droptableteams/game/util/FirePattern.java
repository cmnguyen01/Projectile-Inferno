package com.droptableteams.game.util;

/**
 * currently unused.
 * TODO: store as a member of fire control component?
 */
public class FirePattern {
    private float _baseDirection;
    private int _numberOfBullets;
    private int _dividingAngle;
    private boolean _splitForEven;

    public FirePattern(float baseDirection, int numberOfBullets, int dividingAngle, boolean splitAroundBaseDirection) {
        _baseDirection = baseDirection;
        _numberOfBullets = numberOfBullets;
        _dividingAngle = dividingAngle;
        _splitForEven = splitAroundBaseDirection;
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

    public int getDividingAngle() {
        return _dividingAngle;
    }

    public void set_dividingAngle(int dividingAngle) {
        _dividingAngle = dividingAngle;
    }

    public boolean isSplitForEven() {
        return _splitForEven;
    }

    public void setSplitForEven(boolean splitForEven) {
        _splitForEven = splitForEven;
    }
}
