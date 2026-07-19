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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jN.class */
public final class jN {

    @NotNull
    public static final String aN = "maps";

    @NotNull
    public static final String aO = "games";

    @NotNull
    public static final String aP = "templates";

    private jN() {
    }

    public static void m(@NotNull String str) {
        jO jOVarC = jO.c();
        if (jOVarC.b(aN) == null) {
            C0263jt.logError("[Asset Reload] Maps registry is not registered, cannot hot-reload '%s'.", str);
            return;
        }
        jM jMVarA = jOVarC.a(oK.class);
        if (jMVarA == null) {
            return;
        }
        int i = 0;
        Iterator it = jMVarA.d().values().iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = ((oK) it.next()).a();
            if (oFVarA != null && str.equals(oFVarA.m751a().getName())) {
                oFVarA.m767a().cA();
                oFVarA.cm();
                d(oFVarA);
                C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
                MinecraftServer minecraftServerA = C0262js.a();
                if (minecraftServerA != null) {
                    a(oFVarA, minecraftServerA.overworld(), null);
                }
                i++;
            }
        }
        C0263jt.log("[Asset Reload] Map '%s' reloaded, pushed fresh map data to %d active match(es).", str, Integer.valueOf(i));
    }

    public static void n(@NotNull String str) {
        jO jOVarC = jO.c();
        if (jOVarC.b(aP) == null) {
            C0263jt.logError("[Asset Reload] Templates registry is not registered, cannot hot-reload '%s'.", str);
            return;
        }
        if (jOVarC.b(aN) == null) {
            C0263jt.logError("[Asset Reload] Maps registry is not registered, cannot cascade after template change '%s'.", str);
            return;
        }
        jM jMVarA = jOVarC.a(oK.class);
        if (jMVarA == null) {
            return;
        }
        int i = 0;
        Iterator it = jMVarA.d().values().iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = ((oK) it.next()).a();
            if (oFVarA != null) {
                oFVarA.m767a().cA();
                oFVarA.cm();
                d(oFVarA);
                C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
                MinecraftServer minecraftServerA = C0262js.a();
                if (minecraftServerA != null) {
                    a(oFVarA, minecraftServerA.overworld(), null);
                }
                i++;
            }
        }
        C0263jt.log("[Asset Reload] Template '%s' reloaded, cascaded to maps and notified %d active match(es).", str, Integer.valueOf(i));
    }

    public static void o(@NotNull String str) {
        jO jOVarC = jO.c();
        if (jOVarC.a(oK.class) == null) {
            C0263jt.logError("[Asset Reload] Games registry is not registered, cannot hot-reload '%s'.", str);
        } else {
            jOVarC.b(aO);
            C0263jt.log("[Asset Reload] Game '%s' reloaded, removed affected players and rebuilt the game asset.", str);
        }
    }

    private static void d(@NotNull oF<?, ?, ?> oFVar) {
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA == null) {
            return;
        }
        UUID uuidM757e = oFVar.m757e();
        int iAT = oFVar.aT();
        int i = 0;
        Iterator it = minecraftServerA.getAllLevels().iterator();
        while (it.hasNext()) {
            for (Entity entity : ((ServerLevel) it.next()).getAllEntities()) {
                if (entity != null) {
                    CompoundTag persistentData = entity.getPersistentData();
                    if (persistentData.hasUUID(oR.bK) && uuidM757e.equals(persistentData.getUUID(oR.bK)) && persistentData.contains(oR.bM) && persistentData.getInt(oR.bM) != iAT) {
                        entity.discard();
                        i++;
                    }
                }
            }
        }
        if (i > 0) {
            C0263jt.log("[Map Reload] Discarded %d stale match entity/entities after environment rebind.", Integer.valueOf(i));
        }
    }

    public static boolean a(@NotNull String str, @NotNull String str2) {
        switch (str) {
            case "templates":
                n(str2);
                return true;
            case "maps":
                m(str2);
                return true;
            case "games":
                o(str2);
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @Nullable ServerPlayer serverPlayer) {
        for (pA pAVar : oFVar.m767a().ax()) {
            if (pAVar instanceof pH) {
                ((pH) pAVar).a(serverLevel, serverLevel.getRandom());
            }
            if (pAVar instanceof pK) {
                pK pKVar = (pK) pAVar;
                ByteBuf byteBufBuffer = Unpooled.buffer();
                pKVar.h(byteBufBuffer);
                byte[] bArr = new byte[byteBufBuffer.readableBytes()];
                byteBufBuffer.getBytes(byteBufBuffer.readerIndex(), bArr);
                byteBufBuffer.release();
                if (serverPlayer == null) {
                    C0582vo.a(new vC(pAVar.y, bArr), oFVar);
                } else {
                    C0582vo.a(new vC(pAVar.y, bArr), serverPlayer);
                }
            }
        }
        vY vYVarA = vY.a(oFVar);
        if (serverPlayer == null) {
            C0582vo.a(vYVarA, oFVar);
        } else {
            C0582vo.a(vYVarA, serverPlayer);
        }
    }
}
