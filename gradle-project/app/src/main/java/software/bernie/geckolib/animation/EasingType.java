package software.bernie.geckolib.animation;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.keyframe.AnimationPoint;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/EasingType.class */
@FunctionalInterface
public interface EasingType {
    public static final Map<String, EasingType> EASING_TYPES = new ConcurrentHashMap(64);
    public static final EasingType LINEAR = register("linear", register("none", value -> {
        return easeIn(EasingType::linear);
    }));
    public static final EasingType STEP = register("step", value -> {
        return easeIn(step(value));
    });
    public static final EasingType EASE_IN_SINE = register("easeinsine", value -> {
        return easeIn(EasingType::sine);
    });
    public static final EasingType EASE_OUT_SINE = register("easeoutsine", value -> {
        return easeOut(EasingType::sine);
    });
    public static final EasingType EASE_IN_OUT_SINE = register("easeinoutsine", value -> {
        return easeInOut(EasingType::sine);
    });
    public static final EasingType EASE_IN_QUAD = register("easeinquad", value -> {
        return easeIn(EasingType::quadratic);
    });
    public static final EasingType EASE_OUT_QUAD = register("easeoutquad", value -> {
        return easeOut(EasingType::quadratic);
    });
    public static final EasingType EASE_IN_OUT_QUAD = register("easeinoutquad", value -> {
        return easeInOut(EasingType::quadratic);
    });
    public static final EasingType EASE_IN_CUBIC = register("easeincubic", value -> {
        return easeIn(EasingType::cubic);
    });
    public static final EasingType EASE_OUT_CUBIC = register("easeoutcubic", value -> {
        return easeOut(EasingType::cubic);
    });
    public static final EasingType EASE_IN_OUT_CUBIC = register("easeinoutcubic", value -> {
        return easeInOut(EasingType::cubic);
    });
    public static final EasingType EASE_IN_QUART = register("easeinquart", value -> {
        return easeIn(pow(4.0d));
    });
    public static final EasingType EASE_OUT_QUART = register("easeoutquart", value -> {
        return easeOut(pow(4.0d));
    });
    public static final EasingType EASE_IN_OUT_QUART = register("easeinoutquart", value -> {
        return easeInOut(pow(4.0d));
    });
    public static final EasingType EASE_IN_QUINT = register("easeinquint", value -> {
        return easeIn(pow(4.0d));
    });
    public static final EasingType EASE_OUT_QUINT = register("easeoutquint", value -> {
        return easeOut(pow(5.0d));
    });
    public static final EasingType EASE_IN_OUT_QUINT = register("easeinoutquint", value -> {
        return easeInOut(pow(5.0d));
    });
    public static final EasingType EASE_IN_EXPO = register("easeinexpo", value -> {
        return easeIn(EasingType::exp);
    });
    public static final EasingType EASE_OUT_EXPO = register("easeoutexpo", value -> {
        return easeOut(EasingType::exp);
    });
    public static final EasingType EASE_IN_OUT_EXPO = register("easeinoutexpo", value -> {
        return easeInOut(EasingType::exp);
    });
    public static final EasingType EASE_IN_CIRC = register("easeincirc", value -> {
        return easeIn(EasingType::circle);
    });
    public static final EasingType EASE_OUT_CIRC = register("easeoutcirc", value -> {
        return easeOut(EasingType::circle);
    });
    public static final EasingType EASE_IN_OUT_CIRC = register("easeinoutcirc", value -> {
        return easeInOut(EasingType::circle);
    });
    public static final EasingType EASE_IN_BACK = register("easeinback", value -> {
        return easeIn(back(value));
    });
    public static final EasingType EASE_OUT_BACK = register("easeoutback", value -> {
        return easeOut(back(value));
    });
    public static final EasingType EASE_IN_OUT_BACK = register("easeinoutback", value -> {
        return easeInOut(back(value));
    });
    public static final EasingType EASE_IN_ELASTIC = register("easeinelastic", value -> {
        return easeIn(elastic(value));
    });
    public static final EasingType EASE_OUT_ELASTIC = register("easeoutelastic", value -> {
        return easeOut(elastic(value));
    });
    public static final EasingType EASE_IN_OUT_ELASTIC = register("easeinoutelastic", value -> {
        return easeInOut(elastic(value));
    });
    public static final EasingType EASE_IN_BOUNCE = register("easeinbounce", value -> {
        return easeIn(bounce(value));
    });
    public static final EasingType EASE_OUT_BOUNCE = register("easeoutbounce", value -> {
        return easeOut(bounce(value));
    });
    public static final EasingType EASE_IN_OUT_BOUNCE = register("easeinoutbounce", value -> {
        return easeInOut(bounce(value));
    });
    public static final EasingType CATMULLROM = register("catmullrom", value -> {
        return easeInOut(EasingType::catmullRom);
    });

