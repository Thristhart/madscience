package madscience.madscience;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class TableBlock extends Block {
	public IIcon SideIcons[];
	public TableBlock (Material material) {
		super(material);
		this.SideIcons = new IIcon[6];
		this.setHardness(2f);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockName("madscienceTable");
		this.setCreativeTab(CreativeTabs.tabMisc);
		// WONTFIX: this doesn't actually work, but that's okay fists are cool
		setHarvestLevel("pickaxe", 2); // require iron pickaxe to break effectively
	}
	
	public void registerBlockIcons(IIconRegister icon) {
		SideIcons[0] = icon.registerIcon("madscience:table_bottom");
		SideIcons[1] = icon.registerIcon("madscience:table_top");
		SideIcons[2] = icon.registerIcon("madscience:table_front");
		SideIcons[3] = icon.registerIcon("madscience:table_back");
		SideIcons[4] = icon.registerIcon("madscience:table_right");
		SideIcons[5] = icon.registerIcon("madscience:table_left");
	}
	
	public IIcon getIcon(int side, int metadata) {
		return SideIcons[side];
	}
}
