package foundry.veil.api.compat;

import foundry.veil.Veil;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.ServiceLoader;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/compat/SodiumCompat.class */
public interface SodiumCompat {

    @Nullable
    public static final SodiumCompat INSTANCE;

    Object2IntMap<ResourceLocation> getLoadedShaders();

    @ApiStatus.Experimental
    void recompile();

    @ApiStatus.Internal
    void setActiveBuffers(int i);

    void markChunksDirty();

    @ApiStatus.Internal
    Object getSortedRenderLists();

    @ApiStatus.Internal
    void setSortedRenderLists(@Nullable Object obj);

    @ApiStatus.Internal
    Object getTaskLists();

    @ApiStatus.Internal
    void setTaskList(@Nullable Object obj);

    static {
        INSTANCE = Veil.platform().isModLoaded("sodium") ? (SodiumCompat) ServiceLoader.load(SodiumCompat.class).findFirst().orElse(null) : null;
    }

    static boolean isLoaded() {
        return INSTANCE != null;
    }
}
