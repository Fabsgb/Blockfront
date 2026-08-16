package de.jcm.discordgamesdk.impl.commands;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/ActivityInviteUser.class */
public class ActivityInviteUser {
    private ActivityInviteUser() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/ActivityInviteUser$Args.class */
    public static class Args {
        private final int type;
        private final String user_id;
        private final String content;
        private final int pid;

        public Args(int type, String user_id, String content, int pid) {
            this.type = type;
            this.user_id = user_id;
            this.content = content;
            this.pid = pid;
        }
    }
}
