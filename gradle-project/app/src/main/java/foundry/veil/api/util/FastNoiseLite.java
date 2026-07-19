package foundry.veil.api.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite.class */
public class FastNoiseLite {
    private int mSeed = 1337;
    private float mFrequency = 0.01f;
    private NoiseType mNoiseType = NoiseType.OpenSimplex2;
    private RotationType3D mRotationType3D = RotationType3D.None;
    private TransformType3D mTransformType3D = TransformType3D.DefaultOpenSimplex2;
    private FractalType mFractalType = FractalType.None;
    private int mOctaves = 3;
    private float mLacunarity = 2.0f;
    private float mGain = 0.5f;
    private float mWeightedStrength = 0.0f;
    private float mPingPongStrength = 2.0f;
    private float mFractalBounding = 0.5714286f;
    private CellularDistanceFunction mCellularDistanceFunction = CellularDistanceFunction.EuclideanSq;
    private CellularReturnType mCellularReturnType = CellularReturnType.Distance;
    private float mCellularJitterModifier = 1.0f;
    private DomainWarpType mDomainWarpType = DomainWarpType.OpenSimplex2;
    private TransformType3D mWarpTransformType3D = TransformType3D.DefaultOpenSimplex2;
    private float mDomainWarpAmp = 1.0f;
    private static final int PrimeX = 501125321;
    private static final int PrimeY = 1136930381;
    private static final int PrimeZ = 1720413743;
    public static final Codec<FastNoiseLite> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("frequency").forGetter((v0) -> {
            return v0.GetFrequency();
        }), Codec.INT.fieldOf("seed").forGetter((v0) -> {
            return v0.GetSeed();
        }), Codec.STRING.fieldOf("fractal_type").xmap(FractalType::valueOf, (v0) -> {
            return v0.name();
        }).orElse(FractalType.FBm).forGetter((v0) -> {
            return v0.GetFractalType();
        }), Codec.INT.optionalFieldOf("octaves", 1).forGetter((v0) -> {
            return v0.GetFractalOctaves();
        }), Codec.FLOAT.optionalFieldOf("lacunarity", Float.valueOf(2.0f)).forGetter((v0) -> {
            return v0.GetFractalLacunarity();
        }), Codec.FLOAT.optionalFieldOf("gain", Float.valueOf(0.5f)).forGetter((v0) -> {
            return v0.GetFractalGain();
        }), Codec.STRING.fieldOf("cellular_distance_function").xmap(CellularDistanceFunction::valueOf, (v0) -> {
            return v0.name();
        }).orElse(CellularDistanceFunction.Euclidean).forGetter((v0) -> {
            return v0.GetCellularDistanceFunction();
        }), Codec.STRING.fieldOf("cellular_return_type").xmap(CellularReturnType::valueOf, (v0) -> {
            return v0.name();
        }).orElse(CellularReturnType.CellValue).forGetter((v0) -> {
            return v0.GetCellularReturnType();
        }), Codec.STRING.fieldOf("noise_type").xmap(NoiseType::valueOf, (v0) -> {
            return v0.name();
        }).orElse(NoiseType.OpenSimplex2).forGetter((v0) -> {
            return v0.GetNoiseType();
        }), Codec.STRING.fieldOf("rotation_type_3d").xmap(RotationType3D::valueOf, (v0) -> {
            return v0.name();
        }).orElse(RotationType3D.None).forGetter((v0) -> {
            return v0.GetRotationType3D();
        }), Codec.STRING.fieldOf("domain_warp_type").xmap(DomainWarpType::valueOf, (v0) -> {
            return v0.name();
        }).orElse(DomainWarpType.OpenSimplex2).forGetter((v0) -> {
            return v0.GetDomainWarpType();
        }), Codec.FLOAT.optionalFieldOf("domain_warp_amp", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.GetDomainWarpAmp();
        })).apply(instance, (frequency, seed, fractalType, octaves, lacunarity, gain, cellularDistanceFunction, cellularReturnType, noiseType, rotationType3D, domainWarpType, domainWarpAmp) -> {
            FastNoiseLite noise = new FastNoiseLite();
            noise.SetFrequency(frequency.floatValue());
            noise.SetSeed(seed.intValue());
            noise.SetFractalType(fractalType);
            noise.SetFractalOctaves(octaves.intValue());
            noise.SetFractalLacunarity(lacunarity.floatValue());
            noise.SetFractalGain(gain.floatValue());
            noise.SetCellularDistanceFunction(cellularDistanceFunction);
            noise.SetCellularReturnType(cellularReturnType);
            noise.SetNoiseType(noiseType);
            noise.SetRotationType3D(rotationType3D);
            noise.SetDomainWarpType(domainWarpType);
            noise.SetDomainWarpAmp(domainWarpAmp.floatValue());
            return noise;
        });
    });
    private static final float[] Gradients2D = {0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.9238795f, 0.38268343f, 0.9238795f, -0.38268343f, 0.38268343f, -0.9238795f, -0.38268343f, -0.9238795f, -0.9238795f, -0.38268343f, -0.9238795f, 0.38268343f, -0.38268343f, 0.9238795f};
    private static final float[] RandVecs2D = {-0.2700222f, -0.9628541f, 0.38630927f, -0.9223693f, 0.04444859f, -0.9990117f, -0.59925234f, -0.80056024f, -0.781928f, 0.62336874f, 0.9464672f, 0.32279992f, -0.6514147f, -0.7587219f, 0.93784726f, 0.34704837f, -0.8497876f, -0.52712524f, -0.87904257f, 0.47674325f, -0.8923003f, -0.45144236f, -0.37984443f, -0.9250504f, -0.9951651f, 0.09821638f, 0.7724398f, -0.635088f, 0.75732833f, -0.6530343f, -0.9928005f, -0.119780056f, -0.05326657f, 0.99858034f, 0.97542536f, -0.22033007f, -0.76650184f, 0.64224213f, 0.9916367f, 0.12906061f, -0.99469686f, 0.10285038f, -0.53792053f, -0.8429955f, 0.50228155f, -0.86470413f, 0.45598215f, -0.8899889f, -0.8659131f, -0.50019443f, 0.08794584f, -0.9961253f, -0.5051685f, 0.8630207f, 0.7753185f, -0.6315704f, -0.69219446f, 0.72171104f, -0.51916593f, -0.85467345f, 0.8978623f, -0.4402764f, -0.17067741f, 0.98532695f, -0.935343f, -0.35374206f, -0.99924046f, 0.038967468f, -0.2882064f, -0.9575683f, -0.96638113f, 0.2571138f, -0.87597144f, -0.48236302f, -0.8303123f, -0.55729836f, 0.051101338f, -0.99869347f, -0.85583735f, -0.51724505f, 0.098870255f, 0.9951003f, 0.9189016f, 0.39448678f, -0.24393758f, -0.96979094f, -0.81214094f, -0.5834613f, -0.99104315f, 0.13354214f, 0.8492424f, -0.52800316f, -0.9717839f, -0.23587295f, 0.9949457f, 0.10041421f, 0.6241065f, -0.7813392f, 0.6629103f, 0.74869883f, -0.7197418f, 0.6942418f, -0.8143371f, -0.58039224f, 0.10452105f, -0.9945227f, -0.10659261f, -0.99430275f, 0.44579968f, -0.8951328f, 0.105547406f, 0.99441427f, -0.9927903f, 0.11986445f, -0.83343667f, 0.55261505f, 0.9115562f, -0.4111756f, 0.8285545f, -0.55990845f, 0.7217098f, -0.6921958f, 0.49404928f, -0.8694339f, -0.36523214f, -0.9309165f, -0.9696607f, 0.24445485f, 0.089255095f, -0.9960088f, 0.5354071f, -0.8445941f, -0.10535762f, 0.9944344f, -0.98902845f, 0.1477251f, 0.004856105f, 0.9999882f, 0.98855984f, 0.15082914f, 0.92861295f, -0.37104982f, -0.5832394f, -0.8123003f, 0.30152076f, 0.9534596f, -0.95751107f, 0.28839657f, 0.9715802f, -0.23671055f, 0.2299818f, 0.97319496f, 0.9557638f, -0.2941352f, 0.7409561f, 0.67155343f, -0.9971514f, -0.07542631f, 0.69057107f, -0.7232645f, -0.2907137f, -0.9568101f, 0.5912778f, -0.80646795f, -0.94545925f, -0.3257405f, 0.66644555f, 0.7455537f, 0.6236135f, 0.78173286f, 0.9126994f, -0.40863165f, -0.8191762f, 0.57354194f, -0.8812746f, -0.4726046f, 0.99533135f, 0.09651673f, 0.98556507f, -0.16929697f, -0.8495981f, 0.52743065f, 0.6174854f, -0.78658235f, 0.85081565f, 0.5254643f, 0.99850327f, -0.0546925f, 0.19713716f, -0.98037595f, 0.66078556f, -0.7505747f, -0.030974941f, 0.9995202f, -0.6731661f, 0.73949134f, -0.71950185f, -0.69449055f, 0.97275114f, 0.2318516f, 0.9997059f, -0.02425069f, 0.44217876f, -0.89692694f, 0.9981351f, -0.061043672f, -0.9173661f, -0.39804456f, -0.81500566f, -0.579453f, -0.87893313f, 0.476945f, 0.015860584f, 0.99987423f, -0.8095465f, 0.5870558f, -0.9165899f, -0.39982867f, -0.8023543f, 0.5968481f, -0.5176738f, 0.85557806f, -0.8154407f, -0.57884055f, 0.40220103f, -0.91555136f, -0.9052557f, -0.4248672f, 0.7317446f, 0.681579f, -0.56476325f, -0.825253f, -0.8403276f, -0.54207885f, -0.93142813f, 0.36392525f, 0.52381986f, 0.85182905f, 0.7432804f, -0.66898f, -0.9853716f, -0.17041974f, 0.46014687f, 0.88784283f, 0.8258554f, 0.56388193f, 0.6182366f, 0.785992f, 0.83315027f, -0.55304664f, 0.15003075f, 0.9886813f, -0.6623304f, -0.7492119f, -0.66859865f, 0.74362344f, 0.7025606f, 0.7116239f, -0.54193896f, -0.84041786f, -0.33886164f, 0.9408362f, 0.833153f, 0.55304253f, -0.29897207f, -0.95426184f, 0.2638523f, 0.9645631f, 0.12410874f, -0.9922686f, -0.7282649f, -0.6852957f, 0.69625f, 0.71779937f, -0.91835356f, 0.395761f, -0.6326102f, -0.7744703f, -0.9331892f, -0.35938552f, -0.11537793f, -0.99332166f, 0.9514975f, -0.30765656f, -0.08987977f, -0.9959526f, 0.6678497f, 0.7442962f, 0.79524004f, -0.6062947f, -0.6462007f, -0.7631675f, -0.27335986f, 0.96191186f, 0.966959f, -0.25493184f, -0.9792895f, 0.20246519f, -0.5369503f, -0.84361386f, -0.27003646f, -0.9628501f, -0.6400277f, 0.76835185f, -0.78545374f, -0.6189204f, 0.060059056f, -0.9981948f, -0.024557704f, 0.9996984f, -0.65983623f, 0.7514095f, -0.62538946f, -0.7803128f, -0.6210409f, -0.7837782f, 0.8348889f, 0.55041856f, -0.15922752f, 0.9872419f, 0.83676225f, 0.54756635f, -0.8675754f, -0.4973057f, -0.20226626f, -0.97933054f, 0.939919f, 0.34139755f, 0.98774046f, -0.1561049f, -0.90344554f, 0.42870283f, 0.12698042f, -0.9919052f, -0.3819601f, 0.92417884f, 0.9754626f, 0.22016525f, -0.32040158f, -0.94728184f, -0.9874761f, 0.15776874f, 0.025353484f, -0.99967855f, 0.4835131f, -0.8753371f, -0.28508f, -0.9585037f, -0.06805516f, -0.99768156f, -0.7885244f, -0.61500347f, 0.3185392f, -0.9479097f, 0.8880043f, 0.45983514f, 0.64769214f, -0.76190215f, 0.98202413f, 0.18875542f, 0.93572754f, -0.35272372f, -0.88948953f, 0.45695552f, 0.7922791f, 0.6101588f, 0.74838185f, 0.66326815f, -0.728893f, -0.68462765f, 0.8729033f, -0.48789328f, 0.8288346f, 0.5594937f, 0.08074567f, 0.99673474f, 0.97991484f, -0.1994165f, -0.5807307f, -0.81409574f, -0.47000498f, -0.8826638f, 0.2409493f, 0.9705377f, 0.9437817f, -0.33056942f, -0.89279985f, -0.45045355f, -0.80696225f, 0.59060305f, 0.062589735f, 0.99803936f, -0.93125975f, 0.36435598f, 0.57774496f, 0.81621736f, -0.3360096f, -0.9418586f, 0.69793206f, -0.71616393f, -0.0020081573f, -0.999998f, -0.18272944f, -0.98316324f, -0.6523912f, 0.7578824f, -0.43026268f, -0.9027037f, -0.9985126f, -0.054520912f, -0.010281022f, -0.99994713f, -0.49460712f, 0.86911666f, -0.299935f, 0.95395964f, 0.8165472f, 0.5772787f, 0.26974604f, 0.9629315f, -0.7306287f, -0.68277496f, -0.7590952f, -0.65097964f, -0.9070538f, 0.4210146f, -0.5104861f, -0.859886f, 0.86133504f, 0.5080373f, 0.50078815f, -0.8655699f, -0.6541582f, 0.7563578f, -0.83827555f, -0.54524684f, 0.6940071f, 0.7199682f, 0.06950936f, 0.9975813f, 0.17029423f, -0.9853933f, 0.26959732f, 0.9629731f, 0.55196124f, -0.83386976f, 0.2256575f, -0.9742067f, 0.42152628f, -0.9068162f, 0.48818734f, -0.87273884f, -0.3683855f, -0.92967314f, -0.98253906f, 0.18605645f, 0.81256473f, 0.582871f, 0.3196461f, -0.947537f, 0.9570914f, 0.28978625f, -0.6876655f, -0.7260276f, -0.9988771f, -0.04737673f, -0.1250179f, 0.9921545f, -0.82801336f, 0.56070834f, 0.93248636f, -0.36120513f, 0.63946533f, 0.7688199f, -0.016238471f, -0.99986815f, -0.99550146f, -0.094746135f, -0.8145332f, 0.580117f, 0.4037328f, -0.91487694f, 0.9944263f, 0.10543368f, -0.16247116f, 0.9867133f, -0.9949488f, -0.10038388f, -0.69953024f, 0.714603f, 0.5263415f, -0.85027325f, -0.5395222f, 0.8419714f, 0.65793705f, 0.7530729f, 0.014267588f, -0.9998982f, -0.6734384f, 0.7392433f, 0.6394121f, -0.7688642f, 0.9211571f, 0.38919085f, -0.14663722f, -0.98919034f, -0.7823181f, 0.6228791f, -0.5039611f, -0.8637264f, -0.774312f, -0.632804f};
    private static final float[] Gradients3D = {0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f};
    private static final float[] RandVecs3D = {-0.7292737f, -0.66184396f, 0.17355819f, 0.0f, 0.7902921f, -0.5480887f, -0.2739291f, 0.0f, 0.7217579f, 0.62262124f, -0.3023381f, 0.0f, 0.5656831f, -0.8208298f, -0.079000026f, 0.0f, 0.76004905f, -0.55559796f, -0.33709997f, 0.0f, 0.37139457f, 0.50112647f, 0.78162545f, 0.0f, -0.12770624f, -0.4254439f, -0.8959289f, 0.0f, -0.2881561f, -0.5815839f, 0.7607406f, 0.0f, 0.5849561f, -0.6628202f, -0.4674352f, 0.0f, 0.33071712f, 0.039165374f, 0.94291687f, 0.0f, 0.8712122f, -0.41133744f, -0.26793817f, 0.0f, 0.580981f, 0.7021916f, 0.41156778f, 0.0f, 0.5037569f, 0.6330057f, -0.5878204f, 0.0f, 0.44937122f, 0.6013902f, 0.6606023f, 0.0f, -0.6878404f, 0.090188906f, -0.7202372f, 0.0f, -0.59589565f, -0.64693505f, 0.47579765f, 0.0f, -0.5127052f, 0.1946922f, -0.83619875f, 0.0f, -0.99115074f, -0.054102764f, -0.12121531f, 0.0f, -0.21497211f, 0.9720882f, -0.09397608f, 0.0f, -0.7518651f, -0.54280573f, 0.37424695f, 0.0f, 0.5237069f, 0.8516377f, -0.021078179f, 0.0f, 0.6333505f, 0.19261672f, -0.74951047f, 0.0f, -0.06788242f, 0.39983058f, 0.9140719f, 0.0f, -0.55386287f, -0.47298968f, -0.6852129f, 0.0f, -0.72614557f, -0.5911991f, 0.35099334f, 0.0f, -0.9229275f, -0.17828088f, 0.34120494f, 0.0f, -0.6968815f, 0.65112746f, 0.30064803f, 0.0f, 0.96080446f, -0.20983632f, -0.18117249f, 0.0f, 0.068171464f, -0.9743405f, 0.21450691f, 0.0f, -0.3577285f, -0.6697087f, -0.65078455f, 0.0f, -0.18686211f, 0.7648617f, -0.61649746f, 0.0f, -0.65416974f, 0.3967915f, 0.64390874f, 0.0f, 0.699334f, -0.6164538f, 0.36182392f, 0.0f, -0.15466657f, 0.6291284f, 0.7617583f, 0.0f, -0.6841613f, -0.2580482f, -0.68215424f, 0.0f, 0.5383981f, 0.4258655f, 0.727163f, 0.0f, -0.5026988f, -0.7939833f, -0.3418837f, 0.0f, 0.32029718f, 0.28344154f, 0.9039196f, 0.0f, 0.86832273f, -3.7626564E-4f, -0.49599952f, 0.0f, 0.79112005f, -0.085110456f, 0.60571057f, 0.0f, -0.04011016f, -0.43972486f, 0.8972364f, 0.0f, 0.914512f, 0.35793462f, -0.18854876f, 0.0f, -0.96120393f, -0.27564842f, 0.010246669f, 0.0f, 0.65103614f, -0.28777993f, -0.70237786f, 0.0f, -0.20417863f, 0.73652375f, 0.6448596f, 0.0f, -0.7718264f, 0.37906268f, 0.5104856f, 0.0f, -0.30600828f, -0.7692988f, 0.56083715f, 0.0f, 0.45400733f, -0.5024843f, 0.73578995f, 0.0f, 0.48167956f, 0.6021208f, -0.636738f, 0.0f, 0.69619805f, -0.32221973f, 0.6414692f, 0.0f, -0.65321606f, -0.6781149f, 0.33685157f, 0.0f, 0.50893015f, -0.61546624f, -0.60182345f, 0.0f, -0.16359198f, -0.9133605f, -0.37284088f, 0.0f, 0.5240802f, -0.8437664f, 0.11575059f, 0.0f, 0.5902587f, 0.4983818f, -0.63498837f, 0.0f, 0.5863228f, 0.49476475f, 0.6414308f, 0.0f, 0.6779335f, 0.23413453f, 0.6968409f, 0.0f, 0.7177054f, -0.68589795f, 0.12017863f, 0.0f, -0.532882f, -0.5205125f, 0.6671608f, 0.0f, -0.8654874f, -0.07007271f, -0.4960054f, 0.0f, -0.286181f, 0.79520893f, 0.53454953f, 0.0f, -0.048495296f, 0.98108363f, -0.18741156f, 0.0f, -0.63585216f, 0.60583484f, 0.47818002f, 0.0f, 0.62547946f, -0.28616196f, 0.72586966f, 0.0f, -0.258526f, 0.50619495f, -0.8227582f, 0.0f, 0.021363068f, 0.50640166f, -0.862033f, 0.0f, 0.20011178f, 0.85992634f, 0.46955505f, 0.0f, 0.47435614f, 0.6014985f, -0.6427953f, 0.0f, 0.6622994f, -0.52024746f, -0.539168f, 0.0f, 0.08084973f, -0.65327203f, 0.7527941f, 0.0f, -0.6893687f, 0.059286036f, 0.7219805f, 0.0f, -0.11218871f, -0.96731853f, 0.22739525f, 0.0f, 0.7344116f, 0.59796685f, -0.3210533f, 0.0f, 0.5789393f, -0.24888498f, 0.776457f, 0.0f, 0.69881827f, 0.35571697f, -0.6205791f, 0.0f, -0.86368454f, -0.27487713f, -0.4224826f, 0.0f, -0.4247028f, -0.46408808f, 0.77733505f, 0.0f, 0.5257723f, -0.84270173f, 0.11583299f, 0.0f, 0.93438303f, 0.31630248f, -0.16395439f, 0.0f, -0.10168364f, -0.8057303f, -0.58348876f, 0.0f, -0.6529239f, 0.50602126f, -0.5635893f, 0.0f, -0.24652861f, -0.9668206f, -0.06694497f, 0.0f, -0.9776897f, -0.20992506f, -0.0073688254f, 0.0f, 0.7736893f, 0.57342446f, 0.2694238f, 0.0f, -0.6095088f, 0.4995679f, 0.6155737f, 0.0f, 0.5794535f, 0.7434547f, 0.33392924f, 0.0f, -0.8226211f, 0.081425816f, 0.56272936f, 0.0f, -0.51038545f, 0.47036678f, 0.719904f, 0.0f, -0.5764972f, -0.072316565f, -0.81389266f, 0.0f, 0.7250629f, 0.39499715f, -0.56414634f, 0.0f, -0.1525424f, 0.48608407f, -0.8604958f, 0.0f, -0.55509764f, -0.49578208f, 0.6678823f, 0.0f, -0.18836144f, 0.91458696f, 0.35784173f, 0.0f, 0.76255566f, -0.54144084f, -0.35404897f, 0.0f, -0.5870232f, -0.3226498f, -0.7424964f, 0.0f, 0.30511242f, 0.2262544f, -0.9250488f, 0.0f, 0.63795763f, 0.57724243f, -0.50970703f, 0.0f, -0.5966776f, 0.14548524f, -0.7891831f, 0.0f, -0.65833056f, 0.65554875f, -0.36994147f, 0.0f, 0.74348927f, 0.23510846f, 0.6260573f, 0.0f, 0.5562114f, 0.82643604f, -0.08736329f, 0.0f, -0.302894f, -0.8251527f, 0.47684193f, 0.0f, 0.11293438f, -0.9858884f, -0.123571075f, 0.0f, 0.5937653f, -0.5896814f, 0.5474657f, 0.0f, 0.6757964f, -0.58357584f, -0.45026484f, 0.0f, 0.7242303f, -0.11527198f, 0.67985505f, 0.0f, -0.9511914f, 0.0753624f, -0.29925808f, 0.0f, 0.2539471f, -0.18863393f, 0.9486454f, 0.0f, 0.5714336f, -0.16794509f, -0.8032796f, 0.0f, -0.06778235f, 0.39782694f, 0.9149532f, 0.0f, 0.6074973f, 0.73306f, -0.30589226f, 0.0f, -0.54354787f, 0.16758224f, 0.8224791f, 0.0f, -0.5876678f, -0.3380045f, -0.7351187f, 0.0f, -0.79675627f, 0.040978227f, -0.60290986f, 0.0f, -0.19963509f, 0.8706295f, 0.4496111f, 0.0f, -0.027876602f, -0.91062325f, -0.4122962f, 0.0f, -0.7797626f, -0.6257635f, 0.019757755f, 0.0f, -0.5211233f, 0.74016446f, -0.42495546f, 0.0f, 0.8575425f, 0.4053273f, -0.31675017f, 0.0f, 0.10452233f, 0.8390196f, -0.53396744f, 0.0f, 0.3501823f, 0.9242524f, -0.15208502f, 0.0f, 0.19878499f, 0.076476134f, 0.9770547f, 0.0f, 0.78459966f, 0.6066257f, -0.12809642f, 0.0f, 0.09006737f, -0.97509897f, -0.20265691f, 0.0f, -0.82743436f, -0.54229957f, 0.14582036f, 0.0f, -0.34857976f, -0.41580227f, 0.8400004f, 0.0f, -0.2471779f, -0.730482f, -0.6366311f, 0.0f, -0.3700155f, 0.8577948f, 0.35675845f, 0.0f, 0.59133947f, -0.54831195f, -0.59133035f, 0.0f, 0.120487355f, -0.7626472f, -0.6354935f, 0.0f, 0.6169593f, 0.03079648f, 0.7863923f, 0.0f, 0.12581569f, -0.664083f, -0.73699677f, 0.0f, -0.6477565f, -0.17401473f, -0.74170774f, 0.0f, 0.6217889f, -0.7804431f, -0.06547655f, 0.0f, 0.6589943f, -0.6096988f, 0.44044736f, 0.0f, -0.26898375f, -0.6732403f, -0.68876356f, 0.0f, -0.38497752f, 0.56765425f, 0.7277094f, 0.0f, 0.57544446f, 0.81104714f, -0.10519635f, 0.0f, 0.91415936f, 0.3832948f, 0.13190056f, 0.0f, -0.10792532f, 0.9245494f, 0.36545935f, 0.0f, 0.3779771f, 0.30431488f, 0.87437165f, 0.0f, -0.21428852f, -0.8259286f, 0.5214617f, 0.0f, 0.58025444f, 0.41480985f, -0.7008834f, 0.0f, -0.19826609f, 0.85671616f, -0.47615966f, 0.0f, -0.033815537f, 0.37731808f, -0.9254661f, 0.0f, -0.68679225f, -0.6656598f, 0.29191336f, 0.0f, 0.7731743f, -0.28757936f, -0.565243f, 0.0f, -0.09655942f, 0.91937083f, -0.3813575f, 0.0f, 0.27157024f, -0.957791f, -0.09426606f, 0.0f, 0.24510157f, -0.6917999f, -0.6792188f, 0.0f, 0.97770077f, -0.17538553f, 0.115503654f, 0.0f, -0.522474f, 0.8521607f, 0.029036159f, 0.0f, -0.77348804f, -0.52612925f, 0.35341796f, 0.0f, -0.71344924f, -0.26954725f, 0.6467878f, 0.0f, 0.16440372f, 0.5105846f, -0.84396374f, 0.0f, 0.6494636f, 0.055856112f, 0.7583384f, 0.0f, -0.4711971f, 0.50172806f, -0.7254256f, 0.0f, -0.63357645f, -0.23816863f, -0.7361091f, 0.0f, -0.9021533f, -0.2709478f, -0.33571818f, 0.0f, -0.3793711f, 0.8722581f, 0.3086152f, 0.0f, -0.68555987f, -0.32501432f, 0.6514394f, 0.0f, 0.29009423f, -0.7799058f, -0.5546101f, 0.0f, -0.20983194f, 0.8503707f, 0.48253515f, 0.0f, -0.45926037f, 0.6598504f, -0.5947077f, 0.0f, 0.87159455f, 0.09616365f, -0.48070312f, 0.0f, -0.6776666f, 0.71185046f, -0.1844907f, 0.0f, 0.7044378f, 0.3124276f, 0.637304f, 0.0f, -0.7052319f, -0.24010932f, -0.6670798f, 0.0f, 0.081921004f, -0.72073364f, -0.68835455f, 0.0f, -0.6993681f, -0.5875763f, -0.4069869f, 0.0f, -0.12814544f, 0.6419896f, 0.75592864f, 0.0f, -0.6337388f, -0.67854714f, -0.3714147f, 0.0f, 0.5565052f, -0.21688876f, -0.8020357f, 0.0f, -0.57915545f, 0.7244372f, -0.3738579f, 0.0f, 0.11757791f, -0.7096451f, 0.69467926f, 0.0f, -0.613462f, 0.13236311f, 0.7785528f, 0.0f, 0.69846356f, -0.029805163f, -0.7150247f, 0.0f, 0.83180827f, -0.3930172f, 0.39195976f, 0.0f, 0.14695764f, 0.055416517f, -0.98758924f, 0.0f, 0.70886856f, -0.2690504f, 0.65201014f, 0.0f, 0.27260533f, 0.67369765f, -0.68688995f, 0.0f, -0.65912956f, 0.30354586f, -0.68804663f, 0.0f, 0.48151314f, -0.752827f, 0.4487723f, 0.0f, 0.943001f, 0.16756473f, -0.28752613f, 0.0f, 0.43480295f, 0.7695305f, -0.46772778f, 0.0f, 0.39319962f, 0.5944736f, 0.70142365f, 0.0f, 0.72543365f, -0.60392565f, 0.33018148f, 0.0f, 0.75902355f, -0.6506083f, 0.024333132f, 0.0f, -0.8552769f, -0.3430043f, 0.38839358f, 0.0f, -0.6139747f, 0.6981725f, 0.36822575f, 0.0f, -0.74659055f, -0.575201f, 0.33428493f, 0.0f, 0.5730066f, 0.8105555f, -0.12109168f, 0.0f, -0.92258775f, -0.3475211f, -0.16751404f, 0.0f, -0.71058166f, -0.47196922f, -0.5218417f, 0.0f, -0.0856461f, 0.35830015f, 0.9296697f, 0.0f, -0.8279698f, -0.2043157f, 0.5222271f, 0.0f, 0.42794403f, 0.278166f, 0.8599346f, 0.0f, 0.539908f, -0.78571206f, -0.3019204f, 0.0f, 0.5678404f, -0.5495414f, -0.61283076f, 0.0f, -0.9896071f, 0.13656391f, -0.045034185f, 0.0f, -0.6154343f, -0.64408755f, 0.45430374f, 0.0f, 0.10742044f, -0.79463404f, 0.59750944f, 0.0f, -0.359545f, -0.888553f, 0.28495783f, 0.0f, -0.21804053f, 0.1529889f, 0.9638738f, 0.0f, -0.7277432f, -0.61640507f, -0.30072346f, 0.0f, 0.7249729f, -0.0066971947f, 0.68874484f, 0.0f, -0.5553659f, -0.5336586f, 0.6377908f, 0.0f, 0.5137558f, 0.79762083f, -0.316f, 0.0f, -0.3794025f, 0.92456084f, -0.035227515f, 0.0f, 0.82292485f, 0.27453658f, -0.49741766f, 0.0f, -0.5404114f, 0.60911417f, 0.5804614f, 0.0f, 0.8036582f, -0.27030295f, 0.5301602f, 0.0f, 0.60443187f, 0.68329686f, 0.40959433f, 0.0f, 0.06389989f, 0.96582085f, -0.2512108f, 0.0f, 0.10871133f, 0.74024713f, -0.6634878f, 0.0f, -0.7134277f, -0.6926784f, 0.10591285f, 0.0f, 0.64588976f, -0.57245487f, -0.50509584f, 0.0f, -0.6553931f, 0.73814714f, 0.15999562f, 0.0f, 0.39109614f, 0.91888714f, -0.05186756f, 0.0f, -0.48790225f, -0.5904377f, 0.64291114f, 0.0f, 0.601479f, 0.77074414f, -0.21018201f, 0.0f, -0.5677173f, 0.7511361f, 0.33688518f, 0.0f, 0.7858574f, 0.22667466f, 0.5753667f, 0.0f, -0.45203456f, -0.6042227f, -0.65618575f, 0.0f, 0.0022721163f, 0.4132844f, -0.9105992f, 0.0f, -0.58157516f, -0.5162926f, 0.6286591f, 0.0f, -0.03703705f, 0.8273786f, 0.5604221f, 0.0f, -0.51196927f, 0.79535437f, -0.324498f, 0.0f, -0.26824173f, -0.957229f, -0.10843876f, 0.0f, -0.23224828f, -0.9679131f, -0.09594243f, 0.0f, 0.3554329f, -0.8881506f, 0.29130062f, 0.0f, 0.73465204f, -0.4371373f, 0.5188423f, 0.0f, 0.998512f, 0.046590112f, -0.028339446f, 0.0f, -0.37276876f, -0.9082481f, 0.19007573f, 0.0f, 0.9173738f, -0.3483642f, 0.19252984f, 0.0f, 0.2714911f, 0.41475296f, -0.86848867f, 0.0f, 0.5131763f, -0.71163344f, 0.4798207f, 0.0f, -0.87373537f, 0.18886992f, -0.44823506f, 0.0f, 0.84600437f, -0.3725218f, 0.38145f, 0.0f, 0.89787275f, -0.17802091f, -0.40265754f, 0.0f, 0.21780656f, -0.9698323f, -0.10947895f, 0.0f, -0.15180314f, -0.7788918f, -0.6085091f, 0.0f, -0.2600385f, -0.4755398f, -0.840382f, 0.0f, 0.5723135f, -0.7474341f, -0.33734185f, 0.0f, -0.7174141f, 0.16990171f, -0.67561114f, 0.0f, -0.6841808f, 0.021457076f, -0.72899675f, 0.0f, -0.2007448f, 0.06555606f, -0.9774477f, 0.0f, -0.11488037f, -0.8044887f, 0.5827524f, 0.0f, -0.787035f, 0.03447489f, 0.6159443f, 0.0f, -0.20155965f, 0.68598723f, 0.69913894f, 0.0f, 
    -0.085810825f, -0.10920836f, -0.99030805f, 0.0f, 0.5532693f, 0.73252505f, -0.39661077f, 0.0f, -0.18424894f, -0.9777375f, -0.100407675f, 0.0f, 0.07754738f, -0.9111506f, 0.40471104f, 0.0f, 0.13998385f, 0.7601631f, -0.63447344f, 0.0f, 0.44844192f, -0.84528923f, 0.29049253f, 0.0f};

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$CellularDistanceFunction.class */
    public enum CellularDistanceFunction {
        Euclidean,
        EuclideanSq,
        Manhattan,
        Hybrid
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$CellularReturnType.class */
    public enum CellularReturnType {
        CellValue,
        Distance,
        Distance2,
        Distance2Add,
        Distance2Sub,
        Distance2Mul,
        Distance2Div
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$DomainWarpType.class */
    public enum DomainWarpType {
        OpenSimplex2,
        OpenSimplex2Reduced,
        BasicGrid
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$FractalType.class */
    public enum FractalType {
        None,
        FBm,
        Ridged,
        PingPong,
        DomainWarpProgressive,
        DomainWarpIndependent
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$NoiseType.class */
    public enum NoiseType {
        OpenSimplex2,
        OpenSimplex2S,
        Cellular,
        Perlin,
        ValueCubic,
        Value
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$RotationType3D.class */
    public enum RotationType3D {
        None,
        ImproveXYPlanes,
        ImproveXZPlanes
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$TransformType3D.class */
    private enum TransformType3D {
        None,
        ImproveXYPlanes,
        ImproveXZPlanes,
        DefaultOpenSimplex2
    }

    public void renderImGuiSettings() {
    }

    public int GetSeed() {
        return this.mSeed;
    }

    public float GetFrequency() {
        return this.mFrequency;
    }

    public NoiseType GetNoiseType() {
        return this.mNoiseType;
    }

    public RotationType3D GetRotationType3D() {
        return this.mRotationType3D;
    }

    public TransformType3D GetTransformType3D() {
        return this.mTransformType3D;
    }

    public FractalType GetFractalType() {
        return this.mFractalType;
    }

    public int GetFractalOctaves() {
        return this.mOctaves;
    }

    public float GetFractalLacunarity() {
        return this.mLacunarity;
    }

    public float GetFractalGain() {
        return this.mGain;
    }

    public float GetFractalWeightedStrength() {
        return this.mWeightedStrength;
    }

    public float GetFractalPingPongStrength() {
        return this.mPingPongStrength;
    }

    public float GetFractalBounding() {
        return this.mFractalBounding;
    }

    public CellularDistanceFunction GetCellularDistanceFunction() {
        return this.mCellularDistanceFunction;
    }

    public CellularReturnType GetCellularReturnType() {
        return this.mCellularReturnType;
    }

    public float GetCellularJitterModifier() {
        return this.mCellularJitterModifier;
    }

    public DomainWarpType GetDomainWarpType() {
        return this.mDomainWarpType;
    }

    public TransformType3D GetWarpTransformType3D() {
        return this.mWarpTransformType3D;
    }

    public float GetDomainWarpAmp() {
        return this.mDomainWarpAmp;
    }

    public FastNoiseLite() {
    }

    public FastNoiseLite copy() {
        FastNoiseLite copy = new FastNoiseLite();
        copy.mSeed = this.mSeed;
        copy.mFrequency = this.mFrequency;
        copy.mNoiseType = this.mNoiseType;
        copy.mRotationType3D = this.mRotationType3D;
        copy.mTransformType3D = this.mTransformType3D;
        copy.mFractalType = this.mFractalType;
        copy.mOctaves = this.mOctaves;
        copy.mLacunarity = this.mLacunarity;
        copy.mGain = this.mGain;
        copy.mWeightedStrength = this.mWeightedStrength;
        copy.mPingPongStrength = this.mPingPongStrength;
        copy.mFractalBounding = this.mFractalBounding;
        copy.mCellularDistanceFunction = this.mCellularDistanceFunction;
        copy.mCellularReturnType = this.mCellularReturnType;
        copy.mCellularJitterModifier = this.mCellularJitterModifier;
        copy.mDomainWarpType = this.mDomainWarpType;
        copy.mWarpTransformType3D = this.mWarpTransformType3D;
        copy.mDomainWarpAmp = this.mDomainWarpAmp;
        return copy;
    }

    public FastNoiseLite(int seed) {
        SetSeed(seed);
    }

    public void SetSeed(int seed) {
        this.mSeed = seed;
    }

    public void SetFrequency(float frequency) {
        this.mFrequency = frequency;
    }

    public void SetNoiseType(NoiseType noiseType) {
        this.mNoiseType = noiseType;
        UpdateTransformType3D();
    }

    public void SetRotationType3D(RotationType3D rotationType3D) {
        this.mRotationType3D = rotationType3D;
        UpdateTransformType3D();
        UpdateWarpTransformType3D();
    }

    public void SetFractalType(FractalType fractalType) {
        this.mFractalType = fractalType;
    }

    public void SetFractalOctaves(int octaves) {
        this.mOctaves = octaves;
        CalculateFractalBounding();
    }

    public void SetFractalLacunarity(float lacunarity) {
        this.mLacunarity = lacunarity;
    }

    public void SetFractalGain(float gain) {
        this.mGain = gain;
        CalculateFractalBounding();
    }

    public void SetFractalWeightedStrength(float weightedStrength) {
        this.mWeightedStrength = weightedStrength;
    }

    public void SetFractalPingPongStrength(float pingPongStrength) {
        this.mPingPongStrength = pingPongStrength;
    }

    public void SetCellularDistanceFunction(CellularDistanceFunction cellularDistanceFunction) {
        this.mCellularDistanceFunction = cellularDistanceFunction;
    }

    public void SetCellularReturnType(CellularReturnType cellularReturnType) {
        this.mCellularReturnType = cellularReturnType;
    }

    public void SetCellularJitter(float cellularJitter) {
        this.mCellularJitterModifier = cellularJitter;
    }

    public void SetDomainWarpType(DomainWarpType domainWarpType) {
        this.mDomainWarpType = domainWarpType;
        UpdateWarpTransformType3D();
    }

    public void SetDomainWarpAmp(float domainWarpAmp) {
        this.mDomainWarpAmp = domainWarpAmp;
    }

    public float GetNoise(float x, float y) {
        float x2 = x * this.mFrequency;
        float y2 = y * this.mFrequency;
        switch (this.mNoiseType) {
            case OpenSimplex2:
            case OpenSimplex2S:
                float t = (x2 + y2) * 0.3660254f;
                x2 += t;
                y2 += t;
                break;
        }
        switch (this.mFractalType.ordinal()) {
            case 1:
                return GenFractalFBm(x2, y2);
            case 2:
                return GenFractalRidged(x2, y2);
            case 3:
                return GenFractalPingPong(x2, y2);
            default:
                return GenNoiseSingle(this.mSeed, x2, y2);
        }
    }

    public float GetNoise(float x, float y, float z) {
        float x2 = x * this.mFrequency;
        float y2 = y * this.mFrequency;
        float z2 = z * this.mFrequency;
        switch (this.mTransformType3D.ordinal()) {
            case 1:
                float xy = x2 + y2;
                float s2 = xy * (-0.21132487f);
                float z3 = z2 * 0.57735026f;
                x2 += s2 - z3;
                y2 = (y2 + s2) - z3;
                z2 = z3 + (xy * 0.57735026f);
                break;
            case 2:
                float xz = x2 + z2;
                float s22 = xz * (-0.21132487f);
                float y3 = y2 * 0.57735026f;
                x2 += s22 - y3;
                z2 += s22 - y3;
                y2 = y3 + (xz * 0.57735026f);
                break;
            case 3:
                float r = (x2 + y2 + z2) * 0.6666667f;
                x2 = r - x2;
                y2 = r - y2;
                z2 = r - z2;
                break;
        }
        switch (this.mFractalType.ordinal()) {
            case 1:
                return GenFractalFBm(x2, y2, z2);
            case 2:
                return GenFractalRidged(x2, y2, z2);
            case 3:
                return GenFractalPingPong(x2, y2, z2);
            default:
                return GenNoiseSingle(this.mSeed, x2, y2, z2);
        }
    }

    public void DomainWarp(Vector2 coord) {
        switch (this.mFractalType.ordinal()) {
            case 4:
                DomainWarpFractalProgressive(coord);
                break;
            case 5:
                DomainWarpFractalIndependent(coord);
                break;
            default:
                DomainWarpSingle(coord);
                break;
        }
    }

    public void DomainWarp(Vector3 coord) {
        switch (this.mFractalType.ordinal()) {
            case 4:
                DomainWarpFractalProgressive(coord);
                break;
            case 5:
                DomainWarpFractalIndependent(coord);
                break;
            default:
                DomainWarpSingle(coord);
                break;
        }
    }

    private static float FastMin(float a, float b) {
        return a < b ? a : b;
    }

    private static float FastMax(float a, float b) {
        return a > b ? a : b;
    }

    private static float FastAbs(float f) {
        return f < 0.0f ? -f : f;
    }

    private static float FastSqrt(float f) {
        return (float) Math.sqrt(f);
    }

    private static int FastFloor(float f) {
        return f >= 0.0f ? (int) f : ((int) f) - 1;
    }

    private static int FastRound(float f) {
        return f >= 0.0f ? (int) (f + 0.5f) : (int) (f - 0.5f);
    }

    private static float Lerp(float a, float b, float t) {
        return a + (t * (b - a));
    }

    private static float InterpHermite(float t) {
        return t * t * (3.0f - (2.0f * t));
    }

    private static float InterpQuintic(float t) {
        return t * t * t * ((t * ((t * 6.0f) - 15.0f)) + 10.0f);
    }

    private static float CubicLerp(float a, float b, float c, float d, float t) {
        float p = (d - c) - (a - b);
        return (t * t * t * p) + (t * t * ((a - b) - p)) + (t * (c - a)) + b;
    }

    private static float PingPong(float t) {
        float t2 = t - (((int) (t * 0.5f)) * 2);
        return t2 < 1.0f ? t2 : 2.0f - t2;
    }

    private void CalculateFractalBounding() {
        float gain = FastAbs(this.mGain);
        float amp = gain;
        float ampFractal = 1.0f;
        for (int i = 1; i < this.mOctaves; i++) {
            ampFractal += amp;
            amp *= gain;
        }
        this.mFractalBounding = 1.0f / ampFractal;
    }

    private static int Hash(int seed, int xPrimed, int yPrimed) {
        int hash = (seed ^ xPrimed) ^ yPrimed;
        return hash * 668265261;
    }

    private static int Hash(int seed, int xPrimed, int yPrimed, int zPrimed) {
        int hash = ((seed ^ xPrimed) ^ yPrimed) ^ zPrimed;
        return hash * 668265261;
    }

    private static float ValCoord(int seed, int xPrimed, int yPrimed) {
        int hash = Hash(seed, xPrimed, yPrimed);
        int hash2 = hash * hash;
        return (hash2 ^ (hash2 << 19)) * 4.656613E-10f;
    }

    private static float ValCoord(int seed, int xPrimed, int yPrimed, int zPrimed) {
        int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
        int hash2 = hash * hash;
        return (hash2 ^ (hash2 << 19)) * 4.656613E-10f;
    }

    private static float GradCoord(int seed, int xPrimed, int yPrimed, float xd, float yd) {
        int hash = Hash(seed, xPrimed, yPrimed);
        int hash2 = (hash ^ (hash >> 15)) & 254;
        float xg = Gradients2D[hash2];
        float yg = Gradients2D[hash2 | 1];
        return (xd * xg) + (yd * yg);
    }

    private static float GradCoord(int seed, int xPrimed, int yPrimed, int zPrimed, float xd, float yd, float zd) {
        int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
        int hash2 = (hash ^ (hash >> 15)) & 252;
        float xg = Gradients3D[hash2];
        float yg = Gradients3D[hash2 | 1];
        float zg = Gradients3D[hash2 | 2];
        return (xd * xg) + (yd * yg) + (zd * zg);
    }

    private float GenNoiseSingle(int seed, float x, float y) {
        switch (this.mNoiseType) {
            case OpenSimplex2:
                return SingleSimplex(seed, x, y);
            case OpenSimplex2S:
                return SingleOpenSimplex2S(seed, x, y);
            case Cellular:
                return SingleCellular(seed, x, y);
            case Perlin:
                return SinglePerlin(seed, x, y);
            case ValueCubic:
                return SingleValueCubic(seed, x, y);
            case Value:
                return SingleValue(seed, x, y);
            default:
                return 0.0f;
        }
    }

    private float GenNoiseSingle(int seed, float x, float y, float z) {
        switch (this.mNoiseType) {
            case OpenSimplex2:
                return SingleOpenSimplex2(seed, x, y, z);
            case OpenSimplex2S:
                return SingleOpenSimplex2S(seed, x, y, z);
            case Cellular:
                return SingleCellular(seed, x, y, z);
            case Perlin:
                return SinglePerlin(seed, x, y, z);
            case ValueCubic:
                return SingleValueCubic(seed, x, y, z);
            case Value:
                return SingleValue(seed, x, y, z);
            default:
                return 0.0f;
        }
    }

    private void UpdateTransformType3D() {
        switch (this.mRotationType3D.ordinal()) {
            case 1:
                this.mTransformType3D = TransformType3D.ImproveXYPlanes;
                break;
            case 2:
                this.mTransformType3D = TransformType3D.ImproveXZPlanes;
                break;
            default:
                switch (this.mNoiseType) {
                    case OpenSimplex2:
                    case OpenSimplex2S:
                        this.mTransformType3D = TransformType3D.DefaultOpenSimplex2;
                        break;
                    default:
                        this.mTransformType3D = TransformType3D.None;
                        break;
                }
                break;
        }
    }

    private void UpdateWarpTransformType3D() {
        switch (this.mRotationType3D.ordinal()) {
            case 1:
                this.mWarpTransformType3D = TransformType3D.ImproveXYPlanes;
                break;
            case 2:
                this.mWarpTransformType3D = TransformType3D.ImproveXZPlanes;
                break;
            default:
                switch (this.mDomainWarpType) {
                    case OpenSimplex2:
                    case OpenSimplex2Reduced:
                        this.mWarpTransformType3D = TransformType3D.DefaultOpenSimplex2;
                        break;
                    default:
                        this.mWarpTransformType3D = TransformType3D.None;
                        break;
                }
                break;
        }
    }

    private float GenFractalFBm(float x, float y) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; i++) {
            int i2 = seed;
            seed++;
            float noise = GenNoiseSingle(i2, x, y);
            sum += noise * amp;
            float amp2 = amp * Lerp(1.0f, FastMin(noise + 1.0f, 2.0f) * 0.5f, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            amp = amp2 * this.mGain;
        }
        return sum;
    }

    private float GenFractalFBm(float x, float y, float z) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; i++) {
            int i2 = seed;
            seed++;
            float noise = GenNoiseSingle(i2, x, y, z);
            sum += noise * amp;
            float amp2 = amp * Lerp(1.0f, (noise + 1.0f) * 0.5f, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            z *= this.mLacunarity;
            amp = amp2 * this.mGain;
        }
        return sum;
    }

    private float GenFractalRidged(float x, float y) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; i++) {
            int i2 = seed;
            seed++;
            float noise = FastAbs(GenNoiseSingle(i2, x, y));
            sum += ((noise * (-2.0f)) + 1.0f) * amp;
            float amp2 = amp * Lerp(1.0f, 1.0f - noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            amp = amp2 * this.mGain;
        }
        return sum;
    }

    private float GenFractalRidged(float x, float y, float z) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; i++) {
            int i2 = seed;
            seed++;
            float noise = FastAbs(GenNoiseSingle(i2, x, y, z));
            sum += ((noise * (-2.0f)) + 1.0f) * amp;
            float amp2 = amp * Lerp(1.0f, 1.0f - noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            z *= this.mLacunarity;
            amp = amp2 * this.mGain;
        }
        return sum;
    }

    private float GenFractalPingPong(float x, float y) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; i++) {
            int i2 = seed;
            seed++;
            float noise = PingPong((GenNoiseSingle(i2, x, y) + 1.0f) * this.mPingPongStrength);
            sum += (noise - 0.5f) * 2.0f * amp;
            float amp2 = amp * Lerp(1.0f, noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            amp = amp2 * this.mGain;
        }
        return sum;
    }

    private float GenFractalPingPong(float x, float y, float z) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; i++) {
            int i2 = seed;
            seed++;
            float noise = PingPong((GenNoiseSingle(i2, x, y, z) + 1.0f) * this.mPingPongStrength);
            sum += (noise - 0.5f) * 2.0f * amp;
            float amp2 = amp * Lerp(1.0f, noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            z *= this.mLacunarity;
            amp = amp2 * this.mGain;
        }
        return sum;
    }

    private float SingleSimplex(int seed, float x, float y) {
        float n0;
        float n2;
        float n1;
        int i = FastFloor(x);
        int j = FastFloor(y);
        float xi = x - i;
        float yi = y - j;
        float t = (xi + yi) * 0.21132487f;
        float x0 = xi - t;
        float y0 = yi - t;
        int i2 = i * PrimeX;
        int j2 = j * PrimeY;
        float a = (0.5f - (x0 * x0)) - (y0 * y0);
        if (a <= 0.0f) {
            n0 = 0.0f;
        } else {
            n0 = a * a * a * a * GradCoord(seed, i2, j2, x0, y0);
        }
        float c = (3.1547005f * t) + (-0.6666666f) + a;
        if (c <= 0.0f) {
            n2 = 0.0f;
        } else {
            float x2 = x0 - 0.57735026f;
            float y2 = y0 - 0.57735026f;
            n2 = c * c * c * c * GradCoord(seed, i2 + PrimeX, j2 + PrimeY, x2, y2);
        }
        if (y0 > x0) {
            float x1 = x0 + 0.21132487f;
            float y1 = y0 - 0.7886751f;
            float b = (0.5f - (x1 * x1)) - (y1 * y1);
            if (b <= 0.0f) {
                n1 = 0.0f;
            } else {
                n1 = b * b * b * b * GradCoord(seed, i2, j2 + PrimeY, x1, y1);
            }
        } else {
            float x12 = x0 - 0.7886751f;
            float y12 = y0 + 0.21132487f;
            float b2 = (0.5f - (x12 * x12)) - (y12 * y12);
            if (b2 <= 0.0f) {
                n1 = 0.0f;
            } else {
                n1 = b2 * b2 * b2 * b2 * GradCoord(seed, i2 + PrimeX, j2, x12, y12);
            }
        }
        return (n0 + n1 + n2) * 99.83685f;
    }

    private float SingleOpenSimplex2(int seed, float x, float y, float z) {
        int i = FastRound(x);
        int j = FastRound(y);
        int k = FastRound(z);
        float x0 = x - i;
        float y0 = y - j;
        float z0 = z - k;
        int xNSign = ((int) ((-1.0f) - x0)) | 1;
        int yNSign = ((int) ((-1.0f) - y0)) | 1;
        int zNSign = ((int) ((-1.0f) - z0)) | 1;
        float ax0 = xNSign * (-x0);
        float ay0 = yNSign * (-y0);
        float az0 = zNSign * (-z0);
        int i2 = i * PrimeX;
        int j2 = j * PrimeY;
        int k2 = k * PrimeZ;
        float value = 0.0f;
        float a = (0.6f - (x0 * x0)) - ((y0 * y0) + (z0 * z0));
        int l = 0;
        while (true) {
            if (a > 0.0f) {
                value += a * a * a * a * GradCoord(seed, i2, j2, k2, x0, y0, z0);
            }
            if (ax0 >= ay0 && ax0 >= az0) {
                float b = a + ax0 + ax0;
                if (b > 1.0f) {
                    float b2 = b - 1.0f;
                    value += b2 * b2 * b2 * b2 * GradCoord(seed, i2 - (xNSign * PrimeX), j2, k2, x0 + xNSign, y0, z0);
                }
            } else if (ay0 > ax0 && ay0 >= az0) {
                float b3 = a + ay0 + ay0;
                if (b3 > 1.0f) {
                    float b4 = b3 - 1.0f;
                    value += b4 * b4 * b4 * b4 * GradCoord(seed, i2, j2 - (yNSign * PrimeY), k2, x0, y0 + yNSign, z0);
                }
            } else {
                float b5 = a + az0 + az0;
                if (b5 > 1.0f) {
                    float b6 = b5 - 1.0f;
                    value += b6 * b6 * b6 * b6 * GradCoord(seed, i2, j2, k2 - (zNSign * PrimeZ), x0, y0, z0 + zNSign);
                }
            }
            if (l != 1) {
                ax0 = 0.5f - ax0;
                ay0 = 0.5f - ay0;
                az0 = 0.5f - az0;
                x0 = xNSign * ax0;
                y0 = yNSign * ay0;
                z0 = zNSign * az0;
                a += (0.75f - ax0) - (ay0 + az0);
                i2 += (xNSign >> 1) & PrimeX;
                j2 += (yNSign >> 1) & PrimeY;
                k2 += (zNSign >> 1) & PrimeZ;
                xNSign = -xNSign;
                yNSign = -yNSign;
                zNSign = -zNSign;
                seed ^= -1;
                l++;
            } else {
                return value * 32.694283f;
            }
        }
    }

    private float SingleOpenSimplex2S(int seed, float x, float y) {
        int i = FastFloor(x);
        int j = FastFloor(y);
        float xi = x - i;
        float yi = y - j;
        int i2 = i * PrimeX;
        int j2 = j * PrimeY;
        int i1 = i2 + PrimeX;
        int j1 = j2 + PrimeY;
        float t = (xi + yi) * 0.21132487f;
        float x0 = xi - t;
        float y0 = yi - t;
        float a0 = (0.6666667f - (x0 * x0)) - (y0 * y0);
        float value = a0 * a0 * a0 * a0 * GradCoord(seed, i2, j2, x0, y0);
        float a1 = (3.1547005f * t) + (-0.6666666f) + a0;
        float x1 = x0 - 0.57735026f;
        float y1 = y0 - 0.57735026f;
        float value2 = value + (a1 * a1 * a1 * a1 * GradCoord(seed, i1, j1, x1, y1));
        float xmyi = xi - yi;
        if (t > 0.21132487f) {
            if (xi + xmyi > 1.0f) {
                float x2 = x0 - 1.3660254f;
                float y2 = y0 - 0.3660254f;
                float a2 = (0.6666667f - (x2 * x2)) - (y2 * y2);
                if (a2 > 0.0f) {
                    value2 += a2 * a2 * a2 * a2 * GradCoord(seed, i2 + 1002250642, j2 + PrimeY, x2, y2);
                }
            } else {
                float x22 = x0 + 0.21132487f;
                float y22 = y0 - 0.7886751f;
                float a22 = (0.6666667f - (x22 * x22)) - (y22 * y22);
                if (a22 > 0.0f) {
                    value2 += a22 * a22 * a22 * a22 * GradCoord(seed, i2, j2 + PrimeY, x22, y22);
                }
            }
            if (yi - xmyi > 1.0f) {
                float x3 = x0 - 0.3660254f;
                float y3 = y0 - 1.3660254f;
                float a3 = (0.6666667f - (x3 * x3)) - (y3 * y3);
                if (a3 > 0.0f) {
                    value2 += a3 * a3 * a3 * a3 * GradCoord(seed, i2 + PrimeX, j2 - 2021106534, x3, y3);
                }
            } else {
                float x32 = x0 - 0.7886751f;
                float y32 = y0 + 0.21132487f;
                float a32 = (0.6666667f - (x32 * x32)) - (y32 * y32);
                if (a32 > 0.0f) {
                    value2 += a32 * a32 * a32 * a32 * GradCoord(seed, i2 + PrimeX, j2, x32, y32);
                }
            }
        } else {
            if (xi + xmyi < 0.0f) {
                float x23 = x0 + 0.7886751f;
                float y23 = y0 - 0.21132487f;
                float a23 = (0.6666667f - (x23 * x23)) - (y23 * y23);
                if (a23 > 0.0f) {
                    value2 += a23 * a23 * a23 * a23 * GradCoord(seed, i2 - PrimeX, j2, x23, y23);
                }
            } else {
                float x24 = x0 - 0.7886751f;
                float y24 = y0 + 0.21132487f;
                float a24 = (0.6666667f - (x24 * x24)) - (y24 * y24);
                if (a24 > 0.0f) {
                    value2 += a24 * a24 * a24 * a24 * GradCoord(seed, i2 + PrimeX, j2, x24, y24);
                }
            }
            if (yi < xmyi) {
                float x25 = x0 - 0.21132487f;
                float y25 = y0 - (-0.7886751f);
                float a25 = (0.6666667f - (x25 * x25)) - (y25 * y25);
                if (a25 > 0.0f) {
                    value2 += a25 * a25 * a25 * a25 * GradCoord(seed, i2, j2 - PrimeY, x25, y25);
                }
            } else {
                float x26 = x0 + 0.21132487f;
                float y26 = y0 - 0.7886751f;
                float a26 = (0.6666667f - (x26 * x26)) - (y26 * y26);
                if (a26 > 0.0f) {
                    value2 += a26 * a26 * a26 * a26 * GradCoord(seed, i2, j2 + PrimeY, x26, y26);
                }
            }
        }
        return value2 * 18.241962f;
    }

    private float SingleOpenSimplex2S(int seed, float x, float y, float z) {
        int i = FastFloor(x);
        int j = FastFloor(y);
        int k = FastFloor(z);
        float xi = x - i;
        float yi = y - j;
        float zi = z - k;
        int i2 = i * PrimeX;
        int j2 = j * PrimeY;
        int k2 = k * PrimeZ;
        int seed2 = seed + 1293373;
        int xNMask = (int) ((-0.5f) - xi);
        int yNMask = (int) ((-0.5f) - yi);
        int zNMask = (int) ((-0.5f) - zi);
        float x0 = xi + xNMask;
        float y0 = yi + yNMask;
        float z0 = zi + zNMask;
        float a0 = ((0.75f - (x0 * x0)) - (y0 * y0)) - (z0 * z0);
        float value = a0 * a0 * a0 * a0 * GradCoord(seed, i2 + (xNMask & PrimeX), j2 + (yNMask & PrimeY), k2 + (zNMask & PrimeZ), x0, y0, z0);
        float x1 = xi - 0.5f;
        float y1 = yi - 0.5f;
        float z1 = zi - 0.5f;
        float a1 = ((0.75f - (x1 * x1)) - (y1 * y1)) - (z1 * z1);
        float value2 = value + (a1 * a1 * a1 * a1 * GradCoord(seed2, i2 + PrimeX, j2 + PrimeY, k2 + PrimeZ, x1, y1, z1));
        float xAFlipMask0 = ((xNMask | 1) << 1) * x1;
        float yAFlipMask0 = ((yNMask | 1) << 1) * y1;
        float zAFlipMask0 = ((zNMask | 1) << 1) * z1;
        float xAFlipMask1 = (((-2) - (xNMask << 2)) * x1) - 1.0f;
        float yAFlipMask1 = (((-2) - (yNMask << 2)) * y1) - 1.0f;
        float zAFlipMask1 = (((-2) - (zNMask << 2)) * z1) - 1.0f;
        boolean skip5 = false;
        float a2 = xAFlipMask0 + a0;
        if (a2 > 0.0f) {
            float x2 = x0 - (xNMask | 1);
            value2 += a2 * a2 * a2 * a2 * GradCoord(seed, i2 + ((xNMask ^ (-1)) & PrimeX), j2 + (yNMask & PrimeY), k2 + (zNMask & PrimeZ), x2, y0, z0);
        } else {
            float a3 = yAFlipMask0 + zAFlipMask0 + a0;
            if (a3 > 0.0f) {
                float y3 = y0 - (yNMask | 1);
                float z3 = z0 - (zNMask | 1);
                value2 += a3 * a3 * a3 * a3 * GradCoord(seed, i2 + (xNMask & PrimeX), j2 + ((yNMask ^ (-1)) & PrimeY), k2 + ((zNMask ^ (-1)) & PrimeZ), x0, y3, z3);
            }
            float a4 = xAFlipMask1 + a1;
            if (a4 > 0.0f) {
                float x4 = (xNMask | 1) + x1;
                value2 += a4 * a4 * a4 * a4 * GradCoord(seed2, i2 + (xNMask & 1002250642), j2 + PrimeY, k2 + PrimeZ, x4, y1, z1);
                skip5 = true;
            }
        }
        boolean skip9 = false;
        float a6 = yAFlipMask0 + a0;
        if (a6 > 0.0f) {
            float y6 = y0 - (yNMask | 1);
            value2 += a6 * a6 * a6 * a6 * GradCoord(seed, i2 + (xNMask & PrimeX), j2 + ((yNMask ^ (-1)) & PrimeY), k2 + (zNMask & PrimeZ), x0, y6, z0);
        } else {
            float a7 = xAFlipMask0 + zAFlipMask0 + a0;
            if (a7 > 0.0f) {
                float x7 = x0 - (xNMask | 1);
                float z7 = z0 - (zNMask | 1);
                value2 += a7 * a7 * a7 * a7 * GradCoord(seed, i2 + ((xNMask ^ (-1)) & PrimeX), j2 + (yNMask & PrimeY), k2 + ((zNMask ^ (-1)) & PrimeZ), x7, y0, z7);
            }
            float a8 = yAFlipMask1 + a1;
            if (a8 > 0.0f) {
                float y8 = (yNMask | 1) + y1;
                value2 += a8 * a8 * a8 * a8 * GradCoord(seed2, i2 + PrimeX, j2 + (yNMask & (-2021106534)), k2 + PrimeZ, x1, y8, z1);
                skip9 = true;
            }
        }
        boolean skipD = false;
        float aA = zAFlipMask0 + a0;
        if (aA > 0.0f) {
            float zA = z0 - (zNMask | 1);
            value2 += aA * aA * aA * aA * GradCoord(seed, i2 + (xNMask & PrimeX), j2 + (yNMask & PrimeY), k2 + ((zNMask ^ (-1)) & PrimeZ), x0, y0, zA);
        } else {
            float aB = xAFlipMask0 + yAFlipMask0 + a0;
            if (aB > 0.0f) {
                float xB = x0 - (xNMask | 1);
                float yB = y0 - (yNMask | 1);
                value2 += aB * aB * aB * aB * GradCoord(seed, i2 + ((xNMask ^ (-1)) & PrimeX), j2 + ((yNMask ^ (-1)) & PrimeY), k2 + (zNMask & PrimeZ), xB, yB, z0);
            }
            float aC = zAFlipMask1 + a1;
            if (aC > 0.0f) {
                float zC = (zNMask | 1) + z1;
                value2 += aC * aC * aC * aC * GradCoord(seed2, i2 + PrimeX, j2 + PrimeY, k2 + (zNMask & (-854139810)), x1, y1, zC);
                skipD = true;
            }
        }
        if (!skip5) {
            float a5 = yAFlipMask1 + zAFlipMask1 + a1;
            if (a5 > 0.0f) {
                float y5 = (yNMask | 1) + y1;
                float z5 = (zNMask | 1) + z1;
                value2 += a5 * a5 * a5 * a5 * GradCoord(seed2, i2 + PrimeX, j2 + (yNMask & (-2021106534)), k2 + (zNMask & (-854139810)), x1, y5, z5);
            }
        }
        if (!skip9) {
            float a9 = xAFlipMask1 + zAFlipMask1 + a1;
            if (a9 > 0.0f) {
                float x9 = (xNMask | 1) + x1;
                float z9 = (zNMask | 1) + z1;
                value2 += a9 * a9 * a9 * a9 * GradCoord(seed2, i2 + (xNMask & 1002250642), j2 + PrimeY, k2 + (zNMask & (-854139810)), x9, y1, z9);
            }
        }
        if (!skipD) {
            float aD = xAFlipMask1 + yAFlipMask1 + a1;
            if (aD > 0.0f) {
                float xD = (xNMask | 1) + x1;
                float yD = (yNMask | 1) + y1;
                value2 += aD * aD * aD * aD * GradCoord(seed2, i2 + (xNMask & 1002250642), j2 + (yNMask & (-2021106534)), k2 + PrimeZ, xD, yD, z1);
            }
        }
        return value2 * 9.046026f;
    }

    private float SingleCellular(int seed, float x, float y) {
        int xr = FastRound(x);
        int yr = FastRound(y);
        float distance0 = Float.MAX_VALUE;
        float distance1 = Float.MAX_VALUE;
        int closestHash = 0;
        float cellularJitter = 0.43701595f * this.mCellularJitterModifier;
        int xPrimed = (xr - 1) * PrimeX;
        int yPrimedBase = (yr - 1) * PrimeY;
        switch (this.mCellularDistanceFunction) {
            case Euclidean:
            case EuclideanSq:
            default:
                for (int xi = xr - 1; xi <= xr + 1; xi++) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; yi++) {
                        int hash = Hash(seed, xPrimed, yPrimed);
                        int idx = hash & 510;
                        float vecX = (xi - x) + (RandVecs2D[idx] * cellularJitter);
                        float vecY = (yi - y) + (RandVecs2D[idx | 1] * cellularJitter);
                        float newDistance = (vecX * vecX) + (vecY * vecY);
                        distance1 = FastMax(FastMin(distance1, newDistance), distance0);
                        if (newDistance < distance0) {
                            distance0 = newDistance;
                            closestHash = hash;
                        }
                        yPrimed += PrimeY;
                    }
                    xPrimed += PrimeX;
                }
                break;
            case Manhattan:
                for (int xi2 = xr - 1; xi2 <= xr + 1; xi2++) {
                    int yPrimed2 = yPrimedBase;
                    for (int yi2 = yr - 1; yi2 <= yr + 1; yi2++) {
                        int hash2 = Hash(seed, xPrimed, yPrimed2);
                        int idx2 = hash2 & 510;
                        float newDistance2 = FastAbs((xi2 - x) + (RandVecs2D[idx2] * cellularJitter)) + FastAbs((yi2 - y) + (RandVecs2D[idx2 | 1] * cellularJitter));
                        distance1 = FastMax(FastMin(distance1, newDistance2), distance0);
                        if (newDistance2 < distance0) {
                            distance0 = newDistance2;
                            closestHash = hash2;
                        }
                        yPrimed2 += PrimeY;
                    }
                    xPrimed += PrimeX;
                }
                break;
            case Hybrid:
                for (int xi3 = xr - 1; xi3 <= xr + 1; xi3++) {
                    int yPrimed3 = yPrimedBase;
                    for (int yi3 = yr - 1; yi3 <= yr + 1; yi3++) {
                        int hash3 = Hash(seed, xPrimed, yPrimed3);
                        int idx3 = hash3 & 510;
                        float vecX2 = (xi3 - x) + (RandVecs2D[idx3] * cellularJitter);
                        float vecY2 = (yi3 - y) + (RandVecs2D[idx3 | 1] * cellularJitter);
                        float newDistance3 = FastAbs(vecX2) + FastAbs(vecY2) + (vecX2 * vecX2) + (vecY2 * vecY2);
                        distance1 = FastMax(FastMin(distance1, newDistance3), distance0);
                        if (newDistance3 < distance0) {
                            distance0 = newDistance3;
                            closestHash = hash3;
                        }
                        yPrimed3 += PrimeY;
                    }
                    xPrimed += PrimeX;
                }
                break;
        }
        if (this.mCellularDistanceFunction == CellularDistanceFunction.Euclidean && this.mCellularReturnType != CellularReturnType.CellValue) {
            distance0 = FastSqrt(distance0);
            if (this.mCellularReturnType != CellularReturnType.Distance) {
                distance1 = FastSqrt(distance1);
            }
        }
        switch (this.mCellularReturnType) {
            case CellValue:
                return closestHash * 4.656613E-10f;
            case Distance:
                return distance0 - 1.0f;
            case Distance2:
                return distance1 - 1.0f;
            case Distance2Add:
                return ((distance1 + distance0) * 0.5f) - 1.0f;
            case Distance2Sub:
                return (distance1 - distance0) - 1.0f;
            case Distance2Mul:
                return ((distance1 * distance0) * 0.5f) - 1.0f;
            case Distance2Div:
                return (distance0 / distance1) - 1.0f;
            default:
                return 0.0f;
        }
    }

    private float SingleCellular(int seed, float x, float y, float z) {
        int xr = FastRound(x);
        int yr = FastRound(y);
        int zr = FastRound(z);
        float distance0 = Float.MAX_VALUE;
        float distance1 = Float.MAX_VALUE;
        int closestHash = 0;
        float cellularJitter = 0.39614353f * this.mCellularJitterModifier;
        int xPrimed = (xr - 1) * PrimeX;
        int yPrimedBase = (yr - 1) * PrimeY;
        int zPrimedBase = (zr - 1) * PrimeZ;
        switch (this.mCellularDistanceFunction) {
            case Euclidean:
            case EuclideanSq:
                for (int xi = xr - 1; xi <= xr + 1; xi++) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; yi++) {
                        int zPrimed = zPrimedBase;
                        for (int zi = zr - 1; zi <= zr + 1; zi++) {
                            int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
                            int idx = hash & 1020;
                            float vecX = (xi - x) + (RandVecs3D[idx] * cellularJitter);
                            float vecY = (yi - y) + (RandVecs3D[idx | 1] * cellularJitter);
                            float vecZ = (zi - z) + (RandVecs3D[idx | 2] * cellularJitter);
                            float newDistance = (vecX * vecX) + (vecY * vecY) + (vecZ * vecZ);
                            distance1 = FastMax(FastMin(distance1, newDistance), distance0);
                            if (newDistance < distance0) {
                                distance0 = newDistance;
                                closestHash = hash;
                            }
                            zPrimed += PrimeZ;
                        }
                        yPrimed += PrimeY;
                    }
                    xPrimed += PrimeX;
                }
                break;
            case Manhattan:
                for (int xi2 = xr - 1; xi2 <= xr + 1; xi2++) {
                    int yPrimed2 = yPrimedBase;
                    for (int yi2 = yr - 1; yi2 <= yr + 1; yi2++) {
                        int zPrimed2 = zPrimedBase;
                        for (int zi2 = zr - 1; zi2 <= zr + 1; zi2++) {
                            int hash2 = Hash(seed, xPrimed, yPrimed2, zPrimed2);
                            int idx2 = hash2 & 1020;
                            float newDistance2 = FastAbs((xi2 - x) + (RandVecs3D[idx2] * cellularJitter)) + FastAbs((yi2 - y) + (RandVecs3D[idx2 | 1] * cellularJitter)) + FastAbs((zi2 - z) + (RandVecs3D[idx2 | 2] * cellularJitter));
                            distance1 = FastMax(FastMin(distance1, newDistance2), distance0);
                            if (newDistance2 < distance0) {
                                distance0 = newDistance2;
                                closestHash = hash2;
                            }
                            zPrimed2 += PrimeZ;
                        }
                        yPrimed2 += PrimeY;
                    }
                    xPrimed += PrimeX;
                }
                break;
            case Hybrid:
                for (int xi3 = xr - 1; xi3 <= xr + 1; xi3++) {
                    int yPrimed3 = yPrimedBase;
                    for (int yi3 = yr - 1; yi3 <= yr + 1; yi3++) {
                        int zPrimed3 = zPrimedBase;
                        for (int zi3 = zr - 1; zi3 <= zr + 1; zi3++) {
                            int hash3 = Hash(seed, xPrimed, yPrimed3, zPrimed3);
                            int idx3 = hash3 & 1020;
                            float vecX2 = (xi3 - x) + (RandVecs3D[idx3] * cellularJitter);
                            float vecY2 = (yi3 - y) + (RandVecs3D[idx3 | 1] * cellularJitter);
                            float vecZ2 = (zi3 - z) + (RandVecs3D[idx3 | 2] * cellularJitter);
                            float newDistance3 = FastAbs(vecX2) + FastAbs(vecY2) + FastAbs(vecZ2) + (vecX2 * vecX2) + (vecY2 * vecY2) + (vecZ2 * vecZ2);
                            distance1 = FastMax(FastMin(distance1, newDistance3), distance0);
                            if (newDistance3 < distance0) {
                                distance0 = newDistance3;
                                closestHash = hash3;
                            }
                            zPrimed3 += PrimeZ;
                        }
                        yPrimed3 += PrimeY;
                    }
                    xPrimed += PrimeX;
                }
                break;
        }
        if (this.mCellularDistanceFunction == CellularDistanceFunction.Euclidean && this.mCellularReturnType != CellularReturnType.CellValue) {
            distance0 = FastSqrt(distance0);
            if (this.mCellularReturnType != CellularReturnType.Distance) {
                distance1 = FastSqrt(distance1);
            }
        }
        switch (this.mCellularReturnType) {
            case CellValue:
                return closestHash * 4.656613E-10f;
            case Distance:
                return distance0 - 1.0f;
            case Distance2:
                return distance1 - 1.0f;
            case Distance2Add:
                return ((distance1 + distance0) * 0.5f) - 1.0f;
            case Distance2Sub:
                return (distance1 - distance0) - 1.0f;
            case Distance2Mul:
                return ((distance1 * distance0) * 0.5f) - 1.0f;
            case Distance2Div:
                return (distance0 / distance1) - 1.0f;
            default:
                return 0.0f;
        }
    }

    private float SinglePerlin(int seed, float x, float y) {
        int x0 = FastFloor(x);
        int y0 = FastFloor(y);
        float xd0 = x - x0;
        float yd0 = y - y0;
        float xd1 = xd0 - 1.0f;
        float yd1 = yd0 - 1.0f;
        float xs = InterpQuintic(xd0);
        float ys = InterpQuintic(yd0);
        int x02 = x0 * PrimeX;
        int y02 = y0 * PrimeY;
        int x1 = x02 + PrimeX;
        int y1 = y02 + PrimeY;
        float xf0 = Lerp(GradCoord(seed, x02, y02, xd0, yd0), GradCoord(seed, x1, y02, xd1, yd0), xs);
        float xf1 = Lerp(GradCoord(seed, x02, y1, xd0, yd1), GradCoord(seed, x1, y1, xd1, yd1), xs);
        return Lerp(xf0, xf1, ys) * 1.4247692f;
    }

    private float SinglePerlin(int seed, float x, float y, float z) {
        int x0 = FastFloor(x);
        int y0 = FastFloor(y);
        int z0 = FastFloor(z);
        float xd0 = x - x0;
        float yd0 = y - y0;
        float zd0 = z - z0;
        float xd1 = xd0 - 1.0f;
        float yd1 = yd0 - 1.0f;
        float zd1 = zd0 - 1.0f;
        float xs = InterpQuintic(xd0);
        float ys = InterpQuintic(yd0);
        float zs = InterpQuintic(zd0);
        int x02 = x0 * PrimeX;
        int y02 = y0 * PrimeY;
        int z02 = z0 * PrimeZ;
        int x1 = x02 + PrimeX;
        int y1 = y02 + PrimeY;
        int z1 = z02 + PrimeZ;
        float xf00 = Lerp(GradCoord(seed, x02, y02, z02, xd0, yd0, zd0), GradCoord(seed, x1, y02, z02, xd1, yd0, zd0), xs);
        float xf10 = Lerp(GradCoord(seed, x02, y1, z02, xd0, yd1, zd0), GradCoord(seed, x1, y1, z02, xd1, yd1, zd0), xs);
        float xf01 = Lerp(GradCoord(seed, x02, y02, z1, xd0, yd0, zd1), GradCoord(seed, x1, y02, z1, xd1, yd0, zd1), xs);
        float xf11 = Lerp(GradCoord(seed, x02, y1, z1, xd0, yd1, zd1), GradCoord(seed, x1, y1, z1, xd1, yd1, zd1), xs);
        float yf0 = Lerp(xf00, xf10, ys);
        float yf1 = Lerp(xf01, xf11, ys);
        return Lerp(yf0, yf1, zs) * 0.9649214f;
    }

    private float SingleValueCubic(int seed, float x, float y) {
        int x1 = FastFloor(x);
        int y1 = FastFloor(y);
        float xs = x - x1;
        float ys = y - y1;
        int x12 = x1 * PrimeX;
        int y12 = y1 * PrimeY;
        int x0 = x12 - PrimeX;
        int y0 = y12 - PrimeY;
        int x2 = x12 + PrimeX;
        int y2 = y12 + PrimeY;
        int x3 = x12 + 1002250642;
        int y3 = y12 - 2021106534;
        return CubicLerp(CubicLerp(ValCoord(seed, x0, y0), ValCoord(seed, x12, y0), ValCoord(seed, x2, y0), ValCoord(seed, x3, y0), xs), CubicLerp(ValCoord(seed, x0, y12), ValCoord(seed, x12, y12), ValCoord(seed, x2, y12), ValCoord(seed, x3, y12), xs), CubicLerp(ValCoord(seed, x0, y2), ValCoord(seed, x12, y2), ValCoord(seed, x2, y2), ValCoord(seed, x3, y2), xs), CubicLerp(ValCoord(seed, x0, y3), ValCoord(seed, x12, y3), ValCoord(seed, x2, y3), ValCoord(seed, x3, y3), xs), ys) * 0.44444445f;
    }

    private float SingleValueCubic(int seed, float x, float y, float z) {
        int x1 = FastFloor(x);
        int y1 = FastFloor(y);
        int z1 = FastFloor(z);
        float xs = x - x1;
        float ys = y - y1;
        float zs = z - z1;
        int x12 = x1 * PrimeX;
        int y12 = y1 * PrimeY;
        int z12 = z1 * PrimeZ;
        int x0 = x12 - PrimeX;
        int y0 = y12 - PrimeY;
        int z0 = z12 - PrimeZ;
        int x2 = x12 + PrimeX;
        int y2 = y12 + PrimeY;
        int z2 = z12 + PrimeZ;
        int x3 = x12 + 1002250642;
        int y3 = y12 - 2021106534;
        int z3 = z12 - 854139810;
        return CubicLerp(CubicLerp(CubicLerp(ValCoord(seed, x0, y0, z0), ValCoord(seed, x12, y0, z0), ValCoord(seed, x2, y0, z0), ValCoord(seed, x3, y0, z0), xs), CubicLerp(ValCoord(seed, x0, y12, z0), ValCoord(seed, x12, y12, z0), ValCoord(seed, x2, y12, z0), ValCoord(seed, x3, y12, z0), xs), CubicLerp(ValCoord(seed, x0, y2, z0), ValCoord(seed, x12, y2, z0), ValCoord(seed, x2, y2, z0), ValCoord(seed, x3, y2, z0), xs), CubicLerp(ValCoord(seed, x0, y3, z0), ValCoord(seed, x12, y3, z0), ValCoord(seed, x2, y3, z0), ValCoord(seed, x3, y3, z0), xs), ys), CubicLerp(CubicLerp(ValCoord(seed, x0, y0, z12), ValCoord(seed, x12, y0, z12), ValCoord(seed, x2, y0, z12), ValCoord(seed, x3, y0, z12), xs), CubicLerp(ValCoord(seed, x0, y12, z12), ValCoord(seed, x12, y12, z12), ValCoord(seed, x2, y12, z12), ValCoord(seed, x3, y12, z12), xs), CubicLerp(ValCoord(seed, x0, y2, z12), ValCoord(seed, x12, y2, z12), ValCoord(seed, x2, y2, z12), ValCoord(seed, x3, y2, z12), xs), CubicLerp(ValCoord(seed, x0, y3, z12), ValCoord(seed, x12, y3, z12), ValCoord(seed, x2, y3, z12), ValCoord(seed, x3, y3, z12), xs), ys), CubicLerp(CubicLerp(ValCoord(seed, x0, y0, z2), ValCoord(seed, x12, y0, z2), ValCoord(seed, x2, y0, z2), ValCoord(seed, x3, y0, z2), xs), CubicLerp(ValCoord(seed, x0, y12, z2), ValCoord(seed, x12, y12, z2), ValCoord(seed, x2, y12, z2), ValCoord(seed, x3, y12, z2), xs), CubicLerp(ValCoord(seed, x0, y2, z2), ValCoord(seed, x12, y2, z2), ValCoord(seed, x2, y2, z2), ValCoord(seed, x3, y2, z2), xs), CubicLerp(ValCoord(seed, x0, y3, z2), ValCoord(seed, x12, y3, z2), ValCoord(seed, x2, y3, z2), ValCoord(seed, x3, y3, z2), xs), ys), CubicLerp(CubicLerp(ValCoord(seed, x0, y0, z3), ValCoord(seed, x12, y0, z3), ValCoord(seed, x2, y0, z3), ValCoord(seed, x3, y0, z3), xs), CubicLerp(ValCoord(seed, x0, y12, z3), ValCoord(seed, x12, y12, z3), ValCoord(seed, x2, y12, z3), ValCoord(seed, x3, y12, z3), xs), CubicLerp(ValCoord(seed, x0, y2, z3), ValCoord(seed, x12, y2, z3), ValCoord(seed, x2, y2, z3), ValCoord(seed, x3, y2, z3), xs), CubicLerp(ValCoord(seed, x0, y3, z3), ValCoord(seed, x12, y3, z3), ValCoord(seed, x2, y3, z3), ValCoord(seed, x3, y3, z3), xs), ys), zs) * 0.2962963f;
    }

    private float SingleValue(int seed, float x, float y) {
        int x0 = FastFloor(x);
        int y0 = FastFloor(y);
        float xs = InterpHermite(x - x0);
        float ys = InterpHermite(y - y0);
        int x02 = x0 * PrimeX;
        int y02 = y0 * PrimeY;
        int x1 = x02 + PrimeX;
        int y1 = y02 + PrimeY;
        float xf0 = Lerp(ValCoord(seed, x02, y02), ValCoord(seed, x1, y02), xs);
        float xf1 = Lerp(ValCoord(seed, x02, y1), ValCoord(seed, x1, y1), xs);
        return Lerp(xf0, xf1, ys);
    }

    private float SingleValue(int seed, float x, float y, float z) {
        int x0 = FastFloor(x);
        int y0 = FastFloor(y);
        int z0 = FastFloor(z);
        float xs = InterpHermite(x - x0);
        float ys = InterpHermite(y - y0);
        float zs = InterpHermite(z - z0);
        int x02 = x0 * PrimeX;
        int y02 = y0 * PrimeY;
        int z02 = z0 * PrimeZ;
        int x1 = x02 + PrimeX;
        int y1 = y02 + PrimeY;
        int z1 = z02 + PrimeZ;
        float xf00 = Lerp(ValCoord(seed, x02, y02, z02), ValCoord(seed, x1, y02, z02), xs);
        float xf10 = Lerp(ValCoord(seed, x02, y1, z02), ValCoord(seed, x1, y1, z02), xs);
        float xf01 = Lerp(ValCoord(seed, x02, y02, z1), ValCoord(seed, x1, y02, z1), xs);
        float xf11 = Lerp(ValCoord(seed, x02, y1, z1), ValCoord(seed, x1, y1, z1), xs);
        float yf0 = Lerp(xf00, xf10, ys);
        float yf1 = Lerp(xf01, xf11, ys);
        return Lerp(yf0, yf1, zs);
    }

    private void DoSingleDomainWarp(int seed, float amp, float freq, float x, float y, Vector2 coord) {
        switch (this.mDomainWarpType) {
            case OpenSimplex2:
                SingleDomainWarpSimplexGradient(seed, amp * 38.283688f, freq, x, y, coord, false);
                break;
            case OpenSimplex2Reduced:
                SingleDomainWarpSimplexGradient(seed, amp * 16.0f, freq, x, y, coord, true);
                break;
            case BasicGrid:
                SingleDomainWarpBasicGrid(seed, amp, freq, x, y, coord);
                break;
        }
    }

    private void DoSingleDomainWarp(int seed, float amp, float freq, float x, float y, float z, Vector3 coord) {
        switch (this.mDomainWarpType) {
            case OpenSimplex2:
                SingleDomainWarpOpenSimplex2Gradient(seed, amp * 32.694283f, freq, x, y, z, coord, false);
                break;
            case OpenSimplex2Reduced:
                SingleDomainWarpOpenSimplex2Gradient(seed, amp * 7.716049f, freq, x, y, z, coord, true);
                break;
            case BasicGrid:
                SingleDomainWarpBasicGrid(seed, amp, freq, x, y, z, coord);
                break;
        }
    }

    private void DomainWarpSingle(Vector2 coord) {
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        float xs = coord.x;
        float ys = coord.y;
        switch (this.mDomainWarpType) {
            case OpenSimplex2:
            case OpenSimplex2Reduced:
                float t = (xs + ys) * 0.3660254f;
                xs += t;
                ys += t;
                break;
        }
        DoSingleDomainWarp(seed, amp, freq, xs, ys, coord);
    }

    private void DomainWarpSingle(Vector3 coord) {
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        float xs = coord.x;
        float ys = coord.y;
        float zs = coord.z;
        switch (this.mWarpTransformType3D.ordinal()) {
            case 1:
                float xy = xs + ys;
                float s2 = xy * (-0.21132487f);
                float zs2 = zs * 0.57735026f;
                xs += s2 - zs2;
                ys = (ys + s2) - zs2;
                zs = zs2 + (xy * 0.57735026f);
                break;
            case 2:
                float xz = xs + zs;
                float s22 = xz * (-0.21132487f);
                float ys2 = ys * 0.57735026f;
                xs += s22 - ys2;
                zs += s22 - ys2;
                ys = ys2 + (xz * 0.57735026f);
                break;
            case 3:
                float r = (xs + ys + zs) * 0.6666667f;
                xs = r - xs;
                ys = r - ys;
                zs = r - zs;
                break;
        }
        DoSingleDomainWarp(seed, amp, freq, xs, ys, zs, coord);
    }

    private void DomainWarpFractalProgressive(Vector2 coord) {
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; i++) {
            float xs = coord.x;
            float ys = coord.y;
            switch (this.mDomainWarpType) {
                case OpenSimplex2:
                case OpenSimplex2Reduced:
                    float t = (xs + ys) * 0.3660254f;
                    xs += t;
                    ys += t;
                    break;
            }
            DoSingleDomainWarp(seed, amp, freq, xs, ys, coord);
            seed++;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }

    private void DomainWarpFractalProgressive(Vector3 coord) {
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; i++) {
            float xs = coord.x;
            float ys = coord.y;
            float zs = coord.z;
            switch (this.mWarpTransformType3D.ordinal()) {
                case 1:
                    float xy = xs + ys;
                    float s2 = xy * (-0.21132487f);
                    float zs2 = zs * 0.57735026f;
                    xs += s2 - zs2;
                    ys = (ys + s2) - zs2;
                    zs = zs2 + (xy * 0.57735026f);
                    break;
                case 2:
                    float xz = xs + zs;
                    float s22 = xz * (-0.21132487f);
                    float ys2 = ys * 0.57735026f;
                    xs += s22 - ys2;
                    zs += s22 - ys2;
                    ys = ys2 + (xz * 0.57735026f);
                    break;
                case 3:
                    float r = (xs + ys + zs) * 0.6666667f;
                    xs = r - xs;
                    ys = r - ys;
                    zs = r - zs;
                    break;
            }
            DoSingleDomainWarp(seed, amp, freq, xs, ys, zs, coord);
            seed++;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }

    private void DomainWarpFractalIndependent(Vector2 coord) {
        float xs = coord.x;
        float ys = coord.y;
        switch (this.mDomainWarpType) {
            case OpenSimplex2:
            case OpenSimplex2Reduced:
                float t = (xs + ys) * 0.3660254f;
                xs += t;
                ys += t;
                break;
        }
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; i++) {
            DoSingleDomainWarp(seed, amp, freq, xs, ys, coord);
            seed++;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }

    private void DomainWarpFractalIndependent(Vector3 coord) {
        float xs = coord.x;
        float ys = coord.y;
        float zs = coord.z;
        switch (this.mWarpTransformType3D.ordinal()) {
            case 1:
                float xy = xs + ys;
                float s2 = xy * (-0.21132487f);
                float zs2 = zs * 0.57735026f;
                xs += s2 - zs2;
                ys = (ys + s2) - zs2;
                zs = zs2 + (xy * 0.57735026f);
                break;
            case 2:
                float xz = xs + zs;
                float s22 = xz * (-0.21132487f);
                float ys2 = ys * 0.57735026f;
                xs += s22 - ys2;
                zs += s22 - ys2;
                ys = ys2 + (xz * 0.57735026f);
                break;
            case 3:
                float r = (xs + ys + zs) * 0.6666667f;
                xs = r - xs;
                ys = r - ys;
                zs = r - zs;
                break;
        }
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; i++) {
            DoSingleDomainWarp(seed, amp, freq, xs, ys, zs, coord);
            seed++;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }

    private void SingleDomainWarpBasicGrid(int seed, float warpAmp, float frequency, float x, float y, Vector2 coord) {
        float xf = x * frequency;
        float yf = y * frequency;
        int x0 = FastFloor(xf);
        int y0 = FastFloor(yf);
        float xs = InterpHermite(xf - x0);
        float ys = InterpHermite(yf - y0);
        int x02 = x0 * PrimeX;
        int y02 = y0 * PrimeY;
        int x1 = x02 + PrimeX;
        int y1 = y02 + PrimeY;
        int hash0 = Hash(seed, x02, y02) & 510;
        int hash1 = Hash(seed, x1, y02) & 510;
        float lx0x = Lerp(RandVecs2D[hash0], RandVecs2D[hash1], xs);
        float ly0x = Lerp(RandVecs2D[hash0 | 1], RandVecs2D[hash1 | 1], xs);
        int hash02 = Hash(seed, x02, y1) & 510;
        int hash12 = Hash(seed, x1, y1) & 510;
        float lx1x = Lerp(RandVecs2D[hash02], RandVecs2D[hash12], xs);
        float ly1x = Lerp(RandVecs2D[hash02 | 1], RandVecs2D[hash12 | 1], xs);
        coord.x += Lerp(lx0x, lx1x, ys) * warpAmp;
        coord.y += Lerp(ly0x, ly1x, ys) * warpAmp;
    }

    private void SingleDomainWarpBasicGrid(int seed, float warpAmp, float frequency, float x, float y, float z, Vector3 coord) {
        float xf = x * frequency;
        float yf = y * frequency;
        float zf = z * frequency;
        int x0 = FastFloor(xf);
        int y0 = FastFloor(yf);
        int z0 = FastFloor(zf);
        float xs = InterpHermite(xf - x0);
        float ys = InterpHermite(yf - y0);
        float zs = InterpHermite(zf - z0);
        int x02 = x0 * PrimeX;
        int y02 = y0 * PrimeY;
        int z02 = z0 * PrimeZ;
        int x1 = x02 + PrimeX;
        int y1 = y02 + PrimeY;
        int z1 = z02 + PrimeZ;
        int hash0 = Hash(seed, x02, y02, z02) & 1020;
        int hash1 = Hash(seed, x1, y02, z02) & 1020;
        float lx0x = Lerp(RandVecs3D[hash0], RandVecs3D[hash1], xs);
        float ly0x = Lerp(RandVecs3D[hash0 | 1], RandVecs3D[hash1 | 1], xs);
        float lz0x = Lerp(RandVecs3D[hash0 | 2], RandVecs3D[hash1 | 2], xs);
        int hash02 = Hash(seed, x02, y1, z02) & 1020;
        int hash12 = Hash(seed, x1, y1, z02) & 1020;
        float lx1x = Lerp(RandVecs3D[hash02], RandVecs3D[hash12], xs);
        float ly1x = Lerp(RandVecs3D[hash02 | 1], RandVecs3D[hash12 | 1], xs);
        float lz1x = Lerp(RandVecs3D[hash02 | 2], RandVecs3D[hash12 | 2], xs);
        float lx0y = Lerp(lx0x, lx1x, ys);
        float ly0y = Lerp(ly0x, ly1x, ys);
        float lz0y = Lerp(lz0x, lz1x, ys);
        int hash03 = Hash(seed, x02, y02, z1) & 1020;
        int hash13 = Hash(seed, x1, y02, z1) & 1020;
        float lx0x2 = Lerp(RandVecs3D[hash03], RandVecs3D[hash13], xs);
        float ly0x2 = Lerp(RandVecs3D[hash03 | 1], RandVecs3D[hash13 | 1], xs);
        float lz0x2 = Lerp(RandVecs3D[hash03 | 2], RandVecs3D[hash13 | 2], xs);
        int hash04 = Hash(seed, x02, y1, z1) & 1020;
        int hash14 = Hash(seed, x1, y1, z1) & 1020;
        float lx1x2 = Lerp(RandVecs3D[hash04], RandVecs3D[hash14], xs);
        float ly1x2 = Lerp(RandVecs3D[hash04 | 1], RandVecs3D[hash14 | 1], xs);
        float lz1x2 = Lerp(RandVecs3D[hash04 | 2], RandVecs3D[hash14 | 2], xs);
        coord.x += Lerp(lx0y, Lerp(lx0x2, lx1x2, ys), zs) * warpAmp;
        coord.y += Lerp(ly0y, Lerp(ly0x2, ly1x2, ys), zs) * warpAmp;
        coord.z += Lerp(lz0y, Lerp(lz0x2, lz1x2, ys), zs) * warpAmp;
    }

    private void SingleDomainWarpSimplexGradient(int seed, float warpAmp, float frequency, float x, float y, Vector2 coord, boolean outGradOnly) {
        float xo;
        float yo;
        float xo2;
        float yo2;
        float xo3;
        float yo3;
        float xo4;
        float yo4;
        float x2 = x * frequency;
        float y2 = y * frequency;
        int i = FastFloor(x2);
        int j = FastFloor(y2);
        float xi = x2 - i;
        float yi = y2 - j;
        float t = (xi + yi) * 0.21132487f;
        float x0 = xi - t;
        float y0 = yi - t;
        int i2 = i * PrimeX;
        int j2 = j * PrimeY;
        float vy = 0.0f;
        float vx = 0.0f;
        float a = (0.5f - (x0 * x0)) - (y0 * y0);
        if (a > 0.0f) {
            float aaaa = a * a * a * a;
            if (outGradOnly) {
                int hash = Hash(seed, i2, j2) & 510;
                xo4 = RandVecs2D[hash];
                yo4 = RandVecs2D[hash | 1];
            } else {
                int hash2 = Hash(seed, i2, j2);
                int index1 = hash2 & 254;
                int index2 = (hash2 >> 7) & 510;
                float xg = Gradients2D[index1];
                float yg = Gradients2D[index1 | 1];
                float value = (x0 * xg) + (y0 * yg);
                float xgo = RandVecs2D[index2];
                float ygo = RandVecs2D[index2 | 1];
                xo4 = value * xgo;
                yo4 = value * ygo;
            }
            vx = 0.0f + (aaaa * xo4);
            vy = 0.0f + (aaaa * yo4);
        }
        float c = (3.1547005f * t) + (-0.6666666f) + a;
        if (c > 0.0f) {
            float x22 = x0 - 0.57735026f;
            float y22 = y0 - 0.57735026f;
            float cccc = c * c * c * c;
            if (outGradOnly) {
                int hash3 = Hash(seed, i2 + PrimeX, j2 + PrimeY) & 510;
                xo3 = RandVecs2D[hash3];
                yo3 = RandVecs2D[hash3 | 1];
            } else {
                int hash4 = Hash(seed, i2 + PrimeX, j2 + PrimeY);
                int index12 = hash4 & 254;
                int index22 = (hash4 >> 7) & 510;
                float xg2 = Gradients2D[index12];
                float yg2 = Gradients2D[index12 | 1];
                float value2 = (x22 * xg2) + (y22 * yg2);
                float xgo2 = RandVecs2D[index22];
                float ygo2 = RandVecs2D[index22 | 1];
                xo3 = value2 * xgo2;
                yo3 = value2 * ygo2;
            }
            vx += cccc * xo3;
            vy += cccc * yo3;
        }
        if (y0 > x0) {
            float x1 = x0 + 0.21132487f;
            float y1 = y0 - 0.7886751f;
            float b = (0.5f - (x1 * x1)) - (y1 * y1);
            if (b > 0.0f) {
                float bbbb = b * b * b * b;
                if (outGradOnly) {
                    int hash5 = Hash(seed, i2, j2 + PrimeY) & 510;
                    xo2 = RandVecs2D[hash5];
                    yo2 = RandVecs2D[hash5 | 1];
                } else {
                    int hash6 = Hash(seed, i2, j2 + PrimeY);
                    int index13 = hash6 & 254;
                    int index23 = (hash6 >> 7) & 510;
                    float xg3 = Gradients2D[index13];
                    float yg3 = Gradients2D[index13 | 1];
                    float value3 = (x1 * xg3) + (y1 * yg3);
                    float xgo3 = RandVecs2D[index23];
                    float ygo3 = RandVecs2D[index23 | 1];
                    xo2 = value3 * xgo3;
                    yo2 = value3 * ygo3;
                }
                vx += bbbb * xo2;
                vy += bbbb * yo2;
            }
        } else {
            float x12 = x0 - 0.7886751f;
            float y12 = y0 + 0.21132487f;
            float b2 = (0.5f - (x12 * x12)) - (y12 * y12);
            if (b2 > 0.0f) {
                float bbbb2 = b2 * b2 * b2 * b2;
                if (outGradOnly) {
                    int hash7 = Hash(seed, i2 + PrimeX, j2) & 510;
                    xo = RandVecs2D[hash7];
                    yo = RandVecs2D[hash7 | 1];
                } else {
                    int hash8 = Hash(seed, i2 + PrimeX, j2);
                    int index14 = hash8 & 254;
                    int index24 = (hash8 >> 7) & 510;
                    float xg4 = Gradients2D[index14];
                    float yg4 = Gradients2D[index14 | 1];
                    float value4 = (x12 * xg4) + (y12 * yg4);
                    float xgo4 = RandVecs2D[index24];
                    float ygo4 = RandVecs2D[index24 | 1];
                    xo = value4 * xgo4;
                    yo = value4 * ygo4;
                }
                vx += bbbb2 * xo;
                vy += bbbb2 * yo;
            }
        }
        coord.x += vx * warpAmp;
        coord.y += vy * warpAmp;
    }

    private void SingleDomainWarpOpenSimplex2Gradient(int seed, float warpAmp, float frequency, float x, float y, float z, Vector3 coord, boolean outGradOnly) {
        float b;
        float xo;
        float yo;
        float zo;
        float xo2;
        float yo2;
        float zo2;
        float x2 = x * frequency;
        float y2 = y * frequency;
        float z2 = z * frequency;
        int i = FastRound(x2);
        int j = FastRound(y2);
        int k = FastRound(z2);
        float x0 = x2 - i;
        float y0 = y2 - j;
        float z0 = z2 - k;
        int xNSign = ((int) ((-x0) - 1.0f)) | 1;
        int yNSign = ((int) ((-y0) - 1.0f)) | 1;
        int zNSign = ((int) ((-z0) - 1.0f)) | 1;
        float ax0 = xNSign * (-x0);
        float ay0 = yNSign * (-y0);
        float az0 = zNSign * (-z0);
        int i2 = i * PrimeX;
        int j2 = j * PrimeY;
        int k2 = k * PrimeZ;
        float vz = 0.0f;
        float vy = 0.0f;
        float vx = 0.0f;
        float a = (0.6f - (x0 * x0)) - ((y0 * y0) + (z0 * z0));
        int l = 0;
        while (true) {
            if (a > 0.0f) {
                float aaaa = a * a * a * a;
                if (outGradOnly) {
                    int hash = Hash(seed, i2, j2, k2) & 1020;
                    xo2 = RandVecs3D[hash];
                    yo2 = RandVecs3D[hash | 1];
                    zo2 = RandVecs3D[hash | 2];
                } else {
                    int hash2 = Hash(seed, i2, j2, k2);
                    int index1 = hash2 & 252;
                    int index2 = (hash2 >> 6) & 1020;
                    float xg = Gradients3D[index1];
                    float yg = Gradients3D[index1 | 1];
                    float zg = Gradients3D[index1 | 2];
                    float value = (x0 * xg) + (y0 * yg) + (z0 * zg);
                    float xgo = RandVecs3D[index2];
                    float ygo = RandVecs3D[index2 | 1];
                    float zgo = RandVecs3D[index2 | 2];
                    xo2 = value * xgo;
                    yo2 = value * ygo;
                    zo2 = value * zgo;
                }
                vx += aaaa * xo2;
                vy += aaaa * yo2;
                vz += aaaa * zo2;
            }
            float b2 = a;
            int i1 = i2;
            int j1 = j2;
            int k1 = k2;
            float x1 = x0;
            float y1 = y0;
            float z1 = z0;
            if (ax0 >= ay0 && ax0 >= az0) {
                x1 += xNSign;
                b = b2 + ax0 + ax0;
                i1 -= xNSign * PrimeX;
            } else if (ay0 > ax0 && ay0 >= az0) {
                y1 += yNSign;
                b = b2 + ay0 + ay0;
                j1 -= yNSign * PrimeY;
            } else {
                z1 += zNSign;
                b = b2 + az0 + az0;
                k1 -= zNSign * PrimeZ;
            }
            if (b > 1.0f) {
                float b3 = b - 1.0f;
                float bbbb = b3 * b3 * b3 * b3;
                if (outGradOnly) {
                    int hash3 = Hash(seed, i1, j1, k1) & 1020;
                    xo = RandVecs3D[hash3];
                    yo = RandVecs3D[hash3 | 1];
                    zo = RandVecs3D[hash3 | 2];
                } else {
                    int hash4 = Hash(seed, i1, j1, k1);
                    int index12 = hash4 & 252;
                    int index22 = (hash4 >> 6) & 1020;
                    float xg2 = Gradients3D[index12];
                    float yg2 = Gradients3D[index12 | 1];
                    float zg2 = Gradients3D[index12 | 2];
                    float value2 = (x1 * xg2) + (y1 * yg2) + (z1 * zg2);
                    float xgo2 = RandVecs3D[index22];
                    float ygo2 = RandVecs3D[index22 | 1];
                    float zgo2 = RandVecs3D[index22 | 2];
                    xo = value2 * xgo2;
                    yo = value2 * ygo2;
                    zo = value2 * zgo2;
                }
                vx += bbbb * xo;
                vy += bbbb * yo;
                vz += bbbb * zo;
            }
            if (l != 1) {
                ax0 = 0.5f - ax0;
                ay0 = 0.5f - ay0;
                az0 = 0.5f - az0;
                x0 = xNSign * ax0;
                y0 = yNSign * ay0;
                z0 = zNSign * az0;
                a += (0.75f - ax0) - (ay0 + az0);
                i2 += (xNSign >> 1) & PrimeX;
                j2 += (yNSign >> 1) & PrimeY;
                k2 += (zNSign >> 1) & PrimeZ;
                xNSign = -xNSign;
                yNSign = -yNSign;
                zNSign = -zNSign;
                seed += 1293373;
                l++;
            } else {
                coord.x += vx * warpAmp;
                coord.y += vy * warpAmp;
                coord.z += vz * warpAmp;
                return;
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$Vector2.class */
    public static class Vector2 {
        public float x;
        public float y;

        public Vector2(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/FastNoiseLite$Vector3.class */
    public static class Vector3 {
        public float x;
        public float y;
        public float z;

        public Vector3(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
