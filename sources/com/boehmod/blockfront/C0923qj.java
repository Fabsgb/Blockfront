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

/* JADX INFO: renamed from: com.boehmod.blockfront.qj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qj.class */
public class C0923qj extends AbstractC0835pA implements InterfaceC0843pI, InterfaceC0844pJ {

    /* JADX INFO: renamed from: ej */
    @NotNull
    private static final ResourceLocation f4846ej = C0564jv.m2555d("textures/misc/debug/mapeffect/artillery_gun.png");

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final MapCodec<C0923qj> f4847v = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0923qj -> {
            return Float.valueOf(c0923qj.f4864cO);
        }), Codec.INT.fieldOf("maxYaw").forGetter(c0923qj2 -> {
            return Integer.valueOf(c0923qj2.f4866ov);
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0923qj3 -> {
            return Optional.ofNullable(c0923qj3.f4856m != null ? C1292xo.m7898b(c0923qj3.f4856m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0923qj4 -> {
            return Optional.ofNullable(c0923qj4.f4857n != null ? C1292xo.m7896a(c0923qj4.f4857n.get()) : null);
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0923qj5 -> {
            return c0923qj5.f4858cb != null ? c0923qj5.f4858cb : "";
        }), ResourceLocation.CODEC.optionalFieldOf("commanderSound").forGetter(c0923qj6 -> {
            return Optional.ofNullable(c0923qj6.f4854o != null ? C1292xo.m7900a(c0923qj6.f4854o.get()) : null);
        })).apply(instance, (f, num, optional, optional2, str, optional3) -> {
            C0923qj c0923qj7 = new C0923qj();
            c0923qj7.f4864cO = f.floatValue();
            c0923qj7.f4866ov = num.intValue();
            optional.ifPresent(resourceLocation -> {
                c0923qj7.f4856m = C1292xo.m7899c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0923qj7.f4857n = C1292xo.m7897b(resourceLocation2);
            });
            if (!str.isEmpty()) {
                c0923qj7.f4858cb = str;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0923qj7.f4854o = C1292xo.m7901d(resourceLocation3);
            });
            return c0923qj7;
        });
    });

    /* JADX INFO: renamed from: on */
    private static final int f4848on = 20;

    /* JADX INFO: renamed from: oo */
    private static final int f4849oo = 10;

    /* JADX INFO: renamed from: op */
    private static final int f4850op = 10;

    /* JADX INFO: renamed from: lc */
    private static final float f4851lc = 0.4f;

    /* JADX INFO: renamed from: oq */
    private static final int f4852oq = 2;

    /* JADX INFO: renamed from: or */
    private static final int f4853or = 10;

    /* JADX INFO: renamed from: o */
    @Nullable
    public Supplier<SoundEvent> f4854o;

    /* JADX INFO: renamed from: a */
    @Nullable
    private BlockEntity f4855a;

    /* JADX INFO: renamed from: m */
    @Nullable
    private Supplier<? extends BlockEntityType<?>> f4856m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private Supplier<? extends Block> f4857n;

    /* JADX INFO: renamed from: cb */
    @Nullable
    private String f4858cb;

    /* JADX INFO: renamed from: os */
    private int f4859os;

    /* JADX INFO: renamed from: ot */
    private int f4860ot;

    /* JADX INFO: renamed from: ou */
    private int f4861ou;

    /* JADX INFO: renamed from: ga */
    private float f4862ga;

    /* JADX INFO: renamed from: ld */
    private float f4863ld;

    /* JADX INFO: renamed from: cO */
    public float f4864cO;

    /* JADX INFO: renamed from: gr */
    private boolean f4865gr;

    /* JADX INFO: renamed from: ov */
    private int f4866ov;

    public C0923qj() {
        this(Vec3.ZERO, C1216wJ.f6414cB, C1218wL.f6766iu);
    }

    public C0923qj(@NotNull Vec3 vec3, @NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2) {
        super(vec3);
        this.f4855a = null;
        this.f4858cb = null;
        this.f4859os = 0;
        this.f4860ot = 0;
        this.f4861ou = 0;
        this.f4863ld = 0.0f;
        this.f4864cO = 0.0f;
        this.f4865gr = false;
        this.f4866ov = 30;
        this.f4856m = supplier;
        this.f4857n = supplier2;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4855a == null && this.f4856m != null && this.f4857n != null) {
            this.f4855a = this.f4856m.get().create(BlockPos.ZERO, this.f4857n.get().defaultBlockState());
            BlockEntity blockEntity = this.f4855a;
            if (blockEntity instanceof C0636lN) {
                C0636lN c0636lN = (C0636lN) blockEntity;
                c0636lN.m2805bq();
                if (this.f4858cb != null) {
                    c0636lN.m2810p(this.f4858cb);
                }
            }
        }
        this.f4863ld = this.f4862ga;
        if (this.f4862ga == this.f4860ot) {
            int i = this.f4859os;
            this.f4859os = i - 1;
            if (i <= 0) {
                this.f4859os = (10 + randomSource.nextInt(10)) * 20;
                this.f4860ot = randomSource.nextInt(this.f4866ov * 2) - this.f4866ov;
                BlockEntity blockEntity2 = this.f4855a;
                if (blockEntity2 instanceof C0636lN) {
                    ((C0636lN) blockEntity2).m2817q("move");
                }
                clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, (SoundEvent) C1280xc.f7711sm.get(), SoundSource.AMBIENT, 3.0f, 0.5f, false);
            }
        } else {
            this.f4862ga = C1290xm.m7835d(this.f4862ga, this.f4860ot, 0.4f);
            if (this.f4862ga == this.f4860ot) {
                this.f4861ou = 40;
                this.f4865gr = false;
                BlockEntity blockEntity3 = this.f4855a;
                if (blockEntity3 instanceof C0636lN) {
                    ((C0636lN) blockEntity3).m2817q("move");
                }
                clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, (SoundEvent) C1280xc.f7712sn.get(), SoundSource.AMBIENT, 3.0f, 0.5f, false);
            }
        }
        if (this.f4861ou == 10 && this.f4854o != null) {
            clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, this.f4854o.get(), SoundSource.AMBIENT, 3.0f, 0.9f + (randomSource.nextFloat() * 0.2f), false);
        }
        int i2 = this.f4861ou;
        this.f4861ou = i2 - 1;
        if (i2 <= 0 && !this.f4865gr) {
            this.f4865gr = true;
            m4854b(minecraft, c0622l, localPlayer, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    private void m4854b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        InterfaceC0724mw interfaceC0724mwCreate;
        BlockEntity blockEntity = this.f4855a;
        if (blockEntity instanceof C0636lN) {
            ((C0636lN) blockEntity).m2817q("fire");
        }
        float f = this.f4864cO + this.f4862ga;
        Vec3 vec3Add = this.f4464c.add(new Vec3(5.0d, 0.0d, 0.0d).yRot((f * 0.017453292f) - 1.5707964f));
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f8395Fu.get(), SoundSource.AMBIENT, 6.0f, 0.3f, false);
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f7639qS.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f7640qT.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f7973xo.get(), SoundSource.AMBIENT, 15.0f, 1.0f, false);
        }
        C0470iG.m2124a(minecraft, c0622l, clientLevel, (ParticleOptions) C1232wZ.f7321nW.get(), vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 40, 0.25f);
        C0470iG.m2124a(minecraft, c0622l, clientLevel, ParticleTypes.CLOUD, vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 60, 0.25f);
        C0470iG.m2124a(minecraft, c0622l, clientLevel, (ParticleOptions) C1232wZ.f7301nC.get(), vec3Add.add(0.0d, 0.10000000149011612d, 0.0d), 1.0f, 5.0f, 60, 0.5f);
        C0415hE.m1963a(C0418hH.f2670m, localPlayer, this.f4464c, 80.0f);
        for (int i2 = 0; i2 < 12; i2++) {
            Vec3 vec3Add2 = this.f4464c.add(new Vec3(8.4f + (0.85f * i2), 0.0d, 0.0d).add(0.0d, 2.0d, 0.0d).yRot((f * 0.017453292f) - 1.5707964f));
            C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7301nC.get(), vec3Add2.x, vec3Add2.y, vec3Add2.z, 0.0d, 0.0d, 0.0d);
        }
        Supplier<EntityType<? extends InterfaceC0724mw>> supplierM6223b = ((C1144ur) C1231wY.f7271mZ.get()).m6347a().m6223b();
        if (supplierM6223b != null && (interfaceC0724mwCreate = supplierM6223b.get().create(clientLevel)) != null) {
            Vec3 vec3Add3 = this.f4464c.add(0.0d, 2.0d, 0.0d);
            interfaceC0724mwCreate.mo3284a(vec3Add3, 2.0f, new ItemStack((ItemLike) C1231wY.f7271mZ.get()), -f, 0.0f);
            interfaceC0724mwCreate.setPos(vec3Add3);
            interfaceC0724mwCreate.setDeltaMovement(interfaceC0724mwCreate.getDeltaMovement().scale(4.0d));
            C0470iG.m2121a((Entity) interfaceC0724mwCreate, clientLevel);
            clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, (SoundEvent) C1280xc.f7934wB.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f4855a == null) {
            return;
        }
        C0119bk.m533a(minecraft, clientLevel, poseStack, this.f4855a, this.f4464c.x, this.f4464c.y, this.f4464c.z, 0.0f, this.f4864cO + C1290xm.m7843e(this.f4862ga, this.f4863ld, f2), f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Artillery Gun: rotation=%.1f, yaw=%.1f (target=%d, maxYaw=%d)", Float.valueOf(this.f4864cO), Float.valueOf(this.f4862ga), Integer.valueOf(this.f4860ot), Integer.valueOf(this.f4866ov))));
        list.add(Component.literal("Turn timer: " + this.f4859os + ", Shoot timer: " + this.f4861ou + (this.f4865gr ? " (shot)" : "")));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0853pS(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.f4864cO);
        }, f -> {
            this.f4864cO = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0854pT(Component.literal("Max Yaw"), () -> {
            return Integer.valueOf(this.f4866ov);
        }, num -> {
            this.f4866ov = num.intValue();
        }, 0, 180));
        objectArrayList.add(new C0857pW(Component.literal("Animation"), () -> {
            return this.f4858cb != null ? this.f4858cb : "";
        }, str -> {
            this.f4858cb = str.isEmpty() ? null : str;
        }));
        objectArrayList.add(new C0856pV(Component.literal("Commander Sound"), () -> {
            if (this.f4854o != null) {
                return this.f4854o.get();
            }
            return null;
        }, soundEvent -> {
            this.f4854o = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4846ej;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aO */
    public float mo4271aO() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aP */
    public float mo4272aP() {
        return this.f4864cO;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aQ */
    public float mo4273aQ() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: a */
    public void mo4274a(float f, float f2, float f3) {
        this.f4864cO = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: g */
    public void mo4275g(@NotNull Vec3 vec3) {
        this.f4864cO = (float) Math.toDegrees(Math.atan2(vec3.x, vec3.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    @NotNull
    /* JADX INFO: renamed from: m */
    public Vec3 mo4276m() {
        double radians = Math.toRadians(this.f4864cO);
        return new Vec3(Math.sin(radians), 0.0d, Math.cos(radians));
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
        this.f4855a = null;
        this.f4859os = 0;
        this.f4860ot = 0;
        this.f4861ou = 0;
        this.f4862ga = 0.0f;
        this.f4863ld = 0.0f;
        this.f4865gr = false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_ENTITIES;
    }
}
