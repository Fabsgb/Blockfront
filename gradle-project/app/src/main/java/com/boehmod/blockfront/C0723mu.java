package com.boehmod.blockfront;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

/* JADX INFO: renamed from: com.boehmod.blockfront.mu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mu.class */
public class C0723mu {
    /* JADX INFO: renamed from: a */
    public static void m3335a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("bf").then(Commands.literal("shake").then(Commands.argument("pitchAmplitude", FloatArgumentType.floatArg()).then(Commands.argument("yawAmplitude", FloatArgumentType.floatArg()).then(Commands.argument("rollAmplitude", FloatArgumentType.floatArg()).then(Commands.argument("pitchFrequency", FloatArgumentType.floatArg()).then(Commands.argument("yawFrequency", FloatArgumentType.floatArg()).then(Commands.argument("rollFrequency", FloatArgumentType.floatArg()).then(Commands.argument("easeInLerp", FloatArgumentType.floatArg()).then(Commands.argument("easeOutLerp", FloatArgumentType.floatArg()).then(Commands.argument("idleTime", IntegerArgumentType.integer()).executes(commandContext -> {
            m3336a(commandContext, FloatArgumentType.getFloat(commandContext, "pitchAmplitude"), FloatArgumentType.getFloat(commandContext, "yawAmplitude"), FloatArgumentType.getFloat(commandContext, "rollAmplitude"), FloatArgumentType.getFloat(commandContext, "pitchFrequency"), FloatArgumentType.getFloat(commandContext, "yawFrequency"), FloatArgumentType.getFloat(commandContext, "rollFrequency"), FloatArgumentType.getFloat(commandContext, "easeInLerp"), FloatArgumentType.getFloat(commandContext, "easeOutLerp"), IntegerArgumentType.getInteger(commandContext, "idleTime"));
            return 1;
        }))))))))))));
    }

    /* JADX INFO: renamed from: a */
    private static void m3336a(CommandContext<CommandSourceStack> commandContext, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            C1169vO.m6643a(new C1253wt(new C0434hW(f, f2, f3, f4, f5, f6, f7, f8, i)), entity);
        }
    }
}
