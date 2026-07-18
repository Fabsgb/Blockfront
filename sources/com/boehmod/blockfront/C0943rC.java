package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rC.class */
public class C0943rC extends AbstractC0803oV<C0945rE> {
    public C0943rC(@NotNull C0945rE c0945rE) {
        super(c0945rE);
    }

    public C0943rC(@NotNull C0945rE c0945rE, @NotNull ByteBuf byteBuf) throws IOException {
        super(c0945rE, byteBuf);
    }

    public C0943rC(@NotNull C0945rE c0945rE, @NotNull Player player, @NotNull String str) {
        super(c0945rE, player, str);
    }

    @Override // com.boehmod.blockfront.AbstractC0803oV
    /* JADX INFO: renamed from: c */
    protected boolean mo4102c(@NotNull LivingEntity livingEntity) {
        return true;
    }
}
