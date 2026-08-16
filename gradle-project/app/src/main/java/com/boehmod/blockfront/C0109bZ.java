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

/* JADX INFO: renamed from: com.boehmod.blockfront.bZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bZ.class */
public class C0109bZ extends RemotePlayer {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1098tx f706a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final PlayerInfo f707a;

    /* JADX INFO: renamed from: dq */
    private final float f708dq;

    /* JADX INFO: renamed from: dQ */
    private int f709dQ;

    /* JADX INFO: renamed from: d */
    private Vec2 f710d;

    /* JADX INFO: renamed from: e */
    private Vec2 f711e;

    /* JADX INFO: renamed from: f */
    private Vec2 f712f;

    /* JADX INFO: renamed from: dR */
    private int f713dR;

    /* JADX INFO: renamed from: aR */
    static final /* synthetic */ boolean f714aR;

    static {
        f714aR = !C0109bZ.class.desiredAssertionStatus();
        f706a = C1098tx.m6173g();
    }

    public C0109bZ(@NotNull C0107bX c0107bX, @NotNull GameProfile gameProfile) {
        super(c0107bX, gameProfile);
        this.f709dQ = 20;
        this.f710d = Vec2.ZERO;
        this.f711e = Vec2.ZERO;
        this.f712f = Vec2.ZERO;
        this.f713dR = 0;
        this.f707a = new PlayerInfo(gameProfile, true);
        this.f708dq = C1270xJ.m7175a(0.4f, 0.8f);
    }

    /* JADX INFO: renamed from: s */
    public boolean m414s() {
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public FloatFloatPair m415a(float f) {
        return FloatFloatPair.of(C1270xJ.m7170f(this.f712f.x, this.f711e.x, f), C1270xJ.m7170f(this.f712f.y, this.f711e.y, f));
    }

    public boolean isInvisibleTo(@Nullable Player player) {
        return false;
    }

    public void calculateEntityAnimation(boolean z) {
    }

    public void tick() {
        super.tick();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f714aR && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0555jl c0555jlA = ((C0396gl) c0623lM2852b.m2855a()).mo1154a(this.uuid);
        this.walkAnimation.update(1.5f, 0.0f);
        this.walkAnimation.setSpeed(this.f708dq);
        setPos(-99.0d, -99.0d, -99.0d);
        this.xRotO = 0.0f;
        this.yRotO = 0.0f;
        this.yBodyRot = 0.0f;
        this.yBodyRotO = 0.0f;
        this.yHeadRot = 0.0f;
        this.yHeadRotO = 0.0f;
        setDeltaMovement(Vec3.ZERO);
        this.f711e = new Vec2(this.f712f.x, this.f712f.y);
        this.f712f = new Vec2(Mth.lerp(0.3f, this.f712f.x, this.f710d.x), Mth.lerp(0.3f, this.f712f.y, this.f710d.y));
        if (c0555jlA.m2510a() == PlayerDataType.DISPLAY) {
            int i = this.f713dR;
            this.f713dR = i - 1;
            if (i <= 0) {
                if (this.random.nextBoolean()) {
                    this.f713dR = 20 + this.random.nextInt(60);
                    this.f710d = new Vec2((-2.0f) + C1270xJ.m7175a(-20.0f, 20.0f), C1270xJ.m7175a(-25.0f, 25.0f));
                } else {
                    this.f710d = Vec2.ZERO;
                }
            }
        }
        this.f709dQ--;
        if (c0555jlA.m2510a() == PlayerDataType.DISPLAY) {
            if (getMainHandItem().isEmpty()) {
                f706a.m6182a(true).ifPresent(pair -> {
                    setItemInHand(InteractionHand.MAIN_HAND, ((C0837pB) pair.getLeft()).m3824e());
                });
                return;
            }
            return;
        }
        if (this.f709dQ <= 0) {
            this.f709dQ = 20;
            setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
            setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
            C0550jg inventory = c0555jlA.getInventory();
            CloudRegistry cloudRegistryA = c0623lM2852b.m2855a();
            for (CloudItemStack cloudItemStack : inventory.getItems()) {
                CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
                if (cloudItem != null) {
                    ItemStack itemStackM2530a = C0556jm.m2530a(cloudItem, cloudItemStack);
                    boolean zM2486a = inventory.m2486a(cloudRegistryA, cloudItemStack);
                    if ((cloudItem instanceof CloudItemMelee) && getItemInHand(InteractionHand.OFF_HAND).isEmpty() && zM2486a) {
                        setItemInHand(InteractionHand.OFF_HAND, itemStackM2530a);
                    } else if ((cloudItem instanceof CloudItemGun) && getItemInHand(InteractionHand.MAIN_HAND).isEmpty() && zM2486a) {
                        setItemInHand(InteractionHand.MAIN_HAND, itemStackM2530a);
                    }
                }
            }
        }
    }

    @NotNull
    protected PlayerInfo getPlayerInfo() {
        return this.f707a;
    }
}
