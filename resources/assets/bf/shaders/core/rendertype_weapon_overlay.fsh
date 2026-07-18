#version 150

#moj_import <fog.glsl>

uniform sampler2D Sampler0;
uniform sampler2D Sampler3;
uniform sampler2D Sampler4;
uniform sampler2D Sampler5;
uniform sampler2D Sampler6;

uniform vec4 ColorModulator;
uniform float FogStart;
uniform float FogEnd;
uniform vec4 FogColor;
uniform vec2 PatternOffset;
uniform int HasPattern;
uniform int IsGui;
uniform int Silhouette;

in float vertexDistance;
in vec4 vertexColor;
in vec4 lightMapColor;
in vec4 overlayColor;
in vec2 texCoord0;

out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler0, texCoord0) * ColorModulator;
    
    // Apply vertex lighting only if not in GUI mode
    if (IsGui != 1) {
        color *= vertexColor;
    }
    vec4 bloodColor = texture(Sampler3, texCoord0 * textureSize(Sampler0, 0) / textureSize(Sampler3, 0));
    vec4 mudColor = texture(Sampler4, texCoord0 * textureSize(Sampler0, 0) / textureSize(Sampler4, 0));

    if (color.a < 0.1) {
        discard;
    }

    color.rgb = mix(overlayColor.rgb, color.rgb, overlayColor.a);

    // Apply pattern skin
    if (HasPattern == 1) {
        vec2 patternCoord = (texCoord0 * textureSize(Sampler0, 0) / textureSize(Sampler5, 0)) + (PatternOffset / textureSize(Sampler5, 0));
        vec4 patternColor = texture(Sampler5, patternCoord);
        vec4 patternTemplateColor = texture(Sampler6, texCoord0);

        // Apply the same vertex lighting to pattern colors only if not in GUI mode
        if (IsGui != 1) {
            patternColor.rgb *= vertexColor.rgb;
            patternTemplateColor.rgb *= vertexColor.rgb;
        }

        color.rgb = mix(color.rgb, patternColor.rgb, patternColor.a);
        color.rgb = mix(color.rgb, patternTemplateColor.rgb, patternTemplateColor.a);
    }

    color.rgb = mix(color.rgb, bloodColor.rgb, bloodColor.a * 0.4);
    color.rgb = mix(color.rgb, mudColor.rgb, mudColor.a * 0.2);

    // Handle GUI rendering modes
    if (IsGui == 1) {
        // If silhouette is also enabled, render full-white
        if (Silhouette == 1) {
            color.rgb = vec3(1.0, 1.0, 1.0);
        }
    } else {
        // Normal lighting for non-GUI rendering
        color *= lightMapColor;
    }
    
    fragColor = linear_fog(color, vertexDistance, FogStart, FogEnd, FogColor);
}