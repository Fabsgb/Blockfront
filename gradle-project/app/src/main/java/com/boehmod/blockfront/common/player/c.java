package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.C0262js;
import com.boehmod.blockfront.C0263jt;
import com.boehmod.blockfront.common.player.b;
import com.boehmod.blockfront.iS;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/c.class */
public abstract class c<D extends b<?, ?, ?, ?>> {

    @NotNull
    private final AttachmentType<D> a;

    @NotNull
    private final AttachmentType<iS> b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final LoadingCache<UUID, iS> f106a = b();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private final LoadingCache<UUID, D> f107b = m304a();

    @NotNull
    private final LoadingCache<UUID, AbstractClanData> c = CacheBuilder.newBuilder().maximumSize(256).expireAfterAccess(16, TimeUnit.MINUTES).build(new d());
    static final /* synthetic */ boolean jx;

    protected abstract boolean d(@NotNull UUID uuid);

    @NotNull
    protected abstract PlayerDataCacheLoader<D, ?> a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected abstract D mo306a(@NotNull UUID uuid);

    static {
        jx = !c.class.desiredAssertionStatus();
    }

    public c(@NotNull DeferredHolder<AttachmentType<?>, AttachmentType<D>> deferredHolder, @NotNull DeferredHolder<AttachmentType<?>, AttachmentType<iS>> deferredHolder2) {
        this.a = (AttachmentType) deferredHolder.get();
        this.b = (AttachmentType) deferredHolder2.get();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected LoadingCache<UUID, D> m304a() {
        return CacheBuilder.newBuilder().maximumSize(512L).expireAfterAccess(16L, TimeUnit.MINUTES).removalListener(this::c).build(a());
    }

    protected void b(@NotNull RemovalNotification<UUID, iS> removalNotification) {
        if (removalNotification.getCause() == RemovalCause.EXPLICIT || removalNotification.getCause() == RemovalCause.REPLACED) {
            return;
        }
        UUID uuid = (UUID) removalNotification.getKey();
        if (!jx && uuid == null) {
            throw new AssertionError("Player UUID is null!");
        }
        iS iSVar = (iS) removalNotification.getValue();
        if (iSVar == null) {
            return;
        }
        if (iSVar.a() == PlayerDataType.DISPLAY || d(uuid)) {
            C0263jt.log("Refreshing expired player data for player '" + String.valueOf(uuid) + "' as they are still online.", new Object[0]);
            this.f106a.put(uuid, iSVar);
        }
    }

    protected void c(@NotNull RemovalNotification<UUID, D> removalNotification) {
        if (removalNotification.getCause() == RemovalCause.EXPLICIT || removalNotification.getCause() == RemovalCause.REPLACED) {
            return;
        }
        UUID uuid = (UUID) removalNotification.getKey();
        if (!jx && uuid == null) {
            throw new AssertionError("Player UUID is null!");
        }
        b bVar = (b) removalNotification.getValue();
        if (bVar == null) {
            return;
        }
        if (bVar.a() == PlayerDataType.DISPLAY || d(uuid)) {
            C0263jt.log("Refreshing expired player data for player '" + String.valueOf(uuid) + "' as they are still online.", new Object[0]);
            this.f107b.put(uuid, bVar);
        }
    }

    public int cv() {
        return this.f107b.asMap().size();
    }

    public int cw() {
        return this.f106a.asMap().size();
    }

    @NotNull
    private LoadingCache<UUID, iS> b() {
        CacheBuilder cacheBuilderNewBuilder = CacheBuilder.newBuilder();
        if (C0262js.ab()) {
            cacheBuilderNewBuilder.expireAfterAccess(15L, TimeUnit.MINUTES);
        }
        cacheBuilderNewBuilder.removalListener(this::b);
        return cacheBuilderNewBuilder.build(new PlayerDataCloudCacheLoader());
    }

    @NotNull
    public iS a(@NotNull UUID uuid) {
        try {
            return (iS) this.f106a.get(uuid);
        } catch (ExecutionException e) {
            C0263jt.a("Error while fetching player cloud data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return new iS(uuid);
        }
    }

    @NotNull
    public iS a(@NotNull Player player) {
        return (iS) player.getData(this.b);
    }

    public void a(@NotNull UUID uuid, @NotNull AbstractClanData abstractClanData) {
        this.c.put(uuid, abstractClanData);
    }

    @NotNull
    public D b(@NotNull UUID uuid) {
        try {
            return (D) this.f107b.get(uuid);
        } catch (ExecutionException e) {
            C0263jt.a("Error while fetching player data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return (D) mo306a(uuid);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public D m305a(@NotNull Player player) {
        return (D) player.getData(this.a);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public AbstractClanData m307a(@NotNull UUID uuid) {
        try {
            return (AbstractClanData) this.c.get(uuid);
        } catch (ExecutionException e) {
            C0263jt.a("Error while fetching clan data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return AbstractClanData.EMPTY_CLAN_DATA;
        }
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Level level) {
        Iterator it = this.f107b.asMap().values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(abstractC0264ju, level, true);
        }
    }

    public void a(@NotNull UUID uuid, @NotNull PlayerDataContext playerDataContext, byte[] bArr) throws IOException {
        if (this.f106a.asMap().containsKey(uuid)) {
            return;
        }
        iS iSVar = new iS(uuid);
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(bArr);
        try {
            iSVar.read(playerDataContext, byteBufWrappedBuffer);
            byteBufWrappedBuffer.release();
            this.f106a.put(uuid, iSVar);
        } catch (Throwable th) {
            byteBufWrappedBuffer.release();
            throw th;
        }
    }

    public void q(@NotNull UUID uuid) {
        C0263jt.log("Removing player data for player '%s'", uuid);
        this.f107b.asMap().remove(uuid);
    }

    public void r(@NotNull UUID uuid) {
        C0263jt.log("Removing player cloud data for player '%s'", uuid);
        this.f106a.asMap().remove(uuid);
    }

    public void dA() {
        this.c.invalidateAll();
    }
}
