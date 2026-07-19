package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordUnlinkRequest;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRemove;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequest;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonLinkRequest;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonUnlinkRequest;
import com.boehmod.bflib.cloud.packet.common.profile.PacketCheckPrestige;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dG.class */
public abstract class dG extends C0080cx {
    private static final int gS = 30;

    @NotNull
    protected final Screen j;
    public iS playerCloudData;

    /* JADX INFO: renamed from: gk, reason: collision with other field name */
    private int f111gk;
    private final boolean bD;
    private static final Component fM = Component.translatable("bf.message.prestige").withStyle(ChatFormatting.BOLD);
    private static final Component fN = Component.translatable("bf.message.clan").withStyle(ChatFormatting.BOLD);
    private static final Component fO = Component.translatable("bf.message.profile.base.clan.tip");
    private static final Component fP = Component.translatable("bf.message.add.friend").withStyle(ChatFormatting.BOLD);
    private static final Component fQ = Component.translatable("bf.message.remove.friend").withStyle(ChatFormatting.BOLD);
    private static final Component fR = Component.translatable("bf.message.unlink").withStyle(ChatFormatting.BOLD);
    private static final Component fS = Component.translatable("bf.message.profile.base.unlink.tip");
    private static final Component fT = Component.translatable("bf.message.patreon.link").withStyle(ChatFormatting.BOLD);
    private static final Component fU = Component.translatable("bf.message.profile.base.patreon.link.tip");
    private static final Component fV = Component.translatable("bf.message.patreon.unlink").withStyle(ChatFormatting.BOLD);
    private static final Component fW = Component.translatable("bf.message.profile.base.patreon.unlink.tip");
    private static final Component fX = Component.translatable("bf.message.profile.base.unlink.title");
    private static final Component fY = Component.translatable("bf.message.profile.base.unlink");
    private static final Component fZ = Component.translatable("bf.message.profile.base.add.friend.tip");
    private static final Component ga = Component.translatable("bf.message.profile.base.remove.friend.tip");
    private static final Component gb = Component.translatable("bf.message.prompt.friend.remove.title");
    private static final Component gc = Component.translatable("bf.message.prompt.friend.remove");
    private static final Component gd = Component.translatable("bf.message.prompt.friend.add.title");
    private static final Component ge = Component.translatable("bf.message.prompt.friend.add");
    private static final Component gf = Component.translatable("bf.message.profile.base.patreon.unlink.title");

