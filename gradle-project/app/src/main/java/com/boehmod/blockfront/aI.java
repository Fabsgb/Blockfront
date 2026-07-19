package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.Sound;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.sound.PlaySoundSourceEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aI.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aI {
    @SubscribeEvent
    public static void b(@NotNull PlaySoundSourceEvent playSoundSourceEvent) {
        Sound sound;
        iA sound2 = playSoundSourceEvent.getSound();
        if ((sound2 instanceof iA) && sound2.V() && (sound = sound2.getSound()) != null) {
            C0240ix.a().a(playSoundSourceEvent.getChannel(), sound.getPath());
        }
    }
}
