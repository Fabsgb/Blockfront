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

/* JADX INFO: renamed from: com.boehmod.blockfront.jo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jo.class */
public class C0558jo {
    /* JADX INFO: renamed from: a */
    public static void m2537a(@NotNull Minecraft minecraft, @NotNull CloudRegistry cloudRegistry, @NotNull CloudItemStack cloudItemStack) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        SoundManager soundManager = minecraft.getSoundManager();
        m2539a(soundManager);
        m2538a(soundManager, cloudItem);
    }

    /* JADX INFO: renamed from: a */
    private static void m2538a(@NotNull SoundManager soundManager, @Nullable CloudItem<? extends CloudItem<?>> cloudItem) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = null;
        if (cloudItem instanceof CloudItemTrophy) {
            deferredHolder = C1312xz.f7977py;
        }
        if (deferredHolder != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 1.0f, 1.0f));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2539a(@NotNull SoundManager soundManager) {
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7976px.get(), 1.0f, 1.0f));
    }
}
