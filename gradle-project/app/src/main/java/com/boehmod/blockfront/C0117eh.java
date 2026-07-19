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

/* JADX INFO: renamed from: com.boehmod.blockfront.eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eh.class */
public final class C0117eh extends AbstractC0116eg {
    private static final char a = 167;
    private final String T;
    private boolean bR = false;

    @Nullable
    private String U;

    public C0117eh(@NotNull String str) {
        this.T = str;
    }

    @NotNull
    public static String b(@NotNull String str) {
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
    public C0117eh a(@Nullable String str) {
        this.U = str;
        return this;
    }

    public void ao() {
        this.bR = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        ObjectList<String> objectListA = iH.a(font, b(this.T), this.a.t() - 15);
        boolean zC = C();
        boolean zD = D();
        int size = objectListA.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf((zC || (zD && this.U != null)) ? ChatFormatting.WHITE : "") + ((String) objectListA.get(i3))), this.hI + 2, this.hJ + 2 + ((this.bR ? 5 : 10) * i3), this.bR ? 0.5f : 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int height() {
        return iH.a(Minecraft.getInstance().font, b(this.T), this.a.t() - 15).size() * (this.bR ? 6 : 12);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
        super.a(minecraft, c0297l, fVVar, i, i2, i3);
        String[] strArrSplit = this.T.split(" ");
        if (this.U != null) {
            if (this.U.startsWith("http://") || this.U.startsWith("https://")) {
                C0080cx.b(minecraft, this.U);
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
                C0080cx.b(minecraft, strSubstring);
                return;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    /* JADX INFO: renamed from: t */
    public int mo265t() {
        return this.a.t();
    }
}
