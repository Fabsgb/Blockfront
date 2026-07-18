package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.C0482iS;
import com.boehmod.blockfront.C0561js;
import com.boehmod.blockfront.C0562jt;
import com.boehmod.blockfront.common.player.AbstractC0182b;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/c.class */
public abstract class AbstractC0183c<D extends AbstractC0182b<?, ?, ?, ?>> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AttachmentType<D> f1515a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final AttachmentType<C0482iS> f1516b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final LoadingCache<UUID, C0482iS> f1517a = m1131b();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final LoadingCache<UUID, D> f1518b = m1126a();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final LoadingCache<UUID, AbstractClanData> f1519c = CacheBuilder.newBuilder().maximumSize(256).expireAfterAccess(16, TimeUnit.MINUTES).build(new C0184d());

    /* JADX INFO: renamed from: jx */
    static final /* synthetic */ boolean f1520jx;

    /* JADX INFO: renamed from: d */
    protected abstract boolean mo1124d(@NotNull UUID uuid);

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract PlayerDataCacheLoader<D, ?> mo1125a();

    /* JADX INFO: renamed from: a */
    protected abstract D mo1137a(@NotNull UUID uuid);

    static {
        f1520jx = !AbstractC0183c.class.desiredAssertionStatus();
    }

    public AbstractC0183c(@NotNull DeferredHolder<AttachmentType<?>, AttachmentType<D>> deferredHolder, @NotNull DeferredHolder<AttachmentType<?>, AttachmentType<C0482iS>> deferredHolder2) {
        this.f1515a = (AttachmentType) deferredHolder.get();
        this.f1516b = (AttachmentType) deferredHolder2.get();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected LoadingCache<UUID, D> m1126a() {
        return CacheBuilder.newBuilder().maximumSize(512L).expireAfterAccess(16L, TimeUnit.MINUTES).removalListener(this::m1128c).build(mo1125a());
    }

    /* JADX INFO: renamed from: b */
    protected void m1127b(@NotNull RemovalNotification<UUID, C0482iS> removalNotification) {
        if (removalNotification.getCause() == RemovalCause.EXPLICIT || removalNotification.getCause() == RemovalCause.REPLACED) {
            return;
        }
        UUID uuid = (UUID) removalNotification.getKey();
        if (!f1520jx && uuid == null) {
            throw new AssertionError("Player UUID is null!");
        }
        C0482iS c0482iS = (C0482iS) removalNotification.getValue();
        if (c0482iS == null) {
            return;
        }
        if (c0482iS.m2183a() == PlayerDataType.DISPLAY || mo1124d(uuid)) {
            C0562jt.log("Refreshing expired player data for player '" + String.valueOf(uuid) + "' as they are still online.", new Object[0]);
            this.f1517a.put(uuid, c0482iS);
        }
    }

    /* JADX INFO: renamed from: c */
    protected void m1128c(@NotNull RemovalNotification<UUID, D> removalNotification) {
        if (removalNotification.getCause() == RemovalCause.EXPLICIT || removalNotification.getCause() == RemovalCause.REPLACED) {
            return;
        }
        UUID uuid = (UUID) removalNotification.getKey();
        if (!f1520jx && uuid == null) {
            throw new AssertionError("Player UUID is null!");
        }
        AbstractC0182b abstractC0182b = (AbstractC0182b) removalNotification.getValue();
        if (abstractC0182b == null) {
            return;
        }
        if (abstractC0182b.m1076a() == PlayerDataType.DISPLAY || mo1124d(uuid)) {
            C0562jt.log("Refreshing expired player data for player '" + String.valueOf(uuid) + "' as they are still online.", new Object[0]);
            this.f1518b.put(uuid, abstractC0182b);
        }
    }

    /* JADX INFO: renamed from: cv */
    public int m1129cv() {
        return this.f1518b.asMap().size();
    }

    /* JADX INFO: renamed from: cw */
    public int m1130cw() {
        return this.f1517a.asMap().size();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private LoadingCache<UUID, C0482iS> m1131b() {
        CacheBuilder cacheBuilderNewBuilder = CacheBuilder.newBuilder();
        if (C0561js.m2512ab()) {
            cacheBuilderNewBuilder.expireAfterAccess(15L, TimeUnit.MINUTES);
        }
        cacheBuilderNewBuilder.removalListener(this::m1127b);
        return cacheBuilderNewBuilder.build(new PlayerDataCloudCacheLoader());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0482iS m1132a(@NotNull UUID uuid) {
        try {
            return (C0482iS) this.f1517a.get(uuid);
        } catch (ExecutionException e) {
            C0562jt.m2516a("Error while fetching player cloud data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return new C0482iS(uuid);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0482iS m1133a(@NotNull Player player) {
        return (C0482iS) player.getData(this.f1516b);
    }

    /* JADX INFO: renamed from: a */
    public void m1134a(@NotNull UUID uuid, @NotNull AbstractClanData abstractClanData) {
        this.f1519c.put(uuid, abstractClanData);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public D m1135b(@NotNull UUID uuid) {
        try {
            return (D) this.f1518b.get(uuid);
        } catch (ExecutionException e) {
            C0562jt.m2516a("Error while fetching player data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return (D) mo1137a(uuid);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public D m1136a(@NotNull Player player) {
        return (D) player.getData(this.f1515a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractClanData m1138a(@NotNull UUID uuid) {
        try {
            return (AbstractClanData) this.f1519c.get(uuid);
        } catch (ExecutionException e) {
            C0562jt.m2516a("Error while fetching clan data for player '" + String.valueOf(uuid) + "'.", e, new Object[0]);
            return AbstractClanData.EMPTY_CLAN_DATA;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1139a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Level level) {
        Iterator it = this.f1518b.asMap().values().iterator();
        while (it.hasNext()) {
            ((AbstractC0182b) it.next()).m1081a(abstractC0563ju, level, true);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1140a(@NotNull UUID uuid, @NotNull PlayerDataContext playerDataContext, byte[] bArr) throws IOException {
        if (this.f1517a.asMap().containsKey(uuid)) {
            return;
        }
        C0482iS c0482iS = new C0482iS(uuid);
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(bArr);
        try {
            c0482iS.read(playerDataContext, byteBufWrappedBuffer);
            byteBufWrappedBuffer.release();
            this.f1517a.put(uuid, c0482iS);
        } catch (Throwable th) {
            byteBufWrappedBuffer.release();
            throw th;
        }
    }

    /* JADX INFO: renamed from: q */
    public void m1141q(@NotNull UUID uuid) {
        C0562jt.log("Removing player data for player '%s'", uuid);
        this.f1518b.asMap().remove(uuid);
    }

    /* JADX INFO: renamed from: r */
    public void m1142r(@NotNull UUID uuid) {
        C0562jt.log("Removing player cloud data for player '%s'", uuid);
        this.f1517a.asMap().remove(uuid);
    }

    /* JADX INFO: renamed from: dA */
    public void m1143dA() {
        this.f1519c.invalidateAll();
    }
}
