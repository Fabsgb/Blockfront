package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.light.data.PointLightData;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ql, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ql.class */
public class C0444ql extends pA implements pI {

    @NotNull
    public static final MapCodec<C0444ql> x = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(pB.C.fieldOf("endPos").forGetter(c0444ql -> {
            return c0444ql.b;
        }), Codec.FLOAT.fieldOf("chance").forGetter(c0444ql2 -> {
            return Float.valueOf(c0444ql2.lm);
        }), Codec.BOOL.fieldOf("playSound").forGetter(c0444ql3 -> {
            return Boolean.valueOf(c0444ql3.gs);
        }), pB.C.fieldOf("spread").forGetter(c0444ql4 -> {
            return c0444ql4.ab;
        })).apply(instance, (vec3, f, bool, vec32) -> {
            C0444ql c0444ql5 = new C0444ql(Vec3.ZERO, vec3);
            c0444ql5.lm = f.floatValue();
            c0444ql5.gs = bool.booleanValue();
            c0444ql5.ab = vec32;
            return c0444ql5;
        });
    });

    @NotNull
    private static final ResourceLocation em = C0265jv.d("textures/misc/debug/mapeffect/bullet_tracer_start.png");

    @NotNull
    private static final ResourceLocation en = C0265jv.d("textures/misc/debug/mapeffect/bullet_tracer_end.png");

    @NotNull
    private static final ResourceLocation[] e = {C0265jv.d("textures/misc/muzzleflash/flash0.png"), C0265jv.d("textures/misc/muzzleflash/flash1.png"), C0265jv.d("textures/misc/muzzleflash/flash2.png")};
    private Vec3 b;
    private float lm;
    private int oy;

    @NotNull
    private ResourceLocation eo;
    private boolean gs;

    @NotNull
    private Vec3 ab;

    public C0444ql() {
        this(Vec3.ZERO, Vec3.ZERO);
    }

    public C0444ql(Vec3 vec3, Vec3 vec32) {
        super(vec3);
        this.lm = 0.08f;
        this.oy = 0;
        this.eo = e[0];
        this.gs = false;
        this.ab = new Vec3(8.0d, 8.0d, 8.0d);
        this.b = vec32;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (randomSource.nextFloat() <= this.lm) {
            b(randomSource, clientLevel);
        } else if (this.oy > 0) {
            this.oy--;
        }
    }

    private void b(@NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        this.oy = 1;
        this.eo = e[randomSource.nextInt(3)];
        int iNextInt = (int) (((double) randomSource.nextInt((int) (this.ab.x + this.ab.x))) + this.ab.x);
        int iNextInt2 = (int) (((double) randomSource.nextInt((int) (this.ab.y + this.ab.y))) + this.ab.y);
        int iNextInt3 = (int) (((double) randomSource.nextInt((int) (this.ab.z + this.ab.z))) + this.ab.z);
        aV.l.add(new C0166gc(wY.lA, this.c, this.b.add(((int) (((double) randomSource.nextInt((int) (this.ab.x + this.ab.x))) + this.ab.x)) - iNextInt, ((int) (((double) randomSource.nextInt((int) (this.ab.y + this.ab.y))) + this.ab.y)) - iNextInt2, ((int) (((double) randomSource.nextInt((int) (this.ab.z + this.ab.z))) + this.ab.z)) - iNextInt3)));
        if (this.gs) {
            clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, (SoundEvent) C0624xc.ve.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
        c(randomSource);
    }

    private void c(@NotNull RandomSource randomSource) {
        float fNextFloat = randomSource.nextFloat();
        uM uMVarM1218a = ((C0558ur) wY.lT.get()).m1218a();
        int color = uMVarM1218a.getColor();
        boolean z = iM.dl;
        C0164ga.a(new PointLightData().setOcclusionEnabled(z).setPosition(this.c.x, this.c.y, this.c.z).setBrightness(uMVarM1218a.bG() * fNextFloat).setRadius(uMVarM1218a.bF()).setColor(color), 1);
        C0164ga.a(new PointLightData().setOcclusionEnabled(z).setPosition(this.c.x, this.c.y, this.c.z).setBrightness(uMVarM1218a.bE() * fNextFloat).setRadius(uMVarM1218a.bD()).setColor(color), 1);
    }

    @Override // com.boehmod.blockfront.pI
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.oy > 0) {
            C0040bk.a(poseStack, camera, guiGraphics, this.eo, this.c.x, this.c.y, this.c.z, 48);
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        C0040bk.a(poseStack, camera, guiGraphics, en, this.b, 64, false);
        C0040bk.a(camera, poseStack, this.c, this.b, 1.0f, ColorReferences.COLOR_WHITE);
        Vec3 vec3Add = this.b.add(this.ab.x, 0.0d, 0.0d);
        Vec3 vec3Add2 = this.b.add(-this.ab.x, 0.0d, 0.0d);
        Vec3 vec3Add3 = this.b.add(0.0d, this.ab.y, 0.0d);
        Vec3 vec3Add4 = this.b.add(0.0d, -this.ab.y, 0.0d);
        Vec3 vec3Add5 = this.b.add(0.0d, 0.0d, this.ab.z);
        Vec3 vec3Add6 = this.b.add(0.0d, 0.0d, -this.ab.z);
        C0040bk.a(camera, poseStack, this.c, vec3Add, 1.0f, ColorReferences.COLOR_WHITE);
        C0040bk.a(camera, poseStack, this.c, vec3Add2, 1.0f, ColorReferences.COLOR_WHITE);
        C0040bk.a(camera, poseStack, this.c, vec3Add3, 1.0f, ColorReferences.COLOR_WHITE);
        C0040bk.a(camera, poseStack, this.c, vec3Add4, 1.0f, ColorReferences.COLOR_WHITE);
        C0040bk.a(camera, poseStack, this.c, vec3Add5, 1.0f, ColorReferences.COLOR_WHITE);
        C0040bk.a(camera, poseStack, this.c, vec3Add6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Bullet Tracer: chance=%.3f, playSound=%s", Float.valueOf(this.lm), Boolean.valueOf(this.gs))));
        list.add(Component.literal(String.format("Spread: x=%.1f, y=%.1f, z=%.1f", Double.valueOf(this.ab.x), Double.valueOf(this.ab.y), Double.valueOf(this.ab.z))));
        list.add(Component.literal(String.format("End: (%.1f, %.1f, %.1f)", Double.valueOf(this.b.x), Double.valueOf(this.b.y), Double.valueOf(this.b.z))));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pY(Component.literal("End Position"), () -> {
            return this.b;
        }, vec3 -> {
            this.b = vec3;
        }));
        objectArrayList.add(new pS(Component.literal("Chance"), () -> {
            return Float.valueOf(this.lm);
        }, f -> {
            this.lm = f.floatValue();
        }, 0.0f, 1.0f));
        objectArrayList.add(new pO(Component.literal("Play Sound"), () -> {
            return Boolean.valueOf(this.gs);
        }, bool -> {
            this.gs = bool.booleanValue();
        }));
        objectArrayList.add(new pY(Component.literal("Spread"), () -> {
            return this.ab;
        }, vec32 -> {
            this.ab = vec32;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return em;
    }

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.oy = 0;
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
