package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.util.ModLibraryMathHelper;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.pn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pn.class */
public final class C0875pn {

    /* JADX INFO: renamed from: bU */
    @NotNull
    public static final String f4773bU = "matchId";

    /* JADX INFO: renamed from: bV */
    @NotNull
    public static final String f4774bV = "disableMount";

    /* JADX INFO: renamed from: bW */
    @NotNull
    public static final String f4775bW = "envVersion";

    /* JADX INFO: renamed from: ph */
    private static final int f4784ph = 4;

    /* JADX INFO: renamed from: bX */
    @NotNull
    public static final String f4785bX = "[Team]";

    /* JADX INFO: renamed from: iY */
    @NotNull
    public static final Component f4776iY = Component.literal(String.valueOf((char) 57363)).withColor(ColorReferences.COLOR_WHITE).append(" ");

    /* JADX INFO: renamed from: iZ */
    @NotNull
    public static final Component f4777iZ = Component.translatable("bf.message.admin").withColor(ColorReferences.COLOR_WHITE).append(" ");

    /* JADX INFO: renamed from: ja */
    @NotNull
    public static final Component f4778ja = Component.translatable("bf.message.dead").withStyle(ChatFormatting.DARK_RED);

    /* JADX INFO: renamed from: jb */
    @NotNull
    public static final Component f4779jb = Component.translatable("bf.message.team").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: jc */
    @NotNull
    public static final Component f4780jc = Component.translatable("bf.message.spectator").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: jd */
    @NotNull
    private static final Component f4781jd = Component.translatable("bf.message.chat.report.hover").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final AttributeSupplier f4782a = Player.createAttributes().build();

    /* JADX INFO: renamed from: aD */
    @NotNull
    private static final List<Holder<Attribute>> f4783aD = List.of(Attributes.MAX_HEALTH, Attributes.MOVEMENT_SPEED, Attributes.ATTACK_DAMAGE, Attributes.ATTACK_SPEED, Attributes.ARMOR, Attributes.ARMOR_TOUGHNESS, Attributes.KNOCKBACK_RESISTANCE, Attributes.SCALE, NeoForgeMod.CREATIVE_FLIGHT);

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final MutableComponent f4786s = Component.translatable("bf.cloud.notification.discord.reminder.hover");

