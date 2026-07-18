package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.fT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fT.class */
public class C0324fT extends AbstractC0182b<C0622l, Level, Player, C0251e> {

    /* JADX INFO: renamed from: X */
    @NotNull
    private static final String f2356X = "textures/skins/game/nations/";

    /* JADX INFO: renamed from: Y */
    @NotNull
    public static final String f2357Y = "backpack";

    /* JADX INFO: renamed from: cC */
    @NotNull
    private ResourceLocation f2358cC;

    /* JADX INFO: renamed from: iC */
    private int f2359iC;

    /* JADX INFO: renamed from: iD */
    private static final int f2360iD = 300;

    /* JADX INFO: renamed from: iE */
    private int f2361iE;

    /* JADX INFO: renamed from: a */
    @Nullable
    private EnumC0807oZ f2362a;

    /* JADX INFO: renamed from: iF */
    private int f2363iF;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0498ii f2364a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0491ib f2365a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Item f2366a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private SimpleSoundInstance f2367a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private SimpleSoundInstance f2368b;

    /* JADX INFO: renamed from: cD */
    @Nullable
    private ResourceLocation f2369cD;

    /* JADX INFO: renamed from: cE */
    @Nullable
    private ResourceLocation f2370cE;

    /* JADX INFO: renamed from: iG */
    private int f2371iG;

    /* JADX INFO: renamed from: iH */
    private int f2372iH;

    /* JADX INFO: renamed from: eV */
    private float f2373eV;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0327fW<Player> f2374a;

