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

/* JADX INFO: renamed from: com.boehmod.blockfront.in, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/in.class */
public class C0230in extends AbstractTickableSoundInstance {
    private static final float gB = 0.025f;

    @Nonnull
    private static final ResourceLocation di;
    private static final int jB = 32;

    @NotNull
    private final Minecraft d;

    @NotNull
    private final UUID l;
    private float gC;
    private float gD;

    @NotNull
    private final Vec3 s;

    @NotNull
    private final C0412pg b;
    private final int jC;
    static final /* synthetic */ boolean cX;

    static {
        cX = !C0230in.class.desiredAssertionStatus();
        di = C0265jv.d("textures/misc/debug/sound_ambient.png");
    }

    public C0230in(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, @NotNull Vec3 vec3, float f, @NotNull C0412pg c0412pg, int i) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.gC = 0.0f;
        this.gD = 0.0f;
        this.d = minecraft;
        this.l = oFVar.m757e();
        this.pitch = f;
        this.s = vec3;
        this.b = c0412pg;
        this.jC = i;
        this.looping = true;
        this.volume = 0.0f;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public void h(float f) {
        this.gD = f;
    }

    public boolean canPlaySound() {
        C0297l c0297lB = C0297l.b();
        if (!cX && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        return oFVarM591a != null && oFVarM591a.m757e().equals(this.l);
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.gC = C0634xm.d(this.gC, this.gD, 0.025f);
        this.volume = Mth.clamp(this.gC * aU.bF, 0.001f, 1.0f);
        Entity cameraEntity = this.d.getCameraEntity();
        if (cameraEntity != null) {
            float fAM = this.b.aM() + (((this.jC * 2.0f) * 3.1415927f) / 3.0f);
            Vec3 vec3Add = cameraEntity.position().add(new Vec3((float) ((this.s.x * Math.cos(fAM)) - (this.s.z * Math.sin(fAM))), this.s.y, (float) ((this.s.x * Math.sin(fAM)) + (this.s.z * Math.cos(fAM)))));
            this.x = vec3Add.x;
            this.y = vec3Add.y + 32.0d;
            this.z = vec3Add.z;
        }
    }

    public void a(@Nonnull PoseStack poseStack, @Nonnull GuiGraphics guiGraphics, @Nonnull Camera camera) {
        C0040bk.a(poseStack, camera, guiGraphics, di, this.x, this.y, this.z, 32);
    }
}
