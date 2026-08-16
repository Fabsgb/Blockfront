package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gj.class */
public class C0394gj extends AbstractC0183b<C0623l, Level, Player, C0252e> {

    /* JADX INFO: renamed from: ae */
    @NotNull
    private static final String f2551ae = "textures/skins/game/nations/";

    /* JADX INFO: renamed from: af */
    @NotNull
    public static final String f2552af = "backpack";

    /* JADX INFO: renamed from: cC */
    @NotNull
    private ResourceLocation f2553cC;

    /* JADX INFO: renamed from: jX */
    private int f2554jX;

    /* JADX INFO: renamed from: jY */
    private static final int f2555jY = 300;

    /* JADX INFO: renamed from: jZ */
    private int f2556jZ;

    /* JADX INFO: renamed from: a */
    @Nullable
    private EnumC0883pv f2557a;

    /* JADX INFO: renamed from: ka */
    private int f2558ka;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0516iz f2559a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0509is f2560a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Item f2561a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private SimpleSoundInstance f2562a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private SimpleSoundInstance f2563b;

    /* JADX INFO: renamed from: cD */
    @Nullable
    private ResourceLocation f2564cD;

    /* JADX INFO: renamed from: cE */
    @Nullable
    private ResourceLocation f2565cE;

    /* JADX INFO: renamed from: kb */
    private int f2566kb;

    /* JADX INFO: renamed from: kc */
    private int f2567kc;

    /* JADX INFO: renamed from: fb */
    private float f2568fb;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0397gm<Player> f2569a;

