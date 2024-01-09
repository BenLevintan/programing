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

