package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nE.class */
public class nE<V extends AbstractC0376ny> {
    private ResourceLocation dB;
    public AbstractC0375nx<V> a = null;
    public Supplier<Item> b = null;

    @NotNull
    public List<nD> aj = new ObjectArrayList();

    @NotNull
    public List<nN<V>> ak = new ObjectArrayList();

    @NotNull
    private final Map<String, nN<V>> J = new Object2ObjectOpenHashMap();

    @NotNull
    public List<nJ<V>> al = new ObjectArrayList();
    public float jB = 1.0f;
    public float jC = 6.0f;
    public int mh = 0;
    public int mi = 80;
    public float jD = 0.025f;
    public float jE = 0.015f;
    public float jF = 1.0f;
    public float jG = 0.8f;
    public float jH = 0.0f;
    public float jI = 0.1f;
    public float jJ = 0.1f;
    public float jK = 0.1f;
    public float jL = 0.1f;
    public float jM = 0.75f;
    public float jN = 0.7f;
    public float jO = 1.5f;
    public float jP = 1.5f;
    public float jQ = 1.3f;
    public String bC = "tank";
    public boolean ft = false;
    public boolean fu = false;

    public nE() {
        ck();
    }

    public void ck() {
        this.dB = C0265jv.d("textures/gui/game/vehicle/" + this.bC + ".png");
    }

    public nE<V> a(String str) {
        this.bC = str;
        return this;
    }

    public nE<V> a(boolean z) {
        this.fu = z;
        return this;
    }

    public nE<V> a(@NotNull Supplier<Item> supplier) {
        this.b = supplier;
        return this;
    }

    public nE<V> a(@NotNull AbstractC0375nx<V> abstractC0375nx) {
        this.a = abstractC0375nx;
        return this;
    }

    public nE<V> a(float f) {
        this.jB = f;
        return this;
    }

    public nE<V> a(@NotNull nJ<V> nJVar) {
        this.al.add(nJVar);
        return this;
    }

    public nE<V> a(int i) {
        this.mh = i;
        return this;
    }

    public nE<V> b(float f) {
        this.jC = f;
        return this;
    }

    public nE<V> b(int i) {
        this.mi = i;
        return this;
    }

    public nE<V> a(float f, float f2) {
        this.jD = f;
        this.jE = f2;
        return this;
    }

    public nE<V> c(float f) {
        this.jG = f;
        return this;
    }

    public nE<V> b(float f, float f2) {
        this.jI = f;
        this.jJ = f2;
        return this;
    }

    public nE<V> c(float f, float f2) {
        this.jK = f;
        this.jL = f2;
        return this;
    }

    public nE<V> d(float f) {
        this.jN = f;
        return this;
    }

    public nE<V> e(float f) {
        this.jM = f;
        return this;
    }

    public nE<V> d(float f, float f2) {
        this.jO = f;
        this.jP = f2;
        return this;
    }

    public nE<V> a(nD nDVar) {
        this.aj.add(nDVar);
        return this;
    }

    public nE<V> a(@NotNull nN<V> nNVar) {
        this.ak.add(nNVar);
        this.J.putIfAbsent(nNVar.bD, nNVar);
        return this;
    }

    public nE<V> f(float f) {
        this.jF = f;
        return this;
    }

    public nE<V> g(float f) {
        this.jH = f;
        return this;
    }

    public nE<V> c() {
        this.ft = true;
        return this;
    }

    @Nullable
    public nD f() {
        for (nD nDVar : this.aj) {
            if (nDVar.fo) {
                return nDVar;
            }
        }
        return null;
    }

    public int aO() {
        int i = 0;
        Iterator<nD> it = this.aj.iterator();
        while (it.hasNext()) {
            if (it.next().fo) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public nD m716a(int i) {
        if (i >= this.aj.size()) {
            return new nD();
        }
        return this.aj.get(i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public nN<V> m717a(String str) {
        return this.J.get(str);
    }

    public ResourceLocation w() {
        return this.dB;
    }
}
