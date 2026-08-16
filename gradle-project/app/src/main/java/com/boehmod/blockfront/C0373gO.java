package com.boehmod.blockfront;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gO.class */
public class C0373gO extends C0410gz<C0739nJ> {
    public C0373gO(@NotNull EntityRendererProvider.Context context, @NotNull ItemRenderer itemRenderer, @NotNull DeferredHolder<Item, ? extends Item> deferredHolder) {
        super(context, itemRenderer, deferredHolder);
    }

    @Override // com.boehmod.blockfront.C0410gz
    /* JADX INFO: renamed from: E */
    public float mo1782E() {
        return 1.0f;
    }
}
