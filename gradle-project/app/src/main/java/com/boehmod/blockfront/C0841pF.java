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

/* JADX INFO: renamed from: com.boehmod.blockfront.pF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pF.class */
public final class C0841pF extends Record {

    /* JADX INFO: renamed from: cd */
    @Nullable
    private final String f4539cd;

    /* JADX INFO: renamed from: dR */
    @Nullable
    private final ResourceLocation f4540dR;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final Integer f4541a;

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final Codec<C0841pF> f4542y = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("weapon").forGetter(c0841pF -> {
            return Optional.ofNullable(c0841pF.m3861U());
        }), ResourceLocation.CODEC.optionalFieldOf("id").forGetter(c0841pF2 -> {
            return Optional.ofNullable(c0841pF2.m3862z());
        }), Codec.INT.optionalFieldOf("count").forGetter(c0841pF3 -> {
            return Optional.ofNullable(c0841pF3.m3863a());
        })).apply(instance, (optional, optional2, optional3) -> {
            return new C0841pF((String) optional.orElse(null), (ResourceLocation) optional2.orElse(null), (Integer) optional3.orElse(null));
        });
    });

    public C0841pF(@Nullable String str, @Nullable ResourceLocation resourceLocation, @Nullable Integer num) {
        this.f4539cd = str;
        this.f4540dR = resourceLocation;
        this.f4541a = num;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0841pF.class), C0841pF.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pF;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pF;->dR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pF;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0841pF.class), C0841pF.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pF;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pF;->dR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pF;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0841pF.class, Object.class), C0841pF.class, "weapon;itemId;count", "FIELD:Lcom/boehmod/blockfront/pF;->cd:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/pF;->dR:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/pF;->a:Ljava/lang/Integer;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: U */
    public String m3861U() {
        return this.f4539cd;
    }

    @Nullable
    /* JADX INFO: renamed from: z */
    public ResourceLocation m3862z() {
        return this.f4540dR;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Integer m3863a() {
        return this.f4541a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ItemStack m3860a(@NotNull C1097tw c1097tw, @NotNull Map<String, ItemStack> map) {
        if (this.f4540dR != null) {
            Item item = (Item) BuiltInRegistries.ITEM.getOptional(this.f4540dR).orElse(null);
            if (item == null) {
                C0530jM.logError("Class template slot references unknown item '%s'", this.f4540dR);
                return ItemStack.EMPTY;
            }
            return new ItemStack(item, this.f4541a != null ? this.f4541a.intValue() : 1);
        }
        if (this.f4539cd != null) {
            ItemStack itemStackM6160a = map.get(this.f4539cd);
            if (itemStackM6160a == null) {
                itemStackM6160a = c1097tw.m6160a(this.f4539cd);
            }
            if (itemStackM6160a == null) {
                C0530jM.logError("Nation '%s' arsenal has no weapon role '%s'", c1097tw.m6157av(), this.f4539cd);
                return ItemStack.EMPTY;
            }
            ItemStack itemStackCopy = itemStackM6160a.copy();
            if (this.f4541a != null) {
                itemStackCopy.setCount(this.f4541a.intValue());
            }
            return itemStackCopy;
        }
        C0530jM.logError("Class template slot defines neither 'weapon' nor 'id'", new Object[0]);
        return ItemStack.EMPTY;
    }
}
