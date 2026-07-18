package foundry.veil.api;

import foundry.veil.ext.MinecraftServerExtension;
import foundry.veil.impl.client.VeilClientSchedulerImpl;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/TickTaskScheduler.class */
public interface TickTaskScheduler extends Executor {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/TickTaskScheduler$TickTask.class */
    public interface TickTask<V> extends ScheduledFuture<V> {
        long getDelay();

        CompletableFuture<V> toCompletableFuture();
    }

    @Override // java.util.concurrent.Executor
    void execute(@NotNull Runnable runnable);

    TickTask<?> schedule(@NotNull Runnable runnable, long j);

    <V> TickTask<V> schedule(@NotNull Callable<V> callable, long j);

    TickTask<?> scheduleAtFixedRate(@NotNull Runnable runnable, long j, long j2);

    boolean isShutdown();

    static TickTaskScheduler get(@Nullable MinecraftServer server) {
        return server == null ? VeilClientSchedulerImpl.getScheduler() : ((MinecraftServerExtension) server).veil$getOrCreateScheduler();
    }
}
