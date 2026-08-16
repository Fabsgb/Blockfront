package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.PacketClientState;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.s */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/s.class */
public final class C0994s extends AbstractC0536jS<C0623l, C1101u> {

    /* JADX INFO: renamed from: B */
    public static final boolean f5457B = false;

    /* JADX INFO: renamed from: y */
    public static final int f5458y = 3;

    /* JADX INFO: renamed from: z */
    public static final int f5459z = 4;

    /* JADX INFO: renamed from: A */
    public static final int f5460A = 5;

    /* JADX INFO: renamed from: B */
    public static final int f5461B = 6;

    /* JADX INFO: renamed from: C */
    public static final int f5462C = 7;

    /* JADX INFO: renamed from: D */
    public static final int f5463D = 8;

    /* JADX INFO: renamed from: E */
    public static final int f5464E = 9;

    /* JADX INFO: renamed from: F */
    public static final int f5465F = 10;

    /* JADX INFO: renamed from: G */
    public static final int f5466G = 11;

    /* JADX INFO: renamed from: H */
    public static final int f5467H = 11;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final ObjectList<InterfaceC0009F<C0994s>> f5468b;

    /* JADX INFO: renamed from: I */
    private static final int f5469I = 5;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Int2ObjectMap<ObjectSet<String>> f5470a;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final ObjectList<c> f5471c;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0623l f5472b;

    /* JADX INFO: renamed from: C */
    private volatile boolean f5473C;

    /* JADX INFO: renamed from: D */
    private boolean f5474D;

    /* JADX INFO: renamed from: E */
    private volatile boolean f5475E;

    /* JADX INFO: renamed from: com.boehmod.blockfront.s$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/s$a.class */
    public enum a {
        RUNTIME,
        STARTUP,
        ALL
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.s$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/s$b.class */
    public enum b {
        LOUD,
        SILENT
    }

    public C0994s(@NotNull C0623l c0623l) {
        super(new C1101u());
        this.f5468b = new ObjectArrayList();
        this.f5470a = new Int2ObjectOpenHashMap();
        this.f5471c = new ObjectArrayList();
        this.f5473C = true;
        this.f5474D = false;
        this.f5475E = false;
        this.f5472b = c0623l;
        m5573a(new C1313y());
        m5573a(new C1207w());
        m5573a(new C0005B());
        m5573a(new C0006C());
        m5573a(new C0004A());
        m5573a(new C1260x());
        m5573a(new C0008E());
        m5573a(new C0007D());
        if (!Minecraft.ON_OSX) {
            m5573a(new C1331z());
        }
        new C1048t(c0623l, this).start();
    }

    /* JADX INFO: renamed from: i */
    public boolean m5570i() {
        return this.f5475E;
    }

    /* JADX INFO: renamed from: i */
    private void m5571i() {
        this.f5475E = true;
    }

    /* JADX INFO: renamed from: j */
    public void m5572j() {
        this.f5473C = true;
    }

    /* JADX INFO: renamed from: a */
    private void m5573a(@NotNull InterfaceC0009F<C0994s> interfaceC0009F) {
        this.f5468b.add(interfaceC0009F);
    }

    /* JADX INFO: renamed from: f */
    public int m5574f() {
        return this.f5468b.size();
    }

    /* JADX INFO: renamed from: i */
    private void m5575i(@NotNull Minecraft minecraft) {
        if (!m5570i() && m5577a(a.RUNTIME, minecraft)) {
            m5571i();
        }
    }

    /* JADX INFO: renamed from: k */
    public void m5576k() {
        if (!m5570i() && m5577a(a.STARTUP, Minecraft.getInstance())) {
            m5571i();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m5577a(@NotNull a aVar, @NotNull Minecraft minecraft) {
        ObjectListIterator it = this.f5468b.iterator();
        while (it.hasNext()) {
            InterfaceC0009F interfaceC0009F = (InterfaceC0009F) it.next();
            if (interfaceC0009F.mo11a() == aVar || interfaceC0009F.mo11a() == a.ALL) {
                if (C0549jf.f3277b.contains(interfaceC0009F.mo12g())) {
                    continue;
                } else {
                    String strMo14a = interfaceC0009F.mo14a(minecraft, this);
                    if (strMo14a == null) {
                        continue;
                    } else {
                        if (interfaceC0009F.mo13a() == b.LOUD) {
                            return true;
                        }
                        m5578a(interfaceC0009F.mo12g(), strMo14a);
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m5578a(int i, @NotNull String str) {
        ObjectSet objectSet = (ObjectSet) this.f5470a.computeIfAbsent(i, i2 -> {
            return new ObjectOpenHashSet();
        });
        if (objectSet.size() < 5 && objectSet.add(str)) {
            C0358g c0358g = (C0358g) this.f5472b.m2852b();
            if (!c0358g.m1722a().isVerified()) {
                this.f5471c.add(new c(i, str));
            } else {
                c0358g.sendPacket(new PacketClientState(i, str));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0536jS
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo2406b(@NotNull C0623l c0623l) {
        super.mo2406b(c0623l);
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft == null || minecraft.getOverlay() != null) {
            return;
        }
        if (minecraft.screen == null && minecraft.level == null) {
            return;
        }
        m5580d(c0623l);
        if (this.f5473C) {
            this.f5473C = false;
            m5576k();
        }
        m5575i(Minecraft.getInstance());
    }

    /* JADX INFO: renamed from: d */
    private void m5580d(@NotNull C0623l c0623l) {
        boolean zIsVerified = ((C0358g) c0623l.m2852b()).m1722a().isVerified();
        if (zIsVerified && !this.f5474D && !m5581j()) {
            this.f5470a.remove(10);
        }
        this.f5474D = zIsVerified;
    }

    /* JADX INFO: renamed from: j */
    private boolean m5581j() {
        if (this.f5471c.isEmpty()) {
            return false;
        }
        boolean z = false;
        C0358g c0358g = (C0358g) this.f5472b.m2852b();
        ObjectListIterator it = this.f5471c.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            c0358g.sendPacket(new PacketClientState(cVar.m5583g(), cVar.m5584g()));
            z |= cVar.m5583g() == 10;
        }
        this.f5471c.clear();
        return z;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.s$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/s$c.class */
    private static final class c extends Record {

        /* JADX INFO: renamed from: J */
        private final int f5476J;

        /* JADX INFO: renamed from: q */
        @NotNull
        private final String f5477q;

        private c(int i, @NotNull String str) {
            this.f5476J = i;
            this.f5477q = str;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "key;value", "FIELD:Lcom/boehmod/blockfront/s$c;->J:I", "FIELD:Lcom/boehmod/blockfront/s$c;->q:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "key;value", "FIELD:Lcom/boehmod/blockfront/s$c;->J:I", "FIELD:Lcom/boehmod/blockfront/s$c;->q:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "key;value", "FIELD:Lcom/boehmod/blockfront/s$c;->J:I", "FIELD:Lcom/boehmod/blockfront/s$c;->q:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: g */
        public int m5583g() {
            return this.f5476J;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public String m5584g() {
            return this.f5477q;
        }
    }
}
