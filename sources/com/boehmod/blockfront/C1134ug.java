package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ug */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ug.class */
public final class C1134ug extends AbstractC1144uq implements InterfaceC1071tW, SingletonGeoAnimatable {

    /* JADX INFO: renamed from: dq */
    @NotNull
    private static final String f6227dq = "melee_controller";

    /* JADX INFO: renamed from: nv */
    private static final float f6229nv = 9.0f;

    /* JADX INFO: renamed from: nw */
    private static final float f6230nw = -1.4f;

    /* JADX INFO: renamed from: a */
    private final ItemAttributeModifiers f6232a;

    /* JADX INFO: renamed from: N */
    private C0434hW f6233N;

    /* JADX INFO: renamed from: aV */
    private DeferredHolder<SoundEvent, SoundEvent> f6234aV;

    /* JADX INFO: renamed from: tI */
    private int f6235tI;

    /* JADX INFO: renamed from: tJ */
    private int f6236tJ;

    /* JADX INFO: renamed from: tK */
    private int f6237tK;

    /* JADX INFO: renamed from: cc */
    @NotNull
    private static final List<DeferredHolder<SoundEvent, SoundEvent>> f6228cc = new ObjectArrayList();

    /* JADX INFO: renamed from: al */
    public static final Vec3 f6231al = new Vec3(-10.0d, 5.0d, 0.0d);

    static {
        f6228cc.add(C1312xz.f8655CA);
    }

    public C1134ug(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, f6227dq, properties);
        this.f6233N = C0435hX.f2780D;
        this.f6234aV = C1312xz.f8654Cz;
        this.f6235tI = 0;
        this.f6236tJ = 0;
        this.f6237tK = 0;
        this.f6232a = ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9.0d, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -1.399999976158142d, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    /* JADX INFO: renamed from: ck */
    public int m6523ck() {
        if (this.f6236tJ <= 0) {
            throw new IllegalArgumentException("Tricks count must be greater than 0");
        }
        return ThreadLocalRandom.current().nextInt(this.f6236tJ);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1134ug m6524a(int i) {
        this.f6236tJ = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1134ug m6525a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6234aV = deferredHolder;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1134ug m6526a(C0434hW c0434hW) {
        this.f6233N = c0434hW;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: K */
    private void m6527K(@NotNull Minecraft minecraft) {
        if (this.f6235tI <= 0) {
            this.f6235tI = 5;
            this.f6237tK = 0;
            m6578q("attack");
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) this.f6234aV.get(), 1.0f, 0.8f + (0.2f * ThreadLocalRandom.current().nextFloat())));
            C0432hU.m1986a(this.f6233N);
            this.f6252ny += 0.3f;
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m6528a(@NotNull Minecraft minecraft, @NotNull Random random) {
        if (random.nextFloat() > 0.25f) {
            return;
        }
        int iM6523ck = m6523ck();
        m6578q("trick" + iM6523ck);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) f6228cc.get(iM6523ck).get(), 1.0f, 1.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @NotNull
    /* JADX INFO: renamed from: y */
    public Vec3 mo6195y() {
        return f6231al;
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(interactionHand));
    }

    public boolean canAttackBlock(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player) {
        return false;
    }

    @NotNull
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.f6232a;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        Minecraft minecraft = Minecraft.getInstance();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (entity == minecraft.player && level.isClientSide()) {
            boolean z2 = minecraft.player.getVehicle() instanceof AbstractC0750nU;
            if (this.f6235tI > 0) {
                this.f6235tI--;
            }
            if (z && !z2 && minecraft.player.swinging) {
                minecraft.player.swinging = false;
                m6527K(minecraft);
            }
            int i2 = this.f6237tK;
            this.f6237tK = i2 + 1;
            if (i2 >= 1200 && z) {
                this.f6237tK = 0;
                if (this.f6236tJ > 0) {
                    m6528a(minecraft, threadLocalRandomCurrent);
                }
            }
        }
    }
}
