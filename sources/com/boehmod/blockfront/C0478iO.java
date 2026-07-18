package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.PacketClientRequest;
import com.boehmod.blockfront.AbstractC0563ju;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.iO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iO.class */
public class C0478iO<M extends AbstractC0563ju<?, ?, ?>> {

    /* JADX INFO: renamed from: jK */
    private static final int f2929jK = 120;

    /* JADX INFO: renamed from: jL */
    private static final int f2930jL = 10;

    /* JADX INFO: renamed from: jM */
    private static final int f2931jM = 6;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectLinkedOpenHashSet<a> f2932a = new ObjectLinkedOpenHashSet<>();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0476iM f2933a = new C0476iM();

    /* JADX INFO: renamed from: jN */
    private int f2934jN = 0;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final M f2935c;

    public C0478iO(@NotNull M m) {
        this.f2935c = m;
    }

    /* JADX INFO: renamed from: a */
    public void m2163a(@NotNull RequestType requestType, @NotNull UUID uuid) {
        this.f2932a.removeIf(aVar -> {
            return requestType == aVar.m2171a() && uuid.equals(aVar.m2172b());
        });
    }

    /* JADX INFO: renamed from: a */
    public void m2164a(@NotNull RequestType requestType) {
        this.f2932a.add(new a(requestType, null));
    }

    /* JADX INFO: renamed from: b */
    public void m2165b(@NotNull RequestType requestType, @NotNull UUID uuid) {
        this.f2932a.add(new a(requestType, uuid));
    }

    public void onUpdate() {
        int i = this.f2934jN;
        this.f2934jN = i - 1;
        if (i <= 0) {
            this.f2934jN = 120;
            m2166aX();
        }
    }

    /* JADX INFO: renamed from: aX */
    private void m2166aX() {
        int i = 0;
        while (!this.f2932a.isEmpty()) {
            int i2 = i;
            i++;
            if (i2 < 6) {
                m2167n(i);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: n */
    private void m2167n(int i) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < 10 && !this.f2932a.isEmpty(); i2++) {
            objectArrayList.add((a) this.f2932a.removeFirst());
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(RequestType.class);
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            UUID uuidM2172b = aVar.m2172b();
            RequestType requestTypeM2171a = aVar.m2171a();
            if (uuidM2172b == null) {
                enumSetNoneOf.add(requestTypeM2171a);
            } else {
                objectArrayList2.add(Map.entry(uuidM2172b, EnumSet.of(requestTypeM2171a)));
            }
        }
        this.f2935c.m2520b().sendPacket(new PacketClientRequest(enumSetNoneOf, objectArrayList2));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0476iM m2168a() {
        return this.f2933a;
    }

    /* JADX INFO: renamed from: aY */
    public void m2169aY() {
        this.f2934jN = 0;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.iO$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iO$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final RequestType f2936a;

        /* JADX INFO: renamed from: m */
        @Nullable
        private final UUID f2937m;

        private a(@NotNull RequestType requestType, @Nullable UUID uuid) {
            this.f2936a = requestType;
            this.f2937m = uuid;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "requestType;playerUUID", "FIELD:Lcom/boehmod/blockfront/iO$a;->a:Lcom/boehmod/bflib/cloud/common/RequestType;", "FIELD:Lcom/boehmod/blockfront/iO$a;->m:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "requestType;playerUUID", "FIELD:Lcom/boehmod/blockfront/iO$a;->a:Lcom/boehmod/bflib/cloud/common/RequestType;", "FIELD:Lcom/boehmod/blockfront/iO$a;->m:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "requestType;playerUUID", "FIELD:Lcom/boehmod/blockfront/iO$a;->a:Lcom/boehmod/bflib/cloud/common/RequestType;", "FIELD:Lcom/boehmod/blockfront/iO$a;->m:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public RequestType m2171a() {
            return this.f2936a;
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public UUID m2172b() {
            return this.f2937m;
        }
    }
}
