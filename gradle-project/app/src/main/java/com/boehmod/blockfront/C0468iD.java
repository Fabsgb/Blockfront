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

/* JADX INFO: renamed from: com.boehmod.blockfront.iD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iD.class */
public class C0468iD extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: bY */
    private float f2899bY;

    /* JADX INFO: renamed from: bZ */
    private float f2900bZ;

    /* JADX INFO: renamed from: df */
    static final /* synthetic */ boolean f2901df;

    static {
        f2901df = !C0468iD.class.desiredAssertionStatus();
    }

    public C0468iD(@NotNull SoundEvent soundEvent) {
        super(soundEvent, SoundSource.PLAYERS, SoundInstance.createUnseededRandom());
        this.f2900bZ = 0.0f;
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
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2901df && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        if (c0623lM2852b.m2895a().m3074aJ()) {
            this.volume = 0.0f;
        } else {
            m2130g(localPlayer);
            m2131h(localPlayer);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m2130g(@NotNull LocalPlayer localPlayer) {
        Vec3 vec3Position = localPlayer.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
    }

    /* JADX INFO: renamed from: h */
    private void m2131h(@NotNull LocalPlayer localPlayer) {
        float xRot = localPlayer.getXRot();
        float yRot = localPlayer.getYRot();
        float f = this.f2899bY - xRot;
        float f2 = this.f2900bZ - yRot;
        boolean z = !localPlayer.isCreative();
        m2132i(localPlayer);
        if (z) {
            m2133a(f, f2);
        }
        if (this.volume > 1.0f) {
            this.volume = 1.0f;
        }
        this.volume = Mth.lerp(0.2f, this.volume, 0.0f);
        this.f2899bY = xRot;
        this.f2900bZ = yRot;
    }

    /* JADX INFO: renamed from: i */
    private void m2132i(@NotNull LocalPlayer localPlayer) {
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1117uP) && C0486iV.m2182aa()) {
            this.volume += 0.005f;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2133a(float f, float f2) {
        if (this.volume >= 1.0f) {
            return;
        }
        float fAbs = Mth.abs(C0112bc.f746bD - C0112bc.f747bE);
        this.volume += 0.002f * C0112bc.f746bD;
        this.volume += Mth.abs(f * 0.005f) + Mth.abs(f2 * 0.005f) + fAbs;
        this.volume += Mth.abs(C0115bf.f780bU - C0115bf.f781bV);
    }
}
