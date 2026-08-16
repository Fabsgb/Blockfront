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

/* JADX INFO: renamed from: com.boehmod.blockfront.tn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tn.class */
public final class C1088tn {

    /* JADX INFO: renamed from: tf */
    public static final int f5849tf = 12;

    /* JADX INFO: renamed from: jI */
    @NotNull
    private final Component f5850jI;

    /* JADX INFO: renamed from: aN */
    private int f5851aN;

    /* JADX INFO: renamed from: aI */
    private float f5852aI;

    /* JADX INFO: renamed from: aJ */
    private float f5853aJ;

    public C1088tn(@NotNull Component component, int i) {
        this.f5853aJ = 0.0f;
        this.f5850jI = component;
        this.f5851aN = i;
    }

    public C1088tn(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: f */
    public void m5962f(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f5850jI);
        registryFriendlyByteBuf.writeInt(this.f5851aN);
    }

    /* JADX INFO: renamed from: l */
    public boolean m5963l() {
        this.f5853aJ = this.f5852aI;
        this.f5851aN--;
        if (this.f5851aN > 0) {
            this.f5852aI = Mth.lerp(0.6f, this.f5852aI, 1.0f);
            return false;
        }
        if (this.f5852aI <= 0.0f && this.f5853aJ <= 0.0f) {
            return true;
        }
        this.f5852aI = C1270xJ.m7161d(this.f5852aI, 0.0f, 0.3f);
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5964a(@NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f) {
        int value = ColorReferences.COLOR_WHITE_SOLID;
        TextColor color = this.f5850jI.getStyle().getColor();
        if (color != null) {
            value = color.getValue();
        }
        int iWidth = font.width(this.f5850jI) + 3;
        float fM7170f = 1.0f - C1270xJ.m7170f(this.f5852aI, this.f5853aJ, f);
        C0129bt.m518b(guiGraphics, i, i2, iWidth, 13, C0129bt.m465t());
        if (this.f5851aN > 0) {
            C0129bt.m519b(guiGraphics, i, i2, iWidth, 13, value, fM7170f);
        }
        C0129bt.m470a(font, guiGraphics, this.f5850jI, i + 2, i2 + 3);
    }

    @NotNull
    public Component getMessage() {
        return this.f5850jI;
    }

    /* JADX INFO: renamed from: by */
    public int m5965by() {
        return this.f5851aN;
    }

    public int getHeight() {
        return 12;
    }
}
