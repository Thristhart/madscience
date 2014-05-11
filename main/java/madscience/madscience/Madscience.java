package madscience.madscience;


import java.util.EnumMap;

import madscience.madscience.network.ChannelHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Madscience.MODID, version = Madscience.VERSION)

public class Madscience {
    public static final String MODID = "madscience";
    public static final String VERSION = "0.1";
    
    @Instance(value="Madscience")
    public static Madscience instance;
    
    public static EnumMap<Side, FMLEmbeddedChannel> channels;
    
    @SidedProxy(clientSide = "madscience.madscience.client.ClientProxy", serverSide = "madscience.madscience.CommonProxy")
	public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Madscience.instance = this;
    	TableBlock tableBlock = new TableBlock(Material.piston);
    	GameRegistry.addShapedRecipe(new ItemStack(tableBlock),
    			"xxx",
    			"xyx",
    			"x x",
    			'x', new ItemStack(Blocks.iron_block),
    			'y', new ItemStack(Blocks.redstone_block));
    	GameRegistry.registerBlock(tableBlock, "madscienceTable");
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	channels = NetworkRegistry.INSTANCE.newChannel("madscience", new ChannelHandler());
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new MadscienceEventHandler());
    }
}
