package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ci */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ci.class */
public class C0170ci extends AbstractC0103bU<C0994sA, C0996sC> {
    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo319a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, @NotNull AbstractC0788oG abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m1001a(minecraft, (C0994sA) abstractC0787oF, (C0996sC) abstractC0790oI, (AbstractC0788oG<C0994sA, C0996sC>) abstractC0788oG, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1001a(@NotNull Minecraft minecraft, @NotNull C0994sA c0994sA, @NotNull C0996sC c0996sC, @NotNull AbstractC0788oG<C0994sA, C0996sC> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        EnumC1004sK enumC1004sKM5440a = c0994sA.m5440a(localPlayer.getUUID());
        if (enumC1004sKM5440a != null) {
            m327a(enumC1004sKM5440a.getTexture());
            m329a((Component) Component.literal(enumC1004sKM5440a.getKey()).withColor(enumC1004sKM5440a.getColor()));
        }
    }
}
