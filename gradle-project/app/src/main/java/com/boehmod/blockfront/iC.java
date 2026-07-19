package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iC.class */
public final class iC {

    @NotNull
    private static final String au = "aka.ms/JavaAccountSettings";

    @NotNull
    public static final Component hL = Component.translatable("bf.message.chat.disabled").withStyle(ChatFormatting.RED).append(" ").append(Component.translatable("bf.message.chat.disabled.visit").withStyle(ChatFormatting.RED)).append(" ").append(Component.literal(au).withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GRAY));

    private iC() {
    }

    public static void c(@NotNull Minecraft minecraft, @NotNull Component component) {
        minecraft.gui.getChat().addMessage(component);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), 1.0f));
    }

    public static boolean f(@NotNull Minecraft minecraft) {
        return minecraft.getChatStatus().isChatAllowed(minecraft.isLocalServer());
    }

    public static boolean X() {
        C0297l c0297lB = C0297l.b();
        return (c0297lB == null || c0297lB.m591a() == null) ? false : true;
    }
}
