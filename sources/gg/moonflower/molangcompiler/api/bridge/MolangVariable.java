package gg.moonflower.molangcompiler.api.bridge;

import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/bridge/MolangVariable.class */
public interface MolangVariable {
    float getValue();

    void setValue(float f);

    MolangVariable copy();

    default MolangVariable immutable() {
        return new MolangVariable() { // from class: gg.moonflower.molangcompiler.api.bridge.MolangVariable.1
            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public float getValue() {
                return MolangVariable.this.getValue();
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public void setValue(float value) {
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public MolangVariable copy() {
                return this;
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public MolangVariable immutable() {
                return this;
            }

            public String toString() {
                return "ImmutableMolangVariable[value=" + getValue() + "]";
            }
        };
    }

    /* JADX INFO: renamed from: of */
    static MolangVariable m8004of(final Supplier<Float> getter, final Consumer<Float> setter) {
        return new MolangVariable() { // from class: gg.moonflower.molangcompiler.api.bridge.MolangVariable.2
            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public float getValue() {
                return ((Float) getter.get()).floatValue();
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public void setValue(float value) {
                setter.accept(Float.valueOf(value));
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public MolangVariable copy() {
                return this;
            }

            public String toString() {
                return "DynamicMolangVariable[value=" + getValue() + "]";
            }
        };
    }

    static MolangVariable create() {
        return create(0.0f);
    }

    static MolangVariable create(final float initialValue) {
        final float[] value = {initialValue};
        return new MolangVariable() { // from class: gg.moonflower.molangcompiler.api.bridge.MolangVariable.3
            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public float getValue() {
                return value[0];
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public void setValue(float v) {
                value[0] = v;
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
            public MolangVariable copy() {
                return MolangVariable.create(initialValue);
            }

            public String toString() {
                return "MolangVariable[value=" + getValue() + "]";
            }
        };
    }
}
