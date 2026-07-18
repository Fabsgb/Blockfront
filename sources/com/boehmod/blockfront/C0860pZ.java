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

/* JADX INFO: renamed from: com.boehmod.blockfront.pZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pZ.class */
public class C0860pZ extends AbstractC0835pA {

    /* JADX INFO: renamed from: dW */
    @NotNull
    private static final ResourceLocation f4500dW = C0564jv.m2555d("textures/misc/debug/mapeffect/author.png");

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final MapCodec<C0860pZ> f4501l = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("author").forGetter(c0860pZ -> {
            return c0860pZ.f4502bX;
        })).apply(instance, C0860pZ::new);
    });

    /* JADX INFO: renamed from: bX */
    @NotNull
    public String f4502bX;

    public C0860pZ() {
        this.f4502bX = "";
    }

    public C0860pZ(@NotNull String str) {
        this.f4502bX = "";
        this.f4502bX = str;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: b */
    public void mo4219b(@NotNull C1017sX c1017sX) {
        c1017sX.m5555D(this.f4502bX);
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
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0857pW(Component.literal("Author"), () -> {
            return this.f4502bX;
        }, str -> {
            this.f4502bX = str;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Author: " + this.f4502bX));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4500dW;
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
