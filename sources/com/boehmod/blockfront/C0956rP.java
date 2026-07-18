package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0788oG;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rP.class */
public final class C0956rP extends AbstractC0788oG<C0955rO, C0958rR> {

    /* JADX INFO: renamed from: je */
    private static final Component f5055je = Component.literal("<<< ").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jf */
    private static final Component f5056jf = Component.literal(" >>>").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: jg */
    private static final Component f5057jg = Component.translatable("bf.message.gamemode.gungame.weapon.previous").withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jh */
    private static final Component f5058jh = Component.translatable("bf.message.gamemode.gungame.weapon.next").withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: ji */
    private static final Component f5059ji = Component.translatable("bf.message.gamemode.gungame.weapon.current").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: jj */
    private static final Component f5060jj = Component.empty().append(f5058jh).append(f5056jf).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jk */
    private static final Component f5061jk = Component.empty().append(f5055je).append(f5057jg).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jl */
    private static final Component f5062jl = Component.translatable("bf.message.gamemode.gungame.kill.last.title").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: jm */
    private static final Component f5063jm = Component.translatable("bf.message.gamemode.gungame.kill.last.subtitle").withStyle(ChatFormatting.YELLOW);

    /* JADX INFO: renamed from: fb */
    private static final ResourceLocation f5064fb = C0564jv.m2555d("textures/gui/backshadow.png");

    /* JADX INFO: renamed from: fc */
    private static final ResourceLocation f5065fc = C0564jv.m2555d("textures/gui/effects/fade.png");