    Double2DoubleFunction buildTransformer(Double d);

    static double lerpWithOverride(AnimationPoint animationPoint, EasingType override) {
        EasingType easingType = override;
        if (override == null) {
            easingType = animationPoint.keyFrame() == null ? LINEAR : animationPoint.keyFrame().easingType();
        }
        return easingType.apply(animationPoint);
    }

    default double apply(AnimationPoint animationPoint) {
        Double easingVariable = null;
        if (animationPoint.keyFrame() != null && animationPoint.keyFrame().easingArgs().size() > 0) {
            easingVariable = Double.valueOf(((MathValue) animationPoint.keyFrame().easingArgs().get(0)).get());
        }
        return apply(animationPoint, easingVariable, animationPoint.currentTick() / animationPoint.transitionLength());
    }

    default double apply(AnimationPoint animationPoint, Double easingValue, double lerpValue) {
        if (animationPoint.currentTick() >= animationPoint.transitionLength()) {
            return (float) animationPoint.animationEndValue();
        }
        return Mth.lerp(((Double) buildTransformer(easingValue).apply(Double.valueOf(lerpValue))).doubleValue(), animationPoint.animationStartValue(), animationPoint.animationEndValue());
    }

    static EasingType register(String name, EasingType easingType) {
        EASING_TYPES.putIfAbsent(name, easingType);
        return easingType;
    }

    static EasingType fromJson(JsonElement json) {
        if (json instanceof JsonPrimitive) {
            JsonPrimitive primitive = (JsonPrimitive) json;
            if (primitive.isString()) {
                return fromString(primitive.getAsString().toLowerCase(Locale.ROOT));
            }
        }
        return LINEAR;
    }

    static EasingType fromString(String name) {
        return EASING_TYPES.getOrDefault(name, LINEAR);
    }

    static Double2DoubleFunction linear(Double2DoubleFunction function) {
        return function;
    }

    static double catmullRom(double n) {
        return 0.5d * ((2.0d * (n + 1.0d)) + (((n + 2.0d) - n) * 1.0d) + (((((2.0d * n) - (5.0d * (n + 1.0d))) + (4.0d * (n + 2.0d))) - (n + 3.0d)) * 1.0d) + (((((3.0d * (n + 1.0d)) - n) - (3.0d * (n + 2.0d))) + n + 3.0d) * 1.0d));
    }

    static Double2DoubleFunction easeIn(Double2DoubleFunction function) {
        return function;
    }

    static Double2DoubleFunction easeOut(Double2DoubleFunction function) {
        return time -> {
            return 1.0d - ((Double) function.apply(Double.valueOf(1.0d - time))).doubleValue();
        };
    }

    static Double2DoubleFunction easeInOut(Double2DoubleFunction function) {
        return time -> {
            if (time < 0.5d) {
                return ((Double) function.apply(Double.valueOf(time * 2.0d))).doubleValue() / 2.0d;
            }
            return 1.0d - (((Double) function.apply(Double.valueOf((1.0d - time) * 2.0d))).doubleValue() / 2.0d);
        };
    }