    /* JADX INFO: renamed from: t */
    @NotNull
    private static final MutableComponent f4787t = Component.translatable("bf.message.match.discord.vc").withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, f4786s)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, C0528jK.f3165aH))).withColor(ColorReferences.COLOR_THEME_DISCORD);

    /* JADX INFO: renamed from: a */
    public static boolean m4351a(@NotNull BlockAndTintGetter blockAndTintGetter, @NotNull BlockPos blockPos) {
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
    public static boolean m4352a(@NotNull Level level, int i, int i2, int i3) {
        return level.getHeight(Heightmap.Types.MOTION_BLOCKING, i, i2) > i3;
    }

    /* JADX INFO: renamed from: c */
    public static void m4353c(@NotNull Level level, @NotNull Vec3 vec3) {
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
    public static void m4354a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C0680mD c0680mD, @Nullable C0685mI c0685mI, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a != null) {
                m4356a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, c0680mD, c0685mI, serverPlayerM4399a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4355a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C0680mD c0680mD, @Nullable C0685mI c0685mI, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            m4356a(abstractC0531jN, c0680mD, c0685mI, serverPlayerM4399a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4356a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C0680mD c0680mD, @Nullable C0685mI c0685mI, @NotNull ServerPlayer serverPlayer) {
        AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jN.m2351a();
        AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) serverPlayer);
        if (abstractC0183bM1153a instanceof C1326ym) {
            C1323yj c1323yjM8298a = ((C1326ym) abstractC0183bM1153a).m8298a();
            c1323yjM8298a.m8287d(serverPlayer, abstractC0184cM2351a);
            c1323yjM8298a.m8282c(c0680mD);
            c1323yjM8298a.m8285b(serverPlayer, abstractC0184cM2351a);
        }
        C1169vO.m6643a(new C1250wq(c0680mD, Optional.ofNullable(c0685mI)), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m4357a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull ServerPlayer serverPlayer) {
        C0881pt c0881ptM4226c = abstractC0866pe.m4226c();
        if (c0881ptM4226c == null) {
            return;
        }
        for (C0745nP c0745nP : serverLevel.getEntitiesOfClass(C0745nP.class, new AABB(c0881ptM4226c.m4587c()).inflate(abstractC0863pb.m4032bk()))) {
            if (serverPlayer.equals(c0745nP.m3143a())) {
                c0745nP.discard();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4358a(@Nullable ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe) {
        C0881pt c0881ptM4226c;
        if (serverLevel == null || (c0881ptM4226c = abstractC0866pe.m4226c()) == null) {
            return;
        }
        for (Entity entity : serverLevel.getEntitiesOfClass(Entity.class, new AABB(c0881ptM4226c.m4587c()).inflate(abstractC0863pb.m4032bk()), entity2 -> {
            return (entity2 instanceof ItemEntity) || (entity2 instanceof AbstractC0699mW) || (entity2 instanceof C0701mY) || (entity2 instanceof C0756na) || (entity2 instanceof C0768nm) || (entity2 instanceof C0776nu) || (entity2 instanceof Horse) || (entity2 instanceof AbstractC0774ns) || (entity2 instanceof C0700mX) || (entity2 instanceof AbstractC0750nU);
        })) {
            if (entity instanceof AbstractC0750nU) {
                ((AbstractC0750nU) entity).ejectPassengers();
            }
            entity.discard();
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4359d(@NotNull Set<UUID> set) {
        set.forEach(C0875pn::m4360i);
    }

    /* JADX INFO: renamed from: i */
    public static void m4360i(@NotNull UUID uuid) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a == null) {
            return;
        }
        serverPlayerM4399a.getInventory().clearContent();
        serverPlayerM4399a.containerMenu.broadcastChanges();
    }

    /* JADX INFO: renamed from: a */
    public static void m4361a(@NotNull Set<UUID> set, @NotNull C0502il c0502il) {
        set.forEach(uuid -> {
            m4362a(uuid, c0502il);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4362a(@NotNull UUID uuid, @NotNull C0502il c0502il) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a == null) {
            return;
        }
        C1169vO.m6643a(new C1240wg(c0502il), serverPlayerM4399a);
    }

    /* JADX INFO: renamed from: a */
    public static void m4363a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        m4368a(uuid, soundEvent, soundSource, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m4364a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        m4365a(serverPlayer, soundEvent, soundSource, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m4365a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        C1169vO.m6643a(new C1254wu(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent), soundSource, f, f2), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m4366a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f) {
        m4365a(serverPlayer, soundEvent, soundSource, f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m4367a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f) {
        m4368a(uuid, soundEvent, soundSource, f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m4368a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            m4365a(serverPlayerM4399a, soundEvent, soundSource, f, f2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4369a(@NotNull Set<UUID> set, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        set.forEach(uuid -> {
            m4363a(uuid, soundEvent, soundSource);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4370a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        m4369a(abstractC0863pb.m4018b().m4248j(), soundEvent, soundSource);
    }

    /* JADX INFO: renamed from: a */
    public static void m4371a(@NotNull Set<UUID> set, SoundEvent soundEvent, SoundSource soundSource, float f) {
        m4372a(set, soundEvent, soundSource, f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m4372a(@NotNull Set<UUID> set, SoundEvent soundEvent, SoundSource soundSource, float f, float f2) {
        set.forEach(uuid -> {
            m4368a(uuid, soundEvent, soundSource, f, f2);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4373a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        C1169vO.m6643a(new C1255wv(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent), soundSource, f, vec3), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m4374a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        m4375a(abstractC0863pb.m4018b().m4248j(), soundEvent, soundSource, f, vec3);
    }

    /* JADX INFO: renamed from: a */
    public static void m4375a(@NotNull Set<UUID> set, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        set.forEach(uuid -> {
            m4376a(uuid, soundEvent, soundSource, f, vec3);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4376a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a == null) {
            return;
        }
        m4373a(serverPlayerM4399a, soundEvent, soundSource, f, vec3);
    }

    /* JADX INFO: renamed from: a */
    public static void m4377a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        level.playSound((Player) null, vec3.x, vec3.y, vec3.z, soundEvent, soundSource, f, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m4378a(@NotNull Level level, double d, double d2, double d3, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        level.playSound((Player) null, d, d2, d3, soundEvent, soundSource, f, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m4379a(@NotNull ServerPlayer serverPlayer, @NotNull C1088tn c1088tn) {
        C1169vO.m6643a(new C1238we(c1088tn), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m4380a(@NotNull UUID uuid, @NotNull C1088tn c1088tn) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            m4379a(serverPlayerM4399a, c1088tn);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4381a(@NotNull ServerPlayer serverPlayer, @NotNull C1089to c1089to) {
        C1169vO.m6643a(new C1223wP(c1089to), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public static void m4382a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0847pL c0847pL) {
        C1222wO c1222wO = new C1222wO(c0847pL);
        Iterator<UUID> it = abstractC0866pe.m4245h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = m4399a(it.next());
            if (serverPlayerM4399a != null) {
                C1169vO.m6643a(c1222wO, serverPlayerM4399a);
            }
        }
        Iterator<UUID> it2 = abstractC0866pe.m4246i().iterator();
        while (it2.hasNext()) {
            ServerPlayer serverPlayerM4399a2 = m4399a(it2.next());
            if (serverPlayerM4399a2 != null) {
                C1169vO.m6643a(c1222wO, serverPlayerM4399a2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4383a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @NotNull AbstractC0184c<?> abstractC0184c) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a != null) {
                m4384a((AbstractC0184c<?>) abstractC0184c, serverLevel, serverPlayerM4399a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4384a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        if (serverLevel.isClientSide()) {
            return;
        }
        serverPlayer.removeAllEffects();
        serverPlayer.resetFallDistance();
        serverPlayer.clearFire();
        serverPlayer.setInvisible(false);
        m4385e(serverPlayer);
        serverPlayer.setHealth(serverPlayer.getMaxHealth());
        Abilities abilities = serverPlayer.getAbilities();
        abilities.mayfly = false;
        abilities.flying = false;
        serverPlayer.onUpdateAbilities();
        serverPlayer.setGameMode(GameType.ADVENTURE);
        AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
        abstractC0183bM1153a.m1105Y(false);
        abstractC0183bM1153a.m1113J(0);
        abstractC0183bM1153a.m1094b().m1088X(false);
    }

    /* JADX INFO: renamed from: e */
    private static void m4385e(@NotNull ServerPlayer serverPlayer) {
        for (Holder<Attribute> holder : f4783aD) {
            AttributeInstance attribute = serverPlayer.getAttribute(holder);
            if (attribute != null) {
                attribute.setBaseValue(f4782a.getBaseValue(holder));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static SortedSet<UUID> m4386a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set, @NotNull C1060tL c1060tL) {
        return m4387a(abstractC0863pb, set, c1060tL.getKey());
    }

    /* JADX INFO: renamed from: a */
    public static SortedSet<UUID> m4387a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set, @NotNull String str) {
        if (set.size() <= 1) {
            return new ObjectLinkedOpenHashSet(set);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        objectArrayList.sort((uuid, uuid2) -> {
            return Integer.compare(abstractC0863pb.m4034a(uuid2).m4289a(str), abstractC0863pb.m4034a(uuid).m4289a(str));
        });
        return new ObjectLinkedOpenHashSet(objectArrayList);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectSortedSet<UUID> m4388a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, @NotNull C1060tL c1060tL, @NotNull Set<UUID> set) {
        return m4389a(abstractC0863pb, i, c1060tL.getKey(), set);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectSortedSet<UUID> m4389a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, @NotNull String str, @NotNull Set<UUID> set) {
        if (set.isEmpty() || i <= 0) {
            return new ObjectLinkedOpenHashSet();
        }
        SortedSet<UUID> sortedSetM4387a = m4387a(abstractC0863pb, set, str);
        ObjectLinkedOpenHashSet objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
        int i2 = 0;
        for (UUID uuid : sortedSetM4387a) {
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
    public static ObjectSortedSet<UUID> m4390a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, @NotNull C1060tL c1060tL, @NotNull C0872pk c0872pk) {
        return m4388a(abstractC0863pb, i, c1060tL, c0872pk.m4308h());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Set<UUID> m4391a(@NotNull Set<UUID> set, int i) {
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
    public static void m4392a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a != null) {
                m4394a((AbstractC0184c<?>) abstractC0184c, serverPlayerM4399a);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public static void m4393b(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a != null) {
                m4395b((AbstractC0184c<?>) abstractC0184c, serverPlayerM4399a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4394a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerPlayer serverPlayer) {
        abstractC0184c.m1153a((Player) serverPlayer).m1111aa(true);
    }

    /* JADX INFO: renamed from: b */
    public static void m4395b(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerPlayer serverPlayer) {
        AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
        if (abstractC0183bM1153a.m1110dv() || abstractC0183bM1153a.m1108l() != null) {
            abstractC0183bM1153a.m1111aa(false);
            abstractC0183bM1153a.m1109e((C0881pt) null);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4396a(@NotNull Set<UUID> set, @NotNull Component component) {
        set.forEach(uuid -> {
            m4397a(uuid, component);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4397a(@NotNull UUID uuid, @NotNull Component component) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            m4398b(serverPlayerM4399a, component);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4398b(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        serverPlayer.connection.disconnect(component);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ServerPlayer m4399a(@NotNull UUID uuid) {
        MinecraftServer minecraftServerM2335a;
        if (C0529jL.m2333af() && (minecraftServerM2335a = C0529jL.m2335a()) != null) {
            return minecraftServerM2335a.getPlayerList().getPlayer(uuid);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static void m4400a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull UUID uuid, @NotNull List<C0881pt> list) {
        m4401a(abstractC0184c, uuid, (C0881pt) C1267xG.m7152a(list));
    }

    /* JADX INFO: renamed from: a */
    public static void m4401a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull UUID uuid, @NotNull C0881pt c0881pt) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            m4402a(abstractC0184c, serverPlayerM4399a, c0881pt);
            serverPlayerM4399a.containerMenu.sendAllDataToRemote();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4402a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerPlayer serverPlayer, @NotNull C0881pt c0881pt) {
        serverPlayer.teleportTo(serverPlayer.serverLevel(), c0881pt.f4827c.x, c0881pt.f4827c.y, c0881pt.f4827c.z, c0881pt.f4826h.x, c0881pt.f4826h.y);
        AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
        if (abstractC0183bM1153a.m1110dv()) {
            abstractC0183bM1153a.m1109e(c0881pt);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4403a(@NotNull ChatGraphic chatGraphic, @NotNull Set<UUID> set, @NotNull Component component) {
        set.forEach(uuid -> {
            m4404a(chatGraphic, uuid, component);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4404a(@NotNull ChatGraphic chatGraphic, @NotNull UUID uuid, @NotNull Component component) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            m4405a(chatGraphic, serverPlayerM4399a, component);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4405a(@NotNull ChatGraphic chatGraphic, @NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        C1169vO.m6643a(new C1156vB(chatGraphic, component), serverPlayer);
    }

    /* JADX INFO: renamed from: c */
    public static void m4406c(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        m4409a(serverPlayer, C1062tN.f5784jM, component);
    }

    /* JADX INFO: renamed from: b */
    public static void m4407b(@NotNull UUID uuid, @NotNull Component component) {
        m4408a(uuid, C1062tN.f5784jM, component);
    }

    /* JADX INFO: renamed from: a */
    public static void m4408a(@NotNull UUID uuid, @NotNull Component component, @NotNull Component component2) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a == null) {
            return;
        }
        m4409a(serverPlayerM4399a, component, component2);
    }

    /* JADX INFO: renamed from: a */
    public static void m4409a(@NotNull ServerPlayer serverPlayer, @NotNull Component component, @NotNull Component component2) {
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
    public static void m4410a(@NotNull ServerLevel serverLevel, @NotNull C1280xT c1280xT, @NotNull Component component) {
        if (C0529jL.m2333af()) {
            C1328yo c1328yo = (C1328yo) c1280xT.m7277a();
            serverLevel.getServer().getPlayerList().getPlayers().stream().filter(serverPlayer -> {
                return c1328yo.m1150a((Player) serverPlayer).m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN);
            }).forEach(serverPlayer2 -> {
                m4406c(serverPlayer2, component);
            });
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4411e(@NotNull Set<UUID> set) {
        m4412b(set, (Component) Component.empty());
    }

    /* JADX INFO: renamed from: b */
    public static void m4412b(@NotNull Set<UUID> set, @NotNull Component component) {
        m4415a(set, C1062tN.f5784jM, component);
    }

    /* JADX INFO: renamed from: a */
    public static void m4413a(@NotNull Set<UUID> set, @NotNull String str) {
        m4415a(set, C1062tN.f5784jM, (Component) Component.literal(str));
    }

    /* JADX INFO: renamed from: a */
    public static void m4414a(@NotNull Set<UUID> set, @NotNull Component component, @NotNull String str) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a == null) {
                return;
            }
            m4409a(serverPlayerM4399a, component, (Component) Component.literal(str));
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4415a(@NotNull Set<UUID> set, @NotNull Component component, @NotNull Component component2) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a == null) {
                return;
            }
            m4409a(serverPlayerM4399a, component, component2);
        });
    }

    /* JADX INFO: renamed from: f */
    public static void m4416f(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        m4411e(abstractC0863pb.m4018b().m4248j());
    }

    /* JADX INFO: renamed from: a */
    public static void m4417a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component) {
        m4412b(abstractC0863pb.m4018b().m4248j(), component);
    }

    /* JADX INFO: renamed from: a */
    public static void m4418a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull String str) {
        m4413a(abstractC0863pb.m4018b().m4248j(), str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4419a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component, @NotNull Component component2) {
        m4415a(abstractC0863pb.m4018b().m4248j(), component, component2);
    }

    /* JADX INFO: renamed from: a */
    public static void m4420a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component, @NotNull String str) {
        m4414a(abstractC0863pb.m4018b().m4248j(), component, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4421a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull Component component, @NotNull Component component2) {
        m4423a(abstractC0866pe, c0872pk, EnumC0877pp.ALL, component, component2);
    }

    /* JADX INFO: renamed from: a */
    public static void m4422a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull Component component) {
        abstractC0866pe.m4249a(c0872pk, EnumC0877pp.ALL).forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a == null) {
                return;
            }
            m4406c(serverPlayerM4399a, component);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4423a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull EnumC0877pp enumC0877pp, @NotNull Component component, @NotNull Component component2) {
        abstractC0866pe.m4249a(c0872pk, enumC0877pp).forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a == null) {
                return;
            }
            m4409a(serverPlayerM4399a, component, component2);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4424a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0300ev enumC0300ev) {
        m4425a(abstractC0866pe, c0872pk, EnumC0877pp.ALL, component, component2, enumC0300ev);
    }

    /* JADX INFO: renamed from: a */
    public static void m4425a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull EnumC0877pp enumC0877pp, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0300ev enumC0300ev) {
        abstractC0866pe.m4249a(c0872pk, enumC0877pp).forEach(uuid -> {
            m4426a(uuid, component, component2, enumC0300ev);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4426a(@NotNull UUID uuid, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0300ev enumC0300ev) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            C1169vO.m6643a(new C1160vF(component, component2, enumC0300ev), serverPlayerM4399a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4427a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull Component component, int i, @Nullable String str) {
        m4428a(abstractC0866pe, c0872pk, EnumC0877pp.ALL, component, i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4428a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull EnumC0877pp enumC0877pp, @NotNull Component component, int i, @Nullable String str) {
        abstractC0866pe.m4249a(c0872pk, enumC0877pp).forEach(uuid -> {
            m4440a(uuid, component, i, str);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4429a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        abstractC0866pe.m4249a(c0872pk, EnumC0877pp.ALL).forEach(uuid -> {
            m4443a(uuid, component, i, str, vec3, i2, i3);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4430a(@NotNull Set<UUID> set, @NotNull Component component, int i) {
        m4431a(set, component, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4431a(@NotNull Set<UUID> set, @NotNull Component component, int i, @Nullable String str) {
        set.forEach(uuid -> {
            m4440a(uuid, component, i, str);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4432a(@NotNull Set<UUID> set, @NotNull List<Component> list, int i) {
        m4433a(set, list, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4433a(@NotNull Set<UUID> set, @NotNull List<Component> list, int i, @Nullable String str) {
        set.forEach(uuid -> {
            m4442a(uuid, (List<Component>) list, i, str);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4434a(@NotNull Set<UUID> set, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        set.forEach(uuid -> {
            m4443a(uuid, component, i, str, vec3, i2, i3);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4435a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component, int i) {
        m4436a(abstractC0863pb, component, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4436a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component, int i, @Nullable String str) {
        m4431a(abstractC0863pb.m4018b().m4248j(), component, i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4437a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull List<Component> list, int i, @Nullable String str) {
        m4433a(abstractC0863pb.m4018b().m4248j(), list, i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4438a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        m4434a(abstractC0863pb.m4018b().m4248j(), component, i, str, vec3, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m4439a(@NotNull UUID uuid, @NotNull Component component, int i) {
        m4440a(uuid, component, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4440a(@NotNull UUID uuid, @NotNull Component component, int i, @Nullable String str) {
        m4442a(uuid, (List<Component>) List.of(component), i, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m4441a(@NotNull UUID uuid, @NotNull List<Component> list, int i) {
        m4442a(uuid, list, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4442a(@NotNull UUID uuid, @NotNull List<Component> list, int i, @Nullable String str) {
        m4444a(uuid, list, i, str, (Vec3) null, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m4443a(@NotNull UUID uuid, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        m4444a(uuid, (List<Component>) List.of(component), i, str, vec3, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m4444a(@NotNull UUID uuid, @NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null) {
            C1169vO.m6643a(new C1177vW(list, i, str, vec3, i2, i3), serverPlayerM4399a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m4445a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL) {
        return abstractC0863pb.m4034a(uuid).m4289a(c1060tL.getKey());
    }

    /* JADX INFO: renamed from: a */
    public static int m4446a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL, int i) {
        return abstractC0863pb.m4034a(uuid).m4290a(c1060tL.getKey(), i);
    }

    /* JADX INFO: renamed from: a */
    public static void m4447a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL, int i) {
        abstractC0863pb.m4034a(uuid).m4291a(c1060tL.getKey(), i);
    }

    /* JADX INFO: renamed from: a */
    public static void m4448a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set, @NotNull C1060tL c1060tL) {
        m4449a(abstractC0531jN, abstractC0863pb, set, c1060tL, 1);
    }

    /* JADX INFO: renamed from: a */
    public static void m4449a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set, @NotNull C1060tL c1060tL, int i) {
        set.forEach(uuid -> {
            m4451a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, uuid, c1060tL, i);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4450a(AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL) {
        m4451a(abstractC0531jN, abstractC0863pb, uuid, c1060tL, 1);
    }

    /* JADX INFO: renamed from: a */
    public static void m4451a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL, int i) {
        m4452a(abstractC0531jN, abstractC0863pb, uuid, c1060tL, i, (ItemStack) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m4452a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL, int i, @Nullable ItemStack itemStack) {
        m4453a(abstractC0531jN, abstractC0863pb, uuid, c1060tL, i, itemStack, -1);
    }

    /* JADX INFO: renamed from: a */
    public static void m4453a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL, int i, @Nullable ItemStack itemStack, int i2) {
        int iM4445a = m4445a(abstractC0863pb, uuid, c1060tL);
        m4447a(abstractC0863pb, uuid, c1060tL, iM4445a + i);
        if (c1060tL instanceof C1059tK) {
            ((C1059tK) c1060tL).m5881a(uuid, i);
        }
        if (abstractC0531jN.mo2375g() && c1060tL.m5884cp()) {
            c1060tL.m5883a(abstractC0531jN, abstractC0863pb, uuid, i, iM4445a + i, itemStack, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4454a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL) {
        m4455b(abstractC0863pb, uuid, c1060tL, 1);
    }

    /* JADX INFO: renamed from: b */
    public static void m4455b(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull C1060tL c1060tL, int i) {
        m4447a(abstractC0863pb, uuid, c1060tL, m4445a(abstractC0863pb, uuid, c1060tL) - i);
    }

    /* JADX INFO: renamed from: f */
    public static void m4456f(@NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerM4399a = m4399a(uuid);
            if (serverPlayerM4399a != null) {
                C1169vO.m6643a(new C1159vE(), serverPlayerM4399a);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4457a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0837pB c0837pB) {
        m4458a(serverLevel, serverPlayer, c0837pB, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m4458a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0837pB c0837pB, boolean z) {
        EquipmentSlot equipmentSlot;
        if (serverLevel.isClientSide()) {
            return;
        }
        Inventory inventory = serverPlayer.getInventory();
        if (!z) {
            inventory.clearContent();
        }
        int i = 3;
        ItemStack itemStackM3824e = c0837pB.m3824e();
        if (itemStackM3824e != null && !itemStackM3824e.isEmpty()) {
            inventory.setItem(0, itemStackM3824e.copy());
        }
        ItemStack itemStackM3825f = c0837pB.m3825f();
        if (itemStackM3825f != null && !itemStackM3825f.isEmpty()) {
            inventory.setItem(1, itemStackM3825f.copy());
        }
        ItemStack itemStackM3826g = c0837pB.m3826g();
        if (itemStackM3826g != null && !itemStackM3826g.isEmpty()) {
            inventory.setItem(2, itemStackM3826g.copy());
        }
        ItemStack itemStackM3827h = c0837pB.m3827h();
        if (itemStackM3827h != null && !itemStackM3827h.isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.OFF_HAND, itemStackM3827h.copy());
        }
        ItemStack itemStackM3829j = c0837pB.m3829j();
        if (itemStackM3829j != null && !itemStackM3829j.isEmpty()) {
            serverPlayer.setItemSlot(serverPlayer.getEquipmentSlotForItem(itemStackM3829j), itemStackM3829j);
        }
        for (ItemStack itemStack : c0837pB.m3823H()) {
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
        for (ItemStack itemStack2 : c0837pB.m3832I()) {
            ItemStack itemStackCopy = itemStack2.copy();
            ArmorItem item = itemStack2.getItem();
            if ((item instanceof ArmorItem) && (equipmentSlot = item.getEquipmentSlot(itemStackCopy)) != null) {
                serverPlayer.setItemSlot(equipmentSlot, itemStack2.copy());
            }
        }
        serverPlayer.containerMenu.broadcastChanges();
    }

    /* JADX INFO: renamed from: a */
    public static void m4459a(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull C0837pB c0837pB) {
        EquipmentSlot equipmentSlot;
        if (level.isClientSide()) {
            return;
        }
        if (c0837pB.m3824e() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0837pB.m3824e());
        }
        if (c0837pB.m3825f() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0837pB.m3825f());
        }
        if (c0837pB.m3826g() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0837pB.m3826g());
        }
        if (c0837pB.m3827h() != null) {
            livingEntity.setItemInHand(InteractionHand.OFF_HAND, c0837pB.m3827h());
        }
        Iterator<ItemStack> it = c0837pB.m3832I().iterator();
        while (it.hasNext()) {
            ItemStack itemStackCopy = it.next().copy();
            ArmorItem item = itemStackCopy.getItem();
            if ((item instanceof ArmorItem) && (equipmentSlot = item.getEquipmentSlot(itemStackCopy)) != null) {
                switch (AnonymousClass1.f4788s[equipmentSlot.ordinal()]) {
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

    /* JADX INFO: renamed from: com.boehmod.blockfront.pn$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pn$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: s */
        static final /* synthetic */ int[] f4788s = new int[EquipmentSlot.values().length];

        static {
            try {
                f4788s[EquipmentSlot.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4788s[EquipmentSlot.CHEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4788s[EquipmentSlot.LEGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4788s[EquipmentSlot.FEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4460a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
        long time = (Calendar.getInstance().getTime().getTime() - abstractC0183bM1153a.m1102j()) / 1000;
        if (abstractC0863pb.mo4057bn() && time <= 5 && abstractC0863pb.m4023a() == EnumC0871pj.GAME && abstractC0183bM1153a.m1102j() != 0) {
            m4412b(set, (Component) Component.translatable("bf.message.gamemode.ragequit", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
            m4461a(abstractC0531jN, uuid, CloudAchievements.ACH_USER_RAGEQUIT);
        }
        abstractC0183bM1153a.m1103e(0L);
    }

    /* JADX INFO: renamed from: a */
    public static void m4461a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull UUID uuid, @NotNull CloudAchievement cloudAchievement) {
        abstractC0531jN.m2342b().sendPacket(new PacketPlayerDataIncreaseValue(uuid, "achievement", cloudAchievement.getId()));
    }

    /* JADX INFO: renamed from: f */
    public static void m4462f(@NotNull ServerPlayer serverPlayer) {
        Inventory inventory = serverPlayer.getInventory();
        int size = inventory.items.size();
        for (int i = 0; i < size; i++) {
            ItemStack itemStack = (ItemStack) inventory.items.get(i);
            if (!itemStack.isEmpty() && (itemStack.getItem() instanceof C1117uP)) {
                C1117uP.m6270f(itemStack);
                C1117uP.m6273g(itemStack);
                serverPlayer.containerMenu.sendAllDataToRemote();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4463a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            m4464a(serverLevel, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, uuid);
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m4464a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid) {
        C0872pk c0872pkM4229a = abstractC0863pb.m4018b().m4229a(uuid);
        C0870pi c0870piM4034a = abstractC0863pb.m4034a(uuid);
        int iM4290a = c0870piM4034a.m4290a(C1062tN.f5745i.getKey(), -1);
        int iM4290a2 = c0870piM4034a.m4290a(C1062tN.f5746j.getKey(), -1);
        ServerPlayer serverPlayerM4399a = m4399a(uuid);
        if (serverPlayerM4399a != null && c0872pkM4229a != null && iM4290a != -1 && iM4290a2 != -1) {
            m4457a(serverLevel, serverPlayerM4399a, m4465a(abstractC0863pb, c0872pkM4229a, C1093ts.m6016a(iM4290a), iM4290a2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0837pB m4465a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0872pk c0872pk, @NotNull C1093ts c1093ts, int i) {
        return c0872pk.m4296a(abstractC0863pb).m6184a(c1093ts, i);
    }

    /* JADX INFO: renamed from: a */
    public static int m4466a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C1093ts c1093ts, @NotNull C0872pk c0872pk) {
        int i = 0;
        String key = C1062tN.f5745i.getKey();
        int iM6011cc = c1093ts.m6011cc();
        Iterator<UUID> it = c0872pk.m4308h().iterator();
        while (it.hasNext()) {
            if (abstractC0863pb.m4034a(it.next()).m4289a(key) == iM6011cc) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static void m4467a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        m4384a(abstractC0184c, serverLevel, serverPlayer);
        abstractC0531jN.m2357a(abstractC0531jN, abstractC0184c, serverLevel, serverPlayer, uuid);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4468b(@NotNull ItemStack itemStack) {
        int iM6403cr;
        Item item = itemStack.getItem();
        if (!(item instanceof C1117uP)) {
            return false;
        }
        C1117uP c1117uP = (C1117uP) item;
        if (c1117uP.m6324cC() && C1117uP.m6268d(itemStack) != (iM6403cr = c1117uP.m6283a(itemStack).m6403cr())) {
            C1117uP.m6269c(itemStack, iM6403cr);
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m4469h(@NotNull Player player) {
        for (ItemStack itemStack : player.getInventory().items.subList(0, 9)) {
            if (itemStack == null || !itemStack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static int m4470a(@NotNull Inventory inventory, int i, int i2) {
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

    /* JADX INFO: renamed from: d */
    public static boolean m4471d(@NotNull ServerPlayer serverPlayer) {
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (!itemStack.isEmpty()) {
                Item item = itemStack.getItem();
                if (item instanceof C1117uP) {
                    C1118uQ c1118uQM6283a = ((C1117uP) item).m6283a(itemStack);
                    int iM6402cq = c1118uQM6283a.m6402cq();
                    if (C1117uP.m6268d(itemStack) != c1118uQM6283a.m6403cr() || C1117uP.m6265c(itemStack) != iM6402cq) {
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
    public static boolean m4472a(@NotNull ServerPlayer serverPlayer, @NotNull C0837pB c0837pB) {
        List<ItemStack> listM3823H = c0837pB.m3823H();
        if (listM3823H.isEmpty()) {
            return false;
        }
        HashMap map = new HashMap();
        for (ItemStack itemStack : listM3823H) {
            if (!itemStack.isEmpty()) {
                map.merge(itemStack.getItem(), Integer.valueOf(itemStack.getCount()), (v0, v1) -> {
                    return Integer.sum(v0, v1);
                });
            }
        }
        HashMap map2 = new HashMap();
        for (ItemStack itemStack2 : serverPlayer.getInventory().items) {
            if (!itemStack2.isEmpty() && (itemStack2.getItem() instanceof InterfaceC1148uu)) {
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
    public static boolean m4473a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull C0872pk c0872pk) {
        Iterator<UUID> it = c0872pk.m4308h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = m4399a(it.next());
            if (serverPlayerM4399a != null && !m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) abstractC0184c.m1153a((Player) serverPlayerM4399a))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m4474a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0872pk c0872pk) {
        C0870pi c0870piM4034a = abstractC0863pb.m4034a(serverPlayer.getUUID());
        int iM4290a = c0870piM4034a.m4290a(C1062tN.f5745i.getKey(), -1);
        int iM4290a2 = c0870piM4034a.m4290a(C1062tN.f5746j.getKey(), -1);
        if (iM4290a != -1 && iM4290a2 != -1) {
            C1093ts c1093tsM6016a = C1093ts.m6016a(iM4290a);
            c0870piM4034a.m4291a(C1062tN.f5747k.getKey(), iM4290a);
            m4457a(serverLevel, serverPlayer, m4465a(abstractC0863pb, c0872pk, c1093tsM6016a, iM4290a2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4475a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0872pk c0872pk) {
        Iterator<UUID> it = c0872pk.m4308h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = m4399a(it.next());
            if (serverPlayerM4399a != null) {
                m4474a(serverLevel, serverPlayerM4399a, abstractC0863pb, c0872pk);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4476a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull UUID uuid, @NotNull UUID uuid2) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jN.mo2354a(uuid);
        if (abstractC0863pbMo2354a == null) {
            return false;
        }
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b();
        C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid);
        return c0872pkM4229a != null && c0872pkM4229a.equals(abstractC0866peM4018b.m4229a(uuid2));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4477a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull UUID uuid, @NotNull UUID uuid2) {
        C0872pk c0872pkM4229a = abstractC0866pe.m4229a(uuid);
        return c0872pkM4229a != null && c0872pkM4229a.equals(abstractC0866pe.m4229a(uuid2));
    }

    /* JADX INFO: renamed from: a */
    public static BlockPos m4478a(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos) {
        BlockPos heightmapPos = serverLevel.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos);
        if (heightmapPos.getY() == serverLevel.getMinBuildHeight() - 1) {
            heightmapPos = heightmapPos.above(2);
        }
        return heightmapPos;
    }

    /* JADX INFO: renamed from: a */
    public static void m4479a(@NotNull LivingEntity livingEntity, @NotNull ParticleOptions particleOptions, @NotNull RandomSource randomSource, float f, float f2, float f3, int i) {
        ServerLevel serverLevelLevel = livingEntity.level();
        if (serverLevelLevel instanceof ServerLevel) {
            ServerLevel serverLevel = serverLevelLevel;
            for (int i2 = 0; i2 < i; i2++) {
                serverLevel.sendParticles(particleOptions, livingEntity.getRandomX(1.0d) + ((double) f), livingEntity.getRandomY() + ((double) f2), livingEntity.getRandomZ(1.0d) + ((double) f3), 1, randomSource.nextGaussian() * 0.02d, randomSource.nextGaussian() * 0.02d, randomSource.nextGaussian() * 0.02d, 1.0d);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4480a(@NotNull Level level, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, double d, double d2, int i, float f) {
        for (int i2 = 0; i2 < i; i2++) {
            double dPow = d + ((d2 - d) * Math.pow(level.random.nextDouble(), 2.0d));
            double d3 = (6.283185307179586d / ((double) i)) * ((double) i2);
            double dCos = Math.cos(d3);
            double dSin = Math.sin(d3);
            level.addParticle(particleOptions, true, vec3.x + (dPow * dCos), vec3.y, vec3.z + (dPow * dSin), ((double) f) * dCos, 0.0d, ((double) f) * dSin);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4481a(@NotNull Level level, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
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
    public static boolean m4482a(@NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, float f) {
        float fAbs = Math.abs(((livingEntity.getYHeadRot() + 360.0f) % 360.0f) - ((livingEntity2.getYHeadRot() + 360.0f) % 360.0f));
        return ((fAbs > 180.0f ? 1 : (fAbs == 180.0f ? 0 : -1)) > 0 ? 360.0f - fAbs : fAbs) <= f;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4483b(@NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, float f) {
        Vec3 eyePosition = livingEntity2.getEyePosition();
        Vec3 eyePosition2 = livingEntity.getEyePosition();
        float yHeadRot = livingEntity.getYHeadRot();
        float xRot = livingEntity.getXRot();
        return Math.acos(new Vec3((double) ((-Mth.sin(yHeadRot * 0.017453292f)) * Mth.cos(xRot * 0.017453292f)), (double) (-Mth.sin(xRot * 0.017453292f)), (double) (Mth.cos(yHeadRot * 0.017453292f) * Mth.cos(xRot * 0.017453292f))).dot(eyePosition.subtract(eyePosition2).normalize())) <= Math.toRadians((double) (f / 2.0f));
    }

    /* JADX INFO: renamed from: a */
    public static float m4484a(@NotNull Entity entity, @NotNull Camera camera) {
        return m4486a(entity, camera.getPosition());
    }

    /* JADX INFO: renamed from: a */
    public static float m4485a(@NotNull Entity entity, @NotNull Entity entity2) {
        return m4486a(entity, entity2.getEyePosition());
    }

    /* JADX INFO: renamed from: a */
    public static float m4486a(@NotNull Entity entity, @NotNull Vec3 vec3) {
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
    public static boolean m4487a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        if (!livingEntity2.isAlive() || livingEntity2.getHealth() <= 0.0f || livingEntity2.tickCount <= 20) {
            return false;
        }
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (livingEntity2 instanceof ServerPlayer) {
                AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jN.mo2354a(serverPlayer.getUUID());
                AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a2 = abstractC0531jN.mo2354a(((ServerPlayer) livingEntity2).getUUID());
                if (abstractC0863pbMo2354a != null && abstractC0863pbMo2354a2 != null && !abstractC0863pbMo2354a.equals(abstractC0863pbMo2354a2)) {
                    return false;
                }
            }
        }
        Entity vehicle = livingEntity2.getVehicle();
        if ((vehicle instanceof AbstractC0750nU) && ((AbstractC0750nU) vehicle).m3450k(livingEntity2)) {
            return false;
        }
        if (livingEntity2 instanceof Player) {
            Entity entity = (Player) livingEntity2;
            if (abstractC0184c.m1153a((Player) entity).m1104dt() || entity.isSpectator()) {
                return false;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a3 = abstractC0531jN.mo2354a(entity.getUUID());
            if (abstractC0863pbMo2354a3 != null && abstractC0863pbMo2354a3.m4018b().m4247g(entity.getUUID())) {
                return false;
            }
            Entity vehicle2 = entity.getVehicle();
            if ((vehicle2 instanceof AbstractC0750nU) && ((AbstractC0750nU) vehicle2).m3450k(entity)) {
                return false;
            }
        }
        if (livingEntity instanceof C0756na) {
            return ((C0756na) livingEntity).canAttack(livingEntity2);
        }
        return (livingEntity2.isSpectator() || livingEntity2.equals(livingEntity)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4488a(@NotNull Player player, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        return abstractC0183b.m1104dt() || !player.isAlive() || player.isSpectator() || player.isDeadOrDying();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4489a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @Nullable LivingEntity livingEntity, @NotNull UUID uuid) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a;
        return (livingEntity == null || (abstractC0863pbMo2354a = abstractC0531jN.mo2354a(livingEntity.getUUID())) == null || !abstractC0863pbMo2354a.m4018b().m4247g(uuid)) ? false : true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Explosion m4490a(@NotNull Level level, @Nullable Entity entity, @NotNull Vec3 vec3, @NotNull ItemStack itemStack, float f) {
        Entity entityM3143a;
        if (entity instanceof AbstractC0699mW) {
            entityM3143a = ((AbstractC0699mW) entity).m3143a();
        } else {
            entityM3143a = entity;
        }
        return new Explosion(level, entity, new C0725mw(level, entityM3143a, itemStack, vec3, (entity instanceof C0745nP) && ((C0745nP) entity).m3405aD()), (ExplosionDamageCalculator) null, vec3.x, vec3.y, vec3.z, f, false, Explosion.BlockInteraction.KEEP, ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, SoundEvents.GENERIC_EXPLODE);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static <T extends Entity> T m4491a(@NotNull Level level, @NotNull Entity entity, @NotNull Class<T> cls, float f) {
        List entitiesOfClass = level.getEntitiesOfClass(cls, entity.getBoundingBox().inflate(f));
        if (!entitiesOfClass.isEmpty()) {
            return (T) entitiesOfClass.getFirst();
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Set<UUID> m4492a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Set<UUID> set) {
        Object2FloatOpenHashMap object2FloatOpenHashMap = new Object2FloatOpenHashMap();
        for (UUID uuid : set) {
            C0555jl c0555jlM1149a = abstractC0184c.m1149a(uuid);
            object2FloatOpenHashMap.put(uuid, c0555jlM1149a.getKills() / Math.max(1.0f, c0555jlM1149a.getDeaths()));
        }
        return (Set) object2FloatOpenHashMap.object2FloatEntrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map((v0) -> {
            return v0.getKey();
        }).collect(Collectors.toCollection(ObjectLinkedOpenHashSet::new));
    }

    /* JADX INFO: renamed from: a */
    public static void m4493a(@NotNull C1280xT c1280xT, @NotNull C1328yo c1328yo, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull Component component, @NotNull UUID uuid) {
        if (!abstractC0863pb.m4068a(c1280xT, serverPlayer, component)) {
            return;
        }
        String string = component.getString();
        boolean zStartsWith = string.startsWith(f4785bX);
        C1326ym c1326ym = (C1326ym) c1328yo.m1150a((Player) serverPlayer);
        C0555jl c0555jlA = c1328yo.m1150a((Player) serverPlayer);
        if (c1280xT.mo2374f() && !m4494a(c1280xT, serverLevel, serverPlayer, string, c1326ym, c0555jlA)) {
            return;
        }
        C0530jM.log("[Chat] %s: %s", serverPlayer.getScoreboardName(), string);
        m4497a(c1280xT, abstractC0863pb, component, serverPlayer, uuid);
        Set<UUID> setM4248j = abstractC0863pb.m4018b().m4248j();
        String scoreboardName = serverPlayer.getScoreboardName();
        boolean zM4488a = m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) c1326ym);
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (UUID uuid2 : setM4248j) {
            ServerPlayer serverPlayerM4399a = m4399a(uuid2);
            if (serverPlayerM4399a != null && abstractC0863pb.m4070a(uuid, serverPlayerM4399a, uuid2, zStartsWith, zM4488a)) {
                objectOpenHashSet.add(uuid2);
            }
        }
        UUID uuidM8306a = null;
        if (c1280xT.mo2374f()) {
            uuidM8306a = c1280xT.m7280a().m8306a(uuid, scoreboardName, string.replace("<" + scoreboardName + "> ", ""), objectOpenHashSet, abstractC0863pb.m4025S());
        }
        Component componentM4495a = m4495a(c1328yo, abstractC0863pb, serverPlayer, uuid, scoreboardName, component, c1326ym, null, uuidM8306a);
        List objectArrayList = new ObjectArrayList();
        Iterator<UUID> it = setM4248j.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a2 = m4399a(it.next());
            if (serverPlayerM4399a2 != null && C1266xF.m7145c(string, serverPlayerM4399a2.getScoreboardName())) {
                objectArrayList.add(serverPlayerM4399a2.getScoreboardName());
            }
        }
        for (UUID uuid3 : objectOpenHashSet) {
            ServerPlayer serverPlayerM4399a3 = m4399a(uuid3);
            if (serverPlayerM4399a3 != null) {
                String scoreboardName2 = serverPlayerM4399a3.getScoreboardName();
                Component componentM4495a2 = componentM4495a;
                if (uuid3.equals(uuid)) {
                    componentM4495a2 = m4495a(c1328yo, abstractC0863pb, serverPlayer, uuid, scoreboardName, component, c1326ym, objectArrayList.isEmpty() ? null : objectArrayList, null);
                } else if (C1266xF.m7145c(string, scoreboardName2)) {
                    componentM4495a2 = m4495a(c1328yo, abstractC0863pb, serverPlayer, uuid, scoreboardName, component, c1326ym, List.of(scoreboardName2), uuidM8306a);
                }
                serverPlayerM4399a3.sendSystemMessage(componentM4495a2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4494a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b, @NotNull C0555jl c0555jl) {
        Component componentM7295a = C1283xW.m7295a(abstractC0531jN, serverPlayer, serverLevel, abstractC0183b, c0555jl, str);
        if (componentM7295a != null) {
            m4405a(ChatGraphic.WARNING, serverPlayer, componentM7295a);
            m4365a(serverPlayer, (SoundEvent) SoundEvents.NOTE_BLOCK_HARP.value(), SoundSource.MASTER, 1.0f, 2.0f);
            m4365a(serverPlayer, (SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), SoundSource.MASTER, 1.0f, 2.0f);
            return false;
        }
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m4495a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull String str, @NotNull Component component, @NotNull C1326ym c1326ym, @Nullable List<String> list, @Nullable UUID uuid2) {
        MutableComponent mutableComponentEmpty;
        MutableComponent mutableComponentLiteral;
        String strReplace = component.getString().replace("<" + str + "> ", "");
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
        boolean zStartsWith = strReplace.startsWith(f4785bX);
        String strReplace2 = strReplace.replace("[Team] ", "");
        boolean zM4488a = m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) c1326ym);
        C0555jl c0555jlM1150a = abstractC0184c.m1150a((Player) serverPlayer);
        MutableComponent mutableComponentM2515b = c0555jlM1150a.m2515b();
        MutableComponent mutableComponentM4496b = m4496b(c0555jlM1150a);
        PlayerRank rank = c0555jlM1150a.getRank();
        MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(rank.getGraphic())).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(rank.getTitle()).withColor(ColorReferences.COLOR_WHITE))));
        MutableComponent mutableComponentAppend = Component.empty().append(mutableComponentM2515b);
        if (c1326ym.m8303dE()) {
            mutableComponentEmpty = Component.empty().append(f4787t).append(" ");
        } else {
            mutableComponentEmpty = Component.empty();
        }
        MutableComponent mutableComponentWithStyle2 = mutableComponentAppend.withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, mutableComponentM4496b)));
        C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid);
        MutableComponent mutableComponentWithStyle3 = Component.literal(": ").withStyle(c0872pkM4229a != null ? c0872pkM4229a.m4312a() : Style.EMPTY);
        String strReplaceAll = strReplace2.replaceAll("\\p{C}", "?");
        if (C0549jf.f3276dy) {
            mutableComponentLiteral = C1265xE.m7139a(strReplaceAll);
        } else {
            mutableComponentLiteral = Component.literal(strReplaceAll);
        }
        MutableComponent mutableComponentWithStyle4 = mutableComponentLiteral;
        if (list != null) {
            mutableComponentWithStyle4 = C1266xF.m7147a((Component) mutableComponentWithStyle4, list);
        }
        if (uuid2 != null) {
            mutableComponentWithStyle4 = mutableComponentWithStyle4.copy().withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, f4781jd)).withClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "bf:chat_report/" + String.valueOf(uuid2))));
        }
        MutableComponent mutableComponentAppend2 = Component.empty().append(mutableComponentEmpty).append(mutableComponentWithStyle).append(" ").append(mutableComponentWithStyle2).append(mutableComponentWithStyle3).append(mutableComponentWithStyle4);
        if (c0872pkM4229a != null) {
            mutableComponentAppend2 = mutableComponentAppend2.copy().withStyle(c0872pkM4229a.m4313b());
        }
        if (abstractC0866peM4018b.m4247g(uuid)) {
            mutableComponentAppend2 = Component.empty().append(f4780jc).append(" ").append(mutableComponentAppend2);
        } else if (zM4488a) {
            mutableComponentAppend2 = Component.empty().append(f4778ja).append(" ").append(mutableComponentAppend2);
        } else if (zStartsWith) {
            mutableComponentAppend2 = Component.empty().append(f4779jb).append(" ").append(mutableComponentAppend2);
        }
        return mutableComponentAppend2;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static MutableComponent m4496b(@NotNull C0555jl c0555jl) {
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(Component.literal("Player " + c0555jl.getUsername() + " Stats:"));
        mutableComponentEmpty.append("\n");
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.exp", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getExp())).withStyle(ChatFormatting.YELLOW)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.karma", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getMatchKarma())).withStyle(ChatFormatting.LIGHT_PURPLE)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.time", new Object[]{Component.literal(ModLibraryMathHelper.round(c0555jl.getMinutesPlayed() / 60.0d, 1) + "h").withStyle(ChatFormatting.GRAY)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.games", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getTotalGames())).withStyle(ChatFormatting.GRAY)}));
        mutableComponentEmpty.append("\n");
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.headshots", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getHeadShots())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getKills())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.assists", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getAssists())).withStyle(ChatFormatting.YELLOW)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills.streak", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getKillStreak())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills.fire", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getFireKills())).withStyle(ChatFormatting.GOLD)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.deaths", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getDeaths())).withStyle(ChatFormatting.RED)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.deaths.streak", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getDeathStreak())).withStyle(ChatFormatting.RED)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.fb", new Object[]{Component.literal(C1273xM.m7239b(c0555jl.getFirstBloods())).withStyle(ChatFormatting.DARK_RED)}));
        int prestigeLevel = c0555jl.getPrestigeLevel();
        if (prestigeLevel > 0) {
            mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.prestige", new Object[]{Component.literal(C1273xM.m7239b(prestigeLevel)).withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)}));
        }
        mutableComponentEmpty.append("\n");
        return mutableComponentEmpty;
    }

    /* JADX INFO: renamed from: a */
    private static void m4497a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        if (abstractC0863pb.m4023a() == EnumC0871pj.POST_GAME && m4445a(abstractC0863pb, uuid, C1062tN.f5742f) != 1 && !abstractC0863pb.m4018b().m4247g(uuid) && m4498a(component)) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.popup.message.karma", new Object[]{Component.literal(String.valueOf(3)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.LIGHT_PURPLE);
            m4450a(abstractC0531jN, abstractC0863pb, uuid, C1062tN.f5742f);
            m4451a(abstractC0531jN, abstractC0863pb, uuid, C1062tN.f5756t, 3);
            m4406c(serverPlayer, (Component) mutableComponentWithStyle);
            m4379a(serverPlayer, new C1088tn(mutableComponentWithStyle, 80));
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4498a(@NotNull Component component) {
        String lowerCase = component.getString().toLowerCase(Locale.ROOT);
        return lowerCase.contains("gg") || lowerCase.contains("wp") || (lowerCase.contains("good") && lowerCase.contains("game"));
    }

    /* JADX INFO: renamed from: a */
    public static void m4499a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @NotNull C0872pk c0872pk, boolean z) {
        c0872pk.m4296a(abstractC0863pb).m6183a(true, pair -> {
            return m4502a((Pair<C0837pB, C1093ts>) pair) && ((C1093ts) pair.getRight()).m6014a((AbstractC0863pb<?, ?, ?>) abstractC0863pb);
        }).ifPresent(pair2 -> {
            m4500a((AbstractC0863pb<?, ?, ?>) abstractC0863pb, serverLevel, c0872pk, (Pair<C0837pB, C1093ts>) pair2, z);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m4500a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @NotNull C0872pk c0872pk, @NotNull Pair<C0837pB, C1093ts> pair, boolean z) {
        m4501a(abstractC0863pb, serverLevel, c0872pk, pair, z, 16.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m4501a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @NotNull C0872pk c0872pk, @NotNull Pair<C0837pB, C1093ts> pair, boolean z, float f) {
        C0837pB c0837pB = (C0837pB) pair.getLeft();
        C1093ts c1093ts = (C1093ts) pair.getRight();
        C0881pt c0881ptM4299a = c0872pk.m4299a(abstractC0863pb);
        serverLevel.getChunkAt(c0881ptM4299a.m4587c());
        C0756na c0756naCreate = ((EntityType) C1307xu.f7600kF.get()).create(serverLevel);
        if (c0756naCreate == null) {
            return;
        }
        C1098tx c1098txM4296a = c0872pk.m4296a(abstractC0863pb);
        ItemStack itemStackCopy = c0837pB.m3824e().copy();
        if (itemStackCopy.isEmpty()) {
            itemStackCopy = c0837pB.m3825f().copy();
        }
        itemStackCopy.set(C1305xs.f7545Z.get(), true);
        float f2 = c0881ptM4299a.f4826h.x;
        c0756naCreate.moveTo(c0881ptM4299a.f4827c.x, c0881ptM4299a.f4827c.y, c0881ptM4299a.f4827c.z, f2, c0881ptM4299a.f4826h.y);
        c0756naCreate.setYHeadRot(f2);
        c0756naCreate.setYBodyRot(f2);
        c0756naCreate.mo3117e(abstractC0863pb);
        c0756naCreate.m3555a(abstractC0863pb, c0872pk);
        c0756naCreate.m3561s(c0872pk.getName());
        c0756naCreate.m3567r(c1098txM4296a.m6175a().ordinal());
        c0756naCreate.m3563t(c1098txM4296a.m6179a().m6159aw());
        c0756naCreate.m3559d(itemStackCopy);
        c0756naCreate.m3580a(c1093ts);
        c0756naCreate.m3577F(z);
        AttributeInstance attribute = c0756naCreate.getAttribute(Attributes.MAX_HEALTH);
        if (attribute != null) {
            attribute.setBaseValue(f);
        }
        c0756naCreate.setHealth(f);
        serverLevel.addFreshEntity(c0756naCreate);
        if (abstractC0863pb instanceof InterfaceC0976ri) {
            ((InterfaceC0976ri) abstractC0863pb).mo5333a(c0756naCreate, (Level) serverLevel);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4502a(@NotNull Pair<C0837pB, C1093ts> pair) {
        C0837pB c0837pB = (C0837pB) pair.getLeft();
        ItemStack itemStackM3824e = c0837pB.m3824e();
        if (itemStackM3824e != null) {
            Item item = itemStackM3824e.getItem();
            if ((item instanceof C1117uP) && ((C1117uP) item).m6316a().m6878cx() > 1) {
                return false;
            }
        }
        ItemStack itemStackM3825f = c0837pB.m3825f();
        if (itemStackM3825f == null) {
            return true;
        }
        Item item2 = itemStackM3825f.getItem();
        return !(item2 instanceof C1117uP) || ((C1117uP) item2).m6316a().m6878cx() <= 1;
    }
}
