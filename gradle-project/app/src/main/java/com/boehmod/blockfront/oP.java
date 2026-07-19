package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oP.class */
public final class oP {
    private final int nb;
    private final int nc;
    private int nd;
    private int ne;
    private int nf;
    private boolean gf;

    /* JADX INFO: renamed from: gg, reason: collision with root package name */
    private boolean f419gg;

    public oP() {
        this.nf = 0;
        this.gf = false;
        this.f419gg = false;
        this.nd = 0;
        this.ne = 0;
        this.nb = 0;
        this.nc = 0;
    }

    public oP(int i, int i2) {
        this.nf = 0;
        this.gf = false;
        this.f419gg = false;
        this.ne = 60 * i;
        this.ne += i2;
        this.nd = this.ne;
        this.nb = this.ne;
        this.nc = this.ne;
    }

    public oP a(int i) {
        this.nf = i;
        this.gf = true;
        return this;
    }

    public void cu() {
        this.nd = this.nb;
        this.ne = this.nc;
    }

    public void c(@NotNull Set<UUID> set) {
        if (this.nd >= 0) {
            this.nd--;
        }
        if (this.gf && this.nd <= this.nf) {
            a(set, this.f419gg);
            this.f419gg = !this.f419gg;
        }
    }

    public static void a(@NotNull Set<UUID> set, boolean z) {
        oR.a(set, (SoundEvent) (z ? C0624xc.pM : C0624xc.pN).get(), SoundSource.MASTER, 1.0f, 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f));
    }

    public MutableComponent d() {
        return Component.literal(C0040bk.a(bb())).withColor(this.nd <= this.nf ? ColorReferences.COLOR_STOPWATCH : ColorReferences.COLOR_WHITE);
    }

    public void A(int i) {
        this.nd = i;
    }

    public boolean bs() {
        return this.nd > 0;
    }

    public boolean P() {
        return this.nd <= 0;
    }

    public int ba() {
        return this.ne - this.nd;
    }

    public int bb() {
        return this.nd;
    }

    public double p() {
        return ((double) this.nd) / ((double) this.ne);
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.nd = byteBuf.readInt();
        this.ne = byteBuf.readInt();
        this.gf = IPacket.readBoolean(byteBuf);
        this.nf = byteBuf.readInt();
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.nd);
        byteBuf.writeInt(this.ne);
        IPacket.writeBoolean(byteBuf, this.gf);
        byteBuf.writeInt(this.nf);
    }
}
