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

/* JADX INFO: renamed from: com.boehmod.blockfront.in */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/in.class */
public abstract class AbstractC0504in {

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final Map<String, MapCodec<? extends AbstractC0504in>> f3106m = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final MapCodec<AbstractC0504in> f3107a;

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final Codec<AbstractC0504in> f3108g;

    @NotNull
    /* JADX INFO: renamed from: v */
    public abstract String mo2264v();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo2265a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f);

    static {
        f3106m.put(C0505io.f3109ay, C0505io.f3110b);
        f3106m.put(C0507iq.f3124az, C0507iq.f3125c);
        f3107a = Codec.STRING.dispatchMap("entryType", (v0) -> {
            return v0.mo2264v();
        }, str -> {
            MapCodec<? extends AbstractC0504in> mapCodec = f3106m.get(str);
            if (mapCodec == null) {
                throw new IllegalArgumentException("No codec registered for environment sound entry type: " + str);
            }
            return mapCodec;
        });
        f3108g = f3107a.codec();
    }
}
