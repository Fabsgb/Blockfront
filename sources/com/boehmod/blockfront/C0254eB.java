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

/* JADX INFO: renamed from: com.boehmod.blockfront.eB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eB.class */
public class C0254eB extends AbstractC0302ex {

    /* JADX INFO: renamed from: ef */
    private static final float f2083ef = 128.0f;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final C0555jl f2084f;

    /* JADX INFO: renamed from: jn */
    private final int f2085jn;

    /* JADX INFO: renamed from: cg */
    private final boolean f2086cg;

    /* JADX INFO: renamed from: cY */
    private float f2087cY;

    /* JADX INFO: renamed from: cZ */
    private float f2088cZ;

    /* JADX INFO: renamed from: ch */
    static final /* synthetic */ boolean f2089ch;

    static {
        f2089ch = !C0254eB.class.desiredAssertionStatus();
    }

    public C0254eB(int i, int i2, int i3, int i4, boolean z, int i5, @NotNull UUID uuid) {
        super(i, i2, i3, i4, Component.empty());
        this.f2086cg = z;
        this.f2085jn = i5;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2089ch && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.f2084f = ((C0396gl) c0623lM2852b.m2855a()).mo1154a(uuid);
        if (this.f2084f.m2510a() != PlayerDataType.DISPLAY) {
            m1634a();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        FloatFloatImmutablePair floatFloatImmutablePairM415a;
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX() + i3;
        int y = getY() + i4;
        float fM7170f = C1270xJ.m7170f(this.f2087cY, this.f2088cZ, f2);
        float f3 = (this.f2085jn % 2 == 1 ? 45.0f : 60.0f) + (10.0f * fM7170f);
        float f4 = (this.f2085jn % 2 == 1 ? 5.0f : 20.0f) + (10.0f * fM7170f);
        float f5 = this.f2085jn % 2 == 1 ? 0.0f : 30.0f;
        C0109bZ c0109bZM1039a = C0129bt.f871a.m1039a(minecraft, this.f2084f.m2522a());
        float fSin = Mth.sin(c0109bZM1039a.walkAnimation.position(f2) * 1.5f);
        float y2 = ((getY() + this.height) - 45) + fSin + f4;
        C0129bt.m545b(poseStackPose, guiGraphics, C0143cG.f1039aJ, x, y, 100, 100, 0.0f, 0.5f);
        C0129bt.m545b(poseStackPose, guiGraphics, C0143cG.f1040aK, x, y, C0358g.f2490g, 150, 0.0f, fM7170f);
        C0129bt.m545b(poseStackPose, guiGraphics, C0143cG.f1040aK, x, y, 80, 100, 0.0f, fM7170f);
        if (this.f2086cg) {
            floatFloatImmutablePairM415a = new FloatFloatImmutablePair(55.0f * ((i2 / minecraft.getWindow().getScreenHeight()) - 0.25f), 125.0f * (i / minecraft.getWindow().getScreenWidth()));
        } else {
            floatFloatImmutablePairM415a = c0109bZM1039a.m415a(f2);
        }
        float f6 = this.f2085jn % 2 == 1 ? 0.75f : 1.0f;
        C0129bt.m544b(poseStackPose, guiGraphics, C0143cG.f1039aJ, x, y + f4 + 40.0f, 75.0f * f6, 20.0f * f6, 0.0f, 0.55f + (0.05f * fSin));
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, f5);
        C0129bt.m595a(c0396gl, poseStackPose, guiGraphics, minecraft, (LivingEntity) c0109bZM1039a, x, y + f4 + 38.0f + fSin, f3, floatFloatImmutablePairM415a.firstFloat(), -35.0f, floatFloatImmutablePairM415a.secondFloat(), f2);
        if (this.f2084f.m2510a() != PlayerDataType.DISPLAY) {
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, f2083ef - f5);
            C0129bt.m598a(minecraft, c0623l, poseStackPose, minecraft.font, guiGraphics, c0555jl, this.f2084f, x, y2, m1445I());
            poseStackPose.popPose();
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    public void mo1443a(float f) {
        this.f2088cZ = this.f2087cY;
        this.f2087cY = Mth.lerp(0.5f, this.f2087cY, m1445I() ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1441a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0555jl c0555jl) {
        return this.f2084f.m2510a() == PlayerDataType.DISPLAY ? List.of() : List.of(Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(this.f2084f.getUsername())}));
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: F */
    protected boolean mo1444F() {
        return true;
    }

    public void onClick(double d, double d2) {
        if (this.f2084f.m2510a() == PlayerDataType.DISPLAY) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
        minecraft.setScreen(new C0215dP(minecraft.screen, this.f2084f));
    }

    /* JADX INFO: renamed from: I */
    private boolean m1445I() {
        return isHovered() && this.f2084f.m2510a() != PlayerDataType.DISPLAY;
    }
}
