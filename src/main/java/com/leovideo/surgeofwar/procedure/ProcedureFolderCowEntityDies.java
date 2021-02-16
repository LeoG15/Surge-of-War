package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemFolderSteak;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureFolderCowEntityDies extends ElementsSurgeofwarMod.ModElement {
	public ProcedureFolderCowEntityDies(ElementsSurgeofwarMod instance) {
		super(instance, 196);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FolderCowEntityDies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() <= 50)) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemFolderSteak.block, (int) (1));
				_setstack.setCount(2);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
