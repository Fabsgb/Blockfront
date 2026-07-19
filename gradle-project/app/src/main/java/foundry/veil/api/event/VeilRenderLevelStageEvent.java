package foundry.veil.api.event;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import foundry.veil.api.client.render.MatrixStack;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import org.joml.Matrix4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilRenderLevelStageEvent.class */
@FunctionalInterface
public interface VeilRenderLevelStageEvent {
    void onRenderLevelStage(Stage stage, LevelRenderer levelRenderer, MultiBufferSource.BufferSource bufferSource, MatrixStack matrixStack, Matrix4fc matrix4fc, Matrix4fc matrix4fc2, int i, DeltaTracker deltaTracker, Camera camera, Frustum frustum);

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilRenderLevelStageEvent$Stage.class */
    public enum Stage {
        AFTER_SKY,
        AFTER_SOLID_BLOCKS,
        AFTER_CUTOUT_MIPPED_BLOCKS,
        AFTER_CUTOUT_BLOCKS,
        AFTER_ENTITIES,
        AFTER_BLOCK_ENTITIES,
        AFTER_TRANSLUCENT_BLOCKS,
        AFTER_TRIPWIRE_BLOCKS,
        AFTER_PARTICLES,
        AFTER_WEATHER,
        AFTER_LEVEL;

        private static final Stage[] VALUES = values();
        public static final Codec<Stage> CODEC = Codec.STRING.flatXmap(name -> {
            for (Stage stage : VALUES) {
                if (stage.getName().equals(name)) {
                    return DataResult.success(stage);
                }
            }
            return DataResult.error(() -> {
                return "Unknown render stage: " + name + ". Valid stages: " + ((String) Arrays.stream(VALUES).map((v0) -> {
                    return v0.getName();
                }).collect(Collectors.joining(", ")));
            });
        }, stage -> {
            return DataResult.success(stage.getName());
        });
        private final String name = name().toLowerCase(Locale.ROOT);

        Stage() {
        }

        public String getName() {
            return this.name;
        }
    }
}
