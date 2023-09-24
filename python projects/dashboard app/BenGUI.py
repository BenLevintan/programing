import sys
import win32api
from PySide6.QtWidgets import QApplication, QLabel, QVBoxLayout, QPushButton, QWidget
from PySide6.QtCore import Slot
from PySide6.QtCore import QDateTime, QTimer
from win32con import VK_MEDIA_PLAY_PAUSE, KEYEVENTF_EXTENDEDKEY, VK_VOLUME_UP, VK_VOLUME_DOWN, VK_MEDIA_NEXT_TRACK


WINDOW_HEIGHT = 300
WINDOW_WIDTH_MIN = 5
WINDOW_WIDTH_EX = 150

class CounterApp(QWidget):
    def __init__(self):
        super().__init__()
        self.counter = 0
        self.init_ui()

    def init_ui(self):
        self.layout = QVBoxLayout(self)
        self.time_label = QLabel(self.get_current_time())
        self.resize(WINDOW_WIDTH_MIN, WINDOW_HEIGHT)  # Set the initial window size

        self.timer = QTimer(self)
        self.timer.timeout.connect(self.update_time)
        self.timer.start(1000)  # 1000 milliseconds = 1 second

        #creates the buttons in the window
        self.layout.addWidget(self.time_label, 0)
        self.label = QLabel(f'Counter: {self.counter}')
        self.add_button = QPushButton('Add 1')
        self.decrement_button = QPushButton('Subtract 1')
        self.reset_button = QPushButton('Reset acounter')
        self.resize_button = QPushButton('Resize window')
        self.play_button = QPushButton('Play/Pause')
        self.volume_up_button = QPushButton('Volume +')
        self.volume_down_button = QPushButton('Volume -')
        self.track_next = QPushButton('Next')

        self.layout.addWidget(self.time_label, 0)
        
        #adds the widget that fits the button 
        self.layout.addWidget(self.label)
        self.layout.addWidget(self.add_button)
        self.layout.addWidget(self.decrement_button)
        self.layout.addWidget(self.reset_button)
        self.layout.addWidget(self.resize_button)
        self.layout.addWidget(self.play_button)
        self.layout.addWidget(self.volume_up_button)
        self.layout.addWidget(self.volume_down_button)
        self.layout.addWidget(self.track_next)
        

        #calls the function that the button needs to execute
        self.add_button.clicked.connect(self.increment_counter)
        self.decrement_button.clicked.connect(self.decrement_counter)
        self.reset_button.clicked.connect(self.reset_couner)
        self.resize_button.clicked.connect(self.toggle_size)
        self.play_button.clicked.connect(self.play_media)
        self.volume_up_button.clicked.connect(self.volume_up)
        self.volume_down_button.clicked.connect(self.volume_down)
        self.track_next.clicked.connect(self.next_track)

        self.setLayout(self.layout)

        self.setMouseTracking(True)  # Enable the widget to accept hover events

    #the functions 
    def increment_counter(self):
        self.counter += 1
        self.label.setText(f'Counter: {self.counter}')

    def decrement_counter(self):
        self.counter -= 1
        self.label.setText(f'Counter: {self.counter}')

    def reset_couner(self):
        self.counter = 0
        self.label.setText(f'Counter: {self.counter}')

    def toggle_size(self):
        if self.width() == WINDOW_WIDTH_MIN:
            self.resize(WINDOW_WIDTH_EX, WINDOW_HEIGHT)
        else:
            self.resize(WINDOW_WIDTH_MIN, WINDOW_HEIGHT)

    def play_media(self):
        win32api.keybd_event(VK_MEDIA_PLAY_PAUSE, 0, KEYEVENTF_EXTENDEDKEY, 0)

    def volume_up(self):
        win32api.keybd_event(VK_VOLUME_UP, 12)


    def volume_down(self):
        win32api.keybd_event(VK_VOLUME_DOWN, 12)

    def next_track(self):
        win32api.keybd_event(VK_MEDIA_NEXT_TRACK, 1)

    def get_current_time(self):
        return QDateTime.currentDateTime().toString('hh:mm:ss')
    
    def update_time(self):
        current_time = self.get_current_time()
        self.time_label.setText(current_time)

    def enterEvent(self, event):
        self.setWindowOpacity(1.0)  # Make the window fully opaque
        self.resize(WINDOW_WIDTH_EX, WINDOW_HEIGHT)  # Resize to the bigger window
        super().enterEvent(event)

    def leaveEvent(self, event):
        self.setWindowOpacity(0.3)  # Make the window transparent
        self.resize(WINDOW_WIDTH_MIN, WINDOW_HEIGHT)  # Resize to the smaller window
        super().leaveEvent(event)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = CounterApp()
    window.show()
    sys.exit(app.exec_())

