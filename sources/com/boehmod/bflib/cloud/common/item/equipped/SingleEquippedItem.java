package com.boehmod.bflib.cloud.common.item.equipped;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.packet.PacketRegistry;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/equipped/SingleEquippedItem.class */
public class SingleEquippedItem extends BaseEquippedItem {

    @NotNull
    private UUID cloudStackUUID = PacketRegistry.EMPTY_UUID;

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    public void clearStack(@NotNull String key) {
        this.cloudStackUUID = PacketRegistry.EMPTY_UUID;
    }

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    @Nullable
    public UUID getStack(@Nullable String key) {
        return this.cloudStackUUID;
    }

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    @OverridingMethodsMustInvokeSuper
    public void setCloudStackUUID(@NotNull UUID stackUUID, @NotNull CloudItem<?> cloudItem) {
        this.cloudStackUUID = stackUUID;
    }

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    @NotNull
    public Set<UUID> getCloudStackUUIDs() {
        return Collections.singleton(this.cloudStackUUID);
    }
}
