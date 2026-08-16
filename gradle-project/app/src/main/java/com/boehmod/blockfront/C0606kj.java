package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kj.class */
public final class C0606kj {

    /* JADX INFO: renamed from: aW */
    @NotNull
    public static final String f3512aW = "maps";

    /* JADX INFO: renamed from: aX */
    @NotNull
    public static final String f3513aX = "games";

    /* JADX INFO: renamed from: aY */
    @NotNull
    public static final String f3514aY = "templates";

    private C0606kj() {
    }

    /* JADX INFO: renamed from: m */
    public static void m2728m(@NotNull String str) {
        C0607kk c0607kkM2734c = C0607kk.m2734c();
        if (c0607kkM2734c.m2744b(f3512aW) == null) {
            C0530jM.logError("[Asset Reload] Maps registry is not registered, cannot hot-reload '%s'.", str);
            return;
        }
        C0605ki c0605kiM2737a = c0607kkM2734c.m2737a(C0868pg.class);
        if (c0605kiM2737a == null) {
            return;
        }
        int i = 0;
        Iterator it = c0605kiM2737a.m2720d().values().iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = ((C0868pg) it.next()).m4272a();
            if (abstractC0863pbM4272a != null && str.equals(abstractC0863pbM4272a.m4027a().getName())) {
                abstractC0863pbM4272a.m4089a().m6145cM();
                abstractC0863pbM4272a.m4002cy();
                m2731d(abstractC0863pbM4272a);
                C1169vO.m6646a(new C1220wM(abstractC0863pbM4272a, true), abstractC0863pbM4272a);
                MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
                if (minecraftServerM2335a != null) {
                    m2733a(abstractC0863pbM4272a, minecraftServerM2335a.overworld(), null);
                }
                i++;
            }
        }
        C0530jM.log("[Asset Reload] Map '%s' reloaded, pushed fresh map data to %d active match(es).", str, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: n */
    public static void m2729n(@NotNull String str) {
        C0607kk c0607kkM2734c = C0607kk.m2734c();
        if (c0607kkM2734c.m2744b(f3514aY) == null) {
            C0530jM.logError("[Asset Reload] Templates registry is not registered, cannot hot-reload '%s'.", str);
            return;
        }
        if (c0607kkM2734c.m2744b(f3512aW) == null) {
            C0530jM.logError("[Asset Reload] Maps registry is not registered, cannot cascade after template change '%s'.", str);
            return;
        }
        C0605ki c0605kiM2737a = c0607kkM2734c.m2737a(C0868pg.class);
        if (c0605kiM2737a == null) {
            return;
        }
        int i = 0;
        Iterator it = c0605kiM2737a.m2720d().values().iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = ((C0868pg) it.next()).m4272a();
            if (abstractC0863pbM4272a != null) {
                abstractC0863pbM4272a.m4089a().m6145cM();
                abstractC0863pbM4272a.m4002cy();
                m2731d(abstractC0863pbM4272a);
                C1169vO.m6646a(new C1220wM(abstractC0863pbM4272a, true), abstractC0863pbM4272a);
                MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
                if (minecraftServerM2335a != null) {
                    m2733a(abstractC0863pbM4272a, minecraftServerM2335a.overworld(), null);
                }
                i++;
            }
        }
        C0530jM.log("[Asset Reload] Template '%s' reloaded, cascaded to maps and notified %d active match(es).", str, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: o */
    public static void m2730o(@NotNull String str) {
        C0607kk c0607kkM2734c = C0607kk.m2734c();
        if (c0607kkM2734c.m2737a(C0868pg.class) == null) {
            C0530jM.logError("[Asset Reload] Games registry is not registered, cannot hot-reload '%s'.", str);
        } else {
            c0607kkM2734c.m2744b(f3513aX);
            C0530jM.log("[Asset Reload] Game '%s' reloaded, removed affected players and rebuilt the game asset.", str);
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m2731d(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a == null) {
            return;
        }
        UUID uuidM4064e = abstractC0863pb.m4064e();
        int iM4003bi = abstractC0863pb.m4003bi();
        int i = 0;
        Iterator it = minecraftServerM2335a.getAllLevels().iterator();
        while (it.hasNext()) {
            for (Entity entity : ((ServerLevel) it.next()).getAllEntities()) {
                if (entity != null) {
                    CompoundTag persistentData = entity.getPersistentData();
                    if (persistentData.hasUUID(C0875pn.f4773bU) && uuidM4064e.equals(persistentData.getUUID(C0875pn.f4773bU)) && persistentData.contains(C0875pn.f4775bW) && persistentData.getInt(C0875pn.f4775bW) != iM4003bi) {
                        entity.discard();
                        i++;
                    }
                }
            }
        }
        if (i > 0) {
            C0530jM.log("[Map Reload] Discarded %d stale match entity/entities after environment rebind.", Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2732b(@NotNull String str, @NotNull String str2) {
        switch (str) {
            case "templates":
                m2729n(str2);
                return true;
            case "maps":
                m2728m(str2);
                return true;
            case "games":
                m2730o(str2);
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m2733a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @Nullable ServerPlayer serverPlayer) {
        for (AbstractC0858pW abstractC0858pW : abstractC0863pb.m4089a().m6107az()) {
            if (abstractC0858pW instanceof InterfaceC0918qd) {
                ((InterfaceC0918qd) abstractC0858pW).mo5070a(serverLevel, serverLevel.getRandom());
            }
            if (abstractC0858pW instanceof InterfaceC0921qg) {
                InterfaceC0921qg interfaceC0921qg = (InterfaceC0921qg) abstractC0858pW;
                ByteBuf byteBufBuffer = Unpooled.buffer();
                interfaceC0921qg.mo5071h(byteBufBuffer);
                byte[] bArr = new byte[byteBufBuffer.readableBytes()];
                byteBufBuffer.getBytes(byteBufBuffer.readerIndex(), bArr);
                byteBufBuffer.release();
                if (serverPlayer == null) {
                    C1169vO.m6646a(new C1235wb(abstractC0858pW.f4592y, bArr), abstractC0863pb);
                } else {
                    C1169vO.m6643a(new C1235wb(abstractC0858pW.f4592y, bArr), serverPlayer);
                }
            }
        }
        C1258wy c1258wyM7116a = C1258wy.m7116a(abstractC0863pb);
        if (serverPlayer == null) {
            C1169vO.m6646a(c1258wyM7116a, abstractC0863pb);
        } else {
            C1169vO.m6643a(c1258wyM7116a, serverPlayer);
        }
    }
}
