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

/* JADX INFO: renamed from: com.boehmod.blockfront.pU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pU.class */
public abstract class AbstractC0856pU extends AbstractC0858pW {

    /* JADX INFO: renamed from: pQ */
    private static final int f4585pQ = 10;

    /* JADX INFO: renamed from: pR */
    private static final int f4586pR = 64;

    /* JADX INFO: renamed from: lA */
    protected float f4587lA;

    /* JADX INFO: renamed from: pS */
    private int f4588pS;

    /* JADX INFO: renamed from: fl */
    private boolean f4589fl;

    public AbstractC0856pU() {
        this.f4587lA = 512.0f;
        this.f4588pS = ThreadLocalRandom.current().nextInt(10);
        this.f4589fl = false;
    }

    public AbstractC0856pU(@NotNull Vec3 vec3) {
        super(vec3);
        this.f4587lA = 512.0f;
        this.f4588pS = ThreadLocalRandom.current().nextInt(10);
        this.f4589fl = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public final void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4588pS;
        this.f4588pS = i - 1;
        if (i <= 0) {
            this.f4588pS = 10;
            boolean zM3940f = m3940f(localPlayer);
            if (zM3940f != this.f4589fl) {
                this.f4589fl = zM3940f;
                if (zM3940f) {
                    mo3941a(minecraft, c0623l, abstractC0863pb, localPlayer, clientLevel);
                } else {
                    mo3942b(minecraft, c0623l, abstractC0863pb, localPlayer, clientLevel);
                }
            }
        }
        if (this.f4589fl) {
            mo3943b(minecraft, c0623l, randomSource, abstractC0863pb, localPlayer, clientLevel, f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: f */
    protected boolean m3940f(@NotNull LocalPlayer localPlayer) {
        return localPlayer.distanceToSqr(this.f4593c) <= ((double) (this.f4587lA * this.f4587lA));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3941a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3942b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3943b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        if (z) {
            int i = this.f4589fl ? 65280 : 16711680;
            m3945a(camera, poseStack, i, Direction.Axis.X);
            m3945a(camera, poseStack, i, Direction.Axis.Y);
            m3945a(camera, poseStack, i, Direction.Axis.Z);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m3945a(@NotNull Camera camera, @NotNull PoseStack poseStack, int i, @NotNull Direction.Axis axis) throws MatchException {
        Vec3 vec3Add;
        double d = this.f4587lA;
        Vec3 vec3 = null;
        for (int i2 = 0; i2 <= 64; i2++) {
            double d2 = (6.283185307179586d * ((double) i2)) / 64.0d;
            double dCos = Math.cos(d2) * d;
            double dSin = Math.sin(d2) * d;
            switch (AnonymousClass1.f4590u[axis.ordinal()]) {
                case 1:
                    vec3Add = this.f4593c.add(0.0d, dCos, dSin);
                    break;
                case 2:
                    vec3Add = this.f4593c.add(dCos, 0.0d, dSin);
                    break;
                case 3:
                    vec3Add = this.f4593c.add(dCos, dSin, 0.0d);
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            Vec3 vec4 = vec3Add;
            if (vec3 != null) {
                C0129bt.m574a(camera, poseStack, vec3, vec4, 1.0f, i);
            }
            vec3 = vec4;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pU$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pU$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: u */
        static final /* synthetic */ int[] f4590u = new int[Direction.Axis.values().length];

        static {
            try {
                f4590u[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4590u[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4590u[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        List<AbstractC0927qm<?>> listMo3946J = super.mo3946J();
        listMo3946J.add(new C0929qo(Component.literal("Activation Distance"), () -> {
            return Float.valueOf(this.f4587lA);
        }, f -> {
            this.f4587lA = f.floatValue();
        }, 0.0f, 1024.0f));
        return listMo3946J;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        Object[] objArr = new Object[2];
        objArr[0] = Float.valueOf(this.f4587lA);
        objArr[1] = this.f4589fl ? "active" : "inactive";
        list.add(Component.literal(String.format("Activation Distance: %.1f (%s)", objArr)));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        this.f4589fl = false;
        this.f4588pS = randomSource.nextInt(10);
    }
}
