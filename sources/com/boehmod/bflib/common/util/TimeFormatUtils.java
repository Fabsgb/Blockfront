package com.boehmod.bflib.common.util;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/common/util/TimeFormatUtils.class */
public final class TimeFormatUtils {
    private TimeFormatUtils() {
    }

    @NotNull
    public static String formatRelativeTime(long epochMillis) {
        long diff = Math.max(0L, System.currentTimeMillis() - epochMillis);
        long minutes = diff / 60000;
        if (minutes < 1) {
            return "Just now";
        }
        if (minutes < 60) {
            return minutes + "m ago";
        }
        long hours = minutes / 60;
        if (hours < 24) {
            return hours + "h ago";
        }
        long days = hours / 24;
        return days + "d ago";
    }

    @NotNull
    public static String formatDuration(long seconds) {
        long minutes = seconds / 60;
        long remainder = seconds % 60;
        return String.format(Locale.ROOT, "%dm %02ds", Long.valueOf(minutes), Long.valueOf(remainder));
    }

    @NotNull
    public static String formatDurationBreakdown(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }
        long days = TimeUnit.MILLISECONDS.toDays(millis);
        long millis2 = millis - TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis2);
        long millis3 = millis2 - TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis3);
        TimeUnit.MILLISECONDS.toSeconds(millis3 - TimeUnit.MINUTES.toMillis(minutes));
        return days + "d " + days + "h " + hours + "m " + days + "s";
    }
}
