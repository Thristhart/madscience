package madscience.madscience;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TableBlock extends Block {
	public TableBlock (Material material) {
		super(material);
		this.setHardness(2f);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockName("madscienceTable");
		this.setCreativeTab(CreativeTabs.tabMisc);
		// WONTFIX: this doesn't actually work, but that's okay fists are cool
		setHarvestLevel("pickaxe", 2); // require iron pickaxe to break effectively
	}
}
