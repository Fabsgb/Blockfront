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

/* JADX INFO: renamed from: com.boehmod.blockfront.qE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qE.class */
public class C0893qE extends AbstractC0855pT implements InterfaceC0920qf {

    /* JADX INFO: renamed from: eg */
    @NotNull
    private static final ResourceLocation f4910eg = C0532jO.m2378d("textures/misc/debug/mapeffect/light.png");

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final MapCodec<C0893qE> f4911u = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0859pX.f4603G.fieldOf("color").forGetter(c0893qE -> {
            return Integer.valueOf(c0893qE.f4912aM);
        }), Codec.FLOAT.fieldOf("brightness").forGetter(c0893qE2 -> {
            return Float.valueOf(c0893qE2.f4913lP);
        }), Codec.FLOAT.fieldOf("size_x").forGetter(c0893qE3 -> {
            return Float.valueOf(c0893qE3.f4914lQ);
        }), Codec.FLOAT.fieldOf("size_y").forGetter(c0893qE4 -> {
            return Float.valueOf(c0893qE4.f4915lR);
        }), Codec.FLOAT.fieldOf("angle").forGetter(c0893qE5 -> {
            return Float.valueOf(c0893qE5.f4916lS);
        }), Codec.FLOAT.fieldOf("distance").forGetter(c0893qE6 -> {
            return Float.valueOf(c0893qE6.f4917gL);
        }), Codec.BOOL.fieldOf("occlude").forGetter(c0893qE7 -> {
            return Boolean.valueOf(c0893qE7.f4918gK);
        }), Codec.FLOAT.optionalFieldOf("inscattering", Float.valueOf(0.0f)).forGetter(c0893qE8 -> {
            return Float.valueOf(c0893qE8.f4919lT);
        }), Codec.FLOAT.optionalFieldOf("rotation_x", Float.valueOf(0.0f)).forGetter(c0893qE9 -> {
            return Float.valueOf(c0893qE9.f4920lU);
        }), Codec.FLOAT.optionalFieldOf("rotation_y", Float.valueOf(0.0f)).forGetter(c0893qE10 -> {
            return Float.valueOf(c0893qE10.f4921lV);
        }), Codec.FLOAT.optionalFieldOf("rotation_z", Float.valueOf(0.0f)).forGetter(c0893qE11 -> {
            return Float.valueOf(c0893qE11.f4922lW);
        }), StringRepresentable.fromEnum(EnumC0857pV::values).optionalFieldOf("application", EnumC0857pV.DEFAULT).forGetter(c0893qE12 -> {
            return c0893qE12.f4923a;
        })).apply(instance, (num, f, f2, f3, f4, f5, bool, f6, f7, f8, f9, enumC0857pV) -> {
            C0893qE c0893qE13 = new C0893qE(num.intValue(), Vec3.ZERO);
            c0893qE13.f4913lP = f.floatValue();
            c0893qE13.f4914lQ = f2.floatValue();
            c0893qE13.f4915lR = f3.floatValue();
            c0893qE13.f4916lS = f4.floatValue();
            c0893qE13.f4917gL = f5.floatValue();
            c0893qE13.f4918gK = bool.booleanValue();
            c0893qE13.f4919lT = f6.floatValue();
            c0893qE13.f4920lU = f7.floatValue();
            c0893qE13.f4921lV = f8.floatValue();
            c0893qE13.f4922lW = f9.floatValue();
            c0893qE13.f4923a = enumC0857pV;
            return c0893qE13;
        });
    });

    /* JADX INFO: renamed from: aM */
    private int f4912aM;

    /* JADX INFO: renamed from: lP */
    private float f4913lP;

    /* JADX INFO: renamed from: lQ */
    private float f4914lQ;

    /* JADX INFO: renamed from: lR */
    private float f4915lR;

    /* JADX INFO: renamed from: lS */
    private float f4916lS;

    /* JADX INFO: renamed from: gL */
    private float f4917gL;

    /* JADX INFO: renamed from: gK */
    private boolean f4918gK;

    /* JADX INFO: renamed from: lT */
    private float f4919lT;

    /* JADX INFO: renamed from: lU */
    private float f4920lU;

    /* JADX INFO: renamed from: lV */
    private float f4921lV;

    /* JADX INFO: renamed from: lW */
    private float f4922lW;

    /* JADX INFO: renamed from: a */
    private EnumC0857pV f4923a;

    /* JADX INFO: renamed from: lX */
    private final float f4924lX;

    /* JADX INFO: renamed from: f */
    @Nullable
    private LightRenderHandle<AreaLightData> f4925f;

    public C0893qE() {
        this(ColorReferences.COLOR_WHITE, Vec3.ZERO);
    }

    public C0893qE(int i, @NotNull Vec3 vec3) {
        super(vec3);
        this.f4913lP = 1.5f;
        this.f4914lQ = 1.0f;
        this.f4915lR = 1.0f;
        this.f4916lS = 45.0f;
        this.f4917gL = 5.0f;
        this.f4918gK = false;
        this.f4919lT = 0.0f;
        this.f4920lU = 0.0f;
        this.f4921lV = 0.0f;
        this.f4922lW = 0.0f;
        this.f4923a = EnumC0857pV.DEFAULT;
        this.f4924lX = ThreadLocalRandom.current().nextFloat() * 1000.0f;
        this.f4912aM = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3935a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4925f != null) {
            return;
        }
        AreaLightData inscatteringStrength = new AreaLightData().setColor(this.f4912aM).setBrightness(this.f4913lP).setSize(this.f4914lQ, this.f4915lR).setAngle((float) Math.toRadians(this.f4916lS)).setDistance(this.f4917gL).setOcclusionEnabled(this.f4918gK).setInscatteringStrength(this.f4919lT);
        inscatteringStrength.getPosition().set(this.f4593c.x, this.f4593c.y, this.f4593c.z);
        inscatteringStrength.getOrientation().identity().rotationXYZ((float) Math.toRadians(this.f4920lU), (float) Math.toRadians(this.f4921lV), (float) Math.toRadians(this.f4922lW));
        this.f4925f = VeilRenderSystem.renderer().getLightRenderer().addLight(inscatteringStrength);
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3936b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (this.f4925f != null) {
            this.f4925f.free();
            this.f4925f = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0855pT
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3937b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4925f == null) {
            return;
        }
        AreaLightData areaLightData = (AreaLightData) this.f4925f.getLightData();
        areaLightData.getPosition().set(this.f4593c.x, this.f4593c.y, this.f4593c.z);
        areaLightData.getOrientation().identity().rotationXYZ((float) Math.toRadians(this.f4920lU), (float) Math.toRadians(this.f4921lV), (float) Math.toRadians(this.f4922lW));
        float fApplyTo = this.f4923a.applyTo(this.f4913lP, f, this.f4924lX);
        areaLightData.setBrightness(fApplyTo);
        areaLightData.setInscatteringStrength(this.f4913lP > 0.0f ? this.f4919lT * (fApplyTo / this.f4913lP) : this.f4919lT);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0926ql(Component.literal("Color"), () -> {
            return Integer.valueOf(this.f4912aM);
        }, num -> {
            this.f4912aM = num.intValue();
        }));
        objectArrayList.add(new C0929qo(Component.literal("Brightness"), () -> {
            return Float.valueOf(this.f4913lP);
        }, f -> {
            this.f4913lP = f.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0929qo(Component.literal("Size X"), () -> {
            return Float.valueOf(this.f4914lQ);
        }, f2 -> {
            this.f4914lQ = f2.floatValue();
        }, 0.1f, 32.0f));
        objectArrayList.add(new C0929qo(Component.literal("Size Y"), () -> {
            return Float.valueOf(this.f4915lR);
        }, f3 -> {
            this.f4915lR = f3.floatValue();
        }, 0.1f, 32.0f));
        objectArrayList.add(new C0929qo(Component.literal("Angle (deg)"), () -> {
            return Float.valueOf(this.f4916lS);
        }, f4 -> {
            this.f4916lS = f4.floatValue();
        }, 0.1f, 180.0f));
        objectArrayList.add(new C0929qo(Component.literal("Distance"), () -> {
            return Float.valueOf(this.f4917gL);
        }, f5 -> {
            this.f4917gL = f5.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0925qk(Component.literal("Occlude"), () -> {
            return Boolean.valueOf(this.f4918gK);
        }, bool -> {
            this.f4918gK = bool.booleanValue();
        }));
        objectArrayList.add(new C0929qo(Component.literal("In-scattering"), () -> {
            return Float.valueOf(this.f4919lT);
        }, f6 -> {
            this.f4919lT = f6.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0929qo(Component.literal("Rotation X (deg)"), () -> {
            return Float.valueOf(this.f4920lU);
        }, f7 -> {
            this.f4920lU = f7.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0929qo(Component.literal("Rotation Y (deg)"), () -> {
            return Float.valueOf(this.f4921lV);
        }, f8 -> {
            this.f4921lV = f8.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0929qo(Component.literal("Rotation Z (deg)"), () -> {
            return Float.valueOf(this.f4922lW);
        }, f9 -> {
            this.f4922lW = f9.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0928qn(Component.literal("Application"), EnumC0857pV.class, () -> {
            return this.f4923a;
        }, enumC0857pV -> {
            this.f4923a = enumC0857pV;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4910eg;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aU */
    public float mo4682aU() {
        return this.f4920lU;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aV */
    public float mo4683aV() {
        return this.f4921lV;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aW */
    public float mo4684aW() {
        return this.f4922lW;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: a */
    public void mo4685a(float f, float f2, float f3) {
        this.f4920lU = f;
        this.f4921lV = f2;
        this.f4922lW = f3;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: g */
    public void mo4686g(@NotNull Vec3 vec3) {
        Vector3f eulerAnglesXYZ = new Quaternionf().lookAlong((float) (-vec3.x), (float) (-vec3.y), (float) (-vec3.z), 0.0f, 1.0f, 0.0f).getEulerAnglesXYZ(new Vector3f());
        this.f4920lU = (float) Math.toDegrees(eulerAnglesXYZ.x);
        this.f4921lV = (float) Math.toDegrees(eulerAnglesXYZ.y);
        this.f4922lW = (float) Math.toDegrees(eulerAnglesXYZ.z);
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    @NotNull
    /* JADX INFO: renamed from: n */
    public Vec3 mo4687n() {
        Vector3f vector3fTransformInverse = new Quaternionf().rotationXYZ((float) Math.toRadians(this.f4920lU), (float) Math.toRadians(this.f4921lV), (float) Math.toRadians(this.f4922lW)).transformInverse(new Vector3f(0.0f, 0.0f, 1.0f));
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
        if (this.f4925f != null) {
            this.f4925f.free();
            this.f4925f = null;
        }
    }
}
