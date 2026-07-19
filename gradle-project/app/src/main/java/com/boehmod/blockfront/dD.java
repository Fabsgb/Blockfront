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
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dD.class */
public class dD extends dG {
    private static final int gH = 30;
    private static final Component fk = Component.translatable("bf.profile.clan.none.title").withColor(ColorReferences.COLOR_THEME_CLANS_SOLID);
    private static final Component fl = Component.translatable("bf.message.prestige").append(" 1").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
    private static final Component fm = Component.translatable("bf.profile.clan.none.description.self");
    private static final Component fn = Component.translatable("bf.profile.clan.none.description.requirement", new Object[]{fl}).withStyle(ChatFormatting.DARK_GRAY);
    private static final Component fo = Component.translatable("bf.profile.clan.none.description");
    private static final Component fp = Component.translatable("bf.message.clan.invite");
    private static final Component fq = Component.translatable("bf.message.prompt.clan.invite.tip");
    private static final Component fr = Component.translatable("bf.message.clan.kick").withStyle(ChatFormatting.RED);
    private static final Component fs = Component.translatable("bf.message.prompt.clan.kick.tip");
    private static final Component ft = Component.translatable("bf.message.clan.delete").withStyle(ChatFormatting.DARK_RED);
    private static final Component fu = Component.translatable("bf.message.prompt.clan.delete.tip");
    private static final Component fv = Component.translatable("bf.message.prompt.clan.delete.title");
    private static final Component fw = Component.translatable("bf.message.prompt.clan.delete");
    private static final Component fx = Component.translatable("bf.message.clan.leave").withStyle(ChatFormatting.RED);
    private static final Component fy = Component.translatable("bf.message.prompt.clan.leave.tip");
    private static final Component fz = Component.translatable("bf.message.prompt.clan.leave.title");
    private static final Component fA = Component.translatable("bf.message.prompt.clan.leave");
    private static final Component fB = Component.translatable("bf.message.clan.create");
    private static final Component fC = Component.translatable("bf.message.prompt.clan.create.tip");
    private static final Component fD = Component.translatable("bf.message.clan.information").withColor(ColorReferences.COLOR_WHITE);
    private int gI;
    private C0048bs j;
    private C0048bs k;

    @NotNull
    private final List<C0048bs> x;

