package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Objects;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.qz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qz.class */
public class C0458qz extends pA {

    @NotNull
    private static final ResourceLocation eE = C0265jv.d("textures/misc/debug/mapeffect/teams.png");

    @NotNull
    private static final Codec<C0514ta> J = ResourceLocation.CODEC.xmap(resourceLocation -> {
        return (C0514ta) Objects.requireNonNull(C0514ta.b(resourceLocation), "Unknown team type: " + String.valueOf(resourceLocation));
    }, (v0) -> {
        return v0.L();
    });

    @NotNull
    public static final MapCodec<C0458qz> L = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(J.fieldOf("alliesTeam").forGetter(c0458qz -> {
            return c0458qz.c;
        }), J.fieldOf("axisTeam").forGetter(c0458qz2 -> {
            return c0458qz2.d;
        })).apply(instance, C0458qz::new);
    });

    @NotNull
    public C0514ta c;

    @NotNull
    public C0514ta d;

    public C0458qz() {
        this.c = C0514ta.a("us_airborne");
        this.d = C0514ta.a("ger_wehrmacht");
    }

    public C0458qz(@NotNull C0514ta c0514ta, @NotNull C0514ta c0514ta2) {
        this.c = C0514ta.a("us_airborne");
        this.d = C0514ta.a("ger_wehrmacht");
        this.c = c0514ta;
        this.d = c0514ta2;
    }

    @Override // com.boehmod.blockfront.pA
    public void b(@NotNull sX sXVar) {
        sXVar.d(this.c);
        sXVar.e(this.d);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Allies Team: " + String.valueOf(this.c.L())));
        list.add(Component.literal("Axis Team: " + String.valueOf(this.d.L())));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eE;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pU(Component.literal("Allies Team"), () -> {
            return this.c;
        }, c0514ta -> {
            this.c = c0514ta;
        }, Component.literal("Select Allies Team"), () -> {
            return new ObjectArrayList(C0514ta.bR);
        }, c0514ta2 -> {
            return c0514ta2.L().toString();
        }, c0514ta3 -> {
            return Component.literal(c0514ta3.L().toString());
        }));
        objectArrayList.add(new pU(Component.literal("Axis Team"), () -> {
            return this.d;
        }, c0514ta4 -> {
            this.d = c0514ta4;
        }, Component.literal("Select Axis Team"), () -> {
            return new ObjectArrayList(C0514ta.bR);
        }, c0514ta5 -> {
            return c0514ta5.L().toString();
        }, c0514ta6 -> {
            return Component.literal(c0514ta6.L().toString());
        }));
        return objectArrayList;
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
