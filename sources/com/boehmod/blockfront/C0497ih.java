package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ih */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ih.class */
public class C0497ih extends AbstractTickableSoundInstance {
    public C0497ih(@NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
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
        float fM6299c = 0.0f;
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (mainHandItem.getItem() instanceof C1144ur) {
            fM6299c = C1144ur.m6299c(mainHandItem);
        }
        this.volume = C1290xm.m7835d(this.volume, fM6299c, 0.1f);
    }
}
