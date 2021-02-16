package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemNitronium;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureXpTransformatorBouton2 extends ElementsSurgeofwarMod.ModElement {
	public ProcedureXpTransformatorBouton2(ElementsSurgeofwarMod instance) {
		super(instance, 343);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure XpTransformatorBouton2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).experienceLevel : 0) >= 2)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperienceLevel(-((int) 2));
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemNitronium.block, (int) (1));
				_setstack.setCount(2);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
