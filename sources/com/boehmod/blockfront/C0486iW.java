package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.ActivatedCloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCape;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCase;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iW.class */
public class C0486iW {
    @NotNull
    /* JADX INFO: renamed from: a */
    public static Screen m2213a(@NotNull Screen screen, @NotNull C0622l c0622l, @NotNull CloudItemStack cloudItemStack, int i, int i2) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(c0622l.m2670a());
        if (cloudItem instanceof CloudItemCape) {
            return new C0087bE(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof CloudItemCase) {
            return new C0088bF(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof AbstractCloudItemCoin) {
            return new C0089bG(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof ActivatedCloudItem) {
            return new C0086bD(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        return new C0085bC(screen, cloudItemStack, i + 2, i2 + 2, 80, 12);
    }
}
