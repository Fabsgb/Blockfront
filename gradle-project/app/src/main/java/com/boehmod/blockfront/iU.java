package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCallingCard;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import com.boehmod.bflib.cloud.common.item.types.CloudItemMelee;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iU.class */
public class iU {
    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull CloudItemStack cloudItemStack) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(c0297l.a());
        SoundManager soundManager = minecraft.getSoundManager();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C0624xc.oY;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder2 = null;
        if (cloudItem instanceof CloudItemGun) {
            deferredHolder2 = C0624xc.oZ;
        } else if (cloudItem instanceof CloudItemMelee) {
            deferredHolder2 = C0624xc.pa;
        } else if (cloudItem instanceof CloudItemCallingCard) {
            deferredHolder2 = C0624xc.pb;
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 1.0f, 1.0f));
        if (deferredHolder2 != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder2.get(), 1.0f, 1.0f));
        }
    }
}
