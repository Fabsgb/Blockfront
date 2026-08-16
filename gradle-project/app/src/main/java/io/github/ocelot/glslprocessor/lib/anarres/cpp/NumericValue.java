package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/NumericValue.class */
@ApiStatus.Internal
public class NumericValue extends Number {
    public static final int F_UNSIGNED = 1;
    public static final int F_INT = 2;
    public static final int F_LONG = 4;
    public static final int F_LONGLONG = 8;
    public static final int F_FLOAT = 16;
    public static final int F_DOUBLE = 32;
    public static final int FF_SIZE = 62;
    private final int base;
    private final String integer;
    private String fraction;
    private int expbase = 0;
    private String exponent;

    public NumericValue(int base, @NotNull String integer) {
        this.base = base;
        this.integer = integer;
    }

    public int getBase() {
        return this.base;
    }

    @NotNull
    public String getIntegerPart() {
        return this.integer;
    }

    @Nullable
    public String getFractionalPart() {
        return this.fraction;
    }

    void setFractionalPart(@NotNull String fraction) {
        this.fraction = fraction;
    }

    @Nullable
    public String getExponent() {
        return this.exponent;
    }

    void setExponent(int expbase, @NotNull String exponent) {
        this.expbase = expbase;
        this.exponent = exponent;
    }

    private int exponentValue() {
        return Integer.parseInt(this.exponent, 10);
    }

    @Override // java.lang.Number
    public int intValue() {
        int v = this.integer.isEmpty() ? 0 : Integer.parseInt(this.integer, this.base);
        if (this.expbase == 2) {
            v <<= exponentValue();
        } else if (this.expbase != 0) {
            v = (int) (((double) v) * Math.pow(this.expbase, exponentValue()));
        }
        return v;
    }

    @Override // java.lang.Number
    public long longValue() {
        long v = this.integer.isEmpty() ? 0L : Long.parseLong(this.integer, this.base);
        if (this.expbase == 2) {
            v <<= exponentValue();
        } else if (this.expbase != 0) {
            v = (long) (v * Math.pow(this.expbase, exponentValue()));
        }
        return v;
    }

    @Override // java.lang.Number
    public float floatValue() {
        if (getBase() != 10) {
            return longValue();
        }
        return Float.parseFloat(toString());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        if (getBase() != 10) {
            return longValue();
        }
        return Double.parseDouble(toString());
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        switch (this.base) {
            case 2:
                buf.append('b');
                break;
            case 8:
                buf.append('0');
                break;
            case 10:
                break;
            case 16:
                buf.append("0x");
                break;
            default:
                buf.append("[base-").append(this.base).append("]");
                break;
        }
        buf.append(getIntegerPart());
        if (getFractionalPart() != null) {
            buf.append('.').append(getFractionalPart());
        }
        if (getExponent() != null) {
            buf.append(this.base > 10 ? 'p' : 'e');
            buf.append(getExponent());
        }
        return buf.toString();
    }
}
