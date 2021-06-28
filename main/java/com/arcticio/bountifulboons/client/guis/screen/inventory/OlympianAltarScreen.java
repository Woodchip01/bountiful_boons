package com.arcticio.bountifulboons.client.guis.screen.inventory;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.gods.Boon;
import com.arcticio.bountifulboons.common.tiles.OlympianAltarTileEntity;
import com.arcticio.bountifulboons.core.init.ItemInit;
import com.arcticio.bountifulboons.common.containers.OlympianAltarContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.play.client.CCloseWindowPacket;
import net.minecraft.network.play.client.CUpdateBeaconPacket;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OlympianAltarScreen extends ContainerScreen<OlympianAltarContainer> {
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(BountifulBoons.MOD_ID, "textures/guis" +
            "/olympian_altar");
    private static final ITextComponent ACTIVE_GOD_LABEL = new TranslationTextComponent("block.bountifulboons" +
            ".olympianaltar" + // Not sure what this path should be
            ".selectedBoon");
    private static final ITextComponent GOD_PATH_LABEL = new TranslationTextComponent("block.minecraft.beacon" +
            ".secondary");
    private OlympianAltarScreen.ConfirmButton confirmButton;
    private boolean initButtons;
    private boolean active;
    private Boon selectedBoon;
    // TODO: CREATE God CLASS AND IMPLEMENT, create Boon class
    // private God activeGod
    // private GodPath godPath (?)


    public OlympianAltarScreen(OlympianAltarContainer container, PlayerInventory playerInv, ITextComponent name) {
        super(container, playerInv, name);
        this.height = 230;
        this.width = 219;
        container.addSlotListener(new IContainerListener() {
            @Override
            public void refreshContainer(Container container1, NonNullList<ItemStack> stacks) {

            }

            @Override
            public void slotChanged(Container container1, int p_71111_2_, ItemStack stack) {
            }

            @Override
            public void setContainerData(Container container1, int p_71112_2_, int p_71112_3_) {
                // TODO call activator for player skills in a manager which activates specific god class, tree number
                //  and skill numbers,,, create getGod() and getPath()
                // OlympianAltarScreen.this.activeGod = container1.getGod()
                // OlympianAltarScreen.this.godPath = container1.getPath()
                OlympianAltarScreen.this.initButtons = true;

            }
        });
    }


    protected void init() {
        super.init();
        this.confirmButton = this.addButton(new OlympianAltarScreen.ConfirmButton(this.leftPos + 164,
                this.topPos + 107));
        this.addButton(new OlympianAltarScreen.CancelButton(this.leftPos + 190, this.topPos + 107));
        this.initButtons = true;
        this.confirmButton.active = false;
    }

    public void tick() {
        super.tick();

        //int favor =
        if (this.initButtons) {
            this.initButtons = false;

            //for
        }

        // TODO replace getLevels with a check on player Capability for bonding with specific god
        /*int i = this.menu.getLevels();
        if (this.initButtons && i >= 0) {
            this.initButtons = false;

            for(int j = 0; j <= 2; ++j) {
                int k = OlympianAltarTileEntity.GOD_BOONS[j].length; //?
                int l = k * 22 + (k - 1) * 2;

                for(int i1 = 0; i1 < k; ++i1) {
                    Boon boon = OlympianAltarTileEntity.GOD_BOONS[j][i1];
                    OlympianAltarScreen.PowerButton olympianaltarscreen$powerbutton =
                            new OlympianAltarScreen.PowerButton(this.leftPos + 76 + i1 * 24 - l / 2,
                                    this.topPos + 22 + j * 25, boon, true);
                    this.addButton(olympianaltarscreen$powerbutton);
                    if (j >= i) {
                        olympianaltarscreen$powerbutton.active = false;
                    } else if (boon == this.selectedBoon) {
                        olympianaltarscreen$powerbutton.setSelected(true);
                    }
                }
            }

            int j1 = 3;
            int k1 = OlympianAltarTileEntity.GOD_BOONS[3].length + 1;
            int l1 = k1 * 22 + (k1 - 1) * 2;

            for(int i2 = 0; i2 < k1 - 1; ++i2) {
                Boon boon1 = OlympianAltarTileEntity.GOD_BOONS[3][i2];
                OlympianAltarScreen.PowerButton olympianaltarscreen$powerbutton2 =
                        new OlympianAltarScreen.PowerButton(this.leftPos + 167 + i2 * 24 - l1 / 2,
                                this.topPos + 47, boon1, false);
                this.addButton(olympianaltarscreen$powerbutton2);
                if (3 >= i) {
                    olympianaltarscreen$powerbutton2.active = false;
                } else if (boon1 == this.secondary) {
                    olympianaltarscreen$powerbutton2.setSelected(true);
                }
            }

            if (this.selectedBoon != null) {
                OlympianAltarScreen.PowerButton olympianaltarscreen$powerbutton1 =
                        new OlympianAltarScreen.PowerButton(this.leftPos + 167 + (k1 - 1) * 24 - l1 / 2,
                                this.topPos + 47, this.selectedBoon, false);
                this.addButton(olympianaltarscreen$powerbutton1);
                if (3 >= i) {
                    olympianaltarscreen$powerbutton1.active = false;
                } else if (this.selectedBoon == this.secondary) {
                    olympianaltarscreen$powerbutton1.setSelected(true);
                }
            }
        }*/

        this.confirmButton.active = /*this.menu.hasPayment() &&*/ this.selectedBoon != null;
    }

    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) { // ah may not be renderLabels...
        drawCenteredString(matrixStack, this.font, ACTIVE_GOD_LABEL, 62, 10, 14737632);
        drawCenteredString(matrixStack, this.font, GOD_PATH_LABEL, 169, 10, 14737632);

        for(Widget widget : this.buttons) {
            if (widget.isHovered()) {
                widget.renderToolTip(matrixStack, mouseX - this.leftPos,
                        mouseY - this.topPos);
                break;
            }
        }

    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(BG_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        this.itemRenderer.blitOffset = 100.0F;
        this.itemRenderer.renderAndDecorateFakeItem(new ItemStack(ItemInit.TOKEN_OF_APHRODITE.get()), i + 20, j + 109);
        this.itemRenderer.renderAndDecorateFakeItem(new ItemStack(ItemInit.TOKEN_OF_ARES.get()), i + 41, j + 109);
        this.itemRenderer.renderAndDecorateFakeItem(new ItemStack(ItemInit.TOKEN_OF_ARTEMIS.get()), i + 41 + 22, j + 109);
        this.itemRenderer.renderAndDecorateFakeItem(new ItemStack(ItemInit.TOKEN_OF_ATHENA.get()), i + 42 + 44, j + 109);
        this.itemRenderer.renderAndDecorateFakeItem(new ItemStack(ItemInit.TOKEN_OF_DEMETER.get()), i + 42 + 66, j + 109);
        this.itemRenderer.blitOffset = 0.0F;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
        //this.renderComponentHoverEffect(matrixStack, Style.EMPTY ,mouseX, mouseY);
    }

    @OnlyIn(Dist.CLIENT)
    abstract static class Button extends AbstractButton {
        private boolean selected;

        protected Button(int p_i50826_1_, int p_i50826_2_) {
            super(p_i50826_1_, p_i50826_2_, 22, 22, StringTextComponent.EMPTY);
        }

        public void renderButton(MatrixStack p_230431_1_, int p_230431_2_, int p_230431_3_, float p_230431_4_) {
            Minecraft.getInstance().getTextureManager().bind(OlympianAltarScreen.BG_TEXTURE);
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            int i = 219;
            int j = 0;
            if (!this.active) {
                j += this.width * 2;
            } else if (this.selected) {
                j += this.width * 1;
            } else if (this.isHovered()) {
                j += this.width * 3;
            }

            this.blit(p_230431_1_, this.x, this.y, j, 219, this.width, this.height);
            this.renderIcon(p_230431_1_);
        }

        protected abstract void renderIcon(MatrixStack p_230454_1_);

        public boolean isSelected() {
            return this.selected;
        }

        public void setSelected(boolean p_146140_1_) {
            this.selected = p_146140_1_;
        }
    }

    @OnlyIn(Dist.CLIENT)
    class CancelButton extends OlympianAltarScreen.SpriteButton {
        public CancelButton(int p_i50829_2_, int p_i50829_3_) {
            super(p_i50829_2_, p_i50829_3_, 112, 220);
        }

        public void onPress() {
            OlympianAltarScreen.this.minecraft.player.connection.send(new CCloseWindowPacket(OlympianAltarScreen.this.minecraft.player.containerMenu.containerId));
            OlympianAltarScreen.this.minecraft.setScreen((Screen)null);
        }

        public void renderToolTip(MatrixStack p_230443_1_, int p_230443_2_, int p_230443_3_) {
            OlympianAltarScreen.this.renderTooltip(p_230443_1_, DialogTexts.GUI_CANCEL, p_230443_2_, p_230443_3_);
        }
    }

    @OnlyIn(Dist.CLIENT)
    class ConfirmButton extends OlympianAltarScreen.SpriteButton {
        public ConfirmButton(int p_i50828_2_, int p_i50828_3_) {
            super(p_i50828_2_, p_i50828_3_, 90, 220);
        }

        public void onPress() { // TODO oh god this first line what how
            //OlympianAltarScreen.this.minecraft.getConnection().send(new CUpdateBeaconPacket(Boon.getId
            // (OlympianAltarScreen.this.selectedBoon), Boon.getId(OlympianAltarScreen.this.secondary)));
            OlympianAltarScreen.this.minecraft.player.connection.send(new CCloseWindowPacket(OlympianAltarScreen.this.minecraft.player.containerMenu.containerId));
            OlympianAltarScreen.this.minecraft.setScreen((Screen)null);
        }

        public void renderToolTip(MatrixStack p_230443_1_, int p_230443_2_, int p_230443_3_) {
            OlympianAltarScreen.this.renderTooltip(p_230443_1_, DialogTexts.GUI_DONE, p_230443_2_, p_230443_3_);
        }
    }

    @OnlyIn(Dist.CLIENT)
    class PowerButton extends OlympianAltarScreen.Button {
        private final Boon boon;
        private final TextureAtlasSprite sprite;
        private final boolean isPrimary;
        private final ITextComponent tooltip;

        public PowerButton(int p_i50827_2_, int p_i50827_3_, Boon boon, boolean p_i50827_5_) {
            super(p_i50827_2_, p_i50827_3_);
            this.boon = boon;
            this.sprite = Minecraft.getInstance().getMobEffectTextures().get(Effects.ABSORPTION);
            this.isPrimary = p_i50827_5_;
            this.tooltip = this.createTooltip(boon/*, p_i50827_5_*/);
        }

        private ITextComponent createTooltip(Boon boon/*, boolean p_243337_2_*/) {
            IFormattableTextComponent iformattabletextcomponent = new TranslationTextComponent(boon.getDescriptionId());
            /*if (!p_243337_2_ && boon != Effects.REGENERATION) {
                iformattabletextcomponent.append(" II");
            }*/

            return iformattabletextcomponent;
        }

        public void onPress() {
            if (!this.isSelected()) {

                OlympianAltarScreen.this.selectedBoon = this.boon;


                OlympianAltarScreen.this.buttons.clear();
                OlympianAltarScreen.this.children.clear();
                OlympianAltarScreen.this.init();
                OlympianAltarScreen.this.tick();
            }
        }

        public void renderToolTip(MatrixStack p_230443_1_, int p_230443_2_, int p_230443_3_) {
            OlympianAltarScreen.this.renderTooltip(p_230443_1_, this.tooltip, p_230443_2_, p_230443_3_);
        }

        protected void renderIcon(MatrixStack p_230454_1_) {
            Minecraft.getInstance().getTextureManager().bind(this.sprite.atlas().location());
            blit(p_230454_1_, this.x + 2, this.y + 2, this.getBlitOffset(), 18, 18, this.sprite);
        }
    }

    @OnlyIn(Dist.CLIENT)
    abstract static class SpriteButton extends OlympianAltarScreen.Button {
        private final int iconX;
        private final int iconY;

        protected SpriteButton(int p_i50825_1_, int p_i50825_2_, int p_i50825_3_, int p_i50825_4_) {
            super(p_i50825_1_, p_i50825_2_);
            this.iconX = p_i50825_3_;
            this.iconY = p_i50825_4_;
        }

        protected void renderIcon(MatrixStack p_230454_1_) {
            this.blit(p_230454_1_, this.x + 2, this.y + 2, this.iconX, this.iconY, 18, 18);
        }
    }
}
