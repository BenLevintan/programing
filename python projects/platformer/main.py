# main.py
import os
import pygame
from utils import get_background, draw
from player import Player, Hearts
from levels import destroy_level, create_level
from objects import Fire, Spikes

pygame.init()

pygame.display.set_caption("Platformer")

WIN_WIDTH, WIN_HEIGHT = 1280, 720
FPS = 60
BLOCK_SIZE = 96
LEVEL_START = 50
PLAYER_SPAWN = 50


window = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))
keys = pygame.key.get_pressed()

# respawn the player at PLAYER_SPAWN, returning a new screen offset 
def respawn(player,scroll_area_width):
    player.rect.y = 100
    player.rect.x = PLAYER_SPAWN
    player.y_vel = 0
    player.jump_count = 2
    offset_x = PLAYER_SPAWN - scroll_area_width
    return offset_x

def restart(player,scroll_area_width):
    player.rect.y = 100
    player.rect.x = LEVEL_START
    player.y_vel = 0
    player.jump_count = 2
    player.life = 3
    offset_x = LEVEL_START - scroll_area_width
    return offset_x

def main(window):
    clock = pygame.time.Clock()

    player = Player(PLAYER_SPAWN, 100, 50, 50)
    background = get_background(window, "lvl3.png")
    hearts = Hearts(player.life)  # Create an instance of the Hearts class

    run = True
    game_paused = False
    level_objects = create_level(window)  
    scroll_area_width = 350
    offset_x = PLAYER_SPAWN - scroll_area_width

    while run:
        clock.tick(FPS)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                break
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_ESCAPE:
                game_paused = not game_paused
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_r:
                offset_x = respawn(player,scroll_area_width)
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_s:
                offset_x = restart(player,scroll_area_width)

        # contains all the function that run while the game is not paused 
        if not game_paused:
            player.loop(FPS)
            for obj in level_objects:
                if isinstance(obj, Fire):
                    obj.loop()
            player.handle_move(level_objects)
            draw(window, background, player, level_objects, offset_x)
            hearts.draw(window)  # Draw the hearts on the screen
            mouse_x, mouse_y = pygame.mouse.get_pos()
            #print(f"Mouse Position: ({mouse_x + offset_x}, {mouse_y})")
            #print(player.animation_count % 12 , player.rect.y)


            # respawn if falling off the map
            if player.rect.y > 1200:
                player.life -= 1
                player.rect.y = 100
                player.rect.x = PLAYER_SPAWN
                player.y_vel = 0
                player.jump_count = 2
                offset_x = PLAYER_SPAWN - scroll_area_width

            hearts.current_life = player.life  # Update the hearts based on player's life

        # changes the offset value, so the elements stay around the player
        if ((player.rect.right - offset_x >= WIN_WIDTH - scroll_area_width) and player.x_vel > 0) or (
                (player.rect.left - offset_x <= scroll_area_width) and player.x_vel < 0):
            offset_x += player.x_vel

        
        
        #print(player.rect.x  , player.rect.y)

        pygame.display.update()

        # Destroy level objects when exiting the level
        destroy_level(level_objects)

    pygame.quit()
    quit()

if __name__ == "__main__":
    main(window)
