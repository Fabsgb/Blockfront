package foundry.veil.api.molang;

import gg.moonflower.molangcompiler.api.GlobalMolangCompiler;
import gg.moonflower.molangcompiler.api.MolangCompiler;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/molang/VeilMolang.class */
public final class VeilMolang {
    private static MolangCompiler compiler = input -> {
        return GlobalMolangCompiler.get().compile(input);
    };

    public static MolangCompiler get() {
        return compiler;
    }

    @ApiStatus.Internal
    public static void set(MolangCompiler compiler2) {
        compiler = compiler2;
    }
}