    /* JADX INFO: renamed from: fd */
    private static final ResourceLocation f5066fd = C0564jv.m2555d("textures/gui/effects/starburst.png");

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.gungame.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.gungame.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.gungame.tip.2"));
        return objectArrayList;
    }

    public C0956rP(@NotNull C0622l c0622l, @NotNull C0955rO c0955rO, @NotNull C0326fV c0326fV) {
        super(c0622l, c0955rO, c0326fV);
        c0622l.m2709a().m3222b(new C0719mr(c0955rO));
    }

    /* JADX INFO: renamed from: a */
    private void m5236a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, float f) {
        int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4272f, localPlayer.getUUID(), C1089tp.f5712C);
        if (iM4009a > ((C0955rO) this.f4272f).f5052bm.size()) {
            return;
        }
        C1144ur c1144urM5228a = ((C0955rO) this.f4272f).m5228a(iM4009a);
        C1144ur c1144urM5230c = ((C0955rO) this.f4272f).m5230c(iM4009a);
        C1144ur c1144urM5229b = ((C0955rO) this.f4272f).m5229b(iM4009a);
        boolean z = iM4009a >= ((C0955rO) this.f4272f).f5052bm.size();
        C0119bk.m443b(poseStack, guiGraphics, f5064fb, i, -10, 256, 256, 0.3f);
        C0119bk.m441b(poseStack, guiGraphics, f5065fc, i, -10, 256, 256);
        C0119bk.m442b(poseStack, guiGraphics, f5065fc, i, -10.0f, 128.0f, 128.0f, 0.5f);
        C0119bk.m444b(poseStack, guiGraphics, f5066fd, i, -60.0f, 256.0f, 256.0f, f / 5.0f, 0.5f);
        if (z) {
            C0119bk.m391b(poseStack, font, guiGraphics, f5062jl, i, 20, 2.0f);
            C0119bk.m391b(poseStack, font, guiGraphics, f5063jm, i, 45, 1.0f);
            return;
        }
        if (c1144urM5228a != null) {
            C0119bk.m501a(poseStack, guiGraphics, new ItemStack(c1144urM5228a), i, 50.0f, 4.0f);
        }
        if (c1144urM5229b != null) {
            int i2 = i + 60;
            C0119bk.m501a(poseStack, guiGraphics, new ItemStack(c1144urM5229b), i2, 50.0f, 2.0f);
            C0119bk.m391b(poseStack, font, guiGraphics, f5060jj, i2, 60, 0.5f);
        }
        if (c1144urM5230c != null) {
            int i3 = i - 60;
            C0119bk.m501a(poseStack, guiGraphics, new ItemStack(c1144urM5230c), i3, 50.0f, 2.0f);
            C0119bk.m391b(poseStack, font, guiGraphics, f5061jk, i3, 60, 0.5f);
        }
        if (c1144urM5228a != null) {
            C0119bk.m391b(poseStack, font, guiGraphics, f5059ji, i, 20, 1.5f);
            C0119bk.m383c(font, guiGraphics, (Component) Component.translatable(c1144urM5228a.asItem().getDescriptionId()).withStyle(ChatFormatting.BOLD), i, 70);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C0955rO, C0958rR>> mo3670w() {
        return List.of(new C0163cb(), new C0167cf());
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        if (((C0955rO) this.f4272f).mo3560a() == EnumC0795oN.GAME) {
            m5236a(localPlayer, poseStack, guiGraphics, font, i3, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3715a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo3715a(abstractC0790oI, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C0958rR c0958rRB = ((C0955rO) this.f4272f).m3582b();
        C0796oO c0796oOA2 = c0958rRB.m3793a(player.getUUID());
        String strM3053E = null;
        if ((livingEntity instanceof Player) && (c0796oOA = c0958rRB.m3793a(((Player) livingEntity).getUUID())) != null) {
            strM3053E = c0796oOA.getName();
        }
        if (livingEntity instanceof C0680mE) {
            strM3053E = ((C0680mE) livingEntity).m3053E();
        }
        if (c0796oOA2 != null && strM3053E != null) {
            return c0796oOA2.getName().equalsIgnoreCase(strM3053E);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bk */
    public boolean mo3721bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0124bp> mo3730b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA = ((C0955rO) this.f4272f).m3582b().m3793a(localPlayer.getUUID());
        if (c0796oOA == null) {
            return new ObjectArrayList();
        }
        Set<UUID> setM3872h = c0796oOA.m3872h();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Player player : clientLevel.players()) {
            UUID uuid = player.getUUID();
            if (set.contains(uuid) && !player.equals(localPlayer)) {
                boolean z = true;
                boolean zContains = setM3872h.contains(uuid);
                ResourceLocation resourceLocation = zContains ? C0124bp.f865M : C0124bp.f866N;
                if (!zContains && ((C0324fT) this.f4311b.m1133a(player)).m1646af() <= 0) {
                    z = false;
                }
                if (z) {
                    objectArrayList.add(new C0124bp(resourceLocation, player.position()).m625a(4).m623a(player.getYRot() - 180.0f));
                }
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bh */
    public boolean mo3717bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3731a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C0958rR c0958rRB = ((C0955rO) this.f4272f).m3582b();
        String strM3053E = null;
        C0796oO c0796oOA2 = c0958rRB.m3793a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0796oOA = c0958rRB.m3793a(entity.getUUID())) != null) {
            strM3053E = c0796oOA.getName();
        }
        C0680mE entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof C0680mE) {
            strM3053E = entity2.m3053E();
        }
        if (strM3053E != null && c0796oOA2 != null && strM3053E.equals(c0796oOA2.getName()) && player.hasLineOfSight(renderNameTagEvent.getEntity()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: g */
    public boolean mo3710g(@NotNull Player player) {
        return (player.getVehicle() == null && ((C0955rO) this.f4272f).mo3560a() == EnumC0795oN.GAME) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0788oG.a mo3711a() {
        return new AbstractC0788oG.a().m3765a("PING", (c0324fT, playerInfo, c0794oM) -> {
            return playerInfo != null ? C1293xp.m7912a(playerInfo.getLatency()) : "???";
        }).m3765a("K", (c0324fT2, playerInfo2, c0794oM2) -> {
            return C1293xp.m7912a(c0794oM2.m3853a(C1089tp.f5713D.getKey()));
        }).m3765a("A", (c0324fT3, playerInfo3, c0794oM3) -> {
            return C1293xp.m7912a(c0794oM3.m3853a(C1089tp.f5722M.getKey()));
        }).m3765a("SCORE", (c0324fT4, playerInfo4, c0794oM4) -> {
            return C1293xp.m7912a(c0794oM4.m3853a(C1089tp.f5695l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C0955rO) this.f4272f, z);
    }
}
