package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayDeque;
import java.util.Collection;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.hU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hU.class */
public class C0431hU {

    /* JADX INFO: renamed from: C */
    @NotNull
    private final ObjectList<a> f2798C = new ObjectArrayList();

    private C0431hU() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0431hU m2020a() {
        return new C0431hU();
    }

    /* JADX INFO: renamed from: a */
    public C0431hU m2021a(@NotNull EnumC1123uW enumC1123uW) {
        this.f2798C.add(new a(enumC1123uW, false, false, 0));
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0431hU m2022b(@NotNull EnumC1123uW enumC1123uW) {
        this.f2798C.add(new a(enumC1123uW, false, true, 0));
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0431hU m2023c(@NotNull EnumC1123uW enumC1123uW) {
        this.f2798C.add(new a(enumC1123uW, true, false, 0));
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0431hU m2024d(@NotNull EnumC1123uW enumC1123uW) {
        this.f2798C.add(new a(enumC1123uW, true, true, 0));
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0431hU m2025a(int i) {
        this.f2798C.add(new a(null, false, false, i * 20));
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m2026a(@NotNull C0430hT c0430hT, @NotNull Minecraft minecraft) {
        c0430hT.m2017a(new ArrayDeque((Collection) this.f2798C));
        c0430hT.m2018t(minecraft);
    }

    /* JADX INFO: renamed from: c */
    public void m2027c(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f2798C.size());
        ObjectListIterator it = this.f2798C.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            friendlyByteBuf.writeBoolean(aVar.f2799a != null);
            if (aVar.f2799a != null) {
                friendlyByteBuf.writeInt(aVar.f2799a.ordinal());
            }
            friendlyByteBuf.writeBoolean(aVar.f2800cL);
            friendlyByteBuf.writeBoolean(aVar.f2801cM);
            friendlyByteBuf.writeInt(aVar.f2802jq);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0431hU m2028a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0431hU c0431hU = new C0431hU();
        int i = friendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            c0431hU.f2798C.add(new a(friendlyByteBuf.readBoolean() ? EnumC1123uW.values()[friendlyByteBuf.readInt()] : null, friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt()));
        }
        return c0431hU;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.hU$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hU$a.class */
    public static class a {

        /* JADX INFO: renamed from: a */
        @Nullable
        public final EnumC1123uW f2799a;

        /* JADX INFO: renamed from: cL */
        public final boolean f2800cL;

        /* JADX INFO: renamed from: cM */
        public final boolean f2801cM;

        /* JADX INFO: renamed from: jq */
        public final int f2802jq;

        a(@Nullable EnumC1123uW enumC1123uW, boolean z, boolean z2, int i) {
            this.f2799a = enumC1123uW;
            this.f2800cL = z;
            this.f2801cM = z2;
            this.f2802jq = i;
        }
    }
}
