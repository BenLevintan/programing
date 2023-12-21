import pygame
import sys
import random

class Physics:
    def __init__(self):
        self.gravity = 1  # You can adjust the gravity value as needed

    def free_fall(self, falling_object):
        falling_object.pos.y += falling_object.vel.y
        falling_object.vel.y += self.gravity

        # Optional: You might want to add other conditions or logic based on the collision
        # For example, check if the falling_object reaches the ground and reset its velocity

        return falling_object.vel.y

