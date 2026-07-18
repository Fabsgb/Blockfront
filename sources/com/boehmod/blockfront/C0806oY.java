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

/* JADX INFO: renamed from: com.boehmod.blockfront.oY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oY.class */
public class C0806oY {

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final Codec<C0806oY> f4425t = C0836pB.f4471D.listOf().xmap(list -> {
        C0806oY c0806oY = new C0806oY();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c0806oY.m4165a((Vec2) it.next());
        }
        return c0806oY;
    }, c0806oY -> {
        return List.copyOf(c0806oY.f4427O);
    });

    /* JADX INFO: renamed from: N */
    @NotNull
    private final ObjectList<a> f4426N = new ObjectArrayList();

    /* JADX INFO: renamed from: O */
    @NotNull
    private final ObjectList<Vec2> f4427O = new ObjectArrayList();

    /* JADX INFO: renamed from: be */
    public int m4162be() {
        return this.f4427O.size();
    }

    /* JADX INFO: renamed from: bf */
    public int m4163bf() {
        return this.f4426N.size();
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public ObjectList<a> m4164f() {
        return ObjectLists.unmodifiable(this.f4426N);
    }

    /* JADX INFO: renamed from: a */
    public void m4165a(@NotNull Vec2 vec2) {
        this.f4427O.add(vec2);
        m4170cz();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vec2 m4166b() {
        if (this.f4427O.isEmpty()) {
            return Vec2.ZERO;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        ObjectListIterator it = this.f4427O.iterator();
        while (it.hasNext()) {
            Vec2 vec2 = (Vec2) it.next();
            f += vec2.x;
            f2 += vec2.y;
        }
        int size = this.f4427O.size();
        return new Vec2(f / size, f2 / size);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4167a(float f, float f2) {
        int i = 0;
        ObjectListIterator it = this.f4426N.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).m4176b(f, f2)) {
                i++;
            }
        }
        return i % 2 != 0;
    }

    /* JADX INFO: renamed from: b */
    public void m4168b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4427O.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f4427O.add(new Vec2(byteBuf.readFloat(), byteBuf.readFloat()));
        }
        m4170cz();
    }

    /* JADX INFO: renamed from: c */
    public void m4169c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4427O.size());
        ObjectListIterator it = this.f4427O.iterator();
        while (it.hasNext()) {
            Vec2 vec2 = (Vec2) it.next();
            byteBuf.writeFloat(vec2.x);
            byteBuf.writeFloat(vec2.y);
        }
    }

    /* JADX INFO: renamed from: cz */
    private void m4170cz() {
        this.f4426N.clear();
        int size = this.f4427O.size();
        for (int i = 0; i < size; i++) {
            this.f4426N.add(new a((Vec2) this.f4427O.get(i), (Vec2) this.f4427O.get((i + 1) % size)));
        }
    }

    /* JADX INFO: renamed from: bu */
    public boolean m4171bu() {
        return this.f4427O.isEmpty();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.oY$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oY$a.class */
    public static class a {

        /* JADX INFO: renamed from: i */
        private final Vec2 f4428i;

        /* JADX INFO: renamed from: j */
        private final Vec2 f4429j;

        /* JADX INFO: renamed from: kw */
        private final float f4430kw;

        /* JADX INFO: renamed from: kx */
        private final float f4431kx;

        a(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
            this.f4428i = vec2;
            this.f4429j = vec22;
            this.f4430kw = vec22.x - vec2.x;
            this.f4431kx = vec22.y - vec2.y;
        }

        /* JADX INFO: renamed from: c */
        public Vec2 m4174c() {
            return this.f4428i;
        }

        /* JADX INFO: renamed from: d */
        public Vec2 m4175d() {
            return this.f4429j;
        }

        /* JADX INFO: renamed from: b */
        boolean m4176b(float f, float f2) {
            return (((this.f4428i.y > f2 ? 1 : (this.f4428i.y == f2 ? 0 : -1)) < 0 && (this.f4429j.y > f2 ? 1 : (this.f4429j.y == f2 ? 0 : -1)) >= 0) || ((this.f4429j.y > f2 ? 1 : (this.f4429j.y == f2 ? 0 : -1)) < 0 && (this.f4428i.y > f2 ? 1 : (this.f4428i.y == f2 ? 0 : -1)) >= 0)) && this.f4428i.x + (((f2 - this.f4428i.y) * this.f4430kw) / this.f4431kx) > f;
        }
    }
}
