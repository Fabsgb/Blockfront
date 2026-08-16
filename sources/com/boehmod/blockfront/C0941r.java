package com.boehmod.blockfront;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.r */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/r.class */
public final class C0941r {

    /* JADX INFO: renamed from: b */
    private static final double f5208b = 150.0d;

    /* JADX INFO: renamed from: f */
    private static final float f5209f = 5.0f;

    /* JADX INFO: renamed from: g */
    private static final float f5210g = 0.35f;

    /* JADX INFO: renamed from: h */
    private static final float f5211h = 1.5f;

    /* JADX INFO: renamed from: w */
    private static final int f5212w = 100;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static a f5213a = a.HUMANIZED;

    /* JADX INFO: renamed from: A */
    private static boolean f5214A;

    /* JADX INFO: renamed from: x */
    private static int f5215x;

    /* JADX INFO: renamed from: com.boehmod.blockfront.r$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/r$a.class */
    public enum a {
        LOCK,
        SMOOTH,
        HUMANIZED
    }

    private C0941r() {
    }

    /* JADX INFO: renamed from: a */
    public static void m5171a(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer) {
        C0756na c0756naM5173a;
        boolean z = localPlayer != null && minecraft.options.keyShift.isDown();
        if (z && !f5214A) {
            a[] aVarArrValues = a.values();
            f5213a = aVarArrValues[(f5213a.ordinal() + 1) % aVarArrValues.length];
            f5215x = 100;
            C0530jM.log("[AimTestHack] Engaged, mode: " + String.valueOf(f5213a), new Object[0]);
            minecraft.gui.getChat().addMessage(Component.literal("[AimTestHack] ").withStyle(ChatFormatting.RED).append(Component.literal("Mode: " + String.valueOf(f5213a)).withStyle(ChatFormatting.YELLOW)));
        } else if (!z && f5214A) {
            m5174h();
        }
        f5214A = z;
        if (z && (c0756naM5173a = m5173a(minecraft, localPlayer)) != null) {
            m5172a(localPlayer, c0756naM5173a);
            int i = f5215x;
            f5215x = i - 1;
            if (i <= 0) {
                f5215x = 100;
                m5174h();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5172a(@NotNull LocalPlayer localPlayer, @NotNull C0756na c0756na) {
        Vec3 vec3Subtract = c0756na.getEyePosition().subtract(localPlayer.getEyePosition());
        double dSqrt = Math.sqrt((vec3Subtract.x * vec3Subtract.x) + (vec3Subtract.z * vec3Subtract.z));
        float fAtan2 = ((float) (Math.atan2(vec3Subtract.z, vec3Subtract.x) * 57.2957763671875d)) - 90.0f;
        float f = (float) (-(Math.atan2(vec3Subtract.y, dSqrt) * 57.2957763671875d));
        float fWrapDegrees = Mth.wrapDegrees(fAtan2 - localPlayer.getYRot());
        float fWrapDegrees2 = Mth.wrapDegrees(f - localPlayer.getXRot());
        switch (f5213a.ordinal()) {
            case 1:
                fWrapDegrees = Mth.clamp(fWrapDegrees, -5.0f, 5.0f);
                fWrapDegrees2 = Mth.clamp(fWrapDegrees2, -5.0f, 5.0f);
                break;
            case 2:
                ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
                fWrapDegrees = (fWrapDegrees * 0.35f) + ((threadLocalRandomCurrent.nextFloat() - 0.5f) * 2.0f * 1.5f);
                fWrapDegrees2 = (fWrapDegrees2 * 0.35f) + ((threadLocalRandomCurrent.nextFloat() - 0.5f) * 2.0f * 1.5f);
                break;
        }
        localPlayer.setYRot(localPlayer.getYRot() + fWrapDegrees);
        localPlayer.setXRot(Mth.clamp(localPlayer.getXRot() + fWrapDegrees2, -90.0f, 90.0f));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0756na m5173a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        C0872pk c0872pkM4229a;
        String strM3560L;
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel == null) {
            return null;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b != null ? c0623lM2852b.m2874a() : null;
        if (abstractC0863pbM2874a == null || (c0872pkM4229a = abstractC0863pbM2874a.m4018b().m4229a(localPlayer.getUUID())) == null) {
            return null;
        }
        C0756na c0756na = null;
        double d = 22500.0d;
        for (Entity entity : clientLevel.entitiesForRendering()) {
            if (entity instanceof C0756na) {
                C0756na c0756na2 = (C0756na) entity;
                if (c0756na2.isAlive() && (strM3560L = c0756na2.m3560L()) != null && !c0872pkM4229a.getName().equalsIgnoreCase(strM3560L)) {
                    double dDistanceToSqr = c0756na2.distanceToSqr(localPlayer);
                    if (dDistanceToSqr < d && localPlayer.hasLineOfSight(c0756na2)) {
                        d = dDistanceToSqr;
                        c0756na = c0756na2;
                    }
                }
            }
        }
        return c0756na;
    }

    /* JADX INFO: renamed from: h */
    private static void m5174h() {
        C1154v.b bVarM6583a = C1154v.m6583a();
        C0530jM.log(String.format(Locale.ROOT, "[AimTestHack] mode=%s | n=%d m=%d run=%d med=%.2f max=%.2f", f5213a, Long.valueOf(bVarM6583a.m6584a()), Integer.valueOf(bVarM6583a.m6585h()), Integer.valueOf(bVarM6583a.m6586i()), Double.valueOf(bVarM6583a.m6587a()), Double.valueOf(bVarM6583a.m6588b())), new Object[0]);
    }
}
