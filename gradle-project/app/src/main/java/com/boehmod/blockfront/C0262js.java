package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/* JADX INFO: renamed from: com.boehmod.blockfront.js, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/js.class */
public class C0262js {
    public static boolean ab() {
        return FMLEnvironment.dist == Dist.CLIENT;
    }

    public static boolean ac() {
        return FMLEnvironment.dist == Dist.DEDICATED_SERVER;
    }

    @Nullable
    public static MinecraftServer a() {
        return ServerLifecycleHooks.getCurrentServer();
    }
}
