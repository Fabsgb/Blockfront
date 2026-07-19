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

/* JADX INFO: renamed from: com.boehmod.blockfront.qn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qn.class */
public class C0446qn extends AbstractC0429px {

    @NotNull
    private static final ResourceLocation eq = C0265jv.d("textures/misc/debug/mapeffect/light.png");

    @NotNull
    public static final MapCodec<C0446qn> z = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("color").forGetter(c0446qn -> {
            return Integer.valueOf(c0446qn.Y);
        }), Codec.FLOAT.fieldOf("brightness").forGetter(c0446qn2 -> {
            return Float.valueOf(c0446qn2.kU);
        }), Codec.FLOAT.fieldOf("radius").forGetter(c0446qn3 -> {
            return Float.valueOf(c0446qn3.iY);
        }), Codec.BOOL.fieldOf("occlude").forGetter(c0446qn4 -> {
            return Boolean.valueOf(c0446qn4.gq);
        }), StringRepresentable.fromEnum(EnumC0431pz::values).optionalFieldOf("application", EnumC0431pz.DEFAULT).forGetter(c0446qn5 -> {
            return c0446qn5.a;
        })).apply(instance, (num, f, f2, bool, enumC0431pz) -> {
            C0446qn c0446qn6 = new C0446qn(num.intValue(), Vec3.ZERO);
            c0446qn6.kU = f.floatValue();
            c0446qn6.iY = f2.floatValue();
            c0446qn6.gq = bool.booleanValue();
            c0446qn6.a = enumC0431pz;
            return c0446qn6;
        });
    });
    private int Y;
    private float kU;
    private float iY;
    private boolean gq;
    private EnumC0431pz a;
    private final float ln;

    @Nullable
    private LightRenderHandle<PointLightData> f;

    public C0446qn() {
        this(ColorReferences.COLOR_WHITE, Vec3.ZERO);
    }

    public C0446qn(int i, @NotNull Vec3 vec3) {
        super(vec3);
        this.kU = 1.5f;
        this.iY = 5.0f;
        this.gq = false;
        this.a = EnumC0431pz.DEFAULT;
        this.ln = ThreadLocalRandom.current().nextFloat() * 1000.0f;
        this.Y = i;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0429px
    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f != null) {
            return;
        }
        this.f = VeilRenderSystem.renderer().getLightRenderer().addLight(new PointLightData().setColor(this.Y).setPosition(this.c.x, this.c.y, this.c.z).setBrightness(this.kU).setRadius(this.iY).setOcclusionEnabled(this.gq));
    }

    @Override // com.boehmod.blockfront.AbstractC0429px
    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f != null) {
            this.f.free();
            this.f = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0429px
    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f == null) {
            return;
        }
        PointLightData pointLightData = (PointLightData) this.f.getLightData();
        pointLightData.setPosition(this.c.x, this.c.y, this.c.z);
        pointLightData.setBrightness(this.a.applyTo(this.kU, f, this.ln));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pP(Component.literal("Color"), () -> {
            return Integer.valueOf(this.Y);
        }, num -> {
            this.Y = num.intValue();
        }));
        objectArrayList.add(new pS(Component.literal("Brightness"), () -> {
            return Float.valueOf(this.kU);
        }, f -> {
            this.kU = f.floatValue();
        }, 0.0f, 16.0f));
        objectArrayList.add(new pS(Component.literal("Radius"), () -> {
            return Float.valueOf(this.iY);
        }, f2 -> {
            this.iY = f2.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new pO(Component.literal("Occlude"), () -> {
            return Boolean.valueOf(this.gq);
        }, bool -> {
            this.gq = bool.booleanValue();
        }));
        objectArrayList.add(new pR(Component.literal("Application"), EnumC0431pz.class, () -> {
            return this.a;
        }, enumC0431pz -> {
            this.a = enumC0431pz;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eq;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0429px, com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        if (this.f != null) {
            this.f.free();
            this.f = null;
        }
    }
}
