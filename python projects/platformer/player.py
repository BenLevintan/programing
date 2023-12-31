# player
import pygame
from utils import load_sprite_sheets
from objects import Object, Block

pygame.init()

def print_function_name(func):
    def wrapper(*args, **kwargs):
        print(f"Calling {func.__name__} function")
        return func(*args, **kwargs)
    return wrapper

class Player(pygame.sprite.Sprite):

    PLAYER_VEL = 6
    GRAVITY = 3
    TERMINAL_VELOCITY = 20

    SPRITES = load_sprite_sheets("MainCharacters", "MaskDude", 32, 32, True)
    ANIMATION_DELAY = 3

    def __init__(self, x, y, width, height):
        super().__init__()
        self.rect = pygame.Rect(x, y, width, height)
        self.x_vel = 0
        self.y_vel = 0
        self.mask = None
        self.direction = "right"
        self.animation_count = 0
        self.jump_count = 2
        self.fall_count = 0 #counts the frames of which player been falling

    def jump(self):
        self.rect.y -= 4
        self.y_vel = -self.GRAVITY * 5
        self.animation_count = 0 
        self.jump_count += 1
        if self.jump_count == 1:
            self.fall_count = 0

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

        self.fall_count += 1
        self.update_sprite()

    def landed(self):
        self.fall_count = 0
        self.y_vel = 0
        self.jump_count = 0

    def hit_head(self):
        self.y_vel = 0

    def update_sprite(self):
        sprite_sheet = "idle"
        if self.y_vel < 0:
            if self.jump_count == 1:
                sprite_sheet = "jump"
            elif self.jump_count == 2:
                sprite_sheet = "double_jump"
        elif self.y_vel > self.GRAVITY * 2:
            sprite_sheet = "fall"
        elif self.x_vel != 0:
            sprite_sheet = "run"

        sprite_sheet_name = sprite_sheet + "_" + self.direction
        sprites = self.SPRITES[sprite_sheet_name]
        sprite_index = (self.animation_count //
                        self.ANIMATION_DELAY) % len(sprites)
        self.sprite = sprites[sprite_index]
        self.animation_count += 1
        self.update()
    
    def update(self):
        self.rect = self.sprite.get_rect(topleft=(self.rect.x, self.rect.y))
        self.mask = pygame.mask.from_surface(self.sprite)

    def draw(self, window, offset_x):
        window.blit(self.sprite, (self.rect.x - offset_x, self.rect.y))

    def handle_vertical_collision(self, objects, dy):
        collided_objects = []
        for obj in objects:
            #if type(obj) is Object:    testing if obj is an Object type
                if  pygame.sprite.collide_mask(self, obj): # no collision is detected if obj is Object type 
                    if dy > 0:
                        self.rect.bottom = obj.rect.top
                        self.landed()
                    elif dy < 0:
                        self.rect.top = obj.rect.bottom
                        self.hit_head()

                collided_objects.append(obj)

        return collided_objects

    def handle_move(self, objects):
        keys = pygame.key.get_pressed()
        self.x_vel = 0
        if keys[pygame.K_LEFT]:
            self.move_left(self.PLAYER_VEL)
        if keys[pygame.K_RIGHT]:
            self.move_right(self.PLAYER_VEL)
        if keys[pygame.K_UP] and not self.up_key_pressed:
            if  self.jump_count < 2:
                self.jump()

        self.up_key_pressed = keys[pygame.K_UP]
        self.handle_vertical_collision(objects, self.y_vel)

#bug report: *  standing on the edge of the block causes a fall loop
#            *  first jump has the 2nd jump animation 