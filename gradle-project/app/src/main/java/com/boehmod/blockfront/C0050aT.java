package com.boehmod.blockfront;

import net.minecraft.client.gui.components.toasts.RecipeToast;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.TutorialToast;
import net.minecraft.client.resources.language.I18n;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ToastAddEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aT.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0050aT {

    /* JADX INFO: renamed from: F */
    public static final String f368F = I18n.get("multiplayer.unsecureserver.toast.title", new Object[0]);

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m240a(@NotNull ToastAddEvent toastAddEvent) {
        C0623l c0623lM2852b;
        SystemToast toast = toastAddEvent.getToast();
        if (toast instanceof SystemToast) {
            if (toast.title.getString().equalsIgnoreCase(f368F)) {
                toastAddEvent.setCanceled(true);
            }
        } else if (((toast instanceof RecipeToast) || (toast instanceof TutorialToast)) && (c0623lM2852b = C0623l.m2852b()) != null && c0623lM2852b.m2874a() != null) {
            toastAddEvent.setCanceled(true);
        }
    }
}
