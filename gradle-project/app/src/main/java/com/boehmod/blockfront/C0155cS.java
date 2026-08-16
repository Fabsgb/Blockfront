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

/* JADX INFO: renamed from: com.boehmod.blockfront.cS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cS.class */
public final class C0155cS extends AbstractC0298et {

    /* JADX INFO: renamed from: aY */
    @NotNull
    private static final ResourceLocation f1208aY = C0532jO.m2378d("textures/gui/game/loadout/challenge.png");

    /* JADX INFO: renamed from: E */
    @NotNull
    private final ObjectList<C0837pB> f1209E;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1093ts f1210a;

    /* JADX INFO: renamed from: fs */
    private final int f1211fs;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final String[] f1212b;

    /* JADX INFO: renamed from: ft */
    private final int f1213ft;

    /* JADX INFO: renamed from: fu */
    private final int f1214fu;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0153cQ<?, ?> f1219a;

    /* JADX INFO: renamed from: fv */
    private int f1215fv = 0;

    /* JADX INFO: renamed from: be */
    private boolean f1216be = false;

    /* JADX INFO: renamed from: bf */
    private boolean f1220bf = false;

    /* JADX INFO: renamed from: bg */
    private boolean f1221bg = false;

    /* JADX INFO: renamed from: dM */
    private float f1217dM = 1.0f;

    /* JADX INFO: renamed from: dN */
    private float f1218dN = 1.0f;

    public C0155cS(@NotNull AbstractC0153cQ<?, ?> abstractC0153cQ, @NotNull C1093ts c1093ts, @NotNull ObjectList<C0837pB> objectList, @NotNull String[] strArr, int i, int i2, int i3) {
        this.f1219a = abstractC0153cQ;
        this.f1209E = objectList;
        this.f1210a = c1093ts;
        this.f1213ft = i;
        this.f1214fu = i2;
        this.f1212b = strArr;
        this.f1211fs = i3;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        int iIntValue;
        super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        if (minecraft.player == null || (abstractC0864pcM2878a = c0623l.m2878a()) == null) {
            return;
        }
        float gameTimeDeltaPartialTick = minecraft.getTimer().getGameTimeDeltaPartialTick(true);
        this.f1216be = m1615E();
        float fM7170f = C1270xJ.m7170f(this.f1217dM, this.f1218dN, gameTimeDeltaPartialTick);
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        boolean z = c0555jlM1886a.getExpForClass(this.f1210a.m6011cc()) >= ((C0837pB) this.f1209E.get(this.f1215fv)).m3818bA();
        int i3 = z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_BLACK_SOLID + C0129bt.f861cu;
        if (this.f1216be) {
            C0129bt.m517a(guiGraphics, this.f2339iY, (this.f2340iZ + this.f1214fu) - 1, this.f1213ft, 1, i3, 1.0f - fM7170f);
        }
        if (abstractC0864pcM2878a.m4158a().m4018b().m4229a(minecraft.player.getUUID()) == null) {
            return;
        }
        this.f1220bf = m867a(c0555jlM1886a);
        this.f1221bg = m868b(c0555jlM1886a);
        if (z) {
            iIntValue = this.f1221bg ? ColorReferences.COLOR_THEME_YELLOW : ChatFormatting.GRAY.getColor().intValue();
        } else {
            iIntValue = ColorReferences.COLOR_BLACK_SOLID + C0129bt.f861cu;
        }
        MutableComponent mutableComponentAppend = Component.translatable(this.f1210a.m6004as()).append(" ").append(Component.translatable("enchantment.level." + (this.f1215fv + 1)).withColor(iIntValue));
        int i4 = this.f1221bg ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        C0129bt.m469a(poseStack, font, guiGraphics, (Component) mutableComponentAppend, this.f2339iY + 5 + (15.0f * fM7170f), this.f2340iZ + 7, i4);
        C0129bt.m537a(poseStack, guiGraphics, this.f1210a.getIcon(), this.f2339iY + 2, this.f2340iZ + 2, 16, 16, 0.0f, fM7170f, i4);
        if (this.f1220bf) {
            C0129bt.m531a(poseStack, guiGraphics, f1208aY, this.f2339iY + 2, this.f2340iZ + 2, 4, 4);
        }
    }

