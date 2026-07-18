package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hZ.class */
public final class C0436hZ extends AbstractC0433hW {

    /* JADX INFO: renamed from: at */
    @NotNull
    public static final String f2822at = "group_ref";

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final MapCodec<C0436hZ> f2823c = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("group").forGetter(c0436hZ -> {
            return c0436hZ.f2824dh;
        })).apply(instance, C0436hZ::new);
    });

    /* JADX INFO: renamed from: dh */
    @NotNull
    private final ResourceLocation f2824dh;

    public C0436hZ(@NotNull ResourceLocation resourceLocation) {
        this.f2824dh = resourceLocation;
    }

    @Override // com.boehmod.blockfront.AbstractC0433hW
    @NotNull
    /* JADX INFO: renamed from: r */
    public String mo2030r() {
        return f2822at;
    }

    @Override // com.boehmod.blockfront.AbstractC0433hW
    /* JADX INFO: renamed from: a */
    public void mo2031a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f) {
        AbstractC0433hW abstractC0433hWM2046a;
        C0435hY c0435hYM2041a = C0435hY.m2041a(this.f2824dh);
        if (c0435hYM2041a != null && (abstractC0433hWM2046a = c0435hYM2041a.m2046a()) != null) {
            abstractC0433hWM2046a.mo2031a(minecraft, vec3, clientLevel, localPlayer, f);
        }
    }
}
