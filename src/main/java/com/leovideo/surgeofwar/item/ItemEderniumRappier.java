
package com.leovideo.surgeofwar.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import com.leovideo.surgeofwar.creativetab.TabItemOfWar;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

import com.google.common.collect.Multimap;

@ElementsSurgeofwarMod.ModElement.Tag
public class ItemEderniumRappier extends ElementsSurgeofwarMod.ModElement {
	@GameRegistry.ObjectHolder("surgeofwar:ederniumrappier")
	public static final Item block = null;
	public ItemEderniumRappier(ElementsSurgeofwarMod instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
		}.setUnlocalizedName("ederniumrappier").setRegistryName("ederniumrappier").setCreativeTab(TabItemOfWar.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("surgeofwar:ederniumrappier", "inventory"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			setMaxDamage(20000);
			setMaxStackSize(1);
		}

		@Override
		public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 12f, 0));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -1, 0));
			}
			return multimap;
		}

		@Override
		public boolean canHarvestBlock(IBlockState blockIn) {
			return true;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 10f;
		}

		@Override
		public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
			stack.damageItem(1, attacker);
			return true;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
			stack.damageItem(1, entityLiving);
			return true;
		}

		@Override
		public boolean isFull3D() {
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 2;
		}
	}
}
