package foundry.veil.api.flare;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/EffectHost.class */
public interface EffectHost extends AutoCloseable {
    float getValue(String str);

    String getName();

    void update(float f);

    @Override // java.lang.AutoCloseable
    default void close() {
        FlareEffectManager.getInstance().getControllerManager().removeHost(getName());
    }
}
