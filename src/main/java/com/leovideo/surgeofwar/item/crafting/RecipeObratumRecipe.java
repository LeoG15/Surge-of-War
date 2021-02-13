
package com.leovideo.surgeofwar.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.leovideo.surgeofwar.item.ItemObratum;
import com.leovideo.surgeofwar.block.BlockObratumOre;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class RecipeObratumRecipe extends ElementsSurgeofwarMod.ModElement {
	public RecipeObratumRecipe(ElementsSurgeofwarMod instance) {
		super(instance, 106);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockObratumOre.block, (int) (1)), new ItemStack(ItemObratum.block, (int) (1)), 50F);
	}
}
