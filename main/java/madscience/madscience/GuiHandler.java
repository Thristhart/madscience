package madscience.madscience;

import madscience.madscience.client.gui.TableGui;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return new TableGuiContainer();
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		if(block instanceof TableBlock) {
			return new TableGui();
		}
		return null;
	}

}
