package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xi.class */
public final class C1286xi {

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final Style f8630k = Style.EMPTY.withColor(ColorReferences.COLOR_STOPWATCH);

    private C1286xi() {
    }

    /* JADX INFO: renamed from: b */
    public static boolean m7821b(@NotNull String str, @NotNull String str2) {
        return m7825a(str, str2, 0) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    @org.jetbrains.annotations.NotNull
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static net.minecraft.network.chat.Component m7822a(@org.jetbrains.annotations.NotNull net.minecraft.network.chat.Component r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r0 = r4
            net.minecraft.network.chat.ComponentContents r0 = r0.getContents()
            r8 = r0
            r0 = r8
            boolean r0 = r0 instanceof net.minecraft.network.chat.contents.PlainTextContents
            if (r0 == 0) goto L3a
            r0 = r8
            net.minecraft.network.chat.contents.PlainTextContents r0 = (net.minecraft.network.chat.contents.PlainTextContents) r0
            r7 = r0
            r0 = r7
            java.lang.String r0 = r0.text()
            r1 = r5
            boolean r0 = m7821b(r0, r1)
            if (r0 == 0) goto L3a
            r0 = r7
            java.lang.String r0 = r0.text()
            r1 = r5
            net.minecraft.network.chat.MutableComponent r0 = m7824a(r0, r1)
            r1 = r4
            net.minecraft.network.chat.Style r1 = r1.getStyle()
            net.minecraft.network.chat.MutableComponent r0 = r0.setStyle(r1)
            r6 = r0
            goto L4d
        L3a:
            r0 = r4
            net.minecraft.network.chat.ComponentContents r0 = r0.getContents()
            net.minecraft.network.chat.MutableComponent r0 = net.minecraft.network.chat.MutableComponent.create(r0)
            r1 = r4
            net.minecraft.network.chat.Style r1 = r1.getStyle()
            net.minecraft.network.chat.MutableComponent r0 = r0.setStyle(r1)
            r6 = r0
        L4d:
            r0 = r4
            java.util.List r0 = r0.getSiblings()
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
        L59:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L7b
            r0 = r7
            java.lang.Object r0 = r0.next()
            net.minecraft.network.chat.Component r0 = (net.minecraft.network.chat.Component) r0
            r8 = r0
            r0 = r6
            r1 = r8
            r2 = r5
            net.minecraft.network.chat.Component r1 = m7822a(r1, r2)
            net.minecraft.network.chat.MutableComponent r0 = r0.append(r1)
            goto L59
        L7b:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.C1286xi.m7822a(net.minecraft.network.chat.Component, java.lang.String):net.minecraft.network.chat.Component");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m7823a(@NotNull Component component, @NotNull List<String> list) {
        Component componentM7822a = component;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            componentM7822a = m7822a(componentM7822a, it.next());
        }
        return componentM7822a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static MutableComponent m7824a(@NotNull String str, @NotNull String str2) {
        int i;
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = str2.length();
        int i2 = 0;
        while (true) {
            i = i2;
            int iM7825a = m7825a(str, str2, i);
            if (iM7825a < 0) {
                break;
            }
            int i3 = (iM7825a <= i || str.charAt(iM7825a - 1) != '@') ? iM7825a : iM7825a - 1;
            if (i3 > i) {
                mutableComponentEmpty.append(Component.literal(str.substring(i, i3)));
            }
            mutableComponentEmpty.append(Component.literal("@" + str2).withStyle(f8630k));
            i2 = iM7825a + length;
        }
        if (i < str.length()) {
            mutableComponentEmpty.append(Component.literal(str.substring(i)));
        }
        return mutableComponentEmpty;
    }

    /* JADX INFO: renamed from: a */
    private static int m7825a(@NotNull String str, @NotNull String str2, int i) {
        int length = str2.length();
        if (length == 0) {
            return -1;
        }
        int length2 = str.length() - length;
        int iMax = Math.max(i, 0);
        while (iMax <= length2) {
            if (str.regionMatches(true, iMax, str2, 0, length)) {
                boolean z = iMax == 0 || !m7826a(str.charAt(iMax - 1));
                boolean z2 = iMax + length == str.length() || !m7826a(str.charAt(iMax + length));
                if (z && z2) {
                    return iMax;
                }
            }
            iMax++;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7826a(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }
}
