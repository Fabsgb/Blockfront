package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xh.class */
public final class C1285xh {

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final Style f8627h = Style.EMPTY.withItalic(true);

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final Style f8628i = Style.EMPTY.withBold(true);

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final Style f8629j = Style.EMPTY.withBold(true).withItalic(true);

    private C1285xh() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m7816a(@NotNull String str) {
        int length = str.length();
        if (str.indexOf(42) < 0) {
            return Component.literal(str);
        }
        MutableComponent mutableComponentEmpty = Component.empty();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '*') {
                sb.append(cCharAt);
                i++;
            } else {
                int iM7817a = m7817a(str, i, length);
                int i2 = iM7817a - i;
                for (int i3 = 3; i3 < i2; i3++) {
                    sb.append('*');
                }
                int iMin = Math.min(i2, 3);
                int iIndexOf = str.indexOf(42, iM7817a);
                if (iIndexOf < 0 || m7818a(str, iM7817a, iIndexOf)) {
                    for (int i4 = 0; i4 < iMin; i4++) {
                        sb.append('*');
                    }
                    i = iM7817a;
                } else {
                    int iMin2 = Math.min(iMin, m7817a(str, iIndexOf, length) - iIndexOf);
                    for (int i5 = iMin2; i5 < iMin; i5++) {
                        sb.append('*');
                    }
                    m7819a(mutableComponentEmpty, sb);
                    mutableComponentEmpty.append(Component.literal(str.substring(iM7817a, iIndexOf)).withStyle(m7820a(iMin2)));
                    i = iIndexOf + iMin2;
                }
            }
        }
        m7819a(mutableComponentEmpty, sb);
        return mutableComponentEmpty;
    }

    /* JADX INFO: renamed from: a */
    private static int m7817a(@NotNull String str, int i, int i2) {
        int i3 = i + 1;
        while (i3 < i2 && str.charAt(i3) == '*') {
            i3++;
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7818a(@NotNull String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static void m7819a(@NotNull MutableComponent mutableComponent, @NotNull StringBuilder sb) {
        if (!sb.isEmpty()) {
            mutableComponent.append(Component.literal(sb.toString()));
            sb.setLength(0);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Style m7820a(int i) {
        switch (i) {
            case 1:
                return f8627h;
            case 2:
                return f8628i;
            default:
                return f8629j;
        }
    }
}
