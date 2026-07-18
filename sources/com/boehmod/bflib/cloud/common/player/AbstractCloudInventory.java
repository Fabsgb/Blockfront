package com.boehmod.bflib.cloud.common.player;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.equipped.BaseEquippedItem;
import com.boehmod.bflib.cloud.common.item.equipped.MultiEquippedItem;
import com.boehmod.bflib.cloud.common.item.equipped.SingleEquippedItem;
import com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/AbstractCloudInventory.class */
public class AbstractCloudInventory<P extends AbstractPlayerCloudData<?, ?>> {
    protected static final int INVENTORY_SPLITS_AT = 64;
    private static final int SHOWCASE_SIZE = 5;

    @NotNull
    protected final P playerData;

    @NotNull
    private final Object2ObjectMap<UUID, CloudItemStack> inventory = new Object2ObjectLinkedOpenHashMap();

    @NotNull
    private final ObjectLinkedOpenHashSet<UUID> showcasedItems = new ObjectLinkedOpenHashSet<>();

    @NotNull
    private final Object2ObjectMap<CloudItemType, BaseEquippedItem> equippedItemStacks = new Object2ObjectOpenHashMap();

    public AbstractCloudInventory(@NotNull P playerData) {
        this.playerData = playerData;
    }

    @NotNull
    public ObjectList<CloudItemStack> getItemsSorted(@NotNull CloudRegistry cloudRegistry) {
        ObjectArrayList objectArrayList = new ObjectArrayList(this.inventory.values());
        Comparator<CloudItemStack> comparator = Comparator.comparingInt(o -> {
            CloudItem<?> cloudItem = o.getCloudItem(cloudRegistry);
            if (cloudItem != null) {
                return cloudItem.getId();
            }
            return 0;
        });
        objectArrayList.sort(comparator);
        return ObjectLists.unmodifiable(objectArrayList);
    }

    @NotNull
    public Optional<CloudItemStack> getStackFromUUID(@NotNull UUID uuid) {
        return Optional.ofNullable((CloudItemStack) this.inventory.get(uuid));
    }

    public boolean hasItem(@NotNull CloudRegistry cloudRegistry, @NotNull CloudItem<?> cloudItem) {
        Stream map = this.inventory.values().stream().map(cloudItemStack -> {
            return cloudItemStack.getCloudItem(cloudRegistry);
        });
        Objects.requireNonNull(cloudItem);
        return map.anyMatch((v1) -> {
            return r1.equals(v1);
        });
    }

    @NotNull
    public Collection<CloudItemStack> getItems() {
        return Collections.unmodifiableCollection(this.inventory.values());
    }

