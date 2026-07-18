package foundry.veil.api.client.color;

import org.jetbrains.annotations.Contract;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/color/Colorc.class */
public interface Colorc {
    @Contract(pure = true)
    float red();

    @Contract(pure = true)
    float green();

    @Contract(pure = true)
    float blue();

    @Contract(pure = true)
    float alpha();

    @Contract(pure = true)
    default int redInt() {
        return (int) (red() * 255.0f);
    }

    @Contract(pure = true)
    default int greenInt() {
        return (int) (green() * 255.0f);
    }

    @Contract(pure = true)
    default int blueInt() {
        return (int) (blue() * 255.0f);
    }

    @Contract(pure = true)
    default int alphaInt() {
        return (int) (alpha() * 255.0f);
    }

    @Contract(pure = true)
    default int rgb() {
        return ((((int) (red() * 255.0f)) & 255) << 16) | ((((int) (green() * 255.0f)) & 255) << 8) | (((int) (blue() * 255.0f)) & 255);
    }

    @Contract(pure = true)
    default int argb() {
        return ((((int) (alpha() * 255.0f)) & 255) << 24) | ((((int) (red() * 255.0f)) & 255) << 16) | ((((int) (green() * 255.0f)) & 255) << 8) | (((int) (blue() * 255.0f)) & 255);
    }

    @Contract(pure = true)
    default float minComponent() {
        return Math.min(red(), Math.min(green(), blue()));
    }

    @Contract(pure = true)
    default float maxComponent() {
        return Math.max(red(), Math.max(green(), blue()));
    }

    @Contract(pure = true)
    default float hue() {
        float hue;
        float min = minComponent();
        float max = maxComponent();
        if (red() == max) {
            hue = (60.0f * (green() - blue())) / (max - min);
        } else if (green() == max) {
            hue = 60.0f * (2.0f + ((blue() - red()) / (max - min)));
        } else {
            hue = 60.0f * (4.0f + ((red() - green()) / (max - min)));
        }
        float hue2 = hue % 360.0f;
        if (hue2 < 0.0f) {
            hue2 += 360.0f;
        }
        return hue2;
    }

    @Contract(pure = true)
    default float saturation() {
        float min = minComponent();
        float max = maxComponent();
        if (min == max) {
            return 0.0f;
        }
        float luminance = luminance();
        if (luminance <= 0.5d) {
            return (max - min) / (max + min);
        }
        return (max - min) / ((2.0f - max) - min);
    }

    @Contract(pure = true)
    default float luminance() {
        return (minComponent() + maxComponent()) / 2.0f;
    }

    @Contract(pure = true)
    default Color lerp(Colorc other, float delta, Color store) {
        return store.set(red() + ((other.red() - red()) * delta), green() + ((other.green() - green()) * delta), blue() + ((other.blue() - blue()) * delta), alpha() + ((other.alpha() - alpha()) * delta));
    }

    @Contract(pure = true)
    default Color mix(Colorc color, float amount, Color store) {
        return store.set((red() * (1.0f - amount)) + (color.red() * amount), (green() * (1.0f - amount)) + (color.green() * amount), (blue() * (1.0f - amount)) + (color.blue() * amount), (alpha() * (1.0f - amount)) + (color.alpha() * amount));
    }

    @Contract(pure = true)
    default Color lighten(float amount, Color store) {
        return mix(Color.WHITE, amount, store);
    }

    @Contract(pure = true)
    default Color darken(float amount, Color store) {
        return mix(Color.BLACK, amount, store);
    }

    @Contract(pure = true)
    default Color invert(Color store) {
        float max = Math.max(1.0f, maxComponent());
        return store.set(max - red(), max - green(), max - blue());
    }

    @Contract(pure = true)
    default Color grayscale(Color store) {
        return setHSV(0.0f, 1.0f, luminance(), store);
    }

    @Contract(pure = true)
    default Color sepia(Color store) {
        float red = red();
        float green = green();
        float blue = blue();
        return store.set((red * 0.393f) + (green * 0.769f) + (blue * 0.189f), (red * 0.349f) + (green * 0.686f) + (blue * 0.168f), (red * 0.272f) + (green * 0.534f) + (blue * 0.131f));
    }

    @Contract(pure = true)
    default Color setHue(float hue, Color store) {
        return setHSV(hue, saturation(), luminance(), store);
    }

    @Contract(pure = true)
    default Color setSaturation(float saturation, Color store) {
        return setHSV(hue(), saturation, luminance(), store);
    }

    @Contract(pure = true)
    default Color setLuminance(float luminance, Color store) {
        return setHSV(hue(), saturation(), luminance, store);
    }

    @Contract(pure = true)
    default Color setHSV(float hue, float saturation, float luminance, Color store) {
        if (saturation <= 0.0f) {
            return store.set(luminance, luminance, luminance);
        }
        float hue2 = (hue / 360.0f) % 1.0f;
        if (hue2 < 0.0f) {
            hue2 += 1.0f;
        }
        float saturation2 = Math.min(saturation, 1.0f);
        float luminance2 = luminance < 0.0f ? 0.0f : Math.min(luminance, 1.0f);
        float temp1 = ((double) luminance2) < 0.5d ? luminance2 * (1.0f + saturation2) : (luminance2 + saturation2) - (luminance2 * saturation2);
        float temp2 = (2.0f * luminance2) - temp1;
        float tempR = hue2 + 0.33333334f;
        float tempG = hue2;
        float tempB = hue2 - 0.33333334f;
        if (tempR < 0.0f) {
            tempR += 1.0f;
        } else if (tempR > 1.0f) {
            tempR -= 1.0f;
        }
        if (tempG < 0.0f) {
            tempG += 1.0f;
        } else if (tempG > 1.0f) {
            tempG -= 1.0f;
        }
        if (tempB < 0.0f) {
            tempB += 1.0f;
        } else if (tempB > 1.0f) {
            tempB -= 1.0f;
        }
        if (6.0d * ((double) tempR) < 1.0d) {
            store.red(temp2 + ((temp1 - temp2) * 6.0f * tempR));
        } else if (2.0d * ((double) tempR) < 1.0d) {
            store.red(temp1);
        } else if (3.0d * ((double) tempR) < 2.0d) {
            store.red(temp2 + ((temp1 - temp2) * (0.6666667f - tempR) * 6.0f));
        }
        if (6.0d * ((double) tempG) < 1.0d) {
            store.green(temp2 + ((temp1 - temp2) * 6.0f * tempG));
        } else if (2.0d * ((double) tempG) < 1.0d) {
            store.green(temp1);
        } else if (3.0d * ((double) tempG) < 2.0d) {
            store.green(temp2 + ((temp1 - temp2) * (0.6666667f - tempG) * 6.0f));
        }
        if (6.0d * ((double) tempB) < 1.0d) {
            store.blue(temp2 + ((temp1 - temp2) * 6.0f * tempB));
        } else if (2.0d * ((double) tempB) < 1.0d) {
            store.blue(temp1);
        } else if (3.0d * ((double) tempB) < 2.0d) {
            store.blue(temp2 + ((temp1 - temp2) * (0.6666667f - tempB) * 6.0f));
        }
        return store;
    }
}
