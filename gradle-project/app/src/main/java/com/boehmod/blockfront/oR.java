package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.util.ModLibraryMathHelper;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oR.class */
public final class oR {

    @NotNull
    public static final String bK = "matchId";

    @NotNull
    public static final String bL = "disableMount";

    @NotNull
    public static final String bM = "envVersion";
    private static final int ni = 4;

    @NotNull
    public static final String bN = "[Team]";

    @NotNull
    public static final Component iM = Component.literal(String.valueOf((char) 57363)).withColor(ColorReferences.COLOR_WHITE).append(" ");

    @NotNull
    public static final Component iN = Component.translatable("bf.message.admin").withColor(ColorReferences.COLOR_WHITE).append(" ");

    @NotNull
    public static final Component iO = Component.translatable("bf.message.dead").withStyle(ChatFormatting.DARK_RED);

    @NotNull
    public static final Component iP = Component.translatable("bf.message.team").withStyle(ChatFormatting.GRAY);

    @NotNull
    public static final Component iQ = Component.translatable("bf.message.spectator").withStyle(ChatFormatting.GRAY);

    @NotNull
    private static final AttributeSupplier a = Player.createAttributes().build();

    @NotNull
    private static final List<Holder<Attribute>> aw = List.of(Attributes.MAX_HEALTH, Attributes.MOVEMENT_SPEED, Attributes.ATTACK_DAMAGE, Attributes.ATTACK_SPEED, Attributes.ARMOR, Attributes.ARMOR_TOUGHNESS, Attributes.KNOCKBACK_RESISTANCE, Attributes.SCALE, NeoForgeMod.CREATIVE_FLIGHT);

    @NotNull
    private static final MutableComponent s = Component.translatable("bf.cloud.notification.discord.reminder.hover");

