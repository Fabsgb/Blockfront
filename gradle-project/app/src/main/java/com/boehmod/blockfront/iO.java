package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.PacketClientRequest;
import com.boehmod.blockfront.AbstractC0264ju;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iO.class */
public class iO<M extends AbstractC0264ju<?, ?, ?>> {
    private static final int jK = 120;
    private static final int jL = 10;
    private static final int jM = 6;

    @NotNull
    private final ObjectLinkedOpenHashSet<a> a = new ObjectLinkedOpenHashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final iM f171a = new iM();
    private int jN = 0;

    @NotNull
    private final M c;

    public iO(@NotNull M m) {
        this.c = m;
    }

    public void a(@NotNull RequestType requestType, @NotNull UUID uuid) {
        this.a.removeIf(aVar -> {
            return requestType == aVar.a() && uuid.equals(aVar.b());
        });
    }

    public void a(@NotNull RequestType requestType) {
        this.a.add(new a(requestType, null));
    }

    public void b(@NotNull RequestType requestType, @NotNull UUID uuid) {
        this.a.add(new a(requestType, uuid));
    }

    public void onUpdate() {
        int i = this.jN;
        this.jN = i - 1;
        if (i <= 0) {
            this.jN = 120;
            aX();
        }
    }

    private void aX() {
        int i = 0;
        while (!this.a.isEmpty()) {
            int i2 = i;
            i++;
            if (i2 < 6) {
                n(i);
            } else {
                return;
            }
        }
    }

    private void n(int i) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < 10 && !this.a.isEmpty(); i2++) {
            objectArrayList.add((a) this.a.removeFirst());
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(RequestType.class);
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            UUID uuidB = aVar.b();
            RequestType requestTypeA = aVar.a();
            if (uuidB == null) {
                enumSetNoneOf.add(requestTypeA);
            } else {
                objectArrayList2.add(Map.entry(uuidB, EnumSet.of(requestTypeA)));
            }
        }
        this.c.m529b().sendPacket(new PacketClientRequest(enumSetNoneOf, objectArrayList2));
    }

    @NotNull
    public iM a() {
        return this.f171a;
    }

    public void aY() {
        this.jN = 0;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iO$a.class */
    private static final class a extends Record {

        @NotNull
        private final RequestType a;

        @Nullable
        private final UUID m;

        private a(@NotNull RequestType requestType, @Nullable UUID uuid) {
            this.a = requestType;
            this.m = uuid;
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
        public RequestType a() {
            return this.a;
        }

        @Nullable
        public UUID b() {
            return this.m;
        }
    }
}
