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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/a.class */
@Mod("bf")
public final class C0030a {

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final String f264b = "bf";

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final String f270d = "cloud.blockfrontmc.com";

    /* JADX INFO: renamed from: a */
    public static final int f271a = 1924;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final String f272e = "https://api.blockfrontmc.com";

    /* JADX INFO: renamed from: a */
    @NotNull
    private static C0030a f274a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0531jN<?, ?, ?> f275a;

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final String f265c = ModList.get().getModFileById("bf").versionString();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Component f266a = Component.literal(f265c);

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final EnumC0534jQ f267a = EnumC0534jQ.BETA;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final String f263a = "BlockFront";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Component f268b = Component.literal(f263a);

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Component f269c = f267a.getComponent();

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final String f273f = f263a.toLowerCase(Locale.ROOT) + "/";

    public C0030a(@NotNull IEventBus iEventBus) {
        f274a = this;
        C0530jM.log("Initializing BlockFront v" + f265c + " (" + String.valueOf(f267a) + ") for OS '" + Util.getPlatform().telemetryName() + "'.", new Object[0]);
        C0530jM.log("Class " + CloudItems.ITEM_GUN_BAR.getName() + " exists!", new Object[0]);
        C0530jM.log("Achievement " + CloudAchievements.ACH_STATS_HEADSHOT_10.getNameKey() + " exists!", new Object[0]);
        C0530jM.log("Registering universal events...", new Object[0]);
        NeoForge.EVENT_BUS.register(this);
        iEventBus.addListener(this::m176a);
        iEventBus.addListener(this::m177a);
        iEventBus.addListener(C0801oS::m3687a);
        iEventBus.addListener(C0789oG::m3675a);
        C0530jM.log("Registering data components...", new Object[0]);
        C1305xs.f7517e.register(iEventBus);
        C0530jM.log("Registering player data components...", new Object[0]);
        C1310xx.f7899h.register(iEventBus);
        C0530jM.log("Registering blocks...", new Object[0]);
        C1295xi.f6988b.register(iEventBus);
        C0530jM.log("Registering generated blocks...", new Object[0]);
        C1295xi.f6989c.register(iEventBus);
        C0530jM.log("Registering items...", new Object[0]);
        C1308xv.f7668a.register(iEventBus);
        C0530jM.log("Registering block entities...", new Object[0]);
        C1293xg.f6930a.register(iEventBus);
        C0530jM.log("Registering sounds...", new Object[0]);
        C1312xz.f7909i.register(iEventBus);
        C0530jM.log("Registering entity types...", new Object[0]);
        C1307xu.f7547f.register(iEventBus);
        C0530jM.log("Registering particles...", new Object[0]);
        C1309xw.f7851g.register(iEventBus);
        C0530jM.log("Registering creative tabs...", new Object[0]);
        C1303xq.f7496d.register(iEventBus);
        C0530jM.log("Migrating old objects...", new Object[0]);
        C1291xe.m7323dN();
        if (C0529jL.m2332ae()) {
            iEventBus.addListener(fMLClientSetupEvent -> {
                C0136c.m741a(this, fMLClientSetupEvent);
            });
            iEventBus.addListener(C0136c::m743a);
            iEventBus.addListener(C0136c::m742a);
            iEventBus.addListener(C0136c::m744a);
            iEventBus.addListener(C0136c::m745a);
        }
        if (C0529jL.m2333af()) {
            iEventBus.addListener(fMLDedicatedServerSetupEvent -> {
                C1275xO.m7247a(this, fMLDedicatedServerSetupEvent);
            });
        }
        C0530jM.log("Successfully initialized BlockFront v" + f265c + " (" + String.valueOf(f267a) + ")", new Object[0]);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0030a m175a() {
        return f274a;
    }

    /* JADX INFO: renamed from: a */
    private void m176a(@NotNull FMLCommonSetupEvent fMLCommonSetupEvent) {
        C0530jM.log("Entering common setup procedure...", new Object[0]);
        if (new File(f273f).mkdirs()) {
            C0530jM.log(String.format("Successfully created '%s' directory!", f273f), new Object[0]);
        } else {
            C0530jM.log(String.format("'%s' directory already exists!", f273f), new Object[0]);
        }
        C1302xp.m7879a(NeoForge.EVENT_BUS);
        C0530jM.log("Completed common setup procedure!", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private void m177a(@NotNull GatherDataEvent gatherDataEvent) {
        DataGenerator generator = gatherDataEvent.getGenerator();
        PackOutput packOutput = gatherDataEvent.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture lookupProvider = gatherDataEvent.getLookupProvider();
        boolean zIncludeClient = gatherDataEvent.includeClient();
        generator.addProvider(zIncludeClient, new C0727my(packOutput, existingFileHelper));
        generator.addProvider(zIncludeClient, new C0677mA(packOutput, existingFileHelper));
        generator.addProvider(gatherDataEvent.includeServer(), new C0728mz(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(zIncludeClient, new C0678mB(packOutput));
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public void m178a(@NotNull RegisterCommandsEvent registerCommandsEvent) {
        C0530jM.log("Registering commands...", new Object[0]);
        C1301xo.m7878b(registerCommandsEvent);
        C0530jM.log("Successfully registered commands!", new Object[0]);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0531jN<?, ?, ?> m179a() {
        return this.f275a;
    }

    /* JADX INFO: renamed from: a */
    public void m180a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        this.f275a = abstractC0531jN;
    }
}
