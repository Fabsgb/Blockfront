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

/* JADX INFO: renamed from: com.boehmod.blockfront.bl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bl.class */
public class C0121bl extends AbstractC0053aW {
    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        AbstractC1140um abstractC1140um = item instanceof AbstractC1140um ? (AbstractC1140um) item : null;
        m429a(abstractC1140um instanceof C1117uP ? ((C1117uP) abstractC1140um).m6296a(mainHandItem) : null, abstractC1140um != null ? abstractC1140um.m6568a() : C1129ub.m6472a(C1130uc.f6196fP));
    }

    /* JADX INFO: renamed from: a */
    private void m429a(@Nullable C1188vh c1188vh, @NotNull C1129ub c1129ub) {
        C1129ub.f6191ns = C1129ub.f6190nr;
        C1129ub.f6190nr = Mth.lerp(0.6f, C1129ub.f6190nr, C1123uV.m6417a(c1129ub, c1188vh));
    }
}
