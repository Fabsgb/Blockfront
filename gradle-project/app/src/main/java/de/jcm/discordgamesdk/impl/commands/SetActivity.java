package de.jcm.discordgamesdk.impl.commands;

import de.jcm.discordgamesdk.activity.Activity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetActivity.class */
public class SetActivity {
    private SetActivity() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetActivity$Args.class */
    public static class Args {
        private int pid;
        private Activity activity;

        public Args(int pid, Activity activity) {
            this.pid = pid;
            this.activity = activity;
        }
    }
}
