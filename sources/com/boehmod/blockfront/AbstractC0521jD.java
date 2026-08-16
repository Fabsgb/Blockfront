package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.reward.AbstractItemRewardType;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jD.class */
public abstract class AbstractC0521jD<T extends AbstractItemRewardType> extends AbstractC0526jI<T> {
    @Override // com.boehmod.blockfront.AbstractC0526jI
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Component mo2326a(@NotNull T t) {
        CloudItem<?> cloudItem;
        CloudItemStack grantedStack = t.getGrantedStack();
        if (grantedStack == null) {
            return Component.literal(t.getDescription()).withColor(ColorReferences.COLOR_WHITE);
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null && (cloudItem = grantedStack.getCloudItem(c0623lM2852b.m2855a())) != null) {
            return Component.literal("+ ").withColor(9633658).append(Component.literal(cloudItem.getDisplayName()).withColor(cloudItem.getRarity().getColor()));
        }
        return Component.literal("Unknown Item").withColor(ColorReferences.COLOR_THEME_RED);
    }

    @Override // com.boehmod.blockfront.AbstractC0526jI
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2325a(@NotNull T t, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        C0623l c0623lM2852b;
        CloudItem<?> cloudItem;
        CloudItemStack grantedStack = t.getGrantedStack();
        if (grantedStack == null || (c0623lM2852b = C0623l.m2852b()) == null || (cloudItem = grantedStack.getCloudItem(c0623lM2852b.m2855a())) == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        m2329b(guiGraphics, i, i2, i3, i4, cloudItem.getRarity().getColor());
        C0129bt.m601b(poseStackPose, guiGraphics, C0556jm.m2530a(cloudItem, grantedStack), i + (i3 / 2), i2 + (i4 / 2), 1.75f);
    }
}
