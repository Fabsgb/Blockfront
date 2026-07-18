package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.common.PatternReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xz.class */
public class C1303xz {

    /* JADX INFO: renamed from: kc */
    @NotNull
    private static final Component f8706kc = Component.translatable("bf.message.chat.spam.muted").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: kd */
    @NotNull
    private static final Component f8707kd = Component.translatable("bf.message.chat.spam.caps").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ke */
    @NotNull
    private static final Component f8708ke = Component.translatable("bf.message.chat.spam.link").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: kf */
    @NotNull
    private static final Component f8709kf = Component.translatable("bf.message.chat.spam.profanity").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: cm */
    @NotNull
    private static final List<a> f8710cm = new ObjectArrayList();

    /* JADX INFO: renamed from: com.boehmod.blockfront.xz$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xz$a.class */
    private interface a {
        @Nullable
        Component getMessage(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b, @NotNull C0482iS c0482iS, @NotNull String str);
    }

    static {
        f8710cm.add((abstractC0563ju, serverLevel, serverPlayer, abstractC0182b, c0482iS, str) -> {
            if (c0482iS.hasActivePunishment(PunishmentType.MUTE) || abstractC0182b.m1113dn()) {
                return f8706kc;
            }
            return null;
        });
        f8710cm.add((abstractC0563ju2, serverLevel2, serverPlayer2, abstractC0182b2, c0482iS2, str2) -> {
            if (str2.length() > 5 && m7968a(serverLevel2, str2) > 50.0d) {
                return f8707kd;
            }
            return null;
        });
        f8710cm.add((abstractC0563ju3, serverLevel3, serverPlayer3, abstractC0182b3, c0482iS3, str3) -> {
            if (PatternReferences.LINK.matcher(str3).find()) {
                return f8708ke;
            }
            return null;
        });
        f8710cm.add((abstractC0563ju4, serverLevel4, serverPlayer4, abstractC0182b4, c0482iS4, str4) -> {
            if ((abstractC0563ju4 instanceof C1300xw) && ((C1300xw) abstractC0563ju4).m7951a().processMessage(serverPlayer4.getUUID(), str4) > 1) {
                return f8709kf;
            }
            return null;
        });
        f8710cm.add((abstractC0563ju5, serverLevel5, serverPlayer5, abstractC0182b5, c0482iS5, str5) -> {
            long jM1109j = abstractC0182b5.m1109j();
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis - jM1109j);
            String strM1106aE = abstractC0182b5.m1106aE();
            if (strM1106aE != null && strM1106aE.equals(str5) && seconds <= 10) {
                return Component.translatable("bf.message.chat.spam.clone", new Object[]{Long.valueOf(10 - seconds)}).withStyle(ChatFormatting.RED);
            }
            abstractC0182b5.m1107F(str5);
            abstractC0182b5.m1110e(timeInMillis);
            return null;
        });
    }

    /* JADX INFO: renamed from: a */
    public static Component m7967a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull ServerLevel serverLevel, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b, @NotNull C0482iS c0482iS, @NotNull String str) {
        return (Component) f8710cm.stream().map(aVar -> {
            return aVar.getMessage(abstractC0563ju, serverLevel, serverPlayer, abstractC0182b, c0482iS, str);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).findFirst().orElse(null);
    }

    /* JADX INFO: renamed from: a */
    public static double m7968a(@NotNull ServerLevel serverLevel, @NotNull String str) {
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
