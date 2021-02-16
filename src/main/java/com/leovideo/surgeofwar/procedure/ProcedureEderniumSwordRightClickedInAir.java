package com.leovideo.surgeofwar.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

import java.util.Map;

import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureEderniumSwordRightClickedInAir extends ElementsSurgeofwarMod.ModElement {
	public ProcedureEderniumSwordRightClickedInAir(ElementsSurgeofwarMod instance) {
		super(instance, 223);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure EderniumSwordRightClickedInAir!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.SHARPNESS, (int) 1);
	}
}
