package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.SpotLightData;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.qO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qO.class */
public class C0903qO extends AbstractC0855pT implements InterfaceC0920qf {

    /* JADX INFO: renamed from: et */
    @NotNull
    private static final ResourceLocation f5031et = C0532jO.m2378d("textures/misc/debug/mapeffect/light.png");

    /* JADX INFO: renamed from: E */
    @NotNull
    public static final MapCodec<C0903qO> f5032E = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0859pX.f4603G.fieldOf("color").forGetter(c0903qO -> {
            return Integer.valueOf(c0903qO.f5033aM);
        }), Codec.FLOAT.fieldOf("brightness").forGetter(c0903qO2 -> {
            return Float.valueOf(c0903qO2.f5034lP);
        }), Codec.FLOAT.fieldOf("size").forGetter(c0903qO3 -> {
            return Float.valueOf(c0903qO3.f5035mp);
        }), Codec.FLOAT.fieldOf("angle").forGetter(c0903qO4 -> {
            return Float.valueOf(c0903qO4.f5036lS);
        }), Codec.FLOAT.fieldOf("distance").forGetter(c0903qO5 -> {
            return Float.valueOf(c0903qO5.f5037gL);
        }), Codec.BOOL.fieldOf("occlude").forGetter(c0903qO6 -> {
            return Boolean.valueOf(c0903qO6.f5038gK);
        }), Codec.FLOAT.optionalFieldOf("inscattering", Float.valueOf(0.0f)).forGetter(c0903qO7 -> {
            return Float.valueOf(c0903qO7.f5039lT);
        }), Codec.FLOAT.optionalFieldOf("rotation_x", Float.valueOf(0.0f)).forGetter(c0903qO8 -> {
            return Float.valueOf(c0903qO8.f5040lU);
        }), Codec.FLOAT.optionalFieldOf("rotation_y", Float.valueOf(0.0f)).forGetter(c0903qO9 -> {
            return Float.valueOf(c0903qO9.f5041lV);
        }), Codec.FLOAT.optionalFieldOf("rotation_z", Float.valueOf(0.0f)).forGetter(c0903qO10 -> {
            return Float.valueOf(c0903qO10.f5042lW);
        }), StringRepresentable.fromEnum(EnumC0857pV::values).optionalFieldOf("application", EnumC0857pV.DEFAULT).forGetter(c0903qO11 -> {
            return c0903qO11.f5043a;
        })).apply(instance, (num, f, f2, f3, f4, bool, f5, f6, f7, f8, enumC0857pV) -> {
            C0903qO c0903qO12 = new C0903qO(num.intValue(), Vec3.ZERO);
            c0903qO12.f5034lP = f.floatValue();
            c0903qO12.f5035mp = f2.floatValue();
            c0903qO12.f5036lS = f3.floatValue();
            c0903qO12.f5037gL = f4.floatValue();
            c0903qO12.f5038gK = bool.booleanValue();
            c0903qO12.f5039lT = f5.floatValue();
            c0903qO12.f5040lU = f6.floatValue();
            c0903qO12.f5041lV = f7.floatValue();
            c0903qO12.f5042lW = f8.floatValue();
            c0903qO12.f5043a = enumC0857pV;
            return c0903qO12;
        });
    });

    /* JADX INFO: renamed from: aM */
    private int f5033aM;

    /* JADX INFO: renamed from: lP */
    private float f5034lP;

    /* JADX INFO: renamed from: mp */
    private float f5035mp;

    /* JADX INFO: renamed from: lS */
    private float f5036lS;

    /* JADX INFO: renamed from: gL */
    private float f5037gL;

    /* JADX INFO: renamed from: gK */
    private boolean f5038gK;

    /* JADX INFO: renamed from: lT */
    private float f5039lT;

    /* JADX INFO: renamed from: lU */
    private float f5040lU;

    /* JADX INFO: renamed from: lV */
    private float f5041lV;

    /* JADX INFO: renamed from: lW */
    private float f5042lW;

    /* JADX INFO: renamed from: a */
    private EnumC0857pV f5043a;

    /* JADX INFO: renamed from: mq */
    private final float f5044mq;

    /* JADX INFO: renamed from: f */
    @Nullable
    private LightRenderHandle<SpotLightData> f5045f;

    public C0903qO() {
        this(ColorReferences.COLOR_WHITE, Vec3.ZERO);
    }

    public C0903qO(int i, @NotNull Vec3 vec3) {
        super(vec3);
        this.f5034lP = 1.5f;
        this.f5035mp = 45.0f;
        this.f5036lS = 45.0f;
        this.f5037gL = 5.0f;
        this.f5038gK = false;
        this.f5039lT = 0.0f;
        this.f5040lU = 0.0f;
        this.f5041lV = 0.0f;
        this.f5042lW = 0.0f;
        this.f5043a = EnumC0857pV.DEFAULT;
        this.f5044mq = ThreadLocalRandom.current().nextFloat() * 1000.0f;
        this.f5033aM = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3935a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f5045f != null) {
            return;
        }
        SpotLightData inscatteringStrength = new SpotLightData().setColor(this.f5033aM).setBrightness(this.f5034lP).setSize((float) Math.toRadians(this.f5035mp)).setAngle((float) Math.toRadians(this.f5036lS)).setDistance(this.f5037gL).setOcclusionEnabled(this.f5038gK).setInscatteringStrength(this.f5039lT);
        inscatteringStrength.getPositionMutable().set(this.f4593c.x, this.f4593c.y, this.f4593c.z);
        inscatteringStrength.getOrientationMutable().identity().rotationXYZ((float) Math.toRadians(this.f5040lU), (float) Math.toRadians(this.f5041lV), (float) Math.toRadians(this.f5042lW));
        this.f5045f = VeilRenderSystem.renderer().getLightRenderer().addLight(inscatteringStrength);
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3936b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f5045f != null) {
            this.f5045f.free();
            this.f5045f = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3937b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f5045f == null) {
            return;
        }
        SpotLightData spotLightData = (SpotLightData) this.f5045f.getLightData();
        spotLightData.getPositionMutable().set(this.f4593c.x, this.f4593c.y, this.f4593c.z);
        spotLightData.getOrientationMutable().identity().rotationXYZ((float) Math.toRadians(this.f5040lU), (float) Math.toRadians(this.f5041lV), (float) Math.toRadians(this.f5042lW));
        float fApplyTo = this.f5043a.applyTo(this.f5034lP, f, this.f5044mq);
        spotLightData.setBrightness(fApplyTo);
        spotLightData.setInscatteringStrength(this.f5034lP > 0.0f ? this.f5039lT * (fApplyTo / this.f5034lP) : this.f5039lT);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0926ql(Component.literal("Color"), () -> {
            return Integer.valueOf(this.f5033aM);
        }, num -> {
            this.f5033aM = num.intValue();
        }));
        objectArrayList.add(new C0929qo(Component.literal("Brightness"), () -> {
            return Float.valueOf(this.f5034lP);
        }, f -> {
            this.f5034lP = f.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0929qo(Component.literal("Size (deg)"), () -> {
            return Float.valueOf(this.f5035mp);
        }, f2 -> {
            this.f5035mp = f2.floatValue();
        }, 0.1f, 90.0f));
        objectArrayList.add(new C0929qo(Component.literal("Angle (deg)"), () -> {
            return Float.valueOf(this.f5036lS);
        }, f3 -> {
            this.f5036lS = f3.floatValue();
        }, 0.1f, 180.0f));
        objectArrayList.add(new C0929qo(Component.literal("Distance"), () -> {
            return Float.valueOf(this.f5037gL);
        }, f4 -> {
            this.f5037gL = f4.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0925qk(Component.literal("Occlude"), () -> {
            return Boolean.valueOf(this.f5038gK);
        }, bool -> {
            this.f5038gK = bool.booleanValue();
        }));
        objectArrayList.add(new C0929qo(Component.literal("In-scattering"), () -> {
            return Float.valueOf(this.f5039lT);
        }, f5 -> {
            this.f5039lT = f5.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0929qo(Component.literal("Rotation X (deg)"), () -> {
            return Float.valueOf(this.f5040lU);
        }, f6 -> {
            this.f5040lU = f6.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0929qo(Component.literal("Rotation Y (deg)"), () -> {
            return Float.valueOf(this.f5041lV);
        }, f7 -> {
            this.f5041lV = f7.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0929qo(Component.literal("Rotation Z (deg)"), () -> {
            return Float.valueOf(this.f5042lW);
        }, f8 -> {
            this.f5042lW = f8.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0928qn(Component.literal("Application"), EnumC0857pV.class, () -> {
            return this.f5043a;
        }, enumC0857pV -> {
            this.f5043a = enumC0857pV;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5031et;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aU */
    public float mo4682aU() {
        return this.f5040lU;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aV */
    public float mo4683aV() {
        return this.f5041lV;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aW */
    public float mo4684aW() {
        return this.f5042lW;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: a */
    public void mo4685a(float f, float f2, float f3) {
        this.f5040lU = f;
        this.f5041lV = f2;
        this.f5042lW = f3;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: g */
    public void mo4686g(@NotNull Vec3 vec3) {
        Vector3f eulerAnglesXYZ = new Quaternionf().lookAlong((float) (-vec3.x), (float) (-vec3.y), (float) (-vec3.z), 0.0f, 1.0f, 0.0f).getEulerAnglesXYZ(new Vector3f());
        this.f5040lU = (float) Math.toDegrees(eulerAnglesXYZ.x);
        this.f5041lV = (float) Math.toDegrees(eulerAnglesXYZ.y);
        this.f5042lW = (float) Math.toDegrees(eulerAnglesXYZ.z);
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    @NotNull
    /* JADX INFO: renamed from: n */
    public Vec3 mo4687n() {
        Vector3f vector3fTransformInverse = new Quaternionf().rotationXYZ((float) Math.toRadians(this.f5040lU), (float) Math.toRadians(this.f5041lV), (float) Math.toRadians(this.f5042lW)).transformInverse(new Vector3f(0.0f, 0.0f, 1.0f));
        return new Vec3(vector3fTransformInverse.x, vector3fTransformInverse.y, vector3fTransformInverse.z);
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
        if (this.f5045f != null) {
            this.f5045f.free();
            this.f5045f = null;
        }
    }
}
