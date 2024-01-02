# player
import pygame

pygame.init()

PLAYER_VEL = 5

class Player(pygame.sprite.Sprite):
    def __init__(self, x, y, width, height):
        self.rect = pygame.Rect(x, y, width, height)
        self.x_vel = 0
        self.y_vel = 0
        self.mask = None
        self.direction = "right"
        self.animation_count = 0
        self.COLOR = 233, 23, 23

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
        self.move(self.x_vel, self.y_vel)

    def draw(self, window):
        pygame.draw.rect(window, self.COLOR, self.rect)

    def movment(self):
        keys = pygame.key.get_pressed()

        self.x_vel = 0
        if keys[pygame.K_LEFT]:
            self.move_left(PLAYER_VEL)
        if keys[pygame.K_RIGHT]:
            self.move_right(PLAYER_VEL)