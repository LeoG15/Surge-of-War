
package com.leovideo.surgeofwar.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import com.leovideo.surgeofwar.item.ItemNitronium;
import com.leovideo.surgeofwar.block.BlockNitroniumore;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class RecipeNItroniumrecipe extends ElementsSurgeofwarMod.ModElement {
	public RecipeNItroniumrecipe(ElementsSurgeofwarMod instance) {
		super(instance, 58);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockNitroniumore.block, (int) (1)), new ItemStack(ItemNitronium.block, (int) (1)), 10F);
	}
}
