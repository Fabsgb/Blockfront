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

/* JADX INFO: renamed from: com.boehmod.blockfront.uz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uz.class */
public final class C1152uz extends Record {

    /* JADX INFO: renamed from: nl */
    private final float f6109nl;

    /* JADX INFO: renamed from: ai */
    @NotNull
    public static final Codec<C1152uz> f6110ai = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("reduction").forGetter((v0) -> {
            return v0.m6480by();
        })).apply(instance, (v1) -> {
            return new C1152uz(v1);
        });
    });

    /* JADX INFO: renamed from: an */
    @NotNull
    public static final Map<ResourceLocation, C1152uz> f6111an = new LinkedHashMap();

    public C1152uz(float f) {
        this.f6109nl = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1152uz.class), C1152uz.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uz;->nl:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1152uz.class), C1152uz.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uz;->nl:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1152uz.class, Object.class), C1152uz.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uz;->nl:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: by */
    public float m6480by() {
        return this.f6109nl;
    }

    /* JADX INFO: renamed from: aR */
    public static void m6477aR() {
        f6111an.clear();
    }

    /* JADX INFO: renamed from: a */
    public static void m6478a(@NotNull ResourceLocation resourceLocation, @NotNull C1152uz c1152uz) {
        f6111an.put(resourceLocation, c1152uz);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1152uz m6479a(@NotNull ResourceLocation resourceLocation) {
        return f6111an.get(resourceLocation);
    }
}
