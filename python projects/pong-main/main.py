import pygame
from pygame import display, draw, key
import random
pygame.font.init()
import time

from Engine.window_dispaly import MainWindow

WINDOW = MainWindow(1000, 1000)    
PLAYER_WIDTH = 40
PLAYER_HEIGHT = 60

PLAYER_VEL = 5
STAR_WIDTH = 10
STAR_HEIGHT = 20
STAR_VEL = 10

FONT = pygame.font.SysFont("David", 32)

def draw_scene(player, elapsed_time, stars, player_color):
    WINDOW.screen.fill((28, 0, 9))
    time_text = FONT.render(f"Time: {round(elapsed_time)} seconds", 1, "white")
    WINDOW.screen.blit(time_text, (10, 10))
    draw.rect(WINDOW.screen, player_color, player)

    for star in stars:
        pygame.draw.rect(WINDOW.screen, "white", star)

    display.update()

def move_player(player):
    keys = key.get_pressed()
    if keys[pygame.K_LEFT]:
        player.x -= PLAYER_VEL
    if keys[pygame.K_RIGHT]:
        player.x += PLAYER_VEL

    if player.x < 0:
        player.x = 0

    if player.x > WINDOW.width - PLAYER_WIDTH:
        player.x = WINDOW.width - PLAYER_WIDTH

def move_stars(stars, player):
    for star in stars[:]:
        star.y += STAR_VEL
        if star.y > WINDOW.height:
            stars.remove(star)
        elif star.y >= player.y + star.height and star.colliderect(player):
            return True  # Collision detected

    return False  # No collision

def game_loop(player, clock, start_time, star_count, star_add_increment, stars):
    player_color = "red"  # Default color for the player
    c_key_released = True
    game_over = False

    while not game_over:
        star_count += clock.tick(60)
        elapsed_time = time.time() - start_time

        if star_count > star_add_increment:
            number = random.randint(1, 5)
            for _ in range(number):
                star_x = random.randint(0, WINDOW.width - STAR_WIDTH)
                star = pygame.Rect(star_x, -STAR_HEIGHT, STAR_WIDTH, STAR_HEIGHT)
                stars.append(star)

            star_add_increment = max(200, star_add_increment - 50)
            star_count = 0

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_over = True
                break

            if event.type == pygame.KEYUP and event.key == pygame.K_c:
                c_key_released = True

        keys = key.get_pressed()
        if keys[pygame.K_c] and c_key_released:
            player_color = (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))
            c_key_released = False

        move_player(player)
        if not game_over:
            collision = move_stars(stars, player)
            draw_scene(player, elapsed_time, stars, player_color)

            if collision:
                print(f"Collision occurred! Time: {round(elapsed_time)} seconds")
                game_over = True

    while game_over:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                return

def main():
    pygame.init()
    
    WINDOW.screen.fill((28, 0, 9))
    
    display.set_caption("game name here")
    display.update()

    player = pygame.Rect(200, WINDOW.height - PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT)

    clock = pygame.time.Clock()
    start_time = time.time()
    elapsed_time = 0

    star_add_increment = 2000
    star_count = 0

    stars = []
    hit = False

    game_loop(player, clock, start_time, star_count, star_add_increment, stars)

if __name__ == "__main__":
    main()