package party.lemons.rusted_iron;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.particle.ParticleType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import party.lemons.rusted_iron.Rustable.OxidizationLevel;

public class RustedIron implements ModInitializer {

	public static final String modid = "rusted_iron";

	public static final Supplier<ImmutableBiMap<Object, Object>> UNWAXED_TO_WAXED_IRON_BLOCKS = Suppliers.memoize(() -> {
		return ImmutableBiMap.builder().put(Blocks.IRON_BLOCK, RustedIron.WAXED_IRON_BLOCK).put(RustedIron.EXPOSED_IRON, RustedIron.WAXED_EXPOSED_IRON).put(RustedIron.WEATHERED_IRON, RustedIron.WAXED_WEATHERED_IRON).put(RustedIron.RUSTED_IRON, RustedIron.WAXED_RUSTED_IRON)
				.put(RustedIron.CUT_IRON, RustedIron.WAXED_CUT_IRON).put(RustedIron.EXPOSED_CUT_IRON, RustedIron.WAXED_EXPOSED_CUT_IRON).put(RustedIron.WEATHERED_CUT_IRON, RustedIron.WAXED_WEATHERED_CUT_IRON).put(RustedIron.RUSTED_CUT_IRON, RustedIron.WAXED_RUSTED_CUT_IRON)
				.put(RustedIron.CUT_IRON_SLAB, RustedIron.WAXED_CUT_IRON_SLAB).put(RustedIron.EXPOSED_CUT_IRON_SLAB, RustedIron.WAXED_EXPOSED_CUT_IRON_SLAB).put(RustedIron.WEATHERED_CUT_IRON_SLAB, RustedIron.WAXED_WEATHERED_CUT_IRON_SLAB)
				.put(RustedIron.RUSTED_CUT_IRON_SLAB, RustedIron.WAXED_RUSTED_CUT_IRON_SLAB).put(RustedIron.CUT_IRON_STAIRS, RustedIron.WAXED_CUT_IRON_STAIRS).put(RustedIron.EXPOSED_CUT_IRON_STAIRS, RustedIron.WAXED_EXPOSED_CUT_IRON_STAIRS)
				.put(RustedIron.WEATHERED_CUT_IRON_STAIRS, RustedIron.WAXED_WEATHERED_CUT_IRON_STAIRS).put(RustedIron.RUSTED_CUT_IRON_STAIRS, RustedIron.WAXED_RUSTED_CUT_IRON_STAIRS).put(RustedIron.IRON_SLAB, RustedIron.WAXED_IRON_SLAB)
				.put(RustedIron.EXPOSED_IRON_SLAB, RustedIron.WAXED_EXPOSED_IRON_SLAB).put(RustedIron.WEATHERED_IRON_SLAB, RustedIron.WAXED_WEATHERED_IRON_SLAB).put(RustedIron.RUSTED_IRON_SLAB, RustedIron.WAXED_RUSTED_IRON_SLAB).put(RustedIron.IRON_STAIRS, RustedIron.WAXED_IRON_STAIRS)
				.put(RustedIron.EXPOSED_IRON_STAIRS, RustedIron.WAXED_EXPOSED_IRON_STAIRS).put(RustedIron.WEATHERED_IRON_STAIRS, RustedIron.WAXED_WEATHERED_IRON_STAIRS).put(RustedIron.RUSTED_IRON_STAIRS, RustedIron.WAXED_RUSTED_IRON_STAIRS).build();
	});
	public static final Supplier<BiMap<Object, Object>> WAXED_TO_UNWAXED_IRON_BLOCKS = Suppliers.memoize(() -> {
		return ((BiMap<Object, Object>) UNWAXED_TO_WAXED_IRON_BLOCKS.get()).inverse();
	});

	public static final RustingIronBlock EXPOSED_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronBlock WEATHERED_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronBlock RUSTED_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);

	public static final RustingIronBlock CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);
	public static final RustingIronBlock EXPOSED_CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronBlock WEATHERED_CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronBlock RUSTED_CUT_IRON = new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);

	public static final Block WAXED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_WEATHERED_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_RUSTED_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final Block WAXED_CUT_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_EXPOSED_CUT_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_WEATHERED_CUT_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final Block WAXED_RUSTED_CUT_IRON = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final RustingIronSlabBlock IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);
	public static final RustingIronSlabBlock EXPOSED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronSlabBlock WEATHERED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronSlabBlock RUSTED_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);

	public static final RustingIronSlabBlock CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);
	public static final RustingIronSlabBlock EXPOSED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronSlabBlock WEATHERED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronSlabBlock RUSTED_CUT_IRON_SLAB = new RustingIronSlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);

	public static final SlabBlock WAXED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final SlabBlock WAXED_EXPOSED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final SlabBlock WAXED_WEATHERED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final SlabBlock WAXED_RUSTED_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final SlabBlock WAXED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final SlabBlock WAXED_EXPOSED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final SlabBlock WAXED_WEATHERED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final SlabBlock WAXED_RUSTED_CUT_IRON_SLAB = new SlabBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final RustingIronStairsBlock IRON_STAIRS = new RustingIronStairsBlock(Blocks.IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);
	public static final RustingIronStairsBlock EXPOSED_IRON_STAIRS = new RustingIronStairsBlock(EXPOSED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronStairsBlock WEATHERED_IRON_STAIRS = new RustingIronStairsBlock(WEATHERED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronStairsBlock RUSTED_IRON_STAIRS = new RustingIronStairsBlock(RUSTED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);

	public static final RustingIronStairsBlock CUT_IRON_STAIRS = new RustingIronStairsBlock(CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED);
	public static final RustingIronStairsBlock EXPOSED_CUT_IRON_STAIRS = new RustingIronStairsBlock(EXPOSED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.EXPOSED);
	public static final RustingIronStairsBlock WEATHERED_CUT_IRON_STAIRS = new RustingIronStairsBlock(WEATHERED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.WEATHERED);
	public static final RustingIronStairsBlock RUSTED_CUT_IRON_STAIRS = new RustingIronStairsBlock(RUSTED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.OXIDIZED);

	public static final PublicStairsBlock WAXED_IRON_STAIRS = new PublicStairsBlock(WAXED_IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final PublicStairsBlock WAXED_EXPOSED_IRON_STAIRS = new PublicStairsBlock(WAXED_EXPOSED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final PublicStairsBlock WAXED_WEATHERED_IRON_STAIRS = new PublicStairsBlock(WAXED_WEATHERED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final PublicStairsBlock WAXED_RUSTED_IRON_STAIRS = new PublicStairsBlock(WAXED_WEATHERED_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static final PublicStairsBlock WAXED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final PublicStairsBlock WAXED_EXPOSED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_EXPOSED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final PublicStairsBlock WAXED_WEATHERED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_WEATHERED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));
	public static final PublicStairsBlock WAXED_RUSTED_CUT_IRON_STAIRS = new PublicStairsBlock(WAXED_WEATHERED_CUT_IRON.getDefaultState(), FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL));

	public static ParticleType<?> SCRAPE_IRON;
	
	@Override
	public void onInitialize() {
		SCRAPE_IRON = Registry.register(Registry.PARTICLE_TYPE, new Identifier(modid, "scrape_iron"), FabricParticleTypes.simple(true));
	}

}
