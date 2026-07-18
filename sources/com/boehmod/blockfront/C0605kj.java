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

/* JADX INFO: renamed from: com.boehmod.blockfront.kj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kj.class */
public final class C0605kj {

    /* JADX INFO: renamed from: m */
    private static final Codec<a> f3311m = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("template").forGetter((v0) -> {
            return v0.m2659B();
        }), Codec.PASSTHROUGH.optionalFieldOf("overrides").forGetter((v0) -> {
            return v0.m2660b();
        })).apply(instance, a::new);
    });

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final Codec<C0605kj> f3312n = f3311m.xmap(aVar -> {
        Vec3 vec3 = Vec3.ZERO;
        JsonObject jsonObject = null;
        if (aVar.m2660b().isPresent()) {
            JsonElement jsonElement = (JsonElement) aVar.m2660b().get().convert(JsonOps.INSTANCE).getValue();
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
        return new C0605kj(aVar.m2659B(), vec3, jsonObject);
    }, c0605kj -> {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("x", Double.valueOf(c0605kj.f3314E.x));
        jsonObject2.addProperty("y", Double.valueOf(c0605kj.f3314E.y));
        jsonObject2.addProperty("z", Double.valueOf(c0605kj.f3314E.z));
        jsonObject.add("position", jsonObject2);
        if (c0605kj.f3315a != null) {
            for (Map.Entry entry : c0605kj.f3315a.entrySet()) {
                jsonObject.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        return new a(c0605kj.f3313bf, Optional.of(new Dynamic(JsonOps.INSTANCE, jsonObject)));
    });

    /* JADX INFO: renamed from: bf */
    @NotNull
    private final String f3313bf;

    /* JADX INFO: renamed from: E */
    @NotNull
    private Vec3 f3314E;

    /* JADX INFO: renamed from: a */
    @Nullable
    private JsonObject f3315a;

    /* JADX INFO: renamed from: com.boehmod.blockfront.kj$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kj$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: bg */
        private final String f3316bg;

        /* JADX INFO: renamed from: a */
        private final Optional<Dynamic<?>> f3317a;

        private a(String str, Optional<Dynamic<?>> optional) {
            this.f3316bg = str;
            this.f3317a = optional;
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

        /* JADX INFO: renamed from: B */
        public String m2659B() {
            return this.f3316bg;
        }

        /* JADX INFO: renamed from: b */
        public Optional<Dynamic<?>> m2660b() {
            return this.f3317a;
        }
    }

    public C0605kj(@NotNull String str, @NotNull Vec3 vec3, @Nullable JsonObject jsonObject) {
        this.f3313bf = str;
        this.f3314E = vec3;
        this.f3315a = jsonObject;
    }

    public C0605kj(@NotNull String str, @NotNull Vec3 vec3) {
        this(str, vec3, null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0835pA m2650a(@NotNull C0531jO c0531jO, int i) {
        C0529jM c0529jMM2375a = c0531jO.m2375a(C0604ki.class);
        if (c0529jMM2375a == null) {
            C0562jt.m2515a("[MapEffectTemplateReference] No template registry found when resolving '%s'.", this.f3313bf);
            return null;
        }
        C0604ki c0604ki = (C0604ki) c0529jMM2375a.m2347a(this.f3313bf);
        if (c0604ki == null) {
            C0562jt.m2515a("[MapEffectTemplateReference] Template '%s' not found in registry.", this.f3313bf);
            return null;
        }
        DataResult dataResultEncodeStart = C0836pB.f4476H.encodeStart(JsonOps.INSTANCE, c0604ki.m2645a());
        if (dataResultEncodeStart.isError()) {
            C0562jt.m2515a("[MapEffectTemplateReference] Failed to encode template effect for '%s': %s", this.f3313bf, dataResultEncodeStart.error().map((v0) -> {
                return v0.message();
            }).orElse("unknown"));
            return null;
        }
        JsonObject jsonObjectDeepCopy = ((JsonElement) dataResultEncodeStart.getOrThrow()).getAsJsonObject().deepCopy();
        if (this.f3315a != null) {
            for (Map.Entry entry : this.f3315a.entrySet()) {
                jsonObjectDeepCopy.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        Vec3 vec3Add = this.f3314E.add(c0604ki.m2645a().f4464c);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("x", Double.valueOf(vec3Add.x));
        jsonObject.addProperty("y", Double.valueOf(vec3Add.y));
        jsonObject.addProperty("z", Double.valueOf(vec3Add.z));
        jsonObjectDeepCopy.add("position", jsonObject);
        DataResult dataResult = C0836pB.f4476H.parse(JsonOps.INSTANCE, jsonObjectDeepCopy);
        if (dataResult.isError()) {
            C0562jt.m2515a("[MapEffectTemplateReference] Failed to parse resolved effect for template '%s': %s", this.f3313bf, dataResult.error().map((v0) -> {
                return v0.message();
            }).orElse("unknown"));
            return null;
        }
        AbstractC0835pA abstractC0835pA = (AbstractC0835pA) dataResult.getOrThrow();
        abstractC0835pA.f4463y = UUID.nameUUIDFromBytes((this.f3313bf + "#" + i).getBytes(StandardCharsets.UTF_8));
        return abstractC0835pA;
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public String m2651A() {
        return this.f3313bf;
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Vec3 m2652j() {
        return this.f3314E;
    }

    /* JADX INFO: renamed from: b */
    public void m2653b(@NotNull Vec3 vec3) {
        this.f3314E = vec3;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public JsonObject m2654b() {
        return this.f3315a;
    }

    /* JADX INFO: renamed from: c */
    public void m2655c(@Nullable JsonObject jsonObject) {
        this.f3315a = jsonObject;
    }
}
