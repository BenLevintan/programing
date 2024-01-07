# main.py
import os
import pygame
from utils import get_background, draw
from player import Player
from levels import floor, destroy_level, create_level

pygame.init()

pygame.display.set_caption("Platformer")

WIN_WIDTH, WIN_HEIGHT = 1280, 720
FPS = 60
BLOCK_SIZE = 96

window = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))


def main(window):
    clock = pygame.time.Clock()

    player = Player(100, 100, 50, 50)
    level_objects = create_level(window, BLOCK_SIZE)  # Adjust the block_size as needed
    background = get_background(window, "lvl3.png")

    run = True
    while run:
        clock.tick(FPS)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                break


        player.loop(FPS)
        player.handle_move(level_objects)
        draw(window, background, player)

        print(player.rect)

        # Draw level objects
        for obj in level_objects:
            obj.draw(window, 0)  # The offset_x is set to 0, adjust if needed

        pygame.display.update()

    # Destroy level objects when exiting the level
    destroy_level(level_objects)

    pygame.quit()
    quit()

if __name__ == "__main__":
    main(window)
