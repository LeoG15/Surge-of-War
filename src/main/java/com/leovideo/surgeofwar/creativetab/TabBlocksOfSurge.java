
package com.leovideo.surgeofwar.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import com.leovideo.surgeofwar.block.BlockViprinGrass;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class TabBlocksOfSurge extends ElementsSurgeofwarMod.ModElement {
	public TabBlocksOfSurge(ElementsSurgeofwarMod instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabblocksofsurge") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockViprinGrass.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
