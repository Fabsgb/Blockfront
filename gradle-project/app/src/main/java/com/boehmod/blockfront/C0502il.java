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

/* JADX INFO: renamed from: com.boehmod.blockfront.il */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/il.class */
public class C0502il {

    /* JADX INFO: renamed from: L */
    @NotNull
    private final ObjectList<a> f3100L = new ObjectArrayList();

    private C0502il() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0502il m2254a() {
        return new C0502il();
    }

    /* JADX INFO: renamed from: a */
    public C0502il m2255a(@NotNull EnumC1203vw enumC1203vw) {
        this.f3100L.add(new a(enumC1203vw, false, false, 0));
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0502il m2256b(@NotNull EnumC1203vw enumC1203vw) {
        this.f3100L.add(new a(enumC1203vw, false, true, 0));
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0502il m2257c(@NotNull EnumC1203vw enumC1203vw) {
        this.f3100L.add(new a(enumC1203vw, true, false, 0));
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0502il m2258d(@NotNull EnumC1203vw enumC1203vw) {
        this.f3100L.add(new a(enumC1203vw, true, true, 0));
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0502il m2259a(int i) {
        this.f3100L.add(new a(null, false, false, i * 20));
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m2260a(@NotNull C0501ik c0501ik, @NotNull Minecraft minecraft) {
        c0501ik.m2251a(new ArrayDeque((Collection) this.f3100L));
        c0501ik.m2252u(minecraft);
    }

    /* JADX INFO: renamed from: c */
    public void m2261c(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f3100L.size());
        ObjectListIterator it = this.f3100L.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            friendlyByteBuf.writeBoolean(aVar.f3101a != null);
            if (aVar.f3101a != null) {
                friendlyByteBuf.writeInt(aVar.f3101a.ordinal());
            }
            friendlyByteBuf.writeBoolean(aVar.f3102cU);
            friendlyByteBuf.writeBoolean(aVar.f3103cV);
            friendlyByteBuf.writeInt(aVar.f3104kL);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0502il m2262a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0502il c0502il = new C0502il();
        int i = friendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            c0502il.f3100L.add(new a(friendlyByteBuf.readBoolean() ? EnumC1203vw.values()[friendlyByteBuf.readInt()] : null, friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt()));
        }
        return c0502il;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.il$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/il$a.class */
    public static class a {

        /* JADX INFO: renamed from: a */
        @Nullable
        public final EnumC1203vw f3101a;

        /* JADX INFO: renamed from: cU */
        public final boolean f3102cU;

        /* JADX INFO: renamed from: cV */
        public final boolean f3103cV;

        /* JADX INFO: renamed from: kL */
        public final int f3104kL;

        a(@Nullable EnumC1203vw enumC1203vw, boolean z, boolean z2, int i) {
            this.f3101a = enumC1203vw;
            this.f3102cU = z;
            this.f3103cV = z2;
            this.f3104kL = i;
        }
    }
}
