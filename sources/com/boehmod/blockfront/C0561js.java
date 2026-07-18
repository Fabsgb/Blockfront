package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/* JADX INFO: renamed from: com.boehmod.blockfront.js */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/js.class */
public class C0561js {
    /* JADX INFO: renamed from: ab */
    public static boolean m2512ab() {
        return FMLEnvironment.dist == Dist.CLIENT;
    }

    /* JADX INFO: renamed from: ac */
    public static boolean m2513ac() {
        return FMLEnvironment.dist == Dist.DEDICATED_SERVER;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static MinecraftServer m2514a() {
        return ServerLifecycleHooks.getCurrentServer();
    }
}
