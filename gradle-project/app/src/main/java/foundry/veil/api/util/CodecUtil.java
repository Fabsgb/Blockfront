package foundry.veil.api.util;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector2d;
import org.joml.Vector2dc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4d;
import org.joml.Vector4dc;
import org.joml.Vector4f;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/util/CodecUtil.class */
public class CodecUtil {
    public static final EnumCodec<GlslTypeSpecifier.BuiltinType> BUILTIN_TYPE_CODEC = EnumCodec.builder("glsl_type").values(GlslTypeSpecifier.BuiltinType.values()).build();
    public static final Codec<Vector2fc> VECTOR2FC_CODEC = Codec.FLOAT.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(2, list2);
    }).xmap(list3 -> {
        return new Vector2f(((Float) list3.get(0)).floatValue(), ((Float) list3.get(1)).floatValue());
    }, vector -> {
        return List.of(Float.valueOf(vector.x()), Float.valueOf(vector.y()));
    });
    public static final Codec<Vector3fc> VECTOR3FC_CODEC = Codec.FLOAT.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(3, list2);
    }).xmap(list3 -> {
        return new Vector3f(((Float) list3.get(0)).floatValue(), ((Float) list3.get(1)).floatValue(), ((Float) list3.get(2)).floatValue());
    }, vector -> {
        return List.of(Float.valueOf(vector.x()), Float.valueOf(vector.y()), Float.valueOf(vector.z()));
    });
    public static final Codec<Vector4fc> VECTOR4FC_CODEC = Codec.FLOAT.listOf().flatXmap(list -> {
        return check(4, list);
    }, list2 -> {
        return check(4, list2);
    }).xmap(list3 -> {
        return new Vector4f(((Float) list3.get(0)).floatValue(), ((Float) list3.get(1)).floatValue(), ((Float) list3.get(2)).floatValue(), ((Float) list3.get(3)).floatValue());
    }, vector -> {
        return List.of(Float.valueOf(vector.x()), Float.valueOf(vector.y()), Float.valueOf(vector.z()), Float.valueOf(vector.w()));
    });
    public static final Codec<Vector2dc> VECTOR2DC_CODEC = Codec.DOUBLE.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(2, list2);
    }).xmap(list3 -> {
        return new Vector2d(((Double) list3.get(0)).doubleValue(), ((Double) list3.get(1)).doubleValue());
    }, vector -> {
        return List.of(Double.valueOf(vector.x()), Double.valueOf(vector.y()));
    });
    public static final Codec<Vector3dc> VECTOR3DC_CODEC = Codec.DOUBLE.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(3, list2);
    }).xmap(list3 -> {
        return new Vector3d(((Double) list3.get(0)).doubleValue(), ((Double) list3.get(1)).doubleValue(), ((Double) list3.get(2)).doubleValue());
    }, vector -> {
        return List.of(Double.valueOf(vector.x()), Double.valueOf(vector.y()), Double.valueOf(vector.z()));
    });
    public static final Codec<Vector4dc> VECTOR4DC_CODEC = Codec.DOUBLE.listOf().flatXmap(list -> {
        return check(4, list);
    }, list2 -> {
        return check(4, list2);
    }).xmap(list3 -> {
        return new Vector4d(((Double) list3.get(0)).doubleValue(), ((Double) list3.get(1)).doubleValue(), ((Double) list3.get(2)).doubleValue(), ((Double) list3.get(3)).doubleValue());
    }, vector -> {
        return List.of(Double.valueOf(vector.x()), Double.valueOf(vector.y()), Double.valueOf(vector.z()), Double.valueOf(vector.w()));
    });
    public static final Codec<Matrix3fc> MATRIX3FC_CODEC = VECTOR3FC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix3f((Vector3fc) list.get(0), (Vector3fc) list.get(1), (Vector3fc) list.get(2));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector3f()), matrix.getColumn(1, new Vector3f()), matrix.getColumn(2, new Vector3f()));
    });
    public static final Codec<Matrix4fc> MATRIX4FC_CODEC = VECTOR4FC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix4f((Vector4fc) list.get(0), (Vector4fc) list.get(1), (Vector4fc) list.get(2), (Vector4fc) list.get(3));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector4f()), matrix.getColumn(1, new Vector4f()), matrix.getColumn(2, new Vector4f()), matrix.getColumn(3, new Vector4f()));
    });
    public static final Codec<Matrix3dc> MATRIX3DC_CODEC = VECTOR3DC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix3d((Vector3dc) list.get(0), (Vector3dc) list.get(1), (Vector3dc) list.get(2));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector3d()), matrix.getColumn(1, new Vector3d()), matrix.getColumn(2, new Vector3d()));
    });
    public static final Codec<Matrix4dc> MATRIX4DC_CODEC = VECTOR4DC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix4d((Vector4d) list.get(0), (Vector4d) list.get(1), (Vector4d) list.get(2), (Vector4d) list.get(3));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector4d()), matrix.getColumn(1, new Vector4d()), matrix.getColumn(2, new Vector4d()), matrix.getColumn(3, new Vector4d()));
    });
    public static final Codec<Vector2f> VECTOR2F_CODEC = Codec.FLOAT.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(2, list2);
    }).xmap(list3 -> {
        return new Vector2f(((Float) list3.get(0)).floatValue(), ((Float) list3.get(1)).floatValue());
    }, vector -> {
        return List.of(Float.valueOf(vector.x()), Float.valueOf(vector.y()));
    });
    public static final Codec<Vector3f> VECTOR3F_CODEC = Codec.FLOAT.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(3, list2);
    }).xmap(list3 -> {
        return new Vector3f(((Float) list3.get(0)).floatValue(), ((Float) list3.get(1)).floatValue(), ((Float) list3.get(2)).floatValue());
    }, vector -> {
        return List.of(Float.valueOf(vector.x()), Float.valueOf(vector.y()), Float.valueOf(vector.z()));
    });
    public static final Codec<Vector4f> VECTOR4F_CODEC = Codec.FLOAT.listOf().flatXmap(list -> {
        return check(4, list);
    }, list2 -> {
        return check(4, list2);
    }).xmap(list3 -> {
        return new Vector4f(((Float) list3.get(0)).floatValue(), ((Float) list3.get(1)).floatValue(), ((Float) list3.get(2)).floatValue(), ((Float) list3.get(3)).floatValue());
    }, vector -> {
        return List.of(Float.valueOf(vector.x()), Float.valueOf(vector.y()), Float.valueOf(vector.z()), Float.valueOf(vector.w()));
    });
    public static final Codec<Vector2d> VECTOR2D_CODEC = Codec.DOUBLE.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(2, list2);
    }).xmap(list3 -> {
        return new Vector2d(((Double) list3.get(0)).doubleValue(), ((Double) list3.get(1)).doubleValue());
    }, vector -> {
        return List.of(Double.valueOf(vector.x()), Double.valueOf(vector.y()));
    });
    public static final Codec<Vector3d> VECTOR3D_CODEC = Codec.DOUBLE.listOf().flatXmap(list -> {
        return check(3, list);
    }, list2 -> {
        return check(3, list2);
    }).xmap(list3 -> {
        return new Vector3d(((Double) list3.get(0)).doubleValue(), ((Double) list3.get(1)).doubleValue(), ((Double) list3.get(2)).doubleValue());
    }, vector -> {
        return List.of(Double.valueOf(vector.x()), Double.valueOf(vector.y()), Double.valueOf(vector.z()));
    });
    public static final Codec<Vector4d> VECTOR4D_CODEC = Codec.DOUBLE.listOf().flatXmap(list -> {
        return check(4, list);
    }, list2 -> {
        return check(4, list2);
    }).xmap(list3 -> {
        return new Vector4d(((Double) list3.get(0)).doubleValue(), ((Double) list3.get(1)).doubleValue(), ((Double) list3.get(2)).doubleValue(), ((Double) list3.get(3)).doubleValue());
    }, vector -> {
        return List.of(Double.valueOf(vector.x()), Double.valueOf(vector.y()), Double.valueOf(vector.z()), Double.valueOf(vector.w()));
    });
    public static final Codec<Matrix3f> MATRIX3F_CODEC = VECTOR3FC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix3f((Vector3fc) list.get(0), (Vector3fc) list.get(1), (Vector3fc) list.get(2));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector3f()), matrix.getColumn(1, new Vector3f()), matrix.getColumn(2, new Vector3f()));
    });
    public static final Codec<Matrix4f> MATRIX4F_CODEC = VECTOR4FC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix4f((Vector4fc) list.get(0), (Vector4fc) list.get(1), (Vector4fc) list.get(2), (Vector4fc) list.get(3));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector4f()), matrix.getColumn(1, new Vector4f()), matrix.getColumn(2, new Vector4f()), matrix.getColumn(3, new Vector4f()));
    });
    public static final Codec<Matrix3dc> MATRIX3D_CODEC = VECTOR3DC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix3d((Vector3dc) list.get(0), (Vector3dc) list.get(1), (Vector3dc) list.get(2));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector3d()), matrix.getColumn(1, new Vector3d()), matrix.getColumn(2, new Vector3d()));
    });
    public static final Codec<Matrix4d> MATRIX4D_CODEC = VECTOR4DC_CODEC.listOf(3, 3).xmap(list -> {
        return new Matrix4d((Vector4d) list.get(0), (Vector4d) list.get(1), (Vector4d) list.get(2), (Vector4d) list.get(3));
    }, matrix -> {
        return List.of(matrix.getColumn(0, new Vector4d()), matrix.getColumn(1, new Vector4d()), matrix.getColumn(2, new Vector4d()), matrix.getColumn(3, new Vector4d()));
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> DataResult<List<T>> check(int size, List<T> list) {
        if (list.size() != size) {
            return DataResult.error(() -> {
                return "Vector" + size + "f must have " + size + " elements!";
            });
        }
        return DataResult.success(list);
    }

    public static <T> Codec<List<T>> singleOrList(Codec<T> codec) {
        return Codec.either(codec.flatComapMap(List::of, l -> {
            if (l.size() == 1) {
                return DataResult.success(l.getFirst());
            }
            return DataResult.error(() -> {
                return "List must have exactly one element.";
            });
        }), ExtraCodecs.nonEmptyList(codec.listOf())).xmap(e -> {
            return (List) e.map(Function.identity(), Function.identity());
        }, l2 -> {
            return l2.size() == 1 ? Either.left(l2) : Either.right(l2);
        });
    }

    public static <T> Codec<T> registryOrLegacyCodec(Registry<T> registry) {
        Codec<T> legacyCodec = Codec.STRING.comapFlatMap(name -> {
            return ResourceLocation.read("veil:" + name.toLowerCase(Locale.ROOT));
        }, (v0) -> {
            return v0.toString();
        }).flatXmap(loc -> {
            return (DataResult) Optional.ofNullable(registry.get(loc)).map(DataResult::success).orElseGet(() -> {
                return DataResult.error(() -> {
                    return "Unknown registry key in " + String.valueOf(registry.key()) + ": " + String.valueOf(loc);
                });
            });
        }, object -> {
            return (DataResult) registry.getResourceKey(object).map((v0) -> {
                return v0.location();
            }).map((v0) -> {
                return DataResult.success(v0);
            }).orElseGet(() -> {
                return DataResult.error(() -> {
                    return "Unknown registry element in " + String.valueOf(registry.key()) + ":" + String.valueOf(object);
                });
            });
        });
        return Codec.either(registry.byNameCodec(), legacyCodec).xmap(e -> {
            return e.map(Function.identity(), Function.identity());
        }, Either::left);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V, K> Map<V, K> pairListToMap(List<? extends Pair<? extends V, ? extends K>> list) {
        HashMap map = new HashMap();
        for (Pair<? extends V, ? extends K> pair : list) {
            map.put(pair.getFirst(), pair.getSecond());
        }
        return map;
    }

    public static <V, K> List<Pair<V, K>> entrySetToPairList(Set<? extends Map.Entry<? extends V, ? extends K>> entrySet) {
        return entrySet.stream().map(entry -> {
            return new Pair(entry.getKey(), entry.getValue());
        }).toList();
    }
}
