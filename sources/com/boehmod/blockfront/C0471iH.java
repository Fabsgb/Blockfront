package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.client.gui.Font;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iH.class */
public final class C0471iH {
    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m2130a(@NotNull List<String> list) {
        return ((String) list.stream().map(str -> {
            return " " + str.trim();
        }).collect(Collectors.joining())).trim();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectList<String> m2131a(@NotNull Font font, @NotNull String str, int i) {
        String str2;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String str3 = "";
        for (String str4 : m2132c(str).split(" ")) {
            if (str4.equals("[br]")) {
                if (font.width(str3) > 0) {
                    objectArrayList.add(str3);
                }
                str2 = "";
            } else if (str4.equals("[nl]") || str4.equals("++")) {
                if (font.width(str3) > 0) {
                    objectArrayList.add(str3);
                }
                objectArrayList.add("");
                str2 = "";
            } else if (font.width(str3) + font.width(str4) <= i) {
                str2 = str3 + str4 + " ";
            } else {
                if (font.width(str3) > 0) {
                    objectArrayList.add(str3);
                }
                str2 = str4 + " ";
            }
            str3 = str2;
        }
        if (font.width(str3) > 0) {
            objectArrayList.add(str3);
        }
        return objectArrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0087 A[PHI: r6
  0x0087: PHI (r6v2 boolean) = (r6v1 boolean), (r6v1 boolean), (r6v3 boolean) binds: [B:9:0x002c, B:11:0x0036, B:20:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    @org.jetbrains.annotations.NotNull
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m2132c(@org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r7 = r0
            r0 = r4
            int r0 = r0.length()
            r8 = r0
        L12:
            r0 = r7
            r1 = r8
            if (r0 >= r1) goto L94
            r0 = r4
            r1 = r7
            char r0 = r0.charAt(r1)
            r9 = r0
            r0 = r6
            if (r0 == 0) goto L28
            r0 = 0
            r6 = r0
            goto L8e
        L28:
            r0 = r9
            r1 = 38
            if (r0 != r1) goto L87
            r0 = r7
            r1 = r4
            int r1 = r1.length()
            r2 = 1
            int r1 = r1 - r2
            if (r0 == r1) goto L87
            r0 = r4
            r1 = r7
            r2 = 1
            int r1 = r1 + r2
            char r0 = r0.charAt(r1)
            r10 = r0
            r0 = 0
            r11 = r0
            net.minecraft.ChatFormatting[] r0 = net.minecraft.ChatFormatting.values()
            r12 = r0
            r0 = r12
            int r0 = r0.length
            r13 = r0
            r0 = 0
            r14 = r0
        L52:
            r0 = r14
            r1 = r13
            if (r0 >= r1) goto L7f
            r0 = r12
            r1 = r14
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            char r0 = r0.getChar()
            r1 = r10
            if (r0 != r1) goto L79
            r0 = r5
            r1 = r15
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = 1
            r6 = r0
            r0 = 1
            r11 = r0
            goto L7f
        L79:
            int r14 = r14 + 1
            goto L52
        L7f:
            r0 = r11
            if (r0 == 0) goto L87
            goto L8e
        L87:
            r0 = r5
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
        L8e:
            int r7 = r7 + 1
            goto L12
        L94:
            r0 = r5
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.C0471iH.m2132c(java.lang.String):java.lang.String");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> m2133a(@NotNull Map<K, V> map) {
        ObjectArrayList objectArrayList = new ObjectArrayList(map.entrySet());
        objectArrayList.sort((entry, entry2) -> {
            return ((Comparable) entry2.getValue()).compareTo(entry.getValue());
        });
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m2134b(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return (String) list.getFirst();
        }
        if (list.size() == 2) {
            return list.get(0) + " and " + list.get(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 2; i++) {
            sb.append(list.get(i)).append(", ");
        }
        sb.append(list.get(list.size() - 2)).append(" and ").append((String) list.getLast());
        return sb.toString();
    }
}
