package software.bernie.geckolib.cache;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.level.saveddata.SavedData;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/cache/AnimatableIdCache.class */
public final class AnimatableIdCache extends SavedData {
    private static final SavedData.Factory<AnimatableIdCache> FACTORY = new SavedData.Factory<>(AnimatableIdCache::new, AnimatableIdCache::new, (DataFixTypes) null);
    private static final String DATA_KEY = "geckolib_id_cache";
    private long lastId;

    private AnimatableIdCache() {
    }

    private AnimatableIdCache(CompoundTag tag, HolderLookup.Provider registryLookup) {
        this.lastId = tag.getLong("last_id");
    }

    public static long getFreeId(ServerLevel level) {
        return getCache(level).getNextId();
    }

    private long getNextId() {
        setDirty();
        long j = this.lastId + 1;
        this.lastId = j;
        return j;
    }

    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registryLookup) {
        tag.putLong("last_id", this.lastId);
        return tag;
    }

    private static AnimatableIdCache getCache(ServerLevel level) {
        return (AnimatableIdCache) level.getServer().overworld().getDataStorage().computeIfAbsent(FACTORY, DATA_KEY);
    }
}
