package foundry.veil.forge.ext;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/ext/RenderSectionExtension.class */
public interface RenderSectionExtension {
    boolean veil$hasNotRendered();

    void veil$markRendered();

    void veil$addIncomingDirections(int i);
}
