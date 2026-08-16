package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.PacketClientRequest;
import com.boehmod.blockfront.AbstractC0531jN;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.EnumSet;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.jh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jh.class */
public class C0551jh<M extends AbstractC0531jN<?, ?, ?>> {

    /* JADX INFO: renamed from: lr */
    private static final int f3280lr = 120;

    /* JADX INFO: renamed from: ls */
    private static final int f3281ls = 10;

    /* JADX INFO: renamed from: lt */
    private static final int f3282lt = 6;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectLinkedOpenHashSet<a> f3283a = new ObjectLinkedOpenHashSet<>();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0549jf f3284a = new C0549jf();

    /* JADX INFO: renamed from: lu */
    private int f3285lu = 0;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final M f3286c;

    public C0551jh(@NotNull M m) {
        this.f3286c = m;
    }

    /* JADX INFO: renamed from: a */
    public void m2490a(@NotNull RequestType requestType, @NotNull UUID uuid) {
        this.f3283a.removeIf(aVar -> {
            return requestType == aVar.m2498a() && uuid.equals(aVar.m2499b());
        });
    }

    /* JADX INFO: renamed from: a */
    public void m2491a(@NotNull RequestType requestType) {
        this.f3283a.add(new a(requestType, null));
    }

    /* JADX INFO: renamed from: b */
    public void m2492b(@NotNull RequestType requestType, @NotNull UUID uuid) {
        this.f3283a.add(new a(requestType, uuid));
    }

    public void onUpdate() {
        int i = this.f3285lu;
        this.f3285lu = i - 1;
        if (i <= 0) {
            this.f3285lu = 120;
            m2493bj();
        }
    }

    /* JADX INFO: renamed from: bj */
    private void m2493bj() {
        int i = 0;
        while (!this.f3283a.isEmpty()) {
            int i2 = i;
            i++;
            if (i2 < 6) {
                m2494o(i);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: o */
    private void m2494o(int i) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < 10 && !this.f3283a.isEmpty(); i2++) {
            objectArrayList.add((a) this.f3283a.removeFirst());
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(RequestType.class);
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            UUID uuidM2499b = aVar.m2499b();
            RequestType requestTypeM2498a = aVar.m2498a();
            if (uuidM2499b == null) {
                enumSetNoneOf.add(requestTypeM2498a);
            } else {
                objectArrayList2.add(Map.entry(uuidM2499b, EnumSet.of(requestTypeM2498a)));
            }
        }
        this.f3286c.m2342b().sendPacket(new PacketClientRequest(enumSetNoneOf, objectArrayList2));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0549jf m2495a() {
        return this.f3284a;
    }

    /* JADX INFO: renamed from: bk */
    public void m2496bk() {
        this.f3285lu = 0;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.jh$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jh$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final RequestType f3287a;

        /* JADX INFO: renamed from: m */
        @Nullable
        private final UUID f3288m;

        private a(@NotNull RequestType requestType, @Nullable UUID uuid) {
            this.f3287a = requestType;
            this.f3288m = uuid;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "requestType;playerUUID", "FIELD:Lcom/boehmod/blockfront/jh$a;->a:Lcom/boehmod/bflib/cloud/common/RequestType;", "FIELD:Lcom/boehmod/blockfront/jh$a;->m:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "requestType;playerUUID", "FIELD:Lcom/boehmod/blockfront/jh$a;->a:Lcom/boehmod/bflib/cloud/common/RequestType;", "FIELD:Lcom/boehmod/blockfront/jh$a;->m:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "requestType;playerUUID", "FIELD:Lcom/boehmod/blockfront/jh$a;->a:Lcom/boehmod/bflib/cloud/common/RequestType;", "FIELD:Lcom/boehmod/blockfront/jh$a;->m:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public RequestType m2498a() {
            return this.f3287a;
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public UUID m2499b() {
            return this.f3288m;
        }
    }
}
