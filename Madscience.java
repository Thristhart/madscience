package madscience.madscience;


import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = Madscience.MODID, version = Madscience.VERSION)

public class Madscience {
    public static final String MODID = "madscience";
    public static final String VERSION = "0.1";
    
    @Instance(value="Madscience")
    public static Madscience instance;
    
    @SidedProxy(clientSide = "madscience.madscience.ClientProxy", serverSide = "madscience.madscience.CommonProxy")
	public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("Hello World!");
    }
}
