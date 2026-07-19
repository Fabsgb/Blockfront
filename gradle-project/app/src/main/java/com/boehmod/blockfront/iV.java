package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemTrophy;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iV.class */
public class iV {
    public static void a(@NotNull Minecraft minecraft, @NotNull CloudRegistry cloudRegistry, @NotNull CloudItemStack cloudItemStack) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        SoundManager soundManager = minecraft.getSoundManager();
        a(soundManager);
        a(soundManager, cloudItem);
    }

    private static void a(@NotNull SoundManager soundManager, @Nullable CloudItem<? extends CloudItem<?>> cloudItem) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = null;
        if (cloudItem instanceof CloudItemTrophy) {
            deferredHolder = C0624xc.pw;
        }
        if (deferredHolder != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 1.0f, 1.0f));
        }
    }

    private static void a(@NotNull SoundManager soundManager) {
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pv.get(), 1.0f, 1.0f));
    }
}
