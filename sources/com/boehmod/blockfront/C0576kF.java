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

/* JADX INFO: renamed from: com.boehmod.blockfront.kF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kF.class */
public final class C0576kF {

    /* JADX INFO: renamed from: m */
    private static final Codec<a> f3343m = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("template").forGetter((v0) -> {
            return v0.m2612I();
        }), Codec.PASSTHROUGH.optionalFieldOf("overrides").forGetter((v0) -> {
            return v0.m2613b();
        })).apply(instance, a::new);
    });

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final Codec<C0576kF> f3344n = f3343m.xmap(aVar -> {
        Vec3 vec3 = Vec3.ZERO;
        JsonObject jsonObject = null;
        if (aVar.m2613b().isPresent()) {
            JsonElement jsonElement = (JsonElement) aVar.m2613b().get().convert(JsonOps.INSTANCE).getValue();
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
        return new C0576kF(aVar.m2612I(), vec3, jsonObject);
    }, c0576kF -> {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("x", Double.valueOf(c0576kF.f3346F.x));
        jsonObject2.addProperty("y", Double.valueOf(c0576kF.f3346F.y));
        jsonObject2.addProperty("z", Double.valueOf(c0576kF.f3346F.z));
        jsonObject.add("position", jsonObject2);
        if (c0576kF.f3347a != null) {
            for (Map.Entry entry : c0576kF.f3347a.entrySet()) {
                jsonObject.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        return new a(c0576kF.f3345bo, Optional.of(new Dynamic(JsonOps.INSTANCE, jsonObject)));
    });

    /* JADX INFO: renamed from: bo */
    @NotNull
    private final String f3345bo;

    /* JADX INFO: renamed from: F */
    @NotNull
    private Vec3 f3346F;

    /* JADX INFO: renamed from: a */
    @Nullable
    private JsonObject f3347a;

    /* JADX INFO: renamed from: com.boehmod.blockfront.kF$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kF$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: bp */
        private final String f3348bp;

        /* JADX INFO: renamed from: a */
        private final Optional<Dynamic<?>> f3349a;

        private a(String str, Optional<Dynamic<?>> optional) {
            this.f3348bp = str;
            this.f3349a = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "templateName;overrides", "FIELD:Lcom/boehmod/blockfront/kF$a;->bp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kF$a;->a:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "templateName;overrides", "FIELD:Lcom/boehmod/blockfront/kF$a;->bp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kF$a;->a:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "templateName;overrides", "FIELD:Lcom/boehmod/blockfront/kF$a;->bp:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kF$a;->a:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: I */
        public String m2612I() {
            return this.f3348bp;
        }

        /* JADX INFO: renamed from: b */
        public Optional<Dynamic<?>> m2613b() {
            return this.f3349a;
        }
    }

    public C0576kF(@NotNull String str, @NotNull Vec3 vec3, @Nullable JsonObject jsonObject) {
        this.f3345bo = str;
        this.f3346F = vec3;
        this.f3347a = jsonObject;
    }

    public C0576kF(@NotNull String str, @NotNull Vec3 vec3) {
        this(str, vec3, null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0858pW m2603a(@NotNull C0607kk c0607kk, int i) {
        C0605ki c0605kiM2737a = c0607kk.m2737a(C0575kE.class);
        if (c0605kiM2737a == null) {
            C0530jM.m2337a("[MapEffectTemplateReference] No template registry found when resolving '%s'.", this.f3345bo);
            return null;
        }
        C0575kE c0575kE = (C0575kE) c0605kiM2737a.m2707a(this.f3345bo);
        if (c0575kE == null) {
            C0530jM.m2337a("[MapEffectTemplateReference] Template '%s' not found in registry.", this.f3345bo);
            return null;
        }
        DataResult dataResultEncodeStart = C0859pX.f4605H.encodeStart(JsonOps.INSTANCE, c0575kE.m2595a());
        if (dataResultEncodeStart.isError()) {
            C0530jM.m2337a("[MapEffectTemplateReference] Failed to encode template effect for '%s': %s", this.f3345bo, dataResultEncodeStart.error().map((v0) -> {
                return v0.message();
            }).orElse("unknown"));
            return null;
        }
        JsonObject jsonObjectDeepCopy = ((JsonElement) dataResultEncodeStart.getOrThrow()).getAsJsonObject().deepCopy();
        if (this.f3347a != null) {
            for (Map.Entry entry : this.f3347a.entrySet()) {
                jsonObjectDeepCopy.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        Vec3 vec3Add = this.f3346F.add(c0575kE.m2595a().f4593c);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("x", Double.valueOf(vec3Add.x));
        jsonObject.addProperty("y", Double.valueOf(vec3Add.y));
        jsonObject.addProperty("z", Double.valueOf(vec3Add.z));
        jsonObjectDeepCopy.add("position", jsonObject);
        DataResult dataResult = C0859pX.f4605H.parse(JsonOps.INSTANCE, jsonObjectDeepCopy);
        if (dataResult.isError()) {
            C0530jM.m2337a("[MapEffectTemplateReference] Failed to parse resolved effect for template '%s': %s", this.f3345bo, dataResult.error().map((v0) -> {
                return v0.message();
            }).orElse("unknown"));
            return null;
        }
        AbstractC0858pW abstractC0858pW = (AbstractC0858pW) dataResult.getOrThrow();
        abstractC0858pW.f4592y = UUID.nameUUIDFromBytes((this.f3345bo + "#" + i).getBytes(StandardCharsets.UTF_8));
        return abstractC0858pW;
    }

    @NotNull
    /* JADX INFO: renamed from: H */
    public String m2604H() {
        return this.f3345bo;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Vec3 m2605k() {
        return this.f3346F;
    }

    /* JADX INFO: renamed from: b */
    public void m2606b(@NotNull Vec3 vec3) {
        this.f3346F = vec3;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public JsonObject m2607b() {
        return this.f3347a;
    }

    /* JADX INFO: renamed from: c */
    public void m2608c(@Nullable JsonObject jsonObject) {
        this.f3347a = jsonObject;
    }
}
