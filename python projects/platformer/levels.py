# classes in this file should contain all the functions
# that should be activated in order to load a level
# * use a decorator to load/destroy all elements of a level

import pygame
from utils import load_sprite_sheets, get_block
from objects import Block

def create_level(window):
    level_objects = []

    # Define the position and size of the blocks in the level
    block_positions = [
        (0, 0),
        (2, 0),
        (4, 0),
        # Add more block positions as needed
    ]

    block_size = 32  # Adjust the size of the blocks

    for pos_x, pos_y in block_positions:
        block = Block(pos_x * block_size, pos_y * block_size, 96, 0, block_size)
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