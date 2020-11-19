package com.leovideo.surgeofwar.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

import com.leovideo.surgeofwar.ElementsSurgeofWar;

@ElementsSurgeofWar.ModElement.Tag
public class ProcedureEderniumSwordRightClickedInAir extends ElementsSurgeofWar.ModElement {
	public ProcedureEderniumSwordRightClickedInAir(ElementsSurgeofWar instance) {
		super(instance, 89);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure EderniumSwordRightClickedInAir!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.addEnchantment(Enchantments.SHARPNESS, (int) 1);
	}
}
