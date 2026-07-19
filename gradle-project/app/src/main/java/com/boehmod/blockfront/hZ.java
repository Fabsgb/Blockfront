package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hZ.class */
public final class hZ extends hW {

    @NotNull
    public static final String at = "group_ref";

    @NotNull
    public static final MapCodec<hZ> c = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("group").forGetter(hZVar -> {
            return hZVar.dh;
        })).apply(instance, hZ::new);
    });

    @NotNull
    private final ResourceLocation dh;

    public hZ(@NotNull ResourceLocation resourceLocation) {
        this.dh = resourceLocation;
    }

    @Override // com.boehmod.blockfront.hW
    @NotNull
    public String r() {
        return at;
    }

    @Override // com.boehmod.blockfront.hW
    public void a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f) {
        hW hWVarM465a;
        hY hYVarA = hY.a(this.dh);
        if (hYVarA != null && (hWVarM465a = hYVarA.m465a()) != null) {
            hWVarM465a.a(minecraft, vec3, clientLevel, localPlayer, f);
        }
    }
}
