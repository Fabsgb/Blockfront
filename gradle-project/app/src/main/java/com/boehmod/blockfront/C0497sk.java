package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.sk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sk.class */
public class C0497sk extends oV<C0500sn> {
    private static final int qM = 30;

    public C0497sk(@NotNull C0500sn c0500sn) {
        super(c0500sn);
    }

    public C0497sk(@NotNull C0500sn c0500sn, @NotNull ByteBuf byteBuf) throws IOException {
        super(c0500sn, byteBuf);
    }

    public C0497sk(@NotNull C0500sn c0500sn, @NotNull Player player, @NotNull String str) {
        super(c0500sn, player, str);
    }

    @Override // com.boehmod.blockfront.oV
    protected boolean c(@NotNull LivingEntity livingEntity) {
        return true;
    }

    @Override // com.boehmod.blockfront.oV
    protected boolean a(@NotNull oO oOVar, @NotNull oF<?, ?, ?> oFVar) {
        if (oFVar instanceof C0496sj) {
            oO oOVarF = ((C0496sj) oFVar).f();
            return oOVarF != null && oOVarF.equals(oOVar);
        }
        return true;
    }

    @Override // com.boehmod.blockfront.oV
    protected boolean bt() {
        return true;
    }

    @Override // com.boehmod.blockfront.oV
    protected int j(int i) {
        return 1;
    }

    @Override // com.boehmod.blockfront.oV
    public int bd() {
        return 30;
    }

    @Override // com.boehmod.blockfront.oV
    @Nullable
    /* JADX INFO: renamed from: c */
    public oO mo800c() {
        oO oOVar = this.e;
        if (oOVar != null) {
            return oOVar;
        }
        if (this.nm > 0) {
            return ((C0496sj) b().a()).f();
        }
        return null;
    }
}
