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

/* JADX INFO: renamed from: com.boehmod.blockfront.qW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qW.class */
public class C0911qW extends AbstractC0858pW {

    /* JADX INFO: renamed from: eD */
    @NotNull
    private static final ResourceLocation f5093eD = C0532jO.m2378d("textures/misc/debug/mapeffect/teams.png");

    /* JADX INFO: renamed from: J */
    @NotNull
    private static final Codec<C1098tx> f5094J = ResourceLocation.CODEC.xmap(resourceLocation -> {
        return (C1098tx) Objects.requireNonNull(C1098tx.m6171b(resourceLocation), "Unknown team type: " + String.valueOf(resourceLocation));
    }, (v0) -> {
        return v0.m6178M();
    });

    /* JADX INFO: renamed from: M */
    @NotNull
    public static final MapCodec<C0911qW> f5095M = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(f5094J.fieldOf("alliesTeam").forGetter(c0911qW -> {
            return c0911qW.f5096c;
        }), f5094J.fieldOf("axisTeam").forGetter(c0911qW2 -> {
            return c0911qW2.f5097d;
        })).apply(instance, C0911qW::new);
    });

    /* JADX INFO: renamed from: c */
    @NotNull
    public C1098tx f5096c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public C1098tx f5097d;

    public C0911qW() {
        this.f5096c = C1098tx.m6172a("us_airborne");
        this.f5097d = C1098tx.m6172a("ger_wehrmacht");
    }

    public C0911qW(@NotNull C1098tx c1098tx, @NotNull C1098tx c1098tx2) {
        this.f5096c = C1098tx.m6172a("us_airborne");
        this.f5097d = C1098tx.m6172a("ger_wehrmacht");
        this.f5096c = c1098tx;
        this.f5097d = c1098tx2;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: b */
    public void mo3954b(@NotNull C1095tu c1095tu) {
        c1095tu.m6044d(this.f5096c);
        c1095tu.m6045e(this.f5097d);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Allies Team: " + String.valueOf(this.f5096c.m6178M())));
        list.add(Component.literal("Axis Team: " + String.valueOf(this.f5097d.m6178M())));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5093eD;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0931qq(Component.literal("Allies Team"), () -> {
            return this.f5096c;
        }, c1098tx -> {
            this.f5096c = c1098tx;
        }, Component.literal("Select Allies Team"), () -> {
            return new ObjectArrayList(C1098tx.f5986bY);
        }, c1098tx2 -> {
            return c1098tx2.m6178M().toString();
        }, c1098tx3 -> {
            return Component.literal(c1098tx3.m6178M().toString());
        }));
        objectArrayList.add(new C0931qq(Component.literal("Axis Team"), () -> {
            return this.f5097d;
        }, c1098tx4 -> {
            this.f5097d = c1098tx4;
        }, Component.literal("Select Axis Team"), () -> {
            return new ObjectArrayList(C1098tx.f5986bY);
        }, c1098tx5 -> {
            return c1098tx5.m6178M().toString();
        }, c1098tx6 -> {
            return Component.literal(c1098tx6.m6178M().toString());
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
    }
}
