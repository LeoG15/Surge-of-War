package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemDoomOrb;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureAznarTheChaos4thPhaseEntityDies extends ElementsSurgeofwarMod.ModElement {
	public ProcedureAznarTheChaos4thPhaseEntityDies(ElementsSurgeofwarMod instance) {
		super(instance, 255);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AznarTheChaos4thPhaseEntityDies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemDoomOrb.block, (int) (1));
			_setstack.setCount(2);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
