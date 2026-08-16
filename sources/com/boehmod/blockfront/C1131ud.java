package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.ud */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ud.class */
public class C1131ud extends Item {

    /* JADX INFO: renamed from: aT */
    public static final double f6209aT = 64.0d;

    public C1131ud(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            b.m6486e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ud$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ud$b.class */
    @OnlyIn(Dist.CLIENT)
    public static final class b {
        private b() {
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static a m6484a() {
            return (a) C0495ie.f3071b.m2018a();
        }

        /* JADX INFO: renamed from: J */
        public static void m6485J(@NotNull Minecraft minecraft) {
            a next = m6484a().next();
            C0495ie.f3071b.m2019a(next);
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (abstractC0531jNM179a instanceof C0623l) {
                C0498ih.m2238e((C0623l) abstractC0531jNM179a);
            }
            minecraft.player.playSound((SoundEvent) SoundEvents.NOTE_BLOCK_CHIME.value(), 0.8f + (0.3f * next.ordinal()), 1.0f);
        }

        /* JADX INFO: renamed from: e */
        public static void m6486e(@NotNull Player player) {
            Minecraft minecraft = Minecraft.getInstance();
            switch (m6484a()) {
                case CREATE_INDEPENDENT:
                    m6489b(minecraft, m6487a(player));
                    break;
                case CREATE_REFERENCED:
                    m6488a(minecraft, m6487a(player));
                    break;
                case EDIT_TEMPLATES:
                    minecraft.setScreen(new C0158cV(null));
                    break;
            }
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static Vec3 m6487a(@NotNull Player player) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation();
        }

        /* JADX INFO: renamed from: a */
        private static void m6488a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3) {
            ObjectArrayList objectArrayList = new ObjectArrayList(C0782o.m3663a());
            objectArrayList.sort(Comparator.naturalOrder());
            if (objectArrayList.isEmpty()) {
                minecraft.player.displayClientMessage(Component.translatable("bf.message.template.none.available"), true);
            } else {
                minecraft.setScreen(new C0159cW(null, Component.translatable("bf.menu.picker.select.template"), objectArrayList, str -> {
                    return str;
                }, Component::literal, null, str2 -> {
                    if (str2 == null) {
                        return;
                    }
                    C1169vO.m6648c(new C1164vJ(str2, vec3));
                }));
            }
        }

        /* JADX INFO: renamed from: b */
        private static void m6489b(@NotNull Minecraft minecraft, @NotNull Vec3 vec3) {
            ObjectArrayList objectArrayList = new ObjectArrayList(C0860pY.m3993l());
            objectArrayList.sort(Comparator.naturalOrder());
            minecraft.setScreen(new C0159cW(null, Component.translatable("bf.menu.picker.select.map.effect.type"), objectArrayList, str -> {
                return str;
            }, str2 -> {
                return C0156cT.m896a(str2);
            }, null, str3 -> {
                if (str3 == null) {
                    return;
                }
                m6490c(str3, vec3);
            }));
        }

        /* JADX INFO: renamed from: c */
        private static void m6490c(@NotNull String str, @NotNull Vec3 vec3) {
            try {
                try {
                    AbstractC0858pW abstractC0858pW = (AbstractC0858pW) C0860pY.m3991a(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    abstractC0858pW.f4593c = vec3;
                    Minecraft.getInstance().setScreen(new C0156cT(null, abstractC0858pW, C0156cT.b.CREATE));
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException("Failed to instantiate map effect type " + str + ", every registered type must expose a public no-arg constructor", e);
                }
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ud$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ud$a.class */
    public enum a implements InterfaceC0492ib {
        CREATE_INDEPENDENT("Create Effect", -1, "create_independent"),
        CREATE_REFERENCED("Reference Template", -8335105, "create_referenced"),
        EDIT_TEMPLATES("Edit Templates", -12224, "edit_templates");


        @NotNull
        private final String displayName;
        private final int displayColor;

        @NotNull
        private final String settingsKey;

        a(@NotNull String str, int i, String str2) {
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

        @Override // com.boehmod.blockfront.InterfaceC0492ib
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
