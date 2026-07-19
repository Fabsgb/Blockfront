package foundry.veil.api.flare.modifier;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/modifier/Controller.class */
public interface Controller {
    void update(float f);

    float getUpdatedValue();

    float getValue();

    String getName();

    default void initialize() {
    }
}
