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

WIN_WIDTH, WIN_HEIGHT = 1280, 720
GROUND_POS_Y = WIN_HEIGHT - 60
screen = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))  #creating a game screen
pygame.display.set_caption("Game Title")                   #name of the game window

clock = pygame.time.Clock()
running = True

FONT_SIZE = 50
FONT_TYPE = 'assets/fonts/Pixle_Font.ttf'
test_font = pygame.font.Font(FONT_TYPE, FONT_SIZE)

sky_surface = pygame.image.load('assets/background1.png')
ground_surface = pygame.image.load('assets/ground1.png')
text_surface = test_font.render('Hello Player', ANTI_ALIASING, WHITE)

background_birds = Birds(1300, 50, 4)
player = Player(WIN_HEIGHT-200, 200, 3)

while running:
    for event in pygame.event.get(): 
        if event.type == pygame.QUIT:   
            pygame.quit()               #closing pygame
            exit()                      #closing the program (sys import)

    screen.blit(sky_surface,(0, 0))   #position()
    screen.blit(ground_surface,(0,GROUND_POS_Y))   #position
    screen.blit(text_surface,(20, 20))

    player.draw(screen)

    background_birds.bird_movement()
    background_birds.draw(screen)

    pygame.display.update()
    clock.tick(60)

pygame.quit()
sys.exit()
