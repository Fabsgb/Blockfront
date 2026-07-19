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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lU.class */
public class lU {
    public static void a(@NotNull CommandDispatcher<CommandSourceStack> commandDispatcher, @NotNull CommandBuildContext commandBuildContext) {
        commandDispatcher.register(Commands.literal("bf").then(Commands.literal("tracer").requires(commandSourceStack -> {
            return commandSourceStack.hasPermission(2) || lW.b(commandSourceStack);
        }).then(Commands.argument("start", Vec3Argument.vec3()).then(Commands.argument("end", Vec3Argument.vec3()).then(Commands.argument("gun", ResourceArgument.resource(commandBuildContext, Registries.ITEM)).executes(commandContext -> {
            a(Vec3Argument.getVec3(commandContext, "start"), Vec3Argument.getVec3(commandContext, "end"), ResourceArgument.getResource(commandContext, "gun", Registries.ITEM));
            return 1;
        }))))));
    }

    private static void a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Holder.Reference<Item> reference) {
        int iCa;
        Item item = (Item) reference.value();
        if (item instanceof C0558ur) {
            iCa = ((C0558ur) item).ca();
        } else {
            iCa = -3659;
        }
        C0582vo.b(new C0607wm(-1, new C0166gc((Holder<Item>) reference, vec3, vec32, iCa)));
    }
}
