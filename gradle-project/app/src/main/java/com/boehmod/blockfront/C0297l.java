package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
import com.boehmod.blockfront.A;
import com.boehmod.blockfront.B;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/l.class */
public final class C0297l extends AbstractC0264ju<fV, C0163g, C0459r> {

    @NotNull
    private final C0628xg a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final uB<uC> f207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private oF<?, ?, ?> f208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private oG<?, ?> f209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final iF f210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final hT f211a;
    private static final int o = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0405p f212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0333mi f213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final A.a f214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final B.a f215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0218ia f216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0432q f217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0083d f218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0243j f219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final W f220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0270k f221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final F f222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final fO f223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0412pg f224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Minecraft f225a;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    @NotNull
    private String f226n;
    private boolean w;
    private int p;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final iI f227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private PacketDailyReward f228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final ObjectArrayFIFOQueue<a> f229a;
    private static final Component k = Component.translatable("bf.message.okay");

    @NotNull
    private static final Component l = Component.translatable("bf.cloud.message.connection.established");

    @NotNull
    private static final Component m = Component.translatable("bf.cloud.message.connection.lost");

    @NotNull
    private static final Component n = Component.translatable("menu.savingLevel");

    /* JADX INFO: renamed from: com.boehmod.blockfront.l$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/l$a.class */
    public static final class a extends Record {

        @NotNull
        private final Component o;

        @NotNull
        private final Component p;

        @NotNull
        private final PopupType a;