    /* JADX INFO: renamed from: gg, reason: collision with root package name */
    private static final Component f412gg = Component.translatable("bf.message.profile.base.patreon.unlink");
    private static final Component gh = Component.translatable("bf.message.profile.base.prestige.title").setStyle(Style.EMPTY.withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID));
    private static final Component gi = Component.translatable("bf.message.profile.base.prestige.tip");
    private static final Component gj = Component.translatable("bf.menu.button.back");
    private static final Component gk = Component.translatable("bf.dropdown.button.settings");
    private static final Component gl = Component.translatable("bf.message.main").withStyle(ChatFormatting.BOLD);
    private static final Component gm = Component.translatable("bf.message.profile.base.main.tip");
    private static final Component gn = Component.translatable("bf.message.statistics").withStyle(ChatFormatting.BOLD);
    private static final Component go = Component.translatable("bf.message.profile.base.stats.tip");
    private static final Component gp = Component.translatable("bf.message.profile.base.achievements").withStyle(ChatFormatting.BOLD);
    private static final Component gq = Component.translatable("bf.message.profile.base.achievements.tip");
    private static final Component gr = Component.translatable("bf.message.profile.base.matches").withStyle(ChatFormatting.BOLD);
    private static final Component gs = Component.translatable("bf.message.profile.base.matches.tip");
    private static final ResourceLocation bM = C0265jv.d("textures/gui/menu/icons/menu.png");
    private static final ResourceLocation bN = C0265jv.d("textures/gui/menu/icons/addfriend.png");
    private static final ResourceLocation bO = C0265jv.d("textures/gui/menu/icons/removefriend.png");
    private static final ResourceLocation bP = C0265jv.d("textures/gui/menu/icons/profile_main.png");
    private static final ResourceLocation bQ = C0265jv.d("textures/gui/menu/icons/profile_stats.png");
    private static final ResourceLocation bR = C0265jv.d("textures/gui/menu/icons/profile_achievements.png");
    private static final ResourceLocation bS = C0265jv.d("textures/gui/menu/icons/profile_prestige.png");
    private static final ResourceLocation bT = C0265jv.d("textures/gui/menu/icons/profile_clan.png");
    private static final ResourceLocation bU = C0265jv.d("textures/gui/menu/icons/profile_unlink.png");
    private static final ResourceLocation bV = C0265jv.d("textures/gui/menu/icons/profile_patreon_link.png");
    private static final ResourceLocation bW = C0265jv.d("textures/gui/menu/icons/profile_patreon_unlink.png");

    public dG(@NotNull Screen screen, @NotNull iS iSVar, @NotNull Component component) {
        super(component);
        this.f111gk = 15;
        this.j = screen;
        this.playerCloudData = iSVar;
        this.bD = iSVar.getUUID().equals(this.b.getUser().getProfileId());
    }

    public boolean A() {
        return this.bD;
    }

    public boolean B() {
        AbstractClanData clanData = this.playerCloudData.getClanData();
        if (clanData == null || clanData.isEmpty()) {
            return false;
        }
        return clanData.getMembers().contains(this.b.getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        int i = this.width / 2;
        int width = 0;
        boolean zEquals = this.b.getUser().getProfileId().equals(this.playerCloudData.getUUID());
        ObjectArrayList<C0048bs> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0048bs(i, 40, 0, 15, gl, button -> {
            this.b.setScreen(new dE(this.j, this.playerCloudData));
        }).a(bP).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(gm));
        objectArrayList.add(new C0048bs(i, 40, 0, 15, gn, button2 -> {
            this.b.setScreen(new dH(this.j, this.playerCloudData));
        }).a(bQ).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(go));
        objectArrayList.add(new C0048bs(i, 40, 0, 15, gp, button3 -> {
            this.b.setScreen(new dC(this.j, this.playerCloudData));
        }).a(bR).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(gq));
        objectArrayList.add(new C0048bs(i, 40, 0, 15, gr, button4 -> {
            this.b.setScreen(new dF(this.j, this.playerCloudData));
        }).a(bQ).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(gs));
        objectArrayList.add(new C0048bs(i, 40, 0, 15, fN, button5 -> {
            this.b.setScreen(new dD(this.j, this.playerCloudData));
        }).a(bT).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(fO));
        if (zEquals) {
            objectArrayList.add(new C0048bs(i, 40, 0, 15, fM, button6 -> {
                dL dLVar = new dL(this, gh, z -> {
                    if (z) {
                        C0263jt.log("Attempting to send prestige request to cloud...", new Object[0]);
                        ((C0163g) this.e.b()).sendPacket(new PacketCheckPrestige());
                    }
                });
                dLVar.a(Component.empty(), Component.translatable("bf.message.profile.base.prestige.par1", new Object[]{Component.literal(String.valueOf(this.playerCloudData.getPrestigeLevel() + 1)).withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)}), Component.empty(), Component.translatable("bf.message.profile.base.prestige.par2").withStyle(ChatFormatting.DARK_GRAY));
                this.b.setScreen(dLVar);
            }).a(c0048bs -> {
                return this.playerCloudData.canPrestige();
            }).a(bS).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(gi).a(C0048bs.a.NONE));
            if (this.playerCloudData.Y()) {
                objectArrayList.add(new C0048bs(i, 40, 0, 15, fR, button7 -> {
                    dT dTVar = new dT(this, fX, z -> {
                        if (z) {
                            C0263jt.log("Attempting to send unlink request to cloud...", new Object[0]);
                            ((C0163g) this.e.b()).sendPacket(new PacketDiscordUnlinkRequest());
                        }
                    });
                    dTVar.a(fY);
                    this.b.setScreen(dTVar);
                }).a(bU).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(fS));
            }
            if (this.playerCloudData.Z()) {
                objectArrayList.add(new C0048bs(i, 40, 0, 15, fV, button8 -> {
                    dT dTVar = new dT(this, gf, z -> {
                        if (z) {
                            C0263jt.log("Attempting to send Patreon unlink request to cloud...", new Object[0]);
                            ((C0163g) this.e.b()).sendPacket(new PacketPatreonUnlinkRequest());
                        }
                    });
                    dTVar.a(f412gg);
                    this.b.setScreen(dTVar);
                }).a(bW).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(fW));
            } else {
                objectArrayList.add(new C0048bs(i, 40, 0, 15, fT, button9 -> {
                    C0263jt.log("Attempting to send Patreon link request to cloud...", new Object[0]);
                    ((C0163g) this.e.b()).sendPacket(new PacketPatreonLinkRequest());
                }).a(bV).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(fU));
            }
        }
        boolean zC = this.e.m582a().c(this.playerCloudData.getUUID());
        if (!zEquals) {
            if (!zC) {
                objectArrayList.add(new C0048bs(i, 40, 0, 15, fP, button10 -> {
                    dT dTVar = new dT(this, gd, z -> {
                        if (z) {
                            C0263jt.log("Attempting to add friend...", new Object[0]);
                            ((C0163g) this.e.b()).sendPacket(new PacketFriendRequest(this.playerCloudData.getUsername()));
                        }
                    });
                    dTVar.a(ge);
                    this.b.setScreen(dTVar);
                }).a(bN).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(fZ));
            } else {
                objectArrayList.add(new C0048bs(i, 40, 0, 15, fQ, button11 -> {
                    dT dTVar = new dT(this, gb, z -> {
                        if (z) {
                            C0263jt.log("Attempting to remove friend...", new Object[0]);
                            ((C0163g) this.e.b()).sendPacket(new PacketFriendRemove(this.playerCloudData.getUUID()));
                        }
                    });
                    dTVar.a(gc);
                    this.b.setScreen(dTVar);
                }).a(bO).a(9, 9).b(0, -2).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE).a(ga));
            }
        }
        for (C0048bs c0048bs2 : objectArrayList) {
            c0048bs2.setWidth(((this.font.width(c0048bs2.getMessage().getString()) + 15) / 2) + 4);
            width += c0048bs2.getWidth() + 2;
        }
        int i2 = i - (width / 2);
        int width2 = 0;
        for (C0048bs c0048bs3 : objectArrayList) {
            c0048bs3.setX(i2 + width2);
            addRenderableWidget(c0048bs3);
            width2 += c0048bs3.getWidth() + 2;
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        int i = this.f111gk;
        this.f111gk = i + 1;
        if (i > 30) {
            this.f111gk = 0;
            UUID uuid = this.playerCloudData.getUUID();
            iO iOVarA = ((C0163g) this.e.b()).a();
            iOVarA.b(RequestType.PLAYER_DATA, uuid);
            iOVarA.b(RequestType.INVENTORY_MINIMAL, uuid);
            iOVarA.b(RequestType.PLAYER_STATUS, uuid);
            UUID clanId = this.playerCloudData.getClanId();
            if (clanId != null) {
                iOVarA.b(RequestType.CLAN_DATA, clanId);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        C0048bs c0048bs = new C0048bs(5, 18, 20, 20, Component.empty(), button -> {
            J();
        });
        addRenderableWidget(c0048bs);
        c0048bs.a(aH);
        c0048bs.a(20, 20);
        c0048bs.a(C0048bs.a.NONE);
        c0048bs.a(gj);
        addRenderableWidget(c0048bs);
        addRenderableWidget(new C0048bs(this.width - (20 + 5), 18, 20, 20, Component.empty(), button2 -> {
            this.b.setScreen(new cA(this, false));
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pk.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }).a(bM).a(20, 20).a(C0048bs.a.NONE).a(gk));
    }

    public void J() {
        Screen screen = this.j;
        if (screen instanceof AbstractC0078cv) {
            ((AbstractC0078cv) screen).aU = true;
        }
        this.b.setScreen(this.j);
    }
}
