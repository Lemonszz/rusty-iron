package party.lemons.rusted_iron.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import party.lemons.rusted_iron.Rustable.OxidizationLevel;
import party.lemons.rusted_iron.RustedIron;
import party.lemons.rusted_iron.RustingIronBlock;

@Mixin(Blocks.class)
public class InjectIronBlocks {
	
	private static final String modid = RustedIron.modid;
	
	@Unique
	private static Block registerIronBlock(String id, Block block) {
		return (Block)Registry.register(Registry.BLOCK, (String)id, block);
	}
	
	@Unique
	private static Block registerIronBlock(Identifier id, Block block) {
		return (Block)Registry.register(Registry.BLOCK, id, block);
	}
	
	@Inject(method = "register", at = @At("HEAD"), cancellable = true)
	private static void replaceIronBlock(String id, Block block, CallbackInfoReturnable<Block> cir) {
		if (id.equals("iron_block")) {
			cir.setReturnValue(registerIronBlock("iron_block", new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED)));
		} else if (id.equals("exposed_copper")) {
			registerBlocks();
		}
	}
	
	@Unique
	private static void registerBlocks () {
		
		registerIronBlock(new Identifier(modid, "exposed_iron"), RustedIron.EXPOSED_IRON);
		registerIronBlock(new Identifier(modid, "weathered_iron"), RustedIron.WEATHERED_IRON);
		registerIronBlock(new Identifier(modid, "rusted_iron"), RustedIron.RUSTED_IRON);

		registerIronBlock(new Identifier(modid, "cut_iron"), RustedIron.CUT_IRON);
		registerIronBlock(new Identifier(modid, "exposed_cut_iron"), RustedIron.EXPOSED_CUT_IRON);
		registerIronBlock(new Identifier(modid, "weathered_cut_iron"), RustedIron.WEATHERED_CUT_IRON);
		registerIronBlock(new Identifier(modid, "rusted_cut_iron"), RustedIron.RUSTED_CUT_IRON);

		registerIronBlock(new Identifier(modid, "iron_stairs"), RustedIron.IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "exposed_iron_stairs"), RustedIron.EXPOSED_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "weathered_iron_stairs"), RustedIron.WEATHERED_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "rusted_iron_stairs"), RustedIron.RUSTED_IRON_STAIRS);

		registerIronBlock(new Identifier(modid, "cut_iron_stairs"), RustedIron.CUT_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "weathered_cut_iron_stairs"), RustedIron.WEATHERED_CUT_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "rusted_cut_iron_stairs"), RustedIron.RUSTED_CUT_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "exposed_cut_iron_stairs"), RustedIron.EXPOSED_CUT_IRON_STAIRS);
		
		registerIronBlock(new Identifier(modid, "iron_slab"), RustedIron.IRON_SLAB);
		registerIronBlock(new Identifier(modid, "exposed_iron_slab"), RustedIron.EXPOSED_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "weathered_iron_slab"), RustedIron.WEATHERED_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "rusted_iron_slab"), RustedIron.RUSTED_IRON_SLAB);

		registerIronBlock(new Identifier(modid, "cut_iron_slab"), RustedIron.CUT_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "exposed_cut_iron_slab"), RustedIron.EXPOSED_CUT_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "weathered_cut_iron_slab"), RustedIron.WEATHERED_CUT_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "rusted_cut_iron_slab"), RustedIron.RUSTED_CUT_IRON_SLAB);
		
		registerIronBlock(new Identifier(modid, "waxed_iron_block"), RustedIron.WAXED_IRON_BLOCK);
		registerIronBlock(new Identifier(modid, "waxed_exposed_iron"), RustedIron.WAXED_EXPOSED_IRON);
		registerIronBlock(new Identifier(modid, "waxed_weathered_iron"), RustedIron.WAXED_WEATHERED_IRON);
		registerIronBlock(new Identifier(modid, "waxed_rusted_iron"), RustedIron.WAXED_RUSTED_IRON);

		registerIronBlock(new Identifier(modid, "waxed_cut_iron"), RustedIron.WAXED_CUT_IRON);
		registerIronBlock(new Identifier(modid, "waxed_exposed_cut_iron"), RustedIron.WAXED_EXPOSED_CUT_IRON);
		registerIronBlock(new Identifier(modid, "waxed_weathered_cut_iron"), RustedIron.WAXED_WEATHERED_CUT_IRON);
		registerIronBlock(new Identifier(modid, "waxed_rusted_cut_iron"), RustedIron.WAXED_RUSTED_CUT_IRON);

		registerIronBlock(new Identifier(modid, "waxed_iron_stairs"), RustedIron.WAXED_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "waxed_exposed_iron_stairs"), RustedIron.WAXED_EXPOSED_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "waxed_weathered_iron_stairs"), RustedIron.WAXED_WEATHERED_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "waxed_rusted_iron_stairs"), RustedIron.WAXED_RUSTED_IRON_STAIRS);

		registerIronBlock(new Identifier(modid, "waxed_cut_iron_stairs"), RustedIron.WAXED_CUT_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "waxed_exposed_cut_iron_stairs"), RustedIron.WAXED_EXPOSED_CUT_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "waxed_weathered_cut_iron_stairs"), RustedIron.WAXED_WEATHERED_CUT_IRON_STAIRS);
		registerIronBlock(new Identifier(modid, "waxed_rusted_cut_iron_stairs"), RustedIron.WAXED_RUSTED_CUT_IRON_STAIRS);
	
		registerIronBlock(new Identifier(modid, "waxed_iron_slab"), RustedIron.WAXED_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "waxed_exposed_iron_slab"), RustedIron.WAXED_EXPOSED_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "waxed_weathered_iron_slab"), RustedIron.WAXED_WEATHERED_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "waxed_rusted_iron_slab"), RustedIron.WAXED_RUSTED_IRON_SLAB);
		
		registerIronBlock(new Identifier(modid, "waxed_cut_iron_slab"), RustedIron.WAXED_CUT_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "waxed_exposed_cut_iron_slab"), RustedIron.WAXED_EXPOSED_CUT_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "waxed_weathered_cut_iron_slab"), RustedIron.WAXED_WEATHERED_CUT_IRON_SLAB);
		registerIronBlock(new Identifier(modid, "waxed_rusted_cut_iron_slab"), RustedIron.WAXED_RUSTED_CUT_IRON_SLAB);
	}

}
