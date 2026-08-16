package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vf.class */
public class C1186vf extends AbstractC1181va<ServerLevel, LivingEntity, C1328yo, C1280xT> {

    /* JADX INFO: renamed from: us */
    private static final int f6443us = 10747841;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C1264xD f6444d;

    /* JADX INFO: renamed from: P */
    private final long f6445P;

    /* JADX INFO: renamed from: ut */
    private final int f6446ut;

    /* JADX INFO: renamed from: ok */
    private final float f6447ok;

    /* JADX INFO: renamed from: ol */
    private final float f6448ol;

    /* JADX INFO: renamed from: aw */
    @NotNull
    private final Vec3 f6449aw;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Vec2 f6450n;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final ServerPlayer f6451d;

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6718a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        m6760a((C1280xT) abstractC0531jN, (ServerLevel) level, livingEntity, (List<C1114uM>) list);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6717a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        m6759a((C1280xT) abstractC0531jN, (ServerLevel) level, livingEntity, (List<C1115uN>) list, randomSource, random, j, j2, i);
    }

    public C1186vf(@NotNull ServerPlayer serverPlayer, @NotNull C1328yo c1328yo, @NotNull C1189vi c1189vi, @NotNull C1264xD c1264xD, @NotNull Vec3 vec3, @NotNull Vec2 vec2, float f, float f2, long j, int i) {
        super(c1328yo, c1189vi);
        this.f6451d = serverPlayer;
        this.f6444d = c1264xD;
        this.f6449aw = vec3;
        this.f6450n = vec2;
        this.f6445P = j;
        this.f6446ut = i;
        this.f6447ok = f;
        this.f6448ol = f2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C1115uN> m6757a(@NotNull C1280xT c1280xT, @NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull C1117uP c1117uP, @NotNull C1199vs c1199vs, long j, long j2, int i) {
        m6708bd();
        mo6713a(c1280xT, serverLevel, randomSource, random, livingEntity, c1117uP, c1199vs, j, j2, i);
        return new ObjectArrayList(this.f6429cn);
    }

    @NotNull
    /* JADX INFO: renamed from: aP */
    public List<C1114uM> m6758aP() {
        return new ObjectArrayList(this.f6427cm);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6716a(@NotNull LivingEntity livingEntity, @NotNull C1117uP c1117uP, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        int iM6374cp = c1117uP.m6374cp();
        if (iM6374cp != -1 || randomSource.nextFloat() < c1117uP.m6375bC()) {
            C1217wJ c1217wJ = new C1217wJ(this.f6451d.getId(), new C0403gs((Holder<Item>) c1117uP.builtInRegistryHolder(), vec3, vec4, iM6374cp));
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (abstractC0531jNM179a != null) {
                AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a = abstractC0531jNM179a.m2353a((Player) this.f6451d);
                if (abstractC0863pbM2353a != null) {
                    Iterator<UUID> it = abstractC0863pbM2353a.m4018b().m4245h().iterator();
                    while (it.hasNext()) {
                        ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
                        if (serverPlayerM4399a != null && !serverPlayerM4399a.equals(this.f6451d)) {
                            C1169vO.m6643a(c1217wJ, serverPlayerM4399a);
                        }
                    }
                    return;
                }
                for (ServerPlayer serverPlayer : this.f6451d.level().players()) {
                    if (serverPlayer instanceof ServerPlayer) {
                        ServerPlayer serverPlayer2 = serverPlayer;
                        if (!serverPlayer2.equals(this.f6451d)) {
                            C1169vO.m6643a(c1217wJ, serverPlayer2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6759a(@NotNull C1280xT c1280xT, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1115uN> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
    }

    /* JADX INFO: renamed from: a */
    public void m6760a(@NotNull C1280xT c1280xT, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1114uM> list) {
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Vec3 mo6714a(@NotNull LivingEntity livingEntity) {
        return this.f6449aw;
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public Vec3 mo6719a(@NotNull LivingEntity livingEntity, @NotNull RandomSource randomSource, @NotNull C1199vs c1199vs, int i, long j) {
        C1202vv c1202vvM6879a = c1199vs.m6879a();
        if (c1202vvM6879a != null) {
            return m6720a(this.f6450n, c1202vvM6879a, i, j, this.f6447ok, this.f6448ol);
        }
        return m6721a(this.f6450n, randomSource, this.f6447ok, this.f6448ol);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 mo6715a(@NotNull LivingEntity livingEntity, @NotNull C1117uP c1117uP) {
        return c1117uP.m6287B().zRot(((livingEntity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-livingEntity.getYRot()) * 0.017453292f) - 1.5707964f);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6735a(@NotNull C0057aa c0057aa) {
        if (this.f6451d.isCreative()) {
            C1169vO.m6643a(new C1167vM(c0057aa.m256a(f6443us)), this.f6451d);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6736a(@NotNull C0029Z c0029z) {
        if (this.f6451d.isCreative()) {
            C1169vO.m6643a(new C1166vL(c0029z.m169a(f6443us)), this.f6451d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC1181va
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC1261xA mo6737a(@NotNull C1280xT c1280xT, @NotNull ServerLevel serverLevel) {
        return new C1262xB(this.f6444d, this.f6445P, this.f6446ut);
    }
}
