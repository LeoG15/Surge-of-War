
package com.leovideo.surgeofwar.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import com.leovideo.surgeofwar.creativetab.TabBlocksOfSurge;
import com.leovideo.surgeofwar.ElementsSurgeofWar;

@ElementsSurgeofWar.ModElement.Tag
public class BlockAmethisteore extends ElementsSurgeofWar.ModElement {
	@GameRegistry.ObjectHolder("surgeofwar:amethisteore")
	public static final Block block = null;
	public BlockAmethisteore(ElementsSurgeofWar instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("amethisteore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("surgeofwar:amethisteore", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("amethisteore");
			setSoundType(SoundType.STONE);
			setHardness(1F);
			setResistance(12F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabBlocksOfSurge.tab);
		}
	}
}