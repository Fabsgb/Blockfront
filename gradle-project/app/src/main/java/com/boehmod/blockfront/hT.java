package com.boehmod.blockfront;

import com.boehmod.blockfront.hU;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayDeque;
import java.util.Queue;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hT.class */
public class hT {

    @NotNull
    private final ObjectList<Cif> B = new ObjectArrayList();

    @NotNull
    private Queue<hU.a> a = new ArrayDeque();
    private int jp = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private Cif f162a = null;
    static final /* synthetic */ boolean cK;

    static {
        cK = !hT.class.desiredAssertionStatus();
    }

    public void c(@NotNull C0297l c0297l) {
        this.B.removeIf((v0) -> {
            return v0.isStopped();
        });
        f(c0297l);
    }

    private void f(@NotNull C0297l c0297l) {
        if (c0297l.m591a() == null) {
            aQ();
            return;
        }
        if (this.jp > 0) {
            this.jp--;
        } else if (this.f162a == null || this.f162a.U()) {
            t(Minecraft.getInstance());
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull uW uWVar, boolean z, boolean z2) {
        if (z2) {
            aQ();
        }
        this.a.add(new hU.a(uWVar, z, z2, 0));
        if (this.f162a == null) {
            t(minecraft);
        }
    }

    public void a(@NotNull Queue<hU.a> queue) {
        this.a = queue;
    }

    public void t(@NotNull Minecraft minecraft) {
        uX uXVarA;
        hU.a aVarPoll;
        SoundEvent soundEventA;
        C0297l c0297lB = C0297l.b();
        if (!cK && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a == null || (uXVarA = oFVarM591a.m751a().a()) == null || this.a.isEmpty() || (aVarPoll = this.a.poll()) == null) {
            return;
        }
        if (aVarPoll.jq > 0) {
            this.jp = aVarPoll.jq;
            return;
        }
        if (aVarPoll.a == null || (soundEventA = uXVarA.a(aVarPoll.a)) == null) {
            return;
        }
        Cif cif = new Cif(soundEventA, aVarPoll.cL, aVarPoll.cM);
        minecraft.getSoundManager().play(cif);
        this.f162a = cif;
        ObjectListIterator it = this.B.iterator();
        while (it.hasNext()) {
            ((Cif) it.next()).y(true);
        }
        this.B.add(cif);
    }

    public void aQ() {
        if (this.f162a != null) {
            this.f162a.y(true);
            this.f162a = null;
        }
        this.a.clear();
    }
}
