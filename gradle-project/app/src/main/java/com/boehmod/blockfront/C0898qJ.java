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

/* JADX INFO: renamed from: com.boehmod.blockfront.qJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qJ.class */
public class C0898qJ extends AbstractC0855pT {

    /* JADX INFO: renamed from: eo */
    @NotNull
    private static final ResourceLocation f4983eo = C0532jO.m2378d("textures/misc/debug/mapeffect/light.png");

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final MapCodec<C0898qJ> f4984z = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("color").forGetter(c0898qJ -> {
            return Integer.valueOf(c0898qJ.f4985aM);
        }), Codec.FLOAT.fieldOf("brightness").forGetter(c0898qJ2 -> {
            return Float.valueOf(c0898qJ2.f4986lP);
        }), Codec.FLOAT.fieldOf("radius").forGetter(c0898qJ3 -> {
            return Float.valueOf(c0898qJ3.f4987jR);
        }), Codec.BOOL.fieldOf("occlude").forGetter(c0898qJ4 -> {
            return Boolean.valueOf(c0898qJ4.f4988gK);
        }), Codec.FLOAT.optionalFieldOf("inscattering", Float.valueOf(0.0f)).forGetter(c0898qJ5 -> {
            return Float.valueOf(c0898qJ5.f4989lT);
        }), StringRepresentable.fromEnum(EnumC0857pV::values).optionalFieldOf("application", EnumC0857pV.DEFAULT).forGetter(c0898qJ6 -> {
            return c0898qJ6.f4990a;
        })).apply(instance, (num, f, f2, bool, f3, enumC0857pV) -> {
            C0898qJ c0898qJ7 = new C0898qJ(num.intValue(), Vec3.ZERO);
            c0898qJ7.f4986lP = f.floatValue();
            c0898qJ7.f4987jR = f2.floatValue();
            c0898qJ7.f4988gK = bool.booleanValue();
            c0898qJ7.f4989lT = f3.floatValue();
            c0898qJ7.f4990a = enumC0857pV;
            return c0898qJ7;
        });
    });

    /* JADX INFO: renamed from: aM */
    private int f4985aM;

    /* JADX INFO: renamed from: lP */
    private float f4986lP;

    /* JADX INFO: renamed from: jR */
    private float f4987jR;

    /* JADX INFO: renamed from: gK */
    private boolean f4988gK;

    /* JADX INFO: renamed from: lT */
    private float f4989lT;

    /* JADX INFO: renamed from: a */
    private EnumC0857pV f4990a;

    /* JADX INFO: renamed from: mk */
    private final float f4991mk;

    /* JADX INFO: renamed from: f */
    @Nullable
    private LightRenderHandle<PointLightData> f4992f;

    public C0898qJ() {
        this(ColorReferences.COLOR_WHITE, Vec3.ZERO);
    }

    public C0898qJ(int i, @NotNull Vec3 vec3) {
        super(vec3);
        this.f4986lP = 1.5f;
        this.f4987jR = 5.0f;
        this.f4988gK = false;
        this.f4989lT = 0.0f;
        this.f4990a = EnumC0857pV.DEFAULT;
        this.f4991mk = ThreadLocalRandom.current().nextFloat() * 1000.0f;
        this.f4985aM = i;
    }

    /* JADX INFO: renamed from: a */
    public C0898qJ m4799a(float f) {
        this.f4986lP = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0898qJ m4800b(float f) {
        this.f4987jR = f;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3935a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4992f != null) {
            return;
        }
        this.f4992f = VeilRenderSystem.renderer().getLightRenderer().addLight(new PointLightData().setColor(this.f4985aM).setPosition(this.f4593c.x, this.f4593c.y, this.f4593c.z).setBrightness(this.f4986lP).setRadius(this.f4987jR).setOcclusionEnabled(this.f4988gK).setInscatteringStrength(this.f4989lT));
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3936b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4992f != null) {
            this.f4992f.free();
            this.f4992f = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3937b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4992f == null) {
            return;
        }
        PointLightData pointLightData = (PointLightData) this.f4992f.getLightData();
        pointLightData.setPosition(this.f4593c.x, this.f4593c.y, this.f4593c.z);
        float fApplyTo = this.f4990a.applyTo(this.f4986lP, f, this.f4991mk);
        pointLightData.setBrightness(fApplyTo);
        pointLightData.setInscatteringStrength(this.f4986lP > 0.0f ? this.f4989lT * (fApplyTo / this.f4986lP) : this.f4989lT);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0926ql(Component.literal("Color"), () -> {
            return Integer.valueOf(this.f4985aM);
        }, num -> {
            this.f4985aM = num.intValue();
        }));
        objectArrayList.add(new C0929qo(Component.literal("Brightness"), () -> {
            return Float.valueOf(this.f4986lP);
        }, f -> {
            this.f4986lP = f.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0929qo(Component.literal("Radius"), () -> {
            return Float.valueOf(this.f4987jR);
        }, f2 -> {
            this.f4987jR = f2.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0925qk(Component.literal("Occlude"), () -> {
            return Boolean.valueOf(this.f4988gK);
        }, bool -> {
            this.f4988gK = bool.booleanValue();
        }));
        objectArrayList.add(new C0929qo(Component.literal("In-scattering"), () -> {
            return Float.valueOf(this.f4989lT);
        }, f3 -> {
            this.f4989lT = f3.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0928qn(Component.literal("Application"), EnumC0857pV.class, () -> {
            return this.f4990a;
        }, enumC0857pV -> {
            this.f4990a = enumC0857pV;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4983eo;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT, com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        if (this.f4992f != null) {
            this.f4992f.free();
            this.f4992f = null;
        }
    }
}
