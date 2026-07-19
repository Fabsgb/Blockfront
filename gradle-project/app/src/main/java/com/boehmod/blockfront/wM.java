package com.boehmod.blockfront;

import com.boehmod.blockfront.vX;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM.class */
public class wM {

    @NotNull
    public static final List<b> cl;

    @NotNull
    public static final KeyMapping a;

    @NotNull
    public static final KeyMapping b;

    @NotNull
    public static final KeyMapping c;

    @NotNull
    public static final KeyMapping d;

    @NotNull
    public static final KeyMapping e;

    @NotNull
    public static final KeyMapping f;

    @NotNull
    public static final KeyMapping g;

    @NotNull
    public static final KeyMapping h;

    @NotNull
    public static final Map<oZ, KeyMapping> at;

    @NotNull
    public static final KeyMapping i;

    @NotNull
    public static final KeyMapping j;

    @NotNull
    public static final KeyMapping k;
    static final /* synthetic */ boolean jz;

    static {
        jz = !wM.class.desiredAssertionStatus();
        cl = new ObjectArrayList();
        a = a(new a("bf.key.gun.reload", 82, "bf.key.categories.weapon", minecraft -> {
            C0582vo.c(new wB());
        }));
        b = a(new a("bf.key.gun.firemode", 71, "bf.key.categories.weapon", minecraft2 -> {
            if (minecraft2.player == null || minecraft2.screen != null) {
                return;
            }
            ItemStack mainHandItem = minecraft2.player.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C0558ur) {
                C0558ur c0558ur = (C0558ur) item;
                if (!C0558ur.m1202f(mainHandItem) && c0558ur.m1215a().length > 1) {
                    minecraft2.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.uR.get(), 1.0f, 1.0f));
                    c0558ur.dq();
                    hE.a(hH.I);
                }
            }
        }));
        c = a(new b("bf.key.gun.inspect", 70, "bf.key.categories.weapon"));
        d = a(new a("bf.key.match.warcry", 67, "bf.key.categories.match", minecraft3 -> {
            C0582vo.c(new C0593vz());
        }));
        e = a(new a("bf.key.match.spectate.next", Token.DEC, "bf.key.categories.match", minecraft4 -> {
            if (g(minecraft4)) {
                C0582vo.c(new vX(vX.a.CYCLE_NEXT));
            }
        }));
        f = a(new a("bf.key.match.spectate.previous", Token.DIV_EQ, "bf.key.categories.match", minecraft5 -> {
            if (g(minecraft5)) {
                C0582vo.c(new vX(vX.a.CYCLE_PREVIOUS));
            }
        }));
        g = a(new a("bf.key.match.teamchat", 89, "bf.key.categories.match", minecraft6 -> {
            if (iC.f(minecraft6)) {
                minecraft6.setScreen(new ChatScreen("[Team] "));
            } else if (iC.X()) {
                iC.c(minecraft6, iC.hL);
            }
        }));
        h = a(new a("bf.key.callout", 88, "bf.key.categories.match.callout", minecraft7 -> {
            if (iB.e(minecraft7)) {
                minecraft7.setScreen(new cG());
            }
        }));
        at = new EnumMap(oZ.class);
        for (oZ oZVar : oZ.values()) {
            at.put(oZVar, a(new a("bf.key.callout." + oZVar.name().toLowerCase(Locale.ROOT), InputConstants.UNKNOWN.getValue(), "bf.key.categories.match.callout", minecraft8 -> {
                if (iB.e(minecraft8)) {
                    iB.a(minecraft8, oZVar);
                }
            })));
        }
        i = a(new a("bf.key.match.class.selection", 77, "bf.key.categories.match", minecraft9 -> {
            LocalPlayer localPlayer;
            i.setDown(false);
            C0297l c0297lB = C0297l.b();
            if (!jz && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            oG<?, ?> oGVarM593a = c0297lB.m593a();
            if (oGVarM593a != null && (localPlayer = minecraft9.player) != null) {
                oGVarM593a.f(minecraft9, localPlayer);
            }
        }));
        j = a(new a("bf.key.match.ping", InputConstants.Type.MOUSE, 2, "bf.key.categories.match", minecraft10 -> {
            if (iM.f417de) {
                C0297l c0297lB = C0297l.b();
                if (!jz && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                Object objM593a = c0297lB.m593a();
                if (objM593a != null && (objM593a instanceof qJ)) {
                    ((qJ) objM593a).e(minecraft10, c0297lB);
                }
            }
        }));
        k = a(new c("bf.key.vehicle.horn", 72, "bf.key.categories.vehicle", 60, minecraft11 -> {
            if (minecraft11.player != null && (minecraft11.player.getVehicle() instanceof AbstractC0376ny)) {
                C0582vo.c(new vB());
            }
        }));
    }

    public static void b(@NotNull RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        registerKeyMappingsEvent.register(a);
        registerKeyMappingsEvent.register(b);
        registerKeyMappingsEvent.register(c);
        registerKeyMappingsEvent.register(g);
        registerKeyMappingsEvent.register(h);
        registerKeyMappingsEvent.register(d);
        registerKeyMappingsEvent.register(i);
        registerKeyMappingsEvent.register(j);
        registerKeyMappingsEvent.register(e);
        registerKeyMappingsEvent.register(f);
        Iterator<KeyMapping> it = at.values().iterator();
        while (it.hasNext()) {
            registerKeyMappingsEvent.register(it.next());
        }
        registerKeyMappingsEvent.register(k);
    }

    private static boolean g(@NotNull Minecraft minecraft) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return false;
        }
        if (c0297lB.m592d()) {
            return true;
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        return oFVarM591a != null && oFVarM591a.bb() && minecraft.player != null && minecraft.player.isSpectator();
    }

    public static b a(@NotNull b bVar) {
        cl.add(bVar);
        return bVar;
    }

    public static void n(@NotNull Minecraft minecraft) {
        for (b bVar : cl) {
            bVar.onUpdate();
            if (bVar.consumeClick()) {
                if (bVar.mo1553do()) {
                    bVar.T(minecraft);
                }
            } else if (!bVar.isDown() && bVar.dp()) {
                bVar.U(minecraft);
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM$b.class */
    public static class b extends KeyMapping {
        public boolean jA;

        public b(@NotNull String str, int i, @NotNull String str2) {
            super(str, i, str2);
            this.jA = true;
        }

        public b(@NotNull String str, @NotNull InputConstants.Type type, int i, @NotNull String str2) {
            super(str, type, i, str2);
            this.jA = true;
        }

        public void onUpdate() {
        }

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public boolean mo1553do() {
            return true;
        }

        public void T(Minecraft minecraft) {
        }

        public void U(Minecraft minecraft) {
        }

        public boolean consumeClick() {
            boolean zConsumeClick = super.consumeClick();
            if (zConsumeClick) {
                this.jA = false;
            }
            return zConsumeClick;
        }

        public boolean dp() {
            boolean z = !this.jA;
            this.jA = true;
            return z;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM$a.class */
    public static class a extends b {
        private final Consumer<Minecraft> e;

        public a(@NotNull String str, int i, @NotNull String str2, @NotNull Consumer<Minecraft> consumer) {
            super(str, i, str2);
            this.e = consumer;
        }

        public a(@NotNull String str, @NotNull InputConstants.Type type, int i, @NotNull String str2, @NotNull Consumer<Minecraft> consumer) {
            super(str, type, i, str2);
            this.e = consumer;
        }

        @Override // com.boehmod.blockfront.wM.b
        public void T(Minecraft minecraft) {
            this.e.accept(minecraft);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wM$c.class */
    public static class c extends a {
        private final int tl;
        private int tm;

        public c(@NotNull String str, int i, @NotNull String str2, int i2, @NotNull Consumer<Minecraft> consumer) {
            super(str, i, str2, consumer);
            this.tm = 0;
            this.tl = i2;
        }

        @Override // com.boehmod.blockfront.wM.b
        public void onUpdate() {
            if (this.tm > 0) {
                this.tm--;
            }
        }

        @Override // com.boehmod.blockfront.wM.b
        /* JADX INFO: renamed from: do */
        public boolean mo1553do() {
            return this.tm <= 0;
        }

        @Override // com.boehmod.blockfront.wM.a, com.boehmod.blockfront.wM.b
        public void T(Minecraft minecraft) {
            super.T(minecraft);
            this.tm = this.tl;
        }
    }
}