    public dD(@NotNull Screen screen, @NotNull iS iSVar) {
        super(screen, iSVar, fD);
        this.gI = 0;
        this.x = new ObjectArrayList();
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData) {
        int i = this.width / 2;
        a(guiGraphics, abstractClanData, 75, i);
        a(poseStack, guiGraphics, abstractClanData, 75, i);
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData, int i, int i2) {
        C0040bk.c(this.font, guiGraphics, (Component) Component.literal(abstractClanData.getName()).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID).append(Component.literal(" - ").withColor(ColorReferences.COLOR_WHITE)).append(fD).append(" ").append(Component.translatable("bf.profile.clan.skill.level", new Object[]{String.format("%.2f", Float.valueOf(iL.a(this.a, abstractClanData)))}).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID)), i2, i);
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractClanData abstractClanData, int i, int i2) {
        Set<UUID> members = abstractClanData.getMembers();
        int size = members.size();
        int i3 = i + 15;
        int i4 = 60 * size;
        int i5 = 0;
        for (UUID uuid : members) {
            iS iSVarA = this.a.mo306a(uuid);
            GameProfile gameProfileM491a = iSVarA.m491a();
            int i6 = (i2 - (i4 / 2)) + (60 * i5);
            a(poseStack, guiGraphics, gameProfileM491a, abstractClanData.getOwner().equals(uuid), i6, i3, 55, 30, 12);
            a(guiGraphics, iSVarA, i6, i3, 55);
            i5++;
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GameProfile gameProfile, boolean z, int i, int i2, int i3, int i4, int i5) {
        CloudRegistry cloudRegistryA = this.e.a();
        iN inventory = this.a.mo306a(gameProfile.getId()).getInventory();
        C0040bk.a(guiGraphics, i, i2, i3, i3, C0040bk.p());
        int i6 = i + i5;
        int i7 = (i2 + i5) - 5;
        C0040bk.a(guiGraphics, i6 - 1, i7 - 1, i4 + 2, i4 + 2, z ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        C0040bk.a(this.b, this.e, poseStack, guiGraphics, gameProfile, i6, i7, i4);
        CloudItemStack cloudItemStackA = inventory.a(CloudItemType.COIN);
        if (cloudItemStackA != null) {
            CloudItem<?> cloudItem = cloudItemStackA.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0245jb.a(abstractCloudItemCoin).a(abstractCloudItemCoin, cloudItemStackA, poseStack, this.b, guiGraphics, i6, i7, 16.0f, 16.0f, 1.0f);
            }
        }
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull iS iSVar, int i, int i2, int i3) {
        MutableComponent mutableComponentB = iSVar.b();
        Font font = this.font;
        C0040bk.c(font, guiGraphics, (Component) mutableComponentB, i + (i3 / 2), (i2 + i3) - 10);
    }

    @Override // com.boehmod.blockfront.dG, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        AbstractClanData clanData = getClanData();
        UUID clanId = this.playerCloudData.getClanId();
        boolean zEquals = clanData.getOwner().equals(this.playerCloudData.m491a().getId());
        boolean zA = A();
        boolean zIsEmpty = clanData.isEmpty();
        boolean zB = B();
        this.j.visible = zIsEmpty && zA;
        this.k.visible = !zEquals && zB;
        boolean z = zEquals && zA;
        Iterator<C0048bs> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().visible = z;
        }
        if (clanId != null) {
            int i = this.gI;
            this.gI = i + 1;
            if (i > 30) {
                this.gI = 0;
                ((C0163g) this.e.b()).a().b(RequestType.CLAN_DATA, clanId);
            }
        }
    }

    @Override // com.boehmod.blockfront.dG, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        int i = this.width / 2;
        int i2 = i - 100;
        int i3 = this.height - 90;
        this.j = new C0048bs(i2, i3, 200, 20, fB, button -> {
            this.b.setScreen(new dS(this));
        }).a(fC).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW);
        addRenderableWidget(this.j);
        this.k = new C0048bs(i2, i3, 200, 20, fx, button2 -> {
            dM dMVarA = new dT(this, fz, z -> {
                if (z) {
                    C0263jt.log("Attempting to send clan leave request to cloud...", new Object[0]);
                    ((C0163g) this.e.b()).sendPacket(new PacketClanLeave());
                }
            }).a(fA);
            dMVarA.a(fz);
            this.b.setScreen(dMVarA);
        }).a(fy);
        addRenderableWidget(this.k);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        objectArrayList.add(fp);
        objectArrayList2.add(fq);
        objectArrayList3.add(button3 -> {
            this.b.setScreen(new dQ(this));
        });
        objectArrayList.add(fr);
        objectArrayList2.add(fs);
        objectArrayList3.add(button4 -> {
            this.b.setScreen(new dR(this));
        });
        objectArrayList.add(ft);
        objectArrayList2.add(fu);
        objectArrayList3.add(button5 -> {
            dT dTVar = new dT(this, fv, z -> {
                if (z) {
                    C0263jt.log("Attempting to send clan delete request to cloud...", new Object[0]);
                    ((C0163g) this.e.b()).sendPacket(new PacketClanDelete());
                }
            });
            dTVar.a(fw);
            this.b.setScreen(dTVar);
        });
        int size = objectArrayList.size();
        int i4 = 85 * size;
        for (int i5 = 0; i5 < size; i5++) {
            C0048bs c0048bsA = new C0048bs((i - (i4 / 2)) + (85 * i5), i3, 80, 20, (Component) objectArrayList.get(i5), (Button.OnPress) objectArrayList3.get(i5)).a((Component) objectArrayList2.get(i5));
            this.x.add(c0048bsA);
            addRenderableWidget(c0048bsA);
        }
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        AbstractClanData clanData = getClanData();
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 35;
        if (!clanData.isEmpty()) {
            a(poseStackPose, guiGraphics, clanData);
            return;
        }
        int i5 = i3 - 150;
        int i6 = (i4 - 6) - 10;
        C0040bk.c(guiGraphics, i5, i6, 301, 70, C0040bk.p());
        C0040bk.a(poseStackPose, guiGraphics, i5 + 3, i6 + 3, Token.XOR_EQ, 64);
        C0040bk.a(poseStackPose, this.font, guiGraphics, fk, i3, i4);
        if (A()) {
            C0040bk.a(poseStackPose, this.font, guiGraphics, fm, i3, i4 + 15);
            C0040bk.a(poseStackPose, this.font, guiGraphics, (Component) fn.copy(), i3, i4 + 30);
            return;
        }
        C0040bk.a(poseStackPose, this.font, guiGraphics, fo, i3, i4 + 15);
    }

    @NotNull
    private AbstractClanData getClanData() {
        UUID clanId = this.playerCloudData.getClanId();
        return clanId != null ? this.a.mo306a(clanId) : AbstractClanData.EMPTY_CLAN_DATA;
    }
}