        public a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType) {
            this.o = component;
            this.p = component2;
            this.a = popupType;
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
        public Component a() {
            return this.o;
        }

        @NotNull
        public Component b() {
            return this.p;
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public PopupType m605a() {
            return this.a;
        }
    }

    public C0297l(@NotNull Minecraft minecraft) {
        super(new fV());
        this.a = new C0628xg();
        this.f207a = new uB<>();
        this.f210a = new iF();
        this.f211a = new hT();
        this.f226n = "";
        this.w = false;
        this.p = 20;
        this.f229a = new ObjectArrayFIFOQueue<>();
        this.f225a = minecraft;
        c(String.valueOf(minecraft.gameDirectory) + "/blockfront/");
        File file = new File(m584d());
        if (!file.exists() && file.mkdirs()) {
            C0263jt.log("Could not find client directory. Creating...", new Object[0]);
        }
        this.f220a = new W(this, ((fV) a()).m404a(minecraft));
        this.f212a = new C0405p(C0002a.d);
        this.f216a = new C0218ia();
        this.f217a = new C0432q();
        this.f218a = new C0083d();
        this.f219a = new C0243j(this);
        this.f214a = new A.a(minecraft);
        this.f215a = new B.a(minecraft);
        this.f213a = new C0333mi(this);
        this.f221a = new C0270k();
        this.f222a = new F();
        this.f227a = new iI();
        this.f223a = fO.b();
        this.f224a = new C0412pg();
        C0253jj.ba();
        C0217i.b();
    }

    @Nullable
    public static C0297l b() {
        return C0056c.a();
    }

    public static void a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType, @NotNull C0042bm... c0042bmArr) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.setScreen(new C0043bn(minecraft.screen, component, component2, popupType, c0042bmArr));
    }

    public void b(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel) {
        boolean zIsLocalServer = minecraft.isLocalServer();
        clientLevel.disconnect();
        if (zIsLocalServer) {
            minecraft.disconnect(new GenericMessageScreen(n));
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
    public hT a() {
        return this.f211a;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull iS iSVar, @NotNull fT fTVar, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        wM.n(minecraft);
        ((C0163g) this.f187a).a(minecraft, iSVar, (fV) this.a);
        this.f217a.a((C0163g) this.f187a, iSVar);
        this.f219a.a(minecraft, clientLevel);
        this.f218a.a(minecraft, (C0163g) this.f187a);
        this.f212a.onUpdate();
        this.f213a.a(minecraft, localPlayer, clientLevel);
        this.f220a.c(iSVar);
        this.f221a.a(minecraft, clientLevel, localPlayer, this, (fV) this.a);
        this.f211a.c(this);
        this.f210a.a(minecraft, minecraft.font, minecraft.gameRenderer.itemInHandRenderer);
        if (clientLevel != null && localPlayer != null) {
            a(minecraft, clientLevel, localPlayer);
        }
        if (clientLevel == null && this.w) {
            a(fTVar);
            this.w = false;
        } else if (clientLevel != null && !this.w) {
            a(clientLevel);
            this.w = true;
        }
        if (this.f208a != null && localPlayer != null && clientLevel != null) {
            this.f224a.a(minecraft, this.f208a, clientLevel, localPlayer, vec3);
            Set<UUID> setH = this.f208a.b().h();
            if (this.f209a != null) {
                this.f209a.a(minecraft, random, clientLevel.random, localPlayer, clientLevel, this, fTVar, setH, f, vec3, blockPos);
            }
        }
        if (((C0163g) this.f187a).a().getStatus().isConnected() && ((C0459r) this.f186a).i()) {
            if (clientLevel != null && !minecraft.isLocalServer()) {
                b(minecraft, clientLevel);
            }
            ((C0163g) this.f187a).a().disconnect("Invalid Game State.", true);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer) {
        this.a.a((AbstractC0264ju<?, ?, ?>) this, clientLevel.entitiesForRendering(), clientLevel.getGameTime(), (LivingEntity) localPlayer);
        this.f223a.onUpdate();
        this.f222a.a(minecraft, this, localPlayer, clientLevel);
        this.f216a.b(minecraft, clientLevel, localPlayer);
        if (this.p > 0) {
            this.p--;
            if (this.p == 0) {
                C0263jt.log("Reloading chunks via the client manager...", new Object[0]);
                minecraft.levelRenderer.allChanged();
            }
        }
    }

    private void a(@NotNull ClientLevel clientLevel) {
        this.f222a.c(clientLevel);
    }

    private void a(@NotNull fT fTVar) {
        this.f222a.q();
        this.f213a.u(this.f225a);
        this.f223a.aE();
        this.f219a.a(this.f225a);
        a(this.f225a, fTVar, (fV) this.a, (ClientLevel) null);
        C0094dk.b((fV) this.a);
    }

    public void d() {
        this.p = 4;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0432q m582a() {
        return this.f217a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0083d m583a() {
        return this.f218a;
    }

    @NotNull
    public String c() {
        return this.f226n;
    }

    public void c(@NotNull String str) {
        this.f226n = str;
        if (!new File(this.f226n).mkdirs()) {
            C0263jt.log("Failed to create BlockFront directory! (Does it already exist?)", new Object[0]);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public String m584d() {
        return this.f226n + "client/";
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public A.a m585a() {
        return this.f214a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public B.a m586a() {
        return this.f215a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0218ia m587a() {
        return this.f216a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0405p m588a() {
        return this.f212a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public F m589a() {
        return this.f222a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fO m590a() {
        return this.f223a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0264ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0163g mo530a() {
        return new C0163g(C0002a.d, this);
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0628xg mo532a() {
        return this.a;
    }

    @NotNull
    public uC a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull uI uIVar) {
        return (uC) this.f207a.a(uIVar, uIVar2 -> {
            return new uC(minecraft, fVVar, uIVar2);
        });
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oF<?, ?, ?> m591a() {
        return this.f208a;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m592d() {
        LocalPlayer localPlayer;
        return (this.f208a == null || (localPlayer = Minecraft.getInstance().player) == null || !this.f208a.b().g(localPlayer.getUUID())) ? false : true;
    }

    public boolean e() {
        if (m592d()) {
            return true;
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return localPlayer != null && localPlayer.isSpectator() && this.f208a != null && this.f208a.bb();
    }

    public boolean a(@NotNull UUID uuid) {
        PlayerInfo playerInfo;
        if (this.f208a != null && this.f208a.b().g(uuid)) {
            return true;
        }
        ClientPacketListener connection = Minecraft.getInstance().getConnection();
        return (connection == null || (playerInfo = connection.getPlayerInfo(uuid)) == null || playerInfo.getGameMode() != GameType.SPECTATOR) ? false : true;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oG<?, ?> m593a() {
        return this.f209a;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable ClientLevel clientLevel, @Nullable oF<?, ?, ?> oFVar) {
        if (this.f208a == oFVar) {
            return;
        }
        if (this.f208a == null || oFVar == null || !this.f208a.m757e().equals(oFVar.m757e())) {
            if (this.f208a != null) {
                this.f208a.m767a().a(minecraft, RandomSource.create());
                this.f208a.stop();
            }
            if (this.f209a != null) {
                this.f209a.stop();
            }
            this.f224a.u(minecraft);
            this.f208a = oFVar;
            a(minecraft, fVVar, clientLevel);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable ClientLevel clientLevel) {
        if (minecraft.screen instanceof cU) {
            minecraft.setScreen((Screen) null);
        }
        if (this.f208a != null) {
            this.f209a = this.f208a.a(this);
            if (this.f208a.m750a() == oN.POST_GAME) {
                this.f209a.m774a().V(true);
            }
            iO iOVarA = ((C0163g) this.f187a).a();
            for (UUID uuid : this.f208a.b().h()) {
                iOVarA.b(RequestType.PLAYER_DATA, uuid);
                iOVarA.b(RequestType.INVENTORY_MINIMAL, uuid);
            }
            this.f208a.m767a().G(minecraft);
            if (clientLevel != null) {
                clientLevel.setDayTime(this.f208a.m767a().bj());
            }
        } else {
            this.f209a = null;
            m602a().u(minecraft);
        }
        C0038bi.j(minecraft);
        this.f222a.p();
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                minecraft.levelRenderer.allChanged();
                a(this.f208a);
            });
        } else {
            minecraft.levelRenderer.allChanged();
            a(this.f208a);
        }
        fT fTVarA = fVVar.a(minecraft);
        fTVarA.Z(false);
        fTVarA.X(false);
    }

    public void a(@Nullable oF<?, ?, ?> oFVar) {
        GameRenderer gameRenderer = this.f225a.gameRenderer;
        if (oFVar == null) {
            gameRenderer.shutdownEffect();
            return;
        }
        ResourceLocation resourceLocationM = oFVar.m767a().M();
        PostChain postChainCurrentEffect = gameRenderer.currentEffect();
        if (resourceLocationM == null) {
            if (postChainCurrentEffect != null) {
                gameRenderer.shutdownEffect();
            }
        } else if (postChainCurrentEffect == null || !postChainCurrentEffect.getName().equals(resourceLocationM.toString())) {
            gameRenderer.loadEffect(resourceLocationM);
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull fT fTVar, @NotNull fV fVVar, @Nullable ClientLevel clientLevel) {
        a(minecraft, fVVar, clientLevel, (oF<?, ?, ?>) null);
        fTVar.Z(false);
        fTVar.X(false);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0243j m594a() {
        return this.f219a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0412pg m595a() {
        return this.f224a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0270k m596a() {
        return this.f221a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Minecraft m597a() {
        return this.f225a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public iF m598a() {
        return this.f210a;
    }

    private void a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2) {
        SoundEvent soundEvent = null;
        Component component = null;
        if (connectionStatus2 == ConnectionStatus.CONNECTED_VERIFIED) {
            soundEvent = SoundEvents.BEACON_ACTIVATE;
            component = l;
        } else if (connectionStatus == ConnectionStatus.CONNECTED_VERIFIED) {
            soundEvent = SoundEvents.BEACON_DEACTIVATE;
            component = m;
        }
        if (soundEvent != null) {
            this.f225a.getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0f));
        }
        if (component != null) {
            C0119ej.a(Minecraft.getInstance(), (Component) Component.literal("BlockFront Cloud"), component, true);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public iI m599a() {
        return this.f227a;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public PacketDailyReward m600a() {
        return this.f228a;
    }

    public void a(@Nullable PacketDailyReward packetDailyReward) {
        this.f228a = packetDailyReward;
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public PacketDailyReward m601b() {
        PacketDailyReward packetDailyReward = this.f228a;
        this.f228a = null;
        return packetDailyReward;
    }

    public void a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType) {
        this.f229a.enqueue(new a(component, component2, popupType));
    }

    public void b(@NotNull Minecraft minecraft) {
        if (this.f229a.isEmpty()) {
            return;
        }
        Screen screen = minecraft.screen;
        if ((screen instanceof AbstractC0084da) || (screen instanceof C0043bn)) {
            return;
        }
        a aVar = (a) this.f229a.dequeue();
        a(aVar.a(), aVar.b(), aVar.m605a(), new C0042bm(k, null, button -> {
            minecraft.setScreen(screen);
        }));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0333mi m602a() {
        return this.f213a;
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected jO mo603a() {
        return new jO(this, true);
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    /* JADX INFO: renamed from: a */
    public C0459r mo528a() {
        return new C0459r(this);
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oF<?, ?, ?> mo604a(@NotNull UUID uuid) {
        return (this.f208a == null || !this.f208a.b().h().contains(uuid)) ? super.mo604a(uuid) : this.f208a;
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    public boolean f() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    public boolean g() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    public void a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        super.a(connectionStatus, connectionStatus2, connectionStatusContext);
        a(connectionStatus, connectionStatus2);
        iO iOVarA = ((C0163g) this.f187a).a();
        UUID uuidMo409a = ((C0163g) this.f187a).mo409a();
        if (connectionStatus2 == ConnectionStatus.CONNECTED_VERIFIED) {
            iOVarA.b(RequestType.PLAYER_INVENTORY, uuidMo409a);
            iOVarA.b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo409a);
            iOVarA.b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo409a);
            iOVarA.aY();
        }
        if (!connectionStatus2.isConnected()) {
            m596a().a(false);
        }
    }
}
