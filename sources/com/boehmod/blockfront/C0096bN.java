package com.boehmod.blockfront;

import com.mojang.datafixers.util.Either;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bN.class */
public final class C0096bN extends Record implements Holder<DimensionType> {
    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0096bN.class), C0096bN.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0096bN.class, Object.class), C0096bN.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean isBound() {
        return true;
    }

    /* JADX INFO: renamed from: is */
    public boolean m297is(@NotNull ResourceLocation resourceLocation) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m298is(@NotNull ResourceKey<DimensionType> resourceKey) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m299is(@NotNull TagKey<DimensionType> tagKey) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m300is(@NotNull Holder<DimensionType> holder) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m301is(@NotNull Predicate<ResourceKey<DimensionType>> predicate) {
        return false;
    }

    @NotNull
    public Either<ResourceKey<DimensionType>, DimensionType> unwrap() {
        return Either.right(C0097bO.f634a);
    }

    @NotNull
    public Optional<ResourceKey<DimensionType>> unwrapKey() {
        return Optional.of(BuiltinDimensionTypes.OVERWORLD);
    }

    @NotNull
    public Holder.Kind kind() {
        return Holder.Kind.DIRECT;
    }

    @Override // java.lang.Record
    public String toString() {
        return "Direct{" + String.valueOf(value()) + "}";
    }

    public boolean canSerializeIn(@NotNull HolderOwner<DimensionType> holderOwner) {
        return true;
    }

    @NotNull
    public Stream<TagKey<DimensionType>> tags() {
        return Stream.of((Object[]) new TagKey[0]);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public DimensionType value() {
        return C0097bO.f634a;
    }
}
