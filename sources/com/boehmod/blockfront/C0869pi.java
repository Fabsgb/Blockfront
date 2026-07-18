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

/* JADX INFO: renamed from: com.boehmod.blockfront.pi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pi.class */
public final class C0869pi extends C0805oX {

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final Codec<C0869pi> f4564x = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0869pi -> {
            return Double.valueOf(c0869pi.f4424c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0869pi2 -> {
            return Double.valueOf(c0869pi2.f4424c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0869pi3 -> {
            return Double.valueOf(c0869pi3.f4424c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0869pi4 -> {
            return Float.valueOf(c0869pi4.f4423h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0869pi5 -> {
            return Float.valueOf(c0869pi5.f4423h.y);
        }), Codec.STRING.fieldOf("sound").forGetter(c0869pi6 -> {
            return c0869pi6.f4567bR;
        }), Codec.BOOL.fieldOf("hasMessage").forGetter(c0869pi7 -> {
            return Boolean.valueOf(c0869pi7.f4568gi);
        }), Codec.STRING.optionalFieldOf("message", "").forGetter(c0869pi8 -> {
            return c0869pi8.f4569bS != null ? c0869pi8.f4569bS : "";
        })).apply(instance, (d, d2, d3, f, f2, str, bool, str2) -> {
            C0869pi c0869pi9 = new C0869pi(str, d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue());
            c0869pi9.f4568gi = bool.booleanValue();
            c0869pi9.f4569bS = str2.isEmpty() ? null : str2;
            return c0869pi9;
        });
    });

    /* JADX INFO: renamed from: nH */
    public static final int f4565nH = 4;

    /* JADX INFO: renamed from: c */
    public C1088to f4566c;

    /* JADX INFO: renamed from: bR */
    public String f4567bR;

    /* JADX INFO: renamed from: gi */
    public boolean f4568gi;

    /* JADX INFO: renamed from: bS */
    public String f4569bS;

    public C0869pi() {
        this.f4568gi = false;
    }

    public C0869pi(@NotNull String str, double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.f4568gi = false;
        this.f4567bR = str;
        this.f4566c = new C1088to("blockLocation" + this.f4567bR);
    }

    /* JADX INFO: renamed from: a */
    public void m4362a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : m4134a(serverLevel, 4, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (serverPlayer.tickCount > 20 && C0799oR.m4009a(abstractC0787oF, uuid, this.f4566c) == 0) {
                C0799oR.m4011a(abstractC0787oF, uuid, this.f4566c, 1);
                Supplier<SoundEvent> supplierM7888d = C1292xo.m7888d(this.f4567bR);
                if (supplierM7888d != null) {
                    C0799oR.m3928a(serverPlayer, supplierM7888d.get(), SoundSource.NEUTRAL);
                }
                if (this.f4568gi) {
                    C0799oR.m3970c(serverPlayer, (Component) Component.literal(this.f4569bS));
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0805oX
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0869pi mo4124d() {
        return new C0869pi(this.f4567bR, this.f4424c.x, this.f4424c.y, this.f4424c.z, this.f4423h.x, this.f4423h.y);
    }
}
