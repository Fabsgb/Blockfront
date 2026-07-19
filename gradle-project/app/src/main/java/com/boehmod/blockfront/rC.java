package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rC.class */
public class rC extends oV<rE> {
    public rC(@NotNull rE rEVar) {
        super(rEVar);
    }

    public rC(@NotNull rE rEVar, @NotNull ByteBuf byteBuf) throws IOException {
        super(rEVar, byteBuf);
    }

    public rC(@NotNull rE rEVar, @NotNull Player player, @NotNull String str) {
        super(rEVar, player, str);
    }

    @Override // com.boehmod.blockfront.oV
    protected boolean c(@NotNull LivingEntity livingEntity) {
        return true;
    }
}
