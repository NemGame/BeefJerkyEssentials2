package lol.ngakos.beefjerkyessentials2.item;

import lol.ngakos.beefjerkyessentials2.BeefJerkyEssentials2;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item COOKED_JERKY = registerItem("beef_jerky", new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(3)
                    .saturationModifier(0.6f)
                    .build()
    )));
    public static final Item CRISPY_JERKY = registerItem("crispy_jerky", new Item((new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(0.8f)
                    .build()
    ))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, BeefJerkyEssentials2.id(name), item);
    }
    public static void registerModItems() {
        BeefJerkyEssentials2.LOGGER.info("Registering mod items for " + BeefJerkyEssentials2.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(COOKED_JERKY);
            entries.add(CRISPY_JERKY);
        });
    }
}
