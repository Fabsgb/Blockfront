package foundry.veil.api.flare.data.model;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.flare.data.model.SimpleBakedShell;
import foundry.veil.api.flare.model.BakedShell;
import foundry.veil.api.flare.model.ShellBakery;
import foundry.veil.api.flare.model.UnbakedShell;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/model/FlareShell.class */
public final class FlareShell implements UnbakedShell {
    public static final Codec<FlareShell> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(ShellElement.CODEC.listOf().fieldOf("elements").forGetter((v0) -> {
            return v0.elements();
        })).apply(instance, FlareShell::new);
    });
    private final List<ShellElement> elements;

    public FlareShell(List<ShellElement> elements) {
        this.elements = List.copyOf(elements);
    }

    @Override // foundry.veil.api.flare.model.UnbakedShell
    @Nullable
    public BakedShell bake() {
        SimpleBakedShell.Builder builder = new SimpleBakedShell.Builder();
        for (ShellElement element : this.elements) {
            for (Map.Entry<Direction, ShellElementFace> entry : element.faces().entrySet()) {
                builder.addFace(ShellBakery.bakeQuad(element, entry.getValue(), entry.getKey()));
            }
        }
        return builder.build();
    }

    @Override // foundry.veil.api.flare.model.UnbakedShell
    public List<ShellElement> elements() {
        return new ArrayList(this.elements);
    }
}
