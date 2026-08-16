package de.jcm.discordgamesdk.impl.events;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.EventHandler;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/OverlayUpdateEvent.class */
public class OverlayUpdateEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/OverlayUpdateEvent$Data.class */
    public static class Data {
        private boolean enabled;
        private boolean locked;

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isLocked() {
            return this.locked;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/OverlayUpdateEvent$Handler.class */
    public static class Handler extends EventHandler<Data> {
        public Handler(Core.CorePrivate core) {
            super(core);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public void handle(Command command, Data data) {
            this.core.overlayData = data;
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Class<?> getDataClass() {
            return Data.class;
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/OverlayUpdateEvent$Handler$Args.class */
        private static class Args {
            private final int pid;

            public Args(int pid) {
                this.pid = pid;
            }
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Object getRegisterArgs() {
            return new Args(this.core.pid);
        }
    }
}
