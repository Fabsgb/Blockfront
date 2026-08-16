package de.jcm.discordgamesdk.impl;

import de.jcm.discordgamesdk.Core;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/EventHandler.class */
public abstract class EventHandler<Data> {
    protected final Core.CorePrivate core;

    public abstract void handle(Command command, Data data);

    public abstract Class<?> getDataClass();

    protected EventHandler(Core.CorePrivate core) {
        this.core = core;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleObject(Command command, Object obj) {
        handle(command, obj);
    }

    public boolean shouldRegister() {
        return true;
    }

    public Object getRegisterArgs() {
        return null;
    }
}
