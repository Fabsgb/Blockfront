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

/* JADX INFO: renamed from: com.boehmod.blockfront.qT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qT.class */
public class C0908qT extends AbstractC0858pW implements InterfaceC0919qe {

    /* JADX INFO: renamed from: qH */
    private static final int f5074qH = 200;

    /* JADX INFO: renamed from: qI */
    private static final int f5075qI = 250;

    /* JADX INFO: renamed from: qJ */
    private static final int f5076qJ = 60;

    /* JADX INFO: renamed from: qK */
    private static final int f5077qK = -50;

    /* JADX INFO: renamed from: qL */
    private static final int f5078qL = -20;

    /* JADX INFO: renamed from: qM */
    private static final int f5079qM = 25;

    /* JADX INFO: renamed from: ql */
    private int f5081ql;

    /* JADX INFO: renamed from: qN */
    private int f5082qN;

    /* JADX INFO: renamed from: q */
    @NotNull
    private Supplier<? extends Block> f5083q;

    /* JADX INFO: renamed from: ez */
    @NotNull
    private static final ResourceLocation f5073ez = C0532jO.m2378d("textures/misc/debug/mapeffect/sky_planes.png");

    /* JADX INFO: renamed from: J */
    @NotNull
    public static final MapCodec<C0908qT> f5080J = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("radius").forGetter(c0908qT -> {
            return Integer.valueOf(c0908qT.f5081ql);
        }), Codec.INT.fieldOf("repeat").forGetter(c0908qT2 -> {
            return Integer.valueOf(c0908qT2.f5082qN);
        }), ResourceLocation.CODEC.fieldOf("block").forGetter(c0908qT3 -> {
            return C1272xL.m7223a(c0908qT3.f5083q.get());
        })).apply(instance, (num, num2, resourceLocation) -> {
            return new C0908qT(num.intValue(), num2.intValue(), C1272xL.m7224b(resourceLocation));
        });
    });

    public C0908qT() {
        this(0, 0, C1295xi.f7300hR);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0908qT(int i, int i2, @NotNull Supplier<? extends Block> supplier) {
        this.f5081ql = i;
        this.f5082qN = i2;
        this.f5083q = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        BlockState blockStateDefaultBlockState = this.f5083q.get().defaultBlockState();
        double d = this.f5081ql * this.f5082qN;
        Vec3 vec3Position = localPlayer.position();
        double d2 = (((double) (f % this.f5081ql)) + vec3Position.x) - (d / 2.0d);
        double d3 = vec3Position.y + 200.0d;
        double d4 = vec3Position.z;
        poseStack.translate(d2, d3, d4);
        m5000a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 0.0d, 0.0d, 0.0d);
        m5000a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 60.0d, -50.0d, 250.0d);
        m5000a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, blockStateDefaultBlockState, 60.0d, -50.0d, -250.0d);
        poseStack.translate(-d2, -d3, -d4);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Sky Planes: block=" + C1272xL.m7214c(this.f5083q.get()) + ", radius=" + this.f5081ql + ", repeat=" + this.f5082qN));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5073ez;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0930qp(Component.literal("Radius"), () -> {
            return Integer.valueOf(this.f5081ql);
        }, num -> {
            this.f5081ql = num.intValue();
        }, 1, 1024));
        objectArrayList.add(new C0930qp(Component.literal("Repeat"), () -> {
            return Integer.valueOf(this.f5082qN);
        }, num2 -> {
            this.f5082qN = num2.intValue();
        }, 1, 64));
        objectArrayList.add(new C0931qq(Component.literal("Block"), () -> {
            return this.f5083q.get();
        }, block -> {
            this.f5083q = () -> {
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

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return true;
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

    /* JADX INFO: renamed from: a */
    private void m5000a(@NotNull PoseStack poseStack, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, double d, double d2, double d3) {
        for (int i = 0; i < this.f5082qN; i++) {
            m5001a(clientLevel, blockRenderDispatcher, bufferSource, poseStack, blockState, d + ((double) (this.f5081ql * i)), d2, d3);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5001a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull BlockState blockState, double d, double d2, double d3) {
        C0129bt.m634a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d, d2, d3, 0.0f, -90.0f, 0.0f);
        C0129bt.m634a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d - 20.0d, d2 + 25.0d, d3 + 25.0d, 0.0f, -90.0f, 0.0f);
        C0129bt.m634a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d - 20.0d, d2 + 25.0d, d3 - 25.0d, 0.0f, -90.0f, 0.0f);
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
