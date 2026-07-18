package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bZ.class */
public class C0108bZ extends C0167cf<C1030sj, C1034sn> {

    /* JADX INFO: renamed from: aw */
    private boolean f669aw = false;

    @Override // com.boehmod.blockfront.C0167cf, com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo319a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, @NotNull AbstractC0788oG abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m333a(minecraft, (C1030sj) abstractC0787oF, (C1034sn) abstractC0790oI, (AbstractC0788oG<C1030sj, C1034sn>) abstractC0788oG, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m333a(@NotNull Minecraft minecraft, @NotNull C1030sj c1030sj, @NotNull C1034sn c1034sn, @NotNull AbstractC0788oG<C1030sj, C1034sn> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        super.mo319a(minecraft, c1030sj, c1034sn, abstractC0788oG, localPlayer);
        this.f669aw = abstractC0788oG.m3678a().m3896bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: s */
    public boolean mo334s() {
        return this.f669aw;
    }
}
