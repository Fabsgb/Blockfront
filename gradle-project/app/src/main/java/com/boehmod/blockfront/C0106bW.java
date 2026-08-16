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

/* JADX INFO: renamed from: com.boehmod.blockfront.bW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bW.class */
public final class C0106bW extends Record implements Holder<DimensionType> {
    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0106bW.class), C0106bW.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0106bW.class, Object.class), C0106bW.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean isBound() {
        return true;
    }

    /* JADX INFO: renamed from: is */
    public boolean m402is(@NotNull ResourceLocation resourceLocation) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m403is(@NotNull ResourceKey<DimensionType> resourceKey) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m404is(@NotNull TagKey<DimensionType> tagKey) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m405is(@NotNull Holder<DimensionType> holder) {
        return false;
    }

    /* JADX INFO: renamed from: is */
    public boolean m406is(@NotNull Predicate<ResourceKey<DimensionType>> predicate) {
        return false;
    }

    @NotNull
    public Either<ResourceKey<DimensionType>, DimensionType> unwrap() {
        return Either.right(C0107bX.f703a);
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
        return C0107bX.f703a;
    }
}
