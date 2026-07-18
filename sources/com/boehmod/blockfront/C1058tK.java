package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Tool;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tK.class */
public class C1058tK extends Item {
    public C1058tK(@NotNull String str, @NotNull Item.Properties properties) {
        super(properties);
        C1231wY.f7104f.put(str, this);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Item.Properties m5894a(int i, boolean z) {
        Item.Properties propertiesStacksTo = new Item.Properties().stacksTo(i);
        if (!z) {
            propertiesStacksTo = propertiesStacksTo.component(DataComponents.TOOL, m5895a());
        }
        return propertiesStacksTo;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Tool m5895a() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(), 15.0f)), 1.0f, 2);
    }
}
