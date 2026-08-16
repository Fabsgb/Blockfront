package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C1154v;
import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/ClientPacketListenerMixin.class */
@Mixin({ClientPacketListener.class})
public class ClientPacketListenerMixin {
    @Inject(method = {"handleMovePlayer", "handleLookAt", "handleRespawn", "handleLogin"}, at = {@At("RETURN")})
    private void bf$suspendRotationIntegrity(CallbackInfo callbackInfo) {
        C1154v.m6581o();
    }
}
