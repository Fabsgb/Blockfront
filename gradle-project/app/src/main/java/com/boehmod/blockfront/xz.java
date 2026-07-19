package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.common.PatternReferences;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xz.class */
public class xz {

    @NotNull
    private static final Component kc = Component.translatable("bf.message.chat.spam.muted").withStyle(ChatFormatting.RED);

    @NotNull
    private static final Component kd = Component.translatable("bf.message.chat.spam.caps").withStyle(ChatFormatting.RED);

    @NotNull
    private static final Component ke = Component.translatable("bf.message.chat.spam.link").withStyle(ChatFormatting.RED);

    @NotNull
    private static final Component kf = Component.translatable("bf.message.chat.spam.profanity").withStyle(ChatFormatting.RED);

    @NotNull
    private static final List<a> cm = new ObjectArrayList();

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xz$a.class */
    private interface a {
        @Nullable
        Component getMessage(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar, @NotNull iS iSVar, @NotNull String str);
    }

    static {
        cm.add((abstractC0264ju, serverLevel, serverPlayer, bVar, iSVar, str) -> {
            if (iSVar.hasActivePunishment(PunishmentType.MUTE) || bVar.dn()) {
                return kc;
            }
            return null;
        });
        cm.add((abstractC0264ju2, serverLevel2, serverPlayer2, bVar2, iSVar2, str2) -> {
            if (str2.length() > 5 && a(serverLevel2, str2) > 50.0d) {
                return kd;
            }
            return null;
        });
        cm.add((abstractC0264ju3, serverLevel3, serverPlayer3, bVar3, iSVar3, str3) -> {
            if (PatternReferences.LINK.matcher(str3).find()) {
                return ke;
            }
            return null;
        });
        cm.add((abstractC0264ju4, serverLevel4, serverPlayer4, bVar4, iSVar4, str4) -> {
            if ((abstractC0264ju4 instanceof xw) && ((xw) abstractC0264ju4).m1709a().processMessage(serverPlayer4.getUUID(), str4) > 1) {
                return kf;
            }
            return null;
        });
        cm.add((abstractC0264ju5, serverLevel5, serverPlayer5, bVar5, iSVar5, str5) -> {
            long j = bVar5.j();
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis - j);
            String strAE = bVar5.aE();
            if (strAE != null && strAE.equals(str5) && seconds <= 10) {
                return Component.translatable("bf.message.chat.spam.clone", new Object[]{Long.valueOf(10 - seconds)}).withStyle(ChatFormatting.RED);
            }
            bVar5.F(str5);
            bVar5.e(timeInMillis);
            return null;
        });
    }

    public static Component a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull ServerLevel serverLevel, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar, @NotNull iS iSVar, @NotNull String str) {
        return (Component) cm.stream().map(aVar -> {
            return aVar.getMessage(abstractC0264ju, serverLevel, serverPlayer, bVar, iSVar, str);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).findFirst().orElse(null);
    }

    public static double a(@NotNull ServerLevel serverLevel, @NotNull String str) {
        Iterator it = serverLevel.players().iterator();
        while (it.hasNext()) {
            str = str.replace(((ServerPlayer) it.next()).getScoreboardName(), "");
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isUpperCase(str.charAt(i2))) {
                i++;
            }
        }
        return (((double) i) * 100.0d) / ((double) length);
    }
}
