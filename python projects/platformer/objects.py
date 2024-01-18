# objects
import pygame
from utils import load_sprite_sheets, get_block
from os.path import isfile, join

class Object(pygame.sprite.Sprite):
    def __init__(self, x, y, width, height, name=None):
        super().__init__()
        self.rect = pygame.Rect(x, y, width, height)
        self.image = pygame.Surface((width, height), pygame.SRCALPHA)
        self.width = width
        self.height = height
        self.name = name

    def draw(self, win, offset_x):
        win.blit(self.image, (self.rect.x - offset_x, self.rect.y))


class Block(Object):
    def __init__(self, x, y, pos_x, pos_y, size):
        super().__init__(x, y, size, size)
        block = get_block(pos_x, pos_y,size)
        self.image.blit(block, (0, 0))
        self.mask = pygame.mask.from_surface(self.image)

def get_block(pos_x, pos_y, size):  # coords of a block in the png(96, 0 xy for example) 
    path = join("assets", "Terrain", "Terrain.png")
    image = pygame.image.load(path).convert_alpha()
    surface = pygame.Surface((size, size), pygame.SRCALPHA, 32)
    rect = pygame.Rect(pos_x, pos_y, size, size)
    surface.blit(image, (0, 0), rect)
    return pygame.transform.scale2x(surface)

class Fire(Object):
    ANIMATION_DELAY = 3

    def __init__(self, x, y, width, height):
        super().__init__(x , y, width, height, "fire")
        self.fire = load_sprite_sheets("Traps", "Fire", width , height)
        self.image = self.fire["off"][0]
        self.mask = pygame.mask.from_surface(self.image)
        self.animation_count = 0
        self.animation_name = "off"

    def on(self):
        self.animation_name = "on"

    def off(self):
        self.animation_name = "off"

    def loop(self):
        sprites = self.fire[self.animation_name]
        sprite_index = (self.animation_count //
                        self.ANIMATION_DELAY) % len(sprites)
        self.image = sprites[sprite_index]
        self.animation_count += 1

        self.rect = self.image.get_rect(topleft=(self.rect.x, self.rect.y))
        self.mask = pygame.mask.from_surface(self.image)

        if self.animation_count // self.ANIMATION_DELAY > len(sprites):
            self.animation_count = 0

class Spikes(Object):
    def __init__(self, x, y, width, height):
        super().__init__(x , y, width, height, "spikes")
        self.spikes = load_sprite_sheets("Traps", "Spikes", width, height)
        self.image = self.spikes["Idle"][0]
        self.mask = pygame.mask.from_surface(self.image)


