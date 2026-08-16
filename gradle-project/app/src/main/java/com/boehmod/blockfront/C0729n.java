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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/n.class */
public final class C0729n {

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final Component f4021r = Component.translatable("bf.cloud.auth.error.title");

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final Component f4022s = Component.translatable("bf.cloud.auth.error.message.credentials").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: t */
    @NotNull
    private static final Component f4023t = Component.translatable("bf.cloud.auth.error.message.unknown").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: p */
    private static final String f4024p = m3346f();

    /* JADX INFO: renamed from: z */
    private boolean f4025z = false;

    /* JADX INFO: renamed from: d */
    public void m3344d(@NotNull Minecraft minecraft) {
        try {
            User user = minecraft.getUser();
            minecraft.getMinecraftSessionService().joinServer(user.getProfileId(), user.getAccessToken(), f4024p);
            this.f4025z = true;
        } catch (AuthenticationException e) {
            String message = e.getMessage();
            MutableComponent mutableComponentWithStyle = e instanceof InvalidCredentialsException ? f4022s : message != null ? Component.literal(message).withStyle(ChatFormatting.RED) : f4023t;
            C0301ew.m1625a(minecraft, f4021r, (Component) Component.translatable("bf.cloud.auth.error.message", new Object[]{mutableComponentWithStyle}));
            C0530jM.log("Failed to refresh Minecraft session! (%s)", mutableComponentWithStyle);
            this.f4025z = false;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public String m3345e() {
        return f4024p;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private static String m3346f() {
        return new BigInteger(200, new SecureRandom()).toString(16).substring(0, 40);
    }

    /* JADX INFO: renamed from: h */
    public boolean m3347h() {
        return this.f4025z;
    }
}
