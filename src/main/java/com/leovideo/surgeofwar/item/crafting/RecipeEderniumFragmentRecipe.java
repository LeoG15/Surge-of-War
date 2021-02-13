
package com.leovideo.surgeofwar.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.leovideo.surgeofwar.item.ItemEderniumFragment;
import com.leovideo.surgeofwar.block.BlockEderniumOre;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class RecipeEderniumFragmentRecipe extends ElementsSurgeofwarMod.ModElement {
	public RecipeEderniumFragmentRecipe(ElementsSurgeofwarMod instance) {
		super(instance, 77);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockEderniumOre.block, (int) (1)), new ItemStack(ItemEderniumFragment.block, (int) (1)), 1F);
	}
}
