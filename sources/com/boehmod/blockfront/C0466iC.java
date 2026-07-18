package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iC.class */
public final class C0466iC {

    /* JADX INFO: renamed from: au */
    @NotNull
    private static final String f2881au = "aka.ms/JavaAccountSettings";

    /* JADX INFO: renamed from: hL */
    @NotNull
    public static final Component f2882hL = Component.translatable("bf.message.chat.disabled").withStyle(ChatFormatting.RED).append(" ").append(Component.translatable("bf.message.chat.disabled.visit").withStyle(ChatFormatting.RED)).append(" ").append(Component.literal(f2881au).withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GRAY));

    private C0466iC() {
    }

    /* JADX INFO: renamed from: c */
    public static void m2099c(@NotNull Minecraft minecraft, @NotNull Component component) {
        minecraft.gui.getChat().addMessage(component);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), 1.0f));
    }

    /* JADX INFO: renamed from: f */
    public static boolean m2100f(@NotNull Minecraft minecraft) {
        return minecraft.getChatStatus().isChatAllowed(minecraft.isLocalServer());
    }

    /* JADX INFO: renamed from: X */
    public static boolean m2101X() {
        C0622l c0622lM2667b = C0622l.m2667b();
        return (c0622lM2667b == null || c0622lM2667b.m2688a() == null) ? false : true;
    }
}
