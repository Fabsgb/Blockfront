package foundry.veil.api.flare.modifier;

import foundry.veil.api.flare.EffectHost;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/modifier/HostBoundController.class */
public class HostBoundController implements Controller {
    private final String name;
    private final String hostName;
    protected final EffectHost host;
    protected float value;

    public HostBoundController(String name, EffectHost host) {
        this.name = name;
        this.hostName = host.getName();
        this.host = host;
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public void initialize() {
        update(0.0f);
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public void update(float partialTick) {
        this.host.update(partialTick);
        this.value = getUpdatedValue();
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public float getUpdatedValue() {
        return this.host.getValue(this.name);
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public float getValue() {
        return this.value;
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public String getName() {
        return this.name;
    }

    public String getHost() {
        return this.hostName;
    }
}
