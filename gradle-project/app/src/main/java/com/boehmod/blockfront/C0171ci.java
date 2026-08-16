package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ci */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ci.class */
public class C0171ci extends C0181co<C1001sG, C1005sK> {

    /* JADX INFO: renamed from: aB */
    private boolean f1351aB = false;

    @Override // com.boehmod.blockfront.C0181co, com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1042a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, @NotNull AbstractC0864pc abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1058a(minecraft, (C1001sG) abstractC0863pb, (C1005sK) abstractC0866pe, (AbstractC0864pc<C1001sG, C1005sK>) abstractC0864pc, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1058a(@NotNull Minecraft minecraft, @NotNull C1001sG c1001sG, @NotNull C1005sK c1005sK, @NotNull AbstractC0864pc<C1001sG, C1005sK> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        super.mo1042a(minecraft, c1001sG, c1005sK, abstractC0864pc, localPlayer);
        this.f1351aB = abstractC0864pc.m4114a().m4332bC();
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: t */
    public boolean mo1059t() {
        return this.f1351aB;
    }
}
