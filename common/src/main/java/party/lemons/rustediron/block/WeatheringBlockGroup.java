package party.lemons.rustediron.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import party.lemons.rustediron.Constants;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class WeatheringBlockGroup
{
	private final String prefix, postfix;
	private final String[] stages;
	private final WeatheringIron.IronState[] states;
	private final Factory factory;

	public final List<Supplier<Block>> blocks = Lists.newArrayList();
	public final Map<WeatheringIron.IronState, Supplier<Block>> state_to_block = Maps.newHashMap();

	public WeatheringBlockGroup(String prefix, String postfix, String[] stages, WeatheringIron.IronState[] states, Factory factory)
	{
		this.prefix = prefix;
		this.postfix = postfix;
		this.stages = stages;
		this.states = states;
		this.factory = factory;
	}

	public WeatheringBlockGroup addBlockOverride(Supplier<Block> block, WeatheringIron.IronState state)
	{
		//Used to insert regular iron block
		blocks.add(block);
		state_to_block.put(state, block);
		return this;
	}

	public WeatheringBlockGroup register(DeferredRegister<Block> blockRegistry, DeferredRegister<Item> itemRegister)
	{
		for(int i = 0; i < states.length; i++)
		{
			String stage = stages[i];
			WeatheringIron.IronState state = states[i];

			String name = prefix + stage + postfix;
			ResourceLocation location = new ResourceLocation(Constants.MOD_ID, name);

			RegistrySupplier<Block> block = blockRegistry.register(location, factory.create(state));

			itemRegister.register(location, ()->new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

			blocks.add(block);
			state_to_block.put(state, block);
		}
		WeatheringIron.GROUPS.add(this);
		return this;
	}

	public void registerWeatherables()
	{
		for(int i = 0; i < blocks.size() - 1; i++)
		{
			Supplier<Block> next = blocks.get(i + 1);
			WeatheringIron.NEXT_BY_BLOCK.put(blocks.get(i).get(), next.get());
		}
	}

	public interface Factory{
		Supplier<Block> create(WeatheringIron.IronState age);
	}
}
