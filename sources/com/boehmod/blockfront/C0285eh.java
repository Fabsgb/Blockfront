package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eh.class */
public final class C0285eh extends AbstractC0284eg {

    /* JADX INFO: renamed from: a */
    private static final char f2170a = 167;

    /* JADX INFO: renamed from: T */
    private final String f2171T;

    /* JADX INFO: renamed from: bR */
    private boolean f2172bR = false;

    /* JADX INFO: renamed from: U */
    @Nullable
    private String f2173U;

    public C0285eh(@NotNull String str) {
        this.f2171T = str;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m1503b(@NotNull String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length - 1;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(charArray[i + 1]) > -1) {
                charArray[i] = 167;
                charArray[i + 1] = Character.toLowerCase(charArray[i + 1]);
            }
        }
        return new String(charArray);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0285eh m1504a(@Nullable String str) {
        this.f2173U = str;
        return this;
    }

    /* JADX INFO: renamed from: ao */
    public void m1505ao() {
        this.f2172bR = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        ObjectList<String> objectListM2131a = C0471iH.m2131a(font, m1503b(this.f2171T), this.f2165a.m699t() - 15);
        boolean zC = m1498C();
        boolean zD = m1499D();
        int size = objectListM2131a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0119bk.m387a(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf((zC || (zD && this.f2173U != null)) ? ChatFormatting.WHITE : "") + ((String) objectListM2131a.get(i3))), this.f2166hI + 2, this.f2167hJ + 2 + ((this.f2172bR ? 5 : 10) * i3), this.f2172bR ? 0.5f : 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return C0471iH.m2131a(Minecraft.getInstance().font, m1503b(this.f2171T), this.f2165a.m699t() - 15).size() * (this.f2172bR ? 6 : 12);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
        super.mo817a(minecraft, c0622l, c0326fV, i, i2, i3);
        String[] strArrSplit = this.f2171T.split(" ");
        if (this.f2173U != null) {
            if (this.f2173U.startsWith("http://") || this.f2173U.startsWith("https://")) {
                C0195cx.m1186b(minecraft, this.f2173U);
                return;
            }
            return;
        }
        int length = strArrSplit.length;
        for (int i4 = 0; i4 < length; i4++) {
            String strSubstring = strArrSplit[i4];
            if (strSubstring.length() > 2 && strSubstring.startsWith("&")) {
                strSubstring = strSubstring.substring(2);
            }
            if (strSubstring.startsWith("http://") || strSubstring.startsWith("https://")) {
                C0195cx.m1186b(minecraft, strSubstring);
                return;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: t */
    public int mo812t() {
        return this.f2165a.m699t();
    }
}
