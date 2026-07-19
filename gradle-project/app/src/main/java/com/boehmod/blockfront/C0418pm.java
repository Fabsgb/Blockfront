package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pm.class */
public final class C0418pm extends oX {

    @NotNull
    public static final Codec<C0418pm> B = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0418pm -> {
            return Double.valueOf(c0418pm.c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0418pm2 -> {
            return Double.valueOf(c0418pm2.c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0418pm3 -> {
            return Double.valueOf(c0418pm3.c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0418pm4 -> {
            return Float.valueOf(c0418pm4.h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0418pm5 -> {
            return Float.valueOf(c0418pm5.h.y);
        }), C0411pf.w.fieldOf("loadout").forGetter(c0418pm6 -> {
            return c0418pm6.a;
        })).apply(instance, (d, d2, d3, f, f2, c0411pf) -> {
            return new C0418pm(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), c0411pf);
        });
    });
    public static final int nK = 3;
    public C0411pf a;

    public C0418pm() {
    }

    public C0418pm(double d, double d2, double d3, float f, float f2, @NotNull C0411pf c0411pf) {
        super(d, d2, d3, f, f2);
        this.a = c0411pf;
    }

    public void b(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : a(serverLevel, 3, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (serverPlayer.tickCount > 20) {
                C0528to c0528to = new C0528to("loadout" + this.a.hashCode());
                if (oR.a(oFVar, uuid, c0528to) == 0) {
                    oR.m792a(oFVar, uuid, c0528to, 1);
                    oR.a(serverLevel, serverPlayer, this.a);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.oX
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0418pm d() {
        return new C0418pm(this.c.x, this.c.y, this.c.z, this.h.x, this.h.y, this.a);
    }
}
