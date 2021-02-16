
package com.leovideo.surgeofwar.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.leovideo.surgeofwar.item.ItemAmethiste;
import com.leovideo.surgeofwar.block.BlockAmethisteore;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class RecipeAmethisteRecipe extends ElementsSurgeofwarMod.ModElement {
	public RecipeAmethisteRecipe(ElementsSurgeofwarMod instance) {
		super(instance, 186);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockAmethisteore.block, (int) (1)), new ItemStack(ItemAmethiste.block, (int) (1)), 5F);
	}
}
