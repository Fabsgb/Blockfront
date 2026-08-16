package foundry.veil.ext;

import foundry.veil.impl.TickTaskSchedulerImpl;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/ext/MinecraftServerExtension.class */
public interface MinecraftServerExtension {
    @Nullable
    TickTaskSchedulerImpl veil$getScheduler();

    TickTaskSchedulerImpl veil$getOrCreateScheduler();
}
