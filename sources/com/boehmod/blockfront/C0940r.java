package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.r */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/r.class */
public final class C0940r extends AbstractC0568jz<C0622l, C1047t> {

    /* JADX INFO: renamed from: z */
    private static final boolean f5002z = false;

    /* JADX INFO: renamed from: A */
    public static final boolean f5003A = false;

    /* JADX INFO: renamed from: B */
    public static boolean f5004B = false;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final ObjectList<InterfaceC1305z<C0940r>> f5005b;

    /* JADX INFO: renamed from: C */
    private boolean f5006C;

    /* JADX INFO: renamed from: D */
    private boolean f5007D;

    /* JADX INFO: renamed from: com.boehmod.blockfront.r$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/r$a.class */
    public enum a {
        RUNTIME,
        STARTUP,
        ALL
    }

    public C0940r(@NotNull C0622l c0622l) {
        super(new C1047t());
        this.f5005b = new ObjectArrayList();
        this.f5006C = true;
        this.f5007D = false;
        m5136a(new C1100u());
        m5136a(new C1153v());
        m5136a(new C1259x());
        m5136a(new C1304y());
        m5136a(new C1206w());
        new C0993s(c0622l, this).start();
    }

    /* JADX INFO: renamed from: i */
    public boolean m5133i() {
        return this.f5007D;
    }

    /* JADX INFO: renamed from: b */
    private void m5134b(boolean z) {
        this.f5007D = z;
    }

    /* JADX INFO: renamed from: h */
    public void m5135h() {
        this.f5006C = true;
    }

    /* JADX INFO: renamed from: a */
    private void m5136a(@NotNull InterfaceC1305z<C0940r> interfaceC1305z) {
        this.f5005b.add(interfaceC1305z);
    }

    /* JADX INFO: renamed from: i */
    private void m5137i(@NotNull Minecraft minecraft) {
        if (!m5133i() && m5139a(a.RUNTIME, minecraft)) {
            m5134b(true);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m5138i() {
        if (!m5133i() && m5139a(a.STARTUP, Minecraft.getInstance())) {
            m5134b(true);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m5139a(@NotNull a aVar, @NotNull Minecraft minecraft) {
        ObjectListIterator it = this.f5005b.iterator();
        while (it.hasNext()) {
            InterfaceC1305z interfaceC1305z = (InterfaceC1305z) it.next();
            if (interfaceC1305z.mo6057a() == aVar || interfaceC1305z.mo6057a() == a.ALL) {
                if (interfaceC1305z.mo6058a(minecraft, this)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0568jz
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo2581b(@NotNull C0622l c0622l) {
        super.mo2581b(c0622l);
        if (f5004B) {
            if (this.f5006C) {
                this.f5006C = false;
                m5138i();
            }
            m5137i(Minecraft.getInstance());
        }
    }
}
