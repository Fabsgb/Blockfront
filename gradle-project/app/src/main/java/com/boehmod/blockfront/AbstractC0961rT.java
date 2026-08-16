package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rT.class */
public abstract class AbstractC0961rT extends AbstractC0954rM {

    /* JADX INFO: renamed from: af */
    @NotNull
    protected final Vec3 f5347af;

    public AbstractC0961rT(@Nullable ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, i, i2);
        this.f5347af = vec3;
    }
}
