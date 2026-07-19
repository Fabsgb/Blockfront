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

/* JADX INFO: renamed from: com.boehmod.blockfront.qk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qk.class */
public class C0443qk extends pA implements pI, pJ {

    @NotNull
    public static final MapCodec<C0443qk> w = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0443qk -> {
            return Float.valueOf(c0443qk.cO);
        }), Codec.INT.fieldOf("color").forGetter(c0443qk2 -> {
            return Integer.valueOf(c0443qk2.Y);
        }), Codec.FLOAT.fieldOf("scale").forGetter(c0443qk3 -> {
            return Float.valueOf(c0443qk3.aB);
        }), Codec.STRING.fieldOf("sound").forGetter(c0443qk4 -> {
            return C0636xo.f(c0443qk4.j.get());
        })).apply(instance, (f, num, f2, str) -> {
            C0443qk c0443qk5 = new C0443qk(Vec3.ZERO, f.floatValue(), C0636xo.d(str));
            c0443qk5.Y = num.intValue();
            c0443qk5.aB = f2.floatValue();
            return c0443qk5;
        });
    });
    private static final ResourceLocation ek = C0265jv.d("textures/misc/world/bombing.png");
    private static final ResourceLocation el = C0265jv.d("textures/misc/debug/mapeffect/bombing_flash.png");
    private static final float le = 8000.0f;
    private static final float lf = 4000.0f;
    private static final int ow = 16777215;
    private static final float lg = 1.0f;
    private static final float lh = 0.04f;
    private static final float li = 0.02f;
    private static final float lj = 0.8f;
    private static final float lk = 0.1f;
    private static final int ox = 4;
    private static final float ll = 30.0f;
    private float cO;
    private float aB;
    private int Y;
    private float aD;
    private float aE;
    private Supplier<SoundEvent> j;

    public C0443qk() {
        this(Vec3.ZERO, 0.0f, C0624xc.Db);
    }

    public C0443qk(Vec3 vec3, float f, Supplier<SoundEvent> supplier) {
        super(vec3);
        this.aB = 1.0f;
        this.Y = 16777215;
        this.aD = 0.0f;
        this.aE = 0.0f;
        this.cO = f;
        this.j = supplier;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.aE = this.aD;
        this.aD = C0634xm.d(this.aD, 0.0f, 0.04f);
        if (randomSource.nextFloat() < li) {
            this.aD = 1.0f;
            if (this.j != null) {
                clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, this.j.get(), SoundSource.AMBIENT, ll, lj + (0.1f * randomSource.nextInt(4)), false);
            }
        }
    }

    @Override // com.boehmod.blockfront.pI
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        float fE = C0634xm.e(this.aD, this.aE, f2);
        C0040bk.a(poseStack, guiGraphics, ek, this.c.x, this.c.y, this.c.z, le * this.aB, lf * this.aB, fE, this.Y, true, 0.0f, this.cO);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Bombing Flash: pos=(%.1f, %.1f, %.1f)", Double.valueOf(this.c.x), Double.valueOf(this.c.y), Double.valueOf(this.c.z))));
        list.add(Component.literal(String.format("Rotation: %.1f, Scale: %.2f, Color: #%06X", Float.valueOf(this.cO), Float.valueOf(this.aB), Integer.valueOf(this.Y & 16777215))));
        SoundEvent soundEvent = this.j != null ? this.j.get() : null;
        list.add(Component.literal("Sound: " + (soundEvent != null ? C0636xo.f(soundEvent) : "none")));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pS(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.cO);
        }, f -> {
            this.cO = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new pP(Component.literal("Color"), () -> {
            return Integer.valueOf(this.Y);
        }, num -> {
            this.Y = num.intValue();
        }));
        objectArrayList.add(new pS(Component.literal("Scale"), () -> {
            return Float.valueOf(this.aB);
        }, f2 -> {
            this.aB = f2.floatValue();
        }, 0.0f, 16.0f));
        objectArrayList.add(new pV(Component.literal("Sound"), () -> {
            if (this.j != null) {
                return this.j.get();
            }
            return null;
        }, soundEvent -> {
            this.j = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return el;
    }

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aO() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aP() {
        return this.cO;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aQ() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.pJ
    public void a(float f, float f2, float f3) {
        this.cO = f2;
    }

    @Override // com.boehmod.blockfront.pJ
    public void g(@NotNull Vec3 vec3) {
        this.cO = (float) Math.toDegrees(Math.atan2(-vec3.x, -vec3.z));
    }

    @Override // com.boehmod.blockfront.pJ
    @NotNull
    public Vec3 m() {
        double radians = Math.toRadians(this.cO);
        return new Vec3(-Math.sin(radians), 0.0d, -Math.cos(radians));
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
