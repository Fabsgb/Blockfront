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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tI.class */
public final class tI extends tS implements InterfaceC0538ty, SingletonGeoAnimatable {

    @NotNull
    private static final String df = "melee_controller";
    private static final float mw = 9.0f;
    private static final float mx = -1.4f;
    private final ItemAttributeModifiers a;
    private hG M;
    private DeferredHolder<SoundEvent, SoundEvent> aV;
    private int rF;
    private int rG;
    private int rH;

    @NotNull
    private static final List<DeferredHolder<SoundEvent, SoundEvent>> bV = new ObjectArrayList();
    public static final Vec3 ak = new Vec3(-10.0d, 5.0d, 0.0d);

    static {
        bV.add(C0624xc.Cx);
    }

    public tI(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, df, properties);
        this.M = hH.D;
        this.aV = C0624xc.Cw;
        this.rF = 0;
        this.rG = 0;
        this.rH = 0;
        this.a = ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9.0d, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -1.399999976158142d, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public int bV() {
        if (this.rG <= 0) {
            throw new IllegalArgumentException("Tricks count must be greater than 0");
        }
        return ThreadLocalRandom.current().nextInt(this.rG);
    }

    @NotNull
    public tI a(int i) {
        this.rG = i;
        return this;
    }

    @NotNull
    public tI a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.aV = deferredHolder;
        return this;
    }

    @NotNull
    public tI a(hG hGVar) {
        this.M = hGVar;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    private void I(@NotNull Minecraft minecraft) {
        if (this.rF <= 0) {
            this.rF = 5;
            this.rH = 0;
            q("attack");
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) this.aV.get(), 1.0f, 0.8f + (0.2f * ThreadLocalRandom.current().nextFloat())));
            hE.a(this.M);
            this.mz += 0.3f;
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull Random random) {
        if (random.nextFloat() > 0.25f) {
            return;
        }
        int iBV = bV();
        q("trick" + iBV);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) bV.get(iBV).get(), 1.0f, 1.0f));
    }

    @Override // com.boehmod.blockfront.tO
    @NotNull
    public Vec3 x() {
        return ak;
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
        return this.a;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        Minecraft minecraft = Minecraft.getInstance();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (entity == minecraft.player && level.isClientSide()) {
            boolean z2 = minecraft.player.getVehicle() instanceof AbstractC0376ny;
            if (this.rF > 0) {
                this.rF--;
            }
            if (z && !z2 && minecraft.player.swinging) {
                minecraft.player.swinging = false;
                I(minecraft);
            }
            int i2 = this.rH;
            this.rH = i2 + 1;
            if (i2 >= 1200 && z) {
                this.rH = 0;
                if (this.rG > 0) {
                    a(minecraft, threadLocalRandomCurrent);
                }
            }
        }
    }
}
