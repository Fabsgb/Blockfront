package foundry.veil.api.flare.model;

import foundry.veil.api.flare.data.model.ShellElement;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/model/UnbakedShell.class */
public interface UnbakedShell {
    @Contract("->new")
    @Nullable
    BakedShell bake();

    @Contract("->new")
    List<ShellElement> elements();
}
