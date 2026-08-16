package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.common.PatternReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xW.class */
public class C1283xW {

    /* JADX INFO: renamed from: kp */
    @NotNull
    private static final Component f6905kp = Component.translatable("bf.message.chat.spam.muted").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: kq */
    @NotNull
    private static final Component f6906kq = Component.translatable("bf.message.chat.spam.caps").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: kr */
    @NotNull
    private static final Component f6907kr = Component.translatable("bf.message.chat.spam.link").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ks */
    @NotNull
    private static final Component f6908ks = Component.translatable("bf.message.chat.spam.profanity").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: cu */
    @NotNull
    private static final List<a> f6909cu = new ObjectArrayList();

    /* JADX INFO: renamed from: com.boehmod.blockfront.xW$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xW$a.class */
    private interface a {
        @Nullable
        Component getMessage(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b, @NotNull C0555jl c0555jl, @NotNull String str);
    }

    static {
        f6909cu.add((abstractC0531jN, serverLevel, serverPlayer, abstractC0183b, c0555jl, str) -> {
            if (c0555jl.hasActivePunishment(PunishmentType.MUTE) || abstractC0183b.m1130dw()) {
                return f6905kp;
            }
            return null;
        });
        f6909cu.add((abstractC0531jN2, serverLevel2, serverPlayer2, abstractC0183b2, c0555jl2, str2) -> {
            if (str2.length() > 5 && m7296a(serverLevel2, str2) > 50.0d) {
                return f6906kq;
            }
            return null;
        });
        f6909cu.add((abstractC0531jN3, serverLevel3, serverPlayer3, abstractC0183b3, c0555jl3, str3) -> {
            if (PatternReferences.LINK.matcher(str3).find()) {
                return f6907kr;
            }
            return null;
        });
        f6909cu.add((abstractC0531jN4, serverLevel4, serverPlayer4, abstractC0183b4, c0555jl4, str4) -> {
            if ((abstractC0531jN4 instanceof C1280xT) && ((C1280xT) abstractC0531jN4).m7278a().processMessage(serverPlayer4.getUUID(), str4) > 1) {
                return f6908ks;
            }
            return null;
        });
        f6909cu.add((abstractC0531jN5, serverLevel5, serverPlayer5, abstractC0183b5, c0555jl5, str5) -> {
            long jM1126k = abstractC0183b5.m1126k();
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis - jM1126k);
            String strM1123aL = abstractC0183b5.m1123aL();
            if (strM1123aL != null && strM1123aL.equals(str5) && seconds <= 10) {
                return Component.translatable("bf.message.chat.spam.clone", new Object[]{Long.valueOf(10 - seconds)}).withStyle(ChatFormatting.RED);
            }
            abstractC0183b5.m1124F(str5);
            abstractC0183b5.m1127f(timeInMillis);
            return null;
        });
    }

    /* JADX INFO: renamed from: a */
    public static Component m7295a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull ServerLevel serverLevel, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b, @NotNull C0555jl c0555jl, @NotNull String str) {
        return (Component) f6909cu.stream().map(aVar -> {
            return aVar.getMessage(abstractC0531jN, serverLevel, serverPlayer, abstractC0183b, c0555jl, str);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).findFirst().orElse(null);
    }

    /* JADX INFO: renamed from: a */
    public static double m7296a(@NotNull ServerLevel serverLevel, @NotNull String str) {
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
