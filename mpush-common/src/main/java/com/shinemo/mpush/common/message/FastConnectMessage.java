package com.shinemo.mpush.common.message;

import com.shinemo.mpush.api.connection.Connection;
import com.shinemo.mpush.api.protocol.Packet;
import io.netty.buffer.ByteBuf;

/**
 * Created by ohun on 2015/12/25.
 */
public final class FastConnectMessage extends ByteBufMessage {
    public String sessionId;
    public String deviceId;
    public int minHeartbeat;
    public int maxHeartbeat;

    public FastConnectMessage(Packet message, Connection connection) {
        super(message, connection);
    }

    @Override
    public void decode(ByteBuf body) {
        sessionId = decodeString(body);
        deviceId = decodeString(body);
        minHeartbeat = decodeInt(body);
        maxHeartbeat = decodeInt(body);
    }

    @Override
    public void encode(ByteBuf body) {
        encodeString(body, sessionId);
        encodeString(body, deviceId);
        encodeInt(body, minHeartbeat);
        encodeInt(body, maxHeartbeat);
    }
}
