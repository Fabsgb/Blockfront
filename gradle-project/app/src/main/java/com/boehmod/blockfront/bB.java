package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bB.class */
public abstract class bB extends AbstractC0076ct {

    @NotNull
    protected final CloudItemStack b;

    public bB(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull Component component, @NotNull CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, component);
        this.b = cloudItemStack;
    }
}
