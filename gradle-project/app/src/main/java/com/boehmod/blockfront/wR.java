package com.boehmod.blockfront;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.data.registries.VanillaRegistries;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wR.class */
public class wR {
    public static void b(@NotNull RegisterCommandsEvent registerCommandsEvent) {
        CommandDispatcher dispatcher = registerCommandsEvent.getDispatcher();
        lV.a((CommandDispatcher<CommandSourceStack>) dispatcher, Commands.createValidationContext(VanillaRegistries.createLookup()));
        lU.a(dispatcher, Commands.createValidationContext(VanillaRegistries.createLookup()));
        lX.a((CommandDispatcher<CommandSourceStack>) dispatcher);
        lT.a((CommandDispatcher<CommandSourceStack>) dispatcher);
        lY.a(dispatcher);
    }
}
