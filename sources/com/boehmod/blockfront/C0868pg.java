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

/* JADX INFO: renamed from: com.boehmod.blockfront.pg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pg.class */
public class C0868pg implements InterfaceC0613kq {

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0863pb<?, ?, ?> f4739a;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final AbstractC0531jN<?, ?, ?> f4740f;

    /* JADX INFO: renamed from: gy */
    private boolean f4741gy = false;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0620kx f4742c = new C0620kx().m2840a("rotation", new C0620kx((commandContext, strArr) -> {
        this.f4741gy = strArr[0].equals("true");
        C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(this.f4741gy ? "Added game " + this.f4739a.f4630bN + " to map rotation" : "Removed game " + this.f4739a.f4630bN + " from map rotation"));
    }).m2836a(C0622kz.m2847a(new String[]{"true/false"})).m2842a((commandContext2, strArr2) -> {
        return strArr2.length == 0 ? List.of("true", "false") : List.of();
    }));

    public C0868pg(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        this.f4739a = abstractC0863pb;
        this.f4740f = abstractC0531jN;
        if (abstractC0863pb != null) {
            abstractC0531jN.m2362b(abstractC0863pb);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> m4272a() {
        return this.f4739a;
    }

    /* JADX INFO: renamed from: by */
    public boolean m4273by() {
        return this.f4741gy;
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo2596a() {
        if (this.f4739a != null) {
            return this.f4742c.m2835a(this.f4739a.mo4082a());
        }
        return this.f4742c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    /* JADX INFO: renamed from: c */
    public void mo2597c(@NotNull CommandSource commandSource) {
        List<MutableComponent> objectArrayList = new ObjectArrayList<>();
        if (this.f4739a != null) {
            this.f4739a.mo4083h(objectArrayList);
        }
        Iterator<MutableComponent> it = objectArrayList.iterator();
        while (it.hasNext()) {
            C0721ms.m3328a(commandSource, (Component) it.next());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0949rH m4274a() {
        AbstractC0863pb<?, ?, ?> abstractC0863pb = this.f4739a;
        if (abstractC0863pb == null) {
            throw new IllegalStateException("Cannot convert a GameAsset with no game to data");
        }
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
        List list = abstractC0866peM4018b.m4244C().stream().map(c0872pk -> {
            return new C0952rK(c0872pk.getName(), List.copyOf(c0872pk.m4309D()));
        }).toList();
        return new C0949rH(abstractC0863pb.m4025S(), abstractC0863pb.m4027a().getName(), list, Optional.ofNullable(abstractC0866peM4018b.m4226c()), abstractC0863pb.mo4042a(), this.f4741gy);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0868pg m4275a(@NotNull C0949rH c0949rH, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        String strMo5223aj = c0949rH.m5220b().mo5223aj();
        C1094tt c1094ttM6019a = C1094tt.m6019a(strMo5223aj);
        if (c1094ttM6019a == null) {
            return null;
        }
        Class<? extends AbstractC0863pb<?, ?, ?>> clsM6021b = c1094ttM6019a.m6021b();
        try {
            AbstractC0863pb<?, ?, ?> abstractC0863pbNewInstance = clsM6021b.getDeclaredConstructor(AbstractC0531jN.class).newInstance(abstractC0531jN);
            abstractC0863pbNewInstance.m4026v(c0949rH.m5216ah());
            if (!c0949rH.m5217ai().isEmpty()) {
                abstractC0863pbNewInstance.m4028a(new C0604kh<>(C1095tu.class, c0949rH.m5217ai(), C1095tu.f5931b));
            }
            AbstractC0866pe abstractC0866peM4018b = abstractC0863pbNewInstance.m4018b();
            for (C0952rK c0952rK : c0949rH.m5218R()) {
                C0872pk c0872pkM4242a = abstractC0866peM4018b.m4242a(c0952rK.m5282k());
                if (c0872pkM4242a != null) {
                    c0872pkM4242a.m4311cF();
                    Iterator<C0881pt> it = c0952rK.m5283ak().iterator();
                    while (it.hasNext()) {
                        c0872pkM4242a.m4310b(it.next().mo3849d());
                    }
                }
            }
            Optional<C0881pt> optionalM5219f = c0949rH.m5219f();
            Objects.requireNonNull(abstractC0866peM4018b);
            optionalM5219f.ifPresent(abstractC0866peM4018b::m4227a);
            abstractC0863pbNewInstance.mo4043a(c0949rH.m5220b());
            abstractC0863pbNewInstance.m4039d((ServerLevel) null);
            C0868pg c0868pg = new C0868pg(abstractC0863pbNewInstance, abstractC0531jN);
            c0868pg.f4741gy = c0949rH.m5221bT();
            return c0868pg;
        } catch (Exception e) {
            C0530jM.m2338a("Failed to create game asset from codec data for game type %s (Class: %s)", e, strMo5223aj, clsM6021b.getName());
            return null;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    /* JADX INFO: renamed from: bA */
    public void mo2598bA() {
        ServerLevel level;
        if (this.f4739a == null) {
            return;
        }
        Set<UUID> setM4245h = this.f4739a.m4018b().m4245h();
        if (!setM4245h.isEmpty()) {
            MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
            if (minecraftServerM2335a == null || (level = minecraftServerM2335a.getLevel(Level.OVERWORLD)) == null) {
                return;
            }
            C0530jM.log("[GameAsset] Removing %d player(s) from game '%s' before asset removal.", Integer.valueOf(setM4245h.size()), this.f4739a.m4025S());
            ObjectListIterator it = new ObjectArrayList(setM4245h).iterator();
            while (it.hasNext()) {
                ServerPlayer player = minecraftServerM2335a.getPlayerList().getPlayer((UUID) it.next());
                if (player != null) {
                    this.f4739a.m4067a(this.f4740f, level, player);
                }
            }
        }
        this.f4739a.stop();
        this.f4740f.m2363c(this.f4739a);
    }
}
