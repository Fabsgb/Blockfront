package com.boehmod.blockfront;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oS.class */
public class C0801oS {
    /* JADX INFO: renamed from: a */
    public static void m3687a(@NotNull RegisterPayloadHandlersEvent registerPayloadHandlersEvent) {
        PayloadRegistrar payloadRegistrarOptional = registerPayloadHandlersEvent.registrar("bf").versioned(C0030a.f265c).optional();
        payloadRegistrarOptional.playToClient(C1176vV.f6402y, C1176vV.f6403z, C1176vV::m6689b);
        payloadRegistrarOptional.playToClient(C1220wM.f6631ap, C1220wM.f6632aq, C1220wM::m6959b);
        payloadRegistrarOptional.playToClient(C1222wO.f6642ar, C1222wO.f6643as, C1222wO::m6969b);
        payloadRegistrarOptional.playToClient(C1223wP.f6647as, C1223wP.f6648at, C1223wP::m6972b);
        payloadRegistrarOptional.playToClient(C1237wd.f6700G, C1237wd.f6701H, C1237wd::m7022b);
        payloadRegistrarOptional.playToClient(C1287xa.f6922aD, C1287xa.f6923aE, C1287xa::m7310b);
        payloadRegistrarOptional.playToClient(C1215wH.f6609ak, C1215wH.f6610al, C1215wH::m6935b);
        payloadRegistrarOptional.playToClient(C1214wG.f6605aj, C1214wG.f6606ak, C1214wG::m6931b);
        payloadRegistrarOptional.playToClient(C1230wW.f6677az, C1230wW.f6678aA, C1230wW::m7001b);
        payloadRegistrarOptional.playToClient(C1254wu.f6777X, C1254wu.f6778Y, C1254wu::m7092b);
        payloadRegistrarOptional.playToClient(C1255wv.f6784Y, C1255wv.f6785Z, C1255wv::m7098b);
        payloadRegistrarOptional.playToClient(C1160vF.f6334j, C1160vF.f6335k, C1160vF::m6610b);
        payloadRegistrarOptional.playToClient(C1238we.f6703H, C1238we.f6704I, C1238we::m7025b);
        payloadRegistrarOptional.playToClient(C1217wJ.f6616am, C1217wJ.f6617an, C1217wJ::m6942b);
        payloadRegistrarOptional.playToClient(C1256ww.f6788Z, C1256ww.f6789aa, C1256ww::m7105b);
        payloadRegistrarOptional.playToClient(C1213wF.f6601ai, C1213wF.f6602aj, C1213wF::m6928b);
        payloadRegistrarOptional.playToClient(C1242wi.f6726L, C1242wi.f6727M, C1242wi::m7042b);
        payloadRegistrarOptional.playToClient(C1174vT.f6395w, C1174vT.f6396x, C1174vT::m6677b);
        payloadRegistrarOptional.playToClient(C1175vU.f6399x, C1175vU.f6400y, C1175vU::m6685b);
        payloadRegistrarOptional.playToClient(C1155vA.f6313e, C1155vA.f6314f, C1155vA::m6591b);
        payloadRegistrarOptional.playToClient(C1159vE.f6329i, C1159vE.f6330j, C1159vE::m6608b);
        payloadRegistrarOptional.playToClient(C1156vB.f6317f, C1156vB.f6318g, C1156vB::m6595b);
        payloadRegistrarOptional.playToClient(C1253wt.f6771W, C1253wt.f6772X, C1253wt::m7089b);
        payloadRegistrarOptional.playToClient(C1239wf.f6708I, C1239wf.f6709J, C1239wf::m7028b);
        payloadRegistrarOptional.playToClient(C1209wB.f6587ae, C1209wB.f6588af, C1209wB::m6913b);
        payloadRegistrarOptional.playToClient(C1180vZ.f6421C, C1180vZ.f6422D, C1180vZ::m6706b);
        payloadRegistrarOptional.playToClient(C1167vM.f6358q, C1167vM.f6359r, C1167vM::m6638b);
        payloadRegistrarOptional.playToClient(C1166vL.f6355p, C1166vL.f6356q, C1166vL::m6635b);
        payloadRegistrarOptional.playToClient(C1165vK.f6352o, C1165vK.f6353p, C1165vK::m6631b);
        payloadRegistrarOptional.playToClient(C1216wI.f6612al, C1216wI.f6613am, C1216wI::m6939b);
        payloadRegistrarOptional.playToClient(C1219wL.f6629ao, C1219wL.f6630ap, C1219wL::m6956b);
        payloadRegistrarOptional.playToClient(C1240wg.f6711J, C1240wg.f6712K, C1240wg::m7034b);
        payloadRegistrarOptional.playToClient(C1250wq.f6761T, C1250wq.f6762U, C1250wq::m7080b);
        payloadRegistrarOptional.playToClient(C1211wD.f6593ag, C1211wD.f6594ah, C1211wD::m6919b);
        payloadRegistrarOptional.playToClient(C1224wQ.f6649at, C1224wQ.f6650au, C1224wQ::m6977b);
        payloadRegistrarOptional.playToClient(C1158vD.f6327h, C1158vD.f6328i, C1158vD::m6602b);
        payloadRegistrarOptional.playToClient(C1244wk.f6734N, C1244wk.f6735O, C1244wk::m7052b);
        payloadRegistrarOptional.playToClient(C1246wm.f6743P, C1246wm.f6744Q, C1246wm::m7060b);
        payloadRegistrarOptional.playToClient(C1212wE.f6598ah, C1212wE.f6599ai, C1212wE::m6923b);
        payloadRegistrarOptional.playToClient(C1235wb.f6693E, C1235wb.f6694F, C1235wb::m7014b);
        payloadRegistrarOptional.playToClient(C1258wy.f6799ab, C1258wy.f6800ac, C1258wy::m7117b);
        payloadRegistrarOptional.playToClient(C1177vW.f6410z, C1177vW.f6411A, C1177vW::m6692b);
        payloadRegistrarOptional.playToServer(C1233wZ.f6687aC, C1233wZ.f6688aD, C1233wZ::m7009a);
        payloadRegistrarOptional.playToServer(C1289xc.f6928aF, C1289xc.f6929aG, C1289xc::m7321a);
        payloadRegistrarOptional.playToServer(C1218wK.f6625an, C1218wK.f6626ao, C1218wK::m6947a);
        payloadRegistrarOptional.playToServer(C1232wY.f6683aB, C1232wY.f6684aC, C1232wY::m7007a);
        payloadRegistrarOptional.playToServer(C1227wT.f6665aw, C1227wT.f6666ax, C1227wT::m6990a);
        payloadRegistrarOptional.playToServer(C1231wX.f6680aA, C1231wX.f6681aB, C1231wX::m7004a);
        payloadRegistrarOptional.playToServer(C1229wV.f6674ay, C1229wV.f6675az, C1229wV::m6998a);
        payloadRegistrarOptional.playToServer(C1259wz.f6801ac, C1259wz.f6802ad, C1259wz::m7120a);
        payloadRegistrarOptional.playToServer(C1178vX.f6412A, C1178vX.f6413B, C1178vX::m6702a);
        payloadRegistrarOptional.playToServer(C1241wh.f6715K, C1241wh.f6716L, C1241wh::m7037a);
        payloadRegistrarOptional.playToServer(C1228wU.f6670ax, C1228wU.f6671ay, C1228wU::m6994a);
        payloadRegistrarOptional.playToServer(C1225wR.f6656au, C1225wR.f6657av, C1225wR::m6981a);
        payloadRegistrarOptional.playToServer(C1206vz.f6567d, C1206vz.f6568e, C1206vz::m6897a);
        payloadRegistrarOptional.playToServer(C1236wc.f6697F, C1236wc.f6698G, C1236wc::m7018a);
        payloadRegistrarOptional.playToServer(C1162vH.f6341l, C1162vH.f6342m, C1162vH::m6621a);
        payloadRegistrarOptional.playToServer(C1168vN.f6361r, C1168vN.f6362s, C1168vN::m6641a);
        payloadRegistrarOptional.playToServer(C1171vQ.f6375t, C1171vQ.f6376u, C1171vQ::m6661a);
        payloadRegistrarOptional.playToServer(C1163vI.f6344m, C1163vI.f6345n, C1163vI::m6624a);
        payloadRegistrarOptional.playToServer(C1249wp.f6757S, C1249wp.f6758T, C1249wp::m7072a);
        payloadRegistrarOptional.playToServer(C1164vJ.f6348n, C1164vJ.f6349o, C1164vJ::m6627a);
        payloadRegistrarOptional.playToServer(C1243wj.f6729M, C1243wj.f6730N, C1243wj::m7049a);
        payloadRegistrarOptional.playToServer(C1161vG.f6338k, C1161vG.f6339l, C1161vG::m6615a);
        payloadRegistrarOptional.playToServer(C1172vR.f6379u, C1172vR.f6380v, C1172vR::m6665a);
        payloadRegistrarOptional.playToServer(C1173vS.f6384v, C1173vS.f6385w, C1173vS::m6670a);
        payloadRegistrarOptional.playToServer(C1170vP.f6371s, C1170vP.f6372t, C1170vP::m6652a);
        payloadRegistrarOptional.playToServer(C1288xb.f6925aE, C1288xb.f6926aF, C1288xb::m7318a);
        payloadRegistrarOptional.playToServer(C1208wA.f6583ad, C1208wA.f6584ae, C1208wA::m6904a);
        payloadRegistrarOptional.playToServer(C1210wC.f6589af, C1210wC.f6590ag, C1210wC::m6917a);
        payloadRegistrarOptional.playToServer(C1221wN.f6638aq, C1221wN.f6639ar, C1221wN::m6965a);
        payloadRegistrarOptional.playToServer(C1226wS.f6660av, C1226wS.f6661aw, C1226wS::m6987a);
        payloadRegistrarOptional.playToServer(C1179vY.f6417B, C1179vY.f6418C, C1179vY::m6704a);
        payloadRegistrarOptional.playToServer(C1257wx.f6794aa, C1257wx.f6795ab, C1257wx::m7114a);
        payloadRegistrarOptional.playToServer(C1234wa.f6689D, C1234wa.f6690E, C1234wa::m7012a);
        payloadRegistrarOptional.playToServer(C1252ws.f6767V, C1252ws.f6768W, C1252ws::m7086a);
        payloadRegistrarOptional.playToServer(C1251wr.f6763U, C1251wr.f6764V, C1251wr::m7084a);
        payloadRegistrarOptional.playToServer(C1245wl.f6737O, C1245wl.f6738P, C1245wl::m7057a);
        payloadRegistrarOptional.playToServer(C1247wn.f6747Q, C1247wn.f6748R, C1247wn::m7065a);
        payloadRegistrarOptional.playToServer(C1157vC.f6321g, C1157vC.f6322h, C1157vC::m6599a);
        payloadRegistrarOptional.playToServer(C1248wo.f6751R, C1248wo.f6752S, C1248wo::m7069a);
        payloadRegistrarOptional.playToClient(C0539jV.f3214b, C0539jV.f3215b, C0539jV::m2413b);
        payloadRegistrarOptional.playToClient(C0538jU.f3212a, C0538jU.f3213a, C0538jU::m2410b);
        payloadRegistrarOptional.playToServer(C0540jW.f3217c, C0540jW.f3218c, C0540jW::m2415a);
    }
}
