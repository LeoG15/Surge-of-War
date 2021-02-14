
package com.leovideo.surgeofwar.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import com.leovideo.surgeofwar.creativetab.TabItemOfWar;
import com.leovideo.surgeofwar.ElementsSurgeofwarMod;

@ElementsSurgeofwarMod.ModElement.Tag
public class ItemMercureArmor extends ElementsSurgeofwarMod.ModElement {
	@GameRegistry.ObjectHolder("surgeofwar:mercure_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("surgeofwar:mercure_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("surgeofwar:mercure_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("surgeofwar:mercure_armorboots")
	public static final Item boots = null;
	public ItemMercureArmor(ElementsSurgeofwarMod instance) {
		super(instance, 270);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("MERCURE_ARMOR", "surgeofwar:mercure_", 420, new int[]{6, 7, 8, 7}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("mercure_armorhelmet")
				.setRegistryName("mercure_armorhelmet").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("mercure_armorbody")
				.setRegistryName("mercure_armorbody").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("mercure_armorlegs")
				.setRegistryName("mercure_armorlegs").setCreativeTab(TabItemOfWar.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("mercure_armorboots")
				.setRegistryName("mercure_armorboots").setCreativeTab(TabItemOfWar.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("surgeofwar:mercure_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("surgeofwar:mercure_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("surgeofwar:mercure_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("surgeofwar:mercure_armorboots", "inventory"));
	}
}
