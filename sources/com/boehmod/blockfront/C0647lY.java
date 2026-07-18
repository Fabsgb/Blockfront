package com.boehmod.blockfront;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

/* JADX INFO: renamed from: com.boehmod.blockfront.lY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lY.class */
public class C0647lY {
    /* JADX INFO: renamed from: a */
    public static void m2904a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("bf").then(Commands.literal("shake").then(Commands.argument("pitchAmplitude", FloatArgumentType.floatArg()).then(Commands.argument("yawAmplitude", FloatArgumentType.floatArg()).then(Commands.argument("rollAmplitude", FloatArgumentType.floatArg()).then(Commands.argument("pitchFrequency", FloatArgumentType.floatArg()).then(Commands.argument("yawFrequency", FloatArgumentType.floatArg()).then(Commands.argument("rollFrequency", FloatArgumentType.floatArg()).then(Commands.argument("easeInLerp", FloatArgumentType.floatArg()).then(Commands.argument("easeOutLerp", FloatArgumentType.floatArg()).then(Commands.argument("idleTime", IntegerArgumentType.integer()).executes(commandContext -> {
            m2905a(commandContext, FloatArgumentType.getFloat(commandContext, "pitchAmplitude"), FloatArgumentType.getFloat(commandContext, "yawAmplitude"), FloatArgumentType.getFloat(commandContext, "rollAmplitude"), FloatArgumentType.getFloat(commandContext, "pitchFrequency"), FloatArgumentType.getFloat(commandContext, "yawFrequency"), FloatArgumentType.getFloat(commandContext, "rollFrequency"), FloatArgumentType.getFloat(commandContext, "easeInLerp"), FloatArgumentType.getFloat(commandContext, "easeOutLerp"), IntegerArgumentType.getInteger(commandContext, "idleTime"));
            return 1;
        }))))))))))));
    }

    /* JADX INFO: renamed from: a */
    private static void m2905a(CommandContext<CommandSourceStack> commandContext, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            C1194vo.m6648a(new C1173vT(new C0417hG(f, f2, f3, f4, f5, f6, f7, f8, i)), entity);
        }
    }
}
