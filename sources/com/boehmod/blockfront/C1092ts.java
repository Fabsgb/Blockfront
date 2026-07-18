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

/* JADX INFO: renamed from: com.boehmod.blockfront.ts */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ts.class */
public class C1092ts {

    /* JADX INFO: renamed from: rB */
    private static final int f5742rB = 3;

    /* JADX INFO: renamed from: rC */
    private static final int f5743rC = 3;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final AbstractC0787oF<?, ?, ?> f5744l;

    /* JADX INFO: renamed from: bU */
    @NotNull
    private final List<C1091tr> f5745bU = new ObjectArrayList();

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Set<UUID> f5746s = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Set<UUID> f5747t = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: hB */
    private boolean f5748hB = false;

    /* JADX INFO: renamed from: ch */
    public boolean m6026ch() {
        return this.f5748hB;
    }

    public C1092ts(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f5744l = abstractC0787oF;
    }

    /* JADX INFO: renamed from: n */
    public void m6027n(@NotNull UUID uuid) {
        if (this.f5748hB) {
            Iterator<C1091tr> it = this.f5745bU.iterator();
            while (it.hasNext()) {
                it.next().m6022h().remove(uuid);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6028a(@NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull String str2) {
        UUID uuid = serverPlayer.getUUID();
        Set<UUID> setM3809h = this.f5744l.m3582b().m3809h();
        for (C1091tr c1091tr : this.f5745bU) {
            if (c1091tr.m6022h().contains(uuid) && c1091tr.getName().equals(str)) {
                C0799oR.m3927a(uuid, (SoundEvent) C1280xc.f7537oU.get(), SoundSource.MASTER);
                return;
            }
        }
        if (this.f5746s.contains(uuid)) {
            Iterator<C1091tr> it = this.f5745bU.iterator();
            while (it.hasNext()) {
                it.next().m6022h().remove(uuid);
            }
            this.f5746s.remove(uuid);
        }
        this.f5746s.add(uuid);
        for (C1091tr c1091tr2 : this.f5745bU) {
            if (c1091tr2.getName().equals(str) && c1091tr2.m6024ar().equals(str2)) {
                c1091tr2.m6018m(uuid);
                C0799oR.m3933a(setM3809h, (SoundEvent) C1280xc.f7538oV.get(), SoundSource.MASTER);
                C0799oR.m3927a(uuid, (SoundEvent) C1280xc.f7539oW.get(), SoundSource.MASTER);
                C1194vo.m6651a(new C1251ws(this.f5744l), this.f5744l);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m6029d(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        C0562jt.log("[Map Vote] Starting map-vote sequence!", new Object[0]);
        this.f5748hB = true;
        this.f5745bU.clear();
        this.f5746s.clear();
        this.f5747t.clear();
        String strM3594M = this.f5744l.m3594M();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        C1016sW c1016sWM5531a = C1016sW.m5531a(strM3594M);
        if (c1016sWM5531a == null) {
            C0562jt.log("[Map Vote] Game type '" + strM3594M + "' not found! Skipping map vote...", new Object[0]);
            return;
        }
        C0562jt.log("[Map Vote] Finding map-vote entries for game-type '" + c1016sWM5531a.m5537am() + "' (" + c1016sWM5531a.getDisplayName().getString() + ")", new Object[0]);
        List<AbstractC0787oF<?, ?, ?>> listM2545a = abstractC0563ju.m2545a(c1016sWM5531a, this.f5744l);
        listM2545a.remove(this.f5744l);
        if (listM2545a.isEmpty()) {
            C0562jt.log("[Map Vote] No other games of type '" + c1016sWM5531a.m5537am() + "' available! Looking for different gamemodes only.", new Object[0]);
            m6031a(abstractC0563ju, c1016sWM5531a);
            if (this.f5745bU.isEmpty()) {
                C0562jt.log("[Map Vote] No votable games found! Current game will be used.", new Object[0]);
            }
        } else {
            m6030a(listM2545a, threadLocalRandomCurrent);
            m6031a(abstractC0563ju, c1016sWM5531a);
        }
        C0562jt.log("[Map Vote] Map-vote sequence complete! Total vote options: " + this.f5745bU.size() + " out of 6 expected.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private void m6030a(@NotNull List<AbstractC0787oF<?, ?, ?>> list, @NotNull ThreadLocalRandom threadLocalRandom) {
        while (list.size() > 3) {
            list.remove(threadLocalRandom.nextInt(list.size()));
        }
        for (AbstractC0787oF<?, ?, ?> abstractC0787oF : list) {
            C0562jt.log("[Map Vote] Adding match '" + String.valueOf(abstractC0787oF.m3628e()) + "' to vote.", new Object[0]);
            this.f5745bU.add(new C1091tr(abstractC0787oF));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6031a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C1016sW c1016sW) {
        List<C1016sW> listM5543aw = c1016sW.m5543aw();
        if (listM5543aw.isEmpty()) {
            C0562jt.log("[Map Vote] No other game-types available for vote! Skipping different gamemode maps.", new Object[0]);
            return;
        }
        C0562jt.log("[Map Vote] Other game-types available for vote! Attempting to add different gamemode maps...", new Object[0]);
        int i = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1016sW c1016sW2 : listM5543aw) {
            List<AbstractC0787oF<?, ?, ?>> listM2545a = abstractC0563ju.m2545a(c1016sW2, this.f5744l);
            if (!listM2545a.isEmpty()) {
                C0562jt.log("[Map Vote] Found " + listM2545a.size() + " games from game-type '" + c1016sW2.m5537am() + "' (" + c1016sW2.getDisplayName().getString() + ")", new Object[0]);
                objectArrayList.addAll(listM2545a);
            }
        }
        if (objectArrayList.isEmpty()) {
            C0562jt.log("[Map Vote] No games from different gamemodes are available!", new Object[0]);
            return;
        }
        C0562jt.log("[Map Vote] Found a total of " + objectArrayList.size() + " games from different gamemodes. Will randomly select 3", new Object[0]);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        while (i < 3 && !objectArrayList.isEmpty()) {
            int iNextInt = threadLocalRandomCurrent.nextInt(objectArrayList.size());
            AbstractC0787oF abstractC0787oF = (AbstractC0787oF) objectArrayList.get(iNextInt);
            objectArrayList.remove(iNextInt);
            this.f5745bU.add(new C1091tr(abstractC0787oF));
            i++;
            C0562jt.log("[Map Vote] Added game '" + String.valueOf(abstractC0787oF.m3628e()) + "' of type '" + abstractC0787oF.m3594M() + "' to vote options", new Object[0]);
        }
        if (i == 0) {
            C0562jt.log("[Map Vote] Could not add any different gamemode maps.", new Object[0]);
        } else if (i < 3) {
            C0562jt.log("[Map Vote] Could only add " + i + " different gamemode maps (requested 3)", new Object[0]);
        } else {
            C0562jt.log("[Map Vote] Successfully added " + i + " different gamemode maps", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m6032a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull ServerLevel serverLevel) {
        this.f5748hB = false;
        UUID uuidM3628e = null;
        int i = 0;
        for (C1091tr c1091tr : this.f5745bU) {
            int size = c1091tr.m6022h().size();
            UUID uuidM6021a = c1091tr.m6021a();
            if (size > i) {
                i = size;
                uuidM3628e = uuidM6021a;
            }
        }
        if (uuidM3628e == null) {
            uuidM3628e = this.f5744l.m3628e();
        }
        C0799oR.m3922a(serverLevel, this.f5744l, abstractC0790oI);
        return this.f5744l.m3572a(abstractC0563ju, serverLevel, uuidM3628e);
    }

    /* JADX INFO: renamed from: b */
    public void m6033b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5748hB = IPacket.readBoolean(byteBuf);
        if (this.f5748hB) {
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 < this.f5745bU.size()) {
                    this.f5745bU.get(i2).m6019b(byteBuf);
                } else {
                    C1091tr c1091tr = new C1091tr();
                    c1091tr.m6019b(byteBuf);
                    this.f5745bU.add(c1091tr);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6034c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, this.f5748hB);
        if (this.f5748hB) {
            byteBuf.writeInt(this.f5745bU.size());
            Iterator<C1091tr> it = this.f5745bU.iterator();
            while (it.hasNext()) {
                it.next().m6020c(byteBuf);
            }
        }
    }

    /* JADX INFO: renamed from: bf */
    public void m6035bf() {
        this.f5748hB = false;
        this.f5746s.clear();
        this.f5747t.clear();
        this.f5745bU.clear();
    }

    /* JADX INFO: renamed from: q */
    public boolean m6036q(@NotNull UUID uuid) {
        return this.f5747t.contains(uuid);
    }

    /* JADX INFO: renamed from: o */
    public void m6037o(@NotNull UUID uuid) {
        this.f5747t.add(uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: aE */
    public List<C1091tr> m6038aE() {
        return this.f5745bU;
    }

    /* JADX INFO: renamed from: l */
    public boolean m6039l(@NotNull String str) {
        Iterator<C1091tr> it = this.f5745bU.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
