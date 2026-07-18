package com.boehmod.blockfront;

import com.boehmod.bflib.common.util.TimeFormatUtils;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import java.text.NumberFormat;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xp.class */
public final class C1293xp {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final NumberFormat f8643a = NumberFormat.getInstance(Locale.ROOT);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Char2ObjectMap<String> f8644a = new Char2ObjectOpenHashMap();

    static {
        f8644a.put('a', "ᴀ");
        f8644a.put('b', "ʙ");
        f8644a.put('c', "ᴄ");
        f8644a.put('d', "ᴅ");
        f8644a.put('e', "ᴇ");
        f8644a.put('f', "ꜰ");
        f8644a.put('g', "ɢ");
        f8644a.put('h', "ʜ");
        f8644a.put('i', "ɪ");
        f8644a.put('j', "ᴊ");
        f8644a.put('k', "ᴋ");
        f8644a.put('l', "ʟ");
        f8644a.put('m', "ᴍ");
        f8644a.put('n', "ɴ");
        f8644a.put('o', "ᴏ");
        f8644a.put('p', "ᴘ");
        f8644a.put('q', "ǫ");
        f8644a.put('r', "ʀ");
        f8644a.put('s', "s");
        f8644a.put('t', "ᴛ");
        f8644a.put('u', "ᴜ");
        f8644a.put('v', "ᴠ");
        f8644a.put('w', "ᴡ");
        f8644a.put('x', "x");
        f8644a.put('y', "ʏ");
        f8644a.put('z', "ᴢ");
        f8644a.put('A', "ᴀ");
        f8644a.put('B', "ʙ");
        f8644a.put('C', "ᴄ");
        f8644a.put('D', "ᴅ");
        f8644a.put('E', "ᴇ");
        f8644a.put('F', "ꜰ");
        f8644a.put('G', "ɢ");
        f8644a.put('H', "ʜ");
        f8644a.put('I', "ɪ");
        f8644a.put('J', "ᴊ");
        f8644a.put('K', "ᴋ");
        f8644a.put('L', "ʟ");
        f8644a.put('M', "ᴍ");
        f8644a.put('N', "ɴ");
        f8644a.put('O', "ᴏ");
        f8644a.put('P', "ᴘ");
        f8644a.put('Q', "ǫ");
        f8644a.put('R', "ʀ");
        f8644a.put('S', "s");
        f8644a.put('T', "ᴛ");
        f8644a.put('U', "ᴜ");
        f8644a.put('V', "ᴠ");
        f8644a.put('W', "ᴡ");
        f8644a.put('X', "x");
        f8644a.put('Y', "ʏ");
        f8644a.put('Z', "ᴢ");
        f8644a.put(' ', " ");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m7912a(long j) {
        return f8643a.format(j);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public static String m7913d(float f) {
        return ((double) f) == Math.rint((double) f) ? String.valueOf((int) f) : String.format(Locale.ROOT, "%.2f", Float.valueOf(f));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m7914a(@NotNull String str, int i) {
        return m7915a(str, 0, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m7915a(@NotNull String str, int i, int i2) {
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
                sb.append("...").append(m7915a(str.substring(i), 0, i2 - 3));
            } else {
                sb.append("...").append(str.substring(length - (i2 - 3)));
            }
        }
        return sb.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m7916b(long j) {
        return TimeFormatUtils.formatDurationBreakdown(j);
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public static String m7917p(@NotNull String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            sb.append((String) f8644a.getOrDefault(c, String.valueOf(c)));
        }
        return sb.toString();
    }
}
