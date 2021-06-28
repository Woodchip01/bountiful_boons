package com.arcticio.bountifulboons.common.gods;

import com.arcticio.bountifulboons.BountifulBoons;
import com.google.common.collect.Maps;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nullable;
import java.util.Map;

public class Boon extends net.minecraftforge.registries.ForgeRegistryEntry<Boon> /*implements net.minecraftforge
.common.extensions.IForgeEffect*/{
    private final Map<Attribute, AttributeModifier> attributeModifiers = Maps.newHashMap();
    private final String name;
    private final int color;
    @Nullable
    private String descriptionId;

    /*@Nullable
    public static Effect byId(int p_188412_0_) {
        return Registry.MOB_EFFECT.byId(p_188412_0_);
    }

    public static int getId(Effect p_188409_0_) {
        return Registry.MOB_EFFECT.getId(p_188409_0_);
    }*/

    public Boon(String name, int color) {
        this.name = "boon."+ name;
        this.color = color;
        setRegistryName(new ResourceLocation(BountifulBoons.MOD_ID + ":" + name));
    }

    public void applyEffectTick(LivingEntity ent, int p_76394_2_) {
        if (this == Boons.FORTITUDE) {
            ent.setAbsorptionAmount(2);
        }
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(this.getDescriptionId());
    }

    protected String getOrCreateDescriptionId() {
        if (this.descriptionId == null) {
            // TODO THIS description stuff
            //this.descriptionId = Util.makeDescriptionId("boon", );
            return "Null Description";
        }
        return this.descriptionId;
    }
}
