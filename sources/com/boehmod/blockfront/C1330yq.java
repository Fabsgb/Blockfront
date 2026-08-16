package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMChatReport;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.yq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yq.class */
public class C1330yq {

    /* JADX INFO: renamed from: eV */
    @NotNull
    public static final String f9071eV = "bf:chat_report/";

    /* JADX INFO: renamed from: wD */
    private static final int f9072wD = 256;

    /* JADX INFO: renamed from: wE */
    private static final int f9073wE = 8;

    /* JADX INFO: renamed from: ad */
    private static final long f9074ad = 10000;

    /* JADX INFO: renamed from: ae */
    private static final long f9075ae = 1800000;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final DateTimeFormatter f9076b = DateTimeFormatter.ofPattern("HH:mm:ss");

    /* JADX INFO: renamed from: kw */
    @NotNull
    private static final Component f9077kw = Component.translatable("bf.message.chat.report.submitted").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: kx */
    @NotNull
    private static final Component f9078kx = Component.translatable("bf.message.chat.report.cooldown").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ky */
    @NotNull
    private static final Component f9079ky = Component.translatable("bf.message.chat.report.invalid").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Object2ObjectLinkedOpenHashMap<UUID, a> f9080b = new Object2ObjectLinkedOpenHashMap<>();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Object2LongOpenHashMap<UUID> f9081a = new Object2LongOpenHashMap<>();

    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID m8306a(@NotNull UUID uuid, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set, @NotNull String str3) {
        UUID uuidRandomUUID = UUID.randomUUID();
        this.f9080b.putAndMoveToLast(uuidRandomUUID, new a(uuidRandomUUID, uuid, str, str2, System.currentTimeMillis(), f9076b.format(LocalTime.now()), new ObjectOpenHashSet(set), new ObjectOpenHashSet(), str3));
        while (this.f9080b.size() > 256) {
            this.f9080b.removeFirst();
        }
        return uuidRandomUUID;
    }

