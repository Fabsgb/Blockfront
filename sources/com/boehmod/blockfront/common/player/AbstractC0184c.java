package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.C0529jL;
import com.boehmod.blockfront.C0530jM;
import com.boehmod.blockfront.C0555jl;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalNotification;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.c */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/c.class */
public abstract class AbstractC0184c<D extends AbstractC0183b<?, ?, ?, ?>> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AttachmentType<D> f1437a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final AttachmentType<C0555jl> f1438b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final LoadingCache<UUID, C0555jl> f1439a = m1148b();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final LoadingCache<UUID, D> f1440b = m1143a();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final LoadingCache<UUID, AbstractClanData> f1441c = CacheBuilder.newBuilder().maximumSize(256).expireAfterAccess(16, TimeUnit.MINUTES).build(new C0185d());

    /* JADX INFO: renamed from: jN */
    static final /* synthetic */ boolean f1442jN;

    /* JADX INFO: renamed from: d */
    protected abstract boolean mo1141d(@NotNull UUID uuid);

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract PlayerDataCacheLoader<D, ?> mo1142a();

    /* JADX INFO: renamed from: a */
    protected abstract D mo1154a(@NotNull UUID uuid);

    static {
        f1442jN = !AbstractC0184c.class.desiredAssertionStatus();
    }

    public AbstractC0184c(@NotNull DeferredHolder<AttachmentType<?>, AttachmentType<D>> deferredHolder, @NotNull DeferredHolder<AttachmentType<?>, AttachmentType<C0555jl>> deferredHolder2) {
        this.f1437a = (AttachmentType) deferredHolder.get();
        this.f1438b = (AttachmentType) deferredHolder2.get();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected LoadingCache<UUID, D> m1143a() {
        return CacheBuilder.newBuilder().maximumSize(512L).expireAfterAccess(16L, TimeUnit.MINUTES).removalListener(this::m1145c).build(mo1142a());
    }

    /* JADX INFO: renamed from: b */
    protected void m1144b(@NotNull RemovalNotification<UUID, C0555jl> removalNotification) {
        if (removalNotification.getCause() == RemovalCause.EXPLICIT || removalNotification.getCause() == RemovalCause.REPLACED) {
            return;
        }
        UUID uuid = (UUID) removalNotification.getKey();
        if (!f1442jN && uuid == null) {
            throw new AssertionError("Player UUID is null!");
        }
        C0555jl c0555jl = (C0555jl) removalNotification.getValue();
        if (c0555jl == null) {
            return;
        }
        if (c0555jl.m2510a() == PlayerDataType.DISPLAY || mo1141d(uuid)) {
            C0530jM.log("Refreshing expired player data for player '" + String.valueOf(uuid) + "' as they are still online.", new Object[0]);
            this.f1439a.put(uuid, c0555jl);
        }
    }

    /* JADX INFO: renamed from: c */
    protected void m1145c(@NotNull RemovalNotification<UUID, D> removalNotification) {
        if (removalNotification.getCause() == RemovalCause.EXPLICIT || removalNotification.getCause() == RemovalCause.REPLACED) {
            return;
        }
        UUID uuid = (UUID) removalNotification.getKey();
        if (!f1442jN && uuid == null) {
            throw new AssertionError("Player UUID is null!");
        }
        AbstractC0183b abstractC0183b = (AbstractC0183b) removalNotification.getValue();
        if (abstractC0183b == null) {
            return;
        }
        if (abstractC0183b.m1093a() == PlayerDataType.DISPLAY || mo1141d(uuid)) {
            C0530jM.log("Refreshing expired player data for player '" + String.valueOf(uuid) + "' as they are still online.", new Object[0]);
            this.f1440b.put(uuid, abstractC0183b);
        }
    }

    /* JADX INFO: renamed from: cL */
    public int m1146cL() {
        return this.f1440b.asMap().size();
    }

    /* JADX INFO: renamed from: cM */
    public int m1147cM() {
        return this.f1439a.asMap().size();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private LoadingCache<UUID, C0555jl> m1148b() {
        CacheBuilder cacheBuilderNewBuilder = CacheBuilder.newBuilder();
        if (C0529jL.m2332ae()) {
            cacheBuilderNewBuilder.expireAfterAccess(15L, TimeUnit.MINUTES);
        }
        cacheBuilderNewBuilder.removalListener(this::m1144b);
        return cacheBuilderNewBuilder.build(new PlayerDataCloudCacheLoader());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0555jl m1149a(@NotNull UUID uuid) {
        try {
            return (C0555jl) this.f1439a.get(uuid);
        } catch (ExecutionException e) {
            C0530jM.m2338a("Error while fetching player cloud data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return new C0555jl(uuid);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0555jl m1150a(@NotNull Player player) {
        return (C0555jl) player.getData(this.f1438b);
    }

    /* JADX INFO: renamed from: a */
    public void m1151a(@NotNull UUID uuid, @NotNull AbstractClanData abstractClanData) {
        this.f1441c.put(uuid, abstractClanData);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public D m1152b(@NotNull UUID uuid) {
        try {
            return (D) this.f1440b.get(uuid);
        } catch (ExecutionException e) {
            C0530jM.m2338a("Error while fetching player data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return (D) mo1154a(uuid);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public D m1153a(@NotNull Player player) {
        return (D) player.getData(this.f1437a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractClanData m1155a(@NotNull UUID uuid) {
        try {
            return (AbstractClanData) this.f1441c.get(uuid);
        } catch (ExecutionException e) {
            C0530jM.m2338a("Error while fetching clan data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return AbstractClanData.EMPTY_CLAN_DATA;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1156a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Level level) {
        Iterator it = this.f1440b.asMap().values().iterator();
        while (it.hasNext()) {
            ((AbstractC0183b) it.next()).m1098a(abstractC0531jN, level, true);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1157a(@NotNull UUID uuid, @NotNull PlayerDataContext playerDataContext, byte[] bArr) throws IOException {
        if (this.f1439a.asMap().containsKey(uuid)) {
            return;
        }
        C0555jl c0555jl = new C0555jl(uuid);
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(bArr);
        try {
            c0555jl.read(playerDataContext, byteBufWrappedBuffer);
            byteBufWrappedBuffer.release();
            this.f1439a.put(uuid, c0555jl);
        } catch (Throwable th) {
            byteBufWrappedBuffer.release();
            throw th;
        }
    }

    /* JADX INFO: renamed from: q */
    public void m1158q(@NotNull UUID uuid) {
        C0530jM.log("Removing player data for player '%s'", uuid);
        this.f1440b.asMap().remove(uuid);
    }

    /* JADX INFO: renamed from: r */
    public void m1159r(@NotNull UUID uuid) {
        C0530jM.log("Removing player cloud data for player '%s'", uuid);
        this.f1439a.asMap().remove(uuid);
    }

    /* JADX INFO: renamed from: dK */
    public void m1160dK() {
        this.f1441c.invalidateAll();
    }
}
