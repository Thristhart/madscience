package madscience.madscience.network;

import io.netty.buffer.ByteBuf;
import madscience.madscience.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class UpdateResearchPointsPacket implements IPacket {
	int newPointsValue;

	public UpdateResearchPointsPacket() {}
	public UpdateResearchPointsPacket(int newPoints) {
		this.newPointsValue = newPoints;
	}
	
	@Override
	public void readBytes(ByteBuf bytes) {
		this.newPointsValue = bytes.readInt();
	}

	@Override
	public void writeBytes(ByteBuf bytes) {
		bytes.writeInt(this.newPointsValue);
	}

	@Override
	public void executeClient(EntityPlayer player) {
		// do nothing for now
	}

	@Override
	public void executeServer(EntityPlayer player) {
		ExtendedPlayer.get(player).setResearchPoints(this.newPointsValue);
	}

}
