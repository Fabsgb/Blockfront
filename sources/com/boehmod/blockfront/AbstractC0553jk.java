package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.reward.AbstractItemRewardType;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jk.class */
public abstract class AbstractC0553jk<T extends AbstractItemRewardType> extends AbstractC0558jp<T> {
    @Override // com.boehmod.blockfront.AbstractC0558jp
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Component mo2506a(@NotNull T t) {
        CloudItem<?> cloudItem;
        CloudItemStack grantedStack = t.getGrantedStack();
        if (grantedStack == null) {
            return Component.literal(t.getDescription()).withColor(ColorReferences.COLOR_WHITE);
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null && (cloudItem = grantedStack.getCloudItem(c0622lM2667b.m2670a())) != null) {
            return Component.literal("+ ").withColor(9633658).append(Component.literal(cloudItem.getDisplayName()).withColor(cloudItem.getRarity().getColor()));
        }
        return Component.literal("Unknown Item").withColor(ColorReferences.COLOR_THEME_RED);
    }

    @Override // com.boehmod.blockfront.AbstractC0558jp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2505a(@NotNull T t, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        C0622l c0622lM2667b;
        CloudItem<?> cloudItem;
        CloudItemStack grantedStack = t.getGrantedStack();
        if (grantedStack == null || (c0622lM2667b = C0622l.m2667b()) == null || (cloudItem = grantedStack.getCloudItem(c0622lM2667b.m2670a())) == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        m2509b(guiGraphics, i, i2, i3, i4, cloudItem.getRarity().getColor());
        C0119bk.m501a(poseStackPose, guiGraphics, C0483iT.m2203a(cloudItem, grantedStack), i + (i3 / 2), i2 + (i4 / 2), 1.75f);
    }
}
