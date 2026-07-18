package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.util.ModLibraryMathHelper;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;
import java.util.stream.Collectors;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.oR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oR.class */
public final class C0799oR {

    /* JADX INFO: renamed from: bK */
    @NotNull
    public static final String f4377bK = "matchId";

    /* JADX INFO: renamed from: bL */
    @NotNull
    public static final String f4378bL = "disableMount";

    /* JADX INFO: renamed from: bM */
    @NotNull
    public static final String f4379bM = "envVersion";

    /* JADX INFO: renamed from: ni */
    private static final int f4387ni = 4;

    /* JADX INFO: renamed from: bN */
    @NotNull
    public static final String f4388bN = "[Team]";

    /* JADX INFO: renamed from: iM */
    @NotNull
    public static final Component f4380iM = Component.literal(String.valueOf((char) 57363)).withColor(ColorReferences.COLOR_WHITE).append(" ");

    /* JADX INFO: renamed from: iN */
    @NotNull
    public static final Component f4381iN = Component.translatable("bf.message.admin").withColor(ColorReferences.COLOR_WHITE).append(" ");

    /* JADX INFO: renamed from: iO */
    @NotNull
    public static final Component f4382iO = Component.translatable("bf.message.dead").withStyle(ChatFormatting.DARK_RED);

    /* JADX INFO: renamed from: iP */
    @NotNull
    public static final Component f4383iP = Component.translatable("bf.message.team").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: iQ */
    @NotNull
    public static final Component f4384iQ = Component.translatable("bf.message.spectator").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final AttributeSupplier f4385a = Player.createAttributes().build();

    /* JADX INFO: renamed from: aw */
    @NotNull
    private static final List<Holder<Attribute>> f4386aw = List.of(Attributes.MAX_HEALTH, Attributes.MOVEMENT_SPEED, Attributes.ATTACK_DAMAGE, Attributes.ATTACK_SPEED, Attributes.ARMOR, Attributes.ARMOR_TOUGHNESS, Attributes.KNOCKBACK_RESISTANCE, Attributes.SCALE, NeoForgeMod.CREATIVE_FLIGHT);

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final MutableComponent f4389s = Component.translatable("bf.cloud.notification.discord.reminder.hover");

