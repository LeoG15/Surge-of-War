package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemAmethiste;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureXpTransformatorBouton1 extends ElementsSurgeofwarMod.ModElement {
	public ProcedureXpTransformatorBouton1(ElementsSurgeofwarMod instance) {
		super(instance, 342);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure XpTransformatorBouton1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).experienceLevel : 0) >= 1)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperienceLevel(-((int) 1));
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemAmethiste.block, (int) (1));
				_setstack.setCount(3);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
