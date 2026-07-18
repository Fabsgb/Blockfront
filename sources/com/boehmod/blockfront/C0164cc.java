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

/* JADX INFO: renamed from: com.boehmod.blockfront.cc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cc.class */
public class C0164cc<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0103bU<G, P> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1088to f1326a;

    /* JADX INFO: renamed from: dd */
    private final int f1327dd;

    public C0164cc(@NotNull ResourceLocation resourceLocation, @NotNull C1088to c1088to, int i) {
        this.f1326a = c1088to;
        this.f1327dd = i;
        super.m327a(resourceLocation);
    }

    public C0164cc(@NotNull ResourceLocation resourceLocation, @NotNull C1088to c1088to) {
        this(resourceLocation, c1088to, 0);
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo319a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0788oG<G, P> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        MutableComponent mutableComponentLiteral;
        int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) g, localPlayer.getUUID(), this.f1326a);
        if (this.f1327dd > 0) {
            mutableComponentLiteral = Component.literal(C1293xp.m7912a(iM4009a)).append(Component.literal(" / ").withStyle(ChatFormatting.GRAY)).append(Component.literal(C1293xp.m7912a(this.f1327dd)));
        } else {
            mutableComponentLiteral = Component.literal(C1293xp.m7912a(iM4009a));
        }
        m329a((Component) mutableComponentLiteral);
    }
}
