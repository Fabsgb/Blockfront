package com.boehmod.blockfront;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dN.class */
public class dN extends dO {

    @NotNull
    private final hS a;

    public dN(@NotNull Screen screen, @NotNull hS hSVar) {
        super(screen, Component.translatable(hSVar.getName()));
        this.a = hSVar;
    }

    @Override // com.boehmod.blockfront.dO
    public void U() {
        this.a.g(this.f.getValue());
        J();
    }
}
