package de.jcm.discordgamesdk.impl.commands;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetOverlayLocked.class */
public class SetOverlayLocked {
    private SetOverlayLocked() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetOverlayLocked$Args.class */
    public static class Args {
        private boolean locked;
        private int pid;

        public Args(boolean locked, int pid) {
            this.locked = locked;
            this.pid = pid;
        }
    }
}
