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

/* JADX INFO: renamed from: com.boehmod.blockfront.vc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vc.class */
public class C1183vc extends AbstractC1181va<ClientLevel, LocalPlayer, C0396gl, C0623l> {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Minecraft f6438d;

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6718a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        m6742a((C0623l) abstractC0531jN, (ClientLevel) level, (LocalPlayer) livingEntity, (List<C1114uM>) list);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6717a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        m6741a((C0623l) abstractC0531jN, (ClientLevel) level, (LocalPlayer) livingEntity, (List<C1115uN>) list, randomSource, random, j, j2, i);
    }

    public C1183vc(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C1189vi c1189vi) {
        super(c0396gl, c1189vi);
        this.f6438d = minecraft;
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6716a(@NotNull LocalPlayer localPlayer, @NotNull C1117uP c1117uP, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        int iM6374cp = c1117uP.m6374cp();
        if (iM6374cp != -1 || randomSource.nextFloat() < c1117uP.m6375bC()) {
            C0113bd.f766m.add(new C0403gs((Holder<Item>) c1117uP.builtInRegistryHolder(), vec3, vec4, iM6374cp).m1913a());
            C0111bb.f718j.add(new C0057aa(vec3.add(0.0d, 0.10000000149011612d, 0.0d), vec4.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, -838669));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6741a(@NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull List<C1115uN> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        for (C1115uN c1115uN : list) {
            LivingEntity entity = clientLevel.getEntity(c1115uN.m6248aB());
            if (entity instanceof LivingEntity) {
                C0054aX.m251a(minecraft, c0623l, clientLevel, randomSource, random, localPlayer, entity, c1115uN.m6255A(), c1115uN.m6254b(), c1115uN.m6250an());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6742a(@NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull List<C1114uM> list) {
        Minecraft minecraft = Minecraft.getInstance();
        RandomSource random = clientLevel.getRandom();
        Iterator<C1114uM> it = list.iterator();
        while (it.hasNext()) {
            C0054aX.m247a(minecraft, c0623l, clientLevel, random, localPlayer, (LivingEntity) localPlayer, it.next(), 0);
        }
        if (!list.isEmpty()) {
            C0054aX.m252a(minecraft, clientLevel, (C1114uM) list.getLast(), localPlayer.getEyePosition(), random);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec3 mo6719a(@NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource, @NotNull C1199vs c1199vs, int i, long j) {
        Vec2 vec2 = new Vec2(localPlayer.getXRot(), localPlayer.getYRot());
        C1202vv c1202vvM6879a = c1199vs.m6879a();
        if (c1202vvM6879a != null) {
            return m6720a(vec2, c1202vvM6879a, i, j, C1129ub.f6190nr, C0120bk.f806cn);
        }
        return m6721a(vec2, randomSource, C1129ub.f6190nr, C0120bk.f806cn);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec3 mo6715a(@NotNull LocalPlayer localPlayer, @NotNull C1117uP c1117uP) {
        if (!C1117uP.f6063il) {
            return c1117uP.m6287B().zRot((((localPlayer.getXRot() + 90.0f) - C0120bk.f806cn) * 0.017453292f) - 1.5707964f).yRot(((-localPlayer.getYRot()) * 0.017453292f) - 1.5707964f);
        }
        return c1117uP.m6288C();
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6735a(@NotNull C0057aa c0057aa) {
        if (this.f6438d.getDebugOverlay().showDebugScreen()) {
            C0111bb.f718j.add(c0057aa);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6736a(@NotNull C0029Z c0029z) {
        if (this.f6438d.getDebugOverlay().showDebugScreen()) {
            C0111bb.f719k.add(c0029z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC1181va
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC1261xA mo6737a(@NotNull C0623l c0623l, @NotNull ClientLevel clientLevel) {
        return new C1263xC(clientLevel, (int) clientLevel.getGameTime());
    }
}
