package com.boehmod.blockfront;

import com.mojang.authlib.GameProfile;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bR.class */
public final class bR {
    private final Object2ObjectMap<UUID, bQ> b = new Object2ObjectOpenHashMap();

    @NotNull
    private final GameProfile a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bO f57a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bQ f58a;

    public bR(@NotNull GameProfile gameProfile) {
        this.a = gameProfile;
    }

    public void n(@NotNull Minecraft minecraft) {
        this.b.values().forEach((v0) -> {
            v0.tick();
        });
        o(minecraft);
        this.f58a.tick();
    }

    private void o(@NotNull Minecraft minecraft) {
        if (this.f57a == null || this.f58a == null) {
            m(minecraft);
        }
    }

    private void m(@NotNull Minecraft minecraft) {
        C0263jt.log("Initializing fake player environment...", new Object[0]);
        this.f57a = new bO(minecraft);
        this.f58a = new bQ(this.f57a, this.a);
        C0263jt.log("Finished initializing fake player environment.", new Object[0]);
    }

    public bQ a(@NotNull Minecraft minecraft) {
        o(minecraft);
        return this.f58a;
    }

    public bQ a(@NotNull Minecraft minecraft, @NotNull GameProfile gameProfile) {
        o(minecraft);
        return (bQ) this.b.computeIfAbsent(gameProfile.getId(), obj -> {
            return new bQ(this.f57a, gameProfile);
        });
    }
}
