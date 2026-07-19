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

/* JADX INFO: renamed from: com.boehmod.blockfront.qj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qj.class */
public class C0442qj extends pA implements pI, pJ {

    @NotNull
    private static final ResourceLocation ej = C0265jv.d("textures/misc/debug/mapeffect/artillery_gun.png");

    @NotNull
    public static final MapCodec<C0442qj> v = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0442qj -> {
            return Float.valueOf(c0442qj.cO);
        }), Codec.INT.fieldOf("maxYaw").forGetter(c0442qj2 -> {
            return Integer.valueOf(c0442qj2.ov);
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0442qj3 -> {
            return Optional.ofNullable(c0442qj3.m != null ? C0636xo.m1696b(c0442qj3.m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0442qj4 -> {
            return Optional.ofNullable(c0442qj4.n != null ? C0636xo.a(c0442qj4.n.get()) : null);
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0442qj5 -> {
            return c0442qj5.cb != null ? c0442qj5.cb : "";
        }), ResourceLocation.CODEC.optionalFieldOf("commanderSound").forGetter(c0442qj6 -> {
            return Optional.ofNullable(c0442qj6.o != null ? C0636xo.a(c0442qj6.o.get()) : null);
        })).apply(instance, (f, num, optional, optional2, str, optional3) -> {
            C0442qj c0442qj7 = new C0442qj();
            c0442qj7.cO = f.floatValue();
            c0442qj7.ov = num.intValue();
            optional.ifPresent(resourceLocation -> {
                c0442qj7.m = C0636xo.c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0442qj7.n = C0636xo.b(resourceLocation2);
            });
            if (!str.isEmpty()) {
                c0442qj7.cb = str;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0442qj7.o = C0636xo.d(resourceLocation3);
            });
            return c0442qj7;
        });
    });
    private static final int on = 20;
    private static final int oo = 10;
    private static final int op = 10;
    private static final float lc = 0.4f;
    private static final int oq = 2;
    private static final int or = 10;

    @Nullable
    public Supplier<SoundEvent> o;

    @Nullable
    private BlockEntity a;

    @Nullable
    private Supplier<? extends BlockEntityType<?>> m;

    @Nullable
    private Supplier<? extends Block> n;

    @Nullable
    private String cb;
    private int os;
    private int ot;
    private int ou;
    private float ga;
    private float ld;
    public float cO;
    private boolean gr;
    private int ov;

    public C0442qj() {
        this(Vec3.ZERO, wJ.cB, wL.iu);
    }

    public C0442qj(@NotNull Vec3 vec3, @NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2) {
        super(vec3);
        this.a = null;
        this.cb = null;
        this.os = 0;
        this.ot = 0;
        this.ou = 0;
        this.ld = 0.0f;
        this.cO = 0.0f;
        this.gr = false;
        this.ov = 30;
        this.m = supplier;
        this.n = supplier2;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.a == null && this.m != null && this.n != null) {
            this.a = this.m.get().create(BlockPos.ZERO, this.n.get().defaultBlockState());
            BlockEntity blockEntity = this.a;
            if (blockEntity instanceof lN) {
                lN lNVar = (lN) blockEntity;
                lNVar.bq();
                if (this.cb != null) {
                    lNVar.p(this.cb);
                }
            }
        }
        this.ld = this.ga;
        if (this.ga == this.ot) {
            int i = this.os;
            this.os = i - 1;
            if (i <= 0) {
                this.os = (10 + randomSource.nextInt(10)) * 20;
                this.ot = randomSource.nextInt(this.ov * 2) - this.ov;
                BlockEntity blockEntity2 = this.a;
                if (blockEntity2 instanceof lN) {
                    ((lN) blockEntity2).q("move");
                }
                clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, (SoundEvent) C0624xc.sm.get(), SoundSource.AMBIENT, 3.0f, 0.5f, false);
            }
        } else {
            this.ga = C0634xm.d(this.ga, this.ot, 0.4f);
            if (this.ga == this.ot) {
                this.ou = 40;
                this.gr = false;
                BlockEntity blockEntity3 = this.a;
                if (blockEntity3 instanceof lN) {
                    ((lN) blockEntity3).q("move");
                }
                clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, (SoundEvent) C0624xc.sn.get(), SoundSource.AMBIENT, 3.0f, 0.5f, false);
            }
        }
        if (this.ou == 10 && this.o != null) {
            clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, this.o.get(), SoundSource.AMBIENT, 3.0f, 0.9f + (randomSource.nextFloat() * 0.2f), false);
        }
        int i2 = this.ou;
        this.ou = i2 - 1;
        if (i2 <= 0 && !this.gr) {
            this.gr = true;
            b(minecraft, c0297l, localPlayer, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        InterfaceC0347mw interfaceC0347mwCreate;
        BlockEntity blockEntity = this.a;
        if (blockEntity instanceof lN) {
            ((lN) blockEntity).q("fire");
        }
        float f = this.cO + this.ga;
        Vec3 vec3Add = this.c.add(new Vec3(5.0d, 0.0d, 0.0d).yRot((f * 0.017453292f) - 1.5707964f));
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.Fu.get(), SoundSource.AMBIENT, 6.0f, 0.3f, false);
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.qS.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.qT.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.xo.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        }
        iG.a(minecraft, c0297l, clientLevel, (ParticleOptions) wZ.nW.get(), vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 40, 0.25f);
        iG.a(minecraft, c0297l, clientLevel, ParticleTypes.CLOUD, vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 60, 0.25f);
        iG.a(minecraft, c0297l, clientLevel, (ParticleOptions) wZ.nC.get(), vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 60, 0.5f);
        hE.a(hH.m, localPlayer, this.c, 80.0f);
        for (int i2 = 0; i2 < 12; i2++) {
            Vec3 vec3Add2 = this.c.add(new Vec3(8.4f + (0.85f * i2), 0.0d, 0.0d).add(0.0d, 2.0d, 0.0d).yRot((f * 0.017453292f) - 1.5707964f));
            iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nC.get(), vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
        }
        Supplier<EntityType<? extends InterfaceC0347mw>> supplierB = ((C0558ur) wY.mZ.get()).m1210a().b();
        if (supplierB != null && (interfaceC0347mwCreate = supplierB.get().create(clientLevel)) != null) {
            Vec3 vec3Add3 = this.c.add(0.0d, 2.0d, 0.0d);
            interfaceC0347mwCreate.a(vec3Add3, 2.0f, new ItemStack((ItemLike) wY.mZ.get()), -f, 0.0f);
            interfaceC0347mwCreate.setPos(vec3Add3);
            interfaceC0347mwCreate.setDeltaMovement(interfaceC0347mwCreate.getDeltaMovement().scale(4.0d));
            iG.a((Entity) interfaceC0347mwCreate, clientLevel);
            clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, (SoundEvent) C0624xc.wB.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.a == null) {
            return;
        }
        C0040bk.a(minecraft, clientLevel, poseStack, this.a, this.c.x, this.c.y, this.c.z, 0.0f, this.cO + C0634xm.e(this.ga, this.ld, f2), f2);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Artillery Gun: rotation=%.1f, yaw=%.1f (target=%d, maxYaw=%d)", Float.valueOf(this.cO), Float.valueOf(this.ga), Integer.valueOf(this.ot), Integer.valueOf(this.ov))));
        list.add(Component.literal("Turn timer: " + this.os + ", Shoot timer: " + this.ou + (this.gr ? " (shot)" : "")));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pS(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.cO);
        }, f -> {
            this.cO = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new pT(Component.literal("Max Yaw"), () -> {
            return Integer.valueOf(this.ov);
        }, num -> {
            this.ov = num.intValue();
        }, 0, 180));
        objectArrayList.add(new pW(Component.literal("Animation"), () -> {
            return this.cb != null ? this.cb : "";
        }, str -> {
            this.cb = str.isEmpty() ? null : str;
        }));
        objectArrayList.add(new pV(Component.literal("Commander Sound"), () -> {
            if (this.o != null) {
                return this.o.get();
            }
            return null;
        }, soundEvent -> {
            this.o = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ej;
    }

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aO() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aP() {
        return this.cO;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aQ() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.pJ
    public void a(float f, float f2, float f3) {
        this.cO = f2;
    }

    @Override // com.boehmod.blockfront.pJ
    public void g(@NotNull Vec3 vec3) {
        this.cO = (float) Math.toDegrees(Math.atan2(vec3.x, vec3.z));
    }

    @Override // com.boehmod.blockfront.pJ
    @NotNull
    public Vec3 m() {
        double radians = Math.toRadians(this.cO);
        return new Vec3(Math.sin(radians), 0.0d, Math.cos(radians));
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.a = null;
        this.os = 0;
        this.ot = 0;
        this.ou = 0;
        this.ga = 0.0f;
        this.ld = 0.0f;
        this.gr = false;
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_ENTITIES;
    }
}
