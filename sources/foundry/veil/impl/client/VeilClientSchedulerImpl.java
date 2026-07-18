package foundry.veil.impl.client;

import foundry.veil.api.TickTaskScheduler;
import foundry.veil.impl.TickTaskSchedulerImpl;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/VeilClientSchedulerImpl.class */
@ApiStatus.Internal
public class VeilClientSchedulerImpl {
    private static final TickTaskSchedulerImpl INSTANCE = new TickTaskSchedulerImpl();

    public static void tick() {
        INSTANCE.run();
    }

    public static void shutdown() {
        INSTANCE.shutdown();
    }

    public static TickTaskScheduler getScheduler() {
        return INSTANCE;
    }
}
