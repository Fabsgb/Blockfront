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

/* JADX INFO: renamed from: com.boehmod.blockfront.bd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bd.class */
public class C0112bd extends AbstractC0044aO {
    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        AbstractC1062tO abstractC1062tO = item instanceof AbstractC1062tO ? (AbstractC1062tO) item : null;
        m336a(abstractC1062tO instanceof C1144ur ? ((C1144ur) abstractC1062tO).m6329a(mainHandItem) : null, abstractC1062tO != null ? abstractC1062tO.m5935a() : C1051tD.m5836a(C1052tE.f5557fQ));
    }

    /* JADX INFO: renamed from: a */
    private void m336a(@Nullable C1108uH c1108uH, @NotNull C1051tD c1051tD) {
        C1051tD.f5552mt = C1051tD.f5551ms;
        C1051tD.f5551ms = Mth.lerp(0.6f, C1051tD.f5551ms, C1148uv.m6431a(c1051tD, c1108uH, C1144ur.f5994hR));
    }
}
