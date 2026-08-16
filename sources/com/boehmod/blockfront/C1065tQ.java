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

/* JADX INFO: renamed from: com.boehmod.blockfront.tQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tQ.class */
public class C1065tQ {

    /* JADX INFO: renamed from: tE */
    private static final int f5795tE = 3;

    /* JADX INFO: renamed from: tF */
    private static final int f5796tF = 3;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final AbstractC0863pb<?, ?, ?> f5797l;

    /* JADX INFO: renamed from: cb */
    @NotNull
    private final List<C1064tP> f5798cb = new ObjectArrayList();

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Set<UUID> f5799t = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: u */
    @NotNull
    private final Set<UUID> f5800u = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: hV */
    private boolean f5801hV = false;

    /* JADX INFO: renamed from: cr */
    public boolean m5912cr() {
        return this.f5801hV;
    }

    public C1065tQ(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f5797l = abstractC0863pb;
    }

    /* JADX INFO: renamed from: n */
    public void m5913n(@NotNull UUID uuid) {
        if (this.f5801hV) {
            Iterator<C1064tP> it = this.f5798cb.iterator();
            while (it.hasNext()) {
                it.next().m5908h().remove(uuid);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5914a(@NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull String str2) {
        UUID uuid = serverPlayer.getUUID();
        Set<UUID> setM4245h = this.f5797l.m4018b().m4245h();
        for (C1064tP c1064tP : this.f5798cb) {
            if (c1064tP.m5908h().contains(uuid) && c1064tP.getName().equals(str)) {
                C0875pn.m4363a(uuid, (SoundEvent) C1312xz.f7949oW.get(), SoundSource.MASTER);
                return;
            }
        }
        if (this.f5799t.contains(uuid)) {
            Iterator<C1064tP> it = this.f5798cb.iterator();
            while (it.hasNext()) {
                it.next().m5908h().remove(uuid);
            }
            this.f5799t.remove(uuid);
        }
        this.f5799t.add(uuid);
        for (C1064tP c1064tP2 : this.f5798cb) {
            if (c1064tP2.getName().equals(str) && c1064tP2.m5910ay().equals(str2)) {
                c1064tP2.m5904m(uuid);
                C0875pn.m4369a(setM4245h, (SoundEvent) C1312xz.f7950oX.get(), SoundSource.MASTER);
                C0875pn.m4363a(uuid, (SoundEvent) C1312xz.f7951oY.get(), SoundSource.MASTER);
                C1169vO.m6646a(new C1224wQ(this.f5797l), this.f5797l);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m5915d(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        C0530jM.log("[Map Vote] Starting map-vote sequence!", new Object[0]);
        this.f5801hV = true;
        this.f5798cb.clear();
        this.f5799t.clear();
        this.f5800u.clear();
        String strM4030T = this.f5797l.m4030T();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        C1094tt c1094ttM6019a = C1094tt.m6019a(strM4030T);
        if (c1094ttM6019a == null) {
            C0530jM.log("[Map Vote] Game type '" + strM4030T + "' not found! Skipping map vote...", new Object[0]);
            return;
        }
        C0530jM.log("[Map Vote] Finding map-vote entries for game-type '" + c1094ttM6019a.m6025at() + "' (" + c1094ttM6019a.getDisplayName().getString() + ")", new Object[0]);
        List<AbstractC0863pb<?, ?, ?>> listM2368a = abstractC0531jN.m2368a(c1094ttM6019a, this.f5797l);
        listM2368a.remove(this.f5797l);
        if (listM2368a.isEmpty()) {
            C0530jM.log("[Map Vote] No other games of type '" + c1094ttM6019a.m6025at() + "' available! Looking for different gamemodes only.", new Object[0]);
            m5917a(abstractC0531jN, c1094ttM6019a);
            if (this.f5798cb.isEmpty()) {
                C0530jM.log("[Map Vote] No votable games found! Current game will be used.", new Object[0]);
            }
        } else {
            m5916a(listM2368a, threadLocalRandomCurrent);
            m5917a(abstractC0531jN, c1094ttM6019a);
        }
        C0530jM.log("[Map Vote] Map-vote sequence complete! Total vote options: " + this.f5798cb.size() + " out of 6 expected.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private void m5916a(@NotNull List<AbstractC0863pb<?, ?, ?>> list, @NotNull ThreadLocalRandom threadLocalRandom) {
        while (list.size() > 3) {
            list.remove(threadLocalRandom.nextInt(list.size()));
        }
        for (AbstractC0863pb<?, ?, ?> abstractC0863pb : list) {
            C0530jM.log("[Map Vote] Adding match '" + String.valueOf(abstractC0863pb.m4064e()) + "' to vote.", new Object[0]);
            this.f5798cb.add(new C1064tP(abstractC0863pb));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5917a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C1094tt c1094tt) {
        List<C1094tt> listM6031ay = c1094tt.m6031ay();
        if (listM6031ay.isEmpty()) {
            C0530jM.log("[Map Vote] No other game-types available for vote! Skipping different gamemode maps.", new Object[0]);
            return;
        }
        C0530jM.log("[Map Vote] Other game-types available for vote! Attempting to add different gamemode maps...", new Object[0]);
        int i = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1094tt c1094tt2 : listM6031ay) {
            List<AbstractC0863pb<?, ?, ?>> listM2368a = abstractC0531jN.m2368a(c1094tt2, this.f5797l);
            if (!listM2368a.isEmpty()) {
                C0530jM.log("[Map Vote] Found " + listM2368a.size() + " games from game-type '" + c1094tt2.m6025at() + "' (" + c1094tt2.getDisplayName().getString() + ")", new Object[0]);
                objectArrayList.addAll(listM2368a);
            }
        }
        if (objectArrayList.isEmpty()) {
            C0530jM.log("[Map Vote] No games from different gamemodes are available!", new Object[0]);
            return;
        }
        C0530jM.log("[Map Vote] Found a total of " + objectArrayList.size() + " games from different gamemodes. Will randomly select 3", new Object[0]);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        while (i < 3 && !objectArrayList.isEmpty()) {
            int iNextInt = threadLocalRandomCurrent.nextInt(objectArrayList.size());
            AbstractC0863pb abstractC0863pb = (AbstractC0863pb) objectArrayList.get(iNextInt);
            objectArrayList.remove(iNextInt);
            this.f5798cb.add(new C1064tP(abstractC0863pb));
            i++;
            C0530jM.log("[Map Vote] Added game '" + String.valueOf(abstractC0863pb.m4064e()) + "' of type '" + abstractC0863pb.m4030T() + "' to vote options", new Object[0]);
        }
        if (i == 0) {
            C0530jM.log("[Map Vote] Could not add any different gamemode maps.", new Object[0]);
        } else if (i < 3) {
            C0530jM.log("[Map Vote] Could only add " + i + " different gamemode maps (requested 3)", new Object[0]);
        } else {
            C0530jM.log("[Map Vote] Successfully added " + i + " different gamemode maps", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m5918a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull ServerLevel serverLevel) {
        this.f5801hV = false;
        UUID uuidM4064e = null;
        int i = 0;
        for (C1064tP c1064tP : this.f5798cb) {
            int size = c1064tP.m5908h().size();
            UUID uuidM5907a = c1064tP.m5907a();
            if (size > i) {
                i = size;
                uuidM4064e = uuidM5907a;
            }
        }
        if (uuidM4064e == null) {
            uuidM4064e = this.f5797l.m4064e();
        }
        C0875pn.m4358a(serverLevel, this.f5797l, abstractC0866pe);
        return this.f5797l.m4008a(abstractC0531jN, serverLevel, uuidM4064e);
    }

    /* JADX INFO: renamed from: b */
    public void m5919b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5801hV = IPacket.readBoolean(byteBuf);
        if (this.f5801hV) {
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 < this.f5798cb.size()) {
                    this.f5798cb.get(i2).m5905b(byteBuf);
                } else {
                    C1064tP c1064tP = new C1064tP();
                    c1064tP.m5905b(byteBuf);
                    this.f5798cb.add(c1064tP);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5920c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, this.f5801hV);
        if (this.f5801hV) {
            byteBuf.writeInt(this.f5798cb.size());
            Iterator<C1064tP> it = this.f5798cb.iterator();
            while (it.hasNext()) {
                it.next().m5906c(byteBuf);
            }
        }
    }

    /* JADX INFO: renamed from: bd */
    public void m5921bd() {
        this.f5801hV = false;
        this.f5799t.clear();
        this.f5800u.clear();
        this.f5798cb.clear();
    }

    /* JADX INFO: renamed from: q */
    public boolean m5922q(@NotNull UUID uuid) {
        return this.f5800u.contains(uuid);
    }

    /* JADX INFO: renamed from: o */
    public void m5923o(@NotNull UUID uuid) {
        this.f5800u.add(uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: aG */
    public List<C1064tP> m5924aG() {
        return this.f5798cb;
    }

    /* JADX INFO: renamed from: o */
    public boolean m5925o(@NotNull String str) {
        Iterator<C1064tP> it = this.f5798cb.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
