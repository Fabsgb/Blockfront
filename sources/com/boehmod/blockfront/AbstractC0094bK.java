package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bK.class */
public abstract class AbstractC0094bK extends AbstractC0139cC {

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final CloudItemStack f631b;

    public AbstractC0094bK(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull Component component, @NotNull CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, component);
        this.f631b = cloudItemStack;
    }
}
