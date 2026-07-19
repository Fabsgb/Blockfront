package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ca, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ca.class */
public class C0057ca extends bV<C0496sj, C0500sn> {
    @Override // com.boehmod.blockfront.AbstractC0063cg
    public /* bridge */ /* synthetic */ void a(@NotNull Minecraft minecraft, @NotNull oF oFVar, @NotNull oI oIVar, @NotNull oG oGVar, @NotNull LocalPlayer localPlayer) {
        a(minecraft, (C0496sj) oFVar, (C0500sn) oIVar, (oG<C0496sj, C0500sn>) oGVar, localPlayer);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0496sj c0496sj, @NotNull C0500sn c0500sn, @NotNull oG<C0496sj, C0500sn> oGVar, @NotNull LocalPlayer localPlayer) {
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.of.waves", new Object[]{Component.literal(String.valueOf(c0496sj.bG())).withStyle(ChatFormatting.WHITE)});
        oO oOVarF = c0496sj.f();
        mutableComponentTranslatable.withColor(oOVarF != null ? oOVarF.getColor() : ColorReferences.COLOR_WHITE);
        a((Component) mutableComponentTranslatable);
    }
}