    @NotNull
    private static final MutableComponent t = Component.translatable("bf.message.match.discord.vc").withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, s)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, C0261jr.aB))).withColor(ColorReferences.COLOR_THEME_DISCORD);

    public static boolean a(@NotNull BlockAndTintGetter blockAndTintGetter, @NotNull BlockPos blockPos) {
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

    public static boolean a(@NotNull Level level, int i, int i2, int i3) {
        return level.getHeight(Heightmap.Types.MOTION_BLOCKING, i, i2) > i3;
    }

    public static void c(@NotNull Level level, @NotNull Vec3 vec3) {
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

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull C0332mh c0332mh, @Nullable C0337mm c0337mm, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA != null) {
                a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, c0332mh, c0337mm, serverPlayerA);
            }
        });
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull C0332mh c0332mh, @Nullable C0337mm c0337mm, @NotNull UUID uuid) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            a(abstractC0264ju, c0332mh, c0337mm, serverPlayerA);
        }
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull C0332mh c0332mh, @Nullable C0337mm c0337mm, @NotNull ServerPlayer serverPlayer) {
        com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264ju.m531a();
        com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a((Player) serverPlayer);
        if (bVarM305a instanceof xO) {
            xL xLVarA = ((xO) bVarM305a).a();
            xLVarA.d(serverPlayer, cVarM531a);
            xLVarA.c(c0332mh);
            xLVarA.b(serverPlayer, cVarM531a);
        }
        C0582vo.a(new vQ(c0332mh, Optional.ofNullable(c0337mm)), serverPlayer);
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar, @NotNull ServerPlayer serverPlayer) {
        oX oXVarC = oIVar.c();
        if (oXVarC == null) {
            return;
        }
        for (C0371nt c0371nt : serverLevel.getEntitiesOfClass(C0371nt.class, new AABB(oXVarC.c()).inflate(oFVar.aV()))) {
            if (serverPlayer.equals(c0371nt.a())) {
                c0371nt.discard();
            }
        }
    }

    public static void a(@Nullable ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar) {
        oX oXVarC;
        if (serverLevel == null || (oXVarC = oIVar.c()) == null) {
            return;
        }
        for (Entity entity : serverLevel.getEntitiesOfClass(Entity.class, new AABB(oXVarC.c()).inflate(oFVar.aV()), entity2 -> {
            return (entity2 instanceof ItemEntity) || (entity2 instanceof mA) || (entity2 instanceof mC) || (entity2 instanceof mE) || (entity2 instanceof mQ) || (entity2 instanceof mY) || (entity2 instanceof Horse) || (entity2 instanceof mW) || (entity2 instanceof mB) || (entity2 instanceof AbstractC0376ny);
        })) {
            if (entity instanceof AbstractC0376ny) {
                ((AbstractC0376ny) entity).ejectPassengers();
            }
            entity.discard();
        }
    }

    public static void d(@NotNull Set<UUID> set) {
        set.forEach(oR::i);
    }

    public static void i(@NotNull UUID uuid) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA == null) {
            return;
        }
        serverPlayerA.getInventory().clearContent();
        serverPlayerA.containerMenu.broadcastChanges();
    }

    public static void a(@NotNull Set<UUID> set, @NotNull hU hUVar) {
        set.forEach(uuid -> {
            a(uuid, hUVar);
        });
    }

    public static void a(@NotNull UUID uuid, @NotNull hU hUVar) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA == null) {
            return;
        }
        C0582vo.a(new vH(hUVar), serverPlayerA);
    }

    public static void a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        a(uuid, soundEvent, soundSource, 1.0f, 1.0f);
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        a(serverPlayer, soundEvent, soundSource, 1.0f, 1.0f);
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        C0582vo.a(new vU(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent), soundSource, f, f2), serverPlayer);
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f) {
        a(serverPlayer, soundEvent, soundSource, f, 1.0f);
    }

    public static void a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f) {
        a(uuid, soundEvent, soundSource, f, 1.0f);
    }

    public static void a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            a(serverPlayerA, soundEvent, soundSource, f, f2);
        }
    }

    public static void a(@NotNull Set<UUID> set, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        set.forEach(uuid -> {
            a(uuid, soundEvent, soundSource);
        });
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource) {
        a(oFVar.b().j(), soundEvent, soundSource);
    }

    public static void a(@NotNull Set<UUID> set, SoundEvent soundEvent, SoundSource soundSource, float f) {
        a(set, soundEvent, soundSource, f, 1.0f);
    }

    public static void a(@NotNull Set<UUID> set, SoundEvent soundEvent, SoundSource soundSource, float f, float f2) {
        set.forEach(uuid -> {
            a(uuid, soundEvent, soundSource, f, f2);
        });
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        C0582vo.a(new vV(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent), soundSource, f, vec3), serverPlayer);
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        a(oFVar.b().j(), soundEvent, soundSource, f, vec3);
    }

    public static void a(@NotNull Set<UUID> set, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        set.forEach(uuid -> {
            a(uuid, soundEvent, soundSource, f, vec3);
        });
    }

    public static void a(@NotNull UUID uuid, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, @NotNull Vec3 vec3) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA == null) {
            return;
        }
        a(serverPlayerA, soundEvent, soundSource, f, vec3);
    }

    public static void a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        level.playSound((Player) null, vec3.x, vec3.y, vec3.z, soundEvent, soundSource, f, f2);
    }

    public static void a(@NotNull Level level, double d, double d2, double d3, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        level.playSound((Player) null, d, d2, d3, soundEvent, soundSource, f, f2);
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull sQ sQVar) {
        C0582vo.a(new vF(sQVar), serverPlayer);
    }

    public static void a(@NotNull UUID uuid, @NotNull sQ sQVar) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            a(serverPlayerA, sQVar);
        }
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull sR sRVar) {
        C0582vo.a(new C0612wr(sRVar), serverPlayer);
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull C0421pp c0421pp) {
        C0611wq c0611wq = new C0611wq(c0421pp);
        Iterator<UUID> it = oIVar.h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = a(it.next());
            if (serverPlayerA != null) {
                C0582vo.a(c0611wq, serverPlayerA);
            }
        }
        Iterator<UUID> it2 = oIVar.i().iterator();
        while (it2.hasNext()) {
            ServerPlayer serverPlayerA2 = a(it2.next());
            if (serverPlayerA2 != null) {
                C0582vo.a(c0611wq, serverPlayerA2);
            }
        }
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA != null) {
                a((com.boehmod.blockfront.common.player.c<?>) cVar, serverLevel, serverPlayerA);
            }
        });
    }

    public static void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        if (serverLevel.isClientSide()) {
            return;
        }
        serverPlayer.removeAllEffects();
        serverPlayer.resetFallDistance();
        serverPlayer.clearFire();
        serverPlayer.setInvisible(false);
        e(serverPlayer);
        serverPlayer.setHealth(serverPlayer.getMaxHealth());
        Abilities abilities = serverPlayer.getAbilities();
        abilities.mayfly = false;
        abilities.flying = false;
        serverPlayer.onUpdateAbilities();
        serverPlayer.setGameMode(GameType.ADVENTURE);
        com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
        bVarM305a.X(false);
        bVarM305a.I(0);
        bVarM305a.b().W(false);
    }

    private static void e(@NotNull ServerPlayer serverPlayer) {
        for (Holder<Attribute> holder : aw) {
            AttributeInstance attribute = serverPlayer.getAttribute(holder);
            if (attribute != null) {
                attribute.setBaseValue(a.getBaseValue(holder));
            }
        }
    }

    public static SortedSet<UUID> a(@NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set, @NotNull C0528to c0528to) {
        return a(oFVar, set, c0528to.getKey());
    }

    public static SortedSet<UUID> a(@NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set, @NotNull String str) {
        if (set.size() <= 1) {
            return new ObjectLinkedOpenHashSet(set);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        objectArrayList.sort((uuid, uuid2) -> {
            return Integer.compare(oFVar.a(uuid2).a(str), oFVar.a(uuid).a(str));
        });
        return new ObjectLinkedOpenHashSet(objectArrayList);
    }

    @NotNull
    public static ObjectSortedSet<UUID> a(@NotNull oF<?, ?, ?> oFVar, int i, @NotNull C0528to c0528to, @NotNull Set<UUID> set) {
        return a(oFVar, i, c0528to.getKey(), set);
    }

    @NotNull
    public static ObjectSortedSet<UUID> a(@NotNull oF<?, ?, ?> oFVar, int i, @NotNull String str, @NotNull Set<UUID> set) {
        if (set.isEmpty() || i <= 0) {
            return new ObjectLinkedOpenHashSet();
        }
        SortedSet<UUID> sortedSetA = a(oFVar, set, str);
        ObjectLinkedOpenHashSet objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
        int i2 = 0;
        for (UUID uuid : sortedSetA) {
            if (i2 >= i) {
                break;
            }
            objectLinkedOpenHashSet.add(uuid);
            i2++;
        }
        return objectLinkedOpenHashSet;
    }

    @NotNull
    public static ObjectSortedSet<UUID> a(@NotNull oF<?, ?, ?> oFVar, int i, @NotNull C0528to c0528to, @NotNull oO oOVar) {
        return a(oFVar, i, c0528to, oOVar.h());
    }

    @NotNull
    public static Set<UUID> a(@NotNull Set<UUID> set, int i) {
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

    public static void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA != null) {
                a((com.boehmod.blockfront.common.player.c<?>) cVar, serverPlayerA);
            }
        });
    }

    public static void b(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA != null) {
                b((com.boehmod.blockfront.common.player.c<?>) cVar, serverPlayerA);
            }
        });
    }

    public static void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerPlayer serverPlayer) {
        cVar.m305a((Player) serverPlayer).Z(true);
    }

    public static void b(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerPlayer serverPlayer) {
        com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
        if (bVarM305a.dm() || bVarM305a.l() != null) {
            bVarM305a.Z(false);
            bVarM305a.e((oX) null);
        }
    }

    public static void a(@NotNull Set<UUID> set, @NotNull Component component) {
        set.forEach(uuid -> {
            a(uuid, component);
        });
    }

    public static void a(@NotNull UUID uuid, @NotNull Component component) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            b(serverPlayerA, component);
        }
    }

    public static void b(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        serverPlayer.connection.disconnect(component);
    }

    @Nullable
    public static ServerPlayer a(@NotNull UUID uuid) {
        MinecraftServer minecraftServerA;
        if (C0262js.ac() && (minecraftServerA = C0262js.a()) != null) {
            return minecraftServerA.getPlayerList().getPlayer(uuid);
        }
        return null;
    }

    public static void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull UUID uuid, @NotNull List<oX> list) {
        a(cVar, uuid, (oX) C0631xj.a(list));
    }

    public static void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull UUID uuid, @NotNull oX oXVar) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            a(cVar, serverPlayerA, oXVar);
            serverPlayerA.containerMenu.sendAllDataToRemote();
        }
    }

    public static void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerPlayer serverPlayer, @NotNull oX oXVar) {
        serverPlayer.teleportTo(serverPlayer.serverLevel(), oXVar.c.x, oXVar.c.y, oXVar.c.z, oXVar.h.x, oXVar.h.y);
        com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
        if (bVarM305a.dm()) {
            bVarM305a.e(oXVar);
        }
    }

    public static void a(@NotNull ChatGraphic chatGraphic, @NotNull Set<UUID> set, @NotNull Component component) {
        set.forEach(uuid -> {
            a(chatGraphic, uuid, component);
        });
    }

    public static void a(@NotNull ChatGraphic chatGraphic, @NotNull UUID uuid, @NotNull Component component) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            a(chatGraphic, serverPlayerA, component);
        }
    }

    public static void a(@NotNull ChatGraphic chatGraphic, @NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        C0582vo.a(new C0569vb(chatGraphic, component), serverPlayer);
    }

    public static void c(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        a(serverPlayer, C0529tp.jz, component);
    }

    public static void b(@NotNull UUID uuid, @NotNull Component component) {
        a(uuid, C0529tp.jz, component);
    }

    public static void a(@NotNull UUID uuid, @NotNull Component component, @NotNull Component component2) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA == null) {
            return;
        }
        a(serverPlayerA, component, component2);
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull Component component, @NotNull Component component2) {
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

    public static void a(@NotNull ServerLevel serverLevel, @NotNull xw xwVar, @NotNull Component component) {
        if (C0262js.ac()) {
            xQ xQVar = (xQ) xwVar.a();
            serverLevel.getServer().getPlayerList().getPlayers().stream().filter(serverPlayer -> {
                return xQVar.a((Player) serverPlayer).j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN);
            }).forEach(serverPlayer2 -> {
                c(serverPlayer2, component);
            });
        }
    }

    public static void e(@NotNull Set<UUID> set) {
        b(set, (Component) Component.empty());
    }

    public static void b(@NotNull Set<UUID> set, @NotNull Component component) {
        a(set, C0529tp.jz, component);
    }

    public static void a(@NotNull Set<UUID> set, @NotNull String str) {
        a(set, C0529tp.jz, (Component) Component.literal(str));
    }

    public static void a(@NotNull Set<UUID> set, @NotNull Component component, @NotNull String str) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA == null) {
                return;
            }
            a(serverPlayerA, component, (Component) Component.literal(str));
        });
    }

    public static void a(@NotNull Set<UUID> set, @NotNull Component component, @NotNull Component component2) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA == null) {
                return;
            }
            a(serverPlayerA, component, component2);
        });
    }

    public static void f(@NotNull oF<?, ?, ?> oFVar) {
        e(oFVar.b().j());
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull Component component) {
        b(oFVar.b().j(), component);
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull String str) {
        a(oFVar.b().j(), str);
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull Component component, @NotNull Component component2) {
        a(oFVar.b().j(), component, component2);
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull Component component, @NotNull String str) {
        a(oFVar.b().j(), component, str);
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull Component component, @NotNull Component component2) {
        a(oIVar, oOVar, oT.ALL, component, component2);
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull Component component) {
        oIVar.a(oOVar, oT.ALL).forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA == null) {
                return;
            }
            c(serverPlayerA, component);
        });
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull oT oTVar, @NotNull Component component, @NotNull Component component2) {
        oIVar.a(oOVar, oTVar).forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA == null) {
                return;
            }
            a(serverPlayerA, component, component2);
        });
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0118ei enumC0118ei) {
        a(oIVar, oOVar, oT.ALL, component, component2, enumC0118ei);
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull oT oTVar, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0118ei enumC0118ei) {
        oIVar.a(oOVar, oTVar).forEach(uuid -> {
            a(uuid, component, component2, enumC0118ei);
        });
    }

    public static void a(@NotNull UUID uuid, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0118ei enumC0118ei) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            C0582vo.a(new C0573vf(component, component2, enumC0118ei), serverPlayerA);
        }
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull Component component, int i, @Nullable String str) {
        a(oIVar, oOVar, oT.ALL, component, i, str);
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull oT oTVar, @NotNull Component component, int i, @Nullable String str) {
        oIVar.a(oOVar, oTVar).forEach(uuid -> {
            a(uuid, component, i, str);
        });
    }

    public static void a(@NotNull oI<?> oIVar, @NotNull oO oOVar, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        oIVar.a(oOVar, oT.ALL).forEach(uuid -> {
            a(uuid, component, i, str, vec3, i2, i3);
        });
    }

    public static void a(@NotNull Set<UUID> set, @NotNull Component component, int i) {
        a(set, component, i, (String) null);
    }

    public static void a(@NotNull Set<UUID> set, @NotNull Component component, int i, @Nullable String str) {
        set.forEach(uuid -> {
            a(uuid, component, i, str);
        });
    }

    public static void a(@NotNull Set<UUID> set, @NotNull List<Component> list, int i) {
        a(set, list, i, (String) null);
    }

    public static void a(@NotNull Set<UUID> set, @NotNull List<Component> list, int i, @Nullable String str) {
        set.forEach(uuid -> {
            a(uuid, (List<Component>) list, i, str);
        });
    }

    public static void a(@NotNull Set<UUID> set, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        set.forEach(uuid -> {
            a(uuid, component, i, str, vec3, i2, i3);
        });
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull Component component, int i) {
        a(oFVar, component, i, (String) null);
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull Component component, int i, @Nullable String str) {
        a(oFVar.b().j(), component, i, str);
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull List<Component> list, int i, @Nullable String str) {
        a(oFVar.b().j(), list, i, str);
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        a(oFVar.b().j(), component, i, str, vec3, i2, i3);
    }

    public static void a(@NotNull UUID uuid, @NotNull Component component, int i) {
        a(uuid, component, i, (String) null);
    }

    public static void a(@NotNull UUID uuid, @NotNull Component component, int i, @Nullable String str) {
        a(uuid, (List<Component>) List.of(component), i, str);
    }

    public static void a(@NotNull UUID uuid, @NotNull List<Component> list, int i) {
        a(uuid, list, i, (String) null);
    }

    public static void a(@NotNull UUID uuid, @NotNull List<Component> list, int i, @Nullable String str) {
        a(uuid, list, i, str, (Vec3) null, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
    }

    public static void a(@NotNull UUID uuid, @NotNull Component component, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        a(uuid, (List<Component>) List.of(component), i, str, vec3, i2, i3);
    }

    public static void a(@NotNull UUID uuid, @NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null) {
            C0582vo.a(new C0591vx(list, i, str, vec3, i2, i3), serverPlayerA);
        }
    }

    public static int a(@NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to) {
        return oFVar.a(uuid).a(c0528to.getKey());
    }

    public static int a(@NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to, int i) {
        return oFVar.a(uuid).a(c0528to.getKey(), i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m792a(@NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to, int i) {
        oFVar.a(uuid).m787a(c0528to.getKey(), i);
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set, @NotNull C0528to c0528to) {
        a(abstractC0264ju, oFVar, set, c0528to, 1);
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set, @NotNull C0528to c0528to, int i) {
        set.forEach(uuid -> {
            a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, (oF<?, ?, ?>) oFVar, uuid, c0528to, i);
        });
    }

    public static void a(AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to) {
        a(abstractC0264ju, oFVar, uuid, c0528to, 1);
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to, int i) {
        a(abstractC0264ju, oFVar, uuid, c0528to, i, (ItemStack) null);
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to, int i, @Nullable ItemStack itemStack) {
        a(abstractC0264ju, oFVar, uuid, c0528to, i, itemStack, -1);
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to, int i, @Nullable ItemStack itemStack, int i2) {
        int iA = a(oFVar, uuid, c0528to);
        m792a(oFVar, uuid, c0528to, iA + i);
        if (c0528to instanceof C0527tn) {
            ((C0527tn) c0528to).a(uuid, i);
        }
        if (abstractC0264ju.g() && c0528to.cf()) {
            c0528to.a(abstractC0264ju, oFVar, uuid, i, iA + i, itemStack, i2);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m793a(@NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to) {
        b(oFVar, uuid, c0528to, 1);
    }

    public static void b(@NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull C0528to c0528to, int i) {
        m792a(oFVar, uuid, c0528to, a(oFVar, uuid, c0528to) - i);
    }

    public static void f(@NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            ServerPlayer serverPlayerA = a(uuid);
            if (serverPlayerA != null) {
                C0582vo.a(new C0572ve(), serverPlayerA);
            }
        });
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0411pf c0411pf) {
        a(serverLevel, serverPlayer, c0411pf, false);
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0411pf c0411pf, boolean z) {
        EquipmentSlot equipmentSlot;
        if (serverLevel.isClientSide()) {
            return;
        }
        Inventory inventory = serverPlayer.getInventory();
        if (!z) {
            inventory.clearContent();
        }
        int i = 3;
        ItemStack itemStackC = c0411pf.c();
        if (itemStackC != null && !itemStackC.isEmpty()) {
            inventory.setItem(0, itemStackC.copy());
        }
        ItemStack itemStackD = c0411pf.d();
        if (itemStackD != null && !itemStackD.isEmpty()) {
            inventory.setItem(1, itemStackD.copy());
        }
        ItemStack itemStackE = c0411pf.e();
        if (itemStackE != null && !itemStackE.isEmpty()) {
            inventory.setItem(2, itemStackE.copy());
        }
        ItemStack itemStackF = c0411pf.f();
        if (itemStackF != null && !itemStackF.isEmpty()) {
            serverPlayer.setItemInHand(InteractionHand.OFF_HAND, itemStackF.copy());
        }
        ItemStack itemStackH = c0411pf.h();
        if (itemStackH != null && !itemStackH.isEmpty()) {
            serverPlayer.setItemSlot(serverPlayer.getEquipmentSlotForItem(itemStackH), itemStackH);
        }
        for (ItemStack itemStack : c0411pf.F()) {
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
        for (ItemStack itemStack2 : c0411pf.G()) {
            ItemStack itemStackCopy = itemStack2.copy();
            ArmorItem item = itemStack2.getItem();
            if ((item instanceof ArmorItem) && (equipmentSlot = item.getEquipmentSlot(itemStackCopy)) != null) {
                serverPlayer.setItemSlot(equipmentSlot, itemStack2.copy());
            }
        }
        serverPlayer.containerMenu.broadcastChanges();
    }

    public static void a(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull C0411pf c0411pf) {
        EquipmentSlot equipmentSlot;
        if (level.isClientSide()) {
            return;
        }
        if (c0411pf.c() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0411pf.c());
        }
        if (c0411pf.d() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0411pf.d());
        }
        if (c0411pf.e() != null) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, c0411pf.e());
        }
        if (c0411pf.f() != null) {
            livingEntity.setItemInHand(InteractionHand.OFF_HAND, c0411pf.f());
        }
        Iterator<ItemStack> it = c0411pf.G().iterator();
        while (it.hasNext()) {
            ItemStack itemStackCopy = it.next().copy();
            ArmorItem item = itemStackCopy.getItem();
            if ((item instanceof ArmorItem) && (equipmentSlot = item.getEquipmentSlot(itemStackCopy)) != null) {
                switch (AnonymousClass1.q[equipmentSlot.ordinal()]) {
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

    /* JADX INFO: renamed from: com.boehmod.blockfront.oR$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oR$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] q = new int[EquipmentSlot.values().length];

        static {
            try {
                q[EquipmentSlot.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                q[EquipmentSlot.CHEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                q[EquipmentSlot.LEGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                q[EquipmentSlot.FEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
        long time = (Calendar.getInstance().getTime().getTime() - bVarM305a.i()) / 1000;
        if (oFVar.bd() && time <= 5 && oFVar.m750a() == oN.GAME && bVarM305a.i() != 0) {
            b(set, (Component) Component.translatable("bf.message.gamemode.ragequit", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
            a(abstractC0264ju, uuid, CloudAchievements.ACH_USER_RAGEQUIT);
        }
        bVarM305a.d(0L);
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull UUID uuid, @NotNull CloudAchievement cloudAchievement) {
        abstractC0264ju.m529b().sendPacket(new PacketPlayerDataIncreaseValue(uuid, "achievement", cloudAchievement.getId()));
    }

    public static void f(@NotNull ServerPlayer serverPlayer) {
        Inventory inventory = serverPlayer.getInventory();
        int size = inventory.items.size();
        for (int i = 0; i < size; i++) {
            ItemStack itemStack = (ItemStack) inventory.items.get(i);
            if (!itemStack.isEmpty() && (itemStack.getItem() instanceof C0558ur)) {
                C0558ur.f(itemStack);
                serverPlayer.containerMenu.sendAllDataToRemote();
            }
        }
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        set.forEach(uuid -> {
            a(serverLevel, (oF<?, ?, ?>) oFVar, uuid);
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid) {
        oO oOVarA = oFVar.b().a(uuid);
        oM oMVarA = oFVar.a(uuid);
        int iA = oMVarA.a(C0529tp.i.getKey(), -1);
        int iA2 = oMVarA.a(C0529tp.j.getKey(), -1);
        ServerPlayer serverPlayerA = a(uuid);
        if (serverPlayerA != null && oOVarA != null && iA != -1 && iA2 != -1) {
            a(serverLevel, serverPlayerA, a(oFVar, oOVarA, sV.a(iA), iA2));
        }
    }

    public static C0411pf a(@NotNull oF<?, ?, ?> oFVar, @NotNull oO oOVar, @NotNull sV sVVar, int i) {
        return oOVar.a(oFVar).a(sVVar, i);
    }

    public static int a(@NotNull oF<?, ?, ?> oFVar, @NotNull sV sVVar, @NotNull oO oOVar) {
        int i = 0;
        String key = C0529tp.i.getKey();
        int iBN = sVVar.bN();
        Iterator<UUID> it = oOVar.h().iterator();
        while (it.hasNext()) {
            if (oFVar.a(it.next()).a(key) == iBN) {
                i++;
            }
        }
        return i;
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        a(cVar, serverLevel, serverPlayer);
        abstractC0264ju.a(abstractC0264ju, cVar, serverLevel, serverPlayer, uuid);
    }

    public static boolean b(@NotNull ItemStack itemStack) {
        int iCc;
        Item item = itemStack.getItem();
        if (!(item instanceof C0558ur)) {
            return false;
        }
        C0558ur c0558ur = (C0558ur) item;
        if (c0558ur.ct() && C0558ur.m1200b(itemStack) != (iCc = c0558ur.m1206a(itemStack).cc())) {
            C0558ur.c(itemStack, iCc);
            return true;
        }
        return false;
    }

    public static boolean h(@NotNull Player player) {
        for (ItemStack itemStack : player.getInventory().items.subList(0, 9)) {
            if (itemStack == null || !itemStack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static int a(@NotNull Inventory inventory, int i, int i2) {
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

    public static boolean c(@NotNull ServerPlayer serverPlayer) {
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (!itemStack.isEmpty()) {
                Item item = itemStack.getItem();
                if (item instanceof C0558ur) {
                    C0559us c0559usM1206a = ((C0558ur) item).m1206a(itemStack);
                    int iCb = c0559usM1206a.cb();
                    if (C0558ur.m1200b(itemStack) != c0559usM1206a.cc() || C0558ur.a(itemStack) != iCb) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public static boolean a(@NotNull ServerPlayer serverPlayer, @NotNull C0411pf c0411pf) {
        List<ItemStack> listF = c0411pf.F();
        if (listF.isEmpty()) {
            return false;
        }
        HashMap map = new HashMap();
        for (ItemStack itemStack : listF) {
            if (!itemStack.isEmpty()) {
                map.merge(itemStack.getItem(), Integer.valueOf(itemStack.getCount()), (v0, v1) -> {
                    return Integer.sum(v0, v1);
                });
            }
        }
        HashMap map2 = new HashMap();
        for (ItemStack itemStack2 : serverPlayer.getInventory().items) {
            if (!itemStack2.isEmpty() && (itemStack2.getItem() instanceof tW)) {
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

    public static boolean a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull oO oOVar) {
        Iterator<UUID> it = oOVar.h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = a(it.next());
            if (serverPlayerA != null && !a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) cVar.m305a((Player) serverPlayerA))) {
                return false;
            }
        }
        return true;
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull oO oOVar) {
        oM oMVarA = oFVar.a(serverPlayer.getUUID());
        int iA = oMVarA.a(C0529tp.i.getKey(), -1);
        int iA2 = oMVarA.a(C0529tp.j.getKey(), -1);
        if (iA != -1 && iA2 != -1) {
            sV sVVarA = sV.a(iA);
            oMVarA.m787a(C0529tp.k.getKey(), iA);
            a(serverLevel, serverPlayer, a(oFVar, oOVar, sVVarA, iA2));
        }
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull oO oOVar) {
        Iterator<UUID> it = oOVar.h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = a(it.next());
            if (serverPlayerA != null) {
                a(serverLevel, serverPlayerA, oFVar, oOVar);
            }
        }
    }

    public static boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull UUID uuid, @NotNull UUID uuid2) {
        oF<?, ?, ?> oFVarMo604a = abstractC0264ju.mo604a(uuid);
        if (oFVarMo604a == null) {
            return false;
        }
        oI oIVarB = oFVarMo604a.b();
        oO oOVarA = oIVarB.a(uuid);
        return oOVarA != null && oOVarA.equals(oIVarB.a(uuid2));
    }

    public static boolean a(@NotNull oI<?> oIVar, @NotNull UUID uuid, @NotNull UUID uuid2) {
        oO oOVarA = oIVar.a(uuid);
        return oOVarA != null && oOVarA.equals(oIVar.a(uuid2));
    }

    public static BlockPos a(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos) {
        BlockPos heightmapPos = serverLevel.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos);
        if (heightmapPos.getY() == serverLevel.getMinBuildHeight() - 1) {
            heightmapPos = heightmapPos.above(2);
        }
        return heightmapPos;
    }

    public static void a(@NotNull LivingEntity livingEntity, @NotNull ParticleOptions particleOptions, @NotNull RandomSource randomSource, float f, float f2, float f3, int i) {
        ServerLevel serverLevelLevel = livingEntity.level();
        if (serverLevelLevel instanceof ServerLevel) {
            ServerLevel serverLevel = serverLevelLevel;
            for (int i2 = 0; i2 < i; i2++) {
                serverLevel.sendParticles(particleOptions, livingEntity.getRandomX(1.0d) + ((double) f), livingEntity.getRandomY() + ((double) f2), livingEntity.getRandomZ(1.0d) + ((double) f3), 1, randomSource.nextGaussian() * 0.02d, randomSource.nextGaussian() * 0.02d, randomSource.nextGaussian() * 0.02d, 1.0d);
            }
        }
    }

    public static void a(@NotNull Level level, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, double d, double d2, int i, float f) {
        for (int i2 = 0; i2 < i; i2++) {
            double dPow = d + ((d2 - d) * Math.pow(level.random.nextDouble(), 2.0d));
            double d3 = (6.283185307179586d / ((double) i)) * ((double) i2);
            double dCos = Math.cos(d3);
            double dSin = Math.sin(d3);
            level.addParticle(particleOptions, true, vec3.x + (dPow * dCos), vec3.y, vec3.z + (dPow * dSin), ((double) f) * dCos, 0.0d, ((double) f) * dSin);
        }
    }

    public static void a(@NotNull Level level, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
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

    public static boolean a(@NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, float f) {
        float fAbs = Math.abs(((livingEntity.getYHeadRot() + 360.0f) % 360.0f) - ((livingEntity2.getYHeadRot() + 360.0f) % 360.0f));
        return ((fAbs > 180.0f ? 1 : (fAbs == 180.0f ? 0 : -1)) > 0 ? 360.0f - fAbs : fAbs) <= f;
    }

    public static boolean b(@NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, float f) {
        Vec3 eyePosition = livingEntity2.getEyePosition();
        Vec3 eyePosition2 = livingEntity.getEyePosition();
        float yHeadRot = livingEntity.getYHeadRot();
        float xRot = livingEntity.getXRot();
        return Math.acos(new Vec3((double) ((-Mth.sin(yHeadRot * 0.017453292f)) * Mth.cos(xRot * 0.017453292f)), (double) (-Mth.sin(xRot * 0.017453292f)), (double) (Mth.cos(yHeadRot * 0.017453292f) * Mth.cos(xRot * 0.017453292f))).dot(eyePosition.subtract(eyePosition2).normalize())) <= Math.toRadians((double) (f / 2.0f));
    }

    public static float a(@NotNull Entity entity, @NotNull Camera camera) {
        return a(entity, camera.getPosition());
    }

    public static float a(@NotNull Entity entity, @NotNull Entity entity2) {
        return a(entity, entity2.getEyePosition());
    }

    public static float a(@NotNull Entity entity, @NotNull Vec3 vec3) {
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

    public static boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        if (!livingEntity2.isAlive() || livingEntity2.getHealth() <= 0.0f || livingEntity2.tickCount <= 20) {
            return false;
        }
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (livingEntity2 instanceof ServerPlayer) {
                oF<?, ?, ?> oFVarMo604a = abstractC0264ju.mo604a(serverPlayer.getUUID());
                oF<?, ?, ?> oFVarMo604a2 = abstractC0264ju.mo604a(((ServerPlayer) livingEntity2).getUUID());
                if (oFVarMo604a != null && oFVarMo604a2 != null && !oFVarMo604a.equals(oFVarMo604a2)) {
                    return false;
                }
            }
        }
        Entity vehicle = livingEntity2.getVehicle();
        if ((vehicle instanceof AbstractC0376ny) && ((AbstractC0376ny) vehicle).k((Entity) livingEntity2)) {
            return false;
        }
        if (livingEntity2 instanceof Player) {
            Entity entity = (Player) livingEntity2;
            if (cVar.m305a((Player) entity).dk() || entity.isSpectator()) {
                return false;
            }
            oF<?, ?, ?> oFVarMo604a3 = abstractC0264ju.mo604a(entity.getUUID());
            if (oFVarMo604a3 != null && oFVarMo604a3.b().g(entity.getUUID())) {
                return false;
            }
            Entity vehicle2 = entity.getVehicle();
            if ((vehicle2 instanceof AbstractC0376ny) && ((AbstractC0376ny) vehicle2).k(entity)) {
                return false;
            }
        }
        if (livingEntity instanceof mE) {
            return ((mE) livingEntity).canAttack(livingEntity2);
        }
        return (livingEntity2.isSpectator() || livingEntity2.equals(livingEntity)) ? false : true;
    }

    public static boolean a(@NotNull Player player, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        return bVar.dk() || !player.isAlive() || player.isSpectator() || player.isDeadOrDying();
    }

    public static boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @Nullable LivingEntity livingEntity, @NotNull UUID uuid) {
        oF<?, ?, ?> oFVarMo604a;
        return (livingEntity == null || (oFVarMo604a = abstractC0264ju.mo604a(livingEntity.getUUID())) == null || !oFVarMo604a.b().g(uuid)) ? false : true;
    }

    public static Explosion a(@NotNull Level level, @Nullable Entity entity, @NotNull Vec3 vec3, @NotNull ItemStack itemStack, float f) {
        return new Explosion(level, entity, new C0325ma(level, entity instanceof mA ? ((mA) entity).a() : entity, itemStack, vec3), (ExplosionDamageCalculator) null, vec3.x, vec3.y, vec3.z, f, false, Explosion.BlockInteraction.KEEP, ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, SoundEvents.GENERIC_EXPLODE);
    }

    @Nullable
    public static <T extends Entity> T a(@NotNull Level level, @NotNull Entity entity, @NotNull Class<T> cls, float f) {
        List entitiesOfClass = level.getEntitiesOfClass(cls, entity.getBoundingBox().inflate(f));
        if (!entitiesOfClass.isEmpty()) {
            return (T) entitiesOfClass.getFirst();
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Set<UUID> m794a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Set<UUID> set) {
        Object2FloatOpenHashMap object2FloatOpenHashMap = new Object2FloatOpenHashMap();
        for (UUID uuid : set) {
            iS iSVarA = cVar.a(uuid);
            object2FloatOpenHashMap.put(uuid, iSVarA.getKills() / Math.max(1.0f, iSVarA.getDeaths()));
        }
        return (Set) object2FloatOpenHashMap.object2FloatEntrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map((v0) -> {
            return v0.getKey();
        }).collect(Collectors.toCollection(ObjectLinkedOpenHashSet::new));
    }

    public static void a(@NotNull xw xwVar, @NotNull xQ xQVar, @NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull Component component, @NotNull UUID uuid) {
        if (!oFVar.a(xwVar, serverPlayer, component)) {
            return;
        }
        String string = component.getString();
        boolean zStartsWith = string.startsWith(bN);
        xO xOVar = (xO) xQVar.a((Player) serverPlayer);
        iS iSVarA = xQVar.a((Player) serverPlayer);
        if (xwVar.f() && !a(xwVar, serverLevel, serverPlayer, string, xOVar, iSVarA)) {
            return;
        }
        C0263jt.log("[Chat] %s: %s", serverPlayer.getScoreboardName(), string);
        a(xwVar, oFVar, component, serverPlayer, uuid);
        Set<UUID> setJ = oFVar.b().j();
        Component componentA = a(xQVar, oFVar, serverPlayer, uuid, serverPlayer.getScoreboardName(), component, xOVar, (List<String>) null);
        boolean zA = a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) xOVar);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<UUID> it = setJ.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = a(it.next());
            if (serverPlayerA != null && C0630xi.b(string, serverPlayerA.getScoreboardName())) {
                objectArrayList.add(serverPlayerA.getScoreboardName());
            }
        }
        for (UUID uuid2 : setJ) {
            ServerPlayer serverPlayerA2 = a(uuid2);
            if (serverPlayerA2 != null && oFVar.a(uuid, serverPlayerA2, uuid2, zStartsWith, zA)) {
                String scoreboardName = serverPlayerA2.getScoreboardName();
                Component componentA2 = componentA;
                if (uuid2.equals(uuid)) {
                    if (!objectArrayList.isEmpty()) {
                        componentA2 = a((com.boehmod.blockfront.common.player.c<?>) xQVar, oFVar, serverPlayer, uuid, serverPlayer.getScoreboardName(), component, xOVar, (List<String>) objectArrayList);
                    }
                } else if (C0630xi.b(string, scoreboardName)) {
                    componentA2 = a(xQVar, oFVar, serverPlayer, uuid, serverPlayer.getScoreboardName(), component, xOVar, (List<String>) List.of(scoreboardName));
                }
                serverPlayerA2.sendSystemMessage(componentA2);
            }
        }
    }

    private static boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar, @NotNull iS iSVar) {
        Component componentA = xz.a(abstractC0264ju, serverPlayer, serverLevel, bVar, iSVar, str);
        if (componentA != null) {
            a(ChatGraphic.WARNING, serverPlayer, componentA);
            a(serverPlayer, (SoundEvent) SoundEvents.NOTE_BLOCK_HARP.value(), SoundSource.MASTER, 1.0f, 2.0f);
            a(serverPlayer, (SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), SoundSource.MASTER, 1.0f, 2.0f);
            return false;
        }
        return true;
    }

    @NotNull
    private static Component a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull oF<?, ?, ?> oFVar, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull String str, @NotNull Component component, @NotNull xO xOVar, @Nullable List<String> list) {
        MutableComponent mutableComponentEmpty;
        MutableComponent mutableComponentLiteral;
        String strReplace = component.getString().replace("<" + str + "> ", "");
        oI oIVarB = oFVar.b();
        boolean zStartsWith = strReplace.startsWith(bN);
        String strReplace2 = strReplace.replace("[Team] ", "");
        boolean zA = a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) xOVar);
        iS iSVarA = cVar.a((Player) serverPlayer);
        MutableComponent mutableComponentB = iSVarA.b();
        MutableComponent mutableComponentB2 = b(iSVarA);
        PlayerRank rank = iSVarA.getRank();
        MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(rank.getGraphic())).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(rank.getTitle()).withColor(ColorReferences.COLOR_WHITE))));
        MutableComponent mutableComponentAppend = Component.empty().append(mutableComponentB);
        if (xOVar.dv()) {
            mutableComponentEmpty = Component.empty().append(t).append(" ");
        } else {
            mutableComponentEmpty = Component.empty();
        }
        MutableComponent mutableComponentWithStyle2 = mutableComponentAppend.withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, mutableComponentB2)));
        oO oOVarA = oIVarB.a(uuid);
        MutableComponent mutableComponentWithStyle3 = Component.literal(": ").withStyle(oOVarA != null ? oOVarA.a() : Style.EMPTY);
        String strReplaceAll = strReplace2.replaceAll("\\p{C}", "?");
        if (iM.dn) {
            mutableComponentLiteral = C0629xh.a(strReplaceAll);
        } else {
            mutableComponentLiteral = Component.literal(strReplaceAll);
        }
        MutableComponent mutableComponentA = mutableComponentLiteral;
        if (list != null) {
            mutableComponentA = C0630xi.a((Component) mutableComponentA, list);
        }
        MutableComponent mutableComponentAppend2 = Component.empty().append(mutableComponentEmpty).append(mutableComponentWithStyle).append(" ").append(mutableComponentWithStyle2).append(mutableComponentWithStyle3).append(mutableComponentA);
        if (oOVarA != null) {
            mutableComponentAppend2 = mutableComponentAppend2.copy().withStyle(oOVarA.b());
        }
        if (oIVarB.g(uuid)) {
            mutableComponentAppend2 = Component.empty().append(iQ).append(" ").append(mutableComponentAppend2);
        } else if (zA) {
            mutableComponentAppend2 = Component.empty().append(iO).append(" ").append(mutableComponentAppend2);
        } else if (zStartsWith) {
            mutableComponentAppend2 = Component.empty().append(iP).append(" ").append(mutableComponentAppend2);
        }
        return mutableComponentAppend2;
    }

    @NotNull
    private static MutableComponent b(@NotNull iS iSVar) {
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(Component.literal("Player " + iSVar.getUsername() + " Stats:"));
        mutableComponentEmpty.append("\n");
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.exp", new Object[]{Component.literal(C0637xp.a(iSVar.getExp())).withStyle(ChatFormatting.YELLOW)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.karma", new Object[]{Component.literal(C0637xp.a(iSVar.getMatchKarma())).withStyle(ChatFormatting.LIGHT_PURPLE)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.time", new Object[]{Component.literal(ModLibraryMathHelper.round(iSVar.getMinutesPlayed() / 60.0d, 1) + "h").withStyle(ChatFormatting.GRAY)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.games", new Object[]{Component.literal(C0637xp.a(iSVar.getTotalGames())).withStyle(ChatFormatting.GRAY)}));
        mutableComponentEmpty.append("\n");
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.headshots", new Object[]{Component.literal(C0637xp.a(iSVar.getHeadShots())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills", new Object[]{Component.literal(C0637xp.a(iSVar.getKills())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.assists", new Object[]{Component.literal(C0637xp.a(iSVar.getAssists())).withStyle(ChatFormatting.YELLOW)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills.streak", new Object[]{Component.literal(C0637xp.a(iSVar.getKillStreak())).withStyle(ChatFormatting.GREEN)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.kills.fire", new Object[]{Component.literal(C0637xp.a(iSVar.getFireKills())).withStyle(ChatFormatting.GOLD)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.deaths", new Object[]{Component.literal(C0637xp.a(iSVar.getDeaths())).withStyle(ChatFormatting.RED)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.deaths.streak", new Object[]{Component.literal(C0637xp.a(iSVar.getDeathStreak())).withStyle(ChatFormatting.RED)}));
        mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.fb", new Object[]{Component.literal(C0637xp.a(iSVar.getFirstBloods())).withStyle(ChatFormatting.DARK_RED)}));
        int prestigeLevel = iSVar.getPrestigeLevel();
        if (prestigeLevel > 0) {
            mutableComponentEmpty.append("\n").append(Component.translatable("bf.message.profile.details.prestige", new Object[]{Component.literal(C0637xp.a(prestigeLevel)).withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)}));
        }
        mutableComponentEmpty.append("\n");
        return mutableComponentEmpty;
    }

    private static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull Component component, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        if (oFVar.m750a() == oN.POST_GAME && a(oFVar, uuid, C0529tp.f) != 1 && a(component)) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.popup.message.karma", new Object[]{Component.literal(String.valueOf(3)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.LIGHT_PURPLE);
            a(abstractC0264ju, oFVar, uuid, C0529tp.f);
            a(abstractC0264ju, oFVar, uuid, C0529tp.t, 3);
            c(serverPlayer, (Component) mutableComponentWithStyle);
            a(serverPlayer, new sQ(mutableComponentWithStyle, 80));
        }
    }

    private static boolean a(@NotNull Component component) {
        String lowerCase = component.getString().toLowerCase(Locale.ROOT);
        return lowerCase.contains("gg") || lowerCase.contains("wp") || (lowerCase.contains("good") && lowerCase.contains("game"));
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @NotNull oO oOVar, boolean z) {
        oOVar.a(oFVar).a(true, pair -> {
            return a((Pair<C0411pf, sV>) pair) && ((sV) pair.getRight()).a((oF<?, ?, ?>) oFVar);
        }).ifPresent(pair2 -> {
            a((oF<?, ?, ?>) oFVar, serverLevel, oOVar, (Pair<C0411pf, sV>) pair2, z);
        });
    }

    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @NotNull oO oOVar, @NotNull Pair<C0411pf, sV> pair, boolean z) {
        a(oFVar, serverLevel, oOVar, pair, z, 16.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @NotNull oO oOVar, @NotNull Pair<C0411pf, sV> pair, boolean z, float f) {
        C0411pf c0411pf = (C0411pf) pair.getLeft();
        sV sVVar = (sV) pair.getRight();
        oX oXVarM789a = oOVar.m789a(oFVar);
        serverLevel.getChunkAt(oXVarM789a.c());
        mE mEVarCreate = ((EntityType) wX.kF.get()).create(serverLevel);
        if (mEVarCreate == null) {
            return;
        }
        C0514ta c0514taA = oOVar.a(oFVar);
        ItemStack itemStackCopy = c0411pf.c().copy();
        if (itemStackCopy.isEmpty()) {
            itemStackCopy = c0411pf.d().copy();
        }
        itemStackCopy.set(wV.X.get(), true);
        float f2 = oXVarM789a.h.x;
        mEVarCreate.moveTo(oXVarM789a.c.x, oXVarM789a.c.y, oXVarM789a.c.z, f2, oXVarM789a.h.y);
        mEVarCreate.setYHeadRot(f2);
        mEVarCreate.setYBodyRot(f2);
        mEVarCreate.e(oFVar);
        mEVarCreate.a(oFVar, oOVar);
        mEVarCreate.s(oOVar.getName());
        mEVarCreate.q(c0514taA.a().ordinal());
        mEVarCreate.t(c0514taA.m1156a().ap());
        mEVarCreate.d(itemStackCopy);
        mEVarCreate.a(sVVar);
        mEVarCreate.F(z);
        AttributeInstance attribute = mEVarCreate.getAttribute(Attributes.MAX_HEALTH);
        if (attribute != null) {
            attribute.setBaseValue(f);
        }
        mEVarCreate.setHealth(f);
        serverLevel.addFreshEntity(mEVarCreate);
        if (oFVar instanceof qL) {
            ((qL) oFVar).a(mEVarCreate, (Level) serverLevel);
        }
    }

    private static boolean a(@NotNull Pair<C0411pf, sV> pair) {
        C0411pf c0411pf = (C0411pf) pair.getLeft();
        ItemStack itemStackC = c0411pf.c();
        if (itemStackC != null) {
            Item item = itemStackC.getItem();
            if ((item instanceof C0558ur) && ((C0558ur) item).m1210a().ch() > 1) {
                return false;
            }
        }
        ItemStack itemStackD = c0411pf.d();
        if (itemStackD == null) {
            return true;
        }
        Item item2 = itemStackD.getItem();
        return !(item2 instanceof C0558ur) || ((C0558ur) item2).m1210a().ch() <= 1;
    }
}
