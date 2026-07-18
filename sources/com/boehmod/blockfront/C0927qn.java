package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.PointLightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.qn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qn.class */
public class C0927qn extends AbstractC0884px {

    /* JADX INFO: renamed from: eq */
    @NotNull
    private static final ResourceLocation f4903eq = C0564jv.m2555d("textures/misc/debug/mapeffect/light.png");

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final MapCodec<C0927qn> f4904z = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("color").forGetter(c0927qn -> {
            return Integer.valueOf(c0927qn.f4905Y);
        }), Codec.FLOAT.fieldOf("brightness").forGetter(c0927qn2 -> {
            return Float.valueOf(c0927qn2.f4906kU);
        }), Codec.FLOAT.fieldOf("radius").forGetter(c0927qn3 -> {
            return Float.valueOf(c0927qn3.f4907iY);
        }), Codec.BOOL.fieldOf("occlude").forGetter(c0927qn4 -> {
            return Boolean.valueOf(c0927qn4.f4908gq);
        }), StringRepresentable.fromEnum(EnumC0886pz::values).optionalFieldOf("application", EnumC0886pz.DEFAULT).forGetter(c0927qn5 -> {
            return c0927qn5.f4909a;
        })).apply(instance, (num, f, f2, bool, enumC0886pz) -> {
            C0927qn c0927qn6 = new C0927qn(num.intValue(), Vec3.ZERO);
            c0927qn6.f4906kU = f.floatValue();
            c0927qn6.f4907iY = f2.floatValue();
            c0927qn6.f4908gq = bool.booleanValue();
            c0927qn6.f4909a = enumC0886pz;
            return c0927qn6;
        });
    });

    /* JADX INFO: renamed from: Y */
    private int f4905Y;

    /* JADX INFO: renamed from: kU */
    private float f4906kU;

    /* JADX INFO: renamed from: iY */
    private float f4907iY;

    /* JADX INFO: renamed from: gq */
    private boolean f4908gq;

    /* JADX INFO: renamed from: a */
    private EnumC0886pz f4909a;

    /* JADX INFO: renamed from: ln */
    private final float f4910ln;

    /* JADX INFO: renamed from: f */
    @Nullable
    private LightRenderHandle<PointLightData> f4911f;

    public C0927qn() {
        this(ColorReferences.COLOR_WHITE, Vec3.ZERO);
    }

    public C0927qn(int i, @NotNull Vec3 vec3) {
        super(vec3);
        this.f4906kU = 1.5f;
        this.f4907iY = 5.0f;
        this.f4908gq = false;
        this.f4909a = EnumC0886pz.DEFAULT;
        this.f4910ln = ThreadLocalRandom.current().nextFloat() * 1000.0f;
        this.f4905Y = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0884px
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo4446a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4911f != null) {
            return;
        }
        this.f4911f = VeilRenderSystem.renderer().getLightRenderer().addLight(new PointLightData().setColor(this.f4905Y).setPosition(this.f4464c.x, this.f4464c.y, this.f4464c.z).setBrightness(this.f4906kU).setRadius(this.f4907iY).setOcclusionEnabled(this.f4908gq));
    }

    @Override // com.boehmod.blockfront.AbstractC0884px
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4447b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4911f != null) {
            this.f4911f.free();
            this.f4911f = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0884px
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4448b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4911f == null) {
            return;
        }
        PointLightData pointLightData = (PointLightData) this.f4911f.getLightData();
        pointLightData.setPosition(this.f4464c.x, this.f4464c.y, this.f4464c.z);
        pointLightData.setBrightness(this.f4909a.applyTo(this.f4906kU, f, this.f4910ln));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0850pP(Component.literal("Color"), () -> {
            return Integer.valueOf(this.f4905Y);
        }, num -> {
            this.f4905Y = num.intValue();
        }));
        objectArrayList.add(new C0853pS(Component.literal("Brightness"), () -> {
            return Float.valueOf(this.f4906kU);
        }, f -> {
            this.f4906kU = f.floatValue();
        }, 0.0f, 16.0f));
        objectArrayList.add(new C0853pS(Component.literal("Radius"), () -> {
            return Float.valueOf(this.f4907iY);
        }, f2 -> {
            this.f4907iY = f2.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0849pO(Component.literal("Occlude"), () -> {
            return Boolean.valueOf(this.f4908gq);
        }, bool -> {
            this.f4908gq = bool.booleanValue();
        }));
        objectArrayList.add(new C0852pR(Component.literal("Application"), EnumC0886pz.class, () -> {
            return this.f4909a;
        }, enumC0886pz -> {
            this.f4909a = enumC0886pz;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4903eq;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0884px, com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        if (this.f4911f != null) {
            this.f4911f.free();
            this.f4911f = null;
        }
    }
}
