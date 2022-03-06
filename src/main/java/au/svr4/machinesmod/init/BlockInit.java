package au.svr4.machinesmod.init;

import au.svr4.machinesmod.CableBlock;
import au.svr4.machinesmod.ExtruderBlock;
import au.svr4.machinesmod.MachinesModMain;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MachinesModMain.MOD_ID);

    public static final RegistryObject<Block> CABLE_BLOCK = BLOCKS.register("cable_block",
            () -> new CableBlock(Block.Properties.of(Material.GLASS).strength(4f, 1200f).requiresCorrectToolForDrops().lightLevel((state) -> 15).noOcclusion()));
    public static final RegistryObject<Block> EXTRUDER_BLOCK = BLOCKS.register("extruder_block",
            () -> new ExtruderBlock(Block.Properties.copy(Blocks.FURNACE).strength(4f, 1200f).lightLevel((state) -> 15)));
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach( (block) -> {
            final Item.Properties properties = new Item.Properties().tab(ItemInit.ModCreativeTab.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }
}
