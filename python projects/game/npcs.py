import pygame
import random

class Birds:
    def __init__(self, x, y, speed):
        self.x = x
        self.y = y
        self.speed = speed
        self.surface = pygame.image.load('assets/characters/birds.png')
        self.surface.set_colorkey((255, 255, 255))

    def bird_movement(self):
        self.x -= self.speed
        if self.x < -100:
            self.x = 1400 + random.randint(0, 400)
            self.y = 50 + random.randint(-20, 20)

    def draw(self, screen):
        screen.blit(self.surface, (self.x, self.y))

