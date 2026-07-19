package com.boehmod.blockfront;

import com.mojang.authlib.GameProfile;
import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.CreateParams;
import de.jcm.discordgamesdk.LogLevel;
import de.jcm.discordgamesdk.activity.Activity;
import de.jcm.discordgamesdk.activity.ActivityAssets;
import de.jcm.discordgamesdk.activity.ActivityButton;
import de.jcm.discordgamesdk.activity.ActivityButtonsMode;
import de.jcm.discordgamesdk.activity.ActivityParty;
import de.jcm.discordgamesdk.activity.ActivityPartySize;
import de.jcm.discordgamesdk.activity.ActivitySecrets;
import de.jcm.discordgamesdk.activity.ActivityType;
import java.time.Instant;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/W.class */
public class W {

    @NotNull
    private static final String y = "bf.discord.rpc.state";

    @NotNull
    private static final String z = "bf.discord.rpc.button.join";
    private static final int ac = 100;
    private static final long b = 664231140651040768L;
    public static final int ad = 1200;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Core f26a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread f27a;

    @NotNull
    private final C0297l d;

    @NotNull
    private final Instant a = Instant.now();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final ActivityButton f25a = new ActivityButton(I18n.get(z, new Object[0]), C0261jr.az);
    private int ae = 0;
    private int af = 0;

    public W(@NotNull C0297l c0297l, @NotNull iS iSVar) {
        this.d = c0297l;
        b(iSVar);
    }

    private static String a(@NotNull GameProfile gameProfile) {
        return String.format(C0261jr.ay, gameProfile.getId().toString());
    }

    private static String a(@NotNull iS iSVar, @NotNull GameProfile gameProfile) {
        return iSVar.getRank().getTitle() + " " + gameProfile.getName();
    }

    @NotNull
    private static String a(@Nullable oF<?, ?, ?> oFVar, @NotNull iS iSVar) {
        sW sWVarA;
        String string = Component.translatable(iSVar.getStatus().getOnlineStatus().toString()).getString();
        if (oFVar != null && (sWVarA = sW.a(oFVar.M())) != null) {
            string = Component.translatable("bf.discord.rpc.status.playing", new Object[]{sWVarA.getDisplayName().getString(), oFVar.m751a().getName()}).getString();
        }
        return string;
    }

    private void b(@NotNull iS iSVar) {
        C0263jt.log("Attempting to initialize Discord manager...", new Object[0]);
        try {
            this.f26a = a();
            d(iSVar);
            t();
            C0263jt.log("Successfully initialized Discord manager.", new Object[0]);
        } catch (Exception e) {
            C0263jt.logError("Failed to initialize Discord manager. (%s)", e.getMessage());
            this.f26a = null;
        }
    }

    private Core a() {
        C0263jt.log("Attempting to create Discord Game API core...", new Object[0]);
        CreateParams createParams = new CreateParams();
        createParams.setClientID(b);
        createParams.setFlags(CreateParams.getDefaultFlags());
        createParams.registerEventHandler(new V(this.d));
        Core core = new Core(createParams);
        core.setLogHook(LogLevel.VERBOSE, (logLevel, str) -> {
        });
        return core;
    }

    private void t() {
        if (this.f27a != null) {
            return;
        }
        this.f27a = new Thread(() -> {
            while (true) {
                v();
            }
        }, "Discord Callback Thread");
        this.f27a.start();
    }

    public void shutdown() {
        C0263jt.log("Shutting down Discord manager...", new Object[0]);
        u();
        this.f26a = null;
    }

    private void u() {
        C0263jt.log("Closing Discord core...", new Object[0]);
        if (this.f26a != null) {
            try {
                this.f26a.close();
                C0263jt.log("Successfully closed Discord core.", new Object[0]);
            } catch (Exception e) {
                C0263jt.logError("Failed to close Discord core. (%s)", e.getMessage());
            }
        }
    }

    public void c(@NotNull iS iSVar) {
        if (this.f26a == null) {
            int i = this.af;
            this.af = i - 1;
            if (i <= 0) {
                b(iSVar);
                this.af = 1200;
                return;
            }
            return;
        }
        int i2 = this.ae;
        this.ae = i2 - 1;
        if (i2 <= 0) {
            this.ae = 100;
            d(iSVar);
        }
    }

    private void d(@NotNull iS iSVar) {
        ActivitySecrets activitySecretsSecrets;
        GameProfile gameProfile = Minecraft.getInstance().getGameProfile();
        oF<?, ?, ?> oFVarM591a = this.d.m591a();
        Activity activity = new Activity();
        activity.setDetails("BlockFront - v" + C0002a.c);
        activity.setState(I18n.get(y, new Object[0]));
        activity.setType(ActivityType.PLAYING);
        activity.timestamps().setStart(this.a);
        this.f25a.setLabel(I18n.get(z, new Object[0]));
        activity.setActivityButtonsMode(ActivityButtonsMode.BUTTONS);
        activity.addButton(this.f25a);
        a(activity.party(), oFVarM591a);
        if (oFVarM591a != null && (activitySecretsSecrets = activity.secrets()) != null) {
            activitySecretsSecrets.setJoinSecret(gameProfile.getId().toString());
        }
        ActivityAssets activityAssetsAssets = activity.assets();
        activityAssetsAssets.setLargeText(a(oFVarM591a, iSVar));
        activityAssetsAssets.setLargeImage(C0261jr.aD);
        activityAssetsAssets.setSmallText(a(iSVar, gameProfile));
        activityAssetsAssets.setSmallImage(a(gameProfile));
        if (this.f26a != null) {
            try {
                this.f26a.activityManager().updateActivity(activity);
            } catch (Exception e) {
                C0263jt.logError("Failed to update Discord rich presence. (%s)", e.getMessage());
                shutdown();
            }
        }
    }

    private void a(@NotNull ActivityParty activityParty, @Nullable oF<?, ?, ?> oFVar) {
        if (oFVar != null) {
            oI oIVarB = oFVar.b();
            ActivityPartySize size = activityParty.size();
            size.setCurrentSize(oIVarB.h().size());
            size.setMaxSize(oIVarB.aX());
        }
    }

    private void v() {
        if (this.f26a == null) {
            return;
        }
        try {
            this.f26a.runCallbacks();
            Thread.sleep(16L);
        } catch (Exception e) {
            C0263jt.logError("Failed to run Discord callbacks. (%s)", e.getMessage());
            shutdown();
        }
    }
}
