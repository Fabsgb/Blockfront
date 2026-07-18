package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eu.class */
public final class C0298eu {
    private C0298eu() {
    }

    /* JADX INFO: renamed from: q */
    public static void m1576q(@NotNull Minecraft minecraft) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
    }

    /* JADX INFO: renamed from: b */
    public static void m1577b(@NotNull Minecraft minecraft, @NotNull Component component) {
        minecraft.getNarrator().sayNow(Component.literal(component.getString()));
    }

    /* JADX INFO: renamed from: a */
    public static void m1578a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull List<Component> list, int i, int i2) {
        if (list.isEmpty()) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        guiGraphics.renderComponentTooltip(font, list, i, i2);
        poseStackPose.popPose();
    }
}
