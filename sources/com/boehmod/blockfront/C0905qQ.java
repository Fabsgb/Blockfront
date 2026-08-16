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

/* JADX INFO: renamed from: com.boehmod.blockfront.qQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qQ.class */
public class C0905qQ extends AbstractC0858pW implements InterfaceC0919qe, InterfaceC0920qf {

    /* JADX INFO: renamed from: ev */
    @NotNull
    private static final ResourceLocation f5055ev = C0532jO.m2378d("textures/misc/debug/mapeffect/vehicle_tank.png");

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final MapCodec<C0905qQ> f5056G = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0905qQ -> {
            return Float.valueOf(c0905qQ.f5063cU);
        }), ResourceLocation.CODEC.optionalFieldOf("entityType").forGetter(c0905qQ2 -> {
            return Optional.ofNullable(c0905qQ2.f5058m != null ? C1272xL.m7225b(c0905qQ2.f5058m) : null);
        }), ResourceLocation.CODEC.optionalFieldOf("blockType").forGetter(c0905qQ3 -> {
            return Optional.ofNullable(c0905qQ3.f5059n != null ? C1272xL.m7223a(c0905qQ3.f5059n.get()) : null);
        }), Codec.STRING.optionalFieldOf("animation", "").forGetter(c0905qQ4 -> {
            return c0905qQ4.f5060cl != null ? c0905qQ4.f5060cl : "";
        }), ResourceLocation.CODEC.optionalFieldOf("texture").forGetter(c0905qQ5 -> {
            return Optional.ofNullable(c0905qQ5.f5061dk);
        }), Codec.BOOL.optionalFieldOf("bypassCulling", false).forGetter(c0905qQ6 -> {
            return Boolean.valueOf(c0905qQ6.f5062gO);
        })).apply(instance, (f, optional, optional2, str, optional3, bool) -> {
            C0905qQ c0905qQ7 = new C0905qQ();
            c0905qQ7.f5063cU = f.floatValue();
            optional.ifPresent(resourceLocation -> {
                c0905qQ7.f5058m = C1272xL.m7226c(resourceLocation);
            });
            optional2.ifPresent(resourceLocation2 -> {
                c0905qQ7.f5059n = C1272xL.m7224b(resourceLocation2);
            });
            if (!str.isEmpty()) {
                c0905qQ7.f5060cl = str;
            }
            optional3.ifPresent(resourceLocation3 -> {
                c0905qQ7.f5061dk = resourceLocation3;
            });
            c0905qQ7.f5062gO = bool.booleanValue();
            return c0905qQ7;
        });
    });

    /* JADX INFO: renamed from: a */
    @Nullable
    private BlockEntity f5057a;

    /* JADX INFO: renamed from: m */
    @Nullable
    private Supplier<? extends BlockEntityType<?>> f5058m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private Supplier<? extends Block> f5059n;

    /* JADX INFO: renamed from: cl */
    @Nullable
    private String f5060cl;

    /* JADX INFO: renamed from: dk */
    @Nullable
    private ResourceLocation f5061dk;

    /* JADX INFO: renamed from: gO */
    private boolean f5062gO;

    /* JADX INFO: renamed from: cU */
    public float f5063cU;

    public C0905qQ() {
        this(Vec3.ZERO, C1293xg.f6984cI, C1295xi.f7338iD);
    }

    public C0905qQ(@NotNull Vec3 vec3, @NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2) {
        super(vec3);
        this.f5057a = null;
        this.f5060cl = null;
        this.f5061dk = null;
        this.f5062gO = false;
        this.f5063cU = 0.0f;
        this.f5058m = supplier;
        this.f5059n = supplier2;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f5057a == null && this.f5058m != null && this.f5059n != null) {
            this.f5057a = this.f5058m.get().create(BlockPos.ZERO, this.f5059n.get().defaultBlockState());
            BlockEntity blockEntity = this.f5057a;
            if (blockEntity instanceof C0712mj) {
                C0712mj c0712mj = (C0712mj) blockEntity;
                c0712mj.m3236bB();
                if (this.f5062gO) {
                    c0712mj.m3237bC();
                }
                if (this.f5060cl != null) {
                    String[] strArrSplit = this.f5060cl.split(",");
                    c0712mj.m3241p(strArrSplit[strArrSplit.length - 1].trim());
                    for (int i = 0; i < strArrSplit.length - 1; i++) {
                        c0712mj.m3248q(strArrSplit[i].trim());
                    }
                    c0712mj.m3242c(this.f4593c);
                }
                if (this.f5061dk != null) {
                    c0712mj.m3245f(this.f5061dk);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public void m4961f(@NotNull ResourceLocation resourceLocation) {
        this.f5061dk = resourceLocation;
    }

    @Nullable
    /* JADX INFO: renamed from: o */
    public ResourceLocation m4962o() {
        return this.f5061dk;
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f5057a == null) {
            return;
        }
        C0129bt.m635a(minecraft, clientLevel, poseStack, this.f5057a, this.f4593c.x, this.f4593c.y, this.f4593c.z, 0.0f, this.f5063cU, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Positioned Vehicle: rotation=%.1f", Float.valueOf(this.f5063cU))));
        if (this.f5060cl != null) {
            list.add(Component.literal("Animation: " + this.f5060cl));
        }
        if (this.f5061dk != null) {
            list.add(Component.literal("Texture: " + String.valueOf(this.f5061dk)));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0929qo(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.f5063cU);
        }, f -> {
            this.f5063cU = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0933qs(Component.literal("Animation"), () -> {
            return this.f5060cl != null ? this.f5060cl : "";
        }, str -> {
            this.f5060cl = str.isEmpty() ? null : str;
        }));
        objectArrayList.add(new C0933qs(Component.literal("Texture"), () -> {
            return this.f5061dk != null ? this.f5061dk.toString() : "";
        }, str2 -> {
            this.f5061dk = str2.isEmpty() ? null : ResourceLocation.parse(str2);
        }));
        objectArrayList.add(new C0925qk(Component.literal("Bypass Culling"), () -> {
            return Boolean.valueOf(this.f5062gO);
        }, bool -> {
            this.f5062gO = bool.booleanValue();
            this.f5057a = null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5055ev;
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
        return this.f5063cU;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aW */
    public float mo4684aW() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: a */
    public void mo4685a(float f, float f2, float f3) {
        this.f5063cU = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: g */
    public void mo4686g(@NotNull Vec3 vec3) {
        this.f5063cU = (float) Math.toDegrees(Math.atan2(vec3.x, vec3.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    @NotNull
    /* JADX INFO: renamed from: n */
    public Vec3 mo4687n() {
        double radians = Math.toRadians(this.f5063cU);
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
        if (this.f5057a != null) {
            BlockEntity blockEntity = this.f5057a;
            if (blockEntity instanceof C0712mj) {
                ((C0712mj) blockEntity).m3244s().forEach(soundInstance -> {
                    minecraft.getSoundManager().stop(soundInstance);
                });
            }
            this.f5057a = null;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_ENTITIES;
    }
}
