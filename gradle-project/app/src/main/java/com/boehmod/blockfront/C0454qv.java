package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Optional;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.qv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qv.class */
public class C0454qv extends pA {

    @NotNull
    private static final ResourceLocation ey = C0265jv.d("textures/misc/debug/mapeffect/shader.png");

    @NotNull
    public static final MapCodec<C0454qv> H = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.optionalFieldOf("shader").forGetter(c0454qv -> {
            return Optional.ofNullable(c0454qv.ez);
        })).apply(instance, optional -> {
            return new C0454qv((ResourceLocation) optional.orElse(null));
        });
    });

    @Nullable
    public ResourceLocation ez;

    public C0454qv() {
    }

    public C0454qv(@Nullable ResourceLocation resourceLocation) {
        this.ez = resourceLocation;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull sY sYVar) {
        sYVar.a(this.ez);
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
        objectArrayList.add(new pW(Component.literal("Shader"), () -> {
            return this.ez != null ? this.ez.toString() : "";
        }, str -> {
            if (str.isEmpty()) {
                this.ez = null;
                return;
            }
            ResourceLocation resourceLocationTryParse = ResourceLocation.tryParse(str);
            if (resourceLocationTryParse != null) {
                this.ez = resourceLocationTryParse;
            }
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Shader: " + (this.ez != null ? this.ez.toString() : "none")));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ey;
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
