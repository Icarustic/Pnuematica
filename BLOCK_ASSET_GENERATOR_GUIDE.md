## BlockAssetGenerator - Automated Block Asset Creation

This utility automatically generates all the `.json` files needed for your custom blocks, so you only need to:
1. Create your texture
2. Run the generator
3. Add the block to ModBlocks.java

### Quick Start

**Step 1: Place your texture**
```
src/main/resources/assets/pnuematica/textures/block/ruby_block.png
```

**Step 2: Generate the assets**
Open `BlockAssetGenerator.java` and uncomment the main method, then run it:

```java
public static void main(String[] args) {
    generateBlockAssets("ruby_block");
}
```

This creates:
- `blockstates/ruby_block.json`
- `models/block/ruby_block.json`
- `models/item/ruby_block.json`

**Step 3: Add language entry to `en_us.json`**
Use the helper method to generate the correct format:
```java
System.out.println(generateLanguageEntry("ruby_block", "Block of Ruby"));
```
Output: `"block.pnuematica.ruby_block": "Block of Ruby"`

Copy this into `src/main/resources/assets/pnuematica/lang/en_us.json`

**Step 4: Add to ModBlocks.java**
```java
public static final RegistryObject<Block> Ruby_Block = registerBlocks("ruby_block",
    () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.Pnuematica_Tab);
```

Done! Your block is now in the mod.

### File Structure Created

For a block named `ruby_block`:

```
src/main/resources/assets/pnuematica/
├── blockstates/
│   └── ruby_block.json          (AUTO-GENERATED)
├── models/
│   ├── block/
│   │   └── ruby_block.json      (AUTO-GENERATED)
│   └── item/
│       └── ruby_block.json      (AUTO-GENERATED)
├── textures/block/
│   └── ruby_block.png           (YOU CREATE THIS)
└── lang/
    └── en_us.json               (UPDATE MANUALLY)
```

### For Complex/Custom Blocks

If you need custom behavior, create a block class and use it:

```java
public static final RegistryObject<Block> MyCustomBlock = registerBlocks("my_custom_block",
    () -> new MyCustomBlockClass(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.Pnuematica_Tab);
```

The asset generator still creates all the JSON files—only the block class itself is custom!

### One-Time Setup

After generating assets for the first time, you can leave `BlockAssetGenerator.java` in your project or comment out the main method. It's reusable whenever you add new blocks.

---

**Now you only need to:**
1. Create texture + Run generator = 2 automatic steps
2. Update language file = 1 line to copy
3. Add to ModBlocks = Full control over properties and creative tab

No more manual JSON creation! ✓
