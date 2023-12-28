import os
import random
import math
import pygame
from os import listdir
from os.path import isfile, join
pygame.init()

BG_COLOR = (255, 255, 255)
WIN_WIDTH, WIN_HEIGHT = 1280, 720
FPS = 60
PLAYER_VEL = 5

def load(function):
    print("started loading")
    # Define a wrapper function that will be used as the new constructor
    def wrapper(*args, **kwargs):
        # Instantiate an object of the original class
        instance = cls(*args, **kwargs)

        # Call all methods within the class
        for name, method in cls.__dict__.items():
            # Check if the item is a method (callable) and exclude special methods
            if callable(method) and not name.startswith("__"):
                # Call the method for the instance
                method(instance)

        # Return the instance
        return instance

    # Return the wrapper function
    return wrapper
    

@load
def level1():
    get_background('Blue.png')
    draw(get_background('Blue.png'))



def get_background(name):
    image = pygame.image.load(join("assets", "Background", name))
    _, _, width, height = image.get_rect()
    tiles = []

    for i in range(WIN_WIDTH // width + 1):
        for j in range(WIN_HEIGHT // height + 1):
            pos = [i * width, j * height]
            tiles.append(pos)
        
    return tiles, image


def draw(window, background, bg_image):
    for tile in background:
        window.blit(bg_image, tuple(tile))

    pygame.display.update()
    