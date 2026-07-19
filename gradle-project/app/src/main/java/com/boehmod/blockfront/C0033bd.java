package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.bd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bd.class */
public class C0033bd extends aO {
    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        tO tOVar = item instanceof tO ? (tO) item : null;
        a(tOVar instanceof C0558ur ? ((C0558ur) tOVar).m1208a(mainHandItem) : null, tOVar != null ? tOVar.a() : tD.a(tE.fQ));
    }

    private void a(@Nullable uH uHVar, @NotNull tD tDVar) {
        tD.mt = tD.ms;
        tD.ms = Mth.lerp(0.6f, tD.ms, C0562uv.a(tDVar, uHVar, C0558ur.hR));
    }
}
