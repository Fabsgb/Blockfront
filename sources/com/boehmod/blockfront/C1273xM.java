package com.boehmod.blockfront;

import com.boehmod.bflib.common.util.TimeFormatUtils;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import java.text.NumberFormat;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xM.class */
public final class C1273xM {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final NumberFormat f6840a = NumberFormat.getInstance(Locale.ROOT);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Char2ObjectMap<String> f6841a = new Char2ObjectOpenHashMap();

    static {
        f6841a.put('a', "ᴀ");
        f6841a.put('b', "ʙ");
        f6841a.put('c', "ᴄ");
        f6841a.put('d', "ᴅ");
        f6841a.put('e', "ᴇ");
        f6841a.put('f', "ꜰ");
        f6841a.put('g', "ɢ");
        f6841a.put('h', "ʜ");
        f6841a.put('i', "ɪ");
        f6841a.put('j', "ᴊ");
        f6841a.put('k', "ᴋ");
        f6841a.put('l', "ʟ");
        f6841a.put('m', "ᴍ");
        f6841a.put('n', "ɴ");
        f6841a.put('o', "ᴏ");
        f6841a.put('p', "ᴘ");
        f6841a.put('q', "ǫ");
        f6841a.put('r', "ʀ");
        f6841a.put('s', "s");
        f6841a.put('t', "ᴛ");
        f6841a.put('u', "ᴜ");
        f6841a.put('v', "ᴠ");
        f6841a.put('w', "ᴡ");
        f6841a.put('x', "x");
        f6841a.put('y', "ʏ");
        f6841a.put('z', "ᴢ");
        f6841a.put('A', "ᴀ");
        f6841a.put('B', "ʙ");
        f6841a.put('C', "ᴄ");
        f6841a.put('D', "ᴅ");
        f6841a.put('E', "ᴇ");
        f6841a.put('F', "ꜰ");
        f6841a.put('G', "ɢ");
        f6841a.put('H', "ʜ");
        f6841a.put('I', "ɪ");
        f6841a.put('J', "ᴊ");
        f6841a.put('K', "ᴋ");
        f6841a.put('L', "ʟ");
        f6841a.put('M', "ᴍ");
        f6841a.put('N', "ɴ");
        f6841a.put('O', "ᴏ");
        f6841a.put('P', "ᴘ");
        f6841a.put('Q', "ǫ");
        f6841a.put('R', "ʀ");
        f6841a.put('S', "s");
        f6841a.put('T', "ᴛ");
        f6841a.put('U', "ᴜ");
        f6841a.put('V', "ᴠ");
        f6841a.put('W', "ᴡ");
        f6841a.put('X', "x");
        f6841a.put('Y', "ʏ");
        f6841a.put('Z', "ᴢ");
        f6841a.put(' ', " ");
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m7239b(long j) {
        return f6840a.format(j);
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public static String m7240e(float f) {
        return ((double) f) == Math.rint((double) f) ? String.valueOf((int) f) : String.format(Locale.ROOT, "%.2f", Float.valueOf(f));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m7241a(@NotNull String str, int i) {
        return m7242a(str, 0, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m7242a(@NotNull String str, int i, int i2) {
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
                sb.append("...").append(m7242a(str.substring(i), 0, i2 - 3));
            } else {
                sb.append("...").append(str.substring(length - (i2 - 3)));
            }
        }
        return sb.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m7243c(long j) {
        return TimeFormatUtils.formatDurationBreakdown(j);
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public static String m7244p(@NotNull String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            sb.append((String) f6841a.getOrDefault(c, String.valueOf(c)));
        }
        return sb.toString();
    }
}
