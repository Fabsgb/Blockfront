package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qC.class */
public class C0890qC extends AbstractC0835pA implements InterfaceC0843pI {

    /* JADX INFO: renamed from: ls */
    private float f4636ls;

    /* JADX INFO: renamed from: lt */
    private float f4637lt;

    /* JADX INFO: renamed from: lu */
    private float f4638lu;

    /* JADX INFO: renamed from: oQ */
    private static final int f4639oQ = 1024;

    /* JADX INFO: renamed from: oR */
    private static final int f4640oR = 128;

    /* JADX INFO: renamed from: lv */
    public float f4643lv;

    /* JADX INFO: renamed from: lw */
    public float f4644lw;

    /* JADX INFO: renamed from: dE */
    public float f4645dE;

    /* JADX INFO: renamed from: dF */
    public float f4646dF;

    /* JADX INFO: renamed from: oS */
    private final int f4647oS;

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final MapCodec<C0890qC> f4635O = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.optionalFieldOf("heightOffset", Float.valueOf(61.0f)).forGetter(c0890qC -> {
            return Float.valueOf(c0890qC.f4636ls);
        }), Codec.FLOAT.optionalFieldOf("imageScale", Float.valueOf(6.0f)).forGetter(c0890qC2 -> {
            return Float.valueOf(c0890qC2.f4637lt);
        }), Codec.FLOAT.optionalFieldOf("maxRotation", Float.valueOf(35.0f)).forGetter(c0890qC3 -> {
            return Float.valueOf(c0890qC3.f4638lu);
        })).apply(instance, (f, f2, f3) -> {
            C0890qC c0890qC4 = new C0890qC();
            c0890qC4.f4636ls = f.floatValue();
            c0890qC4.f4637lt = f2.floatValue();
            c0890qC4.f4638lu = f3.floatValue();
            return c0890qC4;
        });
    });

    /* JADX INFO: renamed from: eH */
    @NotNull
    private static final ResourceLocation f4641eH = C0564jv.m2555d("textures/misc/world/watchlight.png");

    /* JADX INFO: renamed from: eI */
    @NotNull
    private static final ResourceLocation f4642eI = C0564jv.m2555d("textures/misc/debug/mapeffect/watchlight.png");

    public C0890qC() {
        this(Vec3.ZERO);
    }

    public C0890qC(@NotNull Vec3 vec3) {
        super(vec3);
        this.f4636ls = 61.0f;
        this.f4637lt = 6.0f;
        this.f4638lu = 35.0f;
        this.f4644lw = 0.0f;
        this.f4646dF = 0.0f;
        this.f4647oS = ThreadLocalRandom.current().nextInt(1, 3000);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        float f2 = f + this.f4647oS;
        this.f4644lw = this.f4643lv;
        this.f4643lv = 1.0f + Mth.sin(f2 / 160.0f);
        this.f4646dF = this.f4645dE;
        this.f4645dE = Mth.sin(f2 / 30.0f);
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        Vec3 position = localPlayer.getPosition(f2);
        float fAtan2 = (float) (Math.atan2((float) (position.z - this.f4464c.z), (float) (position.x - this.f4464c.x)) * 57.29577951308232d);
        float fM7843e = C1290xm.m7843e(this.f4643lv, this.f4644lw, f2);
        float fM7843e2 = C1290xm.m7843e(this.f4645dE, this.f4646dF, f2);
        float f3 = 128.0f * this.f4637lt;
        float f4 = 1024.0f * this.f4637lt;
        poseStack.pushPose();
        poseStack.translate(this.f4464c.x, this.f4464c.y, this.f4464c.z);
        poseStack.mulPose(Axis.YP.rotationDegrees((-fAtan2) - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees((-this.f4638lu) + (fM7843e * this.f4638lu)));
        C0119bk.m515a(poseStack, guiGraphics, f4641eH, 0.0d, this.f4636ls, 0.0d, f3, f4, 1.0f + (fM7843e2 / 2.0f), 0.0f, 0.0f);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0853pS(Component.literal("Height Offset"), () -> {
            return Float.valueOf(this.f4636ls);
        }, f -> {
            this.f4636ls = f.floatValue();
        }, -512.0f, 512.0f));
        objectArrayList.add(new C0853pS(Component.literal("Image Scale"), () -> {
            return Float.valueOf(this.f4637lt);
        }, f2 -> {
            this.f4637lt = f2.floatValue();
        }, 0.1f, 64.0f));
        objectArrayList.add(new C0853pS(Component.literal("Max Rotation"), () -> {
            return Float.valueOf(this.f4638lu);
        }, f3 -> {
            this.f4638lu = f3.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Watchlight: rotAlpha=%.2f, fadeAlpha=%.2f, randomSpeed=%d", Float.valueOf(this.f4643lv), Float.valueOf(this.f4645dE), Integer.valueOf(this.f4647oS))));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4642eI;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
