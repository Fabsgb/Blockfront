package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
import com.boehmod.blockfront.C0003A;
import com.boehmod.blockfront.C0004B;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.ObjectArrayFIFOQueue;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.GenericMessageScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.l */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/l.class */
public final class C0622l extends AbstractC0563ju<C0326fV, C0357g, C0940r> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1284xg f3356a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1102uB<C1103uC> f3357a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0787oF<?, ?, ?> f3360a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0788oG<?, ?> f3361a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0469iF f3362a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0430hT f3363a;

    /* JADX INFO: renamed from: o */
    private static final int f3364o = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0834p f3366a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0710mi f3367a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0003A.a f3368a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0004B.a f3369a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0490ia f3370a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0887q f3371a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0198d f3372a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0516j f3373a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0025W f3374a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0569k f3375a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0008F f3376a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0319fO f3377a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0867pg f3378a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Minecraft f3379a;

    /* JADX INFO: renamed from: n */
    @NotNull
    private String f3380n;

    /* JADX INFO: renamed from: w */
    private boolean f3381w;

    /* JADX INFO: renamed from: p */
    private int f3382p;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0472iI f3383a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private PacketDailyReward f3384a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectArrayFIFOQueue<a> f3385a;

    /* JADX INFO: renamed from: k */
    private static final Component f3355k = Component.translatable("bf.message.okay");

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final Component f3358l = Component.translatable("bf.cloud.message.connection.established");

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final Component f3359m = Component.translatable("bf.cloud.message.connection.lost");

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final Component f3365n = Component.translatable("menu.savingLevel");

    /* JADX INFO: renamed from: com.boehmod.blockfront.l$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/l$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: o */
        @NotNull
        private final Component f3386o;

        /* JADX INFO: renamed from: p */
        @NotNull
        private final Component f3387p;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final PopupType f3388a;

        public a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType) {
            this.f3386o = component;
            this.f3387p = component2;
            this.f3388a = popupType;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "title;message;type", "FIELD:Lcom/boehmod/blockfront/l$a;->o:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/l$a;->p:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/l$a;->a:Lcom/boehmod/bflib/cloud/common/PopupType;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "title;message;type", "FIELD:Lcom/boehmod/blockfront/l$a;->o:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/l$a;->p:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/l$a;->a:Lcom/boehmod/bflib/cloud/common/PopupType;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "title;message;type", "FIELD:Lcom/boehmod/blockfront/l$a;->o:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/l$a;->p:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/l$a;->a:Lcom/boehmod/bflib/cloud/common/PopupType;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public Component m2713a() {
            return this.f3386o;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public Component m2714b() {
            return this.f3387p;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public PopupType m2715a() {
            return this.f3388a;
        }
    }

    public C0622l(@NotNull Minecraft minecraft) {
        super(new C0326fV());
        this.f3356a = new C1284xg();
        this.f3357a = new C1102uB<>();
        this.f3362a = new C0469iF();
        this.f3363a = new C0430hT();
        this.f3380n = "";
        this.f3381w = false;
        this.f3382p = 20;
        this.f3385a = new ObjectArrayFIFOQueue<>();
        this.f3379a = minecraft;
        m2679c(String.valueOf(minecraft.gameDirectory) + "/blockfront/");
        File file = new File(m2680d());
        if (!file.exists() && file.mkdirs()) {
            C0562jt.log("Could not find client directory. Creating...", new Object[0]);
        }
        this.f3374a = new C0025W(this, ((C0326fV) m2670a()).m1676a(minecraft));
        this.f3366a = new C0834p(C0029a.f253d);
        this.f3370a = new C0490ia();
        this.f3371a = new C0887q();
        this.f3372a = new C0198d();
        this.f3373a = new C0516j(this);
        this.f3368a = new C0003A.a(minecraft);
        this.f3369a = new C0004B.a(minecraft);
        this.f3367a = new C0710mi(this);
        this.f3375a = new C0569k();
        this.f3376a = new C0008F();
        this.f3383a = new C0472iI();
        this.f3377a = C0319fO.m1628b();
        this.f3378a = new C0867pg();
        C0552jj.m2492ba();
        C0463i.m2071b();
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static C0622l m2667b() {
        return C0135c.m716a();
    }

    /* JADX INFO: renamed from: a */
    public static void m2668a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType, @NotNull C0121bm... c0121bmArr) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.setScreen(new C0122bn(minecraft.screen, component, component2, popupType, c0121bmArr));
    }

    /* JADX INFO: renamed from: b */
    public void m2669b(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel) {
        boolean zIsLocalServer = minecraft.isLocalServer();
        clientLevel.disconnect();
        if (zIsLocalServer) {
            minecraft.disconnect(new GenericMessageScreen(f3365n));
        } else {
            minecraft.disconnect();
        }
        TitleScreen titleScreen = new TitleScreen();
        if (zIsLocalServer) {
            minecraft.setScreen(titleScreen);
        } else {
            minecraft.setScreen(new JoinMultiplayerScreen(titleScreen));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0430hT m2670a() {
        return this.f3363a;
    }

    /* JADX INFO: renamed from: a */
    public void m2671a(@NotNull Minecraft minecraft, @NotNull Random random, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0482iS c0482iS, @NotNull C0324fT c0324fT, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        C1219wM.m7263n(minecraft);
        ((C0357g) this.f3196a).m1719a(minecraft, c0482iS, (C0326fV) this.f3188a);
        this.f3371a.m4456a((C0357g) this.f3196a, c0482iS);
        this.f3373a.m2270a(minecraft, clientLevel);
        this.f3372a.m1201a(minecraft, (C0357g) this.f3196a);
        this.f3366a.onUpdate();
        this.f3367a.m3229a(minecraft, localPlayer, clientLevel);
        this.f3374a.m156c(c0482iS);
        this.f3375a.m2583a(minecraft, clientLevel, localPlayer, this, (C0326fV) this.f3188a);
        this.f3363a.m2014c(this);
        this.f3362a.m2120a(minecraft, minecraft.font, minecraft.gameRenderer.itemInHandRenderer);
        if (clientLevel != null && localPlayer != null) {
            m2672a(minecraft, clientLevel, localPlayer);
        }
        if (clientLevel == null && this.f3381w) {
            m2674a(c0324fT);
            this.f3381w = false;
        } else if (clientLevel != null && !this.f3381w) {
            m2673a(clientLevel);
            this.f3381w = true;
        }
        if (this.f3360a != null && localPlayer != null && clientLevel != null) {
            this.f3378a.m4357a(minecraft, this.f3360a, clientLevel, localPlayer, vec3);
            Set<UUID> setM3809h = this.f3360a.m3582b().m3809h();
            if (this.f3361a != null) {
                this.f3361a.mo3682a(minecraft, random, clientLevel.random, localPlayer, clientLevel, this, c0324fT, setM3809h, f, vec3, blockPos);
            }
        }
        if (((C0357g) this.f3196a).m1716a().getStatus().isConnected() && ((C0940r) this.f3195a).m5133i()) {
            if (clientLevel != null && !minecraft.isLocalServer()) {
                m2669b(minecraft, clientLevel);
            }
            ((C0357g) this.f3196a).m1716a().disconnect("Invalid Game State.", true);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2672a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer) {
        this.f3356a.m7804a((AbstractC0563ju<?, ?, ?>) this, clientLevel.entitiesForRendering(), clientLevel.getGameTime(), (LivingEntity) localPlayer);
        this.f3377a.onUpdate();
        this.f3376a.m28a(minecraft, this, localPlayer, clientLevel);
        this.f3370a.m2232b(minecraft, clientLevel, localPlayer);
        if (this.f3382p > 0) {
            this.f3382p--;
            if (this.f3382p == 0) {
                C0562jt.log("Reloading chunks via the client manager...", new Object[0]);
                minecraft.levelRenderer.allChanged();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2673a(@NotNull ClientLevel clientLevel) {
        this.f3376a.m35c(clientLevel);
    }

    /* JADX INFO: renamed from: a */
    private void m2674a(@NotNull C0324fT c0324fT) {
        this.f3376a.m36q();
        this.f3367a.m3225u(this.f3379a);
        this.f3377a.m1633aE();
        this.f3373a.m2271a(this.f3379a);
        m2696a(this.f3379a, c0324fT, (C0326fV) this.f3188a, (ClientLevel) null);
        C0235dk.m1374b((C0326fV) this.f3188a);
    }

    /* JADX INFO: renamed from: d */
    public void m2675d() {
        this.f3382p = 4;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0887q m2676a() {
        return this.f3371a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0198d m2677a() {
        return this.f3372a;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public String m2678c() {
        return this.f3380n;
    }

    /* JADX INFO: renamed from: c */
    public void m2679c(@NotNull String str) {
        this.f3380n = str;
        if (!new File(this.f3380n).mkdirs()) {
            C0562jt.log("Failed to create BlockFront directory! (Does it already exist?)", new Object[0]);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public String m2680d() {
        return this.f3380n + "client/";
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0003A.a m2681a() {
        return this.f3368a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0004B.a m2682a() {
        return this.f3369a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0490ia m2683a() {
        return this.f3370a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0834p m2684a() {
        return this.f3366a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0008F m2685a() {
        return this.f3376a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0319fO m2686a() {
        return this.f3377a;
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0357g mo2521a() {
        return new C0357g(C0029a.f253d, this);
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1284xg mo2529a() {
        return this.f3356a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1103uC m2687a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C1109uI c1109uI) {
        return (C1103uC) this.f3357a.m6087a(c1109uI, c1109uI2 -> {
            return new C1103uC(minecraft, c0326fV, c1109uI2);
        });
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> m2688a() {
        return this.f3360a;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2689d() {
        LocalPlayer localPlayer;
        return (this.f3360a == null || (localPlayer = Minecraft.getInstance().player) == null || !this.f3360a.m3582b().m3811g(localPlayer.getUUID())) ? false : true;
    }

    /* JADX INFO: renamed from: e */
    public boolean m2690e() {
        if (m2689d()) {
            return true;
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return localPlayer != null && localPlayer.isSpectator() && this.f3360a != null && this.f3360a.mo3611bb();
    }

    /* JADX INFO: renamed from: a */
    public boolean m2691a(@NotNull UUID uuid) {
        PlayerInfo playerInfo;
        if (this.f3360a != null && this.f3360a.m3582b().m3811g(uuid)) {
            return true;
        }
        ClientPacketListener connection = Minecraft.getInstance().getConnection();
        return (connection == null || (playerInfo = connection.getPlayerInfo(uuid)) == null || playerInfo.getGameMode() != GameType.SPECTATOR) ? false : true;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0788oG<?, ?> m2692a() {
        return this.f3361a;
    }

    /* JADX INFO: renamed from: a */
    public void m2693a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable ClientLevel clientLevel, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (this.f3360a == abstractC0787oF) {
            return;
        }
        if (this.f3360a == null || abstractC0787oF == null || !this.f3360a.m3628e().equals(abstractC0787oF.m3628e())) {
            if (this.f3360a != null) {
                this.f3360a.m3653a().m5658a(minecraft, RandomSource.create());
                this.f3360a.stop();
            }
            if (this.f3361a != null) {
                this.f3361a.stop();
            }
            this.f3378a.m4355u(minecraft);
            this.f3360a = abstractC0787oF;
            m2694a(minecraft, c0326fV, clientLevel);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2694a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable ClientLevel clientLevel) {
        if (minecraft.screen instanceof AbstractC0156cU) {
            minecraft.setScreen((Screen) null);
        }
        if (this.f3360a != null) {
            this.f3361a = this.f3360a.mo3559a(this);
            if (this.f3360a.m3587a() == EnumC0795oN.POST_GAME) {
                this.f3361a.m3746a().m6015V(true);
            }
            C0478iO c0478iOA = ((C0357g) this.f3196a).m1716a();
            for (UUID uuid : this.f3360a.m3582b().m3809h()) {
                c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid);
                c0478iOA.m2165b(RequestType.INVENTORY_MINIMAL, uuid);
            }
            this.f3360a.m3653a().m5593G(minecraft);
            if (clientLevel != null) {
                clientLevel.setDayTime(this.f3360a.m3653a().m5621bj());
            }
        } else {
            this.f3361a = null;
            m2709a().m3225u(minecraft);
        }
        C0117bi.m362j(minecraft);
        this.f3376a.m33p();
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                minecraft.levelRenderer.allChanged();
                m2695a(this.f3360a);
            });
        } else {
            minecraft.levelRenderer.allChanged();
            m2695a(this.f3360a);
        }
        C0324fT c0324fTM1675a = c0326fV.m1675a(minecraft);
        c0324fTM1675a.m1094Z(false);
        c0324fTM1675a.m1088X(false);
    }

    /* JADX INFO: renamed from: a */
    public void m2695a(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        GameRenderer gameRenderer = this.f3379a.gameRenderer;
        if (abstractC0787oF == null) {
            gameRenderer.shutdownEffect();
            return;
        }
        ResourceLocation resourceLocationM5655M = abstractC0787oF.m3653a().m5655M();
        PostChain postChainCurrentEffect = gameRenderer.currentEffect();
        if (resourceLocationM5655M == null) {
            if (postChainCurrentEffect != null) {
                gameRenderer.shutdownEffect();
            }
        } else if (postChainCurrentEffect == null || !postChainCurrentEffect.getName().equals(resourceLocationM5655M.toString())) {
            gameRenderer.loadEffect(resourceLocationM5655M);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2696a(@NotNull Minecraft minecraft, @NotNull C0324fT c0324fT, @NotNull C0326fV c0326fV, @Nullable ClientLevel clientLevel) {
        m2693a(minecraft, c0326fV, clientLevel, (AbstractC0787oF<?, ?, ?>) null);
        c0324fT.m1094Z(false);
        c0324fT.m1088X(false);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0516j m2697a() {
        return this.f3373a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0867pg m2698a() {
        return this.f3378a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0569k m2699a() {
        return this.f3375a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Minecraft m2700a() {
        return this.f3379a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0469iF m2701a() {
        return this.f3362a;
    }

    /* JADX INFO: renamed from: a */
    private void m2702a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2) {
        SoundEvent soundEvent = null;
        Component component = null;
        if (connectionStatus2 == ConnectionStatus.CONNECTED_VERIFIED) {
            soundEvent = SoundEvents.BEACON_ACTIVATE;
            component = f3358l;
        } else if (connectionStatus == ConnectionStatus.CONNECTED_VERIFIED) {
            soundEvent = SoundEvents.BEACON_DEACTIVATE;
            component = f3359m;
        }
        if (soundEvent != null) {
            this.f3379a.getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0f));
        }
        if (component != null) {
            C0287ej.m1510a(Minecraft.getInstance(), (Component) Component.literal("BlockFront Cloud"), component, true);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0472iI m2703a() {
        return this.f3383a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public PacketDailyReward m2704a() {
        return this.f3384a;
    }

    /* JADX INFO: renamed from: a */
    public void m2705a(@Nullable PacketDailyReward packetDailyReward) {
        this.f3384a = packetDailyReward;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public PacketDailyReward m2706b() {
        PacketDailyReward packetDailyReward = this.f3384a;
        this.f3384a = null;
        return packetDailyReward;
    }

    /* JADX INFO: renamed from: a */
    public void m2707a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType) {
        this.f3385a.enqueue(new a(component, component2, popupType));
    }

    /* JADX INFO: renamed from: b */
    public void m2708b(@NotNull Minecraft minecraft) {
        if (this.f3385a.isEmpty()) {
            return;
        }
        Screen screen = minecraft.screen;
        if ((screen instanceof AbstractC0225da) || (screen instanceof C0122bn)) {
            return;
        }
        a aVar = (a) this.f3385a.dequeue();
        m2668a(aVar.m2713a(), aVar.m2714b(), aVar.m2715a(), new C0121bm(f3355k, null, button -> {
            minecraft.setScreen(screen);
        }));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0710mi m2709a() {
        return this.f3367a;
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0531jO mo2517a() {
        return new C0531jO(this, true);
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: a */
    public C0940r mo2518a() {
        return new C0940r(this);
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> mo2531a(@NotNull UUID uuid) {
        return (this.f3360a == null || !this.f3360a.m3582b().m3809h().contains(uuid)) ? super.mo2531a(uuid) : this.f3360a;
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: f */
    public boolean mo2551f() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: g */
    public boolean mo2552g() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: a */
    public void mo2553a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        super.mo2553a(connectionStatus, connectionStatus2, connectionStatusContext);
        m2702a(connectionStatus, connectionStatus2);
        C0478iO c0478iOA = ((C0357g) this.f3196a).m1716a();
        UUID uuidMo1723a = ((C0357g) this.f3196a).mo1723a();
        if (connectionStatus2 == ConnectionStatus.CONNECTED_VERIFIED) {
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY, uuidMo1723a);
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo1723a);
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo1723a);
            c0478iOA.m2169aY();
        }
        if (!connectionStatus2.isConnected()) {
            m2699a().m2598a(false);
        }
    }
}
