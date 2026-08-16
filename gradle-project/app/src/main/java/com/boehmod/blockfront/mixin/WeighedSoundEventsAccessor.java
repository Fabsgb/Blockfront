package com.boehmod.blockfront.mixin;

import java.util.List;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.client.sounds.Weighted;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/WeighedSoundEventsAccessor.class */
@Mixin({WeighedSoundEvents.class})
public interface WeighedSoundEventsAccessor {
    @Accessor("list")
    List<Weighted<Sound>> getList();
}
