package de.jcm.discordgamesdk.impl.events;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.EventHandler;
import de.jcm.discordgamesdk.voice.VoiceInputMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/VoiceSettingsUpdate2Event.class */
public class VoiceSettingsUpdate2Event {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/VoiceSettingsUpdate2Event$Data.class */
    public static class Data {
        public VoiceInputMode input_mode = new VoiceInputMode(VoiceInputMode.InputModeType.VOICE_ACTIVITY, "");
        public List<String> local_mutes = new ArrayList();
        public Map<String, Integer> local_volumes = new HashMap();
        public boolean self_mute;
        public boolean self_deaf;

        public VoiceInputMode getInputMode() {
            return this.input_mode;
        }

        public List<String> getLocalMutes() {
            return this.local_mutes;
        }

        public Map<String, Integer> getLocalVolumes() {
            return this.local_volumes;
        }

        public boolean isSelfMute() {
            return this.self_mute;
        }

        public boolean isSelfDeaf() {
            return this.self_deaf;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/VoiceSettingsUpdate2Event$Handler.class */
    public static class Handler extends EventHandler<Data> {
        public Handler(Core.CorePrivate core) {
            super(core);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public void handle(Command command, Data data) {
            this.core.voiceData = data;
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Class<?> getDataClass() {
            return Data.class;
        }
    }
}
