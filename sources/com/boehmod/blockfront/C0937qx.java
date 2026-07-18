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

/* JADX INFO: renamed from: com.boehmod.blockfront.qx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qx.class */
public class C0937qx extends AbstractC0835pA {

    /* JADX INFO: renamed from: eB */
    @NotNull
    private static final ResourceLocation f4988eB = C0564jv.m2555d("textures/misc/debug/mapeffect/sky_settings.png");

    /* JADX INFO: renamed from: J */
    @NotNull
    public static final MapCodec<C0937qx> f4989J = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("disableSky", false).forGetter(c0937qx -> {
            return Boolean.valueOf(c0937qx.f4990gv);
        }), Codec.BOOL.optionalFieldOf("disableClouds", false).forGetter(c0937qx2 -> {
            return Boolean.valueOf(c0937qx2.f4991gw);
        })).apply(instance, (v1, v2) -> {
            return new C0937qx(v1, v2);
        });
    });

    /* JADX INFO: renamed from: gv */
    public boolean f4990gv;

    /* JADX INFO: renamed from: gw */
    public boolean f4991gw;

    public C0937qx() {
    }

    public C0937qx(boolean z, boolean z2) {
        this.f4990gv = z;
        this.f4991gw = z2;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4218a(@NotNull Minecraft minecraft, @NotNull C1018sY c1018sY) {
        if (this.f4990gv) {
            c1018sY.m5652T(true);
        }
        if (this.f4991gw) {
            c1018sY.m5644S(true);
        }
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
        objectArrayList.add(new C0849pO(Component.literal("Disable Sky"), () -> {
            return Boolean.valueOf(this.f4990gv);
        }, bool -> {
            this.f4990gv = bool.booleanValue();
        }));
        objectArrayList.add(new C0849pO(Component.literal("Disable Clouds"), () -> {
            return Boolean.valueOf(this.f4991gw);
        }, bool2 -> {
            this.f4991gw = bool2.booleanValue();
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Sky Settings: disableSky=" + this.f4990gv + ", disableClouds=" + this.f4991gw));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4988eB;
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
