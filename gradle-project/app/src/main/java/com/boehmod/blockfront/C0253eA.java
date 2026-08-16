package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.challenge.Challenge;
import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eA.class */
public class C0253eA extends AbstractC0302ex {

    /* JADX INFO: renamed from: jm */
    private static final int f2080jm = 2005436552;

    /* JADX INFO: renamed from: cj */
    @NotNull
    private static final ResourceLocation f2079cj = C0532jO.m2378d("textures/gui/menu/icons/challenges.png");

    /* JADX INFO: renamed from: hD */
    @NotNull
    private static final Component f2081hD = Component.translatable("bf.menu.dailychallenge.title").withColor(ColorReferences.COLOR_THEME_YELLOW);

    /* JADX INFO: renamed from: hE */
    @NotNull
    private static final Component f2082hE = Component.translatable("bf.menu.dailychallenge.description").withStyle(ChatFormatting.GRAY);

    public C0253eA(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, f2081hD);
        m1634a();
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        boolean z = m1442a(c0623l) && !c0555jl.getChallenges().isEmpty();
        C0129bt.m591c(guiGraphics, getX(), getY(), this.width, this.height, C0129bt.m465t());
        C0129bt.m515a(guiGraphics, getX(), getY(), this.width, this.height, z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : f2080jm);
        C0129bt.m531a(guiGraphics.pose(), guiGraphics, f2079cj, getX(), getY(), this.width, this.height);
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1441a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0555jl c0555jl) {
        ObjectList<Challenge> challenges = c0555jl.getChallenges();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (!m1442a(c0623l) || challenges.isEmpty()) {
            objectArrayList.add(f2081hD);
            objectArrayList.add(f2082hE);
        } else {
            long jCount = challenges.stream().filter((v0) -> {
                return v0.isCompleted();
            }).count();
            MutableComponent mutableComponentCopy = f2081hD.copy();
            challenges.size();
            objectArrayList.add(mutableComponentCopy.append(Component.literal(" (" + jCount + "/" + objectArrayList + ")").withStyle(ChatFormatting.GRAY)));
            ObjectListIterator it = challenges.iterator();
            while (it.hasNext()) {
                Challenge challenge = (Challenge) it.next();
                objectArrayList.add(Component.literal(C0547jd.m2475a(challenge).getString()).withStyle(challenge.isCompleted() ? ChatFormatting.GREEN : ChatFormatting.GRAY));
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1442a(@NotNull C0623l c0623l) {
        return ((C0358g) c0623l.m2852b()).m1722a().isConnected();
    }
}
