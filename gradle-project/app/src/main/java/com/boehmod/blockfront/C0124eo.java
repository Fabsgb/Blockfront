package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.floats.FloatFloatImmutablePair;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eo.class */
public class C0124eo extends AbstractC0120ek {
    private static final float ec = 128.0f;

    @NotNull
    private final iS f;
    private final int hX;
    private final boolean bY;
    private float cS;
    private float cT;
    static final /* synthetic */ boolean bZ;

    static {
        bZ = !C0124eo.class.desiredAssertionStatus();
    }

    public C0124eo(int i, int i2, int i3, int i4, boolean z, int i5, @NotNull UUID uuid) {
        super(i, i2, i3, i4, Component.empty());
        this.bY = z;
        this.hX = i5;
        C0297l c0297lB = C0297l.b();
        if (!bZ && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.f = ((fV) c0297lB.a()).mo306a(uuid);
        if (this.f.a() != PlayerDataType.DISPLAY) {
            a();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        FloatFloatImmutablePair floatFloatImmutablePairA;
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX() + i3;
        int y = getY() + i4;
        float fE = C0634xm.e(this.cS, this.cT, f2);
        float f3 = (this.hX % 2 == 1 ? 45.0f : 60.0f) + (10.0f * fE);
        float f4 = (this.hX % 2 == 1 ? 5.0f : 20.0f) + (10.0f * fE);
        float f5 = this.hX % 2 == 1 ? 0.0f : 30.0f;
        bQ bQVarA = C0040bk.a.a(minecraft, this.f.m491a());
        float fSin = Mth.sin(bQVarA.walkAnimation.position(f2) * 1.5f);
        float y2 = ((getY() + this.height) - 45) + fSin + f4;
        C0040bk.b(poseStackPose, guiGraphics, C0080cx.aJ, x, y, 100, 100, 0.0f, 0.5f);
        C0040bk.b(poseStackPose, guiGraphics, C0080cx.aK, x, y, C0163g.g, 150, 0.0f, fE);
        C0040bk.b(poseStackPose, guiGraphics, C0080cx.aK, x, y, 80, 100, 0.0f, fE);
        if (this.bY) {
            floatFloatImmutablePairA = new FloatFloatImmutablePair(55.0f * ((i2 / minecraft.getWindow().getScreenHeight()) - 0.25f), 125.0f * (i / minecraft.getWindow().getScreenWidth()));
        } else {
            floatFloatImmutablePairA = bQVarA.a(f2);
        }
        float f6 = this.hX % 2 == 1 ? 0.75f : 1.0f;
        C0040bk.b(poseStackPose, guiGraphics, C0080cx.aJ, x, y + f4 + 40.0f, 75.0f * f6, 20.0f * f6, 0.0f, 0.55f + (0.05f * fSin));
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, f5);
        C0040bk.a(fVVar, poseStackPose, guiGraphics, minecraft, (LivingEntity) bQVarA, x, y + f4 + 38.0f + fSin, f3, floatFloatImmutablePairA.firstFloat(), -35.0f, floatFloatImmutablePairA.secondFloat(), f2);
        if (this.f.a() != PlayerDataType.DISPLAY) {
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, ec - f5);
            C0040bk.a(minecraft, c0297l, poseStackPose, minecraft.font, guiGraphics, iSVar, this.f, x, y2, H());
            poseStackPose.popPose();
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    public void a(float f) {
        this.cT = this.cS;
        this.cS = Mth.lerp(0.5f, this.cS, H() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    @NotNull
    protected List<Component> a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull iS iSVar) {
        return this.f.a() == PlayerDataType.DISPLAY ? List.of() : List.of(Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(this.f.getUsername())}));
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected boolean E() {
        return true;
    }

    public void onClick(double d, double d2) {
        if (this.f.a() == PlayerDataType.DISPLAY) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
        minecraft.setScreen(new dE(minecraft.screen, this.f));
    }

    private boolean H() {
        return isHovered() && this.f.a() != PlayerDataType.DISPLAY;
    }
}
