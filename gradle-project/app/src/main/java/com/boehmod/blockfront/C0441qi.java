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

/* JADX INFO: renamed from: com.boehmod.blockfront.qi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qi.class */
public class C0441qi extends AbstractC0429px implements pJ {

    @NotNull
    private static final ResourceLocation ei = C0265jv.d("textures/misc/debug/mapeffect/light.png");

    @NotNull
    public static final MapCodec<C0441qi> u = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(pB.G.fieldOf("color").forGetter(c0441qi -> {
            return Integer.valueOf(c0441qi.Y);
        }), Codec.FLOAT.fieldOf("brightness").forGetter(c0441qi2 -> {
            return Float.valueOf(c0441qi2.kU);
        }), Codec.FLOAT.fieldOf("size_x").forGetter(c0441qi3 -> {
            return Float.valueOf(c0441qi3.kV);
        }), Codec.FLOAT.fieldOf("size_y").forGetter(c0441qi4 -> {
            return Float.valueOf(c0441qi4.kW);
        }), Codec.FLOAT.fieldOf("angle").forGetter(c0441qi5 -> {
            return Float.valueOf(c0441qi5.kX);
        }), Codec.FLOAT.fieldOf("distance").forGetter(c0441qi6 -> {
            return Float.valueOf(c0441qi6.gq);
        }), Codec.BOOL.fieldOf("occlude").forGetter(c0441qi7 -> {
            return Boolean.valueOf(c0441qi7.f294gq);
        }), Codec.FLOAT.optionalFieldOf("rotation_x", Float.valueOf(0.0f)).forGetter(c0441qi8 -> {
            return Float.valueOf(c0441qi8.kY);
        }), Codec.FLOAT.optionalFieldOf("rotation_y", Float.valueOf(0.0f)).forGetter(c0441qi9 -> {
            return Float.valueOf(c0441qi9.kZ);
        }), Codec.FLOAT.optionalFieldOf("rotation_z", Float.valueOf(0.0f)).forGetter(c0441qi10 -> {
            return Float.valueOf(c0441qi10.la);
        }), StringRepresentable.fromEnum(EnumC0431pz::values).optionalFieldOf("application", EnumC0431pz.DEFAULT).forGetter(c0441qi11 -> {
            return c0441qi11.a;
        })).apply(instance, (num, f, f2, f3, f4, f5, bool, f6, f7, f8, enumC0431pz) -> {
            C0441qi c0441qi12 = new C0441qi(num.intValue(), Vec3.ZERO);
            c0441qi12.kU = f.floatValue();
            c0441qi12.kV = f2.floatValue();
            c0441qi12.kW = f3.floatValue();
            c0441qi12.kX = f4.floatValue();
            c0441qi12.gq = f5.floatValue();
            c0441qi12.f294gq = bool.booleanValue();
            c0441qi12.kY = f6.floatValue();
            c0441qi12.kZ = f7.floatValue();
            c0441qi12.la = f8.floatValue();
            c0441qi12.a = enumC0431pz;
            return c0441qi12;
        });
    });
    private int Y;
    private float kU;
    private float kV;
    private float kW;
    private float kX;
    private float gq;

    /* JADX INFO: renamed from: gq, reason: collision with other field name */
    private boolean f294gq;
    private float kY;
    private float kZ;
    private float la;
    private EnumC0431pz a;
    private final float lb;

    @Nullable
    private LightRenderHandle<AreaLightData> f;

    public C0441qi() {
        this(ColorReferences.COLOR_WHITE, Vec3.ZERO);
    }

    public C0441qi(int i, @NotNull Vec3 vec3) {
        super(vec3);
        this.kU = 1.5f;
        this.kV = 1.0f;
        this.kW = 1.0f;
        this.kX = 45.0f;
        this.gq = 5.0f;
        this.f294gq = false;
        this.kY = 0.0f;
        this.kZ = 0.0f;
        this.la = 0.0f;
        this.a = EnumC0431pz.DEFAULT;
        this.lb = ThreadLocalRandom.current().nextFloat() * 1000.0f;
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
        AreaLightData occlusionEnabled = new AreaLightData().setColor(this.Y).setBrightness(this.kU).setSize(this.kV, this.kW).setAngle((float) Math.toRadians(this.kX)).setDistance(this.gq).setOcclusionEnabled(this.f294gq);
        occlusionEnabled.getPosition().set(this.c.x, this.c.y, this.c.z);
        occlusionEnabled.getOrientation().identity().rotationXYZ((float) Math.toRadians(this.kY), (float) Math.toRadians(this.kZ), (float) Math.toRadians(this.la));
        this.f = VeilRenderSystem.renderer().getLightRenderer().addLight(occlusionEnabled);
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
        AreaLightData areaLightData = (AreaLightData) this.f.getLightData();
        areaLightData.getPosition().set(this.c.x, this.c.y, this.c.z);
        areaLightData.getOrientation().identity().rotationXYZ((float) Math.toRadians(this.kY), (float) Math.toRadians(this.kZ), (float) Math.toRadians(this.la));
        areaLightData.setBrightness(this.a.applyTo(this.kU, f, this.lb));
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
        objectArrayList.add(new pS(Component.literal("Size X"), () -> {
            return Float.valueOf(this.kV);
        }, f2 -> {
            this.kV = f2.floatValue();
        }, 0.1f, 32.0f));
        objectArrayList.add(new pS(Component.literal("Size Y"), () -> {
            return Float.valueOf(this.kW);
        }, f3 -> {
            this.kW = f3.floatValue();
        }, 0.1f, 32.0f));
        objectArrayList.add(new pS(Component.literal("Angle (deg)"), () -> {
            return Float.valueOf(this.kX);
        }, f4 -> {
            this.kX = f4.floatValue();
        }, 0.1f, 180.0f));
        objectArrayList.add(new pS(Component.literal("Distance"), () -> {
            return Float.valueOf(this.gq);
        }, f5 -> {
            this.gq = f5.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new pO(Component.literal("Occlude"), () -> {
            return Boolean.valueOf(this.f294gq);
        }, bool -> {
            this.f294gq = bool.booleanValue();
        }));
        objectArrayList.add(new pS(Component.literal("Rotation X (deg)"), () -> {
            return Float.valueOf(this.kY);
        }, f6 -> {
            this.kY = f6.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new pS(Component.literal("Rotation Y (deg)"), () -> {
            return Float.valueOf(this.kZ);
        }, f7 -> {
            this.kZ = f7.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new pS(Component.literal("Rotation Z (deg)"), () -> {
            return Float.valueOf(this.la);
        }, f8 -> {
            this.la = f8.floatValue();
        }, -180.0f, 180.0f));
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
        return ei;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aO() {
        return this.kY;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aP() {
        return this.kZ;
    }

    @Override // com.boehmod.blockfront.pJ
    public float aQ() {
        return this.la;
    }

    @Override // com.boehmod.blockfront.pJ
    public void a(float f, float f2, float f3) {
        this.kY = f;
        this.kZ = f2;
        this.la = f3;
    }

    @Override // com.boehmod.blockfront.pJ
    public void g(@NotNull Vec3 vec3) {
        Vector3f eulerAnglesXYZ = new Quaternionf().lookAlong((float) (-vec3.x), (float) (-vec3.y), (float) (-vec3.z), 0.0f, 1.0f, 0.0f).getEulerAnglesXYZ(new Vector3f());
        this.kY = (float) Math.toDegrees(eulerAnglesXYZ.x);
        this.kZ = (float) Math.toDegrees(eulerAnglesXYZ.y);
        this.la = (float) Math.toDegrees(eulerAnglesXYZ.z);
    }

    @Override // com.boehmod.blockfront.pJ
    @NotNull
    public Vec3 m() {
        Vector3f vector3fTransformInverse = new Quaternionf().rotationXYZ((float) Math.toRadians(this.kY), (float) Math.toRadians(this.kZ), (float) Math.toRadians(this.la)).transformInverse(new Vector3f(0.0f, 0.0f, 1.0f));
        return new Vec3(vector3fTransformInverse.x, vector3fTransformInverse.y, vector3fTransformInverse.z);
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
