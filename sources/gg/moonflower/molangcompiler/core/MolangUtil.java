package gg.moonflower.molangcompiler.core;

import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.bridge.MolangVariable;
import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.api.object.MolangObject;
import gg.moonflower.molangcompiler.core.node.MolangConstantNode;
import gg.moonflower.molangcompiler.core.node.MolangVariableNode;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/MolangUtil.class */
@ApiStatus.Internal
public class MolangUtil {
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static float dieRoll(int num, float low, float high) {
        float sum = 0.0f;
        for (int i = 0; i < num; i++) {
            sum = (float) (((double) sum) + ((double) low) + (Math.random() * ((double) (high - low))));
        }
        return sum;
    }

    public static float dieRollInt(int num, int low, int high) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum = (int) (sum + random(low, high));
        }
        return sum;
    }

    public static float hermiteBlend(float value) {
        return ((3.0f * value) * value) - (((2.0f * value) * value) * value);
    }

    public static float lerp(float start, float end, float pct) {
        return start + ((end - start) * pct);
    }

    public static float lerpRotate(float start, float end, float pct) {
        return start + (wrapDegrees(end - start) * pct);
    }

    public static float wrapDegrees(float angle) {
        float wrapped = angle % 360.0f;
        if (wrapped >= 180.0f) {
            wrapped -= 360.0f;
        }
        if (wrapped < -180.0f) {
            wrapped += 360.0f;
        }
        return wrapped;
    }

    public static float random(float low, float high) {
        return (float) (((double) low) + (Math.random() * ((double) (high - low))));
    }

    public static float triangleWave(float x, float wavelength) {
        return (Math.abs((x % wavelength) - (wavelength * 0.5f)) - (wavelength * 0.25f)) / (wavelength * 0.25f);
    }

    public static MolangExpression getFunction(MolangObject object, String name, String fullKey) throws MolangException {
        if (object.has(fullKey)) {
            return object.get(fullKey);
        }
        if (object.has(name)) {
            return object.get(name);
        }
        throw new MolangException("Unknown function: " + object + "." + fullKey + "()");
    }

    public static void setValue(MolangObject object, String name, float value) throws MolangRuntimeException {
        if (!object.has(name)) {
            object.set(name, new MolangVariableNode(MolangVariable.create(value)));
            return;
        }
        MolangExpression old = object.get(name);
        if (old instanceof MolangVariable) {
            MolangVariable variable = (MolangVariable) old;
            variable.setValue(value);
        } else {
            object.set(name, new MolangConstantNode(value));
        }
    }
}
