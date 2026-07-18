package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.SearchGame;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sW.class */
public final class C1016sW {

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final Map<String, C1016sW> f5342W = new Object2ObjectLinkedOpenHashMap();

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C1016sW f5343b = new C1016sW(a.SOLO, "bf.gamemode.boot", "boot", SearchGame.BOOT, C0990rx.class).m5542a((Component) Component.translatable("bf.gamemode.boot.description"));

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final C1016sW f5344c = new C1016sW(a.VERSUS, "bf.gamemode.dom", "dom", SearchGame.DOMINATION, C0942rB.class).m5542a((Component) Component.translatable("bf.gamemode.dom.description"));

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final C1016sW f5345d = new C1016sW(a.VERSUS, "bf.gamemode.of", "of", SearchGame.OFFENSIVE, C1030sj.class).m5542a((Component) Component.translatable("bf.gamemode.of.description")).m5538b();

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final C1016sW f5346e = new C1016sW(a.VERSUS, "bf.gamemode.tdm", "tdm", SearchGame.TEAM_DEATHMATCH, C1040st.class).m5542a((Component) Component.translatable("bf.gamemode.tdm.description"));

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final C1016sW f5347f = new C1016sW(a.VERSUS, "bf.gamemode.gg", "gg", SearchGame.GUN_GAME, C0955rO.class).m5542a((Component) Component.translatable("bf.gamemode.gg.description"));

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final C1016sW f5348g = new C1016sW(a.VERSUS, "bf.gamemode.ffa", "ffa", SearchGame.FREE_FOR_ALL, C0949rI.class).m5542a((Component) Component.translatable("bf.gamemode.ffa.description"));

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final C1016sW f5349h = new C1016sW(a.COOP, "bf.gamemode.inf", "inf", SearchGame.INFECT, C0962rV.class).m5542a((Component) Component.translatable("bf.gamemode.inf.description")).m5545a((Supplier<SoundEvent>) C1280xc.f7731sG).m5538b();

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final C1016sW f5350i = new C1016sW(a.MISC, "bf.gamemode.ttt", "ttt", SearchGame.TROUBLE_TOWN, C0994sA.class).m5542a((Component) Component.translatable("bf.gamemode.ttt.description")).m5538b();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final a f5351b;

    /* JADX INFO: renamed from: jw */
    @NotNull
    private final Component f5352jw;

    /* JADX INFO: renamed from: cM */
    @NotNull
    private final String f5353cM;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final SearchGame f5354b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Class<? extends AbstractC0787oF<?, ?, ?>> f5356c;

    /* JADX INFO: renamed from: ht */
    private boolean f5357ht;

    /* JADX INFO: renamed from: fC */
    @NotNull
    private final ResourceLocation f5360fC;

    /* JADX INFO: renamed from: fD */
    @NotNull
    private final ResourceLocation f5361fD;

    /* JADX INFO: renamed from: bF */
    @NotNull
    private final List<C1016sW> f5355bF = new ObjectArrayList();

    @NotNull
    private Component description = Component.empty();

    /* JADX INFO: renamed from: hu */
    private boolean f5358hu = false;

    /* JADX INFO: renamed from: v */
    @Nullable
    private Supplier<SoundEvent> f5359v = null;

    static {
        f5344c.m5536a(f5345d);
        f5345d.m5536a(f5344c);
        f5346e.m5536a(f5348g);
        f5346e.m5536a(f5347f);
        f5348g.m5536a(f5346e);
        f5348g.m5536a(f5347f);
        f5347f.m5536a(f5346e);
        f5347f.m5536a(f5348g);
    }

    public C1016sW(@NotNull a aVar, @NotNull String str, @NotNull String str2, @NotNull SearchGame searchGame, @NotNull Class<? extends AbstractC0787oF<?, ?, ?>> cls) {
        f5342W.put(str2, this);
        this.f5356c = cls;
        this.f5351b = aVar;
        this.f5352jw = Component.translatable(str);
        this.f5353cM = str2;
        this.f5354b = searchGame;
        this.f5357ht = false;
        this.f5360fC = C0564jv.m2555d("textures/gui/gamemode/gamemode_" + str2 + ".png");
        this.f5361fD = C0564jv.m2555d("textures/gui/gamemode/gamemode_" + str2 + "_icon.png");
    }

    @NotNull
    public ResourceLocation getIconTexture() {
        return this.f5361fD;
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.f5360fC;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public static Collection<C1016sW> m5530h() {
        return f5342W.values();
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1016sW m5531a(@NotNull String str) {
        return f5342W.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<C1016sW> m5532a(@NotNull a aVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1016sW c1016sW : f5342W.values()) {
            if (c1016sW.f5351b == aVar || aVar == a.ALL) {
                objectArrayList.add(c1016sW);
            }
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Class<? extends AbstractC0787oF<?, ?, ?>> m5533b() {
        return this.f5356c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SearchGame m5534a() {
        return this.f5354b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m5535a() {
        return this.f5351b;
    }

    /* JADX INFO: renamed from: a */
    public void m5536a(@NotNull C1016sW c1016sW) {
        this.f5355bF.add(c1016sW);
    }

    @NotNull
    public Component getDisplayName() {
        return this.f5352jw;
    }

    @NotNull
    /* JADX INFO: renamed from: am */
    public String m5537am() {
        return this.f5353cM;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1016sW m5538b() {
        this.f5357ht = true;
        return this;
    }

    /* JADX INFO: renamed from: bV */
    public boolean m5539bV() {
        return this.f5357ht;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1016sW m5540c() {
        this.f5358hu = true;
        return this;
    }

    /* JADX INFO: renamed from: bW */
    public boolean m5541bW() {
        return this.f5358hu;
    }

    @NotNull
    public Component getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: a */
    public C1016sW m5542a(@NotNull Component component) {
        this.description = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: aw */
    public List<C1016sW> m5543aw() {
        return this.f5355bF;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Supplier<SoundEvent> m5544a() {
        return this.f5359v;
    }

    /* JADX INFO: renamed from: a */
    public C1016sW m5545a(@NotNull Supplier<SoundEvent> supplier) {
        this.f5359v = supplier;
        return this;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.sW$a */
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
