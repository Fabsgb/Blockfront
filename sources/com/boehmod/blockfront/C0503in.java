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

/* JADX INFO: renamed from: com.boehmod.blockfront.in */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/in.class */
public class C0503in extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: gB */
    private static final float f3006gB = 0.025f;

    /* JADX INFO: renamed from: di */
    @Nonnull
    private static final ResourceLocation f3007di;

    /* JADX INFO: renamed from: jB */
    private static final int f3008jB = 32;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Minecraft f3009d;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final UUID f3010l;

    /* JADX INFO: renamed from: gC */
    private float f3011gC;

    /* JADX INFO: renamed from: gD */
    private float f3012gD;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Vec3 f3013s;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0867pg f3014b;

    /* JADX INFO: renamed from: jC */
    private final int f3015jC;

    /* JADX INFO: renamed from: cX */
    static final /* synthetic */ boolean f3016cX;

    static {
        f3016cX = !C0503in.class.desiredAssertionStatus();
        f3007di = C0564jv.m2555d("textures/misc/debug/sound_ambient.png");
    }

    public C0503in(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, @NotNull Vec3 vec3, float f, @NotNull C0867pg c0867pg, int i) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f3011gC = 0.0f;
        this.f3012gD = 0.0f;
        this.f3009d = minecraft;
        this.f3010l = abstractC0787oF.m3628e();
        this.pitch = f;
        this.f3013s = vec3;
        this.f3014b = c0867pg;
        this.f3015jC = i;
        this.looping = true;
        this.volume = 0.0f;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    /* JADX INFO: renamed from: h */
    public void m2246h(float f) {
        this.f3012gD = f;
    }

    public boolean canPlaySound() {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3016cX && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        return abstractC0787oFM2688a != null && abstractC0787oFM2688a.m3628e().equals(this.f3010l);
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.f3011gC = C1290xm.m7835d(this.f3011gC, this.f3012gD, 0.025f);
        this.volume = Mth.clamp(this.f3011gC * C0050aU.f340bF, 0.001f, 1.0f);
        Entity cameraEntity = this.f3009d.getCameraEntity();
        if (cameraEntity != null) {
            float fM4356aM = this.f3014b.m4356aM() + (((this.f3015jC * 2.0f) * 3.1415927f) / 3.0f);
            Vec3 vec3Add = cameraEntity.position().add(new Vec3((float) ((this.f3013s.x * Math.cos(fM4356aM)) - (this.f3013s.z * Math.sin(fM4356aM))), this.f3013s.y, (float) ((this.f3013s.x * Math.sin(fM4356aM)) + (this.f3013s.z * Math.cos(fM4356aM)))));
            this.x = vec3Add.x;
            this.y = vec3Add.y + 32.0d;
            this.z = vec3Add.z;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2247a(@Nonnull PoseStack poseStack, @Nonnull GuiGraphics guiGraphics, @Nonnull Camera camera) {
        C0119bk.m503a(poseStack, camera, guiGraphics, f3007di, this.x, this.y, this.z, 32);
    }
}
