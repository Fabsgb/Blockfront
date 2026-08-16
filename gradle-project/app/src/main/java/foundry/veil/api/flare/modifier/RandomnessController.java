package foundry.veil.api.flare.modifier;

import net.minecraft.util.RandomSource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/modifier/RandomnessController.class */
public class RandomnessController extends GlobalController {
    public static final RandomnessController INSTANCE = new RandomnessController("random");
    private final RandomSource randomSource;

    private RandomnessController(String name) {
        super(name);
        this.randomSource = RandomSource.create(10840L);
    }

    @Override // foundry.veil.api.flare.modifier.Controller
    public float getUpdatedValue() {
        return this.randomSource.nextFloat();
    }
}
