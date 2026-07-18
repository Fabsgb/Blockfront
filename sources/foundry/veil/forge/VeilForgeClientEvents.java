package foundry.veil.forge;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import foundry.veil.forge.event.ForgeFreeNativeResourcesEvent;
import foundry.veil.impl.ClientEnumArgument;
import foundry.veil.impl.client.VeilClientSchedulerImpl;
import foundry.veil.impl.client.imgui.VeilImGuiCompat;
import foundry.veil.impl.network.VeilClientServerFlags;
import java.util.Locale;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.commands.arguments.coordinates.WorldCoordinates;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/VeilForgeClientEvents.class */
@ApiStatus.Internal
@EventBusSubscriber(modid = Veil.MODID, value = {Dist.CLIENT})
public class VeilForgeClientEvents {
    @SubscribeEvent
    public static void clientDisconnected(ClientPlayerNetworkEvent.LoggingOut event) {
        VeilRenderSystem.renderer().getLightRenderer().free();
        VeilClientServerFlags.onDisconnect();
    }

    @SubscribeEvent
    public static void keyPressed(InputEvent.Key event) {
        if (Veil.IMGUIMC && event.getAction() == 1 && VeilImGuiCompat.EDITOR_KEY.matches(event.getKey(), event.getScanCode())) {
            VeilRenderSystem.renderer().getEditorManager().toggle();
        }
    }

    @SubscribeEvent
    public static void mousePressed(InputEvent.MouseButton.Pre event) {
        if (Veil.IMGUIMC && event.getAction() == 1 && VeilImGuiCompat.EDITOR_KEY.matchesMouse(event.getButton())) {
            VeilRenderSystem.renderer().getEditorManager().toggle();
        }
    }

    @SubscribeEvent
    public static void registerClientCommands(RegisterClientCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        LiteralArgumentBuilder<CommandSourceStack> quasarBuilder = Commands.literal("quasar");
        quasarBuilder.then(Commands.argument("emitter", ResourceLocationArgument.id()).suggests(QuasarParticles.emitterSuggestionProvider()).then(Commands.argument("position", Vec3Argument.vec3()).executes(ctx -> {
            ResourceLocation id = ResourceLocationArgument.getId(ctx, "emitter");
            CommandSourceStack source = (CommandSourceStack) ctx.getSource();
            ParticleSystemManager particleManager = VeilRenderSystem.renderer().getParticleManager();
            ParticleEmitter instance = particleManager.createEmitter(id);
            if (instance == null) {
                source.sendFailure(Component.literal("Unknown emitter: " + String.valueOf(id)));
                return 0;
            }
            WorldCoordinates coordinates = (WorldCoordinates) ctx.getArgument("position", WorldCoordinates.class);
            Vec3 pos = coordinates.getPosition(source);
            instance.setPosition(pos.x, pos.y, pos.z);
            particleManager.addParticleSystem(instance);
            source.sendSuccess(() -> {
                return Component.literal("Spawned " + String.valueOf(id));
            }, true);
            return 1;
        })));
        dispatcher.register(quasarBuilder);
        if (Veil.platform().isDevelopmentEnvironment()) {
            ResourceLocation bufferId = Veil.veilPath("forced");
            LiteralArgumentBuilder<CommandSourceStack> debugBuilder = Commands.literal("veilc");
            debugBuilder.then(Commands.literal("buffers").then(Commands.literal("enable").then(Commands.argument("buffer", ClientEnumArgument.enumArgument(DynamicBufferType.class)).executes(ctx2 -> {
                DynamicBufferType value = (DynamicBufferType) ctx2.getArgument("buffer", DynamicBufferType.class);
                VeilRenderer renderer = VeilRenderSystem.renderer();
                renderer.enableBuffers(bufferId, value);
                ((CommandSourceStack) ctx2.getSource()).sendSuccess(() -> {
                    return Component.translatable("commands.veil.buffers.enable", new Object[]{value.name().toLowerCase(Locale.ROOT)});
                }, true);
                return 1;
            })).then(Commands.literal("all").executes(ctx3 -> {
                DynamicBufferType[] values = DynamicBufferType.values();
                VeilRenderSystem.renderer().enableBuffers(bufferId, values);
                ((CommandSourceStack) ctx3.getSource()).sendSuccess(() -> {
                    return Component.translatable("commands.veil.buffers.enable.all");
                }, true);
                return values.length;
            }))).then(Commands.literal("disable").then(Commands.argument("buffer", ClientEnumArgument.enumArgument(DynamicBufferType.class)).executes(ctx4 -> {
                DynamicBufferType value = (DynamicBufferType) ctx4.getArgument("buffer", DynamicBufferType.class);
                VeilRenderSystem.renderer().disableBuffers(bufferId, value);
                ((CommandSourceStack) ctx4.getSource()).sendSuccess(() -> {
                    return Component.translatable("commands.veil.buffers.disable", new Object[]{value.name().toLowerCase(Locale.ROOT)});
                }, true);
                return 1;
            })).then(Commands.literal("all").executes(ctx5 -> {
                DynamicBufferType[] values = DynamicBufferType.values();
                VeilRenderSystem.renderer().disableBuffers(bufferId, values);
                ((CommandSourceStack) ctx5.getSource()).sendSuccess(() -> {
                    return Component.translatable("commands.veil.buffers.disable.all");
                }, true);
                return values.length;
            }))));
            dispatcher.register(debugBuilder);
        }
    }

    @SubscribeEvent
    public static void clientTick(ClientTickEvent.Pre event) {
        VeilClientSchedulerImpl.tick();
    }

    @SubscribeEvent
    public static void clientStopping(ForgeFreeNativeResourcesEvent event) {
        VeilClientSchedulerImpl.shutdown();
    }
}
