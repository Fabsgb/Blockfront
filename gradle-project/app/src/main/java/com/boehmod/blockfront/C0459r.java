package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/r.class */
public final class C0459r extends AbstractC0269jz<C0297l, C0513t> {
    private static final boolean z = false;
    public static final boolean A = false;
    public static boolean B = false;

    @NotNull
    private final ObjectList<InterfaceC0641z<C0459r>> b;
    private boolean C;
    private boolean D;

    /* JADX INFO: renamed from: com.boehmod.blockfront.r$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/r$a.class */
    public enum a {
        RUNTIME,
        STARTUP,
        ALL
    }

    public C0459r(@NotNull C0297l c0297l) {
        super(new C0513t());
        this.b = new ObjectArrayList();
        this.C = true;
        this.D = false;
        a(new C0540u());
        a(new C0567v());
        a(new C0621x());
        a(new C0640y());
        a(new C0594w());
        new C0486s(c0297l, this).start();
    }

    public boolean i() {
        return this.D;
    }

    private void b(boolean z2) {
        this.D = z2;
    }

    public void h() {
        this.C = true;
    }

    private void a(@NotNull InterfaceC0641z<C0459r> interfaceC0641z) {
        this.b.add(interfaceC0641z);
    }

    private void i(@NotNull Minecraft minecraft) {
        if (!i() && a(a.RUNTIME, minecraft)) {
            b(true);
        }
    }

    /* JADX INFO: renamed from: i, reason: collision with other method in class */
    public void m1019i() {
        if (!i() && a(a.STARTUP, Minecraft.getInstance())) {
            b(true);
        }
    }

    private boolean a(@NotNull a aVar, @NotNull Minecraft minecraft) {
        ObjectListIterator it = this.b.iterator();
        while (it.hasNext()) {
            InterfaceC0641z interfaceC0641z = (InterfaceC0641z) it.next();
            if (interfaceC0641z.mo1294a() == aVar || interfaceC0641z.mo1294a() == a.ALL) {
                if (interfaceC0641z.a(minecraft, this)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0269jz
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull C0297l c0297l) {
        super.b(c0297l);
        if (B) {
            if (this.C) {
                this.C = false;
                m1019i();
            }
            i(Minecraft.getInstance());
        }
    }
}
