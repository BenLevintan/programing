#utlis

import pygame
from os import listdir
from os.path import isfile, join

def init():
    pygame.init()

def get_background(window, name):
    image_path = "assets/Background/" + name
    
    # Load the image
    background_image = pygame.image.load(image_path)
    
    # Get the original dimensions of the image
    original_width, original_height = background_image.get_size()

    # Calculate the scaling factor to fill the vertical space of the window
    scale_factor = window.get_height() / original_height

    # Scale the image while maintaining proportions
    scaled_width = int(original_width * scale_factor)
    scaled_height = int(original_height * scale_factor)
    scaled_background = pygame.transform.scale(background_image, (scaled_width, scaled_height))

    # Get the rect object for the scaled image
    background_rect = scaled_background.get_rect()

    # Return the rect object in case it's needed later
    return scaled_background

def draw(window, background, player):
    window.blit(background, (0, 0))
    player.draw(window)

def flip(sprites):
    return [pygame.transform.flip(sprite, True, False) for sprite in sprites]

def load_sprite_sheets(dir1, dir2, width, height, direction=False):
    init()  # Initialize Pygame

    path = join("assets", dir1, dir2)
    images = [f for f in listdir(path) if isfile(join(path, f))]

    all_sprites = {}

    for image in images:
        sprite_sheet = pygame.image.load(join(path, image)).convert_alpha()

        sprites = []
        for i in range(sprite_sheet.get_width() // width):
            surface = pygame.Surface((width, height), pygame.SRCALPHA, 32)
            rect = pygame.Rect(i * width, 0, width, height)
            surface.blit(sprite_sheet, (0, 0), rect)
            sprites.append(pygame.transform.scale2x(surface))

        if direction:
            all_sprites[image.replace(".png", "") + "_right"] = sprites
            all_sprites[image.replace(".png", "") + "_left"] = flip(sprites)
        else:
            all_sprites[image.replace(".png", "")] = sprites

    return all_sprites

   