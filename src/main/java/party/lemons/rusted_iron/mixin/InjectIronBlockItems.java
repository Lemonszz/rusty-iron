package party.lemons.rusted_iron.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import party.lemons.rusted_iron.RustedIron;

@Mixin(Items.class)
public class InjectIronBlockItems {
	
	private static final String modid = RustedIron.modid;
	
	@Inject(method = "register(Lnet/minecraft/item/BlockItem;)Lnet/minecraft/item/Item;", at = @At("HEAD"), cancellable = true)
	private static void replaceIronBlock(BlockItem blockItem, CallbackInfoReturnable<Item> cir) {
		if (blockItem.getBlock() == Blocks.EXPOSED_COPPER) {
			registerItems();
		}
	}
	
	private static void registerItems () {
		register(new Identifier(modid, "exposed_iron"), new BlockItem(RustedIron.EXPOSED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "weathered_iron"), new BlockItem(RustedIron.WEATHERED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "rusted_iron"), new BlockItem(RustedIron.RUSTED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		register(new Identifier(modid, "cut_iron"), new BlockItem(RustedIron.CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "exposed_cut_iron"), new BlockItem(RustedIron.EXPOSED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "weathered_cut_iron"), new BlockItem(RustedIron.WEATHERED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "rusted_cut_iron"), new BlockItem(RustedIron.RUSTED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		register(new Identifier(modid, "iron_stairs"), new BlockItem(RustedIron.IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "exposed_iron_stairs"), new BlockItem(RustedIron.EXPOSED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "weathered_iron_stairs"), new BlockItem(RustedIron.WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "rusted_iron_stairs"), new BlockItem(RustedIron.RUSTED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		register(new Identifier(modid, "cut_iron_stairs"), new BlockItem(RustedIron.CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "exposed_cut_iron_stairs"), new BlockItem(RustedIron.EXPOSED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "weathered_cut_iron_stairs"), new BlockItem(RustedIron.WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "rusted_cut_iron_stairs"), new BlockItem(RustedIron.RUSTED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	
		register(new Identifier(modid, "iron_slab"), new BlockItem(RustedIron.IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "exposed_iron_slab"), new BlockItem(RustedIron.EXPOSED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "weathered_iron_slab"), new BlockItem(RustedIron.WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "rusted_iron_slab"), new BlockItem(RustedIron.RUSTED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		register(new Identifier(modid, "cut_iron_slab"), new BlockItem(RustedIron.CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "exposed_cut_iron_slab"), new BlockItem(RustedIron.EXPOSED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "weathered_cut_iron_slab"), new BlockItem(RustedIron.WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "rusted_cut_iron_slab"), new BlockItem(RustedIron.RUSTED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		
		register(new Identifier(modid, "waxed_iron_block"), new BlockItem(RustedIron.WAXED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_exposed_iron"), new BlockItem(RustedIron.WAXED_EXPOSED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_weathered_iron"), new BlockItem(RustedIron.WAXED_WEATHERED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_rusted_iron"), new BlockItem(RustedIron.WAXED_RUSTED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		register(new Identifier(modid, "waxed_cut_iron"), new BlockItem(RustedIron.WAXED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_exposed_cut_iron"), new BlockItem(RustedIron.WAXED_EXPOSED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_weathered_cut_iron"), new BlockItem(RustedIron.WAXED_WEATHERED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_rusted_cut_iron"), new BlockItem(RustedIron.WAXED_RUSTED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	
		register(new Identifier(modid, "waxed_iron_stairs"), new BlockItem(RustedIron.WAXED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_exposed_iron_stairs"), new BlockItem(RustedIron.WAXED_EXPOSED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_weathered_iron_stairs"), new BlockItem(RustedIron.WAXED_WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_rusted_iron_stairs"), new BlockItem(RustedIron.WAXED_RUSTED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		register(new Identifier(modid, "waxed_cut_iron_stairs"), new BlockItem(RustedIron.WAXED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_exposed_cut_iron_stairs"), new BlockItem(RustedIron.WAXED_EXPOSED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_weathered_cut_iron_stairs"), new BlockItem(RustedIron.WAXED_WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_rusted_cut_iron_stairs"), new BlockItem(RustedIron.WAXED_RUSTED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		
		register(new Identifier(modid, "waxed_iron_slab"), new BlockItem(RustedIron.WAXED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_exposed_iron_slab"), new BlockItem(RustedIron.WAXED_EXPOSED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_weathered_iron_slab"), new BlockItem(RustedIron.WAXED_WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_rusted_iron_slab"), new BlockItem(RustedIron.WAXED_RUSTED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		register(new Identifier(modid, "waxed_cut_iron_slab"), new BlockItem(RustedIron.WAXED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_exposed_cut_iron_slab"), new BlockItem(RustedIron.WAXED_EXPOSED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_weathered_cut_iron_slab"), new BlockItem(RustedIron.WAXED_WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		register(new Identifier(modid, "waxed_rusted_cut_iron_slab"), new BlockItem(RustedIron.WAXED_RUSTED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}
	
	@Shadow
	private static Item register(Identifier id, Item item) {
		if (item instanceof BlockItem) {
			((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
		}
		return (Item) Registry.register(Registry.ITEM, (Identifier) id, item);
	}
	
}
