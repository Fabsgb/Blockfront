package gg.moonflower.molangcompiler.core.node;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.Objects;
import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/node/MolangLazyNode.class */
@ApiStatus.Internal
public class MolangLazyNode implements MolangExpression {
    private final Supplier<Float> value;

    public MolangLazyNode(final Supplier<Float> value) {
        this.value = new Supplier<Float>() { // from class: gg.moonflower.molangcompiler.core.node.MolangLazyNode.1
            private Float result = null;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public Float get() {
                if (this.result == null) {
                    this.result = (Float) value.get();
                }
                return this.result;
            }
        };
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public float get(MolangEnvironment environment) {
        return this.value.get().floatValue();
    }

    public String toString() {
        return Float.toString(this.value.get().floatValue());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MolangLazyNode that = (MolangLazyNode) o;
        return this.value.get().equals(that.value.get());
    }

    public int hashCode() {
        return Objects.hash(this.value.get());
    }
}
