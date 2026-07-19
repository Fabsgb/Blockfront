package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qI.class */
public class qI {

    @NotNull
    private static final Codec<Vec3> N = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(vec3 -> {
            return Double.valueOf(vec3.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(vec32 -> {
            return Double.valueOf(vec32.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(vec33 -> {
            return Double.valueOf(vec33.z);
        })).apply(instance, (v1, v2, v3) -> {
            return new Vec3(v1, v2, v3);
        });
    });

    @NotNull
    public static final Codec<qI> O = RecordCodecBuilder.create(instance -> {
        return instance.group(N.listOf().fieldOf("positions").forGetter(qIVar -> {
            return qIVar.aG;
        }), Codec.FLOAT.fieldOf("speed").forGetter((v0) -> {
            return v0.aR();
        }), Codec.INT.fieldOf("startTime").forGetter((v0) -> {
            return v0.bq();
        }), Codec.INT.fieldOf("finishTime").forGetter((v0) -> {
            return v0.br();
        }), Codec.BOOL.fieldOf("reverseOnEnd").forGetter((v0) -> {
            return v0.bx();
        })).apply(instance, (list, f, num, num2, bool) -> {
            qI qIVar2 = new qI();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                qIVar2.n((Vec3) it.next());
            }
            qIVar2.n(f.floatValue());
            qIVar2.D(num.intValue());
            qIVar2.E(num2.intValue());
            qIVar2.P(bool.booleanValue());
            return qIVar2;
        });
    });
    public float fl;

    @NotNull
    public List<Vec3> aG = new ObjectArrayList();

    @NotNull
    public Vec3 c = Vec3.ZERO;

    @NotNull
    public Vec3 ac = Vec3.ZERO;
    public int pi = 0;
    public int pj = 0;
    public int pk = 0;
    public int pl = 0;
    public int pm = 0;
    public boolean gB = false;
    private boolean gC = false;

    @NotNull
    private qH a = qH.LINEAR;

    public void a(@NotNull qH qHVar) {
        this.a = qHVar;
    }

    public boolean bx() {
        return this.gB;
    }

    public void P(boolean z) {
        this.gB = z;
    }

    public void n(@NotNull Vec3 vec3) {
        if (this.c.equals(Vec3.ZERO)) {
            this.ac = vec3;
            this.c = vec3;
        }
        this.aG.add(vec3);
    }

    public float aR() {
        return this.fl;
    }

    public void n(float f) {
        this.fl = f;
    }

    @Nullable
    public Vec3 t() {
        if (this.aG.isEmpty()) {
            return null;
        }
        if (this.gC) {
            return this.aG.get(this.pi + 1);
        }
        if (this.pi <= 0) {
            return (Vec3) this.aG.getLast();
        }
        return this.aG.get(this.pi - 1);
    }

    public Vec3 u() {
        return this.aG.isEmpty() ? Vec3.ZERO : this.aG.get(this.pi);
    }

    public boolean be() {
        return this.pj > 0 || this.pk > 0;
    }

    public void cG() {
        if (this.gB) {
            if (this.gC) {
                this.pi--;
                if (this.pi < 0) {
                    this.pi = 0;
                    this.ac = this.c;
                    this.pj = this.pl;
                    this.gC = false;
                    return;
                }
                return;
            }
            this.pi++;
            if (this.pi >= this.aG.size()) {
                this.pi = this.aG.size() - 2;
                this.gC = true;
                this.ac = this.c;
                this.pk = this.pm;
                return;
            }
            return;
        }
        this.pi++;
        if (this.pi >= this.aG.size()) {
            this.pi = 0;
            this.c = this.aG.get(this.pi);
            this.ac = this.c;
            this.pk = this.pm;
            this.pj = this.pl;
        }
    }

    public void cH() {
        int i = this.pj;
        this.pj = i - 1;
        if (i <= 0) {
            int i2 = this.pk;
            this.pk = i2 - 1;
            if (i2 > 0) {
                return;
            }
            this.ac = this.c;
            this.c = this.a.interpolate(this, this.fl);
            if (this.c.distanceTo(u()) <= 0.0d) {
                cG();
            }
        }
    }

    public boolean P() {
        return this.gC ? this.pi <= 0 : this.pi >= this.aG.size() - 1;
    }

    public void bf() {
        this.pi = 0;
        this.pj = 0;
        this.pk = 0;
        this.gC = false;
        if (!this.aG.isEmpty()) {
            Vec3 vec3 = (Vec3) this.aG.getFirst();
            this.ac = vec3;
            this.c = vec3;
        } else {
            Vec3 vec32 = Vec3.ZERO;
            this.ac = vec32;
            this.c = vec32;
        }
    }

    public Vec3 a(float f) {
        return C0634xm.b(this.c, this.ac, f);
    }

    public int bq() {
        return this.pl;
    }

    public void D(int i) {
        this.pl = i;
    }

    public int br() {
        return this.pm;
    }

    public void E(int i) {
        this.pm = i;
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.aG.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            n(new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble()));
        }
        n(byteBuf.readFloat());
        D(byteBuf.readInt());
        E(byteBuf.readInt());
        P(IPacket.readBoolean(byteBuf));
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.aG.size());
        for (Vec3 vec3 : this.aG) {
            byteBuf.writeDouble(vec3.x);
            byteBuf.writeDouble(vec3.y);
            byteBuf.writeDouble(vec3.z);
        }
        byteBuf.writeFloat(aR());
        byteBuf.writeInt(bq());
        byteBuf.writeInt(br());
        IPacket.writeBoolean(byteBuf, bx());
    }
}
