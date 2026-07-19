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

/* JADX INFO: renamed from: com.boehmod.blockfront.qw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qw.class */
public class C0455qw extends pA implements pI {
    private static final int oI = 200;
    private static final int oJ = 250;
    private static final int oK = 60;
    private static final int oL = -50;
    private static final int oM = -20;
    private static final int oN = 25;
    private int om;
    private int oO;

    @NotNull
    private Supplier<? extends Block> q;

    @NotNull
    private static final ResourceLocation eA = C0265jv.d("textures/misc/debug/mapeffect/sky_planes.png");

    @NotNull
    public static final MapCodec<C0455qw> I = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("radius").forGetter(c0455qw -> {
            return Integer.valueOf(c0455qw.om);
        }), Codec.INT.fieldOf("repeat").forGetter(c0455qw2 -> {
            return Integer.valueOf(c0455qw2.oO);
        }), ResourceLocation.CODEC.fieldOf("block").forGetter(c0455qw3 -> {
            return C0636xo.a(c0455qw3.q.get());
        })).apply(instance, (num, num2, resourceLocation) -> {
            return new C0455qw(num.intValue(), num2.intValue(), C0636xo.b(resourceLocation));
        });
    });

    public C0455qw() {
        this(0, 0, wL.hR);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0455qw(int i, int i2, @NotNull Supplier<? extends Block> supplier) {
        this.om = i;
        this.oO = i2;
        this.q = supplier;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.pI
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        BlockState blockStateDefaultBlockState = this.q.get().defaultBlockState();
        double d = this.om * this.oO;
        Vec3 vec3Position = localPlayer.position();
        double d2 = (((double) (f % this.om)) + vec3Position.x) - (d / 2.0d);
        double d3 = vec3Position.y + 200.0d;
        double d4 = vec3Position.z;
        poseStack.translate(d2, d3, d4);
        a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 0.0d, 0.0d, 0.0d);
        a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 60.0d, -50.0d, 250.0d);
        a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 60.0d, -50.0d, -250.0d);
        poseStack.translate(-d2, -d3, -d4);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Sky Planes: block=" + C0636xo.c(this.q.get()) + ", radius=" + this.om + ", repeat=" + this.oO));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eA;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pT(Component.literal("Radius"), () -> {
            return Integer.valueOf(this.om);
        }, num -> {
            this.om = num.intValue();
        }, 1, InterfaceC0638xq.tR));
        objectArrayList.add(new pT(Component.literal("Repeat"), () -> {
            return Integer.valueOf(this.oO);
        }, num2 -> {
            this.oO = num2.intValue();
        }, 1, 64));
        objectArrayList.add(new pU(Component.literal("Block"), () -> {
            return this.q.get();
        }, block -> {
            this.q = () -> {
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

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return true;
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

    private void a(@NotNull PoseStack poseStack, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, double d, double d2, double d3) {
        for (int i = 0; i < this.oO; i++) {
            a(clientLevel, blockRenderDispatcher, bufferSource, poseStack, blockState, d + ((double) (this.om * i)), d2, d3);
        }
    }

    private void a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull BlockState blockState, double d, double d2, double d3) {
        C0040bk.a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d, d2, d3, 0.0f, -90.0f, 0.0f);
        C0040bk.a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d - 20.0d, d2 + 25.0d, d3 + 25.0d, 0.0f, -90.0f, 0.0f);
        C0040bk.a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d - 20.0d, d2 + 25.0d, d3 - 25.0d, 0.0f, -90.0f, 0.0f);
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
