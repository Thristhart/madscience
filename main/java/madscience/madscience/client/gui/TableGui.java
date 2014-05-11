package madscience.madscience.client.gui;

import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import madscience.madscience.ExtendedPlayer;
import madscience.madscience.Madscience;
import madscience.madscience.network.UpdateResearchPointsPacket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ResourceLocation;

public class TableGui extends GuiScreen {
	private final int GUI_WIDTH = 176;
	private final int GUI_HEIGHT = 166;
	private EntityPlayer player;
	public TableGui(EntityPlayer creatingPlayer) {
		player = creatingPlayer;
	}
	@Override
	public void initGui() {
		super.initGui();
		buttonList.add(new GuiButton(0, 0, 0, 20, 20, "+"));
		buttonList.add(new GuiButton(1, 0, 0, 20, 20, "-"));
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	protected void actionPerformed(GuiButton guibutton) {
		ExtendedPlayer extended = ExtendedPlayer.get(player);
    	int currentPoints = extended.getResearchPoints();
    	switch(guibutton.id) {
    	case 0:
    		currentPoints++;
    		break;
    	case 1:
    		currentPoints--;
    		break;
    	}
    	extended.setResearchPoints(currentPoints);
    	
    	Madscience.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
    	Madscience.channels.get(Side.CLIENT).writeOutbound(new UpdateResearchPointsPacket(currentPoints));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float param3) {
		this.mc.renderEngine.bindTexture(new ResourceLocation("madscience", "textures/gui/science_table.png"));
        int x = (width - GUI_WIDTH) / 2;
        int y = (height - GUI_HEIGHT) / 2;
    	this.drawTexturedModalRect(x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);

		ExtendedPlayer extended = ExtendedPlayer.get(player);
    	int currentPoints = extended.getResearchPoints();
    	
    	fontRendererObj.drawString("Current points: " + currentPoints, x + 10, y + 10, 4210752);

        GuiButton plusButton = (GuiButton)this.buttonList.get(0);
        plusButton.xPosition = x + 10;
        plusButton.yPosition = y + 20;

        GuiButton minusButton = (GuiButton)this.buttonList.get(1);
        minusButton.xPosition = x + 40;
        minusButton.yPosition = y + 20;

        super.drawScreen(mouseX, mouseY, param3);
	}
}
