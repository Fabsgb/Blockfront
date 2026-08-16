package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.go */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/go.class */
public class C0399go {

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Codec<C0399go> f2586c = RecordCodecBuilder.create(instance -> {
        return instance.group(C0402gr.f2600d.listOf().optionalFieldOf("x", List.of()).forGetter((v0) -> {
            return v0.m1900j();
        }), C0402gr.f2600d.listOf().optionalFieldOf("y", List.of()).forGetter((v0) -> {
            return v0.m1901k();
        }), C0402gr.f2600d.listOf().optionalFieldOf("z", List.of()).forGetter((v0) -> {
            return v0.m1902l();
        })).apply(instance, C0399go::new);
    });

    /* JADX INFO: renamed from: H */
    @NotNull
    private final ObjectList<C0402gr> f2587H = new ObjectArrayList();

    /* JADX INFO: renamed from: I */
    @NotNull
    private final ObjectList<C0402gr> f2588I = new ObjectArrayList();

    /* JADX INFO: renamed from: J */
    @NotNull
    private final ObjectList<C0402gr> f2589J = new ObjectArrayList();

    public C0399go() {
    }

    public C0399go(@NotNull List<C0402gr> list, @NotNull List<C0402gr> list2, @NotNull List<C0402gr> list3) {
        this.f2587H.addAll(list);
        this.f2588I.addAll(list2);
        this.f2589J.addAll(list3);
    }

    /* JADX INFO: renamed from: a */
    public C0399go m1897a(float f, float f2, float f3) {
        this.f2587H.add(new C0402gr(f, f2, f3));
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0399go m1898b(float f, float f2, float f3) {
        this.f2588I.add(new C0402gr(f, f2, f3));
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0399go m1899c(float f, float f2, float f3) {
        this.f2589J.add(new C0402gr(f, f2, f3));
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public List<C0402gr> m1900j() {
        return this.f2587H;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public List<C0402gr> m1901k() {
        return this.f2588I;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public List<C0402gr> m1902l() {
        return this.f2589J;
    }

    /* JADX INFO: renamed from: a */
    private float m1903a(@NotNull List<C0402gr> list, float f, float f2) {
        float fSin = 0.0f;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C0402gr c0402gr = list.get(i);
            fSin += Mth.sin((f / c0402gr.m1908x()) + c0402gr.m1910z()) * c0402gr.m1909y();
        }
        return fSin / f2;
    }

    /* JADX INFO: renamed from: a */
    public Vector3f m1904a(float f, float f2, @NotNull Vector3f vector3f) {
        return vector3f.set(m1903a((List<C0402gr>) this.f2587H, f, f2), m1903a((List<C0402gr>) this.f2588I, f, f2), m1903a((List<C0402gr>) this.f2589J, f, f2));
    }
}
