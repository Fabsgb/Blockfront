package foundry.veil.forge.event;

import java.util.function.BiConsumer;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilRegisterFixedBuffersEvent.class */
public class ForgeVeilRegisterFixedBuffersEvent extends Event implements IModBusEvent {
    private final BiConsumer<RenderLevelStageEvent.Stage, RenderType> registry;

    public ForgeVeilRegisterFixedBuffersEvent(BiConsumer<RenderLevelStageEvent.Stage, RenderType> registry) {
        this.registry = registry;
    }

    public void register(@Nullable RenderLevelStageEvent.Stage stage, RenderType renderType) {
        this.registry.accept(stage, renderType);
    }
}
