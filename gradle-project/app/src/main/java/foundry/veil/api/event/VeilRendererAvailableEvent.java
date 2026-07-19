package foundry.veil.api.event;

import foundry.veil.api.client.render.VeilRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilRendererAvailableEvent.class */
@FunctionalInterface
public interface VeilRendererAvailableEvent {
    void onVeilRendererAvailable(VeilRenderer veilRenderer);
}