    static Double2DoubleFunction stepPositive(Double2DoubleFunction function) {
        return n -> {
            return n > 0.0d ? 1.0d : 0.0d;
        };
    }

    static Double2DoubleFunction stepNonNegative(Double2DoubleFunction function) {
        return n -> {
            return n >= 0.0d ? 1.0d : 0.0d;
        };
    }

    static double linear(double n) {
        return n;
    }

    static double quadratic(double n) {
        return n * n;
    }

    static double cubic(double n) {
        return n * n * n;
    }

    static double sine(double n) {
        return 1.0d - Math.cos((n * 3.141592653589793d) / 2.0d);
    }

    static double circle(double n) {
        return 1.0d - Math.sqrt(1.0d - (n * n));
    }

    static double exp(double n) {
        return Math.pow(2.0d, 10.0d * (n - 1.0d));
    }

    static Double2DoubleFunction elastic(Double n) {
        double n2 = n == null ? 1.0d : n.doubleValue();
        return t -> {
            return 1.0d - (Math.pow(Math.cos((t * 3.141592653589793d) / 2.0d), 3.0d) * Math.cos((t * n2) * 3.141592653589793d));
        };
    }

    static Double2DoubleFunction bounce(Double n) {
        double n2 = n == null ? 0.5d : n.doubleValue();
        Double2DoubleFunction one = x -> {
            return 7.5625d * x * x;
        };
        Double2DoubleFunction two = x2 -> {
            return (((30.25d * n2) * Math.pow(x2 - 0.5454545617103577d, 2.0d)) + 1.0d) - n2;
        };
        Double2DoubleFunction three = x3 -> {
            return ((((121.0d * n2) * n2) * Math.pow(x3 - 0.8181818127632141d, 2.0d)) + 1.0d) - (n2 * n2);
        };
        Double2DoubleFunction four = x4 -> {
            return (((((484.0d * n2) * n2) * n2) * Math.pow(x4 - 0.9545454382896423d, 2.0d)) + 1.0d) - ((n2 * n2) * n2);
        };
        return t -> {
            return Math.min(Math.min(((Double) one.apply(Double.valueOf(t))).doubleValue(), ((Double) two.apply(Double.valueOf(t))).doubleValue()), Math.min(((Double) three.apply(Double.valueOf(t))).doubleValue(), ((Double) four.apply(Double.valueOf(t))).doubleValue()));
        };
    }

    static Double2DoubleFunction back(Double n) {
        double n2 = n == null ? 1.70158d : n.doubleValue() * 1.70158d;
        return t -> {
            return t * t * (((n2 + 1.0d) * t) - n2);
        };
    }

    static Double2DoubleFunction pow(double n) {
        return t -> {
            return Math.pow(t, n);
        };
    }

    static Double2DoubleFunction step(Double n) {
        double n2 = n == null ? 2.0d : n.doubleValue();
        if (n2 < 2.0d) {
            throw new IllegalArgumentException("Steps must be >= 2, got: " + n2);
        }
        int steps = (int) n2;
        return t -> {
            if (t < 0.0d) {
                return 0.0d;
            }
            double stepLength = 1.0d / ((double) steps);
            if (t > ((double) (steps - 1)) * stepLength) {
                return t;
            }
            int leftBorderIndex = 0;
            int rightBorderIndex = steps - 1;
            while (rightBorderIndex - leftBorderIndex != 1) {
                int testIndex = leftBorderIndex + ((rightBorderIndex - leftBorderIndex) / 2);
                if (t >= ((double) testIndex) * stepLength) {
                    leftBorderIndex = testIndex;
                } else {
                    rightBorderIndex = testIndex;
                }
            }
            return ((double) leftBorderIndex) * stepLength;
        };
    }
}
