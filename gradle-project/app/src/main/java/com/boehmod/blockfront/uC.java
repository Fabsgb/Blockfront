package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uC.class */
public class uC extends uA<ClientLevel, LocalPlayer, fV, C0297l> {

    @NotNull
    private final Minecraft e;
    private static final int sm = 8;
    private static final int sn = 8;

    @Override // com.boehmod.blockfront.uA
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        a((C0297l) abstractC0264ju, (ClientLevel) level, (LocalPlayer) livingEntity, (List<C0555uo>) list);
    }

    @Override // com.boehmod.blockfront.uA
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        a((C0297l) abstractC0264ju, (ClientLevel) level, (LocalPlayer) livingEntity, (List<C0556up>) list, randomSource, random, j, j2, i);
    }

    public uC(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull uI uIVar) {
        super(fVVar, uIVar);
        this.e = minecraft;
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull LocalPlayer localPlayer, @NotNull C0558ur c0558ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        int iCa = c0558ur.ca();
        if (iCa != -1 || randomSource.nextFloat() < c0558ur.bw()) {
            aV.l.add(new C0166gc((Holder<Item>) c0558ur.builtInRegistryHolder(), vec3, vec32, iCa).a());
            aT.i.add(new U(vec3.add(0.0d, 0.10000000149011612d, 0.0d), vec32.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, -838669));
        }
    }

    public void a(@NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull List<C0556up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        C0582vo.c(new C0604wj(List.copyOf(list), a(localPlayer), new Vec2(localPlayer.getXRot(), localPlayer.getYRot()), tD.ms, C0032bc.ch, j, j2, i));
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 8) {
            for (C0556up c0556up : list.subList(i2, Math.min(size, i2 + 8))) {
                LivingEntity entity = clientLevel.getEntity(c0556up.al());
                if (entity instanceof LivingEntity) {
                    aP.a(minecraft, c0297l, clientLevel, randomSource, random, localPlayer, entity, c0556up.z(), c0556up.b(), c0556up.co());
                }
            }
        }
    }

    public void a(@NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull List<C0555uo> list) {
        Minecraft minecraft = Minecraft.getInstance();
        RandomSource random = clientLevel.getRandom();
        int size = list.size();
        for (int i = 0; i < size; i += 8) {
            List listCopyOf = List.copyOf(list.subList(i, Math.min(size, i + 8)));
            C0582vo.c(new C0602wh((List<C0555uo>) listCopyOf));
            Iterator it = listCopyOf.iterator();
            while (it.hasNext()) {
                aP.a(minecraft, c0297l, clientLevel, random, localPlayer, (LivingEntity) localPlayer, (C0555uo) it.next(), 0);
            }
        }
        if (!list.isEmpty()) {
            aP.a(minecraft, clientLevel, (C0555uo) list.getLast(), localPlayer.getEyePosition(), random);
        }
    }

    @Override // com.boehmod.blockfront.uA
    public Vec3 a(@NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource, @NotNull uS uSVar, int i, long j) {
        Vec2 vec2 = new Vec2(localPlayer.getXRot(), localPlayer.getYRot());
        uV uVVarM1178a = uSVar.m1178a();
        if (uVVarM1178a != null) {
            return a(vec2, uVVarM1178a, i, j, tD.ms, C0032bc.ch);
        }
        return a(vec2, randomSource, tD.ms, C0032bc.ch);
    }

    @Override // com.boehmod.blockfront.uA
    @NotNull
    public Vec3 a(@NotNull LocalPlayer localPlayer, @NotNull C0558ur c0558ur) {
        if (!C0558ur.hR) {
            return c0558ur.A().zRot((((localPlayer.getXRot() + 90.0f) - C0032bc.ch) * 0.017453292f) - 1.5707964f).yRot(((-localPlayer.getYRot()) * 0.017453292f) - 1.5707964f);
        }
        return c0558ur.B();
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull U u) {
        if (this.e.getDebugOverlay().showDebugScreen()) {
            aT.i.add(u);
        }
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull T t) {
        if (this.e.getDebugOverlay().showDebugScreen()) {
            aT.j.add(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.uA
    @NotNull
    public InterfaceC0625xd a(@NotNull C0297l c0297l, @NotNull ClientLevel clientLevel) {
        return new C0627xf(clientLevel, (int) clientLevel.getGameTime());
    }
}