    public C0324fT(@NotNull UUID uuid) {
        super(uuid);
        this.f2358cC = EnumC0807oZ.MEDIC.getTexture();
        this.f2359iC = 0;
        this.f2361iE = 0;
        this.f2362a = null;
        this.f2363iF = 0;
        this.f2366a = null;
        this.f2371iG = 0;
        this.f2372iH = 0;
        this.f2373eV = 0.0f;
        this.f2374a = new C0327fW<>();
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0182b
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0251e mo1078a() {
        return new C0251e(this);
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public ResourceLocation m1644j() {
        return this.f2358cC;
    }

    /* JADX INFO: renamed from: l */
    public void m1645l(int i) {
        this.f2359iC = i;
    }

    /* JADX INFO: renamed from: af */
    public int m1646af() {
        return this.f2359iC;
    }

    /* JADX INFO: renamed from: a */
    private void m1647a(@NotNull Player player) {
        if (this.f1498js) {
            player.zza = 0.0f;
            player.xxa = 0.0f;
        }
    }

    /* JADX INFO: renamed from: aH */
    private void m1648aH() {
        this.f1493oj = this.f1492oi;
        this.f1492oi = Mth.lerp(0.4f, this.f1492oi, 0.0f);
        if (this.f2361iE > 0) {
            this.f2361iE--;
            if (this.f2361iE == 0) {
                this.f2362a = null;
            }
        }
        if (this.f2359iC > 0) {
            this.f2359iC--;
        }
    }

    /* JADX INFO: renamed from: aI */
    public void m1649aI() {
        this.f2374a.m1678aI();
    }

    /* JADX INFO: renamed from: N */
    public boolean m1650N() {
        return this.f2374a.m1679O();
    }

    /* JADX INFO: renamed from: a */
    public void m1651a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @Nullable AbstractC0788oG<?, ?> abstractC0788oG, @NotNull Player player) {
        boolean zEquals = player.equals(localPlayer);
        ((C0251e) this.f1513a).m1423a(clientLevel, player, random);
        if (this.f1491td > 0) {
            this.f1491td--;
        }
        if (C0799oR.m4052a(player, this)) {
            this.f2363iF = 10;
        } else if (this.f2363iF > 0) {
            this.f2363iF--;
        }
        m1647a(player);
        m1648aH();
        this.f2374a.m1677a(zEquals, localPlayer, player);
        m1659a(abstractC0787oF, zEquals, localPlayer, player);
        m1655a(minecraft, abstractC0787oF, abstractC0788oG);
        m1654a(minecraft, player, zEquals);
    }

    /* JADX INFO: renamed from: ag */
    public int m1652ag() {
        return this.f2363iF;
    }

    /* JADX INFO: renamed from: m */
    public void m1653m(int i) {
        this.f2363iF = i;
    }

    /* JADX INFO: renamed from: a */
    private void m1654a(@NotNull Minecraft minecraft, @NotNull Player player, boolean z) {
        C1146ut c1146ut;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6428o;
        if (player instanceof C0099bQ) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        C1146ut item = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if (item != this.f2366a) {
            this.f2366a = item;
            if (this.f2365a != null && soundManager.isActive(this.f2365a)) {
                soundManager.stop(this.f2365a);
                this.f2365a = null;
            }
            if ((item instanceof C1146ut) && (deferredHolderM6428o = (c1146ut = item).m6428o()) != null) {
                this.f2365a = new C0491ib(player, (SoundEvent) deferredHolderM6428o.get(), SoundSource.PLAYERS, c1146ut.m6427cC(), z ? 0.1f : 0.25f);
                soundManager.play(this.f2365a);
            }
        }
        if ((this.f2366a == null || this.f2366a == Items.AIR) && this.f2365a != null && soundManager.isActive(this.f2365a)) {
            soundManager.stop(this.f2365a);
            this.f2365a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1655a(@NotNull Minecraft minecraft, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @Nullable AbstractC0788oG<?, ?> abstractC0788oG) {
        if (mo1078a() == PlayerDataType.DISPLAY) {
            return;
        }
        int i = this.f2371iG;
        this.f2371iG = i - 1;
        if (i <= 0) {
            this.f2371iG = 80;
            if (abstractC0787oF != null && abstractC0788oG != null) {
                m1658b(minecraft, abstractC0787oF, abstractC0788oG);
            } else {
                this.f2369cD = null;
                this.f2370cE = null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1656a(@Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2) {
        this.f2369cD = resourceLocation;
        this.f2370cE = resourceLocation2;
    }

    /* JADX INFO: renamed from: aJ */
    public void m1657aJ() {
        this.f2371iG = 0;
    }

    /* JADX INFO: renamed from: b */
    private void m1658b(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG) {
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
        Set<UUID> setM3809h = abstractC0790oIM3582b.m3809h();
        int iM3854a = abstractC0787oF.m3598a(this.f1479V).m3854a(C1089tp.f5692i.getKey(), -1);
        this.f2369cD = C0371gN.m1771a(this.f1479V, abstractC0788oG, iM3854a != -1 ? C1015sV.m5528a(iM3854a).getKey() : "rifleman", setM3809h);
        this.f2370cE = C0371gN.m1771a(this.f1479V, abstractC0788oG, f2357Y, setM3809h);
        Screen screen = minecraft.screen;
        if (screen instanceof AbstractC0143cH) {
            AbstractC0143cH abstractC0143cH = (AbstractC0143cH) screen;
            if (this.f1479V.equals(minecraft.getUser().getProfileId())) {
                C0145cJ c0145cJM792a = abstractC0143cH.m792a();
                C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(this.f1479V);
                if (c0145cJM792a != null && c0796oOM3793a != null && c0145cJM792a.m801a() != null) {
                    C1074ta c1074taM3860a = c0796oOM3793a.m3860a(abstractC0787oF);
                    this.f2369cD = C0454hr.m2066c("textures/skins/game/nations/" + c1074taM3860a.m5976a().m5669ao() + "/" + c1074taM3860a.getSkin() + "/" + c0145cJM792a.m805a().getKey() + ".png");
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1659a(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, @Nullable LocalPlayer localPlayer, @NotNull Player player) {
        if (!z) {
            this.f1495ol = this.f1494ok;
            this.f1494ok = Mth.lerp(0.5f, this.f1494ok, this.f2373eV);
            int i = this.f2372iH;
            this.f2372iH = i + 1;
            if (i >= 10) {
                m1660a(abstractC0787oF, localPlayer, player);
                this.f2372iH = 0;
                return;
            }
            return;
        }
        this.f1495ol = 0.0f;
        this.f1494ok = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private void m1660a(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @Nullable LocalPlayer localPlayer, @NotNull Player player) {
        if (localPlayer != null && m1661a(abstractC0787oF, localPlayer, player)) {
            this.f2373eV = C1290xm.m7859b((Entity) localPlayer, (Entity) player);
        } else {
            this.f2373eV = 0.0f;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1661a(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull Player player) {
        if (!m1111aG() || !localPlayer.hasLineOfSight(player)) {
            return false;
        }
        ItemStack mainHandItem = player.getMainHandItem();
        if (mainHandItem.isEmpty() || !(mainHandItem.getItem() instanceof C1144ur) || !C1144ur.m6297d(mainHandItem)) {
            return false;
        }
        if (abstractC0787oF != null) {
            AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
            C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(localPlayer.getUUID());
            return c0796oOM3793a == null || !c0796oOM3793a.equals(abstractC0790oIM3582b.m3793a(this.f1479V));
        }
        return true;
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public ResourceLocation m1662k() {
        return this.f2369cD;
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public ResourceLocation m1663l() {
        return this.f2370cE;
    }

    /* JADX INFO: renamed from: b */
    public void m1664b(@NotNull EnumC0807oZ enumC0807oZ) {
        this.f2361iE = 300;
        this.f2362a = enumC0807oZ;
        ResourceLocation waypointTexture = enumC0807oZ.getWaypointTexture();
        if (waypointTexture != null) {
            this.f2358cC = waypointTexture;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public EnumC0807oZ m1665a() {
        return this.f2362a;
    }

    /* JADX INFO: renamed from: ah */
    public int m1666ah() {
        return this.f2361iE;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0498ii m1667a() {
        return this.f2364a;
    }

    /* JADX INFO: renamed from: a */
    public void m1668a(@NotNull C0498ii c0498ii) {
        this.f2364a = c0498ii;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SimpleSoundInstance m1669a() {
        return this.f2367a;
    }

    /* JADX INFO: renamed from: a */
    public void m1670a(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f2367a = simpleSoundInstance;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public SimpleSoundInstance m1671b() {
        return this.f2368b;
    }

    /* JADX INFO: renamed from: b */
    public void m1672b(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f2368b = simpleSoundInstance;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1673b(@NotNull LocalPlayer localPlayer) {
        return (localPlayer.isCreative() || localPlayer.isSpectator()) ? false : true;
    }
}
