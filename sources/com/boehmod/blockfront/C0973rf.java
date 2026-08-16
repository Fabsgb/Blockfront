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

/* JADX INFO: renamed from: com.boehmod.blockfront.rf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rf.class */
public class C0973rf {

    /* JADX INFO: renamed from: N */
    @NotNull
    private static final Codec<Vec3> f5443N = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(vec3 -> {
            return Double.valueOf(vec3.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(vec4 -> {
            return Double.valueOf(vec4.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(vec5 -> {
            return Double.valueOf(vec5.z);
        })).apply(instance, (v1, v2, v3) -> {
            return new Vec3(v1, v2, v3);
        });
    });

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final Codec<C0973rf> f5444O = RecordCodecBuilder.create(instance -> {
        return instance.group(f5443N.listOf().fieldOf("positions").forGetter(c0973rf -> {
            return c0973rf.f5445aN;
        }), Codec.FLOAT.fieldOf("speed").forGetter((v0) -> {
            return v0.m5520aX();
        }), Codec.INT.fieldOf("startTime").forGetter((v0) -> {
            return v0.m5530bF();
        }), Codec.INT.fieldOf("finishTime").forGetter((v0) -> {
            return v0.m5532bG();
        }), Codec.BOOL.fieldOf("reverseOnEnd").forGetter((v0) -> {
            return v0.m5517bH();
        })).apply(instance, (list, f, num, num2, bool) -> {
            C0973rf c0973rf2 = new C0973rf();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0973rf2.m5519n((Vec3) it.next());
            }
            c0973rf2.m5521m(f.floatValue());
            c0973rf2.m5531E(num.intValue());
            c0973rf2.m5533F(num2.intValue());
            c0973rf2.m5518Q(bool.booleanValue());
            return c0973rf2;
        });
    });

    /* JADX INFO: renamed from: fv */
    public float f5449fv;

    /* JADX INFO: renamed from: aN */
    @NotNull
    public List<Vec3> f5445aN = new ObjectArrayList();

    /* JADX INFO: renamed from: c */
    @NotNull
    public Vec3 f5446c = Vec3.ZERO;

    /* JADX INFO: renamed from: ad */
    @NotNull
    public Vec3 f5447ad = Vec3.ZERO;

    /* JADX INFO: renamed from: rh */
    public int f5448rh = 0;

    /* JADX INFO: renamed from: ri */
    public int f5450ri = 0;

    /* JADX INFO: renamed from: rj */
    public int f5451rj = 0;

    /* JADX INFO: renamed from: rk */
    public int f5452rk = 0;

    /* JADX INFO: renamed from: rl */
    public int f5453rl = 0;

    /* JADX INFO: renamed from: gV */
    public boolean f5454gV = false;

    /* JADX INFO: renamed from: gW */
    private boolean f5455gW = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0972re f5456a = EnumC0972re.LINEAR;

    /* JADX INFO: renamed from: a */
    public void m5516a(@NotNull EnumC0972re enumC0972re) {
        this.f5456a = enumC0972re;
    }

    /* JADX INFO: renamed from: bH */
    public boolean m5517bH() {
        return this.f5454gV;
    }

    /* JADX INFO: renamed from: Q */
    public void m5518Q(boolean z) {
        this.f5454gV = z;
    }

    /* JADX INFO: renamed from: n */
    public void m5519n(@NotNull Vec3 vec3) {
        if (this.f5446c.equals(Vec3.ZERO)) {
            this.f5447ad = vec3;
            this.f5446c = vec3;
        }
        this.f5445aN.add(vec3);
    }

    /* JADX INFO: renamed from: aX */
    public float m5520aX() {
        return this.f5449fv;
    }

    /* JADX INFO: renamed from: m */
    public void m5521m(float f) {
        this.f5449fv = f;
    }

    @Nullable
    /* JADX INFO: renamed from: u */
    public Vec3 m5522u() {
        if (this.f5445aN.isEmpty()) {
            return null;
        }
        if (this.f5455gW) {
            return this.f5445aN.get(this.f5448rh + 1);
        }
        if (this.f5448rh <= 0) {
            return (Vec3) this.f5445aN.getLast();
        }
        return this.f5445aN.get(this.f5448rh - 1);
    }

    /* JADX INFO: renamed from: v */
    public Vec3 m5523v() {
        return this.f5445aN.isEmpty() ? Vec3.ZERO : this.f5445aN.get(this.f5448rh);
    }

    /* JADX INFO: renamed from: bo */
    public boolean m5524bo() {
        return this.f5450ri > 0 || this.f5451rj > 0;
    }

    /* JADX INFO: renamed from: cS */
    public void m5525cS() {
        if (this.f5454gV) {
            if (this.f5455gW) {
                this.f5448rh--;
                if (this.f5448rh < 0) {
                    this.f5448rh = 0;
                    this.f5447ad = this.f5446c;
                    this.f5450ri = this.f5452rk;
                    this.f5455gW = false;
                    return;
                }
                return;
            }
            this.f5448rh++;
            if (this.f5448rh >= this.f5445aN.size()) {
                this.f5448rh = this.f5445aN.size() - 2;
                this.f5455gW = true;
                this.f5447ad = this.f5446c;
                this.f5451rj = this.f5453rl;
                return;
            }
            return;
        }
        this.f5448rh++;
        if (this.f5448rh >= this.f5445aN.size()) {
            this.f5448rh = 0;
            this.f5446c = this.f5445aN.get(this.f5448rh);
            this.f5447ad = this.f5446c;
            this.f5451rj = this.f5453rl;
            this.f5450ri = this.f5452rk;
        }
    }

    /* JADX INFO: renamed from: cT */
    public void m5526cT() {
        int i = this.f5450ri;
        this.f5450ri = i - 1;
        if (i <= 0) {
            int i2 = this.f5451rj;
            this.f5451rj = i2 - 1;
            if (i2 > 0) {
                return;
            }
            this.f5447ad = this.f5446c;
            this.f5446c = this.f5456a.interpolate(this, this.f5449fv);
            if (this.f5446c.distanceTo(m5523v()) <= 0.0d) {
                m5525cS();
            }
        }
    }

    /* JADX INFO: renamed from: R */
    public boolean m5527R() {
        if (this.f5455gW) {
            return this.f5448rh <= 0;
        }
        return this.f5448rh >= this.f5445aN.size() - 1;
    }

    /* JADX INFO: renamed from: bd */
    public void m5528bd() {
        this.f5448rh = 0;
        this.f5450ri = 0;
        this.f5451rj = 0;
        this.f5455gW = false;
        if (!this.f5445aN.isEmpty()) {
            Vec3 vec3 = (Vec3) this.f5445aN.getFirst();
            this.f5447ad = vec3;
            this.f5446c = vec3;
        } else {
            Vec3 vec4 = Vec3.ZERO;
            this.f5447ad = vec4;
            this.f5446c = vec4;
        }
    }

    /* JADX INFO: renamed from: a */
    public Vec3 m5529a(float f) {
        return C1270xJ.m7172b(this.f5446c, this.f5447ad, f);
    }

    /* JADX INFO: renamed from: bF */
    public int m5530bF() {
        return this.f5452rk;
    }

    /* JADX INFO: renamed from: E */
    public void m5531E(int i) {
        this.f5452rk = i;
    }

    /* JADX INFO: renamed from: bG */
    public int m5532bG() {
        return this.f5453rl;
    }

    /* JADX INFO: renamed from: F */
    public void m5533F(int i) {
        this.f5453rl = i;
    }

    /* JADX INFO: renamed from: b */
    public void m5534b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5445aN.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            m5519n(new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble()));
        }
        m5521m(byteBuf.readFloat());
        m5531E(byteBuf.readInt());
        m5533F(byteBuf.readInt());
        m5518Q(IPacket.readBoolean(byteBuf));
    }

    /* JADX INFO: renamed from: c */
    public void m5535c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f5445aN.size());
        for (Vec3 vec3 : this.f5445aN) {
            byteBuf.writeDouble(vec3.x);
            byteBuf.writeDouble(vec3.y);
            byteBuf.writeDouble(vec3.z);
        }
        byteBuf.writeFloat(m5520aX());
        byteBuf.writeInt(m5530bF());
        byteBuf.writeInt(m5532bG());
        IPacket.writeBoolean(byteBuf, m5517bH());
    }
}
