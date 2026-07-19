package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.ActivatedCloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCape;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCase;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iW.class */
public class iW {
    @NotNull
    public static Screen a(@NotNull Screen screen, @NotNull C0297l c0297l, @NotNull CloudItemStack cloudItemStack, int i, int i2) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(c0297l.a());
        if (cloudItem instanceof CloudItemCape) {
            return new bE(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof CloudItemCase) {
            return new bF(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof AbstractCloudItemCoin) {
            return new bG(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof ActivatedCloudItem) {
            return new bD(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        return new bC(screen, cloudItemStack, i + 2, i2 + 2, 80, 12);
    }
}
