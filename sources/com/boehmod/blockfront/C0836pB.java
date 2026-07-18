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

/* JADX INFO: renamed from: com.boehmod.blockfront.pB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pB.class */
public final class C0836pB {

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final Codec<Vec3> f4470C = RecordCodecBuilder.create(instance -> {
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

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final Codec<Vec2> f4471D = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("x").forGetter(vec2 -> {
            return Float.valueOf(vec2.x);
        }), Codec.FLOAT.fieldOf("y").forGetter(vec22 -> {
            return Float.valueOf(vec22.y);
        })).apply(instance, (v1, v2) -> {
            return new Vec2(v1, v2);
        });
    });

    /* JADX INFO: renamed from: E */
    @NotNull
    public static final Codec<AABB> f4472E = RecordCodecBuilder.create(instance -> {
        return instance.group(f4470C.fieldOf("min").forGetter(aabb -> {
            return new Vec3(aabb.minX, aabb.minY, aabb.minZ);
        }), f4470C.fieldOf("max").forGetter(aabb2 -> {
            return new Vec3(aabb2.maxX, aabb2.maxY, aabb2.maxZ);
        })).apply(instance, AABB::new);
    });

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final Codec<Supplier<SoundEvent>> f4473F = Codec.STRING.flatXmap(str -> {
        Supplier<SoundEvent> supplierM7888d = C1292xo.m7888d(str);
        if (supplierM7888d != null) {
            return DataResult.success(supplierM7888d);
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
        String strM7889f = C1292xo.m7889f(soundEvent);
        if (strM7889f != null) {
            return DataResult.success(strM7889f);
        }
        return DataResult.error(() -> {
            return "Sound event is not registered: " + String.valueOf(soundEvent);
        });
    });

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final Codec<Integer> f4474G = Codec.either(Codec.INT, Codec.STRING).xmap(either -> {
        return (Integer) either.map(num -> {
            return num;
        }, C0836pB::m4232c);
    }, (v0) -> {
        return Either.left(v0);
    });

    /* JADX INFO: renamed from: M */
    @NotNull
    private static final Map<String, MapCodec<? extends AbstractC0835pA>> f4475M = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final Codec<AbstractC0835pA> f4476H;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final StreamCodec<ByteBuf, AbstractC0835pA> f4477d;

    private C0836pB() {
    }

    static {
        f4475M.put("fly_by", m4233a(C0915qb.f4734n));
        f4475M.put("fly_by_entities", m4233a(C0916qc.f4758o));
        f4475M.put("mist", m4233a(C0919qf.f4802r));
        f4475M.put("pathed_vehicle_entities", m4233a(C0921qh.f4810t));
        f4475M.put("positioned_bombing_flash", m4233a(C0924qk.f4867w));
        f4475M.put("positioned_bullet_tracer", m4233a(C0925ql.f4886x));
        f4475M.put("positioned_timed_sound", m4233a(C0932qs.f4950E));
        f4475M.put("positioned_particle", m4233a(C0929qp.f4919B));
        f4475M.put("positioned_rocket_barrage", m4233a(C0930qq.f4928C));
        f4475M.put("positioned_rocket", m4233a(C0931qr.f4942D));
        f4475M.put("sky_planes", m4233a(C0936qw.f4984I));
        f4475M.put("surrender_paper", m4233a(C0938qy.f4993K));
        f4475M.put("watchlight", m4233a(C0890qC.f4635O));
        f4475M.put("positioned_artillery_gun", m4233a(C0923qj.f4847v));
        f4475M.put("falling_artillery", m4233a(C0914qa.f4728m));
        f4475M.put("random_explosion", m4233a(C0934qu.f4969G));
        f4475M.put("lightning", m4233a(C0917qd.f4788p));
        f4475M.put("positioned_looping_sound", m4233a(C0928qo.f4913A));
        f4475M.put("positioned_entity", m4233a(C0926qm.f4897y));
        f4475M.put("water_color", m4233a(C0891qD.f4649P));
        f4475M.put("shader", m4233a(C0935qv.f4975H));
        f4475M.put("time", m4233a(C0888qA.f4628M));
        f4475M.put("sky_settings", m4233a(C0937qx.f4989J));
        f4475M.put("weather", m4233a(C0892qE.f4658Q));
        f4475M.put("map_name", m4233a(C0918qe.f4794q));
        f4475M.put("author", m4233a(C0860pZ.f4501l));
        f4475M.put("teams", m4233a(C0939qz.f4999L));
        f4475M.put("music_set", m4233a(C0920qg.f4807s));
        f4475M.put("positioned_light_source", m4233a(C0927qn.f4904z));
        f4475M.put("positioned_area_light_source", m4233a(C0922qi.f4832u));
        f4475M.put("positioned_vehicle", m4233a(C0933qt.f4960F));
        f4475M.put("trigger_condition", m4233a(C0889qB.f4631N));
        f4476H = Codec.STRING.dispatch("effectType", abstractC0835pA -> {
            return C0837pC.m4262a(abstractC0835pA.getClass());
        }, str -> {
            MapCodec<? extends AbstractC0835pA> mapCodec = f4475M.get(str);
            if (mapCodec == null) {
                throw new IllegalArgumentException("No codec registered for map effect type: " + str);
            }
            return mapCodec;
        });
        f4477d = ByteBufCodecs.fromCodecTrusted(f4476H);
    }

    /* JADX INFO: renamed from: c */
    private static int m4232c(@NotNull String str) {
        return (int) Long.parseLong(str.startsWith("#") ? str.substring(1) : str, 16);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T extends AbstractC0835pA> MapCodec<T> m4233a(@NotNull MapCodec<T> mapCodec) {
        return RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(UUIDUtil.STRING_CODEC.optionalFieldOf("uuid").forGetter(abstractC0835pA -> {
                return Optional.of(abstractC0835pA.f4463y);
            }), Codec.STRING.optionalFieldOf("effectId").forGetter(abstractC0835pA2 -> {
                return Optional.ofNullable(abstractC0835pA2.f4465bW);
            }), Codec.BOOL.optionalFieldOf("defaultEnabled", true).forGetter(abstractC0835pA3 -> {
                return Boolean.valueOf(abstractC0835pA3.f4466gk);
            }), f4470C.optionalFieldOf("position", Vec3.ZERO).forGetter(abstractC0835pA4 -> {
                return abstractC0835pA4.f4464c;
            }), mapCodec.forGetter(abstractC0835pA5 -> {
                return abstractC0835pA5;
            })).apply(instance, (optional, optional2, bool, vec3, abstractC0835pA6) -> {
                abstractC0835pA6.f4463y = (UUID) optional.orElseGet(UUID::randomUUID);
                abstractC0835pA6.f4465bW = (String) optional2.orElse(null);
                abstractC0835pA6.f4466gk = bool.booleanValue();
                abstractC0835pA6.f4467gl = bool.booleanValue();
                abstractC0835pA6.f4464c = vec3;
                return abstractC0835pA6;
            });
        });
    }
}
