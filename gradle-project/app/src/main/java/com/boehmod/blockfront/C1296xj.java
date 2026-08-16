package com.boehmod.blockfront;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xj.class */
public class C1296xj {

    /* JADX INFO: renamed from: ct */
    @NotNull
    public static final List<b> f7478ct;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final KeyMapping f7479a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final KeyMapping f7480b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final KeyMapping f7481c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final KeyMapping f7482d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final KeyMapping f7483e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final KeyMapping f7484f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final KeyMapping f7485g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final KeyMapping f7486h;

    /* JADX INFO: renamed from: at */
    @NotNull
    public static final Map<EnumC0883pv, KeyMapping> f7487at;

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final KeyMapping f7488i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public static final KeyMapping f7489j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final KeyMapping f7490k;

    /* JADX INFO: renamed from: jP */
    static final /* synthetic */ boolean f7491jP;

    static {
        f7491jP = !C1296xj.class.desiredAssertionStatus();
        f7478ct = new ObjectArrayList();
        f7479a = m7850a(new a("bf.key.gun.reload", 82, "bf.key.categories.weapon", C0486iV::m2178v));
        f7480b = m7850a(new a("bf.key.gun.firemode", 71, "bf.key.categories.weapon", minecraft -> {
            if (minecraft.player == null || minecraft.screen != null) {
                return;
            }
            ItemStack mainHandItem = minecraft.player.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) item;
                if (!C0486iV.m2182aa() && c1117uP.m6365a().length > 1) {
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8259uU.get(), 1.0f, 1.0f));
                    C0486iV.m2184b(c1117uP);
                    C0432hU.m1986a(C0435hX.f2785I);
                }
            }
        }));
        f7481c = m7850a(new b("bf.key.gun.inspect", 70, "bf.key.categories.weapon"));
        f7482d = m7850a(new a("bf.key.match.warcry", 67, "bf.key.categories.match", minecraft2 -> {
            C1169vO.m6648c(new C1179vY());
        }));
        f7483e = m7850a(new a("bf.key.match.spectate.next", Token.DEC, "bf.key.categories.match", minecraft3 -> {
            if (m7849h(minecraft3)) {
                C1169vO.m6648c(new C1257wx(C1257wx.a.CYCLE_NEXT));
            }
        }));
        f7484f = m7850a(new a("bf.key.match.spectate.previous", Token.DIV_EQ, "bf.key.categories.match", minecraft4 -> {
            if (m7849h(minecraft4)) {
                C1169vO.m6648c(new C1257wx(C1257wx.a.CYCLE_PREVIOUS));
            }
        }));
        f7485g = m7850a(new a("bf.key.match.teamchat", 89, "bf.key.categories.match", minecraft5 -> {
            if (C0485iU.m2173f(minecraft5)) {
                minecraft5.setScreen(new ChatScreen("[Team] "));
            } else if (C0485iU.m2174Y()) {
                C0485iU.m2172c(minecraft5, C0485iU.f2956hW);
            }
        }));
        f7486h = m7850a(new a("bf.key.callout", 88, "bf.key.categories.match.callout", minecraft6 -> {
            if (C0483iS.m2168e(minecraft6)) {
                minecraft6.setScreen(new C0152cP());
            }
        }));
        f7487at = new EnumMap(EnumC0883pv.class);
        for (EnumC0883pv enumC0883pv : EnumC0883pv.values()) {
            f7487at.put(enumC0883pv, m7850a(new a("bf.key.callout." + enumC0883pv.name().toLowerCase(Locale.ROOT), InputConstants.UNKNOWN.getValue(), "bf.key.categories.match.callout", minecraft7 -> {
                if (C0483iS.m2168e(minecraft7)) {
                    C0483iS.m2169a(minecraft7, enumC0883pv);
                }
            })));
        }
        f7488i = m7850a(new a("bf.key.match.class.selection", 77, "bf.key.categories.match", minecraft8 -> {
            LocalPlayer localPlayer;
            f7488i.setDown(false);
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f7491jP && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
            if (abstractC0864pcM2878a != null && (localPlayer = minecraft8.player) != null) {
                abstractC0864pcM2878a.m4169g(minecraft8, localPlayer);
            }
        }));
        f7489j = m7850a(new a("bf.key.match.ping", InputConstants.Type.MOUSE, 2, "bf.key.categories.match", minecraft9 -> {
            if (C0549jf.f3266do) {
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f7491jP && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                Object objM2878a = c0623lM2852b.m2878a();
                if (objM2878a != null && (objM2878a instanceof InterfaceC0974rg)) {
                    ((InterfaceC0974rg) objM2878a).mo5543e(minecraft9, c0623lM2852b);
                }
            }
        }));
        f7490k = m7850a(new c("bf.key.vehicle.horn", 72, "bf.key.categories.vehicle", 60, minecraft10 -> {
            if (minecraft10.player != null && (minecraft10.player.getVehicle() instanceof AbstractC0750nU)) {
                C1169vO.m6648c(new C1234wa());
            }
        }));
    }

    /* JADX INFO: renamed from: b */
    public static void m7848b(@NotNull RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        registerKeyMappingsEvent.register(f7479a);
        registerKeyMappingsEvent.register(f7480b);
        registerKeyMappingsEvent.register(f7481c);
        registerKeyMappingsEvent.register(f7485g);
        registerKeyMappingsEvent.register(f7486h);
        registerKeyMappingsEvent.register(f7482d);
        registerKeyMappingsEvent.register(f7488i);
        registerKeyMappingsEvent.register(f7489j);
        registerKeyMappingsEvent.register(f7483e);
        registerKeyMappingsEvent.register(f7484f);
        Iterator<KeyMapping> it = f7487at.values().iterator();
        while (it.hasNext()) {
            registerKeyMappingsEvent.register(it.next());
        }
        registerKeyMappingsEvent.register(f7490k);
    }

    /* JADX INFO: renamed from: h */
    private static boolean m7849h(@NotNull Minecraft minecraft) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return false;
        }
        if (c0623lM2852b.m2875d()) {
            return true;
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        return abstractC0863pbM2874a != null && abstractC0863pbM2874a.mo4047bl() && minecraft.player != null && minecraft.player.isSpectator();
    }

    /* JADX INFO: renamed from: a */
    public static b m7850a(@NotNull b bVar) {
        f7478ct.add(bVar);
        return bVar;
    }

    /* JADX INFO: renamed from: o */
    public static void m7851o(@NotNull Minecraft minecraft) {
        for (b bVar : f7478ct) {
            bVar.onUpdate();
            if (bVar.consumeClick()) {
                if (bVar.mo7863dx()) {
                    bVar.mo7862U(minecraft);
                }
            } else if (!bVar.isDown() && bVar.m7865dy()) {
                bVar.m7864V(minecraft);
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.xj$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xj$b.class */
    public static class b extends KeyMapping {

        /* JADX INFO: renamed from: jQ */
        public boolean f7493jQ;

        public b(@NotNull String str, int i, @NotNull String str2) {
            super(str, i, str2);
            this.f7493jQ = true;
        }

        public b(@NotNull String str, @NotNull InputConstants.Type type, int i, @NotNull String str2) {
            super(str, type, i, str2);
            this.f7493jQ = true;
        }

        public void onUpdate() {
        }

        /* JADX INFO: renamed from: dx */
        public boolean mo7863dx() {
            return true;
        }

        /* JADX INFO: renamed from: U */
        public void mo7862U(Minecraft minecraft) {
        }

        /* JADX INFO: renamed from: V */
        public void m7864V(Minecraft minecraft) {
        }

        public boolean consumeClick() {
            boolean zConsumeClick = super.consumeClick();
            if (zConsumeClick) {
                this.f7493jQ = false;
            }
            return zConsumeClick;
        }

        /* JADX INFO: renamed from: dy */
        public boolean m7865dy() {
            boolean z = !this.f7493jQ;
            this.f7493jQ = true;
            return z;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.xj$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xj$a.class */
    public static class a extends b {

        /* JADX INFO: renamed from: e */
        private final Consumer<Minecraft> f7492e;

        public a(@NotNull String str, int i, @NotNull String str2, @NotNull Consumer<Minecraft> consumer) {
            super(str, i, str2);
            this.f7492e = consumer;
        }

        public a(@NotNull String str, @NotNull InputConstants.Type type, int i, @NotNull String str2, @NotNull Consumer<Minecraft> consumer) {
            super(str, type, i, str2);
            this.f7492e = consumer;
        }

        @Override // com.boehmod.blockfront.C1296xj.b
        /* JADX INFO: renamed from: U */
        public void mo7862U(Minecraft minecraft) {
            this.f7492e.accept(minecraft);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.xj$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xj$c.class */
    public static class c extends a {

        /* JADX INFO: renamed from: vp */
        private final int f7494vp;

        /* JADX INFO: renamed from: vq */
        private int f7495vq;

        public c(@NotNull String str, int i, @NotNull String str2, int i2, @NotNull Consumer<Minecraft> consumer) {
            super(str, i, str2, consumer);
            this.f7495vq = 0;
            this.f7494vp = i2;
        }

        @Override // com.boehmod.blockfront.C1296xj.b
        public void onUpdate() {
            if (this.f7495vq > 0) {
                this.f7495vq--;
            }
        }

        @Override // com.boehmod.blockfront.C1296xj.b
        /* JADX INFO: renamed from: dx */
        public boolean mo7863dx() {
            return this.f7495vq <= 0;
        }

        @Override // com.boehmod.blockfront.C1296xj.a, com.boehmod.blockfront.C1296xj.b
        /* JADX INFO: renamed from: U */
        public void mo7862U(Minecraft minecraft) {
            super.mo7862U(minecraft);
            this.f7495vq = this.f7494vp;
        }
    }
}
