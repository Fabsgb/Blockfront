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

/* JADX INFO: renamed from: com.boehmod.blockfront.qD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qD.class */
public class C0892qD extends AbstractC0858pW implements InterfaceC0919qe {

    /* JADX INFO: renamed from: ef */
    @NotNull
    private static final ResourceLocation f4888ef = C0532jO.m2378d("textures/misc/debug/mapeffect/vehicle_path.png");

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final MapCodec<C0892qD> f4889t = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0973rf.f5444O.fieldOf("movablePath").forGetter(c0892qD -> {
            return c0892qD.f4890b;
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0892qD2 -> {
            return Optional.ofNullable(c0892qD2.f4906m != null ? C1272xL.m7225b(c0892qD2.f4906m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0892qD3 -> {
            return Optional.ofNullable(c0892qD3.f4907n != null ? C1272xL.m7223a(c0892qD3.f4907n.get()) : null);
        }), Codec.BOOL.fieldOf("pauseWhenComplete").forGetter(c0892qD4 -> {
            return Boolean.valueOf(c0892qD4.f4898gI);
        }), Codec.STRING.optionalFieldOf("animationOnFinish", "").forGetter(c0892qD5 -> {
            return c0892qD5.f4900ck != null ? c0892qD5.f4900ck : "";
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0892qD6 -> {
            return c0892qD6.f4909cl != null ? c0892qD6.f4909cl : "";
        }), ResourceLocation.CODEC.optionalFieldOf("sound").forGetter(c0892qD7 -> {
            return Optional.ofNullable(c0892qD7.f4901j != null ? C1272xL.m7227a(c0892qD7.f4901j.get()) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("soundPaused").forGetter(c0892qD8 -> {
            return Optional.ofNullable(c0892qD8.f4902k != null ? C1272xL.m7227a(c0892qD8.f4902k.get()) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("soundOnFinish").forGetter(c0892qD9 -> {
            return Optional.ofNullable(c0892qD9.f4903l != null ? C1272xL.m7227a(c0892qD9.f4903l.get()) : null);
        }), Codec.FLOAT.fieldOf("soundVolume").forGetter(c0892qD10 -> {
            return Float.valueOf(c0892qD10.f4896lO);
        })).apply(instance, (c0973rf, optional, optional2, bool, str, str2, optional3, optional4, optional5, f) -> {
            C0892qD c0892qD11 = new C0892qD();
            Iterator<Vec3> it = c0973rf.f5445aN.iterator();
            while (it.hasNext()) {
                c0892qD11.f4890b.m5519n(it.next());
            }
            c0892qD11.f4890b.m5521m(c0973rf.m5520aX());
            c0892qD11.f4890b.m5531E(c0973rf.m5530bF());
            c0892qD11.f4890b.m5533F(c0973rf.m5532bG());
            c0892qD11.f4890b.m5518Q(c0973rf.m5517bH());
            optional.ifPresent(resourceLocation -> {
                c0892qD11.f4906m = C1272xL.m7226c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0892qD11.f4907n = C1272xL.m7224b(resourceLocation2);
            });
            c0892qD11.f4898gI = bool.booleanValue();
            if (!str.isEmpty()) {
                c0892qD11.f4900ck = str;
            }
            if (!str2.isEmpty()) {
                c0892qD11.f4909cl = str2;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0892qD11.f4901j = C1272xL.m7228d(resourceLocation3);
            });
            optional4.ifPresent(resourceLocation4 -> {
                c0892qD11.f4902k = C1272xL.m7228d(resourceLocation4);
            });
            optional5.ifPresent(resourceLocation5 -> {
                c0892qD11.f4903l = C1272xL.m7228d(resourceLocation5);
            });
            c0892qD11.f4896lO = f.floatValue();
            return c0892qD11;
        });
    });

    /* JADX INFO: renamed from: b */
    public final C0973rf f4890b;

    /* JADX INFO: renamed from: fv */
    public float f4891fv;

    /* JADX INFO: renamed from: lK */
    public float f4892lK;

    /* JADX INFO: renamed from: lL */
    public float f4893lL;

    /* JADX INFO: renamed from: lM */
    public float f4894lM;

    /* JADX INFO: renamed from: lN */
    public float f4895lN;

    /* JADX INFO: renamed from: lO */
    public float f4896lO;

    /* JADX INFO: renamed from: gH */
    public boolean f4897gH;

    /* JADX INFO: renamed from: gI */
    public boolean f4898gI;

    /* JADX INFO: renamed from: gJ */
    public boolean f4899gJ;

    /* JADX INFO: renamed from: ck */
    @Nullable
    public String f4900ck;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Supplier<SoundEvent> f4901j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public Supplier<SoundEvent> f4902k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public Supplier<SoundEvent> f4903l;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0467iC f4904a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0467iC f4905b;

    /* JADX INFO: renamed from: m */
    @Nullable
    private Supplier<? extends BlockEntityType<?>> f4906m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private Supplier<? extends Block> f4907n;

    /* JADX INFO: renamed from: a */
    @Nullable
    private BlockEntity f4908a;

    /* JADX INFO: renamed from: cl */
    @Nullable
    private String f4909cl;

    public C0892qD() {
        this(C1293xg.f6948bY, C1295xi.f7302hT, 0.0f);
    }

    public C0892qD(@NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2, float f) {
        this.f4890b = new C0973rf();
        this.f4893lL = 0.0f;
        this.f4895lN = 0.0f;
        this.f4896lO = 1.5f;
        this.f4897gH = false;
        this.f4898gI = false;
        this.f4899gJ = false;
        this.f4900ck = null;
        this.f4901j = null;
        this.f4902k = null;
        this.f4903l = null;
        this.f4904a = null;
        this.f4905b = null;
        this.f4908a = null;
        this.f4909cl = null;
        this.f4906m = supplier;
        this.f4907n = supplier2;
        this.f4891fv = f;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    /* JADX INFO: renamed from: a */
    public static double m4664a(double d, double d2, double d3) {
        return d + ((d2 - d) * d3);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4908a == null && this.f4906m != null && this.f4907n != null) {
            this.f4908a = this.f4906m.get().create(BlockPos.ZERO, this.f4907n.get().defaultBlockState());
            BlockEntity blockEntity = this.f4908a;
            if (blockEntity instanceof C0712mj) {
                C0712mj c0712mj = (C0712mj) blockEntity;
                c0712mj.m3236bB();
                if (this.f4909cl != null) {
                    c0712mj.m3241p(this.f4909cl);
                }
            }
        }
        Vec3 vec3M5523v = this.f4890b.m5523v();
        Vec3 vec3 = this.f4890b.f5446c;
        if (this.f4890b.m5522u() == null || vec3M5523v == null) {
            return;
        }
        if (this.f4901j != null) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (this.f4904a == null || !soundManager.isActive(this.f4904a)) {
                C0467iC c0467iC = new C0467iC(this.f4890b, this.f4901j.get(), vec3, false, this.f4896lO, 1.0f);
                this.f4904a = c0467iC;
                soundManager.play(c0467iC);
            }
        }
        if (this.f4902k != null) {
            SoundManager soundManager2 = minecraft.getSoundManager();
            if (this.f4905b == null || !soundManager2.isActive(this.f4905b)) {
                C0467iC c0467iC2 = new C0467iC(this.f4890b, this.f4902k.get(), vec3, true, this.f4896lO, 1.0f);
                this.f4905b = c0467iC2;
                soundManager2.play(c0467iC2);
            }
        }
        this.f4893lL = this.f4892lK;
        this.f4895lN = this.f4894lM;
        if (!this.f4890b.m5524bo()) {
            this.f4897gH = false;
            Vec3 vec3Normalize = vec3M5523v.subtract(vec3).normalize();
            float degrees = (float) Math.toDegrees(Math.asin(-vec3Normalize.y));
            float fM7185I = C1270xJ.m7185I(((float) Math.toDegrees(Math.atan2(vec3Normalize.x, vec3Normalize.z))) - this.f4894lM);
            this.f4892lK += C1270xJ.m7185I(degrees - this.f4892lK) * 0.1f;
            this.f4894lM += fM7185I * 0.1f;
        } else {
            this.f4899gJ = true;
            if (!this.f4897gH) {
                this.f4897gH = true;
                if (this.f4903l != null) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, this.f4903l.get(), SoundSource.AMBIENT, 3.0f, 1.0f, false);
                }
            }
        }
        if (!this.f4898gI || !this.f4899gJ) {
            this.f4890b.m5526cT();
        }
        if (this.f4890b.m5527R()) {
            BlockEntity blockEntity2 = this.f4908a;
            if (blockEntity2 instanceof C0712mj) {
                C0712mj c0712mj2 = (C0712mj) blockEntity2;
                if (this.f4900ck != null) {
                    c0712mj2.m3248q(this.f4900ck);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f4908a == null) {
            return;
        }
        Vec3 vec3M5529a = this.f4890b.m5529a(f2);
        float fM7170f = C1270xJ.m7170f(this.f4892lK, this.f4893lL, f2);
        C0129bt.m635a(minecraft, clientLevel, poseStack, this.f4908a, vec3M5529a.x, vec3M5529a.y, vec3M5529a.z, -fM7170f, C1270xJ.m7170f(this.f4894lM, this.f4895lN, f2), f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        Vec3 vec3 = null;
        for (Vec3 vec4 : this.f4890b.f5445aN) {
            Object obj = "";
            int i = 65280;
            if (this.f4890b.m5523v().equals(vec4)) {
                obj = "_current";
                i = 16711680;
            }
            if (this.f4890b.m5522u().equals(vec4)) {
                obj = "_previous";
            }
            if (vec3 != null) {
                C0129bt.m574a(camera, poseStack, vec3, vec4, 1.0f, i);
            }
            C0129bt.m605a(poseStack, camera, guiGraphics, C0532jO.m2378d("textures/misc/debug/mapeffect/vehicle_path" + obj + ".png"), vec4, 64, false);
            vec3 = vec4;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        int size = this.f4890b.f5445aN.size();
        Vec3 vec3M5523v = this.f4890b.m5523v();
        int i = -1;
        if (vec3M5523v != null) {
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f4890b.f5445aN.get(i2).equals(vec3M5523v)) {
                    i = i2;
                    break;
                }
            }
        }
        list.add(Component.literal("Pathed Vehicle: point " + (i + 1) + "/" + size + (this.f4899gJ ? " (complete)" : "") + (this.f4890b.m5524bo() ? " (paused)" : "")));
        list.add(Component.literal(String.format("Rotation: pitch=%.1f, yaw=%.1f", Float.valueOf(this.f4892lK), Float.valueOf(this.f4894lM))));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4888ef;
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
        SoundManager soundManager = minecraft.getSoundManager();
        if (this.f4904a != null) {
            soundManager.stop(this.f4904a);
            this.f4904a = null;
        }
        if (this.f4905b != null) {
            soundManager.stop(this.f4905b);
            this.f4905b = null;
        }
        this.f4908a = null;
        this.f4899gJ = false;
        this.f4897gH = false;
        this.f4893lL = 0.0f;
        this.f4892lK = 0.0f;
        this.f4895lN = 0.0f;
        this.f4894lM = 0.0f;
        this.f4890b.m5528bd();
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
