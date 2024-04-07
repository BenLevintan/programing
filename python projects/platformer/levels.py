# classes in this file should contain all the functions
# that should be activated in order to load a level
# * use a decorator to load/destroy all elements of a level
# levels should be stored as data (array for the floor, Block type for blocks, etc..)

import pygame
from utils import load_sprite_sheets, get_block, get_background
from objects import Block, Object, Fire, Spikes

FLOOR_Y = 608
BLOCK_SIZE = 96
SMALL_BLOCK_SIZE = 34

BIG_GRASS_BLOCK_POS = 96, 0

def create_level(window):
    RESPAWN_POINTS = 50, 1150, 2970
    
    level_objects = []

    # Define the position and size of the blocks in the level
    big_block_positions = [
        *generate_horizontal_platfrom(8, 3, 1),
        *generate_horizontal_platfrom(7, 4, 2),
        *generate_horizontal_platfrom(6, 5, 3),
        *generate_horizontal_platfrom(5, 6, 8),
        *generate_horizontal_platfrom(15, 6, 2),
        *generate_horizontal_platfrom(19, 6, 3),
        *generate_horizontal_platfrom(21, 5, 1),
        *generate_wall(21, 4, 1),(32,5),(32,3),
        *generate_horizontal_platfrom(32, 1, 3),
        *generate_wall(35, 6, 5),
        *generate_wall(36, 6, 4),
        *generate_wall(37, 6, 3),
        *generate_wall(38, 6, 2),
        *generate_horizontal_platfrom(42, 6, 7),
        (43, 5),(45, 5),(47, 5),

    ]


    small_block_positions = [

        *generate_horizontal_platfrom(46, 8, 6),
        *generate_horizontal_platfrom(58, 4, 6),
        *generate_horizontal_platfrom(64, 5, 2),
        *generate_horizontal_platfrom(66, 6, 2),
        *generate_horizontal_platfrom(68, 7, 2),
        *generate_horizontal_platfrom(72, 7, 2),
        *generate_horizontal_platfrom(74, 7, 2),
        *generate_horizontal_platfrom(78, 18, 12),
        *generate_horizontal_platfrom(78, 18, 12),
        *generate_horizontal_platfrom(146, 20, 6),
        *generate_horizontal_platfrom(152, 19, 6),
        *generate_horizontal_platfrom(158, 18, 6),
        *generate_horizontal_platfrom(164, 13, 2),
        *generate_horizontal_platfrom(162, 10, 2),
        *generate_horizontal_platfrom(154, 6, 6),
        *generate_horizontal_platfrom(148, 4, 6),
        *generate_horizontal_platfrom(152, 1, 10),
        *generate_horizontal_platfrom(173, 3, 8),
        *generate_wall(180, 12, 10),
        *generate_wall(183, 9, 16),
        *generate_horizontal_platfrom(180, 13, 20),

    ]


    for pos_x, pos_y in big_block_positions:
        block = Block(pos_x * BLOCK_SIZE, pos_y * BLOCK_SIZE, 0, 0, BLOCK_SIZE)
        level_objects.append(block)

    for pos_x, pos_y in small_block_positions:
        block = Block(pos_x * SMALL_BLOCK_SIZE, pos_y * SMALL_BLOCK_SIZE, 48, 31, SMALL_BLOCK_SIZE)
        level_objects.append(block)

    for i in range(5):
        block = Block(i * BLOCK_SIZE, window.get_height() - 0.5 * BLOCK_SIZE, 96, 0, BLOCK_SIZE)
        level_objects.append(block)

    fire_positions = [
        (200, FLOOR_Y), (400 + 2 * BLOCK_SIZE, FLOOR_Y - 2 * BLOCK_SIZE),
         *spike_floor(864,516,6),
         *spike_floor(3456 - 96,224 - 96,3),
         *spike_floor(3456,224,3),
         *spike_floor(3456 + 2 * 96,224 + 2 * 96,3),
         *spike_floor(5070,616,3),
         *spike_floor(5070 + 34 * 6 ,616 - 34,3),
         *spike_floor(5070 + 34 * 12 ,616 - 2 * 34,3),
        # Add more fire positions as needed
    ]

    spikes_position = [
        #(864, 544), (896, 544), (928, 544), (960, 544), (992, 544),
        *spike_floor(864,544,6),
        *spike_floor(2452,206,4),
        *spike_floor(2741,580,6),
        *spike_floor(3180,64,2),
        *spike_floor(4129,448,3),
        *spike_floor(4129 + 2 * 96,448,3),
        *spike_floor(4129+ 4 * 96,448,3),
        *spike_floor(5236,172,3),
        *spike_floor(6495, 412,3),
    ]

    for pos_x, pos_y in fire_positions:
        fire = Fire(pos_x, pos_y, 16, 32)
        fire.on()
        level_objects.append(fire)

    for pos_x, pos_y in spikes_position:
        spikes = Spikes(pos_x, pos_y, 16, 16)
        level_objects.append(spikes)
    
    
    return level_objects

def generate_horizontal_platfrom(x, y, length):
    positions = [(x + i, y) for i in range(length)]
    return positions

def generate_wall(x, y, height):
    positions = [(x, y - i) for i in range(height)]
    return positions

def spike_floor(x, y, length):
    positions = [(x + i * 32 , y) for i in range(length)]
    return positions

def destroy_level(level_objects):
    # Implement any cleanup or destruction logic here
    pass

