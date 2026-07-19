package foundry.veil.api.client.render.shader;

import io.github.ocelot.glslprocessor.api.node.GlslTree;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderModificationManager.class */
@ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
@Deprecated(forRemoval = true)
public class ShaderModificationManager extends SimplePreparableReloadListener<Preparations> {
    public void applyModifiers(ResourceLocation shaderId, GlslTree tree, int flags) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: prepare, reason: merged with bridge method [inline-methods] */
    public Preparations m1827prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        return new Preparations();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apply(@NotNull Preparations preparations, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderModificationManager$Preparations.class */
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @ApiStatus.Internal
    @Deprecated(forRemoval = true)
    public static final class Preparations extends Record {
        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Preparations.class), Preparations.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Preparations.class), Preparations.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Preparations.class, Object.class), Preparations.class, "").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }
    }
}
