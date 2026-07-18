package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.TextColor;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sQ.class */
public final class C1010sQ {

    /* JADX INFO: renamed from: re */
    public static final int f5285re = 12;

    /* JADX INFO: renamed from: jv */
    @NotNull
    private final Component f5286jv;

    /* JADX INFO: renamed from: Z */
    private int f5287Z;

    /* JADX INFO: renamed from: aD */
    private float f5288aD;

    /* JADX INFO: renamed from: aE */
    private float f5289aE;

    public C1010sQ(@NotNull Component component, int i) {
        this.f5289aE = 0.0f;
        this.f5286jv = component;
        this.f5287Z = i;
    }

    public C1010sQ(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: f */
    public void m5474f(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f5286jv);
        registryFriendlyByteBuf.writeInt(this.f5287Z);
    }

    /* JADX INFO: renamed from: k */
    public boolean m5475k() {
        this.f5289aE = this.f5288aD;
        this.f5287Z--;
        if (this.f5287Z > 0) {
            this.f5288aD = Mth.lerp(0.6f, this.f5288aD, 1.0f);
            return false;
        }
        if (this.f5288aD <= 0.0f && this.f5289aE <= 0.0f) {
            return true;
        }
        this.f5288aD = C1290xm.m7835d(this.f5288aD, 0.0f, 0.3f);
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5476a(@NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f) {
        int value = ColorReferences.COLOR_WHITE_SOLID;
        TextColor color = this.f5286jv.getStyle().getColor();
        if (color != null) {
            value = color.getValue();
        }
        int iWidth = font.width(this.f5286jv) + 3;
        float fM7843e = 1.0f - C1290xm.m7843e(this.f5288aD, this.f5289aE, f);
        int iM365p = C0119bk.m365p();
        C0119bk.m415a(guiGraphics, i + 1, i2, iWidth - 2, 1, iM365p);
        C0119bk.m415a(guiGraphics, i, i2 + 1, iWidth, 11, iM365p);
        C0119bk.m415a(guiGraphics, i + 1, i2 + 12, iWidth - 2, 1, iM365p);
        if (this.f5287Z > 0) {
            C0119bk.m417a(guiGraphics, i + 1, i2, iWidth - 2, 1, value, fM7843e);
            C0119bk.m417a(guiGraphics, i, i2 + 1, iWidth, 11, value, fM7843e);
            C0119bk.m417a(guiGraphics, i + 1, i2 + 12, iWidth - 2, 1, value, fM7843e);
        }
        C0119bk.m370a(font, guiGraphics, this.f5286jv, i + 2, i2 + 3);
    }

    @NotNull
    public Component getMessage() {
        return this.f5286jv;
    }

    /* JADX INFO: renamed from: bj */
    public int m5477bj() {
        return this.f5287Z;
    }

    public int getHeight() {
        return 12;
    }
}
