package foundry.veil.api.quasar.particle;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/SpriteData.class */
public final class SpriteData extends Record {
    private final ResourceLocation sprite;
    private final int frameCount;
    private final float frameTime;
    private final int frameWidth;
    private final int frameHeight;
    private final boolean stretchToLifetime;
    public static final Codec<SpriteData> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("sprite").forGetter((v0) -> {
            return v0.sprite();
        }), Codec.INT.optionalFieldOf("frame_count", 1).forGetter((v0) -> {
            return v0.frameCount();
        }), Codec.FLOAT.optionalFieldOf("frame_time", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.frameTime();
        }), Codec.INT.optionalFieldOf("frame_width", 1).forGetter((v0) -> {
            return v0.frameWidth();
        }), Codec.INT.optionalFieldOf("frame_height", 1).forGetter((v0) -> {
            return v0.frameHeight();
        }), Codec.BOOL.optionalFieldOf("stretch_to_lifetime", false).forGetter((v0) -> {
            return v0.stretchToLifetime();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new SpriteData(v1, v2, v3, v4, v5, v6);
        });
    });

    public SpriteData(ResourceLocation sprite, int frameCount, float frameTime, int frameWidth, int frameHeight, boolean stretchToLifetime) {
        this.sprite = sprite;
        this.frameCount = frameCount;
        this.frameTime = frameTime;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.stretchToLifetime = stretchToLifetime;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, SpriteData.class), SpriteData.class, "sprite;frameCount;frameTime;frameWidth;frameHeight;stretchToLifetime", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->sprite:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameCount:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameTime:F", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameWidth:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameHeight:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->stretchToLifetime:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, SpriteData.class), SpriteData.class, "sprite;frameCount;frameTime;frameWidth;frameHeight;stretchToLifetime", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->sprite:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameCount:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameTime:F", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameWidth:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameHeight:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->stretchToLifetime:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, SpriteData.class, Object.class), SpriteData.class, "sprite;frameCount;frameTime;frameWidth;frameHeight;stretchToLifetime", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->sprite:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameCount:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameTime:F", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameWidth:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->frameHeight:I", "FIELD:Lfoundry/veil/api/quasar/particle/SpriteData;->stretchToLifetime:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public ResourceLocation sprite() {
        return this.sprite;
    }

    public int frameCount() {
        return this.frameCount;
    }

    public float frameTime() {
        return this.frameTime;
    }

    public int frameWidth() {
        return this.frameWidth;
    }

    public int frameHeight() {
        return this.frameHeight;
    }

    public boolean stretchToLifetime() {
        return this.stretchToLifetime;
    }

    public Vector4f uv(float renderAge, float agePercent, Vector4f store) {
        int frameIndex = this.stretchToLifetime ? (int) Math.min(agePercent * (this.frameCount + 1), this.frameCount) : (int) (renderAge / this.frameTime);
        int frameColumn = frameIndex / this.frameWidth;
        if (this.frameWidth > 1) {
            int frameRow = frameIndex % this.frameWidth;
            store.x = frameRow / this.frameWidth;
            store.z = (frameRow + 1.0f) / this.frameWidth;
        } else {
            store.x = 0.0f;
            store.z = 1.0f;
        }
        if (this.frameHeight > 1) {
            store.y = frameColumn / this.frameHeight;
            store.w = (frameColumn + 1.0f) / this.frameHeight;
        } else {
            store.y = 0.0f;
            store.w = 1.0f;
        }
        return store;
    }

    public float u(float renderAge, float agePercent, float u) {
        if (this.frameWidth <= 1) {
            return u;
        }
        int frameIndex = this.stretchToLifetime ? (int) Math.min(agePercent * (this.frameCount + 1), this.frameCount) : (int) (renderAge / this.frameTime);
        int frameRow = frameIndex % this.frameWidth;
        return ((frameRow / this.frameWidth) * (1.0f - u)) + (((frameRow + 1.0f) / this.frameWidth) * u);
    }

    public float v(float renderAge, float agePercent, float v) {
        if (this.frameHeight <= 1) {
            return v;
        }
        int frameIndex = this.stretchToLifetime ? (int) Math.min(agePercent * (this.frameCount + 1), this.frameCount) : (int) (renderAge / this.frameTime);
        int frameColumn = frameIndex / this.frameWidth;
        return ((frameColumn / this.frameHeight) * (1.0f - v)) + (((frameColumn + 1.0f) / this.frameHeight) * v);
    }
}
