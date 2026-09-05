package com.r8xyj74j64.obsidianequipment.item;

import com.r8xyj74j64.obsidianequipment.ObsidianEquipmentMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.HoeItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ObsidianEquipmentMod.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, ObsidianEquipmentMod.MOD_ID);

    // ===== 中間素材 =====
    // 黒曜石の粉(かまど/溶鉱炉で黒曜石を精錬して入手)
    public static final DeferredItem<Item> OBSIDIAN_DUST =
            ITEMS.registerSimpleItem("obsidian_dust", new Item.Properties());

    // 精製黒曜石インゴット(黒曜石の粉4つを作業台で固める → 鉄塊的な位置付け)
    public static final DeferredItem<Item> REFINED_OBSIDIAN_INGOT =
            ITEMS.registerSimpleItem("refined_obsidian_ingot", new Item.Properties());

    // ===== 道具 =====
    public static final DeferredItem<SwordItem> REFINED_OBSIDIAN_SWORD =
            ITEMS.registerItem("refined_obsidian_sword",
                    props -> new SwordItem(ModToolTiers.REFINED_OBSIDIAN, props),
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(ModToolTiers.REFINED_OBSIDIAN, 3, -2.4f)));

    public static final DeferredItem<PickaxeItem> REFINED_OBSIDIAN_PICKAXE =
            ITEMS.registerItem("refined_obsidian_pickaxe",
                    props -> new PickaxeItem(ModToolTiers.REFINED_OBSIDIAN, props),
                    new Item.Properties().attributes(
                            PickaxeItem.createAttributes(ModToolTiers.REFINED_OBSIDIAN, 1, -2.8f)));

    public static final DeferredItem<AxeItem> REFINED_OBSIDIAN_AXE =
            ITEMS.registerItem("refined_obsidian_axe",
                    props -> new AxeItem(ModToolTiers.REFINED_OBSIDIAN, props),
                    new Item.Properties().attributes(
                            AxeItem.createAttributes(ModToolTiers.REFINED_OBSIDIAN, 6, -3.1f)));

    public static final DeferredItem<ShovelItem> REFINED_OBSIDIAN_SHOVEL =
            ITEMS.registerItem("refined_obsidian_shovel",
                    props -> new ShovelItem(ModToolTiers.REFINED_OBSIDIAN, props),
                    new Item.Properties().attributes(
                            ShovelItem.createAttributes(ModToolTiers.REFINED_OBSIDIAN, 1.5f, -3.0f)));

    public static final DeferredItem<HoeItem> REFINED_OBSIDIAN_HOE =
            ITEMS.registerItem("refined_obsidian_hoe",
                    props -> new HoeItem(ModToolTiers.REFINED_OBSIDIAN, props),
                    new Item.Properties().attributes(
                            HoeItem.createAttributes(ModToolTiers.REFINED_OBSIDIAN, 0, -3.0f)));

    // ===== クリエイティブタブ =====
    public static final net.neoforged.neoforge.registries.DeferredHolder<CreativeModeTab, CreativeModeTab> OBSIDIAN_TAB =
            CREATIVE_TABS.register("obsidian_equipment_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.obsidianequipment.main"))
                    .icon(() -> REFINED_OBSIDIAN_SWORD.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        output.accept(OBSIDIAN_DUST.get());
                        output.accept(REFINED_OBSIDIAN_INGOT.get());
                        output.accept(REFINED_OBSIDIAN_SWORD.get());
                        output.accept(REFINED_OBSIDIAN_PICKAXE.get());
                        output.accept(REFINED_OBSIDIAN_AXE.get());
                        output.accept(REFINED_OBSIDIAN_SHOVEL.get());
                        output.accept(REFINED_OBSIDIAN_HOE.get());
                    })
                    .build());
}
