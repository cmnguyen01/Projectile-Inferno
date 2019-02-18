package com.droptableteams.game.LibECS.interfaces;

import java.util.HashMap;

/**
 * The interface to be implemented by all concrete Events.
 * <p>
 * Events are used to trigger a callback.</p>
 */
public interface IEvent {
    int getId();
    String getType();
    HashMap<String, Object> getArgs(); // TODO: replace with HashMap<String, Object>
}