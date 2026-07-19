package foundry.veil.api.client.util;

import foundry.veil.api.util.EnumCodec;
import net.minecraft.util.Mth;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/util/Easing.class */
public enum Easing {
    LINEAR { // from class: foundry.veil.api.client.util.Easing.1
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return x;
        }
    },
    EASE_IN_QUAD { // from class: foundry.veil.api.client.util.Easing.2
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return x * x;
        }
    },
    EASE_OUT_QUAD { // from class: foundry.veil.api.client.util.Easing.3
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return 1.0f - ((1.0f - x) * (1.0f - x));
        }
    },
    EASE_IN_OUT_QUAD { // from class: foundry.veil.api.client.util.Easing.4
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return ((double) x) < 0.5d ? 2.0f * x * x : (float) (1.0d - (Math.pow(((-2.0f) * x) + 2.0f, 2.0d) / 2.0d));
        }
    },
    EASE_IN_CUBIC { // from class: foundry.veil.api.client.util.Easing.5
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return x * x * x;
        }
    },
    EASE_OUT_CUBIC { // from class: foundry.veil.api.client.util.Easing.6
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (float) (1.0d - Math.pow(1.0f - x, 3.0d));
        }
    },
    EASE_IN_OUT_CUBIC { // from class: foundry.veil.api.client.util.Easing.7
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return ((double) x) < 0.5d ? 4.0f * x * x * x : (float) (1.0d - (Math.pow(((-2.0f) * x) + 2.0f, 3.0d) / 2.0d));
        }
    },
    EASE_IN_QUART { // from class: foundry.veil.api.client.util.Easing.8
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return x * x * x * x;
        }
    },
    EASE_OUT_QUART { // from class: foundry.veil.api.client.util.Easing.9
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (float) (1.0d - Math.pow(1.0f - x, 4.0d));
        }
    },
    EASE_IN_OUT_QUART { // from class: foundry.veil.api.client.util.Easing.10
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return ((double) x) < 0.5d ? 8.0f * x * x * x * x : (float) (1.0d - (Math.pow(((-2.0f) * x) + 2.0f, 4.0d) / 2.0d));
        }
    },
    EASE_IN_QUINT { // from class: foundry.veil.api.client.util.Easing.11
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return x * x * x * x * x;
        }
    },
    EASE_OUT_QUINT { // from class: foundry.veil.api.client.util.Easing.12
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (float) (1.0d - Math.pow(1.0f - x, 5.0d));
        }
    },
    EASE_IN_OUT_QUINT { // from class: foundry.veil.api.client.util.Easing.13
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return ((double) x) < 0.5d ? 16.0f * x * x * x * x * x : (float) (1.0d - (Math.pow(((-2.0f) * x) + 2.0f, 5.0d) / 2.0d));
        }
    },
    EASE_IN_SINE { // from class: foundry.veil.api.client.util.Easing.14
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return 1.0f - Mth.cos((float) ((((double) x) * 3.141592653589793d) / 2.0d));
        }
    },
    EASE_OUT_SINE { // from class: foundry.veil.api.client.util.Easing.15
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return Mth.sin((float) ((((double) x) * 3.141592653589793d) / 2.0d));
        }
    },
    EASE_IN_OUT_SINE { // from class: foundry.veil.api.client.util.Easing.16
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (-(Mth.cos((float) (3.141592653589793d * ((double) x))) - 1.0f)) / 2.0f;
        }
    },
    EASE_IN_EXPO { // from class: foundry.veil.api.client.util.Easing.17
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            if (x == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (10.0f * x) - 10.0f);
        }
    },
    EASE_OUT_EXPO { // from class: foundry.veil.api.client.util.Easing.18
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            if (x == 1.0f) {
                return 1.0f;
            }
            return (float) (1.0d - Math.pow(2.0d, (-10.0f) * x));
        }
    },
    EASE_IN_OUT_EXPO { // from class: foundry.veil.api.client.util.Easing.19
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            double dPow;
            if (x == 0.0f) {
                return 0.0f;
            }
            if (x == 1.0f) {
                dPow = 1.0d;
            } else if (x < 0.5d) {
                dPow = Math.pow(2.0d, (20.0f * x) - 10.0f) / 2.0d;
            } else {
                dPow = (2.0d - Math.pow(2.0d, ((-20.0f) * x) + 10.0f)) / 2.0d;
            }
            return (float) dPow;
        }
    },
    EASE_IN_CIRC { // from class: foundry.veil.api.client.util.Easing.20
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (float) (1.0d - Math.sqrt(1.0d - Math.pow(x, 2.0d)));
        }
    },
    EASE_OUT_CIRC { // from class: foundry.veil.api.client.util.Easing.21
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (float) Math.sqrt(1.0d - Math.pow(x - 1.0f, 2.0d));
        }
    },
    EASE_IN_OUT_CIRC { // from class: foundry.veil.api.client.util.Easing.22
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (float) (((double) x) < 0.5d ? (1.0d - Math.sqrt(1.0d - Math.pow(2.0f * x, 2.0d))) / 2.0d : (Math.sqrt(1.0d - Math.pow(((-2.0f) * x) + 2.0f, 2.0d)) + 1.0d) / 2.0d);
        }
    },
    EASE_IN_BACK { // from class: foundry.veil.api.client.util.Easing.23
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (((2.70158f * x) * x) * x) - ((1.70158f * x) * x);
        }
    },
    EASE_OUT_BACK { // from class: foundry.veil.api.client.util.Easing.24
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return (float) (1.0d + (2.701580047607422d * Math.pow(x - 1.0f, 3.0d)) + (1.7015800476074219d * Math.pow(x - 1.0f, 2.0d)));
        }
    },
    EASE_IN_OUT_BACK { // from class: foundry.veil.api.client.util.Easing.25
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            double dPow;
            if (x < 0.5d) {
                dPow = (Math.pow(2.0f * x, 2.0d) * ((double) ((7.189819f * x) - 2.5949094f))) / 2.0d;
            } else {
                dPow = ((Math.pow((2.0f * x) - 2.0f, 2.0d) * ((double) ((3.5949094f * ((x * 2.0f) - 2.0f)) + 2.5949094f))) + 2.0d) / 2.0d;
            }
            return (float) dPow;
        }
    },
    EASE_IN_ELASTIC { // from class: foundry.veil.api.client.util.Easing.26
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            double dSin;
            if (x == 0.0f) {
                return 0.0f;
            }
            if (x == 1.0f) {
                dSin = 1.0d;
            } else {
                dSin = (-Math.pow(2.0d, (10.0f * x) - 10.0f)) * ((double) Mth.sin((float) ((((double) (x * 10.0f)) - 10.75d) * 2.0943951023931953d)));
            }
            return (float) dSin;
        }
    },
    EASE_OUT_ELASTIC { // from class: foundry.veil.api.client.util.Easing.27
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            double dPow;
            if (x == 0.0f) {
                return 0.0f;
            }
            if (x == 1.0f) {
                dPow = 1.0d;
            } else {
                dPow = (Math.pow(2.0d, (-10.0f) * x) * ((double) Mth.sin((float) ((((double) (x * 10.0f)) - 0.75d) * 2.0943951023931953d)))) + 1.0d;
            }
            return (float) dPow;
        }
    },
    EASE_IN_OUT_ELASTIC { // from class: foundry.veil.api.client.util.Easing.28
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            double dPow;
            if (x == 0.0f) {
                return 0.0f;
            }
            if (x == 1.0f) {
                dPow = 1.0d;
            } else if (x < 0.5d) {
                dPow = (-(Math.pow(2.0d, (20.0f * x) - 10.0f) * ((double) Mth.sin((float) ((((double) (20.0f * x)) - 11.125d) * 1.3962634015954636d))))) / 2.0d;
            } else {
                dPow = ((Math.pow(2.0d, ((-20.0f) * x) + 10.0f) * ((double) Mth.sin((float) ((((double) (20.0f * x)) - 11.125d) * 1.3962634015954636d)))) / 2.0d) + 1.0d;
            }
            return (float) dPow;
        }
    },
    EASE_IN_BOUNCE { // from class: foundry.veil.api.client.util.Easing.29
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return 1.0f - Easing.bounceOut(1.0f - x);
        }
    },
    EASE_OUT_BOUNCE { // from class: foundry.veil.api.client.util.Easing.30
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return 1.0f - Easing.bounceOut(1.0f - x);
        }
    },
    EASE_IN_OUT_BOUNCE { // from class: foundry.veil.api.client.util.Easing.31
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            if (x < 0.5d) {
                return (1.0f - Easing.bounceOut(1.0f - (2.0f * x))) / 2.0f;
            }
            return (1.0f + Easing.bounceOut((2.0f * x) - 1.0f)) / 2.0f;
        }
    },
    EASE_OUT_IN_QUAD { // from class: foundry.veil.api.client.util.Easing.32
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return ((double) x) < 0.5d ? 1.0f - Mth.square(x - 1.0f) : 1.0f + Mth.square(x - 1.0f);
        }
    },
    EASE_OUT_IN_CUBIC { // from class: foundry.veil.api.client.util.Easing.33
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return 1.0f - ((float) Math.pow(x - 1.0f, 3.0d));
        }
    },
    EASE_OUT_IN_QUART { // from class: foundry.veil.api.client.util.Easing.34
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return ((double) x) < 0.5d ? 1.0f - ((float) Math.pow(x - 1.0f, 4.0d)) : 1.0f + ((float) Math.pow(x - 1.0f, 4.0d));
        }
    },
    EASE_OUT_IN_QUINT { // from class: foundry.veil.api.client.util.Easing.35
        @Override // foundry.veil.api.client.util.Easing
        public float ease(float x) {
            return 1.0f - ((float) Math.pow(x - 1.0f, 5.0d));
        }
    };

    public static final EnumCodec<Easing> CODEC = EnumCodec.builder("Easing").values(Easing.class).build();

    public abstract float ease(float f);

    private static float bounceOut(float x) {
        if (x < 1.0f / 2.75f) {
            return 7.5625f * x * x;
        }
        if (x < 2.0f / 2.75f) {
            float x2 = x - (1.5f / 2.75f);
            return (7.5625f * x2 * x2) + 0.75f;
        }
        if (x < 2.5d / ((double) 2.75f)) {
            float x3 = x - (2.25f / 2.75f);
            return (7.5625f * x3 * x3) + 0.9375f;
        }
        float x4 = x - (2.625f / 2.75f);
        return (7.5625f * x4 * x4) + 0.984375f;
    }
}
