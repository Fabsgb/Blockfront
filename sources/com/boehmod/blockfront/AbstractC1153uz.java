package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uz.class */
public abstract class AbstractC1153uz extends C1136ui implements InterfaceC1128ua, InterfaceC1148uu {

    /* JADX INFO: renamed from: tR */
    public static int f6281tR;

    /* JADX INFO: renamed from: hY */
    static final /* synthetic */ boolean f6282hY;

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract boolean mo6196a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack);

    /* JADX INFO: renamed from: cl */
    public abstract int mo6199cl();

    @NotNull
    /* JADX INFO: renamed from: x */
    public abstract SoundEvent mo6200x();

    /* JADX INFO: renamed from: cj */
    public abstract int mo6197cj();

    @NotNull
    /* JADX INFO: renamed from: az */
    public abstract String mo6198az();

    public abstract int getColor();

    @NotNull
    public abstract ResourceLocation getIcon();

    static {
        f6282hY = !AbstractC1153uz.class.desiredAssertionStatus();
        f6281tR = 0;
    }

    public AbstractC1153uz(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    /* JADX INFO: renamed from: a */
    public void mo6579a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        Object objMo2354a = abstractC0531jN.mo2354a(player.getUUID());
        if (objMo2354a instanceof InterfaceC0988ru) {
            InterfaceC0988ru interfaceC0988ru = (InterfaceC0988ru) objMo2354a;
            if (interfaceC0988ru.mo5566a((Level) serverLevel, player, abstractC1153uz, itemStack)) {
                interfaceC0988ru.mo5567a(serverLevel, player, abstractC1153uz, itemStack);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (level.isClientSide() && z) {
                Vec3 deltaMovement = player.getDeltaMovement();
                Vec3 vec3Position = player.position();
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f6282hY && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
                AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
                C0394gj c0394gj = (C0394gj) c0396gl.m1150a(player);
                boolean z2 = abstractC0863pbM2874a == 0 || mo6196a(c0623lM2852b, abstractC0863pbM2874a, level, player, this, itemStack);
                if (C0875pn.m4488a(player, c0394gj)) {
                    z2 = false;
                }
                if ((abstractC0863pbM2874a instanceof InterfaceC0988ru) && !((InterfaceC0988ru) abstractC0863pbM2874a).mo5566a(level, player, this, itemStack)) {
                    z2 = false;
                }
                if (!z2) {
                    f6281tR = 0;
                    return;
                }
                if (Minecraft.getInstance().mouseHandler.isRightPressed()) {
                    entity.setDeltaMovement(0.0d, deltaMovement.y, 0.0d);
                    entity.setPos(entity.xOld, entity.yOld, entity.zOld);
                    if (f6281tR == 4) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.BLOCKS, 1.0f, 1.5f, false);
                    }
                    if (f6281tR % mo6199cl() == 0 && f6281tR != 0) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, mo6200x(), SoundSource.BLOCKS, 1.0f, (float) (0.800000011920929d + (0.4000000059604645d * Math.random())), false);
                    }
                    int i2 = f6281tR;
                    f6281tR = i2 + 1;
                    if (i2 >= mo6197cj()) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.BLOCKS, 1.0f, 1.2f, false);
                        C1169vO.m6648c(new C1259wz());
                        f6281tR = -10;
                        return;
                    }
                    return;
                }
                f6281tR = 0;
            }
        }
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return f6281tR <= 0 || f6281tR % mo6199cl() == 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC1128ua
    /* JADX INFO: renamed from: by */
    public int mo6471by() {
        return f6281tR;
    }
}
