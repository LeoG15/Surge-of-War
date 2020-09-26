
package com.leovideo.surgeofwar.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.leovideo.surgeofwar.item.ItemAmethiste;
import com.leovideo.surgeofwar.block.BlockAmethisteore;
import com.leovideo.surgeofwar.ElementsSurgeofWar;

@ElementsSurgeofWar.ModElement.Tag
public class RecipeAmethisteRecipe extends ElementsSurgeofWar.ModElement {
	public RecipeAmethisteRecipe(ElementsSurgeofWar instance) {
		super(instance, 8);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockAmethisteore.block, (int) (1)), new ItemStack(ItemAmethiste.block, (int) (1)), 5F);
	}
}
