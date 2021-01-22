package party.lemons.rusted_iron;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RustedIron implements ModInitializer
{
	public static final Block WEATHERED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final RustingIronBlock SEMI_WEATHERED_IRON_BLOCK = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), WEATHERED_IRON_BLOCK);
	public static final RustingIronBlock LIGHTLY_WEATHERED_IRON_BLOCK = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), SEMI_WEATHERED_IRON_BLOCK);

	public static final Block WEATHERED_CUT_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final RustingIronBlock SEMI_WEATHERED_CUT_IRON_BLOCK = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), WEATHERED_CUT_IRON_BLOCK);
	public static final RustingIronBlock LIGHTLY_WEATHERED_CUT_IRON_BLOCK = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), SEMI_WEATHERED_CUT_IRON_BLOCK);
	public static final Block CUT_IRON_BLOCK = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), LIGHTLY_WEATHERED_CUT_IRON_BLOCK);

	public static final Block WAXED_SEMI_WEATHERED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_LIGHTLY_WEATHERED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_SEMI_WEATHERED_CUT_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_LIGHTLY_WEATHERED_CUT_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_CUT_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WEATHERED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final RustingIronSlabBlock SEMI_WEATHERED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), WEATHERED_IRON_SLAB);
	public static final RustingIronSlabBlock LIGHTLY_WEATHERED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), SEMI_WEATHERED_IRON_SLAB);
	public static final RustingIronSlabBlock IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), LIGHTLY_WEATHERED_IRON_SLAB);

	public static final Block WEATHERED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final RustingIronSlabBlock SEMI_WEATHERED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), WEATHERED_CUT_IRON_SLAB);
	public static final RustingIronSlabBlock LIGHTLY_WEATHERED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), SEMI_WEATHERED_CUT_IRON_SLAB);
	public static final Block CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), LIGHTLY_WEATHERED_CUT_IRON_SLAB);

	public static final Block WAXED_SEMI_WEATHERED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_LIGHTLY_WEATHERED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_SEMI_WEATHERED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_LIGHTLY_WEATHERED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WEATHERED_IRON_STAIRS = new PublicStairsBlock(WEATHERED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final RustingIronStairsBlock SEMI_WEATHERED_IRON_STAIRS = new RustingIronStairsBlock(SEMI_WEATHERED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), WEATHERED_IRON_STAIRS);
	public static final RustingIronStairsBlock LIGHTLY_WEATHERED_IRON_STAIRS = new RustingIronStairsBlock(LIGHTLY_WEATHERED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), SEMI_WEATHERED_IRON_STAIRS);
	public static final RustingIronStairsBlock IRON_STAIRS = new RustingIronStairsBlock(Blocks.IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), LIGHTLY_WEATHERED_IRON_STAIRS);

	public static final Block WEATHERED_CUT_IRON_STAIRS = new PublicStairsBlock(WEATHERED_CUT_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final RustingIronStairsBlock SEMI_WEATHERED_CUT_IRON_STAIRS = new RustingIronStairsBlock(SEMI_WEATHERED_CUT_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), WEATHERED_CUT_IRON_STAIRS);
	public static final RustingIronStairsBlock LIGHTLY_WEATHERED_CUT_IRON_STAIRS = new RustingIronStairsBlock(LIGHTLY_WEATHERED_CUT_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), SEMI_WEATHERED_CUT_IRON_STAIRS);
	public static final RustingIronStairsBlock CUT_IRON_STAIRS = new RustingIronStairsBlock(CUT_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), LIGHTLY_WEATHERED_CUT_IRON_STAIRS);

	public static final Block WAXED_SEMI_WEATHERED_IRON_STAIRS = new PublicStairsBlock(WAXED_SEMI_WEATHERED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_LIGHTLY_WEATHERED_IRON_STAIRS = new PublicStairsBlock(WAXED_LIGHTLY_WEATHERED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_IRON_STAIRS = new PublicStairsBlock(WAXED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_SEMI_WEATHERED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_SEMI_WEATHERED_CUT_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_LIGHTLY_WEATHERED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_LIGHTLY_WEATHERED_CUT_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_CUT_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));


	@Override
	public void onInitialize()
	{
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "lightly_weathered_iron_block"), LIGHTLY_WEATHERED_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "semi_weathered_iron_block"), SEMI_WEATHERED_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "weathered_iron_block"), WEATHERED_IRON_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "cut_iron_block"), CUT_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "weathered_cut_iron_block"), WEATHERED_CUT_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "semi_weathered_cut_iron_block"), SEMI_WEATHERED_CUT_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "lightly_weathered_cut_iron_block"), LIGHTLY_WEATHERED_CUT_IRON_BLOCK);

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "lightly_weathered_iron_block"), new BlockItem(LIGHTLY_WEATHERED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "semi_weathered_iron_block"), new BlockItem(SEMI_WEATHERED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "weathered_iron_block"), new BlockItem(WEATHERED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "cut_iron_block"), new BlockItem(CUT_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "weathered_cut_iron_block"), new BlockItem(WEATHERED_CUT_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "semi_weathered_cut_iron_block"), new BlockItem(SEMI_WEATHERED_CUT_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "lightly_weathered_cut_iron_block"), new BlockItem(LIGHTLY_WEATHERED_CUT_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "lightly_weathered_iron_slab"), LIGHTLY_WEATHERED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "weathered_iron_slab"), WEATHERED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "semi_weathered_iron_slab"), SEMI_WEATHERED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "iron_slab"), IRON_SLAB);

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "cut_iron_slab"), CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "weathered_cut_iron_slab"), WEATHERED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "semi_weathered_cut_iron_slab"), SEMI_WEATHERED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "lightly_weathered_cut_iron_slab"), LIGHTLY_WEATHERED_CUT_IRON_SLAB);

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "weathered_iron_slab"), new BlockItem(WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "lightly_weathered_iron_slab"), new BlockItem(LIGHTLY_WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "semi_weathered_iron_slab"), new BlockItem(SEMI_WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "iron_slab"), new BlockItem(IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "cut_iron_slab"), new BlockItem(CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "weathered_cut_iron_slab"), new BlockItem(WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "semi_weathered_cut_iron_slab"), new BlockItem(SEMI_WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "lightly_weathered_cut_iron_slab"), new BlockItem(LIGHTLY_WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "lightly_weathered_iron_stairs"), LIGHTLY_WEATHERED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "semi_weathered_iron_stairs"), SEMI_WEATHERED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "iron_stairs"), IRON_STAIRS);

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "cut_iron_stairs"), CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "semi_weathered_cut_iron_stairs"), SEMI_WEATHERED_CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "lightly_weathered_cut_iron_stairs"), LIGHTLY_WEATHERED_CUT_IRON_STAIRS);

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "lightly_weathered_iron_stairs"), new BlockItem(LIGHTLY_WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "semi_weathered_iron_stairs"), new BlockItem(SEMI_WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "weathered_iron_stairs"), new BlockItem(WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "iron_stairs"), new BlockItem(IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "cut_iron_stairs"), new BlockItem(CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "weathered_cut_iron_stairs"), new BlockItem(WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "semi_weathered_cut_iron_stairs"), new BlockItem(SEMI_WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "lightly_weathered_cut_iron_stairs"), new BlockItem(LIGHTLY_WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_lightly_weathered_iron_block"), WAXED_LIGHTLY_WEATHERED_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_semi_weathered_iron_block"), WAXED_SEMI_WEATHERED_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_iron_block"), WAXED_IRON_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_cut_iron_block"), WAXED_CUT_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_semi_weathered_cut_iron_block"), WAXED_SEMI_WEATHERED_CUT_IRON_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_lightly_weathered_cut_iron_block"), WAXED_LIGHTLY_WEATHERED_CUT_IRON_BLOCK);

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_lightly_weathered_iron_block"), new BlockItem(WAXED_LIGHTLY_WEATHERED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_semi_weathered_iron_block"), new BlockItem(WAXED_SEMI_WEATHERED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_iron_block"), new BlockItem(WAXED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_cut_iron_block"), new BlockItem(WAXED_CUT_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_semi_weathered_cut_iron_block"), new BlockItem(WAXED_SEMI_WEATHERED_CUT_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_lightly_weathered_cut_iron_block"), new BlockItem(WAXED_LIGHTLY_WEATHERED_CUT_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_lightly_weathered_iron_slab"), WAXED_LIGHTLY_WEATHERED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_semi_weathered_iron_slab"), WAXED_SEMI_WEATHERED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_iron_slab"), WAXED_IRON_SLAB);

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_cut_iron_slab"), WAXED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_semi_weathered_cut_iron_slab"), WAXED_SEMI_WEATHERED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_lightly_weathered_cut_iron_slab"), WAXED_LIGHTLY_WEATHERED_CUT_IRON_SLAB);

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_lightly_weathered_iron_slab"), new BlockItem(WAXED_LIGHTLY_WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_semi_weathered_iron_slab"), new BlockItem(WAXED_SEMI_WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_iron_slab"), new BlockItem(WAXED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_cut_iron_slab"), new BlockItem(WAXED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_semi_weathered_cut_iron_slab"), new BlockItem(WAXED_SEMI_WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_lightly_weathered_cut_iron_slab"), new BlockItem(WAXED_LIGHTLY_WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_lightly_weathered_iron_stairs"), WAXED_LIGHTLY_WEATHERED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_semi_weathered_iron_stairs"), WAXED_SEMI_WEATHERED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_iron_stairs"), WAXED_IRON_STAIRS);

		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_cut_iron_stairs"), WAXED_CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_semi_weathered_cut_iron_stairs"), WAXED_SEMI_WEATHERED_CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("rusted-iron", "waxed_lightly_weathered_cut_iron_stairs"), WAXED_LIGHTLY_WEATHERED_CUT_IRON_STAIRS);

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_lightly_weathered_iron_stairs"), new BlockItem(WAXED_LIGHTLY_WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_semi_weathered_iron_stairs"), new BlockItem(WAXED_SEMI_WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_iron_stairs"), new BlockItem(WAXED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_cut_iron_stairs"), new BlockItem(WAXED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_semi_weathered_cut_iron_stairs"), new BlockItem(WAXED_SEMI_WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("rusted-iron", "waxed_lightly_weathered_cut_iron_stairs"), new BlockItem(WAXED_LIGHTLY_WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
