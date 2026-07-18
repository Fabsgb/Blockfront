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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qd.class */
public class C0917qd extends AbstractC0835pA {

    /* JADX INFO: renamed from: ec */
    @NotNull
    private static final ResourceLocation f4787ec = C0564jv.m2555d("textures/misc/debug/mapeffect/lightning.png");

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final MapCodec<C0917qd> f4788p = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0836pB.f4471D.fieldOf("startPos").forGetter(c0917qd -> {
            return c0917qd.f4790l;
        }), C0836pB.f4471D.fieldOf("endPos").forGetter(c0917qd2 -> {
            return c0917qd2.f4791m;
        }), Codec.INT.optionalFieldOf("lightningTimeMax", Integer.valueOf(C1089tp.f5684rx)).forGetter(c0917qd3 -> {
            return Integer.valueOf(c0917qd3.f4789oi);
        })).apply(instance, (vec2, vec22, num) -> {
            C0917qd c0917qd4 = new C0917qd(vec2, vec22);
            c0917qd4.f4789oi = Math.max(1, num.intValue());
            return c0917qd4;
        });
    });

    /* JADX INFO: renamed from: oi */
    private int f4789oi;

    /* JADX INFO: renamed from: l */
    @NotNull
    private Vec2 f4790l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private Vec2 f4791m;

    /* JADX INFO: renamed from: oj */
    private int f4792oj;

    public C0917qd(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
        this.f4789oi = C1089tp.f5684rx;
        this.f4792oj = ThreadLocalRandom.current().nextInt(this.f4789oi);
        this.f4790l = vec2;
        this.f4791m = vec22;
    }

    public C0917qd() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    /* JADX INFO: renamed from: a */
    private void m4772a(@NotNull RandomSource randomSource, @NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        Vec2 vec2 = new Vec2(this.f4790l.x + (randomSource.nextFloat() * (this.f4791m.x - this.f4790l.x)), this.f4790l.y + (randomSource.nextFloat() * (this.f4791m.y - this.f4790l.y)));
        Vec3 bottomCenter = C0799oR.m4042a(serverLevel, new BlockPos((int) vec2.x, 0, (int) vec2.y)).getBottomCenter();
        C0799oR.m3917c((Level) serverLevel, bottomCenter);
        Vec3 vec3Add = bottomCenter.add(0.0d, 5.0d, 0.0d);
        C0799oR.m3941a((Level) serverLevel, vec3Add, (SoundEvent) C1280xc.f8283Dm.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C0799oR.m3941a((Level) serverLevel, vec3Add, (SoundEvent) C1280xc.f8284Dn.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C0799oR.m3941a((Level) serverLevel, vec3Add, (SoundEvent) C1280xc.f8285Do.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C0799oR.m3941a((Level) serverLevel, vec3Add, (SoundEvent) C1280xc.f8352ED.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C1194vo.m6651a(new C1239wg(2), abstractC0787oF);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        int i = this.f4792oj;
        this.f4792oj = i - 1;
        if (i <= 0) {
            this.f4792oj = randomSource.nextInt(Math.max(1, this.f4789oi));
            m4772a(randomSource, serverLevel, abstractC0787oF);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.f4790l.x, 255.0d, this.f4790l.y, this.f4791m.x, 255.0d, this.f4791m.y, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0858pX(Component.literal("Start Position"), () -> {
            return this.f4790l;
        }, vec2 -> {
            this.f4790l = vec2;
        }));
        objectArrayList.add(new C0858pX(Component.literal("End Position"), () -> {
            return this.f4791m;
        }, vec22 -> {
            this.f4791m = vec22;
        }));
        objectArrayList.add(new C0854pT(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.f4789oi);
        }, num -> {
            this.f4789oi = num.intValue();
        }, 1, 144000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Lightning: " + this.f4790l.x + ", " + this.f4790l.y + " -> " + this.f4791m.x + ", " + this.f4791m.y));
        list.add(Component.literal("Next strike in: " + this.f4792oj + " / " + this.f4789oi + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4787ec;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
        this.f4792oj = ThreadLocalRandom.current().nextInt(Math.max(1, this.f4789oi));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
    }
}
