package com.example;

import com.example.item.redcomd;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("templatemod");

    public static final Item MAwnd = new Item(new FabricItemSettings());
    public static final redcomd CUSTOM_ITEM = new redcomd(new FabricItemSettings());

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CUSTOM_ITEM))
            .displayName(Text.translatable("itemGroup.tutorial.test_group"))
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        Registry.register(Registries.ITEM_GROUP, new Identifier("tutorial", "test_group"), ITEM_GROUP);
        FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
    }
}