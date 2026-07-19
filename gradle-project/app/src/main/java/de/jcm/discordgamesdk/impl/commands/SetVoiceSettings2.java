package de.jcm.discordgamesdk.impl.commands;

import de.jcm.discordgamesdk.voice.VoiceInputMode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetVoiceSettings2.class */
public class SetVoiceSettings2 {
    private SetVoiceSettings2() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetVoiceSettings2$InputMode.class */
    public static class InputMode {
        public VoiceInputMode input_mode;

        public InputMode(VoiceInputMode input_mode) {
            this.input_mode = input_mode;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetVoiceSettings2$SelfMute.class */
    public static class SelfMute {
        public boolean self_mute;

        public SelfMute(boolean self_mute) {
            this.self_mute = self_mute;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/SetVoiceSettings2$SelfDeaf.class */
    public static class SelfDeaf {
        public boolean self_deaf;

        public SelfDeaf(boolean self_deaf) {
            this.self_deaf = self_deaf;
        }
    }
}