    /* JADX INFO: renamed from: a */
    public C0837pB m855a() {
        return (C0837pB) this.f1209E.get(this.f1215fv);
    }

    /* JADX INFO: renamed from: f */
    public List<C0837pB> m856f() {
        return this.f1209E;
    }

    /* JADX INFO: renamed from: C */
    public int m857C() {
        return this.f1211fs;
    }

    /* JADX INFO: renamed from: a */
    public String[] m858a() {
        return this.f1212b;
    }

    /* JADX INFO: renamed from: a */
    public C1093ts m859a() {
        return this.f1210a;
    }

    /* JADX INFO: renamed from: D */
    public int m860D() {
        return this.f1215fv;
    }

    /* JADX INFO: renamed from: u */
    public boolean m861u() {
        return this.f1220bf;
    }

    /* JADX INFO: renamed from: v */
    public boolean m862v() {
        return this.f1221bg;
    }

    /* JADX INFO: renamed from: V */
    public void m863V() {
        this.f1215fv++;
        if (this.f1215fv >= this.f1209E.size()) {
            this.f1215fv = 0;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
        this.f1218dN = this.f1217dM;
        this.f1217dM = Mth.lerp(0.8f, this.f1217dM, this.f1216be ? 0.0f : 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return this.f1214fu;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f1213ft;
    }

    /* JADX INFO: renamed from: a */
    private boolean m867a(@NotNull C0555jl c0555jl) {
        int expForClass = c0555jl.getExpForClass(this.f1210a.m6011cc());
        HashSet hashSet = new HashSet();
        ObjectListIterator it = this.f1209E.iterator();
        while (it.hasNext()) {
            C0837pB c0837pB = (C0837pB) it.next();
            if (expForClass >= c0837pB.m3818bA()) {
                ItemStack itemStackM3824e = c0837pB.m3824e();
                if (itemStackM3824e != null) {
                    Item item = itemStackM3824e.getItem();
                    if (item instanceof C1117uP) {
                        C1117uP c1117uP = (C1117uP) item;
                        if (c1117uP.m6398a() != null) {
                            hashSet.add(c1117uP.m6398a());
                        }
                    }
                }
                ItemStack itemStackM3825f = c0837pB.m3825f();
                if (itemStackM3825f != null) {
                    Item item2 = itemStackM3825f.getItem();
                    if (item2 instanceof C1117uP) {
                        C1117uP c1117uP2 = (C1117uP) item2;
                        if (c1117uP2.m6398a() != null) {
                            hashSet.add(c1117uP2.m6398a());
                        }
                    }
                }
            }
        }
        ObjectListIterator it2 = c0555jl.getChallenges().iterator();
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
    private boolean m868b(@NotNull C0555jl c0555jl) {
        C0837pB c0837pB = (C0837pB) this.f1209E.get(this.f1215fv);
        if (c0555jl.getExpForClass(this.f1210a.m6011cc()) < c0837pB.m3818bA()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        ItemStack itemStackM3824e = c0837pB.m3824e();
        if (itemStackM3824e != null) {
            Item item = itemStackM3824e.getItem();
            if (item instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) item;
                if (c1117uP.m6398a() != null) {
                    hashSet.add(c1117uP.m6398a());
                }
            }
        }
        ItemStack itemStackM3825f = c0837pB.m3825f();
        if (itemStackM3825f != null) {
            Item item2 = itemStackM3825f.getItem();
            if (item2 instanceof C1117uP) {
                C1117uP c1117uP2 = (C1117uP) item2;
                if (c1117uP2.m6398a() != null) {
                    hashSet.add(c1117uP2.m6398a());
                }
            }
        }
        ObjectListIterator it = c0555jl.getChallenges().iterator();
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
    public static boolean m869a(@NotNull GunType gunType, @NotNull C0555jl c0555jl) {
        ObjectListIterator it = c0555jl.getChallenges().iterator();
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
    public static boolean m870a(@NotNull ItemStack itemStack, @NotNull C0555jl c0555jl) {
        Item item = itemStack.getItem();
        if (!(item instanceof C1117uP)) {
            return false;
        }
        C1117uP c1117uP = (C1117uP) item;
        if (c1117uP.m6398a() != null) {
            return m869a(c1117uP.m6398a(), c0555jl);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
        if (i3 == 0) {
            this.f1219a.mo851a(this);
        } else {
            m863V();
        }
    }
}
