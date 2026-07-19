package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ih, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ih.class */
public class C0224ih extends AbstractTickableSoundInstance {
    public C0224ih(@NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.looping = true;
        this.attenuation = SoundInstance.Attenuation.NONE;
        this.volume = 0.0f;
    }

    public boolean canPlaySound() {
        return Minecraft.getInstance().player != null;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        this.x = localPlayer.getX();
        this.y = localPlayer.getY();
        this.z = localPlayer.getZ();
        float fM1199c = 0.0f;
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (mainHandItem.getItem() instanceof C0558ur) {
            fM1199c = C0558ur.m1199c(mainHandItem);
        }
        this.volume = C0634xm.d(this.volume, fM1199c, 0.1f);
    }
}
