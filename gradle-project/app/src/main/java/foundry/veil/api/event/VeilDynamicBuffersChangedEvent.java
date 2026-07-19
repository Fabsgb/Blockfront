package foundry.veil.api.event;

import foundry.veil.api.client.render.dynamicbuffer.DynamicBuffersChange;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilDynamicBuffersChangedEvent.class */
@FunctionalInterface
public interface VeilDynamicBuffersChangedEvent {
    void onVeilDynamicBuffersChanged(DynamicBuffersChange dynamicBuffersChange);
}
