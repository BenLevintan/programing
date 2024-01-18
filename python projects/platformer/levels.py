# classes in this file should contain all the functions
# that should be activated in order to load a level
# * use a decorator to load/destroy all elements of a level
# levels should be stored as data (array for the floor, Block type for blocks, etc..)

import pygame
from utils import load_sprite_sheets, get_block, get_background
from objects import Block, Object, Fire, Spikes

FLOOR_Y = 608
BLOCK_SIZE = 96
SMALL_BLOCK_SIZE = 32

def create_level(window):
    level_objects = []

    # Define the position and size of the blocks in the level
    big_block_positions = [
        (5, 5),
        (5, 6),
        (6, 5),
        (8, 4),
        (9, 4),
        (12, 6),
        (12, 3),
        (13, 3),
        (14, 3),
        (16, 6),
        (16, 5),
        (17, 6),
        (20, 4),
        (21, 4),
        (22, 4),
        (23, 4),
        (25, 6),
        (25, 5),
        (26, 6),
        (28, 4),
        (29, 4),
        (32, 6),
        (32, 3),
        (33, 3),
        (34, 3),
        (32, 2),
        (33, 2),
        (34, 2),
        (32, 1),
        (33, 1),
        (34, 1),
        (36, 6),
        (36, 5),
        (37, 6),
        (40, 4),
        (41, 4),
        (42, 4),
        (43, 4),
        (45, 6),
        (45, 5),
        (46, 6),
        (48, 4),
        (49, 4),
        (52, 6),
        (52, 3),
        (53, 3),
        (54, 3),
        (56, 6),
        (56, 5),
        (57, 6),
        (60, 4),
        (61, 4),
        (62, 4),
        (63, 4),
        (68, 4),
        (69, 4),

        # Add more block positions as needed
    ]

    small_block_positions = [
        (0, 0),(-1, 1),(1, 1)
    ]

    for pos_x, pos_y in big_block_positions:
        block = Block(pos_x * BLOCK_SIZE, pos_y * BLOCK_SIZE, 0, 0, BLOCK_SIZE)
        level_objects.append(block)

    for pos_x, pos_y in small_block_positions:
        block = Block(pos_x * SMALL_BLOCK_SIZE, pos_y * SMALL_BLOCK_SIZE, 56, 8, SMALL_BLOCK_SIZE)
        level_objects.append(block)

    for i in range(5):
        block = Block(i * BLOCK_SIZE, window.get_height() - 0.5 * BLOCK_SIZE, 96, 0, BLOCK_SIZE)
        level_objects.append(block)

    fire_positions = [
        (200, FLOOR_Y), (400 + 2 * BLOCK_SIZE, FLOOR_Y - 2 * BLOCK_SIZE)
        # Add more fire positions as needed
    ]

    spikes_position = [
        (300, FLOOR_Y + 32),(332, FLOOR_Y + 32)
    ]

    for pos_x, pos_y in fire_positions:
        fire = Fire(pos_x, pos_y, 16, 32)
        fire.on()
        level_objects.append(fire)

    for pos_x, pos_y in spikes_position:
        spikes = Spikes(pos_x, pos_y, 16, 16)
        level_objects.append(spikes)
    
    
    return level_objects


def destroy_level(level_objects):
    # Implement any cleanup or destruction logic here
    pass
