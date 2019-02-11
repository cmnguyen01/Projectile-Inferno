package com.droptableteams.game.entities.types;

public class BulletType implements IEntitySubtype {
    private float _speed;
    private float _widtch;
    private float _height;
    private int _damage;
    private String _texture;
    private String _subtype;
    private String _entityType;


    public BulletType(String entityType, String subtype, float speed, float width, float height, int damage, String texture) {
        _speed = speed;
        _widtch = width;
        _height = height;
        _damage = damage;
        _texture = texture;
        _entityType = entityType;
        _subtype = subtype;
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

    @Override
    public String getSubtype() {
        return _subtype;
    }

    @Override
    public String getEntityType() {
        return _entityType;
    }
}
