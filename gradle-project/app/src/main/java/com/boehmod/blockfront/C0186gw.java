package com.boehmod.blockfront;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gw.class */
public class C0186gw extends C0173gj<C0361nj> {
    public C0186gw(@NotNull EntityRendererProvider.Context context, @NotNull ItemRenderer itemRenderer, @NotNull DeferredHolder<Item, ? extends Item> deferredHolder) {
        super(context, itemRenderer, deferredHolder);
    }

    @Override // com.boehmod.blockfront.C0173gj
    public float E() {
        return 1.0f;
    }
}
