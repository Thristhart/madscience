package madscience.madscience;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = Madscience.MODID, version = Madscience.VERSION)

public class Madscience {
    public static final String MODID = "madscience";
    public static final String VERSION = "0.1";
    
    @Instance(value="Madscience")
    public static Madscience instance;
    
    @SidedProxy(clientSide = "madscience.madscience.client.ClientProxy", serverSide = "madscience.madscience.CommonProxy")
	public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.addShapedRecipe(new ItemStack(Blocks.dirt),
    			"xxx",
    			"xyx",
    			"x x",
    			'x', new ItemStack(Blocks.iron_block),
    			'y', new ItemStack(Blocks.redstone_block));
        System.out.println("Hello World!");
    }
}