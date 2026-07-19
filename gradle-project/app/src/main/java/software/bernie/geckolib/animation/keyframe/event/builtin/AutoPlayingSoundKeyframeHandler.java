package software.bernie.geckolib.animation.keyframe.event.builtin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.keyframe.event.SoundKeyframeEvent;
import software.bernie.geckolib.util.ClientUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/event/builtin/AutoPlayingSoundKeyframeHandler.class */
public class AutoPlayingSoundKeyframeHandler<A extends GeoAnimatable> implements AnimationController.SoundKeyframeHandler<A> {
    @Override // software.bernie.geckolib.animation.AnimationController.SoundKeyframeHandler
    public void handle(SoundKeyframeEvent<A> event) {
        Entity entity;
        Vec3 center;
        String[] segments = event.getKeyframeData().getSound().split("\\|");
        SoundEvent sound = (SoundEvent) BuiltInRegistries.SOUND_EVENT.get((ResourceLocation) ResourceLocation.read(segments[0]).getOrThrow());
        if (sound != null) {
            Entity animatable = event.getAnimatable();
            if (animatable instanceof Entity) {
                Entity e = animatable;
                entity = e;
            } else {
                entity = null;
            }
            Entity entity2 = entity;
            if (entity2 != null) {
                center = entity2.position();
            } else {
                BlockEntity animatable2 = event.getAnimatable();
                if (animatable2 instanceof BlockEntity) {
                    BlockEntity blockEntity = animatable2;
                    center = blockEntity.getBlockPos().getCenter();
                } else {
                    center = null;
                }
            }
            Vec3 position = center;
            if (position != null) {
                float volume = segments.length > 1 ? Float.parseFloat(segments[1]) : 1.0f;
                float pitch = segments.length > 2 ? Float.parseFloat(segments[2]) : 1.0f;
                SoundSource source = entity2 == null ? SoundSource.BLOCKS : entity2 instanceof Enemy ? SoundSource.HOSTILE : SoundSource.NEUTRAL;
                ClientUtil.getLevel().playSound((Player) null, position.x, position.y, position.z, sound, source, volume, pitch);
            }
        }
    }
}
