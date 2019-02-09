package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class RelativePositionComponent implements IComponent {
    private int _id;
    private String _type;
    private float _angle;
    private float _radius;
    private int _relativeEntityId;

    public RelativePositionComponent(int id, float angle, float radius, int relativeEntityId) {
        _id = id;
        _angle = angle;
        _radius = radius;
        _relativeEntityId = relativeEntityId;
        _type = "RelativePositionComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public float getDAngle() {
        return _angle;
    }

    public void setAngle(float anle) {
        _angle = anle;
    }

    public float getRadius() {
        return _radius;
    }

    public void setRadius(float radius) {
        _radius = radius;
    }

    public int getRelativeEntityId() {
        return _relativeEntityId;
    }

    public void setRelativeEntityId(int relativeEntityId) {
        _relativeEntityId = relativeEntityId;
    }
}
