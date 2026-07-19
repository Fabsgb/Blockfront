package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fY.class */
public class fY {

    @NotNull
    public static final Codec<fY> c = RecordCodecBuilder.create(instance -> {
        return instance.group(C0165gb.d.listOf().optionalFieldOf("x", List.of()).forGetter((v0) -> {
            return v0.h();
        }), C0165gb.d.listOf().optionalFieldOf("y", List.of()).forGetter((v0) -> {
            return v0.i();
        }), C0165gb.d.listOf().optionalFieldOf("z", List.of()).forGetter((v0) -> {
            return v0.j();
        })).apply(instance, fY::new);
    });

    @NotNull
    private final ObjectList<C0165gb> y = new ObjectArrayList();

    @NotNull
    private final ObjectList<C0165gb> z = new ObjectArrayList();

    @NotNull
    private final ObjectList<C0165gb> A = new ObjectArrayList();

    public fY() {
    }

    public fY(@NotNull List<C0165gb> list, @NotNull List<C0165gb> list2, @NotNull List<C0165gb> list3) {
        this.y.addAll(list);
        this.z.addAll(list2);
        this.A.addAll(list3);
    }

    public fY a(float f, float f2, float f3) {
        this.y.add(new C0165gb(f, f2, f3));
        return this;
    }

    public fY b(float f, float f2, float f3) {
        this.z.add(new C0165gb(f, f2, f3));
        return this;
    }

    public fY c(float f, float f2, float f3) {
        this.A.add(new C0165gb(f, f2, f3));
        return this;
    }

    @NotNull
    public List<C0165gb> h() {
        return this.y;
    }

    @NotNull
    public List<C0165gb> i() {
        return this.z;
    }

    @NotNull
    public List<C0165gb> j() {
        return this.A;
    }

    private float a(@NotNull List<C0165gb> list, float f, float f2) {
        float fSin = 0.0f;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C0165gb c0165gb = list.get(i);
            fSin += Mth.sin((f / c0165gb.x()) + c0165gb.z()) * c0165gb.y();
        }
        return fSin / f2;
    }

    public Vector3f a(float f, float f2, @NotNull Vector3f vector3f) {
        return vector3f.set(a((List<C0165gb>) this.y, f, f2), a((List<C0165gb>) this.z, f, f2), a((List<C0165gb>) this.A, f, f2));
    }
}
