package com.boehmod.bflib.cloud.common;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectRBTreeMap;
import java.util.Collection;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/CloudRegistry.class */
public class CloudRegistry {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("CloudRegistry");

    @NotNull
    private final Int2ObjectMap<CloudAchievement> achievements = new Int2ObjectRBTreeMap();

    @NotNull
    private final Int2ObjectMap<CloudItem<?>> items = new Int2ObjectRBTreeMap();

    public void registerAchievements(@NotNull Collection<CloudAchievement> achievements) {
        LOGGER.info("Registering {} achievements", Integer.valueOf(achievements.size()));
        for (CloudAchievement achievement : achievements) {
            registerAchievement(achievement);
        }
        LOGGER.info("Registered {} achievements", Integer.valueOf(achievements.size()));
    }

    private void registerAchievement(@NotNull CloudAchievement achievement) {
        int achievementId = achievement.getId();
        if (this.achievements.containsKey(achievementId)) {
            LOGGER.error("Achievement with ID {} is already registered.", Integer.valueOf(achievementId));
            throw new IllegalArgumentException("Achievement with ID " + achievementId + " is already registered.");
        }
        this.achievements.put(achievementId, achievement);
    }

    @Nullable
    public CloudAchievement getAchievement(int id) {
        return (CloudAchievement) this.achievements.get(id);
    }

    @NotNull
    public Collection<CloudAchievement> getAchievements() {
        return Collections.unmodifiableCollection(this.achievements.values());
    }

    public void registerItems(@NotNull Collection<CloudItem<?>> items) {
        LOGGER.info("Registering {} items", Integer.valueOf(items.size()));
        for (CloudItem<?> item : items) {
            registerItem(item);
        }
        LOGGER.info("Registered {} items", Integer.valueOf(items.size()));
    }

    private void registerItem(@NotNull CloudItem<?> item) {
        int itemId = item.getId();
        if (this.items.containsKey(itemId)) {
            LOGGER.error("Item with ID {} is already registered.", Integer.valueOf(itemId));
            throw new IllegalArgumentException("Item with ID " + itemId + " is already registered.");
        }
        this.items.put(itemId, item);
    }

    @Nullable
    public CloudItem<?> getItem(int id) {
        return (CloudItem) this.items.get(id);
    }

    @NotNull
    public Collection<CloudItem<?>> getItems() {
        return Collections.unmodifiableCollection(this.items.values());
    }
}
