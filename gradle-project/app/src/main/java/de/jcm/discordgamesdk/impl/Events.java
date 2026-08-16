package de.jcm.discordgamesdk.impl;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.events.ActivityJoinEvent;
import de.jcm.discordgamesdk.impl.events.ActivityJoinRequestEvent;
import de.jcm.discordgamesdk.impl.events.CurrentUserUpdateEvent;
import de.jcm.discordgamesdk.impl.events.OverlayUpdateEvent;
import de.jcm.discordgamesdk.impl.events.ReadyEvent;
import de.jcm.discordgamesdk.impl.events.RelationshipUpdateEvent;
import de.jcm.discordgamesdk.impl.events.VoiceSettingsUpdate2Event;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/Events.class */
public class Events {
    private final Core.CorePrivate core;
    private final Map<Command.Event, EventHandler<?>> handlers = new HashMap();

    public Events(Core.CorePrivate core) {
        this.core = core;
        registerEvents();
    }

    private void registerEvents() {
        this.handlers.put(Command.Event.READY, new ReadyEvent.Handler(this.core));
        this.handlers.put(Command.Event.ACTIVITY_JOIN, new ActivityJoinEvent.Handler(this.core));
        this.handlers.put(Command.Event.ACTIVITY_JOIN_REQUEST, new ActivityJoinRequestEvent.Handler(this.core));
        this.handlers.put(Command.Event.CURRENT_USER_UPDATE, new CurrentUserUpdateEvent.Handler(this.core));
        this.handlers.put(Command.Event.OVERLAY_UPDATE, new OverlayUpdateEvent.Handler(this.core));
        this.handlers.put(Command.Event.RELATIONSHIP_UPDATE, new RelationshipUpdateEvent.Handler(this.core));
        this.handlers.put(Command.Event.VOICE_SETTINGS_UPDATE_2, new VoiceSettingsUpdate2Event.Handler(this.core));
    }

    public EventHandler<?> forEvent(Command.Event e) {
        return this.handlers.get(e);
    }

    public <T> void register(Command.Event event, final Class<T> cls, final Consumer<T> consumer) {
        this.handlers.put(event, (EventHandler<?>) new EventHandler<T>(this.core) { // from class: de.jcm.discordgamesdk.impl.Events.1
            @Override // de.jcm.discordgamesdk.impl.EventHandler
            public void handle(Command command, T t) {
                consumer.accept(t);
            }

            @Override // de.jcm.discordgamesdk.impl.EventHandler
            public Class<?> getDataClass() {
                return cls;
            }
        });
    }

    public Set<Map.Entry<Command.Event, EventHandler<?>>> getEventTypes() {
        return this.handlers.entrySet();
    }
}
