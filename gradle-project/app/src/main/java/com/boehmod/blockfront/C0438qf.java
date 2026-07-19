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

/* JADX INFO: renamed from: com.boehmod.blockfront.qf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qf.class */
public class C0438qf extends pA implements pI {
    private static final float kL = 100.0f;
    private static final float kM = 0.1f;
    private static final float kN = 1.0f;
    private static final float kO = 0.25f;
    private static final int ok = 2;
    public int ol;
    public int om;

    @NotNull
    private static final ResourceLocation ee = C0265jv.d("textures/misc/debug/mapeffect/mist.png");

    @NotNull
    public static final MapCodec<C0438qf> r = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("yPos").forGetter(c0438qf -> {
            return Integer.valueOf(c0438qf.ol);
        }), Codec.INT.fieldOf("radius").forGetter(c0438qf2 -> {
            return Integer.valueOf(c0438qf2.om);
        })).apply(instance, (num, num2) -> {
            C0438qf c0438qf3 = new C0438qf(num.intValue());
            c0438qf3.om = num2.intValue();
            return c0438qf3;
        });
    });

    @NotNull
    private static final ResourceLocation ef = C0265jv.d("textures/misc/world/floormist.png");

    public C0438qf() {
        this(0);
    }

    public C0438qf(int i) {
        this.om = 15;
        this.ol = i;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @OnlyIn(Dist.CLIENT)
    private void a(int i, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, PoseStack poseStack, double d, double d2) {
        if (d % 2.0d == 0.0d && d2 % 2.0d == 0.0d) {
            float fClamp = 1.0f - Mth.clamp((Mth.sqrt((float) localPlayer.distanceToSqr(d, this.ol, d2)) / kL) * this.om, 0.1f, 1.0f);
            Vec3 vec3 = new Vec3(d, this.ol + ((0.5f + fClamp) * 0.2f), d2);
            BlockPos blockPosContaining = BlockPos.containing(vec3);
            if (!oR.a((Level) clientLevel, blockPosContaining.getX(), blockPosContaining.getZ(), blockPosContaining.getY())) {
                C0040bk.a(poseStack, guiGraphics, ef, vec3.x, vec3.y, vec3.z, 256.0f, 256.0f, fClamp * 0.25f, i, true);
            }
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        oF<?, ?, ?> oFVarM591a = c0297l.m591a();
        if (oFVarM591a == null) {
            return;
        }
        int iBQ = oFVarM591a.m767a().bQ();
        double x = localPlayer.getX();
        double z = localPlayer.getZ();
        for (int i = -this.om; i < this.om; i++) {
            for (int i2 = -this.om; i2 < this.om; i2++) {
                a(iBQ, localPlayer, clientLevel, guiGraphics, poseStack, x + ((double) i), z + ((double) i2));
            }
        }
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pT(Component.literal("Y Position"), () -> {
            return Integer.valueOf(this.ol);
        }, num -> {
            this.ol = num.intValue();
        }));
        objectArrayList.add(new pT(Component.literal("Radius"), () -> {
            return Integer.valueOf(this.om);
        }, num2 -> {
            this.om = num2.intValue();
        }, 1, 256));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Mist: y=" + this.ol + ", radius=" + this.om));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ee;
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

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
