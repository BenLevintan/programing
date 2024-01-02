#utlis

import pygame
from os import listdir
from os.path import isfile, join
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


   