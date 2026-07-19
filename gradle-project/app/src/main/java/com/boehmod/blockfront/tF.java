package com.boehmod.blockfront;

import com.boehmod.blockfront.cK;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tF.class */
public class tF extends Item {
    public static final double aG = 64.0d;

    public tF(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            b.e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tF$b.class */
    @OnlyIn(Dist.CLIENT)
    public static final class b {
        private b() {
        }

        @NotNull
        public static a a() {
            return (a) hN.f159b.a();
        }

        public static void H(@NotNull Minecraft minecraft) {
            hN.f159b.a(a().next());
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (abstractC0264juM166a instanceof C0297l) {
                hQ.d((C0297l) abstractC0264juM166a);
            }
            minecraft.player.playSound((SoundEvent) SoundEvents.NOTE_BLOCK_CHIME.value(), 0.8f + (0.3f * r0.ordinal()), 1.0f);
        }

        public static void e(@NotNull Player player) {
            Minecraft minecraft = Minecraft.getInstance();
            switch (a()) {
                case CREATE_INDEPENDENT:
                    b(minecraft, a(player));
                    break;
                case CREATE_REFERENCED:
                    a(minecraft, a(player));
                    break;
                case EDIT_TEMPLATES:
                    minecraft.setScreen(new cM(null));
                    break;
            }
        }

        @NotNull
        public static Vec3 a(@NotNull Player player) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation();
        }

        private static void a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3) {
            ObjectArrayList objectArrayList = new ObjectArrayList(C0378o.a());
            objectArrayList.sort(Comparator.naturalOrder());
            if (objectArrayList.isEmpty()) {
                minecraft.player.displayClientMessage(Component.translatable("bf.message.template.none.available"), true);
            } else {
                minecraft.setScreen(new cN(null, Component.translatable("bf.menu.picker.select.template"), objectArrayList, str -> {
                    return str;
                }, Component::literal, null, str2 -> {
                    if (str2 == null) {
                        return;
                    }
                    C0582vo.c(new C0577vj(str2, vec3));
                }));
            }
        }

        private static void b(@NotNull Minecraft minecraft, @NotNull Vec3 vec3) {
            ObjectArrayList objectArrayList = new ObjectArrayList(pC.l());
            objectArrayList.sort(Comparator.naturalOrder());
            minecraft.setScreen(new cN(null, Component.translatable("bf.menu.picker.select.map.effect.type"), objectArrayList, str -> {
                return str;
            }, str2 -> {
                return cK.a(str2);
            }, null, str3 -> {
                if (str3 == null) {
                    return;
                }
                c(str3, vec3);
            }));
        }

        private static void c(@NotNull String str, @NotNull Vec3 vec3) {
            try {
                try {
                    pA pAVar = (pA) pC.a(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    pAVar.c = vec3;
                    Minecraft.getInstance().setScreen(new cK(null, pAVar, cK.b.CREATE));
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException("Failed to instantiate map effect type " + str + ", every registered type must expose a public no-arg constructor", e);
                }
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tF$a.class */
    public enum a implements hL {
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

        @Override // com.boehmod.blockfront.hL
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
