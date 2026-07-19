package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cb.class */
public class C0058cb<G extends oF<G, P, ?>, P extends oI<G>> extends bU<G, P> {

    @NotNull
    private static final ResourceLocation aj;

    @NotNull
    private static final ResourceLocation ak;

    @NotNull
    private static final Component aT;

    @NotNull
    private static final Component aU;
    static final /* synthetic */ boolean aP;

    static {
        aP = !C0058cb.class.desiredAssertionStatus();
        aj = C0265jv.d("textures/text/team_allies.png");
        ak = C0265jv.d("textures/text/team_axis.png");
        aT = Component.translatable("bf.message.no.team");
        aU = Component.translatable("bf.message.spectating").withStyle(ChatFormatting.GRAY);
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull oG<G, P> oGVar, @NotNull LocalPlayer localPlayer) {
        oO oOVarA = g.b().a(localPlayer.getUUID());
        if (oOVarA != null) {
            MutableComponent mutableComponentWithColor = Component.literal(oOVarA.getName()).withColor(oOVarA.getColor());
            a(oOVarA.bp() ? aj : ak);
            a((Component) mutableComponentWithColor);
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!aP && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zE = c0297lB.e();
        a((ResourceLocation) null);
        a(zE ? aU : aT);
    }
}
