package com.boehmod.blockfront;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.xJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xJ.class */
public class C1270xJ {

    /* JADX INFO: renamed from: pz */
    public static final float f6830pz = 3.1415927f;

    /* JADX INFO: renamed from: pA */
    public static final float f6831pA = 0.017453292f;

    /* JADX INFO: renamed from: pB */
    public static final float f6832pB = 1.5707964f;

    /* JADX INFO: renamed from: pC */
    private static final float f6833pC = 100.0f;

    /* JADX INFO: renamed from: aM */
    private static final Vec3 f6834aM = new Vec3(0.0d, 1.0d, 0.0d);

    /* JADX INFO: renamed from: aN */
    private static final Vec3 f6835aN = new Vec3(0.0d, 0.0d, 1.0d);

    /* JADX INFO: renamed from: a */
    public static int m7159a(int i, float f) {
        return FastColor.ARGB32.color(FastColor.as8BitChannel(f), i);
    }

    /* JADX INFO: renamed from: b */
    public static int m7160b(int i, int i2, int i3) {
        if (i == i2) {
            return i;
        }
        int iSignum = Integer.signum(i2 - i);
        int i4 = i + (iSignum * i3);
        return iSignum > 0 ? Math.min(i4, i2) : Math.max(i4, i2);
    }

    /* JADX INFO: renamed from: d */
    public static float m7161d(float f, float f2, float f3) {
        if (f == f2) {
            return f;
        }
        float fSignum = Math.signum(f2 - f);
        float f4 = f + (fSignum * f3);
        return fSignum > 0.0f ? Math.min(f4, f2) : Math.max(f4, f2);
    }

