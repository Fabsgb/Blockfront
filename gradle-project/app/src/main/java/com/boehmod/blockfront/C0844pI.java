package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pI.class */
public final class C0844pI extends C0881pt {

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final Codec<C0844pI> f4552B = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0844pI -> {
            return Double.valueOf(c0844pI.f4827c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0844pI2 -> {
            return Double.valueOf(c0844pI2.f4827c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0844pI3 -> {
            return Double.valueOf(c0844pI3.f4827c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0844pI4 -> {
            return Float.valueOf(c0844pI4.f4826h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0844pI5 -> {
            return Float.valueOf(c0844pI5.f4826h.y);
        }), C0837pB.f4508w.fieldOf("loadout").forGetter(c0844pI6 -> {
            return c0844pI6.f4554a;
        })).apply(instance, (d, d2, d3, f, f2, c0837pB) -> {
            return new C0844pI(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), c0837pB);
        });
    });

    /* JADX INFO: renamed from: pJ */
    public static final int f4553pJ = 3;

    /* JADX INFO: renamed from: a */
    public C0837pB f4554a;

    public C0844pI() {
    }

    public C0844pI(double d, double d2, double d3, float f, float f2, @NotNull C0837pB c0837pB) {
        super(d, d2, d3, f, f2);
        this.f4554a = c0837pB;
    }

    /* JADX INFO: renamed from: b */
    public void m3894b(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : m4571a(serverLevel, 3, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (serverPlayer.tickCount > 20) {
                C1060tL c1060tL = new C1060tL("loadout" + this.f4554a.hashCode());
                if (C0875pn.m4445a(abstractC0863pb, uuid, c1060tL) == 0) {
                    C0875pn.m4447a(abstractC0863pb, uuid, c1060tL, 1);
                    C0875pn.m4457a(serverLevel, serverPlayer, this.f4554a);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0881pt
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0844pI mo3849d() {
        return new C0844pI(this.f4827c.x, this.f4827c.y, this.f4827c.z, this.f4826h.x, this.f4826h.y, this.f4554a);
    }
}
