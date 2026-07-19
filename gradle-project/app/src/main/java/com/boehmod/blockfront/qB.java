package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qB.class */
public class qB extends pA {

    @NotNull
    private static final ResourceLocation eG = C0265jv.d("textures/misc/debug/mapeffect/condition.png");

    @NotNull
    public static final MapCodec<qB> N = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("targetEffectId", "").forGetter(qBVar -> {
            return qBVar.cc;
        }), a.CODEC.optionalFieldOf("condition", a.GAME_STARTED).forGetter(qBVar2 -> {
            return qBVar2.a;
        })).apply(instance, qB::new);
    });

    @NotNull
    public String cc;

    @NotNull
    public a a;

    @Nullable
    private transient sY b;

    public qB() {
        this("", a.GAME_STARTED);
    }

    public qB(@NotNull String str, @NotNull a aVar) {
        this.cc = str;
        this.a = aVar;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull sY sYVar) {
        super.a(minecraft, sYVar);
        this.b = sYVar;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.b == null || this.cc.isEmpty()) {
            return;
        }
        this.b.a(this.cc, this.a.isMet(oFVar));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pW(Component.literal("Target Effect ID"), () -> {
            return this.cc;
        }, str -> {
            this.cc = str;
        }));
        objectArrayList.add(new pR(Component.literal("Condition"), a.class, () -> {
            return this.a;
        }, aVar -> {
            this.a = aVar;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Target: ").append(Component.literal(this.cc.isEmpty() ? "<none>" : this.cc).withStyle(ChatFormatting.GRAY)));
        list.add(Component.literal("Condition: ").append(Component.literal(this.a.name()).withStyle(ChatFormatting.GRAY)));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eG;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qB$a.class */
    public enum a {
        GAME_STARTED(oFVar -> {
            return oFVar.m750a() == oN.GAME;
        });


        @NotNull
        public static final Codec<a> CODEC = Codec.STRING.xmap(a::valueOf, (v0) -> {
            return v0.name();
        });

        @NotNull
        private final Predicate<oF<?, ?, ?>> predicate;

        a(@NotNull Predicate predicate) {
            this.predicate = predicate;
        }

        public boolean isMet(@NotNull oF<?, ?, ?> oFVar) {
            return this.predicate.test(oFVar);
        }
    }
}
