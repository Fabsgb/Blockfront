package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eE.class */
public class C0256eE<T extends AbstractClientPlayer> extends PlayerModel<T> {

    /* JADX INFO: renamed from: ch */
    private final boolean f2065ch;

    /* JADX INFO: renamed from: ci */
    static final /* synthetic */ boolean f2066ci;

    static {
        f2066ci = !C0256eE.class.desiredAssertionStatus();
    }

    public C0256eE(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
        this.f2065ch = z;
    }

    /* JADX INFO: renamed from: L */
    public boolean m1430L() {
        return this.f2065ch;
    }

    /* JADX INFO: renamed from: a */
    public void setupAnim(@NotNull T t, float f, float f2, float f3, float f4, float f5) {
        ItemStack mainHandItem = t.getMainHandItem();
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1144ur)) {
            ((AbstractClientPlayer) t).swinging = false;
        }
        this.head.zRot = 0.0f;
        super.setupAnim(t, f, f2, f3, f4, f5);
        Minecraft minecraft = Minecraft.getInstance();
        float fM366g = C0119bk.m366g() + t.getId();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2066ci && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        UUID uuid = t.getUUID();
        C0324fT c0324fT = (C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) t);
        if (!mainHandItem.isEmpty()) {
            InterfaceC1048tA item = mainHandItem.getItem();
            if (item instanceof InterfaceC1048tA) {
                item.mo5828a(minecraft, uuid.equals(minecraft.getUser().getProfileId()), this, c0324fT, t, fM366g, C1290xm.m7861a(minecraft));
            }
        }
        this.leftSleeve.copyFrom(this.leftArm);
        this.rightSleeve.copyFrom(this.rightArm);
        this.leftPants.copyFrom(this.leftLeg);
        this.rightPants.copyFrom(this.rightLeg);
        this.hat.copyFrom(this.head);
        setAllVisible(true);
        if (c0622lM2667b.m2692a() != null || (t instanceof C0099bQ)) {
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
