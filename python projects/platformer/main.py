# main.py
import os
import random
import math
import pygame
from utils import get_background, draw
from player import Player

pygame.init()

pygame.display.set_caption("Platformer")

WIN_WIDTH, WIN_HEIGHT = 1280, 720
FPS = 60
PLAYER_VEL = 5

window = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))

def main(window):
    clock = pygame.time.Clock()

    player = Player(100, 100, 50, 50)

    run = True
    while run:
        clock.tick(FPS)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                break

        player.handle_move()
        player.loop(FPS)

        background = get_background(window, "level1.png")
        draw(window, background, player)
        # Update the display
        pygame.display.update()

    pygame.quit()
    quit()

if __name__ == "__main__":
    main(window)
