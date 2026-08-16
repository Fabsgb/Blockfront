package com.boehmod.bflib.cloud.common.item;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/CloudInventoryFilter.class */
public class CloudInventoryFilter {
    @NotNull
    public static List<CloudItemStack> filterByRarity(@NotNull CloudRegistry cloudRegistry, @NotNull Collection<CloudItemStack> itemStacks) {
        Map<CloudItemRarity, List<CloudItemStack>> groupedByRarity = (Map) itemStacks.stream().filter(stack -> {
            return stack.getCloudItem(cloudRegistry) != null;
        }).collect(Collectors.groupingBy(stack2 -> {
            return stack2.getCloudItem(cloudRegistry).getRarity();
        }));
        return Arrays.stream(CloudItemRarity.values()).sorted(Collections.reverseOrder()).flatMap(rarity -> {
            return ((List) groupedByRarity.getOrDefault(rarity, List.of())).stream();
        }).toList();
    }

    @NotNull
    public static List<CloudItemStack> filterByType(@NotNull CloudRegistry cloudRegistry, @NotNull Collection<CloudItemStack> cloudItemStacks, @NotNull CloudItemType cloudItemType) {
        return cloudItemStacks.stream().filter(stack -> {
            CloudItem<?> cloudItem = stack.getCloudItem(cloudRegistry);
            return cloudItem != null && cloudItem.getItemType() == cloudItemType;
        }).toList();
    }

    @NotNull
    public static List<CloudItemStack> filterOutDefaults(@NotNull CloudRegistry cloudRegistry, @NotNull Collection<CloudItemStack> itemStacks) {
        return itemStacks.stream().filter(stack -> {
            CloudItem<?> cloudItem = stack.getCloudItem(cloudRegistry);
            return (cloudItem == null || cloudItem.isDefault()) ? false : true;
        }).toList();
    }
}
