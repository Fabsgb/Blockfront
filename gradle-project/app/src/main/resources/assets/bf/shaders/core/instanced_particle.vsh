#version 410

#moj_import <fog.glsl>
#moj_import <light.glsl>

layout(location = 0) in vec3 Position;
layout(location = 1) in vec2 UV0;

layout(location = 2) in vec3 InstancePosition;
layout(location = 3) in float InstanceQuadSize;
layout(location = 4) in vec4 InstanceColor;
layout(location = 5) in vec3 InstanceUVData;
layout(location = 6) in ivec2 InstanceLightTextureCoords;

uniform sampler2D Sampler2;
uniform sampler2D Sampler0;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform int FogShape;

out float vertexDistance;
out vec2 texCoord0;
out vec4 vertexColor;

void main() {
    vec3 pos = Position * InstanceQuadSize + InstancePosition;
    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);

    vec2 textureAtlasSize = vec2(textureSize(Sampler0, 0));
    float aspectRatio = textureAtlasSize.x / textureAtlasSize.y;

    vec2 spriteSize = vec2(InstanceUVData.z / aspectRatio, InstanceUVData.z);

    vertexDistance = fog_distance(pos, FogShape);
    texCoord0 = UV0 * spriteSize + InstanceUVData.xy;
    vertexColor = InstanceColor * minecraft_sample_lightmap(Sampler2, InstanceLightTextureCoords);
}