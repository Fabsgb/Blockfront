package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.SearchGame;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sW.class */
public final class sW {

    @NotNull
    public static final Map<String, sW> W = new Object2ObjectLinkedOpenHashMap();

    @NotNull
    public static final sW b = new sW(a.SOLO, "bf.gamemode.boot", "boot", SearchGame.BOOT, C0483rx.class).a((Component) Component.translatable("bf.gamemode.boot.description"));

    @NotNull
    public static final sW c = new sW(a.VERSUS, "bf.gamemode.dom", "dom", SearchGame.DOMINATION, rB.class).a((Component) Component.translatable("bf.gamemode.dom.description"));

    @NotNull
    public static final sW d = new sW(a.VERSUS, "bf.gamemode.of", "of", SearchGame.OFFENSIVE, C0496sj.class).a((Component) Component.translatable("bf.gamemode.of.description")).m1095b();

    @NotNull
    public static final sW e = new sW(a.VERSUS, "bf.gamemode.tdm", "tdm", SearchGame.TEAM_DEATHMATCH, C0506st.class).a((Component) Component.translatable("bf.gamemode.tdm.description"));

    @NotNull
    public static final sW f = new sW(a.VERSUS, "bf.gamemode.gg", "gg", SearchGame.GUN_GAME, rO.class).a((Component) Component.translatable("bf.gamemode.gg.description"));

    @NotNull
    public static final sW g = new sW(a.VERSUS, "bf.gamemode.ffa", "ffa", SearchGame.FREE_FOR_ALL, rI.class).a((Component) Component.translatable("bf.gamemode.ffa.description"));

    @NotNull
    public static final sW h = new sW(a.COOP, "bf.gamemode.inf", "inf", SearchGame.INFECT, rV.class).a((Component) Component.translatable("bf.gamemode.inf.description")).a((Supplier<SoundEvent>) C0624xc.sG).m1095b();

    @NotNull
    public static final sW i = new sW(a.MISC, "bf.gamemode.ttt", "ttt", SearchGame.TROUBLE_TOWN, sA.class).a((Component) Component.translatable("bf.gamemode.ttt.description")).m1095b();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private final a f298b;

    @NotNull
    private final Component jw;

    @NotNull
    private final String cM;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private final SearchGame f299b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    private final Class<? extends oF<?, ?, ?>> f300c;
    private boolean ht;

    @NotNull
    private final ResourceLocation fC;

    @NotNull
    private final ResourceLocation fD;

    @NotNull
    private final List<sW> bF = new ObjectArrayList();

    @NotNull
    private Component description = Component.empty();
    private boolean hu = false;

    @Nullable
    private Supplier<SoundEvent> v = null;

    static {
        c.a(d);
        d.a(c);
        e.a(g);
        e.a(f);
        g.a(e);
        g.a(f);
        f.a(e);
        f.a(g);
    }

    public sW(@NotNull a aVar, @NotNull String str, @NotNull String str2, @NotNull SearchGame searchGame, @NotNull Class<? extends oF<?, ?, ?>> cls) {
        W.put(str2, this);
        this.f300c = cls;
        this.f298b = aVar;
        this.jw = Component.translatable(str);
        this.cM = str2;
        this.f299b = searchGame;
        this.ht = false;
        this.fC = C0265jv.d("textures/gui/gamemode/gamemode_" + str2 + ".png");
        this.fD = C0265jv.d("textures/gui/gamemode/gamemode_" + str2 + "_icon.png");
    }

    @NotNull
    public ResourceLocation getIconTexture() {
        return this.fD;
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.fC;
    }

    @NotNull
    public static Collection<sW> h() {
        return W.values();
    }

    @Nullable
    public static sW a(@NotNull String str) {
        return W.get(str);
    }

    @NotNull
    public static List<sW> a(@NotNull a aVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (sW sWVar : W.values()) {
            if (sWVar.f298b == aVar || aVar == a.ALL) {
                objectArrayList.add(sWVar);
            }
        }
        return objectArrayList;
    }

    @NotNull
    public Class<? extends oF<?, ?, ?>> b() {
        return this.f300c;
    }

    @NotNull
    public SearchGame a() {
        return this.f299b;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m1094a() {
        return this.f298b;
    }

    public void a(@NotNull sW sWVar) {
        this.bF.add(sWVar);
    }

    @NotNull
    public Component getDisplayName() {
        return this.jw;
    }

    @NotNull
    public String am() {
        return this.cM;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public sW m1095b() {
        this.ht = true;
        return this;
    }

    public boolean bV() {
        return this.ht;
    }

    @NotNull
    public sW c() {
        this.hu = true;
        return this;
    }

    public boolean bW() {
        return this.hu;
    }

    @NotNull
    public Component getDescription() {
        return this.description;
    }

    public sW a(@NotNull Component component) {
        this.description = component;
        return this;
    }

    @NotNull
    public List<sW> aw() {
        return this.bF;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Supplier<SoundEvent> m1096a() {
        return this.v;
    }

    public sW a(@NotNull Supplier<SoundEvent> supplier) {
        this.v = supplier;
        return this;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sW$a.class */
    public enum a {
        ALL(Component.translatable("bf.message.gamemode.category.all"), Component.translatable("bf.message.gamemode.category.all.tip")),
        SOLO(Component.translatable("bf.message.gamemode.category.solo"), Component.translatable("bf.message.gamemode.category.solo.tip")),
        VERSUS(Component.translatable("bf.message.gamemode.category.versus"), Component.translatable("bf.message.gamemode.category.versus.tip")),
        COOP(Component.translatable("bf.message.gamemode.category.coop"), Component.translatable("bf.message.gamemode.category.coop.tip")),
        MISC(Component.translatable("bf.message.gamemode.category.misc"), Component.translatable("bf.message.gamemode.category.misc.tip"));


        @NotNull
        private final Component title;

        @NotNull
        private final Component tip;

        a(@NotNull Component component, @NotNull Component component2) {
            this.title = component;
            this.tip = component2;
        }

        @NotNull
        public Component getTitle() {
            return this.title;
        }

        @NotNull
        public Component getTip() {
            return this.tip;
        }
    }
}
