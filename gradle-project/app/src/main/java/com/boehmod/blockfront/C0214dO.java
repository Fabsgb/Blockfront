package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanDelete;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanLeave;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dO.class */
public class C0214dO extends AbstractC0217dR {

    /* JADX INFO: renamed from: hR */
    private static final int f1638hR = 30;

    /* JADX INFO: renamed from: fq */
    private static final Component f1639fq = Component.translatable("bf.profile.clan.none.title").withColor(ColorReferences.COLOR_THEME_CLANS_SOLID);

    /* JADX INFO: renamed from: fr */
    private static final Component f1640fr = Component.translatable("bf.message.prestige").append(" 1").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);

    /* JADX INFO: renamed from: fs */
    private static final Component f1641fs = Component.translatable("bf.profile.clan.none.description.self");

    /* JADX INFO: renamed from: ft */
    private static final Component f1642ft = Component.translatable("bf.profile.clan.none.description.requirement", new Object[]{f1640fr}).withStyle(ChatFormatting.DARK_GRAY);

    /* JADX INFO: renamed from: fu */
    private static final Component f1643fu = Component.translatable("bf.profile.clan.none.description");

    /* JADX INFO: renamed from: fv */
    private static final Component f1644fv = Component.translatable("bf.message.clan.invite");

    /* JADX INFO: renamed from: fw */
    private static final Component f1645fw = Component.translatable("bf.message.prompt.clan.invite.tip");

    /* JADX INFO: renamed from: fx */
    private static final Component f1646fx = Component.translatable("bf.message.clan.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: fy */
    private static final Component f1647fy = Component.translatable("bf.message.prompt.clan.kick.tip");

    /* JADX INFO: renamed from: fz */
    private static final Component f1648fz = Component.translatable("bf.message.clan.delete").withStyle(ChatFormatting.DARK_RED);

    /* JADX INFO: renamed from: fA */
    private static final Component f1649fA = Component.translatable("bf.message.prompt.clan.delete.tip");

    /* JADX INFO: renamed from: fB */
    private static final Component f1650fB = Component.translatable("bf.message.prompt.clan.delete.title");

    /* JADX INFO: renamed from: fC */
    private static final Component f1651fC = Component.translatable("bf.message.prompt.clan.delete");

    /* JADX INFO: renamed from: fD */
    private static final Component f1652fD = Component.translatable("bf.message.clan.leave").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: fE */
    private static final Component f1653fE = Component.translatable("bf.message.prompt.clan.leave.tip");

    /* JADX INFO: renamed from: fF */
    private static final Component f1654fF = Component.translatable("bf.message.prompt.clan.leave.title");

    /* JADX INFO: renamed from: fG */
    private static final Component f1655fG = Component.translatable("bf.message.prompt.clan.leave");

    /* JADX INFO: renamed from: fH */
    private static final Component f1656fH = Component.translatable("bf.message.clan.create");

    /* JADX INFO: renamed from: fI */
    private static final Component f1657fI = Component.translatable("bf.message.prompt.clan.create.tip");

    /* JADX INFO: renamed from: fJ */
    private static final Component f1658fJ = Component.translatable("bf.message.clan.information").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: hS */
    private int f1659hS;

    /* JADX INFO: renamed from: j */
    private C0085bB f1660j;

    /* JADX INFO: renamed from: k */
    private C0085bB f1661k;

    /* JADX INFO: renamed from: z */
    @NotNull
    private final List<C0085bB> f1662z;

    public C0214dO(@NotNull Screen screen, @NotNull C0555jl c0555jl) {
        super(screen, c0555jl, f1658fJ);
        this.f1659hS = 0;
        this.f1662z = new ObjectArrayList();
    }

    /* JADX INFO: renamed from: a */
    private void m1257a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData) {
        int i = this.width / 2;
        m1258a(guiGraphics, abstractClanData, 75, i);
        m1259a(poseStack, guiGraphics, abstractClanData, 75, i);
    }

    /* JADX INFO: renamed from: a */
    private void m1258a(@NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData, int i, int i2) {
        C0129bt.m483c(this.font, guiGraphics, (Component) Component.literal(abstractClanData.getName()).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID).append(Component.literal(" - ").withColor(ColorReferences.COLOR_WHITE)).append(f1658fJ).append(" ").append(Component.translatable("bf.profile.clan.skill.level", new Object[]{String.format("%.2f", Float.valueOf(C0548je.m2476a(this.f1056a, abstractClanData)))}).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID)), i2, i);
    }

    /* JADX INFO: renamed from: a */
    private void m1259a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData, int i, int i2) {
        Set<UUID> members = abstractClanData.getMembers();
        int size = members.size();
        int i3 = i + 15;
        int i4 = 60 * size;
        int i5 = 0;
        for (UUID uuid : members) {
            C0555jl c0555jlA = this.f1056a.mo1154a(uuid);
            GameProfile gameProfileM2522a = c0555jlA.m2522a();
            int i6 = (i2 - (i4 / 2)) + (60 * i5);
            m1260a(poseStack, guiGraphics, gameProfileM2522a, abstractClanData.getOwner().equals(uuid), i6, i3, 55, 30, 12);
            m1261a(guiGraphics, c0555jlA, i6, i3, 55);
            i5++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1260a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GameProfile gameProfile, boolean z, int i, int i2, int i3, int i4, int i5) {
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        C0550jg inventory = this.f1056a.mo1154a(gameProfile.getId()).getInventory();
        C0129bt.m515a(guiGraphics, i, i2, i3, i3, C0129bt.m465t());
        int i6 = i + i5;
        int i7 = (i2 + i5) - 5;
        C0129bt.m515a(guiGraphics, i6 - 1, i7 - 1, i4 + 2, i4 + 2, z ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        C0129bt.m585a(this.f1058a, this.f1057f, poseStack, guiGraphics, gameProfile, i6, i7, i4);
        CloudItemStack cloudItemStackM2487a = inventory.m2487a(CloudItemType.COIN);
        if (cloudItemStackM2487a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2487a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0564ju.m2556a(abstractCloudItemCoin).mo2310a(abstractCloudItemCoin, cloudItemStackM2487a, poseStack, this.f1058a, guiGraphics, i6, i7, 16.0f, 16.0f, 1.0f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1261a(@NotNull GuiGraphics guiGraphics, @NotNull C0555jl c0555jl, int i, int i2, int i3) {
        MutableComponent mutableComponentM2515b = c0555jl.m2515b();
        Font font = this.font;
        C0129bt.m483c(font, guiGraphics, (Component) mutableComponentM2515b, i + (i3 / 2), (i2 + i3) - 10);
    }

    @Override // com.boehmod.blockfront.AbstractC0217dR, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        AbstractClanData clanData = getClanData();
        UUID clanId = this.playerCloudData.getClanId();
        boolean zEquals = clanData.getOwner().equals(this.playerCloudData.m2522a().getId());
        boolean zB = m1291B();
        boolean zIsEmpty = clanData.isEmpty();
        boolean zC = m1292C();
        this.f1660j.visible = zIsEmpty && zB;
        this.f1661k.visible = !zEquals && zC;
        boolean z = zEquals && zB;
        Iterator<C0085bB> it = this.f1662z.iterator();
        while (it.hasNext()) {
            it.next().visible = z;
        }
        if (clanId != null) {
            int i = this.f1659hS;
            this.f1659hS = i + 1;
            if (i > 30) {
                this.f1659hS = 0;
                ((C0358g) this.f1057f.m2852b()).m1722a().m2492b(RequestType.CLAN_DATA, clanId);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0217dR, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        int i = this.width / 2;
        int i2 = i - 100;
        int i3 = this.height - 90;
        this.f1660j = new C0085bB(i2, i3, 200, 20, f1656fH, button -> {
            this.f1058a.setScreen(new C0282ed(this));
        }).m326a(f1657fI).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW);
        addRenderableWidget(this.f1660j);
        this.f1661k = new C0085bB(i2, i3, 200, 20, f1652fD, button2 -> {
            AbstractC0223dX abstractC0223dXA = new C0283ee(this, f1654fF, z -> {
                if (z) {
                    C0530jM.log("Attempting to send clan leave request to cloud...", new Object[0]);
                    ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketClanLeave());
                }
            }).m1324a(f1655fG);
            abstractC0223dXA.m1324a(f1654fF);
            this.f1058a.setScreen(abstractC0223dXA);
        }).m326a(f1653fE);
        addRenderableWidget(this.f1661k);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        objectArrayList.add(f1644fv);
        objectArrayList2.add(f1645fw);
        objectArrayList3.add(button3 -> {
            this.f1058a.setScreen(new C0280eb(this));
        });
        objectArrayList.add(f1646fx);
        objectArrayList2.add(f1647fy);
        objectArrayList3.add(button4 -> {
            this.f1058a.setScreen(new C0281ec(this));
        });
        objectArrayList.add(f1648fz);
        objectArrayList2.add(f1649fA);
        objectArrayList3.add(button5 -> {
            C0283ee c0283ee = new C0283ee(this, f1650fB, z -> {
                if (z) {
                    C0530jM.log("Attempting to send clan delete request to cloud...", new Object[0]);
                    ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketClanDelete());
                }
            });
            c0283ee.m1324a(f1651fC);
            this.f1058a.setScreen(c0283ee);
        });
        int size = objectArrayList.size();
        int i4 = 85 * size;
        for (int i5 = 0; i5 < size; i5++) {
            C0085bB c0085bBM326a = new C0085bB((i - (i4 / 2)) + (85 * i5), i3, 80, 20, (Component) objectArrayList.get(i5), (Button.OnPress) objectArrayList3.get(i5)).m326a((Component) objectArrayList2.get(i5));
            this.f1662z.add(c0085bBM326a);
            addRenderableWidget(c0085bBM326a);
        }
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        AbstractClanData clanData = getClanData();
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 35;
        if (!clanData.isEmpty()) {
            m1257a(poseStackPose, guiGraphics, clanData);
            return;
        }
        int i5 = i3 - 150;
        int i6 = (i4 - 6) - 10;
        C0129bt.m591c(guiGraphics, i5, i6, 301, 70, C0129bt.m465t());
        C0129bt.m467a(poseStackPose, guiGraphics, i5 + 3, i6 + 3, Token.XOR_EQ, 64);
        C0129bt.m499a(poseStackPose, this.font, guiGraphics, f1639fq, i3, i4);
        if (m1291B()) {
            C0129bt.m499a(poseStackPose, this.font, guiGraphics, f1641fs, i3, i4 + 15);
            C0129bt.m499a(poseStackPose, this.font, guiGraphics, (Component) f1642ft.copy(), i3, i4 + 30);
            return;
        }
        C0129bt.m499a(poseStackPose, this.font, guiGraphics, f1643fu, i3, i4 + 15);
    }

    @NotNull
    private AbstractClanData getClanData() {
        UUID clanId = this.playerCloudData.getClanId();
        return clanId != null ? this.f1056a.mo1154a(clanId) : AbstractClanData.EMPTY_CLAN_DATA;
    }
}
