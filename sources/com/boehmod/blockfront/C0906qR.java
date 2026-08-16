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

/* JADX INFO: renamed from: com.boehmod.blockfront.qR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qR.class */
public class C0906qR extends AbstractC0858pW {

    /* JADX INFO: renamed from: ew */
    @NotNull
    private static final ResourceLocation f5064ew = C0532jO.m2378d("textures/misc/debug/mapeffect/random_explosion.png");

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final MapCodec<C0906qR> f5065H = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0859pX.f4600D.fieldOf("startPos").forGetter(c0906qR -> {
            return c0906qR.f5067l;
        }), C0859pX.f4600D.fieldOf("endPos").forGetter(c0906qR2 -> {
            return c0906qR2.f5068m;
        }), Codec.INT.optionalFieldOf("explodeTimeMax", 200).forGetter(c0906qR3 -> {
            return Integer.valueOf(c0906qR3.f5066qF);
        })).apply(instance, (vec2, vec3, num) -> {
            C0906qR c0906qR4 = new C0906qR(vec2, vec3);
            c0906qR4.f5066qF = Math.max(1, num.intValue());
            return c0906qR4;
        });
    });

    /* JADX INFO: renamed from: qF */
    private int f5066qF;

    /* JADX INFO: renamed from: l */
    private Vec2 f5067l;

    /* JADX INFO: renamed from: m */
    private Vec2 f5068m;

    /* JADX INFO: renamed from: qG */
    private int f5069qG;

    public C0906qR() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0906qR(@NotNull Vec2 vec2, @NotNull Vec2 vec3) {
        this.f5066qF = 200;
        this.f5069qG = ThreadLocalRandom.current().nextInt(this.f5066qF);
        this.f5067l = vec2;
        this.f5068m = vec3;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f5069qG;
        this.f5069qG = i - 1;
        if (i <= 0) {
            this.f5069qG = randomSource.nextInt(this.f5066qF);
            m4983a(minecraft, c0623l, randomSource, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4983a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        Vec2 vec2 = new Vec2(this.f5067l.x + (randomSource.nextFloat() * (this.f5068m.x - this.f5067l.x)), this.f5067l.y + (randomSource.nextFloat() * (this.f5068m.y - this.f5067l.y)));
        if (clientLevel.isLoaded(new BlockPos((int) vec2.x, 255, (int) vec2.y))) {
            Vec3 vec3 = new Vec3(vec2.x, 255.0d, vec2.y);
            C0693mQ.m3103a(minecraft, c0623l, clientLevel, EnumC0862pa.ARTILLERY_EXPLOSION, clientLevel.clip(new ClipContext(vec3, vec3.subtract(0.0d, 255.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, CollisionContext.empty())).getLocation());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.f5067l.x, 255.0d, this.f5067l.y, this.f5068m.x, 255.0d, this.f5068m.y, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0934qt(Component.literal("Start Position"), () -> {
            return this.f5067l;
        }, vec2 -> {
            this.f5067l = vec2;
        }));
        objectArrayList.add(new C0934qt(Component.literal("End Position"), () -> {
            return this.f5068m;
        }, vec3 -> {
            this.f5068m = vec3;
        }));
        objectArrayList.add(new C0930qp(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.f5066qF);
        }, num -> {
            this.f5066qF = num.intValue();
        }, 1, 72000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Random Explosion: " + this.f5067l.x + ", " + this.f5067l.y + " -> " + this.f5068m.x + ", " + this.f5068m.y));
        list.add(Component.literal("Next explosion in: " + this.f5069qG + " / " + this.f5066qF + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5064ew;
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
        this.f5069qG = randomSource.nextInt(this.f5066qF);
    }
}
