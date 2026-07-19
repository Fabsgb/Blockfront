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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sQ.class */
public final class sQ {
    public static final int re = 12;

    @NotNull
    private final Component jv;
    private int Z;
    private float aD;
    private float aE;

    public sQ(@NotNull Component component, int i) {
        this.aE = 0.0f;
        this.jv = component;
        this.Z = i;
    }

    public sQ(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readInt());
    }

    public void f(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.jv);
        registryFriendlyByteBuf.writeInt(this.Z);
    }

    public boolean k() {
        this.aE = this.aD;
        this.Z--;
        if (this.Z > 0) {
            this.aD = Mth.lerp(0.6f, this.aD, 1.0f);
            return false;
        }
        if (this.aD <= 0.0f && this.aE <= 0.0f) {
            return true;
        }
        this.aD = C0634xm.d(this.aD, 0.0f, 0.3f);
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f) {
        int value = ColorReferences.COLOR_WHITE_SOLID;
        TextColor color = this.jv.getStyle().getColor();
        if (color != null) {
            value = color.getValue();
        }
        int iWidth = font.width(this.jv) + 3;
        float fE = 1.0f - C0634xm.e(this.aD, this.aE, f);
        int iP = C0040bk.p();
        C0040bk.a(guiGraphics, i + 1, i2, iWidth - 2, 1, iP);
        C0040bk.a(guiGraphics, i, i2 + 1, iWidth, 11, iP);
        C0040bk.a(guiGraphics, i + 1, i2 + 12, iWidth - 2, 1, iP);
        if (this.Z > 0) {
            C0040bk.a(guiGraphics, i + 1, i2, iWidth - 2, 1, value, fE);
            C0040bk.a(guiGraphics, i, i2 + 1, iWidth, 11, value, fE);
            C0040bk.a(guiGraphics, i + 1, i2 + 12, iWidth - 2, 1, value, fE);
        }
        C0040bk.a(font, guiGraphics, this.jv, i + 2, i2 + 3);
    }

    @NotNull
    public Component getMessage() {
        return this.jv;
    }

    public int bj() {
        return this.Z;
    }

    public int getHeight() {
        return 12;
    }
}
