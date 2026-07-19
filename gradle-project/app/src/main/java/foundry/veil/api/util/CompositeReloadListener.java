package foundry.veil.api.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Unit;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/CompositeReloadListener.class */
public final class CompositeReloadListener implements PreparableReloadListener {
    private final PreparableReloadListener[] listeners;

    private CompositeReloadListener(PreparableReloadListener[] listeners) {
        this.listeners = listeners;
    }

    public static PreparableReloadListener of(PreparableReloadListener... listeners) {
        if (listeners.length == 0) {
            return new PreparableReloadListener() { // from class: foundry.veil.api.util.CompositeReloadListener.1
                @NotNull
                public CompletableFuture<Void> reload(@NotNull PreparableReloadListener.PreparationBarrier preparationBarrier, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller prepareProfiler, @NotNull ProfilerFiller applyProfiler, @NotNull Executor backgroundExecutor, @NotNull Executor gameExecutor) {
                    return preparationBarrier.wait((Object) null);
                }

                @NotNull
                public String getName() {
                    return "EmptyListener";
                }
            };
        }
        if (listeners.length == 1) {
            return listeners[0];
        }
        return new CompositeReloadListener(listeners);
    }

    @NotNull
    public CompletableFuture<Void> reload(@NotNull final PreparableReloadListener.PreparationBarrier preparationBarrier, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller prepareProfiler, @NotNull ProfilerFiller applyProfiler, @NotNull Executor backgroundExecutor, @NotNull Executor gameExecutor) {
        final CompletableFuture<Unit> allComplete = new CompletableFuture<>();
        final Set<PreparableReloadListener> preparingListeners = new HashSet<>(Arrays.asList(this.listeners));
        List<CompletableFuture<?>> futures = new ArrayList<>(this.listeners.length);
        for (final PreparableReloadListener listener : this.listeners) {
            PreparableReloadListener.PreparationBarrier barrier = new PreparableReloadListener.PreparationBarrier(this) { // from class: foundry.veil.api.util.CompositeReloadListener.2
                @NotNull
                public <T> CompletableFuture<T> wait(@Nullable T backgroundResult) {
                    if (preparingListeners.remove(listener) && preparingListeners.isEmpty()) {
                        CompletableFuture completableFutureWait = preparationBarrier.wait((Object) null);
                        CompletableFuture completableFuture = allComplete;
                        completableFutureWait.thenRun(() -> {
                            completableFuture.complete(Unit.INSTANCE);
                        });
                    }
                    return allComplete.thenApply(unused -> {
                        return backgroundResult;
                    });
                }
            };
            futures.add(listener.reload(barrier, resourceManager, prepareProfiler, applyProfiler, backgroundExecutor, gameExecutor));
        }
        return CompletableFuture.allOf((CompletableFuture[]) futures.toArray(x$0 -> {
            return new CompletableFuture[x$0];
        }));
    }

    @NotNull
    public String getName() {
        return "CompositeListener[" + ((String) Arrays.stream(this.listeners).map((v0) -> {
            return v0.getName();
        }).collect(Collectors.joining(","))) + "]";
    }
}
