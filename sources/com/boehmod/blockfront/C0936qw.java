package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qw.class */
public class C0936qw extends AbstractC0835pA implements InterfaceC0843pI {

    /* JADX INFO: renamed from: oI */
    private static final int f4978oI = 200;

    /* JADX INFO: renamed from: oJ */
    private static final int f4979oJ = 250;

    /* JADX INFO: renamed from: oK */
    private static final int f4980oK = 60;

    /* JADX INFO: renamed from: oL */
    private static final int f4981oL = -50;

    /* JADX INFO: renamed from: oM */
    private static final int f4982oM = -20;

    /* JADX INFO: renamed from: oN */
    private static final int f4983oN = 25;

    /* JADX INFO: renamed from: om */
    private int f4985om;

    /* JADX INFO: renamed from: oO */
    private int f4986oO;

    /* JADX INFO: renamed from: q */
    @NotNull
    private Supplier<? extends Block> f4987q;

    /* JADX INFO: renamed from: eA */
    @NotNull
    private static final ResourceLocation f4977eA = C0564jv.m2555d("textures/misc/debug/mapeffect/sky_planes.png");

    /* JADX INFO: renamed from: I */
    @NotNull
    public static final MapCodec<C0936qw> f4984I = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("radius").forGetter(c0936qw -> {
            return Integer.valueOf(c0936qw.f4985om);
        }), Codec.INT.fieldOf("repeat").forGetter(c0936qw2 -> {
            return Integer.valueOf(c0936qw2.f4986oO);
        }), ResourceLocation.CODEC.fieldOf("block").forGetter(c0936qw3 -> {
            return C1292xo.m7896a(c0936qw3.f4987q.get());
        })).apply(instance, (num, num2, resourceLocation) -> {
            return new C0936qw(num.intValue(), num2.intValue(), C1292xo.m7897b(resourceLocation));
        });
    });

    public C0936qw() {
        this(0, 0, C1218wL.f6737hR);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0936qw(int i, int i2, @NotNull Supplier<? extends Block> supplier) {
        this.f4985om = i;
        this.f4986oO = i2;
        this.f4987q = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        BlockState blockStateDefaultBlockState = this.f4987q.get().defaultBlockState();
        double d = this.f4985om * this.f4986oO;
        Vec3 vec3Position = localPlayer.position();
        double d2 = (((double) (f % this.f4985om)) + vec3Position.x) - (d / 2.0d);
        double d3 = vec3Position.y + 200.0d;
        double d4 = vec3Position.z;
        poseStack.translate(d2, d3, d4);
        m5088a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 0.0d, 0.0d, 0.0d);
        m5088a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 60.0d, -50.0d, 250.0d);
        m5088a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 60.0d, -50.0d, -250.0d);
        poseStack.translate(-d2, -d3, -d4);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Sky Planes: block=" + C1292xo.m7887c(this.f4987q.get()) + ", radius=" + this.f4985om + ", repeat=" + this.f4986oO));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4977eA;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0854pT(Component.literal("Radius"), () -> {
            return Integer.valueOf(this.f4985om);
        }, num -> {
            this.f4985om = num.intValue();
        }, 1, InterfaceC1294xq.f8656tR));
        objectArrayList.add(new C0854pT(Component.literal("Repeat"), () -> {
            return Integer.valueOf(this.f4986oO);
        }, num2 -> {
            this.f4986oO = num2.intValue();
        }, 1, 64));
        objectArrayList.add(new C0855pU(Component.literal("Block"), () -> {
            return this.f4987q.get();
        }, block -> {
            this.f4987q = () -> {
                return block;
            };
        }, Component.literal("Select Block"), () -> {
            return new ObjectArrayList(BuiltInRegistries.BLOCK.stream().toList());
        }, block2 -> {
            return BuiltInRegistries.BLOCK.getKey(block2).toString();
        }, block3 -> {
            return Component.literal(BuiltInRegistries.BLOCK.getKey(block3).toString());
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return true;
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

    /* JADX INFO: renamed from: a */
    private void m5088a(@NotNull PoseStack poseStack, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, double d, double d2, double d3) {
        for (int i = 0; i < this.f4986oO; i++) {
            m5089a(clientLevel, blockRenderDispatcher, bufferSource, poseStack, blockState, d + ((double) (this.f4985om * i)), d2, d3);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5089a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull BlockState blockState, double d, double d2, double d3) {
        C0119bk.m532a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d, d2, d3, 0.0f, -90.0f, 0.0f);
        C0119bk.m532a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d - 20.0d, d2 + 25.0d, d3 + 25.0d, 0.0f, -90.0f, 0.0f);
        C0119bk.m532a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d - 20.0d, d2 + 25.0d, d3 - 25.0d, 0.0f, -90.0f, 0.0f);
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
