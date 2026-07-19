package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.reward.AbstractItemRewardType;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jk.class */
public abstract class AbstractC0254jk<T extends AbstractItemRewardType> extends AbstractC0259jp<T> {
    @Override // com.boehmod.blockfront.AbstractC0259jp
    @NotNull
    public Component a(@NotNull T t) {
        CloudItem<?> cloudItem;
        CloudItemStack grantedStack = t.getGrantedStack();
        if (grantedStack == null) {
            return Component.literal(t.getDescription()).withColor(ColorReferences.COLOR_WHITE);
        }
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && (cloudItem = grantedStack.getCloudItem(c0297lB.a())) != null) {
            return Component.literal("+ ").withColor(9633658).append(Component.literal(cloudItem.getDisplayName()).withColor(cloudItem.getRarity().getColor()));
        }
        return Component.literal("Unknown Item").withColor(ColorReferences.COLOR_THEME_RED);
    }

    @Override // com.boehmod.blockfront.AbstractC0259jp
    public void a(@NotNull T t, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        C0297l c0297lB;
        CloudItem<?> cloudItem;
        CloudItemStack grantedStack = t.getGrantedStack();
        if (grantedStack == null || (c0297lB = C0297l.b()) == null || (cloudItem = grantedStack.getCloudItem(c0297lB.a())) == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        b(guiGraphics, i, i2, i3, i4, cloudItem.getRarity().getColor());
        C0040bk.a(poseStackPose, guiGraphics, iT.a(cloudItem, grantedStack), i + (i3 / 2), i2 + (i4 / 2), 1.75f);
    }
}
