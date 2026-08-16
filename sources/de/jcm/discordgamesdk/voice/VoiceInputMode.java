package de.jcm.discordgamesdk.voice;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/voice/VoiceInputMode.class */
public class VoiceInputMode {
    private InputModeType type;
    private String shortcut;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/voice/VoiceInputMode$InputModeType.class */
    public enum InputModeType {
        VOICE_ACTIVITY,
        PUSH_TO_TALK;

        private static final int OFFSET = 0;

        private int nativeValue() {
            return ordinal() + 0;
        }

        private static InputModeType javaValue(int nativeValue) {
            return values()[nativeValue - 0];
        }
    }

    VoiceInputMode(int type, String shortcut) {
        this(InputModeType.javaValue(type), shortcut);
    }

    public VoiceInputMode(InputModeType type, String shortcut) {
        this.type = type;
        this.shortcut = shortcut;
    }

    public InputModeType getType() {
        return this.type;
    }

    public void setType(InputModeType type) {
        this.type = type;
    }

    public String getShortcut() {
        return this.shortcut;
    }

    public void setShortcut(String shortcut) {
        if (shortcut.getBytes(StandardCharsets.UTF_8).length >= 256) {
            throw new IllegalArgumentException("max shortcut length is 255");
        }
        this.shortcut = shortcut;
    }

    public String toString() {
        return "VoiceInputMode{type=" + this.type + ", shortcut='" + this.shortcut + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VoiceInputMode that = (VoiceInputMode) o;
        return this.type == that.type && Objects.equals(this.shortcut, that.shortcut);
    }

    public int hashCode() {
        return Objects.hash(this.type, this.shortcut);
    }

    int getNativeType() {
        return getType().nativeValue();
    }
}
