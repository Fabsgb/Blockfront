package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xB.class */
public class xB extends jA<xw> {

    @NotNull
    private final Object2ObjectMap<UUID, xC> i = new Object2ObjectOpenHashMap();

    @Nullable
    public xC a(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        if (!this.i.containsKey(uuid)) {
            this.i.put(uuid, new xC(serverPlayer));
        }
        return (xC) this.i.get(uuid);
    }

    public void s(@NotNull UUID uuid) {
        this.i.remove(uuid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jA
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull xw xwVar) {
        this.i.values().forEach((v0) -> {
            v0.onUpdate();
        });
    }
}
