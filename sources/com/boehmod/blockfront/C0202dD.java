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
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dD.class */
public class C0202dD extends AbstractC0205dG {

    /* JADX INFO: renamed from: gH */
    private static final int f1609gH = 30;

    /* JADX INFO: renamed from: fk */
    private static final Component f1610fk = Component.translatable("bf.profile.clan.none.title").withColor(ColorReferences.COLOR_THEME_CLANS_SOLID);

    /* JADX INFO: renamed from: fl */
    private static final Component f1611fl = Component.translatable("bf.message.prestige").append(" 1").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);

    /* JADX INFO: renamed from: fm */
    private static final Component f1612fm = Component.translatable("bf.profile.clan.none.description.self");

    /* JADX INFO: renamed from: fn */
    private static final Component f1613fn = Component.translatable("bf.profile.clan.none.description.requirement", new Object[]{f1611fl}).withStyle(ChatFormatting.DARK_GRAY);

    /* JADX INFO: renamed from: fo */
    private static final Component f1614fo = Component.translatable("bf.profile.clan.none.description");

    /* JADX INFO: renamed from: fp */
    private static final Component f1615fp = Component.translatable("bf.message.clan.invite");

    /* JADX INFO: renamed from: fq */
    private static final Component f1616fq = Component.translatable("bf.message.prompt.clan.invite.tip");

    /* JADX INFO: renamed from: fr */
    private static final Component f1617fr = Component.translatable("bf.message.clan.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: fs */
    private static final Component f1618fs = Component.translatable("bf.message.prompt.clan.kick.tip");

    /* JADX INFO: renamed from: ft */
    private static final Component f1619ft = Component.translatable("bf.message.clan.delete").withStyle(ChatFormatting.DARK_RED);

    /* JADX INFO: renamed from: fu */
    private static final Component f1620fu = Component.translatable("bf.message.prompt.clan.delete.tip");

    /* JADX INFO: renamed from: fv */
    private static final Component f1621fv = Component.translatable("bf.message.prompt.clan.delete.title");

    /* JADX INFO: renamed from: fw */
    private static final Component f1622fw = Component.translatable("bf.message.prompt.clan.delete");

    /* JADX INFO: renamed from: fx */
    private static final Component f1623fx = Component.translatable("bf.message.clan.leave").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: fy */
    private static final Component f1624fy = Component.translatable("bf.message.prompt.clan.leave.tip");

    /* JADX INFO: renamed from: fz */
    private static final Component f1625fz = Component.translatable("bf.message.prompt.clan.leave.title");

    /* JADX INFO: renamed from: fA */
    private static final Component f1626fA = Component.translatable("bf.message.prompt.clan.leave");

    /* JADX INFO: renamed from: fB */
    private static final Component f1627fB = Component.translatable("bf.message.clan.create");

    /* JADX INFO: renamed from: fC */
    private static final Component f1628fC = Component.translatable("bf.message.prompt.clan.create.tip");

    /* JADX INFO: renamed from: fD */
    private static final Component f1629fD = Component.translatable("bf.message.clan.information").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: gI */
    private int f1630gI;

    /* JADX INFO: renamed from: j */
    private C0127bs f1631j;

    /* JADX INFO: renamed from: k */
    private C0127bs f1632k;

    /* JADX INFO: renamed from: x */
    @NotNull
    private final List<C0127bs> f1633x;

    public C0202dD(@NotNull Screen screen, @NotNull C0482iS c0482iS) {
        super(screen, c0482iS, f1629fD);
        this.f1630gI = 0;
        this.f1633x = new ObjectArrayList();
    }

    /* JADX INFO: renamed from: a */
    private void m1206a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData) {
        int i = this.width / 2;
        m1207a(guiGraphics, abstractClanData, 75, i);
        m1208a(poseStack, guiGraphics, abstractClanData, 75, i);
    }

    /* JADX INFO: renamed from: a */
    private void m1207a(@NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData, int i, int i2) {
        C0119bk.m383c(this.font, guiGraphics, (Component) Component.literal(abstractClanData.getName()).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID).append(Component.literal(" - ").withColor(ColorReferences.COLOR_WHITE)).append(f1629fD).append(" ").append(Component.translatable("bf.profile.clan.skill.level", new Object[]{String.format("%.2f", Float.valueOf(C0475iL.m2149a(this.f1585a, abstractClanData)))}).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID)), i2, i);
    }

    /* JADX INFO: renamed from: a */
    private void m1208a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData, int i, int i2) {
        Set<UUID> members = abstractClanData.getMembers();
        int size = members.size();
        int i3 = i + 15;
        int i4 = 60 * size;
        int i5 = 0;
        for (UUID uuid : members) {
            C0482iS c0482iSA = this.f1585a.mo1137a(uuid);
            GameProfile gameProfileM2195a = c0482iSA.m2195a();
            int i6 = (i2 - (i4 / 2)) + (60 * i5);
            m1209a(poseStack, guiGraphics, gameProfileM2195a, abstractClanData.getOwner().equals(uuid), i6, i3, 55, 30, 12);
            m1210a(guiGraphics, c0482iSA, i6, i3, 55);
            i5++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1209a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GameProfile gameProfile, boolean z, int i, int i2, int i3, int i4, int i5) {
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        C0477iN inventory = this.f1585a.mo1137a(gameProfile.getId()).getInventory();
        C0119bk.m415a(guiGraphics, i, i2, i3, i3, C0119bk.m365p());
        int i6 = i + i5;
        int i7 = (i2 + i5) - 5;
        C0119bk.m415a(guiGraphics, i6 - 1, i7 - 1, i4 + 2, i4 + 2, z ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        C0119bk.m485a(this.f1587b, this.f1586e, poseStack, guiGraphics, gameProfile, i6, i7, i4);
        CloudItemStack cloudItemStackM2160a = inventory.m2160a(CloudItemType.COIN);
        if (cloudItemStackM2160a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2160a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0544jb.m2468a(abstractCloudItemCoin).mo2466a(abstractCloudItemCoin, cloudItemStackM2160a, poseStack, this.f1587b, guiGraphics, i6, i7, 16.0f, 16.0f, 1.0f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1210a(@NotNull GuiGraphics guiGraphics, @NotNull C0482iS c0482iS, int i, int i2, int i3) {
        MutableComponent mutableComponentM2188b = c0482iS.m2188b();
        Font font = this.font;
        C0119bk.m383c(font, guiGraphics, (Component) mutableComponentM2188b, i + (i3 / 2), (i2 + i3) - 10);
    }

    @Override // com.boehmod.blockfront.AbstractC0205dG, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        AbstractClanData clanData = getClanData();
        UUID clanId = this.playerCloudData.getClanId();
        boolean zEquals = clanData.getOwner().equals(this.playerCloudData.m2195a().getId());
        boolean zA = m1240A();
        boolean zIsEmpty = clanData.isEmpty();
        boolean zB = m1241B();
        this.f1631j.visible = zIsEmpty && zA;
        this.f1632k.visible = !zEquals && zB;
        boolean z = zEquals && zA;
        Iterator<C0127bs> it = this.f1633x.iterator();
        while (it.hasNext()) {
            it.next().visible = z;
        }
        if (clanId != null) {
            int i = this.f1630gI;
            this.f1630gI = i + 1;
            if (i > 30) {
                this.f1630gI = 0;
                ((C0357g) this.f1586e.m2667b()).m1716a().m2165b(RequestType.CLAN_DATA, clanId);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0205dG, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        int i = this.width / 2;
        int i2 = i - 100;
        int i3 = this.height - 90;
        this.f1631j = new C0127bs(i2, i3, 200, 20, f1627fB, button -> {
            this.f1587b.setScreen(new C0217dS(this));
        }).m651a(f1628fC).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW);
        addRenderableWidget(this.f1631j);
        this.f1632k = new C0127bs(i2, i3, 200, 20, f1623fx, button2 -> {
            AbstractC0211dM abstractC0211dMA = new C0218dT(this, f1625fz, z -> {
                if (z) {
                    C0562jt.log("Attempting to send clan leave request to cloud...", new Object[0]);
                    ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketClanLeave());
                }
            }).m1273a(f1626fA);
            abstractC0211dMA.m1273a(f1625fz);
            this.f1587b.setScreen(abstractC0211dMA);
        }).m651a(f1624fy);
        addRenderableWidget(this.f1632k);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        objectArrayList.add(f1615fp);
        objectArrayList2.add(f1616fq);
        objectArrayList3.add(button3 -> {
            this.f1587b.setScreen(new C0215dQ(this));
        });
        objectArrayList.add(f1617fr);
        objectArrayList2.add(f1618fs);
        objectArrayList3.add(button4 -> {
            this.f1587b.setScreen(new C0216dR(this));
        });
        objectArrayList.add(f1619ft);
        objectArrayList2.add(f1620fu);
        objectArrayList3.add(button5 -> {
            C0218dT c0218dT = new C0218dT(this, f1621fv, z -> {
                if (z) {
                    C0562jt.log("Attempting to send clan delete request to cloud...", new Object[0]);
                    ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketClanDelete());
                }
            });
            c0218dT.m1273a(f1622fw);
            this.f1587b.setScreen(c0218dT);
        });
        int size = objectArrayList.size();
        int i4 = 85 * size;
        for (int i5 = 0; i5 < size; i5++) {
            C0127bs c0127bsM651a = new C0127bs((i - (i4 / 2)) + (85 * i5), i3, 80, 20, (Component) objectArrayList.get(i5), (Button.OnPress) objectArrayList3.get(i5)).m651a((Component) objectArrayList2.get(i5));
            this.f1633x.add(c0127bsM651a);
            addRenderableWidget(c0127bsM651a);
        }
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        AbstractClanData clanData = getClanData();
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 35;
        if (!clanData.isEmpty()) {
            m1206a(poseStackPose, guiGraphics, clanData);
            return;
        }
        int i5 = i3 - 150;
        int i6 = (i4 - 6) - 10;
        C0119bk.m491c(guiGraphics, i5, i6, 301, 70, C0119bk.m365p());
        C0119bk.m367a(poseStackPose, guiGraphics, i5 + 3, i6 + 3, Token.XOR_EQ, 64);
        C0119bk.m399a(poseStackPose, this.font, guiGraphics, f1610fk, i3, i4);
        if (m1240A()) {
            C0119bk.m399a(poseStackPose, this.font, guiGraphics, f1612fm, i3, i4 + 15);
            C0119bk.m399a(poseStackPose, this.font, guiGraphics, (Component) f1613fn.copy(), i3, i4 + 30);
            return;
        }
        C0119bk.m399a(poseStackPose, this.font, guiGraphics, f1614fo, i3, i4 + 15);
    }

    @NotNull
    private AbstractClanData getClanData() {
        UUID clanId = this.playerCloudData.getClanId();
        return clanId != null ? this.f1585a.mo1137a(clanId) : AbstractClanData.EMPTY_CLAN_DATA;
    }
}
