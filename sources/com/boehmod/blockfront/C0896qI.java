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

/* JADX INFO: renamed from: com.boehmod.blockfront.qI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qI.class */
public class C0896qI {

    /* JADX INFO: renamed from: N */
    @NotNull
    private static final Codec<Vec3> f4713N = RecordCodecBuilder.create(instance -> {
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

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final Codec<C0896qI> f4714O = RecordCodecBuilder.create(instance -> {
        return instance.group(f4713N.listOf().fieldOf("positions").forGetter(c0896qI -> {
            return c0896qI.f4715aG;
        }), Codec.FLOAT.fieldOf("speed").forGetter((v0) -> {
            return v0.m4625aR();
        }), Codec.INT.fieldOf("startTime").forGetter((v0) -> {
            return v0.m4635bq();
        }), Codec.INT.fieldOf("finishTime").forGetter((v0) -> {
            return v0.m4637br();
        }), Codec.BOOL.fieldOf("reverseOnEnd").forGetter((v0) -> {
            return v0.m4622bx();
        })).apply(instance, (list, f, num, num2, bool) -> {
            C0896qI c0896qI2 = new C0896qI();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0896qI2.m4624n((Vec3) it.next());
            }
            c0896qI2.m4626n(f.floatValue());
            c0896qI2.m4636D(num.intValue());
            c0896qI2.m4638E(num2.intValue());
            c0896qI2.m4623P(bool.booleanValue());
            return c0896qI2;
        });
    });

    /* JADX INFO: renamed from: fl */
    public float f4719fl;

    /* JADX INFO: renamed from: aG */
    @NotNull
    public List<Vec3> f4715aG = new ObjectArrayList();

    /* JADX INFO: renamed from: c */
    @NotNull
    public Vec3 f4716c = Vec3.ZERO;

    /* JADX INFO: renamed from: ac */
    @NotNull
    public Vec3 f4717ac = Vec3.ZERO;

    /* JADX INFO: renamed from: pi */
    public int f4718pi = 0;

    /* JADX INFO: renamed from: pj */
    public int f4720pj = 0;

    /* JADX INFO: renamed from: pk */
    public int f4721pk = 0;

    /* JADX INFO: renamed from: pl */
    public int f4722pl = 0;

    /* JADX INFO: renamed from: pm */
    public int f4723pm = 0;

    /* JADX INFO: renamed from: gB */
    public boolean f4724gB = false;

    /* JADX INFO: renamed from: gC */
    private boolean f4725gC = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0895qH f4726a = EnumC0895qH.LINEAR;

    /* JADX INFO: renamed from: a */
    public void m4621a(@NotNull EnumC0895qH enumC0895qH) {
        this.f4726a = enumC0895qH;
    }

    /* JADX INFO: renamed from: bx */
    public boolean m4622bx() {
        return this.f4724gB;
    }

    /* JADX INFO: renamed from: P */
    public void m4623P(boolean z) {
        this.f4724gB = z;
    }

    /* JADX INFO: renamed from: n */
    public void m4624n(@NotNull Vec3 vec3) {
        if (this.f4716c.equals(Vec3.ZERO)) {
            this.f4717ac = vec3;
            this.f4716c = vec3;
        }
        this.f4715aG.add(vec3);
    }

    /* JADX INFO: renamed from: aR */
    public float m4625aR() {
        return this.f4719fl;
    }

    /* JADX INFO: renamed from: n */
    public void m4626n(float f) {
        this.f4719fl = f;
    }

    @Nullable
    /* JADX INFO: renamed from: t */
    public Vec3 m4627t() {
        if (this.f4715aG.isEmpty()) {
            return null;
        }
        if (this.f4725gC) {
            return this.f4715aG.get(this.f4718pi + 1);
        }
        if (this.f4718pi <= 0) {
            return (Vec3) this.f4715aG.getLast();
        }
        return this.f4715aG.get(this.f4718pi - 1);
    }

    /* JADX INFO: renamed from: u */
    public Vec3 m4628u() {
        return this.f4715aG.isEmpty() ? Vec3.ZERO : this.f4715aG.get(this.f4718pi);
    }

    /* JADX INFO: renamed from: be */
    public boolean m4629be() {
        return this.f4720pj > 0 || this.f4721pk > 0;
    }

    /* JADX INFO: renamed from: cG */
    public void m4630cG() {
        if (this.f4724gB) {
            if (this.f4725gC) {
                this.f4718pi--;
                if (this.f4718pi < 0) {
                    this.f4718pi = 0;
                    this.f4717ac = this.f4716c;
                    this.f4720pj = this.f4722pl;
                    this.f4725gC = false;
                    return;
                }
                return;
            }
            this.f4718pi++;
            if (this.f4718pi >= this.f4715aG.size()) {
                this.f4718pi = this.f4715aG.size() - 2;
                this.f4725gC = true;
                this.f4717ac = this.f4716c;
                this.f4721pk = this.f4723pm;
                return;
            }
            return;
        }
        this.f4718pi++;
        if (this.f4718pi >= this.f4715aG.size()) {
            this.f4718pi = 0;
            this.f4716c = this.f4715aG.get(this.f4718pi);
            this.f4717ac = this.f4716c;
            this.f4721pk = this.f4723pm;
            this.f4720pj = this.f4722pl;
        }
    }

    /* JADX INFO: renamed from: cH */
    public void m4631cH() {
        int i = this.f4720pj;
        this.f4720pj = i - 1;
        if (i <= 0) {
            int i2 = this.f4721pk;
            this.f4721pk = i2 - 1;
            if (i2 > 0) {
                return;
            }
            this.f4717ac = this.f4716c;
            this.f4716c = this.f4726a.interpolate(this, this.f4719fl);
            if (this.f4716c.distanceTo(m4628u()) <= 0.0d) {
                m4630cG();
            }
        }
    }

    /* JADX INFO: renamed from: P */
    public boolean m4632P() {
        return this.f4725gC ? this.f4718pi <= 0 : this.f4718pi >= this.f4715aG.size() - 1;
    }

    /* JADX INFO: renamed from: bf */
    public void m4633bf() {
        this.f4718pi = 0;
        this.f4720pj = 0;
        this.f4721pk = 0;
        this.f4725gC = false;
        if (!this.f4715aG.isEmpty()) {
            Vec3 vec3 = (Vec3) this.f4715aG.getFirst();
            this.f4717ac = vec3;
            this.f4716c = vec3;
        } else {
            Vec3 vec32 = Vec3.ZERO;
            this.f4717ac = vec32;
            this.f4716c = vec32;
        }
    }

    /* JADX INFO: renamed from: a */
    public Vec3 m4634a(float f) {
        return C1290xm.m7845b(this.f4716c, this.f4717ac, f);
    }

    /* JADX INFO: renamed from: bq */
    public int m4635bq() {
        return this.f4722pl;
    }

    /* JADX INFO: renamed from: D */
    public void m4636D(int i) {
        this.f4722pl = i;
    }

    /* JADX INFO: renamed from: br */
    public int m4637br() {
        return this.f4723pm;
    }

    /* JADX INFO: renamed from: E */
    public void m4638E(int i) {
        this.f4723pm = i;
    }

    /* JADX INFO: renamed from: b */
    public void m4639b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4715aG.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            m4624n(new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble()));
        }
        m4626n(byteBuf.readFloat());
        m4636D(byteBuf.readInt());
        m4638E(byteBuf.readInt());
        m4623P(IPacket.readBoolean(byteBuf));
    }

    /* JADX INFO: renamed from: c */
    public void m4640c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4715aG.size());
        for (Vec3 vec3 : this.f4715aG) {
            byteBuf.writeDouble(vec3.x);
            byteBuf.writeDouble(vec3.y);
            byteBuf.writeDouble(vec3.z);
        }
        byteBuf.writeFloat(m4625aR());
        byteBuf.writeInt(m4635bq());
        byteBuf.writeInt(m4637br());
        IPacket.writeBoolean(byteBuf, m4622bx());
    }
}
