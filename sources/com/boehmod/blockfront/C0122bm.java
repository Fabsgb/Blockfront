package com.boehmod.blockfront;

import java.util.List;
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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bm.class */
public class C0122bm extends AbstractC0053aW {
    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        int iM3484a;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0750nU)) {
            return;
        }
        AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
        boolean zIsLeftPressed = minecraft.mouseHandler.isLeftPressed();
        C0755nZ c0755nZM3472a = abstractC0750nU.m3472a((Entity) localPlayer);
        if (c0755nZM3472a == null) {
            return;
        }
        for (AbstractC0818oj<?> abstractC0818oj : c0755nZM3472a.m3514c()) {
            if (abstractC0818oj instanceof C0816oh) {
                C0816oh c0816oh = (C0816oh) abstractC0818oj;
                if (c0816oh.m3763a() == EnumC0817oi.BULLET) {
                    C1117uP c1117uP = (C1117uP) c0816oh.m3764c().get();
                    C1198vr c1198vrM6384a = c1117uP.m6384a(new ItemStack(c1117uP));
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6816w = c1198vrM6384a.m6816w();
                    boolean z2 = c0816oh.f4432fT && !c0816oh.f4433fU;
                    if (!zIsLeftPressed && !z2) {
                        c0816oh.f4432fT = false;
                    } else if (c0816oh.f4431oj <= 0) {
                        if (deferredHolderM6816w != null && !c0816oh.f4432fT) {
                            c0816oh.f4432fT = true;
                            c0816oh.f4433fU = false;
                            c0816oh.f4431oj = c1198vrM6384a.m6871cv();
                            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6816w.get(), 1.0f, 5.0f));
                        } else {
                            C1199vs c1199vsM6316a = c1117uP.m6316a();
                            c0816oh.f4431oj = c1199vsM6316a.m6875cw() - c1117uP.m6322a(c1199vsM6316a, c1198vrM6384a);
                            if (vehicle instanceof AbstractC0752nW) {
                                AbstractC0752nW abstractC0752nW = (AbstractC0752nW) vehicle;
                                SynchedEntityData entityData = abstractC0752nW.getEntityData();
                                AbstractC0752nW.a aVarM3479a = abstractC0752nW.m3479a(c0816oh);
                                if (aVarM3479a != null && (iM3484a = aVarM3479a.m3484a(entityData)) > 0) {
                                    m430a(minecraft, c0396gl, c0623l, localPlayer, clientLevel, c1117uP);
                                    aVarM3479a.m3485a(entityData, iM3484a - 1);
                                }
                            }
                            if (deferredHolderM6816w != null) {
                                if (!c1198vrM6384a.m6868cV()) {
                                    c0816oh.f4432fT = false;
                                }
                                c0816oh.f4433fU = true;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m430a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, C1117uP c1117uP) {
        C1183vc c1183vcM2873a = c0623l.m2873a(minecraft, c0396gl, c1117uP.m6369a());
        long gameTime = clientLevel.getGameTime();
        long jM6413a = C1121uT.m6413a(localPlayer.getUUID(), gameTime);
        c1183vcM2873a.mo6713a(c0623l, clientLevel, RandomSource.create(jM6413a), ThreadLocalRandom.current(), localPlayer, c1117uP, c1117uP.m6316a(), gameTime, jM6413a, 0);
        C1169vO.m6648c(new C1218wK(localPlayer.getEyePosition(), new Vec2(localPlayer.getXRot(), localPlayer.getYRot()), C1129ub.f6190nr, C0120bk.f806cn, gameTime, List.of(new C1120uS(0, List.copyOf(c1183vcM2873a.m6710aO()), List.copyOf(c1183vcM2873a.m6709aN())))));
        C0487iW.m2197a(minecraft, c0623l, c0396gl, localPlayer, clientLevel, new ItemStack(c1117uP), c1117uP, localPlayer.position(), true, false, false, 0);
        C0432hU.m1986a(c1117uP.getShakeNodeData());
    }
}
