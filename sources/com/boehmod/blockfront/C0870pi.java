package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.pi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pi.class */
public final class C0870pi extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final CompoundTag f4750a;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0870pi.class), C0870pi.class, "tag", "FIELD:Lcom/boehmod/blockfront/pi;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0870pi.class), C0870pi.class, "tag", "FIELD:Lcom/boehmod/blockfront/pi;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0870pi.class, Object.class), C0870pi.class, "tag", "FIELD:Lcom/boehmod/blockfront/pi;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public C0870pi() {
        this(new CompoundTag());
    }

    public C0870pi(@NotNull CompoundTag compoundTag) {
        this.f4750a = compoundTag;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public CompoundTag m4287a() {
        return this.f4750a;
    }

    /* JADX INFO: renamed from: h */
    public boolean m4288h(@NotNull String str) {
        return this.f4750a.contains(str);
    }

    /* JADX INFO: renamed from: a */
    public int m4289a(@NotNull String str) {
        return this.f4750a.getInt(str);
    }

    /* JADX INFO: renamed from: a */
    public int m4290a(@NotNull String str, int i) {
        return this.f4750a.contains(str) ? this.f4750a.getInt(str) : i;
    }

    /* JADX INFO: renamed from: a */
    public void m4291a(@NotNull String str, int i) {
        this.f4750a.putInt(str, i);
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public String m4292l(@NotNull String str) {
        if (this.f4750a.contains(str)) {
            return this.f4750a.getString(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m4293a(@NotNull String str, @NotNull String str2) {
        this.f4750a.putString(str, str2);
    }

    /* JADX INFO: renamed from: x */
    public void m4294x(@NotNull String str) {
        this.f4750a.remove(str);
    }

    /* JADX INFO: renamed from: e */
    public void m4295e() {
        ObjectListIterator it = new ObjectArrayList(this.f4750a.getAllKeys()).iterator();
        while (it.hasNext()) {
            this.f4750a.remove((String) it.next());
        }
    }
}
