package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItems;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.a */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/a.class */
@Mod("bf")
public final class C0029a {

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final String f247b = "bf";

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final String f253d = "cloud.blockfrontmc.com";

    /* JADX INFO: renamed from: a */
    public static final int f254a = 1924;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static C0029a f256a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0563ju<?, ?, ?> f257a;

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final String f248c = ModList.get().getModFileById("bf").versionString();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Component f249a = Component.literal(f248c);

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final EnumC0566jx f250a = EnumC0566jx.BETA;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final String f246a = "BlockFront";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Component f251b = Component.literal(f246a);

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Component f252c = f250a.getComponent();

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final String f255e = f246a.toLowerCase(Locale.ROOT) + "/";

    public C0029a(@NotNull IEventBus iEventBus) {
        f256a = this;
        C0562jt.log("Initializing BlockFront v" + f248c + " (" + String.valueOf(f250a) + ") for OS '" + Util.getPlatform().telemetryName() + "'.", new Object[0]);
        C0562jt.log("Class " + CloudItems.ITEM_GUN_BAR.getName() + " exists!", new Object[0]);
        C0562jt.log("Achievement " + CloudAchievements.ACH_STATS_HEADSHOT_10.getNameKey() + " exists!", new Object[0]);
        C0562jt.log("Registering universal events...", new Object[0]);
        NeoForge.EVENT_BUS.register(this);
        iEventBus.addListener(this::m165a);
        iEventBus.addListener(this::m166a);
        iEventBus.addListener(C0830ow::m4199a);
        iEventBus.addListener(C0818ok::m4187a);
        C0562jt.log("Registering data components...", new Object[0]);
        C1228wV.f6954e.register(iEventBus);
        C0562jt.log("Registering player data components...", new Object[0]);
        C1278xa.f7487h.register(iEventBus);
        C0562jt.log("Registering blocks...", new Object[0]);
        C1218wL.f6425b.register(iEventBus);
        C0562jt.log("Registering generated blocks...", new Object[0]);
        C1218wL.f6426c.register(iEventBus);
        C0562jt.log("Registering items...", new Object[0]);
        C1231wY.f7103a.register(iEventBus);
        C0562jt.log("Registering block entities...", new Object[0]);
        C1216wJ.f6367a.register(iEventBus);
        C0562jt.log("Registering sounds...", new Object[0]);
        C1280xc.f7497i.register(iEventBus);
        C0562jt.log("Registering entity types...", new Object[0]);
        C1230wX.f6982f.register(iEventBus);
        C0562jt.log("Registering particles...", new Object[0]);
        C1232wZ.f7286g.register(iEventBus);
        C0562jt.log("Registering creative tabs...", new Object[0]);
        C1226wT.f6933d.register(iEventBus);
        C0562jt.log("Migrating old objects...", new Object[0]);
        C1214wH.m6735dD();
        if (C0561js.m2512ab()) {
            iEventBus.addListener(fMLClientSetupEvent -> {
                C0135c.m717a(this, fMLClientSetupEvent);
            });
            iEventBus.addListener(C0135c::m719a);
            iEventBus.addListener(C0135c::m718a);
            iEventBus.addListener(C0135c::m720a);
            iEventBus.addListener(C0135c::m721a);
        }
        if (C0561js.m2513ac()) {
            iEventBus.addListener(fMLDedicatedServerSetupEvent -> {
                C1295xr.m7920a(this, fMLDedicatedServerSetupEvent);
            });
        }
        C0562jt.log("Successfully initialized BlockFront v" + f248c + " (" + String.valueOf(f250a) + ")", new Object[0]);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0029a m164a() {
        return f256a;
    }

    /* JADX INFO: renamed from: a */
    private void m165a(@NotNull FMLCommonSetupEvent fMLCommonSetupEvent) {
        C0562jt.log("Entering common setup procedure...", new Object[0]);
        if (new File(f255e).mkdirs()) {
            C0562jt.log(String.format("Successfully created '%s' directory!", f255e), new Object[0]);
        } else {
            C0562jt.log(String.format("'%s' directory already exists!", f255e), new Object[0]);
        }
        C1225wS.m7290a(NeoForge.EVENT_BUS);
        C0562jt.log("Completed common setup procedure!", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private void m166a(@NotNull GatherDataEvent gatherDataEvent) {
        DataGenerator generator = gatherDataEvent.getGenerator();
        PackOutput packOutput = gatherDataEvent.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture lookupProvider = gatherDataEvent.getLookupProvider();
        boolean zIncludeClient = gatherDataEvent.includeClient();
        generator.addProvider(zIncludeClient, new C0704mc(packOutput, existingFileHelper));
        generator.addProvider(zIncludeClient, new C0706me(packOutput, existingFileHelper));
        generator.addProvider(gatherDataEvent.includeServer(), new C0705md(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(zIncludeClient, new C0707mf(packOutput));
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public void m167a(@NotNull RegisterCommandsEvent registerCommandsEvent) {
        C0562jt.log("Registering commands...", new Object[0]);
        C1224wR.m7289b(registerCommandsEvent);
        C0562jt.log("Successfully registered commands!", new Object[0]);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0563ju<?, ?, ?> m168a() {
        return this.f257a;
    }

    /* JADX INFO: renamed from: a */
    public void m169a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        this.f257a = abstractC0563ju;
    }
}
