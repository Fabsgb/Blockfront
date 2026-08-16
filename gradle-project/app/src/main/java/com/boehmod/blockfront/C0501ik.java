package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayDeque;
import java.util.Queue;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ik */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ik.class */
public class C0501ik {

    /* JADX INFO: renamed from: K */
    @NotNull
    private final ObjectList<C0513iw> f3095K = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private Queue<C0502il.a> f3096a = new ArrayDeque();

    /* JADX INFO: renamed from: kK */
    private int f3097kK = 0;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0513iw f3098a = null;

    /* JADX INFO: renamed from: cT */
    static final /* synthetic */ boolean f3099cT;

    static {
        f3099cT = !C0501ik.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: c */
    public void m2248c(@NotNull C0623l c0623l) {
        this.f3095K.removeIf((v0) -> {
            return v0.isStopped();
        });
        m2249g(c0623l);
    }

    /* JADX INFO: renamed from: g */
    private void m2249g(@NotNull C0623l c0623l) {
        if (c0623l.m2874a() == null) {
            m2253aY();
            return;
        }
        if (this.f3097kK > 0) {
            this.f3097kK--;
        } else if (this.f3098a == null || this.f3098a.m2292V()) {
            m2252u(Minecraft.getInstance());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2250a(@NotNull Minecraft minecraft, @NotNull EnumC1203vw enumC1203vw, boolean z, boolean z2) {
        if (z2) {
            m2253aY();
        }
        this.f3096a.add(new C0502il.a(enumC1203vw, z, z2, 0));
        if (this.f3098a == null) {
            m2252u(minecraft);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2251a(@NotNull Queue<C0502il.a> queue) {
        this.f3096a = queue;
    }

    /* JADX INFO: renamed from: u */
    public void m2252u(@NotNull Minecraft minecraft) {
        C1204vx c1204vxM6052a;
        C0502il.a aVarPoll;
        SoundEvent soundEventM6894a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3099cT && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a == null || (c1204vxM6052a = abstractC0863pbM2874a.m4027a().m6052a()) == null || this.f3096a.isEmpty() || (aVarPoll = this.f3096a.poll()) == null) {
            return;
        }
        if (aVarPoll.f3104kL > 0) {
            this.f3097kK = aVarPoll.f3104kL;
            return;
        }
        if (aVarPoll.f3101a == null || (soundEventM6894a = c1204vxM6052a.m6894a(aVarPoll.f3101a)) == null) {
            return;
        }
        C0513iw c0513iw = new C0513iw(soundEventM6894a, aVarPoll.f3102cU, aVarPoll.f3103cV);
        minecraft.getSoundManager().play(c0513iw);
        this.f3098a = c0513iw;
        ObjectListIterator it = this.f3095K.iterator();
        while (it.hasNext()) {
            ((C0513iw) it.next()).m2291y(true);
        }
        this.f3095K.add(c0513iw);
    }

    /* JADX INFO: renamed from: aY */
    public void m2253aY() {
        if (this.f3098a != null) {
            this.f3098a.m2291y(true);
            this.f3098a = null;
        }
        this.f3096a.clear();
    }
}