    /* JADX INFO: renamed from: a */
    public void m8307a(@NotNull C1280xT c1280xT, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        if (c1280xT.mo2374f()) {
            UUID uuid2 = serverPlayer.getUUID();
            a aVar = (a) this.f9080b.get(uuid);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (aVar == null || jCurrentTimeMillis - aVar.m8314n() > f9075ae) {
                C0875pn.m4405a(ChatGraphic.WARNING, serverPlayer, f9079ky);
                return;
            }
            if (!aVar.m8316n().contains(uuid2) || aVar.m8311t().equals(uuid2)) {
                return;
            }
            if (aVar.m8317o().contains(uuid2)) {
                C0875pn.m4405a(ChatGraphic.QUESTION, serverPlayer, f9077kw);
                return;
            }
            if (jCurrentTimeMillis - this.f9081a.getLong(uuid2) < f9074ad) {
                C0875pn.m4405a(ChatGraphic.WARNING, serverPlayer, f9078kx);
                return;
            }
            aVar.m8317o().add(uuid2);
            this.f9081a.put(uuid2, jCurrentTimeMillis);
            C0530jM.log("[ChatReport] '%s' reported message '%s' from '%s'", serverPlayer.getScoreboardName(), uuid, aVar.m8312aP());
            ((C1278xR) c1280xT.m7289b()).sendPacket(new PacketMMChatReport(uuid2, uuid, aVar.m8311t(), aVar.m8312aP(), aVar.m8313aD(), m8308a(aVar), aVar.m8318ah()));
            C0875pn.m4405a(ChatGraphic.QUESTION, serverPlayer, f9077kw);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private ObjectList<String> m8308a(@NotNull a aVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectIterator it = this.f9080b.values().iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            if (aVar2 != aVar && aVar2.m8318ah().equals(aVar.m8318ah())) {
                objectArrayList.add(m8309a(aVar2));
                if (objectArrayList.size() > 8) {
                    objectArrayList.removeFirst();
                }
            }
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m8309a(@NotNull a aVar) {
        return aVar.m8315aQ() + " " + aVar.m8312aP() + ": " + aVar.m8313aD();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.yq$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yq$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: ab */
        @NotNull
        private final UUID f9082ab;

        /* JADX INFO: renamed from: ac */
        @NotNull
        private final UUID f9083ac;

        /* JADX INFO: renamed from: eW */
        @NotNull
        private final String f9084eW;

        /* JADX INFO: renamed from: eX */
        @NotNull
        private final String f9085eX;

        /* JADX INFO: renamed from: af */
        private final long f9086af;

        /* JADX INFO: renamed from: eY */
        @NotNull
        private final String f9087eY;

        /* JADX INFO: renamed from: v */
        @NotNull
        private final Set<UUID> f9088v;

        /* JADX INFO: renamed from: w */
        @NotNull
        private final Set<UUID> f9089w;

        /* JADX INFO: renamed from: eZ */
        @NotNull
        private final String f9090eZ;

        private a(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull String str, @NotNull String str2, long j, @NotNull String str3, @NotNull Set<UUID> set, @NotNull Set<UUID> set2, @NotNull String str4) {
            this.f9082ab = uuid;
            this.f9083ac = uuid2;
            this.f9084eW = str;
            this.f9085eX = str2;
            this.f9086af = j;
            this.f9087eY = str3;
            this.f9088v = set;
            this.f9089w = set2;
            this.f9090eZ = str4;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "messageUUID;senderUUID;senderName;message;timestamp;timeLabel;recipients;reporters;gameName", "FIELD:Lcom/boehmod/blockfront/yq$a;->ab:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/yq$a;->ac:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eW:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eX:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->af:J", "FIELD:Lcom/boehmod/blockfront/yq$a;->eY:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->v:Ljava/util/Set;", "FIELD:Lcom/boehmod/blockfront/yq$a;->w:Ljava/util/Set;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eZ:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "messageUUID;senderUUID;senderName;message;timestamp;timeLabel;recipients;reporters;gameName", "FIELD:Lcom/boehmod/blockfront/yq$a;->ab:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/yq$a;->ac:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eW:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eX:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->af:J", "FIELD:Lcom/boehmod/blockfront/yq$a;->eY:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->v:Ljava/util/Set;", "FIELD:Lcom/boehmod/blockfront/yq$a;->w:Ljava/util/Set;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eZ:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "messageUUID;senderUUID;senderName;message;timestamp;timeLabel;recipients;reporters;gameName", "FIELD:Lcom/boehmod/blockfront/yq$a;->ab:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/yq$a;->ac:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eW:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eX:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->af:J", "FIELD:Lcom/boehmod/blockfront/yq$a;->eY:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/yq$a;->v:Ljava/util/Set;", "FIELD:Lcom/boehmod/blockfront/yq$a;->w:Ljava/util/Set;", "FIELD:Lcom/boehmod/blockfront/yq$a;->eZ:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: q */
        public UUID m8310q() {
            return this.f9082ab;
        }

        @NotNull
        /* JADX INFO: renamed from: t */
        public UUID m8311t() {
            return this.f9083ac;
        }

        @NotNull
        /* JADX INFO: renamed from: aP */
        public String m8312aP() {
            return this.f9084eW;
        }

        @NotNull
        /* JADX INFO: renamed from: aD */
        public String m8313aD() {
            return this.f9085eX;
        }

        /* JADX INFO: renamed from: n */
        public long m8314n() {
            return this.f9086af;
        }

        @NotNull
        /* JADX INFO: renamed from: aQ */
        public String m8315aQ() {
            return this.f9087eY;
        }

        @NotNull
        /* JADX INFO: renamed from: n */
        public Set<UUID> m8316n() {
            return this.f9088v;
        }

        @NotNull
        /* JADX INFO: renamed from: o */
        public Set<UUID> m8317o() {
            return this.f9089w;
        }

        @NotNull
        /* JADX INFO: renamed from: ah */
        public String m8318ah() {
            return this.f9090eZ;
        }
    }
}
