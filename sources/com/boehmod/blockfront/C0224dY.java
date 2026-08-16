package com.boehmod.blockfront;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dY.class */
public class C0224dY extends AbstractC0225dZ {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0500ij f1779a;

    public C0224dY(@NotNull Screen screen, @NotNull C0500ij c0500ij) {
        super(screen, Component.translatable(c0500ij.getName()));
        this.f1779a = c0500ij;
    }

    @Override // com.boehmod.blockfront.AbstractC0225dZ
    /* JADX INFO: renamed from: Y */
    public void mo942Y() {
        this.f1779a.m2246g(this.f1795f.getValue());
        m1327N();
    }
}
