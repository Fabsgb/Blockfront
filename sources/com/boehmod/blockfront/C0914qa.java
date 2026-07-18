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

/* JADX INFO: renamed from: com.boehmod.blockfront.qa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qa.class */
public class C0914qa extends AbstractC0835pA {

    /* JADX INFO: renamed from: dX */
    @NotNull
    private static final ResourceLocation f4727dX = C0564jv.m2555d("textures/misc/debug/mapeffect/falling_artillery.png");

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final MapCodec<C0914qa> f4728m = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0836pB.f4471D.fieldOf("startPos").forGetter(c0914qa -> {
            return c0914qa.f4730l;
        }), C0836pB.f4471D.fieldOf("endPos").forGetter(c0914qa2 -> {
            return c0914qa2.f4731m;
        }), Codec.INT.optionalFieldOf("artilleryTimeMax", 600).forGetter(c0914qa3 -> {
            return Integer.valueOf(c0914qa3.f4729oa);
        })).apply(instance, (vec2, vec22, num) -> {
            C0914qa c0914qa4 = new C0914qa(vec2, vec22);
            c0914qa4.f4729oa = Math.max(1, num.intValue());
            return c0914qa4;
        });
    });

    /* JADX INFO: renamed from: oa */
    private int f4729oa;

    /* JADX INFO: renamed from: l */
    private Vec2 f4730l;

    /* JADX INFO: renamed from: m */
    private Vec2 f4731m;

    /* JADX INFO: renamed from: ob */
    private int f4732ob;

    public C0914qa() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    public C0914qa(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
        this.f4729oa = 600;
        this.f4732ob = ThreadLocalRandom.current().nextInt(this.f4729oa);
        this.f4730l = vec2;
        this.f4731m = vec22;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4732ob;
        this.f4732ob = i - 1;
        if (i <= 0) {
            this.f4732ob = randomSource.nextInt(this.f4729oa);
            m4699a(randomSource, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4699a(@NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        Vec2 vec2 = new Vec2(this.f4730l.x + (randomSource.nextFloat() * (this.f4731m.x - this.f4730l.x)), this.f4730l.y + (randomSource.nextFloat() * (this.f4731m.y - this.f4730l.y)));
        if (clientLevel.isLoaded(new BlockPos((int) vec2.x, 255, (int) vec2.y))) {
            Vec3 vec3 = new Vec3(vec2.x, 255.0d, vec2.y);
            C0756nb c0756nbCreate = ((EntityType) C1230wX.f7054kX.get()).create(clientLevel);
            if (c0756nbCreate != null) {
                c0756nbCreate.mo3284a(vec3, 2.0f, new ItemStack((ItemLike) C1231wY.f7271mZ.get()), 0.0f, 0.0f);
                c0756nbCreate.setDeltaMovement(0.0d, -1.0d, 0.0d);
                c0756nbCreate.setPos(vec3.x, vec3.y, vec3.z);
                C0470iG.m2121a((Entity) c0756nbCreate, clientLevel);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.f4730l.x, 255.0d, this.f4730l.y, this.f4731m.x, 255.0d, this.f4731m.y, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0858pX(Component.literal("Start Position"), () -> {
            return this.f4730l;
        }, vec2 -> {
            this.f4730l = vec2;
        }));
        objectArrayList.add(new C0858pX(Component.literal("End Position"), () -> {
            return this.f4731m;
        }, vec22 -> {
            this.f4731m = vec22;
        }));
        objectArrayList.add(new C0854pT(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.f4729oa);
        }, num -> {
            this.f4729oa = num.intValue();
        }, 1, 72000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Falling Artillery: " + this.f4730l.x + ", " + this.f4730l.y + " -> " + this.f4731m.x + ", " + this.f4731m.y));
        list.add(Component.literal("Artillery: next strike in " + this.f4732ob + " / " + this.f4729oa + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4727dX;
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
        this.f4732ob = randomSource.nextInt(this.f4729oa);
    }
}
