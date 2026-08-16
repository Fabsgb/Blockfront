package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xY.class */
public class C1285xY extends AbstractC0537jT<C1280xT> {

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Object2ObjectMap<UUID, C1286xZ> f6910i = new Object2ObjectOpenHashMap();

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1286xZ m7303a(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        if (!this.f6910i.containsKey(uuid)) {
            this.f6910i.put(uuid, new C1286xZ(serverPlayer));
        }
        return (C1286xZ) this.f6910i.get(uuid);
    }

    /* JADX INFO: renamed from: s */
    public void m7304s(@NotNull UUID uuid) {
        this.f6910i.remove(uuid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0537jT
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void mo2408b(@NotNull C1280xT c1280xT) {
        this.f6910i.values().forEach((v0) -> {
            v0.onUpdate();
        });
    }
}
