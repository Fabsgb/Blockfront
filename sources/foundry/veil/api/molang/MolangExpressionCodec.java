package foundry.veil.api.molang;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.api.object.MolangObject;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/molang/MolangExpressionCodec.class */
public final class MolangExpressionCodec {
    public static final Codec<MolangExpression> CODEC = new Impl();

    private MolangExpressionCodec() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/molang/MolangExpressionCodec$Impl.class */
    private static class Impl implements Codec<MolangExpression> {
        private static final MolangEnvironment ENCODE_ENVIRONMENT = new EncodeEnvironment();

        private Impl() {
        }

        public /* bridge */ /* synthetic */ DataResult encode(Object obj, DynamicOps dynamicOps, Object obj2) {
            return encode((MolangExpression) obj, (DynamicOps<Object>) dynamicOps, obj2);
        }

        public <T> DataResult<T> encode(MolangExpression input, DynamicOps<T> ops, T prefix) {
            try {
                return DataResult.success(ops.createFloat(ENCODE_ENVIRONMENT.resolve(input)));
            } catch (MolangException e) {
                return DataResult.success(ops.createString(input.toString()));
            }
        }

        public <T> DataResult<Pair<MolangExpression, T>> decode(DynamicOps<T> ops, T input) {
            DataResult<Number> numberValue = ops.getNumberValue(input);
            if (numberValue.result().isPresent()) {
                return DataResult.success(Pair.of(MolangExpression.m7998of(((Number) numberValue.result().get()).floatValue()), input));
            }
            DataResult<Boolean> booleanValue = ops.getBooleanValue(input);
            if (booleanValue.result().isPresent()) {
                return DataResult.success(Pair.of(MolangExpression.m7999of(((Boolean) booleanValue.result().get()).booleanValue()), input));
            }
            DataResult<String> stringValue = ops.getStringValue(input);
            if (stringValue.result().isPresent()) {
                try {
                    return DataResult.success(Pair.of(VeilMolang.get().compile((String) stringValue.result().get()), input));
                } catch (Exception e) {
                    Objects.requireNonNull(e);
                    return DataResult.error(e::getMessage);
                }
            }
            return DataResult.error(() -> {
                return "Not a number, boolean, or string: " + String.valueOf(input);
            });
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/molang/MolangExpressionCodec$EncodeEnvironment.class */
    private static class EncodeEnvironment implements MolangEnvironment {
        private EncodeEnvironment() {
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public void loadLibrary(String name, MolangObject object, String... aliases) {
            throw new UnsupportedOperationException("Invalid Call");
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public void loadAlias(String name, String first, String... aliases) throws IllegalArgumentException {
            throw new UnsupportedOperationException("Invalid Call");
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public void loadParameter(float value) throws MolangRuntimeException {
            throw new MolangRuntimeException("Invalid Call");
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public void clearParameters() {
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public float getThis() {
            return 0.0f;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public MolangObject get(String name) throws MolangRuntimeException {
            throw new MolangRuntimeException("Invalid Call");
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public float getParameter(int parameter) throws MolangRuntimeException {
            throw new MolangRuntimeException("Invalid Call");
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public int getParameters() {
            return 0;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public Collection<String> getObjects() {
            return null;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public void setThisValue(float thisValue) {
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public boolean canEdit() {
            return false;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
        public MolangEnvironmentBuilder<? extends MolangEnvironment> edit() throws IllegalStateException {
            throw new IllegalStateException("Immutable MoLang environments cannot be edited");
        }
    }
}
