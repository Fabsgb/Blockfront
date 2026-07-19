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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qC.class */
public class qC extends pA implements pI {
    private float ls;
    private float lt;
    private float lu;
    private static final int oQ = 1024;
    private static final int oR = 128;
    public float lv;
    public float lw;
    public float dE;
    public float dF;
    private final int oS;

    @NotNull
    public static final MapCodec<qC> O = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.optionalFieldOf("heightOffset", Float.valueOf(61.0f)).forGetter(qCVar -> {
            return Float.valueOf(qCVar.ls);
        }), Codec.FLOAT.optionalFieldOf("imageScale", Float.valueOf(6.0f)).forGetter(qCVar2 -> {
            return Float.valueOf(qCVar2.lt);
        }), Codec.FLOAT.optionalFieldOf("maxRotation", Float.valueOf(35.0f)).forGetter(qCVar3 -> {
            return Float.valueOf(qCVar3.lu);
        })).apply(instance, (f, f2, f3) -> {
            qC qCVar4 = new qC();
            qCVar4.ls = f.floatValue();
            qCVar4.lt = f2.floatValue();
            qCVar4.lu = f3.floatValue();
            return qCVar4;
        });
    });

    @NotNull
    private static final ResourceLocation eH = C0265jv.d("textures/misc/world/watchlight.png");

    @NotNull
    private static final ResourceLocation eI = C0265jv.d("textures/misc/debug/mapeffect/watchlight.png");

    public qC() {
        this(Vec3.ZERO);
    }

    public qC(@NotNull Vec3 vec3) {
        super(vec3);
        this.ls = 61.0f;
        this.lt = 6.0f;
        this.lu = 35.0f;
        this.lw = 0.0f;
        this.dF = 0.0f;
        this.oS = ThreadLocalRandom.current().nextInt(1, 3000);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        float f2 = f + this.oS;
        this.lw = this.lv;
        this.lv = 1.0f + Mth.sin(f2 / 160.0f);
        this.dF = this.dE;
        this.dE = Mth.sin(f2 / 30.0f);
    }

    @Override // com.boehmod.blockfront.pI
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        Vec3 position = localPlayer.getPosition(f2);
        float fAtan2 = (float) (Math.atan2((float) (position.z - this.c.z), (float) (position.x - this.c.x)) * 57.29577951308232d);
        float fE = C0634xm.e(this.lv, this.lw, f2);
        float fE2 = C0634xm.e(this.dE, this.dF, f2);
        float f3 = 128.0f * this.lt;
        float f4 = 1024.0f * this.lt;
        poseStack.pushPose();
        poseStack.translate(this.c.x, this.c.y, this.c.z);
        poseStack.mulPose(Axis.YP.rotationDegrees((-fAtan2) - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees((-this.lu) + (fE * this.lu)));
        C0040bk.a(poseStack, guiGraphics, eH, 0.0d, this.ls, 0.0d, f3, f4, 1.0f + (fE2 / 2.0f), 0.0f, 0.0f);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pS(Component.literal("Height Offset"), () -> {
            return Float.valueOf(this.ls);
        }, f -> {
            this.ls = f.floatValue();
        }, -512.0f, 512.0f));
        objectArrayList.add(new pS(Component.literal("Image Scale"), () -> {
            return Float.valueOf(this.lt);
        }, f2 -> {
            this.lt = f2.floatValue();
        }, 0.1f, 64.0f));
        objectArrayList.add(new pS(Component.literal("Max Rotation"), () -> {
            return Float.valueOf(this.lu);
        }, f3 -> {
            this.lu = f3.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Watchlight: rotAlpha=%.2f, fadeAlpha=%.2f, randomSpeed=%d", Float.valueOf(this.lv), Float.valueOf(this.dE), Integer.valueOf(this.oS))));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eI;
    }

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
