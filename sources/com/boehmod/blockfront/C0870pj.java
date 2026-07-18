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

/* JADX INFO: renamed from: com.boehmod.blockfront.pj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pj.class */
public final class C0870pj extends Record {

    /* JADX INFO: renamed from: bT */
    @Nullable
    private final String f4570bT;

    /* JADX INFO: renamed from: dT */
    @Nullable
    private final ResourceLocation f4571dT;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final Integer f4572a;

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final Codec<C0870pj> f4573y = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("weapon").forGetter(c0870pj -> {
            return Optional.ofNullable(c0870pj.m4375N());
        }), ResourceLocation.CODEC.optionalFieldOf("id").forGetter(c0870pj2 -> {
            return Optional.ofNullable(c0870pj2.m4376y());
        }), Codec.INT.optionalFieldOf("count").forGetter(c0870pj3 -> {
            return Optional.ofNullable(c0870pj3.m4377a());
        })).apply(instance, (optional, optional2, optional3) -> {
            return new C0870pj((String) optional.orElse(null), (ResourceLocation) optional2.orElse(null), (Integer) optional3.orElse(null));
        });
    });

    public C0870pj(@Nullable String str, @Nullable ResourceLocation resourceLocation, @Nullable Integer num) {
        this.f4570bT = str;
        this.f4571dT = resourceLocation;
        this.f4572a = num;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0870pj.class), C0870pj.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pj;->bT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pj;->dT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pj;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0870pj.class), C0870pj.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pj;->bT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pj;->dT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pj;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0870pj.class, Object.class), C0870pj.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pj;->bT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pj;->dT:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pj;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: N */
    public String m4375N() {
        return this.f4570bT;
    }

    @Nullable
    /* JADX INFO: renamed from: y */
    public ResourceLocation m4376y() {
        return this.f4571dT;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Integer m4377a() {
        return this.f4572a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ItemStack m4374a(@NotNull C1019sZ c1019sZ, @NotNull Map<String, ItemStack> map) {
        if (this.f4571dT != null) {
            Item item = (Item) BuiltInRegistries.ITEM.getOptional(this.f4571dT).orElse(null);
            if (item == null) {
                C0562jt.logError("Class template slot references unknown item '%s'", this.f4571dT);
                return ItemStack.EMPTY;
            }
            return new ItemStack(item, this.f4572a != null ? this.f4572a.intValue() : 1);
        }
        if (this.f4570bT != null) {
            ItemStack itemStackM5672a = map.get(this.f4570bT);
            if (itemStackM5672a == null) {
                itemStackM5672a = c1019sZ.m5672a(this.f4570bT);
            }
            if (itemStackM5672a == null) {
                C0562jt.logError("Nation '%s' arsenal has no weapon role '%s'", c1019sZ.m5669ao(), this.f4570bT);
                return ItemStack.EMPTY;
            }
            ItemStack itemStackCopy = itemStackM5672a.copy();
            if (this.f4572a != null) {
                itemStackCopy.setCount(this.f4572a.intValue());
            }
            return itemStackCopy;
        }
        C0562jt.logError("Class template slot defines neither 'weapon' nor 'id'", new Object[0]);
        return ItemStack.EMPTY;
    }
}
