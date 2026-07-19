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

/* JADX INFO: renamed from: com.boehmod.blockfront.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/n.class */
public final class C0351n {

    @NotNull
    private static final Component r = Component.translatable("bf.cloud.auth.error.title");

    @NotNull
    private static final Component s = Component.translatable("bf.cloud.auth.error.message.credentials").withStyle(ChatFormatting.RED);

    @NotNull
    private static final Component t = Component.translatable("bf.cloud.auth.error.message.unknown").withStyle(ChatFormatting.RED);
    private static final String o = f();
    private boolean y = false;

    public void d(@NotNull Minecraft minecraft) {
        try {
            User user = minecraft.getUser();
            minecraft.getMinecraftSessionService().joinServer(user.getProfileId(), user.getAccessToken(), o);
            this.y = true;
        } catch (AuthenticationException e) {
            String message = e.getMessage();
            MutableComponent mutableComponentWithStyle = e instanceof InvalidCredentialsException ? s : message != null ? Component.literal(message).withStyle(ChatFormatting.RED) : t;
            C0119ej.a(minecraft, r, (Component) Component.translatable("bf.cloud.auth.error.message", new Object[]{mutableComponentWithStyle}));
            C0263jt.log("Failed to refresh Minecraft session! (%s)", mutableComponentWithStyle);
            this.y = false;
        }
    }

    @NotNull
    public String e() {
        return o;
    }

    @NotNull
    private static String f() {
        return new BigInteger(200, new SecureRandom()).toString(16).substring(0, 40);
    }

    public boolean h() {
        return this.y;
    }
}
