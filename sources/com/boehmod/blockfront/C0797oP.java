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

/* JADX INFO: renamed from: com.boehmod.blockfront.oP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oP.class */
public final class C0797oP {

    /* JADX INFO: renamed from: nb */
    private final int f4366nb;

    /* JADX INFO: renamed from: nc */
    private final int f4367nc;

    /* JADX INFO: renamed from: nd */
    private int f4368nd;

    /* JADX INFO: renamed from: ne */
    private int f4369ne;

    /* JADX INFO: renamed from: nf */
    private int f4370nf;

    /* JADX INFO: renamed from: gf */
    private boolean f4371gf;

    /* JADX INFO: renamed from: gg */
    private boolean f4372gg;

    public C0797oP() {
        this.f4370nf = 0;
        this.f4371gf = false;
        this.f4372gg = false;
        this.f4368nd = 0;
        this.f4369ne = 0;
        this.f4366nb = 0;
        this.f4367nc = 0;
    }

    public C0797oP(int i, int i2) {
        this.f4370nf = 0;
        this.f4371gf = false;
        this.f4372gg = false;
        this.f4369ne = 60 * i;
        this.f4369ne += i2;
        this.f4368nd = this.f4369ne;
        this.f4366nb = this.f4369ne;
        this.f4367nc = this.f4369ne;
    }

    /* JADX INFO: renamed from: a */
    public C0797oP m3890a(int i) {
        this.f4370nf = i;
        this.f4371gf = true;
        return this;
    }

    /* JADX INFO: renamed from: cu */
    public void m3891cu() {
        this.f4368nd = this.f4366nb;
        this.f4369ne = this.f4367nc;
    }

    /* JADX INFO: renamed from: c */
    public void m3892c(@NotNull Set<UUID> set) {
        if (this.f4368nd >= 0) {
            this.f4368nd--;
        }
        if (this.f4371gf && this.f4368nd <= this.f4370nf) {
            m3893a(set, this.f4372gg);
            this.f4372gg = !this.f4372gg;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3893a(@NotNull Set<UUID> set, boolean z) {
        C0799oR.m3936a(set, (SoundEvent) (z ? C1280xc.f7581pM : C1280xc.f7582pN).get(), SoundSource.MASTER, 1.0f, 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f));
    }

    /* JADX INFO: renamed from: d */
    public MutableComponent m3894d() {
        return Component.literal(C0119bk.m502a(m3899bb())).withColor(this.f4368nd <= this.f4370nf ? ColorReferences.COLOR_STOPWATCH : ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: A */
    public void m3895A(int i) {
        this.f4368nd = i;
    }

    /* JADX INFO: renamed from: bs */
    public boolean m3896bs() {
        return this.f4368nd > 0;
    }

    /* JADX INFO: renamed from: P */
    public boolean m3897P() {
        return this.f4368nd <= 0;
    }

    /* JADX INFO: renamed from: ba */
    public int m3898ba() {
        return this.f4369ne - this.f4368nd;
    }

    /* JADX INFO: renamed from: bb */
    public int m3899bb() {
        return this.f4368nd;
    }

    /* JADX INFO: renamed from: p */
    public double m3900p() {
        return ((double) this.f4368nd) / ((double) this.f4369ne);
    }

    /* JADX INFO: renamed from: b */
    public void m3901b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4368nd = byteBuf.readInt();
        this.f4369ne = byteBuf.readInt();
        this.f4371gf = IPacket.readBoolean(byteBuf);
        this.f4370nf = byteBuf.readInt();
    }

    /* JADX INFO: renamed from: c */
    public void m3902c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4368nd);
        byteBuf.writeInt(this.f4369ne);
        IPacket.writeBoolean(byteBuf, this.f4371gf);
        byteBuf.writeInt(this.f4370nf);
    }
}
