package de.jcm.discordgamesdk.impl.commands;

import de.jcm.discordgamesdk.image.ImageHandle;
import java.util.Base64;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/GetImage.class */
public class GetImage {
    private GetImage() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/GetImage$Args.class */
    public static class Args {
        private final String type;
        private final String id;
        private final String format;
        private final int size;

        public Args(ImageHandle handle) {
            this(handle.getType().name().toLowerCase(), Long.toString(handle.getId()), "png", handle.getSize());
        }

        public Args(String type, String id, String format, int size) {
            this.type = type;
            this.id = id;
            this.format = format;
            this.size = size;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/GetImage$Response.class */
    public static class Response {
        private String data_url;

        public String getDataURL() {
            return this.data_url;
        }

        public byte[] getData() {
            if (!this.data_url.startsWith("data:image/png;base64,")) {
                throw new IllegalArgumentException("not a data url");
            }
            return Base64.getDecoder().decode(this.data_url.substring("data:image/png;base64,".length()));
        }
    }
}
