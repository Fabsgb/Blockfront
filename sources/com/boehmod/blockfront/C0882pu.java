package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pu.class */
public class C0882pu {

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final Codec<C0882pu> f4828t = C0859pX.f4600D.listOf().xmap(list -> {
        C0882pu c0882pu = new C0882pu();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c0882pu.m4602a((Vec2) it.next());
        }
        return c0882pu;
    }, c0882pu -> {
        return List.copyOf(c0882pu.f4830X);
    });

    /* JADX INFO: renamed from: W */
    @NotNull
    private final ObjectList<a> f4829W = new ObjectArrayList();

    /* JADX INFO: renamed from: X */
    @NotNull
    private final ObjectList<Vec2> f4830X = new ObjectArrayList();

    /* JADX INFO: renamed from: bt */
    public int m4599bt() {
        return this.f4830X.size();
    }

    /* JADX INFO: renamed from: bu */
    public int m4600bu() {
        return this.f4829W.size();
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public ObjectList<a> m4601j() {
        return ObjectLists.unmodifiable(this.f4829W);
    }

    /* JADX INFO: renamed from: a */
    public void m4602a(@NotNull Vec2 vec2) {
        this.f4830X.add(vec2);
        m4607cL();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vec2 m4603b() {
        if (this.f4830X.isEmpty()) {
            return Vec2.ZERO;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        ObjectListIterator it = this.f4830X.iterator();
        while (it.hasNext()) {
            Vec2 vec2 = (Vec2) it.next();
            f += vec2.x;
            f2 += vec2.y;
        }
        int size = this.f4830X.size();
        return new Vec2(f / size, f2 / size);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4604a(float f, float f2) {
        int i = 0;
        ObjectListIterator it = this.f4829W.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).m4613b(f, f2)) {
                i++;
            }
        }
        return i % 2 != 0;
    }

    /* JADX INFO: renamed from: b */
    public void m4605b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4830X.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f4830X.add(new Vec2(byteBuf.readFloat(), byteBuf.readFloat()));
        }
        m4607cL();
    }

    /* JADX INFO: renamed from: c */
    public void m4606c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4830X.size());
        ObjectListIterator it = this.f4830X.iterator();
        while (it.hasNext()) {
            Vec2 vec2 = (Vec2) it.next();
            byteBuf.writeFloat(vec2.x);
            byteBuf.writeFloat(vec2.y);
        }
    }

    /* JADX INFO: renamed from: cL */
    private void m4607cL() {
        this.f4829W.clear();
        int size = this.f4830X.size();
        for (int i = 0; i < size; i++) {
            this.f4829W.add(new a((Vec2) this.f4830X.get(i), (Vec2) this.f4830X.get((i + 1) % size)));
        }
    }

    /* JADX INFO: renamed from: bE */
    public boolean m4608bE() {
        return this.f4830X.isEmpty();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pu$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pu$a.class */
    public static class a {

        /* JADX INFO: renamed from: i */
        private final Vec2 f4831i;

        /* JADX INFO: renamed from: j */
        private final Vec2 f4832j;

        /* JADX INFO: renamed from: lr */
        private final float f4833lr;

        /* JADX INFO: renamed from: ls */
        private final float f4834ls;

        a(@NotNull Vec2 vec2, @NotNull Vec2 vec3) {
            this.f4831i = vec2;
            this.f4832j = vec3;
            this.f4833lr = vec3.x - vec2.x;
            this.f4834ls = vec3.y - vec2.y;
        }

        /* JADX INFO: renamed from: c */
        public Vec2 m4611c() {
            return this.f4831i;
        }

        /* JADX INFO: renamed from: d */
        public Vec2 m4612d() {
            return this.f4832j;
        }

        /* JADX INFO: renamed from: b */
        boolean m4613b(float f, float f2) {
            return (((this.f4831i.y > f2 ? 1 : (this.f4831i.y == f2 ? 0 : -1)) < 0 && (this.f4832j.y > f2 ? 1 : (this.f4832j.y == f2 ? 0 : -1)) >= 0) || ((this.f4832j.y > f2 ? 1 : (this.f4832j.y == f2 ? 0 : -1)) < 0 && (this.f4831i.y > f2 ? 1 : (this.f4831i.y == f2 ? 0 : -1)) >= 0)) && this.f4831i.x + (((f2 - this.f4831i.y) * this.f4833lr) / this.f4834ls) > f;
        }
    }
}
