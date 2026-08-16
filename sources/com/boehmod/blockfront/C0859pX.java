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

/* JADX INFO: renamed from: com.boehmod.blockfront.pX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pX.class */
public final class C0859pX {

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final Codec<Vec3> f4599C = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(vec3 -> {
            return Double.valueOf(vec3.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(vec4 -> {
            return Double.valueOf(vec4.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(vec5 -> {
            return Double.valueOf(vec5.z);
        })).apply(instance, (v1, v2, v3) -> {
            return new Vec3(v1, v2, v3);
        });
    });

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final Codec<Vec2> f4600D = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("x").forGetter(vec2 -> {
            return Float.valueOf(vec2.x);
        }), Codec.FLOAT.fieldOf("y").forGetter(vec3 -> {
            return Float.valueOf(vec3.y);
        })).apply(instance, (v1, v2) -> {
            return new Vec2(v1, v2);
        });
    });

    /* JADX INFO: renamed from: E */
    @NotNull
    public static final Codec<AABB> f4601E = RecordCodecBuilder.create(instance -> {
        return instance.group(f4599C.fieldOf("min").forGetter(aabb -> {
            return new Vec3(aabb.minX, aabb.minY, aabb.minZ);
        }), f4599C.fieldOf("max").forGetter(aabb2 -> {
            return new Vec3(aabb2.maxX, aabb2.maxY, aabb2.maxZ);
        })).apply(instance, AABB::new);
    });

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final Codec<Supplier<SoundEvent>> f4602F = Codec.STRING.flatXmap(str -> {
        Supplier<SoundEvent> supplierM7215d = C1272xL.m7215d(str);
        if (supplierM7215d != null) {
            return DataResult.success(supplierM7215d);
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
        String strM7216f = C1272xL.m7216f(soundEvent);
        if (strM7216f != null) {
            return DataResult.success(strM7216f);
        }
        return DataResult.error(() -> {
            return "Sound event is not registered: " + String.valueOf(soundEvent);
        });
    });

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final Codec<Integer> f4603G = Codec.either(Codec.INT, Codec.STRING).xmap(either -> {
        return (Integer) either.map(num -> {
            return num;
        }, C0859pX::m3962c);
    }, (v0) -> {
        return Either.left(v0);
    });

    /* JADX INFO: renamed from: M */
    @NotNull
    private static final Map<String, MapCodec<? extends AbstractC0858pW>> f4604M = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final Codec<AbstractC0858pW> f4605H;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final StreamCodec<ByteBuf, AbstractC0858pW> f4606d;

    private C0859pX() {
    }

    static {
        f4604M.put("fly_by", m3963a(C0938qx.f5149n));
        f4604M.put("fly_by_entities", m3963a(C0939qy.f5173o));
        f4604M.put("mist", m3963a(C0890qB.f4881r));
        f4604M.put("pathed_vehicle_entities", m3963a(C0892qD.f4889t));
        f4604M.put("positioned_bombing_flash", m3963a(C0895qG.f4947w));
        f4604M.put("positioned_bullet_tracer", m3963a(C0896qH.f4966x));
        f4604M.put("positioned_timed_sound", m3963a(C0904qP.f5046F));
        f4604M.put("positioned_particle", m3963a(C0900qL.f5000B));
        f4604M.put("positioned_rocket_barrage", m3963a(C0901qM.f5009C));
        f4604M.put("positioned_rocket", m3963a(C0902qN.f5023D));
        f4604M.put("sky_planes", m3963a(C0908qT.f5080J));
        f4604M.put("surrender_paper", m3963a(C0910qV.f5089L));
        f4604M.put("watchlight", m3963a(C0914qZ.f5106P));
        f4604M.put("positioned_artillery_gun", m3963a(C0894qF.f4927v));
        f4604M.put("falling_artillery", m3963a(C0937qw.f5143m));
        f4604M.put("random_explosion", m3963a(C0906qR.f5065H));
        f4604M.put("lightning", m3963a(C0940qz.f5203p));
        f4604M.put("positioned_looping_sound", m3963a(C0899qK.f4994A));
        f4604M.put("positioned_entity", m3963a(C0897qI.f4977y));
        f4604M.put("water_color", m3963a(C0968ra.f5379Q));
        f4604M.put("shader", m3963a(C0907qS.f5071I));
        f4604M.put("time", m3963a(C0912qX.f5099N));
        f4604M.put("sky_settings", m3963a(C0909qU.f5085K));
        f4604M.put("weather", m3963a(C0969rb.f5388R));
        f4604M.put("map_name", m3963a(C0889qA.f4873q));
        f4604M.put("author", m3963a(C0936qv.f5140l));
        f4604M.put("teams", m3963a(C0911qW.f5095M));
        f4604M.put("music_set", m3963a(C0891qC.f4886s));
        f4604M.put("positioned_light_source", m3963a(C0898qJ.f4984z));
        f4604M.put("positioned_area_light_source", m3963a(C0893qE.f4911u));
        f4604M.put("positioned_spot_light_source", m3963a(C0903qO.f5032E));
        f4604M.put("positioned_vehicle", m3963a(C0905qQ.f5056G));
        f4604M.put("trigger_condition", m3963a(C0913qY.f5102O));
        f4605H = Codec.STRING.dispatch("effectType", abstractC0858pW -> {
            return C0860pY.m3992a(abstractC0858pW.getClass());
        }, str -> {
            MapCodec<? extends AbstractC0858pW> mapCodec = f4604M.get(str);
            if (mapCodec == null) {
                throw new IllegalArgumentException("No codec registered for map effect type: " + str);
            }
            return mapCodec;
        });
        f4606d = ByteBufCodecs.fromCodecTrusted(f4605H);
    }

    /* JADX INFO: renamed from: c */
    private static int m3962c(@NotNull String str) {
        return (int) Long.parseLong(str.startsWith("#") ? str.substring(1) : str, 16);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T extends AbstractC0858pW> MapCodec<T> m3963a(@NotNull MapCodec<T> mapCodec) {
        return RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(UUIDUtil.STRING_CODEC.optionalFieldOf("uuid").forGetter(abstractC0858pW -> {
                return Optional.of(abstractC0858pW.f4592y);
            }), Codec.STRING.optionalFieldOf("effectId").forGetter(abstractC0858pW2 -> {
                return Optional.ofNullable(abstractC0858pW2.f4594cg);
            }), Codec.BOOL.optionalFieldOf("defaultEnabled", true).forGetter(abstractC0858pW3 -> {
                return Boolean.valueOf(abstractC0858pW3.f4595gE);
            }), f4599C.optionalFieldOf("position", Vec3.ZERO).forGetter(abstractC0858pW4 -> {
                return abstractC0858pW4.f4593c;
            }), mapCodec.forGetter(abstractC0858pW5 -> {
                return abstractC0858pW5;
            })).apply(instance, (optional, optional2, bool, vec3, abstractC0858pW6) -> {
                abstractC0858pW6.f4592y = (UUID) optional.orElseGet(UUID::randomUUID);
                abstractC0858pW6.f4594cg = (String) optional2.orElse(null);
                abstractC0858pW6.f4595gE = bool.booleanValue();
                abstractC0858pW6.f4596gF = bool.booleanValue();
                abstractC0858pW6.f4593c = vec3;
                return abstractC0858pW6;
            });
        });
    }
}
