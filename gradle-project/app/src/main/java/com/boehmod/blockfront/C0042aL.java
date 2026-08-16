package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aL.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0042aL {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m221a(@NotNull RenderTooltipEvent.Color color) {
        color.setBorderStart(ColorReferences.COLOR_TOOL_TIP_BORDER_START);
        color.setBorderEnd(ColorReferences.COLOR_TOOL_TIP_BORDER_END);
        color.setBackground(ColorReferences.COLOR_TOOL_TIP_BACKGROUND);
    }
}
