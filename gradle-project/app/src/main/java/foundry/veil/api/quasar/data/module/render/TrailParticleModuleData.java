package foundry.veil.api.quasar.data.module.render;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.render.TrailParticleModule;
import foundry.veil.api.quasar.emitters.module.render.TrailSettings;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import imgui.ImGui;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/render/TrailParticleModuleData.class */
public final class TrailParticleModuleData extends Record implements ParticleModuleData, EditorAttributeProvider {
    private final List<TrailSettings> settings;
    public static final MapCodec<TrailParticleModuleData> CODEC = TrailSettings.CODEC.listOf().fieldOf("settings").xmap(TrailParticleModuleData::new, (v0) -> {
        return v0.settings();
    });

    public TrailParticleModuleData(List<TrailSettings> settings) {
        this.settings = settings;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TrailParticleModuleData.class), TrailParticleModuleData.class, "settings", "FIELD:Lfoundry/veil/api/quasar/data/module/render/TrailParticleModuleData;->settings:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TrailParticleModuleData.class), TrailParticleModuleData.class, "settings", "FIELD:Lfoundry/veil/api/quasar/data/module/render/TrailParticleModuleData;->settings:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TrailParticleModuleData.class, Object.class), TrailParticleModuleData.class, "settings", "FIELD:Lfoundry/veil/api/quasar/data/module/render/TrailParticleModuleData;->settings:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public List<TrailSettings> settings() {
        return this.settings;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new TrailParticleModule(this.settings));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.TRAIL;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        for (TrailSettings setting : this.settings) {
            ImGui.pushID(setting.hashCode());
            setting.renderImGuiAttributes();
            ImGui.popID();
        }
        if (ImGui.button("Add Trail Settings")) {
            this.settings.add(new TrailSettings());
        }
    }
}
