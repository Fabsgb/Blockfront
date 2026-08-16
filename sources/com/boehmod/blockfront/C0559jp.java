package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.ActivatedCloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCape;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCase;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jp.class */
public class C0559jp {
    @NotNull
    /* JADX INFO: renamed from: a */
    public static Screen m2540a(@NotNull Screen screen, @NotNull C0623l c0623l, @NotNull CloudItemStack cloudItemStack, int i, int i2) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(c0623l.m2855a());
        if (cloudItem instanceof CloudItemCape) {
            return new C0097bN(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof CloudItemCase) {
            return new C0098bO(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof AbstractCloudItemCoin) {
            return new C0099bP(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        if (cloudItem instanceof ActivatedCloudItem) {
            return new C0096bM(screen, i + 2, i2 + 2, 80, 12, cloudItemStack);
        }
        return new C0095bL(screen, cloudItemStack, i + 2, i2 + 2, 80, 12);
    }
}
