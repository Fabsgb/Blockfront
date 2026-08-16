package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jO.class */
public class C0532jO {
    @NotNull
    /* JADX INFO: renamed from: d */
    public static ResourceLocation m2378d(@NotNull String str) {
        return ResourceLocation.fromNamespaceAndPath("bf", str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m2379a(@NotNull CloudResourceLocation cloudResourceLocation) {
        return ResourceLocation.fromNamespaceAndPath(cloudResourceLocation.namespace(), cloudResourceLocation.path());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static CloudResourceLocation m2380a(@NotNull ResourceLocation resourceLocation) {
        return new CloudResourceLocation(resourceLocation.getNamespace(), resourceLocation.getPath());
    }
}
