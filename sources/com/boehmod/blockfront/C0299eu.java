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

/* JADX INFO: renamed from: com.boehmod.blockfront.eu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eu.class */
public final class C0299eu extends AbstractC0298et {

    /* JADX INFO: renamed from: a */
    private static final char f2343a = 167;

    /* JADX INFO: renamed from: aa */
    private final String f2344aa;

    /* JADX INFO: renamed from: bV */
    private boolean f2345bV = false;

    /* JADX INFO: renamed from: ab */
    @Nullable
    private String f2346ab;

    public C0299eu(@NotNull String str) {
        this.f2344aa = str;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m1619b(@NotNull String str) {
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
    public C0299eu m1620a(@Nullable String str) {
        this.f2346ab = str;
        return this;
    }

    /* JADX INFO: renamed from: at */
    public void m1621at() {
        this.f2345bV = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        ObjectList<String> objectListM2458a = C0544ja.m2458a(font, m1619b(this.f2344aa), this.f2338a.m374x() - 15);
        boolean zD = m1614D();
        boolean zE = m1615E();
        int size = objectListM2458a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0129bt.m487a(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf((zD || (zE && this.f2346ab != null)) ? ChatFormatting.WHITE : "") + ((String) objectListM2458a.get(i3))), this.f2339iY + 2, this.f2340iZ + 2 + ((this.f2345bV ? 5 : 10) * i3), this.f2345bV ? 0.5f : 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return C0544ja.m2458a(Minecraft.getInstance().font, m1619b(this.f2344aa), this.f2338a.m374x() - 15).size() * (this.f2345bV ? 6 : 12);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        super.mo871a(minecraft, c0623l, c0396gl, i, i2, i3);
        String[] strArrSplit = this.f2344aa.split(" ");
        if (this.f2346ab != null) {
            if (this.f2346ab.startsWith("http://") || this.f2346ab.startsWith("https://")) {
                C0143cG.m784b(minecraft, this.f2346ab);
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
                C0143cG.m784b(minecraft, strSubstring);
                return;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x();
    }
}
