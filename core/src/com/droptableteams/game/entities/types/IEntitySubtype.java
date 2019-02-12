package com.droptableteams.game.entities.types;

/**
 * immutable data that will always be the same for all entities
 * of the same type and subtype is stored in an IEntitySubtype
 * class.
 *
 * These classes will be then serialized and deserialized
 * in the scripting system.
 */
public interface IEntitySubtype {
    public String getEntityType();
    public String getSubtype();
}
