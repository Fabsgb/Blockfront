package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.AreaLightData;
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
import org.joml.Quaternionf;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.qi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qi.class */
public class C0922qi extends AbstractC0884px implements InterfaceC0844pJ {

    /* JADX INFO: renamed from: ei */
    @NotNull
    private static final ResourceLocation f4831ei = C0564jv.m2555d("textures/misc/debug/mapeffect/light.png");

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final MapCodec<C0922qi> f4832u = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0836pB.f4474G.fieldOf("color").forGetter(c0922qi -> {
            return Integer.valueOf(c0922qi.f4833Y);
        }), Codec.FLOAT.fieldOf("brightness").forGetter(c0922qi2 -> {
            return Float.valueOf(c0922qi2.f4834kU);
        }), Codec.FLOAT.fieldOf("size_x").forGetter(c0922qi3 -> {
            return Float.valueOf(c0922qi3.f4835kV);
        }), Codec.FLOAT.fieldOf("size_y").forGetter(c0922qi4 -> {
            return Float.valueOf(c0922qi4.f4836kW);
        }), Codec.FLOAT.fieldOf("angle").forGetter(c0922qi5 -> {
            return Float.valueOf(c0922qi5.f4837kX);
        }), Codec.FLOAT.fieldOf("distance").forGetter(c0922qi6 -> {
            return Float.valueOf(c0922qi6.f4838gq);
        }), Codec.BOOL.fieldOf("occlude").forGetter(c0922qi7 -> {
            return Boolean.valueOf(c0922qi7.f4839gq);
        }), Codec.FLOAT.optionalFieldOf("rotation_x", Float.valueOf(0.0f)).forGetter(c0922qi8 -> {
            return Float.valueOf(c0922qi8.f4840kY);
        }), Codec.FLOAT.optionalFieldOf("rotation_y", Float.valueOf(0.0f)).forGetter(c0922qi9 -> {
            return Float.valueOf(c0922qi9.f4841kZ);
        }), Codec.FLOAT.optionalFieldOf("rotation_z", Float.valueOf(0.0f)).forGetter(c0922qi10 -> {
            return Float.valueOf(c0922qi10.f4842la);
        }), StringRepresentable.fromEnum(EnumC0886pz::values).optionalFieldOf("application", EnumC0886pz.DEFAULT).forGetter(c0922qi11 -> {
            return c0922qi11.f4843a;
        })).apply(instance, (num, f, f2, f3, f4, f5, bool, f6, f7, f8, enumC0886pz) -> {
            C0922qi c0922qi12 = new C0922qi(num.intValue(), Vec3.ZERO);
            c0922qi12.f4834kU = f.floatValue();
            c0922qi12.f4835kV = f2.floatValue();
            c0922qi12.f4836kW = f3.floatValue();
            c0922qi12.f4837kX = f4.floatValue();
            c0922qi12.f4838gq = f5.floatValue();
            c0922qi12.f4839gq = bool.booleanValue();
            c0922qi12.f4840kY = f6.floatValue();
            c0922qi12.f4841kZ = f7.floatValue();
            c0922qi12.f4842la = f8.floatValue();
            c0922qi12.f4843a = enumC0886pz;
            return c0922qi12;
        });
    });

    /* JADX INFO: renamed from: Y */
    private int f4833Y;

    /* JADX INFO: renamed from: kU */
    private float f4834kU;

    /* JADX INFO: renamed from: kV */
    private float f4835kV;

    /* JADX INFO: renamed from: kW */
    private float f4836kW;

    /* JADX INFO: renamed from: kX */
    private float f4837kX;

    /* JADX INFO: renamed from: gq */
    private float f4838gq;

    /* JADX INFO: renamed from: gq */
    private boolean f4839gq;

    /* JADX INFO: renamed from: kY */
    private float f4840kY;

    /* JADX INFO: renamed from: kZ */
    private float f4841kZ;

    /* JADX INFO: renamed from: la */
    private float f4842la;

    /* JADX INFO: renamed from: a */
    private EnumC0886pz f4843a;

    /* JADX INFO: renamed from: lb */
    private final float f4844lb;

    /* JADX INFO: renamed from: f */
    @Nullable
    private LightRenderHandle<AreaLightData> f4845f;

    public C0922qi() {
        this(ColorReferences.COLOR_WHITE, Vec3.ZERO);
    }

    public C0922qi(int i, @NotNull Vec3 vec3) {
        super(vec3);
        this.f4834kU = 1.5f;
        this.f4835kV = 1.0f;
        this.f4836kW = 1.0f;
        this.f4837kX = 45.0f;
        this.f4838gq = 5.0f;
        this.f4839gq = false;
        this.f4840kY = 0.0f;
        this.f4841kZ = 0.0f;
        this.f4842la = 0.0f;
        this.f4843a = EnumC0886pz.DEFAULT;
        this.f4844lb = ThreadLocalRandom.current().nextFloat() * 1000.0f;
        this.f4833Y = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0884px
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo4446a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4845f != null) {
            return;
        }
        AreaLightData occlusionEnabled = new AreaLightData().setColor(this.f4833Y).setBrightness(this.f4834kU).setSize(this.f4835kV, this.f4836kW).setAngle((float) Math.toRadians(this.f4837kX)).setDistance(this.f4838gq).setOcclusionEnabled(this.f4839gq);
        occlusionEnabled.getPosition().set(this.f4464c.x, this.f4464c.y, this.f4464c.z);
        occlusionEnabled.getOrientation().identity().rotationXYZ((float) Math.toRadians(this.f4840kY), (float) Math.toRadians(this.f4841kZ), (float) Math.toRadians(this.f4842la));
        this.f4845f = VeilRenderSystem.renderer().getLightRenderer().addLight(occlusionEnabled);
    }

    @Override // com.boehmod.blockfront.AbstractC0884px
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4447b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4845f != null) {
            this.f4845f.free();
            this.f4845f = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0884px
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4448b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4845f == null) {
            return;
        }
        AreaLightData areaLightData = (AreaLightData) this.f4845f.getLightData();
        areaLightData.getPosition().set(this.f4464c.x, this.f4464c.y, this.f4464c.z);
        areaLightData.getOrientation().identity().rotationXYZ((float) Math.toRadians(this.f4840kY), (float) Math.toRadians(this.f4841kZ), (float) Math.toRadians(this.f4842la));
        areaLightData.setBrightness(this.f4843a.applyTo(this.f4834kU, f, this.f4844lb));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0850pP(Component.literal("Color"), () -> {
            return Integer.valueOf(this.f4833Y);
        }, num -> {
            this.f4833Y = num.intValue();
        }));
        objectArrayList.add(new C0853pS(Component.literal("Brightness"), () -> {
            return Float.valueOf(this.f4834kU);
        }, f -> {
            this.f4834kU = f.floatValue();
        }, 0.0f, 16.0f));
        objectArrayList.add(new C0853pS(Component.literal("Size X"), () -> {
            return Float.valueOf(this.f4835kV);
        }, f2 -> {
            this.f4835kV = f2.floatValue();
        }, 0.1f, 32.0f));
        objectArrayList.add(new C0853pS(Component.literal("Size Y"), () -> {
            return Float.valueOf(this.f4836kW);
        }, f3 -> {
            this.f4836kW = f3.floatValue();
        }, 0.1f, 32.0f));
        objectArrayList.add(new C0853pS(Component.literal("Angle (deg)"), () -> {
            return Float.valueOf(this.f4837kX);
        }, f4 -> {
            this.f4837kX = f4.floatValue();
        }, 0.1f, 180.0f));
        objectArrayList.add(new C0853pS(Component.literal("Distance"), () -> {
            return Float.valueOf(this.f4838gq);
        }, f5 -> {
            this.f4838gq = f5.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0849pO(Component.literal("Occlude"), () -> {
            return Boolean.valueOf(this.f4839gq);
        }, bool -> {
            this.f4839gq = bool.booleanValue();
        }));
        objectArrayList.add(new C0853pS(Component.literal("Rotation X (deg)"), () -> {
            return Float.valueOf(this.f4840kY);
        }, f6 -> {
            this.f4840kY = f6.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0853pS(Component.literal("Rotation Y (deg)"), () -> {
            return Float.valueOf(this.f4841kZ);
        }, f7 -> {
            this.f4841kZ = f7.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0853pS(Component.literal("Rotation Z (deg)"), () -> {
            return Float.valueOf(this.f4842la);
        }, f8 -> {
            this.f4842la = f8.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0852pR(Component.literal("Application"), EnumC0886pz.class, () -> {
            return this.f4843a;
        }, enumC0886pz -> {
            this.f4843a = enumC0886pz;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4831ei;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aO */
    public float mo4271aO() {
        return this.f4840kY;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aP */
    public float mo4272aP() {
        return this.f4841kZ;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: aQ */
    public float mo4273aQ() {
        return this.f4842la;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: a */
    public void mo4274a(float f, float f2, float f3) {
        this.f4840kY = f;
        this.f4841kZ = f2;
        this.f4842la = f3;
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    /* JADX INFO: renamed from: g */
    public void mo4275g(@NotNull Vec3 vec3) {
        Vector3f eulerAnglesXYZ = new Quaternionf().lookAlong((float) (-vec3.x), (float) (-vec3.y), (float) (-vec3.z), 0.0f, 1.0f, 0.0f).getEulerAnglesXYZ(new Vector3f());
        this.f4840kY = (float) Math.toDegrees(eulerAnglesXYZ.x);
        this.f4841kZ = (float) Math.toDegrees(eulerAnglesXYZ.y);
        this.f4842la = (float) Math.toDegrees(eulerAnglesXYZ.z);
    }

    @Override // com.boehmod.blockfront.InterfaceC0844pJ
    @NotNull
    /* JADX INFO: renamed from: m */
    public Vec3 mo4276m() {
        Vector3f vector3fTransformInverse = new Quaternionf().rotationXYZ((float) Math.toRadians(this.f4840kY), (float) Math.toRadians(this.f4841kZ), (float) Math.toRadians(this.f4842la)).transformInverse(new Vector3f(0.0f, 0.0f, 1.0f));
        return new Vec3(vector3fTransformInverse.x, vector3fTransformInverse.y, vector3fTransformInverse.z);
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
        if (this.f4845f != null) {
            this.f4845f.free();
            this.f4845f = null;
        }
    }
}
