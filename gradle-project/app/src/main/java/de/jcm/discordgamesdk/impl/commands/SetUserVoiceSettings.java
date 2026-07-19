package de.jcm.discordgamesdk.impl.commands;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetUserVoiceSettings.class */
public class SetUserVoiceSettings {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetUserVoiceSettings$Args.class */
    public static class Args {
        public String user_id;

        public Args(String user_id) {
            this.user_id = user_id;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetUserVoiceSettings$Mute.class */
    public static class Mute extends Args {
        public boolean mute;

        public Mute(String user_id, boolean mute) {
            super(user_id);
            this.mute = mute;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetUserVoiceSettings$Volume.class */
    public static class Volume extends Args {
        public int volume;

        public Volume(String user_id, int volume) {
            super(user_id);
            this.volume = volume;
        }
    }
}
