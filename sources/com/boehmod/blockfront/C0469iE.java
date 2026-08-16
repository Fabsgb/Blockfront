package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iE.class */
public class C0469iE extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: gW */
    private static final float f2902gW = 0.025f;

    /* JADX INFO: renamed from: di */
    @Nonnull
    private static final ResourceLocation f2903di;

    /* JADX INFO: renamed from: kW */
    private static final int f2904kW = 32;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Minecraft f2905c;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final UUID f2906l;

    /* JADX INFO: renamed from: gX */
    private float f2907gX;

    /* JADX INFO: renamed from: gY */
    private float f2908gY;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Vec3 f2909s;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0838pC f2910b;

    /* JADX INFO: renamed from: kX */
    private final int f2911kX;

    /* JADX INFO: renamed from: dg */
    static final /* synthetic */ boolean f2912dg;

    static {
        f2912dg = !C0469iE.class.desiredAssertionStatus();
        f2903di = C0532jO.m2378d("textures/misc/debug/sound_ambient.png");
    }

    public C0469iE(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, @NotNull Vec3 vec3, float f, @NotNull C0838pC c0838pC, int i) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f2907gX = 0.0f;
        this.f2908gY = 0.0f;
        this.f2905c = minecraft;
        this.f2906l = abstractC0863pb.m4064e();
        this.pitch = f;
        this.f2909s = vec3;
        this.f2910b = c0838pC;
        this.f2911kX = i;
        this.looping = true;
        this.volume = 0.0f;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    /* JADX INFO: renamed from: f */
    public void m2134f(float f) {
        this.f2908gY = f;
    }

    public boolean canPlaySound() {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2912dg && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        return abstractC0863pbM2874a != null && abstractC0863pbM2874a.m4064e().equals(this.f2906l);
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.f2907gX = C1270xJ.m7161d(this.f2907gX, this.f2908gY, 0.025f);
        this.volume = Mth.clamp(this.f2907gX * C0112bc.f754bL, 0.001f, 1.0f);
        Entity cameraEntity = this.f2905c.getCameraEntity();
        if (cameraEntity != null) {
            float fM3841aS = this.f2910b.m3841aS() + (((this.f2911kX * 2.0f) * 3.1415927f) / 3.0f);
            Vec3 vec3Add = cameraEntity.position().add(new Vec3((float) ((this.f2909s.x * Math.cos(fM3841aS)) - (this.f2909s.z * Math.sin(fM3841aS))), this.f2909s.y, (float) ((this.f2909s.x * Math.sin(fM3841aS)) + (this.f2909s.z * Math.cos(fM3841aS)))));
            this.x = vec3Add.x;
            this.y = vec3Add.y + 32.0d;
            this.z = vec3Add.z;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2135a(@Nonnull PoseStack poseStack, @Nonnull GuiGraphics guiGraphics, @Nonnull Camera camera) {
        C0129bt.m603a(poseStack, camera, guiGraphics, f2903di, this.x, this.y, this.z, 32);
    }
}
