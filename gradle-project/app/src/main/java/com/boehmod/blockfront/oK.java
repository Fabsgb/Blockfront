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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oK.class */
public class oK implements jU {

    @Nullable
    private oF<?, ?, ?> a;

    @NotNull
    private final AbstractC0264ju<?, ?, ?> f;
    private boolean ge = false;

    @NotNull
    private final C0272kb c = new C0272kb().a("rotation", new C0272kb((commandContext, strArr) -> {
        this.ge = strArr[0].equals("true");
        lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(this.ge ? "Added game " + this.a.bE + " to map rotation" : "Removed game " + this.a.bE + " from map rotation"));
    }).a(C0274kd.a(new String[]{"true/false"})).a((commandContext2, strArr2) -> {
        return strArr2.length == 0 ? List.of("true", "false") : List.of();
    }));

    public oK(@Nullable oF<?, ?, ?> oFVar, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        this.a = oFVar;
        this.f = abstractC0264ju;
        if (oFVar != null) {
            abstractC0264ju.b(oFVar);
        }
    }

    @Nullable
    public oF<?, ?, ?> a() {
        return this.a;
    }

    public boolean bo() {
        return this.ge;
    }

    @Override // com.boehmod.blockfront.jU
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo565a() {
        if (this.a != null) {
            return this.c.a(this.a.mo763a());
        }
        return this.c;
    }

    @Override // com.boehmod.blockfront.jU
    public void c(@NotNull CommandSource commandSource) {
        List<MutableComponent> objectArrayList = new ObjectArrayList<>();
        if (this.a != null) {
            this.a.g(objectArrayList);
        }
        Iterator<MutableComponent> it = objectArrayList.iterator();
        while (it.hasNext()) {
            lW.a(commandSource, (Component) it.next());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0470rk m786a() {
        oF<?, ?, ?> oFVar = this.a;
        if (oFVar == null) {
            throw new IllegalStateException("Cannot convert a GameAsset with no game to data");
        }
        oI oIVarB = oFVar.b();
        List list = oIVarB.A().stream().map(oOVar -> {
            return new C0473rn(oOVar.getName(), List.copyOf(oOVar.B()));
        }).toList();
        return new C0470rk(oFVar.L(), oFVar.m751a().getName(), list, Optional.ofNullable(oIVarB.c()), oFVar.mo752a(), this.ge);
    }

    @Nullable
    public static oK a(@NotNull C0470rk c0470rk, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        String strAc = c0470rk.b().ac();
        sW sWVarA = sW.a(strAc);
        if (sWVarA == null) {
            return null;
        }
        Class<? extends oF<?, ?, ?>> clsB = sWVarA.b();
        try {
            oF<?, ?, ?> oFVarNewInstance = clsB.getDeclaredConstructor(AbstractC0264ju.class).newInstance(abstractC0264ju);
            oFVarNewInstance.v(c0470rk.aa());
            if (!c0470rk.ab().isEmpty()) {
                oFVarNewInstance.a(new jL<>(sX.class, c0470rk.ab(), sX.b));
            }
            oI oIVarB = oFVarNewInstance.b();
            for (C0473rn c0473rn : c0470rk.P()) {
                oO oOVarA = oIVarB.a(c0473rn.g());
                if (oOVarA != null) {
                    oOVarA.ct();
                    Iterator<oX> it = c0473rn.ai().iterator();
                    while (it.hasNext()) {
                        oOVarA.b(it.next().d());
                    }
                }
            }
            Optional<oX> optionalF = c0470rk.f();
            Objects.requireNonNull(oIVarB);
            optionalF.ifPresent(oIVarB::a);
            oFVarNewInstance.a(c0470rk.b());
            oFVarNewInstance.d((ServerLevel) null);
            oK oKVar = new oK(oFVarNewInstance, abstractC0264ju);
            oKVar.ge = c0470rk.bJ();
            return oKVar;
        } catch (Exception e) {
            C0263jt.a("Failed to create game asset from codec data for game type %s (Class: %s)", e, strAc, clsB.getName());
            return null;
        }
    }

    @Override // com.boehmod.blockfront.jU
    public void bp() {
        ServerLevel level;
        if (this.a == null) {
            return;
        }
        Set<UUID> setH = this.a.b().h();
        if (!setH.isEmpty()) {
            MinecraftServer minecraftServerA = C0262js.a();
            if (minecraftServerA == null || (level = minecraftServerA.getLevel(Level.OVERWORLD)) == null) {
                return;
            }
            C0263jt.log("[GameAsset] Removing %d player(s) from game '%s' before asset removal.", Integer.valueOf(setH.size()), this.a.L());
            ObjectListIterator it = new ObjectArrayList(setH).iterator();
            while (it.hasNext()) {
                ServerPlayer player = minecraftServerA.getPlayerList().getPlayer((UUID) it.next());
                if (player != null) {
                    this.a.a(this.f, level, player);
                }
            }
        }
        this.a.stop();
        this.f.c(this.a);
    }
}
