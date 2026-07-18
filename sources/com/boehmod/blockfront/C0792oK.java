package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oK.class */
public class C0792oK implements InterfaceC0537jU {

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0787oF<?, ?, ?> f4344a;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final AbstractC0563ju<?, ?, ?> f4345f;

    /* JADX INFO: renamed from: ge */
    private boolean f4346ge = false;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0597kb f4347c = new C0597kb().m2628a("rotation", new C0597kb((commandContext, strArr) -> {
        this.f4346ge = strArr[0].equals("true");
        C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(this.f4346ge ? "Added game " + this.f4344a.f4236bE + " to map rotation" : "Removed game " + this.f4344a.f4236bE + " from map rotation"));
    }).m2624a(C0599kd.m2635a(new String[]{"true/false"})).m2630a((commandContext2, strArr2) -> {
        return strArr2.length == 0 ? List.of("true", "false") : List.of();
    }));

    public C0792oK(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        this.f4344a = abstractC0787oF;
        this.f4345f = abstractC0563ju;
        if (abstractC0787oF != null) {
            abstractC0563ju.m2539b(abstractC0787oF);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> m3836a() {
        return this.f4344a;
    }

    /* JADX INFO: renamed from: bo */
    public boolean m3837bo() {
        return this.f4346ge;
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo2429a() {
        if (this.f4344a != null) {
            return this.f4347c.m2623a(this.f4344a.mo3646a());
        }
        return this.f4347c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    /* JADX INFO: renamed from: c */
    public void mo2430c(@NotNull CommandSource commandSource) {
        List<MutableComponent> objectArrayList = new ObjectArrayList<>();
        if (this.f4344a != null) {
            this.f4344a.mo3647g(objectArrayList);
        }
        Iterator<MutableComponent> it = objectArrayList.iterator();
        while (it.hasNext()) {
            C0645lW.m2897a(commandSource, (Component) it.next());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0977rk m3838a() {
        AbstractC0787oF<?, ?, ?> abstractC0787oF = this.f4344a;
        if (abstractC0787oF == null) {
            throw new IllegalStateException("Cannot convert a GameAsset with no game to data");
        }
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
        List list = abstractC0790oIM3582b.m3808A().stream().map(c0796oO -> {
            return new C0980rn(c0796oO.getName(), List.copyOf(c0796oO.m3873B()));
        }).toList();
        return new C0977rk(abstractC0787oF.m3589L(), abstractC0787oF.m3591a().getName(), list, Optional.ofNullable(abstractC0790oIM3582b.m3790c()), abstractC0787oF.mo3606a(), this.f4346ge);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0792oK m3839a(@NotNull C0977rk c0977rk, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        String strMo5347ac = c0977rk.m5344b().mo5347ac();
        C1016sW c1016sWM5531a = C1016sW.m5531a(strMo5347ac);
        if (c1016sWM5531a == null) {
            return null;
        }
        Class<? extends AbstractC0787oF<?, ?, ?>> clsM5533b = c1016sWM5531a.m5533b();
        try {
            AbstractC0787oF<?, ?, ?> abstractC0787oFNewInstance = clsM5533b.getDeclaredConstructor(AbstractC0563ju.class).newInstance(abstractC0563ju);
            abstractC0787oFNewInstance.m3590v(c0977rk.m5340aa());
            if (!c0977rk.m5341ab().isEmpty()) {
                abstractC0787oFNewInstance.m3592a(new C0528jL<>(C1017sX.class, c0977rk.m5341ab(), C1017sX.f5367b));
            }
            AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFNewInstance.m3582b();
            for (C0980rn c0980rn : c0977rk.m5342P()) {
                C0796oO c0796oOM3806a = abstractC0790oIM3582b.m3806a(c0980rn.m5406g());
                if (c0796oOM3806a != null) {
                    c0796oOM3806a.m3875ct();
                    Iterator<C0805oX> it = c0980rn.m5407ai().iterator();
                    while (it.hasNext()) {
                        c0796oOM3806a.m3874b(it.next().mo4124d());
                    }
                }
            }
            Optional<C0805oX> optionalM5343f = c0977rk.m5343f();
            Objects.requireNonNull(abstractC0790oIM3582b);
            optionalM5343f.ifPresent(abstractC0790oIM3582b::m3791a);
            abstractC0787oFNewInstance.mo3607a(c0977rk.m5344b());
            abstractC0787oFNewInstance.m3603d((ServerLevel) null);
            C0792oK c0792oK = new C0792oK(abstractC0787oFNewInstance, abstractC0563ju);
            c0792oK.f4346ge = c0977rk.m5345bJ();
            return c0792oK;
        } catch (Exception e) {
            C0562jt.m2516a("Failed to create game asset from codec data for game type %s (Class: %s)", e, strMo5347ac, clsM5533b.getName());
            return null;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    /* JADX INFO: renamed from: bp */
    public void mo2431bp() {
        ServerLevel level;
        if (this.f4344a == null) {
            return;
        }
        Set<UUID> setM3809h = this.f4344a.m3582b().m3809h();
        if (!setM3809h.isEmpty()) {
            MinecraftServer minecraftServerM2514a = C0561js.m2514a();
            if (minecraftServerM2514a == null || (level = minecraftServerM2514a.getLevel(Level.OVERWORLD)) == null) {
                return;
            }
            C0562jt.log("[GameAsset] Removing %d player(s) from game '%s' before asset removal.", Integer.valueOf(setM3809h.size()), this.f4344a.m3589L());
            ObjectListIterator it = new ObjectArrayList(setM3809h).iterator();
            while (it.hasNext()) {
                ServerPlayer player = minecraftServerM2514a.getPlayerList().getPlayer((UUID) it.next());
                if (player != null) {
                    this.f4344a.m3631a(this.f4345f, level, player);
                }
            }
        }
        this.f4344a.stop();
        this.f4345f.m2540c(this.f4344a);
    }
}
