package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ja */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ja.class */
public final class C0544ja {
    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m2457a(@NotNull List<String> list) {
        return ((String) list.stream().map(str -> {
            return " " + str.trim();
        }).collect(Collectors.joining())).trim();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectList<String> m2458a(@NotNull Font font, @NotNull String str, int i) {
        String str2;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String str3 = "";
        for (String str4 : m2459c(str).split(" ")) {
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

    /* JADX WARN: Code duplicated, block: B:22:0x0087 A[PHI: r6
  0x0087: PHI (r6v2 boolean) = (r6v1 boolean), (r6v1 boolean), (r6v3 boolean) binds: [B:9:0x002c, B:11:0x0036, B:20:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m2459c(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (z) {
                z = false;
            } else if (cCharAt == '&' && i != str.length() - 1) {
                char cCharAt2 = str.charAt(i + 1);
                boolean z2 = false;
                for (ChatFormatting chatFormatting : ChatFormatting.values()) {
                    if (chatFormatting.getChar() == cCharAt2) {
                        sb.append(chatFormatting);
                        z = true;
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> m2460a(@NotNull Map<K, V> map) {
        ObjectArrayList objectArrayList = new ObjectArrayList(map.entrySet());
        objectArrayList.sort((entry, entry2) -> {
            return ((Comparable) entry2.getValue()).compareTo(entry.getValue());
        });
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m2461b(List<String> list) {
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
