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

/* JADX INFO: renamed from: com.boehmod.blockfront.qZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qZ.class */
public class C0914qZ extends AbstractC0858pW implements InterfaceC0919qe {

    /* JADX INFO: renamed from: mr */
    private float f5107mr;

    /* JADX INFO: renamed from: ms */
    private float f5108ms;

    /* JADX INFO: renamed from: mt */
    private float f5109mt;

    /* JADX INFO: renamed from: qP */
    private static final int f5110qP = 1024;

    /* JADX INFO: renamed from: qQ */
    private static final int f5111qQ = 128;

    /* JADX INFO: renamed from: mu */
    public float f5114mu;

    /* JADX INFO: renamed from: mv */
    public float f5115mv;

    /* JADX INFO: renamed from: dH */
    public float f5116dH;

    /* JADX INFO: renamed from: dI */
    public float f5117dI;

    /* JADX INFO: renamed from: qR */
    private final int f5118qR;

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final MapCodec<C0914qZ> f5106P = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.optionalFieldOf("heightOffset", Float.valueOf(61.0f)).forGetter(c0914qZ -> {
            return Float.valueOf(c0914qZ.f5107mr);
        }), Codec.FLOAT.optionalFieldOf("imageScale", Float.valueOf(6.0f)).forGetter(c0914qZ2 -> {
            return Float.valueOf(c0914qZ2.f5108ms);
        }), Codec.FLOAT.optionalFieldOf("maxRotation", Float.valueOf(35.0f)).forGetter(c0914qZ3 -> {
            return Float.valueOf(c0914qZ3.f5109mt);
        })).apply(instance, (f, f2, f3) -> {
            C0914qZ c0914qZ4 = new C0914qZ();
            c0914qZ4.f5107mr = f.floatValue();
            c0914qZ4.f5108ms = f2.floatValue();
            c0914qZ4.f5109mt = f3.floatValue();
            return c0914qZ4;
        });
    });

    /* JADX INFO: renamed from: eG */
    @NotNull
    private static final ResourceLocation f5112eG = C0532jO.m2378d("textures/misc/world/watchlight.png");

    /* JADX INFO: renamed from: eH */
    @NotNull
    private static final ResourceLocation f5113eH = C0532jO.m2378d("textures/misc/debug/mapeffect/watchlight.png");

    public C0914qZ() {
        this(Vec3.ZERO);
    }

    public C0914qZ(@NotNull Vec3 vec3) {
        super(vec3);
        this.f5107mr = 61.0f;
        this.f5108ms = 6.0f;
        this.f5109mt = 35.0f;
        this.f5115mv = 0.0f;
        this.f5117dI = 0.0f;
        this.f5118qR = ThreadLocalRandom.current().nextInt(1, 3000);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        float f2 = f + this.f5118qR;
        this.f5115mv = this.f5114mu;
        this.f5114mu = 1.0f + Mth.sin(f2 / 160.0f);
        this.f5117dI = this.f5116dH;
        this.f5116dH = Mth.sin(f2 / 30.0f);
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        Vec3 position = localPlayer.getPosition(f2);
        float fAtan2 = (float) (Math.atan2((float) (position.z - this.f4593c.z), (float) (position.x - this.f4593c.x)) * 57.29577951308232d);
        float fM7170f = C1270xJ.m7170f(this.f5114mu, this.f5115mv, f2);
        float fM7170f2 = C1270xJ.m7170f(this.f5116dH, this.f5117dI, f2);
        float f3 = 128.0f * this.f5108ms;
        float f4 = 1024.0f * this.f5108ms;
        poseStack.pushPose();
        poseStack.translate(this.f4593c.x, this.f4593c.y, this.f4593c.z);
        poseStack.mulPose(Axis.YP.rotationDegrees((-fAtan2) - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees((-this.f5109mt) + (fM7170f * this.f5109mt)));
        C0129bt.m616a(poseStack, guiGraphics, f5112eG, 0.0d, this.f5107mr, 0.0d, f3, f4, 1.0f + (fM7170f2 / 2.0f), 0.0f, 0.0f);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0929qo(Component.literal("Height Offset"), () -> {
            return Float.valueOf(this.f5107mr);
        }, f -> {
            this.f5107mr = f.floatValue();
        }, -512.0f, 512.0f));
        objectArrayList.add(new C0929qo(Component.literal("Image Scale"), () -> {
            return Float.valueOf(this.f5108ms);
        }, f2 -> {
            this.f5108ms = f2.floatValue();
        }, 0.1f, 64.0f));
        objectArrayList.add(new C0929qo(Component.literal("Max Rotation"), () -> {
            return Float.valueOf(this.f5109mt);
        }, f3 -> {
            this.f5109mt = f3.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Watchlight: rotAlpha=%.2f, fadeAlpha=%.2f, randomSpeed=%d", Float.valueOf(this.f5114mu), Float.valueOf(this.f5116dH), Integer.valueOf(this.f5118qR))));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5113eH;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
