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

/* JADX INFO: renamed from: com.boehmod.blockfront.jn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jn.class */
public class C0557jn {
    /* JADX INFO: renamed from: a */
    public static void m2536a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull CloudItemStack cloudItemStack) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(c0623l.m2855a());
        SoundManager soundManager = minecraft.getSoundManager();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C1312xz.f7953pa;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder2 = null;
        if (cloudItem instanceof CloudItemGun) {
            deferredHolder2 = C1312xz.f7954pb;
        } else if (cloudItem instanceof CloudItemMelee) {
            deferredHolder2 = C1312xz.f7955pc;
        } else if (cloudItem instanceof CloudItemCallingCard) {
            deferredHolder2 = C1312xz.f7956pd;
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 1.0f, 1.0f));
        if (deferredHolder2 != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder2.get(), 1.0f, 1.0f));
        }
    }
}
