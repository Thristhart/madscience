package madscience.madscience;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class TableGuiContainer extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
