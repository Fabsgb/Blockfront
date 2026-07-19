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

/* JADX INFO: renamed from: com.boehmod.blockfront.py, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/py.class */
public abstract class AbstractC0430py extends pA {
    private static final int nR = 10;
    private static final int nS = 64;
    protected float kF;
    private int nT;
    private boolean eR;

    public AbstractC0430py() {
        this.kF = 512.0f;
        this.nT = ThreadLocalRandom.current().nextInt(10);
        this.eR = false;
    }

    public AbstractC0430py(@NotNull Vec3 vec3) {
        super(vec3);
        this.kF = 512.0f;
        this.nT = ThreadLocalRandom.current().nextInt(10);
        this.eR = false;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public final void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.nT;
        this.nT = i - 1;
        if (i <= 0) {
            this.nT = 10;
            boolean zF = f(localPlayer);
            if (zF != this.eR) {
                this.eR = zF;
                if (zF) {
                    a(minecraft, c0297l, oFVar, localPlayer, clientLevel);
                } else {
                    b(minecraft, c0297l, oFVar, localPlayer, clientLevel);
                }
            }
        }
        if (this.eR) {
            b(minecraft, c0297l, randomSource, oFVar, localPlayer, clientLevel, f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected boolean f(@NotNull LocalPlayer localPlayer) {
        return localPlayer.distanceToSqr(this.c) <= ((double) (this.kF * this.kF));
    }

    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.pA
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        if (z) {
            int i = this.eR ? 65280 : 16711680;
            a(camera, poseStack, i, Direction.Axis.X);
            a(camera, poseStack, i, Direction.Axis.Y);
            a(camera, poseStack, i, Direction.Axis.Z);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Camera camera, @NotNull PoseStack poseStack, int i, @NotNull Direction.Axis axis) throws MatchException {
        Vec3 vec3Add;
        double d = this.kF;
        Vec3 vec3 = null;
        for (int i2 = 0; i2 <= 64; i2++) {
            double d2 = (6.283185307179586d * ((double) i2)) / 64.0d;
            double dCos = Math.cos(d2) * d;
            double dSin = Math.sin(d2) * d;
            switch (AnonymousClass1.s[axis.ordinal()]) {
                case 1:
                    vec3Add = this.c.add(0.0d, dCos, dSin);
                    break;
                case 2:
                    vec3Add = this.c.add(dCos, 0.0d, dSin);
                    break;
                case 3:
                    vec3Add = this.c.add(dCos, dSin, 0.0d);
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            Vec3 vec32 = vec3Add;
            if (vec3 != null) {
                C0040bk.a(camera, poseStack, vec3, vec32, 1.0f, i);
            }
            vec3 = vec32;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.py$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/py$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] s = new int[Direction.Axis.values().length];

        static {
            try {
                s[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                s[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                s[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        List<pQ<?>> listH = super.H();
        listH.add(new pS(Component.literal("Activation Distance"), () -> {
            return Float.valueOf(this.kF);
        }, f -> {
            this.kF = f.floatValue();
        }, 0.0f, 1024.0f));
        return listH;
    }

    @Override // com.boehmod.blockfront.pA
    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        Object[] objArr = new Object[2];
        objArr[0] = Float.valueOf(this.kF);
        objArr[1] = this.eR ? "active" : "inactive";
        list.add(Component.literal(String.format("Activation Distance: %.1f (%s)", objArr)));
    }

    @Override // com.boehmod.blockfront.pA
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.eR = false;
        this.nT = randomSource.nextInt(10);
    }
}
