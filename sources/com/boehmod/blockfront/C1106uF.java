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

/* JADX INFO: renamed from: com.boehmod.blockfront.uF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uF.class */
public class C1106uF extends AbstractC1101uA<ServerLevel, LivingEntity, C1276xQ, C1300xw> {

    /* JADX INFO: renamed from: so */
    private static final int f5804so = 10747841;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C1284xg f5805c;

    /* JADX INFO: renamed from: u */
    private final long f5806u;

    /* JADX INFO: renamed from: sp */
    private final int f5807sp;

    /* JADX INFO: renamed from: nm */
    private final float f5808nm;

    /* JADX INFO: renamed from: nn */
    private final float f5809nn;

    /* JADX INFO: renamed from: av */
    @NotNull
    private final Vec3 f5810av;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Vec2 f5811n;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final ServerPlayer f5812c;

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6067a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        m6107a((C1300xw) abstractC0563ju, (ServerLevel) level, livingEntity, (List<C1141uo>) list);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6066a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        m6106a((C1300xw) abstractC0563ju, (ServerLevel) level, livingEntity, (List<C1142up>) list, randomSource, random, j, j2, i);
    }

    public C1106uF(@NotNull ServerPlayer serverPlayer, @NotNull C1276xQ c1276xQ, @NotNull C1109uI c1109uI, @NotNull C1284xg c1284xg, @NotNull Vec3 vec3, @NotNull Vec2 vec2, float f, float f2, long j, int i) {
        super(c1276xQ, c1109uI);
        this.f5812c = serverPlayer;
        this.f5805c = c1284xg;
        this.f5810av = vec3;
        this.f5811n = vec2;
        this.f5806u = j;
        this.f5807sp = i;
        this.f5808nm = f;
        this.f5809nn = f2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C1142up> m6104a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull C1144ur c1144ur, long j, long j2, int i) {
        m6105dt();
        mo6062a(c1300xw, serverLevel, randomSource, random, livingEntity, c1144ur, j, j2, i);
        return new ObjectArrayList(this.f5788ce);
    }

    /* JADX INFO: renamed from: dt */
    private void m6105dt() {
        this.f5788ce.clear();
        this.f5787d.clear();
        this.f5786cd.clear();
        this.f5790mS = 0.0f;
        this.f5791at = null;
        this.f5794aT = 0.0d;
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6065a(@NotNull LivingEntity livingEntity, @NotNull C1144ur c1144ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        int iM6399ca = c1144ur.m6399ca();
        if (iM6399ca != -1 || randomSource.nextFloat() < c1144ur.m6400bw()) {
            C1245wm c1245wm = new C1245wm(this.f5812c.getId(), new C0386gc((Holder<Item>) c1144ur.builtInRegistryHolder(), vec3, vec32, iM6399ca));
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (abstractC0563juM168a != null) {
                AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a = abstractC0563juM168a.m2530a((Player) this.f5812c);
                if (abstractC0787oFM2530a != null) {
                    Iterator<UUID> it = abstractC0787oFM2530a.m3582b().m3809h().iterator();
                    while (it.hasNext()) {
                        ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
                        if (serverPlayerM3963a != null && !serverPlayerM3963a.equals(this.f5812c)) {
                            C1194vo.m6648a(c1245wm, serverPlayerM3963a);
                        }
                    }
                    return;
                }
                for (ServerPlayer serverPlayer : this.f5812c.level().players()) {
                    if (serverPlayer instanceof ServerPlayer) {
                        ServerPlayer serverPlayer2 = serverPlayer;
                        if (!serverPlayer2.equals(this.f5812c)) {
                            C1194vo.m6648a(c1245wm, serverPlayer2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6106a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1142up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
    }

    /* JADX INFO: renamed from: a */
    public void m6107a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1141uo> list) {
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Vec3 mo6063a(@NotNull LivingEntity livingEntity) {
        return this.f5810av;
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public Vec3 mo6068a(@NotNull LivingEntity livingEntity, @NotNull RandomSource randomSource, @NotNull C1119uS c1119uS, int i, long j) {
        C1122uV c1122uVM6226a = c1119uS.m6226a();
        if (c1122uVM6226a != null) {
            return m6069a(this.f5811n, c1122uVM6226a, i, j, this.f5808nm, this.f5809nn);
        }
        return m6070a(this.f5811n, randomSource, this.f5808nm, this.f5809nn);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 mo6064a(@NotNull LivingEntity livingEntity, @NotNull C1144ur c1144ur) {
        return c1144ur.m6321A().zRot(((livingEntity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-livingEntity.getYRot()) * 0.017453292f) - 1.5707964f);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6083a(@NotNull C0023U c0023u) {
        if (this.f5812c.isCreative()) {
            C1194vo.m6648a(new C1192vm(c0023u.m142a(f5804so)), this.f5812c);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6084a(@NotNull C0022T c0022t) {
        if (this.f5812c.isCreative()) {
            C1194vo.m6648a(new C1191vl(c0022t.m136a(f5804so)), this.f5812c);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC1281xd mo6085a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel) {
        return new C1282xe(this.f5805c, this.f5806u, this.f5807sp);
    }
}
