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

/* JADX INFO: renamed from: com.boehmod.blockfront.eo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eo.class */
public class C0292eo extends AbstractC0288ek {

    /* JADX INFO: renamed from: ec */
    private static final float f2213ec = 128.0f;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final C0482iS f2214f;

    /* JADX INFO: renamed from: hX */
    private final int f2215hX;

    /* JADX INFO: renamed from: bY */
    private final boolean f2216bY;

    /* JADX INFO: renamed from: cS */
    private float f2217cS;

    /* JADX INFO: renamed from: cT */
    private float f2218cT;

    /* JADX INFO: renamed from: bZ */
    static final /* synthetic */ boolean f2219bZ;

    static {
        f2219bZ = !C0292eo.class.desiredAssertionStatus();
    }

    public C0292eo(int i, int i2, int i3, int i4, boolean z, int i5, @NotNull UUID uuid) {
        super(i, i2, i3, i4, Component.empty());
        this.f2216bY = z;
        this.f2215hX = i5;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2219bZ && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.f2214f = ((C0326fV) c0622lM2667b.m2670a()).mo1137a(uuid);
        if (this.f2214f.m2183a() != PlayerDataType.DISPLAY) {
            m1518a();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        FloatFloatImmutablePair floatFloatImmutablePairM310a;
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX() + i3;
        int y = getY() + i4;
        float fM7843e = C1290xm.m7843e(this.f2217cS, this.f2218cT, f2);
        float f3 = (this.f2215hX % 2 == 1 ? 45.0f : 60.0f) + (10.0f * fM7843e);
        float f4 = (this.f2215hX % 2 == 1 ? 5.0f : 20.0f) + (10.0f * fM7843e);
        float f5 = this.f2215hX % 2 == 1 ? 0.0f : 30.0f;
        C0099bQ c0099bQM316a = C0119bk.f736a.m316a(minecraft, this.f2214f.m2195a());
        float fSin = Mth.sin(c0099bQM316a.walkAnimation.position(f2) * 1.5f);
        float y2 = ((getY() + this.height) - 45) + fSin + f4;
        C0119bk.m445b(poseStackPose, guiGraphics, C0195cx.f1566aJ, x, y, 100, 100, 0.0f, 0.5f);
        C0119bk.m445b(poseStackPose, guiGraphics, C0195cx.f1567aK, x, y, C0357g.f2439g, 150, 0.0f, fM7843e);
        C0119bk.m445b(poseStackPose, guiGraphics, C0195cx.f1567aK, x, y, 80, 100, 0.0f, fM7843e);
        if (this.f2216bY) {
            floatFloatImmutablePairM310a = new FloatFloatImmutablePair(55.0f * ((i2 / minecraft.getWindow().getScreenHeight()) - 0.25f), 125.0f * (i / minecraft.getWindow().getScreenWidth()));
        } else {
            floatFloatImmutablePairM310a = c0099bQM316a.m310a(f2);
        }
        float f6 = this.f2215hX % 2 == 1 ? 0.75f : 1.0f;
        C0119bk.m444b(poseStackPose, guiGraphics, C0195cx.f1566aJ, x, y + f4 + 40.0f, 75.0f * f6, 20.0f * f6, 0.0f, 0.55f + (0.05f * fSin));
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, f5);
        C0119bk.m495a(c0326fV, poseStackPose, guiGraphics, minecraft, (LivingEntity) c0099bQM316a, x, y + f4 + 38.0f + fSin, f3, floatFloatImmutablePairM310a.firstFloat(), -35.0f, floatFloatImmutablePairM310a.secondFloat(), f2);
        if (this.f2214f.m2183a() != PlayerDataType.DISPLAY) {
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, f2213ec - f5);
            C0119bk.m498a(minecraft, c0622l, poseStackPose, minecraft.font, guiGraphics, c0482iS, this.f2214f, x, y2, m1543H());
            poseStackPose.popPose();
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    public void mo1519a(float f) {
        this.f2218cT = this.f2217cS;
        this.f2217cS = Mth.lerp(0.5f, this.f2217cS, m1543H() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1522a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0482iS c0482iS) {
        return this.f2214f.m2183a() == PlayerDataType.DISPLAY ? List.of() : List.of(Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(this.f2214f.getUsername())}));
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: E */
    protected boolean mo1520E() {
        return true;
    }

    public void onClick(double d, double d2) {
        if (this.f2214f.m2183a() == PlayerDataType.DISPLAY) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
        minecraft.setScreen(new C0203dE(minecraft.screen, this.f2214f));
    }

    /* JADX INFO: renamed from: H */
    private boolean m1543H() {
        return isHovered() && this.f2214f.m2183a() != PlayerDataType.DISPLAY;
    }
}
