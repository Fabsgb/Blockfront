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

/* JADX INFO: renamed from: com.boehmod.blockfront.jN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jN.class */
public final class C0530jN {

    /* JADX INFO: renamed from: aN */
    @NotNull
    public static final String f3134aN = "maps";

    /* JADX INFO: renamed from: aO */
    @NotNull
    public static final String f3135aO = "games";

    /* JADX INFO: renamed from: aP */
    @NotNull
    public static final String f3136aP = "templates";

    private C0530jN() {
    }

    /* JADX INFO: renamed from: m */
    public static void m2366m(@NotNull String str) {
        C0531jO c0531jOM2372c = C0531jO.m2372c();
        if (c0531jOM2372c.m2382b(f3134aN) == null) {
            C0562jt.logError("[Asset Reload] Maps registry is not registered, cannot hot-reload '%s'.", str);
            return;
        }
        C0529jM c0529jMM2375a = c0531jOM2372c.m2375a(C0792oK.class);
        if (c0529jMM2375a == null) {
            return;
        }
        int i = 0;
        Iterator it = c0529jMM2375a.m2358d().values().iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = ((C0792oK) it.next()).m3836a();
            if (abstractC0787oFM3836a != null && str.equals(abstractC0787oFM3836a.m3591a().getName())) {
                abstractC0787oFM3836a.m3653a().m5657cA();
                abstractC0787oFM3836a.m3566cm();
                m2369d(abstractC0787oFM3836a);
                C1194vo.m6651a(new C1247wo(abstractC0787oFM3836a, true), abstractC0787oFM3836a);
                MinecraftServer minecraftServerM2514a = C0561js.m2514a();
                if (minecraftServerM2514a != null) {
                    m2371a(abstractC0787oFM3836a, minecraftServerM2514a.overworld(), null);
                }
                i++;
            }
        }
        C0562jt.log("[Asset Reload] Map '%s' reloaded, pushed fresh map data to %d active match(es).", str, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: n */
    public static void m2367n(@NotNull String str) {
        C0531jO c0531jOM2372c = C0531jO.m2372c();
        if (c0531jOM2372c.m2382b(f3136aP) == null) {
            C0562jt.logError("[Asset Reload] Templates registry is not registered, cannot hot-reload '%s'.", str);
            return;
        }
        if (c0531jOM2372c.m2382b(f3134aN) == null) {
            C0562jt.logError("[Asset Reload] Maps registry is not registered, cannot cascade after template change '%s'.", str);
            return;
        }
        C0529jM c0529jMM2375a = c0531jOM2372c.m2375a(C0792oK.class);
        if (c0529jMM2375a == null) {
            return;
        }
        int i = 0;
        Iterator it = c0529jMM2375a.m2358d().values().iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = ((C0792oK) it.next()).m3836a();
            if (abstractC0787oFM3836a != null) {
                abstractC0787oFM3836a.m3653a().m5657cA();
                abstractC0787oFM3836a.m3566cm();
                m2369d(abstractC0787oFM3836a);
                C1194vo.m6651a(new C1247wo(abstractC0787oFM3836a, true), abstractC0787oFM3836a);
                MinecraftServer minecraftServerM2514a = C0561js.m2514a();
                if (minecraftServerM2514a != null) {
                    m2371a(abstractC0787oFM3836a, minecraftServerM2514a.overworld(), null);
                }
                i++;
            }
        }
        C0562jt.log("[Asset Reload] Template '%s' reloaded, cascaded to maps and notified %d active match(es).", str, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: o */
    public static void m2368o(@NotNull String str) {
        C0531jO c0531jOM2372c = C0531jO.m2372c();
        if (c0531jOM2372c.m2375a(C0792oK.class) == null) {
            C0562jt.logError("[Asset Reload] Games registry is not registered, cannot hot-reload '%s'.", str);
        } else {
            c0531jOM2372c.m2382b(f3135aO);
            C0562jt.log("[Asset Reload] Game '%s' reloaded, removed affected players and rebuilt the game asset.", str);
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m2369d(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a == null) {
            return;
        }
        UUID uuidM3628e = abstractC0787oF.m3628e();
        int iM3567aT = abstractC0787oF.m3567aT();
        int i = 0;
        Iterator it = minecraftServerM2514a.getAllLevels().iterator();
        while (it.hasNext()) {
            for (Entity entity : ((ServerLevel) it.next()).getAllEntities()) {
                if (entity != null) {
                    CompoundTag persistentData = entity.getPersistentData();
                    if (persistentData.hasUUID(C0799oR.f4377bK) && uuidM3628e.equals(persistentData.getUUID(C0799oR.f4377bK)) && persistentData.contains(C0799oR.f4379bM) && persistentData.getInt(C0799oR.f4379bM) != iM3567aT) {
                        entity.discard();
                        i++;
                    }
                }
            }
        }
        if (i > 0) {
            C0562jt.log("[Map Reload] Discarded %d stale match entity/entities after environment rebind.", Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2370a(@NotNull String str, @NotNull String str2) {
        switch (str) {
            case "templates":
                m2367n(str2);
                return true;
            case "maps":
                m2366m(str2);
                return true;
            case "games":
                m2368o(str2);
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m2371a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @Nullable ServerPlayer serverPlayer) {
        for (AbstractC0835pA abstractC0835pA : abstractC0787oF.m3653a().m5619ax()) {
            if (abstractC0835pA instanceof InterfaceC0842pH) {
                ((InterfaceC0842pH) abstractC0835pA).mo4268a(serverLevel, serverLevel.getRandom());
            }
            if (abstractC0835pA instanceof InterfaceC0845pK) {
                InterfaceC0845pK interfaceC0845pK = (InterfaceC0845pK) abstractC0835pA;
                ByteBuf byteBufBuffer = Unpooled.buffer();
                interfaceC0845pK.mo4277h(byteBufBuffer);
                byte[] bArr = new byte[byteBufBuffer.readableBytes()];
                byteBufBuffer.getBytes(byteBufBuffer.readerIndex(), bArr);
                byteBufBuffer.release();
                if (serverPlayer == null) {
                    C1194vo.m6651a(new C1156vC(abstractC0835pA.f4463y, bArr), abstractC0787oF);
                } else {
                    C1194vo.m6648a(new C1156vC(abstractC0835pA.f4463y, bArr), serverPlayer);
                }
            }
        }
        C1178vY c1178vYM6590a = C1178vY.m6590a(abstractC0787oF);
        if (serverPlayer == null) {
            C1194vo.m6651a(c1178vYM6590a, abstractC0787oF);
        } else {
            C1194vo.m6648a(c1178vYM6590a, serverPlayer);
        }
    }
}
