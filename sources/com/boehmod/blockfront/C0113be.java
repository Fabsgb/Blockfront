package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0729nA;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.be */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/be.class */
public class C0113be extends AbstractC0044aO {
    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        int iM3297a;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0779ny)) {
            return;
        }
        AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
        boolean zIsLeftPressed = minecraft.mouseHandler.isLeftPressed();
        C0732nD c0732nDM3535a = abstractC0779ny.m3535a((Entity) localPlayer);
        if (c0732nDM3535a == null) {
            return;
        }
        for (AbstractC0742nN<?> abstractC0742nN : c0732nDM3535a.m3327b()) {
            if (abstractC0742nN instanceof C0740nL) {
                C0740nL c0740nL = (C0740nL) abstractC0742nN;
                if (c0740nL.m3391a() == EnumC0741nM.BULLET) {
                    C1144ur c1144ur = (C1144ur) c0740nL.m3392c().get();
                    C1118uR c1118uRM6408a = c1144ur.m6408a(new ItemStack(c1144ur));
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6163w = c1118uRM6408a.m6163w();
                    boolean z2 = c0740nL.f4004fz && !c0740nL.f4005fA;
                    if (!zIsLeftPressed && !z2) {
                        c0740nL.f4004fz = false;
                    } else if (c0740nL.f4003ml <= 0) {
                        if (deferredHolderM6163w != null && !c0740nL.f4004fz) {
                            c0740nL.f4004fz = true;
                            c0740nL.f4005fA = false;
                            c0740nL.f4003ml = c1118uRM6408a.m6218cf();
                            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6163w.get(), 1.0f, 5.0f));
                        } else {
                            C1119uS c1119uSM6347a = c1144ur.m6347a();
                            c0740nL.f4003ml = c1119uSM6347a.m6222cg() - ((c1119uSM6347a.m6221a() != EnumC1120uT.SEMI || deferredHolderM6163w == null) ? 0 : c1118uRM6408a.m6218cf());
                            if (vehicle instanceof AbstractC0729nA) {
                                AbstractC0729nA abstractC0729nA = (AbstractC0729nA) vehicle;
                                SynchedEntityData entityData = abstractC0729nA.getEntityData();
                                AbstractC0729nA.a aVarM3290a = abstractC0729nA.m3290a(c0740nL);
                                if (aVarM3290a != null && (iM3297a = aVarM3290a.m3297a(entityData)) > 0) {
                                    m337a(minecraft, c0326fV, c0622l, localPlayer, clientLevel, c1144ur);
                                    aVarM3290a.m3298a(entityData, iM3297a - 1);
                                }
                            }
                            if (deferredHolderM6163w != null) {
                                if (!c1118uRM6408a.m6215cM()) {
                                    c0740nL.f4004fz = false;
                                }
                                c0740nL.f4005fA = true;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m337a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, C1144ur c1144ur) {
        C1103uC c1103uCM2687a = c0622l.m2687a(minecraft, c0326fV, c1144ur.m6394a());
        int gameTime = (int) clientLevel.getGameTime();
        long jNextLong = clientLevel.random.nextLong();
        c1103uCM2687a.mo6062a(c0622l, clientLevel, RandomSource.create(jNextLong), ThreadLocalRandom.current(), localPlayer, c1144ur, gameTime, jNextLong, 0);
        C1194vo.m6653c(new C1234wb());
        C0467iD.m2105a(minecraft, c0622l, c0326fV, localPlayer, clientLevel, new ItemStack(c1144ur), c1144ur, localPlayer.position(), true, false, false, 0);
        C0415hE.m1960a(c1144ur.getShakeNodeData());
    }
}
