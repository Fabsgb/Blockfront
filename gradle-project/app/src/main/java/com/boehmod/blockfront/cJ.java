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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cJ.class */
public final class cJ extends AbstractC0116eg {

    @NotNull
    private static final ResourceLocation ba = C0265jv.d("textures/gui/game/loadout/challenge.png");

    @NotNull
    private final ObjectList<C0411pf> v;

    @NotNull
    private final sV a;
    private final int es;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final String[] f77a;
    private final int et;
    private final int eu;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final cH<?, ?> f79a;
    private int ev = 0;

    /* JADX INFO: renamed from: ba, reason: collision with other field name */
    private boolean f78ba = false;
    private boolean bb = false;
    private boolean bc = false;
    private float dJ = 1.0f;
    private float dK = 1.0f;

    public cJ(@NotNull cH<?, ?> cHVar, @NotNull sV sVVar, @NotNull ObjectList<C0411pf> objectList, @NotNull String[] strArr, int i, int i2, int i3) {
        this.f79a = cHVar;
        this.v = objectList;
        this.a = sVVar;
        this.et = i;
        this.eu = i2;
        this.f77a = strArr;
        this.es = i3;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        oG<?, ?> oGVarM593a;
        int iIntValue;
        super.a(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f, f2);
        if (minecraft.player == null || (oGVarM593a = c0297l.m593a()) == null) {
            return;
        }
        float gameTimeDeltaPartialTick = minecraft.getTimer().getGameTimeDeltaPartialTick(true);
        this.f78ba = D();
        float fE = C0634xm.e(this.dJ, this.dK, gameTimeDeltaPartialTick);
        iS iSVarM404a = fVVar.m404a(minecraft);
        boolean z = iSVarM404a.getExpForClass(this.a.bN()) >= ((C0411pf) this.v.get(this.ev)).bl();
        int i3 = z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_BLACK_SOLID + C0040bk.bC;
        if (this.f78ba) {
            C0040bk.a(guiGraphics, this.hI, (this.hJ + this.eu) - 1, this.et, 1, i3, 1.0f - fE);
        }
        if (oGVarM593a.m771a().b().a(minecraft.player.getUUID()) == null) {
            return;
        }
        this.bb = a(iSVarM404a);
        this.bc = b(iSVarM404a);
        if (z) {
            iIntValue = this.bc ? ColorReferences.COLOR_THEME_YELLOW : ChatFormatting.GRAY.getColor().intValue();
        } else {
            iIntValue = ColorReferences.COLOR_BLACK_SOLID + C0040bk.bC;
        }
        MutableComponent mutableComponentAppend = Component.translatable(this.a.al()).append(" ").append(Component.translatable("enchantment.level." + (this.ev + 1)).withColor(iIntValue));
        int i4 = this.bc ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        C0040bk.a(poseStack, font, guiGraphics, (Component) mutableComponentAppend, this.hI + 5 + (15.0f * fE), this.hJ + 7, i4);
        C0040bk.a(poseStack, guiGraphics, this.a.getIcon(), this.hI + 2, this.hJ + 2, 16, 16, 0.0f, fE, i4);
        if (this.bb) {
            C0040bk.a(poseStack, guiGraphics, ba, this.hI + 2, this.hJ + 2, 4, 4);
        }
    }

    public C0411pf a() {
        return (C0411pf) this.v.get(this.ev);
    }

    public List<C0411pf> e() {
        return this.v;
    }

    public int y() {
        return this.es;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String[] m263a() {
        return this.f77a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sV m264a() {
        return this.a;
    }

    public int z() {
        return this.ev;
    }

    public boolean t() {
        return this.bb;
    }

    public boolean u() {
        return this.bc;
    }

    public void R() {
        this.ev++;
        if (this.ev >= this.v.size()) {
            this.ev = 0;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
        this.dK = this.dJ;
        this.dJ = Mth.lerp(0.8f, this.dJ, this.f78ba ? 0.0f : 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int height() {
        return this.eu;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    /* JADX INFO: renamed from: t, reason: collision with other method in class */
    public int mo265t() {
        return this.et;
    }

    private boolean a(@NotNull iS iSVar) {
        int expForClass = iSVar.getExpForClass(this.a.bN());
        HashSet hashSet = new HashSet();
        ObjectListIterator it = this.v.iterator();
        while (it.hasNext()) {
            C0411pf c0411pf = (C0411pf) it.next();
            if (expForClass >= c0411pf.bl()) {
                ItemStack itemStackC = c0411pf.c();
                if (itemStackC != null) {
                    Item item = itemStackC.getItem();
                    if (item instanceof C0558ur) {
                        C0558ur c0558ur = (C0558ur) item;
                        if (c0558ur.m1226a() != null) {
                            hashSet.add(c0558ur.m1226a());
                        }
                    }
                }
                ItemStack itemStackD = c0411pf.d();
                if (itemStackD != null) {
                    Item item2 = itemStackD.getItem();
                    if (item2 instanceof C0558ur) {
                        C0558ur c0558ur2 = (C0558ur) item2;
                        if (c0558ur2.m1226a() != null) {
                            hashSet.add(c0558ur2.m1226a());
                        }
                    }
                }
            }
        }
        ObjectListIterator it2 = iSVar.getChallenges().iterator();
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

    private boolean b(@NotNull iS iSVar) {
        C0411pf c0411pf = (C0411pf) this.v.get(this.ev);
        if (iSVar.getExpForClass(this.a.bN()) < c0411pf.bl()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        ItemStack itemStackC = c0411pf.c();
        if (itemStackC != null) {
            Item item = itemStackC.getItem();
            if (item instanceof C0558ur) {
                C0558ur c0558ur = (C0558ur) item;
                if (c0558ur.m1226a() != null) {
                    hashSet.add(c0558ur.m1226a());
                }
            }
        }
        ItemStack itemStackD = c0411pf.d();
        if (itemStackD != null) {
            Item item2 = itemStackD.getItem();
            if (item2 instanceof C0558ur) {
                C0558ur c0558ur2 = (C0558ur) item2;
                if (c0558ur2.m1226a() != null) {
                    hashSet.add(c0558ur2.m1226a());
                }
            }
        }
        ObjectListIterator it = iSVar.getChallenges().iterator();
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

    public static boolean a(@NotNull GunType gunType, @NotNull iS iSVar) {
        ObjectListIterator it = iSVar.getChallenges().iterator();
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

    public static boolean a(@NotNull ItemStack itemStack, @NotNull iS iSVar) {
        Item item = itemStack.getItem();
        if (!(item instanceof C0558ur)) {
            return false;
        }
        C0558ur c0558ur = (C0558ur) item;
        if (c0558ur.m1226a() != null) {
            return a(c0558ur.m1226a(), iSVar);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
        if (i3 == 0) {
            this.f79a.a(this);
        } else {
            R();
        }
    }
}
