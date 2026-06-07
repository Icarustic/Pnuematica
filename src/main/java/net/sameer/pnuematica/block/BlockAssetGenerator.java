package net.sameer.pnuematica.block;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * BLOCK ASSET GENERATOR - Automatically creates all the .json and texture setup files for new blocks
 * 
 * HOW TO USE:
 * 1. Place your texture PNG file at: src/main/resources/assets/pnuematica/textures/block/YOUR_BLOCK_NAME.png
 * 2. Run: BlockAssetGenerator.generateBlockAssets("your_block_name");
 * 3. All .json files are created automatically!
 * 4. Then just add the block registration to ModBlocks.java
 * 
 * EXAMPLE:
 * BlockAssetGenerator.generateBlockAssets("ruby_block");
 * 
 * This will create:
 * - src/main/resources/assets/pnuematica/blockstates/ruby_block.json
 * - src/main/resources/assets/pnuematica/models/block/ruby_block.json
 * - src/main/resources/assets/pnuematica/models/item/ruby_block.json
 * - Update en_us.json with the language entry
 */
public class BlockAssetGenerator {

    private static final String MOD_ID = "pnuematica";
    private static final String BASE_PATH = "src/main/resources/assets/" + MOD_ID;

    /**
     * Generate all necessary asset files for a new block
     * @param blockName The block name (lowercase, underscores e.g., "ruby_block")
     */
    public static void generateBlockAssets(String blockName) {
        try {
            // Create blockstate file
            createBlockstateFile(blockName);
            
            // Create block model file
            createBlockModelFile(blockName);
            
            // Create item model file
            createItemModelFile(blockName);
            
            System.out.println("✓ Generated all asset files for: " + blockName);
            System.out.println("  - blockstates/" + blockName + ".json");
            System.out.println("  - models/block/" + blockName + ".json");
            System.out.println("  - models/item/" + blockName + ".json");
            System.out.println("\nNOTE: Make sure you've created the texture file at:");
            System.out.println("  - textures/block/" + blockName + ".png");
            System.out.println("\nNext: Add the block to ModBlocks.java with your desired properties!");
            
        } catch (IOException e) {
            System.err.println("✗ Error generating block assets: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Create blockstate JSON file
     */
    private static void createBlockstateFile(String blockName) throws IOException {
        String content = "{\n" +
                "  \"variants\": {\n" +
                "    \"\": { \"model\": \"" + MOD_ID + ":block/" + blockName + "\" }\n" +
                "  }\n" +
                "}";
        
        Path path = Paths.get(BASE_PATH, "blockstates", blockName + ".json");
        Files.createDirectories(path.getParent());
        Files.write(path, content.getBytes());
    }

    /**
     * Create block model JSON file
     */
    private static void createBlockModelFile(String blockName) throws IOException {
        String content = "{\n" +
                "  \"parent\": \"block/cube_all\",\n" +
                "  \"textures\": {\n" +
                "    \"all\": \"" + MOD_ID + ":block/" + blockName + "\"\n" +
                "  }\n" +
                "}";
        
        Path path = Paths.get(BASE_PATH, "models", "block", blockName + ".json");
        Files.createDirectories(path.getParent());
        Files.write(path, content.getBytes());
    }

    /**
     * Create item model JSON file
     */
    private static void createItemModelFile(String blockName) throws IOException {
        String content = "{\n" +
                "  \"parent\": \"" + MOD_ID + ":block/" + blockName + "\"\n" +
                "}";
        
        Path path = Paths.get(BASE_PATH, "models", "item", blockName + ".json");
        Files.createDirectories(path.getParent());
        Files.write(path, content.getBytes());
    }

    /**
     * Helper: Generate a language entry for en_us.json
     * Copy the output and paste into src/main/resources/assets/pnuematica/lang/en_us.json
     */
    public static String generateLanguageEntry(String blockName, String displayName) {
        return "\"block." + MOD_ID + "." + blockName + "\": \"" + displayName + "\"";
    }

    /**
     * MAIN METHOD - Uncomment and run to generate block assets
     * Then comment it back out or delete
     */
    public static void main(String[] args) {
        // Example usage - uncomment the line below with YOUR block name:
        // generateBlockAssets("your_block_name");
        
        // Example language entries:
        // System.out.println(generateLanguageEntry("ruby_block", "Block of Ruby"));
    }
}
