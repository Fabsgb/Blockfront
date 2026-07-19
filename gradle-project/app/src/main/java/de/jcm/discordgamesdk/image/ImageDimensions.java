package de.jcm.discordgamesdk.image;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/image/ImageDimensions.class */
public class ImageDimensions {
    private final int width;
    private final int height;

    public ImageDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        return "ImageDimensions{width=" + this.width + ", height=" + this.height + "}";
    }
}
