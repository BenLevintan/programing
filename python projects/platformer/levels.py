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
    block_positions = [
        (5, 5),
        (5, 6),
        (6, 5),
        (8, 4),
        (9, 4),
        (12, 6)
        # Add more block positions as needed
    ]

    for pos_x, pos_y in block_positions:
        block = Block(pos_x * block_size, pos_y * block_size , 0, 0, block_size)
        level_objects.append(block)


#creating the floor
    num_blocks = 5 * window.get_width() // block_size

    for i in range(num_blocks):
        if i % 5 != 0 :
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