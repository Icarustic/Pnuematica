package net.sameer.pnuematica.client;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.Level;

public class DummyWerewolfEntity extends Ravager {
    public DummyWerewolfEntity(Level level) {
        super(EntityType.RAVAGER, level); // Ravager visuals for testing
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Ravager.createAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.35D);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }
}