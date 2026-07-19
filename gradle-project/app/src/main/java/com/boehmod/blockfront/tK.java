package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Tool;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tK.class */
public class tK extends Item {
    public tK(@NotNull String str, @NotNull Item.Properties properties) {
        super(properties);
        wY.f.put(str, this);
    }

    @NotNull
    private static Item.Properties a(int i, boolean z) {
        Item.Properties propertiesStacksTo = new Item.Properties().stacksTo(i);
        if (!z) {
            propertiesStacksTo = propertiesStacksTo.component(DataComponents.TOOL, a());
        }
        return propertiesStacksTo;
    }

    @NotNull
    public static Tool a() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(), 15.0f)), 1.0f, 2);
    }
}
