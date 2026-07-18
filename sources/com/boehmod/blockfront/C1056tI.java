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

/* JADX INFO: renamed from: com.boehmod.blockfront.tI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tI.class */
public final class C1056tI extends AbstractC1066tS implements InterfaceC1098ty, SingletonGeoAnimatable {

    /* JADX INFO: renamed from: df */
    @NotNull
    private static final String f5588df = "melee_controller";

    /* JADX INFO: renamed from: mw */
    private static final float f5590mw = 9.0f;

    /* JADX INFO: renamed from: mx */
    private static final float f5591mx = -1.4f;

    /* JADX INFO: renamed from: a */
    private final ItemAttributeModifiers f5593a;

    /* JADX INFO: renamed from: M */
    private C0417hG f5594M;

    /* JADX INFO: renamed from: aV */
    private DeferredHolder<SoundEvent, SoundEvent> f5595aV;

    /* JADX INFO: renamed from: rF */
    private int f5596rF;

    /* JADX INFO: renamed from: rG */
    private int f5597rG;

    /* JADX INFO: renamed from: rH */
    private int f5598rH;

    /* JADX INFO: renamed from: bV */
    @NotNull
    private static final List<DeferredHolder<SoundEvent, SoundEvent>> f5589bV = new ObjectArrayList();

    /* JADX INFO: renamed from: ak */
    public static final Vec3 f5592ak = new Vec3(-10.0d, 5.0d, 0.0d);

    static {
        f5589bV.add(C1280xc.f8242Cx);
    }

    public C1056tI(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, f5588df, properties);
        this.f5594M = C0418hH.f2687D;
        this.f5595aV = C1280xc.f8241Cw;
        this.f5596rF = 0;
        this.f5597rG = 0;
        this.f5598rH = 0;
        this.f5593a = ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9.0d, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -1.399999976158142d, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    /* JADX INFO: renamed from: bV */
    public int m5887bV() {
        if (this.f5597rG <= 0) {
            throw new IllegalArgumentException("Tricks count must be greater than 0");
        }
        return ThreadLocalRandom.current().nextInt(this.f5597rG);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1056tI m5888a(int i) {
        this.f5597rG = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1056tI m5889a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5595aV = deferredHolder;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1056tI m5890a(C0417hG c0417hG) {
        this.f5594M = c0417hG;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: I */
    private void m5891I(@NotNull Minecraft minecraft) {
        if (this.f5596rF <= 0) {
            this.f5596rF = 5;
            this.f5598rH = 0;
            m5961q("attack");
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) this.f5595aV.get(), 1.0f, 0.8f + (0.2f * ThreadLocalRandom.current().nextFloat())));
            C0415hE.m1960a(this.f5594M);
            this.f5613mz += 0.3f;
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5892a(@NotNull Minecraft minecraft, @NotNull Random random) {
        if (random.nextFloat() > 0.25f) {
            return;
        }
        int iM5887bV = m5887bV();
        m5961q("trick" + iM5887bV);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) f5589bV.get(iM5887bV).get(), 1.0f, 1.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @NotNull
    /* JADX INFO: renamed from: x */
    public Vec3 mo5893x() {
        return f5592ak;
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
        return this.f5593a;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        Minecraft minecraft = Minecraft.getInstance();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (entity == minecraft.player && level.isClientSide()) {
            boolean z2 = minecraft.player.getVehicle() instanceof AbstractC0779ny;
            if (this.f5596rF > 0) {
                this.f5596rF--;
            }
            if (z && !z2 && minecraft.player.swinging) {
                minecraft.player.swinging = false;
                m5891I(minecraft);
            }
            int i2 = this.f5598rH;
            this.f5598rH = i2 + 1;
            if (i2 >= 1200 && z) {
                this.f5598rH = 0;
                if (this.f5597rG > 0) {
                    m5892a(minecraft, threadLocalRandomCurrent);
                }
            }
        }
    }
}
