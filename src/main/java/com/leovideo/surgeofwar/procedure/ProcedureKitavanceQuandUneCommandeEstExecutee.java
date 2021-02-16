package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemVitromeeShovel;
import com.leovideo.surgeofwar.item.ItemVitromeePickaxe;
import com.leovideo.surgeofwar.item.ItemVitromeeHoe;
import com.leovideo.surgeofwar.item.ItemVitromeeAxe;
import com.leovideo.surgeofwar.item.ItemVitromeSword;
import com.leovideo.surgeofwar.item.ItemVitromeArmor;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureKitavanceQuandUneCommandeEstExecutee extends ElementsSurgeofwarMod.ModElement {
	public ProcedureKitavanceQuandUneCommandeEstExecutee(ElementsSurgeofwarMod instance) {
		super(instance, 397);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KitavanceQuandUneCommandeEstExecutee!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).experienceLevel : 0) >= 50)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperienceLevel(-((int) 35));
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeArmor.boots, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeArmor.legs, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeArmor.body, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeArmor.helmet, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeSword.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeePickaxe.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeeAxe.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeeShovel.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitromeeHoe.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
