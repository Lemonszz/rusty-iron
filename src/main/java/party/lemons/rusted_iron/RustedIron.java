package party.lemons.rusted_iron;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.mojang.serialization.Lifecycle;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import party.lemons.rusted_iron.Rustable.OxidizationLevel;

public class RustedIron implements ModInitializer
{
	
	public static final String modid = "rusted_iron";
	
	public static final Supplier<ImmutableBiMap<Object, Object>> UNWAXED_TO_WAXED_IRON_BLOCKS = Suppliers.memoize(() -> {
		return ImmutableBiMap.builder().put(Blocks.IRON_BLOCK, RustedIron.WAXED_IRON_BLOCK)
				.put(RustedIron.EXPOSED_IRON, RustedIron.WAXED_EXPOSED_IRON)
				.put(RustedIron.WEATHERED_IRON, RustedIron.WAXED_WEATHERED_IRON)
				//.put(RustedIron.RUSTED_IRON, RustedIron.WAXED_RUSTED_IRON)
				.put(RustedIron.CUT_IRON, RustedIron.WAXED_CUT_IRON)
				.put(RustedIron.EXPOSED_CUT_IRON, RustedIron.WAXED_EXPOSED_CUT_IRON)
				.put(RustedIron.WEATHERED_CUT_IRON, RustedIron.WAXED_WEATHERED_CUT_IRON)
				//.put(RustedIron.RUSTED_CUT_IRON, RustedIron.WAXED_RUSTED_CUT_IRON)
				.put(RustedIron.CUT_IRON_SLAB, RustedIron.WAXED_CUT_IRON_SLAB)
				.put(RustedIron.EXPOSED_CUT_IRON_SLAB, RustedIron.WAXED_EXPOSED_CUT_IRON_SLAB)
				.put(RustedIron.WEATHERED_CUT_IRON_SLAB, RustedIron.WAXED_WEATHERED_CUT_IRON_SLAB)
				//.put(RustedIron.RUSTED_CUT_IRON_SLAB, RustedIron.WAXED_RUSTED_CUT_IRON_SLAB)
				.put(RustedIron.CUT_IRON_STAIRS, RustedIron.WAXED_CUT_IRON_STAIRS)
				.put(RustedIron.EXPOSED_CUT_IRON_STAIRS, RustedIron.WAXED_EXPOSED_CUT_IRON_STAIRS)
				.put(RustedIron.WEATHERED_CUT_IRON_STAIRS, RustedIron.WAXED_WEATHERED_CUT_IRON_STAIRS)
				/*.put(RustedIron.RUSTED_CUT_IRON_STAIRS, RustedIron.WAXED_OXIDIZED_CUT_IRON_STAIRS)*/
				.put(RustedIron.IRON_SLAB, RustedIron.WAXED_IRON_SLAB)
				.put(RustedIron.EXPOSED_IRON_SLAB, RustedIron.WAXED_EXPOSED_IRON_SLAB)
				.put(RustedIron.WEATHERED_IRON_SLAB, RustedIron.WAXED_WEATHERED_IRON_SLAB)
				//.put(RustedIron.RUSTED_IRON_SLAB, RustedIron.WAXED_RUSTED_IRON_SLAB)
				.put(RustedIron.IRON_STAIRS, RustedIron.WAXED_IRON_STAIRS)
				.put(RustedIron.EXPOSED_IRON_STAIRS, RustedIron.WAXED_EXPOSED_IRON_STAIRS)
				.put(RustedIron.WEATHERED_IRON_STAIRS, RustedIron.WAXED_WEATHERED_IRON_STAIRS)
				/*.put(RustedIron.RUSTED_IRON_STAIRS, RustedIron.WAXED_OXIDIZED_IRON_STAIRS)*/.build();
	});
	public static final Supplier<BiMap<Block, Block>> WAXED_TO_UNWAXED_IRON_BLOCKS = Suppliers.memoize(() -> {
		return ((BiMap) UNWAXED_TO_WAXED_IRON_BLOCKS.get()).inverse();
	});
	
