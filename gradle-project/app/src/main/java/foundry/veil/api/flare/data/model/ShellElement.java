package foundry.veil.api.flare.data.model;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.util.CodecUtil;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/model/ShellElement.class */
public final class ShellElement {
    public static final Codec<ShellElement> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(CodecUtil.VECTOR3FC_CODEC.fieldOf("from").forGetter((v0) -> {
            return v0.from();
        }), CodecUtil.VECTOR3FC_CODEC.fieldOf("to").forGetter((v0) -> {
            return v0.to();
        }), ShellElementRotation.CODEC.optionalFieldOf("rotation").forGetter(element -> {
            return Optional.ofNullable(element.rotation);
        }), ShellElementFace.FULL_CODEC.fieldOf("faces").forGetter((v0) -> {
            return v0.faces();
        })).apply(instance, (from, to, rotation, faces) -> {
            Map<Direction, ShellElementFace> facesMap = faces.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new EnumMap(faces));
            return new ShellElement(from, to, (ShellElementRotation) rotation.orElse(null), facesMap);
        });
    });
    private final Vector3fc from;
    private final Vector3fc to;

    @Nullable
    private final ShellElementRotation rotation;
    private final Map<Direction, ShellElementFace> faces;

    public ShellElement(Vector3fc from, Vector3fc to, @Nullable ShellElementRotation rotation, Map<Direction, ShellElementFace> faces) {
        this.from = from;
        this.to = to;
        this.rotation = rotation;
        this.faces = Map.copyOf(faces);
    }

    public Vector3fc from() {
        return this.from;
    }

    public Vector3fc to() {
        return this.to;
    }

    @Nullable
    public ShellElementRotation rotation() {
        return this.rotation;
    }

    public Map<Direction, ShellElementFace> faces() {
        return this.faces;
    }
}
