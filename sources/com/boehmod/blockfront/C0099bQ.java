package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import com.boehmod.bflib.cloud.common.item.types.CloudItemMelee;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.mojang.authlib.GameProfile;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import javax.annotation.Nullable;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bQ.class */
public class C0099bQ extends RemotePlayer {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1074ta f637a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final PlayerInfo f638a;

    /* JADX INFO: renamed from: dk */
    private final float f639dk;

    /* JADX INFO: renamed from: cY */
    private int f640cY;

    /* JADX INFO: renamed from: d */
    private Vec2 f641d;

    /* JADX INFO: renamed from: e */
    private Vec2 f642e;

    /* JADX INFO: renamed from: f */
    private Vec2 f643f;

    /* JADX INFO: renamed from: cZ */
    private int f644cZ;

    /* JADX INFO: renamed from: aM */
    static final /* synthetic */ boolean f645aM;

    static {
        f645aM = !C0099bQ.class.desiredAssertionStatus();
        f637a = C1074ta.m5970g();
    }

    public C0099bQ(@NotNull C0097bO c0097bO, @NotNull GameProfile gameProfile) {
        super(c0097bO, gameProfile);
        this.f640cY = 20;
        this.f641d = Vec2.ZERO;
        this.f642e = Vec2.ZERO;
        this.f643f = Vec2.ZERO;
        this.f644cZ = 0;
        this.f638a = new PlayerInfo(gameProfile, true);
        this.f639dk = C1290xm.m7848a(0.4f, 0.8f);
    }

    /* JADX INFO: renamed from: r */
    public boolean m309r() {
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public FloatFloatPair m310a(float f) {
        return FloatFloatPair.of(C1290xm.m7843e(this.f643f.x, this.f642e.x, f), C1290xm.m7843e(this.f643f.y, this.f642e.y, f));
    }

    public boolean isInvisibleTo(@Nullable Player player) {
        return false;
    }

    public void calculateEntityAnimation(boolean z) {
    }

    public void tick() {
        super.tick();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f645aM && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0482iS c0482iSA = ((C0326fV) c0622lM2667b.m2670a()).mo1137a(this.uuid);
        this.walkAnimation.update(1.5f, 0.0f);
        this.walkAnimation.setSpeed(this.f639dk);
        setPos(-99.0d, -99.0d, -99.0d);
        this.xRotO = 0.0f;
        this.yRotO = 0.0f;
        this.yBodyRot = 0.0f;
        this.yBodyRotO = 0.0f;
        this.yHeadRot = 0.0f;
        this.yHeadRotO = 0.0f;
        setDeltaMovement(Vec3.ZERO);
        this.f642e = new Vec2(this.f643f.x, this.f643f.y);
        this.f643f = new Vec2(Mth.lerp(0.3f, this.f643f.x, this.f641d.x), Mth.lerp(0.3f, this.f643f.y, this.f641d.y));
        if (c0482iSA.m2183a() == PlayerDataType.DISPLAY) {
            int i = this.f644cZ;
            this.f644cZ = i - 1;
            if (i <= 0) {
                if (this.random.nextBoolean()) {
                    this.f644cZ = 20 + this.random.nextInt(60);
                    this.f641d = new Vec2((-2.0f) + C1290xm.m7848a(-20.0f, 20.0f), C1290xm.m7848a(-25.0f, 25.0f));
                } else {
                    this.f641d = Vec2.ZERO;
                }
            }
        }
        this.f640cY--;
        if (c0482iSA.m2183a() == PlayerDataType.DISPLAY) {
            if (getMainHandItem().isEmpty()) {
                f637a.m5979a(true).ifPresent(pair -> {
                    setItemInHand(InteractionHand.MAIN_HAND, ((C0866pf) pair.getLeft()).m4339c());
                });
                return;
            }
            return;
        }
        if (this.f640cY <= 0) {
            this.f640cY = 20;
            setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
            setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
            C0477iN inventory = c0482iSA.getInventory();
            CloudRegistry cloudRegistryA = c0622lM2667b.m2670a();
            for (CloudItemStack cloudItemStack : inventory.getItems()) {
                CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
                if (cloudItem != null) {
                    ItemStack itemStackM2203a = C0483iT.m2203a(cloudItem, cloudItemStack);
                    boolean zM2159a = inventory.m2159a(cloudRegistryA, cloudItemStack);
                    if ((cloudItem instanceof CloudItemMelee) && getItemInHand(InteractionHand.OFF_HAND).isEmpty() && zM2159a) {
                        setItemInHand(InteractionHand.OFF_HAND, itemStackM2203a);
                    } else if ((cloudItem instanceof CloudItemGun) && getItemInHand(InteractionHand.MAIN_HAND).isEmpty() && zM2159a) {
                        setItemInHand(InteractionHand.MAIN_HAND, itemStackM2203a);
                    }
                }
            }
        }
    }

    @NotNull
    protected PlayerInfo getPlayerInfo() {
        return this.f638a;
    }
}
