package com.boehmod.bflib.cloud.common.item.equipped;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/equipped/MultiEquippedItem.class */
public class MultiEquippedItem extends BaseEquippedItem {

    @NotNull
    protected final Object2ObjectMap<String, UUID> equippedItemsMap = new Object2ObjectOpenHashMap();

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    public void clearStack(@NotNull String key) {
        this.equippedItemsMap.remove(key);
    }

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    @Nullable
    public UUID getStack(@Nullable String key) {
        if (key == null) {
            return null;
        }
        return (UUID) this.equippedItemsMap.get(key);
    }

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    @OverridingMethodsMustInvokeSuper
    public void setCloudStackUUID(@NotNull UUID stackUUID, @NotNull CloudItem<?> cloudItem) {
        String key = cloudItem.getMinecraftItem().toString();
        this.equippedItemsMap.put(key, stackUUID);
    }

    @Override // com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem
    @NotNull
    public Set<UUID> getCloudStackUUIDs() {
        return new HashSet((Collection) this.equippedItemsMap.values());
    }
}
