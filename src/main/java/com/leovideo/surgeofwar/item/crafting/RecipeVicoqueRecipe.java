
package com.leovideo.surgeofwar.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.leovideo.surgeofwar.item.ItemVitrome;
import com.leovideo.surgeofwar.block.BlockVicoque;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class RecipeVicoqueRecipe extends ElementsSurgeofwarMod.ModElement {
	public RecipeVicoqueRecipe(ElementsSurgeofwarMod instance) {
		super(instance, 41);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockVicoque.block, (int) (1)), new ItemStack(ItemVitrome.block, (int) (1)), 1F);
	}
}
