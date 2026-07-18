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

/* JADX INFO: renamed from: com.boehmod.blockfront.uC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uC.class */
public class C1103uC extends AbstractC1101uA<ClientLevel, LocalPlayer, C0326fV, C0622l> {

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Minecraft f5797e;

    /* JADX INFO: renamed from: sm */
    private static final int f5798sm = 8;

    /* JADX INFO: renamed from: sn */
    private static final int f5799sn = 8;

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6067a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        m6090a((C0622l) abstractC0563ju, (ClientLevel) level, (LocalPlayer) livingEntity, (List<C1141uo>) list);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6066a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        m6089a((C0622l) abstractC0563ju, (ClientLevel) level, (LocalPlayer) livingEntity, (List<C1142up>) list, randomSource, random, j, j2, i);
    }

    public C1103uC(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C1109uI c1109uI) {
        super(c0326fV, c1109uI);
        this.f5797e = minecraft;
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6065a(@NotNull LocalPlayer localPlayer, @NotNull C1144ur c1144ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        int iM6399ca = c1144ur.m6399ca();
        if (iM6399ca != -1 || randomSource.nextFloat() < c1144ur.m6400bw()) {
            C0051aV.f352l.add(new C0386gc((Holder<Item>) c1144ur.builtInRegistryHolder(), vec3, vec32, iM6399ca).m1849a());
            C0049aT.f304i.add(new C0023U(vec3.add(0.0d, 0.10000000149011612d, 0.0d), vec32.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, -838669));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6089a(@NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull List<C1142up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        C1194vo.m6653c(new C1242wj(List.copyOf(list), mo6063a(localPlayer), new Vec2(localPlayer.getXRot(), localPlayer.getYRot()), C1051tD.f5551ms, C0111bc.f675ch, j, j2, i));
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 8) {
            for (C1142up c1142up : list.subList(i2, Math.min(size, i2 + 8))) {
                LivingEntity entity = clientLevel.getEntity(c1142up.m6284al());
                if (entity instanceof LivingEntity) {
                    C0045aP.m209a(minecraft, c0622l, clientLevel, randomSource, random, localPlayer, entity, c1142up.m6291z(), c1142up.m6290b(), c1142up.m6286co());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6090a(@NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull List<C1141uo> list) {
        Minecraft minecraft = Minecraft.getInstance();
        RandomSource random = clientLevel.getRandom();
        int size = list.size();
        for (int i = 0; i < size; i += 8) {
            List listCopyOf = List.copyOf(list.subList(i, Math.min(size, i + 8)));
            C1194vo.m6653c(new C1240wh((List<C1141uo>) listCopyOf));
            Iterator it = listCopyOf.iterator();
            while (it.hasNext()) {
                C0045aP.m205a(minecraft, c0622l, clientLevel, random, localPlayer, (LivingEntity) localPlayer, (C1141uo) it.next(), 0);
            }
        }
        if (!list.isEmpty()) {
            C0045aP.m210a(minecraft, clientLevel, (C1141uo) list.getLast(), localPlayer.getEyePosition(), random);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec3 mo6068a(@NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource, @NotNull C1119uS c1119uS, int i, long j) {
        Vec2 vec2 = new Vec2(localPlayer.getXRot(), localPlayer.getYRot());
        C1122uV c1122uVM6226a = c1119uS.m6226a();
        if (c1122uVM6226a != null) {
            return m6069a(vec2, c1122uVM6226a, i, j, C1051tD.f5551ms, C0111bc.f675ch);
        }
        return m6070a(vec2, randomSource, C1051tD.f5551ms, C0111bc.f675ch);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec3 mo6064a(@NotNull LocalPlayer localPlayer, @NotNull C1144ur c1144ur) {
        if (!C1144ur.f5994hR) {
            return c1144ur.m6321A().zRot((((localPlayer.getXRot() + 90.0f) - C0111bc.f675ch) * 0.017453292f) - 1.5707964f).yRot(((-localPlayer.getYRot()) * 0.017453292f) - 1.5707964f);
        }
        return c1144ur.m6322B();
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6083a(@NotNull C0023U c0023u) {
        if (this.f5797e.getDebugOverlay().showDebugScreen()) {
            C0049aT.f304i.add(c0023u);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6084a(@NotNull C0022T c0022t) {
        if (this.f5797e.getDebugOverlay().showDebugScreen()) {
            C0049aT.f305j.add(c0022t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC1101uA
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC1281xd mo6085a(@NotNull C0622l c0622l, @NotNull ClientLevel clientLevel) {
        return new C1283xf(clientLevel, (int) clientLevel.getGameTime());
    }
}
