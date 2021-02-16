package com.leovideo.surgeofwar.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.leovideo.surgeofwar.item.ItemVitrome;
import com.leovideo.surgeofwar.item.ItemEderniumFragment;
import com.leovideo.surgeofwar.item.ItemCuivre;
import com.leovideo.surgeofwar.item.ItemAmethiste;
import com.leovideo.surgeofwar.block.BlockEderniumFlower;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ProcedureKitMineraisQuandUneCommandeEstExecutee extends ElementsSurgeofwarMod.ModElement {
	public ProcedureKitMineraisQuandUneCommandeEstExecutee(ElementsSurgeofwarMod instance) {
		super(instance, 401);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KitMineraisQuandUneCommandeEstExecutee!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).experienceLevel : 0) >= 50)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperienceLevel(-((int) 30));
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemCuivre.block, (int) (1));
				_setstack.setCount(10);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemAmethiste.block, (int) (1));
				_setstack.setCount(7);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemVitrome.block, (int) (1));
				_setstack.setCount(3);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((Math.random() <= 3)) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemEderniumFragment.block, (int) (1));
				_setstack.setCount(2);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockEderniumFlower.block, (int) (1));
				_setstack.setCount(2);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
