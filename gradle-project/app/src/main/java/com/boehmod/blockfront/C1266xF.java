package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.PlainTextContents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xF.class */
public final class C1266xF {

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final Style f6822l = Style.EMPTY.withColor(ColorReferences.COLOR_STOPWATCH);

    private C1266xF() {
    }

    /* JADX INFO: renamed from: c */
    public static boolean m7145c(@NotNull String str, @NotNull String str2) {
        return m7149a(str, str2, 0) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x003a  */
    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m7146a(@NotNull Component component, @NotNull String str) {
        MutableComponent style;
        PlainTextContents contents = component.getContents();
        if (contents instanceof PlainTextContents) {
            PlainTextContents plainTextContents = contents;
            if (m7145c(plainTextContents.text(), str)) {
                style = m7148a(plainTextContents.text(), str).setStyle(component.getStyle());
            } else {
                style = MutableComponent.create(component.getContents()).setStyle(component.getStyle());
            }
        } else {
            style = MutableComponent.create(component.getContents()).setStyle(component.getStyle());
        }
        Iterator it = component.getSiblings().iterator();
        while (it.hasNext()) {
            style.append(m7146a((Component) it.next(), str));
        }
        return style;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m7147a(@NotNull Component component, @NotNull List<String> list) {
        Component componentM7146a = component;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            componentM7146a = m7146a(componentM7146a, it.next());
        }
        return componentM7146a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static MutableComponent m7148a(@NotNull String str, @NotNull String str2) {
        int i;
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = str2.length();
        int i2 = 0;
        while (true) {
            i = i2;
            int iM7149a = m7149a(str, str2, i);
            if (iM7149a < 0) {
                break;
            }
            int i3 = (iM7149a <= i || str.charAt(iM7149a - 1) != '@') ? iM7149a : iM7149a - 1;
            if (i3 > i) {
                mutableComponentEmpty.append(Component.literal(str.substring(i, i3)));
            }
            mutableComponentEmpty.append(Component.literal("@" + str2).withStyle(f6822l));
            i2 = iM7149a + length;
        }
        if (i < str.length()) {
            mutableComponentEmpty.append(Component.literal(str.substring(i)));
        }
        return mutableComponentEmpty;
    }

    /* JADX INFO: renamed from: a */
    private static int m7149a(@NotNull String str, @NotNull String str2, int i) {
        int length = str2.length();
        if (length == 0) {
            return -1;
        }
        int length2 = str.length() - length;
        int iMax = Math.max(i, 0);
        while (iMax <= length2) {
            if (str.regionMatches(true, iMax, str2, 0, length)) {
                boolean z = iMax == 0 || !m7150a(str.charAt(iMax - 1));
                boolean z2 = iMax + length == str.length() || !m7150a(str.charAt(iMax + length));
                if (z && z2) {
                    return iMax;
                }
            }
            iMax++;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7150a(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }
}
