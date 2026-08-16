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

/* JADX INFO: renamed from: com.boehmod.blockfront.ac */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ac.class */
public class C0059ac {

    /* JADX INFO: renamed from: D */
    @NotNull
    private static final String f411D = "bf.discord.rpc.state";

    /* JADX INFO: renamed from: E */
    @NotNull
    private static final String f412E = "bf.discord.rpc.button.join";

    /* JADX INFO: renamed from: aQ */
    private static final int f413aQ = 100;

    /* JADX INFO: renamed from: f */
    private static final long f414f = 664231140651040768L;

    /* JADX INFO: renamed from: aR */
    public static final int f415aR = 1200;

    /* JADX INFO: renamed from: a */
    private Core f418a;

    /* JADX INFO: renamed from: a */
    private Thread f421a;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0623l f422e;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Instant f416a = Instant.now();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ActivityButton f417a = new ActivityButton(I18n.get(f412E, new Object[0]), C0528jK.f3163aF);

    /* JADX INFO: renamed from: aS */
    private int f419aS = 0;

    /* JADX INFO: renamed from: aT */
    private int f420aT = 0;

    public C0059ac(@NotNull C0623l c0623l, @NotNull C0555jl c0555jl) {
        this.f422e = c0623l;
        m266b(c0555jl);
    }

    /* JADX INFO: renamed from: a */
    private static String m263a(@NotNull GameProfile gameProfile) {
        return String.format(C0528jK.f3162aE, gameProfile.getId().toString());
    }

    /* JADX INFO: renamed from: a */
    private static String m264a(@NotNull C0555jl c0555jl, @NotNull GameProfile gameProfile) {
        return c0555jl.getRank().getTitle() + " " + gameProfile.getName();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m265a(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0555jl c0555jl) {
        C1094tt c1094ttM6019a;
        String string = Component.translatable(c0555jl.getStatus().getOnlineStatus().toString()).getString();
        if (abstractC0863pb != null && (c1094ttM6019a = C1094tt.m6019a(abstractC0863pb.m4030T())) != null) {
            string = Component.translatable("bf.discord.rpc.status.playing", new Object[]{c1094ttM6019a.getDisplayName().getString(), abstractC0863pb.m4027a().getName()}).getString();
        }
        return string;
    }

    /* JADX INFO: renamed from: b */
    private void m266b(@NotNull C0555jl c0555jl) {
        C0530jM.log("Attempting to initialize Discord manager...", new Object[0]);
        try {
            this.f418a = m267a();
            m271d(c0555jl);
            m268w();
            C0530jM.log("Successfully initialized Discord manager.", new Object[0]);
        } catch (Exception e) {
            C0530jM.logError("Failed to initialize Discord manager. (%s)", e.getMessage());
            this.f418a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private Core m267a() {
        C0530jM.log("Attempting to create Discord Game API core...", new Object[0]);
        CreateParams createParams = new CreateParams();
        createParams.setClientID(f414f);
        createParams.setFlags(CreateParams.getDefaultFlags());
        createParams.registerEventHandler(new C0058ab(this.f422e));
        Core core = new Core(createParams);
        core.setLogHook(LogLevel.VERBOSE, (logLevel, str) -> {
        });
        return core;
    }

    /* JADX INFO: renamed from: w */
    private void m268w() {
        if (this.f421a != null) {
            return;
        }
        this.f421a = new Thread(() -> {
            while (true) {
                m273y();
            }
        }, "Discord Callback Thread");
        this.f421a.start();
    }

    public void shutdown() {
        C0530jM.log("Shutting down Discord manager...", new Object[0]);
        m269x();
        this.f418a = null;
    }

    /* JADX INFO: renamed from: x */
    private void m269x() {
        C0530jM.log("Closing Discord core...", new Object[0]);
        if (this.f418a != null) {
            try {
                this.f418a.close();
                C0530jM.log("Successfully closed Discord core.", new Object[0]);
            } catch (Exception e) {
                C0530jM.logError("Failed to close Discord core. (%s)", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m270c(@NotNull C0555jl c0555jl) {
        if (this.f418a == null) {
            int i = this.f420aT;
            this.f420aT = i - 1;
            if (i <= 0) {
                m266b(c0555jl);
                this.f420aT = 1200;
                return;
            }
            return;
        }
        int i2 = this.f419aS;
        this.f419aS = i2 - 1;
        if (i2 <= 0) {
            this.f419aS = 100;
            m271d(c0555jl);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m271d(@NotNull C0555jl c0555jl) {
        ActivitySecrets activitySecretsSecrets;
        GameProfile gameProfile = Minecraft.getInstance().getGameProfile();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f422e.m2874a();
        Activity activity = new Activity();
        activity.setDetails("BlockFront - v" + C0030a.f265c);
        activity.setState(I18n.get(f411D, new Object[0]));
        activity.setType(ActivityType.PLAYING);
        activity.timestamps().setStart(this.f416a);
        this.f417a.setLabel(I18n.get(f412E, new Object[0]));
        activity.setActivityButtonsMode(ActivityButtonsMode.BUTTONS);
        activity.addButton(this.f417a);
        m272a(activity.party(), abstractC0863pbM2874a);
        if (abstractC0863pbM2874a != null && (activitySecretsSecrets = activity.secrets()) != null) {
            activitySecretsSecrets.setJoinSecret(gameProfile.getId().toString());
        }
        ActivityAssets activityAssetsAssets = activity.assets();
        activityAssetsAssets.setLargeText(m265a(abstractC0863pbM2874a, c0555jl));
        activityAssetsAssets.setLargeImage(C0528jK.f3167aJ);
        activityAssetsAssets.setSmallText(m264a(c0555jl, gameProfile));
        activityAssetsAssets.setSmallImage(m263a(gameProfile));
        if (this.f418a != null) {
            try {
                this.f418a.activityManager().updateActivity(activity);
            } catch (Exception e) {
                C0530jM.logError("Failed to update Discord rich presence. (%s)", e.getMessage());
                shutdown();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m272a(@NotNull ActivityParty activityParty, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (abstractC0863pb != null) {
            AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
            ActivityPartySize size = activityParty.size();
            size.setCurrentSize(abstractC0866peM4018b.m4245h().size());
            size.setMaxSize(abstractC0866peM4018b.m4220bm());
        }
    }

    /* JADX INFO: renamed from: y */
    private void m273y() {
        if (this.f418a == null) {
            return;
        }
        try {
            this.f418a.runCallbacks();
            Thread.sleep(16L);
        } catch (Exception e) {
            C0530jM.logError("Failed to run Discord callbacks. (%s)", e.getMessage());
            shutdown();
        }
    }
}
