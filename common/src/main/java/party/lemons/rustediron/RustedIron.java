package party.lemons.rustediron;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import party.lemons.rustediron.block.*;

import java.util.function.Supplier;

public class RustedIron
{
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Constants.MOD_ID, Registry.BLOCK_REGISTRY);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Constants.MOD_ID, Registry.ITEM_REGISTRY);
	private static final String[] full_stages = new String[]{"", "exposed_", "weathered_", "rusted_"};
	private static final String[] missing_first_stages = new String[]{"exposed_", "weathered_", "rusted_"};
	private static final String[] missing_last_stages = new String[]{"", "exposed_", "weathered_"};

	private static final WeatheringIron.IronState[] full_state = WeatheringIron.IronState.values();
	private static final WeatheringIron.IronState[] missing_first_state = new WeatheringIron.IronState[]{WeatheringIron.IronState.EXPOSED, WeatheringIron.IronState.WEATHERED, WeatheringIron.IronState.RUSTED};
	private static final WeatheringIron.IronState[] missing_last_state = new WeatheringIron.IronState[]{WeatheringIron.IronState.UNAFFECTED, WeatheringIron.IronState.EXPOSED, WeatheringIron.IronState.WEATHERED};

	public static final WeatheringBlockGroup IRON_BLOCKS = new WeatheringBlockGroup("", "iron_block", missing_first_stages, missing_first_state,
			(age)-> ()->new RustingIronFullBlock(age, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).addBlockOverride(()-> Blocks.IRON_BLOCK, WeatheringIron.IronState.UNAFFECTED).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup IRON_BLOCK_SLABS = new WeatheringBlockGroup("", "iron_slab", full_stages, full_state,
			(age)-> ()->new RustingIronSlabBlock(age, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup IRON_BLOCK_STAIRS = new WeatheringBlockGroup("", "iron_stairs", full_stages, full_state,
			(age)-> ()->new RustingIronStairBlock(age, IRON_BLOCKS.state_to_block.get(age).get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup WAXED_IRON_BLOCKS = new WeatheringBlockGroup("waxed_", "iron_block", missing_last_stages, missing_last_state,
			(age)-> ()->new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup WAXED_IRON_BLOCK_SLABS = new WeatheringBlockGroup("waxed_", "iron_slab", missing_last_stages, missing_last_state,
			(age)-> ()->new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup WAXED_IRON_BLOCK_STAIRS = new WeatheringBlockGroup("waxed_", "iron_stairs", missing_last_stages, missing_last_state,
			(age)-> ()->new StairBlock(WAXED_IRON_BLOCKS.state_to_block.get(age).get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup CUT_IRON_BLOCKS = new WeatheringBlockGroup("", "cut_iron_block", full_stages, full_state,
			(age)-> ()->new RustingIronFullBlock(age, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup CUT_IRON_BLOCK_SLABS = new WeatheringBlockGroup("", "cut_iron_slab", full_stages, full_state,
			(age)-> ()->new RustingIronSlabBlock(age, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup CUT_IRON_BLOCK_STAIRS = new WeatheringBlockGroup("", "cut_iron_stairs", full_stages, full_state,
			(age)-> ()->new RustingIronStairBlock(age, CUT_IRON_BLOCKS.state_to_block.get(age).get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup WAXED_CUT_IRON_BLOCKS = new WeatheringBlockGroup("waxed_", "cut_iron_block", missing_last_stages, missing_last_state,
			(age)-> ()->new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup WAXED_CUT_IRON_BLOCK_SLABS = new WeatheringBlockGroup("waxed_", "cut_iron_slab", missing_last_stages, missing_last_state,
			(age)-> ()->new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final WeatheringBlockGroup WAXED_CUT_IRON_BLOCK_STAIRS = new WeatheringBlockGroup("waxed_", "cut_iron_stairs", missing_last_stages, missing_last_state,
			(age)-> ()->new StairBlock(WAXED_CUT_IRON_BLOCKS.state_to_block.get(age).get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
	).register(BLOCKS, ITEMS);

	public static final BiMap<WeatheringBlockGroup, WeatheringBlockGroup> WAX_GROUP_MAP = HashBiMap.create();
	private static BiMap<Block, Block> WAX_MAP = HashBiMap.create();
	private static BiMap<Block, Block> WAX_MAP_INV = null;

	public static void init()
	{
		BLOCKS.register();
		ITEMS.register();

		WAX_GROUP_MAP.put(IRON_BLOCKS, WAXED_IRON_BLOCKS);
		WAX_GROUP_MAP.put(IRON_BLOCK_SLABS, WAXED_IRON_BLOCK_SLABS);
		WAX_GROUP_MAP.put(IRON_BLOCK_STAIRS, WAXED_IRON_BLOCK_STAIRS);

		WAX_GROUP_MAP.put(CUT_IRON_BLOCKS, WAXED_CUT_IRON_BLOCKS);
		WAX_GROUP_MAP.put(CUT_IRON_BLOCK_SLABS, WAXED_CUT_IRON_BLOCK_SLABS);
		WAX_GROUP_MAP.put(CUT_IRON_BLOCK_STAIRS, WAXED_CUT_IRON_BLOCK_STAIRS);
	}

	public static BiMap<Block, Block> getWaxMap()
	{
		if(WAX_MAP.isEmpty())
		{
			for(WeatheringBlockGroup group : WAX_GROUP_MAP.keySet())
			{
				WeatheringBlockGroup group2 = WAX_GROUP_MAP.get(group);
				for(int i = 0; i < group2.blocks.size(); i++)
				{
					Supplier<Block> blockSupplier = group.blocks.get(i);
					Supplier<Block> blockSupplier2 = group2.blocks.get(i);

					WAX_MAP.put(blockSupplier.get(), blockSupplier2.get());
				}
			}
		}

		return WAX_MAP;
	}

	public static BiMap<Block, Block> getWaxMapInv()
	{
		if(WAX_MAP_INV == null)
		{
			WAX_MAP_INV = getWaxMap().inverse();
		}
		return WAX_MAP_INV;
	}
}
