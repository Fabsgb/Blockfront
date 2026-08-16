package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ij */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ij.class */
public class C0500ij extends C0494id {

    /* JADX INFO: renamed from: hT */
    @NotNull
    private static final Component f3091hT = Component.translatable("bf.menu.button.settings.prompt");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0225dZ.a[] f3092a;

    /* JADX INFO: renamed from: ax */
    @NotNull
    private final String f3093ax;

    /* JADX INFO: renamed from: q */
    @NotNull
    private String f3094q;

    public C0500ij(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull C0497ig c0497ig) {
        this(str, str2, str3, c0497ig, AbstractC0225dZ.a.COMMON);
    }

    public C0500ij(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull C0497ig c0497ig, @NotNull AbstractC0225dZ.a... aVarArr) {
        super(str, str2, c0497ig, false);
        this.f3092a = aVarArr;
        this.f3093ax = str3;
        this.f3094q = str3;
    }

    /* JADX INFO: renamed from: g */
    public void m2246g(@NotNull String str) {
        this.f3094q = str;
        C0495ie.f3075cR = true;
        this.f3009dh = 1.0f;
    }

    /* JADX INFO: renamed from: u */
    public String m2247u() {
        return this.f3094q;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2222a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            minecraft.setScreen(new C0224dY(screen, this).m1330a(this.f3092a).m1324a(f3091hT));
        } else if (i == 1) {
            m2246g(this.f3093ax);
        }
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2020a(@NotNull JsonObject jsonObject) {
        this.f3094q = jsonObject.has(getKey()) ? jsonObject.get(getKey()).getAsString() : this.f3093ax;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: b */
    public void mo2021b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), this.f3094q);
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2017a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        int i7 = ColorReferences.COLOR_WHITE_SOLID;
        C0129bt.m517a(guiGraphics, i, i2, i3, i4, i7, C1270xJ.m7170f(this.f3009dh, this.f3010di, f2));
        C0129bt.m515a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        String str = String.format("'%s'", this.f3094q);
        C0129bt.m470a(font, guiGraphics, (Component) Component.literal(str), i5 - font.width(str), i6);
    }

    @Override // com.boehmod.blockfront.C0494id
    public int getColor() {
        return ChatFormatting.GRAY.getColor().intValue();
    }
}
