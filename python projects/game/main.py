import pygame
import sys
from player import Player

pygame.init()

WIN_WIDTH, WIN_HEIGHT = 1280, 720
screen = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))
pygame.display.set_caption("Game Title")

clock = pygame.time.Clock()
running = True

player = Player()
player_pos_x = 40
player_pos_y = WIN_HEIGHT - 100

jumping = False
jump_timer = 0  # Initialize the jump timer

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    player_speed = player.BASE_SPEED

    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]:
        player_pos_x -= player_speed
    if keys[pygame.K_RIGHT]:
        player_pos_x += player_speed
    if keys[pygame.K_UP]:
        if not jumping:
            jumping = True
            jump_timer = 30  # Set the jump timer to 30 frames (.5 second)

    if keys[pygame.K_DOWN]:
        player_pos_y += player_speed

    # Jumping logic
    if jumping:
        player_pos_y -= player_speed * 2  # Move the player up during the jump
        jump_timer -= 1
        if jump_timer <= 0:
            jumping = False

    # Draw the player (circle)
    pygame.draw.circle(screen, "red", (int(player_pos_x), int(player_pos_y)), 40)

    pygame.display.flip()
    screen.fill((0, 0, 0))  # Clear the screen on each iteration

    clock.tick(60)

pygame.quit()
sys.exit()
