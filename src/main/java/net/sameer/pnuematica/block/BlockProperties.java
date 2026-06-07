package net.sameer.pnuematica.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

/**
 * Builder class for creating block properties with common configurations.
 * Use this to define block behavior properties easily.
 */
public class BlockProperties {
    private final Material material;
    private float strength;
    private boolean requiresCorrectTool;

    /**
     * Create block properties with a specific material.
     * @param material The material type (e.g., Material.STONE, Material.METAL)
     */
    public BlockProperties(Material material) {
        this.material = material;
        this.strength = 1f;
        this.requiresCorrectTool = false;
    }

    /**
     * Set block strength (how long it takes to break).
     * Higher values = harder to break.
     */
    public BlockProperties strength(float strength) {
        this.strength = strength;
        return this;
    }

    /**
     * Require correct tool for block drops.
     */
    public BlockProperties requiresCorrectTool() {
        this.requiresCorrectTool = true;
        return this;
    }

    /**
     * Build the BlockBehaviour.Properties.
     */
    public BlockBehaviour.Properties build() {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of(material).strength(strength);
        if (requiresCorrectTool) {
            props = props.requiresCorrectToolForDrops();
        }
        return props;
    }

    // Common presets
    public static BlockProperties stone() {
        return new BlockProperties(Material.STONE).strength(6f).requiresCorrectTool();
    }

    public static BlockProperties metal() {
        return new BlockProperties(Material.METAL).strength(8f).requiresCorrectTool();
    }

    public static BlockProperties wood() {
        return new BlockProperties(Material.WOOD).strength(2f);
    }

    public static BlockProperties dirt() {
        return new BlockProperties(Material.DIRT).strength(0.5f);
    }
}
