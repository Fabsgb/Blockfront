package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qx.class */
public class C0456qx extends pA {

    @NotNull
    private static final ResourceLocation eB = C0265jv.d("textures/misc/debug/mapeffect/sky_settings.png");

    @NotNull
    public static final MapCodec<C0456qx> J = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("disableSky", false).forGetter(c0456qx -> {
            return Boolean.valueOf(c0456qx.gv);
        }), Codec.BOOL.optionalFieldOf("disableClouds", false).forGetter(c0456qx2 -> {
            return Boolean.valueOf(c0456qx2.gw);
        })).apply(instance, (v1, v2) -> {
            return new C0456qx(v1, v2);
        });
    });
    public boolean gv;
    public boolean gw;

    public C0456qx() {
    }

    public C0456qx(boolean z, boolean z2) {
        this.gv = z;
        this.gw = z2;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull sY sYVar) {
        if (this.gv) {
            sYVar.T(true);
        }
        if (this.gw) {
            sYVar.S(true);
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pO(Component.literal("Disable Sky"), () -> {
            return Boolean.valueOf(this.gv);
        }, bool -> {
            this.gv = bool.booleanValue();
        }));
        objectArrayList.add(new pO(Component.literal("Disable Clouds"), () -> {
            return Boolean.valueOf(this.gw);
        }, bool2 -> {
            this.gw = bool2.booleanValue();
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Sky Settings: disableSky=" + this.gv + ", disableClouds=" + this.gw));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eB;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
    }
}
