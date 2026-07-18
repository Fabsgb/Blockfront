package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.challenge.Challenge;
import com.boehmod.bflib.cloud.common.player.challenge.GunType;
import com.boehmod.bflib.cloud.common.player.challenge.WeaponTypeKillChallenge;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.HashSet;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cJ.class */
public final class C0145cJ extends AbstractC0284eg {

    /* JADX INFO: renamed from: ba */
    @NotNull
    private static final ResourceLocation f1118ba = C0564jv.m2555d("textures/gui/game/loadout/challenge.png");

    /* JADX INFO: renamed from: v */
    @NotNull
    private final ObjectList<C0866pf> f1119v;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1015sV f1120a;

    /* JADX INFO: renamed from: es */
    private final int f1121es;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final String[] f1122a;

    /* JADX INFO: renamed from: et */
    private final int f1123et;

    /* JADX INFO: renamed from: eu */
    private final int f1124eu;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0143cH<?, ?> f1129a;

    /* JADX INFO: renamed from: ev */
    private int f1125ev = 0;

    /* JADX INFO: renamed from: ba */
    private boolean f1126ba = false;

    /* JADX INFO: renamed from: bb */
    private boolean f1130bb = false;

    /* JADX INFO: renamed from: bc */
    private boolean f1131bc = false;

    /* JADX INFO: renamed from: dJ */
    private float f1127dJ = 1.0f;

    /* JADX INFO: renamed from: dK */
    private float f1128dK = 1.0f;

    public C0145cJ(@NotNull AbstractC0143cH<?, ?> abstractC0143cH, @NotNull C1015sV c1015sV, @NotNull ObjectList<C0866pf> objectList, @NotNull String[] strArr, int i, int i2, int i3) {
        this.f1129a = abstractC0143cH;
        this.f1119v = objectList;
        this.f1120a = c1015sV;
        this.f1123et = i;
        this.f1124eu = i2;
        this.f1122a = strArr;
        this.f1121es = i3;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        int iIntValue;
        super.mo800a(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f, f2);
        if (minecraft.player == null || (abstractC0788oGM2692a = c0622l.m2692a()) == null) {
            return;
        }
        float gameTimeDeltaPartialTick = minecraft.getTimer().getGameTimeDeltaPartialTick(true);
        this.f1126ba = m1499D();
        float fM7843e = C1290xm.m7843e(this.f1127dJ, this.f1128dK, gameTimeDeltaPartialTick);
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        boolean z = c0482iSM1676a.getExpForClass(this.f1120a.m5523bN()) >= ((C0866pf) this.f1119v.get(this.f1125ev)).m4333bl();
        int i3 = z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_BLACK_SOLID + C0119bk.f726bC;
        if (this.f1126ba) {
            C0119bk.m417a(guiGraphics, this.f2166hI, (this.f2167hJ + this.f1124eu) - 1, this.f1123et, 1, i3, 1.0f - fM7843e);
        }
        if (abstractC0788oGM2692a.m3722a().m3582b().m3793a(minecraft.player.getUUID()) == null) {
            return;
        }
        this.f1130bb = m813a(c0482iSM1676a);
        this.f1131bc = m814b(c0482iSM1676a);
        if (z) {
            iIntValue = this.f1131bc ? ColorReferences.COLOR_THEME_YELLOW : ChatFormatting.GRAY.getColor().intValue();
        } else {
            iIntValue = ColorReferences.COLOR_BLACK_SOLID + C0119bk.f726bC;
        }
        MutableComponent mutableComponentAppend = Component.translatable(this.f1120a.m5516al()).append(" ").append(Component.translatable("enchantment.level." + (this.f1125ev + 1)).withColor(iIntValue));
        int i4 = this.f1131bc ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        C0119bk.m369a(poseStack, font, guiGraphics, (Component) mutableComponentAppend, this.f2166hI + 5 + (15.0f * fM7843e), this.f2167hJ + 7, i4);
        C0119bk.m437a(poseStack, guiGraphics, this.f1120a.getIcon(), this.f2166hI + 2, this.f2167hJ + 2, 16, 16, 0.0f, fM7843e, i4);
        if (this.f1130bb) {
            C0119bk.m431a(poseStack, guiGraphics, f1118ba, this.f2166hI + 2, this.f2167hJ + 2, 4, 4);
        }
    }

    /* JADX INFO: renamed from: a */
    public C0866pf m801a() {
        return (C0866pf) this.f1119v.get(this.f1125ev);
    }

    /* JADX INFO: renamed from: e */
    public List<C0866pf> m802e() {
        return this.f1119v;
    }

    /* JADX INFO: renamed from: y */
    public int m803y() {
        return this.f1121es;
    }

    /* JADX INFO: renamed from: a */
    public String[] m804a() {
        return this.f1122a;
    }

    /* JADX INFO: renamed from: a */
    public C1015sV m805a() {
        return this.f1120a;
    }

    /* JADX INFO: renamed from: z */
    public int m806z() {
        return this.f1125ev;
    }

