package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ts, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ts.class */
public class C0532ts {
    private static final int rB = 3;
    private static final int rC = 3;

    @NotNull
    private final oF<?, ?, ?> l;

    @NotNull
    private final List<C0531tr> bU = new ObjectArrayList();

    @NotNull
    private final Set<UUID> s = new ObjectOpenHashSet();

    @NotNull
    private final Set<UUID> t = new ObjectOpenHashSet();
    private boolean hB = false;

    public boolean ch() {
        return this.hB;
    }

    public C0532ts(@NotNull oF<?, ?, ?> oFVar) {
        this.l = oFVar;
    }

    public void n(@NotNull UUID uuid) {
        if (this.hB) {
            Iterator<C0531tr> it = this.bU.iterator();
            while (it.hasNext()) {
                it.next().h().remove(uuid);
            }
        }
    }

    public void a(@NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull String str2) {
        UUID uuid = serverPlayer.getUUID();
        Set<UUID> setH = this.l.b().h();
        for (C0531tr c0531tr : this.bU) {
            if (c0531tr.h().contains(uuid) && c0531tr.getName().equals(str)) {
                oR.a(uuid, (SoundEvent) C0624xc.oU.get(), SoundSource.MASTER);
                return;
            }
        }
        if (this.s.contains(uuid)) {
            Iterator<C0531tr> it = this.bU.iterator();
            while (it.hasNext()) {
                it.next().h().remove(uuid);
            }
            this.s.remove(uuid);
        }
        this.s.add(uuid);
        for (C0531tr c0531tr2 : this.bU) {
            if (c0531tr2.getName().equals(str) && c0531tr2.ar().equals(str2)) {
                c0531tr2.m(uuid);
                oR.a(setH, (SoundEvent) C0624xc.oV.get(), SoundSource.MASTER);
                oR.a(uuid, (SoundEvent) C0624xc.oW.get(), SoundSource.MASTER);
                C0582vo.a(new C0613ws(this.l), this.l);
                return;
            }
        }
    }

    public void d(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        C0263jt.log("[Map Vote] Starting map-vote sequence!", new Object[0]);
        this.hB = true;
        this.bU.clear();
        this.s.clear();
        this.t.clear();
        String strM = this.l.M();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        sW sWVarA = sW.a(strM);
        if (sWVarA == null) {
            C0263jt.log("[Map Vote] Game type '" + strM + "' not found! Skipping map vote...", new Object[0]);
            return;
        }
        C0263jt.log("[Map Vote] Finding map-vote entries for game-type '" + sWVarA.am() + "' (" + sWVarA.getDisplayName().getString() + ")", new Object[0]);
        List<oF<?, ?, ?>> listA = abstractC0264ju.a(sWVarA, this.l);
        listA.remove(this.l);
        if (listA.isEmpty()) {
            C0263jt.log("[Map Vote] No other games of type '" + sWVarA.am() + "' available! Looking for different gamemodes only.", new Object[0]);
            a(abstractC0264ju, sWVarA);
            if (this.bU.isEmpty()) {
                C0263jt.log("[Map Vote] No votable games found! Current game will be used.", new Object[0]);
            }
        } else {
            a(listA, threadLocalRandomCurrent);
            a(abstractC0264ju, sWVarA);
        }
        C0263jt.log("[Map Vote] Map-vote sequence complete! Total vote options: " + this.bU.size() + " out of 6 expected.", new Object[0]);
    }

    private void a(@NotNull List<oF<?, ?, ?>> list, @NotNull ThreadLocalRandom threadLocalRandom) {
        while (list.size() > 3) {
            list.remove(threadLocalRandom.nextInt(list.size()));
        }
        for (oF<?, ?, ?> oFVar : list) {
            C0263jt.log("[Map Vote] Adding match '" + String.valueOf(oFVar.m757e()) + "' to vote.", new Object[0]);
            this.bU.add(new C0531tr(oFVar));
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull sW sWVar) {
        List<sW> listAw = sWVar.aw();
        if (listAw.isEmpty()) {
            C0263jt.log("[Map Vote] No other game-types available for vote! Skipping different gamemode maps.", new Object[0]);
            return;
        }
        C0263jt.log("[Map Vote] Other game-types available for vote! Attempting to add different gamemode maps...", new Object[0]);
        int i = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (sW sWVar2 : listAw) {
            List<oF<?, ?, ?>> listA = abstractC0264ju.a(sWVar2, this.l);
            if (!listA.isEmpty()) {
                C0263jt.log("[Map Vote] Found " + listA.size() + " games from game-type '" + sWVar2.am() + "' (" + sWVar2.getDisplayName().getString() + ")", new Object[0]);
                objectArrayList.addAll(listA);
            }
        }
        if (objectArrayList.isEmpty()) {
            C0263jt.log("[Map Vote] No games from different gamemodes are available!", new Object[0]);
            return;
        }
        C0263jt.log("[Map Vote] Found a total of " + objectArrayList.size() + " games from different gamemodes. Will randomly select 3", new Object[0]);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        while (i < 3 && !objectArrayList.isEmpty()) {
            int iNextInt = threadLocalRandomCurrent.nextInt(objectArrayList.size());
            oF oFVar = (oF) objectArrayList.get(iNextInt);
            objectArrayList.remove(iNextInt);
            this.bU.add(new C0531tr(oFVar));
            i++;
            C0263jt.log("[Map Vote] Added game '" + String.valueOf(oFVar.m757e()) + "' of type '" + oFVar.M() + "' to vote options", new Object[0]);
        }
        if (i == 0) {
            C0263jt.log("[Map Vote] Could not add any different gamemode maps.", new Object[0]);
        } else if (i < 3) {
            C0263jt.log("[Map Vote] Could only add " + i + " different gamemode maps (requested 3)", new Object[0]);
        } else {
            C0263jt.log("[Map Vote] Successfully added " + i + " different gamemode maps", new Object[0]);
        }
    }

    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oI<?> oIVar, @NotNull ServerLevel serverLevel) {
        this.hB = false;
        UUID uuidM757e = null;
        int i = 0;
        for (C0531tr c0531tr : this.bU) {
            int size = c0531tr.h().size();
            UUID uuidA = c0531tr.a();
            if (size > i) {
                i = size;
                uuidM757e = uuidA;
            }
        }
        if (uuidM757e == null) {
            uuidM757e = this.l.m757e();
        }
        oR.a(serverLevel, this.l, oIVar);
        return this.l.a(abstractC0264ju, serverLevel, uuidM757e);
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.hB = IPacket.readBoolean(byteBuf);
        if (this.hB) {
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 < this.bU.size()) {
                    this.bU.get(i2).b(byteBuf);
                } else {
                    C0531tr c0531tr = new C0531tr();
                    c0531tr.b(byteBuf);
                    this.bU.add(c0531tr);
                }
            }
        }
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, this.hB);
        if (this.hB) {
            byteBuf.writeInt(this.bU.size());
            Iterator<C0531tr> it = this.bU.iterator();
            while (it.hasNext()) {
                it.next().c(byteBuf);
            }
        }
    }

    public void bf() {
        this.hB = false;
        this.s.clear();
        this.t.clear();
        this.bU.clear();
    }

    public boolean q(@NotNull UUID uuid) {
        return this.t.contains(uuid);
    }

    public void o(@NotNull UUID uuid) {
        this.t.add(uuid);
    }

    @NotNull
    public List<C0531tr> aE() {
        return this.bU;
    }

    public boolean l(@NotNull String str) {
        Iterator<C0531tr> it = this.bU.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
