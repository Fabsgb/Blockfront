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

/* JADX INFO: renamed from: com.boehmod.blockfront.qh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qh.class */
public class C0440qh extends pA implements pI {

    @NotNull
    private static final ResourceLocation eh = C0265jv.d("textures/misc/debug/mapeffect/vehicle_path.png");

    @NotNull
    public static final MapCodec<C0440qh> t = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(qI.O.fieldOf("movablePath").forGetter(c0440qh -> {
            return c0440qh.b;
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0440qh2 -> {
            return Optional.ofNullable(c0440qh2.m != null ? C0636xo.m1696b(c0440qh2.m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0440qh3 -> {
            return Optional.ofNullable(c0440qh3.n != null ? C0636xo.a(c0440qh3.n.get()) : null);
        }), Codec.BOOL.fieldOf("pauseWhenComplete").forGetter(c0440qh4 -> {
            return Boolean.valueOf(c0440qh4.go);
        }), Codec.STRING.optionalFieldOf("animationOnFinish", "").forGetter(c0440qh5 -> {
            return c0440qh5.ca != null ? c0440qh5.ca : "";
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0440qh6 -> {
            return c0440qh6.cb != null ? c0440qh6.cb : "";
        }), ResourceLocation.CODEC.optionalFieldOf("sound").forGetter(c0440qh7 -> {
            return Optional.ofNullable(c0440qh7.j != null ? C0636xo.a(c0440qh7.j.get()) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("soundPaused").forGetter(c0440qh8 -> {
            return Optional.ofNullable(c0440qh8.k != null ? C0636xo.a(c0440qh8.k.get()) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("soundOnFinish").forGetter(c0440qh9 -> {
            return Optional.ofNullable(c0440qh9.l != null ? C0636xo.a(c0440qh9.l.get()) : null);
        }), Codec.FLOAT.fieldOf("soundVolume").forGetter(c0440qh10 -> {
            return Float.valueOf(c0440qh10.kT);
        })).apply(instance, (qIVar, optional, optional2, bool, str, str2, optional3, optional4, optional5, f) -> {
            C0440qh c0440qh11 = new C0440qh();
            Iterator<Vec3> it = qIVar.aG.iterator();
            while (it.hasNext()) {
                c0440qh11.b.n(it.next());
            }
            c0440qh11.b.n(qIVar.aR());
            c0440qh11.b.D(qIVar.bq());
            c0440qh11.b.E(qIVar.br());
            c0440qh11.b.P(qIVar.bx());
            optional.ifPresent(resourceLocation -> {
                c0440qh11.m = C0636xo.c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0440qh11.n = C0636xo.b(resourceLocation2);
            });
            c0440qh11.go = bool.booleanValue();
            if (!str.isEmpty()) {
                c0440qh11.ca = str;
            }
            if (!str2.isEmpty()) {
                c0440qh11.cb = str2;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0440qh11.j = C0636xo.d(resourceLocation3);
            });
            optional4.ifPresent(resourceLocation4 -> {
                c0440qh11.k = C0636xo.d(resourceLocation4);
            });
            optional5.ifPresent(resourceLocation5 -> {
                c0440qh11.l = C0636xo.d(resourceLocation5);
            });
            c0440qh11.kT = f.floatValue();
            return c0440qh11;
        });
    });
    public final qI b;
    public float fl;
    public float kP;
    public float kQ;
    public float kR;
    public float kS;
    public float kT;
    public boolean gn;
    public boolean go;
    public boolean gp;

    @Nullable
    public String ca;

    @Nullable
    public Supplier<SoundEvent> j;

    @Nullable
    public Supplier<SoundEvent> k;

    @Nullable
    public Supplier<SoundEvent> l;

    @Nullable
    private C0228il a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private C0228il f292b;

    @Nullable
    private Supplier<? extends BlockEntityType<?>> m;

    @Nullable
    private Supplier<? extends Block> n;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private BlockEntity f293a;

    @Nullable
    private String cb;

    public C0440qh() {
        this(wJ.bY, wL.hT, 0.0f);
    }

    public C0440qh(@NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2, float f) {
        this.b = new qI();
        this.kQ = 0.0f;
        this.kS = 0.0f;
        this.kT = 1.5f;
        this.gn = false;
        this.go = false;
        this.gp = false;
        this.ca = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.a = null;
        this.f292b = null;
        this.f293a = null;
        this.cb = null;
        this.m = supplier;
        this.n = supplier2;
        this.fl = f;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public static double a(double d, double d2, double d3) {
        return d + ((d2 - d) * d3);
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f293a == null && this.m != null && this.n != null) {
            this.f293a = this.m.get().create(BlockPos.ZERO, this.n.get().defaultBlockState());
            BlockEntity blockEntity = this.f293a;
            if (blockEntity instanceof lN) {
                lN lNVar = (lN) blockEntity;
                lNVar.bq();
                if (this.cb != null) {
                    lNVar.p(this.cb);
                }
            }
        }
        Vec3 vec3U = this.b.u();
        Vec3 vec3 = this.b.c;
        if (this.b.t() == null || vec3U == null) {
            return;
        }
        if (this.j != null) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (this.a == null || !soundManager.isActive(this.a)) {
                C0228il c0228il = new C0228il(this.b, this.j.get(), vec3, false, this.kT, 1.0f);
                this.a = c0228il;
                soundManager.play(c0228il);
            }
        }
        if (this.k != null) {
            SoundManager soundManager2 = minecraft.getSoundManager();
            if (this.f292b == null || !soundManager2.isActive(this.f292b)) {
                C0228il c0228il2 = new C0228il(this.b, this.k.get(), vec3, true, this.kT, 1.0f);
                this.f292b = c0228il2;
                soundManager2.play(c0228il2);
            }
        }
        this.kQ = this.kP;
        this.kS = this.kR;
        if (!this.b.be()) {
            this.gn = false;
            Vec3 vec3Normalize = vec3U.subtract(vec3).normalize();
            float degrees = (float) Math.toDegrees(Math.asin(-vec3Normalize.y));
            float F = C0634xm.F(((float) Math.toDegrees(Math.atan2(vec3Normalize.x, vec3Normalize.z))) - this.kR);
            this.kP += C0634xm.F(degrees - this.kP) * 0.1f;
            this.kR += F * 0.1f;
        } else {
            this.gp = true;
            if (!this.gn) {
                this.gn = true;
                if (this.l != null) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, this.l.get(), SoundSource.AMBIENT, 3.0f, 1.0f, false);
                }
            }
        }
        if (!this.go || !this.gp) {
            this.b.cH();
        }
        if (this.b.P()) {
            BlockEntity blockEntity2 = this.f293a;
            if (blockEntity2 instanceof lN) {
                lN lNVar2 = (lN) blockEntity2;
                if (this.ca != null) {
                    lNVar2.q(this.ca);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f293a == null) {
            return;
        }
        Vec3 vec3A = this.b.a(f2);
        float fE = C0634xm.e(this.kP, this.kQ, f2);
        C0040bk.a(minecraft, clientLevel, poseStack, this.f293a, vec3A.x, vec3A.y, vec3A.z, -fE, C0634xm.e(this.kR, this.kS, f2), f2);
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        Vec3 vec3 = null;
        for (Vec3 vec32 : this.b.aG) {
            Object obj = "";
            int i = 65280;
            if (this.b.u().equals(vec32)) {
                obj = "_current";
                i = 16711680;
            }
            if (this.b.t().equals(vec32)) {
                obj = "_previous";
            }
            if (vec3 != null) {
                C0040bk.a(camera, poseStack, vec3, vec32, 1.0f, i);
            }
            C0040bk.a(poseStack, camera, guiGraphics, C0265jv.d("textures/misc/debug/mapeffect/vehicle_path" + obj + ".png"), vec32, 64, false);
            vec3 = vec32;
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        int size = this.b.aG.size();
        Vec3 vec3U = this.b.u();
        int i = -1;
        if (vec3U != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!this.b.aG.get(i2).equals(vec3U)) {
                    i2++;
                } else {
                    i = i2;
                    break;
                }
            }
        }
        list.add(Component.literal("Pathed Vehicle: point " + (i + 1) + "/" + size + (this.gp ? " (complete)" : "") + (this.b.be() ? " (paused)" : "")));
        list.add(Component.literal(String.format("Rotation: pitch=%.1f, yaw=%.1f", Float.valueOf(this.kP), Float.valueOf(this.kR))));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eh;
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
        SoundManager soundManager = minecraft.getSoundManager();
        if (this.a != null) {
            soundManager.stop(this.a);
            this.a = null;
        }
        if (this.f292b != null) {
            soundManager.stop(this.f292b);
            this.f292b = null;
        }
        this.f293a = null;
        this.gp = false;
        this.gn = false;
        this.kQ = 0.0f;
        this.kP = 0.0f;
        this.kS = 0.0f;
        this.kR = 0.0f;
        this.b.bf();
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
