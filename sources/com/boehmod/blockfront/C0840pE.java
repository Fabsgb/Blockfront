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

/* JADX INFO: renamed from: com.boehmod.blockfront.pE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pE.class */
public final class C0840pE extends C0881pt {

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final Codec<C0840pE> f4533x = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0840pE -> {
            return Double.valueOf(c0840pE.f4827c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0840pE2 -> {
            return Double.valueOf(c0840pE2.f4827c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0840pE3 -> {
            return Double.valueOf(c0840pE3.f4827c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0840pE4 -> {
            return Float.valueOf(c0840pE4.f4826h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0840pE5 -> {
            return Float.valueOf(c0840pE5.f4826h.y);
        }), Codec.STRING.fieldOf("sound").forGetter(c0840pE6 -> {
            return c0840pE6.f4536cb;
        }), Codec.BOOL.fieldOf("hasMessage").forGetter(c0840pE7 -> {
            return Boolean.valueOf(c0840pE7.f4537gC);
        }), Codec.STRING.optionalFieldOf("message", "").forGetter(c0840pE8 -> {
            return c0840pE8.f4538cc != null ? c0840pE8.f4538cc : "";
        })).apply(instance, (d, d2, d3, f, f2, str, bool, str2) -> {
            C0840pE c0840pE9 = new C0840pE(str, d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue());
            c0840pE9.f4537gC = bool.booleanValue();
            c0840pE9.f4538cc = str2.isEmpty() ? null : str2;
            return c0840pE9;
        });
    });

    /* JADX INFO: renamed from: pG */
    public static final int f4534pG = 4;

    /* JADX INFO: renamed from: c */
    public C1060tL f4535c;

    /* JADX INFO: renamed from: cb */
    public String f4536cb;

    /* JADX INFO: renamed from: gC */
    public boolean f4537gC;

    /* JADX INFO: renamed from: cc */
    public String f4538cc;

    public C0840pE() {
        this.f4537gC = false;
    }

    public C0840pE(@NotNull String str, double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.f4537gC = false;
        this.f4536cb = str;
        this.f4535c = new C1060tL("blockLocation" + this.f4536cb);
    }

    /* JADX INFO: renamed from: a */
    public void m3847a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : m4571a(serverLevel, 4, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (serverPlayer.tickCount > 20 && C0875pn.m4445a(abstractC0863pb, uuid, this.f4535c) == 0) {
                C0875pn.m4447a(abstractC0863pb, uuid, this.f4535c, 1);
                Supplier<SoundEvent> supplierM7215d = C1272xL.m7215d(this.f4536cb);
                if (supplierM7215d != null) {
                    C0875pn.m4364a(serverPlayer, supplierM7215d.get(), SoundSource.NEUTRAL);
                }
                if (this.f4537gC) {
                    C0875pn.m4406c(serverPlayer, (Component) Component.literal(this.f4538cc));
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0881pt
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0840pE mo3849d() {
        return new C0840pE(this.f4536cb, this.f4827c.x, this.f4827c.y, this.f4827c.z, this.f4826h.x, this.f4826h.y);
    }
}
