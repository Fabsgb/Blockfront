package com.boehmod.blockfront;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dN.class */
public class C0212dN extends AbstractC0213dO {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0429hS f1750a;

    public C0212dN(@NotNull Screen screen, @NotNull C0429hS c0429hS) {
        super(screen, Component.translatable(c0429hS.getName()));
        this.f1750a = c0429hS;
    }

    @Override // com.boehmod.blockfront.AbstractC0213dO
    /* JADX INFO: renamed from: U */
    public void mo888U() {
        this.f1750a.m2012g(this.f1766f.getValue());
        mo1276J();
    }
}
