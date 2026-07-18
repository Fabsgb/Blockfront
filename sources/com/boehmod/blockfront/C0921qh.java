package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qh.class */
public class C0921qh extends AbstractC0835pA implements InterfaceC0843pI {

    /* JADX INFO: renamed from: eh */
    @NotNull
    private static final ResourceLocation f4809eh = C0564jv.m2555d("textures/misc/debug/mapeffect/vehicle_path.png");

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final MapCodec<C0921qh> f4810t = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0896qI.f4714O.fieldOf("movablePath").forGetter(c0921qh -> {
            return c0921qh.f4811b;
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0921qh2 -> {
            return Optional.ofNullable(c0921qh2.f4827m != null ? C1292xo.m7898b(c0921qh2.f4827m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0921qh3 -> {
            return Optional.ofNullable(c0921qh3.f4828n != null ? C1292xo.m7896a(c0921qh3.f4828n.get()) : null);
        }), Codec.BOOL.fieldOf("pauseWhenComplete").forGetter(c0921qh4 -> {
            return Boolean.valueOf(c0921qh4.f4819go);
        }), Codec.STRING.optionalFieldOf("animationOnFinish", "").forGetter(c0921qh5 -> {
            return c0921qh5.f4821ca != null ? c0921qh5.f4821ca : "";
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0921qh6 -> {
            return c0921qh6.f4830cb != null ? c0921qh6.f4830cb : "";
        }), ResourceLocation.CODEC.optionalFieldOf("sound").forGetter(c0921qh7 -> {
            return Optional.ofNullable(c0921qh7.f4822j != null ? C1292xo.m7900a(c0921qh7.f4822j.get()) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("soundPaused").forGetter(c0921qh8 -> {
            return Optional.ofNullable(c0921qh8.f4823k != null ? C1292xo.m7900a(c0921qh8.f4823k.get()) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("soundOnFinish").forGetter(c0921qh9 -> {
            return Optional.ofNullable(c0921qh9.f4824l != null ? C1292xo.m7900a(c0921qh9.f4824l.get()) : null);
        }), Codec.FLOAT.fieldOf("soundVolume").forGetter(c0921qh10 -> {
            return Float.valueOf(c0921qh10.f4817kT);
        })).apply(instance, (c0896qI, optional, optional2, bool, str, str2, optional3, optional4, optional5, f) -> {
            C0921qh c0921qh11 = new C0921qh();
            Iterator<Vec3> it = c0896qI.f4715aG.iterator();
            while (it.hasNext()) {
                c0921qh11.f4811b.m4624n(it.next());
            }
            c0921qh11.f4811b.m4626n(c0896qI.m4625aR());
            c0921qh11.f4811b.m4636D(c0896qI.m4635bq());
            c0921qh11.f4811b.m4638E(c0896qI.m4637br());
            c0921qh11.f4811b.m4623P(c0896qI.m4622bx());
            optional.ifPresent(resourceLocation -> {
                c0921qh11.f4827m = C1292xo.m7899c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0921qh11.f4828n = C1292xo.m7897b(resourceLocation2);
            });
            c0921qh11.f4819go = bool.booleanValue();
            if (!str.isEmpty()) {
                c0921qh11.f4821ca = str;
            }
            if (!str2.isEmpty()) {
                c0921qh11.f4830cb = str2;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0921qh11.f4822j = C1292xo.m7901d(resourceLocation3);
            });
            optional4.ifPresent(resourceLocation4 -> {
                c0921qh11.f4823k = C1292xo.m7901d(resourceLocation4);
            });
            optional5.ifPresent(resourceLocation5 -> {
                c0921qh11.f4824l = C1292xo.m7901d(resourceLocation5);
            });
            c0921qh11.f4817kT = f.floatValue();
            return c0921qh11;
        });
    });

    /* JADX INFO: renamed from: b */
    public final C0896qI f4811b;

    /* JADX INFO: renamed from: fl */
    public float f4812fl;

    /* JADX INFO: renamed from: kP */
    public float f4813kP;

    /* JADX INFO: renamed from: kQ */
    public float f4814kQ;

    /* JADX INFO: renamed from: kR */
    public float f4815kR;

    /* JADX INFO: renamed from: kS */
    public float f4816kS;

    /* JADX INFO: renamed from: kT */
    public float f4817kT;

    /* JADX INFO: renamed from: gn */
    public boolean f4818gn;

    /* JADX INFO: renamed from: go */
    public boolean f4819go;

    /* JADX INFO: renamed from: gp */
    public boolean f4820gp;

    /* JADX INFO: renamed from: ca */
    @Nullable
    public String f4821ca;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Supplier<SoundEvent> f4822j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public Supplier<SoundEvent> f4823k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public Supplier<SoundEvent> f4824l;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0501il f4825a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0501il f4826b;

    /* JADX INFO: renamed from: m */
    @Nullable
    private Supplier<? extends BlockEntityType<?>> f4827m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private Supplier<? extends Block> f4828n;

    /* JADX INFO: renamed from: a */
    @Nullable
    private BlockEntity f4829a;

    /* JADX INFO: renamed from: cb */
    @Nullable
    private String f4830cb;

    public C0921qh() {
        this(C1216wJ.f6385bY, C1218wL.f6739hT, 0.0f);
    }

    public C0921qh(@NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2, float f) {
        this.f4811b = new C0896qI();
        this.f4814kQ = 0.0f;
        this.f4816kS = 0.0f;
        this.f4817kT = 1.5f;
        this.f4818gn = false;
        this.f4819go = false;
        this.f4820gp = false;
        this.f4821ca = null;
        this.f4822j = null;
        this.f4823k = null;
        this.f4824l = null;
        this.f4825a = null;
        this.f4826b = null;
        this.f4829a = null;
        this.f4830cb = null;
        this.f4827m = supplier;
        this.f4828n = supplier2;
        this.f4812fl = f;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    /* JADX INFO: renamed from: a */
    public static double m4801a(double d, double d2, double d3) {
        return d + ((d2 - d) * d3);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4829a == null && this.f4827m != null && this.f4828n != null) {
            this.f4829a = this.f4827m.get().create(BlockPos.ZERO, this.f4828n.get().defaultBlockState());
            BlockEntity blockEntity = this.f4829a;
            if (blockEntity instanceof C0636lN) {
                C0636lN c0636lN = (C0636lN) blockEntity;
                c0636lN.m2805bq();
                if (this.f4830cb != null) {
                    c0636lN.m2810p(this.f4830cb);
                }
            }
        }
        Vec3 vec3M4628u = this.f4811b.m4628u();
        Vec3 vec3 = this.f4811b.f4716c;
        if (this.f4811b.m4627t() == null || vec3M4628u == null) {
            return;
        }
        if (this.f4822j != null) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (this.f4825a == null || !soundManager.isActive(this.f4825a)) {
                C0501il c0501il = new C0501il(this.f4811b, this.f4822j.get(), vec3, false, this.f4817kT, 1.0f);
                this.f4825a = c0501il;
                soundManager.play(c0501il);
            }
        }
        if (this.f4823k != null) {
            SoundManager soundManager2 = minecraft.getSoundManager();
            if (this.f4826b == null || !soundManager2.isActive(this.f4826b)) {
                C0501il c0501il2 = new C0501il(this.f4811b, this.f4823k.get(), vec3, true, this.f4817kT, 1.0f);
                this.f4826b = c0501il2;
                soundManager2.play(c0501il2);
            }
        }
        this.f4814kQ = this.f4813kP;
        this.f4816kS = this.f4815kR;
        if (!this.f4811b.m4629be()) {
            this.f4818gn = false;
            Vec3 vec3Normalize = vec3M4628u.subtract(vec3).normalize();
            float degrees = (float) Math.toDegrees(Math.asin(-vec3Normalize.y));
            float fM7858F = C1290xm.m7858F(((float) Math.toDegrees(Math.atan2(vec3Normalize.x, vec3Normalize.z))) - this.f4815kR);
            this.f4813kP += C1290xm.m7858F(degrees - this.f4813kP) * 0.1f;
            this.f4815kR += fM7858F * 0.1f;
        } else {
            this.f4820gp = true;
            if (!this.f4818gn) {
                this.f4818gn = true;
                if (this.f4824l != null) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, this.f4824l.get(), SoundSource.AMBIENT, 3.0f, 1.0f, false);
                }
            }
        }
        if (!this.f4819go || !this.f4820gp) {
            this.f4811b.m4631cH();
        }
        if (this.f4811b.m4632P()) {
            BlockEntity blockEntity2 = this.f4829a;
            if (blockEntity2 instanceof C0636lN) {
                C0636lN c0636lN2 = (C0636lN) blockEntity2;
                if (this.f4821ca != null) {
                    c0636lN2.m2817q(this.f4821ca);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f4829a == null) {
            return;
        }
        Vec3 vec3M4634a = this.f4811b.m4634a(f2);
        float fM7843e = C1290xm.m7843e(this.f4813kP, this.f4814kQ, f2);
        C0119bk.m533a(minecraft, clientLevel, poseStack, this.f4829a, vec3M4634a.x, vec3M4634a.y, vec3M4634a.z, -fM7843e, C1290xm.m7843e(this.f4815kR, this.f4816kS, f2), f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        Vec3 vec3 = null;
        for (Vec3 vec32 : this.f4811b.f4715aG) {
            Object obj = "";
            int i = 65280;
            if (this.f4811b.m4628u().equals(vec32)) {
                obj = "_current";
                i = 16711680;
            }
            if (this.f4811b.m4627t().equals(vec32)) {
                obj = "_previous";
            }
            if (vec3 != null) {
                C0119bk.m474a(camera, poseStack, vec3, vec32, 1.0f, i);
            }
            C0119bk.m505a(poseStack, camera, guiGraphics, C0564jv.m2555d("textures/misc/debug/mapeffect/vehicle_path" + obj + ".png"), vec32, 64, false);
            vec3 = vec32;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        int size = this.f4811b.f4715aG.size();
        Vec3 vec3M4628u = this.f4811b.m4628u();
        int i = -1;
        if (vec3M4628u != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!this.f4811b.f4715aG.get(i2).equals(vec3M4628u)) {
                    i2++;
                } else {
                    i = i2;
                    break;
                }
            }
        }
        list.add(Component.literal("Pathed Vehicle: point " + (i + 1) + "/" + size + (this.f4820gp ? " (complete)" : "") + (this.f4811b.m4629be() ? " (paused)" : "")));
        list.add(Component.literal(String.format("Rotation: pitch=%.1f, yaw=%.1f", Float.valueOf(this.f4813kP), Float.valueOf(this.f4815kR))));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4809eh;
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
        SoundManager soundManager = minecraft.getSoundManager();
        if (this.f4825a != null) {
            soundManager.stop(this.f4825a);
            this.f4825a = null;
        }
        if (this.f4826b != null) {
            soundManager.stop(this.f4826b);
            this.f4826b = null;
        }
        this.f4829a = null;
        this.f4820gp = false;
        this.f4818gn = false;
        this.f4814kQ = 0.0f;
        this.f4813kP = 0.0f;
        this.f4816kS = 0.0f;
        this.f4815kR = 0.0f;
        this.f4811b.m4633bf();
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
