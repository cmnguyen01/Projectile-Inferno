package com.droptableteams.game.entities.types;

public class BulletType {
    private float _speed;
    private float _widtch;
    private float _height;
    private int _damage;
    private String _texture;


    public BulletType(float speed, float width, float height, int damage, String texture) {
        _speed = speed;
        _widtch = width;
        _height = height;
        _damage = damage;
        _texture = texture;
    }

    public float getSpeed() {
        return _speed;
    }

    public int getDamage() {
        return _damage;
    }

    public String getTexture() {
        return _texture;
    }

    public float getWidtch() {
        return _widtch;
    }

    public float getHeight() {
        return _height;
    }
}
