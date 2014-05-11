package madscience.madscience;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	private final EntityPlayer player;
	
	public static final int RESEARCH_POINTS_WATCHER = 20;
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		
		this.player.getDataWatcher().addObject(RESEARCH_POINTS_WATCHER, 0);
	}
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayer(player));
	}
	
	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		
		properties.setInteger("researchPoints", getResearchPoints());
		
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		int points = properties.getInteger("researchPoints");
		setResearchPoints(points);
	}

	@Override
	public void init(Entity entity, World world) {
	}
	
	public int getResearchPoints() {
		return this.player.getDataWatcher().getWatchableObjectInt(RESEARCH_POINTS_WATCHER);
	}
	public void setResearchPoints(int value) {
		this.player.getDataWatcher().updateObject(RESEARCH_POINTS_WATCHER, value);
	}
}
