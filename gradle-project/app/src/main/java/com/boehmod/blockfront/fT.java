package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerDataType;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fT.class */
public class fT extends com.boehmod.blockfront.common.player.b<C0297l, Level, Player, C0109e> {

    @NotNull
    private static final String X = "textures/skins/game/nations/";

    @NotNull
    public static final String Y = "backpack";

    @NotNull
    private ResourceLocation cC;
    private int iC;
    private static final int iD = 300;
    private int iE;

    @Nullable
    private oZ a;
    private int iF;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private C0225ii f126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private C0219ib f127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private Item f128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private SimpleSoundInstance f129a;

    @Nullable
    private SimpleSoundInstance b;

    @Nullable
    private ResourceLocation cD;

    @Nullable
    private ResourceLocation cE;
    private int iG;
    private int iH;
    private float eV;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final fW<Player> f130a;

    public fT(@NotNull UUID uuid) {
        super(uuid);
        this.cC = oZ.MEDIC.getTexture();
        this.iC = 0;
        this.iE = 0;
        this.a = null;
        this.iF = 0;
        this.f128a = null;
        this.iG = 0;
        this.iH = 0;
        this.eV = 0.0f;
        this.f130a = new fW<>();
    }

    @Override // com.boehmod.blockfront.common.player.b
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0109e mo300a() {
        return new C0109e(this);
    }

    @NotNull
    public ResourceLocation j() {
        return this.cC;
    }

    public void l(int i) {
        this.iC = i;
    }

    public int af() {
        return this.iC;
    }

    private void a(@NotNull Player player) {
        if (this.js) {
            player.zza = 0.0f;
            player.xxa = 0.0f;
        }
    }

    private void aH() {
        this.oj = this.oi;
        this.oi = Mth.lerp(0.4f, this.oi, 0.0f);
        if (this.iE > 0) {
            this.iE--;
            if (this.iE == 0) {
                this.a = null;
            }
        }
        if (this.iC > 0) {
            this.iC--;
        }
    }

    public void aI() {
        this.f130a.aI();
    }

    public boolean N() {
        return this.f130a.O();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @Nullable oF<?, ?, ?> oFVar, @Nullable oG<?, ?> oGVar, @NotNull Player player) {
        boolean zEquals = player.equals(localPlayer);
        ((C0109e) this.f104a).a(clientLevel, player, random);
        if (this.td > 0) {
            this.td--;
        }
        if (oR.a(player, this)) {
            this.iF = 10;
        } else if (this.iF > 0) {
            this.iF--;
        }
        a(player);
        aH();
        this.f130a.a(zEquals, localPlayer, player);
        a(oFVar, zEquals, localPlayer, player);
        a(minecraft, oFVar, oGVar);
        a(minecraft, player, zEquals);
    }

    public int ag() {
        return this.iF;
    }

    public void m(int i) {
        this.iF = i;
    }

    private void a(@NotNull Minecraft minecraft, @NotNull Player player, boolean z) {
        C0560ut c0560ut;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderO;
        if (player instanceof bQ) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        C0560ut item = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if (item != this.f128a) {
            this.f128a = item;
            if (this.f127a != null && soundManager.isActive(this.f127a)) {
                soundManager.stop(this.f127a);
                this.f127a = null;
            }
            if ((item instanceof C0560ut) && (deferredHolderO = (c0560ut = item).o()) != null) {
                this.f127a = new C0219ib(player, (SoundEvent) deferredHolderO.get(), SoundSource.PLAYERS, c0560ut.cC(), z ? 0.1f : 0.25f);
                soundManager.play(this.f127a);
            }
        }
        if ((this.f128a == null || this.f128a == Items.AIR) && this.f127a != null && soundManager.isActive(this.f127a)) {
            soundManager.stop(this.f127a);
            this.f127a = null;
        }
    }

    private void a(@NotNull Minecraft minecraft, @Nullable oF<?, ?, ?> oFVar, @Nullable oG<?, ?> oGVar) {
        if (mo300a() == PlayerDataType.DISPLAY) {
            return;
        }
        int i = this.iG;
        this.iG = i - 1;
        if (i <= 0) {
            this.iG = 80;
            if (oFVar != null && oGVar != null) {
                b(minecraft, oFVar, oGVar);
            } else {
                this.cD = null;
                this.cE = null;
            }
        }
    }

