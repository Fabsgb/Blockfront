package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hW.class */
public abstract class hW {

    @NotNull
    private static final Map<String, MapCodec<? extends hW>> m = new Object2ObjectOpenHashMap();

    @NotNull
    public static final MapCodec<hW> a;

    @NotNull
    public static final Codec<hW> g;

    @NotNull
    public abstract String r();

    @OnlyIn(Dist.CLIENT)
    public abstract void a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f);

    static {
        m.put(hX.as, hX.b);
        m.put(hZ.at, hZ.c);
        a = Codec.STRING.dispatchMap("entryType", (v0) -> {
            return v0.r();
        }, str -> {
            MapCodec<? extends hW> mapCodec = m.get(str);
            if (mapCodec == null) {
                throw new IllegalArgumentException("No codec registered for environment sound entry type: " + str);
            }
            return mapCodec;
        });
        g = a.codec();
    }
}
