
package com.leovideo.surgeofwar.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.leovideo.surgeofwar.item.ItemEderniumFragment;
import com.leovideo.surgeofwar.block.BlockEderniumOre;
import com.leovideo.surgeofwar.ElementsSurgeofWar;

@ElementsSurgeofWar.ModElement.Tag
public class RecipeEderniumFragmentRecipe extends ElementsSurgeofWar.ModElement {
	public RecipeEderniumFragmentRecipe(ElementsSurgeofWar instance) {
		super(instance, 77);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockEderniumOre.block, (int) (1)), new ItemStack(ItemEderniumFragment.block, (int) (1)), 1F);
	}
}
