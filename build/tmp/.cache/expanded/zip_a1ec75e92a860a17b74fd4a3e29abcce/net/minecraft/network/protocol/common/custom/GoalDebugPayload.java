package net.minecraft.network.protocol.common.custom;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public record GoalDebugPayload(int entityId, BlockPos pos, List<GoalDebugPayload.DebugGoal> goals) implements CustomPacketPayload {
    public static final StreamCodec<FriendlyByteBuf, GoalDebugPayload> STREAM_CODEC = CustomPacketPayload.codec(
        GoalDebugPayload::write, GoalDebugPayload::new
    );
    public static final CustomPacketPayload.Type<GoalDebugPayload> TYPE = CustomPacketPayload.createType("debug/goal_selector");

    private GoalDebugPayload(FriendlyByteBuf p_300481_) {
        this(p_300481_.readInt(), p_300481_.readBlockPos(), p_300481_.readList(GoalDebugPayload.DebugGoal::new));
    }

    private void write(FriendlyByteBuf p_297279_) {
        p_297279_.writeInt(this.entityId);
        p_297279_.writeBlockPos(this.pos);
        p_297279_.writeCollection(this.goals, (p_298191_, p_298011_) -> p_298011_.write(p_298191_));
    }

    @Override
    public CustomPacketPayload.Type<GoalDebugPayload> type() {
        return TYPE;
    }

    public static record DebugGoal(int priority, boolean isRunning, String name) {
        public DebugGoal(FriendlyByteBuf pBuffer) {
            this(pBuffer.readInt(), pBuffer.readBoolean(), pBuffer.readUtf(255));
        }

        public void write(FriendlyByteBuf pBuffer) {
            pBuffer.writeInt(this.priority);
            pBuffer.writeBoolean(this.isRunning);
            pBuffer.writeUtf(this.name);
        }
    }
}