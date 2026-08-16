package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qF.class */
public class C0894qF extends AbstractC0858pW implements InterfaceC0919qe, InterfaceC0920qf {

    /* JADX INFO: renamed from: eh */
    @NotNull
    private static final ResourceLocation f4926eh = C0532jO.m2378d("textures/misc/debug/mapeffect/artillery_gun.png");

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final MapCodec<C0894qF> f4927v = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0894qF -> {
            return Float.valueOf(c0894qF.f4944cU);
        }), Codec.INT.fieldOf("maxYaw").forGetter(c0894qF2 -> {
            return Integer.valueOf(c0894qF2.f4946qu);
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0894qF3 -> {
            return Optional.ofNullable(c0894qF3.f4936m != null ? C1272xL.m7225b(c0894qF3.f4936m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0894qF4 -> {
            return Optional.ofNullable(c0894qF4.f4937n != null ? C1272xL.m7223a(c0894qF4.f4937n.get()) : null);
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0894qF5 -> {
            return c0894qF5.f4938cl != null ? c0894qF5.f4938cl : "";
        }), ResourceLocation.CODEC.optionalFieldOf("commanderSound").forGetter(c0894qF6 -> {
            return Optional.ofNullable(c0894qF6.f4934o != null ? C1272xL.m7227a(c0894qF6.f4934o.get()) : null);
        })).apply(instance, (f, num, optional, optional2, str, optional3) -> {
            C0894qF c0894qF7 = new C0894qF();
            c0894qF7.f4944cU = f.floatValue();
            c0894qF7.f4946qu = num.intValue();
            optional.ifPresent(resourceLocation -> {
                c0894qF7.f4936m = C1272xL.m7226c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0894qF7.f4937n = C1272xL.m7224b(resourceLocation2);
            });
            if (!str.isEmpty()) {
                c0894qF7.f4938cl = str;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0894qF7.f4934o = C1272xL.m7228d(resourceLocation3);
            });
            return c0894qF7;
        });
    });

    /* JADX INFO: renamed from: qm */
    private static final int f4928qm = 20;

    /* JADX INFO: renamed from: qn */
    private static final int f4929qn = 10;

    /* JADX INFO: renamed from: qo */
    private static final int f4930qo = 10;

    /* JADX INFO: renamed from: lY */
    private static final float f4931lY = 0.4f;

    /* JADX INFO: renamed from: qp */
    private static final int f4932qp = 2;

    /* JADX INFO: renamed from: qq */
    private static final int f4933qq = 10;

    /* JADX INFO: renamed from: o */
    @Nullable
    public Supplier<SoundEvent> f4934o;

    /* JADX INFO: renamed from: a */
    @Nullable
    private BlockEntity f4935a;

    /* JADX INFO: renamed from: m */
    @Nullable
    private Supplier<? extends BlockEntityType<?>> f4936m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private Supplier<? extends Block> f4937n;

    /* JADX INFO: renamed from: cl */
    @Nullable
    private String f4938cl;

    /* JADX INFO: renamed from: qr */
    private int f4939qr;

    /* JADX INFO: renamed from: qs */
    private int f4940qs;

    /* JADX INFO: renamed from: qt */
    private int f4941qt;

    /* JADX INFO: renamed from: lZ */
    private float f4942lZ;

    /* JADX INFO: renamed from: ma */
    private float f4943ma;

    /* JADX INFO: renamed from: cU */
    public float f4944cU;

    /* JADX INFO: renamed from: gL */
    private boolean f4945gL;

    /* JADX INFO: renamed from: qu */
    private int f4946qu;

    public C0894qF() {
        this(Vec3.ZERO, C1293xg.f6977cB, C1295xi.f7329iu);
    }

    public C0894qF(@NotNull Vec3 vec3, @NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2) {
        super(vec3);
        this.f4935a = null;
        this.f4938cl = null;
        this.f4939qr = 0;
        this.f4940qs = 0;
        this.f4941qt = 0;
        this.f4943ma = 0.0f;
        this.f4944cU = 0.0f;
        this.f4945gL = false;
        this.f4946qu = 30;
        this.f4936m = supplier;
        this.f4937n = supplier2;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4935a == null && this.f4936m != null && this.f4937n != null) {
            this.f4935a = this.f4936m.get().create(BlockPos.ZERO, this.f4937n.get().defaultBlockState());
            BlockEntity blockEntity = this.f4935a;
            if (blockEntity instanceof C0712mj) {
                C0712mj c0712mj = (C0712mj) blockEntity;
                c0712mj.m3236bB();
                if (this.f4938cl != null) {
                    c0712mj.m3241p(this.f4938cl);
                }
            }
        }
        this.f4943ma = this.f4942lZ;
        if (this.f4942lZ == this.f4940qs) {
            int i = this.f4939qr;
            this.f4939qr = i - 1;
            if (i <= 0) {
                this.f4939qr = (10 + randomSource.nextInt(10)) * 20;
                this.f4940qs = randomSource.nextInt(this.f4946qu * 2) - this.f4946qu;
                BlockEntity blockEntity2 = this.f4935a;
                if (blockEntity2 instanceof C0712mj) {
                    ((C0712mj) blockEntity2).m3248q("move");
                }
                clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, (SoundEvent) C1312xz.f8122sn.get(), SoundSource.AMBIENT, 3.0f, 0.5f, false);
            }
        } else {
            this.f4942lZ = C1270xJ.m7161d(this.f4942lZ, this.f4940qs, 0.4f);
            if (this.f4942lZ == this.f4940qs) {
                this.f4941qt = 40;
                this.f4945gL = false;
                BlockEntity blockEntity3 = this.f4935a;
                if (blockEntity3 instanceof C0712mj) {
                    ((C0712mj) blockEntity3).m3248q("move");
                }
                clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, (SoundEvent) C1312xz.f8123so.get(), SoundSource.AMBIENT, 3.0f, 0.5f, false);
            }
        }
        if (this.f4941qt == 10 && this.f4934o != null) {
            clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, this.f4934o.get(), SoundSource.AMBIENT, 3.0f, 0.9f + (randomSource.nextFloat() * 0.2f), false);
        }
        int i2 = this.f4941qt;
        this.f4941qt = i2 - 1;
        if (i2 <= 0 && !this.f4945gL) {
            this.f4945gL = true;
            m4726b(minecraft, c0623l, localPlayer, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    private void m4726b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        InterfaceC0695mS interfaceC0695mSCreate;
        BlockEntity blockEntity = this.f4935a;
        if (blockEntity instanceof C0712mj) {
            ((C0712mj) blockEntity).m3248q("fire");
        }
        float f = this.f4944cU + this.f4942lZ;
        Vec3 vec3Add = this.f4593c.add(new Vec3(5.0d, 0.0d, 0.0d).yRot((f * 0.017453292f) - 1.5707964f));
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8809Fy.get(), SoundSource.AMBIENT, 6.0f, 0.3f, false);
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8051qU.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8052qV.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8386xr.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        }
        C0490iZ.m2216a(minecraft, c0623l, clientLevel, (ParticleOptions) C1309xw.f7886nW.get(), vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 40, 0.25f);
        C0490iZ.m2216a(minecraft, c0623l, clientLevel, ParticleTypes.CLOUD, vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 60, 0.25f);
        C0490iZ.m2216a(minecraft, c0623l, clientLevel, (ParticleOptions) C1309xw.f7866nC.get(), vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 60, 0.5f);
        C0432hU.m1989a(C0435hX.f2763m, localPlayer, this.f4593c, 80.0f);
        for (int i2 = 0; i2 < 12; i2++) {
            Vec3 vec3Add2 = this.f4593c.add(new Vec3(8.4f + (0.85f * i2), 0.0d, 0.0d).add(0.0d, 2.0d, 0.0d).yRot((f * 0.017453292f) - 1.5707964f));
            C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7866nC.get(), vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
        }
        Supplier<EntityType<? extends InterfaceC0695mS>> supplierM6876b = ((C1117uP) C1308xv.f7836mZ.get()).m6316a().m6876b();
        if (supplierM6876b != null && (interfaceC0695mSCreate = supplierM6876b.get().create(clientLevel)) != null) {
            Vec3 vec3Add3 = this.f4593c.add(0.0d, 2.0d, 0.0d);
            interfaceC0695mSCreate.mo3119a(vec3Add3, 2.0f, new ItemStack((ItemLike) C1308xv.f7836mZ.get()), -f, 0.0f);
            interfaceC0695mSCreate.setPos(vec3Add3);
            interfaceC0695mSCreate.setDeltaMovement(interfaceC0695mSCreate.getDeltaMovement().scale(4.0d));
            C0490iZ.m2213a((Entity) interfaceC0695mSCreate, clientLevel);
            clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, (SoundEvent) C1312xz.f8347wE.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f4935a == null) {
            return;
        }
        C0129bt.m635a(minecraft, clientLevel, poseStack, this.f4935a, this.f4593c.x, this.f4593c.y, this.f4593c.z, 0.0f, this.f4944cU + C1270xJ.m7170f(this.f4942lZ, this.f4943ma, f2), f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Artillery Gun: rotation=%.1f, yaw=%.1f (target=%d, maxYaw=%d)", Float.valueOf(this.f4944cU), Float.valueOf(this.f4942lZ), Integer.valueOf(this.f4940qs), Integer.valueOf(this.f4946qu))));
        list.add(Component.literal("Turn timer: " + this.f4939qr + ", Shoot timer: " + this.f4941qt + (this.f4945gL ? " (shot)" : "")));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0929qo(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.f4944cU);
        }, f -> {
            this.f4944cU = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0930qp(Component.literal("Max Yaw"), () -> {
            return Integer.valueOf(this.f4946qu);
        }, num -> {
            this.f4946qu = num.intValue();
        }, 0, 180));
        objectArrayList.add(new C0933qs(Component.literal("Animation"), () -> {
            return this.f4938cl != null ? this.f4938cl : "";
        }, str -> {
            this.f4938cl = str.isEmpty() ? null : str;
        }));
        objectArrayList.add(new C0932qr(Component.literal("Commander Sound"), () -> {
            if (this.f4934o != null) {
                return this.f4934o.get();
            }
            return null;
        }, soundEvent -> {
            this.f4934o = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4926eh;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aU */
    public float mo4682aU() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aV */
    public float mo4683aV() {
        return this.f4944cU;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aW */
    public float mo4684aW() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: a */
    public void mo4685a(float f, float f2, float f3) {
        this.f4944cU = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: g */
    public void mo4686g(@NotNull Vec3 vec3) {
        this.f4944cU = (float) Math.toDegrees(Math.atan2(vec3.x, vec3.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    @NotNull
    /* JADX INFO: renamed from: n */
    public Vec3 mo4687n() {
        double radians = Math.toRadians(this.f4944cU);
        return new Vec3(Math.sin(radians), 0.0d, Math.cos(radians));
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
        this.f4935a = null;
        this.f4939qr = 0;
        this.f4940qs = 0;
        this.f4941qt = 0;
        this.f4942lZ = 0.0f;
        this.f4943ma = 0.0f;
        this.f4945gL = false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_ENTITIES;
    }
}
