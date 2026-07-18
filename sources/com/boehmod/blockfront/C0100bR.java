package com.boehmod.blockfront;

import com.mojang.authlib.GameProfile;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bR.class */
public final class C0100bR {

    /* JADX INFO: renamed from: b */
    private final Object2ObjectMap<UUID, C0099bQ> f646b = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final GameProfile f647a;

    /* JADX INFO: renamed from: a */
    private C0097bO f648a;

    /* JADX INFO: renamed from: a */
    private C0099bQ f649a;

    public C0100bR(@NotNull GameProfile gameProfile) {
        this.f647a = gameProfile;
    }

    /* JADX INFO: renamed from: n */
    public void m312n(@NotNull Minecraft minecraft) {
        this.f646b.values().forEach((v0) -> {
            v0.tick();
        });
        m313o(minecraft);
        this.f649a.tick();
    }

    /* JADX INFO: renamed from: o */
    private void m313o(@NotNull Minecraft minecraft) {
        if (this.f648a == null || this.f649a == null) {
            m314m(minecraft);
        }
    }

    /* JADX INFO: renamed from: m */
    private void m314m(@NotNull Minecraft minecraft) {
        C0562jt.log("Initializing fake player environment...", new Object[0]);
        this.f648a = new C0097bO(minecraft);
        this.f649a = new C0099bQ(this.f648a, this.f647a);
        C0562jt.log("Finished initializing fake player environment.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public C0099bQ m315a(@NotNull Minecraft minecraft) {
        m313o(minecraft);
        return this.f649a;
    }

    /* JADX INFO: renamed from: a */
    public C0099bQ m316a(@NotNull Minecraft minecraft, @NotNull GameProfile gameProfile) {
        m313o(minecraft);
        return (C0099bQ) this.f646b.computeIfAbsent(gameProfile.getId(), obj -> {
            return new C0099bQ(this.f648a, gameProfile);
        });
    }
}
