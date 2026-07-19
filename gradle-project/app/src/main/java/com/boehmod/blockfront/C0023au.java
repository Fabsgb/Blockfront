package com.boehmod.blockfront;

import com.boehmod.blockfront.client.net.PacketListenerCustomPayloadPacket;
import com.boehmod.blockfront.client.net.PacketListenerSetTimePacket;
import io.netty.channel.ChannelPipeline;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.au, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/au.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0023au {
    @SubscribeEvent
    public static void a(@NotNull ClientPlayerNetworkEvent.LoggingIn loggingIn) {
        C0263jt.log("Adding custom packet listeners for new connection...", new Object[0]);
        ChannelPipeline channelPipelinePipeline = loggingIn.getConnection().channel().pipeline();
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_time", new PacketListenerSetTimePacket());
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_custom_payload", new PacketListenerCustomPayloadPacket());
        C0263jt.log("Finished adding custom packet listener for new connection!", new Object[0]);
    }
}
