package foundry.veil.impl.command;

import com.google.common.collect.Iterables;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import foundry.veil.Veil;
import foundry.veil.api.network.VeilPacketManager;
import foundry.veil.ext.VeilClientSuggestionProvider;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import foundry.veil.impl.network.ClientboundAddPostProcessingPacket;
import foundry.veil.impl.network.ClientboundClearPostProcessingPacket;
import foundry.veil.impl.network.ClientboundRemovePostProcessingPacket;
import foundry.veil.platform.VeilPlatform;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.commands.synchronization.SuggestionProviders;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/command/VeilCommand.class */
@ApiStatus.Internal
public final class VeilCommand {
    private static final SuggestionProvider<CommandSourceStack> PIPELINE_SUGGESTIONS = SuggestionProviders.register(Veil.veilPath("post_pipelines"), (context, builder) -> {
        Object patt0$temp = context.getSource();
        if (!(patt0$temp instanceof VeilClientSuggestionProvider)) {
            return builder.buildFuture();
        }
        VeilClientSuggestionProvider provider = (VeilClientSuggestionProvider) patt0$temp;
        return SharedSuggestionProvider.suggestResource(provider.veil$getPostPipelineNames(), builder);
    });
    private static final Component POST_PROCESSING_ADD_FAIL = Component.translatable("commands.veil.post_processing.add.fail");
    private static final Component POST_PROCESSING_REMOVE_FAIL = Component.translatable("commands.veil.post_processing.remove.fail");
    private static final Component POST_PROCESSING_CLEAR_FAIL = Component.translatable("commands.veil.post_processing.clear.fail");

    private VeilCommand() {
    }

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal(Veil.MODID).requires(stack -> {
            return stack.hasPermission(2);
        }).then(Commands.literal("post_processing").then(Commands.literal("add").then(Commands.argument("targets", EntityArgument.players()).then(Commands.argument("pipeline", ResourceLocationArgument.id()).suggests(PIPELINE_SUGGESTIONS).executes(ctx -> {
            Collection<ServerPlayer> targets = EntityArgument.getPlayers(ctx, "targets");
            ResourceLocation pipeline = ResourceLocationArgument.getId(ctx, "pipeline");
            return addPipeline((CommandSourceStack) ctx.getSource(), targets, pipeline, ShaderInjectionDefinition.DEFAULT_PRIORITY);
        }).then(Commands.argument("priority", IntegerArgumentType.integer()).executes(ctx2 -> {
            Collection<ServerPlayer> targets = EntityArgument.getPlayers(ctx2, "targets");
            ResourceLocation pipeline = ResourceLocationArgument.getId(ctx2, "pipeline");
            int priority = IntegerArgumentType.getInteger(ctx2, "priority");
            return addPipeline((CommandSourceStack) ctx2.getSource(), targets, pipeline, priority);
        }))))).then(Commands.literal("remove").then(Commands.argument("targets", EntityArgument.players()).then(Commands.argument("pipeline", ResourceLocationArgument.id()).suggests(PIPELINE_SUGGESTIONS).executes(ctx3 -> {
            Collection<ServerPlayer> targets = EntityArgument.getPlayers(ctx3, "targets");
            ResourceLocation pipeline = ResourceLocationArgument.getId(ctx3, "pipeline");
            return removePipeline((CommandSourceStack) ctx3.getSource(), targets, pipeline);
        })))).then(Commands.literal("clear").then(Commands.argument("targets", EntityArgument.players()).executes(ctx4 -> {
            Collection<ServerPlayer> targets = EntityArgument.getPlayers(ctx4, "targets");
            return clearPipelines((CommandSourceStack) ctx4.getSource(), targets);
        })))));
    }

    private static int addPipeline(CommandSourceStack source, Collection<ServerPlayer> targets, ResourceLocation pipeline, int priority) {
        List<ServerPlayer> sentPlayers = new ArrayList<>();
        VeilPlatform platform = Veil.platform();
        for (ServerPlayer target : targets) {
            if (platform.hasChannel(target.connection, ClientboundAddPostProcessingPacket.TYPE)) {
                sentPlayers.add(target);
                VeilPacketManager.player(target).sendPacket(new ClientboundAddPostProcessingPacket(priority, pipeline));
            }
        }
        if (sentPlayers.isEmpty()) {
            source.sendFailure(POST_PROCESSING_ADD_FAIL);
            return 0;
        }
        if (sentPlayers.size() == 1) {
            source.sendSuccess(() -> {
                return Component.translatable("commands.veil.post_processing.add.success.single", new Object[]{pipeline.toString(), ((ServerPlayer) Iterables.getOnlyElement(sentPlayers)).getDisplayName()});
            }, true);
        } else {
            source.sendSuccess(() -> {
                return Component.translatable("commands.veil.post_processing.add.success.multiple", new Object[]{pipeline.toString(), Integer.valueOf(sentPlayers.size())});
            }, true);
        }
        return sentPlayers.size();
    }

    private static int removePipeline(CommandSourceStack source, Collection<ServerPlayer> targets, ResourceLocation pipeline) {
        List<ServerPlayer> sentPlayers = new ArrayList<>();
        VeilPlatform platform = Veil.platform();
        for (ServerPlayer target : targets) {
            if (platform.hasChannel(target.connection, ClientboundRemovePostProcessingPacket.TYPE)) {
                sentPlayers.add(target);
                VeilPacketManager.player(target).sendPacket(new ClientboundRemovePostProcessingPacket(pipeline));
            }
        }
        if (sentPlayers.isEmpty()) {
            source.sendFailure(POST_PROCESSING_REMOVE_FAIL);
            return 0;
        }
        if (sentPlayers.size() == 1) {
            source.sendSuccess(() -> {
                return Component.translatable("commands.veil.post_processing.remove.success.single", new Object[]{pipeline.toString(), ((ServerPlayer) Iterables.getOnlyElement(sentPlayers)).getDisplayName()});
            }, true);
        } else {
            source.sendSuccess(() -> {
                return Component.translatable("commands.veil.post_processing.remove.success.multiple", new Object[]{pipeline.toString(), Integer.valueOf(sentPlayers.size())});
            }, true);
        }
        return sentPlayers.size();
    }

    private static int clearPipelines(CommandSourceStack source, Collection<ServerPlayer> targets) {
        List<ServerPlayer> sentPlayers = new ArrayList<>();
        VeilPlatform platform = Veil.platform();
        for (ServerPlayer target : targets) {
            if (platform.hasChannel(target.connection, ClientboundClearPostProcessingPacket.TYPE)) {
                sentPlayers.add(target);
                VeilPacketManager.player(target).sendPacket(ClientboundClearPostProcessingPacket.INSTANCE);
            }
        }
        if (sentPlayers.isEmpty()) {
            source.sendFailure(POST_PROCESSING_CLEAR_FAIL);
            return 0;
        }
        if (sentPlayers.size() == 1) {
            source.sendSuccess(() -> {
                return Component.translatable("commands.veil.post_processing.clear.success.single", new Object[]{((ServerPlayer) Iterables.getOnlyElement(sentPlayers)).getDisplayName()});
            }, true);
        } else {
            source.sendSuccess(() -> {
                return Component.translatable("commands.veil.post_processing.clear.success.multiple", new Object[]{Integer.valueOf(sentPlayers.size())});
            }, true);
        }
        return sentPlayers.size();
    }
}