    @NotNull
    public ObjectList<CloudItemStack> getItems(@NotNull CloudRegistry cloudRegistry, @NotNull CloudItemType type) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectIterator it = this.inventory.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<UUID, CloudItemStack> entry = (Map.Entry) it.next();
            CloudItemStack cloudItemStack = entry.getValue();
            CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
            if (cloudItem != null && cloudItem.getItemType() == type) {
                objectArrayList.add(cloudItemStack);
            }
        }
        return objectArrayList;
    }

    public long getCountForItem(@NotNull CloudRegistry cloudRegistry, @NotNull CloudItem<?> item) {
        return this.inventory.values().stream().filter(invItem -> {
            return invItem.getCloudItem(cloudRegistry) == item;
        }).count();
    }

    public int getInventorySplits() {
        long count = 0;
        int bound = getSize();
        for (int i = 0; i < bound; i++) {
            if (i != 0 && i % 64 == 0) {
                count++;
            }
        }
        return (int) count;
    }

    public long getSizeNoDefaults(@NotNull CloudRegistry cloudRegistry) {
        return this.inventory.values().stream().filter(itemStack -> {
            CloudItem<?> cloudItem = itemStack.getCloudItem(cloudRegistry);
            return (cloudItem == null || cloudItem.isDefault()) ? false : true;
        }).count();
    }

    public boolean hasItemStack(@NotNull UUID uuid) {
        return this.inventory.containsKey(uuid);
    }

    public int getSize() {
        return this.inventory.size();
    }

    public void onReceiveSection(@NotNull List<CloudItemStack> itemStacks, int section) {
        if (section == 0) {
            this.inventory.clear();
        }
        for (CloudItemStack itemStack : itemStacks) {
            this.inventory.put(itemStack.getUUID(), itemStack);
        }
    }

    public void onReceiveMinimalStacks(@NotNull List<CloudItemStack> itemStacks) {
        for (CloudItemStack itemStack : itemStacks) {
            this.inventory.put(itemStack.getUUID(), itemStack);
        }
    }

    public void populateDeprecatedItems(@NotNull CloudRegistry cloudRegistry, @NotNull List<CloudItemStack> removedStacks) {
        Stream streamFilter = this.inventory.values().stream().filter(stack -> {
            CloudItem<?> cloudItem = stack.getCloudItem(cloudRegistry);
            return cloudItem != null && cloudItem.isDeprecated();
        });
        Objects.requireNonNull(removedStacks);
        streamFilter.forEach((v1) -> {
            r1.add(v1);
        });
    }

    @NotNull
    public ObjectSet<UUID> getShowcasedItems() {
        return ObjectSets.unmodifiable(this.showcasedItems);
    }

    public void addShowcasedItem(@NotNull CloudItemStack itemStack) {
        addShowcasedItem(itemStack.getUUID());
    }

    @OverridingMethodsMustInvokeSuper
    public void populateShowcasedItems(@NotNull Set<UUID> itemStacks) {
        this.showcasedItems.clear();
        this.showcasedItems.addAll(itemStacks);
    }

    @OverridingMethodsMustInvokeSuper
    public void addShowcasedItem(@NotNull UUID itemStack) {
        this.showcasedItems.add(itemStack);
        while (this.showcasedItems.size() > 5) {
            this.showcasedItems.remove(this.showcasedItems.getFirst());
        }
    }

    public void removeShowcasedItem(@NotNull CloudItemStack itemStack) {
        removeShowcasedItems(Collections.singleton(itemStack.getUUID()));
    }

    @OverridingMethodsMustInvokeSuper
    public void removeShowcasedItems(@NotNull Set<UUID> itemStacks) {
        this.showcasedItems.removeAll(itemStacks);
    }

    public boolean isItemShowcased(@NotNull UUID itemStack) {
        return this.showcasedItems.contains(itemStack);
    }

    public boolean isItemShowcased(@NotNull CloudItemStack itemStack) {
        return isItemShowcased(itemStack.getUUID());
    }

    @OverridingMethodsMustInvokeSuper
    public void addItemStackLocal(@NotNull CloudItemStack itemStack) {
        this.inventory.put(itemStack.getUUID(), itemStack);
    }

    @OverridingMethodsMustInvokeSuper
    public void removeItemStackLocal(@NotNull UUID itemStack) {
        this.inventory.remove(itemStack);
    }

    public boolean hasEquippedItems() {
        return !this.equippedItemStacks.isEmpty();
    }

    @NotNull
    public BaseEquippedItem getEquippedItems(@NotNull CloudItemType itemType) {
        return (BaseEquippedItem) this.equippedItemStacks.computeIfAbsent(itemType, type -> {
            switch (itemType) {
                case GUN:
                case MELEE:
                    return new MultiEquippedItem();
                default:
                    return new SingleEquippedItem();
            }
        });
    }

    @NotNull
    public ObjectSet<UUID> getEquippedItemStacks() {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        ObjectIterator it = this.equippedItemStacks.values().iterator();
        while (it.hasNext()) {
            BaseEquippedItem equippedItem = (BaseEquippedItem) it.next();
            objectOpenHashSet.addAll(equippedItem.getCloudStackUUIDs());
        }
        return objectOpenHashSet;
    }

    public void populateEquippedItems(@NotNull CloudRegistry cloudRegistry, @NotNull Set<UUID> itemStacks) {
        clearEquippedItemStacks();
        addEquippedItemStacks(cloudRegistry, itemStacks);
    }

    public int getSkinCount(@Nonnull CloudRegistry cloudRegistry) {
        return this.inventory.values().stream().mapToInt(stack -> {
            CloudItem<?> cloudItem = stack.getCloudItem(cloudRegistry);
            if (cloudItem == null) {
                return 0;
            }
            boolean isSkinItem = cloudItem.getItemType() == CloudItemType.GUN || cloudItem.getItemType() == CloudItemType.MELEE;
            boolean isDefaultItem = cloudItem.isDefault();
            return (!isSkinItem || isDefaultItem) ? 0 : 1;
        }).sum();
    }

    @OverridingMethodsMustInvokeSuper
    private void clearEquippedItemStacks() {
        this.equippedItemStacks.clear();
    }

    @OverridingMethodsMustInvokeSuper
    private void addEquippedItemStacks(@NotNull CloudRegistry cloudRegistry, @NotNull Set<UUID> itemStacks) {
        CloudItem<?> cloudItem;
        for (UUID itemStack : itemStacks) {
            Optional<CloudItemStack> stack = getStackFromUUID(itemStack);
            if (stack.isPresent() && (cloudItem = stack.get().getCloudItem(cloudRegistry)) != null) {
                BaseEquippedItem equippedItem = getEquippedItems(cloudItem.getItemType());
                equippedItem.setCloudStackUUID(itemStack, cloudItem);
            }
        }
    }
}
