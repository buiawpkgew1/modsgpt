package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;


public class MyModEnglishLangProvider extends FabricLanguageProvider {
    private static final String SIMPLE_ITEM = "SIMPLE_ITEM";

    protected MyModEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(SIMPLE_ITEM, "Simple Item");

        // Load an existing language file.
        try {
            FabricDataOutput dataGenerator = null;
            Path existingFilePath = dataGenerator.getModContainer().findPath("assets/mymod/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
