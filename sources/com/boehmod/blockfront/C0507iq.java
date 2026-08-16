package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iq.class */
public final class C0507iq extends AbstractC0504in {

    /* JADX INFO: renamed from: az */
    @NotNull
    public static final String f3124az = "group_ref";

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final MapCodec<C0507iq> f3125c = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("group").forGetter(c0507iq -> {
            return c0507iq.f3126dh;
        })).apply(instance, C0507iq::new);
    });

    /* JADX INFO: renamed from: dh */
    @NotNull
    private final ResourceLocation f3126dh;

    public C0507iq(@NotNull ResourceLocation resourceLocation) {
        this.f3126dh = resourceLocation;
    }

    @Override // com.boehmod.blockfront.AbstractC0504in
    @NotNull
    /* JADX INFO: renamed from: v */
    public String mo2264v() {
        return f3124az;
    }

    @Override // com.boehmod.blockfront.AbstractC0504in
    /* JADX INFO: renamed from: a */
    public void mo2265a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f) {
        AbstractC0504in abstractC0504inM2280a;
        C0506ip c0506ipM2275a = C0506ip.m2275a(this.f3126dh);
        if (c0506ipM2275a != null && (abstractC0504inM2280a = c0506ipM2275a.m2280a()) != null) {
            abstractC0504inM2280a.mo2265a(minecraft, vec3, clientLevel, localPlayer, f);
        }
    }
}
