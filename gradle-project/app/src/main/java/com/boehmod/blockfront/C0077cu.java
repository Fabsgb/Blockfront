package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.blockfront.C0048bs;
import com.boehmod.blockfront.C0111eb;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cu.class */
public final class C0077cu extends AbstractC0078cv {
    private static final Component bd = Component.translatable("bf.screen.overlay.friends");
    private static final Component be = Component.translatable("bf.message.prompt.friend.add.title").withStyle(ChatFormatting.BOLD);
    private static final Component bf = Component.translatable("bf.message.prompt.friend.add.description");
    private static final Component bg = Component.translatable("bf.message.profile").withStyle(ChatFormatting.BOLD);
    private static final Component bh = Component.translatable("bf.message.profile.description", new Object[]{C0002a.a});
    private static final Component bi = Component.translatable("bf.dropdown.text.my.friends").withStyle(C0266jw.b);
    private static final ResourceLocation aF = C0265jv.d("textures/gui/menu/icons/addfriend.png");
    private static final ResourceLocation aG = C0265jv.d("textures/gui/menu/icons/myprofile.png");
    private static final int dR = 20;

    @Nullable
    private static dZ<AbstractC0116eg> a;
    private int dS;

    public C0077cu(Screen screen, boolean z) {
        super(screen, bd, z);
        this.dS = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        int i = this.dS;
        this.dS = i + 1;
        if (i > 20) {
            H();
            this.dS = 0;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    public float h(float f) {
        return -super.h(f);
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    public void a(@NotNull GuiGraphics guiGraphics, float f) {
        super.a(guiGraphics, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i = this.width / 4;
        poseStackPose.pushPose();
        C0040bk.c(guiGraphics, 0, 0, i, this.height, C0040bk.p());
        C0040bk.a(this.a, guiGraphics, this.font, this.b.getUser().getProfileId(), C0111eb.b.FRIEND, 0, 12, 20, false);
        C0040bk.a(this.b, this.e, poseStackPose, guiGraphics, this.b.getGameProfile(), (i - 18) - 2, 14.0f, 18);
        C0040bk.c(this.font, guiGraphics, bi, i / 2, 4);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    public boolean a(double d, double d2) {
        return d > ((double) (((float) this.width) / 4.0f));
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        int i = (this.width / 4) / 2;
        addRenderableWidget(new C0048bs(0, 34, i, 16, be, button -> {
            this.b.setScreen(new dP(this));
        }).a(aF).a(12, 12).b(0, -3).a(C0048bs.b.CENTER_BOTTOM).a(0.0f, 3.0f).b(0.5f).a(bf));
        addRenderableWidget(new C0048bs(i, 34, i, 16, bg, button2 -> {
            this.b.setScreen(new dE(this, this.a.m404a(this.b)));
        }).a(aG).a(12, 12).b(0, -3).a(C0048bs.b.CENTER_BOTTOM).a(0.0f, 3.0f).b(0.5f).a(bh));
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        int i = this.width / 4;
        if (a == null) {
            a = new dZ<>(0, 50, i, this.height - 50, this);
        }
        a.a(this);
        a.e(i);
        a.f(this.height - 50);
        H();
        a(a);
    }

    private void H() {
        C0432q c0432qM582a = this.e.m582a();
        iS iSVarM404a = this.a.m404a(this.b);
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        ObjectOpenHashSet objectOpenHashSet2 = new ObjectOpenHashSet();
        Set<UUID> setA = c0432qM582a.a();
        for (UUID uuid : setA) {
            if (this.a.mo306a(uuid).getStatus().getOnlineStatus().isOnline()) {
                objectOpenHashSet.add(uuid);
            } else {
                objectOpenHashSet2.add(uuid);
            }
        }
        ObjectOpenHashSet objectOpenHashSet3 = new ObjectOpenHashSet();
        ObjectOpenHashSet objectOpenHashSet4 = new ObjectOpenHashSet();
        ObjectOpenHashSet<UUID> objectOpenHashSet5 = new ObjectOpenHashSet();
        objectOpenHashSet4.removeAll(objectOpenHashSet2);
        AbstractClanData clanData = iSVarM404a.getClanData();
        if (clanData != null) {
            objectOpenHashSet5.addAll(clanData.getMembers());
        }
        for (UUID uuid2 : objectOpenHashSet5) {
            if (this.a.mo306a(uuid2).getStatus().getOnlineStatus().isOnline()) {
                objectOpenHashSet3.add(uuid2);
            } else {
                objectOpenHashSet4.add(uuid2);
            }
        }
        ObjectOpenHashSet objectOpenHashSet6 = new ObjectOpenHashSet(c0432qM582a.b());
        ObjectOpenHashSet objectOpenHashSet7 = new ObjectOpenHashSet(c0432qM582a.c());
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String str = String.format("%s/%s (Max: %s)", Integer.valueOf(objectOpenHashSet.size()), Integer.valueOf(setA.size()), Integer.valueOf(iSVarM404a.ak()));
        String str2 = String.format("%s/%s (Max: %s)", Integer.valueOf(objectOpenHashSet4.size()), Integer.valueOf(objectOpenHashSet5.size()), 6);
        objectArrayList.add(new C0117eh(""));
        objectArrayList.add(new C0117eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.my.friends", new Object[0])));
        objectArrayList.add(new C0117eh(str));
        Iterator it = objectOpenHashSet.iterator();
        while (it.hasNext()) {
            objectArrayList.add(new C0111eb(this, (UUID) it.next(), C0111eb.b.FRIEND));
        }
        if (!objectOpenHashSet3.isEmpty()) {
            String name = clanData != null ? clanData.getName() : "Clan";
            objectArrayList.add(new C0117eh(""));
            objectArrayList.add(new C0117eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.clan.members", new Object[]{name}) + String.valueOf(ChatFormatting.RESET) + " " + str2));
            Iterator it2 = objectOpenHashSet3.iterator();
            while (it2.hasNext()) {
                objectArrayList.add(new C0111eb(this, (UUID) it2.next(), C0111eb.b.CLAN_MEMBER));
            }
        }
        if (!objectOpenHashSet2.isEmpty() || !objectOpenHashSet4.isEmpty()) {
            objectArrayList.add(new C0117eh(""));
            objectArrayList.add(new C0117eh(String.valueOf(ChatFormatting.BOLD) + Component.translatable("bf.dropdown.text.offline").getString()));
        }
        Iterator it3 = objectOpenHashSet2.iterator();
        while (it3.hasNext()) {
            objectArrayList.add(new C0111eb(this, (UUID) it3.next(), C0111eb.b.FRIEND));
        }
        Iterator it4 = objectOpenHashSet4.iterator();
        while (it4.hasNext()) {
            objectArrayList.add(new C0111eb(this, (UUID) it4.next(), C0111eb.b.CLAN_MEMBER));
        }
        if (!c0432qM582a.b().isEmpty()) {
            objectArrayList.add(new C0117eh(""));
            objectArrayList.add(new C0117eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.requests.friends", new Object[0])));
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList(objectOpenHashSet6);
        objectArrayList2.sort(null);
        Iterator it5 = objectArrayList2.iterator();
        while (it5.hasNext()) {
            objectArrayList.add(new C0111eb(this, (UUID) it5.next(), C0111eb.b.FRIEND_REQUEST));
        }
        if (!objectOpenHashSet7.isEmpty()) {
            objectArrayList.add(new C0117eh(""));
            objectArrayList.add(new C0117eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.requests.clans", new Object[0])));
            ObjectIterator it6 = objectOpenHashSet7.iterator();
            while (it6.hasNext()) {
                objectArrayList.add(new C0111eb(this, (UUID) it6.next(), C0111eb.b.CLAN_INVITE));
            }
        }
        if (a != null) {
            try {
                a.d((List) objectArrayList);
            } catch (ConcurrentModificationException e) {
            }
            a.al();
        }
    }
}
