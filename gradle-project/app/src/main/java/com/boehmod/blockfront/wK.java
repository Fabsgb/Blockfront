package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wK.class */
public class wK {

    @NotNull
    public static final BlockSetType a = new BlockSetType("bunker_door", true, false, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL, (SoundEvent) C0624xc.ti.get(), (SoundEvent) C0624xc.th.get(), SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);

    @NotNull
    public static final BlockSetType b = new BlockSetType("blast_door", false, false, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL, (SoundEvent) C0624xc.ti.get(), (SoundEvent) C0624xc.th.get(), SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
}
