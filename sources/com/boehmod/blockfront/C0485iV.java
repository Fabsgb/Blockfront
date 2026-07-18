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

/* JADX INFO: renamed from: com.boehmod.blockfront.iV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iV.class */
public class C0485iV {
    /* JADX INFO: renamed from: a */
    public static void m2210a(@NotNull Minecraft minecraft, @NotNull CloudRegistry cloudRegistry, @NotNull CloudItemStack cloudItemStack) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        SoundManager soundManager = minecraft.getSoundManager();
        m2212a(soundManager);
        m2211a(soundManager, cloudItem);
    }

    /* JADX INFO: renamed from: a */
    private static void m2211a(@NotNull SoundManager soundManager, @Nullable CloudItem<? extends CloudItem<?>> cloudItem) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = null;
        if (cloudItem instanceof CloudItemTrophy) {
            deferredHolder = C1280xc.f7565pw;
        }
        if (deferredHolder != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 1.0f, 1.0f));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2212a(@NotNull SoundManager soundManager) {
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7564pv.get(), 1.0f, 1.0f));
    }
}
