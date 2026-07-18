package com.boehmod.blockfront;

import com.boehmod.blockfront.C1177vX;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM.class */
public class C1219wM {

    /* JADX INFO: renamed from: cl */
    @NotNull
    public static final List<b> f6915cl;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final KeyMapping f6916a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final KeyMapping f6917b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final KeyMapping f6918c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final KeyMapping f6919d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final KeyMapping f6920e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final KeyMapping f6921f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final KeyMapping f6922g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final KeyMapping f6923h;

    /* JADX INFO: renamed from: at */
    @NotNull
    public static final Map<EnumC0807oZ, KeyMapping> f6924at;

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final KeyMapping f6925i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public static final KeyMapping f6926j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final KeyMapping f6927k;

    /* JADX INFO: renamed from: jz */
    static final /* synthetic */ boolean f6928jz;

    static {
        f6928jz = !C1219wM.class.desiredAssertionStatus();
        f6915cl = new ObjectArrayList();
        f6916a = m7262a(new a("bf.key.gun.reload", 82, "bf.key.categories.weapon", minecraft -> {
            C1194vo.m6653c(new C1208wB());
        }));
        f6917b = m7262a(new a("bf.key.gun.firemode", 71, "bf.key.categories.weapon", minecraft2 -> {
            if (minecraft2.player == null || minecraft2.screen != null) {
                return;
            }
            ItemStack mainHandItem = minecraft2.player.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C1144ur) {
                C1144ur c1144ur = (C1144ur) item;
                if (!C1144ur.m6311f(mainHandItem) && c1144ur.m6390a().length > 1) {
                    minecraft2.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7846uR.get(), 1.0f, 1.0f));
                    c1144ur.m6351dq();
                    C0415hE.m1960a(C0418hH.f2692I);
                }
            }
        }));
        f6918c = m7262a(new b("bf.key.gun.inspect", 70, "bf.key.categories.weapon"));
        f6919d = m7262a(new a("bf.key.match.warcry", 67, "bf.key.categories.match", minecraft3 -> {
            C1194vo.m6653c(new C1205vz());
        }));
        f6920e = m7262a(new a("bf.key.match.spectate.next", Token.DEC, "bf.key.categories.match", minecraft4 -> {
            if (m7261g(minecraft4)) {
                C1194vo.m6653c(new C1177vX(C1177vX.a.CYCLE_NEXT));
            }
        }));
        f6921f = m7262a(new a("bf.key.match.spectate.previous", Token.DIV_EQ, "bf.key.categories.match", minecraft5 -> {
            if (m7261g(minecraft5)) {
                C1194vo.m6653c(new C1177vX(C1177vX.a.CYCLE_PREVIOUS));
            }
        }));
        f6922g = m7262a(new a("bf.key.match.teamchat", 89, "bf.key.categories.match", minecraft6 -> {
            if (C0466iC.m2100f(minecraft6)) {
                minecraft6.setScreen(new ChatScreen("[Team] "));
            } else if (C0466iC.m2101X()) {
                C0466iC.m2099c(minecraft6, C0466iC.f2882hL);
            }
        }));
        f6923h = m7262a(new a("bf.key.callout", 88, "bf.key.categories.match.callout", minecraft7 -> {
            if (C0465iB.m2097e(minecraft7)) {
                minecraft7.setScreen(new C0142cG());
            }
        }));
        f6924at = new EnumMap(EnumC0807oZ.class);
        for (EnumC0807oZ enumC0807oZ : EnumC0807oZ.values()) {
            f6924at.put(enumC0807oZ, m7262a(new a("bf.key.callout." + enumC0807oZ.name().toLowerCase(Locale.ROOT), InputConstants.UNKNOWN.getValue(), "bf.key.categories.match.callout", minecraft8 -> {
                if (C0465iB.m2097e(minecraft8)) {
                    C0465iB.m2098a(minecraft8, enumC0807oZ);
                }
            })));
        }
        f6925i = m7262a(new a("bf.key.match.class.selection", 77, "bf.key.categories.match", minecraft9 -> {
            LocalPlayer localPlayer;
            f6925i.setDown(false);
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f6928jz && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
            if (abstractC0788oGM2692a != null && (localPlayer = minecraft9.player) != null) {
                abstractC0788oGM2692a.m3733f(minecraft9, localPlayer);
            }
        }));
        f6926j = m7262a(new a("bf.key.match.ping", InputConstants.Type.MOUSE, 2, "bf.key.categories.match", minecraft10 -> {
            if (C0476iM.f2917de) {
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f6928jz && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                Object objM2692a = c0622lM2667b.m2692a();
                if (objM2692a != null && (objM2692a instanceof InterfaceC0897qJ)) {
                    ((InterfaceC0897qJ) objM2692a).mo4648e(minecraft10, c0622lM2667b);
                }
            }
        }));
        f6927k = m7262a(new c("bf.key.vehicle.horn", 72, "bf.key.categories.vehicle", 60, minecraft11 -> {
            if (minecraft11.player != null && (minecraft11.player.getVehicle() instanceof AbstractC0779ny)) {
                C1194vo.m6653c(new C1155vB());
            }
        }));
    }

    /* JADX INFO: renamed from: b */
    public static void m7260b(@NotNull RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        registerKeyMappingsEvent.register(f6916a);
        registerKeyMappingsEvent.register(f6917b);
        registerKeyMappingsEvent.register(f6918c);
        registerKeyMappingsEvent.register(f6922g);
        registerKeyMappingsEvent.register(f6923h);
        registerKeyMappingsEvent.register(f6919d);
        registerKeyMappingsEvent.register(f6925i);
        registerKeyMappingsEvent.register(f6926j);
        registerKeyMappingsEvent.register(f6920e);
        registerKeyMappingsEvent.register(f6921f);
        Iterator<KeyMapping> it = f6924at.values().iterator();
        while (it.hasNext()) {
            registerKeyMappingsEvent.register(it.next());
        }
        registerKeyMappingsEvent.register(f6927k);
    }

    /* JADX INFO: renamed from: g */
    private static boolean m7261g(@NotNull Minecraft minecraft) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return false;
        }
        if (c0622lM2667b.m2689d()) {
            return true;
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        return abstractC0787oFM2688a != null && abstractC0787oFM2688a.mo3611bb() && minecraft.player != null && minecraft.player.isSpectator();
    }

    /* JADX INFO: renamed from: a */
    public static b m7262a(@NotNull b bVar) {
        f6915cl.add(bVar);
        return bVar;
    }

    /* JADX INFO: renamed from: n */
    public static void m7263n(@NotNull Minecraft minecraft) {
        for (b bVar : f6915cl) {
            bVar.onUpdate();
            if (bVar.consumeClick()) {
                if (bVar.mo7276do()) {
                    bVar.mo7275T(minecraft);
                }
            } else if (!bVar.isDown() && bVar.m7278dp()) {
                bVar.m7277U(minecraft);
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.wM$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM$b.class */
    public static class b extends KeyMapping {

        /* JADX INFO: renamed from: jA */
        public boolean f6930jA;

        public b(@NotNull String str, int i, @NotNull String str2) {
            super(str, i, str2);
            this.f6930jA = true;
        }

        public b(@NotNull String str, @NotNull InputConstants.Type type, int i, @NotNull String str2) {
            super(str, type, i, str2);
            this.f6930jA = true;
        }

        public void onUpdate() {
        }

        /* JADX INFO: renamed from: do */
        public boolean mo7276do() {
            return true;
        }

        /* JADX INFO: renamed from: T */
        public void mo7275T(Minecraft minecraft) {
        }

        /* JADX INFO: renamed from: U */
        public void m7277U(Minecraft minecraft) {
        }

        public boolean consumeClick() {
            boolean zConsumeClick = super.consumeClick();
            if (zConsumeClick) {
                this.f6930jA = false;
            }
            return zConsumeClick;
        }

        /* JADX INFO: renamed from: dp */
        public boolean m7278dp() {
            boolean z = !this.f6930jA;
            this.f6930jA = true;
            return z;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.wM$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM$a.class */
    public static class a extends b {

        /* JADX INFO: renamed from: e */
        private final Consumer<Minecraft> f6929e;

        public a(@NotNull String str, int i, @NotNull String str2, @NotNull Consumer<Minecraft> consumer) {
            super(str, i, str2);
            this.f6929e = consumer;
        }

        public a(@NotNull String str, @NotNull InputConstants.Type type, int i, @NotNull String str2, @NotNull Consumer<Minecraft> consumer) {
            super(str, type, i, str2);
            this.f6929e = consumer;
        }

        @Override // com.boehmod.blockfront.C1219wM.b
        /* JADX INFO: renamed from: T */
        public void mo7275T(Minecraft minecraft) {
            this.f6929e.accept(minecraft);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.wM$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM$c.class */
    public static class c extends a {

        /* JADX INFO: renamed from: tl */
        private final int f6931tl;

        /* JADX INFO: renamed from: tm */
        private int f6932tm;

        public c(@NotNull String str, int i, @NotNull String str2, int i2, @NotNull Consumer<Minecraft> consumer) {
            super(str, i, str2, consumer);
            this.f6932tm = 0;
            this.f6931tl = i2;
        }

        @Override // com.boehmod.blockfront.C1219wM.b
        public void onUpdate() {
            if (this.f6932tm > 0) {
                this.f6932tm--;
            }
        }

        @Override // com.boehmod.blockfront.C1219wM.b
        /* JADX INFO: renamed from: do */
        public boolean mo7276do() {
            return this.f6932tm <= 0;
        }

        @Override // com.boehmod.blockfront.C1219wM.a, com.boehmod.blockfront.C1219wM.b
        /* JADX INFO: renamed from: T */
        public void mo7275T(Minecraft minecraft) {
            super.mo7275T(minecraft);
            this.f6932tm = this.f6931tl;
        }
    }
}
