package software.bernie.geckolib.util;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/util/Color.class */
public final class Color extends Record {
    private final int argbInt;
    public static final Color WHITE = new Color(-1);
    public static final Color LIGHT_GRAY = new Color(-4144960);
    public static final Color GRAY = new Color(-8355712);
    public static final Color DARK_GRAY = new Color(-12566464);
    public static final Color BLACK = new Color(-16777216);
    public static final Color RED = new Color(-65536);
    public static final Color PINK = new Color(-20561);
    public static final Color ORANGE = new Color(-14336);
    public static final Color YELLOW = new Color(-256);
    public static final Color GREEN = new Color(-16711936);
    public static final Color MAGENTA = new Color(-65281);
    public static final Color CYAN = new Color(-16711681);
    public static final Color BLUE = new Color(-16776961);

    public Color(int argbInt) {
        this.argbInt = argbInt;
    }

    public int argbInt() {
        return this.argbInt;
    }

    public static Color ofOpaque(int color) {
        return new Color((-16777216) | color);
    }

    public static Color ofRGB(float red, float green, float blue) {
        return ofRGBA(red, green, blue, 1.0f);
    }

    public static Color ofRGB(int r, int g, int b) {
        return ofRGBA(r, g, b, 255);
    }

    public static Color ofRGBA(float r, float g, float b, float a) {
        return ofRGBA((int) (((double) (r * 255.0f)) + 0.5d), (int) ((g * 255.0f) + 0.5f), (int) ((b * 255.0f) + 0.5f), (int) ((a * 255.0f) + 0.5f));
    }

    public static Color ofRGBA(int r, int g, int b, int a) {
        return new Color(((a & 255) << 24) | ((r & 255) << 16) | ((g & 255) << 8) | (b & 255));
    }

    public static Color ofARGB(float a, float r, float g, float b) {
        return ofARGB((int) ((a * 255.0f) + 0.5f), (int) (((double) (r * 255.0f)) + 0.5d), (int) ((g * 255.0f) + 0.5f), (int) ((b * 255.0f) + 0.5f));
    }

    public static Color ofARGB(int a, int r, int g, int b) {
        return new Color(((a & 255) << 24) | ((r & 255) << 16) | ((g & 255) << 8) | (b & 255));
    }

    public static Color ofHSB(float hue, float saturation, float brightness) {
        return ofOpaque(HSBtoARGB(hue, saturation, brightness));
    }

    public static int HSBtoARGB(float hue, float saturation, float brightness) {
        int r = 0;
        int g = 0;
        int b = 0;
        if (saturation == 0.0f) {
            int i = (int) ((brightness * 255.0f) + 0.5f);
            b = i;
            g = i;
            r = i;
        } else {
            float h = (hue - ((float) Math.floor(hue))) * 6.0f;
            float f = h - ((float) Math.floor(h));
            float p = brightness * (1.0f - saturation);
            float q = brightness * (1.0f - (saturation * f));
            float t = brightness * (1.0f - (saturation * (1.0f - f)));
            switch ((int) h) {
                case 0:
                    r = (int) ((brightness * 255.0f) + 0.5f);
                    g = (int) ((t * 255.0f) + 0.5f);
                    b = (int) ((p * 255.0f) + 0.5f);
                    break;
                case 1:
                    r = (int) ((q * 255.0f) + 0.5f);
                    g = (int) ((brightness * 255.0f) + 0.5f);
                    b = (int) ((p * 255.0f) + 0.5f);
                    break;
                case 2:
                    r = (int) ((p * 255.0f) + 0.5f);
                    g = (int) ((brightness * 255.0f) + 0.5f);
                    b = (int) ((t * 255.0f) + 0.5f);
                    break;
                case 3:
                    r = (int) ((p * 255.0f) + 0.5f);
                    g = (int) ((q * 255.0f) + 0.5f);
                    b = (int) ((brightness * 255.0f) + 0.5f);
                    break;
                case 4:
                    r = (int) ((t * 255.0f) + 0.5f);
                    g = (int) ((p * 255.0f) + 0.5f);
                    b = (int) ((brightness * 255.0f) + 0.5f);
                    break;
                case 5:
                    r = (int) ((brightness * 255.0f) + 0.5f);
                    g = (int) ((p * 255.0f) + 0.5f);
                    b = (int) ((q * 255.0f) + 0.5f);
                    break;
            }
        }
        return (-16777216) | (r << 16) | (g << 8) | b;
    }

    public int getColor() {
        return this.argbInt;
    }

    public int getAlpha() {
        return (this.argbInt >> 24) & 255;
    }

    public float getAlphaFloat() {
        return getAlpha() / 255.0f;
    }

    public int getRed() {
        return (this.argbInt >> 16) & 255;
    }

    public float getRedFloat() {
        return getRed() / 255.0f;
    }

    public int getGreen() {
        return (this.argbInt >> 8) & 255;
    }

    public float getGreenFloat() {
        return getGreen() / 255.0f;
    }

    public int getBlue() {
        return this.argbInt & 255;
    }

    public float getBlueFloat() {
        return getBlue() / 255.0f;
    }

    public Color brighter(double factor) {
        int r = getRed();
        int g = getGreen();
        int b = getBlue();
        int i = (int) (1.0d / (1.0d - (1.0d / factor)));
        if (r == 0 && g == 0 && b == 0) {
            return ofRGBA(i, i, i, getAlpha());
        }
        if (r > 0 && r < i) {
            r = i;
        }
        if (g > 0 && g < i) {
            g = i;
        }
        if (b > 0 && b < i) {
            b = i;
        }
        return ofRGBA(Math.min((int) (((double) r) / (1.0d / factor)), 255), Math.min((int) (((double) g) / (1.0d / factor)), 255), Math.min((int) (((double) b) / (1.0d / factor)), 255), getAlpha());
    }

    public Color darker(float factor) {
        return ofRGBA(Math.max((int) (getRed() * (1.0f / factor)), 0), Math.max((int) (getGreen() * (1.0f / factor)), 0), Math.max((int) (getBlue() * (1.0f / factor)), 0), getAlpha());
    }

    @Override // java.lang.Record
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return getClass() == other.getClass() && hashCode() == other.hashCode();
    }

    @Override // java.lang.Record
    public int hashCode() {
        return this.argbInt;
    }

    @Override // java.lang.Record
    public String toString() {
        return String.valueOf(this.argbInt);
    }
}
