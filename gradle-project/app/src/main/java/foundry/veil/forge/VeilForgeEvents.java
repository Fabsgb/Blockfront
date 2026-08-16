package foundry.veil.forge;

import foundry.veil.Veil;
import foundry.veil.impl.TickTaskSchedulerImpl;
import foundry.veil.impl.command.VeilCommand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/VeilForgeEvents.class */
@ApiStatus.Internal
@EventBusSubscriber(modid = Veil.MODID)
public class VeilForgeEvents {
    @SubscribeEvent
    public static void serverTick(ServerTickEvent.Pre event) {
        TickTaskSchedulerImpl scheduler = event.getServer().veil$getScheduler();
        if (scheduler != null) {
            scheduler.run();
        }
    }

    @SubscribeEvent
    public static void serverStopping(ServerStoppingEvent event) {
        TickTaskSchedulerImpl scheduler = event.getServer().veil$getScheduler();
        if (scheduler != null) {
            scheduler.shutdown();
        }
    }

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        VeilCommand.register(event.getDispatcher());
    }
}
