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

/* JADX INFO: renamed from: com.boehmod.blockfront.hW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hW.class */
public abstract class AbstractC0433hW {

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final Map<String, MapCodec<? extends AbstractC0433hW>> f2804m = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final MapCodec<AbstractC0433hW> f2805a;

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final Codec<AbstractC0433hW> f2806g;

    @NotNull
    /* JADX INFO: renamed from: r */
    public abstract String mo2030r();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo2031a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f);

    static {
        f2804m.put(C0434hX.f2807as, C0434hX.f2808b);
        f2804m.put(C0436hZ.f2822at, C0436hZ.f2823c);
        f2805a = Codec.STRING.dispatchMap("entryType", (v0) -> {
            return v0.mo2030r();
        }, str -> {
            MapCodec<? extends AbstractC0433hW> mapCodec = f2804m.get(str);
            if (mapCodec == null) {
                throw new IllegalArgumentException("No codec registered for environment sound entry type: " + str);
            }
            return mapCodec;
        });
        f2806g = f2805a.codec();
    }
}
