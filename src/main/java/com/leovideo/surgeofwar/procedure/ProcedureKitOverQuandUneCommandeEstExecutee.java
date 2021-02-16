package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemHucknessBow;
import com.leovideo.surgeofwar.item.ItemHucknessArrow;
import com.leovideo.surgeofwar.item.ItemEderniumSword;
import com.leovideo.surgeofwar.item.ItemEderniumApple;
import com.leovideo.surgeofwar.item.ItemEdernium;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureKitOverQuandUneCommandeEstExecutee extends ElementsSurgeofwarMod.ModElement {
	public ProcedureKitOverQuandUneCommandeEstExecutee(ElementsSurgeofwarMod instance) {
		super(instance, 399);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KitOverQuandUneCommandeEstExecutee!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).experienceLevel : 0) >= 125)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperienceLevel(-((int) 100));
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemEderniumSword.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemHucknessBow.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemHucknessArrow.block, (int) (1));
				_setstack.setCount(32);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemEderniumApple.block, (int) (1));
				_setstack.setCount(2);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemEdernium.block, (int) (1));
				_setstack.setCount(3);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
