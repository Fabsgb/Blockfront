package software.bernie.geckolib.loading.math;

import com.google.common.collect.Streams;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.ToDoubleFunction;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Leashable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.loading.math.value.Variable;
import software.bernie.geckolib.util.ClientUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/MolangQueries.class */
public final class MolangQueries {
    public static final String ACTOR_COUNT = "query.actor_count";
    public static final String ANIM_TIME = "query.anim_time";
    public static final String BLOCKING = "query.blocking";
    public static final String BLOCK_STATE = "query.block_state";
    public static final String BODY_X_ROTATION = "query.body_x_rotation";
    public static final String BODY_Y_ROTATION = "query.body_y_rotation";
    public static final String CAN_CLIMB = "query.can_climb";
    public static final String CAN_FLY = "query.can_fly";
    public static final String CAN_SWIM = "query.can_swim";
    public static final String CAN_WALK = "query.can_walk";
    public static final String CARDINAL_FACING = "query.cardinal_facing";
    public static final String CARDINAL_FACING_2D = "query.cardinal_facing_2d";
    public static final String CARDINAL_PLAYER_FACING = "query.cardinal_player_facing";
    public static final String DAY = "query.day";
    public static final String DEATH_TICKS = "query.death_ticks";
    public static final String DISTANCE_FROM_CAMERA = "query.distance_from_camera";
    public static final String EQUIPMENT_COUNT = "query.equipment_count";
    public static final String FRAME_ALPHA = "query.frame_alpha";
    public static final String GET_ACTOR_INFO_ID = "query.get_actor_info_id";
    public static final String GROUND_SPEED = "query.ground_speed";
    public static final String HAS_CAPE = "query.has_cape";
    public static final String HAS_COLLISION = "query.has_collision";
    public static final String HAS_GRAVITY = "query.has_gravity";
    public static final String HAS_HEAD_GEAR = "query.has_head_gear";
    public static final String HAS_OWNER = "query.has_owner";
    public static final String HAS_PLAYER_RIDER = "query.has_player_rider";
    public static final String HAS_RIDER = "query.has_rider";
    public static final String HEAD_X_ROTATION = "query.head_x_rotation";
    public static final String HEAD_Y_ROTATION = "query.head_y_rotation";
    public static final String HEALTH = "query.health";
    public static final String HURT_TIME = "query.hurt_time";
    public static final String INVULNERABLE_TICKS = "query.invulnerable_ticks";
    public static final String IS_ALIVE = "query.is_alive";
    public static final String IS_ANGRY = "query.is_angry";
    public static final String IS_BABY = "query.is_baby";
    public static final String IS_BREATHING = "query.is_breathing";
    public static final String IS_ENCHANTED = "query.is_enchanted";
    public static final String IS_FIRE_IMMUNE = "query.is_fire_immune";
    public static final String IS_FIRST_PERSON = "query.is_first_person";
    public static final String IS_INVISIBLE = "query.is_invisible";
    public static final String IS_IN_CONTACT_WITH_WATER = "query.is_in_contact_with_water";
    public static final String IS_IN_LAVA = "query.is_in_lava";
    public static final String IS_IN_WATER = "query.is_in_water";
    public static final String IS_IN_WATER_OR_RAIN = "query.is_in_water_or_rain";
    public static final String IS_LEASHED = "query.is_leashed";
    public static final String IS_MOVING = "query.is_moving";
    public static final String IS_ON_FIRE = "query.is_on_fire";
    public static final String IS_ON_GROUND = "query.is_on_ground";
    public static final String IS_POWERED = "query.is_powered";
    public static final String IS_RIDING = "query.is_riding";
    public static final String IS_SADDLED = "query.is_saddled";
    public static final String IS_SILENT = "query.is_silent";
    public static final String IS_SLEEPING = "query.is_sleeping";
    public static final String IS_SNEAKING = "query.is_sneaking";
    public static final String IS_SPRINTING = "query.is_sprinting";
    public static final String IS_STACKABLE = "query.is_stackable";
    public static final String IS_SWIMMING = "query.is_swimming";
    public static final String IS_USING_ITEM = "query.is_using_item";
    public static final String IS_WALL_CLIMBING = "query.is_wall_climbing";
    public static final String ITEM_MAX_USE_DURATION = "query.item_max_use_duration";
    public static final String LIFE_TIME = "query.life_time";
    public static final String MAIN_HAND_ITEM_MAX_DURATION = "query.main_hand_item_max_duration";
    public static final String MAIN_HAND_ITEM_USE_DURATION = "query.main_hand_item_use_duration";
    public static final String MAX_DURABILITY = "query.max_durability";
    public static final String MAX_HEALTH = "query.max_health";
    public static final String MOON_BRIGHTNESS = "query.moon_brightness";
    public static final String MOON_PHASE = "query.moon_phase";
    public static final String MOVEMENT_DIRECTION = "query.movement_direction";
    public static final String PLAYER_LEVEL = "query.player_level";
    public static final String REMAINING_DURABILITY = "query.remaining_durability";
    public static final String RIDER_BODY_X_ROTATION = "query.rider_body_x_rotation";
    public static final String RIDER_BODY_Y_ROTATION = "query.rider_body_y_rotation";
    public static final String RIDER_HEAD_X_ROTATION = "query.rider_head_x_rotation";
    public static final String RIDER_HEAD_Y_ROTATION = "query.rider_head_y_rotation";
    public static final String SCALE = "query.scale";
    public static final String SLEEP_ROTATION = "query.sleep_rotation";
    public static final String TIME_OF_DAY = "query.time_of_day";
    public static final String TIME_STAMP = "query.time_stamp";
    public static final String VERTICAL_SPEED = "query.vertical_speed";
    public static final String YAW_SPEED = "query.yaw_speed";
    private static final Map<String, Variable> VARIABLES = new ConcurrentHashMap();
    private static Actor<?> ACTOR = null;

