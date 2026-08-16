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

/* JADX INFO: renamed from: com.boehmod.blockfront.pl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pl.class */
public final class C0873pl {

    /* JADX INFO: renamed from: pa */
    private final int f4762pa;

    /* JADX INFO: renamed from: pb */
    private final int f4763pb;

    /* JADX INFO: renamed from: pc */
    private int f4764pc;

    /* JADX INFO: renamed from: pd */
    private int f4765pd;

    /* JADX INFO: renamed from: pe */
    private int f4766pe;

    /* JADX INFO: renamed from: gz */
    private boolean f4767gz;

    /* JADX INFO: renamed from: gA */
    private boolean f4768gA;

    public C0873pl() {
        this.f4766pe = 0;
        this.f4767gz = false;
        this.f4768gA = false;
        this.f4764pc = 0;
        this.f4765pd = 0;
        this.f4762pa = 0;
        this.f4763pb = 0;
    }

    public C0873pl(int i, int i2) {
        this.f4766pe = 0;
        this.f4767gz = false;
        this.f4768gA = false;
        this.f4765pd = 60 * i;
        this.f4765pd += i2;
        this.f4764pc = this.f4765pd;
        this.f4762pa = this.f4765pd;
        this.f4763pb = this.f4765pd;
    }

    /* JADX INFO: renamed from: a */
    public C0873pl m4326a(int i) {
        this.f4766pe = i;
        this.f4767gz = true;
        return this;
    }

    /* JADX INFO: renamed from: cG */
    public void m4327cG() {
        this.f4764pc = this.f4762pa;
        this.f4765pd = this.f4763pb;
    }

    /* JADX INFO: renamed from: c */
    public void m4328c(@NotNull Set<UUID> set) {
        if (this.f4764pc >= 0) {
            this.f4764pc--;
        }
        if (this.f4767gz && this.f4764pc <= this.f4766pe) {
            m4329a(set, this.f4768gA);
            this.f4768gA = !this.f4768gA;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4329a(@NotNull Set<UUID> set, boolean z) {
        C0875pn.m4372a(set, (SoundEvent) (z ? C1312xz.f7993pO : C1312xz.f7994pP).get(), SoundSource.MASTER, 1.0f, 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f));
    }

    /* JADX INFO: renamed from: d */
    public MutableComponent m4330d() {
        return Component.literal(C0129bt.m602a(m4335bq())).withColor(this.f4764pc <= this.f4766pe ? ColorReferences.COLOR_STOPWATCH : ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: B */
    public void m4331B(int i) {
        this.f4764pc = i;
    }

    /* JADX INFO: renamed from: bC */
    public boolean m4332bC() {
        return this.f4764pc > 0;
    }

    /* JADX INFO: renamed from: R */
    public boolean m4333R() {
        return this.f4764pc <= 0;
    }

    /* JADX INFO: renamed from: bp */
    public int m4334bp() {
        return this.f4765pd - this.f4764pc;
    }

    /* JADX INFO: renamed from: bq */
    public int m4335bq() {
        return this.f4764pc;
    }

    /* JADX INFO: renamed from: r */
    public double m4336r() {
        return ((double) this.f4764pc) / ((double) this.f4765pd);
    }

    /* JADX INFO: renamed from: b */
    public void m4337b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4764pc = byteBuf.readInt();
        this.f4765pd = byteBuf.readInt();
        this.f4767gz = IPacket.readBoolean(byteBuf);
        this.f4766pe = byteBuf.readInt();
    }

    /* JADX INFO: renamed from: c */
    public void m4338c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4764pc);
        byteBuf.writeInt(this.f4765pd);
        IPacket.writeBoolean(byteBuf, this.f4767gz);
        byteBuf.writeInt(this.f4766pe);
    }
}
