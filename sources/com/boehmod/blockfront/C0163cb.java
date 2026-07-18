package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cb.class */
public class C0163cb<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0103bU<G, P> {

    /* JADX INFO: renamed from: aj */
    @NotNull
    private static final ResourceLocation f1321aj;

    /* JADX INFO: renamed from: ak */
    @NotNull
    private static final ResourceLocation f1322ak;

    /* JADX INFO: renamed from: aT */
    @NotNull
    private static final Component f1323aT;

    /* JADX INFO: renamed from: aU */
    @NotNull
    private static final Component f1324aU;

    /* JADX INFO: renamed from: aP */
    static final /* synthetic */ boolean f1325aP;

    static {
        f1325aP = !C0163cb.class.desiredAssertionStatus();
        f1321aj = C0564jv.m2555d("textures/text/team_allies.png");
        f1322ak = C0564jv.m2555d("textures/text/team_axis.png");
        f1323aT = Component.translatable("bf.message.no.team");
        f1324aU = Component.translatable("bf.message.spectating").withStyle(ChatFormatting.GRAY);
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo319a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0788oG<G, P> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        C0796oO c0796oOM3793a = g.m3582b().m3793a(localPlayer.getUUID());
        if (c0796oOM3793a != null) {
            MutableComponent mutableComponentWithColor = Component.literal(c0796oOM3793a.getName()).withColor(c0796oOM3793a.getColor());
            m327a(c0796oOM3793a.m3880bp() ? f1321aj : f1322ak);
            m329a((Component) mutableComponentWithColor);
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f1325aP && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zM2690e = c0622lM2667b.m2690e();
        m327a((ResourceLocation) null);
        m329a(zM2690e ? f1324aU : f1323aT);
    }
}
