package com.boehmod.blockfront;

import com.boehmod.bflib.common.util.TimeFormatUtils;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import java.text.NumberFormat;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xp.class */
public final class C0637xp {

    @NotNull
    private static final NumberFormat a = NumberFormat.getInstance(Locale.ROOT);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final Char2ObjectMap<String> f404a = new Char2ObjectOpenHashMap();

    static {
        f404a.put('a', "ᴀ");
        f404a.put('b', "ʙ");
        f404a.put('c', "ᴄ");
        f404a.put('d', "ᴅ");
        f404a.put('e', "ᴇ");
        f404a.put('f', "ꜰ");
        f404a.put('g', "ɢ");
        f404a.put('h', "ʜ");
        f404a.put('i', "ɪ");
        f404a.put('j', "ᴊ");
        f404a.put('k', "ᴋ");
        f404a.put('l', "ʟ");
        f404a.put('m', "ᴍ");
        f404a.put('n', "ɴ");
        f404a.put('o', "ᴏ");
        f404a.put('p', "ᴘ");
        f404a.put('q', "ǫ");
        f404a.put('r', "ʀ");
        f404a.put('s', "s");
        f404a.put('t', "ᴛ");
        f404a.put('u', "ᴜ");
        f404a.put('v', "ᴠ");
        f404a.put('w', "ᴡ");
        f404a.put('x', "x");
        f404a.put('y', "ʏ");
        f404a.put('z', "ᴢ");
        f404a.put('A', "ᴀ");
        f404a.put('B', "ʙ");
        f404a.put('C', "ᴄ");
        f404a.put('D', "ᴅ");
        f404a.put('E', "ᴇ");
        f404a.put('F', "ꜰ");
        f404a.put('G', "ɢ");
        f404a.put('H', "ʜ");
        f404a.put('I', "ɪ");
        f404a.put('J', "ᴊ");
        f404a.put('K', "ᴋ");
        f404a.put('L', "ʟ");
        f404a.put('M', "ᴍ");
        f404a.put('N', "ɴ");
        f404a.put('O', "ᴏ");
        f404a.put('P', "ᴘ");
        f404a.put('Q', "ǫ");
        f404a.put('R', "ʀ");
        f404a.put('S', "s");
        f404a.put('T', "ᴛ");
        f404a.put('U', "ᴜ");
        f404a.put('V', "ᴠ");
        f404a.put('W', "ᴡ");
        f404a.put('X', "x");
        f404a.put('Y', "ʏ");
        f404a.put('Z', "ᴢ");
        f404a.put(' ', " ");
    }

    @NotNull
    public static String a(long j) {
        return a.format(j);
    }

    @NotNull
    public static String d(float f) {
        return ((double) f) == Math.rint((double) f) ? String.valueOf((int) f) : String.format(Locale.ROOT, "%.2f", Float.valueOf(f));
    }

    @NotNull
    public static String a(@NotNull String str, int i) {
        return a(str, 0, i);
    }

    @NotNull
    public static String a(@NotNull String str, int i, int i2) {
        int length = str.length();
        if (length <= i2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i2);
        if (i > length) {
            sb.append("...");
        } else if (length - i < i2 - 3) {
            sb.append((CharSequence) str, length - (i2 - 3), length);
        } else if (i - 1 < 3) {
            sb.append((CharSequence) str, 0, i2 - 3).append("...");
        } else {
            if (i2 - 3 < 4) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            }
            if (i + (i2 - 3) < length) {
                sb.append("...").append(a(str.substring(i), 0, i2 - 3));
            } else {
                sb.append("...").append(str.substring(length - (i2 - 3)));
            }
        }
        return sb.toString();
    }

    @NotNull
    public static String b(long j) {
        return TimeFormatUtils.formatDurationBreakdown(j);
    }

    @NotNull
    public static String p(@NotNull String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            sb.append((String) f404a.getOrDefault(c, String.valueOf(c)));
        }
        return sb.toString();
    }
}
