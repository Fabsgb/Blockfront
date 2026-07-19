package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pi.class */
public final class C0414pi extends oX {

    @NotNull
    public static final Codec<C0414pi> x = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0414pi -> {
            return Double.valueOf(c0414pi.c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0414pi2 -> {
            return Double.valueOf(c0414pi2.c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0414pi3 -> {
            return Double.valueOf(c0414pi3.c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0414pi4 -> {
            return Float.valueOf(c0414pi4.h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0414pi5 -> {
            return Float.valueOf(c0414pi5.h.y);
        }), Codec.STRING.fieldOf("sound").forGetter(c0414pi6 -> {
            return c0414pi6.bR;
        }), Codec.BOOL.fieldOf("hasMessage").forGetter(c0414pi7 -> {
            return Boolean.valueOf(c0414pi7.gi);
        }), Codec.STRING.optionalFieldOf("message", "").forGetter(c0414pi8 -> {
            return c0414pi8.bS != null ? c0414pi8.bS : "";
        })).apply(instance, (d, d2, d3, f, f2, str, bool, str2) -> {
            C0414pi c0414pi9 = new C0414pi(str, d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue());
            c0414pi9.gi = bool.booleanValue();
            c0414pi9.bS = str2.isEmpty() ? null : str2;
            return c0414pi9;
        });
    });
    public static final int nH = 4;
    public C0528to c;
    public String bR;
    public boolean gi;
    public String bS;

    public C0414pi() {
        this.gi = false;
    }

    public C0414pi(@NotNull String str, double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.gi = false;
        this.bR = str;
        this.c = new C0528to("blockLocation" + this.bR);
    }

    public void a(@NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : a(serverLevel, 4, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (serverPlayer.tickCount > 20 && oR.a(oFVar, uuid, this.c) == 0) {
                oR.m792a(oFVar, uuid, this.c, 1);
                Supplier<SoundEvent> supplierD = C0636xo.d(this.bR);
                if (supplierD != null) {
                    oR.a(serverPlayer, supplierD.get(), SoundSource.NEUTRAL);
                }
                if (this.gi) {
                    oR.c(serverPlayer, (Component) Component.literal(this.bS));
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.oX
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0414pi d() {
        return new C0414pi(this.bR, this.c.x, this.c.y, this.c.z, this.h.x, this.h.y);
    }
}
