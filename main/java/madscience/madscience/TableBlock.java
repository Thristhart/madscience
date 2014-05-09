package madscience.madscience;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TableBlock extends Block {
	public TableBlock (Material material) {
		super(material);
		this.setHardness(0.5f);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockName("madscienceTable");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHarvestLevel("pickaxe", 2); // require iron pickaxe to break effectively
	}
}
