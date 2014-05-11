package madscience.madscience.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class TableGui extends GuiScreen {
	public TableGui() {
		
	}
	
	@Override
	public void drawScreen(int param1, int param2, float param3) {
		fontRendererObj.drawString("Hello World", 8, 6, 4210752);
	}
}
