package com.boehmod.blockfront;

import com.boehmod.blockfront.C0431hU;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayDeque;
import java.util.Queue;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.hT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hT.class */
public class C0430hT {

    /* JADX INFO: renamed from: B */
    @NotNull
    private final ObjectList<C0495if> f2793B = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private Queue<C0431hU.a> f2794a = new ArrayDeque();

    /* JADX INFO: renamed from: jp */
    private int f2795jp = 0;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0495if f2796a = null;

    /* JADX INFO: renamed from: cK */
    static final /* synthetic */ boolean f2797cK;

    static {
        f2797cK = !C0430hT.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: c */
    public void m2014c(@NotNull C0622l c0622l) {
        this.f2793B.removeIf((v0) -> {
            return v0.isStopped();
        });
        m2015f(c0622l);
    }

    /* JADX INFO: renamed from: f */
    private void m2015f(@NotNull C0622l c0622l) {
        if (c0622l.m2688a() == null) {
            m2019aQ();
            return;
        }
        if (this.f2795jp > 0) {
            this.f2795jp--;
        } else if (this.f2796a == null || this.f2796a.m2237U()) {
            m2018t(Minecraft.getInstance());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2016a(@NotNull Minecraft minecraft, @NotNull EnumC1123uW enumC1123uW, boolean z, boolean z2) {
        if (z2) {
            m2019aQ();
        }
        this.f2794a.add(new C0431hU.a(enumC1123uW, z, z2, 0));
        if (this.f2796a == null) {
            m2018t(minecraft);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2017a(@NotNull Queue<C0431hU.a> queue) {
        this.f2794a = queue;
    }

    /* JADX INFO: renamed from: t */
    public void m2018t(@NotNull Minecraft minecraft) {
        C1124uX c1124uXM5564a;
        C0431hU.a aVarPoll;
        SoundEvent soundEventM6241a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2797cK && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a == null || (c1124uXM5564a = abstractC0787oFM2688a.m3591a().m5564a()) == null || this.f2794a.isEmpty() || (aVarPoll = this.f2794a.poll()) == null) {
            return;
        }
        if (aVarPoll.f2802jq > 0) {
            this.f2795jp = aVarPoll.f2802jq;
            return;
        }
        if (aVarPoll.f2799a == null || (soundEventM6241a = c1124uXM5564a.m6241a(aVarPoll.f2799a)) == null) {
            return;
        }
        C0495if c0495if = new C0495if(soundEventM6241a, aVarPoll.f2800cL, aVarPoll.f2801cM);
        minecraft.getSoundManager().play(c0495if);
        this.f2796a = c0495if;
        ObjectListIterator it = this.f2793B.iterator();
        while (it.hasNext()) {
            ((C0495if) it.next()).m2236y(true);
        }
        this.f2793B.add(c0495if);
    }

    /* JADX INFO: renamed from: aQ */
    public void m2019aQ() {
        if (this.f2796a != null) {
            this.f2796a.m2236y(true);
            this.f2796a = null;
        }
        this.f2794a.clear();
    }
}
