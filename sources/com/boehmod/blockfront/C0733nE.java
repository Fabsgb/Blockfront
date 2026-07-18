package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.nE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nE.class */
public class C0733nE<V extends AbstractC0779ny> {

    /* JADX INFO: renamed from: dB */
    private ResourceLocation f3967dB;

    /* JADX INFO: renamed from: a */
    public AbstractC0778nx<V> f3942a = null;

    /* JADX INFO: renamed from: b */
    public Supplier<Item> f3943b = null;

    /* JADX INFO: renamed from: aj */
    @NotNull
    public List<C0732nD> f3944aj = new ObjectArrayList();

    /* JADX INFO: renamed from: ak */
    @NotNull
    public List<AbstractC0742nN<V>> f3945ak = new ObjectArrayList();

    /* JADX INFO: renamed from: J */
    @NotNull
    private final Map<String, AbstractC0742nN<V>> f3946J = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: al */
    @NotNull
    public List<AbstractC0738nJ<V>> f3947al = new ObjectArrayList();

    /* JADX INFO: renamed from: jB */
    public float f3948jB = 1.0f;

    /* JADX INFO: renamed from: jC */
    public float f3949jC = 6.0f;

    /* JADX INFO: renamed from: mh */
    public int f3950mh = 0;

    /* JADX INFO: renamed from: mi */
    public int f3951mi = 80;

    /* JADX INFO: renamed from: jD */
    public float f3952jD = 0.025f;

    /* JADX INFO: renamed from: jE */
    public float f3953jE = 0.015f;

    /* JADX INFO: renamed from: jF */
    public float f3954jF = 1.0f;

    /* JADX INFO: renamed from: jG */
    public float f3955jG = 0.8f;

    /* JADX INFO: renamed from: jH */
    public float f3956jH = 0.0f;

    /* JADX INFO: renamed from: jI */
    public float f3957jI = 0.1f;

    /* JADX INFO: renamed from: jJ */
    public float f3958jJ = 0.1f;

    /* JADX INFO: renamed from: jK */
    public float f3959jK = 0.1f;

    /* JADX INFO: renamed from: jL */
    public float f3960jL = 0.1f;

    /* JADX INFO: renamed from: jM */
    public float f3961jM = 0.75f;

    /* JADX INFO: renamed from: jN */
    public float f3962jN = 0.7f;

    /* JADX INFO: renamed from: jO */
    public float f3963jO = 1.5f;

    /* JADX INFO: renamed from: jP */
    public float f3964jP = 1.5f;

    /* JADX INFO: renamed from: jQ */
    public float f3965jQ = 1.3f;

    /* JADX INFO: renamed from: bC */
    public String f3966bC = "tank";

    /* JADX INFO: renamed from: ft */
    public boolean f3968ft = false;

    /* JADX INFO: renamed from: fu */
    public boolean f3969fu = false;

    public C0733nE() {
        m3329ck();
    }

    /* JADX INFO: renamed from: ck */
    public void m3329ck() {
        this.f3967dB = C0564jv.m2555d("textures/gui/game/vehicle/" + this.f3966bC + ".png");
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3330a(String str) {
        this.f3966bC = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3331a(boolean z) {
        this.f3969fu = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3332a(@NotNull Supplier<Item> supplier) {
        this.f3943b = supplier;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3333a(@NotNull AbstractC0778nx<V> abstractC0778nx) {
        this.f3942a = abstractC0778nx;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3334a(float f) {
        this.f3948jB = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3335a(@NotNull AbstractC0738nJ<V> abstractC0738nJ) {
        this.f3947al.add(abstractC0738nJ);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3336a(int i) {
        this.f3950mh = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0733nE<V> m3337b(float f) {
        this.f3949jC = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0733nE<V> m3338b(int i) {
        this.f3951mi = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3339a(float f, float f2) {
        this.f3952jD = f;
        this.f3953jE = f2;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0733nE<V> m3340c(float f) {
        this.f3955jG = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0733nE<V> m3341b(float f, float f2) {
        this.f3957jI = f;
        this.f3958jJ = f2;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0733nE<V> m3342c(float f, float f2) {
        this.f3959jK = f;
        this.f3960jL = f2;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0733nE<V> m3343d(float f) {
        this.f3962jN = f;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public C0733nE<V> m3344e(float f) {
        this.f3961jM = f;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0733nE<V> m3345d(float f, float f2) {
        this.f3963jO = f;
        this.f3964jP = f2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3346a(C0732nD c0732nD) {
        this.f3944aj.add(c0732nD);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0733nE<V> m3347a(@NotNull AbstractC0742nN<V> abstractC0742nN) {
        this.f3945ak.add(abstractC0742nN);
        this.f3946J.putIfAbsent(abstractC0742nN.f4006bD, abstractC0742nN);
        return this;
    }

    /* JADX INFO: renamed from: f */
    public C0733nE<V> m3348f(float f) {
        this.f3954jF = f;
        return this;
    }

    /* JADX INFO: renamed from: g */
    public C0733nE<V> m3349g(float f) {
        this.f3956jH = f;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0733nE<V> m3350c() {
        this.f3968ft = true;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public C0732nD m3351f() {
        for (C0732nD c0732nD : this.f3944aj) {
            if (c0732nD.f3929fo) {
                return c0732nD;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: aO */
    public int m3352aO() {
        int i = 0;
        Iterator<C0732nD> it = this.f3944aj.iterator();
        while (it.hasNext()) {
            if (it.next().f3929fo) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public C0732nD m3353a(int i) {
        if (i >= this.f3944aj.size()) {
            return new C0732nD();
        }
        return this.f3944aj.get(i);
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0742nN<V> m3354a(String str) {
        return this.f3946J.get(str);
    }

    /* JADX INFO: renamed from: w */
    public ResourceLocation m3355w() {
        return this.f3967dB;
    }
}
