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

/* JADX INFO: renamed from: com.boehmod.blockfront.qu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qu.class */
public class C0453qu extends pA {

    @NotNull
    private static final ResourceLocation ex = C0265jv.d("textures/misc/debug/mapeffect/random_explosion.png");

    @NotNull
    public static final MapCodec<C0453qu> G = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(pB.D.fieldOf("startPos").forGetter(c0453qu -> {
            return c0453qu.l;
        }), pB.D.fieldOf("endPos").forGetter(c0453qu2 -> {
            return c0453qu2.m;
        }), Codec.INT.optionalFieldOf("explodeTimeMax", 200).forGetter(c0453qu3 -> {
            return Integer.valueOf(c0453qu3.oG);
        })).apply(instance, (vec2, vec22, num) -> {
            C0453qu c0453qu4 = new C0453qu(vec2, vec22);
            c0453qu4.oG = Math.max(1, num.intValue());
            return c0453qu4;
        });
    });
    private int oG;
    private Vec2 l;
    private Vec2 m;
    private int oH;

    public C0453qu() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0453qu(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
        this.oG = 200;
        this.oH = ThreadLocalRandom.current().nextInt(this.oG);
        this.l = vec2;
        this.m = vec22;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.oH;
        this.oH = i - 1;
        if (i <= 0) {
            this.oH = randomSource.nextInt(this.oG);
            a(minecraft, c0297l, randomSource, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        Vec2 vec2 = new Vec2(this.l.x + (randomSource.nextFloat() * (this.m.x - this.l.x)), this.l.y + (randomSource.nextFloat() * (this.m.y - this.l.y)));
        if (clientLevel.isLoaded(new BlockPos((int) vec2.x, 255, (int) vec2.y))) {
            Vec3 vec3 = new Vec3(vec2.x, 255.0d, vec2.y);
            C0345mu.a(minecraft, c0297l, clientLevel, oE.ARTILLERY_EXPLOSION, clientLevel.clip(new ClipContext(vec3, vec3.subtract(0.0d, 255.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, CollisionContext.empty())).getLocation());
        }
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.l.x, 255.0d, this.l.y, this.m.x, 255.0d, this.m.y, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pX(Component.literal("Start Position"), () -> {
            return this.l;
        }, vec2 -> {
            this.l = vec2;
        }));
        objectArrayList.add(new pX(Component.literal("End Position"), () -> {
            return this.m;
        }, vec22 -> {
            this.m = vec22;
        }));
        objectArrayList.add(new pT(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.oG);
        }, num -> {
            this.oG = num.intValue();
        }, 1, 72000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Random Explosion: " + this.l.x + ", " + this.l.y + " -> " + this.m.x + ", " + this.m.y));
        list.add(Component.literal("Next explosion in: " + this.oH + " / " + this.oG + " ticks"));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ex;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.oH = randomSource.nextInt(this.oG);
    }
}
