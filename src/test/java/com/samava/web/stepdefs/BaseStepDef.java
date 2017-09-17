package com.samava.web.stepdefs;

import com.samava.web.actor.Actor;
import com.samava.web.util.ContextManager;
import com.samava.web.util.KEYS;

class BaseStepDef {

    Actor kelly;

    BaseStepDef() {
        ContextManager contextManager = ContextManager.getInstance();
        if (contextManager.get(KEYS.ACTOR) == null) {
            kelly = new Actor("Kelly");
            contextManager.addToContext(KEYS.ACTOR, kelly);
        } else {
            kelly = (Actor) contextManager.get(KEYS.ACTOR);
        }
    }
}