    /* JADX INFO: renamed from: t */
    @NotNull
    private static final MutableComponent f4390t = Component.translatable("bf.message.match.discord.vc").withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, f4389s)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, C0560jr.f3182aB))).withColor(ColorReferences.COLOR_THEME_DISCORD);

    /* JADX INFO: renamed from: a */
    public static boolean m3915a(@NotNull BlockAndTintGetter blockAndTintGetter, @NotNull BlockPos blockPos) {
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = -4; i < 4; i++) {
            for (int i2 = -4; i2 < 4; i2++) {
                BlockPos blockPosOffset = blockPos.offset(i, 2, i2);
                if (blockAndTintGetter.getBlockState(blockPosOffset).isAir()) {
                    if (blockAndTintGetter.canSeeSky(blockPosOffset)) {
                        f2 += 1.0f;
                    }
                    f += 1.0f;
                }
            }
        }
        return f2 / f <= 0.5f;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3916a(@NotNull Level level, int i, int i2, int i3) {
        return level.getHeight(Heightmap.Types.MOTION_BLOCKING, i, i2) > i3;
    }

    /* JADX INFO: renamed from: c */
    public static void m3917c(@NotNull Level level, @NotNull Vec3 vec3) {
        LightningBolt lightningBoltCreate = EntityType.LIGHTNING_BOLT.create(level);
        if (lightningBoltCreate == null) {
            return;
        }
        lightningBoltCreate.setPos(vec3);
        lightningBoltCreate.moveTo(vec3.x, vec3.y, vec3.z, 0.0f, 0.0f);
        lightningBoltCreate.setVisualOnly(true);
        lightningBoltCreate.setDamage(0.0f);
        level.addFreshEntity(lightningBoltCreate);
    }

    /* JADX INFO: renamed from: a */
    public static void m3918a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C0709mh c0709mh, @Nullable C0714mm c0714mm, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a != null) {
                m3920a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, c0709mh, c0714mm, serverPlayerM3963a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3919a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C0709mh c0709mh, @Nullable C0714mm c0714mm, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            m3920a(abstractC0563ju, c0709mh, c0714mm, serverPlayerM3963a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3920a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C0709mh c0709mh, @Nullable C0714mm c0714mm, @NotNull ServerPlayer serverPlayer) {
        AbstractC0183c<?> abstractC0183cM2528a = abstractC0563ju.m2528a();
        AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a((Player) serverPlayer);
        if (abstractC0182bM1136a instanceof C1274xO) {
            C1271xL c1271xLM7782a = ((C1274xO) abstractC0182bM1136a).m7782a();
            c1271xLM7782a.m7771d(serverPlayer, abstractC0183cM2528a);
            c1271xLM7782a.m7766c(c0709mh);
            c1271xLM7782a.m7769b(serverPlayer, abstractC0183cM2528a);
        }
        C1194vo.m6648a(new C1170vQ(c0709mh, Optional.ofNullable(c0714mm)), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m3921a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull ServerPlayer serverPlayer) {
        C0805oX c0805oXM3790c = abstractC0790oI.m3790c();
        if (c0805oXM3790c == null) {
            return;
        }
        for (C0774nt c0774nt : serverLevel.getEntitiesOfClass(C0774nt.class, new AABB(c0805oXM3790c.m4150c()).inflate(abstractC0787oF.m3596aV()))) {
            if (serverPlayer.equals(c0774nt.m2992a())) {
                c0774nt.discard();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3922a(@Nullable ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI) {
        C0805oX c0805oXM3790c;
        if (serverLevel == null || (c0805oXM3790c = abstractC0790oI.m3790c()) == null) {
            return;
        }
        for (Entity entity : serverLevel.getEntitiesOfClass(Entity.class, new AABB(c0805oXM3790c.m4150c()).inflate(abstractC0787oF.m3596aV()), entity2 -> {
            return (entity2 instanceof ItemEntity) || (entity2 instanceof AbstractC0676mA) || (entity2 instanceof C0678mC) || (entity2 instanceof C0680mE) || (entity2 instanceof C0692mQ) || (entity2 instanceof C0700mY) || (entity2 instanceof Horse) || (entity2 instanceof AbstractC0698mW) || (entity2 instanceof C0677mB) || (entity2 instanceof AbstractC0779ny);
        })) {
            if (entity instanceof AbstractC0779ny) {
                ((AbstractC0779ny) entity).ejectPassengers();
            }
            entity.discard();
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m3923d(@NotNull Set<UUID> set) {
        set.forEach(C0799oR::m3924i);
    }

    /* JADX INFO: renamed from: i */
    public static void m3924i(@NotNull UUID uuid) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a == null) {
            return;
        }
        serverPlayerM3963a.getInventory().clearContent();
        serverPlayerM3963a.containerMenu.broadcastChanges();
    }

    /* JADX INFO: renamed from: a */
    public static void m3925a(@NotNull Set<UUID> set, @NotNull C0431hU c0431hU) {
        set.forEach(uuid -> {
            m3926a(uuid, c0431hU);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3926a(@NotNull UUID uuid, @NotNull C0431hU c0431hU) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a == null) {
            return;
        }
        C1194vo.m6648a(new C1161vH(c0431hU), serverPlayerM3963a);
    }

    /* JADX INFO: renamed from: a */
    public static void m3927a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        m3932a(uuid, soundEvent, soundSource, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m3928a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        m3929a(serverPlayer, soundEvent, soundSource, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m3929a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        C1194vo.m6648a(new C1174vU(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent), soundSource, f, f2), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m3930a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f) {
        m3929a(serverPlayer, soundEvent, soundSource, f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m3931a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f) {
        m3932a(uuid, soundEvent, soundSource, f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m3932a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            m3929a(serverPlayerM3963a, soundEvent, soundSource, f, f2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3933a(@NotNull Set<UUID> set, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        set.forEach(uuid -> {
            m3927a(uuid, soundEvent, soundSource);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3934a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        m3933a(abstractC0787oF.m3582b().m3812j(), soundEvent, soundSource);
    }

    /* JADX INFO: renamed from: a */
    public static void m3935a(@NotNull Set<UUID> set, SoundEvent soundEvent, SoundSource soundSource, float f) {
        m3936a(set, soundEvent, soundSource, f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m3936a(@NotNull Set<UUID> set, SoundEvent soundEvent, SoundSource soundSource, float f, float f2) {
        set.forEach(uuid -> {
            m3932a(uuid, soundEvent, soundSource, f, f2);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3937a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        C1194vo.m6648a(new C1175vV(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent), soundSource, f, vec3), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m3938a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        m3939a(abstractC0787oF.m3582b().m3812j(), soundEvent, soundSource, f, vec3);
    }

    /* JADX INFO: renamed from: a */
    public static void m3939a(@NotNull Set<UUID> set, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        set.forEach(uuid -> {
            m3940a(uuid, soundEvent, soundSource, f, vec3);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3940a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a == null) {
            return;
        }
        m3937a(serverPlayerM3963a, soundEvent, soundSource, f, vec3);
    }

    /* JADX INFO: renamed from: a */
    public static void m3941a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        level.playSound((Player) null, vec3.x, vec3.y, vec3.z, soundEvent, soundSource, f, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m3942a(@NotNull Level level, double d, double d2, double d3, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        level.playSound((Player) null, d, d2, d3, soundEvent, soundSource, f, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m3943a(@NotNull ServerPlayer serverPlayer, @NotNull C1010sQ c1010sQ) {
        C1194vo.m6648a(new C1159vF(c1010sQ), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m3944a(@NotNull UUID uuid, @NotNull C1010sQ c1010sQ) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            m3943a(serverPlayerM3963a, c1010sQ);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3945a(@NotNull ServerPlayer serverPlayer, @NotNull C1011sR c1011sR) {
        C1194vo.m6648a(new C1250wr(c1011sR), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m3946a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0876pp c0876pp) {
        C1249wq c1249wq = new C1249wq(c0876pp);
        Iterator<UUID> it = abstractC0790oI.m3809h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = m3963a(it.next());
            if (serverPlayerM3963a != null) {
                C1194vo.m6648a(c1249wq, serverPlayerM3963a);
            }
        }
        Iterator<UUID> it2 = abstractC0790oI.m3810i().iterator();
        while (it2.hasNext()) {
            ServerPlayer serverPlayerM3963a2 = m3963a(it2.next());
            if (serverPlayerM3963a2 != null) {
                C1194vo.m6648a(c1249wq, serverPlayerM3963a2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3947a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @NotNull AbstractC0183c<?> abstractC0183c) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a != null) {
                m3948a((AbstractC0183c<?>) abstractC0183c, serverLevel, serverPlayerM3963a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3948a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        if (serverLevel.isClientSide()) {
            return;
        }
        serverPlayer.removeAllEffects();
        serverPlayer.resetFallDistance();
        serverPlayer.clearFire();
        serverPlayer.setInvisible(false);
        m3949e(serverPlayer);
        serverPlayer.setHealth(serverPlayer.getMaxHealth());
        Abilities abilities = serverPlayer.getAbilities();
        abilities.mayfly = false;
        abilities.flying = false;
        serverPlayer.onUpdateAbilities();
        serverPlayer.setGameMode(GameType.ADVENTURE);
        AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
        abstractC0182bM1136a.m1088X(false);
        abstractC0182bM1136a.m1096I(0);
        abstractC0182bM1136a.m1077b().m1071W(false);
    }

    /* JADX INFO: renamed from: e */
    private static void m3949e(@NotNull ServerPlayer serverPlayer) {
        for (Holder<Attribute> holder : f4386aw) {
            AttributeInstance attribute = serverPlayer.getAttribute(holder);
            if (attribute != null) {
                attribute.setBaseValue(f4385a.getBaseValue(holder));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static SortedSet<UUID> m3950a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set, @NotNull C1088to c1088to) {
        return m3951a(abstractC0787oF, set, c1088to.getKey());
    }

    /* JADX INFO: renamed from: a */
    public static SortedSet<UUID> m3951a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set, @NotNull String str) {
        if (set.size() <= 1) {
            return new ObjectLinkedOpenHashSet(set);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        objectArrayList.sort((uuid, uuid2) -> {
            return Integer.compare(abstractC0787oF.m3598a(uuid2).m3853a(str), abstractC0787oF.m3598a(uuid).m3853a(str));
        });
        return new ObjectLinkedOpenHashSet(objectArrayList);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectSortedSet<UUID> m3952a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, @NotNull C1088to c1088to, @NotNull Set<UUID> set) {
        return m3953a(abstractC0787oF, i, c1088to.getKey(), set);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectSortedSet<UUID> m3953a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, @NotNull String str, @NotNull Set<UUID> set) {
        if (set.isEmpty() || i <= 0) {
            return new ObjectLinkedOpenHashSet();
        }
        SortedSet<UUID> sortedSetM3951a = m3951a(abstractC0787oF, set, str);
        ObjectLinkedOpenHashSet objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
        int i2 = 0;
        for (UUID uuid : sortedSetM3951a) {
            if (i2 >= i) {
                break;
            }
            objectLinkedOpenHashSet.add(uuid);
            i2++;
        }
        return objectLinkedOpenHashSet;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectSortedSet<UUID> m3954a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, @NotNull C1088to c1088to, @NotNull C0796oO c0796oO) {
        return m3952a(abstractC0787oF, i, c1088to, c0796oO.m3872h());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Set<UUID> m3955a(@NotNull Set<UUID> set, int i) {
        if (set.isEmpty() || i <= 0) {
            return Collections.emptySet();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        Collections.shuffle(objectArrayList);
        ObjectLinkedOpenHashSet objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
        for (int i2 = 0; i2 < Math.min(i, objectArrayList.size()); i2++) {
            objectLinkedOpenHashSet.add((UUID) objectArrayList.get(i2));
        }
        return objectLinkedOpenHashSet;
    }

    /* JADX INFO: renamed from: a */
    public static void m3956a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a != null) {
                m3958a((AbstractC0183c<?>) abstractC0183c, serverPlayerM3963a);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public static void m3957b(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a != null) {
                m3959b((AbstractC0183c<?>) abstractC0183c, serverPlayerM3963a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3958a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerPlayer serverPlayer) {
        abstractC0183c.m1136a((Player) serverPlayer).m1094Z(true);
    }

    /* JADX INFO: renamed from: b */
    public static void m3959b(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerPlayer serverPlayer) {
        AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
        if (abstractC0182bM1136a.m1093dm() || abstractC0182bM1136a.m1091l() != null) {
            abstractC0182bM1136a.m1094Z(false);
            abstractC0182bM1136a.m1092e((C0805oX) null);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3960a(@NotNull Set<UUID> set, @NotNull Component component) {
        set.forEach(uuid -> {
            m3961a(uuid, component);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3961a(@NotNull UUID uuid, @NotNull Component component) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            m3962b(serverPlayerM3963a, component);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m3962b(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        serverPlayer.connection.disconnect(component);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ServerPlayer m3963a(@NotNull UUID uuid) {
        MinecraftServer minecraftServerM2514a;
        if (C0561js.m2513ac() && (minecraftServerM2514a = C0561js.m2514a()) != null) {
            return minecraftServerM2514a.getPlayerList().getPlayer(uuid);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static void m3964a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull UUID uuid, @NotNull List<C0805oX> list) {
        m3965a(abstractC0183c, uuid, (C0805oX) C1287xj.m7828a(list));
    }

    /* JADX INFO: renamed from: a */
    public static void m3965a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull UUID uuid, @NotNull C0805oX c0805oX) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            m3966a(abstractC0183c, serverPlayerM3963a, c0805oX);
            serverPlayerM3963a.containerMenu.sendAllDataToRemote();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3966a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerPlayer serverPlayer, @NotNull C0805oX c0805oX) {
        serverPlayer.teleportTo(serverPlayer.serverLevel(), c0805oX.f4424c.x, c0805oX.f4424c.y, c0805oX.f4424c.z, c0805oX.f4423h.x, c0805oX.f4423h.y);
        AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
        if (abstractC0182bM1136a.m1093dm()) {
            abstractC0182bM1136a.m1092e(c0805oX);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3967a(@NotNull ChatGraphic chatGraphic, @NotNull Set<UUID> set, @NotNull Component component) {
        set.forEach(uuid -> {
            m3968a(chatGraphic, uuid, component);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3968a(@NotNull ChatGraphic chatGraphic, @NotNull UUID uuid, @NotNull Component component) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            m3969a(chatGraphic, serverPlayerM3963a, component);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3969a(@NotNull ChatGraphic chatGraphic, @NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        C1194vo.m6648a(new C1181vb(chatGraphic, component), serverPlayer);
    }

    /* JADX INFO: renamed from: c */
    public static void m3970c(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        m3973a(serverPlayer, C1089tp.f5731jz, component);
    }

    /* JADX INFO: renamed from: b */
    public static void m3971b(@NotNull UUID uuid, @NotNull Component component) {
        m3972a(uuid, C1089tp.f5731jz, component);
    }

    /* JADX INFO: renamed from: a */
    public static void m3972a(@NotNull UUID uuid, @NotNull Component component, @NotNull Component component2) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a == null) {
            return;
        }
        m3973a(serverPlayerM3963a, component, component2);
    }

    /* JADX INFO: renamed from: a */
    public static void m3973a(@NotNull ServerPlayer serverPlayer, @NotNull Component component, @NotNull Component component2) {
        MutableComponent mutableComponentEmpty = Component.empty();
        if (component.getString().equalsIgnoreCase("Cloud")) {
            component = Component.literal(String.valueOf((char) 57362));
        }
        mutableComponentEmpty.append(component.copy());
        StringBuilder sb = new StringBuilder();
        if (component2.getString().startsWith("/c")) {
            Style style = component2.getStyle();
            int length = "                                                                 ".length() * 4;
            component2 = Component.literal(component2.getString().replaceAll("/c", "").trim()).setStyle(style);
            sb.append(" ".repeat(Math.max(0, ((length / 2) - ((component2.getString().length() * 5) / 2)) / 5)));
        }
        serverPlayer.sendSystemMessage(mutableComponentEmpty.withStyle(ChatFormatting.GRAY).append(Component.literal(sb.toString())).append(component2));
    }

    /* JADX INFO: renamed from: a */
    public static void m3974a(@NotNull ServerLevel serverLevel, @NotNull C1300xw c1300xw, @NotNull Component component) {
        if (C0561js.m2513ac()) {
            C1276xQ c1276xQ = (C1276xQ) c1300xw.m7950a();
            serverLevel.getServer().getPlayerList().getPlayers().stream().filter(serverPlayer -> {
                return c1276xQ.m1133a((Player) serverPlayer).m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN);
            }).forEach(serverPlayer2 -> {
                m3970c(serverPlayer2, component);
            });
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m3975e(@NotNull Set<UUID> set) {
        m3976b(set, (Component) Component.empty());
    }

    /* JADX INFO: renamed from: b */
    public static void m3976b(@NotNull Set<UUID> set, @NotNull Component component) {
        m3979a(set, C1089tp.f5731jz, component);
    }

    /* JADX INFO: renamed from: a */
    public static void m3977a(@NotNull Set<UUID> set, @NotNull String str) {
        m3979a(set, C1089tp.f5731jz, (Component) Component.literal(str));
    }

    /* JADX INFO: renamed from: a */
    public static void m3978a(@NotNull Set<UUID> set, @NotNull Component component, @NotNull String str) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a == null) {
                return;
            }
            m3973a(serverPlayerM3963a, component, (Component) Component.literal(str));
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3979a(@NotNull Set<UUID> set, @NotNull Component component, @NotNull Component component2) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a == null) {
                return;
            }
            m3973a(serverPlayerM3963a, component, component2);
        });
    }

    /* JADX INFO: renamed from: f */
    public static void m3980f(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        m3975e(abstractC0787oF.m3582b().m3812j());
    }

    /* JADX INFO: renamed from: a */
    public static void m3981a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component) {
        m3976b(abstractC0787oF.m3582b().m3812j(), component);
    }

    /* JADX INFO: renamed from: a */
    public static void m3982a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull String str) {
        m3977a(abstractC0787oF.m3582b().m3812j(), str);
    }

    /* JADX INFO: renamed from: a */
    public static void m3983a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component, @NotNull Component component2) {
        m3979a(abstractC0787oF.m3582b().m3812j(), component, component2);
    }

    /* JADX INFO: renamed from: a */
    public static void m3984a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component, @NotNull String str) {
        m3978a(abstractC0787oF.m3582b().m3812j(), component, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m3985a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull Component component, @NotNull Component component2) {
        m3987a(abstractC0790oI, c0796oO, EnumC0801oT.ALL, component, component2);
    }

    /* JADX INFO: renamed from: a */
    public static void m3986a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull Component component) {
        abstractC0790oI.m3813a(c0796oO, EnumC0801oT.ALL).forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a == null) {
                return;
            }
            m3970c(serverPlayerM3963a, component);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3987a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull EnumC0801oT enumC0801oT, @NotNull Component component, @NotNull Component component2) {
        abstractC0790oI.m3813a(c0796oO, enumC0801oT).forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a == null) {
                return;
            }
            m3973a(serverPlayerM3963a, component, component2);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3988a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0286ei enumC0286ei) {
        m3989a(abstractC0790oI, c0796oO, EnumC0801oT.ALL, component, component2, enumC0286ei);
    }

    /* JADX INFO: renamed from: a */
    public static void m3989a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull EnumC0801oT enumC0801oT, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0286ei enumC0286ei) {
        abstractC0790oI.m3813a(c0796oO, enumC0801oT).forEach(uuid -> {
            m3990a(uuid, component, component2, enumC0286ei);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3990a(@NotNull UUID uuid, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0286ei enumC0286ei) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            C1194vo.m6648a(new C1185vf(component, component2, enumC0286ei), serverPlayerM3963a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3991a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull Component component, int i, @Nullable String str) {
        m3992a(abstractC0790oI, c0796oO, EnumC0801oT.ALL, component, i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m3992a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull EnumC0801oT enumC0801oT, @NotNull Component component, int i, @Nullable String str) {
        abstractC0790oI.m3813a(c0796oO, enumC0801oT).forEach(uuid -> {
            m4004a(uuid, component, i, str);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3993a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        abstractC0790oI.m3813a(c0796oO, EnumC0801oT.ALL).forEach(uuid -> {
            m4007a(uuid, component, i, str, vec3, i2, i3);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3994a(@NotNull Set<UUID> set, @NotNull Component component, int i) {
        m3995a(set, component, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m3995a(@NotNull Set<UUID> set, @NotNull Component component, int i, @Nullable String str) {
        set.forEach(uuid -> {
            m4004a(uuid, component, i, str);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3996a(@NotNull Set<UUID> set, @NotNull List<Component> list, int i) {
        m3997a(set, list, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m3997a(@NotNull Set<UUID> set, @NotNull List<Component> list, int i, @Nullable String str) {
        set.forEach(uuid -> {
            m4006a(uuid, (List<Component>) list, i, str);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3998a(@NotNull Set<UUID> set, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        set.forEach(uuid -> {
            m4007a(uuid, component, i, str, vec3, i2, i3);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m3999a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component, int i) {
        m4000a(abstractC0787oF, component, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4000a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component, int i, @Nullable String str) {
        m3995a(abstractC0787oF.m3582b().m3812j(), component, i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4001a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull List<Component> list, int i, @Nullable String str) {
        m3997a(abstractC0787oF.m3582b().m3812j(), list, i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4002a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        m3998a(abstractC0787oF.m3582b().m3812j(), component, i, str, vec3, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m4003a(@NotNull UUID uuid, @NotNull Component component, int i) {
        m4004a(uuid, component, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4004a(@NotNull UUID uuid, @NotNull Component component, int i, @Nullable String str) {
        m4006a(uuid, (List<Component>) List.of(component), i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4005a(@NotNull UUID uuid, @NotNull List<Component> list, int i) {
        m4006a(uuid, list, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4006a(@NotNull UUID uuid, @NotNull List<Component> list, int i, @Nullable String str) {
        m4008a(uuid, list, i, str, (Vec3) null, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m4007a(@NotNull UUID uuid, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        m4008a(uuid, (List<Component>) List.of(component), i, str, vec3, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m4008a(@NotNull UUID uuid, @NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null) {
            C1194vo.m6648a(new C1203vx(list, i, str, vec3, i2, i3), serverPlayerM3963a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m4009a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to) {
        return abstractC0787oF.m3598a(uuid).m3853a(c1088to.getKey());
    }

    /* JADX INFO: renamed from: a */
    public static int m4010a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to, int i) {
        return abstractC0787oF.m3598a(uuid).m3854a(c1088to.getKey(), i);
    }

    /* JADX INFO: renamed from: a */
    public static void m4011a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to, int i) {
        abstractC0787oF.m3598a(uuid).m3855a(c1088to.getKey(), i);
    }

    /* JADX INFO: renamed from: a */
    public static void m4012a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set, @NotNull C1088to c1088to) {
        m4013a(abstractC0563ju, abstractC0787oF, set, c1088to, 1);
    }

    /* JADX INFO: renamed from: a */
    public static void m4013a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set, @NotNull C1088to c1088to, int i) {
        set.forEach(uuid -> {
            m4015a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, uuid, c1088to, i);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4014a(AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to) {
        m4015a(abstractC0563ju, abstractC0787oF, uuid, c1088to, 1);
    }

    /* JADX INFO: renamed from: a */
    public static void m4015a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to, int i) {
        m4016a(abstractC0563ju, abstractC0787oF, uuid, c1088to, i, (ItemStack) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4016a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to, int i, @Nullable ItemStack itemStack) {
        m4017a(abstractC0563ju, abstractC0787oF, uuid, c1088to, i, itemStack, -1);
    }

    /* JADX INFO: renamed from: a */
    public static void m4017a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to, int i, @Nullable ItemStack itemStack, int i2) {
        int iM4009a = m4009a(abstractC0787oF, uuid, c1088to);
        m4011a(abstractC0787oF, uuid, c1088to, iM4009a + i);
        if (c1088to instanceof C1087tn) {
            ((C1087tn) c1088to).m6001a(uuid, i);
        }
        if (abstractC0563ju.mo2552g() && c1088to.m6004cf()) {
            c1088to.m6003a(abstractC0563ju, abstractC0787oF, uuid, i, iM4009a + i, itemStack, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4018a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to) {
        m4019b(abstractC0787oF, uuid, c1088to, 1);
    }

    /* JADX INFO: renamed from: b */
    public static void m4019b(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull C1088to c1088to, int i) {
        m4011a(abstractC0787oF, uuid, c1088to, m4009a(abstractC0787oF, uuid, c1088to) - i);
    }

    /* JADX INFO: renamed from: f */
    public static void m4020f(@NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM3963a = m3963a(uuid);
            if (serverPlayerM3963a != null) {
                C1194vo.m6648a(new C1184ve(), serverPlayerM3963a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4021a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0866pf c0866pf) {
        m4022a(serverLevel, serverPlayer, c0866pf, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m4022a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0866pf c0866pf, boolean z) {
        EquipmentSlot equipmentSlot;
        if (serverLevel.isClientSide()) {
            return;
        }
        Inventory inventory = serverPlayer.getInventory();
        if (!z) {
            inventory.clearContent();
        }
        int i = 3;
        ItemStack itemStackM4339c = c0866pf.m4339c();
        if (itemStackM4339c != null && !itemStackM4339c.isEmpty()) {
            inventory.setItem(0, itemStackM4339c.copy());
        }
        ItemStack itemStackM4340d = c0866pf.m4340d();
        if (itemStackM4340d != null && !itemStackM4340d.isEmpty()) {
            inventory.setItem(1, itemStackM4340d.copy());
        }
        ItemStack itemStackM4341e = c0866pf.m4341e();
        if (itemStackM4341e != null && !itemStackM4341e.isEmpty()) {
            inventory.setItem(2, itemStackM4341e.copy());
        }
        ItemStack itemStackM4342f = c0866pf.m4342f();
        if (itemStackM4342f != null && !itemStackM4342f.isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.OFF_HAND, itemStackM4342f.copy());
        }
        ItemStack itemStackM4344h = c0866pf.m4344h();
        if (itemStackM4344h != null && !itemStackM4344h.isEmpty()) {
            serverPlayer.setItemSlot(serverPlayer.getEquipmentSlotForItem(itemStackM4344h), itemStackM4344h);
        }
        for (ItemStack itemStack : c0866pf.m4338F()) {
            if (itemStack != null && !itemStack.isEmpty()) {
                while (!inventory.getItem(i).isEmpty()) {
                    i++;
                }
                if (i > 6) {
                    break;
                } else {
                    inventory.setItem(i, itemStack.copy());
                }
            }
        }
        for (ItemStack itemStack2 : c0866pf.m4347G()) {
            ItemStack itemStackCopy = itemStack2.copy();
            ArmorItem item = itemStack2.getItem();
            if ((item instanceof ArmorItem) && (equipmentSlot = item.getEquipmentSlot(itemStackCopy)) != null) {
                serverPlayer.setItemSlot(equipmentSlot, itemStack2.copy());
            }
        }
        serverPlayer.containerMenu.broadcastChanges();
    }

    /* JADX INFO: renamed from: a */
    public static void m4023a(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull C0866pf c0866pf) {
        EquipmentSlot equipmentSlot;
        if (level.isClientSide()) {
            return;
        }
        if (c0866pf.m4339c() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0866pf.m4339c());
        }
        if (c0866pf.m4340d() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0866pf.m4340d());
        }
        if (c0866pf.m4341e() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0866pf.m4341e());
        }
        if (c0866pf.m4342f() != null) {
            livingEntity.setItemInHand(InteractionHand.OFF_HAND, c0866pf.m4342f());
        }
        Iterator<ItemStack> it = c0866pf.m4347G().iterator();
        while (it.hasNext()) {
            ItemStack itemStackCopy = it.next().copy();
            ArmorItem item = itemStackCopy.getItem();
            if ((item instanceof ArmorItem) && (equipmentSlot = item.getEquipmentSlot(itemStackCopy)) != null) {
                switch (AnonymousClass1.f4391q[equipmentSlot.ordinal()]) {
                    case 1:
                        livingEntity.setItemSlot(EquipmentSlot.HEAD, itemStackCopy);
                        break;
                    case 2:
                        livingEntity.setItemSlot(EquipmentSlot.CHEST, itemStackCopy);
                        break;
                    case 3:
                        livingEntity.setItemSlot(EquipmentSlot.LEGS, itemStackCopy);
                        break;
                    case 4:
                        livingEntity.setItemSlot(EquipmentSlot.FEET, itemStackCopy);
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.oR$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oR$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: q */
        static final /* synthetic */ int[] f4391q = new int[EquipmentSlot.values().length];

        static {
            try {
                f4391q[EquipmentSlot.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4391q[EquipmentSlot.CHEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4391q[EquipmentSlot.LEGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4391q[EquipmentSlot.FEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4024a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
        long time = (Calendar.getInstance().getTime().getTime() - abstractC0182bM1136a.m1085i()) / 1000;
        if (abstractC0787oF.mo3621bd() && time <= 5 && abstractC0787oF.m3587a() == EnumC0795oN.GAME && abstractC0182bM1136a.m1085i() != 0) {
            m3976b(set, (Component) Component.translatable("bf.message.gamemode.ragequit", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
            m4025a(abstractC0563ju, uuid, CloudAchievements.ACH_USER_RAGEQUIT);
        }
        abstractC0182bM1136a.m1086d(0L);
    }

    /* JADX INFO: renamed from: a */
    public static void m4025a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull UUID uuid, @NotNull CloudAchievement cloudAchievement) {
        abstractC0563ju.m2520b().sendPacket(new PacketPlayerDataIncreaseValue(uuid, "achievement", cloudAchievement.getId()));
    }

    /* JADX INFO: renamed from: f */
    public static void m4026f(@NotNull ServerPlayer serverPlayer) {
        Inventory inventory = serverPlayer.getInventory();
        int size = inventory.items.size();
        for (int i = 0; i < size; i++) {
            ItemStack itemStack = (ItemStack) inventory.items.get(i);
            if (!itemStack.isEmpty() && (itemStack.getItem() instanceof C1144ur)) {
                C1144ur.m6306f(itemStack);
                serverPlayer.containerMenu.sendAllDataToRemote();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4027a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            m4028a(serverLevel, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, uuid);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4028a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid) {
        C0796oO c0796oOM3793a = abstractC0787oF.m3582b().m3793a(uuid);
        C0794oM c0794oMM3598a = abstractC0787oF.m3598a(uuid);
        int iM3854a = c0794oMM3598a.m3854a(C1089tp.f5692i.getKey(), -1);
        int iM3854a2 = c0794oMM3598a.m3854a(C1089tp.f5693j.getKey(), -1);
        ServerPlayer serverPlayerM3963a = m3963a(uuid);
        if (serverPlayerM3963a != null && c0796oOM3793a != null && iM3854a != -1 && iM3854a2 != -1) {
            m4021a(serverLevel, serverPlayerM3963a, m4029a(abstractC0787oF, c0796oOM3793a, C1015sV.m5528a(iM3854a), iM3854a2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0866pf m4029a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0796oO c0796oO, @NotNull C1015sV c1015sV, int i) {
        return c0796oO.m3860a(abstractC0787oF).m5981a(c1015sV, i);
    }

    /* JADX INFO: renamed from: a */
    public static int m4030a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C1015sV c1015sV, @NotNull C0796oO c0796oO) {
        int i = 0;
        String key = C1089tp.f5692i.getKey();
        int iM5523bN = c1015sV.m5523bN();
        Iterator<UUID> it = c0796oO.m3872h().iterator();
        while (it.hasNext()) {
            if (abstractC0787oF.m3598a(it.next()).m3853a(key) == iM5523bN) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static void m4031a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        m3948a(abstractC0183c, serverLevel, serverPlayer);
        abstractC0563ju.m2534a(abstractC0563ju, abstractC0183c, serverLevel, serverPlayer, uuid);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4032b(@NotNull ItemStack itemStack) {
        int iM6425cc;
        Item item = itemStack.getItem();
        if (!(item instanceof C1144ur)) {
            return false;
        }
        C1144ur c1144ur = (C1144ur) item;
        if (c1144ur.m6350ct() && C1144ur.m6304b(itemStack) != (iM6425cc = c1144ur.m6318a(itemStack).m6425cc())) {
            C1144ur.m6305c(itemStack, iM6425cc);
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m4033h(@NotNull Player player) {
        for (ItemStack itemStack : player.getInventory().items.subList(0, 9)) {
            if (itemStack == null || !itemStack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static int m4034a(@NotNull Inventory inventory, int i, int i2) {
        int i3 = i2 > 0 ? 1 : -1;
        int i4 = i;
        do {
            i4 = ((i4 + i3) + 9) % 9;
            if (i4 == i) {
                break;
            }
        } while (inventory.getItem(i4).isEmpty());
        return i4;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4035c(@NotNull ServerPlayer serverPlayer) {
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (!itemStack.isEmpty()) {
                Item item = itemStack.getItem();
                if (item instanceof C1144ur) {
                    C1145us c1145usM6318a = ((C1144ur) item).m6318a(itemStack);
                    int iM6424cb = c1145usM6318a.m6424cb();
                    if (C1144ur.m6304b(itemStack) != c1145usM6318a.m6425cc() || C1144ur.m6301a(itemStack) != iM6424cb) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4036a(@NotNull ServerPlayer serverPlayer, @NotNull C0866pf c0866pf) {
        List<ItemStack> listM4338F = c0866pf.m4338F();
        if (listM4338F.isEmpty()) {
            return false;
        }
        HashMap map = new HashMap();
        for (ItemStack itemStack : listM4338F) {
            if (!itemStack.isEmpty()) {
                map.merge(itemStack.getItem(), Integer.valueOf(itemStack.getCount()), (v0, v1) -> {
                    return Integer.sum(v0, v1);
                });
            }
        }
        HashMap map2 = new HashMap();
        for (ItemStack itemStack2 : serverPlayer.getInventory().items) {
            if (!itemStack2.isEmpty() && (itemStack2.getItem() instanceof InterfaceC1070tW)) {
                map2.merge(itemStack2.getItem(), Integer.valueOf(itemStack2.getCount()), (v0, v1) -> {
                    return Integer.sum(v0, v1);
                });
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) map2.getOrDefault(entry.getKey(), 0)).intValue() < ((Integer) entry.getValue()).intValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4037a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull C0796oO c0796oO) {
        Iterator<UUID> it = c0796oO.m3872h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = m3963a(it.next());
            if (serverPlayerM3963a != null && !m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) abstractC0183c.m1136a((Player) serverPlayerM3963a))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m4038a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0796oO c0796oO) {
        C0794oM c0794oMM3598a = abstractC0787oF.m3598a(serverPlayer.getUUID());
        int iM3854a = c0794oMM3598a.m3854a(C1089tp.f5692i.getKey(), -1);
        int iM3854a2 = c0794oMM3598a.m3854a(C1089tp.f5693j.getKey(), -1);
        if (iM3854a != -1 && iM3854a2 != -1) {
            C1015sV c1015sVM5528a = C1015sV.m5528a(iM3854a);
            c0794oMM3598a.m3855a(C1089tp.f5694k.getKey(), iM3854a);
            m4021a(serverLevel, serverPlayer, m4029a(abstractC0787oF, c0796oO, c1015sVM5528a, iM3854a2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4039a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0796oO c0796oO) {
        Iterator<UUID> it = c0796oO.m3872h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = m3963a(it.next());
            if (serverPlayerM3963a != null) {
                m4038a(serverLevel, serverPlayerM3963a, abstractC0787oF, c0796oO);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4040a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull UUID uuid, @NotNull UUID uuid2) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563ju.mo2531a(uuid);
        if (abstractC0787oFMo2531a == null) {
            return false;
        }
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b();
        C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid);
        return c0796oOM3793a != null && c0796oOM3793a.equals(abstractC0790oIM3582b.m3793a(uuid2));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4041a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull UUID uuid, @NotNull UUID uuid2) {
        C0796oO c0796oOM3793a = abstractC0790oI.m3793a(uuid);
        return c0796oOM3793a != null && c0796oOM3793a.equals(abstractC0790oI.m3793a(uuid2));
    }

    /* JADX INFO: renamed from: a */
    public static BlockPos m4042a(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos) {
        BlockPos heightmapPos = serverLevel.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos);
        if (heightmapPos.getY() == serverLevel.getMinBuildHeight() - 1) {
            heightmapPos = heightmapPos.above(2);
        }
        return heightmapPos;
    }

    /* JADX INFO: renamed from: a */
    public static void m4043a(@NotNull LivingEntity livingEntity, @NotNull ParticleOptions particleOptions, @NotNull RandomSource randomSource, float f, float f2, float f3, int i) {
        ServerLevel serverLevelLevel = livingEntity.level();
        if (serverLevelLevel instanceof ServerLevel) {
            ServerLevel serverLevel = serverLevelLevel;
            for (int i2 = 0; i2 < i; i2++) {
                serverLevel.sendParticles(particleOptions, livingEntity.getRandomX(1.0d) + ((double) f), livingEntity.getRandomY() + ((double) f2), livingEntity.getRandomZ(1.0d) + ((double) f3), 1, randomSource.nextGaussian() * 0.02d, randomSource.nextGaussian() * 0.02d, randomSource.nextGaussian() * 0.02d, 1.0d);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4044a(@NotNull Level level, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, double d, double d2, int i, float f) {
        for (int i2 = 0; i2 < i; i2++) {
            double dPow = d + ((d2 - d) * Math.pow(level.random.nextDouble(), 2.0d));
            double d3 = (6.283185307179586d / ((double) i)) * ((double) i2);
            double dCos = Math.cos(d3);
            double dSin = Math.sin(d3);
            level.addParticle(particleOptions, true, vec3.x + (dPow * dCos), vec3.y, vec3.z + (dPow * dSin), ((double) f) * dCos, 0.0d, ((double) f) * dSin);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4045a(@NotNull Level level, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
        for (int i2 = 0; i2 < i; i2++) {
            double dCbrt = ((double) f) + (((double) (f2 - f)) * Math.cbrt(level.random.nextDouble()));
            double dNextDouble = 6.283185307179586d * level.random.nextDouble();
            double dAcos = Math.acos((2.0d * level.random.nextDouble()) - 1.0d);
            double dSin = Math.sin(dAcos);
            double dCos = Math.cos(dAcos);
            double dSin2 = Math.sin(dNextDouble);
            double dCos2 = Math.cos(dNextDouble);
            level.addParticle(particleOptions, true, vec3.x + (dCbrt * dSin * dCos2), vec3.y + (dCbrt * dSin * dSin2), vec3.z + (dCbrt * dCos), ((double) f3) * dSin * dCos2, ((double) f3) * dSin * dSin2, ((double) f3) * dCos);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4046a(@NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, float f) {
        float fAbs = Math.abs(((livingEntity.getYHeadRot() + 360.0f) % 360.0f) - ((livingEntity2.getYHeadRot() + 360.0f) % 360.0f));
        return ((fAbs > 180.0f ? 1 : (fAbs == 180.0f ? 0 : -1)) > 0 ? 360.0f - fAbs : fAbs) <= f;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4047b(@NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, float f) {
        Vec3 eyePosition = livingEntity2.getEyePosition();
        Vec3 eyePosition2 = livingEntity.getEyePosition();
        float yHeadRot = livingEntity.getYHeadRot();
        float xRot = livingEntity.getXRot();
        return Math.acos(new Vec3((double) ((-Mth.sin(yHeadRot * 0.017453292f)) * Mth.cos(xRot * 0.017453292f)), (double) (-Mth.sin(xRot * 0.017453292f)), (double) (Mth.cos(yHeadRot * 0.017453292f) * Mth.cos(xRot * 0.017453292f))).dot(eyePosition.subtract(eyePosition2).normalize())) <= Math.toRadians((double) (f / 2.0f));
    }

    /* JADX INFO: renamed from: a */
    public static float m4048a(@NotNull Entity entity, @NotNull Camera camera) {
        return m4050a(entity, camera.getPosition());
    }

    /* JADX INFO: renamed from: a */
    public static float m4049a(@NotNull Entity entity, @NotNull Entity entity2) {
        return m4050a(entity, entity2.getEyePosition());
    }

    /* JADX INFO: renamed from: a */
    public static float m4050a(@NotNull Entity entity, @NotNull Vec3 vec3) {
        float fX = (float) (vec3.x() - entity.getX());
        float fY = (float) (vec3.y() - entity.getY());
        float fZ = (float) (vec3.z() - entity.getZ());
        float f = (fX * fX) + (fY * fY) + (fZ * fZ);
        if (f < 1.0E-5f) {
            return 1.0f;
        }
        float fSqrt = (float) Math.sqrt(f);
        float f2 = fX / fSqrt;
        float f3 = fY / fSqrt;
        float f4 = fZ / fSqrt;
        float radians = (float) Math.toRadians(entity.getYHeadRot());
        float radians2 = (float) Math.toRadians(entity.getXRot());
        float fCos = (((((-(((float) Math.sin(radians)) * ((float) Math.cos(radians2)))) * f2) + ((-((float) Math.sin(radians2))) * f3)) + ((((float) Math.cos(radians)) * ((float) Math.cos(radians2))) * f4)) + 1.0f) / 2.0f;
        return fCos * fCos;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4051a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        if (!livingEntity2.isAlive() || livingEntity2.getHealth() <= 0.0f || livingEntity2.tickCount <= 20) {
            return false;
        }
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (livingEntity2 instanceof ServerPlayer) {
                AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563ju.mo2531a(serverPlayer.getUUID());
                AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a2 = abstractC0563ju.mo2531a(((ServerPlayer) livingEntity2).getUUID());
                if (abstractC0787oFMo2531a != null && abstractC0787oFMo2531a2 != null && !abstractC0787oFMo2531a.equals(abstractC0787oFMo2531a2)) {
                    return false;
                }
            }
        }
        Entity vehicle = livingEntity2.getVehicle();
        if ((vehicle instanceof AbstractC0779ny) && ((AbstractC0779ny) vehicle).m3513k((Entity) livingEntity2)) {
            return false;
        }
        if (livingEntity2 instanceof Player) {
            Entity entity = (Player) livingEntity2;
            if (abstractC0183c.m1136a((Player) entity).m1087dk() || entity.isSpectator()) {
                return false;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a3 = abstractC0563ju.mo2531a(entity.getUUID());
            if (abstractC0787oFMo2531a3 != null && abstractC0787oFMo2531a3.m3582b().m3811g(entity.getUUID())) {
                return false;
            }
            Entity vehicle2 = entity.getVehicle();
            if ((vehicle2 instanceof AbstractC0779ny) && ((AbstractC0779ny) vehicle2).m3513k(entity)) {
                return false;
            }
        }
        if (livingEntity instanceof C0680mE) {
            return ((C0680mE) livingEntity).canAttack(livingEntity2);
        }
        return (livingEntity2.isSpectator() || livingEntity2.equals(livingEntity)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4052a(@NotNull Player player, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        return abstractC0182b.m1087dk() || !player.isAlive() || player.isSpectator() || player.isDeadOrDying();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4053a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @Nullable LivingEntity livingEntity, @NotNull UUID uuid) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a;
        return (livingEntity == null || (abstractC0787oFMo2531a = abstractC0563ju.mo2531a(livingEntity.getUUID())) == null || !abstractC0787oFMo2531a.m3582b().m3811g(uuid)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static Explosion m4054a(@NotNull Level level, @Nullable Entity entity, @NotNull Vec3 vec3, @NotNull ItemStack itemStack, float f) {
        return new Explosion(level, entity, new C0702ma(level, entity instanceof AbstractC0676mA ? ((AbstractC0676mA) entity).m2992a() : entity, itemStack, vec3), (ExplosionDamageCalculator) null, vec3.x, vec3.y, vec3.z, f, false, Explosion.BlockInteraction.KEEP, ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, SoundEvents.GENERIC_EXPLODE);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static <T extends Entity> T m4055a(@NotNull Level level, @NotNull Entity entity, @NotNull Class<T> cls, float f) {
        List entitiesOfClass = level.getEntitiesOfClass(cls, entity.getBoundingBox().inflate(f));
        if (!entitiesOfClass.isEmpty()) {
            return (T) entitiesOfClass.getFirst();
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Set<UUID> m4056a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Set<UUID> set) {
        Object2FloatOpenHashMap object2FloatOpenHashMap = new Object2FloatOpenHashMap();
        for (UUID uuid : set) {
            C0482iS c0482iSM1132a = abstractC0183c.m1132a(uuid);
            object2FloatOpenHashMap.put(uuid, c0482iSM1132a.getKills() / Math.max(1.0f, c0482iSM1132a.getDeaths()));
        }
        return (Set) object2FloatOpenHashMap.object2FloatEntrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map((v0) -> {
            return v0.getKey();
        }).collect(Collectors.toCollection(ObjectLinkedOpenHashSet::new));
    }

    /* JADX INFO: renamed from: a */
    public static void m4057a(@NotNull C1300xw c1300xw, @NotNull C1276xQ c1276xQ, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull Component component, @NotNull UUID uuid) {
        if (!abstractC0787oF.m3632a(c1300xw, serverPlayer, component)) {
            return;
        }
        String string = component.getString();
        boolean zStartsWith = string.startsWith(f4388bN);
        C1274xO c1274xO = (C1274xO) c1276xQ.m1133a((Player) serverPlayer);
        C0482iS c0482iSA = c1276xQ.m1133a((Player) serverPlayer);
        if (c1300xw.mo2551f() && !m4058a(c1300xw, serverLevel, serverPlayer, string, c1274xO, c0482iSA)) {
            return;
        }
        C0562jt.log("[Chat] %s: %s", serverPlayer.getScoreboardName(), string);
        m4061a(c1300xw, abstractC0787oF, component, serverPlayer, uuid);
        Set<UUID> setM3812j = abstractC0787oF.m3582b().m3812j();
        Component componentM4059a = m4059a(c1276xQ, abstractC0787oF, serverPlayer, uuid, serverPlayer.getScoreboardName(), component, c1274xO, (List<String>) null);
        boolean zM4052a = m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) c1274xO);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<UUID> it = setM3812j.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = m3963a(it.next());
            if (serverPlayerM3963a != null && C1286xi.m7821b(string, serverPlayerM3963a.getScoreboardName())) {
                objectArrayList.add(serverPlayerM3963a.getScoreboardName());
            }
        }
        for (UUID uuid2 : setM3812j) {
            ServerPlayer serverPlayerM3963a2 = m3963a(uuid2);
            if (serverPlayerM3963a2 != null && abstractC0787oF.m3634a(uuid, serverPlayerM3963a2, uuid2, zStartsWith, zM4052a)) {
                String scoreboardName = serverPlayerM3963a2.getScoreboardName();
                Component componentM4059a2 = componentM4059a;
                if (uuid2.equals(uuid)) {
                    if (!objectArrayList.isEmpty()) {
                        componentM4059a2 = m4059a((AbstractC0183c<?>) c1276xQ, abstractC0787oF, serverPlayer, uuid, serverPlayer.getScoreboardName(), component, c1274xO, (List<String>) objectArrayList);
                    }
                } else if (C1286xi.m7821b(string, scoreboardName)) {
                    componentM4059a2 = m4059a(c1276xQ, abstractC0787oF, serverPlayer, uuid, serverPlayer.getScoreboardName(), component, c1274xO, (List<String>) List.of(scoreboardName));
                }
                serverPlayerM3963a2.sendSystemMessage(componentM4059a2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4058a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b, @NotNull C0482iS c0482iS) {
        Component componentM7967a = C1303xz.m7967a(abstractC0563ju, serverPlayer, serverLevel, abstractC0182b, c0482iS, str);
        if (componentM7967a != null) {
            m3969a(ChatGraphic.WARNING, serverPlayer, componentM7967a);
            m3929a(serverPlayer, (SoundEvent) SoundEvents.NOTE_BLOCK_HARP.value(), SoundSource.MASTER, 1.0f, 2.0f);
            m3929a(serverPlayer, (SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), SoundSource.MASTER, 1.0f, 2.0f);
            return false;
        }
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m4059a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull String str, @NotNull Component component, @NotNull C1274xO c1274xO, @Nullable List<String> list) {
        MutableComponent mutableComponentEmpty;
        MutableComponent mutableComponentLiteral;
        String strReplace = component.getString().replace("<" + str + "> ", "");
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
        boolean zStartsWith = strReplace.startsWith(f4388bN);
        String strReplace2 = strReplace.replace("[Team] ", "");
        boolean zM4052a = m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) c1274xO);
        C0482iS c0482iSM1133a = abstractC0183c.m1133a((Player) serverPlayer);
        MutableComponent mutableComponentM2188b = c0482iSM1133a.m2188b();
        MutableComponent mutableComponentM4060b = m4060b(c0482iSM1133a);
        PlayerRank rank = c0482iSM1133a.getRank();
        MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(rank.getGraphic())).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(rank.getTitle()).withColor(ColorReferences.COLOR_WHITE))));
        MutableComponent mutableComponentAppend = Component.empty().append(mutableComponentM2188b);
        if (c1274xO.m7787dv()) {
            mutableComponentEmpty = Component.empty().append(f4390t).append(" ");
        } else {
            mutableComponentEmpty = Component.empty();
        }
        MutableComponent mutableComponentWithStyle2 = mutableComponentAppend.withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, mutableComponentM4060b)));
        C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid);
        MutableComponent mutableComponentWithStyle3 = Component.literal(": ").withStyle(c0796oOM3793a != null ? c0796oOM3793a.m3876a() : Style.EMPTY);
        String strReplaceAll = strReplace2.replaceAll("\\p{C}", "?");
        if (C0476iM.f2926dn) {
            mutableComponentLiteral = C1285xh.m7816a(strReplaceAll);
        } else {
            mutableComponentLiteral = Component.literal(strReplaceAll);
        }
        MutableComponent mutableComponentM7823a = mutableComponentLiteral;
        if (list != null) {
            mutableComponentM7823a = C1286xi.m7823a((Component) mutableComponentM7823a, list);
        }
        MutableComponent mutableComponentAppend2 = Component.empty().append(mutableComponentEmpty).append(mutableComponentWithStyle).append(" ").append(mutableComponentWithStyle2).append(mutableComponentWithStyle3).append(mutableComponentM7823a);
        if (c0796oOM3793a != null) {
            mutableComponentAppend2 = mutableComponentAppend2.copy().withStyle(c0796oOM3793a.m3877b());
        }
        if (abstractC0790oIM3582b.m3811g(uuid)) {
            mutableComponentAppend2 = Component.empty().append(f4384iQ).append(" ").append(mutableComponentAppend2);
        } else if (zM4052a) {
            mutableComponentAppend2 = Component.empty().append(f4382iO).append(" ").append(mutableComponentAppend2);
        } else if (zStartsWith) {
            mutableComponentAppend2 = Component.empty().append(f4383iP).append(" ").append(mutableComponentAppend2);
        }
        return mutableComponentAppend2;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static MutableComponent m4060b(@NotNull C0482iS c0482iS) {
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(Component.literal("Player " + c0482iS.getUsername() + " Stats:"));
        mutableComponentEmpty.append("\n");
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.exp", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getExp())).withStyle(ChatFormatting.YELLOW)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.karma", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getMatchKarma())).withStyle(ChatFormatting.LIGHT_PURPLE)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.time", new Object[]{Component.literal(ModLibraryMathHelper.round(c0482iS.getMinutesPlayed() / 60.0d, 1) + "h").withStyle(ChatFormatting.GRAY)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.games", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getTotalGames())).withStyle(ChatFormatting.GRAY)}));
        mutableComponentEmpty.append("\n");
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.headshots", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getHeadShots())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getKills())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.assists", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getAssists())).withStyle(ChatFormatting.YELLOW)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills.streak", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getKillStreak())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills.fire", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getFireKills())).withStyle(ChatFormatting.GOLD)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.deaths", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getDeaths())).withStyle(ChatFormatting.RED)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.deaths.streak", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getDeathStreak())).withStyle(ChatFormatting.RED)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.fb", new Object[]{Component.literal(C1293xp.m7912a(c0482iS.getFirstBloods())).withStyle(ChatFormatting.DARK_RED)}));
        int prestigeLevel = c0482iS.getPrestigeLevel();
        if (prestigeLevel > 0) {
            mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.prestige", new Object[]{Component.literal(C1293xp.m7912a(prestigeLevel)).withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)}));
        }
        mutableComponentEmpty.append("\n");
        return mutableComponentEmpty;
    }

    /* JADX INFO: renamed from: a */
    private static void m4061a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        if (abstractC0787oF.m3587a() == EnumC0795oN.POST_GAME && m4009a(abstractC0787oF, uuid, C1089tp.f5689f) != 1 && m4062a(component)) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.popup.message.karma", new Object[]{Component.literal(String.valueOf(3)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.LIGHT_PURPLE);
            m4014a(abstractC0563ju, abstractC0787oF, uuid, C1089tp.f5689f);
            m4015a(abstractC0563ju, abstractC0787oF, uuid, C1089tp.f5703t, 3);
            m3970c(serverPlayer, (Component) mutableComponentWithStyle);
            m3943a(serverPlayer, new C1010sQ(mutableComponentWithStyle, 80));
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4062a(@NotNull Component component) {
        String lowerCase = component.getString().toLowerCase(Locale.ROOT);
        return lowerCase.contains("gg") || lowerCase.contains("wp") || (lowerCase.contains("good") && lowerCase.contains("game"));
    }

    /* JADX INFO: renamed from: a */
    public static void m4063a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @NotNull C0796oO c0796oO, boolean z) {
        c0796oO.m3860a(abstractC0787oF).m5980a(true, pair -> {
            return m4066a((Pair<C0866pf, C1015sV>) pair) && ((C1015sV) pair.getRight()).m5526a((AbstractC0787oF<?, ?, ?>) abstractC0787oF);
        }).ifPresent(pair2 -> {
            m4064a((AbstractC0787oF<?, ?, ?>) abstractC0787oF, serverLevel, c0796oO, (Pair<C0866pf, C1015sV>) pair2, z);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4064a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @NotNull C0796oO c0796oO, @NotNull Pair<C0866pf, C1015sV> pair, boolean z) {
        m4065a(abstractC0787oF, serverLevel, c0796oO, pair, z, 16.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m4065a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @NotNull C0796oO c0796oO, @NotNull Pair<C0866pf, C1015sV> pair, boolean z, float f) {
        C0866pf c0866pf = (C0866pf) pair.getLeft();
        C1015sV c1015sV = (C1015sV) pair.getRight();
        C0805oX c0805oXM3863a = c0796oO.m3863a(abstractC0787oF);
        serverLevel.getChunkAt(c0805oXM3863a.m4150c());
        C0680mE c0680mECreate = ((EntityType) C1230wX.f7035kF.get()).create(serverLevel);
        if (c0680mECreate == null) {
            return;
        }
        C1074ta c1074taM3860a = c0796oO.m3860a(abstractC0787oF);
        ItemStack itemStackCopy = c0866pf.m4339c().copy();
        if (itemStackCopy.isEmpty()) {
            itemStackCopy = c0866pf.m4340d().copy();
        }
        itemStackCopy.set(C1228wV.f6980X.get(), true);
        float f2 = c0805oXM3863a.f4423h.x;
        c0680mECreate.moveTo(c0805oXM3863a.f4424c.x, c0805oXM3863a.f4424c.y, c0805oXM3863a.f4424c.z, f2, c0805oXM3863a.f4423h.y);
        c0680mECreate.setYHeadRot(f2);
        c0680mECreate.setYBodyRot(f2);
        c0680mECreate.mo3282e(abstractC0787oF);
        c0680mECreate.m3048a(abstractC0787oF, c0796oO);
        c0680mECreate.m3054s(c0796oO.getName());
        c0680mECreate.m3060q(c1074taM3860a.m5972a().ordinal());
        c0680mECreate.m3056t(c1074taM3860a.m5976a().m5671ap());
        c0680mECreate.m3052d(itemStackCopy);
        c0680mECreate.m3073a(c1015sV);
        c0680mECreate.m3070F(z);
        AttributeInstance attribute = c0680mECreate.getAttribute(Attributes.MAX_HEALTH);
        if (attribute != null) {
            attribute.setBaseValue(f);
        }
        c0680mECreate.setHealth(f);
        serverLevel.addFreshEntity(c0680mECreate);
        if (abstractC0787oF instanceof InterfaceC0899qL) {
            ((InterfaceC0899qL) abstractC0787oF).mo4657a(c0680mECreate, (Level) serverLevel);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4066a(@NotNull Pair<C0866pf, C1015sV> pair) {
        C0866pf c0866pf = (C0866pf) pair.getLeft();
        ItemStack itemStackM4339c = c0866pf.m4339c();
        if (itemStackM4339c != null) {
            Item item = itemStackM4339c.getItem();
            if ((item instanceof C1144ur) && ((C1144ur) item).m6347a().m6225ch() > 1) {
                return false;
            }
        }
        ItemStack itemStackM4340d = c0866pf.m4340d();
        if (itemStackM4340d == null) {
            return true;
        }
        Item item2 = itemStackM4340d.getItem();
        return !(item2 instanceof C1144ur) || ((C1144ur) item2).m6347a().m6225ch() <= 1;
    }
}
