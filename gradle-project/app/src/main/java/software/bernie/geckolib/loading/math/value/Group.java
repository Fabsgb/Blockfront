package software.bernie.geckolib.loading.math.value;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/value/Group.class */
public final class Group extends Record implements MathValue {
    private final MathValue contents;

    public Group(MathValue contents) {
        this.contents = contents;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Group.class), Group.class, "contents", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Group;->contents:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Group.class, Object.class), Group.class, "contents", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Group;->contents:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MathValue contents() {
        return this.contents;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        return this.contents.get();
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public boolean isMutable() {
        return this.contents.isMutable();
    }

    @Override // java.lang.Record
    public String toString() {
        return "(" + this.contents.toString() + ")";
    }
}
