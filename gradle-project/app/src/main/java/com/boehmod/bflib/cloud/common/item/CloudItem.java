package com.boehmod.bflib.cloud.common.item;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.common.RandomCollection;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/CloudItem.class */
public class CloudItem<T extends CloudItem<T>> {

    @NotNull
    private static final String DEFAULT_SUFFIX = "Default";

    @Nullable
    private static Map<CloudItemRarity, List<CloudItem<?>>> cachedItemsByRarity = null;

    @Nullable
    private static RandomCollection<CloudItemRarity> cachedRarityCollection = null;
    private final int id;

    @NotNull
    private final CloudResourceLocation cloudResourceLocation;

    @NotNull
    private final String name;

    @Nullable
    private String author = null;

    @NotNull
    private String suffix = "Default";

    @Nullable
    private String collection = null;

    @NotNull
    private String displaySuffix = "Default".toLowerCase(Locale.ROOT);
    private float skin = 0.0f;
    private boolean isDefault = false;
    private boolean canEquip = true;
    private boolean canShowcase = true;
    private boolean deprecated = false;

    @NotNull
    private CloudItemType cloudItemType = CloudItemType.GENERIC;

    @NotNull
    private CloudItemRarity rarity = CloudItemRarity.DEFAULT;

    public CloudItem(int id, @NotNull String name, @NotNull CloudResourceLocation cloudResourceLocation) {
        this.id = id;
        this.name = name;
        this.cloudResourceLocation = cloudResourceLocation;
        if (CloudItems.CLOUD_ITEMS.containsKey(id)) {
            throw new IllegalArgumentException("Cloud item with ID " + id + " already exists!");
        }
        CloudItems.CLOUD_ITEMS.put(id, this);
    }

    @Nullable
    public static CloudItem<?> getItemFromSkinId(@NotNull CloudRegistry cloudRegistry, @NotNull CloudResourceLocation cloudResourceLocation, float skinId) {
        return cloudRegistry.getItems().stream().filter(cloudItem -> {
            return cloudItem.getMinecraftItem().equals(cloudResourceLocation) && cloudItem.getSkin() == skinId;
        }).findFirst().orElse(null);
    }

    @NotNull
    public static CloudItemStack getRandomDrop(@NotNull CloudRegistry cloudRegistry) {
        if (cachedItemsByRarity == null) {
            Map<CloudItemRarity, List<CloudItem<?>>> itemsByRarity = new EnumMap<>(CloudItemRarity.class);
            for (CloudItem<?> item : cloudRegistry.getItems()) {
                if (!item.isDefault() && !item.isDeprecated() && item.getRarity().getDropChance() > 0.0f && item.getItemType().getDropChance() > 0.0f) {
                    itemsByRarity.computeIfAbsent(item.getRarity(), k -> {
                        return new ObjectArrayList();
                    }).add(item);
                }
            }
            RandomCollection<CloudItemRarity> rarityCollection = new RandomCollection<>();
            for (Map.Entry<CloudItemRarity, List<CloudItem<?>>> entry : itemsByRarity.entrySet()) {
                rarityCollection.add(entry.getKey().getDropChance(), entry.getKey());
            }
            cachedItemsByRarity = itemsByRarity;
            cachedRarityCollection = rarityCollection;
        }
        CloudItemRarity selectedRarity = cachedRarityCollection.getRandom();
        List<CloudItem<?>> candidates = cachedItemsByRarity.get(selectedRarity);
        CloudItem<?> selectedItem = candidates.get(ThreadLocalRandom.current().nextInt(candidates.size()));
        return new CloudItemStack(selectedItem);
    }

    @Nullable
    public static CloudItem<?> getCloudItemFromMcItem(@NotNull CloudRegistry cloudRegistry, @NotNull CloudResourceLocation cloudResourceLocation) {
        for (CloudItem<?> item : cloudRegistry.getItems()) {
            if (item.getMinecraftItem().equals(cloudResourceLocation)) {
                return item;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    @NotNull
    public CloudResourceLocation getMinecraftItem() {
        return this.cloudResourceLocation;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public Optional<String> getAuthor() {
        return Optional.ofNullable(this.author);
    }

    @NotNull
    public T setAuthor(@NotNull String author) {
        this.author = author;
        return this;
    }

    @NotNull
    public String getSuffix() {
        return this.suffix;
    }

    @NotNull
    public T setSuffix(@NotNull String suffix) {
        this.suffix = suffix;
        this.displaySuffix = suffix.replace(" ", "_").toLowerCase(Locale.ROOT);
        return this;
    }

    @NotNull
    public CloudItemRarity getRarity() {
        return this.rarity;
    }

    @NotNull
    public T setRarity(@NotNull CloudItemRarity rarity) {
        this.rarity = rarity;
        return this;
    }

    @Nullable
    public String getCollection() {
        return this.collection;
    }

    @NotNull
    public T setCollection(@NotNull String collection) {
        this.collection = collection;
        return this;
    }

    @NotNull
    public String getSuffixForDisplay() {
        return this.displaySuffix;
    }

    @NotNull
    public T setDefault() {
        this.isDefault = true;
        return this;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void disableEquip() {
        this.canEquip = false;
    }

    public boolean canEquip() {
        return this.canEquip;
    }

    public void disableShowcase() {
        this.canShowcase = false;
    }

    public boolean canShowcase() {
        return this.canShowcase;
    }

    @NotNull
    public CloudItemType getItemType() {
        return this.cloudItemType;
    }

    @NotNull
    public T setItemType(@NotNull CloudItemType cloudItemType) {
        this.cloudItemType = cloudItemType;
        return this;
    }

    public boolean isDeprecated() {
        return this.deprecated;
    }

    @NotNull
    public T setDeprecated() {
        this.deprecated = true;
        return this;
    }

    public float getSkin() {
        return this.skin;
    }

    @NotNull
    public T setSkin(float skin) {
        this.skin = skin;
        return this;
    }

    @NotNull
    public String getDisplayName() {
        return getDisplayName(false);
    }

    @NotNull
    public String getDisplayName(boolean reversed) {
        String name = getName();
        String suffix = getSuffix();
        return suffix.isEmpty() ? name : reversed ? suffix + " " + name : name + " " + suffix;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CloudItem)) {
            return false;
        }
        CloudItem<?> cloudItem = (CloudItem) object;
        return cloudItem.getId() == getId();
    }
}
