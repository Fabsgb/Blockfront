package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.qk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qk.class */
public class C0924qk extends AbstractC0835pA implements InterfaceC0843pI, InterfaceC0844pJ {

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final MapCodec<C0924qk> f4867w = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0924qk -> {
            return Float.valueOf(c0924qk.f4880cO);
        }), Codec.INT.fieldOf("color").forGetter(c0924qk2 -> {
            return Integer.valueOf(c0924qk2.f4882Y);
        }), Codec.FLOAT.fieldOf("scale").forGetter(c0924qk3 -> {
            return Float.valueOf(c0924qk3.f4881aB);
        }), Codec.STRING.fieldOf("sound").forGetter(c0924qk4 -> {
            return C1292xo.m7889f(c0924qk4.f4885j.get());
        })).apply(instance, (f, num, f2, str) -> {
            C0924qk c0924qk5 = new C0924qk(Vec3.ZERO, f.floatValue(), C1292xo.m7888d(str));
            c0924qk5.f4882Y = num.intValue();
            c0924qk5.f4881aB = f2.floatValue();
            return c0924qk5;
        });
    });

    /* JADX INFO: renamed from: ek */
    private static final ResourceLocation f4868ek = C0564jv.m2555d("textures/misc/world/bombing.png");

    /* JADX INFO: renamed from: el */
    private static final ResourceLocation f4869el = C0564jv.m2555d("textures/misc/debug/mapeffect/bombing_flash.png");

    /* JADX INFO: renamed from: le */
    private static final float f4870le = 8000.0f;

    /* JADX INFO: renamed from: lf */
    private static final float f4871lf = 4000.0f;

    /* JADX INFO: renamed from: ow */
    private static final int f4872ow = 16777215;

    /* JADX INFO: renamed from: lg */
    private static final float f4873lg = 1.0f;

    /* JADX INFO: renamed from: lh */
    private static final float f4874lh = 0.04f;

    /* JADX INFO: renamed from: li */
    private static final float f4875li = 0.02f;

    /* JADX INFO: renamed from: lj */
    private static final float f4876lj = 0.8f;

    /* JADX INFO: renamed from: lk */
    private static final float f4877lk = 0.1f;

    /* JADX INFO: renamed from: ox */
    private static final int f4878ox = 4;

    /* JADX INFO: renamed from: ll */
    private static final float f4879ll = 30.0f;

    /* JADX INFO: renamed from: cO */
    private float f4880cO;

    /* JADX INFO: renamed from: aB */
    private float f4881aB;

    /* JADX INFO: renamed from: Y */
    private int f4882Y;

    /* JADX INFO: renamed from: aD */
    private float f4883aD;

    /* JADX INFO: renamed from: aE */
    private float f4884aE;

    /* JADX INFO: renamed from: j */
    private Supplier<SoundEvent> f4885j;

    public C0924qk() {
        this(Vec3.ZERO, 0.0f, C1280xc.f8272Db);
    }

    public C0924qk(Vec3 vec3, float f, Supplier<SoundEvent> supplier) {
        super(vec3);
        this.f4881aB = 1.0f;
        this.f4882Y = 16777215;
        this.f4883aD = 0.0f;
        this.f4884aE = 0.0f;
        this.f4880cO = f;
        this.f4885j = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.f4884aE = this.f4883aD;
        this.f4883aD = C1290xm.m7835d(this.f4883aD, 0.0f, 0.04f);
        if (randomSource.nextFloat() < f4875li) {
            this.f4883aD = 1.0f;
            if (this.f4885j != null) {
                clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, this.f4885j.get(), SoundSource.AMBIENT, f4879ll, f4876lj + (0.1f * randomSource.nextInt(4)), false);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        float fM7843e = C1290xm.m7843e(this.f4883aD, this.f4884aE, f2);
        C0119bk.m516a(poseStack, guiGraphics, f4868ek, this.f4464c.x, this.f4464c.y, this.f4464c.z, f4870le * this.f4881aB, f4871lf * this.f4881aB, fM7843e, this.f4882Y, true, 0.0f, this.f4880cO);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Bombing Flash: pos=(%.1f, %.1f, %.1f)", Double.valueOf(this.f4464c.x), Double.valueOf(this.f4464c.y), Double.valueOf(this.f4464c.z))));
        list.add(Component.literal(String.format("Rotation: %.1f, Scale: %.2f, Color: #%06X", Float.valueOf(this.f4880cO), Float.valueOf(this.f4881aB), Integer.valueOf(this.f4882Y & 16777215))));
        SoundEvent soundEvent = this.f4885j != null ? this.f4885j.get() : null;
        list.add(Component.literal("Sound: " + (soundEvent != null ? C1292xo.m7889f(soundEvent) : "none")));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0853pS(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.f4880cO);
        }, f -> {
            this.f4880cO = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0850pP(Component.literal("Color"), () -> {
            return Integer.valueOf(this.f4882Y);
        }, num -> {
            this.f4882Y = num.intValue();
        }));
        objectArrayList.add(new C0853pS(Component.literal("Scale"), () -> {
            return Float.valueOf(this.f4881aB);
        }, f2 -> {
            this.f4881aB = f2.floatValue();
        }, 0.0f, 16.0f));
        objectArrayList.add(new C0856pV(Component.literal("Sound"), () -> {
            if (this.f4885j != null) {
                return this.f4885j.get();
            }
            return null;
        }, soundEvent -> {
            this.f4885j = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4869el;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aO */
    public float mo4271aO() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aP */
    public float mo4272aP() {
        return this.f4880cO;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aQ */
    public float mo4273aQ() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: a */
    public void mo4274a(float f, float f2, float f3) {
        this.f4880cO = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: g */
    public void mo4275g(@NotNull Vec3 vec3) {
        this.f4880cO = (float) Math.toDegrees(Math.atan2(-vec3.x, -vec3.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    @NotNull
    /* JADX INFO: renamed from: m */
    public Vec3 mo4276m() {
        double radians = Math.toRadians(this.f4880cO);
        return new Vec3(-Math.sin(radians), 0.0d, -Math.cos(radians));
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
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
