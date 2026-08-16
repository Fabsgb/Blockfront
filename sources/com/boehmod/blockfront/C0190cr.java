package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cr.class */
public class C0190cr extends AbstractC0166cd<C1018sX, C1020sZ> {
    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1042a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, @NotNull AbstractC0864pc abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1188a(minecraft, (C1018sX) abstractC0863pb, (C1020sZ) abstractC0866pe, (AbstractC0864pc<C1018sX, C1020sZ>) abstractC0864pc, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1188a(@NotNull Minecraft minecraft, @NotNull C1018sX c1018sX, @NotNull C1020sZ c1020sZ, @NotNull AbstractC0864pc<C1018sX, C1020sZ> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        EnumC1082th enumC1082thM5718a = c1018sX.m5718a(localPlayer.getUUID());
        if (enumC1082thM5718a != null) {
            m1052a(enumC1082thM5718a.getTexture());
            m1054a((Component) Component.literal(enumC1082thM5718a.getKey()).withColor(enumC1082thM5718a.getColor()));
        }
    }
}
