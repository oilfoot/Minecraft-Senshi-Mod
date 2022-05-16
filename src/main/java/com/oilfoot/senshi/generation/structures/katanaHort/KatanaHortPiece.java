package com.oilfoot.senshi.generation.structures.katanaHort;

import net.minecraft.structure.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.Random;

    public class KatanaHortPiece extends SimpleStructurePiece {
        public KatanaHortPiece(StructurePieceType type, int length, StructureManager structureManager, Identifier id, String template, StructurePlacementData placementData, BlockPos pos) {
            super(type, length, structureManager, id, template, placementData, pos);
        }

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {

        }
        /*
    private final BlockRotation rotation;
    private final Identifier template;

    public KatanaHortPiece(StructureManager structureManager, NbtCompound compoundTag) {
        super(ModStructures.KATANAHORT_PIECE, compoundTag);
        this.template = new Identifier(compoundTag.getString("Template"));
        this.rotation = BlockRotation.valueOf(compoundTag.getString("Rot"));
        this.initializeStructureData(structureManager);
    }

    public KatanaHortPiece(StructureManager structureManager, BlockPos pos, Identifier template, BlockRotation rotation) {
        super(ModStructures.KATANAHORT_PIECE, 0);
        this.pos = pos;
        this.rotation = rotation;
        this.template = template;

        this.initializeStructureData(structureManager);
    }

    private void initializeStructureData(StructureManager structureManager) {
        Structure structure = structureManager.getStructureOrBlank(this.template);
        StructurePlacementData placementData = (new StructurePlacementData())
                .setRotation(this.rotation)
                .setMirror(BlockMirror.NONE)
                .addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
        this.setStructureData(structure, this.pos, placementData);
    }

    protected void toNbt(NbtCompound tag) {
        super.toNbt(tag);
        tag.putString("Template", this.template.toString());
        tag.putString("Rot", this.rotation.name());
    }

    @Override
    protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess serverWorldAccess, Random random,
                                  BlockBox boundingBox) {
    }

 */
}
