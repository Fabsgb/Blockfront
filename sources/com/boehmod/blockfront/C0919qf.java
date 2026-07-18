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
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qf.class */
public class C0919qf extends AbstractC0835pA implements InterfaceC0843pI {

    /* JADX INFO: renamed from: kL */
    private static final float f4797kL = 100.0f;

    /* JADX INFO: renamed from: kM */
    private static final float f4798kM = 0.1f;

    /* JADX INFO: renamed from: kN */
    private static final float f4799kN = 1.0f;

    /* JADX INFO: renamed from: kO */
    private static final float f4800kO = 0.25f;

    /* JADX INFO: renamed from: ok */
    private static final int f4801ok = 2;

    /* JADX INFO: renamed from: ol */
    public int f4804ol;

    /* JADX INFO: renamed from: om */
    public int f4805om;

    /* JADX INFO: renamed from: ee */
    @NotNull
    private static final ResourceLocation f4796ee = C0564jv.m2555d("textures/misc/debug/mapeffect/mist.png");

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final MapCodec<C0919qf> f4802r = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("yPos").forGetter(c0919qf -> {
            return Integer.valueOf(c0919qf.f4804ol);
        }), Codec.INT.fieldOf("radius").forGetter(c0919qf2 -> {
            return Integer.valueOf(c0919qf2.f4805om);
        })).apply(instance, (num, num2) -> {
            C0919qf c0919qf3 = new C0919qf(num.intValue());
            c0919qf3.f4805om = num2.intValue();
            return c0919qf3;
        });
    });

    /* JADX INFO: renamed from: ef */
    @NotNull
    private static final ResourceLocation f4803ef = C0564jv.m2555d("textures/misc/world/floormist.png");

    public C0919qf() {
        this(0);
    }

    public C0919qf(int i) {
        this.f4805om = 15;
        this.f4804ol = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4788a(int i, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, PoseStack poseStack, double d, double d2) {
        if (d % 2.0d == 0.0d && d2 % 2.0d == 0.0d) {
            float fClamp = 1.0f - Mth.clamp((Mth.sqrt((float) localPlayer.distanceToSqr(d, this.f4804ol, d2)) / f4797kL) * this.f4805om, 0.1f, 1.0f);
            Vec3 vec3 = new Vec3(d, this.f4804ol + ((0.5f + fClamp) * 0.2f), d2);
            BlockPos blockPosContaining = BlockPos.containing(vec3);
            if (!C0799oR.m3916a((Level) clientLevel, blockPosContaining.getX(), blockPosContaining.getZ(), blockPosContaining.getY())) {
                C0119bk.m514a(poseStack, guiGraphics, f4803ef, vec3.x, vec3.y, vec3.z, 256.0f, 256.0f, fClamp * 0.25f, i, true);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622l.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        int iM5633bQ = abstractC0787oFM2688a.m3653a().m5633bQ();
        double x = localPlayer.getX();
        double z = localPlayer.getZ();
        for (int i = -this.f4805om; i < this.f4805om; i++) {
            for (int i2 = -this.f4805om; i2 < this.f4805om; i2++) {
                m4788a(iM5633bQ, localPlayer, clientLevel, guiGraphics, poseStack, x + ((double) i), z + ((double) i2));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0854pT(Component.literal("Y Position"), () -> {
            return Integer.valueOf(this.f4804ol);
        }, num -> {
            this.f4804ol = num.intValue();
        }));
        objectArrayList.add(new C0854pT(Component.literal("Radius"), () -> {
            return Integer.valueOf(this.f4805om);
        }, num2 -> {
            this.f4805om = num2.intValue();
        }, 1, 256));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Mist: y=" + this.f4804ol + ", radius=" + this.f4805om));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4796ee;
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

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
