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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oY.class */
public class oY {

    @NotNull
    public static final Codec<oY> t = pB.D.listOf().xmap(list -> {
        oY oYVar = new oY();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            oYVar.a((Vec2) it.next());
        }
        return oYVar;
    }, oYVar -> {
        return List.copyOf(oYVar.O);
    });

    @NotNull
    private final ObjectList<a> N = new ObjectArrayList();

    @NotNull
    private final ObjectList<Vec2> O = new ObjectArrayList();

    public int be() {
        return this.O.size();
    }

    public int bf() {
        return this.N.size();
    }

    @NotNull
    public ObjectList<a> f() {
        return ObjectLists.unmodifiable(this.N);
    }

    public void a(@NotNull Vec2 vec2) {
        this.O.add(vec2);
        cz();
    }

    @NotNull
    public Vec2 b() {
        if (this.O.isEmpty()) {
            return Vec2.ZERO;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        ObjectListIterator it = this.O.iterator();
        while (it.hasNext()) {
            Vec2 vec2 = (Vec2) it.next();
            f += vec2.x;
            f2 += vec2.y;
        }
        int size = this.O.size();
        return new Vec2(f / size, f2 / size);
    }

    public boolean a(float f, float f2) {
        int i = 0;
        ObjectListIterator it = this.N.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).b(f, f2)) {
                i++;
            }
        }
        return i % 2 != 0;
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.O.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.O.add(new Vec2(byteBuf.readFloat(), byteBuf.readFloat()));
        }
        cz();
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.O.size());
        ObjectListIterator it = this.O.iterator();
        while (it.hasNext()) {
            Vec2 vec2 = (Vec2) it.next();
            byteBuf.writeFloat(vec2.x);
            byteBuf.writeFloat(vec2.y);
        }
    }

    private void cz() {
        this.N.clear();
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            this.N.add(new a((Vec2) this.O.get(i), (Vec2) this.O.get((i + 1) % size)));
        }
    }

    public boolean bu() {
        return this.O.isEmpty();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oY$a.class */
    public static class a {
        private final Vec2 i;
        private final Vec2 j;
        private final float kw;
        private final float kx;

        a(@NotNull Vec2 vec2, @NotNull Vec2 vec22) {
            this.i = vec2;
            this.j = vec22;
            this.kw = vec22.x - vec2.x;
            this.kx = vec22.y - vec2.y;
        }

        public Vec2 c() {
            return this.i;
        }

        public Vec2 d() {
            return this.j;
        }

        boolean b(float f, float f2) {
            return (((this.i.y > f2 ? 1 : (this.i.y == f2 ? 0 : -1)) < 0 && (this.j.y > f2 ? 1 : (this.j.y == f2 ? 0 : -1)) >= 0) || ((this.j.y > f2 ? 1 : (this.j.y == f2 ? 0 : -1)) < 0 && (this.i.y > f2 ? 1 : (this.i.y == f2 ? 0 : -1)) >= 0)) && this.i.x + (((f2 - this.i.y) * this.kw) / this.kx) > f;
        }
    }
}
