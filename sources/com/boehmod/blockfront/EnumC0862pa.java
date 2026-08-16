package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pa.class */
public enum EnumC0862pa {
    GENERIC(16.0f, 2.0f, 0, new Vec2(0.1f, 1.5f), C0808oZ.f4368a, C0435hX.f2763m, C0435hX.f2764n, true, true, 1.5f, 8.0f),
    GORE_EXPLOSION(6.0f, 2.0f, 0, Vec2.ZERO, C0808oZ.f4368a, null, null, false, false, 0.0f, 0.0f),
    ARTILLERY_EXPLOSION(32.0f, 4.0f, 2, new Vec2(0.2f, 1.5f), C0808oZ.f4369b, C0435hX.f2763m, C0435hX.f2764n, true, true, 3.0f, 32.0f),
    VEHICLE_EXPLOSION(16.0f, 4.0f, 2, new Vec2(0.2f, 1.5f), C0808oZ.f4368a, C0435hX.f2763m, C0435hX.f2764n, true, true, 2.0f, 16.0f),
    LANDMINE_EXPLOSION(16.0f, 3.0f, 2, new Vec2(0.2f, 1.5f), C0808oZ.f4368a, C0435hX.f2763m, C0435hX.f2764n, true, true, 2.0f, 8.0f);

    private final boolean shouldDisplayBlockDamage;
    private final float maxDistance;
    private final float power;
    private final int blockDamageRadius;
    private final boolean emitLight;
    public final float lightBrightness;
    public final float lightRadius;

    @NotNull
    final Vec2 blockDamageMotion;

    @NotNull
    final C0807oY audioConfig;

    @Nullable
    final C0434hW shakeNodeData;

    @Nullable
    final C0434hW shakeNodeFaintData;

    EnumC0862pa(float f, @NotNull float f2, @NotNull int i, @Nullable Vec2 vec2, @Nullable C0807oY c0807oY, C0434hW c0434hW, C0434hW c0434hW2, boolean z, boolean z2, float f3, float f4) {
        this.maxDistance = f;
        this.power = f2;
        this.blockDamageRadius = i;
        this.blockDamageMotion = vec2;
        this.audioConfig = c0807oY;
        this.shakeNodeData = c0434hW;
        this.shakeNodeFaintData = c0434hW2;
        this.shouldDisplayBlockDamage = z;
        this.emitLight = z2;
        this.lightBrightness = f3;
        this.lightRadius = f4;
    }

    public float getMaxDistance() {
        return this.maxDistance;
    }

    public float getPower() {
        return this.power;
    }

    public int getBlockDamageRadius() {
        return this.blockDamageRadius;
    }

    @NotNull
    public Vec2 getBlockDamageMotion() {
        return this.blockDamageMotion;
    }

    @NotNull
    public C0807oY getAudioConfig() {
        return this.audioConfig;
    }

    @Nullable
    public C0434hW getShakeNodeData() {
        return this.shakeNodeData;
    }

    @Nullable
    public C0434hW getShakeNodeFaintData() {
        return this.shakeNodeFaintData;
    }

    public boolean shouldDisplayBlockDamage() {
        return this.shouldDisplayBlockDamage;
    }

    public boolean emitsLight() {
        return this.emitLight;
    }

    public float getLightBrightness() {
        return this.lightBrightness;
    }

    public float getLightRadius() {
        return this.lightRadius;
    }
}
