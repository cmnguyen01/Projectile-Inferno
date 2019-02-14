package com.droptableteams.game.LibECS.interfaces;

import java.util.ArrayList;

/**
 * An builder interface which facilitates the creation of entities,
 * and their related components and systems.
 * <p>
 * TODO: This builder can be passed to ECSEngine to add the full set of
 * entity, components, and systems to their respective managers.</p>
 */
public interface IEntityBuilder {
    public IEntity buildEntity();
    public ArrayList<IComponent> buildComponentList();
    public ArrayList<ISystem> buildSystemList();
}
