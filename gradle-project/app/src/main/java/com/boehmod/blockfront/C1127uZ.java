package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uZ.class */
public final class C1127uZ extends Record {

    /* JADX INFO: renamed from: oj */
    private final float f6179oj;

    /* JADX INFO: renamed from: ai */
    @NotNull
    public static final Codec<C1127uZ> f6180ai = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("reduction").forGetter((v0) -> {
            return v0.m6469bE();
        })).apply(instance, (v1) -> {
            return new C1127uZ(v1);
        });
    });

    /* JADX INFO: renamed from: an */
    @NotNull
    public static final Map<ResourceLocation, C1127uZ> f6181an = new LinkedHashMap();

    public C1127uZ(float f) {
        this.f6179oj = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1127uZ.class), C1127uZ.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uZ;->oj:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1127uZ.class), C1127uZ.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uZ;->oj:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1127uZ.class, Object.class), C1127uZ.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uZ;->oj:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bE */
    public float m6469bE() {
        return this.f6179oj;
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6466aZ() {
        f6181an.clear();
    }

    /* JADX INFO: renamed from: a */
    public static void m6467a(@NotNull ResourceLocation resourceLocation, @NotNull C1127uZ c1127uZ) {
        f6181an.put(resourceLocation, c1127uZ);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1127uZ m6468a(@NotNull ResourceLocation resourceLocation) {
        return f6181an.get(resourceLocation);
    }
}
