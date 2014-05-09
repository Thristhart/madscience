package madscience.madscience;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TableBlock extends Block {
	public TableBlock (Material material) {
		super(material);
		this.setHardness(0.5f);
		this.setStepSound(Block.soundTypeMetal);
		this.setUnlocalizedName("madscienceTable");
	}
}
