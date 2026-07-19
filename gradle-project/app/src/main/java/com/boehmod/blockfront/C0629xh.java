package com.boehmod.blockfront;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xh.class */
public final class C0629xh {

    @NotNull
    private static final Style h = Style.EMPTY.withItalic(true);

    @NotNull
    private static final Style i = Style.EMPTY.withBold(true);

    @NotNull
    private static final Style j = Style.EMPTY.withBold(true).withItalic(true);

    private C0629xh() {
    }

    @NotNull
    public static MutableComponent a(@NotNull String str) {
        int length = str.length();
        if (str.indexOf(42) < 0) {
            return Component.literal(str);
        }
        MutableComponent mutableComponentEmpty = Component.empty();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '*') {
                sb.append(cCharAt);
                i2++;
            } else {
                int iA = a(str, i2, length);
                int i3 = iA - i2;
                for (int i4 = 3; i4 < i3; i4++) {
                    sb.append('*');
                }
                int iMin = Math.min(i3, 3);
                int iIndexOf = str.indexOf(42, iA);
                if (iIndexOf < 0 || m1686a(str, iA, iIndexOf)) {
                    for (int i5 = 0; i5 < iMin; i5++) {
                        sb.append('*');
                    }
                    i2 = iA;
                } else {
                    int iMin2 = Math.min(iMin, a(str, iIndexOf, length) - iIndexOf);
                    for (int i6 = iMin2; i6 < iMin; i6++) {
                        sb.append('*');
                    }
                    a(mutableComponentEmpty, sb);
                    mutableComponentEmpty.append(Component.literal(str.substring(iA, iIndexOf)).withStyle(a(iMin2)));
                    i2 = iIndexOf + iMin2;
                }
            }
        }
        a(mutableComponentEmpty, sb);
        return mutableComponentEmpty;
    }

    private static int a(@NotNull String str, int i2, int i3) {
        int i4 = i2 + 1;
        while (i4 < i3 && str.charAt(i4) == '*') {
            i4++;
        }
        return i4;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m1686a(@NotNull String str, int i2, int i3) {
        for (int i4 = i2; i4 < i3; i4++) {
            if (!Character.isWhitespace(str.charAt(i4))) {
                return false;
            }
        }
        return true;
    }

    private static void a(@NotNull MutableComponent mutableComponent, @NotNull StringBuilder sb) {
        if (!sb.isEmpty()) {
            mutableComponent.append(Component.literal(sb.toString()));
            sb.setLength(0);
        }
    }

    @NotNull
    private static Style a(int i2) {
        switch (i2) {
            case 1:
                return h;
            case 2:
                return i;
            default:
                return j;
        }
    }
}
