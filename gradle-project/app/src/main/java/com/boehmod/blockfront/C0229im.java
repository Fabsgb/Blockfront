package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.im, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/im.class */
public class C0229im extends AbstractTickableSoundInstance {
    private float bS;
    private float bT;
    static final /* synthetic */ boolean cW;

    static {
        cW = !C0229im.class.desiredAssertionStatus();
    }

    public C0229im(@NotNull SoundEvent soundEvent) {
        super(soundEvent, SoundSource.PLAYERS, SoundInstance.createUnseededRandom());
        this.bT = 0.0f;
        this.looping = true;
        this.attenuation = SoundInstance.Attenuation.NONE;
        this.volume = 0.0f;
    }

    public boolean canPlaySound() {
        return Minecraft.getInstance().player != null;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        C0297l c0297lB = C0297l.b();
        if (!cW && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        if (c0297lB.m602a().ay()) {
            this.volume = 0.0f;
        } else {
            g(localPlayer);
            h(localPlayer);
        }
    }

    private void g(@NotNull LocalPlayer localPlayer) {
        Vec3 vec3Position = localPlayer.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
    }

    private void h(@NotNull LocalPlayer localPlayer) {
        float xRot = localPlayer.getXRot();
        float yRot = localPlayer.getYRot();
        float f = this.bS - xRot;
        float f2 = this.bT - yRot;
        boolean z = !localPlayer.isCreative();
        i(localPlayer);
        if (z) {
            a(f, f2);
        }
        if (this.volume > 1.0f) {
            this.volume = 1.0f;
        }
        this.volume = Mth.lerp(0.2f, this.volume, 0.0f);
        this.bS = xRot;
        this.bT = yRot;
    }

    private void i(@NotNull LocalPlayer localPlayer) {
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C0558ur) && C0558ur.m1202f(mainHandItem)) {
            this.volume += 0.005f;
        }
    }

    private void a(float f, float f2) {
        if (this.volume >= 1.0f) {
            return;
        }
        float fAbs = Mth.abs(aU.bx - aU.by);
        this.volume += 0.002f * aU.bx;
        this.volume += Mth.abs(f * 0.005f) + Mth.abs(f2 * 0.005f) + fAbs;
        this.volume += Mth.abs(aX.bO - aX.bP);
    }
}
