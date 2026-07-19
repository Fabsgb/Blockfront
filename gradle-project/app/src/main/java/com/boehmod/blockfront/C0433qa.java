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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qa.class */
public class C0433qa extends pA {

    @NotNull
    private static final ResourceLocation dX = C0265jv.d("textures/misc/debug/mapeffect/falling_artillery.png");

    @NotNull
    public static final MapCodec<C0433qa> m = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(pB.D.fieldOf("startPos").forGetter(c0433qa -> {
            return c0433qa.l;
        }), pB.D.fieldOf("endPos").forGetter(c0433qa2 -> {
            return c0433qa2.f289m;
        }), Codec.INT.optionalFieldOf("artilleryTimeMax", 600).forGetter(c0433qa3 -> {
            return Integer.valueOf(c0433qa3.oa);
        })).apply(instance, (vec2, vec22, num) -> {
            C0433qa c0433qa4 = new C0433qa(vec2, vec22);
            c0433qa4.oa = Math.max(1, num.intValue());
            return c0433qa4;
        });
    });
    private int oa;
    private Vec2 l;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    private Vec2 f289m;
    private int ob;

    public C0433qa() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    public C0433qa(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
        this.oa = 600;
        this.ob = ThreadLocalRandom.current().nextInt(this.oa);
        this.l = vec2;
        this.f289m = vec22;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.ob;
        this.ob = i - 1;
        if (i <= 0) {
            this.ob = randomSource.nextInt(this.oa);
            a(randomSource, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        Vec2 vec2 = new Vec2(this.l.x + (randomSource.nextFloat() * (this.f289m.x - this.l.x)), this.l.y + (randomSource.nextFloat() * (this.f289m.y - this.l.y)));
        if (clientLevel.isLoaded(new BlockPos((int) vec2.x, 255, (int) vec2.y))) {
            Vec3 vec3 = new Vec3(vec2.x, 255.0d, vec2.y);
            C0353nb c0353nbCreate = ((EntityType) wX.kX.get()).create(clientLevel);
            if (c0353nbCreate != null) {
                c0353nbCreate.a(vec3, 2.0f, new ItemStack((ItemLike) wY.mZ.get()), 0.0f, 0.0f);
                c0353nbCreate.setDeltaMovement(0.0d, -1.0d, 0.0d);
                c0353nbCreate.setPos(vec3.x, vec3.y, vec3.z);
                iG.a((Entity) c0353nbCreate, clientLevel);
            }
        }
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.l.x, 255.0d, this.l.y, this.f289m.x, 255.0d, this.f289m.y, 1.0f, 0.0f, 0.0f, 1.0f);
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
            return this.f289m;
        }, vec22 -> {
            this.f289m = vec22;
        }));
        objectArrayList.add(new pT(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.oa);
        }, num -> {
            this.oa = num.intValue();
        }, 1, 72000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Falling Artillery: " + this.l.x + ", " + this.l.y + " -> " + this.f289m.x + ", " + this.f289m.y));
        list.add(Component.literal("Artillery: next strike in " + this.ob + " / " + this.oa + " ticks"));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return dX;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.ob = randomSource.nextInt(this.oa);
    }
}
