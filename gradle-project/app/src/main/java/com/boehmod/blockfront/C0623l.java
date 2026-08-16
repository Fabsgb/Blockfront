package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/l.class */
public final class C0623l extends AbstractC0531jN<C0396gl, C0358g, C0994s> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1264xD f3556a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1182vb<C1183vc> f3557a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0863pb<?, ?, ?> f3560a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0864pc<?, ?> f3561a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0489iY f3562a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0501ik f3563a;

    /* JADX INFO: renamed from: q */
    private static final int f3564q = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0835p f3566a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0681mE f3567a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0010G.a f3568a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0011H.a f3569a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0508ir f3570a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0888q f3571a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0199d f3572a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0276eX f3573a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0517j f3574a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0059ac f3575a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0570k f3576a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0015L f3577a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0389ge f3578a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0838pC f3579a;

    @NotNull
    private final Minecraft minecraft;

    /* JADX INFO: renamed from: o */
    @NotNull
    private String f3580o;

    /* JADX INFO: renamed from: x */
    private boolean f3581x;

    /* JADX INFO: renamed from: r */
    private int f3582r;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0545jb f3583a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private PacketDailyReward f3584a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectArrayFIFOQueue<a> f3585a;

    /* JADX INFO: renamed from: k */
    private static final Component f3555k = Component.translatable("bf.message.okay");

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final Component f3558l = Component.translatable("bf.cloud.message.connection.established");

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final Component f3559m = Component.translatable("bf.cloud.message.connection.lost");

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final Component f3565n = Component.translatable("menu.savingLevel");

    /* JADX INFO: renamed from: com.boehmod.blockfront.l$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/l$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: o */
        @NotNull
        private final Component f3586o;

        /* JADX INFO: renamed from: p */
        @NotNull
        private final Component f3587p;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final PopupType f3588a;

        public a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType) {
            this.f3586o = component;
            this.f3587p = component2;
            this.f3588a = popupType;
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
        public Component m2899a() {
            return this.f3586o;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public Component m2900b() {
            return this.f3587p;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public PopupType m2901a() {
            return this.f3588a;
        }
    }

    public C0623l(@NotNull Minecraft minecraft) {
        super(new C0396gl());
        this.f3556a = new C1264xD();
        this.f3557a = new C1182vb<>();
        this.f3562a = new C0489iY();
        this.f3563a = new C0501ik();
        this.f3580o = "";
        this.f3581x = false;
        this.f3582r = 20;
        this.f3585a = new ObjectArrayFIFOQueue<>();
        this.minecraft = minecraft;
        m2865c(String.valueOf(minecraft.gameDirectory) + "/blockfront/");
        File file = new File(m2866d());
        if (!file.exists() && file.mkdirs()) {
            C0530jM.log("Could not find client directory. Creating...", new Object[0]);
        }
        this.f3575a = new C0059ac(this, ((C0396gl) m2855a()).m1886a(minecraft));
        this.f3566a = new C0835p(C0030a.f270d);
        this.f3570a = new C0508ir();
        this.f3571a = new C0888q();
        this.f3572a = new C0199d();
        this.f3573a = new C0276eX(this);
        this.f3574a = new C0517j(this);
        this.f3568a = new C0010G.a(minecraft);
        this.f3569a = new C0011H.a(minecraft);
        this.f3567a = new C0681mE(this);
        this.f3576a = new C0570k();
        this.f3577a = new C0015L();
        this.f3583a = new C0545jb();
        this.f3578a = C0389ge.m1838b();
        this.f3579a = new C0838pC();
        C0520jC.m2312bm();
        C0464i.m2097b();
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static C0623l m2852b() {
        return C0136c.m740a();
    }

    /* JADX INFO: renamed from: a */
    public static void m2853a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType, @NotNull C0131bv... c0131bvArr) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.setScreen(new C0132bw(minecraft.screen, component, component2, popupType, c0131bvArr));
    }

    /* JADX INFO: renamed from: b */
    public void m2854b(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel) {
        boolean zIsLocalServer = minecraft.isLocalServer();
        clientLevel.disconnect();
        if (zIsLocalServer) {
            minecraft.disconnect(new GenericMessageScreen(f3565n));
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
    public C0501ik m2855a() {
        return this.f3563a;
    }

    /* JADX INFO: renamed from: a */
    public void m2856a(@NotNull Minecraft minecraft, @NotNull Random random, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0555jl c0555jl, @NotNull C0394gj c0394gj, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        C1296xj.m7851o(minecraft);
        ((C0358g) this.f3179a).m1725a(minecraft, c0555jl, (C0396gl) this.f3171a);
        this.f3571a.m4639a((C0358g) this.f3179a, c0555jl);
        this.f3574a.m2295a(minecraft, clientLevel);
        this.f3572a.m1233a(minecraft, (C0358g) this.f3179a);
        this.f3566a.onUpdate();
        this.f3567a.m3060a(minecraft, localPlayer, clientLevel);
        this.f3575a.m270c(c0555jl);
        this.f3576a.m2572a(minecraft, clientLevel, localPlayer, this, (C0396gl) this.f3171a);
        this.f3563a.m2248c(this);
        this.f3562a.m2212a(minecraft, minecraft.font, minecraft.gameRenderer.itemInHandRenderer);
        if (clientLevel != null && localPlayer != null) {
            m2857a(minecraft, clientLevel, localPlayer);
        }
        if (clientLevel == null && this.f3581x) {
            m2859a(c0394gj);
            this.f3581x = false;
        } else if (clientLevel != null && !this.f3581x) {
            m2858a(clientLevel);
            this.f3581x = true;
        }
        if (this.f3560a != null && localPlayer != null && clientLevel != null) {
            this.f3579a.m3842a(minecraft, this.f3560a, clientLevel, localPlayer, vec3);
            Set<UUID> setM4245h = this.f3560a.m4018b().m4245h();
            if (this.f3561a != null) {
                this.f3561a.mo4118a(minecraft, random, clientLevel.random, localPlayer, clientLevel, this, c0394gj, setM4245h, f, vec3, blockPos);
            }
        }
        if (((C0358g) this.f3179a).m1722a().getStatus().isConnected() && ((C0994s) this.f3178a).m5570i()) {
            if (clientLevel != null && !minecraft.isLocalServer()) {
                m2854b(minecraft, clientLevel);
            }
            ((C0358g) this.f3179a).m1722a().disconnect("Invalid Game State.", true);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2857a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer) {
        this.f3556a.m7126a((AbstractC0531jN<?, ?, ?>) this, clientLevel.entitiesForRendering(), clientLevel.getGameTime(), (LivingEntity) localPlayer);
        this.f3578a.onUpdate();
        this.f3577a.m60a(minecraft, this, localPlayer, clientLevel);
        this.f3570a.m2287b(minecraft, clientLevel, localPlayer);
        if (this.f3582r > 0) {
            this.f3582r--;
            if (this.f3582r == 0) {
                C0530jM.log("Reloading chunks via the client manager...", new Object[0]);
                minecraft.levelRenderer.allChanged();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2858a(@NotNull ClientLevel clientLevel) {
        this.f3577a.m67c(clientLevel);
    }

    /* JADX INFO: renamed from: a */
    private void m2859a(@NotNull C0394gj c0394gj) {
        this.f3577a.m68t();
        this.f3567a.m3056w(this.minecraft);
        this.f3578a.m1843aK();
        this.f3574a.m2296a(this.minecraft);
        m2882a(this.minecraft, c0394gj, (C0396gl) this.f3171a, (ClientLevel) null);
        C0245dt.m1401b((C0396gl) this.f3171a);
    }

    /* JADX INFO: renamed from: d */
    public void m2860d() {
        this.f3582r = 4;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0888q m2861a() {
        return this.f3571a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0199d m2862a() {
        return this.f3572a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0276eX m2863a() {
        return this.f3573a;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public String m2864c() {
        return this.f3580o;
    }

    /* JADX INFO: renamed from: c */
    public void m2865c(@NotNull String str) {
        this.f3580o = str;
        if (!new File(this.f3580o).mkdirs()) {
            C0530jM.log("Failed to create BlockFront directory! (Does it already exist?)", new Object[0]);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public String m2866d() {
        return this.f3580o + "client/";
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0010G.a m2867a() {
        return this.f3568a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0011H.a m2868a() {
        return this.f3569a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0508ir m2869a() {
        return this.f3570a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0835p m2870a() {
        return this.f3566a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0015L m2871a() {
        return this.f3577a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0389ge m2872a() {
        return this.f3578a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0531jN
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0358g mo2344a() {
        return new C0358g(C0030a.f270d, this);
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1264xD mo2352a() {
        return this.f3556a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1183vc m2873a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C1189vi c1189vi) {
        return (C1183vc) this.f3557a.m6739a(c1189vi, c1189vi2 -> {
            return new C1183vc(minecraft, c0396gl, c1189vi2);
        });
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> m2874a() {
        return this.f3560a;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2875d() {
        LocalPlayer localPlayer;
        return (this.f3560a == null || (localPlayer = Minecraft.getInstance().player) == null || !this.f3560a.m4018b().m4247g(localPlayer.getUUID())) ? false : true;
    }

    /* JADX INFO: renamed from: e */
    public boolean m2876e() {
        if (m2875d()) {
            return true;
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return localPlayer != null && localPlayer.isSpectator() && this.f3560a != null && this.f3560a.mo4047bl();
    }

    /* JADX INFO: renamed from: a */
    public boolean m2877a(@NotNull UUID uuid) {
        PlayerInfo playerInfo;
        if (this.f3560a != null && this.f3560a.m4018b().m4247g(uuid)) {
            return true;
        }
        ClientPacketListener connection = Minecraft.getInstance().getConnection();
        return (connection == null || (playerInfo = connection.getPlayerInfo(uuid)) == null || playerInfo.getGameMode() != GameType.SPECTATOR) ? false : true;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0864pc<?, ?> m2878a() {
        return this.f3561a;
    }

    /* JADX INFO: renamed from: a */
    public void m2879a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable ClientLevel clientLevel, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (this.f3560a == abstractC0863pb) {
            return;
        }
        if (this.f3560a == null || abstractC0863pb == null || !this.f3560a.m4064e().equals(abstractC0863pb.m4064e())) {
            if (this.f3560a != null) {
                this.f3560a.m4089a().m6146a(minecraft, RandomSource.create());
                this.f3560a.stop();
            }
            if (this.f3561a != null) {
                this.f3561a.stop();
            }
            this.f3579a.m3840w(minecraft);
            this.f3560a = abstractC0863pb;
            m2880a(minecraft, c0396gl, clientLevel);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2880a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable ClientLevel clientLevel) {
        if (minecraft.screen instanceof AbstractC0229dd) {
            minecraft.setScreen((Screen) null);
        }
        if (this.f3560a != null) {
            this.f3561a = this.f3560a.mo3995a(this);
            if (this.f3560a.m4023a() == EnumC0871pj.POST_GAME) {
                this.f3561a.m4182a().m5901W(true);
            }
            C0551jh c0551jhA = ((C0358g) this.f3179a).m1722a();
            for (UUID uuid : this.f3560a.m4018b().m4245h()) {
                c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid);
                c0551jhA.m2492b(RequestType.INVENTORY_MINIMAL, uuid);
            }
            this.f3560a.m4089a().m6081I(minecraft);
            if (clientLevel != null) {
                clientLevel.setDayTime(this.f3560a.m4089a().m6109by());
            }
        } else {
            this.f3561a = null;
            m2895a().m3056w(minecraft);
        }
        C0127br.m462k(minecraft);
        this.f3577a.m65s();
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                minecraft.levelRenderer.allChanged();
                m2881a(this.f3560a);
            });
        } else {
            minecraft.levelRenderer.allChanged();
            m2881a(this.f3560a);
        }
        C0394gj c0394gjM1885a = c0396gl.m1885a(minecraft);
        c0394gjM1885a.m1111aa(false);
        c0394gjM1885a.m1105Y(false);
    }

    /* JADX INFO: renamed from: a */
    public void m2881a(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        GameRenderer gameRenderer = this.minecraft.gameRenderer;
        if (abstractC0863pb == null) {
            gameRenderer.shutdownEffect();
            return;
        }
        ResourceLocation resourceLocationM6143N = abstractC0863pb.m4089a().m6143N();
        PostChain postChainCurrentEffect = gameRenderer.currentEffect();
        if (resourceLocationM6143N == null) {
            if (postChainCurrentEffect != null) {
                gameRenderer.shutdownEffect();
            }
        } else if (postChainCurrentEffect == null || !postChainCurrentEffect.getName().equals(resourceLocationM6143N.toString())) {
            gameRenderer.loadEffect(resourceLocationM6143N);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2882a(@NotNull Minecraft minecraft, @NotNull C0394gj c0394gj, @NotNull C0396gl c0396gl, @Nullable ClientLevel clientLevel) {
        m2879a(minecraft, c0396gl, clientLevel, (AbstractC0863pb<?, ?, ?>) null);
        c0394gj.m1111aa(false);
        c0394gj.m1105Y(false);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0517j m2883a() {
        return this.f3574a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0838pC m2884a() {
        return this.f3579a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0570k m2885a() {
        return this.f3576a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Minecraft m2886a() {
        return this.minecraft;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0489iY m2887a() {
        return this.f3562a;
    }

    /* JADX INFO: renamed from: a */
    private void m2888a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2) {
        SoundEvent soundEvent = null;
        Component component = null;
        if (connectionStatus2 == ConnectionStatus.CONNECTED_VERIFIED) {
            soundEvent = SoundEvents.BEACON_ACTIVATE;
            component = f3558l;
        } else if (connectionStatus == ConnectionStatus.CONNECTED_VERIFIED) {
            soundEvent = SoundEvents.BEACON_DEACTIVATE;
            component = f3559m;
        }
        if (soundEvent != null) {
            this.minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0f));
        }
        if (component != null) {
            C0301ew.m1626a(Minecraft.getInstance(), (Component) Component.literal("BlockFront Cloud"), component, true);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0545jb m2889a() {
        return this.f3583a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public PacketDailyReward m2890a() {
        return this.f3584a;
    }

    /* JADX INFO: renamed from: a */
    public void m2891a(@Nullable PacketDailyReward packetDailyReward) {
        this.f3584a = packetDailyReward;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public PacketDailyReward m2892b() {
        PacketDailyReward packetDailyReward = this.f3584a;
        this.f3584a = null;
        return packetDailyReward;
    }

    /* JADX INFO: renamed from: a */
    public void m2893a(@NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType) {
        this.f3585a.enqueue(new a(component, component2, popupType));
    }

    /* JADX INFO: renamed from: b */
    public void m2894b(@NotNull Minecraft minecraft) {
        if (this.f3585a.isEmpty()) {
            return;
        }
        Screen screen = minecraft.screen;
        if ((screen instanceof AbstractC0235dj) || (screen instanceof C0132bw)) {
            return;
        }
        a aVar = (a) this.f3585a.dequeue();
        m2853a(aVar.m2899a(), aVar.m2900b(), aVar.m2901a(), new C0131bv(f3555k, null, button -> {
            minecraft.setScreen(screen);
        }));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0681mE m2895a() {
        return this.f3567a;
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0607kk mo2339a() {
        return new C0607kk(this, true);
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: a */
    public C0994s mo2340a() {
        return new C0994s(this);
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> mo2354a(@NotNull UUID uuid) {
        return (this.f3560a == null || !this.f3560a.m4018b().m4245h().contains(uuid)) ? super.mo2354a(uuid) : this.f3560a;
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: f */
    public boolean mo2374f() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: g */
    public boolean mo2375g() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: a */
    public void mo2376a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        super.mo2376a(connectionStatus, connectionStatus2, connectionStatusContext);
        m2888a(connectionStatus, connectionStatus2);
        C0551jh c0551jhA = ((C0358g) this.f3179a).m1722a();
        UUID uuidMo1729a = ((C0358g) this.f3179a).mo1729a();
        if (connectionStatus2 == ConnectionStatus.CONNECTED_VERIFIED) {
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY, uuidMo1729a);
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo1729a);
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo1729a);
            c0551jhA.m2496bk();
        }
        if (!connectionStatus2.isConnected()) {
            m2885a().m2587a(false);
        }
    }
}
