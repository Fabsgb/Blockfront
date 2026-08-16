package foundry.veil.api.flare.data.model;

import com.mojang.serialization.Codec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/data/model/ShellElementFace.class */
public final class ShellElementFace extends Record {

    /* JADX INFO: renamed from: uv */
    private final ShellFaceUV f9144uv;
    public static final Codec<ShellElementFace> CODEC = ShellFaceUV.CODEC.xmap(ShellElementFace::new, (v0) -> {
        return v0.m8342uv();
    });
    public static final Codec<Map<Direction, ShellElementFace>> FULL_CODEC = Codec.simpleMap(Direction.CODEC, CODEC, StringRepresentable.keys(Direction.values())).codec();

    public ShellElementFace(ShellFaceUV uv) {
        this.f9144uv = uv;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShellElementFace.class), ShellElementFace.class, "uv", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementFace;->uv:Lfoundry/veil/api/flare/data/model/ShellFaceUV;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShellElementFace.class), ShellElementFace.class, "uv", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementFace;->uv:Lfoundry/veil/api/flare/data/model/ShellFaceUV;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShellElementFace.class, Object.class), ShellElementFace.class, "uv", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementFace;->uv:Lfoundry/veil/api/flare/data/model/ShellFaceUV;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: uv */
    public ShellFaceUV m8342uv() {
        return this.f9144uv;
    }
}
