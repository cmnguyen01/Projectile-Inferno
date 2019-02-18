package com.droptableteams.game.LibECS.interfaces;

import java.util.HashMap;

/**
 * The interface to be implemented by all concrete EventListeners.
 * <p>
 * EventListeners contain a callback to be processed when triggered by an event.</p>
 *
 * TODO: clarify whether id and type apply to the listener itself, or what it is listening for
 */
public interface IEventListener {
    Integer getId();
    String getType();
    String getTriggerType();
    boolean canHandle(Integer id, String type);
    void handleEvent(HashMap<String, Object> args);
}