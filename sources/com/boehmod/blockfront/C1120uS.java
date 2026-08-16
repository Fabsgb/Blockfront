package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uS.class */
public final class C1120uS extends Record {

    /* JADX INFO: renamed from: uo */
    private final int f6142uo;

    /* JADX INFO: renamed from: cg */
    @NotNull
    private final List<C1115uN> f6143cg;

    /* JADX INFO: renamed from: ch */
    @NotNull
    private final List<C1114uM> f6144ch;

    public C1120uS(int i, @NotNull List<C1115uN> list, @NotNull List<C1114uM> list2) {
        this.f6142uo = i;
        this.f6143cg = list;
        this.f6144ch = list2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1120uS.class), C1120uS.class, "pelletIndex;entityHits;blockHits", "FIELD:Lcom/boehmod/blockfront/uS;->uo:I", "FIELD:Lcom/boehmod/blockfront/uS;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uS;->ch:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1120uS.class), C1120uS.class, "pelletIndex;entityHits;blockHits", "FIELD:Lcom/boehmod/blockfront/uS;->uo:I", "FIELD:Lcom/boehmod/blockfront/uS;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uS;->ch:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1120uS.class, Object.class), C1120uS.class, "pelletIndex;entityHits;blockHits", "FIELD:Lcom/boehmod/blockfront/uS;->uo:I", "FIELD:Lcom/boehmod/blockfront/uS;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/uS;->ch:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cs */
    public int m6410cs() {
        return this.f6142uo;
    }

    @NotNull
    /* JADX INFO: renamed from: aH */
    public List<C1115uN> m6411aH() {
        return this.f6143cg;
    }

    @NotNull
    /* JADX INFO: renamed from: aI */
    public List<C1114uM> m6412aI() {
        return this.f6144ch;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1120uS m6408a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C1120uS(friendlyByteBuf.readVarInt(), C1271xK.m7206b(friendlyByteBuf), C1271xK.m7204a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: a */
    public void m6409a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVarInt(this.f6142uo);
        C1271xK.m7207b(friendlyByteBuf, this.f6143cg);
        C1271xK.m7205a(friendlyByteBuf, this.f6144ch);
    }
}
