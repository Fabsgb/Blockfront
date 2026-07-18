package com.boehmod.blockfront;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.data.registries.VanillaRegistries;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wR.class */
public class C1224wR {
    /* JADX INFO: renamed from: b */
    public static void m7289b(@NotNull RegisterCommandsEvent registerCommandsEvent) {
        CommandDispatcher dispatcher = registerCommandsEvent.getDispatcher();
        C0644lV.m2864a((CommandDispatcher<CommandSourceStack>) dispatcher, Commands.createValidationContext(VanillaRegistries.createLookup()));
        C0643lU.m2860a(dispatcher, Commands.createValidationContext(VanillaRegistries.createLookup()));
        C0646lX.m2899a((CommandDispatcher<CommandSourceStack>) dispatcher);
        C0642lT.m2836a((CommandDispatcher<CommandSourceStack>) dispatcher);
        C0647lY.m2904a(dispatcher);
    }
}
