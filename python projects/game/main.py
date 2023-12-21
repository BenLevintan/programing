import pygame
import sys
import random
from player import Player
from npcs import Birds, Player

pygame.init()

BLACK = 0, 0 ,0
BROWN = 200, 200, 0
WHITE = 255, 255, 255

ANTI_ALIASING = False
FRAME_RATE = 60

WIN_WIDTH, WIN_HEIGHT = 1280, 720
GROUND_POS_Y = WIN_HEIGHT - 60

HEADLINE_TEXT = (20, 20)
PLAYER_SPAWN = 0, 200
PLAYER_SPEED = 20

screen = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))  #creating a game screen
pygame.display.set_caption("Game Title")                   #name of the game window

clock = pygame.time.Clock()
running = True

FONT_SIZE = 30
FONT_TYPE = 'assets/fonts/Pixle_Font.ttf'
TIME_COLOR = (64, 64, 64)
TIME_POS = 20, 80
test_font = pygame.font.Font(FONT_TYPE, FONT_SIZE)

def display_time():
    current_time = int(pygame.time.get_ticks()/1000)
    time_surface = test_font.render(f'Time: {current_time}', False, TIME_COLOR)
    time_rect = time_surface.get_rect(topleft = TIME_POS)
    screen.blit(time_surface, time_rect)

sky_surface = pygame.image.load('assets/background1.png')
ground_surface = pygame.image.load('assets/ground1.png')
ground_rect = ground_surface.get_rect(topleft = (0, GROUND_POS_Y))
text_surface = test_font.render('Hello Player', ANTI_ALIASING, WHITE)

background_birds = Birds(1300, 50, 4)
background_birds2 = Birds(1500, 100, 3)

player = Player(PLAYER_SPAWN, PLAYER_SPEED)

while running:
    for event in pygame.event.get(): 
        if event.type == pygame.QUIT:   
            pygame.quit()               #closing pygame
            exit()                      #closing the program (sys import)

    keys = pygame.key.get_pressed()
    player.player_movement(keys)

    screen.blit(sky_surface,(0, 0))   #position()
    screen.blit(ground_surface,(0, GROUND_POS_Y))   #position
    screen.blit(text_surface,(HEADLINE_TEXT))

    player.draw(screen)

    background_birds.bird_movement()
    background_birds.draw(screen)
    background_birds2.bird_movement()
    background_birds2.draw(screen)

    player.gravity += 1
    player.rect.y += player.gravity

    if player.rect.colliderect(ground_rect):
        player.rect.y = GROUND_POS_Y - player.rect.height
        player.gravity = 0
        player.is_jumping = False

    display_time()

    pygame.display.update()
    clock.tick(FRAME_RATE)

pygame.quit()
sys.exit()
