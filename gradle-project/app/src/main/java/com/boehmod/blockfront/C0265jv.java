package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jv.class */
public class C0265jv {
    @NotNull
    public static ResourceLocation d(@NotNull String str) {
        return ResourceLocation.fromNamespaceAndPath("bf", str);
    }

    @NotNull
    public static ResourceLocation a(@NotNull CloudResourceLocation cloudResourceLocation) {
        return ResourceLocation.fromNamespaceAndPath(cloudResourceLocation.namespace(), cloudResourceLocation.path());
    }

    @NotNull
    public static CloudResourceLocation a(@NotNull ResourceLocation resourceLocation) {
        return new CloudResourceLocation(resourceLocation.getNamespace(), resourceLocation.getPath());
    }
}
