package foundry.veil.impl.client.editor;

import foundry.veil.api.client.editor.Inspector;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.profiler.RenderProfilerCounter;
import foundry.veil.impl.client.render.profiler.VeilRenderProfilerImpl;
import imgui.ImGui;
import imgui.extension.implot.ImPlot;
import imgui.type.ImBoolean;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/PipelineStatisticsViewer.class */
@ApiStatus.Internal
public class PipelineStatisticsViewer implements Inspector {
    public static final Component TITLE = Component.translatable("inspector.veil.pipeline_statistics.title");
    public static final int HISTORY_LENGTH = 200;
    private final ImBoolean open = new ImBoolean();
    private final Set<String> enabledPaths = new HashSet();
    private final ObjectList<Map<String, VeilRenderProfilerImpl.ResultField>> history = new ObjectArrayList(200);
    private int historyIndex = 0;

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return INFO_GROUP;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public boolean isEnabled() {
        return VeilRenderSystem.pipelineStatisticsQuerySupported();
    }

    private void renderComponents() {
        if (!VeilRenderSystem.pipelineStatisticsQuerySupported()) {
            return;
        }
        while (this.history.size() < 200) {
            this.history.add(new Object2ObjectOpenHashMap());
        }
        VeilRenderProfilerImpl.setEnabled(this.enabledPaths, RenderProfilerCounter.ALL);
        this.enabledPaths.clear();
        renderCounters("", RenderProfilerCounter.FRAGMENT_SHADER_INVOCATIONS);
        this.historyIndex++;
        this.historyIndex %= 200;
        getHistory(0).clear();
    }

    private Map<String, VeilRenderProfilerImpl.ResultField> getHistory(int past) {
        return (Map) this.history.get(Math.floorMod(this.historyIndex - past, 200));
    }

    private void renderCounters(String path, RenderProfilerCounter sortedStatistic) {
        List<VeilRenderProfilerImpl.ResultField> fields = VeilRenderProfilerImpl.getCounters(path, sortedStatistic);
        Map<String, VeilRenderProfilerImpl.ResultField> map = (Map) this.history.get(this.historyIndex);
        for (VeilRenderProfilerImpl.ResultField field : fields) {
            String label = path.isBlank() ? field.name() : path.replace("\u001e", ".") + "." + field.name();
            if (ImGui.collapsingHeader(field.name())) {
                ImGui.pushID(label);
                ImGui.indent();
                map.put(label, field);
                if (ImGui.collapsingHeader("Plot")) {
                    this.enabledPaths.add(path.isBlank() ? field.name() : path + "\u001e" + field.name());
                    RenderProfilerCounter[] statistics = field.statistics();
                    long[] values = new long[200];
                    for (RenderProfilerCounter statistic : statistics) {
                        if (ImPlot.beginPlot(statistic.name(), ImGui.getContentRegionAvailX(), 150.0f, 70)) {
                            long max = 0;
                            for (int j = 0; j < 200; j++) {
                                VeilRenderProfilerImpl.ResultField past = getHistory((200 - j) - 1).get(label);
                                if (past != null) {
                                    long value = past.count()[statistic.ordinal()];
                                    values[j] = value;
                                    if (value > max) {
                                        max = value;
                                    }
                                }
                            }
                            ImPlot.setupAxis(0, 12);
                            ImPlot.setupAxis(3, 4);
                            ImPlot.setupAxesLimits(0.0d, 200.0d, 0.0d, Math.max(max * 1.1d, 10.0d), 1);
                            ImPlot.setupAxisFormat(3, "%3.0f");
                            ImPlot.pushStyleColor(0, VeilImGuiUtil.colorOf(statistic.name()));
                            ImPlot.pushStyleVar(17, 0.0f, 0.0f);
                            ImPlot.pushStyleVar(18, 0.0f, 0.0f);
                            ImPlot.plotLine(statistic.name(), values);
                            ImPlot.popStyleVar();
                            ImPlot.popStyleColor();
                            ImPlot.endPlot();
                        }
                    }
                    ImGui.newLine();
                }
                renderCounters(label, sortedStatistic);
                ImGui.unindent();
                ImGui.popID();
            }
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void render() {
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void renderLast() {
        ImGui.setNextWindowSizeConstraints(400.0f, 460.0f, Float.MAX_VALUE, Float.MAX_VALUE);
        if (ImGui.begin(getDisplayName().getString(), this.open)) {
            renderComponents();
        }
        ImGui.end();
        if (!this.open.get()) {
            VeilRenderSystem.renderer().getEditorManager().hide(this);
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void onShow() {
        this.open.set(true);
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void onHide() {
        super.onHide();
        this.history.clear();
        this.historyIndex = 0;
    }
}
