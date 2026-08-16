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

/* JADX INFO: renamed from: com.boehmod.blockfront.qB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qB.class */
public class C0890qB extends AbstractC0858pW implements InterfaceC0919qe {

    /* JADX INFO: renamed from: lG */
    private static final float f4876lG = 100.0f;

    /* JADX INFO: renamed from: lH */
    private static final float f4877lH = 0.1f;

    /* JADX INFO: renamed from: lI */
    private static final float f4878lI = 1.0f;

    /* JADX INFO: renamed from: lJ */
    private static final float f4879lJ = 0.25f;

    /* JADX INFO: renamed from: qj */
    private static final int f4880qj = 2;

    /* JADX INFO: renamed from: qk */
    public int f4883qk;

    /* JADX INFO: renamed from: ql */
    public int f4884ql;

    /* JADX INFO: renamed from: ec */
    @NotNull
    private static final ResourceLocation f4875ec = C0532jO.m2378d("textures/misc/debug/mapeffect/mist.png");

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final MapCodec<C0890qB> f4881r = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("yPos").forGetter(c0890qB -> {
            return Integer.valueOf(c0890qB.f4883qk);
        }), Codec.INT.fieldOf("radius").forGetter(c0890qB2 -> {
            return Integer.valueOf(c0890qB2.f4884ql);
        })).apply(instance, (num, num2) -> {
            C0890qB c0890qB3 = new C0890qB(num.intValue());
            c0890qB3.f4884ql = num2.intValue();
            return c0890qB3;
        });
    });

    /* JADX INFO: renamed from: ed */
    @NotNull
    private static final ResourceLocation f4882ed = C0532jO.m2378d("textures/misc/world/floormist.png");

    public C0890qB() {
        this(0);
    }

    public C0890qB(int i) {
        this.f4884ql = 15;
        this.f4883qk = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4649a(int i, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, PoseStack poseStack, double d, double d2) {
        if (d % 2.0d == 0.0d && d2 % 2.0d == 0.0d) {
            float fClamp = 1.0f - Mth.clamp((Mth.sqrt((float) localPlayer.distanceToSqr(d, this.f4883qk, d2)) / f4876lG) * this.f4884ql, 0.1f, 1.0f);
            Vec3 vec3 = new Vec3(d, this.f4883qk + ((0.5f + fClamp) * 0.2f), d2);
            BlockPos blockPosContaining = BlockPos.containing(vec3);
            if (!C0875pn.m4352a((Level) clientLevel, blockPosContaining.getX(), blockPosContaining.getZ(), blockPosContaining.getY())) {
                C0129bt.m615a(poseStack, guiGraphics, f4882ed, vec3.x, vec3.y, vec3.z, 256.0f, 256.0f, fClamp * 0.25f, i, true);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623l.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        int iM6121cf = abstractC0863pbM2874a.m4089a().m6121cf();
        double x = localPlayer.getX();
        double z = localPlayer.getZ();
        for (int i = -this.f4884ql; i < this.f4884ql; i++) {
            for (int i2 = -this.f4884ql; i2 < this.f4884ql; i2++) {
                m4649a(iM6121cf, localPlayer, clientLevel, guiGraphics, poseStack, x + ((double) i), z + ((double) i2));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0930qp(Component.literal("Y Position"), () -> {
            return Integer.valueOf(this.f4883qk);
        }, num -> {
            this.f4883qk = num.intValue();
        }));
        objectArrayList.add(new C0930qp(Component.literal("Radius"), () -> {
            return Integer.valueOf(this.f4884ql);
        }, num2 -> {
            this.f4884ql = num2.intValue();
        }, 1, 256));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Mist: y=" + this.f4883qk + ", radius=" + this.f4884ql));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4875ec;
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

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
