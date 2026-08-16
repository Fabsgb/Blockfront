package com.boehmod.blockfront;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.data.registries.VanillaRegistries;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xo.class */
public class C1301xo {
    /* JADX INFO: renamed from: b */
    public static void m7878b(@NotNull RegisterCommandsEvent registerCommandsEvent) {
        CommandDispatcher dispatcher = registerCommandsEvent.getDispatcher();
        C0720mr.m3295a((CommandDispatcher<CommandSourceStack>) dispatcher, Commands.createValidationContext(VanillaRegistries.createLookup()));
        C0719mq.m3291a(dispatcher, Commands.createValidationContext(VanillaRegistries.createLookup()));
        C0722mt.m3330a((CommandDispatcher<CommandSourceStack>) dispatcher);
        C0718mp.m3267a((CommandDispatcher<CommandSourceStack>) dispatcher);
        C0723mu.m3335a(dispatcher);
    }
}
