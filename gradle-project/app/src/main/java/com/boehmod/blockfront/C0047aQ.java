package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.Sound;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.sound.PlaySoundSourceEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aQ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0047aQ {
    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m234b(@NotNull PlaySoundSourceEvent playSoundSourceEvent) {
        Sound sound;
        InterfaceC0482iR sound2 = playSoundSourceEvent.getSound();
        if ((sound2 instanceof InterfaceC0482iR) && sound2.mo2136W() && (sound = sound2.getSound()) != null) {
            C0479iO.m2144a().m2145a(playSoundSourceEvent.getChannel(), sound.getPath());
        }
    }
}
