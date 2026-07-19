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

/* JADX INFO: renamed from: com.boehmod.blockfront.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/a.class */
@Mod("bf")
public final class C0002a {

    @NotNull
    public static final String b = "bf";

    @NotNull
    public static final String d = "cloud.blockfrontmc.com";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f32a = 1924;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static C0002a f33a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private AbstractC0264ju<?, ?, ?> f34a;

    @NotNull
    public static final String c = ModList.get().getModFileById("bf").versionString();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Component f28a = Component.literal(c);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final EnumC0267jx f29a = EnumC0267jx.BETA;

    @NotNull
    public static final String a = "BlockFront";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    public static final Component f30b = Component.literal(a);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    public static final Component f31c = f29a.getComponent();

    @NotNull
    public static final String e = a.toLowerCase(Locale.ROOT) + "/";

    public C0002a(@NotNull IEventBus iEventBus) {
        f33a = this;
        C0263jt.log("Initializing BlockFront v" + c + " (" + String.valueOf(f29a) + ") for OS '" + Util.getPlatform().telemetryName() + "'.", new Object[0]);
        C0263jt.log("Class " + CloudItems.ITEM_GUN_BAR.getName() + " exists!", new Object[0]);
        C0263jt.log("Achievement " + CloudAchievements.ACH_STATS_HEADSHOT_10.getNameKey() + " exists!", new Object[0]);
        C0263jt.log("Registering universal events...", new Object[0]);
        NeoForge.EVENT_BUS.register(this);
        iEventBus.addListener(this::a);
        iEventBus.addListener(this::a);
        iEventBus.addListener(C0401ow::a);
        iEventBus.addListener(C0389ok::a);
        C0263jt.log("Registering data components...", new Object[0]);
        wV.e.register(iEventBus);
        C0263jt.log("Registering player data components...", new Object[0]);
        C0622xa.h.register(iEventBus);
        C0263jt.log("Registering blocks...", new Object[0]);
        wL.b.register(iEventBus);
        C0263jt.log("Registering generated blocks...", new Object[0]);
        wL.c.register(iEventBus);
        C0263jt.log("Registering items...", new Object[0]);
        wY.a.register(iEventBus);
        C0263jt.log("Registering block entities...", new Object[0]);
        wJ.a.register(iEventBus);
        C0263jt.log("Registering sounds...", new Object[0]);
        C0624xc.i.register(iEventBus);
        C0263jt.log("Registering entity types...", new Object[0]);
        wX.f.register(iEventBus);
        C0263jt.log("Registering particles...", new Object[0]);
        wZ.g.register(iEventBus);
        C0263jt.log("Registering creative tabs...", new Object[0]);
        wT.d.register(iEventBus);
        C0263jt.log("Migrating old objects...", new Object[0]);
        wH.dD();
        if (C0262js.ab()) {
            iEventBus.addListener(fMLClientSetupEvent -> {
                C0056c.a(this, fMLClientSetupEvent);
            });
            iEventBus.addListener(C0056c::a);
            iEventBus.addListener(C0056c::a);
            iEventBus.addListener(C0056c::a);
            iEventBus.addListener(C0056c::a);
        }
        if (C0262js.ac()) {
            iEventBus.addListener(fMLDedicatedServerSetupEvent -> {
                C0639xr.a(this, fMLDedicatedServerSetupEvent);
            });
        }
        C0263jt.log("Successfully initialized BlockFront v" + c + " (" + String.valueOf(f29a) + ")", new Object[0]);
    }

    @NotNull
    public static C0002a a() {
        return f33a;
    }

    private void a(@NotNull FMLCommonSetupEvent fMLCommonSetupEvent) {
        C0263jt.log("Entering common setup procedure...", new Object[0]);
        if (new File(e).mkdirs()) {
            C0263jt.log(String.format("Successfully created '%s' directory!", e), new Object[0]);
        } else {
            C0263jt.log(String.format("'%s' directory already exists!", e), new Object[0]);
        }
        wS.a(NeoForge.EVENT_BUS);
        C0263jt.log("Completed common setup procedure!", new Object[0]);
    }

    private void a(@NotNull GatherDataEvent gatherDataEvent) {
        DataGenerator generator = gatherDataEvent.getGenerator();
        PackOutput packOutput = gatherDataEvent.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture lookupProvider = gatherDataEvent.getLookupProvider();
        boolean zIncludeClient = gatherDataEvent.includeClient();
        generator.addProvider(zIncludeClient, new C0327mc(packOutput, existingFileHelper));
        generator.addProvider(zIncludeClient, new C0329me(packOutput, existingFileHelper));
        generator.addProvider(gatherDataEvent.includeServer(), new C0328md(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(zIncludeClient, new C0330mf(packOutput));
    }

    @SubscribeEvent
    public void a(@NotNull RegisterCommandsEvent registerCommandsEvent) {
        C0263jt.log("Registering commands...", new Object[0]);
        wR.b(registerCommandsEvent);
        C0263jt.log("Successfully registered commands!", new Object[0]);
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public AbstractC0264ju<?, ?, ?> m166a() {
        return this.f34a;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        this.f34a = abstractC0264ju;
    }
}
