package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.iT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iT.class */
public final class C0484iT {

    /* JADX INFO: renamed from: hU */
    @NotNull
    private static final Component f2953hU = Component.translatable("bf.message.chat.report.prompt.title");

    /* JADX INFO: renamed from: hV */
    @NotNull
    private static final Component f2954hV = Component.translatable("bf.message.chat.report.prompt").withStyle(ChatFormatting.GRAY);

    private C0484iT() {
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2170a(@Nullable Style style) {
        ClickEvent clickEvent;
        if (style == null || (clickEvent = style.getClickEvent()) == null || clickEvent.getAction() != ClickEvent.Action.COPY_TO_CLIPBOARD) {
            return false;
        }
        String value = clickEvent.getValue();
        if (!value.startsWith(C1330yq.f9071eV)) {
            return false;
        }
        try {
            UUID uuidFromString = UUID.fromString(value.substring(C1330yq.f9071eV.length()));
            Minecraft minecraft = Minecraft.getInstance();
            C0283ee c0283ee = new C0283ee(null, f2953hU, z -> {
                if (z) {
                    C1169vO.m6648c(new C1248wo(uuidFromString));
                }
                minecraft.setScreen((Screen) null);
            });
            c0283ee.m1324a(f2954hV);
            minecraft.setScreen(c0283ee);
            return true;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
