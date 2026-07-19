package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.pj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pj.class */
public final class C0415pj extends Record {

    @Nullable
    private final String bT;

    @Nullable
    private final ResourceLocation dT;

    @Nullable
    private final Integer a;

    @NotNull
    public static final Codec<C0415pj> y = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("weapon").forGetter(c0415pj -> {
            return Optional.ofNullable(c0415pj.N());
        }), ResourceLocation.CODEC.optionalFieldOf("id").forGetter(c0415pj2 -> {
            return Optional.ofNullable(c0415pj2.y());
        }), Codec.INT.optionalFieldOf("count").forGetter(c0415pj3 -> {
            return Optional.ofNullable(c0415pj3.a());
        })).apply(instance, (optional, optional2, optional3) -> {
            return new C0415pj((String) optional.orElse(null), (ResourceLocation) optional2.orElse(null), (Integer) optional3.orElse(null));
        });
    });

    public C0415pj(@Nullable String str, @Nullable ResourceLocation resourceLocation, @Nullable Integer num) {
        this.bT = str;
        this.dT = resourceLocation;
        this.a = num;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0415pj.class), C0415pj.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pj;->bT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pj;->dT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pj;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0415pj.class), C0415pj.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pj;->bT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pj;->dT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pj;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0415pj.class, Object.class), C0415pj.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pj;->bT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pj;->dT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pj;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    public String N() {
        return this.bT;
    }

    @Nullable
    public ResourceLocation y() {
        return this.dT;
    }

    @Nullable
    public Integer a() {
        return this.a;
    }

    @NotNull
    public ItemStack a(@NotNull sZ sZVar, @NotNull Map<String, ItemStack> map) {
        if (this.dT != null) {
            Item item = (Item) BuiltInRegistries.ITEM.getOptional(this.dT).orElse(null);
            if (item == null) {
                C0263jt.logError("Class template slot references unknown item '%s'", this.dT);
                return ItemStack.EMPTY;
            }
            return new ItemStack(item, this.a != null ? this.a.intValue() : 1);
        }
        if (this.bT != null) {
            ItemStack itemStackM1105a = map.get(this.bT);
            if (itemStackM1105a == null) {
                itemStackM1105a = sZVar.m1105a(this.bT);
            }
            if (itemStackM1105a == null) {
                C0263jt.logError("Nation '%s' arsenal has no weapon role '%s'", sZVar.ao(), this.bT);
                return ItemStack.EMPTY;
            }
            ItemStack itemStackCopy = itemStackM1105a.copy();
            if (this.a != null) {
                itemStackCopy.setCount(this.a.intValue());
            }
            return itemStackCopy;
        }
        C0263jt.logError("Class template slot defines neither 'weapon' nor 'id'", new Object[0]);
        return ItemStack.EMPTY;
    }
}
