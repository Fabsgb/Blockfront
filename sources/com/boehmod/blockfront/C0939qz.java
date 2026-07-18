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

/* JADX INFO: renamed from: com.boehmod.blockfront.qz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qz.class */
public class C0939qz extends AbstractC0835pA {

    /* JADX INFO: renamed from: eE */
    @NotNull
    private static final ResourceLocation f4997eE = C0564jv.m2555d("textures/misc/debug/mapeffect/teams.png");

    /* JADX INFO: renamed from: J */
    @NotNull
    private static final Codec<C1074ta> f4998J = ResourceLocation.CODEC.xmap(resourceLocation -> {
        return (C1074ta) Objects.requireNonNull(C1074ta.m5968b(resourceLocation), "Unknown team type: " + String.valueOf(resourceLocation));
    }, (v0) -> {
        return v0.m5975L();
    });

    /* JADX INFO: renamed from: L */
    @NotNull
    public static final MapCodec<C0939qz> f4999L = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(f4998J.fieldOf("alliesTeam").forGetter(c0939qz -> {
            return c0939qz.f5000c;
        }), f4998J.fieldOf("axisTeam").forGetter(c0939qz2 -> {
            return c0939qz2.f5001d;
        })).apply(instance, C0939qz::new);
    });

    /* JADX INFO: renamed from: c */
    @NotNull
    public C1074ta f5000c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public C1074ta f5001d;

    public C0939qz() {
        this.f5000c = C1074ta.m5969a("us_airborne");
        this.f5001d = C1074ta.m5969a("ger_wehrmacht");
    }

    public C0939qz(@NotNull C1074ta c1074ta, @NotNull C1074ta c1074ta2) {
        this.f5000c = C1074ta.m5969a("us_airborne");
        this.f5001d = C1074ta.m5969a("ger_wehrmacht");
        this.f5000c = c1074ta;
        this.f5001d = c1074ta2;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: b */
    public void mo4219b(@NotNull C1017sX c1017sX) {
        c1017sX.m5556d(this.f5000c);
        c1017sX.m5557e(this.f5001d);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Allies Team: " + String.valueOf(this.f5000c.m5975L())));
        list.add(Component.literal("Axis Team: " + String.valueOf(this.f5001d.m5975L())));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4997eE;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0855pU(Component.literal("Allies Team"), () -> {
            return this.f5000c;
        }, c1074ta -> {
            this.f5000c = c1074ta;
        }, Component.literal("Select Allies Team"), () -> {
            return new ObjectArrayList(C1074ta.f5641bR);
        }, c1074ta2 -> {
            return c1074ta2.m5975L().toString();
        }, c1074ta3 -> {
            return Component.literal(c1074ta3.m5975L().toString());
        }));
        objectArrayList.add(new C0855pU(Component.literal("Axis Team"), () -> {
            return this.f5001d;
        }, c1074ta4 -> {
            this.f5001d = c1074ta4;
        }, Component.literal("Select Axis Team"), () -> {
            return new ObjectArrayList(C1074ta.f5641bR);
        }, c1074ta5 -> {
            return c1074ta5.m5975L().toString();
        }, c1074ta6 -> {
            return Component.literal(c1074ta6.m5975L().toString());
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
    }
}
