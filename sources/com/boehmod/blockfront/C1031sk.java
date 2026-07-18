package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.sk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sk.class */
public class C1031sk extends AbstractC0803oV<C1034sn> {

    /* JADX INFO: renamed from: qM */
    private static final int f5485qM = 30;

    public C1031sk(@NotNull C1034sn c1034sn) {
        super(c1034sn);
    }

    public C1031sk(@NotNull C1034sn c1034sn, @NotNull ByteBuf byteBuf) throws IOException {
        super(c1034sn, byteBuf);
    }

    public C1031sk(@NotNull C1034sn c1034sn, @NotNull Player player, @NotNull String str) {
        super(c1034sn, player, str);
    }

    @Override // com.boehmod.blockfront.AbstractC0803oV
    /* JADX INFO: renamed from: c */
    protected boolean mo4102c(@NotNull LivingEntity livingEntity) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0803oV
    /* JADX INFO: renamed from: a */
    protected boolean mo4103a(@NotNull C0796oO c0796oO, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (abstractC0787oF instanceof C1030sj) {
            C0796oO c0796oOM5749f = ((C1030sj) abstractC0787oF).m5749f();
            return c0796oOM5749f != null && c0796oOM5749f.equals(c0796oO);
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0803oV
    /* JADX INFO: renamed from: bt */
    protected boolean mo4104bt() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0803oV
    /* JADX INFO: renamed from: j */
    protected int mo4106j(int i) {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0803oV
    /* JADX INFO: renamed from: bd */
    public int mo4107bd() {
        return 30;
    }

    @Override // com.boehmod.blockfront.AbstractC0803oV
    @Nullable
    /* JADX INFO: renamed from: c */
    public C0796oO mo4105c() {
        C0796oO c0796oO = this.f4403e;
        if (c0796oO != null) {
            return c0796oO;
        }
        if (this.f4405nm > 0) {
            return ((C1030sj) m4100b().m3771a()).m5749f();
        }
        return null;
    }
}
