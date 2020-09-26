
package com.leovideo.surgeofwar.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;

import com.leovideo.surgeofwar.world.WorldViprin;
import com.leovideo.surgeofwar.creativetab.TabItemOfWar;

public class ItemViprin extends Item {
	@GameRegistry.ObjectHolder("surgeofwar:viprin")
	public static final Item block = null;
	public ItemViprin() {
		super();
		this.maxStackSize = 1;
		setMaxDamage(64);
		setCreativeTab(TabItemOfWar.tab);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		pos = pos.offset(facing);
		ItemStack itemstack = entity.getHeldItem(hand);
		if (!entity.canPlayerEdit(pos, facing, itemstack)) {
			return EnumActionResult.FAIL;
		} else {
			if (world.isAirBlock(pos))
				WorldViprin.portal.portalSpawn(world, pos);
			itemstack.damageItem(1, entity);
			return EnumActionResult.SUCCESS;
		}
	}
}
