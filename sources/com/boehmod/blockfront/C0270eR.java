package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eR.class */
public class C0270eR<T extends AbstractClientPlayer> extends PlayerModel<T> {

    /* JADX INFO: renamed from: cp */
    private final boolean f2184cp;

    /* JADX INFO: renamed from: cq */
    static final /* synthetic */ boolean f2185cq;

    static {
        f2185cq = !C0270eR.class.desiredAssertionStatus();
    }

    public C0270eR(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
        this.f2184cp = z;
    }

    /* JADX INFO: renamed from: M */
    public boolean m1509M() {
        return this.f2184cp;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull T t, float f, float f2, float f3, float f4, float f5) {
        ItemStack mainHandItem = t.getMainHandItem();
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1117uP)) {
            ((AbstractClientPlayer) t).swinging = false;
        }
        this.head.zRot = 0.0f;
        super.setupAnim(t, f, f2, f3, f4, f5);
        Minecraft minecraft = Minecraft.getInstance();
        float fM466g = C0129bt.m466g() + t.getId();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2185cq && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        UUID uuid = t.getUUID();
        C0394gj c0394gj = (C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) t);
        if (!mainHandItem.isEmpty()) {
            InterfaceC1073tY item = mainHandItem.getItem();
            if (item instanceof InterfaceC1073tY) {
                item.mo5942a(minecraft, uuid.equals(minecraft.getUser().getProfileId()), this, c0394gj, t, fM466g, C1270xJ.m7188a(minecraft));
            }
        }
        this.leftSleeve.copyFrom(this.leftArm);
        this.rightSleeve.copyFrom(this.rightArm);
        this.leftPants.copyFrom(this.leftLeg);
        this.rightPants.copyFrom(this.rightLeg);
        this.hat.copyFrom(this.head);
        setAllVisible(true);
        if (c0623lM2852b.m2878a() != null || (t instanceof C0109bZ)) {
            this.hat.xScale = 0.92f;
            this.hat.yScale = 0.92f;
            this.hat.zScale = 0.92f;
            this.jacket.visible = false;
            this.leftSleeve.visible = false;
            this.rightSleeve.visible = false;
            this.leftPants.visible = false;
            this.rightPants.visible = false;
        }
    }
}
