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

/* JADX INFO: renamed from: com.boehmod.blockfront.im */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/im.class */
public class C0502im extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: bS */
    private float f3003bS;

    /* JADX INFO: renamed from: bT */
    private float f3004bT;

    /* JADX INFO: renamed from: cW */
    static final /* synthetic */ boolean f3005cW;

    static {
        f3005cW = !C0502im.class.desiredAssertionStatus();
    }

    public C0502im(@NotNull SoundEvent soundEvent) {
        super(soundEvent, SoundSource.PLAYERS, SoundInstance.createUnseededRandom());
        this.f3004bT = 0.0f;
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
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3005cW && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        if (c0622lM2667b.m2709a().m3241ay()) {
            this.volume = 0.0f;
        } else {
            m2242g(localPlayer);
            m2243h(localPlayer);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m2242g(@NotNull LocalPlayer localPlayer) {
        Vec3 vec3Position = localPlayer.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
    }

    /* JADX INFO: renamed from: h */
    private void m2243h(@NotNull LocalPlayer localPlayer) {
        float xRot = localPlayer.getXRot();
        float yRot = localPlayer.getYRot();
        float f = this.f3003bS - xRot;
        float f2 = this.f3004bT - yRot;
        boolean z = !localPlayer.isCreative();
        m2244i(localPlayer);
        if (z) {
            m2245a(f, f2);
        }
        if (this.volume > 1.0f) {
            this.volume = 1.0f;
        }
        this.volume = Mth.lerp(0.2f, this.volume, 0.0f);
        this.f3003bS = xRot;
        this.f3004bT = yRot;
    }

    /* JADX INFO: renamed from: i */
    private void m2244i(@NotNull LocalPlayer localPlayer) {
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1144ur) && C1144ur.m6311f(mainHandItem)) {
            this.volume += 0.005f;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2245a(float f, float f2) {
        if (this.volume >= 1.0f) {
            return;
        }
        float fAbs = Mth.abs(C0050aU.f332bx - C0050aU.f333by);
        this.volume += 0.002f * C0050aU.f332bx;
        this.volume += Mth.abs(f * 0.005f) + Mth.abs(f2 * 0.005f) + fAbs;
        this.volume += Mth.abs(C0053aX.f366bO - C0053aX.f367bP);
    }
}
