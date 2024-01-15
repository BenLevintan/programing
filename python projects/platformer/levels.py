# classes in this file should contain all the functions
# that should be activated in order to load a level
# * use a decorator to load/destroy all elements of a level
# levels should be stored as data (array for the floor, Block type for blocks, etc..)

import pygame
from utils import load_sprite_sheets, get_block, get_background
from objects import Block, Object

def create_level(window, block_size):
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



    ]

    for pos_x, pos_y in big_block_positions:
        block = Block(pos_x * block_size, pos_y * block_size , 0, 0, block_size)
        level_objects.append(block)

    for pos_x, pos_y in small_block_positions:
        block = Block(pos_x * block_size, pos_y * block_size , 0, 0, block_size)
        level_objects.append(block)



    for i in range(5):
        block = Block(i * block_size , window.get_height() - 0.5 * block_size, 96, 0, block_size)
        level_objects.append(block)

   

    return level_objects


def floor(window, block_size):
    level_objects = []

    # Calculate the number of blocks needed to fill the width of the window
    num_blocks = window.get_width() // block_size

    # Create a row of blocks for the floor
    for i in range(num_blocks):
        block = Block(i * block_size, window.get_height() - block_size, 96, 0, block_size)
        level_objects.append(block)

    return level_objects

def destroy_level(level_objects):
    # Implement any cleanup or destruction logic here
    pass