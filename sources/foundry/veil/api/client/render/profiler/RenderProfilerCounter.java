package foundry.veil.api.client.render.profiler;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/profiler/RenderProfilerCounter.class */
public enum RenderProfilerCounter {
    VERTICES_SUBMITTED(33518),
    PRIMITIVES_SUBMITTED(33519),
    VERTEX_SHADER_INVOCATIONS(33520),
    TESS_CONTROL_SHADER_PATCHES(33521),
    TESS_EVALUATION_SHADER_INVOCATIONS(33522),
    GEOMETRY_SHADER_INVOCATIONS(34943),
    GEOMETRY_SHADER_PRIMITIVES_EMITTED(33523),
    FRAGMENT_SHADER_INVOCATIONS(33524),
    COMPUTE_SHADER_INVOCATIONS(33525),
    CLIPPING_INPUT_PRIMITIVES(33526),
    CLIPPING_OUTPUT_PRIMITIVES(33527);


    /* JADX INFO: renamed from: id */
    private final int f8749id;
    public static final RenderProfilerCounter[] ALL = values();
    public static final RenderProfilerCounter[] STANDARD_GEOMETRY = {VERTICES_SUBMITTED, PRIMITIVES_SUBMITTED, VERTEX_SHADER_INVOCATIONS, FRAGMENT_SHADER_INVOCATIONS, CLIPPING_INPUT_PRIMITIVES, CLIPPING_OUTPUT_PRIMITIVES};

    RenderProfilerCounter(int id) {
        this.f8749id = id;
    }

    public int getId() {
        return this.f8749id;
    }
}
