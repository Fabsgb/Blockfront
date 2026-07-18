package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0092bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bM.class */
public final class C0095bM implements InterfaceC0092bJ {

    /* JADX INFO: renamed from: aa */
    public static final ResourceLocation f627aa = C0564jv.m2555d("textures/gui/emitter/flash.png");

    /* JADX INFO: renamed from: ab */
    public static final ResourceLocation f628ab = C0564jv.m2555d("textures/gui/emitter/snowflake.png");

    /* JADX INFO: renamed from: di */
    private final float f629di;

    /* JADX INFO: renamed from: dj */
    private final float f630dj;

    /* JADX INFO: renamed from: db */
    private float f632db;

    /* JADX INFO: renamed from: aL */
    private boolean f631aL = false;

    /* JADX INFO: renamed from: dc */
    private float f633dc = 0.0f;

    public C0095bM(float f, float f2) {
        this.f629di = f;
        this.f630dj = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: m */
    public void mo289m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public boolean mo290a(float f) {
        this.f633dc = this.f632db;
        if (this.f631aL) {
            if (this.f632db > 0.0f) {
                this.f632db -= 0.05f;
                return false;
            }
            return true;
        }
        if (this.f632db < 1.0f) {
            this.f632db += 0.25f;
            return false;
        }
        this.f631aL = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public void mo291a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: b */
    public void mo292b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float f3 = this.f633dc + ((this.f632db - this.f633dc) * f2);
        float fSin = 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f);
        C0119bk.m444b(poseStack, guiGraphics, f627aa, this.f629di, this.f630dj, 25.0f * f3, 25.0f * f3, fSin, f3 / 2.0f);
        C0119bk.m444b(poseStack, guiGraphics, f628ab, this.f629di, this.f630dj, 15.0f * f3, 15.0f * f3, fSin, f3);
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0092bJ.a mo293a() {
        return InterfaceC0092bJ.a.BACKGROUND;
    }
}
