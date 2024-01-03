# player
import pygame
from utils import load_sprite_sheets

pygame.init()



def print_function_name(func):
    def wrapper(*args, **kwargs):
        print(f"Calling {func.__name__} function")
        return func(*args, **kwargs)
    return wrapper

class Player(pygame.sprite.Sprite):

    PLAYER_VEL = 5
    GRAVITY = 1
    TERMINAL_VELOCITY = 10

    SPRITES = load_sprite_sheets("MainCharacters", "MaskDude", 32, 32, True)
    ANIMATION_DELAY = 3

    def __init__(self, x, y, width, height):
        self.rect = pygame.Rect(x, y, width, height)
        self.x_vel = 0
        self.y_vel = 0
        self.mask = None
        self.direction = "right"
        self.animation_count = 0
        self.COLOR = 233, 23, 23
        self.fall_count = 0 #counts the frames of which player been falling


    def move(self, dx, dy):
        self.rect.x += dx
        self.rect.y += dy


    def move_left(self, vel):
        self.x_vel = -vel
        if self.direction != "left":    #face the player to the left
            self.direction = "left"
            self.animation_count = 0    #restart the animation


    def move_right(self, vel):
        self.x_vel = vel
        if self.direction != "right":    #face the player to the right
            self.direction = "right"
            self.animation_count = 0     #reset animation


    def loop(self, fps):
        self.y_vel += min (1, (self.fall_count / fps) * self.GRAVITY)
        self.move(self.x_vel, self.y_vel)
        self.y_vel = min(self.y_vel, self.TERMINAL_VELOCITY)

        self.fall_count += 2


    def draw(self, window):
        self.sprtie = self.SPRITES["idle_right"][0]
        window.blit(self.sprtie, (self.rect.x, self.rect.y))


    def handle_move(self):
        keys = pygame.key.get_pressed()

        self.x_vel = 0
        if keys[pygame.K_LEFT]:
            self.move_left(self.PLAYER_VEL)
        if keys[pygame.K_RIGHT]:
            self.move_right(self.PLAYER_VEL)