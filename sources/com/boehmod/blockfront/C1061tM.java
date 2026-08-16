package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerStatExtra;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValueBatch;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tM.class */
public final class C1061tM {

    /* JADX INFO: renamed from: ty */
    private static final int f5731ty = 100;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Object2IntOpenHashMap<a> f5732a = new Object2IntOpenHashMap<>();

    /* JADX INFO: renamed from: tz */
    private int f5733tz = 0;

    /* JADX INFO: renamed from: com.boehmod.blockfront.tM$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tM$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: D */
        @NotNull
        private final UUID f5734D;

        /* JADX INFO: renamed from: dj */
        @NotNull
        private final String f5735dj;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final PlayerStatExtra f5736a;

        private a(@NotNull UUID uuid, @NotNull String str, @NotNull PlayerStatExtra playerStatExtra) {
            this.f5734D = uuid;
            this.f5735dj = str;
            this.f5736a = playerStatExtra;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "playerUUID;value;extra", "FIELD:Lcom/boehmod/blockfront/tM$a;->D:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/tM$a;->dj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/tM$a;->a:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "playerUUID;value;extra", "FIELD:Lcom/boehmod/blockfront/tM$a;->D:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/tM$a;->dj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/tM$a;->a:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "playerUUID;value;extra", "FIELD:Lcom/boehmod/blockfront/tM$a;->D:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/tM$a;->dj:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/tM$a;->a:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public UUID m5890b() {
            return this.f5734D;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public String m5891g() {
            return this.f5735dj;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public PlayerStatExtra m5892a() {
            return this.f5736a;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5887a(@NotNull UUID uuid, @NotNull String str, int i, @NotNull PlayerStatExtra playerStatExtra) {
        this.f5732a.addTo(new a(uuid, str, playerStatExtra), i);
    }

    /* JADX INFO: renamed from: a */
    public void m5888a(@NotNull AbstractC0546jc<?> abstractC0546jc) {
        int i = this.f5733tz + 1;
        this.f5733tz = i;
        if (i < 100) {
            return;
        }
        this.f5733tz = 0;
        m5889b(abstractC0546jc);
    }

    /* JADX INFO: renamed from: b */
    public void m5889b(@NotNull AbstractC0546jc<?> abstractC0546jc) {
        if (this.f5732a.isEmpty()) {
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(this.f5732a.size());
        ObjectIterator it = this.f5732a.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            a aVar = (a) entry.getKey();
            objectArrayList.add(new PacketPlayerDataIncreaseValueBatch.Entry(aVar.m5892a(), aVar.m5890b(), aVar.m5891g(), entry.getIntValue()));
        }
        this.f5732a.clear();
        abstractC0546jc.sendPacket(new PacketPlayerDataIncreaseValueBatch((List<PacketPlayerDataIncreaseValueBatch.Entry>) objectArrayList));
    }
}
