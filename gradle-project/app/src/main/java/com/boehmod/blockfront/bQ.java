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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bQ.class */
public class bQ extends RemotePlayer {

    @NotNull
    public static final C0514ta a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final PlayerInfo f56a;
    private final float dk;
    private int cY;
    private Vec2 d;
    private Vec2 e;
    private Vec2 f;
    private int cZ;
    static final /* synthetic */ boolean aM;

    static {
        aM = !bQ.class.desiredAssertionStatus();
        a = C0514ta.g();
    }

    public bQ(@NotNull bO bOVar, @NotNull GameProfile gameProfile) {
        super(bOVar, gameProfile);
        this.cY = 20;
        this.d = Vec2.ZERO;
        this.e = Vec2.ZERO;
        this.f = Vec2.ZERO;
        this.cZ = 0;
        this.f56a = new PlayerInfo(gameProfile, true);
        this.dk = C0634xm.a(0.4f, 0.8f);
    }

    public boolean r() {
        return false;
    }

    @NotNull
    public FloatFloatPair a(float f) {
        return FloatFloatPair.of(C0634xm.e(this.f.x, this.e.x, f), C0634xm.e(this.f.y, this.e.y, f));
    }

    public boolean isInvisibleTo(@Nullable Player player) {
        return false;
    }

    public void calculateEntityAnimation(boolean z) {
    }

    public void tick() {
        super.tick();
        C0297l c0297lB = C0297l.b();
        if (!aM && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        iS iSVarA = ((fV) c0297lB.a()).mo306a(this.uuid);
        this.walkAnimation.update(1.5f, 0.0f);
        this.walkAnimation.setSpeed(this.dk);
        setPos(-99.0d, -99.0d, -99.0d);
        this.xRotO = 0.0f;
        this.yRotO = 0.0f;
        this.yBodyRot = 0.0f;
        this.yBodyRotO = 0.0f;
        this.yHeadRot = 0.0f;
        this.yHeadRotO = 0.0f;
        setDeltaMovement(Vec3.ZERO);
        this.e = new Vec2(this.f.x, this.f.y);
        this.f = new Vec2(Mth.lerp(0.3f, this.f.x, this.d.x), Mth.lerp(0.3f, this.f.y, this.d.y));
        if (iSVarA.a() == PlayerDataType.DISPLAY) {
            int i = this.cZ;
            this.cZ = i - 1;
            if (i <= 0) {
                if (this.random.nextBoolean()) {
                    this.cZ = 20 + this.random.nextInt(60);
                    this.d = new Vec2((-2.0f) + C0634xm.a(-20.0f, 20.0f), C0634xm.a(-25.0f, 25.0f));
                } else {
                    this.d = Vec2.ZERO;
                }
            }
        }
        this.cY--;
        if (iSVarA.a() == PlayerDataType.DISPLAY) {
            if (getMainHandItem().isEmpty()) {
                a.a(true).ifPresent(pair -> {
                    setItemInHand(InteractionHand.MAIN_HAND, ((C0411pf) pair.getLeft()).c());
                });
                return;
            }
            return;
        }
        if (this.cY <= 0) {
            this.cY = 20;
            setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
            setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
            iN inventory = iSVarA.getInventory();
            CloudRegistry cloudRegistryA = c0297lB.a();
            for (CloudItemStack cloudItemStack : inventory.getItems()) {
                CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
                if (cloudItem != null) {
                    ItemStack itemStackA = iT.a(cloudItem, cloudItemStack);
                    boolean zA = inventory.a(cloudRegistryA, cloudItemStack);
                    if ((cloudItem instanceof CloudItemMelee) && getItemInHand(InteractionHand.OFF_HAND).isEmpty() && zA) {
                        setItemInHand(InteractionHand.OFF_HAND, itemStackA);
                    } else if ((cloudItem instanceof CloudItemGun) && getItemInHand(InteractionHand.MAIN_HAND).isEmpty() && zA) {
                        setItemInHand(InteractionHand.MAIN_HAND, itemStackA);
                    }
                }
            }
        }
    }

    @NotNull
    protected PlayerInfo getPlayerInfo() {
        return this.f56a;
    }
}
