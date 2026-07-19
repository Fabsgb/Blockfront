package com.boehmod.blockfront;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pB.class */
public final class pB {

    @NotNull
    public static final Codec<Vec3> C = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(vec3 -> {
            return Double.valueOf(vec3.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(vec32 -> {
            return Double.valueOf(vec32.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(vec33 -> {
            return Double.valueOf(vec33.z);
        })).apply(instance, (v1, v2, v3) -> {
            return new Vec3(v1, v2, v3);
        });
    });

    @NotNull
    public static final Codec<Vec2> D = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("x").forGetter(vec2 -> {
            return Float.valueOf(vec2.x);
        }), Codec.FLOAT.fieldOf("y").forGetter(vec22 -> {
            return Float.valueOf(vec22.y);
        })).apply(instance, (v1, v2) -> {
            return new Vec2(v1, v2);
        });
    });

    @NotNull
    public static final Codec<AABB> E = RecordCodecBuilder.create(instance -> {
        return instance.group(C.fieldOf("min").forGetter(aabb -> {
            return new Vec3(aabb.minX, aabb.minY, aabb.minZ);
        }), C.fieldOf("max").forGetter(aabb2 -> {
            return new Vec3(aabb2.maxX, aabb2.maxY, aabb2.maxZ);
        })).apply(instance, AABB::new);
    });

    @NotNull
    public static final Codec<Supplier<SoundEvent>> F = Codec.STRING.flatXmap(str -> {
        Supplier<SoundEvent> supplierD = C0636xo.d(str);
        if (supplierD != null) {
            return DataResult.success(supplierD);
        }
        return DataResult.error(() -> {
            return "Unknown sound event key: " + str;
        });
    }, supplier -> {
        SoundEvent soundEvent = (SoundEvent) supplier.get();
        if (soundEvent == null) {
            return DataResult.error(() -> {
                return "Sound supplier resolved to null";
            });
        }
        String strF = C0636xo.f(soundEvent);
        if (strF != null) {
            return DataResult.success(strF);
        }
        return DataResult.error(() -> {
            return "Sound event is not registered: " + String.valueOf(soundEvent);
        });
    });

    @NotNull
    public static final Codec<Integer> G = Codec.either(Codec.INT, Codec.STRING).xmap(either -> {
        return (Integer) either.map(num -> {
            return num;
        }, pB::c);
    }, (v0) -> {
        return Either.left(v0);
    });

    @NotNull
    private static final Map<String, MapCodec<? extends pA>> M = new Object2ObjectOpenHashMap();

    @NotNull
    public static final Codec<pA> H;

    @NotNull
    public static final StreamCodec<ByteBuf, pA> d;

    private pB() {
    }

    static {
        M.put("fly_by", a(C0434qb.n));
        M.put("fly_by_entities", a(C0435qc.o));
        M.put("mist", a(C0438qf.r));
        M.put("pathed_vehicle_entities", a(C0440qh.t));
        M.put("positioned_bombing_flash", a(C0443qk.w));
        M.put("positioned_bullet_tracer", a(C0444ql.x));
        M.put("positioned_timed_sound", a(C0451qs.E));
        M.put("positioned_particle", a(C0448qp.B));
        M.put("positioned_rocket_barrage", a(C0449qq.C));
        M.put("positioned_rocket", a(C0450qr.D));
        M.put("sky_planes", a(C0455qw.I));
        M.put("surrender_paper", a(C0457qy.K));
        M.put("watchlight", a(qC.O));
        M.put("positioned_artillery_gun", a(C0442qj.v));
        M.put("falling_artillery", a(C0433qa.m));
        M.put("random_explosion", a(C0453qu.G));
        M.put("lightning", a(C0436qd.p));
        M.put("positioned_looping_sound", a(C0447qo.A));
        M.put("positioned_entity", a(C0445qm.y));
        M.put("water_color", a(qD.P));
        M.put("shader", a(C0454qv.H));
        M.put("time", a(qA.M));
        M.put("sky_settings", a(C0456qx.J));
        M.put("weather", a(qE.Q));
        M.put("map_name", a(C0437qe.q));
        M.put("author", a(pZ.l));
        M.put("teams", a(C0458qz.L));
        M.put("music_set", a(C0439qg.s));
        M.put("positioned_light_source", a(C0446qn.z));
        M.put("positioned_area_light_source", a(C0441qi.u));
        M.put("positioned_vehicle", a(C0452qt.F));
        M.put("trigger_condition", a(qB.N));
        H = Codec.STRING.dispatch("effectType", pAVar -> {
            return pC.a(pAVar.getClass());
        }, str -> {
            MapCodec<? extends pA> mapCodec = M.get(str);
            if (mapCodec == null) {
                throw new IllegalArgumentException("No codec registered for map effect type: " + str);
            }
            return mapCodec;
        });
        d = ByteBufCodecs.fromCodecTrusted(H);
    }

    private static int c(@NotNull String str) {
        return (int) Long.parseLong(str.startsWith("#") ? str.substring(1) : str, 16);
    }

    @NotNull
    private static <T extends pA> MapCodec<T> a(@NotNull MapCodec<T> mapCodec) {
        return RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(UUIDUtil.STRING_CODEC.optionalFieldOf("uuid").forGetter(pAVar -> {
                return Optional.of(pAVar.y);
            }), Codec.STRING.optionalFieldOf("effectId").forGetter(pAVar2 -> {
                return Optional.ofNullable(pAVar2.bW);
            }), Codec.BOOL.optionalFieldOf("defaultEnabled", true).forGetter(pAVar3 -> {
                return Boolean.valueOf(pAVar3.gk);
            }), C.optionalFieldOf("position", Vec3.ZERO).forGetter(pAVar4 -> {
                return pAVar4.c;
            }), mapCodec.forGetter(pAVar5 -> {
                return pAVar5;
            })).apply(instance, (optional, optional2, bool, vec3, pAVar6) -> {
                pAVar6.y = (UUID) optional.orElseGet(UUID::randomUUID);
                pAVar6.bW = (String) optional2.orElse(null);
                pAVar6.gk = bool.booleanValue();
                pAVar6.gl = bool.booleanValue();
                pAVar6.c = vec3;
                return pAVar6;
            });
        });
    }
}
