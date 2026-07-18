package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.py */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/py.class */
public abstract class AbstractC0885py extends AbstractC0835pA {

    /* JADX INFO: renamed from: nR */
    private static final int f4616nR = 10;

    /* JADX INFO: renamed from: nS */
    private static final int f4617nS = 64;

    /* JADX INFO: renamed from: kF */
    protected float f4618kF;

    /* JADX INFO: renamed from: nT */
    private int f4619nT;

    /* JADX INFO: renamed from: eR */
    private boolean f4620eR;

    public AbstractC0885py() {
        this.f4618kF = 512.0f;
        this.f4619nT = ThreadLocalRandom.current().nextInt(10);
        this.f4620eR = false;
    }

    public AbstractC0885py(@NotNull Vec3 vec3) {
        super(vec3);
        this.f4618kF = 512.0f;
        this.f4619nT = ThreadLocalRandom.current().nextInt(10);
        this.f4620eR = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public final void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4619nT;
        this.f4619nT = i - 1;
        if (i <= 0) {
            this.f4619nT = 10;
            boolean zM4449f = m4449f(localPlayer);
            if (zM4449f != this.f4620eR) {
                this.f4620eR = zM4449f;
                if (zM4449f) {
                    mo4450a(minecraft, c0622l, abstractC0787oF, localPlayer, clientLevel);
                } else {
                    mo4451b(minecraft, c0622l, abstractC0787oF, localPlayer, clientLevel);
                }
            }
        }
        if (this.f4620eR) {
            mo4452b(minecraft, c0622l, randomSource, abstractC0787oF, localPlayer, clientLevel, f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: f */
    protected boolean m4449f(@NotNull LocalPlayer localPlayer) {
        return localPlayer.distanceToSqr(this.f4464c) <= ((double) (this.f4618kF * this.f4618kF));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo4450a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4451b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4452b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) throws MatchException {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        if (z) {
            int i = this.f4620eR ? 65280 : 16711680;
            m4453a(camera, poseStack, i, Direction.Axis.X);
            m4453a(camera, poseStack, i, Direction.Axis.Y);
            m4453a(camera, poseStack, i, Direction.Axis.Z);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4453a(@NotNull Camera camera, @NotNull PoseStack poseStack, int i, @NotNull Direction.Axis axis) throws MatchException {
        Vec3 vec3Add;
        double d = this.f4618kF;
        Vec3 vec3 = null;
        for (int i2 = 0; i2 <= 64; i2++) {
            double d2 = (6.283185307179586d * ((double) i2)) / 64.0d;
            double dCos = Math.cos(d2) * d;
            double dSin = Math.sin(d2) * d;
            switch (AnonymousClass1.f4621s[axis.ordinal()]) {
                case 1:
                    vec3Add = this.f4464c.add(0.0d, dCos, dSin);
                    break;
                case 2:
                    vec3Add = this.f4464c.add(dCos, 0.0d, dSin);
                    break;
                case 3:
                    vec3Add = this.f4464c.add(dCos, dSin, 0.0d);
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            Vec3 vec32 = vec3Add;
            if (vec3 != null) {
                C0119bk.m474a(camera, poseStack, vec3, vec32, 1.0f, i);
            }
            vec3 = vec32;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.py$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/py$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: s */
        static final /* synthetic */ int[] f4621s = new int[Direction.Axis.values().length];

        static {
            try {
                f4621s[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4621s[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4621s[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        List<AbstractC0851pQ<?>> listMo4227H = super.mo4227H();
        listMo4227H.add(new C0853pS(Component.literal("Activation Distance"), () -> {
            return Float.valueOf(this.f4618kF);
        }, f -> {
            this.f4618kF = f.floatValue();
        }, 0.0f, 1024.0f));
        return listMo4227H;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        Object[] objArr = new Object[2];
        objArr[0] = Float.valueOf(this.f4618kF);
        objArr[1] = this.f4620eR ? "active" : "inactive";
        list.add(Component.literal(String.format("Activation Distance: %.1f (%s)", objArr)));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        this.f4620eR = false;
        this.f4619nT = randomSource.nextInt(10);
    }
}
