package com.boehmod.blockfront;

import java.util.Locale;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.sound.PlaySoundSourceEvent;
import net.neoforged.neoforge.client.event.sound.PlayStreamingSourceEvent;
import net.neoforged.neoforge.event.PlayLevelSoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aH.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aH {
    @SubscribeEvent
    public static void a(@NotNull PlaySoundSourceEvent playSoundSourceEvent) {
        String lowerCase = playSoundSourceEvent.getName().toLowerCase(Locale.ROOT);
        SoundInstance sound = playSoundSourceEvent.getSound();
        SoundEngine engine = playSoundSourceEvent.getEngine();
        if (lowerCase.equals("entity.generic.explode")) {
            engine.stop(sound);
        }
    }

    @SubscribeEvent
    public static void a(@NotNull PlayStreamingSourceEvent playStreamingSourceEvent) {
        SoundInstance sound = playStreamingSourceEvent.getSound();
        SoundEngine engine = playStreamingSourceEvent.getEngine();
        if (sound.getSource() == SoundSource.MUSIC && !sound.getLocation().getNamespace().equals("bf")) {
            engine.stop(sound);
        }
    }

    @SubscribeEvent
    public static void a(@NotNull PlayLevelSoundEvent.AtPosition atPosition) {
        Holder sound = atPosition.getSound();
        if (sound == null) {
            return;
        }
        a(atPosition, (String) sound.unwrap().map(resourceKey -> {
            return resourceKey.location().getPath();
        }, soundEvent -> {
            return soundEvent.getLocation().getPath();
        }));
    }

    @SubscribeEvent
    public static void a(@NotNull PlayLevelSoundEvent.AtEntity atEntity) {
        Holder sound = atEntity.getSound();
        if (sound == null) {
            return;
        }
        a(atEntity, (String) sound.unwrap().map(resourceKey -> {
            return resourceKey.location().getPath();
        }, soundEvent -> {
            return soundEvent.getLocation().getPath();
        }));
    }

    private static void a(@NotNull PlayLevelSoundEvent playLevelSoundEvent, String str) {
        if (playLevelSoundEvent.getOriginalVolume() > 0.0f && str.endsWith(".step") && playLevelSoundEvent.getSource() == SoundSource.PLAYERS) {
            playLevelSoundEvent.setNewVolume(0.3f);
        }
    }
}
