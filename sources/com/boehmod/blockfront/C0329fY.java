package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.fY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fY.class */
public class C0329fY {

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Codec<C0329fY> f2391c = RecordCodecBuilder.create(instance -> {
        return instance.group(C0385gb.f2545d.listOf().optionalFieldOf("x", List.of()).forGetter((v0) -> {
            return v0.m1690h();
        }), C0385gb.f2545d.listOf().optionalFieldOf("y", List.of()).forGetter((v0) -> {
            return v0.m1691i();
        }), C0385gb.f2545d.listOf().optionalFieldOf("z", List.of()).forGetter((v0) -> {
            return v0.m1692j();
        })).apply(instance, C0329fY::new);
    });

    /* JADX INFO: renamed from: y */
    @NotNull
    private final ObjectList<C0385gb> f2392y = new ObjectArrayList();

    /* JADX INFO: renamed from: z */
    @NotNull
    private final ObjectList<C0385gb> f2393z = new ObjectArrayList();

    /* JADX INFO: renamed from: A */
    @NotNull
    private final ObjectList<C0385gb> f2394A = new ObjectArrayList();

    public C0329fY() {
    }

    public C0329fY(@NotNull List<C0385gb> list, @NotNull List<C0385gb> list2, @NotNull List<C0385gb> list3) {
        this.f2392y.addAll(list);
        this.f2393z.addAll(list2);
        this.f2394A.addAll(list3);
    }

    /* JADX INFO: renamed from: a */
    public C0329fY m1687a(float f, float f2, float f3) {
        this.f2392y.add(new C0385gb(f, f2, f3));
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0329fY m1688b(float f, float f2, float f3) {
        this.f2393z.add(new C0385gb(f, f2, f3));
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0329fY m1689c(float f, float f2, float f3) {
        this.f2394A.add(new C0385gb(f, f2, f3));
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public List<C0385gb> m1690h() {
        return this.f2392y;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public List<C0385gb> m1691i() {
        return this.f2393z;
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public List<C0385gb> m1692j() {
        return this.f2394A;
    }

    /* JADX INFO: renamed from: a */
    private float m1693a(@NotNull List<C0385gb> list, float f, float f2) {
        float fSin = 0.0f;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C0385gb c0385gb = list.get(i);
            fSin += Mth.sin((f / c0385gb.m1844x()) + c0385gb.m1846z()) * c0385gb.m1845y();
        }
        return fSin / f2;
    }

    /* JADX INFO: renamed from: a */
    public Vector3f m1694a(float f, float f2, @NotNull Vector3f vector3f) {
        return vector3f.set(m1693a((List<C0385gb>) this.f2392y, f, f2), m1693a((List<C0385gb>) this.f2393z, f, f2), m1693a((List<C0385gb>) this.f2394A, f, f2));
    }
}
