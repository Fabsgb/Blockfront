package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iU.class */
public final class C0485iU {

    /* JADX INFO: renamed from: aA */
    @NotNull
    private static final String f2955aA = "aka.ms/JavaAccountSettings";

    /* JADX INFO: renamed from: hW */
    @NotNull
    public static final Component f2956hW = Component.translatable("bf.message.chat.disabled").withStyle(ChatFormatting.RED).append(" ").append(Component.translatable("bf.message.chat.disabled.visit").withStyle(ChatFormatting.RED)).append(" ").append(Component.literal(f2955aA).withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GRAY));

    private C0485iU() {
    }

    /* JADX INFO: renamed from: c */
    public static void m2172c(@NotNull Minecraft minecraft, @NotNull Component component) {
        minecraft.gui.getChat().addMessage(component);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), 1.0f));
    }

    /* JADX INFO: renamed from: f */
    public static boolean m2173f(@NotNull Minecraft minecraft) {
        return minecraft.getChatStatus().isChatAllowed(minecraft.isLocalServer());
    }

    /* JADX INFO: renamed from: Y */
    public static boolean m2174Y() {
        C0623l c0623lM2852b = C0623l.m2852b();
        return (c0623lM2852b == null || c0623lM2852b.m2874a() == null) ? false : true;
    }
}
