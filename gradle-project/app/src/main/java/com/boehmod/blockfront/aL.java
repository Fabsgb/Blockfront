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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aL.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aL {
    public static final String A = I18n.get("multiplayer.unsecureserver.toast.title", new Object[0]);

    @SubscribeEvent
    public static void a(@NotNull ToastAddEvent toastAddEvent) {
        C0297l c0297lB;
        SystemToast toast = toastAddEvent.getToast();
        if (toast instanceof SystemToast) {
            if (toast.title.getString().equalsIgnoreCase(A)) {
                toastAddEvent.setCanceled(true);
            }
        } else if (((toast instanceof RecipeToast) || (toast instanceof TutorialToast)) && (c0297lB = C0297l.b()) != null && c0297lB.m591a() != null) {
            toastAddEvent.setCanceled(true);
        }
    }
}
