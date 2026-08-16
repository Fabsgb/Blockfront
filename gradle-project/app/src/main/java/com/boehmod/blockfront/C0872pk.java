package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.pk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pk.class */
public final class C0872pk {

    /* JADX INFO: renamed from: bT */
    @NotNull
    private final String f4751bT;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final Style f4752f;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Style f4753g;

    /* JADX INFO: renamed from: oX */
    private final int f4754oX;

    /* JADX INFO: renamed from: oY */
    private final int f4755oY;

    /* JADX INFO: renamed from: oZ */
    private final int f4759oZ;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final AbstractC0863pb<?, ?, ?> f4761i;

    /* JADX INFO: renamed from: aC */
    @NotNull
    private final List<C0881pt> f4756aC = new ObjectArrayList();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final ObjectOpenHashSet<UUID> f4757b = new ObjectOpenHashSet<>();

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Set<UUID> f4758n = Collections.unmodifiableSet(this.f4757b);

    /* JADX INFO: renamed from: a */
    @NotNull
    private C0870pi f4760a = new C0870pi();

    public C0872pk(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull String str, @NotNull Style style, @NotNull Style style2, int i) {
        this.f4761i = abstractC0863pb;
        this.f4751bT = str;
        this.f4752f = style;
        this.f4753g = style2;
        this.f4759oZ = i;
        TextColor color = style.getColor();
        this.f4754oX = color != null ? color.getValue() : ColorReferences.COLOR_WHITE;
        TextColor color2 = style2.getColor();
        this.f4755oY = color2 != null ? color2.getValue() : ColorReferences.COLOR_WHITE;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1098tx m4296a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        return m4316bz() ? abstractC0863pb.m4059a() : abstractC0863pb.m4060b();
    }

    /* JADX INFO: renamed from: cD */
    public void m4297cD() {
        this.f4760a.m4295e();
    }

    /* JADX INFO: renamed from: a */
    public void m4298a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f4757b.forEach(uuid -> {
            C0875pn.m4401a((AbstractC0184c<?>) abstractC0184c, uuid, m4299a((AbstractC0863pb<?, ?, ?>) abstractC0863pb));
        });
    }

    /* JADX INFO: renamed from: a */
    public C0881pt m4299a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (!this.f4756aC.isEmpty()) {
            return this.f4756aC.get(ThreadLocalRandom.current().nextInt(this.f4756aC.size()));
        }
        return abstractC0863pb.m4018b().m4226c();
    }

    /* JADX INFO: renamed from: a */
    public void m4300a(@NotNull C1060tL c1060tL, int i) {
        this.f4760a.m4291a(c1060tL.getKey(), i);
    }

    /* JADX INFO: renamed from: b */
    public void m4301b(@NotNull C1060tL c1060tL, int i) {
        m4300a(c1060tL, m4302a(c1060tL) - i);
    }

    /* JADX INFO: renamed from: a */
    public int m4302a(@NotNull C1060tL c1060tL) {
        return this.f4760a.m4289a(c1060tL.getKey());
    }

    /* JADX INFO: renamed from: a */
    public int m4303a(@NotNull C1060tL c1060tL, int i) {
        return this.f4760a.m4290a(c1060tL.getKey(), i);
    }

    /* JADX INFO: renamed from: c */
    public boolean m4304c(@NotNull ServerPlayer serverPlayer) {
        return m4305h(serverPlayer.getUUID());
    }

    /* JADX INFO: renamed from: h */
    public boolean m4305h(@NotNull UUID uuid) {
        if (!m4321bB()) {
            this.f4757b.add(uuid);
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public void m4306f(@NotNull UUID uuid) {
        this.f4757b.remove(uuid);
    }

    /* JADX INFO: renamed from: cE */
    public void m4307cE() {
        this.f4757b.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Set<UUID> m4308h() {
        return this.f4758n;
    }

    @NotNull
    public String getName() {
        return this.f4751bT;
    }

    @NotNull
    /* JADX INFO: renamed from: D */
    public List<C0881pt> m4309D() {
        return Collections.unmodifiableList(this.f4756aC);
    }

    /* JADX INFO: renamed from: b */
    public void m4310b(@NotNull C0881pt c0881pt) {
        this.f4756aC.add(c0881pt);
    }

    /* JADX INFO: renamed from: cF */
    public void m4311cF() {
        this.f4756aC.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Style m4312a() {
        return this.f4752f;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Style m4313b() {
        return this.f4753g;
    }

    public int getColor() {
        return this.f4754oX;
    }

    /* JADX INFO: renamed from: bn */
    public int m4314bn() {
        return this.f4755oY;
    }

    /* JADX INFO: renamed from: i */
    public boolean m4315i(@NotNull UUID uuid) {
        return this.f4757b.contains(uuid);
    }

    /* JADX INFO: renamed from: bz */
    public boolean m4316bz() {
        return this.f4751bT.equals(C1062tN.f5782dk);
    }

    /* JADX INFO: renamed from: bA */
    public boolean m4317bA() {
        return this.f4751bT.equals(C1062tN.f5783dl);
    }

    /* JADX INFO: renamed from: bm */
    public int m4318bm() {
        return this.f4759oZ;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public UUID m4319f() {
        if (this.f4757b.isEmpty()) {
            return null;
        }
        return (UUID) C1267xG.m7151a((Set) this.f4757b);
    }

    /* JADX INFO: renamed from: bo */
    public int m4320bo() {
        return this.f4757b.size();
    }

    /* JADX INFO: renamed from: bB */
    public boolean m4321bB() {
        return this.f4761i.m4088a().hasTeamSizeLimit() && m4320bo() >= this.f4759oZ;
    }

    public void onUpdate() {
        int iM4303a = m4303a(C1062tN.f5759w, 0);
        if (iM4303a > 0) {
            m4300a(C1062tN.f5759w, iM4303a - 1);
        }
        int iM4303a2 = m4303a(C1062tN.f5760x, 0);
        if (iM4303a2 > 0) {
            m4300a(C1062tN.f5760x, iM4303a2 - 1);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m4322i(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4756aC.size());
        Iterator<C0881pt> it = this.f4756aC.iterator();
        while (it.hasNext()) {
            it.next().mo3870c(byteBuf);
        }
        byteBuf.writeInt(this.f4757b.size());
        ObjectIterator it2 = this.f4757b.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, (UUID) it2.next());
        }
        new FriendlyByteBuf(byteBuf).writeNbt(this.f4760a.m4287a());
    }

    /* JADX INFO: renamed from: j */
    public void m4323j(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4756aC.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0881pt c0881pt = new C0881pt();
            c0881pt.mo3869b(byteBuf);
            this.f4756aC.add(c0881pt);
        }
        this.f4757b.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f4757b.add(IPacket.readUUID(byteBuf));
        }
        CompoundTag nbt = new FriendlyByteBuf(byteBuf).readNbt();
        this.f4760a = nbt != null ? new C0870pi(nbt) : new C0870pi();
    }

    /* JADX INFO: renamed from: a */
    public void m4324a(@NotNull CustomPacketPayload customPacketPayload) {
        Iterator<UUID> it = m4308h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                C1169vO.m6643a(customPacketPayload, serverPlayerM4399a);
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0872pk) && ((C0872pk) obj).f4751bT.equalsIgnoreCase(this.f4751bT);
    }

    public int hashCode() {
        return this.f4751bT.toLowerCase(Locale.ROOT).hashCode();
    }
}
