package dev.crmodders.flux.api.block;

import dev.crmodders.flux.api.generators.BlockEventGenerator;
import dev.crmodders.flux.api.generators.BlockGenerator;
import dev.crmodders.flux.api.generators.BlockModelGenerator;
import dev.crmodders.flux.tags.Identifier;
import finalforeach.cosmicreach.blocks.BlockPosition;
import finalforeach.cosmicreach.blocks.BlockState;
import finalforeach.cosmicreach.entities.Player;
import finalforeach.cosmicreach.world.Zone;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Adds an Interactive block to Cosmic Reach
 */
public interface IModBlock {

    /**
     * Triggered when a Player Interacts with a block
     * @param zone The Zone that this block is in
     * @param player The Player that interacted with this block
     * @param blockState The Blocks State
     * @param position The Blocks Position
     */
    default void onInteract(Zone zone, Player player, BlockState blockState, BlockPosition position) {}

    /**
     * Triggered when a Player Places this block
     * @param zone The Zone that this block is in
     * @param player The Player that interacted with this block
     * @param blockState The Blocks State
     * @param position The Blocks Position
     */
    default void onPlace(Zone zone, Player player, BlockState blockState, BlockPosition position) {}

    /**
     * Triggered when a Player Breaks this block
     * @param zone The Zone that this block is in
     * @param player The Player that interacted with this block
     * @param blockState The Blocks State
     * @param position The Blocks Position
     */
    default void onBreak(Zone zone, Player player, BlockState blockState, BlockPosition position) {}

    /**
     * Used by FluxAPI for generating this block and registering it with Cosmic Reach
     * @return The {@link BlockGenerator} that is used for generating this Block
     */
    BlockGenerator getBlockGenerator();

    default List<BlockModelGenerator> getBlockModelGenerators(Identifier blockId) { return Collections.emptyList(); }

    default BlockEventGenerator getBlockEventGenerator(Identifier blockId) { return null; }

}
