package com.boehmod.blockfront;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lU.class */
public class C0643lU {
    /* JADX INFO: renamed from: a */
    public static void m2860a(@NotNull CommandDispatcher<CommandSourceStack> commandDispatcher, @NotNull CommandBuildContext commandBuildContext) {
        commandDispatcher.register(Commands.literal("bf").then(Commands.literal("tracer").requires(commandSourceStack -> {
            return commandSourceStack.hasPermission(2) || C0645lW.m2895b(commandSourceStack);
        }).then(Commands.argument("start", Vec3Argument.vec3()).then(Commands.argument("end", Vec3Argument.vec3()).then(Commands.argument("gun", ResourceArgument.resource(commandBuildContext, Registries.ITEM)).executes(commandContext -> {
            m2861a(Vec3Argument.getVec3(commandContext, "start"), Vec3Argument.getVec3(commandContext, "end"), ResourceArgument.getResource(commandContext, "gun", Registries.ITEM));
            return 1;
        }))))));
    }

    /* JADX INFO: renamed from: a */
    private static void m2861a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Holder.Reference<Item> reference) {
        int iM6399ca;
        Item item = (Item) reference.value();
        if (item instanceof C1144ur) {
            iM6399ca = ((C1144ur) item).m6399ca();
        } else {
            iM6399ca = -3659;
        }
        C1194vo.m6649b(new C1245wm(-1, new C0386gc((Holder<Item>) reference, vec3, vec32, iM6399ca)));
    }
}
