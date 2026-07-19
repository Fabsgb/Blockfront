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

/* JADX INFO: renamed from: com.boehmod.blockfront.qd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qd.class */
public class C0436qd extends pA {

    @NotNull
    private static final ResourceLocation ec = C0265jv.d("textures/misc/debug/mapeffect/lightning.png");

    @NotNull
    public static final MapCodec<C0436qd> p = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(pB.D.fieldOf("startPos").forGetter(c0436qd -> {
            return c0436qd.l;
        }), pB.D.fieldOf("endPos").forGetter(c0436qd2 -> {
            return c0436qd2.m;
        }), Codec.INT.optionalFieldOf("lightningTimeMax", Integer.valueOf(C0529tp.rx)).forGetter(c0436qd3 -> {
            return Integer.valueOf(c0436qd3.oi);
        })).apply(instance, (vec2, vec22, num) -> {
            C0436qd c0436qd4 = new C0436qd(vec2, vec22);
            c0436qd4.oi = Math.max(1, num.intValue());
            return c0436qd4;
        });
    });
    private int oi;

    @NotNull
    private Vec2 l;

    @NotNull
    private Vec2 m;
    private int oj;

    public C0436qd(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
        this.oi = C0529tp.rx;
        this.oj = ThreadLocalRandom.current().nextInt(this.oi);
        this.l = vec2;
        this.m = vec22;
    }

    public C0436qd() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    private void a(@NotNull RandomSource randomSource, @NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar) {
        Vec2 vec2 = new Vec2(this.l.x + (randomSource.nextFloat() * (this.m.x - this.l.x)), this.l.y + (randomSource.nextFloat() * (this.m.y - this.l.y)));
        Vec3 bottomCenter = oR.a(serverLevel, new BlockPos((int) vec2.x, 0, (int) vec2.y)).getBottomCenter();
        oR.c((Level) serverLevel, bottomCenter);
        Vec3 vec3Add = bottomCenter.add(0.0d, 5.0d, 0.0d);
        oR.a((Level) serverLevel, vec3Add, (SoundEvent) C0624xc.Dm.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        oR.a((Level) serverLevel, vec3Add, (SoundEvent) C0624xc.Dn.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        oR.a((Level) serverLevel, vec3Add, (SoundEvent) C0624xc.Do.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        oR.a((Level) serverLevel, vec3Add, (SoundEvent) C0624xc.ED.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C0582vo.a(new C0601wg(2), oFVar);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        int i = this.oj;
        this.oj = i - 1;
        if (i <= 0) {
            this.oj = randomSource.nextInt(Math.max(1, this.oi));
            a(randomSource, serverLevel, oFVar);
        }
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
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
            return Integer.valueOf(this.oi);
        }, num -> {
            this.oi = num.intValue();
        }, 1, 144000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Lightning: " + this.l.x + ", " + this.l.y + " -> " + this.m.x + ", " + this.m.y));
        list.add(Component.literal("Next strike in: " + this.oj + " / " + this.oi + " ticks"));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ec;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
        this.oj = ThreadLocalRandom.current().nextInt(Math.max(1, this.oi));
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
    }
}
