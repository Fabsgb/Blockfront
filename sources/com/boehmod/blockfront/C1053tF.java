package com.boehmod.blockfront;

import com.boehmod.blockfront.C0146cK;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Comparator;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tF.class */
public class C1053tF extends Item {

    /* JADX INFO: renamed from: aG */
    public static final double f5570aG = 64.0d;

    public C1053tF(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            b.m5850e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tF$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tF$b.class */
    @OnlyIn(Dist.CLIENT)
    public static final class b {
        private b() {
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static a m5848a() {
            return (a) C0424hN.f2770b.m1987a();
        }

        /* JADX INFO: renamed from: H */
        public static void m5849H(@NotNull Minecraft minecraft) {
            C0424hN.f2770b.m1988a(m5848a().next());
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (abstractC0563juM168a instanceof C0622l) {
                C0427hQ.m2004d((C0622l) abstractC0563juM168a);
            }
            minecraft.player.playSound((SoundEvent) SoundEvents.NOTE_BLOCK_CHIME.value(), 0.8f + (0.3f * r0.ordinal()), 1.0f);
        }

        /* JADX INFO: renamed from: e */
        public static void m5850e(@NotNull Player player) {
            Minecraft minecraft = Minecraft.getInstance();
            switch (m5848a()) {
                case CREATE_INDEPENDENT:
                    m5853b(minecraft, m5851a(player));
                    break;
                case CREATE_REFERENCED:
                    m5852a(minecraft, m5851a(player));
                    break;
                case EDIT_TEMPLATES:
                    minecraft.setScreen(new C0148cM(null));
                    break;
            }
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static Vec3 m5851a(@NotNull Player player) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation();
        }

        /* JADX INFO: renamed from: a */
        private static void m5852a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3) {
            ObjectArrayList objectArrayList = new ObjectArrayList(C0781o.m3547a());
            objectArrayList.sort(Comparator.naturalOrder());
            if (objectArrayList.isEmpty()) {
                minecraft.player.displayClientMessage(Component.translatable("bf.message.template.none.available"), true);
            } else {
                minecraft.setScreen(new C0149cN(null, Component.translatable("bf.menu.picker.select.template"), objectArrayList, str -> {
                    return str;
                }, Component::literal, null, str2 -> {
                    if (str2 == null) {
                        return;
                    }
                    C1194vo.m6653c(new C1189vj(str2, vec3));
                }));
            }
        }

        /* JADX INFO: renamed from: b */
        private static void m5853b(@NotNull Minecraft minecraft, @NotNull Vec3 vec3) {
            ObjectArrayList objectArrayList = new ObjectArrayList(C0837pC.m4263l());
            objectArrayList.sort(Comparator.naturalOrder());
            minecraft.setScreen(new C0149cN(null, Component.translatable("bf.menu.picker.select.map.effect.type"), objectArrayList, str -> {
                return str;
            }, str2 -> {
                return C0146cK.m842a(str2);
            }, null, str3 -> {
                if (str3 == null) {
                    return;
                }
                m5854c(str3, vec3);
            }));
        }

        /* JADX INFO: renamed from: c */
        private static void m5854c(@NotNull String str, @NotNull Vec3 vec3) {
            try {
                try {
                    AbstractC0835pA abstractC0835pA = (AbstractC0835pA) C0837pC.m4261a(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    abstractC0835pA.f4464c = vec3;
                    Minecraft.getInstance().setScreen(new C0146cK(null, abstractC0835pA, C0146cK.b.CREATE));
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException("Failed to instantiate map effect type " + str + ", every registered type must expose a public no-arg constructor", e);
                }
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tF$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tF$a.class */
    public enum a implements InterfaceC0422hL {
        CREATE_INDEPENDENT("Create Effect", -1, "create_independent"),
        CREATE_REFERENCED("Reference Template", -8335105, "create_referenced"),
        EDIT_TEMPLATES("Edit Templates", -12224, "edit_templates");


        @NotNull
        private final String displayName;
        private final int displayColor;

        @NotNull
        private final String settingsKey;

        a(@NotNull String str, int i, @NotNull String str2) {
            this.displayName = str;
            this.displayColor = i;
            this.settingsKey = str2;
        }

        @NotNull
        public String displayName() {
            return this.displayName;
        }

        public int displayColor() {
            return this.displayColor;
        }

        @Override // com.boehmod.blockfront.InterfaceC0422hL
        @NotNull
        public String getSettingsKey() {
            return this.settingsKey;
        }

        @NotNull
        public a next() {
            a[] aVarArrValues = values();
            return aVarArrValues[(ordinal() + 1) % aVarArrValues.length];
        }
    }
}
