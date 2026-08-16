package com.boehmod.bflib.cloud.common.item.equipped;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import java.util.Set;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/equipped/BaseEquippedItem.class */
public abstract class BaseEquippedItem {
    public abstract void clearStack(@NotNull String str);

    @Nullable
    public abstract UUID getStack(@Nullable String str);

    @OverridingMethodsMustInvokeSuper
    public abstract void setCloudStackUUID(@NotNull UUID uuid, @NotNull CloudItem<?> cloudItem);

    @NotNull
    public abstract Set<UUID> getCloudStackUUIDs();

    public void clearStack(@NotNull CloudResourceLocation cloudResourceLocation) {
        clearStack(cloudResourceLocation.toString());
    }

    @Nullable
    public UUID getStack(@NotNull CloudResourceLocation cloudResourceLocation) {
        return getStack(cloudResourceLocation.toString());
    }
}
