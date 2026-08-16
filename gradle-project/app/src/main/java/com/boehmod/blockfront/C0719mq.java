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

/* JADX INFO: renamed from: com.boehmod.blockfront.mq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mq.class */
public class C0719mq {
    /* JADX INFO: renamed from: a */
    public static void m3291a(@NotNull CommandDispatcher<CommandSourceStack> commandDispatcher, @NotNull CommandBuildContext commandBuildContext) {
        commandDispatcher.register(Commands.literal("bf").then(Commands.literal("tracer").requires(commandSourceStack -> {
            return commandSourceStack.hasPermission(2) || C0721ms.m3326b(commandSourceStack);
        }).then(Commands.argument("start", Vec3Argument.vec3()).then(Commands.argument("end", Vec3Argument.vec3()).then(Commands.argument("gun", ResourceArgument.resource(commandBuildContext, Registries.ITEM)).executes(commandContext -> {
            m3292a(Vec3Argument.getVec3(commandContext, "start"), Vec3Argument.getVec3(commandContext, "end"), ResourceArgument.getResource(commandContext, "gun", Registries.ITEM));
            return 1;
        }))))));
    }

    /* JADX INFO: renamed from: a */
    private static void m3292a(@NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull Holder.Reference<Item> reference) {
        int iM6374cp;
        Item item = (Item) reference.value();
        if (item instanceof C1117uP) {
            iM6374cp = ((C1117uP) item).m6374cp();
        } else {
            iM6374cp = -3659;
        }
        C1169vO.m6644b(new C1217wJ(-1, new C0403gs((Holder<Item>) reference, vec3, vec4, iM6374cp)));
    }
}
