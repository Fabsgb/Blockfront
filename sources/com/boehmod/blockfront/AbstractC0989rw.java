package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rw.class */
public abstract class AbstractC0989rw extends AbstractC0982rp {

    /* JADX INFO: renamed from: ae */
    @NotNull
    protected final Vec3 f5243ae;

    public AbstractC0989rw(@Nullable ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, i, i2);
        this.f5243ae = vec3;
    }
}
