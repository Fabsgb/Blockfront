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

/* JADX INFO: renamed from: com.boehmod.blockfront.uz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uz.class */
public final class C0566uz extends Record {
    private final float nl;

    @NotNull
    public static final Codec<C0566uz> ai = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("reduction").forGetter((v0) -> {
            return v0.by();
        })).apply(instance, (v1) -> {
            return new C0566uz(v1);
        });
    });

    @NotNull
    public static final Map<ResourceLocation, C0566uz> an = new LinkedHashMap();

    public C0566uz(float f) {
        this.nl = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0566uz.class), C0566uz.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uz;->nl:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0566uz.class), C0566uz.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uz;->nl:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0566uz.class, Object.class), C0566uz.class, "reduction", "FIELD:Lcom/boehmod/blockfront/uz;->nl:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float by() {
        return this.nl;
    }

    public static void aR() {
        an.clear();
    }

    public static void a(@NotNull ResourceLocation resourceLocation, @NotNull C0566uz c0566uz) {
        an.put(resourceLocation, c0566uz);
    }

    @Nullable
    public static C0566uz a(@NotNull ResourceLocation resourceLocation) {
        return an.get(resourceLocation);
    }
}