    static {
        setDefaultQueryValues();
    }

    public static boolean isExistingVariable(String name) {
        return VARIABLES.containsKey(name);
    }

    static void registerVariable(Variable variable) {
        VARIABLES.put(variable.name(), variable);
    }

    static Variable getVariableFor(String name) {
        return VARIABLES.computeIfAbsent(applyPrefixAliases(name, "query.", "q."), key -> {
            return new Variable(key, 0.0d);
        });
    }

    private static String applyPrefixAliases(String text, String properName, String... aliases) {
        for (String alias : aliases) {
            if (text.startsWith(alias)) {
                return properName + text.substring(alias.length());
            }
        }
        return text;
    }

    public static void updateActor(AnimationState<? extends GeoAnimatable> animationState, double animTime) {
        ACTOR = new Actor<>(animationState, animationState.getAnimatable(), animTime, Minecraft.getInstance(), Minecraft.getInstance().level);
    }

    public static void clearActor() {
        ACTOR = null;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/MolangQueries$Actor.class */
    public static final class Actor<T> extends Record {
        private final AnimationState<? extends GeoAnimatable> animationState;
        private final T animatable;
        private final double animTime;

        /* JADX INFO: renamed from: mc */
        private final Minecraft f8813mc;
        private final Level level;

        public Actor(AnimationState<? extends GeoAnimatable> animationState, T animatable, double animTime, Minecraft mc, Level level) {
            this.animationState = animationState;
            this.animatable = animatable;
            this.animTime = animTime;
            this.f8813mc = mc;
            this.level = level;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Actor.class), Actor.class, "animationState;animatable;animTime;mc;level", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animationState:Lsoftware/bernie/geckolib/animation/AnimationState;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animatable:Ljava/lang/Object;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animTime:D", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->mc:Lnet/minecraft/client/Minecraft;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->level:Lnet/minecraft/world/level/Level;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Actor.class), Actor.class, "animationState;animatable;animTime;mc;level", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animationState:Lsoftware/bernie/geckolib/animation/AnimationState;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animatable:Ljava/lang/Object;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animTime:D", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->mc:Lnet/minecraft/client/Minecraft;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->level:Lnet/minecraft/world/level/Level;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Actor.class, Object.class), Actor.class, "animationState;animatable;animTime;mc;level", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animationState:Lsoftware/bernie/geckolib/animation/AnimationState;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animatable:Ljava/lang/Object;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->animTime:D", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->mc:Lnet/minecraft/client/Minecraft;", "FIELD:Lsoftware/bernie/geckolib/loading/math/MolangQueries$Actor;->level:Lnet/minecraft/world/level/Level;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public AnimationState<? extends GeoAnimatable> animationState() {
            return this.animationState;
        }

        public T animatable() {
            return this.animatable;
        }

        public double animTime() {
            return this.animTime;
        }