    /* JADX INFO: renamed from: a */
    public static float m7162a(float f, int i) {
        double d;
        if (f <= 0.0f || i <= 0) {
            return 1.0f;
        }
        double d2 = f / i;
        double dPow = Math.pow(10.0d, Math.floor(Math.log10(d2)));
        double d3 = d2 / dPow;
        if (d3 <= 1.0d) {
            d = 1.0d;
        } else if (d3 <= 2.0d) {
            d = 2.0d;
        } else {
            d = d3 <= 5.0d ? 5.0d : 10.0d;
        }
        return (float) (d * dPow);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec3 m7163a(@NotNull Vec3 vec3, @NotNull Vec3 vec4, float f) {
        return vec3.distanceTo(vec4) <= ((double) f) ? vec4 : vec3.add(vec4.subtract(vec3).normalize().multiply(f, f, f));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec3 m7164a(@NotNull List<Vec3> list) {
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (Vec3 vec3 : list) {
            d += vec3.x;
            d2 += vec3.y;
            d3 += vec3.z;
        }
        int size = list.size();
        return new Vec3(d / ((double) size), d2 / ((double) size), d3 / ((double) size));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector3f m7165a(@NotNull Vector3f... vector3fArr) {
        int length = vector3fArr.length;
        if (length == 0) {
            throw new IllegalArgumentException("No positions provided");
        }
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (Vector3f vector3f : vector3fArr) {
            f += vector3f.x;
            f2 += vector3f.y;
            f3 += vector3f.z;
        }
        return new Vector3f(f / length, f2 / length, f3 / length);
    }

    /* JADX INFO: renamed from: a */
    public static Vector3f m7166a(@NotNull Vector3f vector3f, float f, float f2) {
        return new Vector3f(Math.min(f2, Math.max(f, vector3f.x)), Math.min(f2, Math.max(f, vector3f.y)), Math.min(f2, Math.max(f, vector3f.z)));
    }

    /* JADX INFO: renamed from: a */
    public static Vector3d m7167a(@NotNull Vector3d vector3d, double d, double d2) {
        return new Vector3d(Math.min(d2, Math.max(d, vector3d.x)), Math.min(d2, Math.max(d, vector3d.y)), Math.min(d2, Math.max(d, vector3d.z)));
    }

    /* JADX INFO: renamed from: e */
    public static float m7168e(float f, float f2, float f3) {
        return Float.isFinite(f) ? Mth.clamp(f, f2, f3) : f2;
    }

    /* JADX INFO: renamed from: a */
    public static double m7169a(double d, double d2, float f) {
        return d2 + ((d - d2) * ((double) f));
    }

    /* JADX INFO: renamed from: f */
    public static float m7170f(float f, float f2, float f3) {
        return f2 + ((f - f2) * f3);
    }

    /* JADX INFO: renamed from: g */
    public static float m7171g(float f, float f2, float f3) {
        float f4 = f - f2;
        if (f4 > 180.0f) {
            f4 -= 360.0f;
        }
        if (f4 < -180.0f) {
            f4 += 360.0f;
        }
        return f2 + (f3 * f4);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Vec3 m7172b(@NotNull Vec3 vec3, @NotNull Vec3 vec4, float f) {
        return new Vec3(m7169a(vec3.x, vec4.x, f), m7169a(vec3.y, vec4.y, f), m7169a(vec3.z, vec4.z, f));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec2 m7173a(@NotNull Vec2 vec2, @NotNull Vec2 vec3, float f) {
        return new Vec2(m7170f(vec2.x, vec3.x, f), m7170f(vec2.y, vec3.y, f));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec3 m7174a(@NotNull C0881pt c0881pt, @NotNull C0881pt c0881pt2, float f) {
        return m7172b(c0881pt.f4827c, c0881pt2.f4827c, f);
    }

    /* JADX INFO: renamed from: a */
    public static float m7175a(float f, float f2) {
        return (ThreadLocalRandom.current().nextFloat() * (f2 - f)) + f;
    }

    /* JADX INFO: renamed from: a */
    public static float m7176a(@NotNull RandomSource randomSource, float f) {
        return ((randomSource.nextFloat() * 2.0f) - 1.0f) * f;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec3 m7177a(@NotNull RandomSource randomSource, @NotNull Vec3 vec3, int i) {
        return new Vec3(vec3.x + (((double) i) * randomSource.nextGaussian()), vec3.y + 1.0d, vec3.z + (((double) i) * randomSource.nextGaussian()));
    }

    /* JADX INFO: renamed from: a */
    public static int m7178a(int i, int i2, float f) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return (((int) (i3 + ((((i2 >> 24) & 255) - i3) * f))) << 24) | (((int) (i4 + ((((i2 >> 16) & 255) - i4) * f))) << 16) | (((int) (i5 + ((((i2 >> 8) & 255) - i5) * f))) << 8) | ((int) (i6 + (((i2 & 255) - i6) * f)));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec3 m7179a(float f, float f2) {
        float f3 = f * 0.017453292f;
        float f4 = (-f2) * 0.017453292f;
        float fCos = Mth.cos(f4);
        float fSin = Mth.sin(f4);
        float fCos2 = Mth.cos(f3);
        return new Vec3(fSin * fCos2, -Mth.sin(f3), fCos * fCos2);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec3 m7180a(@NotNull Vec2 vec2, float f, float f2) {
        Vec3 vec3M7179a = m7179a(vec2.x, vec2.y);
        Vec3 vec3Normalize = vec3M7179a.cross(Math.abs(vec3M7179a.y) > 0.9995d ? f6835aN : f6834aM).normalize();
        Vec3 vec3Cross = vec3Normalize.cross(vec3M7179a);
        float f3 = f2 * 0.017453292f;
        float f4 = f * 0.017453292f;
        return vec3M7179a.add(vec3Normalize.scale(Mth.sin(f3) / Mth.cos(f3))).subtract(vec3Cross.scale(Mth.sin(f4) / Mth.cos(f4))).normalize();
    }

    /* JADX INFO: renamed from: b */
    public static float m7181b(@NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        Vec3 vec3Subtract = vec4.subtract(vec3);
        float degrees = (float) Math.toDegrees((float) Math.atan2(vec3Subtract.z, vec3Subtract.x));
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        return degrees;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Optional<Vec3> m7182a(@NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull AABB aabb) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7 = 1.0d / vec4.x;
        double d8 = 1.0d / vec4.y;
        double d9 = 1.0d / vec4.z;
        double d10 = (aabb.minX - vec3.x) * d7;
        double d11 = (aabb.maxX - vec3.x) * d7;
        if (d7 >= 0.0d) {
            d = d10;
            d2 = d11;
        } else {
            d = d11;
            d2 = d10;
        }
        double d12 = (aabb.minY - vec3.y) * d8;
        double d13 = (aabb.maxY - vec3.y) * d8;
        if (d8 >= 0.0d) {
            d3 = d12;
            d4 = d13;
        } else {
            d3 = d13;
            d4 = d12;
        }
        if (d > d4 || d3 > d2) {
            return Optional.empty();
        }
        if (d3 > d) {
            d = d3;
        }
        if (d4 < d2) {
            d2 = d4;
        }
        double d14 = (aabb.minZ - vec3.z) * d9;
        double d15 = (aabb.maxZ - vec3.z) * d9;
        if (d9 >= 0.0d) {
            d5 = d14;
            d6 = d15;
        } else {
            d5 = d15;
            d6 = d14;
        }
        if (d > d6 || d5 > d2) {
            return Optional.empty();
        }
        if (d5 > d) {
            d = d5;
        }
        if (d6 < d2) {
            d2 = d6;
        }
        if (d >= 0.0d || d2 >= 0.0d) {
            return Optional.of(vec3.add(vec4.scale(d >= 0.0d ? d : d2)));
        }
        return Optional.empty();
    }

    /* JADX INFO: renamed from: h */
    public static float m7183h(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    /* JADX INFO: renamed from: a */
    public static double m7184a(double d, double d2, double d3) {
        return d + ((d2 - d) * d3);
    }

    /* JADX INFO: renamed from: I */
    public static float m7185I(float f) {
        float f2 = f % 360.0f;
        if (f2 > 180.0f) {
            f2 -= 360.0f;
        } else if (f2 < -180.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    /* JADX INFO: renamed from: b */
    public static float m7186b(@NotNull Entity entity, @NotNull Entity entity2) {
        return m7187a(entity.getX(), entity.getZ(), entity2.getX(), entity2.getZ(), entity2.getYRot());
    }

    /* JADX INFO: renamed from: a */
    public static float m7187a(double d, double d2, double d3, double d4, float f) {
        float fAbs = Math.abs((((f % 360.0f) + 360.0f) % 360.0f) - (((((float) Math.toDegrees(Math.atan2(d2 - d4, d - d3))) + 90.0f) + 360.0f) % 360.0f));
        if (fAbs > 180.0f) {
            fAbs = 360.0f - fAbs;
        }
        return fAbs / 180.0f;
    }

    /* JADX INFO: renamed from: a */
    public static float m7188a(@NotNull Minecraft minecraft) {
        return minecraft.getTimer().getGameTimeDeltaPartialTick(true);
    }

    /* JADX INFO: renamed from: i */
    public static float m7189i(float f, float f2, float f3) {
        if (f3 <= f) {
            return 1.0f;
        }
        if (f3 >= f2) {
            return 0.0f;
        }
        return 1.0f - ((f3 - f) / (f2 - f));
    }

    /* JADX INFO: renamed from: j */
    public static float m7190j(float f, float f2, float f3) {
        if (f2 == f3) {
            return 1.0f;
        }
        return Mth.clamp((f - f3) / (f2 - f3), 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: d */
    public static int m7191d(float f) {
        return Math.round((f / f6833pC) * 20.0f);
    }

    /* JADX INFO: renamed from: b */
    public static float m7192b(float f, float f2) {
        return Math.round(f / f2) * f2;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m7193a(@NotNull BlockPos blockPos, @NotNull Vec3 vec3, double d) {
        double x = (((double) blockPos.getX()) + 0.5d) - vec3.x;
        double z = (((double) blockPos.getZ()) + 0.5d) - vec3.z;
        return (x * x) + (z * z) <= d * d;
    }

    /* JADX INFO: renamed from: a */
    public static float m7194a(@NotNull String str, @NotNull Font font, float f, int i, float f2) {
        if (font.width(str) * f <= i) {
            return f;
        }
        return Math.min(i / font.width(str), f2);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.xJ$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xJ$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: C */
        static final /* synthetic */ int[] f6836C = new int[Direction.values().length];

        static {
            try {
                f6836C[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6836C[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6836C[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6836C[Direction.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6836C[Direction.SOUTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6836C[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vec3 m7195a(@NotNull Direction direction, float f) throws MatchException {
        switch (AnonymousClass1.f6836C[direction.ordinal()]) {
            case 1:
                return new Vec3(0.0d, f, 0.0d);
            case 2:
                return new Vec3(0.0d, -f, 0.0d);
            case 3:
                return new Vec3(0.0d, 0.0d, -f);
            case 4:
                return new Vec3(f, 0.0d, 0.0d);
            case 5:
                return new Vec3(0.0d, 0.0d, f);
            case 6:
                return new Vec3(-f, 0.0d, 0.0d);
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
