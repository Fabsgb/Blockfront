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

/* JADX INFO: renamed from: com.boehmod.blockfront.qU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qU.class */
public class C0909qU extends AbstractC0858pW {

    /* JADX INFO: renamed from: eA */
    @NotNull
    private static final ResourceLocation f5084eA = C0532jO.m2378d("textures/misc/debug/mapeffect/sky_settings.png");

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final MapCodec<C0909qU> f5085K = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("disableSky", false).forGetter(c0909qU -> {
            return Boolean.valueOf(c0909qU.f5086gP);
        }), Codec.BOOL.optionalFieldOf("disableClouds", false).forGetter(c0909qU2 -> {
            return Boolean.valueOf(c0909qU2.f5087gQ);
        })).apply(instance, (v1, v2) -> {
            return new C0909qU(v1, v2);
        });
    });

    /* JADX INFO: renamed from: gP */
    public boolean f5086gP;

    /* JADX INFO: renamed from: gQ */
    public boolean f5087gQ;

    public C0909qU() {
    }

    public C0909qU(boolean z, boolean z2) {
        this.f5086gP = z;
        this.f5087gQ = z2;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3953a(@NotNull Minecraft minecraft, @NotNull C1096tv c1096tv) {
        if (this.f5086gP) {
            c1096tv.m6140U(true);
        }
        if (this.f5087gQ) {
            c1096tv.m6132T(true);
        }
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
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0925qk(Component.literal("Disable Sky"), () -> {
            return Boolean.valueOf(this.f5086gP);
        }, bool -> {
            this.f5086gP = bool.booleanValue();
        }));
        objectArrayList.add(new C0925qk(Component.literal("Disable Clouds"), () -> {
            return Boolean.valueOf(this.f5087gQ);
        }, bool2 -> {
            this.f5087gQ = bool2.booleanValue();
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Sky Settings: disableSky=" + this.f5086gP + ", disableClouds=" + this.f5087gQ));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5084eA;
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
