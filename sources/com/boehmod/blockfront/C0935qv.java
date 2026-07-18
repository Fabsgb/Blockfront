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

/* JADX INFO: renamed from: com.boehmod.blockfront.qv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qv.class */
public class C0935qv extends AbstractC0835pA {

    /* JADX INFO: renamed from: ey */
    @NotNull
    private static final ResourceLocation f4974ey = C0564jv.m2555d("textures/misc/debug/mapeffect/shader.png");

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final MapCodec<C0935qv> f4975H = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.optionalFieldOf("shader").forGetter(c0935qv -> {
            return Optional.ofNullable(c0935qv.f4976ez);
        })).apply(instance, optional -> {
            return new C0935qv((ResourceLocation) optional.orElse(null));
        });
    });

    /* JADX INFO: renamed from: ez */
    @Nullable
    public ResourceLocation f4976ez;

    public C0935qv() {
    }

    public C0935qv(@Nullable ResourceLocation resourceLocation) {
        this.f4976ez = resourceLocation;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4218a(@NotNull Minecraft minecraft, @NotNull C1018sY c1018sY) {
        c1018sY.m5654a(this.f4976ez);
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
        objectArrayList.add(new C0857pW(Component.literal("Shader"), () -> {
            return this.f4976ez != null ? this.f4976ez.toString() : "";
        }, str -> {
            if (str.isEmpty()) {
                this.f4976ez = null;
                return;
            }
            ResourceLocation resourceLocationTryParse = ResourceLocation.tryParse(str);
            if (resourceLocationTryParse != null) {
                this.f4976ez = resourceLocationTryParse;
            }
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Shader: " + (this.f4976ez != null ? this.f4976ez.toString() : "none")));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4974ey;
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
