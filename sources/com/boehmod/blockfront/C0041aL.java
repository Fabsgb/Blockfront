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

/* JADX INFO: renamed from: com.boehmod.blockfront.aL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aL.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0041aL {

    /* JADX INFO: renamed from: A */
    public static final String f268A = I18n.get("multiplayer.unsecureserver.toast.title", new Object[0]);

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m198a(@NotNull ToastAddEvent toastAddEvent) {
        C0622l c0622lM2667b;
        SystemToast toast = toastAddEvent.getToast();
        if (toast instanceof SystemToast) {
            if (toast.title.getString().equalsIgnoreCase(f268A)) {
                toastAddEvent.setCanceled(true);
            }
        } else if (((toast instanceof RecipeToast) || (toast instanceof TutorialToast)) && (c0622lM2667b = C0622l.m2667b()) != null && c0622lM2667b.m2688a() != null) {
            toastAddEvent.setCanceled(true);
        }
    }
}
