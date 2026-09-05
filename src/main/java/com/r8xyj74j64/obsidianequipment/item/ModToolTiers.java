package com.r8xyj74j64.obsidianequipment.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * 精製黒曜石ツールのTier定義。
 * 参照: https://docs.neoforged.net/docs/items/tools (SimpleTierは
 * net.neoforged.neoforge.common パッケージに属する)
 *
 * NeoForge 1.21.1のSimpleTierコンストラクタは以下の6引数:
 * (TagKey<Block>, int durability, float speed, float attackDamageBonus,
 *  int enchantmentValue, Supplier<Ingredient> repairIngredient)
 * ※ 1.20.x系にあった level 引数は1.21.1では存在しません。
 *
 * ネザライトより硬く重いイメージ:
 * - 耐久値は非常に高い
 * - 採掘速度はネザライトよりやや遅い(重量感の表現)
 * - 攻撃力ボーナスはネザライト同等〜やや上
 * - エンチャント適性はネザライトと同じ15
 */
public class ModToolTiers {

    public static final int DURABILITY = 3200;       // ネザライトは2031
    public static final float MINING_SPEED = 8.5f;   // ネザライトは9.0f
    public static final float ATTACK_DAMAGE_BONUS = 4.5f; // ネザライトは4.0f
    public static final int ENCHANTMENT_VALUE = 15;  // ネザライトと同じ

    public static final Tier REFINED_OBSIDIAN = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            DURABILITY,
            MINING_SPEED,
            ATTACK_DAMAGE_BONUS,
            ENCHANTMENT_VALUE,
            () -> Ingredient.of(ModItems.REFINED_OBSIDIAN_INGOT.get())
    );
}
