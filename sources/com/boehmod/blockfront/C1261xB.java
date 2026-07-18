package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xB.class */
public class C1261xB extends AbstractC0517jA<C1300xw> {

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Object2ObjectMap<UUID, C1262xC> f7449i = new Object2ObjectOpenHashMap();

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1262xC m7745a(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        if (!this.f7449i.containsKey(uuid)) {
            this.f7449i.put(uuid, new C1262xC(serverPlayer));
        }
        return (C1262xC) this.f7449i.get(uuid);
    }

    /* JADX INFO: renamed from: s */
    public void m7746s(@NotNull UUID uuid) {
        this.f7449i.remove(uuid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0517jA
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void mo2274b(@NotNull C1300xw c1300xw) {
        this.f7449i.values().forEach((v0) -> {
            v0.onUpdate();
        });
    }
}
