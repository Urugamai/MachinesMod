package au.svr4.machinesmod.init;

import au.svr4.machinesmod.MachinesModMain;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static class ModCreativeTab extends CreativeModeTab {
        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "machinesmod");

        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CABLE.get());
        }
    }

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MachinesModMain.MOD_ID);

    public static final RegistryObject<Item> CABLE = ITEMS.register("cable",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
    // TODO Add items and properties such as Lava survival, etc, as needed
}
