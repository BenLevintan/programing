import pygame
import sys
import random

WHITE = 255, 255, 255

class Birds:
    def __init__(self, pos_x, pos_y, speed):
        self.pos_x = pos_x
        self.pos_y = pos_y
        self.speed = speed
        self.surface = pygame.image.load('assets/characters/birds.png').convert_alpha()
        self.surface.set_colorkey(WHITE)

    def bird_movement(self):
        self.pos_x -= self.speed + random.randint(-1, 1)
        if self.pos_x < -100:
            self.pos_x = 1400 + random.randint(0, 400)
            self.pos_y = 50 + random.randint(-20, 20)

    def draw(self, screen):
        screen.blit(self.surface, (self.pos_x, self.pos_y))


class Player:
    def __init__(self, pos_x, pos_y, speed):
        self.pos_x = pos_x
        self.pos_y = pos_y
        self.speed = speed
        self.surface = pygame.image.load('assets/characters/main.png').convert_alpha()
        self.surface.set_colorkey(WHITE)
        self.rect = self.surface.get_rect(topleft = (pos_x, pos_y))
        self.is_jumping = False
        self.jump_count = 10 

    def jump(self):
        if not self.is_jumping:
            self.is_jumping = True
            self.jump_count = 10 

    def player_movement(self, keys):
        keys = pygame.key.get_pressed()
        if keys[pygame.K_UP] and not self.is_jumping:
            self.jump()

        if self.is_jumping:
            if self.jump_count >= -10:
                neg = 1
                if self.jump_count < 0:
                    neg = -1
                self.rect.y -= (self.jump_count ** 2) * 0.5 * neg
                self.jump_count -= 1
            else:
                self.is_jumping = False
        if keys[pygame.K_LEFT]:
            self.rect.x -= self.speed
        if keys[pygame.K_RIGHT]:
            self.rect.x += self.speed
        
        self.rect.y -= (self.jump_count ** 2) * 0.5 * -1 #gravity


    def draw(self, screen):
        screen.blit(self.surface, self.rect)
