package foundry.veil.api.flare.modifier;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/modifier/GlobalController.class */
public abstract class GlobalController implements Controller {
    private final String name;

    public GlobalController(String name) {
        this.name = "global::" + name;
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public void update(float partialTick) {
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public float getValue() {
        return getUpdatedValue();
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public String getName() {
        return this.name;
    }
}
