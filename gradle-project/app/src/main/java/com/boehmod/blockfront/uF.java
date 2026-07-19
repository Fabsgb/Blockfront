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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uF.class */
public class uF extends uA<ServerLevel, LivingEntity, xQ, xw> {
    private static final int so = 10747841;

    @NotNull
    private final C0628xg c;
    private final long u;
    private final int sp;
    private final float nm;
    private final float nn;

    @NotNull
    private final Vec3 av;

    @NotNull
    private final Vec2 n;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    private final ServerPlayer f305c;

    @Override // com.boehmod.blockfront.uA
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        a((xw) abstractC0264ju, (ServerLevel) level, livingEntity, (List<C0555uo>) list);
    }

    @Override // com.boehmod.blockfront.uA
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        a((xw) abstractC0264ju, (ServerLevel) level, livingEntity, (List<C0556up>) list, randomSource, random, j, j2, i);
    }

    public uF(@NotNull ServerPlayer serverPlayer, @NotNull xQ xQVar, @NotNull uI uIVar, @NotNull C0628xg c0628xg, @NotNull Vec3 vec3, @NotNull Vec2 vec2, float f, float f2, long j, int i) {
        super(xQVar, uIVar);
        this.f305c = serverPlayer;
        this.c = c0628xg;
        this.av = vec3;
        this.n = vec2;
        this.u = j;
        this.sp = i;
        this.nm = f;
        this.nn = f2;
    }

    @NotNull
    public List<C0556up> a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull C0558ur c0558ur, long j, long j2, int i) {
        dt();
        a(xwVar, serverLevel, randomSource, random, livingEntity, c0558ur, j, j2, i);
        return new ObjectArrayList(this.ce);
    }

    private void dt() {
        this.ce.clear();
        this.d.clear();
        this.cd.clear();
        this.mS = 0.0f;
        this.at = null;
        this.aT = 0.0d;
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull LivingEntity livingEntity, @NotNull C0558ur c0558ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        int iCa = c0558ur.ca();
        if (iCa != -1 || randomSource.nextFloat() < c0558ur.bw()) {
            C0607wm c0607wm = new C0607wm(this.f305c.getId(), new C0166gc((Holder<Item>) c0558ur.builtInRegistryHolder(), vec3, vec32, iCa));
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (abstractC0264juM166a != null) {
                oF<?, ?, ?> oFVarA = abstractC0264juM166a.a((Player) this.f305c);
                if (oFVarA != null) {
                    Iterator<UUID> it = oFVarA.b().h().iterator();
                    while (it.hasNext()) {
                        ServerPlayer serverPlayerA = oR.a(it.next());
                        if (serverPlayerA != null && !serverPlayerA.equals(this.f305c)) {
                            C0582vo.a(c0607wm, serverPlayerA);
                        }
                    }
                    return;
                }
                for (ServerPlayer serverPlayer : this.f305c.level().players()) {
                    if (serverPlayer instanceof ServerPlayer) {
                        ServerPlayer serverPlayer2 = serverPlayer;
                        if (!serverPlayer2.equals(this.f305c)) {
                            C0582vo.a(c0607wm, serverPlayer2);
                        }
                    }
                }
            }
        }
    }

    public void a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C0556up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
    }

    public void a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C0555uo> list) {
    }

    @Override // com.boehmod.blockfront.uA
    @NotNull
    protected Vec3 a(@NotNull LivingEntity livingEntity) {
        return this.av;
    }

    @Override // com.boehmod.blockfront.uA
    public Vec3 a(@NotNull LivingEntity livingEntity, @NotNull RandomSource randomSource, @NotNull uS uSVar, int i, long j) {
        uV uVVarM1178a = uSVar.m1178a();
        if (uVVarM1178a != null) {
            return a(this.n, uVVarM1178a, i, j, this.nm, this.nn);
        }
        return a(this.n, randomSource, this.nm, this.nn);
    }

    @Override // com.boehmod.blockfront.uA
    @NotNull
    public Vec3 a(@NotNull LivingEntity livingEntity, @NotNull C0558ur c0558ur) {
        return c0558ur.A().zRot(((livingEntity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-livingEntity.getYRot()) * 0.017453292f) - 1.5707964f);
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull U u) {
        if (this.f305c.isCreative()) {
            C0582vo.a(new C0580vm(u.a(so)), this.f305c);
        }
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull T t) {
        if (this.f305c.isCreative()) {
            C0582vo.a(new C0579vl(t.a(so)), this.f305c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.uA
    @NotNull
    public InterfaceC0625xd a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel) {
        return new C0626xe(this.c, this.u, this.sp);
    }
}