	public static final RustingIronBlock RUSTED_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);
	public static final RustingIronBlock WEATHERED_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronBlock EXPOSED_IRON= new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);

	
	public static final Block RUSTED_CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);
	public static final RustingIronBlock WEATHERED_CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronBlock EXPOSED_CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final Block CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);

	public static final Block WAXED_WEATHERED_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_WEATHERED_CUT_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_CUT_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_CUT_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final RustingIronSlabBlock RUSTED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);
	public static final RustingIronSlabBlock WEATHERED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronSlabBlock EXPOSED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronSlabBlock IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);

	public static final RustingIronSlabBlock RUSTED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);
	public static final RustingIronSlabBlock WEATHERED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronSlabBlock EXPOSED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final Block CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);

	public static final Block WAXED_WEATHERED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_WEATHERED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block RUSTED_IRON_STAIRS = new RustingIronStairsBlock(RUSTED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);
	public static final RustingIronStairsBlock WEATHERED_IRON_STAIRS = new RustingIronStairsBlock(WEATHERED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronStairsBlock EXPOSED_IRON_STAIRS = new RustingIronStairsBlock(EXPOSED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronStairsBlock IRON_STAIRS = new RustingIronStairsBlock(Blocks.IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);

	public static final Block RUSTED_CUT_IRON_STAIRS = new RustingIronStairsBlock(RUSTED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);
	public static final RustingIronStairsBlock WEATHERED_CUT_IRON_STAIRS = new RustingIronStairsBlock(WEATHERED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronStairsBlock EXPOSED_CUT_IRON_STAIRS = new RustingIronStairsBlock(EXPOSED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronStairsBlock CUT_IRON_STAIRS = new RustingIronStairsBlock(CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);

	public static final Block WAXED_WEATHERED_IRON_STAIRS = new PublicStairsBlock(WAXED_WEATHERED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_IRON_STAIRS = new PublicStairsBlock(WAXED_EXPOSED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_IRON_STAIRS = new PublicStairsBlock(WAXED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_WEATHERED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_WEATHERED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_EXPOSED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));


	@Override
	public void onInitialize()
	{
		
		//Registry.BLOCK.set(Registry.BLOCK.getRawId(Blocks.IRON_BLOCK), Registry.BLOCK.getKey(Blocks.IRON_BLOCK).get(), IRON_BLOCK, Lifecycle.stable());
		Registry.register(Registry.BLOCK, new Identifier(modid, "exposed_iron"), EXPOSED_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "weathered_iron"), WEATHERED_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "rusted_iron"), RUSTED_IRON);

		Registry.register(Registry.BLOCK, new Identifier(modid, "cut_iron"), CUT_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "rusted_cut_iron"), RUSTED_CUT_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "weathered_cut_iron"), WEATHERED_CUT_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "exposed_cut_iron"), EXPOSED_CUT_IRON);

		Registry.register(Registry.ITEM, new Identifier(modid, "exposed_iron"), new BlockItem(EXPOSED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "weathered_iron"), new BlockItem(WEATHERED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "rusted_iron"), new BlockItem(RUSTED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier(modid, "cut_iron"), new BlockItem(CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "rusted_cut_iron"), new BlockItem(RUSTED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "weathered_cut_iron"), new BlockItem(WEATHERED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "exposed_cut_iron"), new BlockItem(EXPOSED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier(modid, "exposed_iron_slab"), EXPOSED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "rusted_iron_slab"), RUSTED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "weathered_iron_slab"), WEATHERED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "iron_slab"), IRON_SLAB);

		Registry.register(Registry.BLOCK, new Identifier(modid, "cut_iron_slab"), CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "rusted_cut_iron_slab"), RUSTED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "weathered_cut_iron_slab"), WEATHERED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "exposed_cut_iron_slab"), EXPOSED_CUT_IRON_SLAB);

		Registry.register(Registry.ITEM, new Identifier(modid, "rusted_iron_slab"), new BlockItem(RUSTED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "exposed_iron_slab"), new BlockItem(EXPOSED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "weathered_iron_slab"), new BlockItem(WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "iron_slab"), new BlockItem(IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier(modid, "cut_iron_slab"), new BlockItem(CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "rusted_cut_iron_slab"), new BlockItem(RUSTED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "weathered_cut_iron_slab"), new BlockItem(WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "exposed_cut_iron_slab"), new BlockItem(EXPOSED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier(modid, "exposed_iron_stairs"), EXPOSED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "weathered_iron_stairs"), WEATHERED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "rusted_iron_stairs"), RUSTED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "iron_stairs"), IRON_STAIRS);

		Registry.register(Registry.BLOCK, new Identifier(modid, "cut_iron_stairs"), CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "weathered_cut_iron_stairs"), WEATHERED_CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "rusted_cut_iron_stairs"), RUSTED_CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "exposed_cut_iron_stairs"), EXPOSED_CUT_IRON_STAIRS);

		Registry.register(Registry.ITEM, new Identifier(modid, "exposed_iron_stairs"), new BlockItem(EXPOSED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "weathered_iron_stairs"), new BlockItem(WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "rusted_iron_stairs"), new BlockItem(RUSTED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "iron_stairs"), new BlockItem(IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier(modid, "cut_iron_stairs"), new BlockItem(CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "rusted_cut_iron_stairs"), new BlockItem(RUSTED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "weathered_cut_iron_stairs"), new BlockItem(WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "exposed_cut_iron_stairs"), new BlockItem(EXPOSED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_exposed_iron"), WAXED_EXPOSED_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_weathered_iron"), WAXED_WEATHERED_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_iron_block"), WAXED_IRON_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_cut_iron"), WAXED_CUT_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_weathered_cut_iron"), WAXED_WEATHERED_CUT_IRON);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_exposed_cut_iron"), WAXED_EXPOSED_CUT_IRON);

		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_exposed_iron"), new BlockItem(WAXED_EXPOSED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_weathered_iron"), new BlockItem(WAXED_WEATHERED_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_iron_block"), new BlockItem(WAXED_IRON_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_cut_iron"), new BlockItem(WAXED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_weathered_cut_iron"), new BlockItem(WAXED_WEATHERED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_exposed_cut_iron"), new BlockItem(WAXED_EXPOSED_CUT_IRON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_exposed_iron_slab"), WAXED_EXPOSED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_weathered_iron_slab"), WAXED_WEATHERED_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_iron_slab"), WAXED_IRON_SLAB);

		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_cut_iron_slab"), WAXED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_weathered_cut_iron_slab"), WAXED_WEATHERED_CUT_IRON_SLAB);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_exposed_cut_iron_slab"), WAXED_EXPOSED_CUT_IRON_SLAB);

		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_exposed_iron_slab"), new BlockItem(WAXED_EXPOSED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_weathered_iron_slab"), new BlockItem(WAXED_WEATHERED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_iron_slab"), new BlockItem(WAXED_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_cut_iron_slab"), new BlockItem(WAXED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_weathered_cut_iron_slab"), new BlockItem(WAXED_WEATHERED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_exposed_cut_iron_slab"), new BlockItem(WAXED_EXPOSED_CUT_IRON_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_exposed_iron_stairs"), WAXED_EXPOSED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_weathered_iron_stairs"), WAXED_WEATHERED_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_iron_stairs"), WAXED_IRON_STAIRS);

		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_cut_iron_stairs"), WAXED_CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_weathered_cut_iron_stairs"), WAXED_WEATHERED_CUT_IRON_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(modid, "waxed_exposed_cut_iron_stairs"), WAXED_EXPOSED_CUT_IRON_STAIRS);

		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_exposed_iron_stairs"), new BlockItem(WAXED_EXPOSED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_weathered_iron_stairs"), new BlockItem(WAXED_WEATHERED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_iron_stairs"), new BlockItem(WAXED_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_cut_iron_stairs"), new BlockItem(WAXED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_weathered_cut_iron_stairs"), new BlockItem(WAXED_WEATHERED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "waxed_exposed_cut_iron_stairs"), new BlockItem(WAXED_EXPOSED_CUT_IRON_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
