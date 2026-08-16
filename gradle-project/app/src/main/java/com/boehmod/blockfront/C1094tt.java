package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.SearchGame;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.tt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tt.class */
public final class C1094tt {

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final Map<String, C1094tt> f5906W = new Object2ObjectLinkedOpenHashMap();

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C1094tt f5907b = new C1094tt(a.SOLO, "bf.gamemode.boot", "boot", SearchGame.BOOT, C0962rU.class).m6030a((Component) Component.translatable("bf.gamemode.boot.description"));

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final C1094tt f5908c = new C1094tt(a.VERSUS, "bf.gamemode.dom", "dom", SearchGame.DOMINATION, C0966rY.class).m6030a((Component) Component.translatable("bf.gamemode.dom.description"));

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final C1094tt f5909d = new C1094tt(a.VERSUS, "bf.gamemode.of", "of", SearchGame.OFFENSIVE, C1001sG.class).m6030a((Component) Component.translatable("bf.gamemode.of.description")).m6026b();

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final C1094tt f5910e = new C1094tt(a.VERSUS, "bf.gamemode.tdm", "tdm", SearchGame.TEAM_DEATHMATCH, C1011sQ.class).m6030a((Component) Component.translatable("bf.gamemode.tdm.description"));

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final C1094tt f5911f = new C1094tt(a.VERSUS, "bf.gamemode.gg", "gg", SearchGame.GUN_GAME, C1033sl.class).m6030a((Component) Component.translatable("bf.gamemode.gg.description"));

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final C1094tt f5912g = new C1094tt(a.VERSUS, "bf.gamemode.ffa", "ffa", SearchGame.FREE_FOR_ALL, C1027sf.class).m6030a((Component) Component.translatable("bf.gamemode.ffa.description"));

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final C1094tt f5913h = new C1094tt(a.COOP, "bf.gamemode.inf", "inf", SearchGame.INFECT, C1040ss.class).m6030a((Component) Component.translatable("bf.gamemode.inf.description")).m6033a((Supplier<SoundEvent>) C1312xz.f8142sH).m6026b();

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final C1094tt f5914i = new C1094tt(a.MISC, "bf.gamemode.ttt", "ttt", SearchGame.TROUBLE_TOWN, C1018sX.class).m6030a((Component) Component.translatable("bf.gamemode.ttt.description")).m6026b();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final a f5915b;

    /* JADX INFO: renamed from: jJ */
    @NotNull
    private final Component f5916jJ;

    /* JADX INFO: renamed from: cW */
    @NotNull
    private final String f5917cW;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final SearchGame f5918b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Class<? extends AbstractC0863pb<?, ?, ?>> f5920c;

    /* JADX INFO: renamed from: hN */
    private boolean f5921hN;

    /* JADX INFO: renamed from: fB */
    @NotNull
    private final ResourceLocation f5924fB;

    /* JADX INFO: renamed from: fC */
    @NotNull
    private final ResourceLocation f5925fC;

    /* JADX INFO: renamed from: bM */
    @NotNull
    private final List<C1094tt> f5919bM = new ObjectArrayList();

    @NotNull
    private Component description = Component.empty();

    /* JADX INFO: renamed from: hO */
    private boolean f5922hO = false;

    /* JADX INFO: renamed from: v */
    @Nullable
    private Supplier<SoundEvent> f5923v = null;

    static {
        f5908c.m6024a(f5909d);
        f5909d.m6024a(f5908c);
        f5910e.m6024a(f5912g);
        f5910e.m6024a(f5911f);
        f5912g.m6024a(f5910e);
        f5912g.m6024a(f5911f);
        f5911f.m6024a(f5910e);
        f5911f.m6024a(f5912g);
    }

    public C1094tt(@NotNull a aVar, @NotNull String str, @NotNull String str2, @NotNull SearchGame searchGame, @NotNull Class<? extends AbstractC0863pb<?, ?, ?>> cls) {
        f5906W.put(str2, this);
        this.f5920c = cls;
        this.f5915b = aVar;
        this.f5916jJ = Component.translatable(str);
        this.f5917cW = str2;
        this.f5918b = searchGame;
        this.f5921hN = false;
        this.f5924fB = C0532jO.m2378d("textures/gui/gamemode/gamemode_" + str2 + ".png");
        this.f5925fC = C0532jO.m2378d("textures/gui/gamemode/gamemode_" + str2 + "_icon.png");
    }

    @NotNull
    public ResourceLocation getIconTexture() {
        return this.f5925fC;
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.f5924fB;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public static Collection<C1094tt> m6018h() {
        return f5906W.values();
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1094tt m6019a(@NotNull String str) {
        return f5906W.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<C1094tt> m6020a(@NotNull a aVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1094tt c1094tt : f5906W.values()) {
            if (c1094tt.f5915b == aVar || aVar == a.ALL) {
                objectArrayList.add(c1094tt);
            }
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Class<? extends AbstractC0863pb<?, ?, ?>> m6021b() {
        return this.f5920c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SearchGame m6022a() {
        return this.f5918b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m6023a() {
        return this.f5915b;
    }

    /* JADX INFO: renamed from: a */
    public void m6024a(@NotNull C1094tt c1094tt) {
        this.f5919bM.add(c1094tt);
    }

    @NotNull
    public Component getDisplayName() {
        return this.f5916jJ;
    }

    @NotNull
    /* JADX INFO: renamed from: at */
    public String m6025at() {
        return this.f5917cW;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1094tt m6026b() {
        this.f5921hN = true;
        return this;
    }

    /* JADX INFO: renamed from: cf */
    public boolean m6027cf() {
        return this.f5921hN;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1094tt m6028c() {
        this.f5922hO = true;
        return this;
    }

    /* JADX INFO: renamed from: cg */
    public boolean m6029cg() {
        return this.f5922hO;
    }

    @NotNull
    public Component getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: a */
    public C1094tt m6030a(@NotNull Component component) {
        this.description = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: ay */
    public List<C1094tt> m6031ay() {
        return this.f5919bM;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Supplier<SoundEvent> m6032a() {
        return this.f5923v;
    }

    /* JADX INFO: renamed from: a */
    public C1094tt m6033a(@NotNull Supplier<SoundEvent> supplier) {
        this.f5923v = supplier;
        return this;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tt$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tt$a.class */
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

        a(Component component, Component component2) {
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
