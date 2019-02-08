package com.droptableteams.game.entities.types;

public class BulletType {
    private float _speed;
    private int _damage;
    private String _texture;

    // TODO: add width/height

    public BulletType(float speed, int damage, String texture) {
        _speed = speed;
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
}
