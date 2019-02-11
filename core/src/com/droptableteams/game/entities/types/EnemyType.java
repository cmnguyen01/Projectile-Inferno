package com.droptableteams.game.entities.types;

import com.droptableteams.game.util.FirePatternData;

public class EnemyType implements IEntitySubtype {
    private String _entityType;
    private String _subtype;
    private FirePatternData _firePattern;
    private float _width;
    private float _height;
    private float _speed;

    public EnemyType(String entityType, String subtype, FirePatternData firePattern, float width, float height, float speed) {
        _entityType = entityType;
        _subtype = subtype;
        _firePattern = firePattern;
        _width = width;
        _height = height;
        _speed = speed;
    }

    @Override
    public String getEntityType() {
        return _entityType;
    }

    @Override
    public String getSubtype() {
        return _subtype;
    }
}
