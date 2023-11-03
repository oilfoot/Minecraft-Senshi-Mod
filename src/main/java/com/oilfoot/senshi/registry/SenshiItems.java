package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.ToolMaterials.*;
import com.oilfoot.senshi.armor.fallen.FallenSamuraiArmorItem;
import com.oilfoot.senshi.armor.hood.HoodArmorItem;
import com.oilfoot.senshi.armor.hood.HoodArmorMaterial;
import com.oilfoot.senshi.armor.kumo_no_ashi.knaArmorItem;
import com.oilfoot.senshi.armor.kumo_no_ashi.knaArmorMaterial;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorItem;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorMaterial;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorItem;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorMaterial;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorItem;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorMaterial;
import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.armor.tokugawa.TokugawaSamuraiArmorItem;
import com.oilfoot.senshi.armor.tokugawa.TokugawaSamuraiArmorMaterial;
import com.oilfoot.senshi.items.katana.KatanaItem;
import com.oilfoot.senshi.items.katana.kazeshiniKatana;
import com.oilfoot.senshi.items.mortalblade.MortalBladeItem;
import com.oilfoot.senshi.items.sword.RottingSwordItem;
import com.oilfoot.senshi.items.throwables.shuriken.EnderShurikenItem;
import com.oilfoot.senshi.items.throwables.shuriken.ShurikenItem;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SenshiItems {

//basicItems
    public static final Item RED_SCALES = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item BLUE_SCALES = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item ENHANCEMENT_DUST = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

//Special Items
    public static final Item SHURIKEN = new ShurikenItem(new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item ENDER_SHURIKEN = new EnderShurikenItem(new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item KUNAI = new ShurikenItem(new Item.Settings().group(ItemGroup.COMBAT));

//BlockItems
    public static final BlockItem CHAINS = new BlockItem(SenshiBlocks.CHAINS, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem KATANABLOCK = new BlockItem(SenshiBlocks.KATANABLOCK, new Item.Settings());
    public static final BlockItem ENHANCEMENT_ORE = new BlockItem(SenshiBlocks.ENHANCEMENT_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem TATAMI = new BlockItem(SenshiBlocks.TATAMI, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem RICE_WALL = new BlockItem(SenshiBlocks.RICE_WALL, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem RICE_DOOR = new BlockItem(SenshiBlocks.RICE_DOOR, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem SAKURA_LOG = new BlockItem(SenshiBlocks.SAKURA_LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SAKURA_LEAVES = new BlockItem(SenshiBlocks.SAKURA_LEAVES, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem SAKURA_SAPLING = new BlockItem(SenshiBlocks.SAKURA_SAPLING, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem SAKURA_PLANKS = new BlockItem(SenshiBlocks.SAKURA_PLANKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem WAXED_SAKURA_PLANKS = new BlockItem(SenshiBlocks.WAXED_SAKURA_PLANKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SAKURA_SLAB = new BlockItem(SenshiBlocks.SAKURA_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem JAPANESE_LANTERN = new BlockItem(SenshiBlocks.JAPANESE_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem TRADITIONAL_LANTERN = new BlockItem(SenshiBlocks.TRADITIONAL_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem GROUND_LANTERN = new BlockItem(SenshiBlocks.GROUND_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem SHRINE = new BlockItem(SenshiBlocks.SHRINE, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem ROCK_PATH = new BlockItem(SenshiBlocks.ROCK_PATH, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MAPPLE_LOG = new BlockItem(SenshiBlocks.MAPPLE_LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem MAPPLE_LEAVES = new BlockItem(SenshiBlocks.MAPPLE_LEAVES, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MAPPLE_SAPLING = new BlockItem(SenshiBlocks.MAPPLE_SAPLING, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem MAPPLE_PLANKS = new BlockItem(SenshiBlocks.MAPPLE_PLANKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

//ToolItems
    public static final ToolItem KATANA = new KatanaItem(KatanaToolMaterial.INSTANCE, 2, -1.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem SAI = new SwordItem(SaiToolMaterial.INSTANCE, -2, -0.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem NAGINATA = new SwordItem(NaginataToolMaterial.INSTANCE, 2, -3.4F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem BO = new SwordItem(BoToolMaterial.INSTANCE, 0, -1.8F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem KAZESHINI = new kazeshiniKatana(kazeshiniToolMaterial.INSTANCE, 0, -1F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item LONG_BOW = new BowItem(new Item.Settings().group(ItemGroup.COMBAT).maxDamage(640));
    public static final ToolItem MORTAL_BLADE = new MortalBladeItem(KatanaToolMaterial.INSTANCE, 2, -1.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem ROTTING_SWORD = new RottingSwordItem(RottingToolMaterial.INSTANCE, 0, -2.3F, new Item.Settings().group(ItemGroup.COMBAT));

//ArmorItems

    //Mapple Armor
    public static final Item MAPPLE_KABUTO = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MAPPLE_DO = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MAPPLE_HAIDATE = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MAPPLE_WARAJI = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    //Takeda Armor
    public static final Item TAKEDA_KABUTO = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TAKEDA_DO = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TAKEDA_HAIDATE = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TAKEDA_WARAJI = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    //Shinobi Armor
    public static final Item SHINOBI_HOOD = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SHINOBI_ROBE = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SHINOBI_HAIDATE = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SHINOBI_SHOES = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    //Tokugawa Armor
    public static final Item TOKUGAWA_KABUTO = new TokugawaSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TOKUGAWA_DO = new TokugawaSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TOKUGAWA_HAIDATE = new TokugawaSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TOKUGAWA_WARAJI = new TokugawaSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    //Fallen Armor
    public static final Item FALLEN_KABUTO = new FallenSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item FALLEN_DO = new FallenSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item FALLEN_HAIDATE = new FallenSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item FALLEN_WARAJI = new FallenSamuraiArmorItem(TokugawaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    //Special Armor
    public static final Item KUMO_NO_ASHI = new knaArmorItem(knaArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item HOOD = new HoodArmorItem(HoodArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));

    //Armor Dyes
    public static final Item DYE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    public static void RegisterItems() {

    //basicItems
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "red_scales"), RED_SCALES);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "blue_scales"), BLUE_SCALES);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "enhancement_dust"), ENHANCEMENT_DUST);

    //specialItems
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shuriken"), SHURIKEN);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "ender_shuriken"), ENDER_SHURIKEN);
        Registry.register(Registry.ITEM,new Identifier(Senshi.MOD_ID, "kunai"), KUNAI);

    //BlockItems
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "chains"), CHAINS);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "katanablock"), KATANABLOCK);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "enhancement_ore"), ENHANCEMENT_ORE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "tatami"), TATAMI);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "rice_wall"), RICE_WALL);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "rice_door"), RICE_DOOR);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "sakura_log"), SAKURA_LOG);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "sakura_leaves"), SAKURA_LEAVES);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "sakura_sapling"), SAKURA_SAPLING);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "sakura_planks"), SAKURA_PLANKS);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "waxed_sakura_planks"), WAXED_SAKURA_PLANKS);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "sakura_slab"), SAKURA_SLAB);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "japanese_lantern"), JAPANESE_LANTERN);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "traditional_lantern"), TRADITIONAL_LANTERN);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "ground_lantern"), GROUND_LANTERN);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shrine"), SHRINE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "rock_path"), ROCK_PATH);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_log"), MAPPLE_LOG);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_leaves"), MAPPLE_LEAVES);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_sapling"), MAPPLE_SAPLING);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_planks"), MAPPLE_PLANKS);

    //ToolItems//
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "katana"), KATANA);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "sai"), SAI);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "naginata"), NAGINATA);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "bo"), BO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "kazeshini"), KAZESHINI);
        ServerTickEvents.END_WORLD_TICK.register((world) -> {
            for (ServerPlayerEntity player : world.getPlayers()){
                if (player.getInventory().getMainHandStack().getItem() instanceof kazeshiniKatana) {
                    player.addStatusEffect(((new StatusEffectInstance(StatusEffects.SPEED, 20 * 3, 1))));
                }
            }
        });
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "long_bow"), LONG_BOW);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mortal_blade"), MORTAL_BLADE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "rotting_sword"), ROTTING_SWORD);

    //ArmorItems//

        //Mapple Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_kabuto"), MAPPLE_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_do"), MAPPLE_DO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_haidate"), MAPPLE_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_waraji"), MAPPLE_WARAJI);

        //Tadeka Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_kabuto"), TAKEDA_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_do"), TAKEDA_DO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_haidate"), TAKEDA_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_waraji"), TAKEDA_WARAJI);

        //Shinobi Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_hood"), SHINOBI_HOOD);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_robe"), SHINOBI_ROBE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_haidate"), SHINOBI_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_shoes"), SHINOBI_SHOES);

        //Tokugawa Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "tokugawa_kabuto"), TOKUGAWA_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "tokugawa_do"), TOKUGAWA_DO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "tokugawa_haidate"), TOKUGAWA_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "tokugawa_waraji"), TOKUGAWA_WARAJI);

        //Fallen Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "fallen_kabuto"), FALLEN_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "fallen_do"), FALLEN_DO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "fallen_haidate"), FALLEN_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "fallen_waraji"), FALLEN_WARAJI);

        //Special Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "kumo_no_ashi"), KUMO_NO_ASHI);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "hood"), HOOD);

        //Armor Dyes
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "dye"), DYE);

    }
}
