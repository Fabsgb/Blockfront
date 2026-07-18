package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qu.class */
public class C0934qu extends AbstractC0835pA {

    /* JADX INFO: renamed from: ex */
    @NotNull
    private static final ResourceLocation f4968ex = C0564jv.m2555d("textures/misc/debug/mapeffect/random_explosion.png");

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final MapCodec<C0934qu> f4969G = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0836pB.f4471D.fieldOf("startPos").forGetter(c0934qu -> {
            return c0934qu.f4971l;
        }), C0836pB.f4471D.fieldOf("endPos").forGetter(c0934qu2 -> {
            return c0934qu2.f4972m;
        }), Codec.INT.optionalFieldOf("explodeTimeMax", 200).forGetter(c0934qu3 -> {
            return Integer.valueOf(c0934qu3.f4970oG);
        })).apply(instance, (vec2, vec22, num) -> {
            C0934qu c0934qu4 = new C0934qu(vec2, vec22);
            c0934qu4.f4970oG = Math.max(1, num.intValue());
            return c0934qu4;
        });
    });

    /* JADX INFO: renamed from: oG */
    private int f4970oG;

    /* JADX INFO: renamed from: l */
    private Vec2 f4971l;

    /* JADX INFO: renamed from: m */
    private Vec2 f4972m;

    /* JADX INFO: renamed from: oH */
    private int f4973oH;

    public C0934qu() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0934qu(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
        this.f4970oG = 200;
        this.f4973oH = ThreadLocalRandom.current().nextInt(this.f4970oG);
        this.f4971l = vec2;
        this.f4972m = vec22;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4973oH;
        this.f4973oH = i - 1;
        if (i <= 0) {
            this.f4973oH = randomSource.nextInt(this.f4970oG);
            m5071a(minecraft, c0622l, randomSource, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5071a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        Vec2 vec2 = new Vec2(this.f4971l.x + (randomSource.nextFloat() * (this.f4972m.x - this.f4971l.x)), this.f4971l.y + (randomSource.nextFloat() * (this.f4972m.y - this.f4971l.y)));
        if (clientLevel.isLoaded(new BlockPos((int) vec2.x, 255, (int) vec2.y))) {
            Vec3 vec3 = new Vec3(vec2.x, 255.0d, vec2.y);
            C0722mu.m3269a(minecraft, c0622l, clientLevel, EnumC0786oE.ARTILLERY_EXPLOSION, clientLevel.clip(new ClipContext(vec3, vec3.subtract(0.0d, 255.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, CollisionContext.empty())).getLocation());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.f4971l.x, 255.0d, this.f4971l.y, this.f4972m.x, 255.0d, this.f4972m.y, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0858pX(Component.literal("Start Position"), () -> {
            return this.f4971l;
        }, vec2 -> {
            this.f4971l = vec2;
        }));
        objectArrayList.add(new C0858pX(Component.literal("End Position"), () -> {
            return this.f4972m;
        }, vec22 -> {
            this.f4972m = vec22;
        }));
        objectArrayList.add(new C0854pT(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.f4970oG);
        }, num -> {
            this.f4970oG = num.intValue();
        }, 1, 72000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Random Explosion: " + this.f4971l.x + ", " + this.f4971l.y + " -> " + this.f4972m.x + ", " + this.f4972m.y));
        list.add(Component.literal("Next explosion in: " + this.f4973oH + " / " + this.f4970oG + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4968ex;
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
        this.f4973oH = randomSource.nextInt(this.f4970oG);
    }
}
