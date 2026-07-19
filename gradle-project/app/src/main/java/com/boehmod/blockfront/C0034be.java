package com.boehmod.blockfront;

import com.boehmod.blockfront.nA;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.be, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/be.class */
public class C0034be extends aO {
    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        int iM711a;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0376ny)) {
            return;
        }
        AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
        boolean zIsLeftPressed = minecraft.mouseHandler.isLeftPressed();
        nD nDVarA = abstractC0376ny.a((Entity) localPlayer);
        if (nDVarA == null) {
            return;
        }
        for (nN<?> nNVar : nDVarA.m715b()) {
            if (nNVar instanceof nL) {
                nL nLVar = (nL) nNVar;
                if (nLVar.m724a() == nM.BULLET) {
                    C0558ur c0558ur = (C0558ur) nLVar.c().get();
                    uR uRVarM1221a = c0558ur.m1221a(new ItemStack(c0558ur));
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolderW = uRVarM1221a.w();
                    boolean z2 = nLVar.fz && !nLVar.fA;
                    if (!zIsLeftPressed && !z2) {
                        nLVar.fz = false;
                    } else if (nLVar.ml <= 0) {
                        if (deferredHolderW != null && !nLVar.fz) {
                            nLVar.fz = true;
                            nLVar.fA = false;
                            nLVar.ml = uRVarM1221a.cf();
                            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderW.get(), 1.0f, 5.0f));
                        } else {
                            uS uSVarM1210a = c0558ur.m1210a();
                            nLVar.ml = uSVarM1210a.cg() - ((uSVarM1210a.a() != uT.SEMI || deferredHolderW == null) ? 0 : uRVarM1221a.cf());
                            if (vehicle instanceof nA) {
                                nA nAVar = (nA) vehicle;
                                SynchedEntityData entityData = nAVar.getEntityData();
                                nA.a aVarA = nAVar.a(nLVar);
                                if (aVarA != null && (iM711a = aVarA.m711a(entityData)) > 0) {
                                    a(minecraft, fVVar, c0297l, localPlayer, clientLevel, c0558ur);
                                    aVarA.a(entityData, iM711a - 1);
                                }
                            }
                            if (deferredHolderW != null) {
                                if (!uRVarM1221a.cM()) {
                                    nLVar.fz = false;
                                }
                                nLVar.fA = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, C0558ur c0558ur) {
        uC uCVarA = c0297l.a(minecraft, fVVar, c0558ur.m1216a());
        int gameTime = (int) clientLevel.getGameTime();
        long jNextLong = clientLevel.random.nextLong();
        uCVarA.a(c0297l, clientLevel, RandomSource.create(jNextLong), ThreadLocalRandom.current(), localPlayer, c0558ur, gameTime, jNextLong, 0);
        C0582vo.c(new C0596wb());
        iD.a(minecraft, c0297l, fVVar, localPlayer, clientLevel, new ItemStack(c0558ur), c0558ur, localPlayer.position(), true, false, false, 0);
        hE.a(c0558ur.getShakeNodeData());
    }
}
