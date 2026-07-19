package com.boehmod.blockfront;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kj.class */
public final class C0280kj {
    private static final Codec<a> m = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("template").forGetter((v0) -> {
            return v0.B();
        }), Codec.PASSTHROUGH.optionalFieldOf("overrides").forGetter((v0) -> {
            return v0.b();
        })).apply(instance, a::new);
    });

    @NotNull
    public static final Codec<C0280kj> n = m.xmap(aVar -> {
        Vec3 vec3 = Vec3.ZERO;
        JsonObject jsonObject = null;
        if (aVar.b().isPresent()) {
            JsonElement jsonElement = (JsonElement) aVar.b().get().convert(JsonOps.INSTANCE).getValue();
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObjectDeepCopy = jsonElement.getAsJsonObject().deepCopy();
                if (jsonObjectDeepCopy.has("position")) {
                    JsonObject asJsonObject = jsonObjectDeepCopy.getAsJsonObject("position");
                    vec3 = new Vec3(asJsonObject.get("x").getAsDouble(), asJsonObject.get("y").getAsDouble(), asJsonObject.get("z").getAsDouble());
                    jsonObjectDeepCopy.remove("position");
                }
                if (!jsonObjectDeepCopy.entrySet().isEmpty()) {
                    jsonObject = jsonObjectDeepCopy;
                }
            }
        }
        return new C0280kj(aVar.B(), vec3, jsonObject);
    }, c0280kj -> {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("x", Double.valueOf(c0280kj.E.x));
        jsonObject2.addProperty("y", Double.valueOf(c0280kj.E.y));
        jsonObject2.addProperty("z", Double.valueOf(c0280kj.E.z));
        jsonObject.add("position", jsonObject2);
        if (c0280kj.a != null) {
            for (Map.Entry entry : c0280kj.a.entrySet()) {
                jsonObject.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        return new a(c0280kj.bf, Optional.of(new Dynamic(JsonOps.INSTANCE, jsonObject)));
    });

    @NotNull
    private final String bf;

    @NotNull
    private Vec3 E;

    @Nullable
    private JsonObject a;

    /* JADX INFO: renamed from: com.boehmod.blockfront.kj$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kj$a.class */
    private static final class a extends Record {
        private final String bg;
        private final Optional<Dynamic<?>> a;

        private a(String str, Optional<Dynamic<?>> optional) {
            this.bg = str;
            this.a = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "templateName;overrides", "FIELD:Lcom/boehmod/blockfront/kj$a;->bg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kj$a;->a:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "templateName;overrides", "FIELD:Lcom/boehmod/blockfront/kj$a;->bg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kj$a;->a:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "templateName;overrides", "FIELD:Lcom/boehmod/blockfront/kj$a;->bg:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kj$a;->a:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public String B() {
            return this.bg;
        }

        public Optional<Dynamic<?>> b() {
            return this.a;
        }
    }

    public C0280kj(@NotNull String str, @NotNull Vec3 vec3, @Nullable JsonObject jsonObject) {
        this.bf = str;
        this.E = vec3;
        this.a = jsonObject;
    }

    public C0280kj(@NotNull String str, @NotNull Vec3 vec3) {
        this(str, vec3, null);
    }

    @Nullable
    public pA a(@NotNull jO jOVar, int i) {
        jM jMVarA = jOVar.a(C0279ki.class);
        if (jMVarA == null) {
            C0263jt.a("[MapEffectTemplateReference] No template registry found when resolving '%s'.", this.bf);
            return null;
        }
        C0279ki c0279ki = (C0279ki) jMVarA.a(this.bf);
        if (c0279ki == null) {
            C0263jt.a("[MapEffectTemplateReference] Template '%s' not found in registry.", this.bf);
            return null;
        }
        DataResult dataResultEncodeStart = pB.H.encodeStart(JsonOps.INSTANCE, c0279ki.a());
        if (dataResultEncodeStart.isError()) {
            C0263jt.a("[MapEffectTemplateReference] Failed to encode template effect for '%s': %s", this.bf, dataResultEncodeStart.error().map((v0) -> {
                return v0.message();
            }).orElse("unknown"));
            return null;
        }
        JsonObject jsonObjectDeepCopy = ((JsonElement) dataResultEncodeStart.getOrThrow()).getAsJsonObject().deepCopy();
        if (this.a != null) {
            for (Map.Entry entry : this.a.entrySet()) {
                jsonObjectDeepCopy.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        Vec3 vec3Add = this.E.add(c0279ki.a().c);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("x", Double.valueOf(vec3Add.x));
        jsonObject.addProperty("y", Double.valueOf(vec3Add.y));
        jsonObject.addProperty("z", Double.valueOf(vec3Add.z));
        jsonObjectDeepCopy.add("position", jsonObject);
        DataResult dataResult = pB.H.parse(JsonOps.INSTANCE, jsonObjectDeepCopy);
        if (dataResult.isError()) {
            C0263jt.a("[MapEffectTemplateReference] Failed to parse resolved effect for template '%s': %s", this.bf, dataResult.error().map((v0) -> {
                return v0.message();
            }).orElse("unknown"));
            return null;
        }
        pA pAVar = (pA) dataResult.getOrThrow();
        pAVar.y = UUID.nameUUIDFromBytes((this.bf + "#" + i).getBytes(StandardCharsets.UTF_8));
        return pAVar;
    }

    @NotNull
    public String A() {
        return this.bf;
    }

    @NotNull
    public Vec3 j() {
        return this.E;
    }

    public void b(@NotNull Vec3 vec3) {
        this.E = vec3;
    }

    @Nullable
    public JsonObject b() {
        return this.a;
    }

    public void c(@Nullable JsonObject jsonObject) {
        this.a = jsonObject;
    }
}
