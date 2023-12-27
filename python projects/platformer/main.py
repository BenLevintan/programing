import os
import random
import math
import pygame
from os import listdir
from os.path import isfile, join
from levels import load, level1
pygame.init()

pygame.display.set_caption("Platformer")

BG_COLOR = (255, 255, 255)
WIN_WIDTH, WIN_HEIGHT = 1280, 720
FPS = 60
PLAYER_VEL = 5

window = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))

def main(window):
    clock = pygame.time.Clock()

    run = True
    while run:
        clock.tick(FPS)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                break

        load(level1)


    pygame.quit()
    quit()


if __name__ == "__main__":
    main(window)