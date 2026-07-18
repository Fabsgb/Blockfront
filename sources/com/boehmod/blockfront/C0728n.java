package com.boehmod.blockfront;

import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import java.math.BigInteger;
import java.security.SecureRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.User;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.n */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/n.class */
public final class C0728n {

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final Component f3898r = Component.translatable("bf.cloud.auth.error.title");

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final Component f3899s = Component.translatable("bf.cloud.auth.error.message.credentials").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: t */
    @NotNull
    private static final Component f3900t = Component.translatable("bf.cloud.auth.error.message.unknown").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: o */
    private static final String f3901o = m3288f();

    /* JADX INFO: renamed from: y */
    private boolean f3902y = false;

    /* JADX INFO: renamed from: d */
    public void m3286d(@NotNull Minecraft minecraft) {
        try {
            User user = minecraft.getUser();
            minecraft.getMinecraftSessionService().joinServer(user.getProfileId(), user.getAccessToken(), f3901o);
            this.f3902y = true;
        } catch (AuthenticationException e) {
            String message = e.getMessage();
            MutableComponent mutableComponentWithStyle = e instanceof InvalidCredentialsException ? f3899s : message != null ? Component.literal(message).withStyle(ChatFormatting.RED) : f3900t;
            C0287ej.m1509a(minecraft, f3898r, (Component) Component.translatable("bf.cloud.auth.error.message", new Object[]{mutableComponentWithStyle}));
            C0562jt.log("Failed to refresh Minecraft session! (%s)", mutableComponentWithStyle);
            this.f3902y = false;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public String m3287e() {
        return f3901o;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private static String m3288f() {
        return new BigInteger(200, new SecureRandom()).toString(16).substring(0, 40);
    }

    /* JADX INFO: renamed from: h */
    public boolean m3289h() {
        return this.f3902y;
    }
}
