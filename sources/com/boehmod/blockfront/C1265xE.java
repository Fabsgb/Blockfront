package com.boehmod.blockfront;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xE.class */
public final class C1265xE {

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final Style f6817h = Style.EMPTY.withItalic(true);

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final Style f6818i = Style.EMPTY.withBold(true);

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final Style f6819j = Style.EMPTY.withBold(true).withItalic(true);

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final Style f6820k = Style.EMPTY.withColor(ChatFormatting.AQUA).withUnderlined(true);

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final Pattern f6821e = Pattern.compile("\\[([^]]+)]\\((https?://[^)\\s]+)\\)");

    private C1265xE() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m7139a(@NotNull String str) {
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
                int iM7141a = m7141a(str, i, length);
                int i2 = iM7141a - i;
                for (int i3 = 3; i3 < i2; i3++) {
                    sb.append('*');
                }
                int iMin = Math.min(i2, 3);
                int iIndexOf = str.indexOf(42, iM7141a);
                if (iIndexOf < 0 || m7142a(str, iM7141a, iIndexOf)) {
                    for (int i4 = 0; i4 < iMin; i4++) {
                        sb.append('*');
                    }
                    i = iM7141a;
                } else {
                    int iMin2 = Math.min(iMin, m7141a(str, iIndexOf, length) - iIndexOf);
                    for (int i5 = iMin2; i5 < iMin; i5++) {
                        sb.append('*');
                    }
                    m7143a(mutableComponentEmpty, sb);
                    mutableComponentEmpty.append(Component.literal(str.substring(iM7141a, iIndexOf)).withStyle(m7144a(iMin2)));
                    i = iIndexOf + iMin2;
                }
            }
        }
        m7143a(mutableComponentEmpty, sb);
        return mutableComponentEmpty;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static MutableComponent m7140b(@NotNull String str) {
        int i;
        if (str.indexOf(91) < 0) {
            return m7139a(str);
        }
        Matcher matcher = f6821e.matcher(str);
        MutableComponent mutableComponentEmpty = Component.empty();
        int iEnd = 0;
        while (true) {
            i = iEnd;
            if (!matcher.find()) {
                break;
            }
            if (matcher.start() > i) {
                mutableComponentEmpty.append(m7139a(str.substring(i, matcher.start())));
            }
            mutableComponentEmpty.append(Component.literal(matcher.group(1)).withStyle(f6820k.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, matcher.group(2)))));
            iEnd = matcher.end();
        }
        if (i == 0) {
            return m7139a(str);
        }
        if (i < str.length()) {
            mutableComponentEmpty.append(m7139a(str.substring(i)));
        }
        return mutableComponentEmpty;
    }

    /* JADX INFO: renamed from: a */
    private static int m7141a(@NotNull String str, int i, int i2) {
        int i3 = i + 1;
        while (i3 < i2 && str.charAt(i3) == '*') {
            i3++;
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7142a(@NotNull String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static void m7143a(@NotNull MutableComponent mutableComponent, @NotNull StringBuilder sb) {
        if (!sb.isEmpty()) {
            mutableComponent.append(Component.literal(sb.toString()));
            sb.setLength(0);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Style m7144a(int i) {
        switch (i) {
            case 1:
                return f6817h;
            case 2:
                return f6818i;
            default:
                return f6819j;
        }
    }
}
