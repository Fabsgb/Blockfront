package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.oM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oM.class */
public final class C0794oM extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final CompoundTag f4354a;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0794oM.class), C0794oM.class, "tag", "FIELD:Lcom/boehmod/blockfront/oM;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0794oM.class), C0794oM.class, "tag", "FIELD:Lcom/boehmod/blockfront/oM;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0794oM.class, Object.class), C0794oM.class, "tag", "FIELD:Lcom/boehmod/blockfront/oM;->a:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public C0794oM() {
        this(new CompoundTag());
    }

    public C0794oM(@NotNull CompoundTag compoundTag) {
        this.f4354a = compoundTag;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public CompoundTag m3851a() {
        return this.f4354a;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3852f(@NotNull String str) {
        return this.f4354a.contains(str);
    }

    /* JADX INFO: renamed from: a */
    public int m3853a(@NotNull String str) {
        return this.f4354a.getInt(str);
    }

    /* JADX INFO: renamed from: a */
    public int m3854a(@NotNull String str, int i) {
        return this.f4354a.contains(str) ? this.f4354a.getInt(str) : i;
    }

    /* JADX INFO: renamed from: a */
    public void m3855a(@NotNull String str, int i) {
        this.f4354a.putInt(str, i);
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public String m3856l(@NotNull String str) {
        if (this.f4354a.contains(str)) {
            return this.f4354a.getString(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m3857a(@NotNull String str, @NotNull String str2) {
        this.f4354a.putString(str, str2);
    }

    /* JADX INFO: renamed from: x */
    public void m3858x(@NotNull String str) {
        this.f4354a.remove(str);
    }

    /* JADX INFO: renamed from: e */
    public void m3859e() {
        ObjectListIterator it = new ObjectArrayList(this.f4354a.getAllKeys()).iterator();
        while (it.hasNext()) {
            this.f4354a.remove((String) it.next());
        }
    }
}
