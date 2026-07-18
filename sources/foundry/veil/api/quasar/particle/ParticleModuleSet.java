package foundry.veil.api.quasar.particle;

import foundry.veil.api.quasar.emitters.module.CollisionParticleModule;
import foundry.veil.api.quasar.emitters.module.ForceParticleModule;
import foundry.veil.api.quasar.emitters.module.InitParticleModule;
import foundry.veil.api.quasar.emitters.module.ParticleModule;
import foundry.veil.api.quasar.emitters.module.RenderParticleModule;
import foundry.veil.api.quasar.emitters.module.UpdateParticleModule;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/ParticleModuleSet.class */
public final class ParticleModuleSet {
    private final ParticleModule[] modules;
    private final InitParticleModule[] initModules;
    private final UpdateParticleModule[] updateModules;
    private final ForceParticleModule[] forceModules;
    private final CollisionParticleModule[] collisionModules;
    private final RenderParticleModule[] renderModules;
    private final RenderParticleModule[] enabledRenderModules;
    private int enabledRenderModulesSize = 0;

    private ParticleModuleSet(ParticleModule[] modules, InitParticleModule[] initModules, UpdateParticleModule[] updateModules, ForceParticleModule[] forceModules, CollisionParticleModule[] collisionModules, RenderParticleModule[] renderModules) {
        this.modules = modules;
        this.initModules = initModules;
        this.updateModules = updateModules;
        this.forceModules = forceModules;
        this.collisionModules = collisionModules;
        this.renderModules = renderModules;
        this.enabledRenderModules = new RenderParticleModule[this.renderModules.length];
    }

    public ParticleModuleSet copy() {
        return new ParticleModuleSet(this.modules, this.initModules, this.updateModules, this.forceModules, this.collisionModules, this.renderModules);
    }

    public void updateEnabled() {
        this.enabledRenderModulesSize = 0;
        for (RenderParticleModule renderModule : this.renderModules) {
            if (renderModule.isEnabled()) {
                RenderParticleModule[] renderParticleModuleArr = this.enabledRenderModules;
                int i = this.enabledRenderModulesSize;
                this.enabledRenderModulesSize = i + 1;
                renderParticleModuleArr[i] = renderModule;
            }
        }
    }

    public ParticleModule[] getAllModules() {
        return this.modules;
    }

    public InitParticleModule[] getInitModules() {
        return this.initModules;
    }

    public UpdateParticleModule[] getUpdateModules() {
        return this.updateModules;
    }

    public ForceParticleModule[] getForceModules() {
        return this.forceModules;
    }

    public CollisionParticleModule[] getCollisionModules() {
        return this.collisionModules;
    }

    public RenderParticleModule[] getRenderModules() {
        return this.renderModules;
    }

    /* JADX INFO: renamed from: foundry.veil.api.quasar.particle.ParticleModuleSet$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/ParticleModuleSet$1.class */
    class C14121 implements Iterator<RenderParticleModule> {
        private int cursor;

        C14121() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor < ParticleModuleSet.this.enabledRenderModulesSize;
        }

        @Override // java.util.Iterator
        public RenderParticleModule next() {
            RenderParticleModule[] renderParticleModuleArr = ParticleModuleSet.this.enabledRenderModules;
            int i = this.cursor;
            this.cursor = i + 1;
            return renderParticleModuleArr[i];
        }
    }

    public Iterator<RenderParticleModule> getEnabledRenderModules() {
        return new Iterator<RenderParticleModule>() { // from class: foundry.veil.api.quasar.particle.ParticleModuleSet.1
            private int cursor;

            C14121() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.cursor < ParticleModuleSet.this.enabledRenderModulesSize;
            }

            @Override // java.util.Iterator
            public RenderParticleModule next() {
                RenderParticleModule[] renderParticleModuleArr = ParticleModuleSet.this.enabledRenderModules;
                int i = this.cursor;
                this.cursor = i + 1;
                return renderParticleModuleArr[i];
            }
        };
    }

    public int getEnabledRenderModuleCount() {
        return this.enabledRenderModulesSize;
    }

    public RenderParticleModule[] getEnabledRenderModulesArray() {
        return this.enabledRenderModules;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/ParticleModuleSet$Builder.class */
    public static class Builder {
        private final Set<ParticleModule> modules = new HashSet();
        private final Set<InitParticleModule> initModules = new HashSet();
        private final Set<UpdateParticleModule> updateModules = new HashSet();
        private final Set<ForceParticleModule> forceModules = new HashSet();
        private final Set<CollisionParticleModule> collisionModules = new HashSet();
        private final Set<RenderParticleModule> renderModules = new HashSet();

        public void addModule(ParticleModule module) {
            if (!this.modules.add(module)) {
                throw new IllegalArgumentException("Duplicate module: " + String.valueOf(module.getClass()));
            }
            if (module instanceof InitParticleModule) {
                InitParticleModule initModule = (InitParticleModule) module;
                this.initModules.add(initModule);
            }
            if (module instanceof UpdateParticleModule) {
                UpdateParticleModule updateModule = (UpdateParticleModule) module;
                this.updateModules.add(updateModule);
            }
            if (module instanceof ForceParticleModule) {
                ForceParticleModule forceModule = (ForceParticleModule) module;
                this.forceModules.add(forceModule);
            }
            if (module instanceof CollisionParticleModule) {
                CollisionParticleModule collisionModule = (CollisionParticleModule) module;
                this.collisionModules.add(collisionModule);
            }
            if (module instanceof RenderParticleModule) {
                RenderParticleModule renderModule = (RenderParticleModule) module;
                this.renderModules.add(renderModule);
            }
        }

        public ParticleModuleSet build() {
            ParticleModule[] modules = (ParticleModule[]) this.modules.toArray(x$0 -> {
                return new ParticleModule[x$0];
            });
            InitParticleModule[] initModules = (InitParticleModule[]) this.initModules.toArray(x$02 -> {
                return new InitParticleModule[x$02];
            });
            UpdateParticleModule[] updateModules = (UpdateParticleModule[]) this.updateModules.toArray(x$03 -> {
                return new UpdateParticleModule[x$03];
            });
            ForceParticleModule[] forceModules = (ForceParticleModule[]) this.forceModules.toArray(x$04 -> {
                return new ForceParticleModule[x$04];
            });
            CollisionParticleModule[] collisionModules = (CollisionParticleModule[]) this.collisionModules.toArray(x$05 -> {
                return new CollisionParticleModule[x$05];
            });
            RenderParticleModule[] renderModules = (RenderParticleModule[]) this.renderModules.toArray(x$06 -> {
                return new RenderParticleModule[x$06];
            });
            return new ParticleModuleSet(modules, initModules, updateModules, forceModules, collisionModules, renderModules);
        }
    }
}
