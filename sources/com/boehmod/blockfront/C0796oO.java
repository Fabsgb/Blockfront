package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oO.class */
public final class C0796oO {

    /* JADX INFO: renamed from: bJ */
    @NotNull
    private final String f4355bJ;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final Style f4356f;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Style f4357g;

    /* JADX INFO: renamed from: mY */
    private final int f4358mY;

    /* JADX INFO: renamed from: mZ */
    private final int f4359mZ;

    /* JADX INFO: renamed from: na */
    private final int f4363na;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final AbstractC0787oF<?, ?, ?> f4365i;

    /* JADX INFO: renamed from: av */
    @NotNull
    private final List<C0805oX> f4360av = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectOpenHashSet<UUID> f4361a = new ObjectOpenHashSet<>();

    /* JADX INFO: renamed from: m */
    @NotNull
    private final Set<UUID> f4362m = Collections.unmodifiableSet(this.f4361a);

    /* JADX INFO: renamed from: a */
    @NotNull
    private C0794oM f4364a = new C0794oM();

    public C0796oO(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull String str, @NotNull Style style, @NotNull Style style2, int i) {
        this.f4365i = abstractC0787oF;
        this.f4355bJ = str;
        this.f4356f = style;
        this.f4357g = style2;
        this.f4363na = i;
        TextColor color = style.getColor();
        this.f4358mY = color != null ? color.getValue() : ColorReferences.COLOR_WHITE;
        TextColor color2 = style2.getColor();
        this.f4359mZ = color2 != null ? color2.getValue() : ColorReferences.COLOR_WHITE;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1074ta m3860a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        return m3880bp() ? abstractC0787oF.m3623a() : abstractC0787oF.m3624b();
    }

    /* JADX INFO: renamed from: cr */
    public void m3861cr() {
        this.f4364a.m3859e();
    }

    /* JADX INFO: renamed from: a */
    public void m3862a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f4361a.forEach(uuid -> {
            C0799oR.m3965a((AbstractC0183c<?>) abstractC0183c, uuid, m3863a((AbstractC0787oF<?, ?, ?>) abstractC0787oF));
        });
    }

    /* JADX INFO: renamed from: a */
    public C0805oX m3863a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (!this.f4360av.isEmpty()) {
            return this.f4360av.get(ThreadLocalRandom.current().nextInt(this.f4360av.size()));
        }
        return abstractC0787oF.m3582b().m3790c();
    }

    /* JADX INFO: renamed from: a */
    public void m3864a(@NotNull C1088to c1088to, int i) {
        this.f4364a.m3855a(c1088to.getKey(), i);
    }

    /* JADX INFO: renamed from: b */
    public void m3865b(@NotNull C1088to c1088to, int i) {
        m3864a(c1088to, m3866a(c1088to) - i);
    }

    /* JADX INFO: renamed from: a */
    public int m3866a(@NotNull C1088to c1088to) {
        return this.f4364a.m3853a(c1088to.getKey());
    }

    /* JADX INFO: renamed from: a */
    public int m3867a(@NotNull C1088to c1088to, int i) {
        return this.f4364a.m3854a(c1088to.getKey(), i);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3868b(@NotNull ServerPlayer serverPlayer) {
        return m3869h(serverPlayer.getUUID());
    }

    /* JADX INFO: renamed from: h */
    public boolean m3869h(@NotNull UUID uuid) {
        if (!m3885br()) {
            this.f4361a.add(uuid);
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public void m3870f(@NotNull UUID uuid) {
        this.f4361a.remove(uuid);
    }

    /* JADX INFO: renamed from: cs */
    public void m3871cs() {
        this.f4361a.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Set<UUID> m3872h() {
        return this.f4362m;
    }

    @NotNull
    public String getName() {
        return this.f4355bJ;
    }

    @NotNull
    /* JADX INFO: renamed from: B */
    public List<C0805oX> m3873B() {
        return Collections.unmodifiableList(this.f4360av);
    }

    /* JADX INFO: renamed from: b */
    public void m3874b(@NotNull C0805oX c0805oX) {
        this.f4360av.add(c0805oX);
    }

    /* JADX INFO: renamed from: ct */
    public void m3875ct() {
        this.f4360av.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Style m3876a() {
        return this.f4356f;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Style m3877b() {
        return this.f4357g;
    }

    public int getColor() {
        return this.f4358mY;
    }

    /* JADX INFO: renamed from: aY */
    public int m3878aY() {
        return this.f4359mZ;
    }

    /* JADX INFO: renamed from: i */
    public boolean m3879i(@NotNull UUID uuid) {
        return this.f4361a.contains(uuid);
    }

    /* JADX INFO: renamed from: bp */
    public boolean m3880bp() {
        return this.f4355bJ.equals(C1089tp.f5729cZ);
    }

    /* JADX INFO: renamed from: bq */
    public boolean m3881bq() {
        return this.f4355bJ.equals(C1089tp.f5730da);
    }

    /* JADX INFO: renamed from: aX */
    public int m3882aX() {
        return this.f4363na;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public UUID m3883f() {
        if (this.f4361a.isEmpty()) {
            return null;
        }
        return (UUID) C1287xj.m7827a((Set) this.f4361a);
    }

    /* JADX INFO: renamed from: aZ */
    public int m3884aZ() {
        return this.f4361a.size();
    }

    /* JADX INFO: renamed from: br */
    public boolean m3885br() {
        return this.f4365i.m3652a().hasTeamSizeLimit() && m3884aZ() >= this.f4363na;
    }

    public void onUpdate() {
        int iM3867a = m3867a(C1089tp.f5706w, 0);
        if (iM3867a > 0) {
            m3864a(C1089tp.f5706w, iM3867a - 1);
        }
        int iM3867a2 = m3867a(C1089tp.f5707x, 0);
        if (iM3867a2 > 0) {
            m3864a(C1089tp.f5707x, iM3867a2 - 1);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m3886i(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4360av.size());
        Iterator<C0805oX> it = this.f4360av.iterator();
        while (it.hasNext()) {
            it.next().mo4111c(byteBuf);
        }
        byteBuf.writeInt(this.f4361a.size());
        ObjectIterator it2 = this.f4361a.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, (UUID) it2.next());
        }
        new FriendlyByteBuf(byteBuf).writeNbt(this.f4364a.m3851a());
    }

    /* JADX INFO: renamed from: j */
    public void m3887j(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4360av.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0805oX c0805oX = new C0805oX();
            c0805oX.mo4110b(byteBuf);
            this.f4360av.add(c0805oX);
        }
        this.f4361a.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f4361a.add(IPacket.readUUID(byteBuf));
        }
        CompoundTag nbt = new FriendlyByteBuf(byteBuf).readNbt();
        this.f4364a = nbt != null ? new C0794oM(nbt) : new C0794oM();
    }

    /* JADX INFO: renamed from: a */
    public void m3888a(@NotNull CustomPacketPayload customPacketPayload) {
        Iterator<UUID> it = m3872h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                C1194vo.m6648a(customPacketPayload, serverPlayerM3963a);
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0796oO) && ((C0796oO) obj).f4355bJ.equalsIgnoreCase(this.f4355bJ);
    }
}
