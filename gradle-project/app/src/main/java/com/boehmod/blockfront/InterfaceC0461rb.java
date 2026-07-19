package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rb.class */
public interface InterfaceC0461rb {
    void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3);

    void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull Vec3 vec3);
}
