package ninja.egg82.messenger.packets.server;

import io.netty.buffer.ByteBuf;
import ninja.egg82.messenger.packets.AbstractPacket;
import ninja.egg82.messenger.utils.UUIDUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class ShutdownPacket extends AbstractPacket {
    private UUID server;

    public ShutdownPacket(@NotNull UUID sender, @NotNull ByteBuf data) {
        super(sender);
        read(data);
    }

    public ShutdownPacket() {
        super(UUIDUtil.EMPTY_UUID);
    }

    public ShutdownPacket(@NotNull UUID server) {
        super(UUIDUtil.EMPTY_UUID);
        this.server = server;
    }

    @Override
    public void read(@NotNull ByteBuf buffer) {
        this.server = readUUID(buffer);
    }

    @Override
    public void write(@NotNull ByteBuf buffer) {
        writeUUID(this.server, buffer);
    }

    public @NotNull UUID getServer() { return server; }

    public void setServer(@NotNull UUID server) { this.server = server; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShutdownPacket)) {
            return false;
        }
        ShutdownPacket that = (ShutdownPacket) o;
        return server.equals(that.server);
    }

    @Override
    public int hashCode() { return Objects.hash(server); }

    @Override
    public String toString() {
        return "ShutdownPacket{" +
                "server=" + server +
                ", sender=" + sender +
                '}';
    }
}