    public C0394gj(@NotNull UUID uuid) {
        super(uuid);
        this.f2553cC = EnumC0883pv.MEDIC.getTexture();
        this.f2554jX = 0;
        this.f2556jZ = 0;
        this.f2557a = null;
        this.f2558ka = 0;
        this.f2561a = null;
        this.f2566kb = 0;
        this.f2567kc = 0;
        this.f2568fb = 0.0f;
        this.f2569a = new C0397gm<>();
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183b
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0252e mo1095a() {
        return new C0252e(this);
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public ResourceLocation m1854k() {
        return this.f2553cC;
    }

    /* JADX INFO: renamed from: l */
    public void m1855l(int i) {
        this.f2554jX = i;
    }

    /* JADX INFO: renamed from: ar */
    public int m1856ar() {
        return this.f2554jX;
    }

    /* JADX INFO: renamed from: a */
    private void m1857a(@NotNull Player player) {
        if (this.f1420jI) {
            player.zza = 0.0f;
            player.xxa = 0.0f;
        }
    }

    /* JADX INFO: renamed from: aN */
    private void m1858aN() {
        this.f1415ph = this.f1414pg;
        this.f1414pg = Mth.lerp(0.4f, this.f1414pg, 0.0f);
        if (this.f2556jZ > 0) {
            this.f2556jZ--;
            if (this.f2556jZ == 0) {
                this.f2557a = null;
            }
        }
        if (this.f2554jX > 0) {
            this.f2554jX--;
        }
    }

    /* JADX INFO: renamed from: aO */
    public void m1859aO() {
        this.f2569a.m1888aO();
    }

    /* JADX INFO: renamed from: P */
    public boolean m1860P() {
        return this.f2569a.m1889Q();
    }

    /* JADX INFO: renamed from: a */
    public void m1861a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @Nullable AbstractC0864pc<?, ?> abstractC0864pc, @NotNull Player player) {
        boolean zEquals = player.equals(localPlayer);
        ((C0252e) this.f1435a).m1439a(clientLevel, player, random);
        if (this.f1413vh > 0) {
            this.f1413vh--;
        }
        if (C0875pn.m4488a(player, this)) {
            this.f2558ka = 10;
        } else if (this.f2558ka > 0) {
            this.f2558ka--;
        }
        m1857a(player);
        m1858aN();
        this.f2569a.m1887a(zEquals, localPlayer, player);
        m1869a(abstractC0863pb, zEquals, localPlayer, player);
        m1865a(minecraft, abstractC0863pb, abstractC0864pc);
        m1864a(minecraft, player, zEquals);
    }

    /* JADX INFO: renamed from: as */
    public int m1862as() {
        return this.f2558ka;
    }

    /* JADX INFO: renamed from: m */
    public void m1863m(int i) {
        this.f2558ka = i;
    }

    /* JADX INFO: renamed from: a */
    private void m1864a(@NotNull Minecraft minecraft, @NotNull Player player, boolean z) {
        C1119uR c1119uR;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6406o;
        if (player instanceof C0109bZ) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        C1119uR item = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if (item != this.f2561a) {
            this.f2561a = item;
            if (this.f2560a != null && soundManager.isActive(this.f2560a)) {
                soundManager.stop(this.f2560a);
                this.f2560a = null;
            }
            if ((item instanceof C1119uR) && (deferredHolderM6406o = (c1119uR = item).m6406o()) != null) {
                this.f2560a = new C0509is(player, (SoundEvent) deferredHolderM6406o.get(), SoundSource.PLAYERS, c1119uR.m6405cL(), z ? 0.1f : 0.25f);
                soundManager.play(this.f2560a);
            }
        }
        if ((this.f2561a == null || this.f2561a == Items.AIR) && this.f2560a != null && soundManager.isActive(this.f2560a)) {
            soundManager.stop(this.f2560a);
            this.f2560a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1865a(@NotNull Minecraft minecraft, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @Nullable AbstractC0864pc<?, ?> abstractC0864pc) {
        if (mo1095a() == PlayerDataType.DISPLAY) {
            return;
        }
        int i = this.f2566kb;
        this.f2566kb = i - 1;
        if (i <= 0) {
            this.f2566kb = 80;
            if (abstractC0863pb != null && abstractC0864pc != null) {
                m1868b(minecraft, abstractC0863pb, abstractC0864pc);
            } else {
                this.f2564cD = null;
                this.f2565cE = null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1866a(@Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2) {
        this.f2564cD = resourceLocation;
        this.f2565cE = resourceLocation2;
    }

    /* JADX INFO: renamed from: aP */
    public void m1867aP() {
        this.f2566kb = 0;
    }

    /* JADX INFO: renamed from: b */
    private void m1868b(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc) {
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
        Set<UUID> setM4245h = abstractC0866peM4018b.m4245h();
        int iM4290a = abstractC0863pb.m4034a(this.f1401X).m4290a(C1062tN.f5745i.getKey(), -1);
        this.f2564cD = C0441hd.m2027a(this.f1401X, abstractC0864pc, iM4290a != -1 ? C1093ts.m6016a(iM4290a).getKey() : "rifleman", setM4245h);
        this.f2565cE = C0441hd.m2027a(this.f1401X, abstractC0864pc, f2552af, setM4245h);
        Screen screen = minecraft.screen;
        if (screen instanceof AbstractC0153cQ) {
            AbstractC0153cQ abstractC0153cQ = (AbstractC0153cQ) screen;
            if (this.f1401X.equals(minecraft.getUser().getProfileId())) {
                C0155cS c0155cSM846a = abstractC0153cQ.m846a();
                C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(this.f1401X);
                if (c0155cSM846a != null && c0872pkM4229a != null && c0155cSM846a.m855a() != null) {
                    C1098tx c1098txM4296a = c0872pkM4229a.m4296a(abstractC0863pb);
                    this.f2564cD = C0419hH.m1968c("textures/skins/game/nations/" + c1098txM4296a.m6179a().m6157av() + "/" + c1098txM4296a.getSkin() + "/" + c0155cSM846a.m859a().getKey() + ".png");
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1869a(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, @Nullable LocalPlayer localPlayer, @NotNull Player player) {
        if (!z) {
            this.f1417pj = this.f1416pi;
            this.f1416pi = Mth.lerp(0.5f, this.f1416pi, this.f2568fb);
            int i = this.f2567kc;
            this.f2567kc = i + 1;
            if (i >= 10) {
                m1870a(abstractC0863pb, localPlayer, player);
                this.f2567kc = 0;
                return;
            }
            return;
        }
        this.f1417pj = 0.0f;
        this.f1416pi = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private void m1870a(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @Nullable LocalPlayer localPlayer, @NotNull Player player) {
        if (localPlayer != null && m1871a(abstractC0863pb, localPlayer, player)) {
            this.f2568fb = C1270xJ.m7186b((Entity) localPlayer, (Entity) player);
        } else {
            this.f2568fb = 0.0f;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1871a(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull Player player) {
        if (!m1128aR() || !localPlayer.hasLineOfSight(player)) {
            return false;
        }
        ItemStack mainHandItem = player.getMainHandItem();
        if (mainHandItem.isEmpty() || !(mainHandItem.getItem() instanceof C1117uP) || !C1117uP.m6261d(mainHandItem)) {
            return false;
        }
        if (abstractC0863pb != null) {
            AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
            C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(localPlayer.getUUID());
            return c0872pkM4229a == null || !c0872pkM4229a.equals(abstractC0866peM4018b.m4229a(this.f1401X));
        }
        return true;
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public ResourceLocation m1872l() {
        return this.f2564cD;
    }

    @Nullable
    /* JADX INFO: renamed from: m */
    public ResourceLocation m1873m() {
        return this.f2565cE;
    }

    /* JADX INFO: renamed from: b */
    public void m1874b(@NotNull EnumC0883pv enumC0883pv) {
        this.f2556jZ = 300;
        this.f2557a = enumC0883pv;
        ResourceLocation waypointTexture = enumC0883pv.getWaypointTexture();
        if (waypointTexture != null) {
            this.f2553cC = waypointTexture;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public EnumC0883pv m1875a() {
        return this.f2557a;
    }

    /* JADX INFO: renamed from: at */
    public int m1876at() {
        return this.f2556jZ;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0516iz m1877a() {
        return this.f2559a;
    }

    /* JADX INFO: renamed from: a */
    public void m1878a(@NotNull C0516iz c0516iz) {
        this.f2559a = c0516iz;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SimpleSoundInstance m1879a() {
        return this.f2562a;
    }

    /* JADX INFO: renamed from: a */
    public void m1880a(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f2562a = simpleSoundInstance;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public SimpleSoundInstance m1881b() {
        return this.f2563b;
    }

    /* JADX INFO: renamed from: b */
    public void m1882b(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f2563b = simpleSoundInstance;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1883b(@NotNull LocalPlayer localPlayer) {
        return (localPlayer.isCreative() || localPlayer.isSpectator()) ? false : true;
    }
}
