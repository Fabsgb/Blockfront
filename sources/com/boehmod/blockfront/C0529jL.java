package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/* JADX INFO: renamed from: com.boehmod.blockfront.jL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jL.class */
public class C0529jL {
    /* JADX INFO: renamed from: ae */
    public static boolean m2332ae() {
        return FMLEnvironment.dist == Dist.CLIENT;
    }

    /* JADX INFO: renamed from: af */
    public static boolean m2333af() {
        return FMLEnvironment.dist == Dist.DEDICATED_SERVER;
    }

    /* JADX INFO: renamed from: ag */
    public static boolean m2334ag() {
        return FMLEnvironment.production;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static MinecraftServer m2335a() {
        return ServerLifecycleHooks.getCurrentServer();
    }
}
