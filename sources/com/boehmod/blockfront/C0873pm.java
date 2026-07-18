package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pm.class */
public final class C0873pm extends C0805oX {

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final Codec<C0873pm> f4583B = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0873pm -> {
            return Double.valueOf(c0873pm.f4424c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0873pm2 -> {
            return Double.valueOf(c0873pm2.f4424c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0873pm3 -> {
            return Double.valueOf(c0873pm3.f4424c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0873pm4 -> {
            return Float.valueOf(c0873pm4.f4423h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0873pm5 -> {
            return Float.valueOf(c0873pm5.f4423h.y);
        }), C0866pf.f4539w.fieldOf("loadout").forGetter(c0873pm6 -> {
            return c0873pm6.f4585a;
        })).apply(instance, (d, d2, d3, f, f2, c0866pf) -> {
            return new C0873pm(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), c0866pf);
        });
    });

    /* JADX INFO: renamed from: nK */
    public static final int f4584nK = 3;

    /* JADX INFO: renamed from: a */
    public C0866pf f4585a;

    public C0873pm() {
    }

    public C0873pm(double d, double d2, double d3, float f, float f2, @NotNull C0866pf c0866pf) {
        super(d, d2, d3, f, f2);
        this.f4585a = c0866pf;
    }

    /* JADX INFO: renamed from: b */
    public void m4406b(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : m4134a(serverLevel, 3, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (serverPlayer.tickCount > 20) {
                C1088to c1088to = new C1088to("loadout" + this.f4585a.hashCode());
                if (C0799oR.m4009a(abstractC0787oF, uuid, c1088to) == 0) {
                    C0799oR.m4011a(abstractC0787oF, uuid, c1088to, 1);
                    C0799oR.m4021a(serverLevel, serverPlayer, this.f4585a);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0805oX
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0873pm mo4124d() {
        return new C0873pm(this.f4424c.x, this.f4424c.y, this.f4424c.z, this.f4423h.x, this.f4423h.y, this.f4585a);
    }
}