    public void a(@Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2) {
        this.cD = resourceLocation;
        this.cE = resourceLocation2;
    }

    public void aJ() {
        this.iG = 0;
    }

    private void b(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar) {
        oI oIVarB = oFVar.b();
        Set<UUID> setH = oIVarB.h();
        int iA = oFVar.a(this.V).a(C0529tp.i.getKey(), -1);
        this.cD = gN.a(this.V, oGVar, iA != -1 ? sV.a(iA).getKey() : "rifleman", setH);
        this.cE = gN.a(this.V, oGVar, Y, setH);
        Screen screen = minecraft.screen;
        if (screen instanceof cH) {
            cH cHVar = (cH) screen;
            if (this.V.equals(minecraft.getUser().getProfileId())) {
                cJ cJVarA = cHVar.a();
                oO oOVarA = oIVarB.a(this.V);
                if (cJVarA != null && oOVarA != null && cJVarA.a() != null) {
                    C0514ta c0514taA = oOVarA.a(oFVar);
                    this.cD = C0208hr.c("textures/skins/game/nations/" + c0514taA.m1156a().ao() + "/" + c0514taA.getSkin() + "/" + cJVarA.m264a().getKey() + ".png");
                }
            }
        }
    }

    private void a(@Nullable oF<?, ?, ?> oFVar, boolean z, @Nullable LocalPlayer localPlayer, @NotNull Player player) {
        if (!z) {
            this.ol = this.ok;
            this.ok = Mth.lerp(0.5f, this.ok, this.eV);
            int i = this.iH;
            this.iH = i + 1;
            if (i >= 10) {
                a(oFVar, localPlayer, player);
                this.iH = 0;
                return;
            }
            return;
        }
        this.ol = 0.0f;
        this.ok = 0.0f;
    }

    private void a(@Nullable oF<?, ?, ?> oFVar, @Nullable LocalPlayer localPlayer, @NotNull Player player) {
        if (localPlayer != null && m401a(oFVar, localPlayer, player)) {
            this.eV = C0634xm.b((Entity) localPlayer, (Entity) player);
        } else {
            this.eV = 0.0f;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m401a(@Nullable oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull Player player) {
        if (!aG() || !localPlayer.hasLineOfSight(player)) {
            return false;
        }
        ItemStack mainHandItem = player.getMainHandItem();
        if (mainHandItem.isEmpty() || !(mainHandItem.getItem() instanceof C0558ur) || !C0558ur.d(mainHandItem)) {
            return false;
        }
        if (oFVar != null) {
            oI oIVarB = oFVar.b();
            oO oOVarA = oIVarB.a(localPlayer.getUUID());
            return oOVarA == null || !oOVarA.equals(oIVarB.a(this.V));
        }
        return true;
    }

    @Nullable
    public ResourceLocation k() {
        return this.cD;
    }

    @Nullable
    public ResourceLocation l() {
        return this.cE;
    }

    public void b(@NotNull oZ oZVar) {
        this.iE = 300;
        this.a = oZVar;
        ResourceLocation waypointTexture = oZVar.getWaypointTexture();
        if (waypointTexture != null) {
            this.cC = waypointTexture;
        }
    }

    @Nullable
    public oZ a() {
        return this.a;
    }

    public int ah() {
        return this.iE;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0225ii m402a() {
        return this.f126a;
    }

    public void a(@NotNull C0225ii c0225ii) {
        this.f126a = c0225ii;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public SimpleSoundInstance m403a() {
        return this.f129a;
    }

    public void a(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f129a = simpleSoundInstance;
    }

    @Nullable
    public SimpleSoundInstance b() {
        return this.b;
    }

    public void b(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.b = simpleSoundInstance;
    }

    public static boolean b(@NotNull LocalPlayer localPlayer) {
        return (localPlayer.isCreative() || localPlayer.isSpectator()) ? false : true;
    }
}
