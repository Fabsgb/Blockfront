package io.github.ocelot.glslprocessor.api.grammar;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier.class */
public interface GlslTypeQualifier {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Interpolation.class */
    public enum Interpolation implements GlslTypeQualifier {
        SMOOTH,
        FLAT,
        NOPERSPECTIVE
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Invariant.class */
    public enum Invariant implements GlslTypeQualifier {
        INVARIANT
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Precise.class */
    public enum Precise implements GlslTypeQualifier {
        PRECISE
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Precision.class */
    public enum Precision implements GlslTypeQualifier {
        HIGH_PRECISION,
        MEDIUM_PRECISION,
        LOW_PRECISION
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$StorageType.class */
    public enum StorageType implements GlslTypeQualifier {
        CONST,
        IN,
        OUT,
        INOUT,
        CENTROID,
        PATCH,
        SAMPLE,
        UNIFORM,
        BUFFER,
        SHARED,
        COHERENT,
        VOLATILE,
        RESTRICT,
        READONLY,
        WRITEONLY
    }

    static GlslTypeQualifier storage(String... typeNames) {
        return new StorageSubroutine(typeNames);
    }

    static Layout layout(LayoutId... ids) {
        return layout(Arrays.asList(ids));
    }

    static Layout layout(Collection<LayoutId> ids) {
        return new Layout(List.copyOf(ids));
    }

    static LayoutId layoutId(String identifier, @Nullable GlslNode constantExpression) {
        if (identifier.equals("shared")) {
            return LayoutId.SHARED;
        }
        return new LayoutId(identifier, constantExpression);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$StorageSubroutine.class */
    public static final class StorageSubroutine extends Record implements GlslTypeQualifier {
        private final String[] typeNames;

        public StorageSubroutine(String[] typeNames) {
            this.typeNames = typeNames;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StorageSubroutine.class), StorageSubroutine.class, "typeNames", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$StorageSubroutine;->typeNames:[Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StorageSubroutine.class, Object.class), StorageSubroutine.class, "typeNames", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$StorageSubroutine;->typeNames:[Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String[] typeNames() {
            return this.typeNames;
        }

        @Override // java.lang.Record
        public String toString() {
            return "Storage[operand=SUBROUTINE, typeNames=" + Arrays.toString(this.typeNames) + "]";
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Layout.class */
    public static final class Layout extends Record implements GlslTypeQualifier {
        private final List<LayoutId> layoutIds;

        public Layout(List<LayoutId> layoutIds) {
            this.layoutIds = layoutIds;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Layout.class), Layout.class, "layoutIds", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Layout;->layoutIds:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Layout.class), Layout.class, "layoutIds", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Layout;->layoutIds:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Layout.class, Object.class), Layout.class, "layoutIds", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$Layout;->layoutIds:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public List<LayoutId> layoutIds() {
            return this.layoutIds;
        }

        public GlslTypeQualifier addLayoutId(String identifier, @Nullable GlslNode constantExpression) {
            return addLayoutIds(GlslTypeQualifier.layoutId(identifier, constantExpression));
        }

        public GlslTypeQualifier addLayoutIds(LayoutId... newIds) {
            return addLayoutIds(Arrays.asList(newIds));
        }

        public GlslTypeQualifier addLayoutIds(Collection<LayoutId> newIds) {
            List<LayoutId> layoutIds = new ArrayList<>(this.layoutIds.size() + newIds.size());
            layoutIds.addAll(this.layoutIds);
            layoutIds.addAll(newIds);
            return new Layout(Collections.unmodifiableList(layoutIds));
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$LayoutId.class */
    public static final class LayoutId extends Record {
        private final String identifier;

        @Nullable
        private final GlslNode expression;
        public static final LayoutId SHARED = new LayoutId("shared", null);

        public LayoutId(String identifier, @Nullable GlslNode expression) {
            this.identifier = identifier;
            this.expression = expression;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LayoutId.class), LayoutId.class, "identifier;expression", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$LayoutId;->identifier:Ljava/lang/String;", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$LayoutId;->expression:Lio/github/ocelot/glslprocessor/api/node/GlslNode;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LayoutId.class), LayoutId.class, "identifier;expression", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$LayoutId;->identifier:Ljava/lang/String;", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$LayoutId;->expression:Lio/github/ocelot/glslprocessor/api/node/GlslNode;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LayoutId.class, Object.class), LayoutId.class, "identifier;expression", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$LayoutId;->identifier:Ljava/lang/String;", "FIELD:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeQualifier$LayoutId;->expression:Lio/github/ocelot/glslprocessor/api/node/GlslNode;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String identifier() {
            return this.identifier;
        }

        @Nullable
        public GlslNode expression() {
            return this.expression;
        }

        public boolean shared() {
            return "shared".equals(this.identifier);
        }
    }
}
