package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oO.class */
public final class oO {

    @NotNull
    private final String bJ;

    @NotNull
    private final Style f;

    @NotNull
    private final Style g;
    private final int mY;
    private final int mZ;
    private final int na;

    @NotNull
    private final oF<?, ?, ?> i;

    @NotNull
    private final List<oX> av = new ObjectArrayList();

    @NotNull
    private final ObjectOpenHashSet<UUID> a = new ObjectOpenHashSet<>();

    @NotNull
    private final Set<UUID> m = Collections.unmodifiableSet(this.a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private oM f276a = new oM();

    public oO(@NotNull oF<?, ?, ?> oFVar, @NotNull String str, @NotNull Style style, @NotNull Style style2, int i) {
        this.i = oFVar;
        this.bJ = str;
        this.f = style;
        this.g = style2;
        this.na = i;
        TextColor color = style.getColor();
        this.mY = color != null ? color.getValue() : ColorReferences.COLOR_WHITE;
        TextColor color2 = style2.getColor();
        this.mZ = color2 != null ? color2.getValue() : ColorReferences.COLOR_WHITE;
    }

    @NotNull
    public C0514ta a(@NotNull oF<?, ?, ?> oFVar) {
        return bp() ? oFVar.m755a() : oFVar.m756b();
    }

    public void cr() {
        this.f276a.e();
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull oF<?, ?, ?> oFVar) {
        this.a.forEach(uuid -> {
            oR.a((com.boehmod.blockfront.common.player.c<?>) cVar, uuid, m789a((oF<?, ?, ?>) oFVar));
        });
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oX m789a(@NotNull oF<?, ?, ?> oFVar) {
        if (!this.av.isEmpty()) {
            return this.av.get(ThreadLocalRandom.current().nextInt(this.av.size()));
        }
        return oFVar.b().c();
    }

    public void a(@NotNull C0528to c0528to, int i) {
        this.f276a.m787a(c0528to.getKey(), i);
    }

    public void b(@NotNull C0528to c0528to, int i) {
        a(c0528to, a(c0528to) - i);
    }

    public int a(@NotNull C0528to c0528to) {
        return this.f276a.a(c0528to.getKey());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m790a(@NotNull C0528to c0528to, int i) {
        return this.f276a.a(c0528to.getKey(), i);
    }

    public boolean b(@NotNull ServerPlayer serverPlayer) {
        return h(serverPlayer.getUUID());
    }

    public boolean h(@NotNull UUID uuid) {
        if (!br()) {
            this.a.add(uuid);
            return true;
        }
        return false;
    }

    public void f(@NotNull UUID uuid) {
        this.a.remove(uuid);
    }

    public void cs() {
        this.a.clear();
    }

    @NotNull
    public Set<UUID> h() {
        return this.m;
    }

    @NotNull
    public String getName() {
        return this.bJ;
    }

    @NotNull
    public List<oX> B() {
        return Collections.unmodifiableList(this.av);
    }

    public void b(@NotNull oX oXVar) {
        this.av.add(oXVar);
    }

    public void ct() {
        this.av.clear();
    }

    @NotNull
    public Style a() {
        return this.f;
    }

    @NotNull
    public Style b() {
        return this.g;
    }

    public int getColor() {
        return this.mY;
    }

    public int aY() {
        return this.mZ;
    }

    public boolean i(@NotNull UUID uuid) {
        return this.a.contains(uuid);
    }

    public boolean bp() {
        return this.bJ.equals(C0529tp.cZ);
    }

    public boolean bq() {
        return this.bJ.equals(C0529tp.da);
    }

    public int aX() {
        return this.na;
    }

    @Nullable
    public UUID f() {
        if (this.a.isEmpty()) {
            return null;
        }
        return (UUID) C0631xj.a((Set) this.a);
    }

    public int aZ() {
        return this.a.size();
    }

    public boolean br() {
        return this.i.m766a().hasTeamSizeLimit() && aZ() >= this.na;
    }

    public void onUpdate() {
        int iM790a = m790a(C0529tp.w, 0);
        if (iM790a > 0) {
            a(C0529tp.w, iM790a - 1);
        }
        int iM790a2 = m790a(C0529tp.x, 0);
        if (iM790a2 > 0) {
            a(C0529tp.x, iM790a2 - 1);
        }
    }

    public void i(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.av.size());
        Iterator<oX> it = this.av.iterator();
        while (it.hasNext()) {
            it.next().c(byteBuf);
        }
        byteBuf.writeInt(this.a.size());
        ObjectIterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, (UUID) it2.next());
        }
        new FriendlyByteBuf(byteBuf).writeNbt(this.f276a.a());
    }

    public void j(@NotNull ByteBuf byteBuf) throws IOException {
        this.av.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            oX oXVar = new oX();
            oXVar.b(byteBuf);
            this.av.add(oXVar);
        }
        this.a.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.a.add(IPacket.readUUID(byteBuf));
        }
        CompoundTag nbt = new FriendlyByteBuf(byteBuf).readNbt();
        this.f276a = nbt != null ? new oM(nbt) : new oM();
    }

    public void a(@NotNull CustomPacketPayload customPacketPayload) {
        Iterator<UUID> it = h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                C0582vo.a(customPacketPayload, serverPlayerA);
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof oO) && ((oO) obj).bJ.equalsIgnoreCase(this.bJ);
    }
}