    /* JADX INFO: renamed from: t */
    public boolean m807t() {
        return this.f1130bb;
    }

    /* JADX INFO: renamed from: u */
    public boolean m808u() {
        return this.f1131bc;
    }

    /* JADX INFO: renamed from: R */
    public void m809R() {
        this.f1125ev++;
        if (this.f1125ev >= this.f1119v.size()) {
            this.f1125ev = 0;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
        this.f1128dK = this.f1127dJ;
        this.f1127dJ = Mth.lerp(0.8f, this.f1127dJ, this.f1126ba ? 0.0f : 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return this.f1124eu;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: t */
    public int mo812t() {
        return this.f1123et;
    }

    /* JADX INFO: renamed from: a */
    private boolean m813a(@NotNull C0482iS c0482iS) {
        int expForClass = c0482iS.getExpForClass(this.f1120a.m5523bN());
        HashSet hashSet = new HashSet();
        ObjectListIterator it = this.f1119v.iterator();
        while (it.hasNext()) {
            C0866pf c0866pf = (C0866pf) it.next();
            if (expForClass >= c0866pf.m4333bl()) {
                ItemStack itemStackM4339c = c0866pf.m4339c();
                if (itemStackM4339c != null) {
                    Item item = itemStackM4339c.getItem();
                    if (item instanceof C1144ur) {
                        C1144ur c1144ur = (C1144ur) item;
                        if (c1144ur.m6420a() != null) {
                            hashSet.add(c1144ur.m6420a());
                        }
                    }
                }
                ItemStack itemStackM4340d = c0866pf.m4340d();
                if (itemStackM4340d != null) {
                    Item item2 = itemStackM4340d.getItem();
                    if (item2 instanceof C1144ur) {
                        C1144ur c1144ur2 = (C1144ur) item2;
                        if (c1144ur2.m6420a() != null) {
                            hashSet.add(c1144ur2.m6420a());
                        }
                    }
                }
            }
        }
        ObjectListIterator it2 = c0482iS.getChallenges().iterator();
        while (it2.hasNext()) {
            Challenge challenge = (Challenge) it2.next();
            if (challenge instanceof WeaponTypeKillChallenge) {
                WeaponTypeKillChallenge weaponTypeKillChallenge = (WeaponTypeKillChallenge) challenge;
                if (!weaponTypeKillChallenge.isCompleted() && hashSet.contains(weaponTypeKillChallenge.getGunType())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private boolean m814b(@NotNull C0482iS c0482iS) {
        C0866pf c0866pf = (C0866pf) this.f1119v.get(this.f1125ev);
        if (c0482iS.getExpForClass(this.f1120a.m5523bN()) < c0866pf.m4333bl()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        ItemStack itemStackM4339c = c0866pf.m4339c();
        if (itemStackM4339c != null) {
            Item item = itemStackM4339c.getItem();
            if (item instanceof C1144ur) {
                C1144ur c1144ur = (C1144ur) item;
                if (c1144ur.m6420a() != null) {
                    hashSet.add(c1144ur.m6420a());
                }
            }
        }
        ItemStack itemStackM4340d = c0866pf.m4340d();
        if (itemStackM4340d != null) {
            Item item2 = itemStackM4340d.getItem();
            if (item2 instanceof C1144ur) {
                C1144ur c1144ur2 = (C1144ur) item2;
                if (c1144ur2.m6420a() != null) {
                    hashSet.add(c1144ur2.m6420a());
                }
            }
        }
        ObjectListIterator it = c0482iS.getChallenges().iterator();
        while (it.hasNext()) {
            Challenge challenge = (Challenge) it.next();
            if (challenge instanceof WeaponTypeKillChallenge) {
                WeaponTypeKillChallenge weaponTypeKillChallenge = (WeaponTypeKillChallenge) challenge;
                if (!weaponTypeKillChallenge.isCompleted() && hashSet.contains(weaponTypeKillChallenge.getGunType())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m815a(@NotNull GunType gunType, @NotNull C0482iS c0482iS) {
        ObjectListIterator it = c0482iS.getChallenges().iterator();
        while (it.hasNext()) {
            Challenge challenge = (Challenge) it.next();
            if (challenge instanceof WeaponTypeKillChallenge) {
                WeaponTypeKillChallenge weaponTypeKillChallenge = (WeaponTypeKillChallenge) challenge;
                if (!weaponTypeKillChallenge.isCompleted() && gunType.equals(weaponTypeKillChallenge.getGunType())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m816a(@NotNull ItemStack itemStack, @NotNull C0482iS c0482iS) {
        Item item = itemStack.getItem();
        if (!(item instanceof C1144ur)) {
            return false;
        }
        C1144ur c1144ur = (C1144ur) item;
        if (c1144ur.m6420a() != null) {
            return m815a(c1144ur.m6420a(), c0482iS);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
        if (i3 == 0) {
            this.f1129a.mo797a(this);
        } else {
            m809R();
        }
    }
}
