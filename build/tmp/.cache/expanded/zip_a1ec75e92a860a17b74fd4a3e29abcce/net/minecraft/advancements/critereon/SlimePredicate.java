package net.minecraft.advancements.critereon;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.phys.Vec3;

public record SlimePredicate(MinMaxBounds.Ints size) implements EntitySubPredicate {
    public static final MapCodec<SlimePredicate> CODEC = RecordCodecBuilder.mapCodec(
        p_325249_ -> p_325249_.group(MinMaxBounds.Ints.CODEC.optionalFieldOf("size", MinMaxBounds.Ints.ANY).forGetter(SlimePredicate::size))
                .apply(p_325249_, SlimePredicate::new)
    );

    public static SlimePredicate sized(MinMaxBounds.Ints pSize) {
        return new SlimePredicate(pSize);
    }

    @Override
    public boolean matches(Entity pEntity, ServerLevel pLevel, @Nullable Vec3 pPosition) {
        return pEntity instanceof Slime slime ? this.size.matches(slime.getSize()) : false;
    }

    @Override
    public MapCodec<SlimePredicate> codec() {
        return EntitySubPredicates.SLIME;
    }
}