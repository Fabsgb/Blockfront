package com.boehmod.blockfront;

import com.mojang.authlib.GameProfile;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ca */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ca.class */
public final class C0163ca {

    /* JADX INFO: renamed from: b */
    private final Object2ObjectMap<UUID, C0109bZ> f1325b = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final GameProfile f1326a;

    /* JADX INFO: renamed from: a */
    private C0107bX f1327a;

    /* JADX INFO: renamed from: a */
    private C0109bZ f1328a;

    public C0163ca(@NotNull GameProfile gameProfile) {
        this.f1326a = gameProfile;
    }

    /* JADX INFO: renamed from: o */
    public void m1035o(@NotNull Minecraft minecraft) {
        this.f1325b.values().forEach((v0) -> {
            v0.tick();
        });
        m1036p(minecraft);
        this.f1328a.tick();
    }

    /* JADX INFO: renamed from: p */
    private void m1036p(@NotNull Minecraft minecraft) {
        if (this.f1327a == null || this.f1328a == null) {
            m1037n(minecraft);
        }
    }

    /* JADX INFO: renamed from: n */
    private void m1037n(@NotNull Minecraft minecraft) {
        C0530jM.log("Initializing fake player environment...", new Object[0]);
        this.f1327a = new C0107bX(minecraft);
        this.f1328a = new C0109bZ(this.f1327a, this.f1326a);
        C0530jM.log("Finished initializing fake player environment.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public C0109bZ m1038a(@NotNull Minecraft minecraft) {
        m1036p(minecraft);
        return this.f1328a;
    }

    /* JADX INFO: renamed from: a */
    public C0109bZ m1039a(@NotNull Minecraft minecraft, @NotNull GameProfile gameProfile) {
        m1036p(minecraft);
        return (C0109bZ) this.f1325b.computeIfAbsent(gameProfile.getId(), obj -> {
            return new C0109bZ(this.f1327a, gameProfile);
        });
    }
}
