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

/* JADX INFO: renamed from: com.boehmod.blockfront.ql */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ql.class */
public class C0925ql extends AbstractC0835pA implements InterfaceC0843pI {

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final MapCodec<C0925ql> f4886x = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0836pB.f4470C.fieldOf("endPos").forGetter(c0925ql -> {
            return c0925ql.f4890b;
        }), Codec.FLOAT.fieldOf("chance").forGetter(c0925ql2 -> {
            return Float.valueOf(c0925ql2.f4891lm);
        }), Codec.BOOL.fieldOf("playSound").forGetter(c0925ql3 -> {
            return Boolean.valueOf(c0925ql3.f4894gs);
        }), C0836pB.f4470C.fieldOf("spread").forGetter(c0925ql4 -> {
            return c0925ql4.f4895ab;
        })).apply(instance, (vec3, f, bool, vec32) -> {
            C0925ql c0925ql5 = new C0925ql(Vec3.ZERO, vec3);
            c0925ql5.f4891lm = f.floatValue();
            c0925ql5.f4894gs = bool.booleanValue();
            c0925ql5.f4895ab = vec32;
            return c0925ql5;
        });
    });

    /* JADX INFO: renamed from: em */
    @NotNull
    private static final ResourceLocation f4887em = C0564jv.m2555d("textures/misc/debug/mapeffect/bullet_tracer_start.png");

    /* JADX INFO: renamed from: en */
    @NotNull
    private static final ResourceLocation f4888en = C0564jv.m2555d("textures/misc/debug/mapeffect/bullet_tracer_end.png");

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final ResourceLocation[] f4889e = {C0564jv.m2555d("textures/misc/muzzleflash/flash0.png"), C0564jv.m2555d("textures/misc/muzzleflash/flash1.png"), C0564jv.m2555d("textures/misc/muzzleflash/flash2.png")};

    /* JADX INFO: renamed from: b */
    private Vec3 f4890b;

    /* JADX INFO: renamed from: lm */
    private float f4891lm;

    /* JADX INFO: renamed from: oy */
    private int f4892oy;

    /* JADX INFO: renamed from: eo */
    @NotNull
    private ResourceLocation f4893eo;

    /* JADX INFO: renamed from: gs */
    private boolean f4894gs;

    /* JADX INFO: renamed from: ab */
    @NotNull
    private Vec3 f4895ab;

    public C0925ql() {
        this(Vec3.ZERO, Vec3.ZERO);
    }

    public C0925ql(Vec3 vec3, Vec3 vec32) {
        super(vec3);
        this.f4891lm = 0.08f;
        this.f4892oy = 0;
        this.f4893eo = f4889e[0];
        this.f4894gs = false;
        this.f4895ab = new Vec3(8.0d, 8.0d, 8.0d);
        this.f4890b = vec32;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (randomSource.nextFloat() <= this.f4891lm) {
            m4890b(randomSource, clientLevel);
        } else if (this.f4892oy > 0) {
            this.f4892oy--;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4890b(@NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        this.f4892oy = 1;
        this.f4893eo = f4889e[randomSource.nextInt(3)];
        int iNextInt = (int) (((double) randomSource.nextInt((int) (this.f4895ab.x + this.f4895ab.x))) + this.f4895ab.x);
        int iNextInt2 = (int) (((double) randomSource.nextInt((int) (this.f4895ab.y + this.f4895ab.y))) + this.f4895ab.y);
        int iNextInt3 = (int) (((double) randomSource.nextInt((int) (this.f4895ab.z + this.f4895ab.z))) + this.f4895ab.z);
        C0051aV.f352l.add(new C0386gc(C1231wY.f7189lA, this.f4464c, this.f4890b.add(((int) (((double) randomSource.nextInt((int) (this.f4895ab.x + this.f4895ab.x))) + this.f4895ab.x)) - iNextInt, ((int) (((double) randomSource.nextInt((int) (this.f4895ab.y + this.f4895ab.y))) + this.f4895ab.y)) - iNextInt2, ((int) (((double) randomSource.nextInt((int) (this.f4895ab.z + this.f4895ab.z))) + this.f4895ab.z)) - iNextInt3)));
        if (this.f4894gs) {
            clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, (SoundEvent) C1280xc.f7859ve.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
        m4891c(randomSource);
    }

    /* JADX INFO: renamed from: c */
    private void m4891c(@NotNull RandomSource randomSource) {
        float fNextFloat = randomSource.nextFloat();
        C1113uM c1113uMM6398a = ((C1144ur) C1231wY.f7210lT.get()).m6398a();
        int color = c1113uMM6398a.getColor();
        boolean z = C0476iM.f2924dl;
        C0384ga.m1842a(new PointLightData().setOcclusionEnabled(z).setPosition(this.f4464c.x, this.f4464c.y, this.f4464c.z).setBrightness(c1113uMM6398a.m6136bG() * fNextFloat).setRadius(c1113uMM6398a.m6134bF()).setColor(color), 1);
        C0384ga.m1842a(new PointLightData().setOcclusionEnabled(z).setPosition(this.f4464c.x, this.f4464c.y, this.f4464c.z).setBrightness(c1113uMM6398a.m6132bE() * fNextFloat).setRadius(c1113uMM6398a.m6130bD()).setColor(color), 1);
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f4892oy > 0) {
            C0119bk.m503a(poseStack, camera, guiGraphics, this.f4893eo, this.f4464c.x, this.f4464c.y, this.f4464c.z, 48);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        C0119bk.m505a(poseStack, camera, guiGraphics, f4888en, this.f4890b, 64, false);
        C0119bk.m474a(camera, poseStack, this.f4464c, this.f4890b, 1.0f, ColorReferences.COLOR_WHITE);
        Vec3 vec3Add = this.f4890b.add(this.f4895ab.x, 0.0d, 0.0d);
        Vec3 vec3Add2 = this.f4890b.add(-this.f4895ab.x, 0.0d, 0.0d);
        Vec3 vec3Add3 = this.f4890b.add(0.0d, this.f4895ab.y, 0.0d);
        Vec3 vec3Add4 = this.f4890b.add(0.0d, -this.f4895ab.y, 0.0d);
        Vec3 vec3Add5 = this.f4890b.add(0.0d, 0.0d, this.f4895ab.z);
        Vec3 vec3Add6 = this.f4890b.add(0.0d, 0.0d, -this.f4895ab.z);
        C0119bk.m474a(camera, poseStack, this.f4464c, vec3Add, 1.0f, ColorReferences.COLOR_WHITE);
        C0119bk.m474a(camera, poseStack, this.f4464c, vec3Add2, 1.0f, ColorReferences.COLOR_WHITE);
        C0119bk.m474a(camera, poseStack, this.f4464c, vec3Add3, 1.0f, ColorReferences.COLOR_WHITE);
        C0119bk.m474a(camera, poseStack, this.f4464c, vec3Add4, 1.0f, ColorReferences.COLOR_WHITE);
        C0119bk.m474a(camera, poseStack, this.f4464c, vec3Add5, 1.0f, ColorReferences.COLOR_WHITE);
        C0119bk.m474a(camera, poseStack, this.f4464c, vec3Add6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Bullet Tracer: chance=%.3f, playSound=%s", Float.valueOf(this.f4891lm), Boolean.valueOf(this.f4894gs))));
        list.add(Component.literal(String.format("Spread: x=%.1f, y=%.1f, z=%.1f", Double.valueOf(this.f4895ab.x), Double.valueOf(this.f4895ab.y), Double.valueOf(this.f4895ab.z))));
        list.add(Component.literal(String.format("End: (%.1f, %.1f, %.1f)", Double.valueOf(this.f4890b.x), Double.valueOf(this.f4890b.y), Double.valueOf(this.f4890b.z))));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0859pY(Component.literal("End Position"), () -> {
            return this.f4890b;
        }, vec3 -> {
            this.f4890b = vec3;
        }));
        objectArrayList.add(new C0853pS(Component.literal("Chance"), () -> {
            return Float.valueOf(this.f4891lm);
        }, f -> {
            this.f4891lm = f.floatValue();
        }, 0.0f, 1.0f));
        objectArrayList.add(new C0849pO(Component.literal("Play Sound"), () -> {
            return Boolean.valueOf(this.f4894gs);
        }, bool -> {
            this.f4894gs = bool.booleanValue();
        }));
        objectArrayList.add(new C0859pY(Component.literal("Spread"), () -> {
            return this.f4895ab;
        }, vec32 -> {
            this.f4895ab = vec32;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4887em;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return false;
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
        this.f4892oy = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
