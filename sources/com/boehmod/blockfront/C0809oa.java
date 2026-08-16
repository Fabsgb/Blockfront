package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oa.class */
public class C0809oa<V extends AbstractC0750nU> {

    /* JADX INFO: renamed from: dz */
    private ResourceLocation f4395dz;

    /* JADX INFO: renamed from: a */
    public AbstractC0749nT<V> f4370a = null;

    /* JADX INFO: renamed from: b */
    public Supplier<Item> f4371b = null;

    /* JADX INFO: renamed from: aq */
    @NotNull
    public List<C0755nZ> f4372aq = new ObjectArrayList();

    /* JADX INFO: renamed from: ar */
    @NotNull
    public List<AbstractC0818oj<V>> f4373ar = new ObjectArrayList();

    /* JADX INFO: renamed from: J */
    @NotNull
    private final Map<String, AbstractC0818oj<V>> f4374J = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: as */
    @NotNull
    public List<AbstractC0814of<V>> f4375as = new ObjectArrayList();

    /* JADX INFO: renamed from: ku */
    public float f4376ku = 1.0f;

    /* JADX INFO: renamed from: kv */
    public float f4377kv = 6.0f;

    /* JADX INFO: renamed from: of */
    public int f4378of = 0;

    /* JADX INFO: renamed from: og */
    public int f4379og = 80;

    /* JADX INFO: renamed from: kw */
    public float f4380kw = 0.025f;

    /* JADX INFO: renamed from: kx */
    public float f4381kx = 0.015f;

    /* JADX INFO: renamed from: ky */
    public float f4382ky = 1.0f;

    /* JADX INFO: renamed from: kz */
    public float f4383kz = 0.8f;

    /* JADX INFO: renamed from: kA */
    public float f4384kA = 0.0f;

    /* JADX INFO: renamed from: kB */
    public float f4385kB = 0.1f;

    /* JADX INFO: renamed from: kC */
    public float f4386kC = 0.1f;

    /* JADX INFO: renamed from: kD */
    public float f4387kD = 0.1f;

    /* JADX INFO: renamed from: kE */
    public float f4388kE = 0.1f;

    /* JADX INFO: renamed from: kF */
    public float f4389kF = 0.75f;

    /* JADX INFO: renamed from: kG */
    public float f4390kG = 0.7f;

    /* JADX INFO: renamed from: kH */
    public float f4391kH = 1.5f;

    /* JADX INFO: renamed from: kI */
    public float f4392kI = 1.5f;

    /* JADX INFO: renamed from: kJ */
    public float f4393kJ = 1.3f;

    /* JADX INFO: renamed from: bL */
    public String f4394bL = "tank";

    /* JADX INFO: renamed from: fN */
    public boolean f4396fN = false;

    /* JADX INFO: renamed from: fO */
    public boolean f4397fO = false;

    public C0809oa() {
        m3707cw();
    }

    /* JADX INFO: renamed from: cw */
    public void m3707cw() {
        this.f4395dz = C0532jO.m2378d("textures/gui/game/vehicle/" + this.f4394bL + ".png");
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3708a(String str) {
        this.f4394bL = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3709a(boolean z) {
        this.f4397fO = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3710a(@NotNull Supplier<Item> supplier) {
        this.f4371b = supplier;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3711a(@NotNull AbstractC0749nT<V> abstractC0749nT) {
        this.f4370a = abstractC0749nT;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3712a(float f) {
        this.f4376ku = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3713a(@NotNull AbstractC0814of<V> abstractC0814of) {
        this.f4375as.add(abstractC0814of);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3714a(int i) {
        this.f4378of = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0809oa<V> m3715b(float f) {
        this.f4377kv = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0809oa<V> m3716b(int i) {
        this.f4379og = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3717a(float f, float f2) {
        this.f4380kw = f;
        this.f4381kx = f2;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0809oa<V> m3718c(float f) {
        this.f4383kz = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0809oa<V> m3719b(float f, float f2) {
        this.f4385kB = f;
        this.f4386kC = f2;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0809oa<V> m3720c(float f, float f2) {
        this.f4387kD = f;
        this.f4388kE = f2;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0809oa<V> m3721d(float f) {
        this.f4390kG = f;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public C0809oa<V> m3722e(float f) {
        this.f4389kF = f;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0809oa<V> m3723d(float f, float f2) {
        this.f4391kH = f;
        this.f4392kI = f2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3724a(C0755nZ c0755nZ) {
        this.f4372aq.add(c0755nZ);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0809oa<V> m3725a(@NotNull AbstractC0818oj<V> abstractC0818oj) {
        this.f4373ar.add(abstractC0818oj);
        this.f4374J.putIfAbsent(abstractC0818oj.f4434bM, abstractC0818oj);
        return this;
    }

    /* JADX INFO: renamed from: f */
    public C0809oa<V> m3726f(float f) {
        this.f4382ky = f;
        return this;
    }

    /* JADX INFO: renamed from: g */
    public C0809oa<V> m3727g(float f) {
        this.f4384kA = f;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0809oa<V> m3728c() {
        this.f4396fN = true;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public C0755nZ m3729f() {
        for (C0755nZ c0755nZ : this.f4372aq) {
            if (c0755nZ.f4177fI) {
                return c0755nZ;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: bd */
    public int m3730bd() {
        int i = 0;
        Iterator<C0755nZ> it = this.f4372aq.iterator();
        while (it.hasNext()) {
            if (it.next().f4177fI) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public C0755nZ m3731a(int i) {
        if (i >= this.f4372aq.size()) {
            return new C0755nZ();
        }
        return this.f4372aq.get(i);
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0818oj<V> m3732a(String str) {
        return this.f4374J.get(str);
    }

    /* JADX INFO: renamed from: x */
    public ResourceLocation m3733x() {
        return this.f4395dz;
    }
}
