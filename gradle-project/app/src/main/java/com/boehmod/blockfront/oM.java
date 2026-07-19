package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oM.class */
public final class oM extends Record {

    @NotNull
    private final CompoundTag a;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, oM.class), oM.class, "tag", "FIELD:Lcom/boehmod/blockfront/oM;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, oM.class), oM.class, "tag", "FIELD:Lcom/boehmod/blockfront/oM;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, oM.class, Object.class), oM.class, "tag", "FIELD:Lcom/boehmod/blockfront/oM;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public oM() {
        this(new CompoundTag());
    }

    public oM(@NotNull CompoundTag compoundTag) {
        this.a = compoundTag;
    }

    @NotNull
    public CompoundTag a() {
        return this.a;
    }

    public boolean f(@NotNull String str) {
        return this.a.contains(str);
    }

    public int a(@NotNull String str) {
        return this.a.getInt(str);
    }

    public int a(@NotNull String str, int i) {
        return this.a.contains(str) ? this.a.getInt(str) : i;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m787a(@NotNull String str, int i) {
        this.a.putInt(str, i);
    }

    @Nullable
    public String l(@NotNull String str) {
        if (this.a.contains(str)) {
            return this.a.getString(str);
        }
        return null;
    }

    public void a(@NotNull String str, @NotNull String str2) {
        this.a.putString(str, str2);
    }

    public void x(@NotNull String str) {
        this.a.remove(str);
    }

    public void e() {
        ObjectListIterator it = new ObjectArrayList(this.a.getAllKeys()).iterator();
        while (it.hasNext()) {
            this.a.remove((String) it.next());
        }
    }
}
