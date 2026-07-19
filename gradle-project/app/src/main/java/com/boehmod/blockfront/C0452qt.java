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

/* JADX INFO: renamed from: com.boehmod.blockfront.qt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qt.class */
public class C0452qt extends pA implements pI, pJ {

    @NotNull
    private static final ResourceLocation ew = C0265jv.d("textures/misc/debug/mapeffect/vehicle_tank.png");

    @NotNull
    public static final MapCodec<C0452qt> F = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0452qt -> {
            return Float.valueOf(c0452qt.cO);
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0452qt2 -> {
            return Optional.ofNullable(c0452qt2.m != null ? C0636xo.m1696b(c0452qt2.m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0452qt3 -> {
            return Optional.ofNullable(c0452qt3.n != null ? C0636xo.a(c0452qt3.n.get()) : null);
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0452qt4 -> {
            return c0452qt4.cb != null ? c0452qt4.cb : "";
        }), ResourceLocation.CODEC.optionalFieldOf("texture").forGetter(c0452qt5 -> {
            return Optional.ofNullable(c0452qt5.dk);
        }), Codec.BOOL.optionalFieldOf("bypassCulling", false).forGetter(c0452qt6 -> {
            return Boolean.valueOf(c0452qt6.gu);
        })).apply(instance, (f, optional, optional2, str, optional3, bool) -> {
            C0452qt c0452qt7 = new C0452qt();
            c0452qt7.cO = f.floatValue();
            optional.ifPresent(resourceLocation -> {
                c0452qt7.m = C0636xo.c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0452qt7.n = C0636xo.b(resourceLocation2);
            });
            if (!str.isEmpty()) {
                c0452qt7.cb = str;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0452qt7.dk = resourceLocation3;
            });
            c0452qt7.gu = bool.booleanValue();
            return c0452qt7;
        });
    });

    @Nullable
    private BlockEntity a;

    @Nullable
    private Supplier<? extends BlockEntityType<?>> m;

    @Nullable
    private Supplier<? extends Block> n;

    @Nullable
    private String cb;

    @Nullable
    private ResourceLocation dk;
    private boolean gu;
    public float cO;

    public C0452qt() {
        this(Vec3.ZERO, wJ.cI, wL.iD);
    }

    public C0452qt(@NotNull Vec3 vec3, @NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2) {
        super(vec3);
        this.a = null;
        this.cb = null;
        this.dk = null;
        this.gu = false;
        this.cO = 0.0f;
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
                if (this.gu) {
                    lNVar.br();
                }
                if (this.cb != null) {
                    String[] strArrSplit = this.cb.split(",");
                    lNVar.p(strArrSplit[strArrSplit.length - 1].trim());
                    for (int i = 0; i < strArrSplit.length - 1; i++) {
                        lNVar.q(strArrSplit[i].trim());
                    }
                    lNVar.c(this.c);
                }
                if (this.dk != null) {
                    lNVar.b(this.dk);
                }
            }
        }
    }

    public void b(@NotNull ResourceLocation resourceLocation) {
        this.dk = resourceLocation;
    }

    @Nullable
    public ResourceLocation n() {
        return this.dk;
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.a == null) {
            return;
        }
        C0040bk.a(minecraft, clientLevel, poseStack, this.a, this.c.x, this.c.y, this.c.z, 0.0f, this.cO, f2);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Positioned Vehicle: rotation=%.1f", Float.valueOf(this.cO))));
        if (this.cb != null) {
            list.add(Component.literal("Animation: " + this.cb));
        }
        if (this.dk != null) {
            list.add(Component.literal("Texture: " + String.valueOf(this.dk)));
        }
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
        objectArrayList.add(new pW(Component.literal("Animation"), () -> {
            return this.cb != null ? this.cb : "";
        }, str -> {
            this.cb = str.isEmpty() ? null : str;
        }));
        objectArrayList.add(new pW(Component.literal("Texture"), () -> {
            return this.dk != null ? this.dk.toString() : "";
        }, str2 -> {
            this.dk = str2.isEmpty() ? null : ResourceLocation.parse(str2);
        }));
        objectArrayList.add(new pO(Component.literal("Bypass Culling"), () -> {
            return Boolean.valueOf(this.gu);
        }, bool -> {
            this.gu = bool.booleanValue();
            this.a = null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ew;
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
        if (this.a != null) {
            BlockEntity blockEntity = this.a;
            if (blockEntity instanceof lN) {
                ((lN) blockEntity).q().forEach(soundInstance -> {
                    minecraft.getSoundManager().stop(soundInstance);
                });
            }
            this.a = null;
        }
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_ENTITIES;
    }
}
