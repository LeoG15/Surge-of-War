
package com.leovideo.surgeofwar.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import com.leovideo.surgeofwar.item.ItemHellstone;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class TabItemOfWar extends ElementsSurgeofwarMod.ModElement {
	public TabItemOfWar(ElementsSurgeofwarMod instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabitemofwar") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemHellstone.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
