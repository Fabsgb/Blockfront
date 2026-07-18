package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wK.class */
public class C1217wK {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final BlockSetType f6422a = new BlockSetType("bunker_door", true, false, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL, (SoundEvent) C1280xc.f7759ti.get(), (SoundEvent) C1280xc.f7758th.get(), SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final BlockSetType f6423b = new BlockSetType("blast_door", false, false, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL, (SoundEvent) C1280xc.f7759ti.get(), (SoundEvent) C1280xc.f7758th.get(), SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
}
