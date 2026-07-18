package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.Sound;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.sound.PlaySoundSourceEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aI.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0038aI {
    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m192b(@NotNull PlaySoundSourceEvent playSoundSourceEvent) {
        Sound sound;
        InterfaceC0464iA sound2 = playSoundSourceEvent.getSound();
        if ((sound2 instanceof InterfaceC0464iA) && sound2.mo2096V() && (sound = sound2.getSound()) != null) {
            C0513ix.m2255a().m2256a(playSoundSourceEvent.getChannel(), sound.getPath());
        }
    }
}
