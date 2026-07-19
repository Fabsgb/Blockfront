package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bZ.class */
public class bZ extends C0062cf<C0496sj, C0500sn> {
    private boolean aw = false;

    @Override // com.boehmod.blockfront.C0062cf, com.boehmod.blockfront.AbstractC0063cg
    public /* bridge */ /* synthetic */ void a(@NotNull Minecraft minecraft, @NotNull oF oFVar, @NotNull oI oIVar, @NotNull oG oGVar, @NotNull LocalPlayer localPlayer) {
        a(minecraft, (C0496sj) oFVar, (C0500sn) oIVar, (oG<C0496sj, C0500sn>) oGVar, localPlayer);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0496sj c0496sj, @NotNull C0500sn c0500sn, @NotNull oG<C0496sj, C0500sn> oGVar, @NotNull LocalPlayer localPlayer) {
        super.a(minecraft, c0496sj, c0500sn, oGVar, localPlayer);
        this.aw = oGVar.a().bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public boolean s() {
        return this.aw;
    }
}
