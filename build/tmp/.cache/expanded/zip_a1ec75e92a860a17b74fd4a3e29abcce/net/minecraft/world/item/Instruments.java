package net.minecraft.world.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;

public interface Instruments {
    int GOAT_HORN_RANGE_BLOCKS = 256;
    int GOAT_HORN_DURATION = 140;
    ResourceKey<Instrument> PONDER_GOAT_HORN = create("ponder_goat_horn");
    ResourceKey<Instrument> SING_GOAT_HORN = create("sing_goat_horn");
    ResourceKey<Instrument> SEEK_GOAT_HORN = create("seek_goat_horn");
    ResourceKey<Instrument> FEEL_GOAT_HORN = create("feel_goat_horn");
    ResourceKey<Instrument> ADMIRE_GOAT_HORN = create("admire_goat_horn");
    ResourceKey<Instrument> CALL_GOAT_HORN = create("call_goat_horn");
    ResourceKey<Instrument> YEARN_GOAT_HORN = create("yearn_goat_horn");
    ResourceKey<Instrument> DREAM_GOAT_HORN = create("dream_goat_horn");

    private static ResourceKey<Instrument> create(String pName) {
        return ResourceKey.create(Registries.INSTRUMENT, ResourceLocation.withDefaultNamespace(pName));
    }

    static Instrument bootstrap(Registry<Instrument> pRegistry) {
        Registry.register(pRegistry, PONDER_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(0), 140, 256.0F));
        Registry.register(pRegistry, SING_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(1), 140, 256.0F));
        Registry.register(pRegistry, SEEK_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(2), 140, 256.0F));
        Registry.register(pRegistry, FEEL_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(3), 140, 256.0F));
        Registry.register(pRegistry, ADMIRE_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(4), 140, 256.0F));
        Registry.register(pRegistry, CALL_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(5), 140, 256.0F));
        Registry.register(pRegistry, YEARN_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(6), 140, 256.0F));
        return Registry.register(pRegistry, DREAM_GOAT_HORN, new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(7), 140, 256.0F));
    }
}