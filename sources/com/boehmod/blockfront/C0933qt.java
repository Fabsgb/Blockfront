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
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qt.class */
public class C0933qt extends AbstractC0835pA implements InterfaceC0843pI, InterfaceC0844pJ {

    /* JADX INFO: renamed from: ew */
    @NotNull
    private static final ResourceLocation f4959ew = C0564jv.m2555d("textures/misc/debug/mapeffect/vehicle_tank.png");

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final MapCodec<C0933qt> f4960F = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0933qt -> {
            return Float.valueOf(c0933qt.f4967cO);
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0933qt2 -> {
            return Optional.ofNullable(c0933qt2.f4962m != null ? C1292xo.m7898b(c0933qt2.f4962m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0933qt3 -> {
            return Optional.ofNullable(c0933qt3.f4963n != null ? C1292xo.m7896a(c0933qt3.f4963n.get()) : null);
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0933qt4 -> {
            return c0933qt4.f4964cb != null ? c0933qt4.f4964cb : "";
        }), ResourceLocation.CODEC.optionalFieldOf("texture").forGetter(c0933qt5 -> {
            return Optional.ofNullable(c0933qt5.f4965dk);
        }), Codec.BOOL.optionalFieldOf("bypassCulling", false).forGetter(c0933qt6 -> {
            return Boolean.valueOf(c0933qt6.f4966gu);
        })).apply(instance, (f, optional, optional2, str, optional3, bool) -> {
            C0933qt c0933qt7 = new C0933qt();
            c0933qt7.f4967cO = f.floatValue();
            optional.ifPresent(resourceLocation -> {
                c0933qt7.f4962m = C1292xo.m7899c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0933qt7.f4963n = C1292xo.m7897b(resourceLocation2);
            });
            if (!str.isEmpty()) {
                c0933qt7.f4964cb = str;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0933qt7.f4965dk = resourceLocation3;
            });
            c0933qt7.f4966gu = bool.booleanValue();
            return c0933qt7;
        });
    });

    /* JADX INFO: renamed from: a */
    @Nullable
    private BlockEntity f4961a;

    /* JADX INFO: renamed from: m */
    @Nullable
    private Supplier<? extends BlockEntityType<?>> f4962m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private Supplier<? extends Block> f4963n;

    /* JADX INFO: renamed from: cb */
    @Nullable
    private String f4964cb;

    /* JADX INFO: renamed from: dk */
    @Nullable
    private ResourceLocation f4965dk;

    /* JADX INFO: renamed from: gu */
    private boolean f4966gu;

    /* JADX INFO: renamed from: cO */
    public float f4967cO;

    public C0933qt() {
        this(Vec3.ZERO, C1216wJ.f6421cI, C1218wL.f6775iD);
    }

    public C0933qt(@NotNull Vec3 vec3, @NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2) {
        super(vec3);
        this.f4961a = null;
        this.f4964cb = null;
        this.f4965dk = null;
        this.f4966gu = false;
        this.f4967cO = 0.0f;
        this.f4962m = supplier;
        this.f4963n = supplier2;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4961a == null && this.f4962m != null && this.f4963n != null) {
            this.f4961a = this.f4962m.get().create(BlockPos.ZERO, this.f4963n.get().defaultBlockState());
            BlockEntity blockEntity = this.f4961a;
            if (blockEntity instanceof C0636lN) {
                C0636lN c0636lN = (C0636lN) blockEntity;
                c0636lN.m2805bq();
                if (this.f4966gu) {
                    c0636lN.m2806br();
                }
                if (this.f4964cb != null) {
                    String[] strArrSplit = this.f4964cb.split(",");
                    c0636lN.m2810p(strArrSplit[strArrSplit.length - 1].trim());
                    for (int i = 0; i < strArrSplit.length - 1; i++) {
                        c0636lN.m2817q(strArrSplit[i].trim());
                    }
                    c0636lN.m2811c(this.f4464c);
                }
                if (this.f4965dk != null) {
                    c0636lN.m2814b(this.f4965dk);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5049b(@NotNull ResourceLocation resourceLocation) {
        this.f4965dk = resourceLocation;
    }

    @Nullable
    /* JADX INFO: renamed from: n */
    public ResourceLocation m5050n() {
        return this.f4965dk;
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f4961a == null) {
            return;
        }
        C0119bk.m533a(minecraft, clientLevel, poseStack, this.f4961a, this.f4464c.x, this.f4464c.y, this.f4464c.z, 0.0f, this.f4967cO, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Positioned Vehicle: rotation=%.1f", Float.valueOf(this.f4967cO))));
        if (this.f4964cb != null) {
            list.add(Component.literal("Animation: " + this.f4964cb));
        }
        if (this.f4965dk != null) {
            list.add(Component.literal("Texture: " + String.valueOf(this.f4965dk)));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0853pS(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.f4967cO);
        }, f -> {
            this.f4967cO = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0857pW(Component.literal("Animation"), () -> {
            return this.f4964cb != null ? this.f4964cb : "";
        }, str -> {
            this.f4964cb = str.isEmpty() ? null : str;
        }));
        objectArrayList.add(new C0857pW(Component.literal("Texture"), () -> {
            return this.f4965dk != null ? this.f4965dk.toString() : "";
        }, str2 -> {
            this.f4965dk = str2.isEmpty() ? null : ResourceLocation.parse(str2);
        }));
        objectArrayList.add(new C0849pO(Component.literal("Bypass Culling"), () -> {
            return Boolean.valueOf(this.f4966gu);
        }, bool -> {
            this.f4966gu = bool.booleanValue();
            this.f4961a = null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4959ew;
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
        return this.f4967cO;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aQ */
    public float mo4273aQ() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: a */
    public void mo4274a(float f, float f2, float f3) {
        this.f4967cO = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: g */
    public void mo4275g(@NotNull Vec3 vec3) {
        this.f4967cO = (float) Math.toDegrees(Math.atan2(vec3.x, vec3.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    @NotNull
    /* JADX INFO: renamed from: m */
    public Vec3 mo4276m() {
        double radians = Math.toRadians(this.f4967cO);
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
        if (this.f4961a != null) {
            BlockEntity blockEntity = this.f4961a;
            if (blockEntity instanceof C0636lN) {
                ((C0636lN) blockEntity).m2813q().forEach(soundInstance -> {
                    minecraft.getSoundManager().stop(soundInstance);
                });
            }
            this.f4961a = null;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_ENTITIES;
    }
}
