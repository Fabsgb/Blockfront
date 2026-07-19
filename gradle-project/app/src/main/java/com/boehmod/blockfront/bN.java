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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bN.class */
public final class bN extends Record implements Holder<DimensionType> {
    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, bN.class), bN.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, bN.class, Object.class), bN.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean isBound() {
        return true;
    }

    public boolean is(@NotNull ResourceLocation resourceLocation) {
        return false;
    }

    public boolean is(@NotNull ResourceKey<DimensionType> resourceKey) {
        return false;
    }

    public boolean is(@NotNull TagKey<DimensionType> tagKey) {
        return false;
    }

    public boolean is(@NotNull Holder<DimensionType> holder) {
        return false;
    }

    public boolean is(@NotNull Predicate<ResourceKey<DimensionType>> predicate) {
        return false;
    }

    @NotNull
    public Either<ResourceKey<DimensionType>, DimensionType> unwrap() {
        return Either.right(bO.a);
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
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DimensionType value() {
        return bO.a;
    }
}