        /* JADX INFO: renamed from: mc */
        public Minecraft m8012mc() {
            return this.f8813mc;
        }

        public Level level() {
            return this.level;
        }
    }

    public static <T> void setActorVariable(String name, ToDoubleFunction<Actor<T>> value) {
        getVariableFor(name).set(() -> {
            return value.applyAsDouble(getActor());
        });
    }

    private static Actor<?> getActor() {
        return ACTOR;
    }

    private static void setDefaultQueryValues() {
        getVariableFor("PI").set(3.141592653589793d);
        getVariableFor("E").set(2.718281828459045d);
        setActorVariable(CARDINAL_PLAYER_FACING, actor -> {
            return actor.f8813mc.player.getDirection().ordinal();
        });
        setActorVariable(DAY, actor2 -> {
            return actor2.level.getGameTime() / 24000.0d;
        });
        setActorVariable(FRAME_ALPHA, actor3 -> {
            return actor3.animationState().getPartialTick();
        });
        setActorVariable(HAS_CAPE, actor4 -> {
            return actor4.f8813mc.player.getSkin().capeTexture() != null ? 1.0d : 0.0d;
        });
        setActorVariable(IS_FIRST_PERSON, actor5 -> {
            return actor5.f8813mc.options.getCameraType() == CameraType.FIRST_PERSON ? 1.0d : 0.0d;
        });
        setActorVariable(LIFE_TIME, actor6 -> {
            return actor6.animTime / 20.0d;
        });
        setActorVariable(MOON_BRIGHTNESS, actor7 -> {
            return actor7.level.getMoonBrightness();
        });
        setActorVariable(MOON_PHASE, actor8 -> {
            return actor8.level.getMoonPhase();
        });
        setActorVariable(PLAYER_LEVEL, actor9 -> {
            return actor9.f8813mc.player.experienceLevel;
        });
        setActorVariable(TIME_OF_DAY, actor10 -> {
            return actor10.level.getDayTime() / 24000.0f;
        });
        setActorVariable(TIME_STAMP, actor11 -> {
            return actor11.f8813mc.level.getGameTime();
        });
        setDefaultBlockEntityQueryValues();
        setDefaultEntityQueryValues();
        setDefaultLivingEntityQueryValues();
        setDefaultMobQueryValues();
        setDefaultItemQueryValues();
    }

    private static void setDefaultBlockEntityQueryValues() {
        setActorVariable(BLOCK_STATE, actor -> {
            return ((BlockEntity) actor.animatable).getBlockState().getBlock().getStateDefinition().getPossibleStates().indexOf(((BlockEntity) actor.animatable).getBlockState());
        });
    }

    private static void setDefaultEntityQueryValues() {
        setActorVariable(BODY_X_ROTATION, actor -> {
            if (actor.animatable instanceof LivingEntity) {
                return 0.0d;
            }
            return ((Entity) actor.animatable).getViewXRot(actor.animationState.getPartialTick());
        });
        setActorVariable(BODY_Y_ROTATION, actor2 -> {
            float viewYRot;
            Object patt0$temp = actor2.animatable;
            if (patt0$temp instanceof LivingEntity) {
                LivingEntity living = (LivingEntity) patt0$temp;
                viewYRot = Mth.lerp(actor2.animationState.getPartialTick(), living.yBodyRotO, living.yBodyRot);
            } else {
                viewYRot = ((Entity) actor2.animatable).getViewYRot(actor2.animationState.getPartialTick());
            }
            return viewYRot;
        });
        setActorVariable(CARDINAL_FACING, actor3 -> {
            return ((Entity) actor3.animatable).getDirection().get3DDataValue();
        });
        setActorVariable(CARDINAL_FACING_2D, actor4 -> {
            int directionId = ((Entity) actor4.animatable).getDirection().get3DDataValue();
            if (directionId < 2) {
                return 6.0d;
            }
            return directionId;
        });
        setActorVariable(DISTANCE_FROM_CAMERA, actor5 -> {
            return actor5.f8813mc.gameRenderer.getMainCamera().getPosition().distanceTo(((Entity) actor5.animatable).position());
        });
        setActorVariable(GET_ACTOR_INFO_ID, actor6 -> {
            return ((Entity) actor6.animatable).getId();
        });
        setActorVariable(HAS_COLLISION, actor7 -> {
            return !((Entity) actor7.animatable).noPhysics ? 1.0d : 0.0d;
        });
        setActorVariable(HAS_GRAVITY, actor8 -> {
            return !((Entity) actor8.animatable).isNoGravity() ? 1.0d : 0.0d;
        });
        setActorVariable(HAS_OWNER, actor9 -> {
            int i;
            Object patt0$temp = actor9.animatable;
            if (patt0$temp instanceof OwnableEntity) {
                OwnableEntity ownable = (OwnableEntity) patt0$temp;
                i = ownable.getOwnerUUID() != null ? 1 : 0;
            }
            return i;
        });
        setActorVariable(HAS_PLAYER_RIDER, actor10 -> {
            Entity entity = (Entity) actor10.animatable;
            Class<Player> cls = Player.class;
            Objects.requireNonNull(Player.class);
            return entity.hasPassenger((v1) -> {
                return r1.isInstance(v1);
            }) ? 1.0d : 0.0d;
        });
        setActorVariable(HAS_RIDER, actor11 -> {
            return ((Entity) actor11.animatable).isVehicle() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_ALIVE, actor12 -> {
            return ((Entity) actor12.animatable).isAlive() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_ANGRY, actor13 -> {
            int i;
            Object patt0$temp = actor13.animatable;
            if (patt0$temp instanceof NeutralMob) {
                NeutralMob neutralMob = (NeutralMob) patt0$temp;
                i = neutralMob.isAngry() ? 1 : 0;
            }
            return i;
        });
        setActorVariable(IS_BREATHING, actor14 -> {
            return ((Entity) actor14.animatable).getAirSupply() >= ((Entity) actor14.animatable).getMaxAirSupply() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_FIRE_IMMUNE, actor15 -> {
            return ((Entity) actor15.animatable).getType().fireImmune() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_INVISIBLE, actor16 -> {
            return ((Entity) actor16.animatable).isInvisible() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_IN_CONTACT_WITH_WATER, actor17 -> {
            return ((Entity) actor17.animatable).isInWaterRainOrBubble() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_IN_LAVA, actor18 -> {
            return ((Entity) actor18.animatable).isInLava() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_IN_WATER, actor19 -> {
            return ((Entity) actor19.animatable).isInWater() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_IN_WATER_OR_RAIN, actor20 -> {
            return ((Entity) actor20.animatable).isInWaterOrRain() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_LEASHED, actor21 -> {
            int i;
            Object patt0$temp = actor21.animatable;
            if (patt0$temp instanceof Leashable) {
                Leashable leashable = (Leashable) patt0$temp;
                i = leashable.isLeashed() ? 1 : 0;
            }
            return i;
        });
        setActorVariable(IS_MOVING, actor22 -> {
            return actor22.animationState.isMoving() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_ON_FIRE, actor23 -> {
            return ((Entity) actor23.animatable).isOnFire() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_ON_GROUND, actor24 -> {
            return ((Entity) actor24.animatable).onGround() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_POWERED, actor25 -> {
            int i;
            Object patt0$temp = actor25.animatable;
            if (patt0$temp instanceof PowerableMob) {
                PowerableMob powerable = (PowerableMob) patt0$temp;
                i = powerable.isPowered() ? 1 : 0;
            }
            return i;
        });
        setActorVariable(IS_RIDING, actor26 -> {
            return ((Entity) actor26.animatable).isPassenger() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_SADDLED, actor27 -> {
            int i;
            Object patt0$temp = actor27.animatable;
            if (patt0$temp instanceof Saddleable) {
                Saddleable saddleable = (Saddleable) patt0$temp;
                i = saddleable.isSaddled() ? 1 : 0;
            }
            return i;
        });
        setActorVariable(IS_SILENT, actor28 -> {
            return ((Entity) actor28.animatable).isSilent() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_SNEAKING, actor29 -> {
            return ((Entity) actor29.animatable).isCrouching() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_SPRINTING, actor30 -> {
            return ((Entity) actor30.animatable).isSprinting() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_SWIMMING, actor31 -> {
            return ((Entity) actor31.animatable).isSwimming() ? 1.0d : 0.0d;
        });
        setActorVariable(MOVEMENT_DIRECTION, actor32 -> {
            if (actor32.animationState.isMoving()) {
                return Direction.getNearest(((Entity) actor32.animatable).getDeltaMovement()).get3DDataValue();
            }
            return 6.0d;
        });
        setActorVariable(RIDER_BODY_X_ROTATION, actor33 -> {
            if (!((Entity) actor33.animatable).isVehicle() || (((Entity) actor33.animatable).getFirstPassenger() instanceof LivingEntity)) {
                return 0.0d;
            }
            return ((Entity) actor33.animatable).getFirstPassenger().getViewXRot(actor33.animationState.getPartialTick());
        });
        setActorVariable(RIDER_BODY_Y_ROTATION, actor34 -> {
            float viewYRot;
            if (((Entity) actor34.animatable).isVehicle()) {
                LivingEntity firstPassenger = ((Entity) actor34.animatable).getFirstPassenger();
                if (firstPassenger instanceof LivingEntity) {
                    LivingEntity living = firstPassenger;
                    viewYRot = Mth.lerp(actor34.animationState.getPartialTick(), living.yBodyRotO, living.yBodyRot);
                } else {
                    viewYRot = ((Entity) actor34.animatable).getFirstPassenger().getViewYRot(actor34.animationState.getPartialTick());
                }
            } else {
                viewYRot = 0.0f;
            }
            return viewYRot;
        });
        setActorVariable(RIDER_HEAD_X_ROTATION, actor35 -> {
            LivingEntity firstPassenger = ((Entity) actor35.animatable).getFirstPassenger();
            if (!(firstPassenger instanceof LivingEntity)) {
                return 0.0d;
            }
            LivingEntity living = firstPassenger;
            return living.getViewXRot(actor35.animationState.getPartialTick());
        });
        setActorVariable(RIDER_HEAD_Y_ROTATION, actor36 -> {
            LivingEntity firstPassenger = ((Entity) actor36.animatable).getFirstPassenger();
            if (!(firstPassenger instanceof LivingEntity)) {
                return 0.0d;
            }
            LivingEntity living = firstPassenger;
            return living.getViewYRot(actor36.animationState.getPartialTick());
        });
        setActorVariable(VERTICAL_SPEED, actor37 -> {
            return ((Entity) actor37.animatable).getDeltaMovement().y;
        });
        setActorVariable(YAW_SPEED, actor38 -> {
            return ((Entity) actor38.animatable).getYRot() - ((Entity) actor38.animatable).yRotO;
        });
    }

    private static void setDefaultLivingEntityQueryValues() {
        setActorVariable(BLOCKING, actor -> {
            return ((LivingEntity) actor.animatable).isBlocking() ? 1.0d : 0.0d;
        });
        setActorVariable(DEATH_TICKS, actor2 -> {
            if (((LivingEntity) actor2.animatable).deathTime == 0) {
                return 0.0d;
            }
            return ((LivingEntity) actor2.animatable).deathTime + actor2.animationState.getPartialTick();
        });
        setActorVariable(EQUIPMENT_COUNT, actor3 -> {
            return Streams.stream(((LivingEntity) actor3.animatable).getArmorSlots()).filter(stack -> {
                return !stack.isEmpty();
            }).count();
        });
        setActorVariable(GROUND_SPEED, actor4 -> {
            return ((LivingEntity) actor4.animatable).getDeltaMovement().horizontalDistance();
        });
        setActorVariable(HAS_HEAD_GEAR, actor5 -> {
            return !((LivingEntity) actor5.animatable).getItemBySlot(EquipmentSlot.HEAD).isEmpty() ? 1.0d : 0.0d;
        });
        setActorVariable(HEAD_X_ROTATION, actor6 -> {
            return ((LivingEntity) actor6.animatable).getViewXRot(actor6.animationState.getPartialTick());
        });
        setActorVariable(HEAD_Y_ROTATION, actor7 -> {
            return ((LivingEntity) actor7.animatable).getViewYRot(actor7.animationState.getPartialTick());
        });
        setActorVariable(HEALTH, actor8 -> {
            return ((LivingEntity) actor8.animatable).getHealth();
        });
        setActorVariable(HURT_TIME, actor9 -> {
            if (((LivingEntity) actor9.animatable).hurtTime == 0) {
                return 0.0d;
            }
            return ((LivingEntity) actor9.animatable).hurtTime - actor9.animationState.getPartialTick();
        });
        setActorVariable(INVULNERABLE_TICKS, actor10 -> {
            if (((LivingEntity) actor10.animatable).invulnerableTime == 0) {
                return 0.0d;
            }
            return ((LivingEntity) actor10.animatable).invulnerableTime - actor10.animationState.getPartialTick();
        });
        setActorVariable(IS_BABY, actor11 -> {
            return ((LivingEntity) actor11.animatable).isBaby() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_SLEEPING, actor12 -> {
            return ((LivingEntity) actor12.animatable).isSleeping() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_USING_ITEM, actor13 -> {
            return ((LivingEntity) actor13.animatable).isUsingItem() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_WALL_CLIMBING, actor14 -> {
            return ((LivingEntity) actor14.animatable).onClimbable() ? 1.0d : 0.0d;
        });
        setActorVariable(MAIN_HAND_ITEM_MAX_DURATION, actor15 -> {
            return ((LivingEntity) actor15.animatable).getMainHandItem().getUseDuration((LivingEntity) actor15.animatable);
        });
        setActorVariable(MAIN_HAND_ITEM_USE_DURATION, actor16 -> {
            if (((LivingEntity) actor16.animatable).getUsedItemHand() == InteractionHand.MAIN_HAND) {
                return (((double) ((LivingEntity) actor16.animatable).getTicksUsingItem()) / 20.0d) + ((double) actor16.animationState.getPartialTick());
            }
            return 0.0d;
        });
        setActorVariable(MAX_HEALTH, actor17 -> {
            return ((LivingEntity) actor17.animatable).getMaxHealth();
        });
        setActorVariable(SCALE, actor18 -> {
            return ((LivingEntity) actor18.animatable).getScale();
        });
        setActorVariable(SLEEP_ROTATION, actor19 -> {
            return ((Float) Optional.ofNullable(((LivingEntity) actor19.animatable).getBedOrientation()).map((v0) -> {
                return v0.toYRot();
            }).orElse(Float.valueOf(0.0f))).floatValue();
        });
    }

    private static void setDefaultMobQueryValues() {
        setActorVariable(CAN_CLIMB, actor -> {
            return (((Mob) actor.animatable).isNoAi() || !(((Mob) actor.animatable).getNavigation() instanceof WallClimberNavigation)) ? 0.0d : 1.0d;
        });
        setActorVariable(CAN_FLY, actor2 -> {
            return (((Mob) actor2.animatable).isNoAi() || !(((Mob) actor2.animatable).getNavigation() instanceof FlyingPathNavigation)) ? 0.0d : 1.0d;
        });
        setActorVariable(CAN_SWIM, actor3 -> {
            return ((((Mob) actor3.animatable).isNoAi() || !(((Mob) actor3.animatable).getNavigation() instanceof WaterBoundPathNavigation)) && !(((Mob) actor3.animatable).getNavigation() instanceof AmphibiousPathNavigation)) ? 0.0d : 1.0d;
        });
        setActorVariable(CAN_WALK, actor4 -> {
            return ((((Mob) actor4.animatable).isNoAi() || !(((Mob) actor4.animatable).getNavigation() instanceof GroundPathNavigation)) && !(((Mob) actor4.animatable).getNavigation() instanceof AmphibiousPathNavigation)) ? 0.0d : 1.0d;
        });
    }

    private static void setDefaultItemQueryValues() {
        setActorVariable(IS_ENCHANTED, actor -> {
            return ((ItemStack) actor.animationState.getData(DataTickets.ITEMSTACK)).isEnchanted() ? 1.0d : 0.0d;
        });
        setActorVariable(IS_STACKABLE, actor2 -> {
            return ((ItemStack) actor2.animationState.getData(DataTickets.ITEMSTACK)).isStackable() ? 1.0d : 0.0d;
        });
        setActorVariable(ITEM_MAX_USE_DURATION, actor3 -> {
            return ((ItemStack) actor3.animationState.getData(DataTickets.ITEMSTACK)).getUseDuration(ClientUtil.getClientPlayer());
        });
        setActorVariable(MAX_DURABILITY, actor4 -> {
            return ((ItemStack) actor4.animationState.getData(DataTickets.ITEMSTACK)).getMaxDamage();
        });
        setActorVariable(REMAINING_DURABILITY, actor5 -> {
            ItemStack stack = (ItemStack) actor5.animationState.getData(DataTickets.ITEMSTACK);
            if (stack.isDamageableItem()) {
                return stack.getMaxDamage() - stack.getDamageValue();
            }
            return 1.0d;
        });
    }
}
