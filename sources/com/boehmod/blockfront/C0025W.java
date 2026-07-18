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

/* JADX INFO: renamed from: com.boehmod.blockfront.W */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/W.class */
public class C0025W {

    /* JADX INFO: renamed from: y */
    @NotNull
    private static final String f227y = "bf.discord.rpc.state";

    /* JADX INFO: renamed from: z */
    @NotNull
    private static final String f228z = "bf.discord.rpc.button.join";

    /* JADX INFO: renamed from: ac */
    private static final int f229ac = 100;

    /* JADX INFO: renamed from: b */
    private static final long f230b = 664231140651040768L;

    /* JADX INFO: renamed from: ad */
    public static final int f231ad = 1200;

    /* JADX INFO: renamed from: a */
    private Core f234a;

    /* JADX INFO: renamed from: a */
    private Thread f237a;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0622l f238d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Instant f232a = Instant.now();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ActivityButton f233a = new ActivityButton(I18n.get(f228z, new Object[0]), C0560jr.f3180az);

    /* JADX INFO: renamed from: ae */
    private int f235ae = 0;

    /* JADX INFO: renamed from: af */
    private int f236af = 0;

    public C0025W(@NotNull C0622l c0622l, @NotNull C0482iS c0482iS) {
        this.f238d = c0622l;
        m152b(c0482iS);
    }

    /* JADX INFO: renamed from: a */
    private static String m149a(@NotNull GameProfile gameProfile) {
        return String.format(C0560jr.f3179ay, gameProfile.getId().toString());
    }

    /* JADX INFO: renamed from: a */
    private static String m150a(@NotNull C0482iS c0482iS, @NotNull GameProfile gameProfile) {
        return c0482iS.getRank().getTitle() + " " + gameProfile.getName();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m151a(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0482iS c0482iS) {
        C1016sW c1016sWM5531a;
        String string = Component.translatable(c0482iS.getStatus().getOnlineStatus().toString()).getString();
        if (abstractC0787oF != null && (c1016sWM5531a = C1016sW.m5531a(abstractC0787oF.m3594M())) != null) {
            string = Component.translatable("bf.discord.rpc.status.playing", new Object[]{c1016sWM5531a.getDisplayName().getString(), abstractC0787oF.m3591a().getName()}).getString();
        }
        return string;
    }

    /* JADX INFO: renamed from: b */
    private void m152b(@NotNull C0482iS c0482iS) {
        C0562jt.log("Attempting to initialize Discord manager...", new Object[0]);
        try {
            this.f234a = m153a();
            m157d(c0482iS);
            m154t();
            C0562jt.log("Successfully initialized Discord manager.", new Object[0]);
        } catch (Exception e) {
            C0562jt.logError("Failed to initialize Discord manager. (%s)", e.getMessage());
            this.f234a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private Core m153a() {
        C0562jt.log("Attempting to create Discord Game API core...", new Object[0]);
        CreateParams createParams = new CreateParams();
        createParams.setClientID(f230b);
        createParams.setFlags(CreateParams.getDefaultFlags());
        createParams.registerEventHandler(new C0024V(this.f238d));
        Core core = new Core(createParams);
        core.setLogHook(LogLevel.VERBOSE, (logLevel, str) -> {
        });
        return core;
    }

    /* JADX INFO: renamed from: t */
    private void m154t() {
        if (this.f237a != null) {
            return;
        }
        this.f237a = new Thread(() -> {
            while (true) {
                m159v();
            }
        }, "Discord Callback Thread");
        this.f237a.start();
    }

    public void shutdown() {
        C0562jt.log("Shutting down Discord manager...", new Object[0]);
        m155u();
        this.f234a = null;
    }

    /* JADX INFO: renamed from: u */
    private void m155u() {
        C0562jt.log("Closing Discord core...", new Object[0]);
        if (this.f234a != null) {
            try {
                this.f234a.close();
                C0562jt.log("Successfully closed Discord core.", new Object[0]);
            } catch (Exception e) {
                C0562jt.logError("Failed to close Discord core. (%s)", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m156c(@NotNull C0482iS c0482iS) {
        if (this.f234a == null) {
            int i = this.f236af;
            this.f236af = i - 1;
            if (i <= 0) {
                m152b(c0482iS);
                this.f236af = 1200;
                return;
            }
            return;
        }
        int i2 = this.f235ae;
        this.f235ae = i2 - 1;
        if (i2 <= 0) {
            this.f235ae = 100;
            m157d(c0482iS);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m157d(@NotNull C0482iS c0482iS) {
        ActivitySecrets activitySecretsSecrets;
        GameProfile gameProfile = Minecraft.getInstance().getGameProfile();
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f238d.m2688a();
        Activity activity = new Activity();
        activity.setDetails("BlockFront - v" + C0029a.f248c);
        activity.setState(I18n.get(f227y, new Object[0]));
        activity.setType(ActivityType.PLAYING);
        activity.timestamps().setStart(this.f232a);
        this.f233a.setLabel(I18n.get(f228z, new Object[0]));
        activity.setActivityButtonsMode(ActivityButtonsMode.BUTTONS);
        activity.addButton(this.f233a);
        m158a(activity.party(), abstractC0787oFM2688a);
        if (abstractC0787oFM2688a != null && (activitySecretsSecrets = activity.secrets()) != null) {
            activitySecretsSecrets.setJoinSecret(gameProfile.getId().toString());
        }
        ActivityAssets activityAssetsAssets = activity.assets();
        activityAssetsAssets.setLargeText(m151a(abstractC0787oFM2688a, c0482iS));
        activityAssetsAssets.setLargeImage(C0560jr.f3184aD);
        activityAssetsAssets.setSmallText(m150a(c0482iS, gameProfile));
        activityAssetsAssets.setSmallImage(m149a(gameProfile));
        if (this.f234a != null) {
            try {
                this.f234a.activityManager().updateActivity(activity);
            } catch (Exception e) {
                C0562jt.logError("Failed to update Discord rich presence. (%s)", e.getMessage());
                shutdown();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m158a(@NotNull ActivityParty activityParty, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (abstractC0787oF != null) {
            AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
            ActivityPartySize size = activityParty.size();
            size.setCurrentSize(abstractC0790oIM3582b.m3809h().size());
            size.setMaxSize(abstractC0790oIM3582b.m3784aX());
        }
    }

    /* JADX INFO: renamed from: v */
    private void m159v() {
        if (this.f234a == null) {
            return;
        }
        try {
            this.f234a.runCallbacks();
            Thread.sleep(16L);
        } catch (Exception e) {
            C0562jt.logError("Failed to run Discord callbacks. (%s)", e.getMessage());
            shutdown();
        }
    }
}
