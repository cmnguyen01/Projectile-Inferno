package com.droptableteams.game.util.types;

import java.util.HashMap;

public class SubtypeManager {
    private HashMap<String, IEntitySubtype> _subtypes;
    private static SubtypeManager _self;

    private SubtypeManager() {
        _subtypes = new HashMap<String, IEntitySubtype>();
    }

    public static SubtypeManager getInstance() {
        if(null == _self) {
            _self = new SubtypeManager();
        }
        return _self;
    }

    public void addSubtype(IEntitySubtype subtype) {
        _subtypes.put(subtype.getSubtype(), subtype);
    }

    public IEntitySubtype getSubtype(String subtype) {
        return _subtypes.get(subtype);
    }
}
