package foundry.veil.api.client.render.light;

import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/light/IndirectLightData.class */
public interface IndirectLightData extends InstancedLightData {
    Vector3dc getPosition();

    float getRadius();
}
