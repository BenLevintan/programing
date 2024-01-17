#utlis
import os
import pygame
from os import listdir
from os.path import isfile, join


def get_background(window, name):
    image_path = "assets/Background/" + name
    background_image = pygame.image.load(image_path)
    original_width, original_height = background_image.get_size()
    scale_factor = window.get_height() / original_height

    scaled_width = int(original_width * scale_factor)
    scaled_height = int(original_height * scale_factor)
    scaled_background = pygame.transform.scale(background_image, (scaled_width, scaled_height))

    background_rect = scaled_background.get_rect()

    return scaled_background

def draw(window, background, player, level_objects, offset_x):
    window.blit(background, (-100 - offset_x // 10 , 0))
    player.draw(window, offset_x)
    for obj in level_objects:
        obj.draw(window, offset_x) 

def flip(sprites):
    return [pygame.transform.flip(sprite, True, False) for sprite in sprites]


def load_sprite_sheets(dir1, dir2, width, height, direction=False):
    pygame.display.set_mode((1280, 720))
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

def get_block(size):
    path = join("assets", "Terrain", "Terrain.png")
    image = pygame.image.load(path).convert_alpha()
    surface = pygame.Surface((size, size), pygame.SRCALPHA, 32)
    rect = pygame.Rect(96, 0, size, size)
    surface.blit(image, (0, 0), rect)
    return pygame.transform.scale2x(surface)
   