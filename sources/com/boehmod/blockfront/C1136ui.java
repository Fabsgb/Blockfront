package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Tool;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ui */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ui.class */
public class C1136ui extends Item {
    public C1136ui(@NotNull String str, @NotNull Item.Properties properties) {
        super(properties);
        C1308xv.f7669f.put(str, this);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Item.Properties m6529a(int i, boolean z) {
        Item.Properties propertiesStacksTo = new Item.Properties().stacksTo(i);
        if (!z) {
            propertiesStacksTo = propertiesStacksTo.component(DataComponents.TOOL, m6530a());
        }
        return propertiesStacksTo;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Tool m6530a() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(), 15.0f)), 1.0f, 2);
    }
}
