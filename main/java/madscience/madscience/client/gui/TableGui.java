package madscience.madscience.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class TableGui extends GuiScreen {
	private final int GUI_WIDTH = 176;
	private final int GUI_HEIGHT = 166;
	public TableGui() {
		
	}
	
	@Override
	public void drawScreen(int param1, int param2, float param3) {
		this.mc.renderEngine.bindTexture(new ResourceLocation("madscience", "/textures/gui/science_table.png"));
        int x = (width - GUI_WIDTH) / 2;
        int y = (height - GUI_HEIGHT) / 2;
    	this.drawTexturedModalRect(x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);
    	fontRendererObj.drawString("Hello World", x, y, 4210752);
	}
}
